package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author : Huqiao
 * @since : 2017/10/30
 */
public class OrgTypeConnotNullException extends BizException {
    public OrgTypeConnotNullException() {
        super(BEErrorCode.ORGTYPE_CONNOT_NULl);
    }
}
