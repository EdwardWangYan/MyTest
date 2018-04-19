package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.Organization;
import com.ikentop.biz.provider.model.dto.OrganizationDetailInfo;
import com.ikentop.framework.core.factory.AssemblerFactory;
import com.ikentop.framework.core.pojo.Assembler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : Huqiao
 * @since : 2017/10/25
 */
public class Org2OrgDetailInfoAssembler extends Assembler<Organization, OrganizationDetailInfo> {
    @Autowired
    public Org2OrgDetailInfoAssembler(AssemblerFactory factory) {
        factory.put(this, Organization.class, OrganizationDetailInfo.class);
    }

    @Override
    public OrganizationDetailInfo assemble(Organization organization) {
        OrganizationDetailInfo info = new OrganizationDetailInfo();
        BeanUtils.copyProperties(organization, info);
        info.setId(organization.getPk());
        return info;
    }
}
