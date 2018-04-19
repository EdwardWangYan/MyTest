package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.Function;
import com.ikentop.biz.provider.model.dto.FunctionUpdateDto;
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
public class FunctionUpdateDto2FunctionAssembler extends Assembler<FunctionUpdateDto, Function> {
    @Autowired
    public FunctionUpdateDto2FunctionAssembler(AssemblerFactory factory) {
        factory.put(this, FunctionUpdateDto.class, Function.class);
    }

    @Override
    public Function assemble(FunctionUpdateDto dto) {
        Function function = new Function();
        BeanUtils.copyProperties(dto, function);
        function.setPk(dto.getId());
        return function;
    }
}
