package com.ethica.esf.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

import com.ethica.esf.model.ESFArticle;
import com.ethica.esf.model.ESFArticleDelivered;
import com.ethica.esf.model.ESFArticleType;
import com.ethica.esf.model.ESFOrder;
import com.ethica.esf.model.ESFStockist;
import com.ethica.esf.service.ESFArticleDeliveredLocalServiceUtil;
import com.ethica.esf.service.ESFArticleLocalServiceUtil;
import com.ethica.esf.service.ESFArticleTypeLocalServiceUtil;
import com.ethica.esf.service.ESFOrderLocalServiceUtil;
import com.ethica.esf.service.ESFStockistLocalServiceUtil;
import com.ethica.esf.util.ManageDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * Portlet implementation class ESFArticleManagerPortlet
 */
public class ESFArticleManagerPortlet extends MVCPortlet {

	public void addESFArticle(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				ESFArticle.class.getName(), request);
		String code = ParamUtil.getString(request, "code");
		String name = ParamUtil.getString(request, "name");
		String description = ParamUtil.getString(request, "description");
		long xxxlQty = ParamUtil.getLong(request, "xxxlQty");
		long xxlQty = ParamUtil.getLong(request, "xxlQty");
		long xlQty = ParamUtil.getLong(request, "xlQty");
		long lQty = ParamUtil.getLong(request, "lQty");
		long mQty = ParamUtil.getLong(request, "mQty");
		long sQty = ParamUtil.getLong(request, "sQty");
		long xsQty = ParamUtil.getLong(request, "xsQty");
		long xxsQty = ParamUtil.getLong(request, "xxsQty");
		long otherQty = ParamUtil.getLong(request, "otherQty");
		double price = ParamUtil.getDouble(request, "price");
		double sale = ParamUtil.getDouble(request, "sale");
		double tax = ParamUtil.getDouble(request, "tax");
		long esfArticleTypeId = ParamUtil.getLong(request, "esfArticleTypeId");

