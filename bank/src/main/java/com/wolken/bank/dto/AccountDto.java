package com.wolken.bank.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AccountDto {

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
