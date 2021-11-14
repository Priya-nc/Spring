package com.wolken.bank.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wolken.bank.dto.EmployeeDTO;

import com.wolken.bank.service.EmployeeService;

@RestController
public class EmployeeController {

	private Logger logger = LoggerFactory.getLogger(balanceController.class);

	@Autowired
	EmployeeService service;
	

	@PostMapping("saveEmployee")
	String save(@RequestBody EmployeeDTO dto) {
		String msg = null;
		try {
			logger.info(""+dto);
			msg=service.validateAndSave(dto);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return msg;
	}
	
	
	@GetMapping("findByName")
	EmployeeDTO getByName(@Param(value = "name") String name) {
		EmployeeDTO dto = null;
		try {
			logger.info(name);
			dto=service.validateAndFindByName(name);
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e.getClass());
		}
		
		return dto;
	}
	@GetMapping("findAll")
	List<EmployeeDTO> getAll() {
		List<EmployeeDTO> dto = null;
		try {
			
			dto=service.validateAndGetAll();
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e.getClass());
		}
		
		return dto;
	}
	@GetMapping("findByDesignation")
	EmployeeDTO getByDesignation(@Param(value = "designation") String designation) {
		EmployeeDTO dto = null;
		try {
			logger.info(designation);
			dto=service.validateAndFindByDesignation(designation);
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e.getClass());
		}
		
		return dto;
	}
	@GetMapping("findBySalary")
	EmployeeDTO getBySalary(@Param(value = "salary") double salary) {
		EmployeeDTO dto = null;
		try {
			logger.info(""+salary);
			dto=service.validateAndFindBySalary(salary);
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e.getClass());
		}
		
		return dto;
	}

}
