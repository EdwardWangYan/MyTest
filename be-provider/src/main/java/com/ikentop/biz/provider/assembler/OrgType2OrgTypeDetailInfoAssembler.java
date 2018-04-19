package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.OrgType;
import com.ikentop.biz.provider.model.dto.OrgTypeDetailInfo;
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
public class OrgType2OrgTypeDetailInfoAssembler extends Assembler<OrgType, OrgTypeDetailInfo> {
    @Autowired
    public OrgType2OrgTypeDetailInfoAssembler(AssemblerFactory factory) {
        factory.put(this, OrgType.class, OrgTypeDetailInfo.class);
    }

    @Override
    public OrgTypeDetailInfo assemble(OrgType orgType) {
        OrgTypeDetailInfo info = new OrgTypeDetailInfo();
        BeanUtils.copyProperties(orgType, info);
        info.setId(orgType.getPk());
        return info;
    }
}