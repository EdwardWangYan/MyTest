package com.ikentop.biz.provider.domain.oss;

import com.ikentop.biz.provider.domain.oss.pojo.UpTokenRequestArguments;
import com.ikentop.biz.model.dto.UpToken;

/**
 * @author tac
 * @since 26/10/2017
 */
public interface OSSManager {
    UpToken upToken();
    UpToken upToken(UpTokenRequestArguments args);
}
