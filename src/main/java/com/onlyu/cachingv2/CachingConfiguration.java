package com.onlyu.cachingv2;

import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.annotation.*;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.*;

@Configuration
@EnableCaching
public class CachingConfiguration extends CachingConfigurerSupport
{
    @Bean
    public CacheManagerCustomizer<ConcurrentMapCacheManager> cacheManagerCustomizer() {
        return cacheManager ->
        {
            cacheManager.setAllowNullValues(false);
            cacheManager.setStoreByValue(false);
        };
    }

    /*@Bean
    @Override
    public CacheManager cacheManager()
    {
        return new EhCacheCacheManager(net.sf.ehcache.CacheManager.create());
    }*/
}
