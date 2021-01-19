package com.ibm.assignment.md.api.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.assignment.md.api.Balance;

public class BalanceRowMapper<T extends Balance> implements RowMapper<T> {

	@Override
	public T mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Balance balance = new Balance();
		balance.setAccountNumber(rs.getString("accountNumber"));
		balance.setLastUpdateTimestamp(rs.getTimestamp("transactionTs"));
		balance.setBalance(rs.getDouble("balance"));

		
		return (T)balance;
	}

}
