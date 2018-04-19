package com.ikentop.biz.provider.domain.payment.pojo;

/**
 * 扫码支付交易订单创建请求
 *
 * @author tac
 * @since 04/01/2018
 */
public class PagePaymentCreateRequest {
    /**
     * 回调通知url
     */
    private String notifyUrl;
    /**
     * 商户订单号
     */
    private String bizOrderNo;
    /**
     * 订单金额
     */
    private String totalAmount;
    /**
     * 附加参数
     */
    private String attachment;
    /**
     * 第三方支付特有额外参数
     */
    private PagePaymentCreateRequestExt ext;

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getBizOrderNo() {
        return bizOrderNo;
    }

    public void setBizOrderNo(String bizOrderNo) {
        this.bizOrderNo = bizOrderNo;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public PagePaymentCreateRequestExt getExt() {
        return ext;
    }

    public void setExt(PagePaymentCreateRequestExt ext) {
        this.ext = ext;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getAttachment() {
        return attachment;
    }

    public void initDefault() {
        //todo::
    }
}
