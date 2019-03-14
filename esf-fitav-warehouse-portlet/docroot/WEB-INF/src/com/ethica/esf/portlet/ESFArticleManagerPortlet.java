
package com.ethica.esf.portlet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.ethica.esf.model.ESFArticle;
import com.ethica.esf.service.ESFArticleLocalServiceUtil;
import com.ethica.esf.service.ESFArticle_ESFUserLocalServiceUtil;
import com.ethica.esf.service.persistence.ESFArticle_ESFUserPK;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class ESFArticleManagerPortlet extends MVCPortlet {

	public void editESFArticle(ActionRequest request, ActionResponse response)
		throws ParseException, PortalException, SystemException {

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
		long totalQty =
			xxxlQty + xxlQty + xlQty + lQty + mQty + sQty + xsQty + xxsQty +
				otherQty;
		long esfArticleId = ParamUtil.getLong(request, "esfArticleId");
		long esfArticleTypeId = ParamUtil.getLong(request, "esfArticleTypeId");

		if (esfArticleId > 0) {
			ESFArticleLocalServiceUtil.updateESFArticle(
				esfArticleId, code, name, description, xxxlQty, xxlQty, xlQty,
				lQty, mQty, sQty, xsQty, xxsQty, otherQty, totalQty, false,
				esfArticleTypeId);
		}
		else {
			ESFArticleLocalServiceUtil.addESFArticle(
				code, name, description, xxxlQty, xxlQty, xlQty, lQty, mQty,
				sQty, xsQty, xxsQty, otherQty, totalQty, false,
				esfArticleTypeId);
		}

	}

	public void editESFArticleESFUser(
		ActionRequest request, ActionResponse response)
		throws ParseException, PortalException, SystemException {

		long xxxlQty = ParamUtil.getLong(request, "xxxlQty");
		long xxlQty = ParamUtil.getLong(request, "xxlQty");
		long xlQty = ParamUtil.getLong(request, "xlQty");
		long lQty = ParamUtil.getLong(request, "lQty");
		long mQty = ParamUtil.getLong(request, "mQty");
		long sQty = ParamUtil.getLong(request, "sQty");
		long xsQty = ParamUtil.getLong(request, "xsQty");
		long xxsQty = ParamUtil.getLong(request, "xxsQty");
		long otherQty = ParamUtil.getLong(request, "otherQty");
		long esfArticleId = ParamUtil.getLong(request, "esfArticleId");
		long esfUserId = ParamUtil.getLong(request, "esfUserId");

		ESFArticle esfArticle =
			ESFArticleLocalServiceUtil.getESFArticle(esfArticleId);

		if (xxxlQty > esfArticle.getXxxlQty() ||
			xxlQty > esfArticle.getXxlQty() || xlQty > esfArticle.getXlQty() ||
			lQty > esfArticle.getLQty() || mQty > esfArticle.getMQty() ||
			sQty > esfArticle.getSQty() || xsQty > esfArticle.getXsQty() ||
			xxsQty > esfArticle.getXxsQty() ||
			otherQty > esfArticle.getOtherQty()) {
			SessionErrors.add(request, "qty-error");
			return;
		}

		long totalQty =
			xxxlQty + xxlQty + xlQty + lQty + mQty + sQty + xsQty + xxsQty +
				otherQty;

		String description = ParamUtil.getString(request, "description");
		Date deliveryDate =
			ParamUtil.getDate(request, "deliveryDate", new SimpleDateFormat(
				"dd/MM/yyyy"));

		String mode = ParamUtil.getString(request, "mode");

		if (!"add".equalsIgnoreCase(mode)) {
			ESFArticle_ESFUserLocalServiceUtil.updateESFArticle_ESFUser(
				esfArticleId, esfUserId, xxxlQty, xxlQty, xlQty, lQty, mQty,
				sQty, xsQty, xxsQty, otherQty, totalQty, description,
				deliveryDate);
		}
		else {
			ESFArticle_ESFUserLocalServiceUtil.addESFArticle_ESFUser(
				esfArticleId, esfUserId, xxxlQty, xxlQty, xlQty, lQty, mQty,
				sQty, xsQty, xxsQty, otherQty, totalQty, description,
				deliveryDate);
		}

		long temp = 0;
		long total = 0;

		temp = esfArticle.getXxxlQty() - xxxlQty;
		total += temp;
		esfArticle.setXxxlQty(temp);

		temp = esfArticle.getXxlQty() - xxlQty;
		total += temp;
		esfArticle.setXxlQty(temp);

		temp = esfArticle.getXlQty() - xlQty;
		total += temp;
		esfArticle.setXlQty(temp);

		temp = esfArticle.getLQty() - lQty;
		total += temp;
		esfArticle.setLQty(temp);

		temp = esfArticle.getMQty() - mQty;
		total += temp;
		esfArticle.setMQty(temp);

		temp = esfArticle.getSQty() - sQty;
		total += temp;
		esfArticle.setSQty(temp);

		temp = esfArticle.getXsQty() - xsQty;
		total += temp;
		esfArticle.setXsQty(temp);

		temp = esfArticle.getXxsQty() - xxsQty;
		total += temp;
		esfArticle.setXxsQty(temp);

		temp = esfArticle.getOtherQty() - otherQty;
		total += temp;
		esfArticle.setOtherQty(temp);

		esfArticle.setTotalQty(total);

		ESFArticleLocalServiceUtil.updateESFArticle(esfArticle);

	}
	
	public void enableESFArticle(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		long esfArticleId = ParamUtil.getLong(request, "esfArticleId");

		ESFArticle esfArticle =
			ESFArticleLocalServiceUtil.getESFArticle(esfArticleId);
		esfArticle.setDisabled(false);
		ESFArticleLocalServiceUtil.updateESFArticle(esfArticle);
	}

	public void deleteESFArticle(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		long esfArticleId = ParamUtil.getLong(request, "esfArticleId");

		ESFArticle esfArticle =
			ESFArticleLocalServiceUtil.getESFArticle(esfArticleId);
		esfArticle.setDisabled(true);
		ESFArticleLocalServiceUtil.updateESFArticle(esfArticle);

		// ESFArticleLocalServiceUtil.deleteESFArticle(esfArticleId);
	}

	public void deleteESFArticle_ESFUser(
		ActionRequest request, ActionResponse response)
		throws PortalException, SystemException {

		long esfArticleId = ParamUtil.getLong(request, "esfArticleId");
		long esfUserId = ParamUtil.getLong(request, "esfUserId");

		ESFArticle_ESFUserPK pk =
			new ESFArticle_ESFUserPK(esfArticleId, esfUserId);

		ESFArticle_ESFUserLocalServiceUtil.deleteESFArticle_ESFUser(pk);
	}
}
