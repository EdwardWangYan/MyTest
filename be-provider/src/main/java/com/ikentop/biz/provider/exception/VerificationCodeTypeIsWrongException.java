package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author Huqiao
 * @since 2018/1/4
 */
public class VerificationCodeTypeIsWrongException extends BizException {
    public VerificationCodeTypeIsWrongException() {
        super(BEErrorCode.VERIFICATION_CODE_TYPE_IS_WRONG);
    }
}
