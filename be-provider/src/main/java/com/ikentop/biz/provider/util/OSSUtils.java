package com.ikentop.biz.provider.util;

import com.ikentop.biz.model.entity.ImageRecord;
import com.ikentop.biz.model.entity.OSSBucket;
import com.ikentop.biz.provider.service.OSSBucketService;
import com.ikentop.framework.core.util.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author tac
 * @since 27/12/2017
 */
@Component
public class OSSUtils {
    private static OSSBucketService service;

    @Autowired
    public void setService(OSSBucketService service) {
        OSSUtils.service = service;
    }

    public static String buildUrl(ImageRecord record) {
        check();
        if (record == null) {
            return null;
        }
        OSSBucket bucket = service.findByName(record.getStoreBucket());
        if (bucket == null) {
            return null;
        }
        return buildUrl(record, bucket);
    }

    private static String buildUrl(ImageRecord record, OSSBucket bucket) {
        return bucket.getDomain() + "/" + record.getStoreKey();
    }

    private static void check() {
        if (service == null) {
            service = SpringUtils.getBean(OSSBucketService.class);
            if (service == null) {
                throw new RuntimeException("OSSBucketService has no any available bean");
            }
        }
    }
}
