package com.ikentop.biz.provider.mapper;

import com.ikentop.biz.model.entity.RoleResource;
import com.ikentop.biz.provider.model.dto.AreaDetailInfo;
import com.ikentop.framework.dao.GenericMapperSupport;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : Huqiao
 * @since : 2017/10/20
 */
@Mapper
public interface RoleResourceMapper extends GenericMapperSupport<RoleResource> {
    AreaDetailInfo getDetail(String id);
}
