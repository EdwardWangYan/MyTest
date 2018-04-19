package com.ikentop.biz.provider.controller;

import com.ikentop.biz.provider.service.VerificationCodeService;
import com.ikentop.framework.core.pojo.RestfulApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author Huqiao
 * @since 2018/1/5
 */
@RestController
@RequestMapping(SmsController.PATH)
@Api(description = "与手机验证码相关的的api")
public class SmsController {
    public static final String PATH = "sms";

    @Autowired
    private VerificationCodeService verificationCodeService;

    @ApiOperation(value = "发送验证码")
    @RequestMapping(value = "sendCode", method = RequestMethod.GET)
    public RestfulApiResponse<String> sendCode(@RequestParam @ApiParam(value = "手机号", required = true) String receiver) throws IOException {
        return RestfulApiResponse.success("验证码发送成功", verificationCodeService.sendCode(receiver));
    }

    @ApiOperation(value = "校验验证码", hidden = true)
    @RequestMapping(value = "verifyCode", method = RequestMethod.GET)
    public RestfulApiResponse<Boolean> verifyCode(@RequestParam @ApiParam(value = "手机号", required = true) String receiver,
                                                  @RequestParam @ApiParam(value = "验证码", required = true) String vCode) throws IOException {
        return RestfulApiResponse.success("验证码校验成功", verificationCodeService.verifyCode(receiver, vCode));
    }
}
