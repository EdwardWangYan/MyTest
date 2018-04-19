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
public class OrganizationUpdateDto2OrganizationUpdateExtDtoAssembler extends Assembler<OrganizationUpdateDto, OrganizationUpdateExtDto> {
    @Autowired
    public OrganizationUpdateDto2OrganizationUpdateExtDtoAssembler(AssemblerFactory factory) {
        factory.put(this, OrganizationUpdateDto.class, OrganizationUpdateExtDto.class);
    }

    @Override
    public OrganizationUpdateExtDto assemble(OrganizationUpdateDto dto) {
        OrganizationUpdateExtDto o = new OrganizationUpdateExtDto();
        BeanUtils.copyProperties(dto, o);
        return o;
    }
}
