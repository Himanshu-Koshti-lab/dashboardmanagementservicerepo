package com.tcs.poc.app.model;

import lombok.Data;

@Data
public class GetAllCustomerAccountDetailsResponse {

	private int user_id;
	private String firstName;
	private String lastName;
	private double accountNumber;
	private double balance;
	private int AccountRegStatus;
	private int accountStatusId;
	private int accountTypeId;
}
