package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author : Huqiao
 * @since : 2017/11/16
 */
public class OperatorOldPasswordIsWrongException extends BizException {
    public OperatorOldPasswordIsWrongException() {
        super(BEErrorCode.OPERATOR_OLD_PASSWORD_IS_WRONG);
    }
}
