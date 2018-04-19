package com.ikentop.biz.provider.dao;

import com.ikentop.biz.constant.WorkOrderType;
import com.ikentop.biz.model.entity.WorkOrder;
import com.ikentop.biz.provider.mapper.WorkOrderMapper;
import com.ikentop.biz.provider.model.dto.WorkOrderListDto;
import com.ikentop.biz.provider.model.dto.WorkOrderListInfo;
import com.ikentop.framework.dao.GenericDaoSupport;
import com.ikentop.framework.dao.exception.InsertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : Huqiao
 * @since : 2017/10/20
 */
@Repository
public class WorkOrderDao extends GenericDaoSupport<WorkOrder, String> {

    private WorkOrderMapper mapper;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public WorkOrderDao(WorkOrderMapper mapper) {
        super(mapper, WorkOrder.class);
        this.mapper = mapper;
    }

    public int insertWithoutInit(WorkOrder entity) {
        try {
            return mapper.insert(entity);
        } catch (Exception e) {
            InsertException bizEx = new InsertException();
            throw bizEx;
        }
    }

    public List<WorkOrderListInfo> list(WorkOrderListDto dto) {
        dto.setTypeLimit(WorkOrderType.EVENT_CHECK.val);
        return mapper.list(dto);
    }

    public WorkOrder getWorkOrderById(String id) {
        return getWorkOrderById(id, null);
    }

    public WorkOrder getWorkOrderById(String id, String orgId) {
        return mapper.getWorkOrderById(id,orgId);
    }
}
