package com.ikentop.biz.provider.controller;

import com.ikentop.biz.provider.domain.oss.pojo.UploadResult;
import com.ikentop.biz.provider.model.dto.QiniuCallbackDto;
import com.ikentop.biz.provider.service.ImageRecordService;
import com.ikentop.framework.core.pojo.RestfulApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @deprecated 已弃用，请将回调api写到{@link com.ikentop.biz.provider.openapi}包下
 * @author tac
 * @since 14/11/2017
 */
@Api(description = "与回调相关的api", hidden = true)
@RestController
@RequestMapping("callback")
public class CallbackController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ImageRecordService service;

    @ApiOperation(value = "七牛云OSS回调地址")
    @RequestMapping(value = "qiniu_oss_upload", method = RequestMethod.POST)
    public RestfulApiResponse<UploadResult> upCallback(QiniuCallbackDto body) {
        logger.trace("callback success");
        logger.trace("callback body: " + body);
        return RestfulApiResponse.success("上传图片成功", service.handlerQiniuCallback(body));
    }
}
