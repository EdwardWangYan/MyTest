package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author tac
 * @since 21/09/2017
 */
public class OperatorNotFoundException extends BizException{
    public OperatorNotFoundException() {
        super(BEErrorCode.ACCOUNT_NOT_FOUND_ERROR);
    }
}
