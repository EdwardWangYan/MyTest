package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.WorkOrder;
import com.ikentop.biz.provider.model.dto.WorkOrderDetailInfo;
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
public class WorkOrder2WorkOrderDetailInfoAssembler extends Assembler<WorkOrder, WorkOrderDetailInfo> {
    @Autowired
    public WorkOrder2WorkOrderDetailInfoAssembler(AssemblerFactory factory) {
        factory.put(this, WorkOrder.class, WorkOrderDetailInfo.class);
    }

    @Override
    public WorkOrderDetailInfo assemble(WorkOrder o) {
        WorkOrderDetailInfo info = new WorkOrderDetailInfo();
        BeanUtils.copyProperties(o, info);
        info.setId(o.getPk());
        return info;
    }
}
