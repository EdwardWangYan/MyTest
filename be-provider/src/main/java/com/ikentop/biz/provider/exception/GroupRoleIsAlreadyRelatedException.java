package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author Huqiao
 * @since 2017/12/29
 */
public class GroupRoleIsAlreadyRelatedException extends BizException {
    public GroupRoleIsAlreadyRelatedException() {
        super(BEErrorCode.GROUP_ROLE_IS_ALREADY_RELATED);
    }
}
