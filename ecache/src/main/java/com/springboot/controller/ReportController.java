package com.springboot.controller;

import com.springboot.dto.IReportData;
import com.springboot.dto.ReportData;
import com.springboot.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping
    public ResponseEntity<ReportData> fetchReport(@RequestParam(name = "reportId") String reportId) throws InterruptedException {
        return new ResponseEntity<>(reportService.fetchReport(reportId).get(), HttpStatus.OK);
    }
}