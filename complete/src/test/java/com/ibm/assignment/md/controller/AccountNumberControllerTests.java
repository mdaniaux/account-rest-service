package com.ibm.assignment.md.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.ibm.assignment.md.api.Account;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountNumberControllerTests {

	@Autowired
	private MockMvc mockMvc;

	//@Test
	public void getBalance() throws Exception {

		this.mockMvc.perform(get("/accountNumber").param("accountNumber","abc"))
							.andDo(print())
							.andExpect(status().isOk())
							/*.andExpect(jsonPath("$.content").value("Hello, World!"))*/;
		
		// TODO validation work
		
//		MockHttpServletResponse:
//	           Status = 200
//	    Error message = null
//	          Headers = [Content-Type:"application/json"]
//	     Content type = application/json
//	             Body = {"accountNumber":"abc","lastUpdateTimestamp":"2020-04-03T07:02:03.800+00:00","balance":7600.0}

		
	}

	//@Test
	public void getTransactionAbcToday() throws Exception {

		this.mockMvc.perform(get("/accountNumber").param("timeRange", Account.TimeRange.TODAY.getRange()).param("accountNumber","abc"))
								.andDo(print())
								.andExpect(status().isOk())
								/*.andExpect(jsonPath("$.content").value("Hello, World!"))*/;

		// TODO validation work

//		MockHttpServletResponse:
//	           Status = 200
//	    Error message = null
//	          Headers = [Content-Type:"application/json"]
//	     Content type = application/json
//	             Body = [{"accountNumber":"abc","transactionTs":"2021-01-17T10:02:03.000+00:00","type":"WITHDRAW","amount":140.0},{"accountNumber":"abc","transactionTs":"2021-01-17T11:04:03.000+00:00","type":"DEPOSIT","amount":120.0}]


	}

	//@Test
	public void getTransactionAbc7days() throws Exception {

		this.mockMvc.perform(get("/accountNumber").param("timeRange", Account.TimeRange.LAST7DAYS.getRange()).param("accountNumber","abc"))
								.andDo(print())
								.andExpect(status().isOk())
								/*.andExpect(jsonPath("$.content").value("Hello, World!"))*/;

		// TODO validation work

//		MockHttpServletResponse:
//	           Status = 200
//	    Error message = null
//	          Headers = [Content-Type:"application/json"]
//	     Content type = application/json
//	             Body = [{"accountNumber":"abc","transactionTs":"2021-01-14T23:02:03.000+00:00","type":"DEPOSIT","amount":150.0},{"accountNumber":"abc","transactionTs":"2021-01-15T01:03:04.000+00:00","type":"WITHDRAW","amount":250.0},{"accountNumber":"abc","transactionTs":"2021-01-16T00:02:03.000+00:00","type":"WITHDRAW","amount":350.0},{"accountNumber":"abc","transactionTs":"2021-01-16T01:04:03.000+00:00","type":"DEPOSIT","amount":130.0},{"accountNumber":"abc","transactionTs":"2021-01-17T10:02:03.000+00:00","type":"WITHDRAW","amount":140.0},{"accountNumber":"abc","transactionTs":"2021-01-17T11:04:03.000+00:00","type":"DEPOSIT","amount":120.0}]
		
	}

	//@Test
	public void getTransactionAbcMonth() throws Exception {

		this.mockMvc.perform(get("/accountNumber").param("timeRange", Account.TimeRange.LASTMONTH.getRange()).param("accountNumber","abc"))
								.andDo(print())
								.andExpect(status().isOk())
								/*.andExpect(jsonPath("$.content").value("Hello, World!"))*/;

		// TODO validation work

//		MockHttpServletResponse:
//	           Status = 200
//	    Error message = null
//	          Headers = [Content-Type:"application/json"]
//	     Content type = application/json
//	             Body = [{"accountNumber":"abc","transactionTs":"2020-12-19T23:02:03.000+00:00","type":"DEPOSIT","amount":400.0},{"accountNumber":"abc","transactionTs":"2021-01-14T23:02:03.000+00:00","type":"DEPOSIT","amount":150.0},{"accountNumber":"abc","transactionTs":"2021-01-15T01:03:04.000+00:00","type":"WITHDRAW","amount":250.0},{"accountNumber":"abc","transactionTs":"2021-01-16T00:02:03.000+00:00","type":"WITHDRAW","amount":350.0},{"accountNumber":"abc","transactionTs":"2021-01-16T01:04:03.000+00:00","type":"DEPOSIT","amount":130.0},{"accountNumber":"abc","transactionTs":"2021-01-17T10:02:03.000+00:00","type":"WITHDRAW","amount":140.0},{"accountNumber":"abc","transactionTs":"2021-01-17T11:04:03.000+00:00","type":"DEPOSIT","amount":120.0}]

		
	}

	
	//@Test
	public void getTransactionAbcFromToError() throws Exception {

		this.mockMvc.perform(get("/accountNumber").param("timeRange", Account.TimeRange.FROM_TO.getRange()).param("accountNumber","abc"))
								.andDo(print())
								//.andExpect(status().is())
								/*.andExpect(jsonPath("$.content").value("Hello, World!"))*/;
		// TODO validation work

//		MockHttpServletResponse:
//	           Status = 500
//	    Error message = null
//	          Headers = [Content-Type:"application/json"]
//	     Content type = application/json
//	             Body = {"message":"Server Error","details":["java.lang.Exception: with From To, start date and/or end date has to be filled !"]}

		
	}


	//@Test
	public void getTransactionAbcFromToInvalidStart() throws Exception {

			// start Date in UTC TZ
			// so  
	        this.mockMvc.perform(get("/accountNumber").param("timeRange", Account.TimeRange.FROM_TO.getRange()).param("accountNumber","abc").param("start","2021-01-AAT05:00:00.000Z"))
								.andDo(print())
								//.andExpect(status().is())
								/*.andExpect(jsonPath("$.content").value("Hello, World!"))*/;

			// TODO validation work

//	        MockHttpServletResponse:
//	            Status = 500
//	     Error message = null
//	           Headers = [Content-Type:"application/json"]
//	      Content type = application/json
//	              Body = {"message":"Server Error","details":["java.lang.Exception: Invalid format for start 2021-01-AAT05:00:00.000Z should be like this yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"]}

		
	}

	//@Test
	public void getTransactionAbcFromToStart() throws Exception {

			// start Date in UTC TZ
	        this.mockMvc.perform(get("/accountNumber").param("timeRange", Account.TimeRange.FROM_TO.getRange()).param("accountNumber","abc").param("start","2021-01-01T05:00:00.000Z"))
								.andDo(print())
								//.andExpect(status().is())
								/*.andExpect(jsonPath("$.content").value("Hello, World!"))*/;


			// TODO validation work
		
	}

	//@Test
	public void getTransactionAbcFromToEnd() throws Exception {

			
			// end Date in UTC TZ
			this.mockMvc.perform(get("/accountNumber").param("timeRange", Account.TimeRange.FROM_TO.getRange()).param("accountNumber","abc").param("end","2021-01-01T05:00:00.000Z"))
								.andDo(print())
								//.andExpect(status().is())
								/*.andExpect(jsonPath("$.content").value("Hello, World!"))*/;

			// TODO validation work

		
	}

	//@Test
	public void getTransactionAbcFromToStartEnd() throws Exception {

			
			// end Date in UTC TZ
			this.mockMvc.perform(get("/accountNumber").param("timeRange", Account.TimeRange.FROM_TO.getRange()).param("accountNumber","abc").param("start","2020-12-01T05:00:00.000Z").param("end","2021-01-16T05:00:00.000Z"))
								.andDo(print())
								//.andExpect(status().is())
								/*.andExpect(jsonPath("$.content").value("Hello, World!"))*/;


			// TODO validation work
		
	}
	
	//@Test
	public void getTransactionAbcMonthWithdraw() throws Exception {

		this.mockMvc.perform(get("/accountNumber").param("timeRange", Account.TimeRange.LASTMONTH.getRange()).param("accountNumber","abc").param("operationType", Account.OperationType.WITHDRAW.getType()))
								.andDo(print())
								.andExpect(status().isOk())
								/*.andExpect(jsonPath("$.content").value("Hello, World!"))*/;

		// TODO validation work

	}

	@Test
	public void getTransactionAbc7DaysDeposit() throws Exception {

		this.mockMvc.perform(get("/accountNumber").param("timeRange", Account.TimeRange.LASTMONTH.getRange()).param("accountNumber","abc").param("operationType", Account.OperationType.DEPOSIT.getType()))
								.andDo(print())
								.andExpect(status().isOk())
								/*.andExpect(jsonPath("$.content").value("Hello, World!"))*/;

		// TODO validation work

	}
	
}
