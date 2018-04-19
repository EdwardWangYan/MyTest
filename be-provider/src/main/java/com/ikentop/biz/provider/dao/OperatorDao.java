package com.ikentop.biz.provider.dao;

import com.ikentop.biz.model.entity.Operator;
import com.ikentop.biz.provider.mapper.OperatorMapper;
import com.ikentop.biz.provider.model.bo.ListByPageBo;
import com.ikentop.biz.provider.model.dto.AccountInfo;
import com.ikentop.biz.provider.model.dto.OperatorDetailInfo;
import com.ikentop.biz.provider.model.dto.OperatorListDto;
import com.ikentop.biz.provider.model.dto.OperatorListInfo;
import com.ikentop.framework.dao.GenericDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

/**
 * @author : tac
 * @author Huqiao
 * @since : 2017/9/4
 */

@Repository
public class OperatorDao extends GenericDaoSupport<Operator, String> {
    private OperatorMapper mapper;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public OperatorDao(OperatorMapper mapper) {
        super(mapper, Operator.class);
        this.mapper = mapper;
    }

    public Operator selectByUsername(String username) {
        Operator operator = new Operator();
        operator.setLoginName(username);
        return selectOne(operator,false);
    }

    public Operator selectByPhone(String phone) {
        return mapper.selectByPhone(phone);
    }

    public List<AccountInfo> listByPage(ListByPageBo bo) {
        //todo::
        throw new NotImplementedException();
    }

    public List<OperatorListInfo> list(OperatorListDto dto) {
        return mapper.list(dto);
    }

    public OperatorDetailInfo getDetail(String id) {
        return mapper.getDetail(id);
    }
}
