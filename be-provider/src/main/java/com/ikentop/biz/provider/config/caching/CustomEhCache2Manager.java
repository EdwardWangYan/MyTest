package com.ikentop.biz.provider.config.caching;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCache;
import org.springframework.cache.ehcache.EhCacheCacheManager;

/**
 * @author tac
 * @since 23/10/2017
 */
public class CustomEhCache2Manager extends EhCacheCacheManager {
    public CustomEhCache2Manager(CacheManager cacheManager) {
        super(cacheManager);
    }

    @Override
    protected Cache getMissingCache(String name) {
        Ehcache ehcache = getCacheManager().getEhcache(name);
        if (ehcache != null) {
            return new EhCacheCache(ehcache);
        } else {
            getCacheManager().addCache(name);
            return new EhCacheCache(getCacheManager().getEhcache(name));
        }
    }
}
