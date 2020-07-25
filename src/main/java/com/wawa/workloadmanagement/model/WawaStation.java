package com.wawa.workloadmanagement.model;

import java.util.List;

public class WawaStation {
	Integer stationId;
	String stationName;
	List<Employee> employess;

	public WawaStation(Integer stationId, String stationName, List<Employee> employess) {
		this.stationId = stationId;
		this.stationName = stationName;
		this.employess = employess;
	}
}