package com.ikentop.biz.provider.controller;

import com.ikentop.biz.provider.exception.AccountUnauthorizedException;
import com.ikentop.biz.provider.exception.ImageCodeVerifyFailedException;
import com.ikentop.biz.provider.model.OperatorLoginResultDto;
import com.ikentop.biz.provider.model.dto.*;
import com.ikentop.biz.provider.service.OperatorService;
import com.ikentop.framework.core.pojo.DataTableResponse;
import com.ikentop.framework.core.pojo.RestfulApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Objects;

/**
 * @author Huqiao
 * @author tac
 * @since 2017/9/5
 */
@Profile("prod")
@RestController
@RequestMapping(OperatorController.PATH)
@Api(description = "与账号相关的api")
public class OperatorController {
    public static final String PATH = "operator";

    @Autowired
    protected OperatorService operatorService;

    @ApiOperation("为员工开通账号")
    @RequestMapping(value = "createOperator4Staff", method = RequestMethod.POST)
    @RequiresPermissions("operator:create")
    public RestfulApiResponse<MinOperatorInfo> createOperator4Staff(@Valid @RequestBody OperatorCreateDto dto, Errors errors) {
        return RestfulApiResponse.success("创建成功", operatorService.createOperator4Staff(dto));
    }
    @ApiOperation("用户登录")
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public RestfulApiResponse<OperatorLoginResultDto> login(OperatorLoginExtDto dto, HttpServletRequest req, HttpServletResponse res, Errors errors) {
      /*  if (!verifyImageCode(dto.getImageCode(), req))
            throw new ImageCodeVerifyFailedException();*/
        OperatorLoginResultDto log=operatorService.login(dto);
        return RestfulApiResponse.success("登录成功", log);
    }

    @ApiOperation("用户登出")
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public RestfulApiResponse<OperatorLoginResultDto> logout() {
        operatorService.logout();
        return RestfulApiResponse.success("登出成功");
    }

    @ApiOperation(value = "查询账号列表")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    @RequiresPermissions("operator:view")
    public RestfulApiResponse<DataTableResponse<OperatorListInfo>> list(@Valid @ModelAttribute OperatorListDto dto, Errors errors) {
        return RestfulApiResponse.success("查询成功", operatorService.list(dto));
    }

    @ApiOperation(value = "禁用账号")
    @RequestMapping(value = "forbidden", method = RequestMethod.POST)
    @RequiresPermissions("operator:update")
    public RestfulApiResponse<Integer> forbidden(@RequestParam @ApiParam(value = "账号id", required = true) String id) {
        return RestfulApiResponse.success("禁用成功", operatorService.forbidden(id));
    }

    @ApiOperation(value = "解除禁用")
    @RequestMapping(value = "relieveForbidden", method = RequestMethod.POST)
    @RequiresPermissions("operator:update")
    public RestfulApiResponse<Integer> relieveForbidden(@RequestParam @ApiParam(value = "账号id", required = true) String id) {
        return RestfulApiResponse.success("解除禁用成功", operatorService.relieveForbidden(id));
    }

    @ApiOperation("重置密码")
    @RequestMapping(value = "resetPassword", method = RequestMethod.POST)
    @RequiresPermissions("operator:update")
    public RestfulApiResponse<MinOperatorInfo> resetPassword(@RequestParam @ApiParam(value = "账号id", required = true) String id) {
        return RestfulApiResponse.success("重置密码成功", operatorService.resetPassword(id));
    }

    @ApiOperation("找回密码")
    @RequestMapping(value = "retrievePassword", method = RequestMethod.POST)
    public RestfulApiResponse<String> retrievePassword(@Valid @RequestBody RetrievePasswordDto dto) {
        return RestfulApiResponse.success("找回密码申请提交成功", operatorService.createWorkOrder(dto));
    }

    /**
     * todo::
     */
    @ApiOperation(value = "获取用户信息", hidden = true)
    @RequestMapping(value = "getDetail", method = RequestMethod.GET)
    public RestfulApiResponse<OperatorDetailInfo> getUserInfo4Active(String id) {
        return RestfulApiResponse.success("获取用户信息成功", operatorService.getUserInfo(id));
    }


    @ApiOperation(value = "获取当前账号信息")
    @RequestMapping(value = "getCurrentOperator", method = RequestMethod.GET)
    public RestfulApiResponse<OperatorDetailInfo> getCurrentOperator() {
        return RestfulApiResponse.success("获取成功", operatorService.getCurrentOperator());
    }

    @ApiOperation(value = "账号激活")
    @RequestMapping(value = "active", method = RequestMethod.POST)
    public RestfulApiResponse<Integer> active(@Valid @RequestBody OperatorActiveDto dto, Errors errors) {
        return RestfulApiResponse.success("激活成功", operatorService.active(dto));
    }

    @ApiOperation(value = "更新个人信息")
    @RequestMapping(value = "updateCurrentOperator", method = RequestMethod.POST)
    public RestfulApiResponse<Integer> updateCurrentOperator(@Valid @RequestBody CurrentOperatorUpdateDto dto, Errors errors) {
        return RestfulApiResponse.success("修改成功", operatorService.updateCurrentOperator(dto));
    }

    @ApiOperation(value = "修改密码")
    @RequestMapping(value = "alterPassword", method = RequestMethod.POST)
    public RestfulApiResponse<Integer> alterPassword(@Valid @RequestBody AlterPasswordDto dto, Errors errors) {
        return RestfulApiResponse.success("修改成功", operatorService.alterPassword(dto));
    }


    @ApiOperation(value = "", hidden = true)
    @RequestMapping(value = "unauthorized")
    public RestfulApiResponse unauthorized() {
        throw new AccountUnauthorizedException();
    }

    private Boolean verifyImageCode(String imageCode, HttpServletRequest req) {
        Boolean flag = false;
        HttpSession session = req.getSession();
        String sessionCode = (String) session.getAttribute(ImageCodeController.IMAGE_CODE_SESSION);
        if (null != sessionCode && Objects.equals(sessionCode.toLowerCase(), imageCode.toLowerCase()))
            flag = true;
        return flag;
    }
}
