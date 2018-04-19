package com.ikentop.biz.provider.assembler;

import com.ikentop.biz.model.entity.OSSBucket;
import com.ikentop.biz.provider.model.dto.BucketInfoDto;
import com.ikentop.framework.core.factory.AssemblerFactory;
import com.ikentop.framework.core.pojo.Assembler;
import com.ikentop.framework.core.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : Huqiao
 * @since : 2017/10/23
 */
@Component
public class OSSBucket2BucketInfoDtoAssembler extends Assembler<OSSBucket, BucketInfoDto> {
    @Autowired
    public OSSBucket2BucketInfoDtoAssembler(AssemblerFactory factory) {
        factory.put(this, OSSBucket.class, BucketInfoDto.class);
    }

    @Override
    public BucketInfoDto assemble(OSSBucket ossBucket) {
        BucketInfoDto info = new BucketInfoDto();
        BeanUtils.copyProperties(ossBucket, info);
        info.setId(ossBucket.getPk());
        return info;
    }
}
