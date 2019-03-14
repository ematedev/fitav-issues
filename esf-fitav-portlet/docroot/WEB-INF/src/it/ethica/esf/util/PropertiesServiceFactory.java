package it.ethica.esf.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import com.liferay.portal.kernel.util.PropsUtil;

public class PropertiesServiceFactory {
	private static String path = PropsUtil.get("catalina.home")+"/../";
	private static HashMap<String, String> dateValues= new HashMap<String, String>();
	
	//Se gli passo solo la key, la classe factory costruisce un oggetto propertyServiceRead
	public static AbstractPropertyService getInstance(String fileName,  String key) throws IOException{
		AbstractPropertyService abstractPropertyService = null;
			FileInputStream fileInputStream = new FileInputStream(path+fileName);
			abstractPropertyService= new PropertiesServiceRead(fileInputStream, key);
		return abstractPropertyService;
	}
	//Se gli passo la key e il value, la classe factory costruisce un oggetto propertyWrite
	public static AbstractPropertyService getInstance(String fileName, String key, String value) throws IOException{
		//Setto tutto in un oggetto map, per non perdermi la chiave precedente.
		dateValues.put(key, value);
		AbstractPropertyService abstractPropertyService = null;
			FileOutputStream fileOutputStream = new FileOutputStream(path+fileName);
			abstractPropertyService= new PropertiesServiceWrite(fileOutputStream, dateValues);	
		return abstractPropertyService;
	}
}