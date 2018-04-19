package com.ikentop.biz.provider.domain.payment.builder;

import com.ikentop.biz.provider.domain.payment.pojo.PaymentRefundRequest;
import com.ikentop.biz.provider.domain.payment.pojo.PaymentRefundRequestExt;

/**
 * @author tac
 * @since 26/01/2018
 */
public class GenericPaymentRefundRequestBuilder<BUILDER> {
    protected PaymentRefundRequest request;
    protected PaymentRefundRequestExt ext;

    public GenericPaymentRefundRequestBuilder(PaymentRefundRequest request, PaymentRefundRequestExt ext) {
        this.request = request;
        this.ext = ext;
        this.request.setExt(ext);
        setDefault(request, ext);
    }

    protected void setDefault(PaymentRefundRequest request, PaymentRefundRequestExt ext) {
    }

    public PaymentRefundRequest build() {
        return request;
    }

    public BUILDER tradeNo(String tradeNo) {
        request.setTradeNo(tradeNo);
        return (BUILDER) this;
    }

    public BUILDER bizOrderNo(String orderNo) {
        request.setBizOrderNo(orderNo);
        return (BUILDER) this;
    }

    public BUILDER refundFee(Double refundFee) {
        return refundFee(formatTotalAmount(refundFee));
    }

    public BUILDER refundFee(String refundFee) {
        request.setRefundFee(refundFee);
        return (BUILDER) this;
    }

    protected String formatTotalAmount(double totalAmount) {
        return String.format("%.2f", totalAmount);
    }
}
