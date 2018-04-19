package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizExceptionWithArguments;

/**
 * @author Huqiao
 * @since 2017/12/26
 */
public class UserChangePhoneException extends BizExceptionWithArguments {
    public UserChangePhoneException(String reason) {
        super(BEErrorCode.USER_CHANGE_PHONE,reason);
    }
}
