package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author : Huqiao
 * @since : 2017/9/8
 */
public class OperatorIsNotBelongToCurrentOrg extends BizException {
    public OperatorIsNotBelongToCurrentOrg() {
        super(BEErrorCode.OPERATOR_IS_NOT_BELONG_TO_CURRENT_ORG);
    }
}
