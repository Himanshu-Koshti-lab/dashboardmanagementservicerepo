package com.tcs.poc.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.poc.app.model.GetAllCustomerAccountDetailsResponse;
import com.tcs.poc.app.model.GetAllCustomerDetailsForEmployeeResponse;
import com.tcs.poc.app.model.GetAllCustomerResponse;
import com.tcs.poc.app.model.GetAllEmployeeResponse;
import com.tcs.poc.app.service.DashboardService;


@RestController
@CrossOrigin
public class DashboardController {

	@Autowired
	public DashboardService dashboarService;
	
	@GetMapping(value="/getCustomerList")
	@ResponseBody
	public List<GetAllCustomerResponse> getCustomerDetails()
	{
		List<GetAllCustomerResponse> user = dashboarService.getCustomerList();
		return user;
	}
	
	@GetMapping(value="/getEmployeeList")
	@ResponseBody
	public List<GetAllEmployeeResponse> getEmployeeDetails()
	{
		List<GetAllEmployeeResponse> user = dashboarService.getEmployeeDetails();
		return user;
	}
	
	@GetMapping(value="/Customer/accountDetails")
	@ResponseBody
	public List<GetAllCustomerAccountDetailsResponse> getCustomerAccountDetails()
	{
		List<GetAllCustomerAccountDetailsResponse> user = dashboarService.getCustomerAccountDetails();
		return user;
	}
	
	@GetMapping(value="/getCustomerDetails")
	@ResponseBody
	public List<GetAllCustomerDetailsForEmployeeResponse> getCustomerDetailsForEmployee()
	{
		List<GetAllCustomerDetailsForEmployeeResponse> user = dashboarService.getCustomerDetailsForEmployee();
		return user;
	}
	
}
