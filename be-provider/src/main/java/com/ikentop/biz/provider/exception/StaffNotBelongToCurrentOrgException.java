package com.ikentop.biz.provider.exception;

import com.ikentop.framework.core.exception.BizException;
import com.ikentop.biz.provider.BEErrorCode;

/**
 * @author : tac
 * @since : 11/09/2017
 */
public class StaffNotBelongToCurrentOrgException extends BizException {
    public StaffNotBelongToCurrentOrgException() {
        super(BEErrorCode.STAFF_NOT_BELONG_TO_CURRENT_ORG);
    }
}
