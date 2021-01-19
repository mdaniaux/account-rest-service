package com.ibm.assignment.md.repo;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ibm.assignment.md.api.Account;
import com.ibm.assignment.md.api.Balance;
import com.ibm.assignment.md.api.Transaction;
import com.ibm.assignment.md.api.mapper.BalanceRowMapper;
import com.ibm.assignment.md.api.mapper.TransactionRowMapper;
import com.ibm.assignment.md.controller.AccountNumberController;
import com.ibm.assignment.md.sql.AccountQueryBuilder;

@Repository
public class AccountRepository {

	private static final Logger logger = LoggerFactory.getLogger(AccountNumberController.class);
	
	private final JdbcTemplate jdbcTemplate;

	private final String SQL_BALANCE = "select accountNumber, transactionTs, balance from book where accountNumber = '{accountNumber}' order by transactionTs DESC limit 1";
	private final String SQL_TRANSACTION = "select accountNumber, transactionTs, deposit, withdraw from book where accountNumber = '{accountNumber}' {timeRangeWhereClause} {operationTypeWhereClause} order by transactionTs ASC";
	

	
	public AccountRepository(DataSource dataSource) {
		super();
		//this.jdbcTemplate = new JdbcTemplate(dataSource());
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Balance getBalance(String accountNumber) {
				  
		String sql = SQL_BALANCE.replaceFirst("\\{accountNumber\\}", accountNumber)	;	  
		
		logger.info("sql_balance :" + sql);

		List<Balance> balances = jdbcTemplate.query(sql, new BalanceRowMapper<Balance>());
		
		if (balances == null) {
			return null;
		} else {
			if (balances.size() == 0) {
				return null;
			} else {
				return balances.get(0);
			}
		}
		
	}

	public List<Transaction> getTransactions(String accountNumber, 
											String timeRange, 
											Optional<String> start,
											Optional<String> end, 
											Optional<String> operationType) {
		
		
		
		String timeRangeWhereClause = AccountQueryBuilder.getWhereClause(timeRange, start, end);
		String operationTypeWhereClause = AccountQueryBuilder.getWhereClause(operationType);
		
		String sql = SQL_TRANSACTION.replaceFirst("\\{accountNumber\\}", accountNumber)	;	  
		sql = sql.replaceFirst("\\{timeRangeWhereClause\\}", timeRangeWhereClause)	;	  
		sql = sql.replaceFirst("\\{operationTypeWhereClause\\}", operationTypeWhereClause)	;	  
		
		logger.info("sql_transaction :" + sql);
		
		List<Transaction> transactions = jdbcTemplate.query(sql, new TransactionRowMapper<Transaction>());

		return transactions;
	}

	
}
