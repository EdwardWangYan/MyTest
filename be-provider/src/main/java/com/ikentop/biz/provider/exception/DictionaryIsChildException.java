package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author : Huqiao
 * @since : 2017/10/26
 */
public class DictionaryIsChildException extends BizException {
    public DictionaryIsChildException() {
        super(BEErrorCode.DICTIONARY_IS_CHILD);
    }
}
