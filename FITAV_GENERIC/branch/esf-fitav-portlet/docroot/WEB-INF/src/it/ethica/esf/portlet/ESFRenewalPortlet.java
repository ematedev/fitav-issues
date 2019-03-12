
package it.ethica.esf.portlet;

import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

import it.ethica.esf.NoSuchUserESFUserRoleException;
import it.ethica.esf.migration.util.ESFKeys;
import it.ethica.esf.model.ESFEntityState;
import it.ethica.esf.model.ESFField;
import it.ethica.esf.model.ESFGunKind;
import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.model.ESFRenewal;
import it.ethica.esf.model.ESFUserESFUserRole;
import it.ethica.esf.model.ESFUserRole;
import it.ethica.esf.model.impl.ESFRenewalImpl;
import it.ethica.esf.service.ESFConfigurationLocalServiceUtil;
import it.ethica.esf.service.ESFEntityStateLocalServiceUtil;
import it.ethica.esf.service.ESFFieldLocalService;
import it.ethica.esf.service.ESFFieldLocalServiceUtil;
import it.ethica.esf.service.ESFGunKindLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;
import it.ethica.esf.service.ESFRenewalLocalServiceUtil;
import it.ethica.esf.service.ESFUserESFUserRoleLocalServiceUtil;
import it.ethica.esf.service.ESFUserRoleLocalServiceUtil;
import it.ethica.esf.service.impl.ESFFieldLocalServiceImpl;
import it.ethica.esf.service.persistence.ESFRenewalUtil;
import it.ethica.esf.util.ManageDate;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.portlet.PortletProps;
import com.sun.org.apache.xerces.internal.impl.validation.EntityState;

/**
 * Portlet implementation class ESFRenewalPortlet
 */
public class ESFRenewalPortlet extends MVCPortlet {
	
