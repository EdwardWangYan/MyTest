package com.ikentop.biz.provider.controller;

import com.ikentop.biz.constant.ResourceLevel;
import com.ikentop.biz.provider.model.dto.*;
import com.ikentop.biz.provider.service.ResourceService;
import com.ikentop.framework.core.pojo.DataTableResponse;
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
 * @author Huqiao
 * @author tac
 * @since 2017/9/6
 */
@RestController
@RequestMapping(ResourceController.PATH)
@Api(description = "与资源相关的api")
public class ResourceController {
    public static final String PATH = "resource";

    @Autowired
    private ResourceService resourceService;

    @ApiOperation("创建模块")
    @RequestMapping(value = "createModule", method = RequestMethod.POST)
    @RequiresRoles("superAdmin")
    public RestfulApiResponse<String> createModule(@Valid @RequestBody ModuleCreateDto dto, Errors errors) {
        return RestfulApiResponse.success("创建模块成功", resourceService.createResource(dto, ResourceLevel.MODULE));
    }

    @ApiOperation("创建菜单")
    @RequestMapping(value = "createMenu", method = RequestMethod.POST)
    @RequiresRoles("superAdmin")
    public RestfulApiResponse<String> createMenu(@Valid @RequestBody MenuCreateDto dto, Errors errors) {
        return RestfulApiResponse.success("创建菜单成功", resourceService.createResource(dto, ResourceLevel.MENU));
    }

    @ApiOperation("创建页面")
    @RequestMapping(value = "createPage", method = RequestMethod.POST)
    @RequiresRoles("superAdmin")
    public RestfulApiResponse<String> createPage(@Valid @RequestBody PageCreateDto dto, Errors errors) {
        return RestfulApiResponse.success("创建页面成功", resourceService.createResource(dto, ResourceLevel.PAGE));
    }

    @ApiOperation("创建操作")
    @RequestMapping(value = "createOperation", method = RequestMethod.POST)
    @RequiresRoles("superAdmin")
    public RestfulApiResponse<String> createOperation(@Valid @RequestBody OperationCreateDto dto, Errors errors) {
        return RestfulApiResponse.success("创建操作成功", resourceService.createResource(dto, ResourceLevel.OPERATION));
    }

    @ApiOperation(value = "编辑平台资源")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @RequiresRoles("superAdmin")
    public RestfulApiResponse<String> update(@Valid @RequestBody ResourceUpdateDto dto, Errors errors) {
        return RestfulApiResponse.success("修改成功", resourceService.update(dto));
    }

    @ApiOperation("查询资源下一级列表")
    @RequestMapping(value = "listNextLevel", method = RequestMethod.GET)
    @RequiresRoles("superAdmin")
    public RestfulApiResponse<DataTableResponse<ResourceListInfo>> listNextLevel(@Valid @ModelAttribute ResourceListDto dto, Errors errors) {
        return RestfulApiResponse.success("查询成功", resourceService.listNextLevel(dto));
    }

    @ApiOperation("查询资源列表")
    @RequestMapping(value = "list4tree", method = RequestMethod.GET)
    @RequiresRoles("superAdmin")
    public RestfulApiResponse<List<Resource4Tree>> list4tree() {
        return RestfulApiResponse.success("查询成功", resourceService.list4tree());
    }

    @ApiOperation("获取资源详细信息")
    @RequestMapping(value = "getDetail", method = RequestMethod.GET)
    @RequiresRoles("superAdmin")
    public RestfulApiResponse<ResourceListInfo> getDetail(@RequestParam @ApiParam(value = "资源id", required = true) String id) {
        return RestfulApiResponse.success("查询成功", resourceService.getDetail(id));
    }

    @ApiOperation("获取角色相关的资源列表")
    @RequestMapping(value = "list4Role", method = RequestMethod.GET)
    public RestfulApiResponse<List<Resource4RoleInfo>> list4Role(@RequestParam @ApiParam(value = "角色id", required = true) String id) {
        return RestfulApiResponse.success("查询成功", resourceService.list4Role(id));
    }

    @ApiOperation("获取当前账号相关的资源列表")
    @RequestMapping(value = "list4CurrentOperator", method = RequestMethod.GET)
    public RestfulApiResponse<List<Resource4RoleInfo>> list4CurrentOperator() {
        return RestfulApiResponse.success("查询成功", resourceService.list4CurrentOperator());
    }
}
