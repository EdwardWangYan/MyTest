package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author Huqiao
 * @since 2017/12/20
 */
public class ApplyIsAlreadyCheckException extends BizException {
    public ApplyIsAlreadyCheckException() {
        super(BEErrorCode.APPLY_IS_ALREADY_CHECK);
    }
}
