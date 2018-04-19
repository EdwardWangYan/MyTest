package com.ikentop.biz.provider.domain.payment.builder;

import com.ikentop.biz.provider.domain.payment.pojo.PagePaymentCreateRequest;
import com.ikentop.biz.provider.domain.payment.pojo.PayPalPagePaymentCreateRequestExt;

/**
 * @author tac
 * @since 04/01/2018
 */
public class PayPalPagePaymentCreateRequestBuilder extends GenericPagePaymentCreateRequestBuilderSupport<PayPalPagePaymentCreateRequestBuilder> {
    private PayPalPagePaymentCreateRequestExt ext;

    public PayPalPagePaymentCreateRequestBuilder() {
        super(new PagePaymentCreateRequest(), new PayPalPagePaymentCreateRequestExt());
        ext = (PayPalPagePaymentCreateRequestExt) super.ext;
    }

    public PayPalPagePaymentCreateRequestBuilder currency(String currency) {
        ext.setCurrency(currency);
        return this;
    }

    public PayPalPagePaymentCreateRequestBuilder description(String description) {
        ext.setDescription(description);
        return this;
    }

    public PayPalPagePaymentCreateRequestBuilder item(String name, int quantity, double price) {
        ext.addItem(new PayPalPagePaymentCreateRequestExt.PayPalTransactionItem(name, Integer.toString(quantity), String.format("%.2f", price)));
        return this;
    }

    public PayPalPagePaymentCreateRequestBuilder item(String name, int quantity, double price, String currency) {
        ext.addItem(new PayPalPagePaymentCreateRequestExt.PayPalTransactionItem(name, Integer.toString(quantity), String.format("%.2f", price), currency));
        return this;
    }
}
