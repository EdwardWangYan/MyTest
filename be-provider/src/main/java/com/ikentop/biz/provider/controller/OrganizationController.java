package com.ikentop.biz.provider.controller;

import com.ikentop.biz.provider.exception.VerificationCodeIsWrongException;
import com.ikentop.biz.provider.model.dto.*;
import com.ikentop.biz.provider.service.OrganizationService;
import com.ikentop.biz.provider.service.VerificationCodeService;
import com.ikentop.framework.core.pojo.DataTableResponse;
import com.ikentop.framework.core.pojo.RestfulApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Huqiao
 * @author tac
 * @since 2017/9/6
 */
@RestController
@RequestMapping(OrganizationController.PATH)
@Api(description = "与机构相关的api")
public class OrganizationController {
    public static final String PATH = "organization";
    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private VerificationCodeService verificationCodeService;

    @ApiOperation("创建组织")
    @RequestMapping(value = "create", method = RequestMethod.POST)
    @RequiresPermissions("organization:create")
    public RestfulApiResponse<OrganizationCreateResultDto> create(@Valid @RequestBody OrganizationCreateDto dto, Errors errors) {
        return RestfulApiResponse.success("创建组织成功", organizationService.create(dto));
    }

    @ApiOperation("修改组织")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public RestfulApiResponse<String> update(@Valid @RequestBody OrganizationUpdateDto dto, Errors errors) {
        return RestfulApiResponse.success("修改成功", organizationService.update(dto));
    }

    @ApiOperation("修改申请提交")
    @RequestMapping(value = "commitUpdateApplication", method = RequestMethod.POST)
    public RestfulApiResponse<String> commitUpdateApplication(@Valid @RequestBody OrganizationUpdateDto dto, Errors errors) {
        return RestfulApiResponse.success("修改申请提交成功", organizationService.commitUpdateApplication(dto));
    }

    @ApiOperation("获取组织详情")
    @RequestMapping(value = "getDetail", method = RequestMethod.GET)
    @RequiresPermissions("organization:view")
    public RestfulApiResponse<OrganizationDetailInfo> getDetail(@RequestParam @ApiParam(value = "组织id", required = true) String id) {
        return RestfulApiResponse.success("查询成功", organizationService.getDetails(id));
    }

    @ApiOperation("获取当前组织详情")
    @RequestMapping(value = "getCurrentDetail", method = RequestMethod.GET)
    public RestfulApiResponse<OrganizationDetailInfo> getCurrentDetail() {
        return RestfulApiResponse.success("查询成功", organizationService.getCurrentDetails());
    }

    @ApiOperation(value = "机构入驻")
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public RestfulApiResponse<String> register(@RequestBody OrganizationRegisterDto dto) {
        if (!verificationCodeService.verifyCode(dto.getTelephone(), dto.getVerificationCode()))
            throw new VerificationCodeIsWrongException();
        return RestfulApiResponse.success("申请注册组织成功", organizationService.commitRegisterApplication(dto));
    }

    @ApiOperation(value = "查询组织列表")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    @RequiresPermissions("organization:view")
    public RestfulApiResponse<DataTableResponse<OrganizationListInfo>> list(@Valid @ModelAttribute OrganizationListDto dto, Errors errors) {
        return RestfulApiResponse.success("查询成功", organizationService.list(dto));
    }
}
