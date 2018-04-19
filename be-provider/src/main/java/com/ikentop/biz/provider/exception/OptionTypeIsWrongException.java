package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author Huqiao
 * @since 2017/12/19
 */
public class OptionTypeIsWrongException extends BizException {
    public OptionTypeIsWrongException() {
        super(BEErrorCode.OPTION_TYPE_IS_WRONG);
    }
}
