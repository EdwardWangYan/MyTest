package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.Resource;
import com.ikentop.biz.provider.model.dto.ResourceCreateDto;
import com.ikentop.framework.core.factory.AssemblerFactory;
import com.ikentop.framework.core.pojo.Assembler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : tac
 * @since : 14/09/2017
 */
@Component
public class ResourceCreateDto2ResourceAssembler extends Assembler<ResourceCreateDto, Resource> {
    @Autowired
    public ResourceCreateDto2ResourceAssembler(AssemblerFactory factory) {
        factory.put(this, ResourceCreateDto.class, Resource.class);
    }

    @Override
    public Resource assemble(ResourceCreateDto resourceCreateDto) {
        Resource o = new Resource();
        BeanUtils.copyProperties(resourceCreateDto, o);
        return o;
    }
}
