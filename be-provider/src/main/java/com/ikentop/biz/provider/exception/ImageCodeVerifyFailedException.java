package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author Huqiao
 * @since 2018/1/5
 */
public class ImageCodeVerifyFailedException extends BizException {
    public ImageCodeVerifyFailedException() {
        super(BEErrorCode.IMAGE_CODE_VERIFY_FAILED);
    }
}
