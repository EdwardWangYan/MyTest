package com.ikentop.biz.provider.mapper;

import com.ikentop.biz.model.entity.Organization;
import com.ikentop.biz.provider.model.dto.OrganizationDetailInfo;
import com.ikentop.biz.provider.model.dto.OrganizationListDto;
import com.ikentop.biz.provider.model.dto.OrganizationListInfo;
import com.ikentop.framework.dao.GenericMapperSupport;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author : Huqiao
 * @date : 2017/9/4
 */
@Mapper
public interface OrganizationMapper extends GenericMapperSupport<Organization> {
    OrganizationDetailInfo getDetails(String id);

    List<OrganizationListInfo> list(OrganizationListDto dto);
}
