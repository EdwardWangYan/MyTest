package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author : Huqiao
 * @since : 2017/10/27
 */
public class OrgTypeCodeAlreadyExistException extends BizException {
    public OrgTypeCodeAlreadyExistException() {
        super(BEErrorCode.ORGTYPE_CODE_ALREADY_EXIST);
    }
}
