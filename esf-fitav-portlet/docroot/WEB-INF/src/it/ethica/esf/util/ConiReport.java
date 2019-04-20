package it.ethica.esf.util;

import it.ethica.esf.model.ESFAddress;
import it.ethica.esf.model.ESFAnnualConiReport;
import it.ethica.esf.model.ESFEntityState;
import it.ethica.esf.model.ESFField;
import it.ethica.esf.model.ESFFieldESFSportType;
import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.model.ESFPhone;
import it.ethica.esf.model.ESFShooterAffiliationChrono;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.impl.ESFAddressImpl;
import it.ethica.esf.model.impl.ESFAnnualConiReportImpl;
import it.ethica.esf.model.impl.ESFEntityStateImpl;
import it.ethica.esf.model.impl.ESFOrganizationImpl;
import it.ethica.esf.model.impl.ESFUserImpl;
import it.ethica.esf.portlet.ESFReportPortlet;
import it.ethica.esf.service.ESFAddressLocalServiceUtil;
import it.ethica.esf.service.ESFAnnualConiReportLocalServiceUtil;
import it.ethica.esf.service.ESFCityLocalServiceUtil;
import it.ethica.esf.service.ESFEntityStateLocalServiceUtil;
import it.ethica.esf.service.ESFFieldESFSportTypeLocalServiceUtil;
import it.ethica.esf.service.ESFFieldLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;
import it.ethica.esf.service.ESFPhoneLocalServiceUtil;
import it.ethica.esf.service.ESFSportTypeLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;
import it.ethica.esf.service.impl.ESFAnnualConiReportLocalServiceImpl;
import it.ethica.esf.service.persistence.ESFAnnualConiReportPersistence;
import it.ethica.esf.service.persistence.ESFAnnualConiReportUtil;
import it.ethica.esf.service.persistence.ESFCityPK;
import it.ethica.esf.service.persistence.ESFFieldESFSportTypePersistence;
import it.ethica.esf.service.persistence.ESFFieldESFSportTypeUtil;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.EmailAddress;
import com.liferay.portal.model.ListType;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.Phone;
import com.liferay.portal.model.Role;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.EmailAddressLocalServiceUtil;
import com.liferay.portal.service.ListTypeServiceUtil;
import com.liferay.portal.service.PhoneLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.persistence.AddressUtil;
import com.liferay.portal.service.persistence.RoleUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;


public class ConiReport extends MVCPortlet{
	
	private ActionRequest request;
	private ActionResponse response;
	
	public ActionRequest getRequest() {
		
		return request;
	}
	
	public void setRequest(ActionRequest request) {
	
		this.request = request;
	}

	public ActionResponse getResponse() {
	
		return response;
	}
	
	public void setResponse(ActionResponse response) {
	
		this.response = response;
	}
	
