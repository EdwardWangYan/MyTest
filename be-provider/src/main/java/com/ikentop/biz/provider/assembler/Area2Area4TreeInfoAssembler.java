package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.Area;
import com.ikentop.biz.provider.model.dto.Area4TreeInfo;
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
public class Area2Area4TreeInfoAssembler extends Assembler<Area, Area4TreeInfo> {
    @Autowired
    public Area2Area4TreeInfoAssembler(AssemblerFactory factory) {
        factory.put(this, Area.class, Area4TreeInfo.class);
    }

    @Override
    public Area4TreeInfo assemble(Area area) {
        Area4TreeInfo info = new Area4TreeInfo();
        BeanUtils.copyProperties(area, info);
        info.setId(area.getPk());
        info.setTitle(area.getAreaName());
        return info;
    }
}
