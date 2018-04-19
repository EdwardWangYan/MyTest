package com.ikentop.biz.model.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author tac
 * @since 15/11/2017
 */
@Table(name = "comm_image_record")
public class ImageRecord {
    @Id
    private String id;
    private String storeBucket;
    private String storeKey;
    private String hashCode;
    private String extJson;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStoreBucket() {
        return storeBucket;
    }

    public void setStoreBucket(String storeBucket) {
        this.storeBucket = storeBucket;
    }

    public String getStoreKey() {
        return storeKey;
    }

    public void setStoreKey(String storeKey) {
        this.storeKey = storeKey;
    }

    public String getHashCode() {
        return hashCode;
    }

    public void setHashCode(String hashCode) {
        this.hashCode = hashCode;
    }

    public String getExtJson() {
        return extJson;
    }

    public void setExtJson(String extJson) {
        this.extJson = extJson;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("storeBucket", storeBucket)
                .append("storeKey", storeKey)
                .append("hashCode", hashCode)
                .append("extJson", extJson)
                .toString();
    }
}
