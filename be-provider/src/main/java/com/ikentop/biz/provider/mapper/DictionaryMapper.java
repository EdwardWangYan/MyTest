package com.ikentop.biz.provider.mapper;

import com.ikentop.biz.model.entity.Dictionary;
import com.ikentop.biz.provider.model.dto.DictionaryInfo;
import com.ikentop.framework.dao.GenericMapperSupport;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : Huqiao
 * @date : 2017/9/4
 */
@Mapper
public interface DictionaryMapper extends GenericMapperSupport<Dictionary> {
    DictionaryInfo getDetail(String id);
}
