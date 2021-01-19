package com.ibm.assignment.md.api;

public class Account {

	
	// `time range` such as: `Today`, `Last 7 days`, `last Month` and the more general case of a range between `date X` and `date Y`. 
	// For example, I should be able to ask for all my transactions between `January 8th, 2019` and `November 28th, 2020`.
	
	public enum TimeRange {
		TODAY("Today"),
		LAST7DAYS("Last 7 days"),
		LASTMONTH("Last month"),
		FROM_TO("From to");
		
		private final String range;
		
		TimeRange(String range) {
			this.range = range;
		}
		
		public String getRange() {
			return this.range;
		}
		
	}
	
	
	// there are *two* types of transactions: 1. `DEPOSIT` and 2. `WITHDRAW`
	
	public enum OperationType {
		DEPOSIT("DEPOSIT"),
		WITHDRAW("WITHDRAW");
		
		private final String type;
		
		OperationType(String type) {
			this.type = type;
		}
		
		public String getType() {
			return this.type;
		}
		
	}
	
	
}
