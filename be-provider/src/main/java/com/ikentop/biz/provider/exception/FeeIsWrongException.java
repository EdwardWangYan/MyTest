package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author Huqiao
 * @since 2017/12/18
 */
public class FeeIsWrongException extends BizException {
    public FeeIsWrongException() {
        super(BEErrorCode.FEE_IS_WRONG);
    }
}