	public boolean generateConiReport( boolean notNewAssociation , ResourceRequest reqest, ResourceResponse response)
		throws SystemException, PortalException, PortletException{
		
		boolean error = false;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			ThemeDisplay themeDisplay = (ThemeDisplay)reqest.getAttribute(WebKeys.THEME_DISPLAY);
			
			Date createDate = new Date();
			String type = "FSN";
			String sign = "FITAV";
			String transmissionDate = sdf.format(createDate);
			int count = 1;
			
			Workbook workBook = new HSSFWorkbook();
			CreationHelper createHelper = workBook.getCreationHelper();
			Sheet sheet = workBook.createSheet("new sheet");
			Row row = sheet.createRow((short)0);
			
			row.createCell(0).setCellValue(createHelper.createRichTextString("tipo"));
			row.createCell(1).setCellValue(createHelper.createRichTextString("sigla"));
			row.createCell(2).setCellValue(createHelper.createRichTextString("data trasmissione flusso"));
			row.createCell(3).setCellValue(createHelper.createRichTextString("Denominazione"));
			row.createCell(4).setCellValue(createHelper.createRichTextString("codice affiliazione"));
			row.createCell(5).setCellValue(createHelper.createRichTextString("data prima affiliazione"));
			row.createCell(6).setCellValue(createHelper.createRichTextString("data ultima affiliazione"));
			row.createCell(7).setCellValue(createHelper.createRichTextString("data scadenza Affiliazione"));
			row.createCell(8).setCellValue(createHelper.createRichTextString("data eventuale proroga affiliazione"));
			row.createCell(9).setCellValue(createHelper.createRichTextString("stato affiliazione"));
			row.createCell(10).setCellValue(createHelper.createRichTextString("tipo società"));
			row.createCell(11).setCellValue(createHelper.createRichTextString("polisportiva"));
			row.createCell(12).setCellValue(createHelper.createRichTextString("(indirizzo) c/o"));
			row.createCell(13).setCellValue(createHelper.createRichTextString("(indirizzo) via/piazza n°"));
			row.createCell(14).setCellValue(createHelper.createRichTextString("(indirizzo) cap"));
			row.createCell(15).setCellValue(createHelper.createRichTextString("(indirizzo) città"));
			row.createCell(16).setCellValue(createHelper.createRichTextString("(indirizzo) provincia"));
			row.createCell(17).setCellValue(createHelper.createRichTextString("partita iva"));
			row.createCell(18).setCellValue(createHelper.createRichTextString("codice fiscale"));
			row.createCell(19).setCellValue(createHelper.createRichTextString("e-mail"));
			row.createCell(20).setCellValue(createHelper.createRichTextString("fax"));
			row.createCell(21).setCellValue(createHelper.createRichTextString("telefono"));
			row.createCell(22).setCellValue(createHelper.createRichTextString("(legale rappresentante) cognome"));
			row.createCell(23).setCellValue(createHelper.createRichTextString("(legale rappresentante) nome"));
			row.createCell(24).setCellValue(createHelper.createRichTextString("(legale rappresentante) e-mail"));
			row.createCell(25).setCellValue(createHelper.createRichTextString("(legale rappresentante) telefono"));
			row.createCell(26).setCellValue(createHelper.createRichTextString("(legale rappresentante) codice fiscale"));
			row.createCell(27).setCellValue(createHelper.createRichTextString("discipline"));
			
			
			for(int i = 0 ; i < 28 ; i++){
				sheet.autoSizeColumn(i);
			}
			
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			
			List<ESFOrganization> organizations = new ArrayList<ESFOrganization>();
			
			if(notNewAssociation){
					organizations = ESFOrganizationLocalServiceUtil.findAllAffilationConiReportAndArmy();
			}else{
				organizations = ESFOrganizationLocalServiceUtil.findNewAffilationConiReportAndArmy(year);
			}
			_log.debug("******");
			
			Collections.sort(
				organizations, new Comparator<ESFOrganization>() {
					public int compare(ESFOrganization c1, ESFOrganization c2) {
						if (c1.getCode().compareTo(c2.getCode()) <0) return -1;
						if (c1.getCode().compareTo(c2.getCode()) >0) return 1;
						return 0;
					}
				}
			);
			int contatore=0;
			for(ESFOrganization o : organizations){
				
				contatore++;
				ESFEntityState entityState = new ESFEntityStateImpl();
				ESFAddress legalAddress = new ESFAddressImpl();
				ESFUser president = new ESFUserImpl();
				ESFCityPK cityPk = new ESFCityPK();
				List<ESFUser> presidents = new ArrayList<ESFUser>();
				List<ESFEntityState> oldEntityState = new ArrayList<ESFEntityState>();
				List<ESFAddress> associationAddress = new ArrayList<ESFAddress>();
				List<EmailAddress> emailAddresses = new ArrayList<EmailAddress>(); 
				List<Phone> phones = new ArrayList<Phone>();
				List<ESFField> fields = new ArrayList<ESFField>();
				List<ESFFieldESFSportType> fsts = new ArrayList<ESFFieldESFSportType>();
				List<Long> stIds = new ArrayList<Long>();
				
				
				entityState = ESFEntityStateLocalServiceUtil.findESFEntityStateByC_PK_S("it.ethica.esf.model.ESFOrganization", o.getEsfOrganizationId(), ESFKeys.ESFStateType.ENABLE);
				oldEntityState = ESFEntityStateLocalServiceUtil.findESFEntityStateCName_CPk("it.ethica.esf.model.ESFOrganization", o.getEsfOrganizationId());
				
				
				String denomination = "*****";
				String code = "*****";
				String firstAffiliationDate = "*****"; 
				String lastAffiliationDate = "*****";
				String affiliationYear = StringPool.BLANK;
				String endAffiliationDate = "31/12/";
				String extensionDate = StringPool.BLANK;
				String stateName = "*****";
				String associationType = StringPool.BLANK;
				String isMultisport = StringPool.BLANK;
				String coAddress = StringPool.BLANK;
				String assStreet = StringPool.BLANK;
				String assCAP = StringPool.BLANK;
				String assCity = StringPool.BLANK;
				String assProv = "*****";
				String assIVA = StringPool.BLANK;
				String assCF = "*****";
				String assEmail = "*****";
				String assFax = StringPool.BLANK;
				String assPhone = StringPool.BLANK;
				String presidentName = "*****";
				String presdientLastName = "*****";
				String presidentMail = StringPool.BLANK;
				String presidentPhone = StringPool.BLANK;
				String presidentCF = "*****";
				String disciplines = StringPool.BLANK;
				
				
				if(Validator.isNotNull( o.getCode())){
					
					code = o.getCode();
				}else{
					error = true;
				}
				
				if(Validator.isNotNull( o.getName())){
					denomination = o.getName();
				}else{
					error = true;
				}
				
				if(Validator.isNotNull(o.getFirstAffiliationDate())  && Validator.isNotNull(sdf.format(o.getFirstAffiliationDate()))){
					firstAffiliationDate = sdf.format(o.getFirstAffiliationDate());
				}else{
					error = true;
				}
				
				if(Validator.isNotNull(entityState) && Validator.isNotNull(entityState.getStartDate())){
					lastAffiliationDate = sdf.format(entityState.getStartDate());
				}else{
					error = true;
				}
				
				if(Validator.isNotNull(entityState) && Validator.isNotNull(entityState.getStartDate())){
					Date date;
					cal.setTime(entityState.getStartDate());
					affiliationYear = String.valueOf(cal.get(Calendar.YEAR));
					endAffiliationDate = endAffiliationDate+affiliationYear;
				}else{
					error = true;
				}
				
				if(Validator.isNotNull(oldEntityState) && 1 == oldEntityState.size()){
					stateName = "0";
				} else if(Validator.isNotNull(oldEntityState) && 1 < oldEntityState.size()){
					stateName = "1";
				}else{
					error = true;
				}
				
				ListType legalForms = null; 
				if(Validator.isNumber(o.getLegalForm())){
					 legalForms = ListTypeServiceUtil.getListType(Integer.valueOf(o.getLegalForm()));
				}
				
				if(Validator.isNotNull(legalForms)){
					if(legalForms.getName().contains("-anr")){
						associationType = "ANR";
					} else if(legalForms.getName().contains("-asr")){
						associationType = "ASR";
					}else if(legalForms.getName().contains("-soc")){
						associationType = "SOC";
					}
				}
				
				if(Validator.isNotNull(o.getIsMultiSport()) && o.getIsMultiSport()){
					isMultisport = "1";
				}else if(Validator.isNotNull(o.getIsMultiSport()) && !o.getIsMultiSport()){
					isMultisport = "0";
				}
				
				associationAddress = ESFAddressLocalServiceUtil.getESFAddresses(themeDisplay.getCompanyId(), Organization.class.getName(), o.getEsfOrganizationId());
				
				ListType typeadd= null;
				
				if(Validator.isNotNull(associationAddress) && !associationAddress.isEmpty()){
					for(ESFAddress a : associationAddress){
						
						if(Validator.isNotNull(a) && Validator.isNotNull(a.getListTypeId()) && Validator.isNotNull(ListTypeServiceUtil.getListType(a.getListTypeId())) &&
									"legal".equals(ListTypeServiceUtil.getListType(a.getListTypeId()).getName())){
							
							legalAddress = a;
							
							if(Validator.isNotNull( a.getStreet1())){
								assStreet = a.getStreet1();
							}
							
							if(Validator.isNotNull( a.getZip())){
								assCAP = a.getZip();
							}
							
							if(a.getEsfCityId()>0){
								cityPk.setIdCity(a.getEsfCityId());
								cityPk.setIdCountry(a.getEsfCountryId());
								cityPk.setIdProvince(a.getEsfProvinceId());
								cityPk.setIdRegion(a.getEsfRegionId());
							} else {
								cityPk = null;
							}
							
							if( Validator.isNotNull(cityPk) && Validator.isNotNull(ESFCityLocalServiceUtil.fetchESFCity(cityPk)) 
											&& Validator.isNotNull(ESFCityLocalServiceUtil.fetchESFCity(cityPk).getName())){
								assCity = ESFCityLocalServiceUtil.fetchESFCity(cityPk).getName();
							}
							
							if(Validator.isNotNull(a.getEsfProvinceId())){
								assProv = a.getEsfProvinceId();
							}else {
								error = true;
							}
	
						} else {
							error = true;
						}
						
					}
				}
				
				if(Validator.isNotNull(o.getVat())){
					assIVA = o.getVat();
				}
				
				if(Validator.isNotNull(o.getFiscalCode()) && 11 == o.getFiscalCode().length()){
					assCF = o.getFiscalCode();
				}else{
					error = true;
				}
				
				emailAddresses = EmailAddressLocalServiceUtil.getEmailAddresses(themeDisplay.getCompanyId(),
					Organization.class.getName(),o.getEsfOrganizationId());
				
				if (emailAddresses != null && emailAddresses.size() > 0) {
					assEmail = emailAddresses.get(0).getAddress();
				}else{
					error = true;
				}
				
				phones = PhoneLocalServiceUtil.getPhones(themeDisplay.getCompanyId(),  Organization.class.getName(), o.getEsfOrganizationId());
				
				if(Validator.isNotNull(phones) && 0 < phones.size()){
					for(Phone p : phones){
						ESFPhone esfPhone = ESFPhoneLocalServiceUtil.fetchESFPhone(p.getPhoneId());
						ListType typePhone =  ListTypeServiceUtil.getListType(esfPhone.getListTypeId());
						
						if("fax".equalsIgnoreCase(typePhone.getName())){
							assFax = p.getNumber();
						}
						
						if("other".equalsIgnoreCase(typePhone.getName())){
							assPhone = p.getNumber();
						}
					}
				}
				
				Role presidentRole = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), "Presidente Associazione");
				
