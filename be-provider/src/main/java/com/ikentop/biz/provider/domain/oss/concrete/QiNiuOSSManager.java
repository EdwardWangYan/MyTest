package com.ikentop.biz.provider.domain.oss.concrete;

import com.ikentop.biz.provider.domain.oss.OSSManager;
import com.ikentop.biz.provider.domain.oss.OSSProperties;
import com.ikentop.biz.provider.domain.oss.pojo.UpTokenRequestArguments;
import com.ikentop.biz.model.dto.UpToken;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 七牛云OSS管理器
 *
 * @author tac
 * @since 26/10/2017
 */
@Component
@ConditionalOnProperty(name= "oss.type", havingValue = "qiniu")
public class QiNiuOSSManager implements OSSManager {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static final String TYPE = "qiniu";

    private static String callbackBody;

    @Autowired
    private OSSProperties ossProperties;
    @Autowired
    private ServerProperties serverProperties;

    @Override
    public UpToken upToken() {
        Auth auth = Auth.create(ossProperties.getAccessKey(), ossProperties.getSecretKey());
        return new UpToken(TYPE, auth.uploadToken(ossProperties.getDefaultBucket()));
    }

    @Override
    public UpToken upToken(UpTokenRequestArguments args) {
        Auth auth = Auth.create(ossProperties.getAccessKey(), ossProperties.getSecretKey());
        Long expires = getExpires(args);
        StringMap policy = new StringMap();
        String callbackUrl = buildCallbackUrl(args);

        if (StringUtils.isNotBlank(callbackUrl)) {
            String callbackBody = buildCallbackBody();
            policy.put("callbackUrl", callbackUrl);
            policy.put("callbackBody", callbackBody);
        }
        String upToken = auth.uploadToken(ossProperties.getDefaultBucket(), null, expires, policy);
        logger.trace("token expires: " + expires);
        logger.trace("upload policy: " + policy.map().toString());
        logger.trace("upload token: " + upToken);

        return new UpToken(TYPE, upToken);
    }

    Long getExpires(UpTokenRequestArguments args) {
        if (null == args.getExpires() || args.getExpires() <= 0) {
            return ossProperties.getDefaultExpires();
        }
        return args.getExpires();
    }

    String buildCallbackUrl(UpTokenRequestArguments args) {
        if (StringUtils.isBlank(ossProperties.getCallback().getHost())) {
            return null;
        }
        if (StringUtils.isBlank(args.getRelativeCallbackUrl())) {
            return null;
        }

        Integer port = ossProperties.getCallback().getPort() != null ?
                ossProperties.getCallback().getPort() :
                serverProperties.getPort();
        return ossProperties.getCallback().getHost() + ":" + port + "/" + args.getRelativeCallbackUrl();
    }

    String buildCallbackBody() {
        if (StringUtils.isNotBlank(callbackBody)) {
            return callbackBody;
        }
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", "$(fname)");
        map.put("bucket", "$(bucket)");
        map.put("key", "$(key)");
        map.put("hash", "$(etag)");
        map.put("ext", "$(x:ext)");

        StringBuilder sb = new StringBuilder();
        for (String key : map.keySet()) {
            sb.append(key);
            sb.append("=");
            sb.append(map.get(key));
            sb.append("&");
        }
        String s = sb.toString();
        callbackBody = s.substring(0, s.length() - 1);
        return callbackBody;
    }
}
