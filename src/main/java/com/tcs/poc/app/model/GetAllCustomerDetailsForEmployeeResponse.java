package com.tcs.poc.app.model;

import lombok.Data;

@Data
public class GetAllCustomerDetailsForEmployeeResponse {

	private Integer id;
	private String firstName;
	private String lastName;
	private double accountNumber;
	private String emailID;
	private long mobileNo;
	private int accountStatusId;
}
