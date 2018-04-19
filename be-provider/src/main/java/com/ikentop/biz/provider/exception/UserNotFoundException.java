package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author Huqiao
 * @since 2017/12/26
 */
public class UserNotFoundException extends BizException {
    public UserNotFoundException() {
        super(BEErrorCode.USER_NOT_FOUND);
    }
}
