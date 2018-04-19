package com.ikentop.biz.provider.exception;

import com.ikentop.framework.core.exception.BizException;
import com.ikentop.biz.provider.BEErrorCode;

/**
 * @author : tac
 * @since : 12/09/2017
 */
public class SessionNullException extends BizException {
    public SessionNullException() {
        super(BEErrorCode.SESSION_NULL_ERROR);
    }
}
