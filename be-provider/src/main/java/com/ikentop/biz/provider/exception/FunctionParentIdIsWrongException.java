package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author : Huqiao
 * @since : 2017/10/23
 */
public class FunctionParentIdIsWrongException extends BizException {
    public FunctionParentIdIsWrongException() {
        super(BEErrorCode.FUNCTION_PARENTID_IS_WRONG);
    }
}
