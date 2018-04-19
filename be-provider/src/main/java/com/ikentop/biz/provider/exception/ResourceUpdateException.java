package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizExceptionWithArguments;

/**
 * @author : Huqiao
 * @since : 2017/11/1
 */
public class ResourceUpdateException extends BizExceptionWithArguments {
    public ResourceUpdateException(String reason) {
        super(BEErrorCode.RESOURCE_UPDATE_ERROR, reason);
    }
}
