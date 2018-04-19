package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.Staff;
import com.ikentop.biz.provider.model.dto.StaffUpdateDto;
import com.ikentop.framework.core.factory.AssemblerFactory;
import com.ikentop.framework.core.pojo.Assembler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : tac
 * @since : 13/09/2017
 */
@Component
public class StaffUpdateDto2StaffAssembler extends Assembler<StaffUpdateDto, Staff> {
    @Autowired
    public StaffUpdateDto2StaffAssembler(AssemblerFactory factory) {
        factory.put(this, StaffUpdateDto.class, Staff.class);
    }

    @Override
    public Staff assemble(StaffUpdateDto dto) {
        Staff staff = new Staff();
        BeanUtils.copyProperties(dto, staff);
        staff.setPk(dto.getId());
        return staff;
    }
}
