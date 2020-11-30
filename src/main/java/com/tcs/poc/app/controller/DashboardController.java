package com.tcs.poc.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.poc.app.entity.User;
import com.tcs.poc.app.model.GetAdmin;
import com.tcs.poc.app.model.GetAllCustomerAccountDetailsResponse;
import com.tcs.poc.app.model.GetAllCustomerDetailsForEmployeeResponse;
import com.tcs.poc.app.model.GetAllCustomerResponse;
import com.tcs.poc.app.model.GetAllEmployeeResponse;
import com.tcs.poc.app.model.GetCustomer;
import com.tcs.poc.app.model.GetEmployee;
import com.tcs.poc.app.model.UserRegistrationRequest;
import com.tcs.poc.app.model.UserRegistrationResponse;
import com.tcs.poc.app.service.DashboardService;
import com.tcs.poc.app.service.RegistrationService;

@RestController
//@CrossOrigin
public class DashboardController {

	@Autowired
	public DashboardService dashboarService;

	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EMPLOYEE')")
	@GetMapping(value = "/getCustomerList")
	@ResponseBody
	public List<GetAllCustomerResponse> getCustomerDetails() {
		List<GetAllCustomerResponse> user = dashboarService.getCustomerList();
		return user;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value = "/getEmployeeList")
	@ResponseBody
	public List<GetAllEmployeeResponse> getEmployeeDetails() {
		List<GetAllEmployeeResponse> user = dashboarService.getEmployeeDetails();
		return user;
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EMPLOYEE')")
	@GetMapping(value = "/accountDetails")
	@ResponseBody
	public List<GetAllCustomerAccountDetailsResponse> getCustomerAccountDetails() {
		List<GetAllCustomerAccountDetailsResponse> user = dashboarService.getCustomerAccountDetails();
		return user;
	}

	@PreAuthorize("hasRole('ROLE_EMPLOYEE')")
	@GetMapping(value = "/getCustomerDetails")
	@ResponseBody
	public List<GetAllCustomerDetailsForEmployeeResponse> getCustomerDetailsForEmployee() {
		List<GetAllCustomerDetailsForEmployeeResponse> user = dashboarService.getCustomerDetailsForEmployee();
		return user;
	}

	@PreAuthorize("hasRole('ROLE_CUSTOMER')")
	@GetMapping(value = "/getCustomer")
	@ResponseBody
	public GetCustomer getCustomer(@AuthenticationPrincipal String emailID) {
		return dashboarService.getCustomer(emailID);
	}

	@PreAuthorize("hasRole('ROLE_EMPLOYEE')")
	@GetMapping(value = "/getEmployee")
	@ResponseBody
	public GetEmployee getEmployee(@AuthenticationPrincipal String emailID) {
		return dashboarService.getEmployee(emailID);
	}

	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value = "/getAdmin")
	@ResponseBody
	public GetAdmin getAdmin(@AuthenticationPrincipal String emailID) {
		 return dashboarService.getAdmin(emailID);	
	}

}
