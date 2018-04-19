package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.OrgApprove;
import com.ikentop.biz.provider.model.dto.OrgApproveCreateDto;
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
public class OrgApproveCreateDto2OrgApproveAssembler extends Assembler<OrgApproveCreateDto, OrgApprove> {
    @Autowired
    public OrgApproveCreateDto2OrgApproveAssembler(AssemblerFactory factory) {
        factory.put(this, OrgApproveCreateDto.class, OrgApprove.class);
    }

    @Override
    public OrgApprove assemble(OrgApproveCreateDto organizationCreateDto) {
        OrgApprove orgApprove = new OrgApprove();
        BeanUtils.copyProperties(organizationCreateDto, orgApprove);
        return orgApprove;
    }
}
