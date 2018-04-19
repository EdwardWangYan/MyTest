package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author Huqiao
 * @since 2017/12/22
 */
public class UserLoginNameIsWrongException extends BizException {
    public UserLoginNameIsWrongException() {
        super(BEErrorCode.USER_LOGIN_NAME_IS_WRONG);
    }
}
