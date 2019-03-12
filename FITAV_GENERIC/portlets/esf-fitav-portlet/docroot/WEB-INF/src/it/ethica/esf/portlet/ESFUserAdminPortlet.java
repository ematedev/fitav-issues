
package it.ethica.esf.portlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.util.Calendar;
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

import com.liferay.portal.ContactBirthdayException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Phone;
import com.liferay.portal.service.PhoneLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import it.ethica.esf.model.ESFAddress;
import it.ethica.esf.model.ESFCard;
import it.ethica.esf.model.ESFEntityState;
import it.ethica.esf.model.ESFPhone;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.ESFUserRole;
import it.ethica.esf.model.impl.ESFEntityStateImpl;
import it.ethica.esf.service.ESFAddressLocalServiceUtil;
import it.ethica.esf.service.ESFCardLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;
import it.ethica.esf.service.ESFUserRoleLocalServiceUtil;
import it.ethica.esf.util.ESFJsonUtil;
import it.ethica.esf.util.ESFKeys;
import it.ethica.esf.util.ESFServiceUtil;
import it.ethica.esf.util.ManageDate;
import it.ethica.esf.util.ManageOperationsField;

/**
 * Portlet implementation class ESFUserAdminPortlet
 */
public class ESFUserAdminPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest request, RenderResponse response) throws IOException, PortletException {

		ESFJsonUtil esfJsonUtil = new ESFJsonUtil();
		long esfUserId = ParamUtil.getLong(request, "esfUserId");

		String op = ParamUtil.getString(request, "op");

