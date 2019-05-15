package it.ethica.esf.portlet.utility;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.mysql.jdbc.Connection;


public class GenerateAffiliationReport extends MVCPortlet{
	
	String connectionURL = PropsUtil.get("jdbc.default.url");
	String userName = PropsUtil.get("jdbc.default.username");
	String password = PropsUtil.get("jdbc.default.password");
	
	public void generateAffiliationShooterReportDate(ResourceRequest req, ResourceResponse resp, String affiliationDate)
					throws SystemException, PortalException, PortletException{
		
		HashMap map = new HashMap();
		
		
		try {
			// apro la connessione con il db
			Class.forName("com.mysql.jdbc.Driver");
			//String connectionURL = "jdbc:mysql://127.0.0.1:3306/fitav";
			
			Connection conn = (Connection) DriverManager.getConnection(connectionURL, userName,password);
			
			map.put("P_affDate", affiliationDate); 
			
			String path = PropsUtil.get("auto.deploy.tomcat.dest.dir") + File.separator +
							"report"+ File.separator +"EsfShooterAffiliation.jasper";
					
			InputStream jasperStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
			
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new File(path));
			
			JasperPrint print = JasperFillManager.fillReport(jasperReport,map, conn);

			byte[] bytes = null;
			bytes = JasperRunManager.runReportToPdf(jasperReport,map,conn);
			resp.reset();
			resp.resetBuffer();
			resp.setContentType("application/pdf");
			resp.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Report Affiliazioni.pdf;");
			resp.setContentLength(bytes.length);
			OutputStream ouputStream =  resp.getPortletOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
			
			
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void generateAffiliationShooterReportDateYear(ResourceRequest req, ResourceResponse resp)
					throws SystemException, PortalException, PortletException{
		HashMap map = new HashMap();
		
		try {
			// apro la connessione con il db
			Class.forName("com.mysql.jdbc.Driver");
			//String connectionURL = "jdbc:mysql://127.0.0.1:3306/fitav";
			
			Connection conn = (Connection) DriverManager.getConnection(connectionURL, userName,password);
			
			Calendar calendar = GregorianCalendar.getInstance();//
			int year = calendar.get( Calendar.YEAR );//
			
			map.put("year", String.valueOf(year)); 
			map.put("reportYear", String.valueOf(year)); 
			
			String path = PropsUtil.get("auto.deploy.tomcat.dest.dir") + File.separator +
							"report"+ File.separator +"AffiliationShooterYear.jasper";
					
			InputStream jasperStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
			
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new File(path));
			
			JasperPrint print = JasperFillManager.fillReport(jasperReport,map, conn);

			byte[] bytes = null;
			bytes = JasperRunManager.runReportToPdf(jasperReport,map,conn);
			resp.reset();
			resp.resetBuffer();
			resp.setContentType("application/pdf");
			resp.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Report Affiliazioni Annuale.pdf;");
			resp.setContentLength(bytes.length);
			OutputStream ouputStream =  resp.getPortletOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
			
			
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
