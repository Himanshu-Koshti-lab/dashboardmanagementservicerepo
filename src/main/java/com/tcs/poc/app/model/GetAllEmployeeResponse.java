package com.tcs.poc.app.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class GetAllEmployeeResponse {

	private int id;
	private String firstName;
	private String lastName;
	private String emailID;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dob;
	private int registrationStatus;
}
