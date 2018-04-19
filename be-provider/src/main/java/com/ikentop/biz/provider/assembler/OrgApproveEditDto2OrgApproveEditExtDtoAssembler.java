package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.provider.model.dto.OrgApproveEditDto;
import com.ikentop.biz.provider.model.dto.OrgApproveEditExtDto;
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
public class OrgApproveEditDto2OrgApproveEditExtDtoAssembler extends Assembler<OrgApproveEditDto, OrgApproveEditExtDto> {
    @Autowired
    public OrgApproveEditDto2OrgApproveEditExtDtoAssembler(AssemblerFactory factory) {
        factory.put(this, OrgApproveEditDto.class, OrgApproveEditExtDto.class);
    }

    @Override
    public OrgApproveEditExtDto assemble(OrgApproveEditDto dto) {
        OrgApproveEditExtDto o = new OrgApproveEditExtDto();
        BeanUtils.copyProperties(dto, o);
        return o;
    }
}
