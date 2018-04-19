package com.ikentop.biz.provider.domain.payment.pojo;

/**
 * @author tac
 * @since 04/01/2018
 */
public class AliPayPagePaymentCreateRequestExt extends PagePaymentCreateRequestExt {
    public void setSubject(String subject) {
        put("subject", subject);
    }

    public String getSubject() {
        return get("subject").toString();
    }

    public void setBody(String body) {
        put("body", body);
    }

    public String getBody() {
        return get("body").toString();
    }

    public void setReturnUrl(String returnUrl) {
        put("return_url", returnUrl);
    }

    public String getReturnUrl() {
        return toS(get("return_url"));
    }

    @Override
    public void initDefault() {
    }
}
