package com.tcs.poc.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.poc.app.entity.Account;
import com.tcs.poc.app.entity.Role;
import com.tcs.poc.app.entity.User;
import com.tcs.poc.app.entity.UserRegistrationStatus;
import com.tcs.poc.app.model.GetAllCustomerAccountDetailsResponse;
import com.tcs.poc.app.model.GetAllCustomerDetailsForEmployeeResponse;
import com.tcs.poc.app.model.GetAllCustomerResponse;
import com.tcs.poc.app.model.GetAllEmployeeResponse;
import com.tcs.poc.app.model.GetCustomer;
import com.tcs.poc.app.model.GetEmployee;
import com.tcs.poc.app.model.UserRegistrationResponse;
import com.tcs.poc.app.repository.AccountRepository;
import com.tcs.poc.app.repository.UserRegistrationStatusRepository;
import com.tcs.poc.app.repository.UserRepository;

@Service
public class DashboardService {

	@Autowired
	public UserRepository userRepository;

	@Autowired
	public AccountRepository accountRepository;

	public List<GetAllCustomerResponse> getCustomerList() {
		List<User> tempUser = userRepository.findAll();
		List<GetAllCustomerResponse> tempCustomer = new ArrayList<GetAllCustomerResponse>();

		for (int i = 0; i < tempUser.size(); i++) {
			if (tempUser.get(i).getRole().getRoleName().equals("ROLE_CUSTOMER")) {
				GetAllCustomerResponse tempCustomer1 = new GetAllCustomerResponse();
				tempCustomer1.setId(tempUser.get(i).getId());
				tempCustomer1.setFirstName(tempUser.get(i).getFirstName());
				tempCustomer1.setLastName(tempUser.get(i).getLastName());
				tempCustomer1.setEmailID(tempUser.get(i).getEmailID());
				tempCustomer1.setDob(tempUser.get(i).getDob());
				tempCustomer1.setRegistrationStatus(tempUser.get(i).getRegistrationStatus().getRegistrationStatusId());
				tempCustomer.add(tempCustomer1);
			}
		}
		return tempCustomer;
	}

	public List<GetAllEmployeeResponse> getEmployeeDetails() {

		List<User> tempUser = userRepository.findAll();
		List<GetAllEmployeeResponse> tempCustomer = new ArrayList<GetAllEmployeeResponse>();

		for (int i = 0; i < tempUser.size(); i++) {
			if (tempUser.get(i).getRole().getRoleName().equals("ROLE_EMPLOYEE")) {
				GetAllEmployeeResponse tempCustomer1 = new GetAllEmployeeResponse();
				tempCustomer1.setId(tempUser.get(i).getId());
				tempCustomer1.setFirstName(tempUser.get(i).getFirstName());
				tempCustomer1.setLastName(tempUser.get(i).getLastName());
				tempCustomer1.setEmailID(tempUser.get(i).getEmailID());
				tempCustomer1.setDob(tempUser.get(i).getDob());
				tempCustomer1.setRegistrationStatus(tempUser.get(i).getRegistrationStatus().getRegistrationStatusId());
				tempCustomer.add(tempCustomer1);
			}
		}
		return tempCustomer;
	}

	public List<GetAllCustomerAccountDetailsResponse> getCustomerAccountDetails() {
		List<User> tempUser = userRepository.findAll();
		List<Account> tempAcc = accountRepository.findAll();
		List<GetAllCustomerAccountDetailsResponse> tempCustomer = new ArrayList<GetAllCustomerAccountDetailsResponse>();

		for (int i = 0; i < tempUser.size(); i++) {
			
			// tempUser.get(i).getRole().getRoleType().equals("Customer")

			for (int j = 0; j < tempAcc.size(); j++) {
				if (tempUser.get(i).getId() == tempAcc.get(j).getUserId()
						&& tempUser.get(i).getRole().getRoleName().equals("ROLE_CUSTOMER")) {
					GetAllCustomerAccountDetailsResponse tempCustomer1 = new GetAllCustomerAccountDetailsResponse();
					tempCustomer1.setFirstName(tempUser.get(i).getFirstName());
					tempCustomer1.setLastName(tempUser.get(i).getLastName());
					tempCustomer1.setAccountNumber(tempAcc.get(j).getAccountNumber());
					tempCustomer1.setBalance(tempAcc.get(j).getBalance());
					tempCustomer1.setAccountStatusId(tempAcc.get(j).getUserAccountStatusType().getId());
					tempCustomer1.setAccountTypeId(tempAcc.get(j).getUserAccountType().getId());
					tempCustomer.add(tempCustomer1);
				}
			}

		}
		return tempCustomer;
	}

	public List<GetAllCustomerDetailsForEmployeeResponse> getCustomerDetailsForEmployee() {
		List<User> tempUser = userRepository.findAll();
		List<Account> tempAcc = accountRepository.findAll();
		List<GetAllCustomerDetailsForEmployeeResponse> tempCustomer = new ArrayList<GetAllCustomerDetailsForEmployeeResponse>();

		for (int i = 0; i < tempUser.size(); i++) {

			for (int j = 0; j < tempAcc.size(); j++) {
				if (tempUser.get(i).getId() == tempAcc.get(j).getUserId()
						&& tempUser.get(i).getRole().getRoleName().equals("ROLE_CUSTOMER")) {
					GetAllCustomerDetailsForEmployeeResponse tempCustomer1 = new GetAllCustomerDetailsForEmployeeResponse();
					tempCustomer1.setId(tempUser.get(i).getId());
					tempCustomer1.setFirstName(tempUser.get(i).getFirstName());
					tempCustomer1.setLastName(tempUser.get(i).getLastName());
					tempCustomer1.setAccountNumber(tempAcc.get(j).getAccountNumber());
					tempCustomer1.setEmailID(tempUser.get(i).getEmailID());
					tempCustomer1.setMobileNo(tempUser.get(i).getMobileNo());
					tempCustomer1.setAccountStatusId(tempAcc.get(j).getUserAccountType().getId());
					tempCustomer.add(tempCustomer1);
				}
			}

		}
		return tempCustomer;
	}


	public GetCustomer getCustomer(String emailID) {
		User user=userRepository.findByEmailID(emailID);
		GetCustomer response=new GetCustomer();
		response.setFirstName(user.getFirstName());
		response.setLastName(user.getLastName());
		response.setEmailID(user.getEmailID());
		response.setMobileNo(user.getMobileNo());
		response.setPermanentAddress(user.getPermanentAddress());
		response.setPermanentCity(user.getPermanentCity());
		response.setPermanentState(user.getPermanentState());
		response.setPermanentZipcode(user.getPermanentZipcode());
		return response;
	}

	public GetEmployee getEmployee(String emailID) {
		User user=userRepository.findByEmailID(emailID);
		GetEmployee response=new GetEmployee();
		response.setFirstName(user.getFirstName());
		response.setLastName(user.getLastName());
		response.setEmailID(user.getEmailID());
		response.setMobileNo(user.getMobileNo());
		response.setPermanentAddress(user.getPermanentAddress());
		response.setPermanentCity(user.getPermanentCity());
		response.setPermanentState(user.getPermanentState());
		response.setPermanentZipcode(user.getPermanentZipcode());
		return response;
	}

}
