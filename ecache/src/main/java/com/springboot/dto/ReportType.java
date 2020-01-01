package com.springboot.dto;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum ReportType {

	POSITIONS("position"), TRADE("trade"), VC("vc");

	private String value;
	private static final Map<String, ReportType> mapOfReportType;

	static {
		mapOfReportType = Collections.unmodifiableMap(
				Arrays.asList(ReportType.values()).stream().collect(Collectors.toMap(ReportType::value, Function.identity())));
	}

	ReportType(String value) {
		this.value = value;
	}

	@JsonValue
	public String value() {
		return value;
	}

	public static ReportType lookupValue(String value) {
		return mapOfReportType.get(value);
	}
}
