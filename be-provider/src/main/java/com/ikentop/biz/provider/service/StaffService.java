package com.ikentop.biz.provider.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ikentop.biz.model.entity.Staff;
import com.ikentop.biz.provider.dao.StaffDao;
import com.ikentop.biz.provider.exception.StaffMobileIsAlreadyExistException;
import com.ikentop.biz.provider.exception.StaffNotExistException;
import com.ikentop.biz.provider.model.dto.*;
import com.ikentop.framework.core.pojo.DataTableResponse;
import com.ikentop.framework.core.spring.bean.BizDataInterface;
import com.ikentop.framework.service.GenericServiceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * @author Huqiao
 * @author tac
 * @since 2017/9/6
 */
@Service
@Transactional
public class StaffService extends GenericServiceSupport<StaffDao> {
    @Autowired
    private BizDataInterface bizDataInterface;
    @Autowired
    private DepartmentStaffService departmentStaffService;

    @Autowired
    public StaffService(StaffDao staffDao) {
        super(staffDao);
    }

    /**
     * 创建员工
     */
    public String createStaff(StaffCreateDto dto) {
        verifyStaffMobile(dto.getMobile());
        Staff staff = assemble(dto, Staff.class);
        getDao().insert(staff);
        departmentStaffService.relateDepatStaff(staff.getPk(), dto.getDepartmentInfo());
        return staff.getPk();
    }

    /**
     * 修改员工
     */
    public Integer update(StaffUpdateDto dto) {
        verifyStaffIsExist(dto.getId());
        Staff staff = assemble(dto, Staff.class);
        int num = getDao().updateByPrimaryKeySelective(staff);
        departmentStaffService.relateDepatStaff(staff.getPk(), dto.getDepartmentInfo());
        return num;
    }

    /**
     * 修改个人信息时,修改员工信息
     */
    public Integer update4Operator(CurrentOperatorUpdateDto dto) {
        Staff o = verifyStaffIsExist(dto.getId());
        if (!Objects.equals(o.getMobile(), dto.getMobile()))
            verifyStaffMobile(dto.getMobile());
        Staff staff = assemble(dto, Staff.class);
        return getDao().updateByPrimaryKeySelective(staff);
    }


    public StaffDetailInfo getDetail(String id) {
        return getDao().getDetail(id, bizDataInterface.currentOrgId());
    }

    public DataTableResponse<StaffListInfo> list4Admin(StaffListDto dto) {
        PageHelper.startPage(dto.getIndex(), dto.getSize());
        dto.setOrgId(bizDataInterface.currentOrgId());
        List<StaffListInfo> ls = getDao().list4Admin(dto);
        return DataTableResponse.fromPageInfo(new PageInfo<>(ls));
    }


    boolean isCurrentOrg(Staff staff) {
        if (staff == null) {
            return false;
        }
        return staff.getOrgId().equals(bizDataInterface.currentOrgId());
    }

    protected String createStaff4Org(Staff staff) {
        getDao().insert(staff);
        return staff.getPk();
    }

    private Staff verifyStaffIsExist(String id) {
        Staff staff = getDao().selectByPrimaryKey(id);
        if (null == staff)
            throw new StaffNotExistException();
        return staff;
    }

    private void verifyStaffMobile(String mobile) {
        Staff staff = new Staff();
        staff.setMobile(mobile);
        if (getDao().selectCount(staff, false) > 0)
            throw new StaffMobileIsAlreadyExistException();
    }

    public String verifyMobile(String mobile) {
        Staff staff = new Staff();
        staff.setMobile(mobile);
        Boolean flag = getDao().selectCount(staff, false) > 0;
        return flag.toString();
    }
}
