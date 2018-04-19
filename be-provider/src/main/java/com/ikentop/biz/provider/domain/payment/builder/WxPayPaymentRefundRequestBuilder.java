package com.ikentop.biz.provider.domain.payment.builder;

import com.ikentop.biz.provider.domain.payment.pojo.PaymentRefundRequest;
import com.ikentop.biz.provider.domain.payment.pojo.WxPayPaymentRefundRequestExt;

/**
 * @author tac
 * @since 26/01/2018
 */
public class WxPayPaymentRefundRequestBuilder extends GenericPaymentRefundRequestBuilder<WxPayPaymentRefundRequestBuilder> {
    private WxPayPaymentRefundRequestExt ext;

    public WxPayPaymentRefundRequestBuilder() {
        super(new PaymentRefundRequest(), new WxPayPaymentRefundRequestExt());
        ext = (WxPayPaymentRefundRequestExt) super.ext;
    }

    public WxPayPaymentRefundRequestBuilder TotalFee(Double amount) {
        ext.setTotalFee(formatTotalAmount(amount));
        return this;
    }


    public WxPayPaymentRefundRequestBuilder refundNo(String refundNo) {
        ext.setRefundNo(refundNo);
        return this;
    }

    public WxPayPaymentRefundRequestBuilder refundDesc(String refundDesc) {
        ext.setRefundDesc(refundDesc);
        return this;
    }
}
