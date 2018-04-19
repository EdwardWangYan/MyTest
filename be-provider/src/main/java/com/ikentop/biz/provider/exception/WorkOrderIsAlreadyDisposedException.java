package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author : Huqiao
 * @since : 2017/11/17
 */
public class WorkOrderIsAlreadyDisposedException extends BizException {
    public WorkOrderIsAlreadyDisposedException() {
        super(BEErrorCode.WORK_ORDER_IS_ALREADY_DISPOSED);
    }
}
