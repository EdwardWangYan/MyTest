package com.ikentop.biz.provider.dao;

import com.ikentop.biz.model.entity.Department;
import com.ikentop.biz.provider.mapper.DepartmentMapper;
import com.ikentop.biz.provider.model.dto.DepartmentDetailInfo;
import com.ikentop.framework.dao.GenericDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Huqiao
 * @author tac
 * @since 2017/9/4
 */
@Repository
public class DepartmentDao extends GenericDaoSupport<Department, String> {
    private DepartmentMapper mapper;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public DepartmentDao(DepartmentMapper mapper) {
        super(mapper, Department.class);
        this.mapper = mapper;
    }

//    public List<DepartmentInfo> list4Admin(DepartmentListDto dto) {
//        return mapper.list4Admin(dto);
//
//    }

    public List<Department> list() {
        return this.selectAll();
    }

    public DepartmentDetailInfo getDetail(String id, String orgId) {
        return mapper.getDetail(id, orgId);
    }
}
