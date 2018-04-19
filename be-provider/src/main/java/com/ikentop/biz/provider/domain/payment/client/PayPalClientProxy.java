package com.ikentop.biz.provider.domain.payment.client;

import com.ikentop.biz.provider.domain.payment.PaymentClient;
import com.ikentop.biz.provider.domain.payment.PaymentProperties;
import com.ikentop.biz.provider.domain.payment.exception.PaymentCreationException;
import com.ikentop.biz.provider.domain.payment.exception.PaymentRefundException;
import com.ikentop.biz.provider.domain.payment.pojo.PagePaymentCreateRequest;
import com.ikentop.biz.provider.domain.payment.pojo.PayPalPagePaymentCreateRequestExt;
import com.ikentop.biz.provider.domain.payment.pojo.PaymentRefundRequest;
import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author tac
 * @since 04/01/2018
 */
public class PayPalClientProxy implements PaymentClient {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private PaymentProperties paymentProperties;
    private APIContext apiContext;

    public PayPalClientProxy(PaymentProperties paymentProperties) {
        this.paymentProperties = paymentProperties;
        init();
    }

    private void init() {
        logger.debug("准备初始化PayPal的API上下文");
        Boolean sandbox = paymentProperties.getSandbox();
        logger.debug("当前环境：{}", sandbox ? "沙箱环境" : "正式环境");
        String clientID = sandbox ? paymentProperties.getPayPal().getSandbox().getClient().getId() : paymentProperties.getPayPal().getClient().getId();
        String clientSecret = sandbox ? paymentProperties.getPayPal().getSandbox().getClient().getSecret() : paymentProperties.getPayPal().getClient().getSecret();
        String mode = sandbox ? "sandbox" : "production";

        if (StringUtils.isBlank(clientID)) {
            logger.warn("PayPal Client ID为空，在正确配置前客户端将无法正常使用");
        }
        if (StringUtils.isBlank(clientSecret) && !sandbox) {
            logger.warn("PayPal Client Secret为空，在正确配置前客户端将无法正常使用");
        }

        apiContext = new APIContext(clientID, clientSecret, mode);
        logger.info("初始化PayPal API上下文完成");
    }

    /**
     * 对应PayPal网页支付
     */
    @Override
    public String createPagePayment(PagePaymentCreateRequest request) throws PaymentCreationException {
        checkCreatePagePaymentRequest(request);
        logger.debug("准备请求创建PayPal网页支付交易订单");
        PayPalPagePaymentCreateRequestExt ext = (PayPalPagePaymentCreateRequestExt) request.getExt();

        logger.debug("---配置交易参数---");
        Transaction transaction = new Transaction();

        logger.debug("设置总金额");
        transaction.setAmount(new Amount(ext.getCurrency(), request.getTotalAmount()));
        logger.trace("amount: {} {}", request.getTotalAmount(), ext.getCurrency());

        logger.debug("设置订单描述内容");
        transaction.setDescription(ext.getDescription());
        logger.trace("description: {}", ext.getDescription());
//                .setCustom("custom-1")
//                .setInvoiceNumber("invoice-1")

        ItemList items = new ItemList();
        List<Item> ls = Lists.newArrayList();
        for (PayPalPagePaymentCreateRequestExt.PayPalTransactionItem payPalTransactionItem : ext.getItems()) {
            ls.add(new Item(
                    payPalTransactionItem.getName(),
                    payPalTransactionItem.getQuantity(),
                    payPalTransactionItem.getPrice(),
                    payPalTransactionItem.getCurrency()));
        }
        items.setItems(ls);

        logger.debug("设置商品清单");
        transaction.setItemList(items);
        transaction.setCustom(request.getBizOrderNo());
        logger.trace("item list: {}", items.toJSON());
//                .setNoteToPayee("note to payee")
//                .setNotifyUrl("http://6875e33f.ngrok.io/notify")
//                .setSoftDescriptor("soft desc")
//                .setSoftDescriptorCity("soft desc city");

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);
        logger.debug("---配置交易参数完成---");

        Payer payer = new Payer();

        logger.debug("---配置付款人信息---");
        PayerInfo payerInfo = new PayerInfo();
        //todo::
        payerInfo.setFirstName("tac");
        payerInfo.setLastName("cisum");
        payer.setPayerInfo(payerInfo);
        logger.debug("---配置付款人信息完成---");

        payer.setPaymentMethod("paypal");

        Payment payment = new Payment();
        payment.setIntent("sale");
        payment.setPayer(payer);
        payment.setTransactions(transactions);

        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl("/");
        logger.debug("设置支付跳转url");
        String returnUrl = paymentProperties.getDomain() + "/" + request.getNotifyUrl();
        redirectUrls.setReturnUrl(returnUrl);     //通过payment的url直接访问的话，点击继续会跳转到return url
        logger.trace("return url: {}", returnUrl);
        payment.setRedirectUrls(redirectUrls);
        Payment createdPayment = null;
        try {
            logger.debug("发起请求（{}）", paymentProperties.getSandbox() ? "沙箱环境" : "正式环境");
            createdPayment = payment.create(apiContext);
            logger.debug("请求完成");
        } catch (PayPalRESTException e) {
            throw new PaymentCreationException("创建PayPal交易订单失败", e);
        }
        String json = createdPayment.toJSON();
        logger.trace("payment(json) : " + json);

        return json;
    }

    @Override
    public String refund(PaymentRefundRequest request) throws PaymentRefundException {
        //todo::
        throw new NotImplementedException();
    }

    public void executePayment(String paymentId, String payerId, Consumer<Payment> consumer) throws PayPalRESTException {
        logger.debug("---准备执行PayPal支付---");
        logger.trace("payment id: " + paymentId);
        logger.trace("payer id: " + payerId);
        Payment payment = Payment.get(apiContext, paymentId);
        consumer.accept(payment);
        PaymentExecution paymentExecute = new PaymentExecution();
        paymentExecute.setPayerId(payerId);
        payment.execute(apiContext, paymentExecute);
        logger.debug("---执行PayPal支付完成---");
    }

    private void checkCreatePagePaymentRequest(PagePaymentCreateRequest request) {
        //todo::
    }
}
