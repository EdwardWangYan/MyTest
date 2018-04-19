package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.provider.model.dto.OrganizationCreateDto;
import com.ikentop.biz.provider.model.dto.OrganizationRegisterExtDto;
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
public class OrganizationRegisterExtDto2OrganizationCreateDtoAssembler extends Assembler<OrganizationRegisterExtDto, OrganizationCreateDto> {
    @Autowired
    public OrganizationRegisterExtDto2OrganizationCreateDtoAssembler(AssemblerFactory factory) {
        factory.put(this, OrganizationRegisterExtDto.class, OrganizationCreateDto.class);
    }

    @Override
    public OrganizationCreateDto assemble(OrganizationRegisterExtDto dto) {
        OrganizationCreateDto createDto = new OrganizationCreateDto();
        BeanUtils.copyProperties(dto,createDto);
        return createDto;
    }
}
