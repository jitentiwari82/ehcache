package com.springboot.dto;

import java.util.ArrayList;
import java.util.List;

public class SampleData {

	public List<ReportData> buildStudents() {
		List<ReportData> reportData = new ArrayList<>();
		reportData.add(new ReportData("12345", "john", "wayne", "12", ReportType.POSITIONS));
		reportData.add(new ReportData("12346", "jack", "ryan", "13",  ReportType.TRADE));
		reportData.add(new ReportData("12347", "sam", "wilson", "14",  ReportType.POSITIONS));
		reportData.add(new ReportData("12348", "peter", "parker", "15",  ReportType.VC));
		reportData.add(new ReportData("12349", "steve", "rogers", "17",  ReportType.POSITIONS));
		reportData.add(new ReportData("12350", "mark", "meyers", "12",  ReportType.TRADE));
		reportData.add(new ReportData("12351", "mary", "jane", "16",  ReportType.TRADE));
		return reportData;
	}
}
