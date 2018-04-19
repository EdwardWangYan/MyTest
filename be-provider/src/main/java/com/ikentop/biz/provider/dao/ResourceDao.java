package com.ikentop.biz.provider.dao;

import com.ikentop.biz.model.entity.Resource;
import com.ikentop.biz.provider.mapper.ResourceMapper;
import com.ikentop.biz.provider.model.dto.*;
import com.ikentop.framework.dao.GenericDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author qiao
 * @author tac
 * @since 2017/9/4
 */
@Repository
public class ResourceDao extends GenericDaoSupport<Resource, String> {
    private ResourceMapper mapper;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public ResourceDao(ResourceMapper mapper) {
        super(mapper, Resource.class);
        this.mapper = mapper;
    }

    public List<ResourceListInfo> listNextLevel(ResourceListDto dto) {
        return mapper.listNextLevel(dto);
    }

    public List<Resource> list4tree() {
        return this.selectAll();
    }

    public List<Resource4ParentInfo> list4parent(ResourceList4ParentDto dto) {
        return mapper.list4parent(dto);
    }

    public ResourceListInfo getDetail(String id) {
        return mapper.getDetail(id);
    }

    public List<Resource4RoleInfo> list4Role(String operatorId ,String id, String orgType) {
        return mapper.list4Role(operatorId,id,orgType);
    }

    public List<Resource4RoleInfo> list4CurrentOperator(String id, String orgType) {
        return mapper.list4CurrentOperator(id, orgType);
    }

    public List<Resource> list4AdminRole(String orgTypeCode) {
        return mapper.list4AdminRole(orgTypeCode);
    }

    public List<Resource4RoleInfo> list4CurrentAdmin() {
        return mapper.list4CurrentAdmin();
    }
}
