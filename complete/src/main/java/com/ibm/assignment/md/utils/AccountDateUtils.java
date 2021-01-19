package com.ibm.assignment.md.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class AccountDateUtils {

	private static String tsZFormatString = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
	private static SimpleDateFormat formatTsZ = new SimpleDateFormat(tsZFormatString, Locale.US);
	

	public static String getTimestampFormatString() {
		return tsZFormatString;
	}
	
	public static SimpleDateFormat getTimestampFormat() {
		formatTsZ.setTimeZone(TimeZone.getTimeZone("UTC"));
		return formatTsZ;
	}
	
	public static String getTodayLimit() {
		
		Date currentDate = new Date();
	    LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	    localDateTime = localDateTime.minusDays(1);
	    Date currentDateMinusOneDay = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
		
	    return getTimestampFormat().format(currentDateMinusOneDay);
		
	}
	
	public static String getSevenDaysLimit() {
		
		Date currentDate = new Date();
	    LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	    localDateTime = localDateTime.minusDays(7);
	    Date currentDateMinus7Days = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
		
	    return getTimestampFormat().format(currentDateMinus7Days);
		
	}
	
	public static String getMonthLimit() {
		
		Date currentDate = new Date();
	    LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	    localDateTime = localDateTime.minusMonths(1);
	    Date currentDateMinusOneMonth = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
		
	    return getTimestampFormat().format(currentDateMinusOneMonth);
		
	}

}
