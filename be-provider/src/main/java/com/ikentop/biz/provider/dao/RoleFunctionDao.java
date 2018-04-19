package com.ikentop.biz.provider.dao;

import com.ikentop.biz.model.entity.RoleFunction;
import com.ikentop.biz.provider.mapper.RoleFunctionMapper;
import com.ikentop.framework.dao.GenericDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author : Huqiao
 * @date : 2017/9/7
 */
@Repository
public class RoleFunctionDao extends GenericDaoSupport<RoleFunction, String> {
    private RoleFunctionMapper mapper;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public RoleFunctionDao(RoleFunctionMapper mapper) {
        super(mapper, RoleFunction.class);
        this.mapper = mapper;
    }

    public void emptyRoleFunction(String roleId) {
        RoleFunction o = new RoleFunction();
        o.setRoleId(roleId);
        mapper.delete(o);
    }
}
