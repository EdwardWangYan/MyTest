package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author : Huqiao
 * @since : 2017/11/10
 */
public class StaffAlreadyHaveOperatorException extends BizException {
    public StaffAlreadyHaveOperatorException() {
        super(BEErrorCode.STAFF_ALREADY_HAVE_OPERATOR);
    }
}
