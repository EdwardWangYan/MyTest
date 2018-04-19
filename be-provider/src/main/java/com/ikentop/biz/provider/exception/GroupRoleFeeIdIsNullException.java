package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author Huqiao
 * @since 2018/1/17
 */
public class GroupRoleFeeIdIsNullException extends BizException {
    public GroupRoleFeeIdIsNullException() {
        super(BEErrorCode.GROUP_ROLE_FEE_ID_IS_NULL);
    }
}
