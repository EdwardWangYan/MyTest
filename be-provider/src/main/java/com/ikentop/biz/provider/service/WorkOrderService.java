package com.ikentop.biz.provider.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ikentop.biz.constant.*;
import com.ikentop.biz.model.entity.Operator;
import com.ikentop.biz.model.entity.WorkOrder;
import com.ikentop.biz.provider.config.BizDataInterfaceExt;
import com.ikentop.biz.provider.dao.WorkOrderDao;
import com.ikentop.biz.provider.exception.*;
import com.ikentop.biz.provider.model.dto.*;
import com.ikentop.biz.util.CommonUtils;
import com.ikentop.framework.core.pojo.DataTableResponse;
import com.ikentop.framework.core.spring.bean.BizDataInterface;
import com.ikentop.framework.core.util.IDUtils;
import com.ikentop.framework.service.GenericServiceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author : Huqiao
 * @since : 2017/11/16
 */
@Transactional
@Service
public class WorkOrderService extends GenericServiceSupport<WorkOrderDao> {
    @Autowired
    private OperatorService operatorService;
    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private BizDataInterface bizDataInterface;
    @Autowired
    private OrgApproveService orgApproveService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    public WorkOrderService(WorkOrderDao workOrderDao) {
        super(workOrderDao);
    }

    /**
     * 创建找回密码工单
     */
    public String create4RetrievePassword(WorkOrderCreate4RetrievePasswordDto dto) {
        Operator operator = operatorService.getDao().selectByUsername(dto.getExtJson().getLoginName());
        if (null == operator)
            throw new OperatorNotFoundException();
        WorkOrder workOrder = createTempWorkOrder(dto.getExtJson(), operator.getOrgId(), WorkOrderType.PASSWORD_RETRIEVE.val, operator.getPk());
        getDao().insertWithoutInit(workOrder);
        return workOrder.getPk();
    }


    /**
     * 创建机构入驻工单
     *
     * @param dto
     */
    public String create4OrgRegister(OrganizationRegisterDto dto) {
        WorkOrder workOrder = createTempWorkOrder(dto, CommonUtils.nullUUID(), WorkOrderType.ORGANIZATION_REGISTER.val, CommonUtils.nullUUID());
        getDao().insertWithoutInit(workOrder);
        return workOrder.getPk();
    }

    /**
     * 创建机构通用工单
     */
    public String create(Object o, Integer type) {
        WorkOrder workOrder = null;
        try {
            workOrder = new WorkOrder();
            workOrder.setExtJson(objectMapper.writeValueAsString(o));
            workOrder.setType(type);
            workOrder.setStatus(WorkOrderStatus.UNTREATED.val);
            getDao().insert(workOrder);
        } catch (JsonProcessingException e) {
            throw new WorkOrderExtJsonIsWrongException();
        }

        return workOrder.getPk();
    }


    /**
     * 通过处理密码工单
     */
    public MinOperatorInfo pass4RetrievePassword(WorkOrderPass4RetrievePasswordDto dto) {
        WorkOrder workOrder = verifyWorkOrderId(dto.getId());
        verifyWorkOrderType(WorkOrderType.PASSWORD_RETRIEVE.val, workOrder.getType());
        updateWorkOrder(workOrder.getPk());
        RetrievePasswordDto retrievePasswordDto = null;
        try {
            retrievePasswordDto = objectMapper.readValue(workOrder.getExtJson(), RetrievePasswordDto.class);
        } catch (IOException e) {
            throw new WorkOrderExtJsonIsWrongException();
        }
        return operatorService.retrievePassword(retrievePasswordDto, dto.getDto());
    }

    /**
     * 通过组织修改审核工单
     */
    public String pass4OrgUpdate(WorkOrderPassDto dto) {
        WorkOrder workOrder = verifyWorkOrderId(dto.getId());
        verifyWorkOrderType(WorkOrderType.ORGANIZATION_UPDATE.val, workOrder.getType());
        updateWorkOrder(workOrder.getPk());
        OrganizationUpdateExtDto organizationUpdateExtDto = null;
        try {
            organizationUpdateExtDto = objectMapper.readValue(workOrder.getExtJson(), OrganizationUpdateExtDto.class);
        } catch (IOException e) {
            throw new WorkOrderExtJsonIsWrongException();
        }
        return organizationService.update(assemble(organizationUpdateExtDto, OrganizationUpdateDto.class));
    }

