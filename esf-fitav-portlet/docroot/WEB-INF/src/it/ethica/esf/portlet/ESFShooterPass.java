package it.ethica.esf.portlet;

import it.ethica.esf.model.ESFCountry;
import it.ethica.esf.model.ESFGunKind;
import it.ethica.esf.service.ESFCountryLocalServiceUtil;
import it.ethica.esf.service.ESFGunKindLocalServiceUtil;
import it.ethica.esf.service.ESFGunTypeLocalServiceUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64.InputStream;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journalcontent.util.JournalContentUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;


public class ESFShooterPass extends MVCPortlet{
	
	public void serveResource(
		ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortletException {
		
		HttpServletRequest httpReq =
						PortalUtil.getHttpServletRequest(resourceRequest);
					httpReq = PortalUtil.getOriginalServletRequest(httpReq);
		
		boolean filterModelGun = ParamUtil.getBoolean(httpReq, "filterModelGun");
		boolean generatepass = ParamUtil.getBoolean(resourceRequest, "generatepass");
		
		long esfGunKindId1 = ParamUtil.getLong(httpReq, "esfGunKindId1", 0);
		long esfGunKindId2 = ParamUtil.getLong(httpReq, "esfGunKindId2", 0);
		long esfGunTypeId = 0;
		
		
		int type = ParamUtil.getInteger(httpReq, "type",0);
		
		
		
		JSONObject resultJSONObj = JSONFactoryUtil.createJSONObject();
		JSONArray resultJSONArr = JSONFactoryUtil.createJSONArray();
		
		if(0 < esfGunKindId1){
			esfGunTypeId = esfGunKindId1;
		}else{
			esfGunTypeId = esfGunKindId2;
		}
		
		if(filterModelGun){
			
			List<ESFGunKind> esfGunKinds = new ArrayList<ESFGunKind>();
			
			try {
				esfGunKinds =
					ESFGunKindLocalServiceUtil.getESFGunKindsByESFGunType(esfGunTypeId);
			}
			catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for (ESFGunKind esfGunKind : esfGunKinds) {
				
				JSONObject esfGunKindIdName =
						JSONFactoryUtil.createJSONObject();
				esfGunKindIdName.put(
					"esfGunKindId", esfGunKind.getEsfGunKindId());
				esfGunKindIdName.put("name", esfGunKind.getName());

				resultJSONArr.put(esfGunKindIdName);
			}

			resultJSONObj.put("esfGunKinds", resultJSONArr);

			resourceResponse.getWriter().write(resultJSONObj.toString());
		}
		
		if(generatepass){
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			String shooterName = ParamUtil.getString(resourceRequest, "shooterName");
			String cities = ParamUtil.getString(resourceRequest, "cities");
			String street1 = ParamUtil.getString(resourceRequest, "street1");
			String esfAssociation = ParamUtil.getString(resourceRequest, "esfAssociation");
			String matchType = ParamUtil.getString(resourceRequest, "matchType");
			String type1 = ParamUtil.getString(resourceRequest, "type1");
			String type2 = ParamUtil.getString(resourceRequest, "type2");
			String canesExtra = ParamUtil.getString(resourceRequest, "canesExtra");
			String firstCanesExtra = ParamUtil.getString(resourceRequest, "firstCanesExtra");
			String secondCanesExtra = ParamUtil.getString(resourceRequest, "secondCanesExtra");
			String nationalityId = ParamUtil.getString(resourceRequest, "nationality");
			
			int caliber1 = ParamUtil.getInteger(resourceRequest, "caliber1");
			int caliber2 = ParamUtil.getInteger(resourceRequest, "caliber2");
			int catridgeCaliber = ParamUtil.getInteger(resourceRequest, "catridgeCaliber");
			int freshman_1 = ParamUtil.getInteger(resourceRequest, "freshman_1");
			int freshman_2 = ParamUtil.getInteger(resourceRequest, "freshman_2");
			
			
			
			long gunKindId1 = ParamUtil.getLong(resourceRequest, "brand1");
			long gunKindId2 = ParamUtil.getLong(resourceRequest, "brand2");
			long kind1 = ParamUtil.getLong(resourceRequest, "kind1");
			long kind2 = ParamUtil.getLong(resourceRequest, "kind2");
			long catridgeId = ParamUtil.getLong(resourceRequest, "catridgeId");
			
			String birthday = ParamUtil.getString(resourceRequest, "birthday");
			String startDate = ParamUtil.getString(resourceRequest, "startDate");
			String endDate = ParamUtil.getString(resourceRequest, "endDate");
			
			

			ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			JournalArticle article;
			
			
			try {
				
				com.itextpdf.text.Document document = new com.itextpdf.text.Document();
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				PdfWriter writer = PdfWriter.getInstance(document, baos);
				document.open();
				
				
				article = JournalArticleLocalServiceUtil.getArticleByUrlTitle(themeDisplay.getScopeGroupId(), "Pass-Model");
				String passModel = JournalContentUtil.getContent( themeDisplay.getPortletGroupId(), article.getArticleId(), "", themeDisplay.getLocale().toString(), themeDisplay );
			
				String partecipantName = "";
				String _shooterBirthday = "";
				String _shooterCity = "";
				String _shooterCountry = "";
				String _shooterStreet = "";
				
				String _matchPlace = "";
				String _startDateMatch = "";
				String _endDateMatch = "";
				String _eventName = "";
				
				String _gunType2 = "";
				String _gunCaliber2 = "";
				String _gunBrand2 = "";
				String _gunModel2 = "";
				String _gunCode2 = "";
				
				String _gunType1 = "";
				String _gunCaliber1 = "";
				String _gunBrand1 = "";
				String _gunModel1 = "";
				String _gunCode1 = "";
				
				String _catridgeBrand = "";
				String _catridgeCaliber = "";
				
				String _caneType1 = "";
				String _caneType2 = "";
				String _caneType0 = "";
				
				
				if(Validator.isNotNull(shooterName)){
					partecipantName = shooterName;
				}
				
				if(Validator.isNotNull(birthday)){
					_shooterBirthday = birthday;
				}
				
				if(Validator.isNotNull(cities)){
					_shooterCity = cities;
				}
				
				if(Validator.isNotNull(street1)){
					_shooterStreet = street1;
				}
				
				
				if(Validator.isNotNull(ESFCountryLocalServiceUtil.fetchESFCountry(String.valueOf(nationalityId))) &&
								Validator.isNotNull(ESFCountryLocalServiceUtil.fetchESFCountry(String.valueOf(nationalityId)).getName()) ){
					_shooterCountry = ESFCountryLocalServiceUtil.fetchESFCountry(String.valueOf(nationalityId)).getName();
				}
				
				
				
				if(Validator.isNotNull(esfAssociation)){
					_matchPlace = esfAssociation;
				}
				
				if(Validator.isNotNull(startDate)){
					_startDateMatch = startDate;
				}
				
				if(Validator.isNotNull(endDate)){
					_endDateMatch = endDate;
				}
				
				if(Validator.isNotNull(matchType)){
					_eventName = matchType;
				}
				
				
				if(Validator.isNotNull(type1)){
					_gunType1 = type1;
				}
				
				if(Validator.isNotNull(caliber1)){
					_gunCaliber1 = String.valueOf(caliber1);
				}
				
				if(Validator.isNotNull(ESFGunTypeLocalServiceUtil.fetchESFGunType(gunKindId1)) && 
								Validator.isNotNull(ESFGunTypeLocalServiceUtil.fetchESFGunType(gunKindId1).getName())){
					_gunBrand1 = ESFGunTypeLocalServiceUtil.fetchESFGunType(gunKindId1).getName();
				}
				
				if(Validator.isNotNull(ESFGunKindLocalServiceUtil.fetchESFGunKind(kind1)) &&
								Validator.isNotNull(ESFGunKindLocalServiceUtil.fetchESFGunKind(kind1).getName())){
					_gunModel1 = ESFGunKindLocalServiceUtil.fetchESFGunKind(kind1).getName();
				}
				
				if(Validator.isNotNull(freshman_1)){
					_gunCode1 = String.valueOf(freshman_1);
				}
				
				
				if(Validator.isNotNull(type2)){
					_gunType2 = type2;
				}
				
				if(Validator.isNotNull(caliber2)){
					_gunCaliber2 = String.valueOf(caliber2);
				}
				
				if(Validator.isNotNull(ESFGunTypeLocalServiceUtil.fetchESFGunType(gunKindId2)) && 
								Validator.isNotNull(ESFGunTypeLocalServiceUtil.fetchESFGunType(gunKindId2).getName())){
					_gunBrand2 = ESFGunTypeLocalServiceUtil.fetchESFGunType(gunKindId2).getName();
				}
				
				if(Validator.isNotNull(ESFGunKindLocalServiceUtil.fetchESFGunKind(kind2)) &&
								Validator.isNotNull(ESFGunKindLocalServiceUtil.fetchESFGunKind(kind2).getName())){
					_gunModel2 = ESFGunKindLocalServiceUtil.fetchESFGunKind(kind2).getName();
				}
				
				if(Validator.isNotNull(freshman_2)){
					_gunCode2 = String.valueOf(freshman_2);
				}
				
				
				if(Validator.isNotNull(ESFGunTypeLocalServiceUtil.fetchESFGunType(catridgeId)) && 
								Validator.isNotNull(ESFGunTypeLocalServiceUtil.fetchESFGunType(catridgeId).getName())){
					_catridgeBrand = ESFGunTypeLocalServiceUtil.fetchESFGunType(catridgeId).getName();
				}
				
				if(Validator.isNotNull(catridgeCaliber)){
					_catridgeCaliber = String.valueOf(catridgeCaliber);
				}
				
				if(Validator.isNotNull(canesExtra)){
					_caneType0 = canesExtra;
				}
				
				if(Validator.isNotNull(firstCanesExtra)){
					_caneType1 = firstCanesExtra;
				}
				
				if(Validator.isNotNull(secondCanesExtra)){
					_caneType2 = secondCanesExtra;
				}
				
				
				
				passModel = passModel.replaceAll("_shooterName", partecipantName);
				passModel = passModel.replaceAll("_shooterBirthday", _shooterBirthday); 
				passModel = passModel.replaceAll("_shooterCity", _shooterCity); 
				passModel = passModel.replaceAll("_shooterCountry", _shooterCountry); 
				passModel = passModel.replaceAll("_shooterStreet", _shooterStreet);
				passModel = passModel.replaceAll("_matchPlace", _matchPlace);
				
				passModel = passModel.replaceAll("_matchDescription", _eventName); 
				passModel = passModel.replaceAll("_matchStartDate", _startDateMatch);
				passModel = passModel.replaceAll("_matchEndDate", _endDateMatch);
				
				
				passModel = passModel.replaceAll("_gunBrand1", _gunBrand2);
				passModel = passModel.replaceAll("_gunModel1", _gunModel2);
				passModel = passModel.replaceAll("_gunType1", _gunType2);
				passModel = passModel.replaceAll("_gunCode1", _gunCode2);
				passModel = passModel.replaceAll("_gunCaliber1", _gunCaliber2);
				passModel = passModel.replaceAll("_gunBrand0", _gunBrand1);
				passModel = passModel.replaceAll("_gunModel0", _gunModel1);
				passModel = passModel.replaceAll("_gunType0", _gunType1);
				passModel = passModel.replaceAll("_gunCode0", _gunCode1);
				passModel = passModel.replaceAll("_gunCaliber0", _gunCaliber1);
				
				passModel = passModel.replaceAll("_catridgeBrand", _catridgeBrand);
				passModel = passModel.replaceAll("_catridgeCaliber", _catridgeCaliber);
				passModel = passModel.replaceAll("_caneType0", _caneType0);
				passModel = passModel.replaceAll("_caneType1", _caneType1);
				passModel = passModel.replaceAll("_caneType2", _caneType2);
				
				
				
				
				XMLWorkerHelper worker = XMLWorkerHelper.getInstance();
				ByteArrayInputStream is = new ByteArrayInputStream(passModel.getBytes(StandardCharsets.UTF_8));
				worker.parseXHtml(writer, document, is, Charset.forName("UTF-8"));
				
				
				document.close();
				resourceResponse.setContentType("application/pdf");
				resourceResponse.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");
				resourceResponse.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename= Lasciapassare.pdf;");
				OutputStream out = resourceResponse.getPortletOutputStream();
				baos.writeTo(out);
				out.flush();
				out.close();
				
				
			}
			catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
		}
		
	}
	
	private static Log _log = LogFactoryUtil.getLog(ESFShooterPass.class);
}
