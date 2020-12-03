package com.tcs.poc.app.model;

import java.util.Date;

import lombok.Data;

@Data
public class GetCustomer {

	private int user_id;
    private String firstName;
    private String lastName;
    private String emailID;
    private long mobileNo;
    private String permanentAddress;
    private String permanentCity;
    private String permanentState;
    private long permanentZipcode;
    
}
