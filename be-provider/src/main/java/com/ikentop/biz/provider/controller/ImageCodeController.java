package com.ikentop.biz.provider.controller;

import com.ikentop.biz.provider.util.ImageCodeUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
@RequestMapping(ImageCodeController.PATH)
@Api(description = "与图片验证码相关的api")
public class ImageCodeController {
    public static final String PATH = "imageCode";

    protected static final String IMAGE_CODE_SESSION = "imageCode4Session";
    private static final String IMAGE_FORMAT_NAME = "png";

    @ApiOperation("获取图片验证码")
    @RequestMapping(value = "getImageCode", method = RequestMethod.GET)
    public void getImageCode(HttpServletRequest req, HttpServletResponse res)
            throws IOException {
        HttpSession session = req.getSession();
        // 禁止图像缓存。
        res.setHeader("Pragma", "no-cache");
        res.setHeader("Cache-Control", "no-cache");
        res.setDateHeader("Expires", 0);
        res.setContentType("image/jpeg");
        // 将图像输出到Servlet输出流中。
        Object[] objs = ImageCodeUtils.createImage();
        BufferedImage image = (BufferedImage) objs[1];
        session.setAttribute(IMAGE_CODE_SESSION, objs[0]);
        ImageIO.write(image, IMAGE_FORMAT_NAME, res.getOutputStream());
    }
}

