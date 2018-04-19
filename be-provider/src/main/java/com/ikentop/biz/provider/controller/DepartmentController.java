package com.ikentop.biz.provider.controller;

import com.ikentop.biz.provider.model.dto.DepartmentCreateDto;
import com.ikentop.biz.provider.model.dto.DepartmentDetailInfo;
import com.ikentop.biz.provider.model.dto.DepartmentInfo;
import com.ikentop.biz.provider.model.dto.DepartmentUpdateDto;
import com.ikentop.biz.provider.service.DepartmentService;
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
 * @author Huqiao
 * @author tac
 * @since 2017/9/6
 */
@RestController
@RequestMapping(DepartmentController.PATH)
@Api(description = "与部门相关的api")
public class DepartmentController {
    public static final String PATH = "department";

    @Autowired
    private DepartmentService departmentService;

    @ApiOperation(value = "创建部门")
    @RequestMapping(value = "create", method = RequestMethod.POST)
    @RequiresPermissions("department:create")
    public RestfulApiResponse<String> create(@Valid @RequestBody DepartmentCreateDto dto, Errors errors) {
        return RestfulApiResponse.success("创建部门成功", departmentService.create(dto));
    }

    @ApiOperation(value = "查询部门列表")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    @RequiresPermissions("department:view")
    public RestfulApiResponse<List<DepartmentInfo>> list() {
        return RestfulApiResponse.success("获取部门列表成功", departmentService.list());
    }

    @ApiOperation(value = "获取部门详细信息")
    @RequestMapping(value = "getDetail", method = RequestMethod.GET)
    @RequiresPermissions("department:view")
    public RestfulApiResponse<DepartmentDetailInfo> getDetail(@RequestParam @ApiParam(value = "部门id", required = true) String id) {
        return RestfulApiResponse.success("获取部门列表成功", departmentService.getDetail(id));
    }

    @ApiOperation(value = "修改部门")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @RequiresPermissions("department:update")
    public RestfulApiResponse<Integer> update(@Valid @RequestBody DepartmentUpdateDto dto, Errors errors) {
        return RestfulApiResponse.success("修改部门成功", departmentService.update(dto));
    }
}
