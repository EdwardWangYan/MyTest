package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.Dictionary;
import com.ikentop.biz.provider.model.dto.DictionaryUpdateDto;
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
public class DictionaryUpdateDto2DictionaryAssembler extends Assembler<DictionaryUpdateDto, Dictionary> {

    @Autowired
    public DictionaryUpdateDto2DictionaryAssembler(AssemblerFactory factory) {
        factory.put(this, DictionaryUpdateDto.class, Dictionary.class);
    }

    @Override
    public Dictionary assemble(DictionaryUpdateDto dto) {
        Dictionary dictionary = new Dictionary();
        BeanUtils.copyProperties(dto, dictionary);
        dictionary.setPk(dto.getId());
        return dictionary;
    }
}
