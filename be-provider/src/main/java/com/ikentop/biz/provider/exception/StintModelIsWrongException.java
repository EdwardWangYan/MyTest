package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author Huqiao
 * @since 2017/12/14
 */
public class StintModelIsWrongException extends BizException {
    public StintModelIsWrongException() {
        super(BEErrorCode.STINT_MODEL_IS_WRONG);
    }
}
