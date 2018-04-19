package com.ikentop.biz.provider.controller;

import com.ikentop.biz.provider.model.dto.OrgApproveDetailInfo;
import com.ikentop.biz.provider.model.dto.OrgApproveEditDto;
import com.ikentop.biz.provider.service.OrgApproveService;
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
 * @author : Huqiao
 * @since : 2017/10/25
 */
@RestController
@RequestMapping(OrgApproveController.PATH)
@Api(description = "与机构认证表有关的api")
public class OrgApproveController {
    public static final String PATH = "orgApprove";
    @Autowired
    private OrgApproveService orgApproveService;

    @ApiOperation("编辑机构认证信息")
    @RequestMapping(value = "commitEditApplication", method = RequestMethod.POST)
    public RestfulApiResponse<String> commitEditApplication(@Valid @RequestBody OrgApproveEditDto dto, Errors errors) {
        return RestfulApiResponse.success("编辑请求提交成功", orgApproveService.commitEditApplication(dto));
    }

    @ApiOperation(value = "获取机构认证信息", hidden = true)
    @RequestMapping(value = "getDetail", method = RequestMethod.GET)
    @RequiresPermissions("orgApprove:view")
    public RestfulApiResponse<OrgApproveDetailInfo> getDetail(@RequestParam @ApiParam(value = "认证信息id", required = true) String id) {
        return RestfulApiResponse.success("查询成功", orgApproveService.getDetail(id));
    }

    @ApiOperation("通过组织id获取机构认证信息")
    @RequestMapping(value = "getDetailByOrgId", method = RequestMethod.GET)
    public RestfulApiResponse<OrgApproveDetailInfo> getDetailByOrgId(@RequestParam @ApiParam(value = "机构id", required = true) String id) {
        return RestfulApiResponse.success("查询成功", orgApproveService.getDetailByOrgId(id));
    }
}
