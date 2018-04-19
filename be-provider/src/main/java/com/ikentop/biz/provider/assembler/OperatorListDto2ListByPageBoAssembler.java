package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.provider.model.bo.ListByPageBo;
import com.ikentop.biz.provider.model.dto.OperatorListDto;
import com.ikentop.framework.core.factory.AssemblerFactory;
import com.ikentop.framework.core.pojo.Assembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : tac
 * @since : 13/09/2017
 */
@Component
public class OperatorListDto2ListByPageBoAssembler extends Assembler<OperatorListDto, ListByPageBo> {
    @Autowired
    public OperatorListDto2ListByPageBoAssembler(AssemblerFactory factory) {
        factory.put(this, OperatorListDto.class, ListByPageBo.class);
    }

    @Override
    public ListByPageBo assemble(OperatorListDto operatorListDto) {
        ListByPageBo bo = new ListByPageBo();
        //todo::
        return bo;
    }
}
