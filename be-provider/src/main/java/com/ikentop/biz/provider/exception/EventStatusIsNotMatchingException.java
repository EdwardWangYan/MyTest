package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizExceptionWithArguments;

/**
 * @author Huqiao
 * @since 2017/12/13
 */
public class EventStatusIsNotMatchingException extends BizExceptionWithArguments {
    public EventStatusIsNotMatchingException(String reason) {
        super(BEErrorCode.EVENT_STATUS_IS_NOT_MATCHING, reason);
    }
}
