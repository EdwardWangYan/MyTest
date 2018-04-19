package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author : Huqiao
 * @since : 2017/11/22
 */
public class MemberTypeIsNotExistException extends BizException {
    public MemberTypeIsNotExistException() {
        super(BEErrorCode.MEMBER_TYPE_IS_NOT_EXIST);
    }
}
