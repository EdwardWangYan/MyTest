package com.ikentop.biz.provider.config;

import com.ikentop.biz.constant.OrgTypeValue;
import com.ikentop.biz.provider.constant.SessionAttr;
import com.ikentop.biz.provider.exception.OrganizationNotFoundException;
import com.ikentop.biz.provider.model.bo.OrganizationInfo4Session;
import com.ikentop.biz.provider.model.bo.UserInfo4Session;
import com.ikentop.biz.provider.util.ShiroUtils;
import com.ikentop.biz.util.CommonUtils;
import com.ikentop.framework.core.spring.bean.BizDataInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author : tac
 * @since : 14/09/2017
 */
@Configuration
public class BeanConfiguration {

    @Bean
    @Profile({"dev", "test", "prod"})
    public BizDataInterface bizDataInterface() {
        return new BizDataInterfaceExt() {
            @Override
            public String currentUserId() {
                return getCurrentUserInfo4Session().getId();
            }

            @Override
            public String currentOrgId() {
                return getCurrentOrganizationInfo4Session().getId();
            }

            @Override
            public String currentOrgType() {
                return getCurrentOrganizationInfo4Session().getType();
            }

            protected UserInfo4Session getCurrentUserInfo4Session() {
                UserInfo4Session session = null;
                try {
                    session = ShiroUtils.getSessionAttribute(SessionAttr.USER_INFO, UserInfo4Session.class);
                } catch (Exception e) {
                    session = defaultSession();
                }
                return session;
            }

            protected OrganizationInfo4Session getCurrentOrganizationInfo4Session() {
                UserInfo4Session userInfo = getCurrentUserInfo4Session();
                if (userInfo.getOrg() == null) {
                    throw new OrganizationNotFoundException();
                }
                return userInfo.getOrg();
            }

            private UserInfo4Session defaultSession() {
                UserInfo4Session session = new UserInfo4Session();
                session.setId(CommonUtils.nullUUID());
                return session;
            }
        };
    }

    @Bean
    @Profile("ut")
    public BizDataInterface bizDataInterface4UT() {
        return new BizDataInterfaceExt() {
            @Override
            public String currentOrgType() {
                return OrgTypeValue.TEST.val;
            }

            @Override
            public String currentUserId() {
                return "tac";
            }

            @Override
            public String currentOrgId() {
                return "taccisum";
            }
        };
    }

}
