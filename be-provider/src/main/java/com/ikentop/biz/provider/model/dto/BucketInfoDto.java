package com.ikentop.biz.provider.model.dto;

/**
 * @author tac
 * @since 16/11/2017
 */
public class BucketInfoDto {
    private String id;
    private String name;
    private String domain;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
