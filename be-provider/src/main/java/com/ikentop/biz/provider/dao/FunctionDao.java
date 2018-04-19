package com.ikentop.biz.provider.dao;

import com.ikentop.biz.model.entity.Function;
import com.ikentop.biz.provider.mapper.FunctionMapper;
import com.ikentop.biz.provider.model.dto.Function4RoleInfo;
import com.ikentop.biz.provider.model.dto.FunctionDetailInfo;
import com.ikentop.framework.dao.GenericDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author : Huqiao
 * @since : 2017/10/22
 */
@Repository
public class FunctionDao extends GenericDaoSupport<Function, String> {
    private FunctionMapper mapper;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public FunctionDao(FunctionMapper mapper) {
        super(mapper, Function.class);
        this.mapper = mapper;
    }

    public List<Function> list4tree(String orgType, Boolean flag) {
        Example example = new Example(Function.class);
        if (flag) {
            example.or().andEqualTo("orgType", "common");
            example.or().andEqualTo("orgType", orgType);
        }
        Example.Criteria criteria = example.createCriteria();
        criteria.andNotEqualTo("orgType", "specific");
        return this.selectByExample(example);
    }


    public List<Function4RoleInfo> list4Role(String id, String orgType) {
        return mapper.list4Role(id, orgType);
    }

    public Boolean getFunctionByValue(String permissionValue) {
        Function function = new Function();
        function.setPermissionValue(permissionValue);
        return this.selectCount(function) > 0;
    }

    public Set<String> getFunctionValues(String id) {

        List<String> functionValues = mapper.getFunctionValues(id);
        return new HashSet<>(functionValues);
    }

    public List<Function> list4CreateOrg(String orgTypeCode) {

        return mapper.list4CreateOrg(orgTypeCode);
    }

    public FunctionDetailInfo getDetail(String id) {
        return mapper.getDetail(id);
    }
}
