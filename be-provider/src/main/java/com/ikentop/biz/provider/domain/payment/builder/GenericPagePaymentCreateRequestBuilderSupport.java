package com.ikentop.biz.provider.domain.payment.builder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ikentop.biz.provider.domain.payment.pojo.PagePaymentCreateRequest;
import com.ikentop.biz.provider.domain.payment.pojo.PagePaymentCreateRequestExt;
import com.ikentop.biz.provider.domain.payment.pojo.PaymentAttachment;

/**
 * @author tac
 * @since 08/01/2018
 */
public abstract class GenericPagePaymentCreateRequestBuilderSupport<BUILDER extends GenericPagePaymentCreateRequestBuilderSupport> {
    protected PagePaymentCreateRequest request;
    protected PagePaymentCreateRequestExt ext;

    public GenericPagePaymentCreateRequestBuilderSupport(PagePaymentCreateRequest request, PagePaymentCreateRequestExt ext) {
        this.request = request;
        this.ext = ext;
        this.request.setExt(ext);
        setDefault(request, ext);
    }

    protected void setDefault(PagePaymentCreateRequest request, PagePaymentCreateRequestExt ext) {
        request.initDefault();
        ext.initDefault();
    }

    public BUILDER notifyUrl(String url) {
        request.setNotifyUrl(url);
        return (BUILDER) this;
    }

    public BUILDER bizOrderNo(String bizOrderNo) {
        request.setBizOrderNo(bizOrderNo);
        return (BUILDER) this;
    }

    public BUILDER totalAmount(double totalAmount) {
        return totalAmount(formatTotalAmount(totalAmount));
    }

    public BUILDER totalAmount(String totalAmount) {
        request.setTotalAmount(totalAmount);
        return (BUILDER) this;
    }

    public BUILDER attach(PaymentAttachment attachment) {
        request.setAttachment(convertAttachment2String(attachment));
        return (BUILDER) this;
    }

    public BUILDER extend(String key, Object val) {
        ext.put(key, val);
        return (BUILDER) this;
    }

    public PagePaymentCreateRequest build() {
        return request;
    }

    /**
     * 转换附加参数为字符串
     * 默认转换为json格式
     */
    protected String convertAttachment2String(PaymentAttachment attachment) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            return objectMapper.writeValueAsString(attachment);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
        return "";
    }

    protected String formatTotalAmount(double totalAmount) {
        return String.format("%.2f", totalAmount);
    }
}
