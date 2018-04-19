package com.ikentop.biz.provider.mapper;

import com.ikentop.biz.model.entity.OrgApprove;
import com.ikentop.biz.provider.model.dto.OrgApproveDetailInfo;
import com.ikentop.framework.dao.GenericMapperSupport;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : Huqiao
 * @since : 2017/10/20
 */
@Mapper
public interface OrgApproveMapper extends GenericMapperSupport<OrgApprove> {
    OrgApproveDetailInfo getDetail(String id);
}
