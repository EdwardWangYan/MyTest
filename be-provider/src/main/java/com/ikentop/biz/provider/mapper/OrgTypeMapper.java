package com.ikentop.biz.provider.mapper;

import com.ikentop.biz.model.entity.OrgType;
import com.ikentop.biz.provider.model.dto.OrgTypeListDto;
import com.ikentop.biz.provider.model.dto.OrgTypeListInfo;
import com.ikentop.framework.dao.GenericMapperSupport;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author : Huqiao
 * @since : 2017/10/24
 */
@Mapper
public interface OrgTypeMapper extends GenericMapperSupport<OrgType> {
    List<OrgTypeListInfo> getList(OrgTypeListDto dto);
}
