package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizExceptionWithArguments;

/**
 * @author tac
 * @since 15/01/2018
 */
public class EventApplyValidationException extends BizExceptionWithArguments {
    public EventApplyValidationException(String reason) {
        super(BEErrorCode.EVENT_APPLY_VALIDATION_ERROR, reason);
    }

    public EventApplyValidationException(String reason, String name) {
        this(String.format("该组别存在%s，参赛成员%s不符合报名条件", reason, name));
    }
}
