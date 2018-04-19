package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.Organization;
import com.ikentop.biz.provider.model.dto.OrganizationCreateDto;
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
public class OrganizationCreateDto2OrganizationAssembler extends Assembler<OrganizationCreateDto, Organization> {
    @Autowired
    public OrganizationCreateDto2OrganizationAssembler(AssemblerFactory factory) {
        factory.put(this, OrganizationCreateDto.class, Organization.class);
    }

    @Override
    public Organization assemble(OrganizationCreateDto organizationCreateDto) {
        Organization o = new Organization();
        BeanUtils.copyProperties(organizationCreateDto, o);
        return o;
    }
}
