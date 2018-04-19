package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizExceptionWithArguments;

/**
 * @author Huqiao
 * @since 2018/1/25
 */
public class ApplyMemberIsNotUniqueException extends BizExceptionWithArguments {
    public ApplyMemberIsNotUniqueException(String name) {
        super(BEErrorCode.APPLY_MEMBER_IS_NOT_UNIQUE, name);
    }
}
