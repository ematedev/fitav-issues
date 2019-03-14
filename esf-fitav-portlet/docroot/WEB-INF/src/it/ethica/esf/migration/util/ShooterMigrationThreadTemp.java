
package it.ethica.esf.migration.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;

import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;

public class ShooterMigrationThreadTemp implements Runnable {

	private static Log _log = LogFactoryUtil.getLog(ShooterMigrationThreadTemp.class);
	private String jdbc = "";
	private String dbUrl = "";
	private String user = "";
	private String pass = "";
	
	private ServiceContext serviceContext;

	public void run() {

		List<String> errorList = new ArrayList<String>();
		long totElement = 1;
		Statement stat = null;
		Connection connection = null;

		try {
			Class.forName(jdbc);
			connection = DriverManager.getConnection(dbUrl, user, pass);
			String selectShooter="select * from anagrate.anatiratori  a, anagrate.tessere where a.codice =numero_tiratore  and anno >= 2010 order by numero_tiratore,anno,tessera ;";
			stat = connection.createStatement();
			_log.info("Start query");
			ResultSet res = stat.executeQuery(selectShooter);
			int count = 0;
			_log.info("Start shooter import");
			String lastcode="";
			int pos=1;
			Statement stat1 = connection.createStatement();
			
			while (res.next()) {
				count++;
				_log.info("COUNT-->" + count);
				String code = res.getString("Codice").trim();
				if(!code.equals(lastcode)){
					pos=1;
					lastcode=code;
				}else{
					pos++;
				}
					
				try {
					
					String year = res.getString("Anno").trim();
					String cardCode = res.getString("Tessera").trim();
					String organization = res.getString("Societa").trim();
					String data_Creazione = res.getString("Data_Pagamento").trim();
					
					ESFOrganization org = ESFOrganizationLocalServiceUtil.findByCode(organization);
					if (org == null) {
						_log.info("No Organization");
					} else {
						
						String query=assignCard( code,  year , cardCode  , data_Creazione , pos);
						stat1.execute(query);
					}
					
					_log.info("Processed element " + totElement++);
				} catch (Exception e) {
					errorList.add("&&&&&&&&&>>>>>>>> Dati " + code + " " + e.toString());
				}
				
			}
			_log.info("End shooter import --->end count:" + count);
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		} catch (ClassNotFoundException classN) {
			classN.printStackTrace();
		} catch (Exception classN) {
			classN.printStackTrace();
		} finally { // chiude Statement e Connection
			try {
				if (stat != null)
					stat.close();
				if (connection != null)
					connection.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		_log.info("Errori " + errorList.size());
		for (String error : errorList) {

			_log.info(error);
		}

	}

	private String assignCard(String code, String year ,String cardCode ,	String data_Creazione ,int pos) {

		_log.info("code-->" + code);
		
		String tmp="insert into fitav.tessere_appo (ordine,tiratore,tessera,anno,dataIni,dataFine) values ("+pos+","+code+",'"+cardCode+"',"+ year+",'"+data_Creazione+"'";
		if (!year.equals("2016" )) {
			tmp+=",'"+year+"-12-31 23:59:59'";
		}else{
			tmp+=","+null;
		}
		tmp+=");";
		return tmp;		
	}

	public String getJdbc() {

		return jdbc;
	}

	public void setJdbc(String jdbc) {

		this.jdbc = jdbc;
	}

	public String setDbUrl() {

		return dbUrl;
	}

	public void setDbUrl(String dbUrlL) {

		this.dbUrl = dbUrlL;
	}

	public String getUser() {

		return user;
	}

	public void setUser(String user) {

		this.user = user;
	}

	public String getPass() {

		return pass;
	}

	public void setPass(String pass) {

		this.pass = pass;
	}

	public ServiceContext getServiceContext() {

		return serviceContext;
	}

	public void setServiceContext(ServiceContext serviceContext) {

		this.serviceContext = serviceContext;
	}


}