package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author : Huqiao
 * @since : 2017/10/24
 */
public class OrgTypeTitleAlreadyExistException extends BizException {
    public OrgTypeTitleAlreadyExistException() {
        super(BEErrorCode.ORGTYPE_TITLE_IS_ALREADY);
    }
}
