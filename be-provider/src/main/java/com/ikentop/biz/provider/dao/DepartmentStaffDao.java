package com.ikentop.biz.provider.dao;

import com.ikentop.biz.model.entity.DepartmentStaff;
import com.ikentop.biz.provider.mapper.DepartmentStaffMapper;
import com.ikentop.framework.dao.GenericDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author : Huqiao
 * @since : 2017/10/20
 */
@Repository
public class DepartmentStaffDao extends GenericDaoSupport<DepartmentStaff, String> {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public DepartmentStaffDao(DepartmentStaffMapper mapper) {
        super(mapper, DepartmentStaff.class);
    }
}
