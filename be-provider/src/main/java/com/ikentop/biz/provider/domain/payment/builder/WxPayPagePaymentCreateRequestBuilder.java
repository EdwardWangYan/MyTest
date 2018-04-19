package com.ikentop.biz.provider.domain.payment.builder;

import com.ikentop.biz.provider.domain.payment.pojo.PagePaymentCreateRequest;
import com.ikentop.biz.provider.domain.payment.pojo.WxPayPagePaymentCreateRequestExt;

/**
 * @author tac
 * @since 04/01/2018
 */
public class WxPayPagePaymentCreateRequestBuilder extends GenericPagePaymentCreateRequestBuilderSupport<WxPayPagePaymentCreateRequestBuilder> {
    private WxPayPagePaymentCreateRequestExt ext;

    public WxPayPagePaymentCreateRequestBuilder() {
        super(new PagePaymentCreateRequest(), new WxPayPagePaymentCreateRequestExt());
        ext = (WxPayPagePaymentCreateRequestExt) super.ext;
    }

    public WxPayPagePaymentCreateRequestBuilder body(String body) {
        ext.setBody(body);
        return this;
    }

    public WxPayPagePaymentCreateRequestBuilder currency(String currency) {
        ext.setFeeType(currency);
        return this;
    }

    public WxPayPagePaymentCreateRequestBuilder productId(String productId) {
        ext.setProductId(productId);
        return this;
    }

    public WxPayPagePaymentCreateRequestBuilder detail(String detail) {
        ext.setDetail(detail);
        return this;
    }

    @Override
    protected String formatTotalAmount(double totalAmount) {
        return String.format("%.0f", totalAmount * 100);
    }
}
