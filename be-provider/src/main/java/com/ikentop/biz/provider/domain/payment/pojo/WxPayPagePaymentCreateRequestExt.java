package com.ikentop.biz.provider.domain.payment.pojo;

/**
 * @author tac
 * @since 04/01/2018
 */
public class WxPayPagePaymentCreateRequestExt extends PagePaymentCreateRequestExt {
    public String getBody() {
        return get("body").toString();
    }

    public void setBody(String body) {
        put("body", body);
    }

    public String getFeeType() {
        return get("fee_type").toString();
    }

    public void setFeeType(String feeType) {
        put("fee_type", feeType);
    }

    @Override
    public void initDefault() {
        setFeeType("CNY");
    }

    public void setProductId(String productId) {
        put("product_id", productId);
    }

    public String getProductId() {
        return toS(get("product_id"));
    }

    public void setDetail(String detail) {
        put("detail", detail);
    }

    public String getDetail() {
        return toS(get("detail"));
    }

    public void setAttachment(PaymentAttachment attachment) {
        put("attachment", attachment);
    }

    public PaymentAttachment getAttachment() {
        return (PaymentAttachment) getOrDefault("attachment", null);
    }
}
