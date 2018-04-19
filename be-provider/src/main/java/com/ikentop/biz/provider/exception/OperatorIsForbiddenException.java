package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author : Huqiao
 * @since : 2017/11/14
 */
public class OperatorIsForbiddenException extends BizException {
    public OperatorIsForbiddenException() {
        super(BEErrorCode.OPERATOR_IS_FORBIDDEN);
    }
}
