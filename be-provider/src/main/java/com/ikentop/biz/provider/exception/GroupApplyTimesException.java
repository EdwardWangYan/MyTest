package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizExceptionWithArguments;

/**
 * @author Huqiao
 * @since 2017/12/28
 */
public class GroupApplyTimesException extends BizExceptionWithArguments {
    public GroupApplyTimesException(String reason) {
        super(BEErrorCode.GROUP_APPLY_TIMES, reason);
    }
}
