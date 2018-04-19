package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.OrgType;
import com.ikentop.biz.provider.model.dto.OrgTypeUpdateDto;
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
public class OrgTypeUpdateDto2OrgTypeAssembler extends Assembler<OrgTypeUpdateDto, OrgType> {
    @Autowired
    public OrgTypeUpdateDto2OrgTypeAssembler(AssemblerFactory factory) {
        factory.put(this, OrgTypeUpdateDto.class, OrgType.class);
    }

    @Override
    public OrgType assemble(OrgTypeUpdateDto dto) {
        OrgType orgType = new OrgType();
        BeanUtils.copyProperties(dto, orgType);
        orgType.setPk(dto.getId());
        return orgType;
    }
}
