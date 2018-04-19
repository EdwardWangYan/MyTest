package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.Staff;
import com.ikentop.biz.provider.model.dto.OrganizationRegisterDto;
import com.ikentop.framework.core.factory.AssemblerFactory;
import com.ikentop.framework.core.pojo.Assembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : Huqiao
 * @since : 2017/10/23
 */
@Component
public class OrganizationRegisterDto2StaffAssembler extends Assembler<OrganizationRegisterDto, Staff> {
    @Autowired
    public OrganizationRegisterDto2StaffAssembler(AssemblerFactory factory) {
        factory.put(this, OrganizationRegisterDto.class, Staff.class);
    }

    @Override
    public Staff assemble(OrganizationRegisterDto dto) {
        Staff staff = new Staff();
        staff.setStaffName(dto.getContactPerson());
        staff.setMobile(dto.getTelephone());
        return staff;
    }
}
