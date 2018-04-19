package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author : Huqiao
 * @since : 2017/11/9
 */
public class OrgApproveIsAlreadyExistException extends BizException {
    public OrgApproveIsAlreadyExistException() {
        super(BEErrorCode.ORG_APPROVE_IS_ALREADY_EXIST);
    }
}
