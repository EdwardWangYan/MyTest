package com.ikentop.biz.provider.domain.oss.concrete;

import com.ikentop.biz.provider.domain.oss.OSSManager;
import com.ikentop.biz.provider.domain.oss.pojo.UpTokenRequestArguments;
import com.ikentop.biz.model.dto.UpToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * @author tac
 * @since 26/10/2017
 */
@Component
@ConditionalOnProperty(name = "oss.type", havingValue = "dummy", matchIfMissing = true)
public class DummyOSSManager implements OSSManager {
    private Logger logger = LoggerFactory.getLogger(DummyOSSManager.class);
    public static final String TYPE = null;

    @Override
    public UpToken upToken() {
        logger.warn("未指定具体的OSS，将无法获取上传凭证");
        return new UpToken(TYPE, null);
    }

    @Override
    public UpToken upToken(UpTokenRequestArguments args) {
        logger.warn("未指定具体的OSS，将无法获取上传凭证");
        return new UpToken(TYPE, null);
    }
}
