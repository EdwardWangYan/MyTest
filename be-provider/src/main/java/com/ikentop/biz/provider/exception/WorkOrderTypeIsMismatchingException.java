package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author : Huqiao
 * @since : 2017/11/20
 */
public class WorkOrderTypeIsMismatchingException extends BizException {
    public WorkOrderTypeIsMismatchingException() {
        super(BEErrorCode.WORK_ORDER_TYPE_IS_MISMATCHING);
    }
}
