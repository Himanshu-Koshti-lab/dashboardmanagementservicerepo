package com.tcs.poc.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tcs.poc.app.model.AccountResponse;
import com.tcs.poc.app.model.GetAllCustomerAccountDetailsResponse;
import com.tcs.poc.app.model.GetAllCustomerDetailsForEmployeeResponse;
import com.tcs.poc.app.model.UserResponse;
import com.tcs.poc.app.utils.BankConstants;

@Service
public class DashboardService {


	public List<GetAllCustomerAccountDetailsResponse> getCustomerAccountDetails(String token) {
//		List<User> tempUser = userRepository.findAll();
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders  headers = new HttpHeaders();
		headers.set("Authorization", token);
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<UserResponse[]> responseU = restTemplate.exchange(BankConstants.USER_API_URL+"/AllUsers", HttpMethod.GET ,entity , UserResponse[].class);
		UserResponse[] user = responseU.getBody();
		List<UserResponse> tempUser = Arrays.asList(user);
		//List<Account> tempAcc = accountRepository.findAll();
		ResponseEntity<AccountResponse[]> responseA = restTemplate.exchange(BankConstants.ACCOUNT_API_URL+"/AllAccs", HttpMethod.GET ,entity , AccountResponse[].class);
		AccountResponse[] account = responseA.getBody();
		List<AccountResponse> tempAcc = Arrays.asList(account);
		//List<Account> tempAcc = Arrays.asList(account);
		
		List<GetAllCustomerAccountDetailsResponse> tempCustomer = new ArrayList<GetAllCustomerAccountDetailsResponse>();

		for (int i = 0; i < tempUser.size(); i++) {
			for (int j = 0; j < tempAcc.size(); j++) {
				if (tempUser.get(i).getUser_id() == tempAcc.get(j).getUserId()
						&& tempUser.get(i).getRole().equals("CUSTOMER")) {
					GetAllCustomerAccountDetailsResponse tempCustomer1 = new GetAllCustomerAccountDetailsResponse();
					tempCustomer1.setAccountregstatus(tempAcc.get(j).getAccountRegStatusType());
					tempCustomer1.setUser_id(tempUser.get(i).getUser_id());
					tempCustomer1.setFirstName(tempUser.get(i).getFirstName());
					tempCustomer1.setLastName(tempUser.get(i).getLastName());
					tempCustomer1.setAccountNumber(tempAcc.get(j).getAccountNumber());
					tempCustomer1.setBalance(tempAcc.get(j).getBalance());
					tempCustomer1.setAccountStatusId(tempAcc.get(j).getUserAccountStatusType());
					tempCustomer1.setAccounttype(tempAcc.get(j).getUserAccountType());
					tempCustomer.add(tempCustomer1);
				}
			}

		}
		return tempCustomer;
	}

	public List<GetAllCustomerDetailsForEmployeeResponse> getCustomerDetailsForEmployee(String token) {
//		List<User> tempUser = userRepository.findAll();
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders  headers = new HttpHeaders();
		headers.set("Authorization", token);
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<UserResponse[]> responseU = restTemplate.exchange(BankConstants.USER_API_URL+"/AllUsers", HttpMethod.GET ,entity , UserResponse[].class);
		UserResponse[] user = responseU.getBody();
		List<UserResponse> tempUser = Arrays.asList(user);
		//List<Account> tempAcc = accountRepository.findAll();
		ResponseEntity<AccountResponse[]> responseA = restTemplate.exchange(BankConstants.ACCOUNT_API_URL+"/AllAccs", HttpMethod.GET ,entity , AccountResponse[].class);
		AccountResponse[] account = responseA.getBody();
		List<AccountResponse> tempAcc = Arrays.asList(account);
		List<GetAllCustomerDetailsForEmployeeResponse> tempCustomer = new ArrayList<GetAllCustomerDetailsForEmployeeResponse>();

		for (int i = 0; i < tempUser.size(); i++) {

			for (int j = 0; j < tempAcc.size(); j++) {
				if (tempUser.get(i).getUser_id() == tempAcc.get(j).getUserId()
						&& tempUser.get(i).getRole().equals("CUSTOMER")) {
					GetAllCustomerDetailsForEmployeeResponse tempCustomer1 = new GetAllCustomerDetailsForEmployeeResponse();
					tempCustomer1.setId(tempUser.get(i).getUser_id());
					tempCustomer1.setFirstName(tempUser.get(i).getFirstName());
					tempCustomer1.setLastName(tempUser.get(i).getLastName());
					tempCustomer1.setAccountNumber(tempAcc.get(j).getAccountNumber());
					tempCustomer1.setEmailID(tempUser.get(i).getEmailID());
					tempCustomer1.setMobileNo(tempUser.get(i).getMobileNo());
					tempCustomer1.setAccountStatusId(tempAcc.get(j).getUserAccountType());
					tempCustomer.add(tempCustomer1);
				}
			}

		}
		return tempCustomer;
	}


}
