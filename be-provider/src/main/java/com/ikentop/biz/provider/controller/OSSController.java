package com.ikentop.biz.provider.controller;

import com.ikentop.biz.provider.domain.oss.OSSManager;
import com.ikentop.biz.provider.domain.oss.OSSProperties;
import com.ikentop.biz.provider.domain.oss.pojo.UpTokenRequestArguments;
import com.ikentop.biz.provider.model.dto.BucketInfoDto;
import com.ikentop.biz.model.dto.UpToken;
import com.ikentop.biz.provider.model.dto.UpTokenRequestDto;
import com.ikentop.biz.provider.service.OSSBucketService;
import com.ikentop.framework.core.pojo.RestfulApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author tac
 * @since 26/10/2017
 */
@RestController
@RequestMapping(OSSController.PATH)
@Api(description = "OSS相关接口")
public class OSSController {
    public static final String PATH = "oss";

    @Autowired
    private OSSManager ossManager;
    @Autowired
    private OSSBucketService ossBucketService;
    @Autowired
    private OSSProperties ossProperties;

    @ApiOperation("获取上传凭证")
    @RequestMapping(value = "simpleUpToken", method = RequestMethod.GET)
    public RestfulApiResponse<UpToken> upToken() {
        return RestfulApiResponse.success("获取上传凭证成功", ossManager.upToken());
    }

    @ApiOperation("获取上传凭证")
    @RequestMapping(value = "upToken", method = RequestMethod.GET)
    public RestfulApiResponse<UpToken> upToken(UpTokenRequestDto dto) {
        return RestfulApiResponse.success("获取上传凭证成功", ossManager.upToken(assembleUpTokenDto2UpTokenRequestArguments(dto)));
    }

    @ApiOperation("获取oss存储空间列表")
    @RequestMapping(value = "listBucket", method = RequestMethod.GET)
    public RestfulApiResponse<List<BucketInfoDto>> listBucket() {
        return RestfulApiResponse.success("获取oss存储空间列表成功", ossBucketService.listBucket());
    }

    private UpTokenRequestArguments assembleUpTokenDto2UpTokenRequestArguments(UpTokenRequestDto dto) {
        UpTokenRequestArguments arguments = new UpTokenRequestArguments();
        arguments.setExpires(dto.getExpires());
        arguments.setRelativeCallbackUrl(ossProperties.getCallback().getPath());
        return arguments;
    }
}
