package com.ikentop.biz.provider.dao;

import com.ikentop.biz.model.entity.OperatorRole;
import com.ikentop.biz.provider.mapper.OperatorRoleMapper;
import com.ikentop.framework.dao.GenericDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author : Huqiao
 * @date : 2017/9/7
 */
@Repository
public class OperatorRoleDao extends GenericDaoSupport<OperatorRole, String> {
    private OperatorRoleMapper mapper;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public OperatorRoleDao(OperatorRoleMapper mapper) {
        super(mapper, OperatorRole.class);
        this.mapper = mapper;
    }

    public void emptyOperatorRole(String id) {
        OperatorRole o = new OperatorRole();
        o.setOperatorId(id);
        mapper.delete(o);
    }
}
