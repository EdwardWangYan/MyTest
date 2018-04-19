package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author : Huqiao
 * @since : 2017/12/5
 */
public class OperatorIdNotBeNullException extends BizException {
    public OperatorIdNotBeNullException() {
        super(BEErrorCode.OPERATOR_ID_NOT_BE_NULL);
    }
}
