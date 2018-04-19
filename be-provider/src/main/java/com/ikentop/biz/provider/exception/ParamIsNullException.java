package com.ikentop.biz.provider.exception;

import com.ikentop.framework.core.exception.BizExceptionWithArguments;
import com.ikentop.framework.core.pojo.ErrorCode;

/**
 * @author : Huqiao
 * @date : 2017/9/6
 */
public class ParamIsNullException extends BizExceptionWithArguments {

    public ParamIsNullException(ErrorCode errorCode, String... args) {
        super(errorCode, args);
    }
}
