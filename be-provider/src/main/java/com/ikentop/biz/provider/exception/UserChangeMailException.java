package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizExceptionWithArguments;

/**
 * @author tac
 * @since 12/01/2018
 */
public class UserChangeMailException extends BizExceptionWithArguments {
    public UserChangeMailException(String reason) {
        super(BEErrorCode.USER_CHANGE_MAIL, reason);
    }
}
