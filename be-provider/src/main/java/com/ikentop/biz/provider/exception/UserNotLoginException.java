package com.ikentop.biz.provider.exception;

import com.ikentop.framework.core.exception.BizException;
import com.ikentop.biz.provider.BEErrorCode;

/**
 * @author : Huqiao
 * @since : 2017/9/8
 */
public class UserNotLoginException extends BizException {
    public UserNotLoginException() {
        super(BEErrorCode.USER_NOT_LOGIN);
    }
}
