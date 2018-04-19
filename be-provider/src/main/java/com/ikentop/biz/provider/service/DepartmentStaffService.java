package com.ikentop.biz.provider.service;

import com.ikentop.biz.model.entity.Department;
import com.ikentop.biz.model.entity.DepartmentStaff;
import com.ikentop.biz.provider.dao.DepartmentStaffDao;
import com.ikentop.biz.provider.exception.DepartmentNotFoundException;
import com.ikentop.biz.provider.model.dto.DepartmentStaffCreateInfo;
import com.ikentop.framework.service.GenericServiceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : Huqiao
 * @since : 2017/10/31
 */
@Service
@Transactional
public class DepartmentStaffService extends GenericServiceSupport<DepartmentStaffDao> {
    @Autowired
    public DepartmentStaffService(DepartmentStaffDao departmentStaffDao) {
        super(departmentStaffDao);
    }

    @Autowired
    private DepartmentService departmentService;

    public void relateDepatStaff(String pk, List<DepartmentStaffCreateInfo> list) {
        throwDepartmentIsNotExist(list);
        DepartmentStaff o = getDepartmentStaff(list.get(0), pk);
        if (null != o) {
            updateDepartmentStaff(o, list.get(0));
            return;
        }
        DepartmentStaff departmentStaff = new DepartmentStaff();
        departmentStaff.setStaffId(pk);
        departmentStaff.setDeptId(list.get(0).getDepartmentId());
        departmentStaff.setStartTime(list.get(0).getStartTime());
        getDao().insert(departmentStaff);
    }

    private void updateDepartmentStaff(DepartmentStaff o, DepartmentStaffCreateInfo info) {
        DepartmentStaff departmentStaff = assemble(info, DepartmentStaff.class);
        departmentStaff.setPk(o.getPk());
        getDao().updateByPrimaryKeySelective(departmentStaff);
    }

    private DepartmentStaff getDepartmentStaff(DepartmentStaffCreateInfo info, String pk) {
        DepartmentStaff departmentStaff = new DepartmentStaff();
        departmentStaff.setStaffId(pk);
        departmentStaff.setDeptId(info.getDepartmentId());
        return getDao().selectOne(departmentStaff);
    }

    private void throwDepartmentIsNotExist(List<DepartmentStaffCreateInfo> departmentInfos) {
        Department department = new Department();
        department.setPk(departmentInfos.get(0).getDepartmentId());
        if (departmentService.getDao().selectCount(department) == 0)
            throw new DepartmentNotFoundException();
    }
}
