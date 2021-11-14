package com.wolken.bank.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
@ToString
public class EmployeeEntity {

	@Id
	@GenericGenerator(name =  "priya",strategy = "increment")
	@GeneratedValue(generator = "priya")
	private int id;
	private String name;
	private String designation;
	private float salary;
	private long contactNumber;
	private String email;

}
