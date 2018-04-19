package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.Operator;
import com.ikentop.biz.provider.model.dto.OperatorCreateDto;
import com.ikentop.framework.core.factory.AssemblerFactory;
import com.ikentop.framework.core.pojo.Assembler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : Huqiao
 * @since : 2017/9/5
 */
@Component
public class OperatorCreateDto2OperatorAssembler extends Assembler<OperatorCreateDto, Operator> {
    @Autowired
    public OperatorCreateDto2OperatorAssembler(AssemblerFactory factory) {
        factory.put(this, OperatorCreateDto.class, Operator.class);
    }

    @Override
    public Operator assemble(OperatorCreateDto dto) {
        Operator operator = new Operator();
        BeanUtils.copyProperties(dto,operator);
        return operator;
    }
}
