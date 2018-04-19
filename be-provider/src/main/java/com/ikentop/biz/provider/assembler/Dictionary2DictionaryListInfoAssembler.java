package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.Dictionary;
import com.ikentop.biz.provider.model.dto.DictionaryListInfo;
import com.ikentop.framework.core.factory.AssemblerFactory;
import com.ikentop.framework.core.pojo.Assembler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : Huqiao
 * @since : 2017/10/26
 */
@Component
public class Dictionary2DictionaryListInfoAssembler extends Assembler<Dictionary, DictionaryListInfo> {

    @Autowired
    public Dictionary2DictionaryListInfoAssembler(AssemblerFactory factory) {
        factory.put(this, Dictionary.class, DictionaryListInfo.class);
    }

    @Override
    public DictionaryListInfo assemble(Dictionary dictionary) {
        DictionaryListInfo info = new DictionaryListInfo();
        BeanUtils.copyProperties(dictionary, info);
        info.setTitle(dictionary.getDataName());
        info.setId(dictionary.getPk());
        return info;
    }
}
