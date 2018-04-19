package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.Dictionary;
import com.ikentop.biz.provider.model.dto.DictionaryCreateDto;
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
public class DictionaryCreateDto2DictionaryAssembler extends Assembler<DictionaryCreateDto, Dictionary> {

    @Autowired
    public DictionaryCreateDto2DictionaryAssembler(AssemblerFactory factory) {
        factory.put(this, DictionaryCreateDto.class, Dictionary.class);
    }

    @Override
    public Dictionary assemble(DictionaryCreateDto dictionaryCreateDto) {
        Dictionary dictionary = new Dictionary();
        BeanUtils.copyProperties(dictionaryCreateDto, dictionary);
        return dictionary;
    }
}
