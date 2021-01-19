package com.ibm.assignment.md.sql;

import java.util.Optional;

import com.ibm.assignment.md.api.Account;
import com.ibm.assignment.md.utils.AccountDateUtils;

public class AccountQueryBuilder {

	public static void example () {
		
		
	}
	
	
	public static String getWhereClause(String timeRange, Optional<String> start, Optional<String> end) {
		
		String whereClause = "";
		
		if (Account.TimeRange.TODAY.getRange().equals(timeRange) ) {
			
			whereClause = " and transactionTs >= '" + AccountDateUtils.getTodayLimit() + "'";
			
		} else if (Account.TimeRange.LAST7DAYS.getRange().equals(timeRange) ) {
			
			whereClause = " and transactionTs >= '" + AccountDateUtils.getSevenDaysLimit() + "'";
			
		} else if (Account.TimeRange.LASTMONTH.getRange().equals(timeRange) ) {
			
			whereClause = " and transactionTs >= '" + AccountDateUtils.getMonthLimit() + "'";

			
 		} else if (Account.TimeRange.FROM_TO.getRange().equals(timeRange) ) {
 			
 			
 			if (Account.TimeRange.FROM_TO.getRange().equals(timeRange) ) {
 	 			
 	 			if (start.isPresent()) {

 	 				//whereClause = " and transactionTs >= '2021-01-01T05:00:00.000Z' ";
 	 	 			whereClause = " and transactionTs >= '"+start.get()+"' ";
 	 	 			
 	 			} 
 	 				
 	 			if (end.isPresent()) {
 	 	 				
 	 				// Ok end is set
 					whereClause = whereClause + " and transactionTs <= '"+end.get()+"' ";
 	 	 				
 	 			}
 	 			
 	 		}
 			
 		}
		
		return whereClause;
	}

	public static String getWhereClause(Optional<String> operationType) {
		
		if (operationType.isPresent()) {
			String whereClause;
			if ( Account.OperationType.WITHDRAW.getType().equals(operationType.get()) ) {
				
				whereClause =  " and ( (deposit is null) or (deposit = 0) ) ";
				
			} else {
				
				whereClause =  " and ( (withdraw is null) or (withdraw = 0) ) ";
				
			}
			
			
			
			return whereClause;
		} else {
			return "";
		}
		
	}

}
