package com.wolken.bank.service;

import com.wolken.bank.dto.AccountDto;


public interface AccountService {
	AccountDto validateAndFindByBranchName(String branchName);

	String validateAndCreateAccount(AccountDto dto);
	double validateAndGetCurrentBalance(String holderName);
	String validateAccountStatus(AccountDto dto);
	String validateAndWithdraw(AccountDto dto);
	String validateAndDeposit(AccountDto dto);

	

	

	
}
