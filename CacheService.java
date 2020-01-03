package com.springboot.service;

import com.springboot.dto.IReportData;
import com.springboot.dto.ReportData;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;


public class CacheService {

    private CacheManager cacheManager;

    public CacheService(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public void addToCache(final String key, final ReportData reportData) {
        Cache cache = cacheManager.getCache("EmirPositionReportCache");
        cache.put(key, reportData);
    }

    public void removeFromCache(final String key) {
        Cache cache = cacheManager.getCache("EmirPositionReportCache");
        cache.evict(key);
    }

    public void clear() {
        Cache cache = cacheManager.getCache("EmirPositionReportCache");
        cache.clear();
    }
}
