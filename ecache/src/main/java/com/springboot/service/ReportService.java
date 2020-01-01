package com.springboot.service;

import com.springboot.dto.IReportData;
import com.springboot.dto.ReportData;
import com.springboot.dto.ReportType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class ReportService {

    @Autowired
    CacheManager ehCacheManager;
    @Value("ehcache.enabled")
    String isEhcacheEnabled;

   // @CacheEvict(value = "EmirPositionReportCache", key = "'ReportInCache'+#reportId", beforeInvocation = true)
    @Cacheable(value = "EmirPositionReportCache", key = "'ReportInCache'+#reportId")
    public Optional<ReportData> fetchReport(String reportId) throws InterruptedException {
        //Thread.sleep(4000);
        return Arrays
                .asList(new ReportData("19VC21", "John", "Wayne", "11", ReportType.VC),
                        new ReportData("19VC22", "Mary", "Jane", "11", ReportType.TRADE),
                        new ReportData("19VC23", "Peter", "Parker", "11", ReportType.POSITIONS))
                .stream().filter(t -> t.getId().equalsIgnoreCase(reportId)).findFirst();
    }
}
