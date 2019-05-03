package it.ethica.esf.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtilFormatter {
	
	private final static String DEFAULT_DATE_FORMAT_ITA = "dd/MM/yyyy";
	
	public static String formatDate( String format, Date date ) {
		
		String formattedDate = "";
		
		if ( date != null ) {
			formattedDate = new SimpleDateFormat(format).format(date);
		}
		return formattedDate;
	}
	
	public static String formatDate ( Date date ) {
		return formatDate(DEFAULT_DATE_FORMAT_ITA, date);
	}

}
