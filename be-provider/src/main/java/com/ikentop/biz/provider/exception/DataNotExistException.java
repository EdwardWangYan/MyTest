package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizException;

/**
 * @author : Huqiao
 * @date : 2017/9/6
 */
public class DataNotExistException extends BizException{
    public DataNotExistException() {
        super(BEErrorCode.DATA_NOT_EXIST);
    }
}
