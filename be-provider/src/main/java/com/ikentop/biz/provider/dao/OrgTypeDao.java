package com.ikentop.biz.provider.dao;

import com.ikentop.biz.model.entity.OrgType;
import com.ikentop.biz.provider.mapper.OrgTypeMapper;
import com.ikentop.biz.provider.model.dto.OrgTypeListDto;
import com.ikentop.biz.provider.model.dto.OrgTypeListInfo;
import com.ikentop.framework.dao.GenericDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author : Huqiao
 * @since : 2017/10/24
 */
@Repository
public class OrgTypeDao extends GenericDaoSupport<OrgType, String> {
    private OrgTypeMapper mapper;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public OrgTypeDao(OrgTypeMapper mapper) {
        super(mapper, OrgType.class);
        this.mapper = mapper;
    }

    public  List<OrgTypeListInfo> getList(OrgTypeListDto dto) {
        return mapper.getList(dto);
    }


    public boolean paramterIsAlreadyExist(String property,String value) {
        Example example = new Example(OrgType.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(property,value);
        List<OrgType> list = this.selectByExample(example);
        Boolean flag = false;
        if (list.size() > 0)
            flag =true;
        return flag;
    }

    public OrgType getOrgType4CreateOrg(String orgTypeCode) {
        OrgType orgType = new OrgType();
        orgType.setCode(orgTypeCode);
        return this.selectOne(orgType);
    }
}
