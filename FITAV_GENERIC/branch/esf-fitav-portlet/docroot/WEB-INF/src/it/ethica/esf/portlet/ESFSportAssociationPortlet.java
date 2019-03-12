
package it.ethica.esf.portlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.Phone;
import com.liferay.portal.service.PhoneLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import it.ethica.esf.model.ESFAddress;
import it.ethica.esf.model.ESFEntityState;
import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.model.ESFPhone;
import it.ethica.esf.model.impl.ESFEntityStateImpl;
import it.ethica.esf.service.ESFAddressLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;
import it.ethica.esf.util.ESFJsonUtil;
import it.ethica.esf.util.ESFKeys;
import it.ethica.esf.util.ESFServiceUtil;
import it.ethica.esf.util.ManageDate;
import it.ethica.esf.util.ManageOperationsField;

/**
 * Portlet implementation class ESFSportAssociationPortlet
 */
public class ESFSportAssociationPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest request, RenderResponse response)
		throws IOException, PortletException {

		ESFJsonUtil esfJsonUtil = new ESFJsonUtil();
		long esfOrganizationId = ParamUtil.getLong(request, "esfOrganizationId");
		
		String op = ParamUtil.getString(request, "op");
	
		if (op.equals("addAddr")){
		
			for(int i = 0; i < ESFKeys.MinElemIncludePage.MAXADDRESSORG; i++ ){
				
				esfJsonUtil.prepareJSONAddAddress(request, response, i);
			
			}
			
			request.setAttribute("number", ESFKeys.MinElemIncludePage.MINADDRESSORG);
			request.setAttribute("numberOfPhones", ESFKeys.MinElemIncludePage.MINPHONEORG);
			
		}
		else if (op.equals("updAddr")) {
			try {
				ESFOrganization esfOrganization = ESFOrganizationLocalServiceUtil.fetchESFOrganization(esfOrganizationId);
				List<ESFAddress> esfAddresses =
					ESFAddressLocalServiceUtil.getESFAddresses(
						esfOrganization.getCompanyId(), Organization.class.getName(),
						esfOrganizationId);
				
				List<Phone> phones = PhoneLocalServiceUtil.getPhones(esfOrganization.getCompanyId(), Organization.class.getName(),
					esfOrganizationId);
				
				int index = 0;
				
				for(ESFAddress esfAddress : esfAddresses){
					
					esfJsonUtil.prepareJSONUpdAddress(
						request, response, esfAddress.getEsfAddressId(), index);
					
					index++;
				}
				
				if(index < ESFKeys.MinElemIncludePage.MAXADDRESSORG){
					
					for(int i = index; i < ESFKeys.MinElemIncludePage.MAXADDRESSORG; i++ ){
						
						esfJsonUtil.prepareJSONAddAddress(request, response, i);
					
					}
					
				}
				
				if(index < ESFKeys.MinElemIncludePage.MINADDRESSORG){
					
					request.setAttribute("number", ESFKeys.MinElemIncludePage.MINADDRESSORG);
				
				}
				else{
					
					request.setAttribute("number", index);
				
				}
				
				if(phones.size() < ESFKeys.MinElemIncludePage.MINPHONEORG){
					
					request.setAttribute("numberOfPhones", ESFKeys.MinElemIncludePage.MINPHONEORG);
				
				}
				else{
					
					request.setAttribute("numberOfPhones", phones.size());
				
				}
				
			}
			catch (PortalException e) {
				e.printStackTrace();
			}
			catch (SystemException e) {
				e.printStackTrace();
			}
		}
		super.render(request, response);
	}

	@Override
	public void serveResource(
		ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortletException {

		try {
			ESFServiceUtil esfServiceUtil =
				new ESFServiceUtil(ESFOrganization.class.getName(), resourceRequest);

			HttpServletRequest httpReq =
				PortalUtil.getHttpServletRequest(resourceRequest);

			String param =
				PortalUtil.getOriginalServletRequest(httpReq).getParameter(
					"param");
			String idRegion =
				PortalUtil.getOriginalServletRequest(httpReq).getParameter(
					"idRegion");
			String idProvince =
				PortalUtil.getOriginalServletRequest(httpReq).getParameter(
					"idProvince");

			String resourceID = resourceRequest.getResourceID();

			if (resourceID.contains("regions")) {
				esfServiceUtil.serveRegions(
					resourceRequest, resourceResponse, param,
					ESFKeys.ESFAddressConstant.DEFAULT_COUNTRY, idRegion);
			}
			else if (resourceID.contains("provinces")) {
				esfServiceUtil.serveProvinces(
					resourceRequest, resourceResponse, param,
					ESFKeys.ESFAddressConstant.DEFAULT_COUNTRY, idRegion,
					idProvince);
			}
			else if (resourceID.contains("code")) {
				esfServiceUtil.serveCode(
					resourceRequest, resourceResponse, idProvince);
			}

		}
		catch (IOException ioe) {
			throw ioe;
		}
		catch (PortletException pe) {
			throw pe;
		}
		catch (Exception e) {
			throw new PortletException(e);
		}
	}
	
	public void editESFOrganization(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFOrganizationAdminPortlet.class.getName(), request);


		String name = ParamUtil.getString(request, "name");
		String code =ParamUtil.getString(request, "code");
		String emailAddress = ParamUtil.getString(request, "emailAddress");
		String vat = ParamUtil.getString(request, "vat");
		String ibanCode = ParamUtil.getString(request, "ibanCode");
		boolean isMultiSport = ParamUtil.getBoolean(request, "isMultiSport");
		String legalForm = ParamUtil.getString(request, "legalForm");
		String category = ParamUtil.getString(request, "category");
		String fad=ParamUtil.getString(request, "firstAffiliationDate");
		String es=ParamUtil.getString(request, "establishmentDate");
		boolean isYouthActive = ParamUtil.getBoolean(request, "isYouthActive");
		String description = ParamUtil.getString(request, "description");
		
		
		Date establishmentDate=null;
		Date firstAffiliationDate=null;
		try {
			establishmentDate = ManageDate.StringToDate(es);
			firstAffiliationDate =  ManageDate.StringToDate(fad);
		}
		catch (ParseException e1) {
			e1.printStackTrace();
			throw new PortalException(e1);
		}
		
		long esfStateId = ESFKeys.ESFStateType.DISABLE;
		
		Date insertDate = new Date();
		
		List<ESFAddress> esfAddresses = ManageOperationsField.getAddresses(request, response);
		
		List<ESFPhone> phones = ManageOperationsField.getPhones(request, response);

		long parentOrganizationId = getParentOrganizationId(esfAddresses);
		
		ESFEntityState esfEntityState = new ESFEntityStateImpl();
		esfEntityState.setEsfStateId(esfStateId);

		long esfOrganizationId=0;
		try {
			ESFOrganization esfOrganization=ESFOrganizationLocalServiceUtil.addESFOrganization(
				serviceContext.getUserId(), parentOrganizationId, name,
				emailAddress, code, vat, StringPool.BLANK, ibanCode,
				establishmentDate, null, insertDate, null,
				StringPool.BLANK, legalForm, category, esfAddresses, phones, false,
				true, isMultiSport, description, isYouthActive,
				firstAffiliationDate, esfEntityState, 0, 0, serviceContext);
			
			esfOrganizationId=esfOrganization.getEsfOrganizationId();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		SessionMessages.add(request, "esfOrganizationAdded");

		response.setRenderParameter(
				"esfOrganizationId", Long.toString(esfOrganizationId));
		}
	

	private long getParentOrganizationId(List<ESFAddress> esfAddresses) throws SystemException{

		if(esfAddresses.size() == 0)
		
			return 0;
		
		ESFAddress esfAddress = esfAddresses.get(0);
		
		ESFOrganization esfOrganization =
			ESFOrganizationLocalServiceUtil.findByCode(esfAddress.getEsfProvinceId());

		return esfOrganization.getEsfOrganizationId();
	}
	
}
