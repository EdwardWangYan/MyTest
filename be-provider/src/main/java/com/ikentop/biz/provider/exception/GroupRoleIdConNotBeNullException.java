package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author Huqiao
 * @since 2018/1/17
 */
public class GroupRoleIdConNotBeNullException extends BizException {
    public GroupRoleIdConNotBeNullException() {
        super(BEErrorCode.GROUP_ROLE_ID_CON_NOT_BE_NULL);
    }
}
