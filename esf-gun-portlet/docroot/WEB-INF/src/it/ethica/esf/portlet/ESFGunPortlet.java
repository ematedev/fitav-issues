package it.ethica.esf.portlet;

import it.ethica.esf.model.ESFGun;
import it.ethica.esf.model.ESFGunKind;
import it.ethica.esf.service.ESFGunLocalServiceUtil;
import it.ethica.esf.service.ESFGunKindLocalServiceUtil;
import it.ethica.esf.service.ESFGunTypeLocalServiceUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ESFGunPortlet
 */
public class ESFGunPortlet extends MVCPortlet {
	
	public void editESFGun(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				ESFGun.class.getName(), request);

		long esfGunId = ParamUtil.getLong(request, "esfGunId");
		String code = ParamUtil.getString(request, "code");
		long esfGunKindId = ParamUtil.getLong(request,
				"esfGunKindId");
		long esfGunTypeId = ParamUtil.getLong(request,
				"esfGunTypeId");
		long esfOrganizationId = ParamUtil.getLong(request, "esfOrganizationId");
		long esfUserId = ParamUtil.getLong(request,
				"esfUserId");

		if(esfGunId > 0) {

			ESFGunLocalServiceUtil.updateESFGun(serviceContext.getUserId(),
					esfGunId, code, esfGunKindId, esfOrganizationId, esfUserId,
					serviceContext);
		}
		else {

			ESFGunLocalServiceUtil.addESFGun(serviceContext.getUserId(), code,
					esfGunKindId, esfOrganizationId, esfUserId, serviceContext);
		}
	}
	
	public void deleteESFGun(ActionRequest request, ActionResponse response)
			throws PortalException, SystemException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				ESFGun.class.getName(), request);

		long esfGunId = ParamUtil.getLong(request, "esfGunId");

		if(esfGunId > 0) {

			ESFGunLocalServiceUtil.deleteESFGun(esfGunId, serviceContext);
		}
	}
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {

		HttpServletRequest httpReq = PortalUtil
				.getHttpServletRequest(resourceRequest);
		httpReq = PortalUtil.getOriginalServletRequest(httpReq);
		
		long esfGunTypeId = ParamUtil.getLong(httpReq, "esfGunTypeId", 0);
		
		if (esfGunTypeId > 0) {
			
			List<ESFGunKind> esfGunKinds = new ArrayList<>();

			try {
				esfGunKinds = ESFGunKindLocalServiceUtil
						.getESFGunKindsByESFGunType(esfGunTypeId);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			JSONObject resultJSONObj = JSONFactoryUtil.createJSONObject();
			JSONArray resultJSONArr = JSONFactoryUtil.createJSONArray();

			for(ESFGunKind esfGunKind : esfGunKinds) {

				JSONObject esfGunKindIdName = JSONFactoryUtil.createJSONObject();

				esfGunKindIdName.put("esfGunKindId",esfGunKind.getEsfGunKindId());
				esfGunKindIdName.put("name", esfGunKind.getName());

				resultJSONArr.put(esfGunKindIdName);
			}

			resultJSONObj.put("esfGunKinds", resultJSONArr);

			resourceResponse.getWriter().write(resultJSONObj.toString());
		}
	}
}
