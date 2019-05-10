
package it.ethica.esf.portlet;

import it.ethica.esf.model.ESFDocument;
import it.ethica.esf.service.ESFDocumentLocalServiceUtil;
import it.ethica.esf.util.ManageDate;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.commons.io.FileUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.portlet.PortletProps;

/**
 * Portlet implementation class ESFMatchType
 */
public class ESFDocumentPortlet extends MVCPortlet {

	public void editESFdocument(ActionRequest request, ActionResponse response)
		throws PortalException, SystemException, ParseException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFMatchTypePortlet.class.getName(), request);

		UploadPortletRequest uploadRequest =
			PortalUtil.getUploadPortletRequest(request);

		long esfDocumentId = ParamUtil.getLong(uploadRequest, "esfDocumentId");

		String code = ParamUtil.getString(uploadRequest, "code");

		String releasedBy = ParamUtil.getString(uploadRequest, "releasedby");

		String rDate = ParamUtil.getString(uploadRequest, "releasedate");

		Date releaseDate = ManageDate.StringToDate(rDate);

		String eDate = ParamUtil.getString(uploadRequest, "expirationDate");

		Date expirationDate = ManageDate.StringToDate(eDate);

		String type = ParamUtil.getString(uploadRequest, "type");

		ThemeDisplay themeDisplay =
			(ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		User user = themeDisplay.getUser();

		long groupId = user.getGroupId();

		long companyId = user.getCompanyId();

		String userName = user.getFullName();

		String path = "";

		if (esfDocumentId > 0) {
			path = uploadFile(uploadRequest, user, type);
			Date modifiedDate = new Date();
			ESFDocumentLocalServiceUtil.updateEsfDocument(
				esfDocumentId, groupId, companyId, userName, user.getUserId(),
				code, releasedBy, modifiedDate, releaseDate, expirationDate,
				type, path, serviceContext);

			SessionMessages.add(request, "esfDocumentUpdated");

			response.setRenderParameter(
				"esfDocumentId", Long.toString(esfDocumentId));
		}
		else {
			Date createDate = new Date();
			List<ESFDocument> list =
				ESFDocumentLocalServiceUtil.findByT_U(type, user.getUserId());
			if (Validator.isNotNull(list) && list.size() > 0) {
				SessionErrors.add(request, "Document-type-message");
			}
			else {
				path = uploadFile(uploadRequest, user, type);
				ESFDocumentLocalServiceUtil.addEsfDocument(
					groupId, companyId, userName, user.getUserId(), code,
					releasedBy, createDate, releaseDate, expirationDate, type,
					path, serviceContext);

				SessionMessages.add(request, "esfDocumentUpdated");

				response.setRenderParameter(
					"esfDocumentId", Long.toString(esfDocumentId));
			}
		}
	}

	private String uploadFile(
		UploadPortletRequest uploadRequest, User user, String type) {

		String dir =
			PortletProps.get("auto.deploy.tomcat.dest.dir") + File.separator +
				"shooter_document" + File.separator + user.getUserId();

		String paramName = "path";

		if (uploadRequest.getSize(paramName) == 0) {
			return "";
		}
		File uploadedFile = uploadRequest.getFile(paramName);
		String ext =
			uploadedFile.getName().substring(
				uploadedFile.getName().lastIndexOf("."));
		String sourceFileName = type + "_" + user.getEmailAddress();
		File folder = new File(dir);
		File filePath =
			new File(folder.getAbsolutePath() + File.separator +
				sourceFileName + ext);
		try {
			FileUtils.copyFile(uploadedFile, filePath);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return File.separator + "shooter_document" + File.separator +
			user.getUserId() + File.separator + sourceFileName + ext;
	}

	private static Log _log = LogFactoryUtil.getLog(ESFUserAdminPortlet.class);
}
