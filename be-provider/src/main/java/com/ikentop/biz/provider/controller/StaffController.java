package com.ikentop.biz.provider.controller;

import com.ikentop.biz.provider.model.dto.*;
import com.ikentop.biz.provider.service.StaffService;
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
@RequestMapping(StaffController.PATH)
@Api(description = "与员工相关的api")
public class StaffController {
    public static final String PATH = "staff";

    @Autowired
    private StaffService staffService;

    @ApiOperation(value = "录入员工信息")
    @RequestMapping(value = "createStaff", method = RequestMethod.POST)
    @RequiresPermissions("staff:create")
    public RestfulApiResponse<String> createStaff(@Valid @RequestBody StaffCreateDto dto, Errors errors) {
        return RestfulApiResponse.success("员工信息录入成功", staffService.createStaff(dto));
    }


    @ApiOperation(value = "修改员工信息")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @RequiresPermissions("staff:update")
    public RestfulApiResponse<Integer> update(@Valid @RequestBody StaffUpdateDto dto, Errors errors) {
        return RestfulApiResponse.success("修改成功", staffService.update(dto));
    }

    @ApiOperation(value = "查看员工列表")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    @RequiresPermissions("staff:view")
    public RestfulApiResponse<DataTableResponse<StaffListInfo>> list(@Valid @ModelAttribute StaffListDto dto, Errors errors) {
        return RestfulApiResponse.success("查询成功", staffService.list4Admin(dto));
    }

    @ApiOperation(value = "获取员工详情")
    @RequestMapping(value = "getDetail", method = RequestMethod.GET)
    @RequiresPermissions("staff:view")
    public RestfulApiResponse<StaffDetailInfo> getDetail(@RequestParam @ApiParam(value = "员工id", required = true) String id) {
        return RestfulApiResponse.success("查询成功", staffService.getDetail(id));
    }

}
