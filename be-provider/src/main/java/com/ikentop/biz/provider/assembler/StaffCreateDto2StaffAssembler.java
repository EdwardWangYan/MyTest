package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.Staff;
import com.ikentop.biz.provider.model.dto.StaffCreateDto;
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
public class StaffCreateDto2StaffAssembler extends Assembler<StaffCreateDto, Staff> {
    @Autowired
    public StaffCreateDto2StaffAssembler(AssemblerFactory factory) {
        factory.put(this, StaffCreateDto.class, Staff.class);
    }

    @Override
    public Staff assemble(StaffCreateDto staffCreateDto) {
        Staff staff = new Staff();
        BeanUtils.copyProperties(staffCreateDto, staff);
        return staff;
    }
}
