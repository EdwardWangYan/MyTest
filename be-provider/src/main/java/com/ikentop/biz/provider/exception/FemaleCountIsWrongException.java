package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizExceptionWithArguments;

/**
 * @author Huqiao
 * @since 2017/12/18
 */
public class FemaleCountIsWrongException extends BizExceptionWithArguments {
    public FemaleCountIsWrongException(String reason) {
        super(BEErrorCode.FEMALE_COUNT_IS_WRONG, reason);
    }
}
