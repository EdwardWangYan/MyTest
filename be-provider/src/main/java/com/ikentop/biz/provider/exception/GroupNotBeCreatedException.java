package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author Huqiao
 * @since 2017/12/15
 */
public class GroupNotBeCreatedException extends BizException {
    public GroupNotBeCreatedException() {
        super(BEErrorCode.GROUP_NOT_BE_CREATED);
    }
}
