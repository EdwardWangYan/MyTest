package com.ikentop.biz.provider.controller;

import com.ikentop.biz.provider.model.dto.*;
import com.ikentop.biz.provider.service.FunctionService;
import com.ikentop.framework.core.pojo.RestfulApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author : Huqiao
 * @since : 2017/10/22
 */
@RestController
@RequestMapping(FunctionController.PATH)
@Api(description = "与平台功能相关的api")
public class FunctionController {
    public static final String PATH = "function";
    @Autowired
    private FunctionService functionService;


    @ApiOperation("新增平台功能")
    @RequestMapping(value = "create", method = RequestMethod.POST)
    @RequiresRoles("superAdmin")
    public RestfulApiResponse<String> create(@Valid @RequestBody FunctionCreateDto dto, Errors errors) {
        return RestfulApiResponse.success("新增成功", functionService.create(dto));
    }

    @ApiOperation("编辑平台功能信息")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @RequiresRoles("superAdmin")
    public RestfulApiResponse<Integer> update(@Valid @RequestBody FunctionUpdateDto dto, Errors errors) {
        return RestfulApiResponse.success("编辑成功", functionService.update(dto));
    }

    @ApiOperation("为树形图获取所有平台功能")
    @RequestMapping(value = "list4tree", method = RequestMethod.GET)
    @RequiresRoles("superAdmin")
    public RestfulApiResponse<List<FunctionMenuInfo>> list4tree() {
        return RestfulApiResponse.success("查询成功", functionService.list4tree());
    }

    @ApiOperation("为分配权限获取所有平台功能")
    @RequestMapping(value = "list4Relate", method = RequestMethod.GET)
    public RestfulApiResponse<List<Function4RoleInfo>> list4Relate(@RequestParam @ApiParam(value = "角色id", required = true) String id) {
        return RestfulApiResponse.success("查询成功", functionService.list4Role(id));
    }

    @ApiOperation("获取平台功能详情")
    @RequestMapping(value = "getDetail", method = RequestMethod.GET)
    @RequiresRoles("superAdmin")
    public RestfulApiResponse<FunctionDetailInfo> getDetail(@RequestParam @ApiParam(value = "功能id", required = true) String id) {
        return RestfulApiResponse.success("编辑成功", functionService.getDetail(id));
    }

    @ApiOperation("获取角色关联的权限列表")
    @RequestMapping(value = "list4Role", method = RequestMethod.GET)
    @RequiresRoles("superAdmin")
    public RestfulApiResponse<List<Function4RoleInfo>> list4Role(@RequestParam @ApiParam(value = "角色id", required = true) String id) {
        return RestfulApiResponse.success("获取成功", functionService.list4Role(id));
    }
}