		if (ESFArticleLocalServiceUtil.checkCode(code, serviceContext) != null) {
			SessionErrors.add(request, "esfArticleCodeError");
			response.setRenderParameter("mvcPath",
					"/html/esfarticlemanager/add_esfArticle.jsp");
			response.setRenderParameter("code", code);
			response.setRenderParameter("name", name);
			response.setRenderParameter("description", description);
		} else {
			ESFArticleLocalServiceUtil.addESFArticle(code, name, description,
					xxxlQty, xxlQty, xlQty, lQty, mQty, sQty, xsQty, xxsQty,
					otherQty, price, tax, sale, esfArticleTypeId,
					serviceContext);
		}
	}

	public void addESFArticleType(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				ESFArticleType.class.getName(), request);
		String area = ParamUtil.getString(request, "area");
		String description = ParamUtil.getString(request, "description");
		String department = ParamUtil.getString(request, "department");

		if (ESFArticleTypeLocalServiceUtil.checkDescription(description,
				serviceContext) != null) {
			SessionErrors.add(request, "esfArticleTypeDescriptionError");
			response.setRenderParameter("mvcPath",
					"/html/esfarticlemanager/edit_esfArticleType.jsp");
			response.setRenderParameter("area", area);
			response.setRenderParameter("department", department);
			response.setRenderParameter("description", description);
		} else {
			ESFArticleTypeLocalServiceUtil.addESFArticleType(description, area,
					department, serviceContext);
		}
	}

	public void addESFStockist(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				ESFStockist.class.getName(), request);
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

		if (ESFStockistLocalServiceUtil.checkName(name, serviceContext) != null) {
			SessionErrors.add(request, "esfStockistError");
			response.setRenderParameter("mvcPath",
					"/html/esfarticlemanager/edit_esfStockist.jsp");
		} else {
			ESFStockistLocalServiceUtil.addESFStockist(name, email, phone,
					address, nameReference, lastNameReference, emailReference,
					phoneReference, description, other, serviceContext);
		}
	}

	public void editESFArticle(ActionRequest request, ActionResponse response)
			throws ParseException, PortalException, SystemException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				ESFArticle.class.getName(), request);
		String code = ParamUtil.getString(request, "code");
		String name = ParamUtil.getString(request, "name");
		String description = ParamUtil.getString(request, "description");
		String mvcPath = ParamUtil.getString(request, "mvcPath");
		long xxxlQty = ParamUtil.getLong(request, "xxxlQty");
		long xxlQty = ParamUtil.getLong(request, "xxlQty");
		long xlQty = ParamUtil.getLong(request, "xlQty");
		long lQty = ParamUtil.getLong(request, "lQty");
		long mQty = ParamUtil.getLong(request, "mQty");
		long sQty = ParamUtil.getLong(request, "sQty");
		long xsQty = ParamUtil.getLong(request, "xsQty");
		long xxsQty = ParamUtil.getLong(request, "xxsQty");
		long otherQty = ParamUtil.getLong(request, "otherQty");
		double price = ParamUtil.getDouble(request, "price");
		double sale = ParamUtil.getDouble(request, "sale");
		double tax = ParamUtil.getDouble(request, "tax");
		long esfArticleId = ParamUtil.getLong(request, "esfArticleId");
		long esfArticleTypeId = ParamUtil.getLong(request, "esfArticleTypeId");
		boolean editS = ParamUtil.getBoolean(request, "editS");
		long orderId = ParamUtil.getLong(request, "orderId");
		long qty = 0;
		if (esfArticleId > 0) {
			ESFArticle esfArticle = ESFArticleLocalServiceUtil
					.getESFArticle(esfArticleId);

			if (ESFArticleLocalServiceUtil.checkCode(code, serviceContext) != null
					&& !esfArticle.getCode().equalsIgnoreCase(code)) {
				SessionErrors.add(request, "esfArticleCodeError");
				response.setRenderParameter("mvcPath",
						"/html/esfarticlemanager/" + "edit_esfArticle.jsp");
				response.setRenderParameter("esfArticleId",
						String.valueOf(esfArticleId));
			} else {
				ESFArticleLocalServiceUtil.updateESFArticle(esfArticleId, code,
						name, description, xxxlQty, xxlQty, xlQty, lQty, mQty,
						sQty, xsQty, xxsQty, otherQty, price, tax, sale,
						esfArticleTypeId, serviceContext, editS);
				if (Validator.isNotNull(orderId) && orderId > 0) {
					qty = (xxxlQty + xxlQty + xlQty + lQty + mQty + sQty
							+ xsQty + xxsQty + otherQty);
					ESFOrderLocalServiceUtil.updateESFOrderQty(orderId, qty,
							serviceContext);
				}

			}
		}

		if (editS) {
			response.setRenderParameter("esfArticleId",
					String.valueOf(esfArticleId));
			response.setRenderParameter("mvcPath", mvcPath);
		}
	}

	public void assignESFArticle(ActionRequest request, ActionResponse response)
			throws ParseException, PortalException, SystemException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				ESFArticle.class.getName(), request);
		long esfArticleId = ParamUtil.getLong(request, "esfArticleId");
		long esfShooterId = ParamUtil.getLong(request, "shooter");
		String description = ParamUtil.getString(request, "descriptionDeliver");
		String dated = ParamUtil.getString(request, "dateDeliver");
		Date dateDeliver = ManageDate.StringToDate(dated);
		long xxxlQty = ParamUtil.getLong(request, "xxxlQt");
		long xxlQty = ParamUtil.getLong(request, "xxlQt");
		long xlQty = ParamUtil.getLong(request, "xlQt");
		long lQty = ParamUtil.getLong(request, "lQt");
		long mQty = ParamUtil.getLong(request, "mQt");
		long sQty = ParamUtil.getLong(request, "sQt");
		long xsQty = ParamUtil.getLong(request, "xsQt");
		long xxsQty = ParamUtil.getLong(request, "xxsQt");
		long otherQty = ParamUtil.getLong(request, "otherQt");
		String mvcPath = ParamUtil.getString(request, "mvcPath");

		if (esfArticleId > 0) {
			if (Validator.isNotNull(esfShooterId) && esfShooterId > 0) {
				ESFArticleDeliveredLocalServiceUtil.addESFArticleDelivered(
						description, dateDeliver, esfArticleId, esfShooterId,
						xxxlQty, xxlQty, xlQty, lQty, mQty, sQty, xsQty,
						xxsQty, otherQty, serviceContext);

				ESFArticleLocalServiceUtil.decrementESFArticleQ(esfArticleId,
						xxxlQty, xxlQty, xlQty, lQty, mQty, sQty, xsQty,
						xxsQty, otherQty);
			} else {
				SessionErrors.add(request, "esfArticleDeliveredShooterError");
			}
		}

		response.setRenderParameter("esfArticleId",
				String.valueOf(esfArticleId));
		response.setRenderParameter("mvcPath", mvcPath);
	}

	public void deleteESFArticle(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {

		long esfArticleId = ParamUtil.getLong(request, "esfArticleId");

		if (esfArticleId > 0) {
			List<ESFOrder> esfOrders = ESFOrderLocalServiceUtil
					.getESFOrderByArticleId(esfArticleId);
			List<ESFArticleDelivered> esfArticlesDelivered = ESFArticleDeliveredLocalServiceUtil
					.getESFArticleDeliveredByArticleId(esfArticleId);

			if (esfOrders.size() > 0) {
				SessionErrors.add(request, "esfOrderReferenceError");
			} else if (esfArticlesDelivered.size() > 0) {
				SessionErrors.add(request, "esfArticleDeliveredReferenceError");
			} else {
				ESFArticleLocalServiceUtil.deleteESFArticle(esfArticleId);
			}
		}
	}

	public void editESFOrder(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException, ParseException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				ESFOrder.class.getName(), request);
		long esfOrderId = ParamUtil.getLong(request, "esfOrderId");
		String code = ParamUtil.getString(request, "code");
		String description = ParamUtil.getString(request, "description");
		String dateS = ParamUtil.getString(request, "orderDate");
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date dateO = format.parse(dateS);
		long qty = ParamUtil.getLong(request, "orderQty");
		long esfStockistId = ParamUtil.getLong(request, "esfStockistId");
		long esfArticleId = ParamUtil.getLong(request, "esfArticleId");
		if (esfOrderId > 0) {
			ESFOrderLocalServiceUtil.updateESFOrder(esfOrderId, description,
					esfStockistId, dateO, qty, serviceContext);
		} else {
			ESFOrderLocalServiceUtil.addESFOrder(description, code,
					esfStockistId, esfArticleId, qty, dateO, serviceContext);
		}
		response.setRenderParameter("mvcPath",
				"/html/esfarticlemanager/edit_esfArticle.jsp");
		response.setRenderParameter("esfArticleId",
				String.valueOf(esfArticleId));
	}

}