    /**
     * 通过机构认证信息
     */
    public String pass4OrgApprove(WorkOrderPassDto dto) {
        WorkOrder workOrder = verifyWorkOrderId(dto.getId());
        verifyWorkOrderType(WorkOrderType.ORGANIZATION_APPROVE.val, workOrder.getType());
        updateWorkOrder(workOrder.getPk());
        OrgApproveEditExtDto orgApproveEditExtDto = null;
        try {
            orgApproveEditExtDto = objectMapper.readValue(workOrder.getExtJson(), OrgApproveEditExtDto.class);
        } catch (IOException e) {
            throw new WorkOrderExtJsonIsWrongException();
        }
        return orgApproveService.edit(assemble(orgApproveEditExtDto, OrgApproveEditDto.class));
    }

    /**
     * 通过机构入驻信息
     */
    public OrganizationCreateResultDto pass4OrgRegister(WorkOrderPass4OrgRegisterDto dto) {
        WorkOrder workOrder = verifyWorkOrderId(dto.getId());
        verifyWorkOrderType(WorkOrderType.ORGANIZATION_REGISTER.val, workOrder.getType());
        updateWorkOrder(workOrder.getPk());
        OrganizationRegisterDto registerDto = null;
        try {
            registerDto = objectMapper.readValue(workOrder.getExtJson(), OrganizationRegisterDto.class);
        } catch (IOException e) {
            throw new WorkOrderExtJsonIsWrongException();
        }
        return organizationService.register(registerDto, dto.getDto());
    }

    /**
     * 工单列表
     */
    public DataTableResponse<WorkOrderListInfo> list(WorkOrderListDto dto) {
        // TODO: 2018/1/24 逻辑待优化
        if (currentOrgIsNotPlatform()) {
            dto.setType(WorkOrderType.PASSWORD_RETRIEVE.val);
            dto.setOrgId(currentOrgId());
        }
        PageHelper.startPage(dto.getIndex(), dto.getSize());
        List<WorkOrderListInfo> list = getDao().list(dto);
        return DataTableResponse.fromPageInfo(new PageInfo<>(list));
    }

    public WorkOrderDetailInfo getDetail(String id) {
        String orgId = null;
        if (currentOrgIsNotPlatform())
            orgId = currentOrgId();
        WorkOrder workOrder = getDao().getWorkOrderById(id, orgId);
        WorkOrderDetailInfo info = null;
        if (null != workOrder)
            info = assemble(workOrder, WorkOrderDetailInfo.class);
        return info;
    }

    /**
     * 工单未通过处理
     */
    @SuppressWarnings("Duplicates")
    public Integer fail(String id) {
        WorkOrder order = verifyWorkOrderId(id);
        verifyWorkOrderStatus(id);
        WorkOrder workOrder = new WorkOrder();
        workOrder.setPk(id);
        workOrder.setStatus(WorkOrderStatus.FAIL.val);
        int num = 0;
        num +=getDao().updateByPrimaryKeySelective(workOrder);
        return num;
    }

    private void updateWorkOrder(String id) {
        verifyWorkOrderStatus(id);
        WorkOrder workOrder = new WorkOrder();
        workOrder.setPk(id);
        workOrder.setStatus(WorkOrderStatus.PASS.val);
        getDao().updateByPrimaryKeySelective(workOrder);
    }

    private void verifyWorkOrderStatus(String id) {
        WorkOrder workOrder = getDao().selectByPrimaryKey(id, false);
        if (!Objects.equals(WorkOrderStatus.UNTREATED.val, workOrder.getStatus()))
            throw new WorkOrderIsAlreadyDisposedException();
    }


    private WorkOrder createTempWorkOrder(Object o, String orgId, Integer type, String createdBy) {
        String extJson = null;
        try {
            extJson = objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new WorkOrderExtJsonIsWrongException();
        }
        WorkOrder workOrder = new WorkOrder();
        workOrder.setPk(IDUtils.UUID());
        workOrder.setOrgId(orgId);
        workOrder.setType(type);
        workOrder.setStatus(WorkOrderStatus.UNTREATED.val);
        workOrder.setExtJson(extJson);
        workOrder.setDeletedFlag(DeletedFlag.ENABLE.getVal());
        workOrder.setCreatedBy(createdBy);
        workOrder.setCreatedOn(new Date());
        return workOrder;
    }

    private WorkOrder verifyWorkOrderId(String id) {
        WorkOrder workOrder = getDao().getWorkOrderById(id);
        if (null == workOrder)
            throw new WorkOrderNotFoundException();
        return workOrder;
    }

    private void verifyWorkOrderType(Integer val, Integer type) {
        if (!Objects.equals(val, type))
            throw new WorkOrderTypeIsMismatchingException();
    }

    private boolean currentOrgIsNotPlatform() {
        return !Objects.equals(OrgTypeValue.PLATFORM.val, currentOrgType());
    }

    private String currentOrgType() {
        return ((BizDataInterfaceExt) bizDataInterface).currentOrgType();
    }

    private String currentOrgId() {
        return bizDataInterface.currentOrgId();
    }
}
