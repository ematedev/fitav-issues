
package it.ethica.esf.admin.portlet;

import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.ESFUserCategory;
import it.ethica.esf.service.ESFUserCategoryLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class ESFUserCategoryAdminPortlet extends MVCPortlet {
	
	public void deleteESFUserCategory(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws SystemException, PortalException {

		long esfUserCategoryId = ParamUtil.getLong(actionRequest, "esfUserCategoryId");

		ESFUserCategoryLocalServiceUtil.deleteESFUserCategory(esfUserCategoryId);
	}

	public void updateESFUserCategory(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws SystemException, PortalException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFUserCategory.class.getName(), actionRequest);

		ThemeDisplay themeDisplay =
			(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long esfUserCategoryId =
			ParamUtil.getLong(actionRequest, "esfUserCategoryId");
		long esfCategoryId = ParamUtil.getLong(actionRequest, "esfCategoryId");
		long esfSportTypeId =
			ParamUtil.getLong(actionRequest, "esfSportTypeId");
		long esfUserId = ParamUtil.getLong(actionRequest, "esfUserId");

		if (Validator.isNull(esfUserCategoryId) || esfUserCategoryId < 0) {
			ESFUserCategoryLocalServiceUtil.addEsfUserCategory(
				themeDisplay.getUserId(), esfUserId, esfCategoryId,
				esfSportTypeId, serviceContext);
		}
		else {
			ESFUserCategoryLocalServiceUtil.updateEsfUserCategory(
				themeDisplay.getUserId(), esfUserCategoryId, esfUserId,
				esfCategoryId, esfSportTypeId, serviceContext);
		}
	}

	public void serveResource(
		ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortletException {

		String resourceID = resourceRequest.getResourceID();

		if ("autocomplete".equals(resourceID)) {
			String keywords = ParamUtil.getString(resourceRequest, "keywords");

			JSONObject json = JSONFactoryUtil.createJSONObject();
			JSONArray results = JSONFactoryUtil.createJSONArray();
			json.put("response", results);

			try {
				List<ESFUser> esfUsers = ESFUserLocalServiceUtil.findByKeyword(keywords, "screenName");
				for (ESFUser esfUser : esfUsers) {
					JSONObject object = JSONFactoryUtil.createJSONObject();
					object.put("classNameId", esfUser.getEsfUserId());
					object.put("value", esfUser.getScreenName());
					results.put(object);
				}
			}
			catch (SystemException e) {
				e.printStackTrace();
			}
			catch (PortalException e) {
				e.printStackTrace();
			}

			writeJSON(resourceRequest, resourceResponse, json);
		}
		else {
			super.serveResource(resourceRequest, resourceResponse);
		}
	}
}
