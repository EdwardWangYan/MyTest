package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.Organization;
import com.ikentop.biz.provider.model.dto.OrganizationUpdateDto;
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
public class OrganizationUpdateDto2OrganizationAssembler extends Assembler<OrganizationUpdateDto, Organization> {
    @Autowired
    public OrganizationUpdateDto2OrganizationAssembler(AssemblerFactory factory) {
        factory.put(this, OrganizationUpdateDto.class, Organization.class);
    }

    @Override
    public Organization assemble(OrganizationUpdateDto dto) {
        Organization o = new Organization();
        BeanUtils.copyProperties(dto, o);
        o.setPk(dto.getId());
        return o;
    }
}
