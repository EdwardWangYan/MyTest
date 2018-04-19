package com.ikentop.biz.provider.service;

import com.ikentop.biz.constant.WorkOrderType;
import com.ikentop.biz.model.entity.OrgApprove;
import com.ikentop.biz.model.entity.Organization;
import com.ikentop.biz.provider.dao.OrgApproveDao;
import com.ikentop.biz.provider.exception.OrganizationNotFoundException;
import com.ikentop.biz.provider.model.dto.OrgApproveDetailInfo;
import com.ikentop.biz.provider.model.dto.OrgApproveEditDto;
import com.ikentop.biz.provider.model.dto.OrgApproveEditExtDto;
import com.ikentop.framework.service.GenericServiceSupport;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : Huqiao
 * @since : 2017/10/25
 */
@Service
@Transactional
public class OrgApproveService extends GenericServiceSupport<OrgApproveDao> {
    @Autowired
    public OrgApproveService(OrgApproveDao orgApproveDao) {
        super(orgApproveDao);
    }

    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private WorkOrderService workOrderService;
    @Autowired
    private ImageRecordService imageRecordService;

    public OrgApproveDetailInfo getDetail(String id) {
        return getDao().getDetail(id);
    }


    public String commitEditApplication(OrgApproveEditDto dto) {
        verifyOrgIdIsRight(dto.getId());
        OrgApproveEditExtDto extDto = assemble(dto, OrgApproveEditExtDto.class);
        extDto.setPermitPicInfo(imageRecordService.getImageRecordInfo(dto.getPermitPicId()));
        return workOrderService.create(extDto, WorkOrderType.ORGANIZATION_APPROVE.val);
    }

    public String edit(OrgApproveEditDto dto) {
        verifyOrgIdIsRight(dto.getId());
        String orgApproveId = getOrgApproveId(dto.getId());
        OrgApprove approve = createOrgApproveParam(dto);
        if (null == orgApproveId) {
            getDao().insert(approve);
        } else {
            approve.setPk(orgApproveId);
            getDao().updateByPrimaryKeySelective(approve);
        }
        return approve.getPk();
    }

    /**
     * 根据orgId获取认证信息
     */
    public OrgApproveDetailInfo getDetailByOrgId(String id) {
        OrgApproveDetailInfo info = new OrgApproveDetailInfo();
        String pk = getOrgApproveId(id);
        if (null != pk)
            info = getDetail(pk);
        return info;
    }


    private void verifyOrgIdIsRight(String orgId) {
        Organization organization = new Organization();
        organization.setPk(orgId);
        if (organizationService.getDao().selectCount(organization, false) == 0)
            throw new OrganizationNotFoundException();
    }

    private String getOrgApproveId(String id) {
        OrgApprove o = new OrgApprove();
        o.setOrgId(id);
        OrgApprove orgApprove = getDao().selectOne(o, false);
        String pk = null;
        if (null != orgApprove)
            pk = orgApprove.getPk();
        return pk;
    }

    @NotNull
    private OrgApprove createOrgApproveParam(OrgApproveEditDto dto) {
        Organization organization = organizationService.getDao().selectByPrimaryKey(dto.getId());
        OrgApprove approve = assemble(dto, OrgApprove.class);
        approve.setOrgId(organization.getPk());
        approve.setOrgTitle(organization.getTitle());
        approve.setLegalPerson(organization.getContactPerson());
        return approve;
    }
}
