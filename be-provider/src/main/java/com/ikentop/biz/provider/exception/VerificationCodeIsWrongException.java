package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author Huqiao
 * @since 2018/1/8
 */
public class VerificationCodeIsWrongException extends BizException {
    public VerificationCodeIsWrongException() {
        super(BEErrorCode.VERIFICATION_CODE_IS_WRONG);
    }
}
