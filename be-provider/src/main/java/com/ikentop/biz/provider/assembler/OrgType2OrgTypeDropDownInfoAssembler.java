package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.OrgType;
import com.ikentop.biz.provider.model.dto.OrgTypeDropDownInfo;
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
public class OrgType2OrgTypeDropDownInfoAssembler extends Assembler<OrgType, OrgTypeDropDownInfo> {
    @Autowired
    public OrgType2OrgTypeDropDownInfoAssembler(AssemblerFactory factory) {
        factory.put(this, OrgType.class, OrgTypeDropDownInfo.class);
    }

    @Override
    public OrgTypeDropDownInfo assemble(OrgType orgType) {
        OrgTypeDropDownInfo info = new OrgTypeDropDownInfo();
        BeanUtils.copyProperties(orgType, info);
        info.setId(orgType.getPk());
        return info;
    }
}
