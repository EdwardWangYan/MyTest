package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author Huqiao
 * @since 2017/12/13
 */
public class EventConNotFoundException extends BizException {
    public EventConNotFoundException() {
        super(BEErrorCode.EVENT_CON_NOT_FOUND);
    }
}
