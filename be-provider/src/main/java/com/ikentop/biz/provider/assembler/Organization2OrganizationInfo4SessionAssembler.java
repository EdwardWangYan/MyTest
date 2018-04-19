package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.Organization;
import com.ikentop.biz.provider.model.bo.OrganizationInfo4Session;
import com.ikentop.framework.core.factory.AssemblerFactory;
import com.ikentop.framework.core.pojo.Assembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : Huqiao
 * @since : 2017/10/25
 */
@Component
public class Organization2OrganizationInfo4SessionAssembler extends Assembler<Organization, OrganizationInfo4Session> {
    @Autowired
    public Organization2OrganizationInfo4SessionAssembler(AssemblerFactory factory) {
        factory.put(this, Organization.class, OrganizationInfo4Session.class);
    }

    @Override
    public OrganizationInfo4Session assemble(Organization organization) {
        OrganizationInfo4Session info4Session = new OrganizationInfo4Session();
        info4Session.setId(organization.getPk());
        info4Session.setCode(organization.getCode());
        info4Session.setName(organization.getTitle());
        info4Session.setEnableFlag(organization.getDeletedFlag());
        info4Session.setType(organization.getOrgTypeCode());
        return info4Session;
    }
}
