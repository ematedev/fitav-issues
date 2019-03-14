
package it.ethica.esf.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ConvertDateCal {

	/**
	 * Convert date to calendar
	 * 
	 * @param date
	 * @return Calendar
	 */
	public static Calendar DateToCalendar(Date date) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;

	}

	/**
	 * Convert calendar to date
	 * 
	 * @param calendar
	 * @return Date
	 */
	public static Date CalendarToDate(Calendar calendar) {

		return calendar.getTime();
	}

	/**
	 * Convert String to Date
	 * @param dateInString
	 * @return Date
	 * @throws ParseException
	 */
	public static Date StringToDate(String dateInString)
		throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		try {

			date = format.parse(dateInString);
		}
		catch (ParseException e) {
			e.printStackTrace();
		}

		return date;
	}
	
	/**
	 * Convert Date to String
	 * @param date
	 * @return String
	 */
	public static String DateToString(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(date); 
	}

}
