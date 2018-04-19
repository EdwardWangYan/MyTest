package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.Staff;
import com.ikentop.biz.provider.model.dto.CurrentOperatorUpdateDto;
import com.ikentop.framework.core.factory.AssemblerFactory;
import com.ikentop.framework.core.pojo.Assembler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : Huqiao
 * @since : 15/11/2017
 */
@Component
public class CurrentOperatorUpdateDto2StaffAssembler extends Assembler<CurrentOperatorUpdateDto, Staff> {
    @Autowired
    public CurrentOperatorUpdateDto2StaffAssembler(AssemblerFactory factory) {
        factory.put(this, CurrentOperatorUpdateDto.class, Staff.class);
    }

    @Override
    public Staff assemble(CurrentOperatorUpdateDto dto) {
        Staff staff = new Staff();
        BeanUtils.copyProperties(dto, staff);
        staff.setPk(dto.getId());
        return staff;
    }
}
