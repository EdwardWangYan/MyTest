package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author Huqiao
 * @since 2017/12/14
 */
public class OptionConNotFoundException extends BizException {
    public OptionConNotFoundException() {
        super(BEErrorCode.OPTION_CON_NOT_FOUND);
    }
}
