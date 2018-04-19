package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.Role;
import com.ikentop.biz.provider.model.dto.RoleDetailInfo;
import com.ikentop.framework.core.factory.AssemblerFactory;
import com.ikentop.framework.core.pojo.Assembler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author tac
 * @since 2017/9/15
 */
@Component
public class Role2RoleInfoAssembler extends Assembler<Role, RoleDetailInfo> {
    @Autowired
    public Role2RoleInfoAssembler(AssemblerFactory factory) {
        factory.put(this, Role.class, RoleDetailInfo.class);
    }

    @Override
    public RoleDetailInfo assemble(Role role) {
        RoleDetailInfo o = new RoleDetailInfo();
        BeanUtils.copyProperties(role, o);
        o.setId(role.getPk());
        return o;
    }
}
