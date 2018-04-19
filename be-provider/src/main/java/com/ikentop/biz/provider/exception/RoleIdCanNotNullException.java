package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author : Huqiao
 * @since : 2017/11/9
 */
public class RoleIdCanNotNullException extends BizException {
    public RoleIdCanNotNullException() {
        super(BEErrorCode.ROLEIDS_CAN_NOT_BE_NULL);
    }
}
