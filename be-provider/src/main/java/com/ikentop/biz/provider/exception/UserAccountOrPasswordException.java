package com.ikentop.biz.provider.exception;

import com.ikentop.framework.core.exception.BizException;
import com.ikentop.biz.provider.BEErrorCode;

/**
 * @author : tac
 * @since : 06/09/2017
 */
public class UserAccountOrPasswordException extends BizException {
    public UserAccountOrPasswordException() {
        super(BEErrorCode.USER_ACCOUNT_OR_PASSWORD_ERROR);
    }
}
