package it.ethica.esf.util;

import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

public class ManageDate {

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
	 * Convert Calendar to String
	 *
	 * @param date
	 * @return String
	 */
	public static String CalendarToString(Calendar calendar) {

		return DateToString(calendar.getTime());
	}

	/**
	 * Convert String to Date
	 *
	 * @param dateInString
	 * @return Date
	 * @throws ParseException
	 */
	public static Date StringToDate(String dateInString) throws ParseException {
		if (dateInString == null || dateInString.trim().equals(""))
			return null;
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = format.parse(dateInString);

		return date;
	}

	/**
	 * Convert String to Date
	 *
	 * @param dateInString
	 * @return Date
	 * @throws ParseException
	 */
	public static Date StringToDate(String dateInString, DateFormat format)
			throws ParseException {
		if (dateInString == null || dateInString.trim().equals(""))
			return null;

		Date date = format.parse(dateInString);
		return date;
	}

	/**
	 * Convert date to calendar
	 *
	 * @param date
	 * @return Calendar
	 */
	public static Calendar DateToCalendar(Date date) {

		Calendar calendar = CalendarFactoryUtil.getCalendar();// Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}

	/**
	 * Convert Date to String
	 *
	 * @param date
	 * @return String
	 */
	public static String DateToString(Date date) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		if (date == null) {
			return StringPool.BLANK;
		}

		return sdf.format(date);
	}

	/**
	 * Return Year from an input Date
	 * 
	 * @param date
	 * @return year
	 */
	public static int getYear(Date date) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
	}

	/**
	 * Return Month from an input Date
	 * 
	 * @param date
	 * @return month
	 */
	public static int getMonth(Date date) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH);
	}

	/**
	 * Return Day from an input Date
	 * 
	 * @param date
	 * @return day
	 */
	public static int getDay(Date date) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_MONTH);
	}
	
	

	
	public static boolean checkPeriod(Calendar calendar) throws ParseException{
		
		
		String todayS = ManageDate.CalendarToString(calendar);
		System.out.println("Today is:"+todayS);
		int year = getYear(calendar.getTime());
		String novemberS=ESFRenewalConstants.NOVEMBER_RANGE+year;
		String decemberS = ESFRenewalConstants.DECEMBER_RANGE+year;
		Date today=ManageDate.StringToDate(todayS);
		Date novemberD=ManageDate.StringToDate(novemberS);
		Date decemberD=ManageDate.StringToDate(decemberS);
		if (!today.before(novemberD)){
				
				if(today.before(decemberD)||today.compareTo(decemberD)==0) {
					return true;
				}
				else{
					return false;
				}
		}
		else {
			return false;
		}

		
		
	}
}