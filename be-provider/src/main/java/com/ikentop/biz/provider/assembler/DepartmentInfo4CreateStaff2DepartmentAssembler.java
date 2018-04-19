package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.DepartmentStaff;
import com.ikentop.biz.provider.model.dto.DepartmentStaffCreateInfo;
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
public class DepartmentInfo4CreateStaff2DepartmentAssembler extends Assembler<DepartmentStaffCreateInfo, DepartmentStaff> {
    @Autowired
    public DepartmentInfo4CreateStaff2DepartmentAssembler(AssemblerFactory factory) {
        factory.put(this, DepartmentStaffCreateInfo.class, DepartmentStaff.class);
    }

    @Override
    public DepartmentStaff assemble(DepartmentStaffCreateInfo info) {
        DepartmentStaff departmentStaff = new DepartmentStaff();
        BeanUtils.copyProperties(info, departmentStaff);
        departmentStaff.setDeptId(info.getDepartmentId());
        return departmentStaff;
    }
}
