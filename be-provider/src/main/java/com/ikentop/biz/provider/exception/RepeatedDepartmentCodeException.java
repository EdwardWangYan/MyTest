package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author tac
 * @since 18/09/2017
 */
public class RepeatedDepartmentCodeException extends BizException {
    public RepeatedDepartmentCodeException() {
        super(BEErrorCode.REPEATED_DEPARTMENT_CODE_ERROR);
    }
}
