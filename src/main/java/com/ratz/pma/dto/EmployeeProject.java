package com.ratz.pma.dto;

public interface EmployeeProject {

	//we need to have the property begin with get, so spring knows that this DTO needs to be used to populate with the data thats coming from the table(from our custom query)
	public String getFirstName();
	public String getLastName();
	public int getProjectCount();
	
}
