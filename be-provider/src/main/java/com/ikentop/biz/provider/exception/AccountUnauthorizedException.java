package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author tac
 * @since 20/09/2017
 */
public class AccountUnauthorizedException extends BizException {
    public AccountUnauthorizedException() {
        super(BEErrorCode.ACCOUNT_UNAUTHORIZED_ERROR);
    }
}
