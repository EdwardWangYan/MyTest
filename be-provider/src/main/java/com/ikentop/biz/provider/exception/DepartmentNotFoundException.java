package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author tac
 * @since 18/09/2017
 */
public class DepartmentNotFoundException extends BizException{
    public DepartmentNotFoundException() {
        super(BEErrorCode.DEPARTMENT_NOT_FOUND_ERROR);
    }
}
