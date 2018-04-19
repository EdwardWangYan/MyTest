package com.ikentop.biz.provider.config.shiro;

import com.ikentop.biz.model.entity.Operator;
import com.ikentop.biz.provider.constant.GlobalConstant;
import com.ikentop.biz.provider.constant.SessionAttr;
import com.ikentop.biz.provider.dao.FunctionDao;
import com.ikentop.biz.provider.dao.OperatorDao;
import com.ikentop.biz.provider.dao.OrganizationDao;
import com.ikentop.biz.provider.dao.RoleDao;
import com.ikentop.biz.provider.model.bo.UserInfo4Session;
import com.ikentop.biz.provider.service.OrganizationService;
import net.sf.ehcache.config.CacheConfiguration;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;

import javax.servlet.Filter;
import java.util.*;

/**
 * @author Huqiao
 * @author tac
 * @since 2017/9/4
 */
@Configuration
@AutoConfigureAfter(CacheConfiguration.class)
public class ShiroConfiguration {
    public static final String HASH_ALGORITHM_NAME = "MD5";
    public static final int HASH_ITERATIONS = 5;

    @Bean
    @Profile({"dev", "test"})
    public ShiroFilterFactoryBean shiroFilterFactoryBean4Test(SecurityManager securityManager) {
        ShiroFilterFactoryBean bean = shiroFactoryBean(securityManager);
        Map<String, String> chain = new LinkedHashMap<>();
        List<String> anonUrl = new ArrayList<>();
        addDefaultAnonUrl(anonUrl);
        addAnonUrl4Test(anonUrl);
        for (String url : anonUrl) {
            chain.put(url, "anon");
        }
        chain.put("/logout", "logout");
        chain.put("/operator/active", "c_inactive");
        chain.put("/**", "c_user");

        bean.setLoginUrl("/login");
        // 登录成功后要跳转的链接
        bean.setSuccessUrl("/index");
        // 未授权界面;
        bean.setUnauthorizedUrl("/403");
        bean.setFilterChainDefinitionMap(chain);
        return bean;
    }
    @Bean
    @Profile("prod")
    public ShiroFilterFactoryBean shiroFilterFactoryBean4Prod(SecurityManager securityManager) {
        ShiroFilterFactoryBean bean = shiroFactoryBean(securityManager);
        Map<String, String> chain = new LinkedHashMap<>();
        List<String> anonUrl = new ArrayList<>();
        addDefaultAnonUrl(anonUrl);
        for (String url : anonUrl) {
            chain.put(url, "anon");
        }
        chain.put("/operator/active", "c_inactive");
        chain.put("/**", "c_user");
        bean.setFilterChainDefinitionMap(chain);
        return bean;
    }

