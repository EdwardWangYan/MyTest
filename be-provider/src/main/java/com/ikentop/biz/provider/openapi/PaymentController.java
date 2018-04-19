package com.ikentop.biz.provider.openapi;

import com.ikentop.biz.constant.PaymentMethod;
import com.ikentop.biz.provider.service.PaymentService;
import com.ikentop.framework.core.pojo.RestfulApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.ikentop.framework.core.constant.SpringProfiles.PROD;
import static com.ikentop.framework.core.constant.SpringProfiles.TEST;

/**
 * @author tac
 * @since 04/01/2018
 */
@Controller
@RequestMapping(PaymentController.PATH)
@Profile({TEST, PROD})
public class PaymentController {
    public static final String PATH = "openapi/payment";

    @Autowired
    protected PaymentService service;

    @GetMapping("/test/alipay")
    @ResponseBody
    public RestfulApiResponse<String> alipayTest() {
        return RestfulApiResponse.success("创建支付宝测试支付订单成功", service.test(PaymentMethod.ALI_PAY));
    }

    @GetMapping("/test/paypal")
    @ResponseBody
    public RestfulApiResponse<String> paypalTest() {
        return RestfulApiResponse.success("创建PayPal测试支付订单成功", service.test(PaymentMethod.PAY_PAL));
    }

    @GetMapping("/test/wxpay")
    @ResponseBody
    public RestfulApiResponse<String> wxpayTest() {
        return RestfulApiResponse.success("创建微信支付测试支付订单成功", service.test(PaymentMethod.WX_PAY));
    }

    @GetMapping("/event/application/alipay/pc")
    @ResponseBody
    public RestfulApiResponse<String> eventApplicationPayment4PC() {
        return RestfulApiResponse.success("创建赛事报名PC端支付订单成功", service.eventApplicationPayment4PC(PaymentMethod.ALI_PAY));
    }
}
