package com.ikentop.biz.provider.config.shiro;

import com.ikentop.biz.constant.OperatorStatus;
import com.ikentop.biz.provider.constant.SessionAttr;
import com.ikentop.biz.provider.exception.AccountUnauthenticatedException;
import com.ikentop.biz.provider.exception.OperatorIsInactiveException;
import com.ikentop.biz.provider.model.bo.UserInfo4Session;
import com.ikentop.biz.provider.util.ShiroUtils;
import com.ikentop.framework.core.pojo.RestfulApiResponse;
import com.ikentop.framework.core.util.WebUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.UserFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @author tac
 * @since 31/10/2017
 */
public class CustomUserFilter extends UserFilter {
    public static final AccountUnauthenticatedException ACCOUNT_UNAUTHENTICATED_EXCEPTION = new AccountUnauthenticatedException();
    public static final OperatorIsInactiveException OPERATOR_IS_INACTIVE_EXCEPTION = new OperatorIsInactiveException();

    // TODO: 2017/11/27 拦截器待优化
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        saveRequest(request);
        RestfulApiResponse result = RestfulApiResponse.failure(ACCOUNT_UNAUTHENTICATED_EXCEPTION.getErrorCode().getCode(), ACCOUNT_UNAUTHENTICATED_EXCEPTION.getErrorCode().getMessage());
        try {
            if (isInactive())
                result = RestfulApiResponse.failure(OPERATOR_IS_INACTIVE_EXCEPTION.getErrorCode().getCode(), OPERATOR_IS_INACTIVE_EXCEPTION.getErrorCode().getMessage());
        } catch (Exception e) {

        }
        WebUtils.writeJson((HttpServletResponse) response, result);
        return false;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        Boolean flag = false;
        if (isLoginRequest(request, response)) {
            flag = true;
        } else {
            Subject subject = getSubject(request, response);
            // If principal is not null, then the user is known and should be allowed access.
            flag = subject.getPrincipal() != null;
        }
        if (flag) {
            if (isInactive())
                flag = false;
        }
        return flag;
    }


    public boolean isInactive() {
        UserInfo4Session userInfo = ShiroUtils.getSessionAttribute(SessionAttr.USER_INFO, UserInfo4Session.class);
        return null != userInfo && Objects.equals(OperatorStatus.INACTIVE.val, userInfo.getStatus());
    }
}
