package com.ibm.assignment.md.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.assignment.md.api.Balance;
import com.ibm.assignment.md.api.Transaction;
import com.ibm.assignment.md.service.AccountService;

@RestController
@RequestMapping(produces = {"application/json"})
public class AccountNumberController {

	private static final Logger logger = LoggerFactory.getLogger(AccountNumberController.class);
	
	private final AccountService<?> accountservice;
	
	
	@Autowired
	public AccountNumberController(AccountService<?> accountservice) {
		//super();
		this.accountservice = accountservice;
	}
	
	@ResponseBody
	@RequestMapping(value="/accountNumber", method = RequestMethod.GET, params = {"accountNumber"})
	public Balance getBalance(final @RequestParam(name = "accountNumber", required = true) String accountNumber) throws IOException {
		
		logger.info("accountNumber :" + accountNumber);

		Balance balance = accountservice.getBalance(accountNumber);
		
		return balance;
	}

	@ResponseBody
	@RequestMapping(value="/accountNumber", method = RequestMethod.GET, params = {"accountNumber", "timeRange"})
	public List<Transaction> getTransactions(final @RequestParam(name = "accountNumber", required = true) String accountNumber,
			final @RequestParam(name = "timeRange", required = true, defaultValue = "Today") String timeRange,
			final @RequestParam(name = "start" , required = false) Optional<String> start,
			final @RequestParam(name = "end", required = false) Optional<String> end,
			final @RequestParam(name = "operationType", required = false ) Optional<String> operationType) throws IOException {
		
		logger.info("accountNumber :" + accountNumber);
		logger.info("timeRange 	   :" + timeRange);
		logger.info("start         :" + start);
		logger.info("end           :" + end);
		logger.info("operationType :" + operationType);

		
		List<Transaction> operations;
		try {
			operations = accountservice.getTransactions(accountNumber, timeRange, start, end, operationType);
		} catch (Exception e) {
			throw new IOException(e);
		}
		
		return operations;
	}
	
}
