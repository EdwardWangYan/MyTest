package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.Function;
import com.ikentop.biz.provider.model.dto.FunctionCreateDto;
import com.ikentop.framework.core.factory.AssemblerFactory;
import com.ikentop.framework.core.pojo.Assembler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : Huqiao
 * @since : 2017/10/23
 */
@Component
public class FunctionCreateDto2FunctionAssembler extends Assembler<FunctionCreateDto, Function> {
    @Autowired
    public FunctionCreateDto2FunctionAssembler(AssemblerFactory factory) {
        factory.put(this, FunctionCreateDto.class, Function.class);
    }

    @Override
    public Function assemble(FunctionCreateDto functionCreateDto) {
        Function function = new Function();
        functionCreateDto.setPermissionValue(functionCreateDto.getPermissionValue().trim());
        BeanUtils.copyProperties(functionCreateDto, function);
        return function;
    }
}
