package com.ikentop.biz.provider.controller;

import com.ikentop.biz.provider.model.dto.DictionaryCreateDto;
import com.ikentop.biz.provider.model.dto.DictionaryInfo;
import com.ikentop.biz.provider.model.dto.DictionaryListInfo;
import com.ikentop.biz.provider.model.dto.DictionaryUpdateDto;
import com.ikentop.biz.provider.service.DictionaryService;
import com.ikentop.framework.core.pojo.RestfulApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

/**
 * @author : Huqiao
 * @since : 2017/10/26
 */
@RestController
@RequestMapping(DictionaryController.PATH)
@Api(description = "与数据字典相关的api")
public class DictionaryController {
    public static final String PATH = "dictionary";
    @Autowired
    private DictionaryService dictionaryService;

    @ApiOperation("新增数据字典")
    @RequestMapping(value = "create", method = RequestMethod.POST)
    @RequiresRoles("superAdmin")
    public RestfulApiResponse<String> create(@Valid @RequestBody DictionaryCreateDto dto, Errors errors) {
        return RestfulApiResponse.success("新增成功", dictionaryService.create(dto));
    }

    @ApiOperation("获取数据字典列表")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    @RequiresRoles("superAdmin")
    public RestfulApiResponse<List<DictionaryListInfo>> list() {
        return RestfulApiResponse.success("查询成功", dictionaryService.list());
    }

    @ApiOperation("获取数据字典详情")
    @RequestMapping(value = "getDetail", method = RequestMethod.GET)
    @RequiresRoles("superAdmin")
    public RestfulApiResponse<DictionaryInfo> getDetail(@RequestParam @ApiParam(value = "字典id", required = true) String id) {
        return RestfulApiResponse.success("查询成功", dictionaryService.getDetail(id));
    }

    @ApiOperation("根据父级code列表获取所有子级")
    @RequestMapping(value = "listByParentCodes", method = RequestMethod.GET)
    public RestfulApiResponse<HashMap<String, List<DictionaryListInfo>>> listByParentCodes(@RequestParam @ApiParam(value = "字典code列表", required = true) List<String> codes) {
        return RestfulApiResponse.success("查询成功", dictionaryService.listByParentCodes(codes));
    }

    @ApiOperation("编辑数据字典")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @RequiresRoles("superAdmin")
    public RestfulApiResponse<Integer> update(@Valid @RequestBody DictionaryUpdateDto dto, Errors errors) {
        return RestfulApiResponse.success("编辑成功", dictionaryService.update(dto));
    }

    @ApiOperation("删除数据字典")
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    @RequiresRoles("superAdmin")
    public RestfulApiResponse<Integer> delete(@RequestParam @ApiParam(value = "数据字典id", required = true) String id) {
        return RestfulApiResponse.success("删除成功", dictionaryService.delete(id));
    }
}
