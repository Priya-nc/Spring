package com.wolken.bank.service;

import org.hibernate.TypeMismatchException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolken.bank.dto.AccountDto;

import com.wolken.bank.entity.AccountEntity;

import com.wolken.bank.repository.AccountRepo;


@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountRepo repo;
	
	private Logger logger=LoggerFactory.getLogger(AccountServiceImpl.class);
	public AccountDto validateAndFindByBranchName(String branchName) {
		try {
			if (branchName != null) {
				logger.info(branchName);
				AccountEntity entity=repo.findByBranchName(branchName);
				logger.info(""+entity);
				if (entity != null) {
					AccountDto dto = new AccountDto();
					BeanUtils.copyProperties(entity, dto);
					logger.info(""+dto);
					return dto;
				}
				
			}else {
				logger.info("invalid name");
				return null;
			}
			
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e.getClass());
		}
		return null;
	}
	@Override
	public String validateAndCreateAccount(AccountDto dto) {
		// TODO Auto-generated method stub
		try {
			if(dto != null) {
				logger.info(""+dto);
				AccountEntity entity = new AccountEntity();
				BeanUtils.copyProperties(dto, entity);
				logger.info(""+entity);
				repo.save(entity);
				logger.info(" data saved");
				return "data saved";
			}else {
				logger.info("object is null");
				return "data not saved";
			}
		} catch ( NullPointerException | TypeMismatchException  e) {
			
			logger.error(e.getMessage() , e.getClass().getSimpleName());
		}
		return null;
	}
	public double validateAndGetCurrentBalance(String holderName) {
		try {
			if (holderName != null) {
				logger.info(holderName);
				double entity=(double) repo.getCurrentBalance(holderName);
				logger.info(""+entity);
				
					
					return entity;
				}
				
			
			
		} catch (Exception e) {
			
			logger.error(e.getMessage(), e.getClass());
		}
		return 0;
	}
	
	@Override
	public String validateAndDeposit(AccountDto dto) {
		logger.info(""+repo.getByAccountNo((long)2));
		logger.info(""+dto);
		AccountEntity entity = new AccountEntity();
		if(dto!=null) {
		entity=repo.getByAccountNo(dto.getAccountNo());
		logger.info(""+entity);
		double total=dto.getAmount()+(repo.getByAccountNo(dto.getAccountNo())).getAmount();
		entity.setAmount(total);
		logger.info(""+entity.getAmount());
		repo.save(entity);
		return "amount deposit";}
		else {
			return null;
		}
		
	}
	
	public String validateAndWithdraw(AccountDto dto) {
		logger.info(""+repo.getByAccountNo((long)2));
		logger.info(""+dto);
		AccountEntity entity = new AccountEntity();
		if(dto!=null) {
		entity=repo.getByAccountNo(dto.getAccountNo());
		logger.info(""+entity);
		double total=repo.getByAccountNo(dto.getAccountNo()).getAmount()-dto.getAmount();
		if(total>0) {
		entity.setAmount(total);
		logger.info(""+entity.getAmount());
		repo.save(entity);
		return "amount withdraw";}
		else {
			logger.error("Enter valid amount");
		}
		}
		else {
			return null;
		}
		return null;
		
	}
	
	public String validateAccountStatus(AccountDto dto) {
		logger.info(""+repo.getByAccountNo((long)2));
		logger.info(""+dto);
		AccountEntity entity = new AccountEntity();
		if(dto!=null) {
		entity=repo.getByAccountNo(dto.getAccountNo());
		logger.info(""+entity);
		boolean total=dto.isStatus();
		
		entity.setStatus(total);
		logger.info(""+entity.getAmount());
		repo.save(entity);
		return "Account Closed";}
		else {
			logger.error("Enter valid Account Number");
		}
		
		
		return null;
		
	}
	
}
