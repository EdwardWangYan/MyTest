package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.Role;
import com.ikentop.biz.provider.model.dto.RoleCreateDto;
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
public class RoleCreateDto2RoleAssembler extends Assembler<RoleCreateDto, Role> {
    @Autowired
    public RoleCreateDto2RoleAssembler(AssemblerFactory factory) {
        factory.put(this, RoleCreateDto.class, Role.class);
    }

    @Override
    public Role assemble(RoleCreateDto roleCreateDto) {
        Role o = new Role();
        BeanUtils.copyProperties(roleCreateDto, o);
        return o;
    }
}
