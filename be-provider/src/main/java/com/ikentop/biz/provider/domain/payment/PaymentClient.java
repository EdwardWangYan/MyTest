package com.ikentop.biz.provider.domain.payment;

import com.ikentop.biz.provider.domain.payment.exception.PaymentCreationException;
import com.ikentop.biz.provider.domain.payment.exception.PaymentRefundException;
import com.ikentop.biz.provider.domain.payment.pojo.PagePaymentCreateRequest;
import com.ikentop.biz.provider.domain.payment.pojo.PaymentRefundRequest;

/**
 * 支付客户端
 * @author tac
 * @since 04/01/2018
 */
public interface PaymentClient {
    /**
     * 创建网页支付交易订单
     */
    String createPagePayment(PagePaymentCreateRequest request) throws PaymentCreationException;
    String refund(PaymentRefundRequest request) throws PaymentRefundException;
//    String queryOrder(OrderQueryRequest request);
//    String queryRefund(RefundQueryRequest request);
//    String downloadBill(BillDownloadRequest request);
}
