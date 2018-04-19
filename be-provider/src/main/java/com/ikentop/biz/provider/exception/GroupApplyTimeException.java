package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author Huqiao
 * @since 2017/12/13
 */
public class GroupApplyTimeException extends BizException {
    public GroupApplyTimeException() {
        super(BEErrorCode.GROUP_APPLY_TIME);
    }
}
