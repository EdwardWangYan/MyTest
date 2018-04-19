package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author : Huqiao
 * @since : 2017/10/30
 */
public class OrgTypeIsNotExistException extends BizException {
    public OrgTypeIsNotExistException() {
        super(BEErrorCode.ORGTYPE_IS_NOT_EXIST);
    }
}