		if (op.equals("addAddr")) {

			for (int i = 0; i < ESFKeys.MinElemIncludePage.MAXADDRESSUSER; i++) {

				esfJsonUtil.prepareJSONAddAddress(request, response, i);

			}

			request.setAttribute("number", ESFKeys.MinElemIncludePage.MINADDRESSUSER);
			request.setAttribute("numberOfPhones", ESFKeys.MinElemIncludePage.MINPHONEUSER);

		} else if (op.equals("updAddr")) {

			try {

				ESFUser esfUser = ESFUserLocalServiceUtil.getESFUser(esfUserId);

				List<ESFAddress> esfAddresses = ESFAddressLocalServiceUtil.getESFAddresses(esfUser.getCompanyId(),
						ESFUser.class.getName(), esfUserId);

				List<Phone> phones = PhoneLocalServiceUtil.getPhones(esfUser.getCompanyId(), ESFUser.class.getName(),
						esfUserId);

				int index = 0;

				for (ESFAddress esfAddress : esfAddresses) {

					if (Validator.isNotNull(esfAddress)) {
						esfJsonUtil.prepareJSONUpdAddress(request, response, esfAddress.getEsfAddressId(), index);
					}
					index++;
				}

				if (index < ESFKeys.MinElemIncludePage.MAXADDRESSUSER) {

					for (int i = index; i < ESFKeys.MinElemIncludePage.MAXADDRESSUSER; i++) {

						esfJsonUtil.prepareJSONAddAddress(request, response, i);

					}

				}

				if (index < ESFKeys.MinElemIncludePage.MINADDRESSUSER) {

					request.setAttribute("number", ESFKeys.MinElemIncludePage.MINADDRESSUSER);

				} else {

					request.setAttribute("number", index);

				}

				if (phones.size() < ESFKeys.MinElemIncludePage.MINPHONEUSER) {

					request.setAttribute("numberOfPhones", ESFKeys.MinElemIncludePage.MINPHONEUSER);

				} else {

					request.setAttribute("numberOfPhones", phones.size());

				}

				try {
					esfJsonUtil.prepareJSONUpdAssociationsCards(request, response);
				} catch (Exception e) {
					_log.info("errore card");
				}

			} catch (PortalException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		super.render(request, response);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {

		try {
			ESFServiceUtil esfServiceUtil = new ESFServiceUtil(ESFUser.class.getName(), resourceRequest);

			HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(resourceRequest);

			String param = PortalUtil.getOriginalServletRequest(httpReq).getParameter("param");
			String idRegion = PortalUtil.getOriginalServletRequest(httpReq).getParameter("idRegion");
			String idProvince = PortalUtil.getOriginalServletRequest(httpReq).getParameter("idProvince");
			String emailAddress = PortalUtil.getOriginalServletRequest(httpReq).getParameter("emailVal");

			long associationId = StringToLong(
					PortalUtil.getOriginalServletRequest(httpReq).getParameter("idAssociation"));
			long esfUserId = StringToLong(PortalUtil.getOriginalServletRequest(httpReq).getParameter("esfUserId"));

			String resourceID = resourceRequest.getResourceID();

			if (resourceID.contains("regions")) {
				esfServiceUtil.serveRegions(resourceRequest, resourceResponse, param,
						ESFKeys.ESFAddressConstant.DEFAULT_COUNTRY, idRegion);
			} else if (resourceID.contains("provinces")) {
				esfServiceUtil.serveProvinces(resourceRequest, resourceResponse, param,
						ESFKeys.ESFAddressConstant.DEFAULT_COUNTRY, idRegion, idProvince);
			} else if (resourceID.equals("emailaddresses")) {
				esfServiceUtil.serveEmailAddress(resourceRequest, resourceResponse, emailAddress);
			} else if (resourceID.equals("associations")) {
				esfServiceUtil.serveAssociationsCards(resourceRequest, resourceResponse, param, associationId,
						esfUserId);
			} else if (resourceID.equals("fiscalCode")) {
				JSONObject fiscalcode = serveFiscalCode(resourceRequest, resourceResponse);
				resourceResponse.getWriter().print(fiscalcode);
			}
		} catch (IOException ioe) {
			throw ioe;
		} catch (PortletException pe) {
			throw pe;
		} catch (Exception e) {
			throw new PortletException(e);
		}
	}

	public JSONObject serveFiscalCode(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		JSONObject jsonFiscalCode = JSONFactoryUtil.createJSONObject();

		String result = "ko";
		String fiscalCode = "01";

		String lastName = ParamUtil.getString(resourceRequest, "lastName").replace(" ", "");
		String firstName = ParamUtil.getString(resourceRequest, "firstName").replace(" ", "");
		String middleName = ParamUtil.getString(resourceRequest, "middleName").replace(" ", "");
		String birthcity = ParamUtil.getString(resourceRequest, "birthcity").replace(" ", "");
		Boolean male = ParamUtil.getBoolean(resourceRequest, "male");
		String birthday = ParamUtil.getString(resourceRequest, "birthday");
		String sex = "f";
		if (male) {

			sex = "m";

		}
		String totalName =  firstName.concat(middleName);
		String url = "http://webservices.dotnethell.it/codicefiscale.asmx/CalcolaCodiceFiscale?Nome=" + totalName
				+ "&Cognome=" + lastName + "&ComuneNascita=" + birthcity + "&DataNascita=" + birthday + "&Sesso=" + sex;
		URL obj = new URL(url);

		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

		String inputLine;

		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		String responseString = response.toString();

		if (responseString.length() > 117 && !responseString.substring(101, 117).contains(" ")
				&& (StringPool.BLANK != birthday) && (StringPool.BLANK != lastName) && (StringPool.BLANK != firstName)
				&& (StringPool.BLANK != birthcity)) {
			result = "ok";
			fiscalCode = responseString.substring(101, 117);
		}
		jsonFiscalCode.put("result", result);
		jsonFiscalCode.put("fiscalCode", fiscalCode);
		return jsonFiscalCode;
	}

	public void addESFUser(ActionRequest actionRequest, ActionResponse actionResponse)
			throws PortalException, SystemException, ParseException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(ESFUser.class.getName(), actionRequest);

		String firstName = ParamUtil.getString(actionRequest, "firstName");
		String lastName = ParamUtil.getString(actionRequest, "lastName");
		String middleName = ParamUtil.getString(actionRequest, "middleName");
		String userEmail = ParamUtil.getString(actionRequest, "userEmail");
		String fiscalCode = ParamUtil.getString(actionRequest, "fiscalCode");
		String birthcity = ParamUtil.getString(actionRequest, "birthcity");
		long esfStateId = ParamUtil.getLong(actionRequest, "esfStateId");
		String es = ParamUtil.getString(actionRequest, "birthday");
		Date birthday = null;
		if (Validator.isNull(es)) {
			birthday = new Date();
		} else {
			try {
				birthday = ManageDate.StringToDate(es);
			} catch (ParseException e1) {
				e1.printStackTrace();
				throw new PortalException(e1);
			}
		}
		if (Validator.isNull(birthday)) {
			Calendar cal = Calendar.getInstance();
			birthday = cal.getTime();

		}
		int year = ManageDate.getYear(birthday);
		int month = ManageDate.getMonth(birthday);
		int day = ManageDate.getDay(birthday);

		boolean male = ParamUtil.getBoolean(actionRequest, "male");

		List<ESFPhone> phones = ManageOperationsField.getPhones(actionRequest, actionResponse);

		List<ESFAddress> addresses = ManageOperationsField.getAddresses(actionRequest, actionResponse);

		String skype = ParamUtil.getString(actionRequest, "skype");
		String facebook = ParamUtil.getString(actionRequest, "facebook");
		String twitter = ParamUtil.getString(actionRequest, "twitter");

		String jobTitle = ParamUtil.getString(actionRequest, "work");

		try {
			if (ESFUserLocalServiceUtil.checkEmailAddress(userEmail, serviceContext) != null) {
				SessionErrors.add(actionRequest, "user-email-message");
			} else {

				ESFEntityState esfEntityState = new ESFEntityStateImpl();
				esfEntityState.setEsfStateId(esfStateId);

				ESFUser esfUser = ESFUserLocalServiceUtil.addESFUser(serviceContext.getUserId(), StringPool.BLANK,
						firstName, middleName, lastName, userEmail, fiscalCode, day, month, year, male, skype, facebook,
						twitter, jobTitle, esfEntityState, addresses, phones, birthcity, serviceContext);

				/* Assegno il ruolo 'Fitav Manager' all'user 'esfUser' */
				List<ESFUserRole> esfUserRolesFitavManager = ESFUserRoleLocalServiceUtil.getAllUserRoleByLikeT_N(
						ESFKeys.ESFUserRoleDefault.FITAVMANGAR, ESFKeys.ESFUserRoleDefault.FITAVMANGAR,
						ESFKeys.ESFStateType.ENABLE);

				Long roleId = esfUserRolesFitavManager.get(0).getEsfUserRoleId();

				RoleLocalServiceUtil.addUserRole(esfUser.getPrimaryKey(), roleId);

				if (Validator.isNotNull(esfUser) && esfUser.getEsfUserId() > 0)
					SessionMessages.add(actionRequest, "user-success-insert");
				else
					SessionErrors.add(actionRequest, "user-error-insert");

			}
		} catch (ContactBirthdayException cbe) {
			SessionErrors.add(actionRequest, "user-birthday-message");
		} catch (Exception e) {
			_log.error("Error in addESFUser method: " + e.getMessage());
			e.printStackTrace();
		}

	}

	public void updateESFUser(ActionRequest actionRequest, ActionResponse actionResponse)
			throws PortalException, SystemException, ParseException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(ESFUser.class.getName(), actionRequest);

		long esfUserId = ParamUtil.getLong(actionRequest, "esfUserId");
		String firstName = ParamUtil.getString(actionRequest, "firstName");
		String lastName = ParamUtil.getString(actionRequest, "lastName");
		String middleName = ParamUtil.getString(actionRequest, "middleName");
		String userEmail = ParamUtil.getString(actionRequest, "userEmail");
		String fiscalCode = ParamUtil.getString(actionRequest, "fiscalCode");
		String birthcity = ParamUtil.getString(actionRequest, "birthcity");
		String es = ParamUtil.getString(actionRequest, "birthday");
		long esfStateId = ParamUtil.getLong(actionRequest, "esfStateId");

		Date birthday = null;
		try {
			birthday = ManageDate.StringToDate(es);
		} catch (ParseException e1) {
			e1.printStackTrace();
			throw new PortalException(e1);
		}
		int year = ManageDate.getYear(birthday);
		int month = ManageDate.getMonth(birthday);
		int day = ManageDate.getDay(birthday);
		boolean male = ParamUtil.getBoolean(actionRequest, "male");

		List<ESFAddress> addresses = ManageOperationsField.getAddresses(actionRequest, actionResponse);

		List<ESFPhone> phones = ManageOperationsField.getPhones(actionRequest, actionResponse);

		String skype = ParamUtil.getString(actionRequest, "skype");
		String facebook = ParamUtil.getString(actionRequest, "facebook");
		String twitter = ParamUtil.getString(actionRequest, "twitter");

		String jobTitle = ParamUtil.getString(actionRequest, "work");
		boolean disable = ParamUtil.getBoolean(actionRequest, "disable");

		ESFUser esfUserToUpdate = ESFUserLocalServiceUtil.getESFUser(esfUserId);

		try {
			if (ESFUserLocalServiceUtil.checkEmailAddress(userEmail, serviceContext) != null
					&& !esfUserToUpdate.getUserEmail().equals(userEmail)) {
				SessionErrors.add(actionRequest, "user-email-message");
			} else {
				ESFEntityState esfEntityState = new ESFEntityStateImpl();
				esfEntityState.setEsfStateId(esfStateId);

				ESFUser esfUser = ESFUserLocalServiceUtil.updateESFUser(serviceContext.getUserId(), esfUserId,
						StringPool.BLANK, firstName, middleName, lastName, userEmail, fiscalCode, day, month, year,
						male, disable, skype, facebook, twitter, jobTitle, esfEntityState, addresses, phones, birthcity,
						serviceContext);

				if (Validator.isNotNull(esfUser) && esfUser.getEsfUserId() > 0)
					SessionMessages.add(actionRequest, "user-success-update");
				else
					SessionErrors.add(actionRequest, "user-error-update");
			}
		} catch (ContactBirthdayException cbe) {
			SessionErrors.add(actionRequest, "user-birthday-message");
		} catch (Exception e) {
			_log.error("Error in updateESFUser method: " + e.getMessage());
			e.printStackTrace();
		}

	}

	public void updateESFUserESFCard(ActionRequest actionRequest, ActionResponse actionResponse)
			throws PortalException, SystemException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(ESFUser.class.getName(), actionRequest);

		long esfCardId = ParamUtil.getLong(actionRequest, "esfCardId");
		long esfUserId = ParamUtil.getLong(actionRequest, "esfUserId");

		ESFCard esfCard = ESFCardLocalServiceUtil.getESFCard(esfCardId);

		List<ESFCard> esfCards = ESFCardLocalServiceUtil.findAllESFCardsByU_S(esfUserId, ESFKeys.ESFStateType.ENABLE);

		if (esfCards.size() == 0) {
			ESFUserLocalServiceUtil.addESFUserToESFShooter(esfUserId, esfCardId);
		} else {
			ESFUserLocalServiceUtil.updateESFUserToESFShooter(serviceContext.getUserId(), esfUserId, esfCard, esfCards,
					serviceContext);
		}
	}


	private long StringToLong(String value) {

		if (value != null && !value.equals(""))
			return Long.parseLong(value);

		else
			return 0;
	}

	private static Log _log = LogFactoryUtil.getLog(ESFUserAdminPortlet.class);
}
