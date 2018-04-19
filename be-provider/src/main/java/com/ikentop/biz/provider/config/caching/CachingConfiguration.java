package com.ikentop.biz.provider.config.caching;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tac
 * @since 23/10/2017
 */
@Configuration
@EnableCaching
public class CachingConfiguration {

    @Bean
    public CacheManager ehcache2CacheManager(net.sf.ehcache.CacheManager ehcacheManager) {
        CacheManager bean = new CustomEhCache2Manager(ehcacheManager);
        return bean;
    }

    @Bean
    public net.sf.ehcache.CacheManager ehcacheManager(){
        net.sf.ehcache.CacheManager instance = net.sf.ehcache.CacheManager.getInstance();
        if (instance != null) {
            //这里的判断非null主要是避免spring devtools热部署时会导致
            //EhCacheManager已存在实例的问题，需要shutdown才能重新创建的问题
            //实际在生产环境（因为生产环境不存在热部署）中并不会出现此问题
            instance.shutdown();
        }
        net.sf.ehcache.CacheManager bean = new net.sf.ehcache.CacheManager(getClass().getClassLoader().getResource("ehcache.xml"));
        return bean;
    }
}
