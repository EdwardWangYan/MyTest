package com.ikentop.biz.provider.model.bo;

import com.ikentop.biz.constant.PaymentMethod;

import java.util.Date;

/**
 * @author tac
 * @since 26/01/2018
 */
public class PaymentFinishBo {
    private String orderNo;
    private String thirdTradeNo;
    private PaymentMethod paymentMethod;
    private Double totalAmount;
    private String buyerId;
    private Date payTime;

    public PaymentFinishBo() {
    }

    public PaymentFinishBo(String orderNo, String thirdTradeNo, PaymentMethod paymentMethod, Double totalAmount, String buyerId, Date payTime) {
        this.orderNo = orderNo;
        this.thirdTradeNo = thirdTradeNo;
        this.paymentMethod = paymentMethod;
        this.totalAmount = totalAmount;
        this.buyerId = buyerId;
        this.payTime = payTime;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getThirdTradeNo() {
        return thirdTradeNo;
    }

    public void setThirdTradeNo(String thirdTradeNo) {
        this.thirdTradeNo = thirdTradeNo;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }
}
