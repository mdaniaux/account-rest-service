package com.ibm.assignment.md.api;

import java.sql.Timestamp;

public class Transaction {

	// there are *two* types of transactions: 1. `DEPOSIT` and 2. `WITHDRAW`. 

	// {"accountNumber": "abc", "transactionTs": "2020-01-03T01:02:03.8Z", "type": "DEPOSIT", "amount": 89.1}
	// {"accountNumber": "abc", "transactionTs": "2020-01-03T01:02:03.8Z", "type": "WITHDRAW", "amount": 89.1}

	private String accountNumber;
	private Timestamp transactionTs;
	private String type;
	private Double amount;
	
	
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Timestamp getTransactionTs() {
		return transactionTs;
	}
	public void setTransactionTs(Timestamp timestamp) {
		this.transactionTs = timestamp;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double deposit) {
		this.amount = deposit;
	}

	
}
