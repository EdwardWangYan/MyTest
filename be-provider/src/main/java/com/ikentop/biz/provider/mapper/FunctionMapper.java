package com.ikentop.biz.provider.mapper;

import com.ikentop.biz.model.entity.Function;
import com.ikentop.biz.provider.model.dto.Function4RoleInfo;
import com.ikentop.biz.provider.model.dto.FunctionDetailInfo;
import com.ikentop.framework.dao.GenericMapperSupport;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : Huqiao
 * @since : 2017/10/22
 */
@Mapper
public interface FunctionMapper extends GenericMapperSupport<Function> {
    List<Function4RoleInfo> list4Role(String id, String orgType);

    List<String> getFunctionValues(String id);

    FunctionDetailInfo getDetail(String id);

    List<Function> list4CreateOrg(@Param("orgTypeCode") String orgTypeCode);
}
