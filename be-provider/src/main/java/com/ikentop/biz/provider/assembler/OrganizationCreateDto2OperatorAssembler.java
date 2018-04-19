package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.Operator;
import com.ikentop.biz.provider.model.dto.OrganizationCreateDto;
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
public class OrganizationCreateDto2OperatorAssembler extends Assembler<OrganizationCreateDto, Operator> {
    @Autowired
    public OrganizationCreateDto2OperatorAssembler(AssemblerFactory factory) {
        factory.put(this, OrganizationCreateDto.class, Operator.class);
    }

    @Override
    public Operator assemble(OrganizationCreateDto dto) {
        Operator operator = new Operator();
        BeanUtils.copyProperties(dto,operator);
        return operator;
    }
}
