package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.provider.model.bo.OrgStaffCreateBo;
import com.ikentop.biz.provider.model.dto.OrganizationCreateDto;
import com.ikentop.framework.core.factory.AssemblerFactory;
import com.ikentop.framework.core.pojo.Assembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author tac
 * @since 18/09/2017
 */
@Component
public class OrganizationCreateDto2OrgStaffCreateBoAssembler extends Assembler<OrganizationCreateDto, OrgStaffCreateBo> {
    @Autowired
    public OrganizationCreateDto2OrgStaffCreateBoAssembler(AssemblerFactory factory) {
        factory.put(this, OrganizationCreateDto.class, OrgStaffCreateBo.class);
    }

    @Override
    public OrgStaffCreateBo assemble(OrganizationCreateDto organizationCreateDto) {
        OrgStaffCreateBo o = new OrgStaffCreateBo();
//        if (organizationCreateDto.getStaff() != null) {
//            BeanUtils.copyProperties(organizationCreateDto.getStaff(), o);
//        }
        return o;
    }
}
