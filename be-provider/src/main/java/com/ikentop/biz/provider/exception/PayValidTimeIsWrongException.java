package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizExceptionWithArguments;

/**
 * @author Huqiao
 * @since 2018/1/15
 */
public class PayValidTimeIsWrongException extends BizExceptionWithArguments {
    public PayValidTimeIsWrongException(String reason) {
        super(BEErrorCode.PAY_VALID_TIME_IS_WRONG,reason);
    }
}
