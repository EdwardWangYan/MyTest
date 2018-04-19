package com.ikentop.biz.provider.mapper;

import com.ikentop.biz.model.entity.Resource;
import com.ikentop.biz.provider.model.dto.*;
import com.ikentop.framework.dao.GenericMapperSupport;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Huqiao
 * @author tac
 * @since 2017/9/4
 */
@Mapper
public interface ResourceMapper extends GenericMapperSupport<Resource> {
    List<ResourceListInfo> listNextLevel(ResourceListDto dto);

    List<Resource4ParentInfo> list4parent(ResourceList4ParentDto dto);

    ResourceListInfo getDetail(String id);

    List<Resource4RoleInfo> list4Role(String operatorId, String id, String orgType);

    List<Resource4RoleInfo> list4CurrentOperator(String id, String orgType);

    List<Resource4RoleInfo> list4CurrentAdmin();

    List<Resource> list4AdminRole(@Param("orgTypeCode") String orgTypeCode);
}
