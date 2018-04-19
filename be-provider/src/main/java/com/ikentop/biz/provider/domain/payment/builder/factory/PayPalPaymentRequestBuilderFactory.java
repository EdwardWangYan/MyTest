package com.ikentop.biz.provider.domain.payment.builder.factory;

import com.ikentop.biz.provider.domain.payment.builder.PayPalPagePaymentCreateRequestBuilder;

/**
 * @author tac
 * @since 04/01/2018
 */
public class PayPalPaymentRequestBuilderFactory {
    private static PayPalPaymentRequestBuilderFactory instance;

    private PayPalPaymentRequestBuilderFactory() {
    }

    public static PayPalPaymentRequestBuilderFactory instance() {
        if (instance == null) {
            instance = new PayPalPaymentRequestBuilderFactory();
        }
        return instance;
    }

    public PayPalPagePaymentCreateRequestBuilder pagePaymentCreation() {
        return new PayPalPagePaymentCreateRequestBuilder();
    }
}
