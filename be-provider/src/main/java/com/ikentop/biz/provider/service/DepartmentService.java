package com.ikentop.biz.provider.service;

import com.ikentop.biz.model.entity.Department;
import com.ikentop.biz.provider.dao.DepartmentDao;
import com.ikentop.biz.provider.exception.DepartmentNotFoundException;
import com.ikentop.biz.provider.exception.RepeatedDepartmentCodeException;
import com.ikentop.biz.provider.model.dto.DepartmentCreateDto;
import com.ikentop.biz.provider.model.dto.DepartmentDetailInfo;
import com.ikentop.biz.provider.model.dto.DepartmentInfo;
import com.ikentop.biz.provider.model.dto.DepartmentUpdateDto;
import com.ikentop.framework.core.spring.bean.BizDataInterface;
import com.ikentop.framework.service.GenericServiceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Huqiao
 * @author tac
 * @since 2017/9/6
 */

@Profile({"dev", "test", "prod"})
@Service
@Transactional
public class DepartmentService extends GenericServiceSupport<DepartmentDao> {
    @Autowired
    private BizDataInterface bizDataInterface;

    @Autowired
    public DepartmentService(DepartmentDao departmentDao) {
        super(departmentDao);
    }

    public String create(DepartmentCreateDto dto) {
        if (existCode(dto.getCode())) {
            throw new RepeatedDepartmentCodeException();
        }
        if (dto.getParentId() != null && !existDepartment(dto.getParentId())) {
            throw new DepartmentNotFoundException();
        }

        Department o = assemble(dto, Department.class);
        getDao().insert(o);
        return o.getPk();
    }

    /**
     * 获取部门列表
     */
    public List<DepartmentInfo> list() {
        List<Department> list = getDao().list();
        return assemble(list, DepartmentInfo.class);
    }

    /**
     * 获取部门详细信息
     */
    public DepartmentDetailInfo getDetail(String id) {
        return getDao().getDetail(id,bizDataInterface.currentOrgId());
    }

    public Integer update(DepartmentUpdateDto dto) {
        verifyDepaertmentIdIsWrong(dto.getId());
        Department department = assemble(dto, Department.class);
        return getDao().updateByPrimaryKeySelective(department);
    }

    public Department getDepartmentById(String departmentId) {
        return getDao().selectByPrimaryKey(departmentId);
    }

    protected boolean existCode(String code) {
        Department o = new Department();
        o.setCode(code);
        o.setOrgId(currentOrgId());
        return getDao().selectCount(o) > 0;
    }

    protected boolean existDepartment(String parentId) {
        Department o = new Department();
        o.setPk(parentId);
        return getDao().selectCount(o) > 0;
    }

    private String currentOrgId() {
        return bizDataInterface.currentOrgId();
    }

    private void verifyDepaertmentIdIsWrong(String id) {
        if (existCode(id))
            throw new DepartmentNotFoundException();
    }
}
