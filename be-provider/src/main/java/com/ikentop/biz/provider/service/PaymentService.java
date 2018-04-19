package com.ikentop.biz.provider.service;

import com.ikentop.biz.constant.PaymentMethod;
import com.ikentop.biz.provider.domain.payment.PaymentClientFactory;
import com.ikentop.biz.provider.domain.payment.PaymentRequestBuilderFactoryFactory;
import com.ikentop.biz.provider.domain.payment.exception.PaymentCreationException;
import com.ikentop.biz.provider.domain.payment.pojo.PagePaymentCreateRequest;
import com.ikentop.biz.provider.exception.PagePaymentCreationException;
import com.ikentop.biz.provider.exception.UnsupportedPaymentMethodException;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @author tac
 * @since 04/01/2018
 */
@Service
public class PaymentService {
    /**
     * 创建测试用支付订单
     *
     * @param paymentMethod 支付方式
     */
    public String test(PaymentMethod paymentMethod) {
        PagePaymentCreateRequest request;
        switch (paymentMethod) {
            case ALI_PAY:
                request = PaymentRequestBuilderFactoryFactory.aliPay().pagePaymentCreation()
                        .notifyUrl("openapi/payment/callback/test/alipay/notify")
                        .bizOrderNo(generateOutTradeNo())
                        .totalAmount(randomTotalAmount())
                        .subject("测试商品subject")
                        .body("测试商品body")
                        .build();
                break;
            case PAY_PAL:
                request = PaymentRequestBuilderFactoryFactory.payPal().pagePaymentCreation()
                        .notifyUrl("openapi/payment/callback/test/paypal/success")
                        .bizOrderNo(generateOutTradeNo())
                        .totalAmount(23.45)
//                        .currency("CNY")
                        .description("测试商品")
                        .item("测试商品item1", 1, 10)
                        .item("测试商品item2", 2, 5)
                        .item("测试商品item3", 3, 1.15)
                        .build();
                break;
            case WX_PAY:
                request = PaymentRequestBuilderFactoryFactory.wxPay().pagePaymentCreation()
                        .notifyUrl("openapi/payment/callback/test/wxpay/notify")
                        .bizOrderNo(generateOutTradeNo())
                        .totalAmount(randomTotalAmount())
//                        .currency("CNY")
                        .productId(UUID.randomUUID().toString().replace("-", ""))
                        .body("测试商品")
                        .build();
                break;
            default:
                throw new UnsupportedPaymentMethodException(paymentMethod);
        }
        try {
            return PaymentClientFactory.create(paymentMethod).createPagePayment(request);
        } catch (PaymentCreationException e) {
            throw new PagePaymentCreationException(e.getMessage());
        }
    }

    /**
     * 创建赛事报名PC端支付订单
     */
    public String eventApplicationPayment4PC(PaymentMethod paymentMethod) {
        throw new NotImplementedException();
    }

    private String generateOutTradeNo() {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }

    private double randomTotalAmount() {
        return new Random().nextDouble() * 100;
    }
}
