package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author Huqiao
 * @since 2017/12/18
 */
public class GenderLimitIsWrongException extends BizException {
    public GenderLimitIsWrongException() {
        super(BEErrorCode.GENDER_LIMIT_IS_WRONG);
    }
}
