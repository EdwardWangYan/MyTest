package com.ikentop.biz.provider.domain.payment.pojo;

/**
 * @author tac
 * @since 26/01/2018
 */
public class WxPayPaymentRefundRequestExt extends PaymentRefundRequestExt {
    public String getTotalFee() {
        return get("total_fee");
    }

    public void setTotalFee(String totalFee) {
        put("total_fee", totalFee);
    }

    public String getRefundDesc() {
        return get("refund_desc");
    }

    public void setRefundDesc(String refundDesc) {
        put("refund_desc", refundDesc);
    }

    public void setRefundNo(String refundNo) {
        put("refund_no", refundNo);
    }

    public String getRefundNo() {
        return get("refund_no");
    }
}
