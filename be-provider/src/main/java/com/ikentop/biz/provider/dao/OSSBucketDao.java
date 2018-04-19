package com.ikentop.biz.provider.dao;

import com.ikentop.biz.model.entity.OSSBucket;
import com.ikentop.biz.provider.mapper.OSSBucketMapper;
import com.ikentop.framework.dao.GenericDaoSupport;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tac
 * @since 16/11/2017
 */
@Repository
public class OSSBucketDao extends GenericDaoSupport<OSSBucket, String> {
    @Autowired
    public OSSBucketDao(OSSBucketMapper mapper) {
        super(mapper, OSSBucket.class);
    }

    public OSSBucket findByName(String bucketName) {
        OSSBucket o = new OSSBucket();
        o.setName(bucketName);
        List<OSSBucket> ls = select(o);
        if (CollectionUtils.isEmpty(ls)) {
            return null;
        }
        return ls.get(0);
    }
}
