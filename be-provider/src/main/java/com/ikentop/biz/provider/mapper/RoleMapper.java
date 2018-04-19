package com.ikentop.biz.provider.mapper;

import com.ikentop.biz.model.entity.Role;
import com.ikentop.biz.provider.model.dto.Role4OperatorInfo;
import com.ikentop.biz.provider.model.dto.RoleDetailInfo;
import com.ikentop.biz.provider.model.dto.RoleListDto;
import com.ikentop.framework.dao.GenericMapperSupport;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author : Huqiao
 * @date : 2017/9/4
 */
@Mapper
public interface RoleMapper extends GenericMapperSupport<Role> {
    List<RoleDetailInfo> list4Admin(RoleListDto dto);

    List<Role4OperatorInfo> list4operator(String id);

    RoleDetailInfo getDetail(String id, String orgId);

    List<String> getRoleNames(String id);
}
