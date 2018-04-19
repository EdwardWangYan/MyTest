package com.ikentop.biz.provider.dao;

import com.ikentop.biz.constant.DeletedFlag;
import com.ikentop.biz.model.entity.Role;
import com.ikentop.biz.provider.mapper.RoleMapper;
import com.ikentop.biz.provider.model.dto.Role4OperatorInfo;
import com.ikentop.biz.provider.model.dto.RoleDetailInfo;
import com.ikentop.biz.provider.model.dto.RoleListDto;
import com.ikentop.framework.core.spring.bean.BizDataInterface;
import com.ikentop.framework.dao.GenericDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Huqiao
 * @author tac
 * @since 2017/9/4
 */
@Repository
public class RoleDao extends GenericDaoSupport<Role, String> {
    @Autowired
    private BizDataInterface bizDataInterface;

    private RoleMapper mapper;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public RoleDao(RoleMapper mapper) {
        super(mapper, Role.class);
        this.mapper = mapper;
    }

    public List<RoleDetailInfo> list4Admin(RoleListDto dto) {
        return mapper.list4Admin(dto);
    }

    public List<Role4OperatorInfo> list4operator(String id) {
        return mapper.list4operator(id);
    }

    public RoleDetailInfo getDetail(String id, String orgId) {
        return mapper.getDetail(id, orgId);
    }

    public Set<String> getRoleNames(String id) {
        List<String> roleNames = mapper.getRoleNames(id);
        return new HashSet<>(roleNames);
    }

    public boolean isRepeatOrgRoleCode(String code) {
        Role o = new Role();
        o.setCode(code);
        o.setOrgId(bizDataInterface.currentOrgId());
        o.setDeletedFlag(DeletedFlag.ENABLE.getVal());
        return mapper.selectOne(o) != null;
    }
}
