package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.ImageRecord;
import com.ikentop.biz.provider.model.dto.QiniuCallbackDto;
import com.ikentop.framework.core.factory.AssemblerFactory;
import com.ikentop.framework.core.pojo.Assembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : tac
 * @since : 2017/11/15
 */
@Component
public class QiniuCallbackDto2ImageRecordAssembler extends Assembler<QiniuCallbackDto, ImageRecord> {
    @Autowired
    public QiniuCallbackDto2ImageRecordAssembler(AssemblerFactory factory) {
        factory.put(this, QiniuCallbackDto.class, ImageRecord.class);
    }

    @Override
    public ImageRecord assemble(QiniuCallbackDto dto) {
        ImageRecord record = new ImageRecord();
        record.setStoreBucket(dto.getBucket());
        record.setStoreKey(dto.getKey());
        record.setHashCode(dto.getHash());
        record.setExtJson(dto.getExt());
        return record;
    }
}
