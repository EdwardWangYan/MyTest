package com.ikentop.biz.provider.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ikentop.biz.constant.ResourceLevel;
import com.ikentop.biz.model.entity.Resource;
import com.ikentop.biz.provider.config.BizDataInterfaceExt;
import com.ikentop.biz.provider.dao.ResourceDao;
import com.ikentop.biz.provider.exception.OrgTypeIsNotExistException;
import com.ikentop.biz.provider.exception.ResourceCreateException;
import com.ikentop.biz.provider.exception.ResourceNotFoundException;
import com.ikentop.biz.provider.exception.ResourceUpdateException;
import com.ikentop.biz.provider.model.dto.*;
import com.ikentop.biz.provider.model.interf.ChildNode;
import com.ikentop.framework.core.pojo.DataTableResponse;
import com.ikentop.framework.core.spring.bean.BizDataInterface;
import com.ikentop.framework.service.GenericServiceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * @author Huqiao
 * @author tac
 * @since 2017/9/6
 */
@Service
@Transactional
public class ResourceService extends GenericServiceSupport<ResourceDao> {
    @Autowired
    private OrgTypeService orgTypeService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private BizDataInterface bizDataInterface;

    @Autowired
    public ResourceService(ResourceDao resourceDao) {
        super(resourceDao);
    }

    public DataTableResponse<ResourceListInfo> listNextLevel(ResourceListDto dto) {
        PageHelper.startPage(dto.getIndex(), dto.getSize());
        dto.setOperatorId(bizDataInterface.currentUserId());
        List<ResourceListInfo> ls = getDao().listNextLevel(dto);
        return DataTableResponse.fromPageInfo(new PageInfo<>(ls));
    }

    /**
     * 创建资源
     */
    public String createResource(ResourceCreateDto dto, ResourceLevel level) {
        if (dto instanceof ChildNode) {
            assertParentLevelEqualTo(((ChildNode) dto).getParentId(), level.getParent());
        }
        verifyOrgTypeIsExist(dto.getOrgType());
        Resource o = buildResource(dto, level);
        getDao().insert(o);
        return o.getPk();
    }

    public List<Resource> list4AdminRole(String orgTypeCode) {
        return getDao().list4AdminRole(orgTypeCode);
    }

    public List<Resource4RoleInfo> list4CurrentOperator() {
        List<Resource4RoleInfo> ls = null;
        if (operatorIsNotAdmin()) {
            ls = getDao().list4CurrentOperator(bizDataInterface.currentUserId(), currentOrgType());
        } else {
            ls = getDao().list4CurrentAdmin();
        }
        return ls;
    }

    /**
     * 为树形获取资源列表
     */
    public List<Resource4Tree> list4tree() {
        List<Resource> resources = getDao().list4tree();
        return assemble(resources, Resource4Tree.class);
    }

    /**
     * 根据父id查询子节点
     */
    public DataTableResponse<Resource4ParentInfo> list4parent(ResourceList4ParentDto dto) {
        PageHelper.startPage(dto.getIndex(), dto.getSize());
        List<Resource4ParentInfo> resource4ParentInfos = getDao().list4parent(dto);
        return DataTableResponse.fromPageInfo(new PageInfo<>(resource4ParentInfos));
    }

    public List<Resource4RoleInfo> list4Role(String id) {
        roleService.verifyRoleId(id);
        return getDao().list4Role(bizDataInterface.currentUserId(), id, currentOrgType());
    }


    public ResourceListInfo getDetail(String id) {
        return getDao().getDetail(id);
    }

    /**
     * 更新
     */
    public String update(ResourceUpdateDto dto) {
        verifyResourceId(dto.getId());
        assertParentLevelIsEqual(dto);
        Resource resource = assemble(dto, Resource.class);
        getDao().updateByPrimaryKeySelective(resource);
        return resource.getPk();
    }

    protected void assertParentLevelEqualTo(String parentId, ResourceLevel level) {
        Resource parent = getDao().selectByPrimaryKey(parentId);
        if (parent == null) {
            throw new ResourceNotFoundException();
        }
        if (!parent.getResourceType().equals(level.getVal())) {
            throw new ResourceCreateException("无法在\"" + level.getDesc() + "\"等级的资源下创建此资源");
        }
    }

    void verifyResourceId(String id) {
        Resource o = new Resource();
        o.setPk(id);
        if (getDao().selectCount(o) == 0)
            throw new ResourceNotFoundException();
    }

    private Resource buildResource(ResourceCreateDto dto, ResourceLevel level) {
        Resource o = assemble(dto, ResourceCreateDto.class, Resource.class);
        o.setResourceType(level.getVal());
        if (dto instanceof ChildNode) {
            o.setParentId(((ChildNode) dto).getParentId());
        } else {
            o.setParentId(null);
        }
        return o;
    }

    private void assertParentLevelIsEqual(ResourceUpdateDto dto) {
        //todo:::
        if (null == dto.getId())
            throw new ResourceUpdateException("id不能为空");
        Resource child = getDao().selectByPrimaryKey(dto.getId());
        if (null == child)
            throw new ResourceNotFoundException();
        if (null != dto.getParentId()) {
            Resource parent = getDao().selectByPrimaryKey(dto.getParentId());
            if (null == parent)
                throw new ResourceUpdateException("父类id错误");
            if (!Objects.equals(dto.getParentId(), child.getParentId())) {
                if (ResourceLevel.OPERATION.getVal() == child.getResourceType())
                    throw new ResourceUpdateException("操作不能修改父类");
                if (ResourceLevel.MODULE.getVal() == child.getResourceType())
                    throw new ResourceUpdateException("模块不能有父类");
                if ((parent.getResourceType() + 1) != child.getResourceType())
                    throw new ResourceUpdateException("子类类型和父类不匹配");
            }
        } else {
            if (ResourceLevel.MENU.getVal() == child.getResourceType())
                throw new ResourceUpdateException("菜单不能没有父类");
            if (ResourceLevel.PAGE.getVal() == child.getResourceType())
                throw new ResourceUpdateException("页面不能没有父类");
            if (ResourceLevel.OPERATION.getVal() == child.getResourceType())
                throw new ResourceUpdateException("操作不能修改父类");
        }
    }


    private void verifyOrgTypeIsExist(String orgType) {
        if (!orgTypeService.verifyOrgTypeIsExist(orgType))
            throw new OrgTypeIsNotExistException();
    }

    private boolean operatorIsNotAdmin() {
        return !Objects.equals("1725c88db25a46539e3950420a783635", bizDataInterface.currentUserId());
    }

    private String currentOrgType() {
        return ((BizDataInterfaceExt) bizDataInterface).currentOrgType();
    }
}
