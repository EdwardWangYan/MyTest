package com.ikentop.biz.model.entity;

import com.ikentop.framework.core.pojo.GenericUUIDModel;

import javax.persistence.Table;

/**
 * @author tac
 * @since 15/11/2017
 */
@Table(name = "comm_oss_bucket")
public class OSSBucket extends GenericUUIDModel {
    private String name;
    private String domain;

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
