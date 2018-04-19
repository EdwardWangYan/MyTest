package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author Huqiao
 * @since 2017/12/15
 */
public class OptionNotBeCreatedException extends BizException {
    public OptionNotBeCreatedException() {
        super(BEErrorCode.OPTION_NOT_BE_CREATED);
    }
}
