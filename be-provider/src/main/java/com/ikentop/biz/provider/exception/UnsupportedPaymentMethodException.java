package com.ikentop.biz.provider.exception;

import com.ikentop.biz.constant.PaymentMethod;
import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizExceptionWithArguments;

/**
 * @author tac
 * @since 04/01/2018
 */
public class UnsupportedPaymentMethodException extends BizExceptionWithArguments {
    public UnsupportedPaymentMethodException(PaymentMethod paymentMethod) {
        super(BEErrorCode.UNSUPPORTED_PAYMENT_METHOD_ERROR, paymentMethod.name());
    }
}
