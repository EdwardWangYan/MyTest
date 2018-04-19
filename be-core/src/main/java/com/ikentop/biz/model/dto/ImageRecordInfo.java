package com.ikentop.biz.model.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author : Huqiao
 * @since : 2017/11/24
 */
public class ImageRecordInfo {
    @ApiModelProperty(value = "图片ID")
    private String imageId;
    @ApiModelProperty(value = "存储空间")
    private String storeBucket;
    @ApiModelProperty(value = "key")
    private String storeKey;
    @ApiModelProperty(value = "hash值")
    private String hashCode;
    @ApiModelProperty(value = "扩展字段")
    private String extJson;

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
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
}
