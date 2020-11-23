package com.tcs.poc.app.model;

import lombok.Data;

@Data
public class GetAllCustomerAccountDetailsForEmployeeResponse {

	private String firstName;
	private String lastName;
	private double accountNumber;
	private double balance;
	private int accountStatusId;
	private int accountTypeId;
}
