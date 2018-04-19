package com.ikentop.biz.provider.exception;

import com.ikentop.framework.core.exception.BizExceptionWithArguments;
import com.ikentop.biz.provider.BEErrorCode;

/**
 * @author : tac
 * @since : 14/09/2017
 */
public class ResourceCreateException extends BizExceptionWithArguments{
    public ResourceCreateException(String reason) {
        super(BEErrorCode.RESOURCE_CREATE_ERROR, reason);
    }
}
