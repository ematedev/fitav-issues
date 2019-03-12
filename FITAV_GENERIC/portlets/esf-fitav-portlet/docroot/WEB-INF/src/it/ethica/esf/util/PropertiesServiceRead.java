
package it.ethica.esf.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.liferay.portal.kernel.util.StringPool;

public class PropertiesServiceRead extends AbstractPropertyService {

	private InputStream input = null;
	private String key = null;

	PropertiesServiceRead(FileInputStream fileInputStream, String key)
		throws IOException {

		super(fileInputStream);
		this.input = fileInputStream;
		this.key = key;
	}

	protected String read()
		throws IOException {

		Properties prop = new Properties();
		try {
			prop.load(input);
			return prop.getProperty(key, StringPool.BLANK);
		}
		catch (IOException ex) {
			return StringPool.BLANK;
		}
		finally {
			if (input != null) {
				try {
					input.close();
				}
				catch (IOException e) {
					return StringPool.BLANK;
				}
			}
		}
	}

	@Override
	public String toString() {

		// TODO Auto-generated method stub
		try {
			return read();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return StringPool.BLANK;
		}
	}
}
