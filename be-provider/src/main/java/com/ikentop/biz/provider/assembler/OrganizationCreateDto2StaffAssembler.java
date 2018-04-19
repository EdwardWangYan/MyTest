package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.Staff;
import com.ikentop.biz.provider.model.dto.OrganizationCreateDto;
import com.ikentop.framework.core.factory.AssemblerFactory;
import com.ikentop.framework.core.pojo.Assembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : Huqiao
 * @since : 2017/10/23
 */
@Component
public class OrganizationCreateDto2StaffAssembler extends Assembler<OrganizationCreateDto, Staff> {
    @Autowired
    public OrganizationCreateDto2StaffAssembler(AssemblerFactory factory) {
        factory.put(this, OrganizationCreateDto.class, Staff.class);
    }

    @Override
    public Staff assemble(OrganizationCreateDto dto) {
        Staff staff = new Staff();
        staff.setStaffName(dto.getContactPerson());
        staff.setMobile(dto.getTelephone());
        return staff;
    }
}
