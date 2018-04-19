package com.ikentop.biz.provider.controller;

import com.ikentop.biz.provider.model.dto.*;
import com.ikentop.biz.provider.service.WorkOrderService;
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
 * @author : Huqiao
 * @since : 2017/10/20
 */
@RestController
@RequestMapping(WorkOrderController.PATH)
@Api(description = "与工单相关的api")
public class WorkOrderController {
    public static final String PATH = "workOrder";
    @Autowired
    private WorkOrderService workOrderService;

    @ApiOperation("通过工单（找回密码）")
    @RequestMapping(value = "pass4RetrievePassword", method = RequestMethod.POST)
    @RequiresPermissions("workOrder:update")
    public RestfulApiResponse<MinOperatorInfo> pass4RetrievePassword(@Valid @RequestBody WorkOrderPass4RetrievePasswordDto dto, Errors errors) {
        return RestfulApiResponse.success("找回密码成功", workOrderService.pass4RetrievePassword(dto));
    }

    @ApiOperation("通过工单（机构信息修改审核）")
    @RequestMapping(value = "pass4OrgUpdate", method = RequestMethod.POST)
    @RequiresPermissions("workOrder:update")
    public RestfulApiResponse<String> pass4OrgUpdate(@Valid @RequestBody WorkOrderPassDto dto, Errors errors) {
        return RestfulApiResponse.success("机构信息修改成功", workOrderService.pass4OrgUpdate(dto));
    }

    @ApiOperation("通过工单（机构认证信息编辑审核）")
    @RequestMapping(value = "pass4OrgApprove", method = RequestMethod.POST)
    @RequiresPermissions("workOrder:update")
    public RestfulApiResponse<String> pass4OrgApprove(@Valid @RequestBody WorkOrderPassDto dto, Errors errors) {
        return RestfulApiResponse.success("机构认证信息编辑成功", workOrderService.pass4OrgApprove(dto));
    }

    @ApiOperation("通过工单（机构入驻审核）")
    @RequestMapping(value = "pass4OrgRegister", method = RequestMethod.POST)
    @RequiresPermissions("workOrder:update")
    public RestfulApiResponse<OrganizationCreateResultDto> pass4OrgRegister(@Valid @RequestBody WorkOrderPass4OrgRegisterDto dto, Errors errors) {
        return RestfulApiResponse.success("机构入驻成功", workOrderService.pass4OrgRegister(dto));
    }

    @ApiOperation("工单不通过")
    @RequestMapping(value = "fail", method = RequestMethod.POST)
    @RequiresPermissions("workOrder:update")
    public RestfulApiResponse<Integer> fail(@RequestParam @ApiParam(value = "工单ID", required = true) String id) {
        return RestfulApiResponse.success("工单不通过成功", workOrderService.fail(id));
    }

    @ApiOperation("获取工单列表")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    @RequiresPermissions("workOrder:view")
    public RestfulApiResponse<DataTableResponse<WorkOrderListInfo>> list(@Valid @ModelAttribute WorkOrderListDto dto, Errors errors) {
        return RestfulApiResponse.success("获取列表成功", workOrderService.list(dto));
    }

    @ApiOperation("获取工单详情")
    @RequestMapping(value = "getDetail", method = RequestMethod.GET)
    @RequiresPermissions("workOrder:view")
    public RestfulApiResponse<WorkOrderDetailInfo> getDetail(@RequestParam @ApiParam(value = "工单id", required = true) String id) {
        return RestfulApiResponse.success("获取详情成功", workOrderService.getDetail(id));
    }
}
