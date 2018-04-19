package com.ikentop.biz.provider.domain.payment.exception;

/**
 * @author tac
 * @since 08/01/2018
 */
public class PaymentCreationException extends Throwable {
    public PaymentCreationException() {
        super();
    }

    public PaymentCreationException(String message) {
        super(message);
    }

    public PaymentCreationException(String message, Throwable cause) {
        super(message, cause);
    }

    public PaymentCreationException(Throwable cause) {
        super(cause);
    }
}
