package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author Huqiao
 * @since 2017/12/22
 */
public class BirthDayIsWrongException extends BizException {
    public BirthDayIsWrongException() {
        super(BEErrorCode.BIRTHDAY_IS_WRONG);
    }
}
