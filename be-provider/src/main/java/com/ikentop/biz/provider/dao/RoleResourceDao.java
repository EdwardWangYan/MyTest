package com.ikentop.biz.provider.dao;

import com.ikentop.biz.model.entity.RoleResource;
import com.ikentop.biz.provider.mapper.RoleResourceMapper;
import com.ikentop.framework.dao.GenericDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author : Huqiao
 * @since : 2017/10/20
 */
@Repository
public class RoleResourceDao extends GenericDaoSupport<RoleResource, String> {

    private RoleResourceMapper mapper;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public RoleResourceDao(RoleResourceMapper mapper) {
        super(mapper, RoleResource.class);
        this.mapper = mapper;
    }

    public void emptyRoleResource(String roleId) {
        RoleResource o = new RoleResource();
        o.setRoleId(roleId);
        mapper.delete(o);
    }


}
