package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.provider.model.dto.OrganizationUpdateDto;
import com.ikentop.biz.provider.model.dto.OrganizationUpdateExtDto;
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
public class OrganizationUpdateExtDto2OrganizationUpdateDtoAssembler extends Assembler<OrganizationUpdateExtDto, OrganizationUpdateDto> {
    @Autowired
    public OrganizationUpdateExtDto2OrganizationUpdateDtoAssembler(AssemblerFactory factory) {
        factory.put(this, OrganizationUpdateExtDto.class, OrganizationUpdateDto.class);
    }

    @Override
    public OrganizationUpdateDto assemble(OrganizationUpdateExtDto dto) {
        OrganizationUpdateDto o = new OrganizationUpdateDto();
        BeanUtils.copyProperties(dto, o);
        o.setOrgLogoId(dto.getOrgLogoInfo().getImageId());
        return o;
    }
}
