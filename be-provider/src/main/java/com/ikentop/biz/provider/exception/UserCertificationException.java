package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizExceptionWithArguments;

/**
 * @author tac
 * @since 12/01/2018
 */
public class UserCertificationException extends BizExceptionWithArguments {
    public UserCertificationException(String reason) {
        super(BEErrorCode.USER_CERTIFICATION_ERROR, reason);
    }
}
