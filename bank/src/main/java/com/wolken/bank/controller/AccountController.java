package com.wolken.bank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wolken.bank.dto.AccountDto;
import com.wolken.bank.service.AccountService;




@RestController
public class AccountController {

	private Logger logger = LoggerFactory.getLogger(AccountController.class);

	@Autowired(required=true)
     AccountService service;

	@GetMapping("findByHolderName")
	AccountDto getByName(@Param(value = "branchName") String branchName) {
		//AccountEntity entity=new AccountEntity() ;
		AccountDto dto = null ;
		logger.info("dto  "+dto);
		try {
			logger.info("name"+branchName);
			dto = service.validateAndFindByBranchName(branchName);
			logger.info("dto  "+dto);
			
		
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e.getClass());
		}
		return dto;
		
		
	}
	@GetMapping("getCurrentBalance")
	double getCurrentBalance(@Param(value = "holderName") String holderName) {
		
		double dto=0;
		logger.info("dto  "+dto);
		
		try {
			logger.info("name"+holderName);
			dto = service.validateAndGetCurrentBalance(holderName);
			logger.info("dto  "+dto);
			
		
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e.getClass());
		}
		return dto;
		
		
	}
	
	@PostMapping("createAccount")
	String save(@RequestBody AccountDto dto) {
		String msg = null;
		try {
			logger.info(""+dto);
			msg=service.validateAndCreateAccount(dto);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return msg;
	}
	
	@PostMapping("depositAmount")
	String updateAmount(@RequestBody AccountDto dto) {
		String msg = null;
		try {
			logger.info("inside Deposit amount "+dto);
			
			msg=service.validateAndDeposit(dto);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return msg;
	}
	
	@PostMapping("withdrawAmount")
	String withdrawAmount(@RequestBody AccountDto dto) {
		String msg = null;
		try {
			logger.info("inside Withdraw amount"+dto);
			
			msg=service.validateAndWithdraw(dto);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return msg;
	}
	
	@PostMapping("closeAccount")
	String closeAccount(@RequestBody AccountDto dto) {
		String msg = null;
		try {
			logger.info("dto"+dto);
			
			msg=service.validateAccountStatus(dto);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return msg;
	}
	
	



}
