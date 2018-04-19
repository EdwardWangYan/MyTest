package com.ikentop.biz.provider.exception;

import com.ikentop.framework.core.exception.BizException;
import com.ikentop.biz.provider.BEErrorCode;

/**
 * todo::
 *
 * @author : tac
 * @since : 07/09/2017
 */
public class AccountIsActiveException extends BizException {
    public AccountIsActiveException() {
        super(BEErrorCode.ACCOUNT_IS_ALREADY_ACTIVE);
    }
}
