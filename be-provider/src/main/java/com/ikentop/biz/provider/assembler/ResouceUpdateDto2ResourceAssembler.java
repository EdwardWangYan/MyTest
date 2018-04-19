package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.Resource;
import com.ikentop.biz.provider.model.dto.ResourceUpdateDto;
import com.ikentop.framework.core.factory.AssemblerFactory;
import com.ikentop.framework.core.pojo.Assembler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : Huqiao
 * @since : 2017/11/1
 */
@Component
public class ResouceUpdateDto2ResourceAssembler extends Assembler<ResourceUpdateDto, Resource> {

    @Autowired
    public ResouceUpdateDto2ResourceAssembler(AssemblerFactory factory) {
        factory.put(this, ResourceUpdateDto.class, Resource.class);
    }

    @Override
    public Resource assemble(ResourceUpdateDto resourceUpdateDto) {
        Resource resource =new Resource();
        BeanUtils.copyProperties(resourceUpdateDto,resource);
        resource.setPk(resourceUpdateDto.getId());
        return resource;
    }
}
