package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizExceptionWithArguments;

/**
 * @author Huqiao
 * @since 2017/12/18
 */
public class ChildCountIsWrongException extends BizExceptionWithArguments {

    public ChildCountIsWrongException(String reason) {
        super(BEErrorCode.CHILD_COUNT_IS_WRONG, reason);
    }
}
