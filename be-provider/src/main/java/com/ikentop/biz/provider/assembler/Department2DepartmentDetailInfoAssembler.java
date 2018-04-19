package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.Department;
import com.ikentop.biz.provider.model.dto.DepartmentDetailInfo;
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
public class Department2DepartmentDetailInfoAssembler extends Assembler<Department, DepartmentDetailInfo> {
    @Autowired
    public Department2DepartmentDetailInfoAssembler(AssemblerFactory factory) {
        factory.put(this, Department.class, DepartmentDetailInfo.class);
    }


    @Override
    public DepartmentDetailInfo assemble(Department department) {
        DepartmentDetailInfo info = new DepartmentDetailInfo();
        BeanUtils.copyProperties(department, info);
        info.setId(department.getPk());
        return info;
    }
}
