package com.wolken.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wolken.bank.entity.EmployeeEntity;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Integer>{
	
	EmployeeEntity findByName(String name);
	List<EmployeeEntity> findAll();
	EmployeeEntity findByDesignation(String designation);
	EmployeeEntity findBySalary(double salary);
	
}
