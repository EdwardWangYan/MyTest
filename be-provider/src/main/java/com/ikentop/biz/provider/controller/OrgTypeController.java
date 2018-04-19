package com.ikentop.biz.provider.controller;

import com.ikentop.biz.provider.model.dto.*;
import com.ikentop.biz.provider.service.OrgTypeService;
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
 * @author : Huqiao
 * @since : 2017/10/24
 */
@RestController
@RequestMapping(OrgTypeController.PATH)
@Api(description = "与机构类型表相关的api")
public class OrgTypeController {
    public static final String PATH = "orgType";

    @Autowired
    private OrgTypeService orgTypeService;

    @ApiOperation(value = "新增机构类型")
    @RequestMapping(value = "create", method = RequestMethod.POST)
    @RequiresRoles("superAdmin")
    public RestfulApiResponse<String> create(@Valid @RequestBody OrgTypeCreateDto dto, Errors errors) {
        return RestfulApiResponse.success("新增成功", orgTypeService.create(dto));
    }

    @ApiOperation(value = "修改机构类型")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @RequiresRoles("superAdmin")
    public RestfulApiResponse<String> update(@Valid @RequestBody OrgTypeUpdateDto dto, Errors errors) {
        return RestfulApiResponse.success("修改成功", orgTypeService.update(dto));
    }

    @ApiOperation(value = "获取机构详情")
    @RequestMapping(value = "getDetail", method = RequestMethod.GET)
    @RequiresRoles("superAdmin")
    public RestfulApiResponse<OrgTypeDetailInfo> getDetail(@RequestParam @ApiParam(value = "机构类型ID", required = true) String id) {
        return RestfulApiResponse.success("查询成功", orgTypeService.getDetail(id));
    }

    @ApiOperation(value = "获取机构类型列表")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    @RequiresRoles("superAdmin")
    public RestfulApiResponse<DataTableResponse<OrgTypeListInfo>> list(@Valid @ModelAttribute OrgTypeListDto dto, Errors errors) {
        return RestfulApiResponse.success("查询成功", orgTypeService.list(dto));
    }

    @ApiOperation(value = "获取机构类型列表")
    @RequestMapping(value = "list4DropDown", method = RequestMethod.GET)
    public RestfulApiResponse<List<OrgTypeDropDownInfo>> list4DropDown() {
        return RestfulApiResponse.success("查询成功", orgTypeService.list4DropDown());
    }

    @ApiOperation(value = "删除机构类型")
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    @RequiresRoles("superAdmin")
    public RestfulApiResponse<Integer> delete(@RequestParam @ApiParam(value = "机构类型id", required = true) String id) {
        return RestfulApiResponse.success("删除成功", orgTypeService.delete(id));
    }
}
