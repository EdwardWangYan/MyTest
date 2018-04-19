package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author : Huqiao
 * @since : 2017/10/26
 */
public class DictionaryIsNotExistException extends BizException {
    public DictionaryIsNotExistException() {
        super(BEErrorCode. DICTIONARY_IS_NOT_EXIST);
    }
}
