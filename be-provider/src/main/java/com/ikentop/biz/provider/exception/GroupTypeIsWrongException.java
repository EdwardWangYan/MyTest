package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author Huqiao
 * @since 2017/12/14
 */
public class GroupTypeIsWrongException extends BizException {
    public GroupTypeIsWrongException() {
        super(BEErrorCode.GROUP_TYPE_IS_WRONG);
    }
}
