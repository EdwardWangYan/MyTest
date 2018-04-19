package com.ikentop.biz.provider.domain.payment;

import com.ikentop.biz.provider.domain.payment.builder.factory.AliPayPaymentRequestBuilderFactory;
import com.ikentop.biz.provider.domain.payment.builder.factory.PayPalPaymentRequestBuilderFactory;
import com.ikentop.biz.provider.domain.payment.builder.factory.WxPayPaymentRequestBuilderFactory;

/**
 * 支付请求参数构建器工厂的工厂
 *
 * @author tac
 * @since 04/01/2018
 */
public abstract class PaymentRequestBuilderFactoryFactory {
    public static AliPayPaymentRequestBuilderFactory aliPay() {
        return AliPayPaymentRequestBuilderFactory.instance();
    }

    public static WxPayPaymentRequestBuilderFactory wxPay(){
        return WxPayPaymentRequestBuilderFactory.instance();
    }

    public static PayPalPaymentRequestBuilderFactory payPal(){
        return PayPalPaymentRequestBuilderFactory.instance();
    }
}
