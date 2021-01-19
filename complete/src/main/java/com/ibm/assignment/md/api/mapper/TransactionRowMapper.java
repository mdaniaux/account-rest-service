package com.ibm.assignment.md.api.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.assignment.md.api.Account.OperationType;
import com.ibm.assignment.md.api.Balance;
import com.ibm.assignment.md.api.Transaction;

public class TransactionRowMapper<T extends Transaction> implements RowMapper<T> {

	private Double zero = (double) 0;
	
	@Override
	public T mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Transaction transaction = new Transaction();
		transaction.setAccountNumber(rs.getString("accountNumber"));
		transaction.setTransactionTs(rs.getTimestamp("transactionTs"));
		
		Double deposit = rs.getDouble("deposit");
		
		if ( (deposit == null) || (deposit.equals(zero)) ) {

			Double withdraw = rs.getDouble("withdraw");
			
			transaction.setType(OperationType.WITHDRAW.getType());
			transaction.setAmount(withdraw);
			
		} else {
			
			transaction.setType(OperationType.DEPOSIT.getType());
			transaction.setAmount(deposit);
		}
		
		return (T)transaction;
	}

}
