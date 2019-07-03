package it.ethica.esf.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtilFormatter {

	public final static String DEFAULT_DATE_FORMAT_ITA = "dd/MM/yyyy";
	public final static String DEFAULT_DATE_FORMAT_ENG = "MM/dd/yyyy";

	/**
	 * 
	 * @param format
	 * @param date
	 * @return
	 */
	public static String formatDate(String pattern, Date date) throws MissingDateException {

		String formattedDate = "";

		if (date == null) {
			throw new MissingDateException("Please provide a Date to format");
		}
		formattedDate = new SimpleDateFormat(pattern).format(date);
		return formattedDate;
	}
	
	public static Date parseDate(String pattern, String sDate) throws MissingDateException, ParseException {
		if(sDate==null){
			throw new MissingDateException("Please provide a String to format");
		}
		return getFormatter(pattern).parse(sDate);
	}
	
	/**
	 * Metodo per trasformare una data in formato dd/MM/yyyy in un oggetto java.util.Date
	 * @param sDate la data nel formato dd/MM/yyyy
	 * @return L'oggetto date che rappresenta la data passata come parametro
	 * @throws MissingDateException
	 * @throws ParseException
	 */
	public static Date parseDate(String sDate) throws MissingDateException, ParseException {
		if(sDate==null){
			throw new MissingDateException("Please provide a String to format");
		}
		return getDefaultFormatter().parse(sDate);
	}
	
	/**
	 * Format a date using the default pattern
	 * 
	 * @param date
	 * @return
	 */

	public static String formatDate(Date date) throws MissingDateException {
		return formatDate(DEFAULT_DATE_FORMAT_ITA, date);
	}

	/**
	 * Get a SimpleDateFormat formatter with a given pattern
	 * 
	 * @param pattern
	 * @return
	 */
	public static SimpleDateFormat getFormatter(String pattern) {
		return new SimpleDateFormat(pattern);
	}

	/**
	 * get a SimpleDateFormat using default ITA format
	 * 
	 * @return
	 */
	public static SimpleDateFormat getDefaultFormatter() {
		return getFormatter(DEFAULT_DATE_FORMAT_ITA);
	}
	
}
