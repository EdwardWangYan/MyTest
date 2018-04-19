package com.ikentop.biz.provider.domain.payment.pojo;

/**
 * @author tac
 * @since 26/01/2018
 */
public class PaymentRefundRequest {
    private String bizOrderNo;
    private String tradeNo;
    private String refundFee;
    private PaymentRefundRequestExt ext;

    public String getBizOrderNo() {
        return bizOrderNo;
    }

    public void setBizOrderNo(String bizOrderNo) {
        this.bizOrderNo = bizOrderNo;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(String refundFee) {
        this.refundFee = refundFee;
    }

    public PaymentRefundRequestExt getExt() {
        return ext;
    }

    public void setExt(PaymentRefundRequestExt ext) {
        this.ext = ext;
    }
}
