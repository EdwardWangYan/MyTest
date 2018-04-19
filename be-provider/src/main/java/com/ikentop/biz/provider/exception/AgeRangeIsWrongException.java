package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizExceptionWithArguments;

/**
 * @author Huqiao
 * @since 2017/12/18
 */
public class AgeRangeIsWrongException extends BizExceptionWithArguments {

    public AgeRangeIsWrongException(String reason) {
        super(BEErrorCode.AGE_RANGE_IS_WRONG, reason);
    }
}
