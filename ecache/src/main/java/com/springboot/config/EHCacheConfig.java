package com.springboot.config;

import net.sf.ehcache.config.CacheConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Ehcache Configuration
 */
@Configuration
@EnableCaching
public class EHCacheConfig extends CachingConfigurerSupport {
    @Value("${server.port}")
    String port;
    @Value("${ehcache.eviction.policy}")
    String ehcacheEvictionPolicy;

    @Value("${ehcache.max.local.heap}")
    String maxEntriesLocalHeap;

    @Value("${ehcache.time.to.live}")
    String ttl;


    @Bean
    public net.sf.ehcache.CacheManager ehCacheManager() {
        CacheConfiguration emirPositionReportCache = new CacheConfiguration();
        emirPositionReportCache.setName("EmirPositionReportCache");
        emirPositionReportCache.setMemoryStoreEvictionPolicy(ehcacheEvictionPolicy);
        emirPositionReportCache.setMaxEntriesLocalHeap(Long.valueOf(maxEntriesLocalHeap));
        emirPositionReportCache.setTimeToLiveSeconds(Long.valueOf(ttl).longValue());

        CacheConfiguration emirTradeReportCache = new CacheConfiguration();
        emirTradeReportCache.setName("EmirTradeReportCache");
        emirTradeReportCache.setMemoryStoreEvictionPolicy("LRU");
        emirTradeReportCache.setMaxEntriesLocalHeap(1000);
        emirTradeReportCache.setTimeToLiveSeconds(20);

        net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();
        config.addCache(emirPositionReportCache);
        config.addCache(emirTradeReportCache);
        return net.sf.ehcache.CacheManager.newInstance(config);
    }

    @Bean
    @Override
    public CacheManager cacheManager() {
        return new EhCacheCacheManager(ehCacheManager());
    }
}