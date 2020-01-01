package com.springboot.dto;

public class ReportData implements IReportData {

    private static final long serialVersionUID = 1L;
    private String id;
    private String reportName;
    private String category;
    private String age;
    private ReportType reportType;

    public ReportData(String id, String reportName, String category, String age, ReportType reportType) {
        super();
        this.id = id;
        this.reportName = reportName;
        this.category = category;
        this.age = age;
        this.reportType = reportType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public ReportType getReportType() {
        return reportType;
    }

    public void setReportType(ReportType reportType) {
        this.reportType = reportType;
    }


}
