package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizExceptionWithArguments;

/**
 * @author tac
 * @since 28/12/2017
 */
public class ExistPCUserAccountException extends BizExceptionWithArguments {
    public ExistPCUserAccountException(String uid) {
        super(BEErrorCode.PC_USER_ACCOUNT_IS_ALREADY_EXIST, uid);
    }
}
