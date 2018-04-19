package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.Area;
import com.ikentop.biz.provider.model.dto.AreaUpdateDto;
import com.ikentop.framework.core.factory.AssemblerFactory;
import com.ikentop.framework.core.pojo.Assembler;
import com.ikentop.framework.core.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : Huqiao
 * @since : 2017/10/23
 */
@Component
public class AreaUpdateDto2AreaAssembler extends Assembler<AreaUpdateDto, Area> {
    @Autowired
    public AreaUpdateDto2AreaAssembler(AssemblerFactory factory) {
        factory.put(this, AreaUpdateDto.class, Area.class);
    }

    @Override
    public Area assemble(AreaUpdateDto dto) {
        Area area = new Area();
        BeanUtils.copyProperties(dto, area);
        area.setPk(dto.getId());
        return area;
    }
}
