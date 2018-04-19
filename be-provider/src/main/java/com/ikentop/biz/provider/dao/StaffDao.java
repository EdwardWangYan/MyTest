package com.ikentop.biz.provider.dao;

import com.ikentop.biz.model.entity.Staff;
import com.ikentop.biz.provider.mapper.StaffMapper;
import com.ikentop.biz.provider.model.dto.StaffDetailInfo;
import com.ikentop.biz.provider.model.dto.StaffListDto;
import com.ikentop.biz.provider.model.dto.StaffListInfo;
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
public class StaffDao extends GenericDaoSupport<Staff, String> {
    private StaffMapper mapper;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public StaffDao(StaffMapper mapper) {
        super(mapper, Staff.class);
        this.mapper = mapper;
    }

    public List<StaffListInfo> list4Admin(StaffListDto dto) {
        return mapper.list4Admin(dto);
    }

    public StaffDetailInfo getDetail(String id, String orgId) {
        return mapper.getDetail(id, orgId);
    }
}