    public static ShiroFilterFactoryBean shiroFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);

        bean.getFilters().put("c_user", new CustomUserFilter());
        bean.getFilters().put("c_inactive", new CustomInactiveFilter());

        bean.setLoginUrl(null);
        bean.setSuccessUrl(null);
        bean.setUnauthorizedUrl("/operator/unauthorized");
        return bean;
    }

    @Bean
    @Profile({"dev", "test", "prod"})
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator bean = new DefaultAdvisorAutoProxyCreator();
        bean.setProxyTargetClass(true);
        return bean;
    }

    @Bean
    @Profile({"dev", "test", "prod"})
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

    @Bean
    public SecurityManager securityManager(
            Realm realm,
            SessionManager sessionManager,
            Authenticator authenticator,
            RememberMeManager rememberMeManager,
            CacheManager cacheManager) {
        DefaultWebSecurityManager bean = new DefaultWebSecurityManager();
        bean.setRealm(realm);
        bean.setSessionManager(sessionManager);
        bean.setAuthenticator(authenticator);
        bean.setRememberMeManager(rememberMeManager);
        bean.setCacheManager(cacheManager);
        SecurityUtils.setSecurityManager(bean);
        return bean;
    }

    @Bean
    @Profile({"dev", "test", "prod"})
    public Realm customerRealm(OperatorDao operatorDao, CredentialsMatcher credentialsMatcher, FunctionDao functionDao, RoleDao roleDao) {
        CustomRealm bean = new CustomRealm(operatorDao, functionDao, roleDao);
        bean.setCredentialsMatcher(credentialsMatcher);
        return bean;
    }

    @Bean
    @Profile("ut")
    public Realm realm4UT(CredentialsMatcher credentialsMatcher) {
        AuthorizingRealm bean = new Realm4UT();
        bean.setCredentialsMatcher(credentialsMatcher);
        return bean;
    }

    @Bean
    public CredentialsMatcher credentialsMatcher() {
        HashedCredentialsMatcher bean = new HashedCredentialsMatcher();
        bean.setHashAlgorithmName(HASH_ALGORITHM_NAME);
        bean.setHashIterations(HASH_ITERATIONS);
        bean.setStoredCredentialsHexEncoded(true);
        return bean;
    }

    @Bean
    public SessionManager sessionManager() {
        DefaultWebSessionManager bean = new DefaultWebSessionManager();
        bean.setGlobalSessionTimeout(GlobalConstant.SESSION_TIMEOUT_MILLISECONDS);
        return bean;
    }

    @Bean
    public Authenticator authenticator(Realm realm) {
        ModularRealmAuthenticator bean = new ModularRealmAuthenticator();
        bean.setRealms(Arrays.asList(realm));
        //添加监听器将在spring的ContextRefreshedEvent中进行
        return bean;
    }

    /**
     * ![important]
     * 此处使用spring的事件监听来为shiro添加监听器，是为了避免shiro对业务bean的依赖
     * 导致相关bean的加载时机过早而无法被代理，进而引起如`注解式事务`之类由spring通过
     * 代理实现的功能无效化的问题
     */
    @org.springframework.context.event.EventListener
    public void onContextInitOrRefresh(ContextRefreshedEvent event) {
        ModularRealmAuthenticator authenticator = event.getApplicationContext().getBean(ModularRealmAuthenticator.class);
        OrganizationService organizationService = event.getApplicationContext().getBean(OrganizationService.class);

        List<AuthenticationListener> listeners = new ArrayList<>();
        listeners.add(new AuthenticationListener() {
            @Override
            public void onSuccess(AuthenticationToken token, AuthenticationInfo info) {
                Operator operator = (Operator) info.getPrincipals().getPrimaryPrincipal();
                UserInfo4Session userInfo = convert(operator);
                SecurityUtils.getSubject().getSession().setAttribute(SessionAttr.USER_INFO.getKey(), userInfo);
            }

            private UserInfo4Session convert(Operator operator) {
                UserInfo4Session userInfo = new UserInfo4Session();
                userInfo.setId(operator.getPk());
                userInfo.setUsername(operator.getLoginName());
                userInfo.setStatus(operator.getStatus());
                userInfo.setOrg(organizationService.getOrg4UserInfo(operator.getOrgId()));
                //add more info here
                return userInfo;
            }

            @Override
            public void onFailure(AuthenticationToken token, AuthenticationException ae) {
                //do nothing
            }

            @Override
            public void onLogout(PrincipalCollection principals) {
                //do nothing
            }
        });
        authenticator.setAuthenticationListeners(listeners);
    }

    @Bean
    public Cookie cookie() {
        SimpleCookie bean = new SimpleCookie();
        bean.setName("REMEMBER_ME");
        bean.setHttpOnly(true);
        bean.setMaxAge(2592000);    //30天
        return bean;
    }

    /**
     *  更换cookie策略  cookie对象;
     * @return
     */
    @Bean
    public SimpleCookie rememberMeCookie() {
        // 这个参数是cookie的名称，对应前端的checkbox 的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        // <!-- 记住我cookie生效时间30天 ,单位秒;-->
        simpleCookie.setMaxAge(259200);
        return simpleCookie;
    }
    /**
     * cookie管理对象;
     * @return
     */
    @Bean
    public CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        return cookieRememberMeManager;
    }


    /*@Bean   被更换的cookie策略
    public RememberMeManager rememberMeManager(Cookie cookie) {
        CookieRememberMeManager bean = new CookieRememberMeManager();
        bean.setCookie(cookie);
        return bean;
    }*/

    @Bean
    public CacheManager cacheManager(net.sf.ehcache.CacheManager ehcacheManager) {
        EhCacheManager bean = new EhCacheManager();
        bean.setCacheManager(ehcacheManager);
        return bean;
    }

    private static void addDefaultAnonUrl(List<String> anonUrl) {
        anonUrl.add("/login");
        anonUrl.add("/operator/login");
        anonUrl.add("/login");
        anonUrl.add("/operator/login4dev");
        anonUrl.add("/operator/logout");
        anonUrl.add("/operator/retrievePassword");
        anonUrl.add("/banner/**");
        //静态资源访问控制权限
        anonUrl.add("/assets/**");
       /* anonUrl.add("/assets/auth/**");
        anonUrl.add("/assets/global/**");
        anonUrl.add("/assets/global/css/**");
        anonUrl.add("/assets/global/plugins/**");
        anonUrl.add("/assets/global/scripts/**");
        anonUrl.add("/assets/system/**");
        anonUrl.add("/assets/system/dep/**");
        anonUrl.add("/assets/system/function/**");
        anonUrl.add("/assets/system/scheduler/**");*/
        anonUrl.add("/payment/**");
        anonUrl.add("/cnArea/**");
        anonUrl.add("/callback/**");
        anonUrl.add("/openapi/**");
        anonUrl.add("/data/**");
        anonUrl.add("/workOrder/**");
        anonUrl.add("/organization/register");
        anonUrl.add("/imageCode/**");
        anonUrl.add("/sms/**");

        anonUrl.add("/pc/**");      //给pc端访问的接口全部不需要权限控制
    }

    private static void addAnonUrl4Test(List<String> anonUrl) {
        //swagger
        anonUrl.add("/webjars/**");
        anonUrl.add("/v2/**");
        anonUrl.add("/swagger*");
        anonUrl.add("/swagger*/**");

        //spring boot actuator
        anonUrl.add("/loggers/*");
        anonUrl.add("/loggers*");
        anonUrl.add("/health");
        anonUrl.add("/metrics/*");
        anonUrl.add("/metrics*");
        anonUrl.add("/info");
        anonUrl.add("/trace");
        anonUrl.add("/dump");
        anonUrl.add("/auditevents");
        anonUrl.add("/configprops");
        anonUrl.add("/logfile");
        anonUrl.add("/env/*");
        anonUrl.add("/env*");
        anonUrl.add("/mappings");
        anonUrl.add("/autoconfig");
        anonUrl.add("/heapdump*");
        anonUrl.add("/beans");
        anonUrl.add("/shutdown");
    }
}
