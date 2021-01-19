package com.ibm.assignment.md.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.assignment.md.api.Account;
import com.ibm.assignment.md.api.Balance;
import com.ibm.assignment.md.api.Transaction;
import com.ibm.assignment.md.repo.AccountRepository;
import com.ibm.assignment.md.utils.AccountDateUtils;

@Service
public class AccountService<T> {

	private static final Logger logger = LoggerFactory.getLogger(AccountService.class);
	

	
	private AccountRepository accountRepository;
	
	@Autowired
	public AccountService(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	public Balance getBalance(String accountNumber) {
		
		long enterTS = System.currentTimeMillis();
		
		logger.info("Entering getBalance ("+accountNumber+") :" + enterTS); 
	
		
		Balance balance = accountRepository.getBalance(accountNumber);
		
		long exitTS = System.currentTimeMillis();
		
		logger.info("Exiting getBalance ("+accountNumber+") took :" + (exitTS - enterTS) + " ms"); 

		return balance;
	}

	public List<Transaction> getTransactions(String accountNumber, 
											String timeRange, 
											Optional<String> start,
											Optional<String> end, 
											Optional<String> operationType) throws Exception {

		long enterTS = System.currentTimeMillis();
		
		logger.info("Entering getTransactions ("+accountNumber+") :" + enterTS); 
	
		try {
			validateAccount(accountNumber);
			validateTimeRange(timeRange, start, end);
			validateOperationType(operationType);
		} catch (Exception e) {
			logger.error("validation problem " + e.getMessage());
			throw e;
		}
		
		long exitTS = System.currentTimeMillis();
		
		logger.info("Exiting getTransactions ("+accountNumber+") took :" + (exitTS - enterTS) + " ms"); 

		List<Transaction> transactions = accountRepository.getTransactions(accountNumber, timeRange, start, end, operationType);
		
		return transactions;
	}

	private void validateAccount(String accountNumber) {
		
		// check the account is valid
		// TODO
	}

	private void validateTimeRange(String timeRange, Optional<String> start, Optional<String> end) throws Exception {
		
		// if timeRange == FROM_TO then start mandatory
		
		if (Account.TimeRange.FROM_TO.getRange().equals(timeRange) ) {
 			
 			// Check at least start or end not empty
 			if (start.isPresent()) {
 				
 				// Ok start is set
 				try {

 					//Date startDate = formatTsZ.parse("2021-01-01T05:00:00.000Z");
 					Date startDate = AccountDateUtils.getTimestampFormat().parse(start.get());
 					
 				} catch (ParseException e) {
 					throw new Exception("Invalid format for start " + start.get() + " should be like this " + AccountDateUtils.getTimestampFormatString());
 				}
 				
 			} else {
 				
 				// end is empty
 				
 				if (end.isPresent()) {
 	 				
 	 				// Ok end is set
 	 				try {

 	 					//Date startDate = formatTsZ.parse("2021-01-01T05:00:00.000Z");
 	 					Date endDate = AccountDateUtils.getTimestampFormat().parse(end.get());
 	 					
 	 				} catch (ParseException e) {
 	 					throw new Exception("Invalid format for end " + end.get() + " should be like this " + AccountDateUtils.getTimestampFormatString());
 	 				}

 	 				
 	 			} else {
 	 				
 	 				throw new Exception("with 'From To', 'start date' and/or 'end date' has to be filled !");
 	 			}
 				
 				
 			}
 			
 		}
		
	}

	private void validateOperationType(Optional<String> operationType) {
		
		// if operationType not empty then values are DEPOSIT or WITHDRAW only
		
		// TODO
		
	}
	
}
