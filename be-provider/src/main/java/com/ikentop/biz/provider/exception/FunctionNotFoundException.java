package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author : Huqiao
 * @since : 2017/10/23
 */
public class FunctionNotFoundException extends BizException {
    public FunctionNotFoundException() {
        super(BEErrorCode.FUNCTION_NOT_FOUND);
    }
}
