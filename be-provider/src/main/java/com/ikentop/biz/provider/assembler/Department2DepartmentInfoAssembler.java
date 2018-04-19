package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.Department;
import com.ikentop.biz.provider.model.dto.DepartmentInfo;
import com.ikentop.framework.core.factory.AssemblerFactory;
import com.ikentop.framework.core.pojo.Assembler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : Huqiao
 * @since : 2017/10/25
 */
@Component
public class Department2DepartmentInfoAssembler extends Assembler<Department, DepartmentInfo> {
    @Autowired
    public Department2DepartmentInfoAssembler(AssemblerFactory factory) {
        factory.put(this, Department.class, DepartmentInfo.class);
    }


    @Override
    public DepartmentInfo assemble(Department department) {
        DepartmentInfo info = new DepartmentInfo();
        BeanUtils.copyProperties(department, info);
        info.setId(department.getPk());
        info.setTitle(department.getDeptName());
        return info;
    }
}
