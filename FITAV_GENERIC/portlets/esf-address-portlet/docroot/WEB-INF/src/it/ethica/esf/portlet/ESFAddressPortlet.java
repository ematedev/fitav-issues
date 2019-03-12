/**
 * 
 */

package it.ethica.esf.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import it.ethica.esf.model.City;
import it.ethica.esf.model.ESFAddress;
import it.ethica.esf.model.Province;
import it.ethica.esf.model.Region;
import it.ethica.esf.service.ESFAddressLocalServiceUtil;
import it.ethica.esf.util.ESFConstant;
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
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.Organization;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * @author Antonio
 */
public class ESFAddressPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest request, RenderResponse response)
		throws IOException, PortletException {

		long esfAddressId = ParamUtil.getLong(request, "esfAddressId");
		String op = ParamUtil.getString(request, "op");
		if (op.equals("addAddr"))
			prepareJSONAddAddress(request, response);
		else if (op.equals("updAddr"))
			try {
				prepareJSONUpdAddress(request, response, esfAddressId);
			}
			catch (PortalException e) {
				e.printStackTrace();
			}

		super.render(request, response);
	}

	/**
	 * Prepara l'oggetto JSON e lo setta come attributo. L'oggetto JSON avrà una
	 * lista di Regioni. 
	 * Usato nell'operazione di INSERT
	 * 
	 * @param request
	 * @param response
	 * @throws PortletException
	 */
	public void prepareJSONAddAddress(
		RenderRequest request, RenderResponse response)
		throws PortletException {

		try {
			JSONArray regionsJSONArray = JSONFactoryUtil.createJSONArray();
			ServiceContext serviceContext = null;
			try {
				serviceContext =
					ServiceContextFactory.getInstance(
						ESFAddressPortlet.class.getName(), request);
			}
			catch (PortalException | SystemException e1) {
				e1.printStackTrace();
			}

			List<Region> regions = ESFAddressLocalServiceUtil.findAllRegions();
			for (Region region : regions) {
				JSONArray regionsJSONSubarray =
					JSONFactoryUtil.createJSONArray();
				regionsJSONSubarray.put(region.getIdRegion());
				regionsJSONSubarray.put(region.getName());
				regionsJSONArray.put(regionsJSONSubarray);
			}
			request.setAttribute("regions", regionsJSONArray);

		}
		catch (SystemException e) {
			throw new PortletException(e);
		}
	}

	/**
	 * Prepara l'oggetto JSON e lo setta come attributo. L'oggetto JSON avrà una
	 * lista di Regioni, Province e Città. 
	 * Usato nell'operazione di UPDATE
	 * @param request
	 * @param response
	 * @param esfAddressId
	 * @throws PortletException
	 * @throws PortalException
	 */
	public void prepareJSONUpdAddress(
		RenderRequest request, RenderResponse response, long esfAddressId)
		throws PortletException, PortalException {

		try {

			ESFAddress esfAddress =
				ESFAddressLocalServiceUtil.getESFAddress(esfAddressId);

			JSONArray regionsJSONArray = JSONFactoryUtil.createJSONArray();
			JSONArray provincesJSONArray = JSONFactoryUtil.createJSONArray();
			JSONArray citiesJSONArray = JSONFactoryUtil.createJSONArray();

			ServiceContext serviceContext = null;
			try {
				serviceContext =
					ServiceContextFactory.getInstance(
						ESFAddressPortlet.class.getName(), request);
			}
			catch (PortalException | SystemException e1) {
				e1.printStackTrace();
			}

			// Lista delle regioni
			List<Region> regions = ESFAddressLocalServiceUtil.findAllRegions();
			for (Region region : regions) {
				JSONArray regionsJSONSubarray =
					JSONFactoryUtil.createJSONArray();
				regionsJSONSubarray.put(region.getIdRegion());
				regionsJSONSubarray.put(region.getName());
				regionsJSONArray.put(regionsJSONSubarray);
			}

			// Lista delle province associate alla regione già scelta
			String esfRegionId = esfAddress.getEsfRegionId();
			List<Province> provinces =
				ESFAddressLocalServiceUtil.findByC_R(
					esfRegionId, ESFConstant.DEFAULT_COUNTRY);
			for (Province province : provinces) {
				JSONArray provincesJSONSubarray =
					JSONFactoryUtil.createJSONArray();
				provincesJSONSubarray.put(province.getIdProvince());
				provincesJSONSubarray.put(province.getName());
				provincesJSONArray.put(provincesJSONSubarray);
				// regioniJSONArray.put(regione.getIdRegion() + "|" +
				// regione.getName());
			}

			// Lista delle città associate alla provincia già scelta
			String esfProvinceId = esfAddress.getEsfProvinceId();
			List<City> cities =
				ESFAddressLocalServiceUtil.findByC_R_P(
					ESFConstant.DEFAULT_COUNTRY, esfRegionId, esfProvinceId);
			for (City city : cities) {
				JSONArray cityJSONSubarray = JSONFactoryUtil.createJSONArray();
				cityJSONSubarray.put(city.getIdCity());
				cityJSONSubarray.put(city.getName());
				citiesJSONArray.put(cityJSONSubarray);
			}

			request.setAttribute("regions", regionsJSONArray);
			request.setAttribute("provinces", provincesJSONArray);
			request.setAttribute("cities", citiesJSONArray);

		}
		catch (SystemException e) {
			throw new PortletException(e);
		}
	}

	@Override
	public void serveResource(
		ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortletException {

		try {
			ServiceContext serviceContext = null;
			serviceContext =
				ServiceContextFactory.getInstance(
					ESFAddressPortlet.class.getName(), resourceRequest);

			HttpServletRequest httpReq =
				PortalUtil.getHttpServletRequest(resourceRequest);

			String param =
				PortalUtil.getOriginalServletRequest(httpReq).getParameter(
					"param");
			// String idCountryPar =
			// PortalUtil.getOriginalServletRequest(httpReq).getParameter(
			// "idCountry");
			String idRegion =
				PortalUtil.getOriginalServletRequest(httpReq).getParameter(
					"idRegion");
			String idProvince =
				PortalUtil.getOriginalServletRequest(httpReq).getParameter(
					"idProvince");

			String resourceID = resourceRequest.getResourceID();

			if (resourceID.equals("regions")) {
				serveRegions(
					resourceRequest, resourceResponse, param, ESFConstant.DEFAULT_COUNTRY,
					idRegion);
			}
			else if (resourceID.equals("provinces")) {
				serveProvinces(
					resourceRequest, resourceResponse, param, ESFConstant.DEFAULT_COUNTRY,
					idRegion, idProvince);
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

		// super.serveResource(resourceRequest, resourceResponse);
	}

	public void serveRegions(
		ResourceRequest resourceRequest, ResourceResponse resourceResponse,
		String param, String idCountry, String 	idRegion)
		throws Exception {

		JSONArray resultJSONArr = JSONFactoryUtil.createJSONArray();

		try {
			List<Province> province =
				ESFAddressLocalServiceUtil.findByC_R(idRegion, idCountry);
			for (Province provincia : province) {
				JSONArray regioniJSONSubarray =
					JSONFactoryUtil.createJSONArray();
				regioniJSONSubarray.put(provincia.getIdProvince());
				regioniJSONSubarray.put(provincia.getName());
				resultJSONArr.put(regioniJSONSubarray);
			}
		}
		catch (SystemException e) {
			throw new PortletException(e);
		}
		resourceResponse.getWriter().write(resultJSONArr.toString());
	}

	public void serveProvinces(
		ResourceRequest resourceRequest, ResourceResponse resourceResponse,
		String param, String idCountry, String idRegion, String idProvince)
		throws Exception {

		JSONArray resultJSONArr = JSONFactoryUtil.createJSONArray();

		try {
			List<City> comuni = new ArrayList<City>();
			comuni =
				ESFAddressLocalServiceUtil.findByC_R_P(
					idCountry, idRegion, idProvince);
			for (City comune : comuni) {
				JSONArray regioniJSONSubarray =
					JSONFactoryUtil.createJSONArray();
				regioniJSONSubarray.put(comune.getIdCity());
				regioniJSONSubarray.put(comune.getName());
				resultJSONArr.put(regioniJSONSubarray);
			}
		}
		catch (SystemException e) {
			throw new PortletException(e);
		}

		resourceResponse.getWriter().write(resultJSONArr.toString());
	}

	public void addESFAddress(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFAddress.class.getName(), actionRequest);

		double longitude = ParamUtil.getDouble(actionRequest, "longitude");
		double latitude = ParamUtil.getDouble(actionRequest, "latitude");
		String street1 = ParamUtil.getString(actionRequest, "street1");
		String esfCountryId = ESFConstant.DEFAULT_COUNTRY;
		// ParamUtil.getString(actionRequest, "country");
		String esfRegionId = ParamUtil.getString(actionRequest, "esfRegionId");
		String esfProvinceId =
			ParamUtil.getString(actionRequest, "esfProvinceId");
		long esfCityId = ParamUtil.getLong(actionRequest, "esfCityId");

		try {
			ESFAddressLocalServiceUtil.addESFAddress(
				serviceContext.getUserId(), longitude, esfCountryId,
				esfRegionId, esfProvinceId, esfCityId, latitude,
				Organization.class.getName(), serviceContext.getScopeGroupId(),
				street1, null, null, "zip", 12000, false, false, serviceContext);
			// ListTypeConstants.ACCOUNT_ADDRESS_DEFAULT;
			SessionMessages.add(actionRequest, "addESFAddressMess");
		}
		catch (PortalException e) {
			SessionErrors.add(actionRequest, e.getClass().getName());

			actionResponse.setRenderParameter("mvcPath", "");
		}
	}

	public void updateESFAddress(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFAddress.class.getName(), actionRequest);

		long esfAddressId = ParamUtil.getLong(actionRequest, "esfAddressId");
		double longitude = ParamUtil.getDouble(actionRequest, "longitude");
		double latitude = ParamUtil.getDouble(actionRequest, "latitude");
		String street1 = ParamUtil.getString(actionRequest, "street1");
		String esfCountryId = ESFConstant.DEFAULT_COUNTRY;
		// ParamUtil.getString(actionRequest, "esfCountryId");
		String esfRegionId = ParamUtil.getString(actionRequest, "esfRegionId");
		String esfProvinceId =
			ParamUtil.getString(actionRequest, "esfProvinceId");
		long esfCityId = ParamUtil.getLong(actionRequest, "esfCityId");

		try {
			ESFAddressLocalServiceUtil.updateESFAddress(
				serviceContext.getUserId(), esfAddressId, esfCountryId,
				esfRegionId, esfProvinceId, esfCityId, latitude, longitude,
				Organization.class.getName(), serviceContext.getScopeGroupId(),
				street1, null, null, "zip", 12000, false, false, serviceContext);

			SessionMessages.add(actionRequest, "updateESFAddressMess");
		}
		catch (PortalException e) {
			SessionErrors.add(actionRequest, e.getClass().getName());

			actionResponse.setRenderParameter("mvcPath", "");
		}
	}

	public void deleteESFAddress(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException {

		ServiceContext serviceContext =
			ServiceContextFactory.getInstance(
				ESFAddress.class.getName(), actionRequest);

		long esfAddressId = ParamUtil.getLong(actionRequest, "esfAddressId");

		try {
			ESFAddressLocalServiceUtil.deleteESFAddress(
				esfAddressId, serviceContext);

			SessionMessages.add(actionRequest, "deleteESFAddressMess");
		}
		catch (PortalException e) {
			SessionErrors.add(actionRequest, e.getClass().getName());

			actionResponse.setRenderParameter("mvcPath", "");
		}
	}

}
