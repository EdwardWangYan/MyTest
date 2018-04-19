package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author : Huqiao
 * @since : 2017/10/31
 */
public class DepartmentIsNotExistException extends BizException {
    public DepartmentIsNotExistException() {
        super(BEErrorCode.DEPARTMENT_IS_NOT_EXIST);
    }
}
