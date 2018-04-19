package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author : Huqiao
 * @since : 2017/11/1
 */
public class FunctionPermissionValueIsAlreadyExistException extends BizException {
    public FunctionPermissionValueIsAlreadyExistException() {
        super(BEErrorCode.FUNCTION_PERMISSION_VALUE_IS_ALREADY_EXIST);
    }
}
