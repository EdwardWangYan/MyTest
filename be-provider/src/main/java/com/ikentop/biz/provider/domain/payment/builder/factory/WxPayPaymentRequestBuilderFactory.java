package com.ikentop.biz.provider.domain.payment.builder.factory;

import com.ikentop.biz.provider.domain.payment.builder.WxPayPagePaymentCreateRequestBuilder;
import com.ikentop.biz.provider.domain.payment.builder.WxPayPaymentRefundRequestBuilder;

/**
 * @author tac
 * @since 04/01/2018
 */
public class WxPayPaymentRequestBuilderFactory {
    private static WxPayPaymentRequestBuilderFactory instance;

    private WxPayPaymentRequestBuilderFactory() {
    }

    public static WxPayPaymentRequestBuilderFactory instance() {
        if (instance == null) {
            instance = new WxPayPaymentRequestBuilderFactory();
        }
        return instance;
    }

    public WxPayPagePaymentCreateRequestBuilder pagePaymentCreation() {
        return new WxPayPagePaymentCreateRequestBuilder();
    }

    public WxPayPaymentRefundRequestBuilder refund() {
        return new WxPayPaymentRefundRequestBuilder();
    }
}
