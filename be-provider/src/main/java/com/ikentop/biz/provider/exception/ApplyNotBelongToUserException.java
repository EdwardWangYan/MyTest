package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author tac
 * @since 15/01/2018
 */
public class ApplyNotBelongToUserException extends BizException {
    public ApplyNotBelongToUserException() {
        super(BEErrorCode.APPLY_NOT_BELONG_TO_USER_ERROR);
    }
}
