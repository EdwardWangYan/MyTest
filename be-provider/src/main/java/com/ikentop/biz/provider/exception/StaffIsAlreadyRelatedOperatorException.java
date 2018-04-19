package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author : Huqiao
 * @since : 2017/11/9
 */
public class StaffIsAlreadyRelatedOperatorException extends BizException {
    public StaffIsAlreadyRelatedOperatorException() {
        super(BEErrorCode.STAFF_IS_ALREADY_RELATED_OPERATOR);
    }
}
