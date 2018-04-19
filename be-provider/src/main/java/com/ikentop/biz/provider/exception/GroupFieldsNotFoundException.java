package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author Huqiao
 * @since 2018/1/17
 */
public class GroupFieldsNotFoundException extends BizException {
    public GroupFieldsNotFoundException() {
        super(BEErrorCode.GROUP_FIELDS_NOT_FOUND);
    }
}
