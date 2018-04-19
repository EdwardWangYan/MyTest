package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.Area;
import com.ikentop.biz.provider.model.dto.Area4ListInfo;
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
public class Area2Area4ListInfoAssembler extends Assembler<Area, Area4ListInfo> {
    @Autowired
    public Area2Area4ListInfoAssembler(AssemblerFactory factory) {
        factory.put(this, Area.class, Area4ListInfo.class);
    }

    @Override
    public Area4ListInfo assemble(Area area) {
        Area4ListInfo info = new Area4ListInfo();
        BeanUtils.copyProperties(area, info);
        info.setId(area.getPk());
        return info;
    }
}
