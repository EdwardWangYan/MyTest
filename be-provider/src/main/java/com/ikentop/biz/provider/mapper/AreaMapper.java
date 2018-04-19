package com.ikentop.biz.provider.mapper;

import com.ikentop.biz.model.entity.Area;
import com.ikentop.biz.provider.model.dto.Area4ListInfo;
import com.ikentop.biz.provider.model.dto.AreaDetailInfo;
import com.ikentop.biz.provider.model.dto.SearchForAreaDto;
import com.ikentop.framework.dao.GenericMapperSupport;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : Huqiao
 * @since : 2017/10/20
 */
@Mapper
public interface AreaMapper extends GenericMapperSupport<Area> {
    AreaDetailInfo getDetail(String id);

    List<Area> listCityByInitials(List<String> initials);

    List<Area4ListInfo> listChildrenAreaByCondition(SearchForAreaDto searchForAreaDto);
}