	public void addRenewal(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException {
		
		ServiceContext serviceContext =
				ServiceContextFactory.getInstance(actionRequest);
		
		long userId = serviceContext.getUserId();
		
		User user = UserLocalServiceUtil.getUser(userId);
		
		long organizationId = user.getGroup().getClassPK();
		String testOrg =ParamUtil.getString(actionRequest,"organizationId");
		
		if(!testOrg.equals("")){
			
			organizationId = Long.parseLong(actionRequest.getParameter("organizationId"));
		
		}
		
		String operation = actionRequest.getParameter("operation");		
		
		long esfRenewalId =
			CounterLocalServiceUtil.increment(it.ethica.esf.model.ESFRenewal.class.getName());
		
		String madeBy = ParamUtil.getString(actionRequest, "madeBy");
		long quantity = 1;
		String info = ParamUtil.getString(actionRequest, "info");
		double amount = 0;
		double amountTot = 0;
		long groupId = user.getGroup().getClassPK();
		boolean affiliates = false;
		boolean isTotal = true;
		
		String className = ESFOrganization.class.getName();
		
		ESFEntityState  entityState = ESFEntityStateLocalServiceUtil.findESFEntityStateByC_PK(className, organizationId);
		String paymentDateString =
			ParamUtil.getString(actionRequest, "paymentDate");
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
		Date paymentDate = new Date();
		
		int affiliatesYear = ManageDate.getYear(paymentDate);
		
		if(ParamUtil.getInteger(actionRequest, "affiliatesYear") != 0){
			affiliatesYear = ParamUtil.getInteger(actionRequest, "affiliatesYear") ;
		}
		try {
			paymentDate = df.parse(paymentDateString);
		}
		catch (ParseException e) {
			e.getMessage();
		}
		
		String paymentType = ParamUtil.getString(actionRequest, "paymentType");
		Long companyId = serviceContext.getCompanyId();
		ESFRenewal esfRenewal = new ESFRenewalImpl();
		
		if (operation.equals("buy-many-cards")) {
			quantity =
				Long.parseLong(ParamUtil.getString(actionRequest, "quantity"));
			
		}
		
		if (operation.equals("buy-one-card")) {
			amount =
				Double.parseDouble(PortletProps.get("esf-renewal-member-card-cost"));
			amountTot = amount;
		}
		else if (operation.equals("buy-many-cards")) {
			amount =
				quantity *
					Double.parseDouble(PortletProps.get("esf-renewal-member-card-cost"));
			amountTot = amount;
		}
		else if(operation.equals("first-registration")){
			amount = ParamUtil.getDouble(actionRequest, "amountTot");
			affiliates = ParamUtil.getBoolean(actionRequest, "affiliates");
			amountTot = amount;
			isTotal = true;
		}
		else {
			amountTot = ParamUtil.getDouble(actionRequest, "amountTot");
			affiliates = ParamUtil.getBoolean(actionRequest, "affiliates");
			amount = ParamUtil.getDouble(actionRequest, "amount");
			className = ESFOrganization.class.getName();
			if(amount<amountTot){
				isTotal = false;
			}
		}
		
		esfRenewal.setOrganizationId(organizationId);
		esfRenewal.setModifiedDate(new Date());
		esfRenewal.setPaymentReceived(false);
		esfRenewal.setPaymentReason(operation);
		esfRenewal.setQuantity(quantity);
		esfRenewal.setPaymentType(paymentType);
		esfRenewal.setCompanyId(companyId);
		esfRenewal.setUserId(userId);
		esfRenewal.setCreateDate(new Date());
		esfRenewal.setPaymentDate(paymentDate);
		esfRenewal.setGroupId(groupId);
		esfRenewal.setInfo(info);
		esfRenewal.setMadeBy(madeBy);
		esfRenewal.setPrimaryKey(esfRenewalId);
		esfRenewal.setAmount(amount);
		esfRenewal.setReportingYear(affiliatesYear);
		esfRenewal.setAmountTotal(amountTot);
		esfRenewal.setIsTotal(isTotal);
		esfRenewal.setRenewalFatherId(0); 
		esfRenewal.setAffiliates(affiliates);
		
		ESFRenewal esfRenewalResult =
			ESFRenewalLocalServiceUtil.addESFRenewal(esfRenewal);
		
		if (Validator.isNotNull(esfRenewalResult) &&
			esfRenewalResult.getEsfRenewalId() > 0){
			SessionMessages.add(actionRequest, "renewal-success-insert");
		}
		else{
			SessionErrors.add(actionRequest, "renewal-error-insert");
		}
		
	}
	
	public void addIncrement (ActionRequest actionRequest, ActionResponse actionResponse)
			throws PortalException, SystemException {
		
		long esfRenewalId =
				CounterLocalServiceUtil.increment(it.ethica.esf.model.ESFRenewal.class.getName());
		long esfOldRenewalId = ParamUtil.getLong(actionRequest, "esfRenewalId");
		ServiceContext serviceContext =
				ServiceContextFactory.getInstance(actionRequest);
		
		long userId = serviceContext.getUserId();
		long quantity = 1;
		User user = UserLocalServiceUtil.getUser(userId);
		long groupId = user.getGroup().getClassPK();
		Long companyId = serviceContext.getCompanyId();
		long organizationId = ParamUtil.getLong(actionRequest, "organizationId");
		//String testOrg =ParamUtil.getString(actionRequest,"organizationId");
		String madeBy = ParamUtil.getString(actionRequest, "madeBy");
		String info = ParamUtil.getString(actionRequest, "info");
		boolean affiliates = ParamUtil.getBoolean(actionRequest, "affiliates");
		String paymentDateString =
				ParamUtil.getString(actionRequest, "paymentDate");
		String operation = actionRequest.getParameter("operation");
		String paymentType = ParamUtil.getString(actionRequest, "paymentType");
		boolean isTotal = true;
		double amountTot = 0;
		double amount = 0;
		double lastPayment = 0;
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
		Date paymentDate = new Date();
		int affiliatesYear = 0;
		amountTot = 0;
		
		int fild;
		fild = ESFFieldLocalServiceUtil.findByESFOrganization(
				organizationId, ESFKeys.ESFStateType.ENABLE).size();
		if(fild==0){
			amountTot = Double.valueOf( ESFConfigurationLocalServiceUtil.
					 getESFConfigurationByESFKey("first-registration-cost").getValue());
			}else if(fild==1){
				amountTot = Double.valueOf( ESFConfigurationLocalServiceUtil.
						 getESFConfigurationByESFKey("first-registration-cost-1").getValue());
			}else if(fild==2 ){
				amountTot =  Double.valueOf( ESFConfigurationLocalServiceUtil.
						 getESFConfigurationByESFKey("first-registration-cost-2").getValue());
			}else if( fild==3){
				amountTot =  Double.valueOf( ESFConfigurationLocalServiceUtil.
						 getESFConfigurationByESFKey("first-registration-cost-3").getValue());
			}else if(fild==4){
				amountTot =  Double.valueOf( ESFConfigurationLocalServiceUtil.
						 getESFConfigurationByESFKey("first-registration-cost-4").getValue());
			}else if(fild==5){
				amountTot =  Double.valueOf( ESFConfigurationLocalServiceUtil.
						 getESFConfigurationByESFKey("first-registration-cost-5").getValue());
			}else{
				amountTot =  Double.valueOf( ESFConfigurationLocalServiceUtil.
						 getESFConfigurationByESFKey("first-registration-cost-6").getValue());
			}
		
		amount = ParamUtil.getDouble(actionRequest, "amount");
		lastPayment = ParamUtil.getDouble(actionRequest, "lastPayment");
		long esfRenewalFatherId = ParamUtil.getLong(actionRequest, "esfRenewalId");
		ESFRenewal fatherRen = ESFRenewalLocalServiceUtil.fetchESFRenewal(esfRenewalFatherId);
		if((amount+lastPayment)<amountTot){
			isTotal = false;
			
		}else{
			
			fatherRen.setIsTotal(true);
			ESFRenewalLocalServiceUtil.updateESFRenewal(fatherRen);
		}
		affiliatesYear = fatherRen.getReportingYear();
		
		ESFRenewal esfRenewal = new ESFRenewalImpl();
		esfRenewal.setOrganizationId(organizationId);
		esfRenewal.setModifiedDate(new Date());
		esfRenewal.setPaymentReceived(false);
		esfRenewal.setPaymentReason(operation);
		esfRenewal.setQuantity(quantity );
		esfRenewal.setPaymentType(paymentType);
		esfRenewal.setCompanyId(companyId);
		esfRenewal.setUserId(userId);
		esfRenewal.setCreateDate(new Date());
		esfRenewal.setPaymentDate(paymentDate);
		esfRenewal.setGroupId(groupId);
		esfRenewal.setInfo(info);
		esfRenewal.setMadeBy(madeBy);
		esfRenewal.setPrimaryKey(esfRenewalId);
		esfRenewal.setAmount(amount);
		esfRenewal.setReportingYear(affiliatesYear);
		esfRenewal.setAmountTotal(amountTot);
		esfRenewal.setIsTotal(isTotal);
		esfRenewal.setRenewalFatherId(esfRenewalFatherId); 
		esfRenewal.setAffiliates(affiliates);
		ESFRenewal esfRenewalResult =
			ESFRenewalLocalServiceUtil.addESFRenewal(esfRenewal);
		
		
	}
			
	@Override
	public void serveResource(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
			HttpServletRequest httpReq =
				PortalUtil.getHttpServletRequest(resourceRequest);
			httpReq = PortalUtil.getOriginalServletRequest(httpReq);

			String resourceID = resourceRequest.getResourceID();
			if("annual".equalsIgnoreCase(resourceID)){
				
				long organizationId = ParamUtil.getLong(httpReq, "organizationId", 0);
				
				
				double firstRegistrationCost = 0;
				
				if (organizationId > 0) {
				
				int fild;
				
				try {
					 
					fild = ESFFieldLocalServiceUtil.findByESFOrganization(
							organizationId, ESFKeys.ESFStateType.ENABLE).size();
	
					if(fild==0){
						 firstRegistrationCost = Double.valueOf( ESFConfigurationLocalServiceUtil.
								 getESFConfigurationByESFKey("first-registration-cost").getValue());
						}else if(fild==1){
							 firstRegistrationCost = Double.valueOf( ESFConfigurationLocalServiceUtil.
									 getESFConfigurationByESFKey("first-registration-cost-1").getValue());
						}else if(fild==2 ){
							 firstRegistrationCost =  Double.valueOf( ESFConfigurationLocalServiceUtil.
									 getESFConfigurationByESFKey("first-registration-cost-2").getValue());
						}else if( fild==3){
							firstRegistrationCost =  Double.valueOf( ESFConfigurationLocalServiceUtil.
									 getESFConfigurationByESFKey("first-registration-cost-3").getValue());
						}else if(fild==4){
							 firstRegistrationCost =  Double.valueOf( ESFConfigurationLocalServiceUtil.
									 getESFConfigurationByESFKey("first-registration-cost-4").getValue());
						}else if(fild==5){
							firstRegistrationCost =  Double.valueOf( ESFConfigurationLocalServiceUtil.
									 getESFConfigurationByESFKey("first-registration-cost-5").getValue());
						}else{
							 firstRegistrationCost =  Double.valueOf( ESFConfigurationLocalServiceUtil.
									 getESFConfigurationByESFKey("first-registration-cost-6").getValue());
						}
					
				} catch (PortalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					JSONObject resultJSONObj = JSONFactoryUtil.createJSONObject();
	
					resultJSONObj.put("firstRegistration", firstRegistrationCost);
	
					resourceResponse.getWriter().write(resultJSONObj.toString());
				}
			}
			if("increment".equalsIgnoreCase(resourceID)){
				
				long organizationId = ParamUtil.getLong(httpReq, "organizationId", 0);
				double annualMembershipDueCost = 0;
				double amountTot = 0;
				double amount = 0;
				long esfRenewalId = 0; 
				int year_Of = 0;
				String result = "";
				//lastPayment
				if (organizationId > 0) {
					double lastPayment = 0;
					JSONObject resultJSONObj = JSONFactoryUtil.createJSONObject();
					int fild;
					try {
						fild = ESFFieldLocalServiceUtil.findByESFOrganization(
								organizationId, ESFKeys.ESFStateType.ENABLE).size();
						if(fild==0){
							annualMembershipDueCost = Double.valueOf( ESFConfigurationLocalServiceUtil.
									 getESFConfigurationByESFKey("first-registration-cost").getValue());
							}else if(fild==1){
								annualMembershipDueCost = Double.valueOf( ESFConfigurationLocalServiceUtil.
										 getESFConfigurationByESFKey("first-registration-cost-1").getValue());
							}else if(fild==2 ){
								annualMembershipDueCost =  Double.valueOf( ESFConfigurationLocalServiceUtil.
										 getESFConfigurationByESFKey("first-registration-cost-2").getValue());
							}else if( fild==3){
								annualMembershipDueCost =  Double.valueOf( ESFConfigurationLocalServiceUtil.
										 getESFConfigurationByESFKey("first-registration-cost-3").getValue());
							}else if(fild==4){
								annualMembershipDueCost =  Double.valueOf( ESFConfigurationLocalServiceUtil.
										 getESFConfigurationByESFKey("first-registration-cost-4").getValue());
							}else if(fild==5){
								annualMembershipDueCost =  Double.valueOf( ESFConfigurationLocalServiceUtil.
										 getESFConfigurationByESFKey("first-registration-cost-5").getValue());
							}else{
								annualMembershipDueCost =  Double.valueOf( ESFConfigurationLocalServiceUtil.
										 getESFConfigurationByESFKey("first-registration-cost-6").getValue());
							}
						
						List<ESFRenewal> renewalFathers = new ArrayList<ESFRenewal>();
						List<ESFRenewal> renewalSons = new ArrayList<ESFRenewal>();
						ESFRenewal renewalFather = new ESFRenewalImpl(); 
						ESFRenewal renewalFatherOfSons = new ESFRenewalImpl(); 
						List<Integer> years = new ArrayList<Integer>();
						
						double amountFather = 0;
						double amountSons = 0;
						
						//esfRenIncrsOrgs =  ESFRenewalLocalServiceUtil.findByRegion(organizationId);
												
						renewalFathers = ESFRenewalLocalServiceUtil.findByOrgId(organizationId);
						if(renewalFathers.size()>1){
							for(ESFRenewal r : renewalFathers){
								years.add(r.getReportingYear());
							}
							Collections.sort(years); 
							
							for(ESFRenewal r : renewalFathers){
								if(years.get(years.size()-1) == r.getReportingYear()){
									renewalFather = r;
								}
							}
							
							renewalSons = ESFRenewalLocalServiceUtil.findByRenewalFatherId(renewalFather.getEsfRenewalId());
							if(renewalSons.size()>0){
								
								for(ESFRenewal r : renewalSons){
									amountSons=amountSons+r.getAmount();
								}
								amountTot = amountSons + renewalFather.getAmount();
								if(amountTot>=annualMembershipDueCost){
									lastPayment = amountTot;
									amount = 0;
									esfRenewalId = renewalFather.getEsfRenewalId();
									year_Of = renewalFather.getReportingYear();
									result="OK"; 
								}else{
									lastPayment = amountTot;
									amount = annualMembershipDueCost-amountTot;
									esfRenewalId = renewalFather.getEsfRenewalId();
									year_Of = renewalFather.getReportingYear();
									result="OK"; 
								}
								
								
							}else{
								lastPayment = renewalFather.getAmount();
								amount = annualMembershipDueCost-renewalFather.getAmount();
								esfRenewalId = renewalFather.getEsfRenewalId();
								year_Of = renewalFather.getReportingYear();
								result="OK"; 
							}
						
						}else if(renewalFathers.size()==1) {
							renewalFatherOfSons = renewalFathers.get(0);
							renewalSons = ESFRenewalLocalServiceUtil.findByRenewalFatherId_OrgId(renewalFatherOfSons.getEsfRenewalId(),organizationId );
							
							if(renewalSons.size()>0){
								for(ESFRenewal r : renewalSons){
									amountSons=amountSons+r.getAmount();
								}
								amountTot = amountSons + renewalFatherOfSons.getAmount();
								if(amountTot>=annualMembershipDueCost){
									lastPayment = 0;
									amount = 0;
									esfRenewalId = renewalFatherOfSons.getEsfRenewalId();
									year_Of = renewalFatherOfSons.getReportingYear();
									result="OK"; 
								}else{
									lastPayment = amountTot;
									amount = annualMembershipDueCost-amountTot;
									esfRenewalId = renewalFatherOfSons.getEsfRenewalId();
									year_Of = renewalFatherOfSons.getReportingYear();
									result="OK"; 
								}
								
							}else{
								renewalFather = renewalFathers.get(0);
								lastPayment = renewalFather.getAmount();
								amount = annualMembershipDueCost-renewalFather.getAmount();
								esfRenewalId = renewalFather.getEsfRenewalId();
								year_Of = renewalFatherOfSons.getReportingYear();
								result="OK"; 
							}
							
						}else{
							result="KO"; 
							lastPayment = 0;
							amount = 0;
							esfRenewalId = 0;
							year_Of = 0;
						}

					} catch (SystemException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (PortalException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					resultJSONObj.put("result", result);
					resultJSONObj.put("lastPayment", lastPayment);
					resultJSONObj.put("amount", amount);
					resultJSONObj.put("esfRenewalId", esfRenewalId);
					resultJSONObj.put("year_Of", year_Of);
					resultJSONObj.put("amountTot", annualMembershipDueCost);
					resourceResponse.getWriter().write(resultJSONObj.toString());
				}
				
				
			}
		}
	
	private boolean checkBdo(long esfOrganizationId)
			throws NoSuchUserESFUserRoleException, SystemException {
			boolean result = false;

			List<ESFUserESFUserRole> esfUserESFUserRoles =
				ESFUserESFUserRoleLocalServiceUtil.findESFUserESFRolesByEsfOrganizzationId(esfOrganizationId);

			for (ESFUserESFUserRole esfUserESFUserRole : esfUserESFUserRoles) {
				ESFUserRole esfUserRole =
					ESFUserRoleLocalServiceUtil.fetchESFUserRole(esfUserESFUserRole.getEsfUserRoleId());

				if (esfUserRole.getIsBDO())
					result = true;
			}

			return result;
		}

		private boolean checkField(long esfOrganizationId, int state)
			throws PortalException, SystemException {

			boolean result = false;

			List<ESFField> esfFields =
				ESFFieldLocalServiceUtil.findByESFOrganization(
					esfOrganizationId, state);

			if (!esfFields.isEmpty()) {
				result = true;
			}

			return result;
		}

		private boolean checkPayment(long esfOrganizationId)
			throws PortalException, SystemException {

			boolean result = true;

			return result;
		}

		private long checkType(long esfOrganizationId)
			throws SystemException, NumberFormatException, PortalException {

			long type = 0;

			ESFOrganization esfOrganization =
				ESFOrganizationLocalServiceUtil.fetchESFOrganization(esfOrganizationId);

			if (esfOrganization != null)
				type = esfOrganization.getType();

			return type;
		}
	
	
	private static Log _log =
			LogFactoryUtil.getLog(ESFRenewal.class);
	
}
