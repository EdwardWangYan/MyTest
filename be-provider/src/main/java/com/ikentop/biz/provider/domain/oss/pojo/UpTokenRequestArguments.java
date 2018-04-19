package com.ikentop.biz.provider.domain.oss.pojo;

/**
 * @author tac
 * @since 14/11/2017
 */
public class UpTokenRequestArguments {
    private Long expires;
    private String relativeCallbackUrl;

    public Long getExpires() {
        return expires;
    }

    public void setExpires(Long expires) {
        this.expires = expires;
    }

    public String getRelativeCallbackUrl() {
        return relativeCallbackUrl;
    }

    public void setRelativeCallbackUrl(String relativeCallbackUrl) {
        this.relativeCallbackUrl = relativeCallbackUrl;
    }
}
