package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author : Huqiao
 * @since : 2017/11/21
 */
public class OperatorNotHaveStaffException extends BizException {
    public OperatorNotHaveStaffException() {
        super(BEErrorCode.OPERATOR_NOT_HAVE_STAFF);
    }
}
