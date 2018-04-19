package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author : Huqiao
 * @since : 2017/11/16
 */
public class DictionaryCodeIsAlreadyExistException extends BizException {
    public DictionaryCodeIsAlreadyExistException() {
        super(BEErrorCode.DICTIONARY_CODE_IS_ALREADY_EXIST);
    }
}
