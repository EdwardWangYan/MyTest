package com.ikentop.biz.provider.dao;

import com.ikentop.biz.model.entity.OrgApprove;
import com.ikentop.biz.provider.mapper.OrgApproveMapper;
import com.ikentop.biz.provider.model.dto.OrgApproveDetailInfo;
import com.ikentop.framework.dao.GenericDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author : Huqiao
 * @date : 2017/9/4
 */
@Repository
public class OrgApproveDao extends GenericDaoSupport<OrgApprove, String> {

    private OrgApproveMapper mapper;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public OrgApproveDao(OrgApproveMapper mapper) {
        super(mapper, OrgApprove.class);
        this.mapper = mapper;
    }

    public OrgApproveDetailInfo getDetail(String id) {
        return mapper.getDetail(id);
    }

    public OrgApprove getOrgApproveByOrgId(String orgId) {

        Example example = new Example(OrgApprove.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("orgId", orgId);
        List<OrgApprove> orgApproves = this.selectByExample(example);
        if (null == orgApproves || orgApproves.size() == 0)
            return null;
        return orgApproves.get(0);
    }
}
