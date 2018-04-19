package com.ikentop.biz.provider.exception;

/**
 * @author : tac
 * @since : 12/09/2017
 */
public class NoSuchSessionAttributeException extends RuntimeException {
    public NoSuchSessionAttributeException(String attr) {
        super(attr);
    }
}
