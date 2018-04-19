package com.ikentop.biz.provider.controller;

import com.ikentop.framework.core.pojo.RestfulApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  Huqiao
 * @since  2018/11/13
 */
@RestController
@RequestMapping(BannerController.PATH)
@Api(description = "轮播图")
public class BannerController {
    public static final String PATH = "banner";

    @ApiOperation("获取轮播图url列表")
    @RequestMapping(value = "list4url", method = RequestMethod.GET)
    public RestfulApiResponse<List<String>> list4url() {
        List<String> list = new ArrayList<>();
        list.add("banner/picture1.jpg");
        list.add("banner/picture2.jpg");
        list.add("banner/picture3.jpg");
        list.add("banner/picture4.jpg");
        return RestfulApiResponse.success("获取成功", list);
    }
}
