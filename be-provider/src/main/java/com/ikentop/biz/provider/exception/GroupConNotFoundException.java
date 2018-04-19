package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author Huqiao
 * @since 2017/12/13
 */
public class GroupConNotFoundException extends BizException {
    public GroupConNotFoundException() {
        super(BEErrorCode.GROUP_CON_NOT_FOUND);
    }
}
