package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author Huqiao
 * @since 2017/12/13
 */
public class EventUpdatePermissionException extends BizException {
    public EventUpdatePermissionException() {
        super(BEErrorCode.EVENT_UPDATE_PERMISSION);
    }
}
