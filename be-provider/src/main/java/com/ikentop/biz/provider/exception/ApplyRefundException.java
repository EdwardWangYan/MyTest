package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizExceptionWithArguments;

/**
 * @author tac
 * @since 26/01/2018
 */
public class ApplyRefundException extends BizExceptionWithArguments {
    public ApplyRefundException(String reason) {
        super(BEErrorCode.APPLY_REFUND_ERROR, reason);
    }
}
