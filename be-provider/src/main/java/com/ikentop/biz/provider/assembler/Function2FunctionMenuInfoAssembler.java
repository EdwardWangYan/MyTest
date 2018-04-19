package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.Function;
import com.ikentop.biz.provider.model.dto.FunctionMenuInfo;
import com.ikentop.framework.core.factory.AssemblerFactory;
import com.ikentop.framework.core.pojo.Assembler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author tac
 * @since 2017/9/15
 */
@Component
public class Function2FunctionMenuInfoAssembler extends Assembler<Function, FunctionMenuInfo> {
    @Autowired
    public Function2FunctionMenuInfoAssembler(AssemblerFactory factory) {
        factory.put(this, Function.class, FunctionMenuInfo.class);
    }

    @Override
    public FunctionMenuInfo assemble(Function function) {
        FunctionMenuInfo info = new FunctionMenuInfo();
        BeanUtils.copyProperties(function, info);
        info.setId(function.getPk());
        info.setTitle(function.getFunctionTitle());
        return info;
    }
}
