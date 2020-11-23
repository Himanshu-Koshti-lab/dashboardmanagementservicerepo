package com.tcs.poc.app.model;

import lombok.Data;

@Data
public class GetAllCustomerAccountDetailsResponse {

	private String firstName;
	private String lastName;
	private double accountNumber;
	private double balance;
	private int accountStatusId;
	private int accountTypeId;
}
