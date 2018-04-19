package com.ikentop.biz.provider.exception;

import com.ikentop.framework.core.exception.BizException;
import com.ikentop.biz.provider.BEErrorCode;

/**
 * @author : Huqiao
 * @since : 2017/9/8
 */
public class StaffNotExistException extends BizException {
    public StaffNotExistException() {
        super(BEErrorCode.STAFF_NOT_EXIST_ERROR);
    }
}
