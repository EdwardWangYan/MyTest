package com.ikentop.biz.provider.service;

import com.ikentop.biz.model.entity.Resource;
import com.ikentop.biz.model.entity.RoleResource;
import com.ikentop.biz.provider.dao.RoleResourceDao;
import com.ikentop.biz.provider.model.dto.RoleResourceRelatedDto;
import com.ikentop.framework.service.GenericServiceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Huqiao
 * @since : 2017/10/20
 */
@Service
@Transactional
public class RoleResourceService extends GenericServiceSupport<RoleResourceDao> {
    @Autowired
    private RoleService roleService;
    @Autowired
    private ResourceService resourceService;

    @Autowired
    public RoleResourceService(RoleResourceDao roleResourceDao) {
        super(roleResourceDao);
    }

    public Integer related(RoleResourceRelatedDto dto) {
        verifyRoleId(dto.getRoleId());
        emptyRoleResource(dto.getRoleId());
        List<RoleResource> list = new ArrayList<>();
        RoleResource roleResource = null;
        for (String resourceId : dto.getResouceIds()) {
            resourceService.verifyResourceId(resourceId);
            roleResource = new RoleResource();
            roleResource.setRoleId(dto.getRoleId());
            roleResource.setResourceId(resourceId);
            list.add(roleResource);
        }
        return getDao().insertBatch(list);
    }

    private void emptyRoleResource(String roleId) {
        getDao().emptyRoleResource(roleId);
    }

    private void verifyRoleId(String roleId) {
        roleService.verifyRoleId(roleId);
    }

    public void allotResource4AdminRole(String roleId, String orgTypeCode) {
        List<Resource> resources = resourceService.list4AdminRole(orgTypeCode);
        List<RoleResource> list = new ArrayList<>();
        RoleResource roleResource = null;
        for (Resource resource : resources) {
            roleResource = new RoleResource();
            roleResource.setRoleId(roleId);
            roleResource.setResourceId(resource.getPk());
            list.add(roleResource);
        }
        getDao().insertBatch(list);
    }
}
