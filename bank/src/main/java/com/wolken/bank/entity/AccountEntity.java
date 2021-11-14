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

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name="account_entity")

public class AccountEntity {
    @Id
    @GenericGenerator(name =  "priya",strategy = "increment")
	@GeneratedValue(generator = "priya")
	private int id;
	private long accountNo;
	private String holderName;
	private long contactNo;
	private String emailId;
	private String address;
	private String branchName;
	private String typeOfAccount;
	private double amount;
	private boolean status;
	private String nominee;
	private String gender;
	private String dob;
	

}
