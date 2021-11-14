package com.wolken.bank.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import com.wolken.bank.dto.EmployeeDTO;
import com.wolken.bank.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class balanceController {
	private Logger logger=LoggerFactory.getLogger(balanceController.class);
	
	@Autowired
	EmployeeService service;
	
	@GetMapping("get")
	List<EmployeeDTO> getBalance() {
		logger.info("inside getBalance");
		List<EmployeeDTO> list=service.validateAndGetAll();
		logger.info(""+list);
		return list;
		
	}
	@GetMapping("get100")
	String getBalance1() {
		logger.info("inside getBalance");
		return "Balance=100";
		
	}
	@GetMapping("send")
	String sendBalance() {
		logger.info("inside sendBalance");
		return "sending";
	}
	@GetMapping("send100")
	String sendBalance1() {
		logger.info("inside sendBalance");
		return "sending 100";
		
	}
	

}
