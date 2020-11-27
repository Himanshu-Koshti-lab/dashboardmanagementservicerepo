package com.tcs.poc.app.model;

import lombok.Data;

@Data
public class GetAdmin {

	private String firstName;
    private String lastName;
    private String emailID;
    private long mobileNo;
    private String permanentAddress;
    private String permanentCity;
    private String permanentState;
    private long permanentZipcode;
}
