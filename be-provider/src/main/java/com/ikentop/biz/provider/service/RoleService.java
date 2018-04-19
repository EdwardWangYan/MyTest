package com.ikentop.biz.provider.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ikentop.biz.constant.OrgTypeValue;
import com.ikentop.biz.model.entity.Role;
import com.ikentop.biz.provider.config.BizDataInterfaceExt;
import com.ikentop.biz.provider.dao.RoleDao;
import com.ikentop.biz.provider.exception.RoleCodeRepeatException;
import com.ikentop.biz.provider.exception.RoleNotBelongToCurrentOrgException;
import com.ikentop.biz.provider.exception.RoleNotFoundException;
import com.ikentop.biz.provider.model.dto.*;
import com.ikentop.framework.core.pojo.DataTableResponse;
import com.ikentop.framework.core.spring.bean.BizDataInterface;
import com.ikentop.framework.service.GenericServiceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * @author : tac
 * @since : 06/09/2017
 */
@Service
@Transactional
public class RoleService extends GenericServiceSupport<RoleDao> {
    @Autowired
    private BizDataInterface bizDataInterface;
    @Autowired
    private RoleFunctionService roleFunctionService;
    @Autowired
    private OperatorService operatorService;

    @Autowired
    public RoleService(RoleDao roleDao) {
        super(roleDao);
    }

    /**
     * 新增角色
     */
    public String create(RoleCreateDto dto) {
        if (getDao().isRepeatOrgRoleCode(dto.getCode())) {
            throw new RoleCodeRepeatException();
        }
        Role o = assemble(dto, Role.class);
        o.setTypeId(currentOrgType());
        getDao().insert(o);
        return o.getPk();
    }

    public DataTableResponse<RoleDetailInfo> list4Admin(RoleListDto dto) {
        dto.setOrgId(currentOrgId());
        PageHelper.startPage(dto.getIndex(), dto.getSize());
        List<RoleDetailInfo> ls = getDao().list4Admin(dto);
        return DataTableResponse.fromPageInfo(new PageInfo<>(ls));
    }

    public List<RoleDetailInfo> list4RelateRole() {
        RoleListDto dto = new RoleListDto();
        dto.setOrgId(currentOrgId());
        return getDao().list4Admin(dto);
    }

    /**
     * 修改角色
     */
    public Integer update(RoleUpdateDto dto) {
        verifyRoleId(dto.getId());
        Role role = assemble(dto, Role.class);
        return getDao().updateByPrimaryKeySelective(role);
    }

    public Integer delete(String id) {
        verifyRoleId(id);
        return getDao().deleteByPrimaryKey(id);
    }

    /**
     * 查询与操作员相关联的角色列表
     */
    public List<Role4OperatorInfo> list4operator(String id) {
        operatorService.assertOperatorIsExist(id);
        return getDao().list4operator(id);
    }


    public RoleDetailInfo getDetail(String id) {
        RoleDetailInfo info = getDao().getDetail(id, currentOrgId());
        return info;
    }

    String currentOrgType() {
        return ((BizDataInterfaceExt) bizDataInterface).currentOrgType();
    }

    String createRole4Org(String orgTypeCode, String pk, String title) {
        Role role = new Role();
        role.setRoleName(title + "管理员");
        role.setCode("admin");
        role.setRemark("为组织创建的管理员角色");
        role.setTypeId(orgTypeCode);
        role.setOrgId(pk);
        getDao().insert(role);
        return role.getPk();
    }

    String currentOrgId() {
        return bizDataInterface.currentOrgId();
    }


    void verifyRoleId(String id) {
        Role role = getDao().selectByPrimaryKey(id, false);
        if (null == role)
            throw new RoleNotFoundException();
        if (!Objects.equals(OrgTypeValue.COMMON.val, role.getTypeId()) && !Objects.equals(currentOrgId(), role.getOrgId()))//机构管理员可以修改通用角色
            throw new RoleNotBelongToCurrentOrgException();
    }

    protected boolean existRole(String roleId) {
        Role o = new Role();
        o.setPk(roleId);
        return getDao().selectCount(o) > 0;
    }

    protected boolean existRole4Super(String roleId) {
        Role o = new Role();
        o.setPk(roleId);
        return getDao().selectCount(o, false) > 0;
    }


    private boolean orgIsNotPlatform() {
        return !Objects.equals(OrgTypeValue.PLATFORM.val, currentOrgType());
    }
}

