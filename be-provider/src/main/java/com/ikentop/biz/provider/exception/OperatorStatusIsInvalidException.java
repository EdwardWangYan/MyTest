package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author : Huqiao
 * @since : 2017/11/8
 */
public class OperatorStatusIsInvalidException extends BizException {
    public OperatorStatusIsInvalidException() {
        super(BEErrorCode.OPERATOR_STATUS_IS_INVALID);
    }
}
