package com.ikentop.biz.provider.exception;

import com.ikentop.biz.provider.BEErrorCode;
import com.ikentop.framework.core.exception.BizExceptionWithArguments;

/**
 * @author Huqiao
 * @since 2017/12/18
 */
public class TeamGenderLimitIsWrongException extends BizExceptionWithArguments {

    public TeamGenderLimitIsWrongException(String reason) {
        super(BEErrorCode.TEAM_GENDER_LIMIT_IS_WRONG, reason);
    }
}
