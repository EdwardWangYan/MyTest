package com.ikentop.biz.provider.domain.payment.builder;

import com.ikentop.biz.provider.domain.payment.pojo.AliPayPagePaymentCreateRequestExt;
import com.ikentop.biz.provider.domain.payment.pojo.PagePaymentCreateRequest;
import com.ikentop.biz.provider.domain.payment.pojo.PaymentAttachment;

/**
 * @author tac
 * @since 04/01/2018
 */
public class AliPayPagePaymentCreateRequestBuilder extends GenericPagePaymentCreateRequestBuilderSupport<AliPayPagePaymentCreateRequestBuilder> {
    private AliPayPagePaymentCreateRequestExt ext;

    public AliPayPagePaymentCreateRequestBuilder() {
        super(new PagePaymentCreateRequest(), new AliPayPagePaymentCreateRequestExt());
        ext = (AliPayPagePaymentCreateRequestExt) super.ext;
    }

    public AliPayPagePaymentCreateRequestBuilder returnUrl(String url) {
        ext.setReturnUrl(url);
        return this;
    }

    public AliPayPagePaymentCreateRequestBuilder subject(String subject) {
        ext.setSubject(subject);
        return this;
    }

    public AliPayPagePaymentCreateRequestBuilder body(String body) {
        ext.setBody(body);
        return this;
    }

    public AliPayPagePaymentCreateRequestBuilder attach(PaymentAttachment paymentAttachment) {
        ext.put("attachment", paymentAttachment);
        return this;
    }
}
