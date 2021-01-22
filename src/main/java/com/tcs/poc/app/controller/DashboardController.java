package com.tcs.poc.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tcs.poc.app.model.AccountResponse;
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
		return user;
	}
	
	@PreAuthorize("hasRole('ROLE_EMPLOYEE')")
	@GetMapping(value = "/getCustomerDetails")
	@ResponseBody
	public List<GetAllCustomerDetailsForEmployeeResponse> getCustomerDetailsForEmployee(@RequestHeader("Authorization") String token) {
		List<GetAllCustomerDetailsForEmployeeResponse> user = dashboarService.getCustomerDetailsForEmployee(token);
		return user;
	}
	
	
//	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_EMPLOYEE')")
//	@GetMapping(value = "/allacc")
//	@ResponseBody
//	public void getCus(@RequestHeader("Authorization") String token) {
//		RestTemplate restTemplate = new RestTemplate();
//		HttpHeaders  headers = new HttpHeaders();
//		headers.set("Authorization", token);
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		HttpEntity<String> entity = new HttpEntity<String>(headers);
//		ResponseEntity<User[]> response = restTemplate.exchange("http://localhost:8081/AllUsers", HttpMethod.GET ,entity , User[].class);
//		User[] user = response.getBody();
//		List<User> list = Arrays.asList(user);
//		System.out.println(list.size());
//		System.out.println(list.get(0).getId());
//		System.out.println(user.length);
//		System.out.println(user[0].getId());		
//	}
	
	

}
