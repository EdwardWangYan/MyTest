package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizExceptionWithArguments;

/**
 * @author Huqiao
 * @since 2018/1/9
 */
public class RefundIsWrongException extends BizExceptionWithArguments {
    public RefundIsWrongException(String reason) {
        super(BEErrorCode.REFUND_IS_WRONG,reason);
    }
}
