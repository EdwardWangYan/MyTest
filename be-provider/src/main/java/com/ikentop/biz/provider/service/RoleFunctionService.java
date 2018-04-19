package com.ikentop.biz.provider.service;

import com.ikentop.biz.model.entity.Function;
import com.ikentop.biz.model.entity.RoleFunction;
import com.ikentop.biz.provider.dao.RoleFunctionDao;
import com.ikentop.biz.provider.exception.FunctionNotFoundException;
import com.ikentop.biz.provider.exception.RoleNotFoundException;
import com.ikentop.biz.provider.model.dto.RoleFunctionRelatedDto;
import com.ikentop.framework.service.GenericServiceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Huqiao
 * @since : 2017/10/23
 */
@Service
@Transactional
public class RoleFunctionService extends GenericServiceSupport<RoleFunctionDao> {
    @Autowired
    public RoleFunctionService(RoleFunctionDao roleFunctionDao) {
        super(roleFunctionDao);
    }

    @Autowired
    private RoleService roleService;
    @Autowired
    private FunctionService functionService;

    public Integer related(RoleFunctionRelatedDto dto) {
        roleService.verifyRoleId(dto.getRoleId());
        emptyRoleFunction(dto.getRoleId());
        List<RoleFunction> list = new ArrayList<>();
        RoleFunction roleFunction = null;
        for (String functionId : dto.getFunctionIds()) {
            throwFunctionIsNotExist(functionId);
            roleFunction = new RoleFunction();
            roleFunction.setRoleId(dto.getRoleId());
            roleFunction.setPermissionId(functionId);
            list.add(roleFunction);
        }
        return getDao().insertBatch(list);
    }


    /*清空该角色下的权限*/
    private void emptyRoleFunction(String roleId) {
        getDao().emptyRoleFunction(roleId);
    }

    private void throwFunctionIsNotExist(String functionId) {
        if (!functionService.existFunction(functionId))
            throw new FunctionNotFoundException();
    }

    private RoleFunction insertRoleFunction(String roleId, String functionId) {
        RoleFunction roleFunction = new RoleFunction();
        roleFunction.setRoleId(roleId);
        roleFunction.setPermissionId(functionId);
        return roleFunction;
    }

    private void throwRoleIsNotExist(String roleId) {
        if (!roleService.existRole4Super(roleId))
            throw new RoleNotFoundException();
    }

    void allotFunction4AdminRole(String roleId, String orgTypeCode) {
        List<Function> functions = functionService.list4CreateOrg(orgTypeCode);
        List<RoleFunction> list = new ArrayList<>();
        RoleFunction roleFunction;
        for (Function function : functions) {
            roleFunction = new RoleFunction();
            roleFunction.setPermissionId(function.getPk());
            roleFunction.setRoleId(roleId);
            list.add(roleFunction);
        }
        getDao().insertBatch(list);
    }
}
