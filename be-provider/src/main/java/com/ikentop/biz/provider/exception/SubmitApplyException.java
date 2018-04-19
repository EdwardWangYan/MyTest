package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizExceptionWithArguments;

/**
 * @author tac
 * @since 19/01/2018
 */
public class SubmitApplyException extends BizExceptionWithArguments {
    public SubmitApplyException(String reason) {
        super(BEErrorCode.SUBMIT_APPLY_ERROR, reason);
    }
}
