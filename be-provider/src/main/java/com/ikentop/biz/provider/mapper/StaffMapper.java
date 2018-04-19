package com.ikentop.biz.provider.mapper;

import com.ikentop.biz.model.entity.Staff;
import com.ikentop.biz.provider.model.dto.StaffDetailInfo;
import com.ikentop.biz.provider.model.dto.StaffListDto;
import com.ikentop.biz.provider.model.dto.StaffListInfo;
import com.ikentop.framework.dao.GenericMapperSupport;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author : tac
 * @since : 13/09/2017
 */

@Mapper
public interface StaffMapper extends GenericMapperSupport<Staff> {
    List<StaffListInfo> list4Admin(StaffListDto dto);

    StaffDetailInfo getDetail(String id, String orgId);
}
