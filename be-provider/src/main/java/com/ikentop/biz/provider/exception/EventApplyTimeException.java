package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizExceptionWithArguments;

/**
 * @author Huqiao
 * @since 2017/12/28
 */
public class EventApplyTimeException extends BizExceptionWithArguments {
    public EventApplyTimeException(String reason) {
        super(BEErrorCode.EVENT_APPLY_TIME,reason);
    }
}
