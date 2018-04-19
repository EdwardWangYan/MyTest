package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.Department;
import com.ikentop.biz.provider.model.dto.DepartmentUpdateDto;
import com.ikentop.framework.core.factory.AssemblerFactory;
import com.ikentop.framework.core.pojo.Assembler;
import com.ikentop.framework.core.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : Huqiao
 * @since : 2017/10/23
 */
@Component
public class DepartmentUpdateDto2DepartmentAssembler extends Assembler<DepartmentUpdateDto, Department> {
    @Autowired
    public DepartmentUpdateDto2DepartmentAssembler(AssemblerFactory factory) {
        factory.put(this, DepartmentUpdateDto.class, Department.class);
    }

    @Override
    public Department assemble(DepartmentUpdateDto dto) {
        Department department = new Department();
        BeanUtils.copyProperties(dto, department);
        department.setPk(dto.getId());
        return department;
    }
}
