package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author : Huqiao
 * @since : 2017/11/16
 */
public class RoleNotBelongToCurrentOrgException extends BizException {
    public RoleNotBelongToCurrentOrgException() {
        super(BEErrorCode.ROLE_NOT_BELONG_TO_CURRENT_ORG);
    }
}
