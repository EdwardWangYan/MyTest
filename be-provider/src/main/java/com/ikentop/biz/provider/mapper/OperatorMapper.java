package com.ikentop.biz.provider.mapper;

import com.ikentop.biz.model.entity.Operator;
import com.ikentop.biz.provider.model.dto.OperatorDetailInfo;
import com.ikentop.biz.provider.model.dto.OperatorListDto;
import com.ikentop.biz.provider.model.dto.OperatorListInfo;
import com.ikentop.framework.dao.GenericMapperSupport;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author : tac
 * @since : 2017/9/4
 */
@Mapper
public interface OperatorMapper extends GenericMapperSupport<Operator> {
    List<OperatorListInfo> list(OperatorListDto dto);

    Operator selectByPhone(String phone);

    OperatorDetailInfo getDetail(String id);
}
