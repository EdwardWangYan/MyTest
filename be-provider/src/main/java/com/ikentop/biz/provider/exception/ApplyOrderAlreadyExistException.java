package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author tac
 * @since 25/01/2018
 */
public class ApplyOrderAlreadyExistException extends BizException {
    public ApplyOrderAlreadyExistException() {
        super(BEErrorCode.APPLY_ORDER_ALREADY_EXIST_ERROR);
    }
}
