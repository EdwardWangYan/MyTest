package com.ikentop.biz.provider.exception;

/**
 * @author tac
 * @since 26/10/2017
 */
public class NoSuchOSSManagerException extends RuntimeException {
    public NoSuchOSSManagerException(String type) {
        super(type);
    }
}
