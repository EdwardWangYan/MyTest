package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizExceptionWithArguments;

/**
 * @author tac
 * @since 15/01/2018
 */
public class GroupConfigNodeValueFormatException extends BizExceptionWithArguments {
    public GroupConfigNodeValueFormatException(String nodeName) {
        super(BEErrorCode.GROUP_CONFIG_NODE_VALUE_FORMAT_ERROR, nodeName);
    }
}
