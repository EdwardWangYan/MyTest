package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author Huqiao
 * @since 2018/1/26
 */
public class EventApplyOrderNotFoundException extends BizException {
    public EventApplyOrderNotFoundException() {
        super(BEErrorCode.EVENT_APPLY_ORDER_NOT_FOUND);
    }
}
