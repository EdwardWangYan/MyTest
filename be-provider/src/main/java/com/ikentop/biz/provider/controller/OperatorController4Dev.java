package com.ikentop.biz.provider.controller;

import com.ikentop.biz.provider.model.OperatorLoginResultDto;
import com.ikentop.biz.provider.model.dto.OperatorLoginDto;
import com.ikentop.framework.core.pojo.RestfulApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Profile;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author Huqiao
 * @author tac
 * @since 2017/9/5
 */
@Profile({"dev", "test"})
@RestController
@RequestMapping(OperatorController4Dev.PATH)
@Api(description = "与账号相关的api")
public class OperatorController4Dev extends OperatorController {

    @ApiOperation("用户登录")
    @RequestMapping(value = "login4dev", method = RequestMethod.POST)
    public RestfulApiResponse<OperatorLoginResultDto> login4dev(@Valid @RequestBody OperatorLoginDto dto, HttpServletRequest req, HttpServletResponse res, Errors errors) {
        return RestfulApiResponse.success("登录成功", operatorService.login(dto));
    }
}
