package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.WorkOrder;
import com.ikentop.biz.provider.model.dto.WorkOrderCreateDto;
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
public class WorkOrderCreateDto2WorkOrderAssembler extends Assembler<WorkOrderCreateDto, WorkOrder> {
    @Autowired
    public WorkOrderCreateDto2WorkOrderAssembler(AssemblerFactory factory) {
        factory.put(this, WorkOrderCreateDto.class, WorkOrder.class);
    }

    @Override
    public WorkOrder assemble(WorkOrderCreateDto dto) {
        WorkOrder workOrder = new WorkOrder();
        BeanUtils.copyProperties(dto, workOrder);
        return workOrder;
    }
}
