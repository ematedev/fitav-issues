package it.ethica.esf.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesServiceWrite extends AbstractPropertyService {
	private OutputStream output= null;
	private Map<String, String> dateValues= new HashMap<String, String>();
	
	PropertiesServiceWrite(FileOutputStream fileOutputStream, Map<String,String> dateValues) throws IOException {
		super(fileOutputStream);
		this.output = fileOutputStream;
		this.dateValues = dateValues;
		write();
	}
	
	  protected void write() throws IOException {
	        Properties prop = new Properties();
	        try { 
	        	for (Map.Entry<String,String> entry : dateValues.entrySet()) {
	        	   prop.setProperty(entry.getKey(), entry.getValue());
	        	}
	        	  prop.store(output, null);
		             
	        } catch (IOException io) {
	               throw io;
	        } finally {
	               if (output != null) {
	                     try {
	                            output.close();
	                     } catch (IOException e) {
	                            throw e;
	                     }
	               }
	        }
	  }
}