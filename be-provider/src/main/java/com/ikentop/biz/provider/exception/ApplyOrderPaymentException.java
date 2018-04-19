package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizExceptionWithArguments;

/**
 * @author tac
 * @since 25/01/2018
 */
public class ApplyOrderPaymentException extends BizExceptionWithArguments {
    public ApplyOrderPaymentException(String reason) {
        super(BEErrorCode.APPLY_ORDER_PAYMENT_ERROR, reason);
    }
}
