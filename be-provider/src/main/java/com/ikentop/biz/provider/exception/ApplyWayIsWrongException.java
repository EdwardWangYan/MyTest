package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizExceptionWithArguments;

/**
 * @author Huqiao
 * @since 2017/12/18
 */
public class ApplyWayIsWrongException extends BizExceptionWithArguments {
    public ApplyWayIsWrongException(String reason) {
        super(BEErrorCode.APPLY_WAY_IS_WRONG,reason);
    }
}
