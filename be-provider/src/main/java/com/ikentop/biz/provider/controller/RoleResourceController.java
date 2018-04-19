package com.ikentop.biz.provider.controller;

import com.ikentop.biz.provider.model.dto.RoleResourceRelatedDto;
import com.ikentop.biz.provider.service.RoleResourceService;
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
 * @since : 2017/10/20
 */
@RestController
@RequestMapping(RoleResourceController.PATH)
@Api(description = "与角色和资源相关的api")
public class RoleResourceController {
    public static final String PATH = "roleResource";

    @Autowired
    private RoleResourceService roleResourceService;

    @RequestMapping(value = "related", method = RequestMethod.POST)
    @ApiOperation("关联角色与资源")
    @RequiresPermissions("role:relateResource")
    public RestfulApiResponse<Integer> related(@Valid @RequestBody RoleResourceRelatedDto dto, Errors errors) {
        return RestfulApiResponse.success("关联成功", roleResourceService.related(dto));
    }
}
