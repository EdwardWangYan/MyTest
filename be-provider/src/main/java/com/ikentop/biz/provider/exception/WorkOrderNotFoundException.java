package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author : Huqiao
 * @since : 2017/11/17
 */
public class WorkOrderNotFoundException extends BizException {
    public WorkOrderNotFoundException() {
        super(BEErrorCode.WORK_ORDER_NOT_FOUND);
    }
}
