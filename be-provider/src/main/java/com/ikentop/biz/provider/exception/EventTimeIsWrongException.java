package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizExceptionWithArguments;

/**
 * @author Huqiao
 * @since 2018/1/25
 */
public class EventTimeIsWrongException extends BizExceptionWithArguments {
    public EventTimeIsWrongException(String reason) {
        super(BEErrorCode.EVENT_TIME_IS_WRONG,reason);
    }
}
