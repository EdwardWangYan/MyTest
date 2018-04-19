package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.OrgType;
import com.ikentop.biz.provider.model.dto.OrgTypeListInfo;
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
public class OrgType2OrgTypeListInfoAssembler extends Assembler<OrgType, OrgTypeListInfo> {
    @Autowired
    public OrgType2OrgTypeListInfoAssembler(AssemblerFactory factory) {
        factory.put(this, OrgType.class, OrgTypeListInfo.class);
    }

    @Override
    public OrgTypeListInfo assemble(OrgType orgType) {
        OrgTypeListInfo listInfo = new OrgTypeListInfo();
        BeanUtils.copyProperties(orgType,listInfo);
        listInfo.setId(orgType.getPk());
        return listInfo;
    }
}
