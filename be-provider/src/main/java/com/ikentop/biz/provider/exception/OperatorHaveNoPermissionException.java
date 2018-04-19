package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author : Huqiao
 * @since : 2017/11/8
 */
public class OperatorHaveNoPermissionException extends BizException {
    public OperatorHaveNoPermissionException() {
        super(BEErrorCode.OPERATOR_HAVE_NO_PERMISSION);
    }
}
