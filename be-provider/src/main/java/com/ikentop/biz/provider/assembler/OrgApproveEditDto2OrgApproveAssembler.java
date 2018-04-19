package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.OrgApprove;
import com.ikentop.biz.provider.model.dto.OrgApproveEditDto;
import com.ikentop.framework.core.factory.AssemblerFactory;
import com.ikentop.framework.core.pojo.Assembler;
import com.ikentop.framework.core.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author tac
 * @author Huqiao
 * @since 18/09/2017
 */
@Component
public class OrgApproveEditDto2OrgApproveAssembler extends Assembler<OrgApproveEditDto, OrgApprove> {
    @Autowired
    public OrgApproveEditDto2OrgApproveAssembler(AssemblerFactory factory) {
        factory.put(this, OrgApproveEditDto.class, OrgApprove.class);
    }

    @Override
    public OrgApprove assemble(OrgApproveEditDto dto) {
        OrgApprove orgApprove = new OrgApprove();
        BeanUtils.copyProperties(dto, orgApprove);
        return orgApprove;
    }
}
