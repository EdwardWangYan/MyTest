package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author Huqiao
 * @since 2017/12/22
 */
public class UserPasswordIsWrongException extends BizException {
    public UserPasswordIsWrongException() {
        super(BEErrorCode.USER_PASSWORD_IS_WRONG);
    }
}
