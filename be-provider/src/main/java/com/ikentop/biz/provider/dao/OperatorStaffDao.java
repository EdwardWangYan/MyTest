package com.ikentop.biz.provider.dao;

import com.ikentop.biz.model.entity.OperatorStaff;
import com.ikentop.biz.provider.mapper.OperatorStaffMapper;
import com.ikentop.framework.dao.GenericDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author : Huqiao
 * @since : 2017/10/22
 */
@Repository
public class OperatorStaffDao extends GenericDaoSupport<OperatorStaff, String> {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public OperatorStaffDao(OperatorStaffMapper mapper) {
        super(mapper, OperatorStaff.class);
    }

    public OperatorStaff getStaffId(String pk) {
        OperatorStaff o = new OperatorStaff();
        o.setOperatorId(pk);
        return selectOne(o);
    }
}