				presidents = ESFUserLocalServiceUtil.findAllUserByRolenoNull(presidentRole.getRoleId(), o.getEsfOrganizationId());
				
				if(Validator.isNotNull(presidents) && !presidents.isEmpty()){
					president = presidents.get(0);
					
					if(Validator.isNotNull(president.getLastName())){
						presdientLastName = president.getLastName();
					}else{
						error = true;
					}
					
					if(Validator.isNotNull(president.getFirstName())){
						presidentName = president.getFirstName();
					}else{
						error = true;
					}
					
					if(Validator.isNotNull(president.getFiscalCode())){
						presidentCF = president.getFiscalCode();
					}else{
						error = true;
					}
					
					if(Validator.isNotNull(president.getUserEmail())){
						presidentMail = president.getUserEmail();
					}
					if(presidentMail.startsWith("testim-") || presidentMail.startsWith("test-")){
						presidentMail=StringPool.BLANK;
					}
						
					phones = PhoneLocalServiceUtil.getPhones(themeDisplay.getCompanyId(),  ESFUser.class.getName(), president.getEsfUserId());
					
					if(!phones.isEmpty()) {

						presidentPhone = phones.get(0).getNumber();
					}
					
				}else{
					error = true;
				}
				
				fields = ESFFieldLocalServiceUtil.findByESFOrganization(o.getEsfOrganizationId(), ESFKeys.ESFStateType.ENABLE);
				
