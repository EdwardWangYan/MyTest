package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author : Huqiao
 * @since : 2017/11/16
 */
public class WorkOrderExtJsonIsWrongException extends BizException {
    public WorkOrderExtJsonIsWrongException() {
        super(BEErrorCode.WORK_ORDER_EXT_JSON_IS_WRONG);
    }
}
