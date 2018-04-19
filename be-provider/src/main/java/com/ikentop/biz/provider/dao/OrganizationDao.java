package com.ikentop.biz.provider.dao;

import com.ikentop.biz.model.entity.Organization;
import com.ikentop.biz.provider.mapper.OrganizationMapper;
import com.ikentop.biz.provider.model.dto.OrganizationDetailInfo;
import com.ikentop.biz.provider.model.dto.OrganizationListDto;
import com.ikentop.biz.provider.model.dto.OrganizationListInfo;
import com.ikentop.framework.dao.GenericDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : Huqiao
 * @date : 2017/9/4
 */
@Repository
public class OrganizationDao extends GenericDaoSupport<Organization, String> {
    private OrganizationMapper mapper;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public OrganizationDao(OrganizationMapper mapper) {
        super(mapper, Organization.class);
        this.mapper = mapper;
    }

    public OrganizationDetailInfo getDetails(String id) {
        return mapper.getDetails(id);
    }

    public List<OrganizationListInfo> list(OrganizationListDto dto) {
        return mapper.list(dto);
    }
}
