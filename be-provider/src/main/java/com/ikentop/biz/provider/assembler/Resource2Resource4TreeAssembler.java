package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.Resource;
import com.ikentop.biz.provider.model.dto.Resource4Tree;
import com.ikentop.framework.core.factory.AssemblerFactory;
import com.ikentop.framework.core.pojo.Assembler;
import com.ikentop.framework.core.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author tac
 * @since 18/09/2017
 */
@Component
public class Resource2Resource4TreeAssembler extends Assembler<Resource, Resource4Tree> {
    @Autowired
    public Resource2Resource4TreeAssembler(AssemblerFactory factory) {
        factory.put(this, Resource.class, Resource4Tree.class);
    }

    @Override
    public Resource4Tree assemble(Resource resource) {
       Resource4Tree resource4Tree = new Resource4Tree();
       BeanUtils.copyProperties(resource,resource4Tree);
       resource4Tree.setId(resource.getPk());
       resource4Tree.setTitle(resource.getResourceTitle());
       resource4Tree.setIcon(resource.getResourceIcon());
       return resource4Tree;
    }
}
