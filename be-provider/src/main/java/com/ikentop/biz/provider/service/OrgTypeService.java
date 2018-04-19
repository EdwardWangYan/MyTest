package com.ikentop.biz.provider.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ikentop.biz.model.entity.OrgType;
import com.ikentop.biz.provider.dao.OrgTypeDao;
import com.ikentop.biz.provider.exception.OrgTypeCodeAlreadyExistException;
import com.ikentop.biz.provider.exception.OrgTypeIsNotExistException;
import com.ikentop.biz.provider.model.dto.*;
import com.ikentop.framework.core.pojo.DataTableResponse;
import com.ikentop.framework.service.GenericServiceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : Huqiao
 * @since : 2017/10/24
 */
@Service
@Transactional
public class OrgTypeService extends GenericServiceSupport<OrgTypeDao> {
    @Autowired
    public OrgTypeService(OrgTypeDao orgTypeDao) {
        super(orgTypeDao);
    }

    /**
     * 获取机构类型列表
     */
    public DataTableResponse<OrgTypeListInfo> list(OrgTypeListDto dto) {
        PageHelper.startPage(dto.getIndex(), dto.getSize());
        List<OrgTypeListInfo> list = getDao().getList(dto);
        return DataTableResponse.fromPageInfo(new PageInfo<>(list));
    }

    public String create(OrgTypeCreateDto dto) {
        throwOrgTypeCodeAlreadyExist(dto.getCode());
        OrgType orgType = assemble(dto, OrgType.class);
        getDao().insert(orgType);
        return orgType.getPk();
    }

    public String update(OrgTypeUpdateDto dto) {
        verifyOrgTypeId(dto.getId());
        OrgType orgType = assemble(dto, OrgType.class);
        getDao().updateByPrimaryKeySelective(orgType);
        return orgType.getPk();
    }

    public Integer delete(String id) {
        verifyOrgTypeId(id);
        return getDao().deleteByPrimaryKey(id);
    }

    public OrgTypeDetailInfo getDetail(String id) {
        OrgType orgType = getDao().selectByPrimaryKey(id);
        return assemble(orgType, OrgTypeDetailInfo.class);
    }

    protected boolean verifyOrgTypeIsExist(String code) {
        OrgType orgType = new OrgType();
        orgType.setCode(code);
        return getDao().selectCount(orgType) > 0;
    }

    protected OrgType getOrgType4CreateOrg(String orgTypeCode) {
        return getDao().getOrgType4CreateOrg(orgTypeCode);
    }

    private void verifyOrgTypeId(String id) {
        if (null == getDao().selectByPrimaryKey(id))
            throw new OrgTypeIsNotExistException();
    }

    private void throwOrgTypeCodeAlreadyExist(String code) {
        if (getDao().paramterIsAlreadyExist("code", code))
            throw new OrgTypeCodeAlreadyExistException();
    }

    public List<OrgTypeDropDownInfo> list4DropDown() {
        List<OrgType> list = getDao().selectAll();
        return assemble(list,OrgTypeDropDownInfo.class);
    }
}
