package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizExceptionWithArguments;

/**
 * @author tac
 * @since 19/01/2018
 */
public class RemoveMemberException extends BizExceptionWithArguments {
    public RemoveMemberException(String reason) {
        super(BEErrorCode.REMOVE_MEMBER_ERROR, reason);
    }
}
