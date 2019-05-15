
package it.ethica.esf.portlet;

import it.ethica.esf.model.ESFField;
import it.ethica.esf.model.ESFForniture;
import it.ethica.esf.model.ESFFornitureUser;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.service.ESFFornitureLocalServiceUtil;
import it.ethica.esf.service.ESFFornitureUserLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationUnitserviceLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalService;
import it.ethica.esf.service.ESFUserLocalServiceUtil;


import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ESFForniturePortlet
 */
public class ESFForniturePortlet extends MVCPortlet {
	
	private CounterLocalServiceUtil counterLocalService;

	@Override
	public void render(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		/* TODO Auto-generated method stub
		List<ESFUser>  utenti = new ArrayList<ESFUser>();
		try {
			utenti = (List<ESFUser>)ESFUserLocalServiceUtil.findAllUser();
			request.setAttribute("utenti", utenti);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		super.render(request, response);
	}

	
	public void editESFForniture(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFForniture.class.getName(), request);
		long esfFornitureId = ParamUtil.getLong(request, "esfFornitureId");
		String code = ParamUtil.getString(request, "code");
		String name = ParamUtil.getString(request, "name");
		String description = ParamUtil.getString(request, "description");
		String size = ParamUtil.getString(request, "size");
		long esfFornitureTypeId = ParamUtil.getLong(request, "type");
		//long numberFornitures = ParamUtil.getLong(request, "numberFornitures");
		Date now = new Date();
		if (esfFornitureId > 0) {
			
			ESFForniture esfForniture = ESFFornitureLocalServiceUtil.getESFForniture(esfFornitureId);
			ESFFornitureLocalServiceUtil.updateESFForniture(
				serviceContext.getUserId(), esfFornitureId, code, description,
				name, esfFornitureTypeId, esfForniture.getNumberFornitures(), now,size, serviceContext);
		}
		else {
			ESFFornitureLocalServiceUtil.addESFForniture(
				serviceContext.getUserId(), code, description, name,
				esfFornitureTypeId, 1, now, size,serviceContext);
		}
	}

	public void deleteESFForniture(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFForniture.class.getName(), request);
		long esfFornitureId = ParamUtil.getLong(request, "esfFornitureId");

		if (esfFornitureId > 0) {
			ESFFornitureLocalServiceUtil.deleteESFForniture(
				esfFornitureId, serviceContext);
		}
		else {
			SessionErrors.add(request, "esfForniture-reference-error");
		}
	}
	
	public void updateESFQuantity(ActionRequest request, ActionResponse response) throws PortalException, SystemException{
		
		long esfFornitureId = Long.parseLong(ParamUtil.getString(request, "esfFornitureId"));
		long quantity = Long.parseLong(ParamUtil.getString(request, "quantity"));
		ESFForniture esfForniture = ESFFornitureLocalServiceUtil.getESFForniture(esfFornitureId);
		//long sum = quantity + esfForniture.getNumberFornitures();
		ServiceContext serviceContext =
				ServiceContextFactory.getInstance(
					ESFForniture.class.getName(), request);
		String code = esfForniture.getCode();
		String name = esfForniture.getName();
		String description = esfForniture.getDescription();
		Date now = esfForniture.getCreateDate();
		String size = esfForniture.getSize();
		long esfFornitureTypeId = esfForniture.getType();
		ESFFornitureLocalServiceUtil.updateESFForniture(
				serviceContext.getUserId(), esfFornitureId, code, description,
				name, esfFornitureTypeId, quantity, now,size, serviceContext);
	}
	
	public void assignForniture(ActionRequest request, ActionResponse response) 
						throws SystemException, PortalException{
		
		long esfFornitureId = Long.parseLong(ParamUtil.getString(request, "esfFornitureId"));
		long quantity = Long.parseLong(ParamUtil.getString(request, "quantity"));
		long user = Long.parseLong(ParamUtil.getString(request, "esfUserId"));
		
		String dataAssign =
				ParamUtil.getString(request, "esfDateAssign");
			
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
			Date dateAssign = new Date();
			try {
				dateAssign = df.parse(dataAssign);
			}
			catch (ParseException e) {
				e.getMessage();
			}
		ServiceContext serviceContext =
				ServiceContextFactory.getInstance(
					ESFForniture.class.getName(), request);
		
		ESFFornitureUser esfFornitureUser= 
				ESFFornitureUserLocalServiceUtil.createESFFornitureUser
				((CounterLocalServiceUtil.increment("it.ethica.esf.model.ESFFornitureUser")));
		esfFornitureUser.setEsfIDForniture(esfFornitureId);
		esfFornitureUser.setEsfQuantity(quantity);
		esfFornitureUser.setEsfIdUser(user);
		esfFornitureUser.setEsfDateAssign(dateAssign);
		ESFFornitureUserLocalServiceUtil.addESFFornitureUser(esfFornitureUser);
		ESFForniture forniture = ESFFornitureLocalServiceUtil.fetchESFForniture(esfFornitureId);
		long sum = forniture.getNumberFornitures()-quantity;
		ESFFornitureLocalServiceUtil.updateESFForniture(
				serviceContext.getUserId(), esfFornitureId, forniture.getCode(), forniture.getDescription(),
				forniture.getName(), forniture.getType(), sum, forniture.getInsertDate(),forniture.getSize(), serviceContext);
		
	}
}

