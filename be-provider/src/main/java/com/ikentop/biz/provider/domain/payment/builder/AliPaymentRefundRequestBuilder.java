package com.ikentop.biz.provider.domain.payment.builder;

import com.ikentop.biz.provider.domain.payment.pojo.AliPayPaymentRefundRequestExt;
import com.ikentop.biz.provider.domain.payment.pojo.PaymentRefundRequest;

/**
 * @author tac
 * @since 26/01/2018
 */
public class AliPaymentRefundRequestBuilder  extends GenericPaymentRefundRequestBuilder<AliPaymentRefundRequestBuilder> {
    public AliPaymentRefundRequestBuilder() {
        super(new PaymentRefundRequest(), new AliPayPaymentRefundRequestExt());
    }
}
