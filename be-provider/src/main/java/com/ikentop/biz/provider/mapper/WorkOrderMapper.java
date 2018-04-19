package com.ikentop.biz.provider.mapper;

import com.ikentop.biz.model.entity.WorkOrder;
import com.ikentop.biz.provider.model.dto.WorkOrderListDto;
import com.ikentop.biz.provider.model.dto.WorkOrderListInfo;
import com.ikentop.framework.dao.GenericMapperSupport;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : Huqiao
 * @since : 2017/10/20
 */
@Mapper
public interface WorkOrderMapper extends GenericMapperSupport<WorkOrder> {
    List<WorkOrderListInfo> list(WorkOrderListDto dto);

    WorkOrder getWorkOrderById(@Param("id") String id,@Param("orgId") String orgId);
}
