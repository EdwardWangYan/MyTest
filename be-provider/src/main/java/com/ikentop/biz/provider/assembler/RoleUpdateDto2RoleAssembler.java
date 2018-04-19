package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.Role;
import com.ikentop.biz.provider.model.dto.RoleUpdateDto;
import com.ikentop.framework.core.factory.AssemblerFactory;
import com.ikentop.framework.core.pojo.Assembler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : Huqiao
 * @since : 2017/9/5
 */
@Component
public class RoleUpdateDto2RoleAssembler extends Assembler<RoleUpdateDto, Role> {
    @Autowired
    public RoleUpdateDto2RoleAssembler(AssemblerFactory factory) {
        factory.put(this, RoleUpdateDto.class, Role.class);
    }

    @Override
    public Role assemble(RoleUpdateDto dto) {
        Role role = new Role();
        BeanUtils.copyProperties(dto,role);
        role.setPk(dto.getId());
        return role;
    }
}
