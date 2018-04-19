package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.Department;
import com.ikentop.biz.provider.model.dto.DepartmentCreateDto;
import com.ikentop.framework.core.factory.AssemblerFactory;
import com.ikentop.framework.core.pojo.Assembler;
import com.ikentop.framework.core.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author tac
 * @since 18/09/2017
 */
@Component
public class DepartmentCreateDto2DepartmentAssembler extends Assembler<DepartmentCreateDto, Department> {
    @Autowired
    public DepartmentCreateDto2DepartmentAssembler(AssemblerFactory factory) {
        factory.put(this, DepartmentCreateDto.class, Department.class);
    }

    @Override
    public Department assemble(DepartmentCreateDto departmentCreateDto) {
        Department tmp = new Department();
        BeanUtils.copyProperties(departmentCreateDto, tmp);
        return tmp;
    }
}
