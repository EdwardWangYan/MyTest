package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author Huqiao
 * @since 2018/1/26
 */
public class ApplyPaymentNotFoundException extends BizException {
    public ApplyPaymentNotFoundException() {
        super(BEErrorCode.APPLY_PAYMENT_NOT_FOUND);
    }
}
