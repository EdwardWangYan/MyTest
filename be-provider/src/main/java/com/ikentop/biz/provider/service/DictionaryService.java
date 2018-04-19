package com.ikentop.biz.provider.service;

import com.ikentop.biz.model.entity.Dictionary;
import com.ikentop.biz.provider.dao.DictionaryDao;
import com.ikentop.biz.provider.exception.DictionaryCodeIsAlreadyExistException;
import com.ikentop.biz.provider.exception.DictionaryCodeIsWrongException;
import com.ikentop.biz.provider.exception.DictionaryIsChildException;
import com.ikentop.biz.provider.exception.DictionaryIsNotExistException;
import com.ikentop.biz.provider.model.dto.DictionaryCreateDto;
import com.ikentop.biz.provider.model.dto.DictionaryInfo;
import com.ikentop.biz.provider.model.dto.DictionaryListInfo;
import com.ikentop.biz.provider.model.dto.DictionaryUpdateDto;
import com.ikentop.framework.service.GenericServiceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * @author : Huqiao
 * @since : 2017/10/26
 */
@Service
@Transactional
public class DictionaryService extends GenericServiceSupport<DictionaryDao> {
    @Autowired
    public DictionaryService(DictionaryDao dictionaryDao) {
        super(dictionaryDao);
    }

    /**
     * 新增数据字典
     */
    public String create(DictionaryCreateDto dto) {
        verifyDictionaryCanCreate(dto.getParentId());
        verifyDictionaryCode(dto.getCode());
        Dictionary dictionary = assemble(dto, Dictionary.class);
        getDao().insert(dictionary);
        return dictionary.getPk();
    }

    private void verifyDictionaryCode(String code) {
        Dictionary dictionary = new Dictionary();
        dictionary.setCode(code);
        if (getDao().selectCount(dictionary) > 0)
            throw new DictionaryCodeIsAlreadyExistException();
    }

    public Integer update(DictionaryUpdateDto dto) {
        verifyDictionaryIsExist(dto.getId());
        Dictionary dictionary = assemble(dto, Dictionary.class);
        return getDao().updateByPrimaryKeySelective(dictionary);
    }


    public List<DictionaryListInfo> listByParentCode(String code) {
        Dictionary dictionary = new Dictionary();
        dictionary.setCode(code);
        Dictionary selectOne = getDao().selectOne(dictionary);
        if (null == selectOne || null != selectOne.getParentId())
            throw new DictionaryCodeIsWrongException();
        dictionary.setCode(null);
        dictionary.setParentId(selectOne.getPk());
        List<Dictionary> list = getDao().select(dictionary);
        return assemble(list, DictionaryListInfo.class);
    }

    /**
     * 获取数据字典列表
     */
    public List<DictionaryListInfo> list() {
        List<Dictionary> list = getDao().selectAll();
        return assemble(list, DictionaryListInfo.class);
    }


    public HashMap<String, List<DictionaryListInfo>> listByParentCodes(List<String> codes) {
        HashMap<String, List<DictionaryListInfo>> map = new HashMap<>();
        if (null == codes || codes.size() == 0)
            return map;
        for (String code : codes) {
            List<DictionaryListInfo> list = listByParentCode(code);
            map.put(code, list);
        }
        return map;
    }

    public Integer delete(String id) {
        int num = 0;
        Dictionary dictionary = verifyDictionaryIsExist(id);
        num += getDao().deleteByPrimaryKey(id);
        if (null == dictionary.getParentId()) {
            Dictionary o = new Dictionary();
            o.setParentId(dictionary.getPk());
            List<Dictionary> list = getDao().select(o);
            for (Dictionary d : list) {
                num += getDao().deleteByPrimaryKey(d.getPk());
            }
        }
        return num;
    }

    public DictionaryInfo getDetail(String id) {
        return getDao().getDetail(id);
    }

    protected void verifyDictionaryCanCreate(String parentId) {
        if (null != parentId) {
            Dictionary dictionary = getDao().selectByPrimaryKey(parentId);
            if (null == dictionary)
                throw new DictionaryIsNotExistException();
            if (null != dictionary.getParentId())
                throw new DictionaryIsChildException();
        }
    }

    private Dictionary verifyDictionaryIsExist(String id) {
        Dictionary dictionary = getDao().selectByPrimaryKey(id);
        if (null == dictionary)
            throw new DictionaryIsNotExistException();
        return dictionary;
    }
}
