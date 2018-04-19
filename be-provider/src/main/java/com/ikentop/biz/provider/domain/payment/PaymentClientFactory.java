package com.ikentop.biz.provider.domain.payment;

import com.google.common.collect.ImmutableMap;
import com.ikentop.biz.constant.PaymentMethod;
import com.ikentop.biz.provider.domain.payment.client.AliPayClientProxy;
import com.ikentop.biz.provider.domain.payment.client.PayPalClientProxy;
import com.ikentop.biz.provider.domain.payment.client.WxPayClientProxy;
import com.ikentop.biz.provider.exception.UnsupportedPaymentMethodException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author tac
 * @since 04/01/2018
 */
@Component
public class PaymentClientFactory {
    private static Logger logger = LoggerFactory.getLogger(PaymentClientFactory.class);
    private static PaymentProperties paymentProperties;

    @Autowired
    public void setPaymentProperties(PaymentProperties paymentProperties) {
        PaymentClientFactory.paymentProperties = paymentProperties;
    }

    private static boolean init = false;

    static boolean isInit() {
        return init;
    }

    private static ImmutableMap<PaymentMethod, PaymentClient> clients;

    public static PaymentClient create(PaymentMethod paymentMethod) {
        init();
        if (!clients.containsKey(paymentMethod)) {
            throw new UnsupportedPaymentMethodException(paymentMethod);
        }
        return clients.get(paymentMethod);
    }

    public static PaymentClient create(String paymentMethod) {
        return create(PaymentMethod.valueOf(paymentMethod.toUpperCase()));
    }

    private static void init() {
        if (!init) {
            logger.info("支付客户端工厂未初始化，将执行初始化操作");
            if (paymentProperties == null) {
                throw new RuntimeException("paymentProperties can not be null");
            }
            clients = new ImmutableMap.Builder<PaymentMethod, PaymentClient>()
                    .put(PaymentMethod.ALI_PAY, new AliPayClientProxy(paymentProperties))
                    .put(PaymentMethod.PAY_PAL, new PayPalClientProxy(paymentProperties))
                    .put(PaymentMethod.WX_PAY, new WxPayClientProxy(paymentProperties))
                    .build();
            init = !init;
            logger.info("支付客户端工厂初始化完成");
            clients.forEach((key, val) -> logger.trace("{}: {}", key, val.getClass()));
        }
    }
}
