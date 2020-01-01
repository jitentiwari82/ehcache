package com.springboot.task;

import com.springboot.dto.IReportData;

public class EhCacheLifeCycleManager {


    //@CacheEvict(value = "e", allEntries = true)
    public void refreshAllReports() {

    }

    //@CachePut(value = "", key = "#key.name", unless = "#result==null")
    public IReportData updateCache(IReportData reportData) {
        System.out.println("<!----------update --------->");

        return null;
    }

}
