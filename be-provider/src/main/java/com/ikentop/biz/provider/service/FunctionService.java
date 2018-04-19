package com.ikentop.biz.provider.service;

import com.ikentop.biz.model.entity.Function;
import com.ikentop.biz.provider.config.BizDataInterfaceExt;
import com.ikentop.biz.provider.dao.FunctionDao;
import com.ikentop.biz.provider.exception.*;
import com.ikentop.biz.provider.model.dto.*;
import com.ikentop.framework.core.spring.bean.BizDataInterface;
import com.ikentop.framework.service.GenericServiceSupport;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * @author : Huqiao
 * @since : 2017/10/22
 */
@Service
@Transactional
public class FunctionService extends GenericServiceSupport<FunctionDao> {
    @Autowired
    private OrgTypeService orgTypeService;
    @Autowired
    private BizDataInterface bizDataInterface;

    @Autowired
    public FunctionService(FunctionDao functionDao) {
        super(functionDao);
    }

    public List<FunctionMenuInfo> list4tree() {
        List<Function> functions = getDao().list4tree(currentOrgType(), isNotAdmin());
        return assemble(functions, FunctionMenuInfo.class);
    }

    public String create(FunctionCreateDto dto) {
        if (StringUtils.isBlank(dto.getParentId()))
            dto.setParentId(null);
        verifyOrgTypeIsExist(dto.getOrgType());
        assertFunctionPermissionValueIsUnique(dto.getPermissionValue());
        throwFunctionConNotCreate(dto.getParentId());
        Function function = assemble(dto, Function.class);
        getDao().insert(function);
        return function.getPk();
    }

    public Integer update(FunctionUpdateDto dto) {
        if (!existFunction(dto.getId()))
            throw new FunctionNotFoundException();
        Function function = assemble(dto, Function.class);
        return getDao().updateByPrimaryKeySelective(function);
    }

    public FunctionDetailInfo getDetail(String id) {
        return getDao().getDetail(id);
    }

    /**
     * 获取角色关联的权限列表
     */
    public List<Function4RoleInfo> list4Role(String id) {
        String orgType = null;
        if (isNotAdmin())
            orgType = currentOrgType();
        return getDao().list4Role(id, orgType);
    }

    boolean existFunction(String functionId) {
        return getDao().selectByPrimaryKey(functionId) != null;
    }

    List<Function> list4CreateOrg(String orgTypeCode) {
        return getDao().list4CreateOrg(orgTypeCode);
    }

    private void assertFunctionPermissionValueIsUnique(String permissionValue) {
        if (getDao().getFunctionByValue(permissionValue))
            throw new FunctionPermissionValueIsAlreadyExistException();
    }

    @SuppressWarnings("Duplicates")
    private void throwFunctionConNotCreate(String parentId) {
        if (null != parentId && parentId.trim() != "") {
            Function function = getDao().selectByPrimaryKey(parentId);
            if (null == function)
                throw new FunctionParentIdIsWrongException();
            if (null != function.getParentId())
                throw new FunctionConnotCreateException();
        }
    }

    private boolean isNotAdmin() {
        return !Objects.equals("1725c88db25a46539e3950420a783635", bizDataInterface.currentUserId());
    }


    private void verifyOrgTypeIsExist(String orgType) {
        if (!orgTypeService.verifyOrgTypeIsExist(orgType))
            throw new OrgTypeIsNotExistException();
    }

    private String currentOrgType() {
        return ((BizDataInterfaceExt) bizDataInterface).currentOrgType();
    }
}
