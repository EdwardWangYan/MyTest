package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author : Huqiao
 * @since : 2017/12/12
 */
public class EventTypeIsWrongException extends BizException {
    public EventTypeIsWrongException() {
        super(BEErrorCode.EVENT_TYPE_IS_WRONG);
    }
}
