package it.ethica.esf.renewal.portlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.VW_ESFListaIncarichi;
import it.ethica.esf.renewal.model.ESFRenewalCompany;
import it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera;
import it.ethica.esf.renewal.service.ESFRenewalCompanyLocalServiceUtil;
import it.ethica.esf.renewal.service.VW_ESFListaIncarichiTesseraLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;
import it.ethica.esf.util.ESFRenewalConstants;
import it.ethica.esf.util.ManageDate;

/**
 * Portlet implementation class RegistrationRenewal
 */
public class RenewalCompanyPortlet extends MVCPortlet {

	Log logger =  LogFactoryUtil.getLog(RenewalCompanyPortlet.class);
	
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		renderRequest.setAttribute("doView", "Questo l'ha impostato doView");
		
		System.out.println("Chiamato View RenewalCompanyPortlet");
		super.doView(renderRequest, renderResponse);
	}


	@Override
	public void render(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		
		
		// OTTIENI l'ID ESFOrganizationId a partire dal contesto dove sta girando la Portlet
		try {
			ThemeDisplay themeDisplay= (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			long scopeGroupId = themeDisplay.getScopeGroupId();
			Group group = GroupLocalServiceUtil.getGroup(scopeGroupId);
			long currentOrganizationId = group.getOrganizationId();
	
			ESFOrganization currentESFOrganization = ESFOrganizationLocalServiceUtil.fetchESFOrganization(currentOrganizationId);
			long esfOrganizationId = currentESFOrganization.getEsfOrganizationId();
			
			
			
			// Lista dei Consiglieri per l'anno in corso per cui si richiede la Riaffiliazione
			
			Map<Long, VW_ESFListaIncarichiTessera> listaConsiglieriInCarica = new HashMap<Long, VW_ESFListaIncarichiTessera>();
			List<VW_ESFListaIncarichiTessera> listaStoricaIncarichiConsiglieri = 
					VW_ESFListaIncarichiTesseraLocalServiceUtil.findByorganizzazione(esfOrganizationId);
	
			int annoCorrente = Calendar.getInstance().get(Calendar.YEAR);
			
			
			logger.debug("Lista Consiglieri per l'anno[" + annoCorrente + "] dimensione[" + listaStoricaIncarichiConsiglieri.size() + "]");
	
	
			Calendar inizioAnnoSelezionato = Calendar.getInstance();
			inizioAnnoSelezionato.set(annoCorrente, Calendar.JANUARY, 1);
	
			Calendar fineAnnoSelezionato = Calendar.getInstance();
			fineAnnoSelezionato.set(annoCorrente, Calendar.DECEMBER, 31);
			
			
			
			// Filtra quelli che sono in carica nell'anno selezionato
			for (VW_ESFListaIncarichiTessera incaricoCorrente : listaStoricaIncarichiConsiglieri) {
	
				boolean inCarica = true;
				
	
				if ( incaricoCorrente.getEndDate() != null ) {
	
					Calendar fineMandato = Calendar.getInstance();
					fineMandato.setTime( incaricoCorrente.getEndDate() );
					
					inCarica = fineMandato.after(inizioAnnoSelezionato);
				}
								
				logger.debug("Data Inizio[" + incaricoCorrente.getStartDate() + "] annoSelezionato[" + annoCorrente + "]");
				
				Calendar inizioMandato = Calendar.getInstance();
				inizioMandato.setTime(incaricoCorrente.getStartDate());
				
				inCarica = inCarica && inizioMandato.before(fineAnnoSelezionato);
	
					
				if ( inCarica && ! listaConsiglieriInCarica.containsKey( incaricoCorrente.getEsfUserId() ) ) {
					listaConsiglieriInCarica.put(incaricoCorrente.getEsfUserId(), incaricoCorrente);
					logger.debug("Aggiunto incarico per consigliereID[" + incaricoCorrente.getEsfUserId() + "] nell'anno[" + annoCorrente + "]");
				}			
			}
			
			
			
			
			request.setAttribute("render", "Questo l'ha impostato Render");
	
			System.out.println("Chiamato Render RenewalCompanyPortlet");
			// Necessario (non so fare altrimenti) per inviarlo al searchcontainer			
			List<VW_ESFListaIncarichiTessera> list = new ArrayList<VW_ESFListaIncarichiTessera>();
			list.addAll(listaConsiglieriInCarica.values());
			request.setAttribute("listaIncarichiConsiglioDirettivo", list);

			request.setAttribute("dimensioneLista", listaConsiglieriInCarica.size());
		} catch ( SystemException | PortalException exception ) {
			logger.error("Impossibile ottenere la lista degli incarichi Consiglio Direttivo", exception );
			exception.printStackTrace();
			throw new PortletException( exception );
		}
		
		
		super.render(request, response);
	}
	
	
	

	public void checkPin(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, PortalException, SystemException {

		long pin = ParamUtil.getLong(actionRequest, "pin");
		long esfUserId = ParamUtil.getLong(actionRequest, "esfUserId");
		if (esfUserId > 0) {

			ESFUser esfUser = ESFUserLocalServiceUtil.getESFUser(esfUserId);

			if (Validator.isNotNull(pin) && esfUser.getPin() == pin) {
				actionResponse.setRenderParameter("mvcPath",
						"/html/renewal/renewal_form.jsp");
			} else {
				SessionErrors.add(actionRequest, "esfValidationError");
				SessionMessages
						.add(actionRequest,
								PortalUtil.getPortletId(actionRequest)
										+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				actionResponse.setRenderParameter("mvcPath",
						"/html/renewal/insert_pin.jsp");
				actionResponse.setRenderParameter("esfUserId",
						String.valueOf(esfUserId));
			}

		} else {
			if (_log.isDebugEnabled()) {
				_log.debug("No user exists.");
			}
		}
	}

	public void payAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, PortalException, SystemException {

		String valore = ParamUtil.getString(actionRequest, "typePayment");
		String renewalDate = ParamUtil.getString(actionRequest, "renewalDate");

		if (valore.equals("paypal_cc")) {
			actionResponse.setRenderParameter("mvcPath", "/html/renewal/"
					+ "payment_success.jsp");
		} else {
			actionResponse.setRenderParameter("mvcPath", "/html/renewal/"
					+ "download_note.jsp");
		}
	}

	@Override
	public void serveResource(ResourceRequest req, ResourceResponse res)
			throws IOException, PortletException {
		String resourceId = req.getResourceID();
		
		if ("paymentType".equals(resourceId)) {
			int paymentType = ParamUtil.getInteger(req, "paymentType");
			
			long esfRenewalCompanyId = GetterUtil.getLong(req.getPortletSession().getAttribute("esfRenewalCompanyId"));
			String result = "KO";
			if (Validator.isNotNull(esfRenewalCompanyId) && Validator.isNotNull(paymentType)) {
				ESFRenewalCompany esfRenewalCompany = null;
				try {
					esfRenewalCompany = ESFRenewalCompanyLocalServiceUtil.getESFRenewalCompany(esfRenewalCompanyId);
					if (Validator.isNotNull(esfRenewalCompany)) {
						esfRenewalCompany.setPaymentType(paymentType);
						esfRenewalCompany.setStatus(ESFRenewalConstants.RENEWAL_STATUS_PENDING);
						ESFRenewalCompanyLocalServiceUtil.updateESFRenewalCompany(esfRenewalCompany);
						result = "OK";
					}
				} catch (PortalException e) {
					e.printStackTrace();
				} catch (SystemException e) {
					e.printStackTrace();
				}
				
			}
			res.setContentType(ContentTypes.APPLICATION_JSON);
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("result", result);
			PortletResponseUtil.write(res, jsonObject.toString());
			return;
		}
		String rType = ParamUtil.getString(req, "reportType");

		if (rType != null && rType.equals("pdf")) {

			try {

				Document document = new Document();

				ByteArrayOutputStream baos = new ByteArrayOutputStream();

				PdfWriter.getInstance(document, baos);

				document.open();

				ThemeDisplay themeDisplay = (ThemeDisplay) req
						.getAttribute(WebKeys.THEME_DISPLAY);
				Group group = GroupLocalServiceUtil.getGroup(themeDisplay
						.getScopeGroupId());
				long currentOrganizationId = group.getOrganizationId(); // 30039;//
				ESFOrganization currentESFOrganization = ESFOrganizationLocalServiceUtil
						.fetchESFOrganization(currentOrganizationId);

				int currentType = 0;

				if (currentESFOrganization != null) {

					currentType = Integer.valueOf(String
							.valueOf(currentESFOrganization.getType()));
				}

				String arrTable = ParamUtil.getString(req, "arrTable");
				String renewalDate = ParamUtil.getString(req, "renewalDate");
				String associationName = ParamUtil.getString(req,
						"associationName");
				String mailingAddress = ParamUtil.getString(req,
						"mailingAddress");
				String fieldAddress = ParamUtil.getString(req, "fieldAddress");
				String phoneNumbers = ParamUtil.getString(req, "phoneNumbers");
				String phoneNumbers2 = ParamUtil
						.getString(req, "phoneNumbers2");
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
				String year = String.valueOf(ManageDate.getYear(calendar
						.getTime()));
				int yearO = (Integer.parseInt(year) - 1);

				String title = "Rinnovo_Associazione_" + associationName;

				PdfPTable table = new PdfPTable(6);
				table.getDefaultCell().setPadding(6);
				// table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
				// table.addCell("");
				// table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
				table.getDefaultCell().setBorder(0);

				Font boldFont16 = FontFactory.getFont(FontFactory.HELVETICA,
						16, Font.BOLD);
				Font normalFont = FontFactory.getFont(FontFactory.COURIER, 12,
						Font.ITALIC);

				PdfPCell titleCell = new PdfPCell();
				Phrase titleLine = new Phrase(
						"MODULO DI RINNOVO DELL'AFFILIAZIONE " + year,
						boldFont16);
				titleCell.setPhrase(titleLine);
				titleCell.setBorder(0);
				titleCell.setVerticalAlignment(Element.ALIGN_LEFT);
				titleCell.setColspan(6);
				table.addCell(titleCell);

				insertCell(table, new Phrase(" "), 6);

				PdfPCell cell;

				cell = new PdfPCell(new Phrase("Associazione (Denominazione):"));
				cell.setBorder(0);
				cell.setColspan(2);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(associationName, normalFont));
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

				cell = new PdfPCell(new Phrase(mailingAddress, normalFont));
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
				cell = new PdfPCell(new Phrase(fieldAddress, normalFont));
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
				if (phoneNumbers.equals("") || phoneNumbers == null)
					cell = new PdfPCell(new Phrase("", normalFont));
				else
					cell = new PdfPCell(new Phrase(phoneNumbers + "",
							normalFont));
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
				cell = new PdfPCell(new Phrase(email, normalFont));
				cell.setColspan(4);
				cell.setBorder(0);
				table.addCell(cell);

				/*
				 * cell = new PdfPCell(new Phrase("")); cell.setBorder(0);
				 * cell.setColspan(1); table.addCell(cell);
				 */
				cell = new PdfPCell(new Phrase("Sito Internet:"));
				cell.setColspan(2);
				cell.setBorder(0);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(internetSite, normalFont));
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

				cell = new PdfPCell(new Phrase(fiscalCode, normalFont));
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

				cell = new PdfPCell(new Phrase(vatNumber, normalFont));
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

				cell = new PdfPCell(new Phrase(ibanCode, normalFont));
				cell.setColspan(3);
				cell.setBorder(0);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(""));
				cell.setBorder(0);
				cell.setColspan(1);
				table.addCell(cell);

				insertCell(table, new Phrase(" "), 6);
				insertCell(table, new Phrase(" "), 6);

				cell = new PdfPCell(
						new Phrase(
								"In nome e per conto dell'Associazione, il sottoscritto dichiara :"));
				cell.setColspan(6);
				cell.setBorder(0);
				table.addCell(cell);

				insertCell(table, new Phrase(" "), 6);

				cell = new PdfPCell(new Phrase(
						"- Di aver effettuato il versamento di EURO "
								+ versamento
								+ " per il Rinnovo dell'Affiliazione " + yearO
								+ " "));
				cell.setColspan(6);
				cell.setBorder(0);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase("- Di avere n. " + n_campi
						+ " campi da utilizzare in " + "contemporanea"));
				cell.setColspan(6);
				cell.setBorder(0);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase("- Di essere inquadrato nella "
						+ category + " categoria di " + "affiliazione"));
				cell.setColspan(6);
				cell.setBorder(0);
				table.addCell(cell);

				insertCell(table, new Phrase(" "), 6);
				insertCell(table, new Phrase(" "), 6);

				cell = new PdfPCell(new Phrase(
						" COMPOSIZIONE CONSIGLIO DIRETTIVO : "));
				cell.setColspan(6);
				cell.setBorder(0);
				table.addCell(cell);

				document.add(table);

				PdfPTable tableConsiglio = new PdfPTable(4);
				tableConsiglio.getDefaultCell().setPadding(4);
				tableConsiglio.getDefaultCell().setBorder(0);

				PdfPCell cellConsiglio;

				insertCell(tableConsiglio, new Phrase(" "), 4);

				cellConsiglio = new PdfPCell(new Phrase(
						("Titolo").toUpperCase()));
				cellConsiglio.setBorder(1);
				cellConsiglio.setColspan(1);
				tableConsiglio.addCell(cellConsiglio);

				cellConsiglio = new PdfPCell(new Phrase(
						("N.Tessera").toUpperCase()));
				cellConsiglio.setBorder(1);
				cellConsiglio.setColspan(1);
				tableConsiglio.addCell(cellConsiglio);

				cellConsiglio = new PdfPCell(new Phrase(
						("Cognome").toUpperCase()));
				cellConsiglio.setBorder(1);
				cellConsiglio.setColspan(1);
				tableConsiglio.addCell(cellConsiglio);

				cellConsiglio = new PdfPCell(new Phrase(("Nome").toUpperCase()));
				cellConsiglio.setBorder(1);
				cellConsiglio.setColspan(1);
				tableConsiglio.addCell(cellConsiglio);

				JSONArray consiglioJSONArray = JSONFactoryUtil
						.createJSONArray(arrTable);// consiglioJSONObject.getJSONArray("myRows");
				// System.out.println(consiglioJSONArray);
				for (int i = 0; i < consiglioJSONArray.length(); i++) {
					JSONObject jsonobject = consiglioJSONArray.getJSONObject(i);
					String col1 = jsonobject.getString("Titolo");
					String col2 = jsonobject.getString("N.Tessera");
					String col3 = jsonobject.getString("Cognome");
					String col4 = jsonobject.getString("Nome");
					if (Validator.isNotNull(col1) && Validator.isNotNull(col2)
							&& Validator.isNotNull(col3)
							&& Validator.isNotNull(col4)) {
						cellConsiglio = new PdfPCell(new Phrase(col1,
								normalFont));
						cellConsiglio.setBorder(1);
						cellConsiglio.setColspan(1);
						tableConsiglio.addCell(cellConsiglio);

						cellConsiglio = new PdfPCell(new Phrase(col2,
								normalFont));
						cellConsiglio.setBorder(1);
						cellConsiglio.setColspan(1);
						tableConsiglio.addCell(cellConsiglio);

						cellConsiglio = new PdfPCell(new Phrase(col3,
								normalFont));
						cellConsiglio.setBorder(1);
						cellConsiglio.setColspan(1);
						tableConsiglio.addCell(cellConsiglio);

						cellConsiglio = new PdfPCell(new Phrase(col4,
								normalFont));
						cellConsiglio.setBorder(1);
						cellConsiglio.setColspan(1);
						tableConsiglio.addCell(cellConsiglio);
					}

				}
				document.add(tableConsiglio);

				document.close();

				res.setContentType("application/pdf");

				res.addProperty(HttpHeaders.CACHE_CONTROL,
						"max-age=3600, must-revalidate");
				res.addProperty(HttpHeaders.CONTENT_DISPOSITION,
						"attachment; filename=ModuloAdesioneRinnovo_"
								+ associationName.replace(' ', '_') + ".pdf;");
				// res.setContentLength(baos.size());

				OutputStream out = res.getPortletOutputStream();
				baos.writeTo(out);

				out.flush();
				out.close();

			} catch (Exception e2) {
				System.out.println("Error in " + getClass().getName() + "\n"
						+ e2);
			}
		}

	}

	private static void insertCell(PdfPTable table, Phrase phrase, int colspan) {

		// create a new cell with the specified Text and Font
		PdfPCell cell = new PdfPCell(phrase);
		// set the cell alignment
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);

		cell.setColspan(colspan);
		cell.setBorder(0);
		cell.setMinimumHeight(12f);
		table.addCell("");

		// add the call to the table
		table.addCell(cell);

	}

	public void renewalCompanyAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws SystemException {

		int cardsNumber = ParamUtil.getInteger(actionRequest, "cardsNumber");
		int paymentType = ParamUtil.getInteger(actionRequest, "paymentType");
		long esfOrganizationId = ParamUtil.getLong(actionRequest,
				"esfOrganizationId");

		int actualYear = Calendar.getInstance().get(Calendar.YEAR);

		Date date = new Date();

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		try {
//			ESFRenewalCompany esfRenewalCompany = ESFRenewalCompanyLocalServiceUtil
//					.addESFRenewalCompany(themeDisplay.getUserId(),
//							esfOrganizationId, cardsNumber,
//							ManageDate.getYear(date), date, paymentType, 1);
//			ESFRenewalCompany esfRenewalCompany = ESFRenewalCompanyLocalServiceUtil
//					.addESFRenewalCompany(themeDisplay.getUserId(), esfOrganizationId, cardsNumber, year, date, paymentType, status, amount, info, accountholder, paymentDate, integrationAmount, integrationDate, integrationType, integrationAccountholder, join);
//			actionRequest.getPortletSession().setAttribute(
//					"esfRenewalCompanyId",
//					esfRenewalCompany.getEsfRenewalCompanyId(),
//					PortletSession.PORTLET_SCOPE);
			actionResponse.setRenderParameter("mvcPath",
					"/html/renewal/final.jsp");
		} catch (Exception ex) {
			SessionErrors.add(actionRequest, "error");
			SessionMessages
					.add(actionRequest,
							PortalUtil.getPortletId(actionRequest)
									+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			if (_log.isErrorEnabled()) {
				_log.error(ex);
			}
		}
	}

	public void paymentType(ActionRequest actionRequest,
			ActionResponse actionResponse) throws SystemException,
			PortalException {

		int paymentType = ParamUtil.getInteger(actionRequest, "paymentType");
		long esfRenewalCompanyId = (Long) actionRequest.getPortletSession()
				.getAttribute("esfRenewalCompanyId");

		ESFRenewalCompany esfRenewalCompany = ESFRenewalCompanyLocalServiceUtil
				.getESFRenewalCompany(esfRenewalCompanyId);

		esfRenewalCompany.setPaymentType(paymentType);
		esfRenewalCompany.setStatus(ESFRenewalConstants.RENEWAL_STATUS_PENDING);

		ESFRenewalCompanyLocalServiceUtil
				.updateESFRenewalCompany(esfRenewalCompany);
	}

	private static Log _log = LogFactoryUtil
			.getLog(RenewalCompanyPortlet.class);
}
