package com.ethica.esf.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

import com.ethica.esf.model.ESFOrder;
import com.ethica.esf.model.ESFStockist;
import com.ethica.esf.service.ESFOrderLocalServiceUtil;
import com.ethica.esf.service.ESFStockistLocalServiceUtil;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * Portlet implementation class ESFStockistManagerPortlet
 */
public class ESFStockistManagerPortlet extends MVCPortlet {

	public void editESFStockist(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				ESFStockist.class.getName(), request);
		long esfStockistId = ParamUtil.getLong(request, "esfStockistId");
		String name = ParamUtil.getString(request, "name");
		String description = ParamUtil.getString(request, "description");
		String email = ParamUtil.getString(request, "email");
		String phone = ParamUtil.getString(request, "phone");
		String address = ParamUtil.getString(request, "address");
		String other = ParamUtil.getString(request, "other");
		String nameReference = ParamUtil.getString(request, "nameReference");
		String lastNameReference = ParamUtil.getString(request,
				"lastNameReference");
		String emailReference = ParamUtil.getString(request, "emailReference");
		String phoneReference = ParamUtil.getString(request, "phoneReference");

		if (esfStockistId > 0) {
			ESFStockist esfStockist = ESFStockistLocalServiceUtil
					.getESFStockist(esfStockistId);

			if (ESFStockistLocalServiceUtil.checkName(name, serviceContext) != null
					&& !esfStockist.getName().equalsIgnoreCase(name)) {
				SessionErrors.add(request, "esfStockistError");
				response.setRenderParameter("mvcPath",
						"/html/esfstockistmanager/" + "edit_esfStockist.jsp");
				response.setRenderParameter("esfStockistId",
						String.valueOf(esfStockistId));
			} else {
				ESFStockistLocalServiceUtil.updateESFStockist(esfStockistId,
						name, email, phone, address, nameReference,
						lastNameReference, emailReference, phoneReference,
						description, other, serviceContext);
			}
		} else {
			if (ESFStockistLocalServiceUtil.checkName(name, serviceContext) != null) {
				SessionErrors.add(request, "esfStockistError");
				response.setRenderParameter("mvcPath",
						"/html/esfstockistmanager/" + "edit_esfStockist.jsp");
				response.setRenderParameter("name", name);
				response.setRenderParameter("description", description);
				response.setRenderParameter("email", email);
				response.setRenderParameter("phone", phone);
				response.setRenderParameter("address", address);
				response.setRenderParameter("other", other);
				response.setRenderParameter("nameReference", nameReference);
				response.setRenderParameter("lastNameReference",
						lastNameReference);
				response.setRenderParameter("emailReference", emailReference);
				response.setRenderParameter("phoneReference", phoneReference);
			} else {
				ESFStockistLocalServiceUtil.addESFStockist(name, email, phone,
						address, nameReference, lastNameReference,
						emailReference, phoneReference, description, other,
						serviceContext);
			}
		}
	}

	public void deleteESFStockist(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {

		long esfStockistId = ParamUtil.getLong(request, "esfStockistId");

		if (esfStockistId > 0) {
			List<ESFOrder> esfOrders = ESFOrderLocalServiceUtil
					.getESFOrderByStockistId(esfStockistId);

			if (esfOrders.size() > 0) {
				SessionErrors.add(request, "esfOrderReferenceError");
			} else {
				ESFStockistLocalServiceUtil.deleteESFStockist(esfStockistId);
			}
		}
	}

}