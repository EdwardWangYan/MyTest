package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.OrgType;
import com.ikentop.biz.provider.model.dto.OrgTypeCreateDto;
import com.ikentop.framework.core.factory.AssemblerFactory;
import com.ikentop.framework.core.pojo.Assembler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : Huqiao
 * @since : 2017/10/24
 */
@Component
public class OrgTypeCreateDto2OrgTypeAssembler extends Assembler<OrgTypeCreateDto, OrgType> {
    @Autowired
    public OrgTypeCreateDto2OrgTypeAssembler(AssemblerFactory factory) {
        factory.put(this, OrgTypeCreateDto.class, OrgType.class);
    }

    @Override
    public OrgType assemble(OrgTypeCreateDto orgTypeCreateDto) {
        OrgType orgType = new OrgType();
        BeanUtils.copyProperties(orgTypeCreateDto, orgType);
        return orgType;
    }
}
