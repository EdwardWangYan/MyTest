package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author : Huqiao
 * @since : 2017/11/28
 */
public class StaffMobileIsAlreadyExistException extends BizException {
    public StaffMobileIsAlreadyExistException() {
        super(BEErrorCode.STAFF_MOBILE_IS_ALREADY_EXIST);
    }
}