				if(0 < fields.size()){
					
					for(ESFField f : fields){
						
						fsts = ESFFieldESFSportTypeLocalServiceUtil.findByesfFieldId(f.getEsfFieldId());
						
						for(ESFFieldESFSportType fst :fsts){

							if(!stIds.contains(fst.getEsfSportTypeId())){

								stIds.add(fst.getEsfSportTypeId());

							}
						}
					}
					
					for(Long stId : stIds){

						if(Validator.isNotNull(ESFSportTypeLocalServiceUtil.fetchESFSportType(stId)) 
										&& Validator.isNotNull(ESFSportTypeLocalServiceUtil.fetchESFSportType(stId).getCode())){
							disciplines = disciplines + ","+ESFSportTypeLocalServiceUtil.fetchESFSportType(stId).getCode();

						}
						
					}
					
				}else{
					error = true;
					disciplines = "******";
				}
				
				disciplines = disciplines.substring(1, disciplines.length());
				
				Row rowOrg = sheet.createRow((short)count);
				
				rowOrg.createCell(0).setCellValue(createHelper.createRichTextString(type));
				rowOrg.createCell(1).setCellValue(createHelper.createRichTextString(sign));
				rowOrg.createCell(2).setCellValue(createHelper.createRichTextString(transmissionDate));
				rowOrg.createCell(3).setCellValue(createHelper.createRichTextString(denomination));
				rowOrg.createCell(4).setCellValue(createHelper.createRichTextString(code));
				rowOrg.createCell(5).setCellValue(createHelper.createRichTextString(firstAffiliationDate));
				rowOrg.createCell(6).setCellValue(createHelper.createRichTextString(lastAffiliationDate));
				rowOrg.createCell(7).setCellValue(createHelper.createRichTextString(endAffiliationDate));
				rowOrg.createCell(8).setCellValue(createHelper.createRichTextString(extensionDate));
				rowOrg.createCell(9).setCellValue(createHelper.createRichTextString(stateName));
				rowOrg.createCell(10).setCellValue(createHelper.createRichTextString(associationType));
				rowOrg.createCell(11).setCellValue(createHelper.createRichTextString(isMultisport));
				rowOrg.createCell(12).setCellValue(createHelper.createRichTextString(coAddress));
				rowOrg.createCell(13).setCellValue(createHelper.createRichTextString(assStreet));
				rowOrg.createCell(14).setCellValue(createHelper.createRichTextString(assCAP));
				rowOrg.createCell(15).setCellValue(createHelper.createRichTextString(assCity));
				rowOrg.createCell(16).setCellValue(createHelper.createRichTextString(assProv));
				rowOrg.createCell(17).setCellValue(createHelper.createRichTextString(assIVA));
				rowOrg.createCell(18).setCellValue(createHelper.createRichTextString(assCF));
				rowOrg.createCell(19).setCellValue(createHelper.createRichTextString(assEmail));
				rowOrg.createCell(20).setCellValue(createHelper.createRichTextString(assFax));
				rowOrg.createCell(21).setCellValue(createHelper.createRichTextString(assPhone));
				rowOrg.createCell(22).setCellValue(createHelper.createRichTextString(presdientLastName));
				rowOrg.createCell(23).setCellValue(createHelper.createRichTextString(presidentName));
				rowOrg.createCell(24).setCellValue(createHelper.createRichTextString(presidentMail));
				rowOrg.createCell(25).setCellValue(createHelper.createRichTextString(presidentPhone));
				rowOrg.createCell(26).setCellValue(createHelper.createRichTextString(presidentCF));
				rowOrg.createCell(27).setCellValue(createHelper.createRichTextString(disciplines));
				
				boolean find = ESFAnnualConiReportLocalServiceUtil.findAffiliationByYear(o.getEsfOrganizationId(), year);
				
				if(!find){
					
					ESFAnnualConiReport acr = new ESFAnnualConiReportImpl();
					long annualConiReportId = CounterLocalServiceUtil.increment(ESFAnnualConiReport.class.getName());
					acr.setAnnualConiReportId(annualConiReportId);
					acr.setAssId(o.getEsfOrganizationId());
					acr.setYear(year);
					ESFAnnualConiReportLocalServiceUtil.addESFAnnualConiReport(acr);
					
				}
				
				//ESFAnnualConiReport annualConiReport = ESFAnnualConiReport.findByAssYear(o.getEsfOrganizationId(), year);
				
				count = count+1;

			}
			
			response.setContentType("application/vnd.ms-excel");
			response.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=coni "+transmissionDate+".xls");//
			OutputStream out = response.getPortletOutputStream();
			workBook.write(out);
			out.flush();
			out.close();
		}
		catch (Exception e) {
			// TODO: handle exception
			_log.error("errore compilazione excel ");
			error = true;
		}
		return error;
	}
	private static Log _log = LogFactoryUtil.getLog(ConiReport.class);
}
