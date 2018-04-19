package com.ikentop.biz.provider.controller;

import com.ikentop.biz.provider.model.dto.*;
import com.ikentop.biz.provider.service.RoleService;
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
import java.util.List;


/**
 * @author : tac
 * @since : 06/09/2017
 */
@RestController
@RequestMapping(RoleController.PATH)
@Api(description = "与角色相关的API")
public class RoleController {
    public static final String PATH = "role";

    @Autowired
    private RoleService roleService;

    @ApiOperation("创建角色")
    @RequiresPermissions("role:create")
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public RestfulApiResponse<String> create(@Valid @RequestBody RoleCreateDto dto, Errors errors) {
        return RestfulApiResponse.success("创建角色成功", roleService.create(dto));
    }

    @ApiOperation("获取角色详情")
    @RequiresPermissions("role:view")
    @RequestMapping(value = "getDetail", method = RequestMethod.GET)
    public RestfulApiResponse<RoleDetailInfo> getDetail(@RequestParam @ApiParam("角色id") String id) {
        return RestfulApiResponse.success("查询角色成功", roleService.getDetail(id));
    }

    @ApiOperation("查询角色列表")
    @RequiresPermissions("role:view")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public RestfulApiResponse<DataTableResponse<RoleDetailInfo>> list(@Valid @ModelAttribute RoleListDto dto, Errors errors) {
        return RestfulApiResponse.success("查询角色成功", roleService.list4Admin(dto));
    }

    @ApiOperation("查询可分配角色列表")
    @RequiresPermissions("role:view")
    @RequestMapping(value = "list4RelateRole", method = RequestMethod.GET)
    public RestfulApiResponse<List<RoleDetailInfo>> list4RelateRole() {
        return RestfulApiResponse.success("查询角色成功", roleService.list4RelateRole());
    }

    @ApiOperation("修改角色")
    @RequiresPermissions("role:update")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public RestfulApiResponse<Integer> update(@Valid @RequestBody RoleUpdateDto dto, Errors errors) {
        return RestfulApiResponse.success("修改角色成功", roleService.update(dto));
    }

    @ApiOperation("查询与操作员相关的角色列表")
    @RequestMapping(value = "list4operator", method = RequestMethod.GET)
    @RequiresPermissions("role:view")
    public RestfulApiResponse<List<Role4OperatorInfo>> list4operator(@RequestParam @ApiParam("操作员id") String id) {
        return RestfulApiResponse.success("查询角色成功", roleService.list4operator(id));
    }

    @ApiOperation("删除角色")
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    @RequiresPermissions("role:delete")
    public RestfulApiResponse<Integer> delete(@RequestParam @ApiParam(value = "角色id", required = true) String id) {
        return RestfulApiResponse.success("删除角色成功", roleService.delete(id));
    }
}
