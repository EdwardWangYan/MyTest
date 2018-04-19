package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author : Huqiao
 * @since : 2017/12/12
 */
public class EventTypeConNotNullException extends BizException {
    public EventTypeConNotNullException() {
        super(BEErrorCode.EVENT_TYPE_CON_NOT_NULL);
    }
}
