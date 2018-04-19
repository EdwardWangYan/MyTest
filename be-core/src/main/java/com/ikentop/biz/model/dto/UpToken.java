package com.ikentop.biz.model.dto;

/**
 * @author tac
 * @since 26/10/2017
 */
public class UpToken extends OSSDto {
    private String token;

    /**
     * @deprecated only for third-party framework.
     */
    public UpToken() {
        super(null);
    }

    public UpToken(String type, String token) {
        super(type);
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
