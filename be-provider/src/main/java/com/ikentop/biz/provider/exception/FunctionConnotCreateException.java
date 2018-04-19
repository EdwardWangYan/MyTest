package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author : Huqiao
 * @since : 2017/10/23
 */
public class FunctionConnotCreateException extends BizException {
    public FunctionConnotCreateException() {
        super(BEErrorCode.FUNCTION_CONNOT_CREATE);
    }
}
