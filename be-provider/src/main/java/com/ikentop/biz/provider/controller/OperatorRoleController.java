package com.ikentop.biz.provider.controller;

import com.ikentop.biz.provider.model.dto.OperatorRoleDto;
import com.ikentop.biz.provider.service.OperatorRoleService;
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
@RequestMapping(OperatorRoleController.PATH)
@Api(description = "与操作员角色相关的api")
public class OperatorRoleController {
    public static final String PATH = "operatorRole";

    @Autowired
    private OperatorRoleService operatorRoleService;

    @ApiOperation("为操作员分配角色")
    @RequestMapping(value = "allotRole4Operator", method = RequestMethod.POST)
    @RequiresPermissions("operator:relateRole")
    public RestfulApiResponse<Integer> allotRole4Operator(@Valid @RequestBody OperatorRoleDto dto, Errors errors) {
        return RestfulApiResponse.success("分配角色成功", operatorRoleService.allotRole4Operator(dto));
    }
}
