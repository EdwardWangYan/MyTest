package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author Huqiao
 * @since 2017/12/14
 */
public class StintMaxCountIsWrongException extends BizException {
    public StintMaxCountIsWrongException() {
        super(BEErrorCode.STINT_MAX_COUNT_IS_WRONG);
    }
}
