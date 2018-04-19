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
public class OrgApproveEditExtDto2OrgApproveEditDtoAssembler extends Assembler<OrgApproveEditExtDto, OrgApproveEditDto> {
    @Autowired
    public OrgApproveEditExtDto2OrgApproveEditDtoAssembler(AssemblerFactory factory) {
        factory.put(this, OrgApproveEditExtDto.class, OrgApproveEditDto.class);
    }

    @Override
    public OrgApproveEditDto assemble(OrgApproveEditExtDto dto) {
        OrgApproveEditDto o = new OrgApproveEditDto();
        BeanUtils.copyProperties(dto, o);
        o.setPermitPicId(dto.getPermitPicInfo().getImageId());
        return o;
    }
}
