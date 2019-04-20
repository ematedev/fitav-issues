package it.ethica.esf.util;

public class HTTPRequestUtil {
	
	public static java.io.InputStream fireHTTPrequest(String url) throws java.io.IOException {
		return fireHTTPrequest(url, java.nio.charset.StandardCharsets.UTF_8, new java.util.HashMap<String, String>());
	}
	public static java.io.InputStream fireHTTPrequest(String url, java.util.HashMap<String, String> params) throws java.io.IOException {
		return fireHTTPrequest(url, java.nio.charset.StandardCharsets.UTF_8, params);
	}
	public static java.io.InputStream fireHTTPrequest(String url, java.nio.charset.Charset charset, java.util.HashMap<String, String> params) throws java.io.IOException {

		java.util.Set<String> keys = params.keySet();
		String[] values = new String[keys.size()];

		String query = "";
		int i = 0;
		java.util.Iterator<String> keyIterator = keys.iterator();
		
		while (keyIterator.hasNext()) {

			String key = (String) keyIterator.next();

			query += key + "=%s";
			
			if (keyIterator.hasNext()) {
				
				query += "&";
			}
			
			values[i++] = params.get(key);
		}

		if (i > 0) {
			
			query = "?" + String.format(query, (Object[])values);
		}

		java.net.URLConnection connection = new java.net.URL(url + query).openConnection();
		connection.setRequestProperty("Accept-Charset", charset.name());
		java.io.InputStream response = connection.getInputStream();

		return response;
	}

}
