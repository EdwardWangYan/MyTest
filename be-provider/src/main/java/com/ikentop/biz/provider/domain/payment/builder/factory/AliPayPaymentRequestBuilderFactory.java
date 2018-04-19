package com.ikentop.biz.provider.domain.payment.builder.factory;

import com.ikentop.biz.provider.domain.payment.builder.AliPayPagePaymentCreateRequestBuilder;
import com.ikentop.biz.provider.domain.payment.builder.AliPaymentRefundRequestBuilder;

/**
 * @author tac
 * @since 04/01/2018
 */
public class AliPayPaymentRequestBuilderFactory {
    private static AliPayPaymentRequestBuilderFactory instance;

    private AliPayPaymentRequestBuilderFactory() {
    }

    public static AliPayPaymentRequestBuilderFactory instance() {
        if (instance == null) {
            instance = new AliPayPaymentRequestBuilderFactory();
        }
        return instance;
    }

    public AliPayPagePaymentCreateRequestBuilder pagePaymentCreation() {
        return new AliPayPagePaymentCreateRequestBuilder();
    }

    public AliPaymentRefundRequestBuilder refund() {
        return new AliPaymentRefundRequestBuilder();
    }
}
