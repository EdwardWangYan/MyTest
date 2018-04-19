package com.ikentop.biz.provider.model.dto;

/**
 * @author tac
 * @since 15/11/2017
 */
public class QiniuCallbackDto {
    private String name;
    private String bucket;
    private String key;
    private String hash;
    private String ext;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    @Override
    public String toString() {
        return "QiniuCallbackDto{" +
                "name='" + name + '\'' +
                ", key='" + key + '\'' +
                ", bucket='" + bucket + '\'' +
                ", hash='" + hash + '\'' +
                '}';
    }
}

