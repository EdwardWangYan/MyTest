package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizExceptionWithArguments;

/**
 * @author Huqiao
 * @since 2017/12/29
 */
public class EventCommitVerifyException extends BizExceptionWithArguments {
    public EventCommitVerifyException(String reason) {
        super(BEErrorCode.EVENT_COMMIT_VERIFY,reason);
    }
}
