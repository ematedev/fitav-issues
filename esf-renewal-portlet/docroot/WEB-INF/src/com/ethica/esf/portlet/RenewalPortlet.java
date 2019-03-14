package com.ethica.esf.portlet;

import it.ethica.esf.model.ESFCard;
import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.ESFUserESFUserRole;
import it.ethica.esf.service.ESFCardLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;
import it.ethica.esf.service.ESFUserESFUserRoleLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;
import it.ethica.esf.service.ESFUserRoleLocalServiceUtil;

import java.awt.font.TextAttribute;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.MimeResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.ethica.esf.util.ESFKeys;
import com.ethica.esf.util.ManageDate;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPage;
import com.itextpdf.text.pdf.PdfPageLabels;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.liferay.portal.kernel.dao.search.ResultRow;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.mysql.jdbc.StringUtils;

import it.ethica.esf.model.ESFUserRole;

/**
 * Portlet implementation class RegistrationRenewal
 */
public class RenewalPortlet extends MVCPortlet {
	
	public void checkPin(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException, PortalException, SystemException {

			long pin = ParamUtil.getLong(actionRequest, "pin");
			long esfUserId = ParamUtil.getLong(actionRequest, "esfUserId");
			if (esfUserId>0){
				
				ESFUser esfUser = ESFUserLocalServiceUtil.getESFUser(esfUserId);
				
					if (Validator.isNotNull(pin) && esfUser.getPin()== pin){
						actionResponse.setRenderParameter("mvcPath", "/html/renewal/renewal_form.jsp");
					}
					else {
						SessionErrors.add(actionRequest, "esfValidationError");
						SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
						actionResponse.setRenderParameter("mvcPath", "/html/renewal/insert_pin.jsp");
						actionResponse.setRenderParameter("esfUserId", String.valueOf(esfUserId));
					}
				
				
				
					
				
				
			}
			else {
				if (_log.isDebugEnabled()) {
					_log.debug(
						"No user exists.");
				}
			}
	}
		
	
	public void payAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException, PortalException, SystemException {

			String valore =ParamUtil.getString(actionRequest, "typePayment");
			String renewalDate = ParamUtil.getString(actionRequest, "renewalDate");
			
			if (valore.equals("paypal_cc")){
				actionResponse.setRenderParameter("mvcPath", "/html/renewal/"+"payment_success.jsp");
			}
			else {
				actionResponse.setRenderParameter("mvcPath", "/html/renewal/"+"download_note.jsp");
			}
	}
	
	private static Log _log = LogFactoryUtil.getLog(RenewalPortlet.class);

	
	
	
	@Override
	public void serveResource(ResourceRequest req,
			ResourceResponse res) throws IOException,
			PortletException {

		 String rType = ParamUtil.getString(req, "reportType");

	        if(rType != null && rType.equals("pdf")) {
	        	
	        	try {   
		  
	                    
	                    Document document = new Document();
	                    
	                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	                    
	                    PdfWriter.getInstance(document, baos);
	                    
	                    document.open();
						
	                    ThemeDisplay themeDisplay = (ThemeDisplay)req.getAttribute(WebKeys.THEME_DISPLAY);
	            		Group group = GroupLocalServiceUtil.getGroup(themeDisplay.getScopeGroupId());
	            		long currentOrganizationId = group.getOrganizationId(); //30039;//
	            		ESFOrganization currentESFOrganization = ESFOrganizationLocalServiceUtil.fetchESFOrganization(currentOrganizationId);

	            		int currentType = 0;

	            		if (currentESFOrganization != null) {

	            			currentType = Integer.valueOf(String.valueOf(currentESFOrganization.getType()));
	            		}	
	            		
	            		    String arrTable = ParamUtil.getString(req, "arrTable");
	            			String renewalDate = ParamUtil.getString(req, "renewalDate");
	            			String associationName = ParamUtil.getString(req, "associationName");
	            			String mailingAddress = ParamUtil.getString(req, "mailingAddress");
	            			String fieldAddress = ParamUtil.getString(req, "fieldAddress");
	            			String phoneNumbers = ParamUtil.getString(req, "phoneNumbers");
	            			String phoneNumbers2 = ParamUtil.getString(req, "phoneNumbers2");
	            			String fax = ParamUtil.getString(req, "fax");
	            			String email = ParamUtil.getString(req, "email");
	            			String internetSite = ParamUtil.getString(req, "internetSite");
	            			String fiscalCode = ParamUtil.getString(req, "fiscalCode");
	            			String vatNumber = ParamUtil.getString(req, "vatNumber");
	            			String ibanCode = ParamUtil.getString(req, "ibanCode");
	            			String versamento = ParamUtil.getString(req, "versamento");
	            			String n_campi = ParamUtil.getString(req, "n_campi");
	            			String category = ParamUtil.getString(req, "category");
	         
	            			Calendar calendar = CalendarFactoryUtil.getCalendar();
	            			String year = String.valueOf(ManageDate.getYear(calendar.getTime()));
	            			int yearO = (Integer.parseInt(year)-1);
	            			
	            			String title = "Rinnovo_Associazione_"+associationName;
	                       
	            			PdfPTable table = new PdfPTable(6);
	            			table.getDefaultCell().setPadding(6);
	            			//table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
	            			//table.addCell("");
	            			//table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
	            			table.getDefaultCell().setBorder(0);
	            			
	            			Font boldFont16 = FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD);
	            			Font normalFont = FontFactory.getFont(FontFactory.COURIER, 12, Font.ITALIC);
	            			
	            			PdfPCell titleCell = new PdfPCell();
	            			Phrase titleLine = new Phrase("MODULO DI RINNOVO DELL'AFFILIAZIONE "+year, boldFont16 );
	            			titleCell.setPhrase(titleLine);
	            			titleCell.setBorder(0);
	            			titleCell.setVerticalAlignment(Element.ALIGN_LEFT);
	            			titleCell.setColspan(6);
	            			table.addCell(titleCell);
	            			
	            			insertCell(table, new Phrase(" "),6);
	            			
	            			PdfPCell cell;
	            	
	            		    cell = new PdfPCell(new Phrase("Associazione (Denominazione):"));
	            		    cell.setBorder(0);
	            		    cell.setColspan(2);
	            		    table.addCell(cell);

	            		    cell = new PdfPCell(new Phrase(associationName,normalFont));
	            		    cell.setBorder(0);
	            		    cell.setColspan(3);
	            		    table.addCell(cell);
	            		    
	            		    cell = new PdfPCell(new Phrase(""));
	            		    cell.setBorder(0);
	            		    cell.setColspan(1);
	            		    table.addCell(cell);
	            		    
	            		    cell = new PdfPCell(new Phrase("Recapito Postale:"));
	            		    cell.setColspan(2);
	            		    cell.setBorder(0);
	            		    table.addCell(cell);

	            		    cell = new PdfPCell(new Phrase(mailingAddress,normalFont));
	            		    cell.setColspan(3);
	            		    cell.setBorder(0);
	            		    table.addCell(cell);
	            			
	            		    cell = new PdfPCell(new Phrase(""));
	            		    cell.setBorder(0);
	            		    cell.setColspan(1);
	            		    table.addCell(cell);
	            		    
	            		    cell = new PdfPCell(new Phrase("Indirizzo Campo:"));
	            		    cell.setColspan(2);
	            		    cell.setBorder(0);
	            		    table.addCell(cell);
	            		    cell = new PdfPCell(new Phrase(fieldAddress,normalFont));
	            		    cell.setColspan(3);
	            		    cell.setBorder(0);
	            		    table.addCell(cell);
	            		    
	            		    cell = new PdfPCell(new Phrase(""));
	            		    cell.setBorder(0);
	            		    cell.setColspan(1);
	            		    table.addCell(cell);
	            		    
	            		    cell = new PdfPCell(new Phrase("Numeri di Telefono:"));
	            		    cell.setColspan(2);
	            		    cell.setBorder(0);
	            		    table.addCell(cell);
	            		    if (phoneNumbers.equals("")|| phoneNumbers == null)
	            		    	cell = new PdfPCell(new Phrase("",normalFont));
	            		    else 
	            		    	cell = new PdfPCell(new Phrase(phoneNumbers+";",normalFont));
	            		    cell.setColspan(1);
	            		    cell.setBorder(0);
	            		    table.addCell(cell);
	            		    
	            		    cell = new PdfPCell(new Phrase(""));
	            		    cell.setBorder(0);
	            		    cell.setColspan(1);
	            		    table.addCell(cell);
	            		     
	            		    cell = new PdfPCell(new Phrase("Fax:"));
	            		    cell.setColspan(1);
	            		    cell.setBorder(0);
	            		    table.addCell(cell);
	            		    
	            		    cell = new PdfPCell(new Phrase(fax, normalFont));
	            		    cell.setColspan(1);
	            		    cell.setBorder(0);
	            		    table.addCell(cell);
	            		    
	            		    cell = new PdfPCell(new Phrase("Indirizzo Email:"));
	            		    cell.setColspan(2);
	            		    cell.setBorder(0);
	            		    table.addCell(cell);
	            		    cell = new PdfPCell(new Phrase(email,normalFont));
	            		    cell.setColspan(4);
	            		    cell.setBorder(0);
	            		    table.addCell(cell);
	            			
	            		    /*
	            		    cell = new PdfPCell(new Phrase(""));
	            		    cell.setBorder(0);
	            		    cell.setColspan(1);
	            		    table.addCell(cell);
	            		    */
	            		    cell = new PdfPCell(new Phrase("Sito Internet:"));
	            		    cell.setColspan(2);
	            		    cell.setBorder(0);
	            		    table.addCell(cell);
	            		    
	            		    cell = new PdfPCell(new Phrase(internetSite,normalFont));
	            		    cell.setColspan(3);
	            		    cell.setBorder(0);
	            		    table.addCell(cell);
	            		    
	            		    cell = new PdfPCell(new Phrase(""));
	            		    cell.setBorder(0);
	            		    cell.setColspan(1);
	            		    table.addCell(cell);
	            		    
	            		    cell = new PdfPCell(new Phrase("CODICE FISCALE:"));
	            		    cell.setColspan(2);
	            		    cell.setBorder(0);
	            		    table.addCell(cell);
	            		    
	            		    cell = new PdfPCell(new Phrase(fiscalCode,normalFont));
	            		    cell.setColspan(3);
	            		    cell.setBorder(0);
	            		    table.addCell(cell);
	            		    
	            		    cell = new PdfPCell(new Phrase(""));
	            		    cell.setBorder(0);
	            		    cell.setColspan(1);
	            		    table.addCell(cell);
	            		    
	            		    cell = new PdfPCell(new Phrase("PARTITA IVA:"));
	            		    cell.setColspan(2);
	            		    cell.setBorder(0);
	            		    table.addCell(cell);
	            		    
	            		    cell = new PdfPCell(new Phrase(vatNumber,normalFont));
	            		    cell.setColspan(3);
	            		    cell.setBorder(0);
	            		    table.addCell(cell);
	            		    
	            		    cell = new PdfPCell(new Phrase(""));
	            		    cell.setBorder(0);
	            		    cell.setColspan(1);
	            		    table.addCell(cell);
	            		    
	            		    cell = new PdfPCell(new Phrase("CODICE IBAN:"));
	            		    cell.setColspan(2);
	            		    cell.setBorder(0);
	            		    table.addCell(cell);
	            		    
	            		    cell = new PdfPCell(new Phrase(ibanCode,normalFont));
	            		    cell.setColspan(3);
	            		    cell.setBorder(0);
	            		    table.addCell(cell);
	            		    
	            		    cell = new PdfPCell(new Phrase(""));
	            		    cell.setBorder(0);
	            		    cell.setColspan(1);
	            		    table.addCell(cell);
	            		    
	            		    insertCell(table, new Phrase(" "), 6);
	            		    insertCell(table, new Phrase(" "), 6);
	            		    
	            		    cell = new PdfPCell(new Phrase("In nome e per conto dell'Associazione, il sottoscritto dichiara :"));
	            		    cell.setColspan(6);
	            		    cell.setBorder(0);
	            		    table.addCell(cell);
	            		    
	            		    insertCell(table, new Phrase(" "), 6);
	            		    
	            		    cell = new PdfPCell(new Phrase("- Di aver effettuato il versamento di EURO "+ versamento
	            		    		+" per il Rinnovo dell'Affiliazione "+yearO+" "));
	            		    cell.setColspan(6);
	            		    cell.setBorder(0);
	            		    table.addCell(cell);
	            		    
	            		    cell = new PdfPCell(new Phrase("- Di avere n. "+n_campi+" campi da utilizzare in "+
	            		    			"contemporanea"));
	            		    cell.setColspan(6);
	            		    cell.setBorder(0);
	            		    table.addCell(cell);
	            		    
	            		    cell = new PdfPCell(new Phrase("- Di essere inquadrato nella "+category+" categoria di "
	            		    		+ "affiliazione"));
	            		    cell.setColspan(6);
	            		    cell.setBorder(0);
	            		    table.addCell(cell);
	            		    
	            		    insertCell(table, new Phrase(" "), 6);
	            		    insertCell(table, new Phrase(" "), 6);
	            		    
	            		   
	            		    cell = new PdfPCell(new Phrase(" COMPOSIZIONE CONSIGLIO DIRETTIVO : "));
	            		    cell.setColspan(6);
	            		    cell.setBorder(0);
	            		    table.addCell(cell);
	    
	            		    
	            			document.add(table);
	            			
	            	
	            			
	            			PdfPTable tableConsiglio = new PdfPTable(4);
	            			tableConsiglio.getDefaultCell().setPadding(4);
	            			tableConsiglio.getDefaultCell().setBorder(0);
	            		
	            			PdfPCell cellConsiglio;
	    	            	
	            			
	            			insertCell(tableConsiglio, new Phrase(" "), 4);
	            			
	            			cellConsiglio = new PdfPCell(new Phrase(("Titolo").toUpperCase()));
	            			cellConsiglio.setBorder(1);
	            			cellConsiglio.setColspan(1);
	            		    tableConsiglio.addCell(cellConsiglio);

	            		    cellConsiglio = new PdfPCell(new Phrase(("N.Tessera").toUpperCase()));
	            			cellConsiglio.setBorder(1);
	            			cellConsiglio.setColspan(1);
	            		    tableConsiglio.addCell(cellConsiglio);
	            		    
	            		    cellConsiglio = new PdfPCell(new Phrase(("Cognome").toUpperCase()));
	            			cellConsiglio.setBorder(1);
	            			cellConsiglio.setColspan(1);
	            		    tableConsiglio.addCell(cellConsiglio);
	            		    
	            		    cellConsiglio = new PdfPCell(new Phrase(("Nome").toUpperCase()));
	            			cellConsiglio.setBorder(1);
	            			cellConsiglio.setColspan(1);
	            		    tableConsiglio.addCell(cellConsiglio);
	            		    
	            			JSONArray consiglioJSONArray = JSONFactoryUtil.createJSONArray(arrTable);//consiglioJSONObject.getJSONArray("myRows");
	            			//System.out.println(consiglioJSONArray);
	            			for (int i = 0; i < consiglioJSONArray.length(); i++) {
	            			    JSONObject jsonobject = consiglioJSONArray.getJSONObject(i);
	            			    String col1 = jsonobject.getString("Titolo");
	            			    String col2 = jsonobject.getString("N.Tessera");
	            			    String col3 = jsonobject.getString("Cognome");
	            			    String col4 = jsonobject.getString("Nome");
	            			
	            			    String [] tessereL = col2.split(";");
	            			    String [] cognomiL = col3.split(";");
	            			    String [] nomiL = col4.split(";");
	            			  
	            			    cellConsiglio = new PdfPCell(new Phrase(col1,normalFont));
 	    	            		cellConsiglio.setBorder(1);
 	    	            		cellConsiglio.setColspan(1);
 	    	            		cellConsiglio.setRowspan(tessereL.length);
 	    	            		tableConsiglio.addCell(cellConsiglio);
	    	                       
	    	            		   int l = 0;
	    	            		   while (l<tessereL.length){
	        
	    	            		    cellConsiglio = new PdfPCell(new Phrase(tessereL[l],normalFont));
	    	            			cellConsiglio.setColspan(1);
	    	            		    tableConsiglio.addCell(cellConsiglio);
	    	            		    
	    	            		    cellConsiglio = new PdfPCell(new Phrase(cognomiL[l],normalFont));
	    	            			cellConsiglio.setColspan(1);
	    	            		    tableConsiglio.addCell(cellConsiglio);
	    	            		    
	    	            		    cellConsiglio = new PdfPCell(new Phrase(nomiL[l],normalFont));
	    	            			cellConsiglio.setColspan(1);
	    	            		    tableConsiglio.addCell(cellConsiglio);
	    	            		    l++;
	    	            		    }
	    	            		    
	            			    //}
	            			    
	            			}
	            		    document.add(tableConsiglio);
	            			
	            		    document.close();
	                    
	                    res.setContentType("application/pdf");
	                    
	                    res.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");
	                    res.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=ModuloAdesioneRinnovo_"+associationName.replace(' ', '_')+".pdf;");
	                    //res.setContentLength(baos.size());
	                    
	                    OutputStream out = res.getPortletOutputStream();
	                    baos.writeTo(out);
	                    
	                    out.flush();
	                    out.close();

	        	} catch (Exception e2) {
	                    System.out.println("Error in " + getClass().getName() + "\n" + e2);
	        	}
	        }
		
		
	}


