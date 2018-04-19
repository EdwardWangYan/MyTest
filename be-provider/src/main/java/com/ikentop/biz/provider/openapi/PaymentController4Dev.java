package com.ikentop.biz.provider.openapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.ikentop.biz.constant.PaymentMethod;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.ikentop.framework.core.constant.SpringProfiles.DEV;

/**
 * @author tac
 * @since 04/01/2018
 */
@Controller
@RequestMapping(PaymentController4Dev.PATH)
@Profile(DEV)
public class PaymentController4Dev extends PaymentController {
    @GetMapping("/test/alipay4dev")
    @ApiOperation("仅供开发人员使用的api，请通过浏览器直接访问")
    public void alipayTest4Dev(HttpServletResponse response) throws IOException {
        String form = service.test(PaymentMethod.ALI_PAY);
        response.setContentType("text/html;charset=" + Charsets.UTF_8);
        response.getWriter().write(form);
        response.getWriter().flush();
        response.getWriter().close();
    }

    @GetMapping("/test/wxpay4Dev")
    @ApiOperation("仅供开发人员使用的api，请通过浏览器直接访问")
    public void wxpayTest4Dev(HttpServletResponse response) throws IOException {
        String result = service.test(PaymentMethod.WX_PAY);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> r = objectMapper.readValue(result, Map.class);

        String text = r.get("code_url");
        int width = 200;
        int height = 200;
        String format = "gif";

        Map<EncodeHintType, String> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        BitMatrix bitMatrix = null;
        try {
            bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
        } catch (WriterException e1) {
            e1.printStackTrace();
        }
        try {
            //输出二维码图片
            BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);
            response.setContentType("image/gif");
            ImageIO.write(image, format, response.getOutputStream());
            response.getOutputStream().flush();
            response.getOutputStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
