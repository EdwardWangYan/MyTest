package com.ikentop.biz.provider.dao;

import com.ikentop.biz.model.entity.VerificationCode;
import com.ikentop.biz.provider.mapper.VerificationCodeMapper;
import com.ikentop.biz.util.CommonUtils;
import com.ikentop.framework.dao.GenericDaoSupport;
import com.ikentop.framework.dao.exception.UpdateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @author Huqiao
 * @since 2017/12/12
 */
@Repository
public class VerificationCodeDao extends GenericDaoSupport<VerificationCode, String> {

    private VerificationCodeMapper mapper;

    @Autowired
    public VerificationCodeDao(VerificationCodeMapper mapper) {
        super(mapper, VerificationCode.class);
        this.mapper = mapper;
    }

    public Integer update(VerificationCode code) {
        try {
            if (code.getPk() == null) {
                throw new IllegalArgumentException("id不能为空");
            }
            code.setUpdatedBy(CommonUtils.nullUUID());
            code.setUpdatedOn(new Date());
            return mapper.updateByPrimaryKeySelective(code);
        } catch (Exception e) {
            UpdateException bizEx = new UpdateException();
            throw bizEx;
        }
    }
}