	private static void insertCell(PdfPTable table, Phrase phrase, int colspan){
		   
		  //create a new cell with the specified Text and Font
		  PdfPCell cell = new PdfPCell(phrase);
		  //set the cell alignment
		  cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
	
		   cell.setColspan(colspan);
		   cell.setBorder(0);
		   cell.setMinimumHeight(12f);
		   table.addCell("");
		
		  //add the call to the table
		  table.addCell(cell);

	}
	

	public void updateAddESFUserESFRole(
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws SystemException, PortalException {

			ServiceContext serviceContext =
				ServiceContextFactory.getInstance(actionRequest);

			boolean[] chooses = ParamUtil.getBooleanValues(actionRequest, "choose");
			long[] esfUserIds =
				ParamUtil.getLongValues(actionRequest, "esfUserIds");
			long esfUserRoleId = ParamUtil.getLong(actionRequest, "esfUserRoleId");
			long esfOrganizationId =
				ParamUtil.getLong(actionRequest, "esfOrganizationId");
			String type = ParamUtil.getString(actionRequest, "type");
			Date date = new Date();

			ESFUserRole esfUserRole =
				ESFUserRoleLocalServiceUtil.fetchESFUserRole(esfUserRoleId);
			int maxUser = esfUserRole.getMaxUser();
			

			List<ESFUserESFUserRole> esfUserESFUserRoles =
				ESFUserESFUserRoleLocalServiceUtil.findESFUserESFRoleByO_R(
					esfOrganizationId, esfUserRoleId);

			int checkMax = 0;
			if (type.equals("NA")) {
				for (int j = 0; j < chooses.length; j++) {
					if (chooses[j])
						checkMax++;
				}
			}
			// check del max
			if (maxUser == 0 || esfUserESFUserRoles.size() + checkMax <= maxUser ||
				type.equals("A")) {
				for (int i = 0; i < esfUserIds.length; i++) {

					if (type.equals("NA") && chooses[i]) {
						ESFUserESFUserRoleLocalServiceUtil.addESFUserESFRole(
							esfUserIds[i], esfUserRoleId, esfOrganizationId, date);
					}
					else if (type.equals("A") && chooses[i]) {
						ESFUserESFUserRoleLocalServiceUtil.updateESFUserESFRole(
							esfUserIds[i], esfUserRoleId, esfOrganizationId, date,
							serviceContext);
					}
				}
			}
			else {
				SessionErrors.add(actionRequest, "userrole-maxuser-error");
			}
			actionResponse.setRenderParameter("mvcPath", "/html/renewal/renewal_form.jsp");
		}
	
}
