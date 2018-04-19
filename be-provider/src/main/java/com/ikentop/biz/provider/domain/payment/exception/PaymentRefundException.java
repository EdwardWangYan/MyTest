package com.ikentop.biz.provider.domain.payment.exception;

/**
 * @author tac
 * @since 26/01/2018
 */
public class PaymentRefundException extends Throwable {
    public PaymentRefundException(String message) {
        super(message);
    }

    public PaymentRefundException(String message, Throwable cause) {
        super(message, cause);
    }
}
