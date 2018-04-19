package com.ikentop.biz.provider.controller;

import com.ikentop.biz.provider.model.dto.*;
import com.ikentop.biz.provider.service.AreaService;
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
 * @author : Huqiao
 * @since : 2017/10/20
 */
@RestController
@RequestMapping(AreaController.PATH)
@Api(description = "与地区相关的api")
public class AreaController {
    public static final String PATH = "cnArea";

    @Autowired
    private AreaService areaService;

    @ApiOperation("为左边的tree提供地区信息")
    @RequestMapping(value = "list4tree", method = RequestMethod.GET)
    @RequiresPermissions("cnArea:view")
    public RestfulApiResponse<List<Area4TreeInfo>> list4tree() {
        return RestfulApiResponse.success("查询成功", areaService.list4tree());
    }

    @ApiOperation("搜索地区信息")
    @RequestMapping(value = "listChildrenAreaByCondition", method = RequestMethod.GET)
    @RequiresPermissions("cnArea:view")
    public RestfulApiResponse<DataTableResponse<Area4ListInfo>> listChildrenAreaByCondition(@Valid @ModelAttribute SearchForAreaDto dto, Errors errors) {
        return RestfulApiResponse.success("查询成功", areaService.listChildrenAreaByCondition(dto));
    }

    @ApiOperation("获取地区详情")
    @RequestMapping(value = "getDetail", method = RequestMethod.GET)
    @RequiresPermissions("cnArea:view")
    public RestfulApiResponse<AreaDetailInfo> getDetail(@RequestParam @ApiParam(value = "地区id",required = true)String id) {
        return RestfulApiResponse.success("查询成功", areaService.getDetail(id));
    }
    @ApiOperation("编辑行政区域")
    @RequestMapping(value = "update",method = RequestMethod.POST)
    @RequiresPermissions("cnArea:update")
    public RestfulApiResponse<Integer> update(@Valid @RequestBody AreaUpdateDto dto){
        return RestfulApiResponse.success("编辑成功",areaService.update(dto));
    }
}
