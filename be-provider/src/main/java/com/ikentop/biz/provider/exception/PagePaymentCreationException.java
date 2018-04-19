package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizExceptionWithArguments;

/**
 * @author tac
 * @since 08/01/2018
 */
public class PagePaymentCreationException extends BizExceptionWithArguments {
    public PagePaymentCreationException(String reason) {
        super(BEErrorCode.PAGE_PAYMENT_CREATION_ERROR, reason);
    }
}
