package com.ikentop.biz.provider.exception;

import com.ikentop.framework.core.exception.BizException;
import com.ikentop.biz.provider.BEErrorCode;

/**
 * @author : tac
 * @since : 14/09/2017
 */
public class ResourceNotFoundException extends BizException {
    public ResourceNotFoundException() {
        super(BEErrorCode.RESOURCE_NOT_FOUND_ERROR);
    }
}
