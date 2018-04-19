package com.ikentop.biz.provider.domain.payment.client;

import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayConfig;
import com.github.wxpay.sdk.WXPayConstants;
import com.github.wxpay.sdk.WXPayUtil;
import com.ikentop.biz.provider.domain.payment.exception.WxPayCertFileNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Map;

/**
 * @author tac
 * @since 08/01/2018
 */
public class CustomWXPayClient extends WXPay {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private WXPayConfig config;
    private WXPayConstants.SignType signType;
    private boolean useSandbox;

    public CustomWXPayClient(WXPayConfig config) {
        this(config, WXPayConstants.SignType.MD5);
    }

    public CustomWXPayClient(WXPayConfig config, WXPayConstants.SignType signType) {
        this(config, signType, false);
    }

    public CustomWXPayClient(WXPayConfig config, WXPayConstants.SignType signType, boolean useSandbox) {
        super(config, signType, useSandbox);
        this.config = config;
        this.signType = signType;
        this.useSandbox = useSandbox;
    }

    @Override
    public Map<String, String> fillRequestData(Map<String, String> reqData) throws Exception {
        logger.debug("---填充默认请求参数---");
        logger.debug("填充AppID");
        reqData.put("appid", this.config.getAppID());
        logger.trace("app id: {}", config.getAppID());
        logger.debug("填充商户ID");
        reqData.put("mch_id", this.config.getMchID());
        logger.trace("mch id: {}", config.getMchID());
        logger.debug("填充随机字符串");
        String nonceStr = WXPayUtil.generateNonceStr();
        reqData.put("nonce_str", nonceStr);
        logger.trace("nonce str: {}", nonceStr);
        logger.debug("指定签名类名");
        if (WXPayConstants.SignType.MD5.equals(this.signType)) {
            logger.trace("sign type: MD5");
            reqData.put("sign_type", "MD5");
        } else if (WXPayConstants.SignType.HMACSHA256.equals(this.signType)) {
            logger.trace("sign type: HMACSHA256");
            reqData.put("sign_type", "HMAC-SHA256");
        }

        logger.debug("计算签名");
        String signature = WXPayUtil.generateSignature(reqData, this.config.getKey(), this.signType);
        reqData.put("sign", signature);
        logger.trace("sign: {}", signature);
        logger.debug("---填充默认请求参数完成---");
        return reqData;
    }

    public static class SimpleWXPayConfig implements WXPayConfig {
        private String appId;
        private String mchId;
        private String appSecret;
        private byte[] certData;


        public SimpleWXPayConfig(String appId, String mchId, String appSecret, String certPath) {
            this.appId = appId;
            this.mchId = mchId;
            this.appSecret = appSecret;
            String _certPath;
            if (certPath.startsWith("classpath:")) {
                _certPath = this.getClass().getResource(certPath.substring("classpath:".length(), certPath.length())).getPath();
            } else {
                _certPath = certPath;
            }
            File file = new File(_certPath);
            InputStream certStream;
            try {
                certStream = new FileInputStream(file);
                this.certData = new byte[(int) file.length()];
                certStream.read(this.certData);
                certStream.close();
            } catch (FileNotFoundException e) {
                throw new WxPayCertFileNotFoundException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public String getAppID() {
            return appId;
        }

        @Override
        public String getMchID() {
            return mchId;
        }

        @Override
        public String getKey() {
            return appSecret;
        }

        @Override
        public InputStream getCertStream() {
            return new ByteArrayInputStream(this.certData);
        }

        @Override
        public int getHttpConnectTimeoutMs() {
            //todo::
            return 8000;
        }

        @Override
        public int getHttpReadTimeoutMs() {
            //todo::
            return 10000;
        }
    }
}
