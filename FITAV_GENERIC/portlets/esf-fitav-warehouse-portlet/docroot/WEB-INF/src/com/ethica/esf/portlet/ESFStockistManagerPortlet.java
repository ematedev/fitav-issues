
package com.ethica.esf.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.ethica.esf.ESFOrderAssociatedException;
import com.ethica.esf.service.ESFOrderLocalServiceUtil;
import com.ethica.esf.service.ESFStockistLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ESFStockistManagerPortlet
 */
public class ESFStockistManagerPortlet extends MVCPortlet {

	public void editESFStockist(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		long esfStockistId = ParamUtil.getLong(request, "esfStockistId");
		String name = ParamUtil.getString(request, "name");
		String description = ParamUtil.getString(request, "description");
		String email = ParamUtil.getString(request, "email");
		String phone = ParamUtil.getString(request, "phone");
		String address = ParamUtil.getString(request, "address");
		String other = ParamUtil.getString(request, "other");
		String nameReference = ParamUtil.getString(request, "nameReference");
		String lastNameReference =
			ParamUtil.getString(request, "lastNameReference");
		String emailReference = ParamUtil.getString(request, "emailReference");
		String phoneReference = ParamUtil.getString(request, "phoneReference");

		if (esfStockistId > 0) {
			ESFStockistLocalServiceUtil.updateESFStockist(
				esfStockistId, name, email, phone, address, nameReference,
				lastNameReference, emailReference, phoneReference, description,
				other);
		}
		else {
			ESFStockistLocalServiceUtil.addESFStockist(
				name, email, phone, address, nameReference, lastNameReference,
				emailReference, phoneReference, description, other);
		}
	}

	public void deleteESFStockist(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException, ESFOrderAssociatedException {

		long esfStockistId = ParamUtil.getLong(request, "esfStockistId");

		if (ESFOrderLocalServiceUtil.getESFOrdersByESFStockistId(esfStockistId).size() > 0) {
			throw new ESFOrderAssociatedException();
		}

		ESFStockistLocalServiceUtil.deleteESFStockist(esfStockistId);
	}

}
