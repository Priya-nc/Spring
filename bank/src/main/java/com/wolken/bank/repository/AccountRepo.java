package com.wolken.bank.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.wolken.bank.entity.AccountEntity;


public interface AccountRepo extends JpaRepository<AccountEntity, Integer>{
	
	
	AccountEntity findByBranchName(String BranchName);
	@Query(value="select amount from AccountEntity where holderName=?1")
	double getCurrentBalance(String holderName);
	AccountEntity getByAccountNo(long accountNo);
	
	
	
	
	
}
