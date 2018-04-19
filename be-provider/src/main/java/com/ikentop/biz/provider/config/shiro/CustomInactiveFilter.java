package com.ikentop.biz.provider.config.shiro;

import com.ikentop.biz.constant.OperatorStatus;
import com.ikentop.biz.provider.constant.SessionAttr;
import com.ikentop.biz.provider.exception.AccountUnauthenticatedException;
import com.ikentop.biz.provider.model.bo.UserInfo4Session;
import com.ikentop.biz.provider.util.ShiroUtils;
import com.ikentop.framework.core.pojo.RestfulApiResponse;
import com.ikentop.framework.core.util.WebUtils;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @author : Huqiao
 * @since : 2017/11/28
 */
public class CustomInactiveFilter extends AccessControlFilter {
    public static final AccountUnauthenticatedException ACCOUNT_UNAUTHENTICATED_EXCEPTION = new AccountUnauthenticatedException();

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        Boolean flag = false;
        try {
            if (isInactive())
                flag = true;
        } catch (Exception e) {
        }
        return flag;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        saveRequest(request);
        RestfulApiResponse result = RestfulApiResponse.failure(ACCOUNT_UNAUTHENTICATED_EXCEPTION.getErrorCode().getCode(), ACCOUNT_UNAUTHENTICATED_EXCEPTION.getErrorCode().getMessage());
        WebUtils.writeJson((HttpServletResponse) response, result);
        return false;
    }

    public boolean isInactive() {
        UserInfo4Session userInfo = ShiroUtils.getSessionAttribute(SessionAttr.USER_INFO, UserInfo4Session.class);
        return null != userInfo && Objects.equals(OperatorStatus.INACTIVE.val, userInfo.getStatus());
    }
}
