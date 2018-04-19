package com.ikentop.biz.provider.dao;

import com.ikentop.biz.model.entity.Dictionary;
import com.ikentop.biz.provider.mapper.DictionaryMapper;
import com.ikentop.biz.provider.model.dto.DictionaryInfo;
import com.ikentop.framework.dao.GenericDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author : Huqiao
 * @date : 2017/9/4
 */
@Repository
public class DictionaryDao extends GenericDaoSupport<Dictionary, String> {
    private DictionaryMapper mapper;
    @Autowired
    public DictionaryDao(DictionaryMapper mapper) {
        super(mapper, Dictionary.class);
        this.mapper =mapper;
    }

    public DictionaryInfo getDetail(String id) {
        return mapper.getDetail(id);
    }
}
