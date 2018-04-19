package com.ikentop.biz.provider.service;

import com.ikentop.biz.model.entity.OSSBucket;
import com.ikentop.biz.provider.dao.OSSBucketDao;
import com.ikentop.biz.provider.model.dto.BucketInfoDto;
import com.ikentop.framework.service.GenericServiceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tac
 * @since 16/11/2017
 */
@Service
public class OSSBucketService extends GenericServiceSupport<OSSBucketDao> {
    @Autowired
    public OSSBucketService(OSSBucketDao ossBucketDao) {
        super(ossBucketDao);
    }

    @Cacheable("listBucket")
    public List<BucketInfoDto> listBucket() {
        List<OSSBucket> ls = getDao().selectAll();
        return assemble(ls, BucketInfoDto.class);
    }

    @Cacheable("findByName")
    public OSSBucket findByName(String bucketName) {
        return getDao().findByName(bucketName);
    }
}
