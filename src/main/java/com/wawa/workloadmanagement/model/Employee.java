package com.wawa.workloadmanagement.model;

import java.util.List;

public class Employee {
	Integer employeeId;
	List<ProductGroup> productGroups;

	public Employee(Integer employeeId) {
		this.employeeId = employeeId;
	}
}
