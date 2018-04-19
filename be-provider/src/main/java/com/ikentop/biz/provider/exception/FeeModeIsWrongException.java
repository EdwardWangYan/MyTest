package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizExceptionWithArguments;

/**
 * @author Huqiao
 * @since 2017/12/18
 */
public class FeeModeIsWrongException extends BizExceptionWithArguments {
    public FeeModeIsWrongException(String reson) {
        super(BEErrorCode.FEE_MODE_IS_WRONG,reson);
    }
}
