package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.OrgApprove;
import com.ikentop.biz.provider.model.dto.OrgApproveDetailInfo;
import com.ikentop.framework.core.factory.AssemblerFactory;
import com.ikentop.framework.core.pojo.Assembler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : Huqiao
 * @since : 2017/10/25
 */
@Component
public class OrgApprove2OrgApproveDetailInfoAssembler extends Assembler<OrgApprove, OrgApproveDetailInfo> {
    @Autowired
    public OrgApprove2OrgApproveDetailInfoAssembler(AssemblerFactory factory) {
        factory.put(this, OrgApprove.class, OrgApproveDetailInfo.class);
    }

    @Override
    public OrgApproveDetailInfo assemble(OrgApprove orgApprove) {
        OrgApproveDetailInfo info = new OrgApproveDetailInfo();
        BeanUtils.copyProperties(orgApprove, info);
        info.setId(orgApprove.getPk());
        return info;
    }
}
