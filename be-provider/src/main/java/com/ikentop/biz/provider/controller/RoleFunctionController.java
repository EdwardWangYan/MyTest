package com.ikentop.biz.provider.controller;

import com.ikentop.biz.provider.model.dto.RoleFunctionRelatedDto;
import com.ikentop.biz.provider.service.RoleFunctionService;
import com.ikentop.framework.core.pojo.RestfulApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author : Huqiao
 * @since : 2017/10/23
 */
@RestController
@RequestMapping(RoleFunctionController.PATH)
@Api(description = "与角色权限关联表相关的api")
public class RoleFunctionController {
    public static final String PATH = "rolePermission";

    @Autowired
    private RoleFunctionService roleFunctionService;

    @RequestMapping(value = "related", method = RequestMethod.POST)
    @ApiOperation("关联角色与权限")
    @RequiresPermissions("role:relatePermission")
    public RestfulApiResponse<Integer> related(@Valid @RequestBody RoleFunctionRelatedDto dto, Errors errors) {
        return RestfulApiResponse.success("关联成功", roleFunctionService.related(dto));
    }

}
