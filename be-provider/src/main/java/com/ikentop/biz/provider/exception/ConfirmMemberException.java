package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizExceptionWithArguments;

/**
 * @author tac
 * @since 19/01/2018
 */
public class ConfirmMemberException extends BizExceptionWithArguments {
    public ConfirmMemberException(String reason) {
        super(BEErrorCode.CONFIRM_MEMBER_ERROR, reason);
    }
}
