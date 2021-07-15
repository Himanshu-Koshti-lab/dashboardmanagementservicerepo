package com.tcs.poc.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.tcs.poc.app.model.GetAllCustomerAccountDetailsResponse;
import com.tcs.poc.app.model.GetAllCustomerDetailsForEmployeeResponse;
import com.tcs.poc.app.service.DashboardService;

@RestController
//@CrossOrigin
public class DashboardController {

	@Autowired
	public DashboardService dashboarService;

	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EMPLOYEE')")
	@GetMapping(value = "/accountDetails")
	@ResponseBody
	public List<GetAllCustomerAccountDetailsResponse> getCustomerAccountDetails(@RequestHeader("Authorization") String token) {
		List<GetAllCustomerAccountDetailsResponse> user = 
				dashboarService.getCustomerAccountDetails(token);
		System.out.println("Test bug");
		return user;
	}
	
	@PreAuthorize("hasRole('ROLE_EMPLOYEE')")
	@GetMapping(value = "/getCustomerDetails")
	@ResponseBody
	public List<GetAllCustomerDetailsForEmployeeResponse> getCustomerDetailsForEmployee(@RequestHeader("Authorization") String token) {
		List<GetAllCustomerDetailsForEmployeeResponse> user = dashboarService.getCustomerDetailsForEmployee(token);
		return user;
	}
}
