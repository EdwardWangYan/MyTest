package com.ikentop.biz.provider.service;

import com.ikentop.biz.model.entity.OperatorStaff;
import com.ikentop.biz.provider.dao.OperatorStaffDao;
import com.ikentop.biz.provider.exception.StaffAlreadyHaveOperatorException;
import com.ikentop.framework.service.GenericServiceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : Huqiao
 * @since : 2017/10/22
 */
@Service
@Transactional
public class OperatorStaffService extends GenericServiceSupport<OperatorStaffDao> {
    @Autowired
    public OperatorStaffService(OperatorStaffDao operatorStaffDao) {
        super(operatorStaffDao);
    }

    String getStaffId(String pk) {
        OperatorStaff operatorStaff = getDao().getStaffId(pk);
        String id = null;
        if (null != operatorStaff)
            id = operatorStaff.getStaffId();
        return id;
    }

    /**
     * 关联员工与账号
     */
    public void relateOperatorStaff(String pk, String staffId) {
        verifyStaffAlreadyHaveOperator(staffId);
        OperatorStaff operatorStaff = new OperatorStaff();
        operatorStaff.setOperatorId(pk);
        operatorStaff.setStaffId(staffId);
        getDao().insert(operatorStaff);
    }

    void verifyStaffAlreadyHaveOperator(String staffId) {
        OperatorStaff operatorStaff = new OperatorStaff();
        operatorStaff.setStaffId(staffId);
        if (getDao().selectCount(operatorStaff) > 0)
            throw new StaffAlreadyHaveOperatorException();
    }
}
