package com.ikentop.biz.provider.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ikentop.biz.constant.OrganizationStatus;
import com.ikentop.biz.constant.WorkOrderType;
import com.ikentop.biz.model.entity.Organization;
import com.ikentop.biz.model.entity.Staff;
import com.ikentop.biz.provider.dao.OrganizationDao;
import com.ikentop.biz.provider.exception.OrgTypeConnotNullException;
import com.ikentop.biz.provider.exception.OrgTypeIsNotExistException;
import com.ikentop.biz.provider.exception.OrganizationNotFoundException;
import com.ikentop.biz.provider.model.bo.OrganizationInfo4Session;
import com.ikentop.biz.provider.model.dto.*;
import com.ikentop.framework.core.pojo.DataTableResponse;
import com.ikentop.framework.core.spring.bean.BizDataInterface;
import com.ikentop.framework.service.GenericServiceSupport;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Huqiao
 * @author tac
 * @since 2017/9/6
 */
@Transactional
@Service
public class OrganizationService extends GenericServiceSupport<OrganizationDao> {
    @Autowired
    private OperatorService operatorService;
    @Autowired
    private OperatorRoleService operatorRoleService;
    @Autowired
    private StaffService staffService;
    @Autowired
    private OrgTypeService orgTypeService;
    @Autowired
    protected BizDataInterface bizDataInterface;
    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleFunctionService roleFunctionService;
    @Autowired
    private WorkOrderService workOrderService;
    @Autowired
    private ImageRecordService imageRecordService;
    @Autowired
    private RoleResourceService roleResourceService;

    @Autowired
    public OrganizationService(OrganizationDao organizationDao) {
        super(organizationDao);
    }

    /**
     * 获取机构详细信息
     */
    public OrganizationDetailInfo getDetails(String id) {
        OrganizationDetailInfo info = getDao().getDetails(id);
        return info;
    }

    public OrganizationDetailInfo getCurrentDetails() {
        return getDetails(currentOrgId());
    }

    /**
     * 新增机构
     */
    public OrganizationCreateResultDto create(OrganizationCreateDto dto) {
        manageParentId(dto);
        Organization o = assemble(dto, Organization.class);
        throwOrgTypeIsWrong(o.getOrgTypeCode());
        o.setStatus(OrganizationStatus.CKECK_PASSED.getVal());
        getDao().insert(o);
        String staffId = createStaff4Org(dto, o);
        MinOperatorInfo operatorInfo = createOperator4Org(dto, staffId, o.getPk());
        createAndAllotAdminRole(operatorInfo, dto, o);
        return assginOrganizationCreateResultDto(o.getPk(), operatorInfo);
    }

    public String update(OrganizationUpdateDto dto) {
        if (!existOrg(dto.getId()))
            throw new OrganizationNotFoundException();
        Organization organization = assemble(dto, Organization.class);
        getDao().updateByPrimaryKeySelective(organization);
        return organization.getPk();
    }

    /**
     * 创建机构修改审核工单
     */
    public String commitUpdateApplication(OrganizationUpdateDto dto) {
        if (!existOrg(dto.getId()))
            throw new OrganizationNotFoundException();
        OrganizationUpdateExtDto extDto = assemble(dto, OrganizationUpdateExtDto.class);
        extDto.setOrgLogoInfo(imageRecordService.getImageRecordInfo(dto.getOrgLogoId()));
        return workOrderService.create(extDto, WorkOrderType.ORGANIZATION_UPDATE.val);
    }

    /**
     * 创建机构入驻审核工单
     */
    public String commitRegisterApplication(OrganizationRegisterDto dto) {
        return workOrderService.create4OrgRegister(dto);
    }

    public OrganizationCreateResultDto register(OrganizationRegisterDto dto, OrganizationRegisterExtDto extDto) {
        throwOrgTypeIsWrong(extDto.getOrgTypeCode());
        Organization o = assemble(dto, Organization.class);
        o.setStatus(OrganizationStatus.CKECK_PASSED.getVal());
        o.setOrgTypeCode(extDto.getOrgTypeCode());
        getDao().insert(o);
        String staffId = createStaff4Org(dto, o);
        OrganizationCreateDto createDto = assemble(extDto, OrganizationCreateDto.class);
        MinOperatorInfo operatorInfo = createOperator4Org(createDto, staffId, o.getPk());
        createAndAllotAdminRole(operatorInfo, createDto, o);
        return assginOrganizationCreateResultDto(o.getPk(), operatorInfo);
    }

    public DataTableResponse<OrganizationListInfo> list(OrganizationListDto dto) {
        PageHelper.startPage(dto.getIndex(), dto.getSize());
        List<OrganizationListInfo> list = getDao().list(dto);
        return DataTableResponse.fromPageInfo(new PageInfo<>(list));
    }

    public OrganizationInfo4Session getOrg4UserInfo(String orgId) {
        Organization organization = getDao().selectByPrimaryKey(orgId);
        if (null == organization)
            throw new OrganizationNotFoundException();
        return assemble(organization, OrganizationInfo4Session.class);
    }

    private void notifyOrg(Organization org) {
        //todo:: 发送消息通知组织
    }

    private MinOperatorInfo createOperator4Org(OrganizationCreateDto dto, String staffId, String id) {
        OperatorCreateDto operatorCreateDto = new OperatorCreateDto();
        operatorCreateDto.setLoginName(dto.getLoginName());
        operatorCreateDto.setPassword(dto.getPassword());
        operatorCreateDto.setStaffId(staffId);
        return operatorService.createOperator4Org(operatorCreateDto, id);
    }

    private OrganizationCreateResultDto assginOrganizationCreateResultDto(String pk, MinOperatorInfo operatorInfo) {
        OrganizationCreateResultDto dto = new OrganizationCreateResultDto();
        dto.setId(pk);
        dto.setLoginName(operatorInfo.getLoginName());
        dto.setPassword(operatorInfo.getPassword());
        return dto;
    }

    boolean existOrg(String id) {
        Organization o = new Organization();
        o.setPk(id);
        return getDao().selectCount(o, false) > 0;
    }

    private String currentOrgId() {
        return bizDataInterface.currentOrgId();
    }

    private void throwOrgTypeIsWrong(String orgTypeCode) {
        if (null == orgTypeCode)
            throw new OrgTypeConnotNullException();

        if (null == orgTypeService.getOrgType4CreateOrg(orgTypeCode))
            throw new OrgTypeIsNotExistException();
    }


    private void manageParentId(OrganizationCreateDto dto) {
        if (StringUtils.isBlank(dto.getParentId())) {
            dto.setParentId(null);
        } else {
            if (!existOrg(dto.getParentId()))
                throw new OrganizationNotFoundException();
        }
    }

    private String createStaff4Org(Object dto, Organization organization) {
        Staff staff = assemble(dto, Staff.class);
        staff.setOrgId(organization.getPk());
        return staffService.createStaff4Org(staff);
    }

    private void createAndAllotAdminRole(MinOperatorInfo operatorInfo, OrganizationCreateDto dto, Organization o) {
        String roleId = roleService.createRole4Org(dto.getOrgTypeCode(), o.getPk(), o.getTitle());
        operatorRoleService.relateOperatorRole(operatorInfo.getId(), roleId);
        roleFunctionService.allotFunction4AdminRole(roleId, dto.getOrgTypeCode());
        roleResourceService.allotResource4AdminRole(roleId,dto.getOrgTypeCode());
    }
}
