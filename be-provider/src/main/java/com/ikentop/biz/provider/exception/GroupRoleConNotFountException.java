package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author Huqiao
 * @since 2017/12/29
 */
public class GroupRoleConNotFountException extends BizException {
    public GroupRoleConNotFountException() {
        super(BEErrorCode.GROUP_ROLE_CON_NOT_FOUNT);
    }
}
