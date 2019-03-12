
package it.ethica.esf.util;

import it.ethica.esf.model.ESFAddress;
import it.ethica.esf.model.ESFCard;
import it.ethica.esf.model.ESFCity;
import it.ethica.esf.model.ESFField;
import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.model.ESFProvince;
import it.ethica.esf.model.ESFRegion;
import it.ethica.esf.model.ESFSportType;
import it.ethica.esf.service.ESFAddressLocalServiceUtil;
import it.ethica.esf.service.ESFCardLocalServiceUtil;
import it.ethica.esf.service.ESFFieldLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;
import it.ethica.esf.service.ESFSportTypeLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;

public class ESFJsonUtil {

	private ServiceContext serviceContext;

	public ESFJsonUtil(String className, RenderRequest request)
		throws ClassNotFoundException, PortalException, SystemException {

		Class classObject = Class.forName(className);
		serviceContext =
			ServiceContextFactory.getInstance(classObject.getName(), request);
	}

	public ESFJsonUtil() {

	}

	/**
	 * Prepara l'oggetto JSON e lo setta come attributo. L'oggetto JSON avrà una
	 * lista di Regioni. Usato nell'operazione di INSERT
	 * 
	 * @param request
	 * @param response
	 * @param index 
	 * @throws PortletException
	 */
	public void prepareJSONAddAddress(
		RenderRequest request, RenderResponse response, int index)
		throws PortletException {

		try {
			JSONArray regionsJSONArray = JSONFactoryUtil.createJSONArray();

			List<ESFRegion> regions =
				ESFAddressLocalServiceUtil.findAllRegions();
			for (ESFRegion region : regions) {
				JSONArray regionsJSONSubarray =
					JSONFactoryUtil.createJSONArray();
				regionsJSONSubarray.put(region.getIdRegion());
				regionsJSONSubarray.put(region.getName());
				regionsJSONArray.put(regionsJSONSubarray);
			}
			
			request.setAttribute("regions"+index, regionsJSONArray);
			
		}
		catch (SystemException e) {
			throw new PortletException(e);
		}
	}

	/**
	 * Prepara l'oggetto JSON e lo setta come attributo. L'oggetto JSON avrà una
	 * lista di Regioni, Province e Città. Usato nell'operazione di UPDATE
	 * 
	 * @param request
	 * @param response
	 * @param esfAddressId
	 * @throws PortletException
	 * @throws PortalException
	 */
	public void prepareJSONUpdAddress(
		RenderRequest request, RenderResponse response, long esfAddressId, int index)
		throws PortletException, PortalException {

		try {

			ESFAddress esfAddress =
				ESFAddressLocalServiceUtil.getESFAddress(esfAddressId);

			JSONArray regionsJSONArray = JSONFactoryUtil.createJSONArray();
			JSONArray provincesJSONArray = JSONFactoryUtil.createJSONArray();
			JSONArray citiesJSONArray = JSONFactoryUtil.createJSONArray();

			// Lista delle regioni
			List<ESFRegion> regions =
				ESFAddressLocalServiceUtil.findAllRegions();
			for (ESFRegion region : regions) {
				JSONArray regionsJSONSubarray =
					JSONFactoryUtil.createJSONArray();
				regionsJSONSubarray.put(region.getIdRegion());
				regionsJSONSubarray.put(region.getName());
				regionsJSONArray.put(regionsJSONSubarray);
			}

			// Lista delle province associate alla regione già scelta
			String esfRegionId = esfAddress.getEsfRegionId();
			List<ESFProvince> provinces =
				ESFAddressLocalServiceUtil.findByC_R(
					esfRegionId, ESFKeys.ESFAddressConstant.DEFAULT_COUNTRY);
			for (ESFProvince province : provinces) {
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
			List<ESFCity> cities =
				ESFAddressLocalServiceUtil.findByC_R_P(
					ESFKeys.ESFAddressConstant.DEFAULT_COUNTRY, esfRegionId,
					esfProvinceId);
			for (ESFCity city : cities) {
				JSONArray cityJSONSubarray = JSONFactoryUtil.createJSONArray();
				cityJSONSubarray.put(city.getIdCity());
				cityJSONSubarray.put(city.getName());
				citiesJSONArray.put(cityJSONSubarray);
			}

			request.setAttribute("regions"+index, regionsJSONArray);
			request.setAttribute("provinces"+index, provincesJSONArray);
			request.setAttribute("cities"+index, citiesJSONArray);

		}
		catch (SystemException e) {
			throw new PortletException(e);
		}
	}

	/**
	 * Prepara l'oggetto JSON e lo setta come attributo. L'oggetto JSON avrà una
	 * lista di Associations. Usato nell'operazione di INSERT
	 * 
	 * @param request
	 * @param response
	 * @throws PortletException
	 * @throws PortalException
	 */
	public void prepareJSONAddAssociations(
		RenderRequest request, RenderResponse response)
		throws PortalException, PortletException {

		try {
			JSONArray associationsJSONArray = JSONFactoryUtil.createJSONArray();
			long organizationId = ParamUtil.getLong(request, "organizationId");

			List<ESFOrganization> associations =
				ESFOrganizationLocalServiceUtil.findAllLeafOrganizations(organizationId);
			for (ESFOrganization association : associations) {
				JSONArray associationsJSONSubarray =
					JSONFactoryUtil.createJSONArray();
				associationsJSONSubarray.put(association.getEsfOrganizationId());
				associationsJSONSubarray.put(association.getName());
				associationsJSONArray.put(associationsJSONSubarray);
			}
			request.setAttribute("associations", associationsJSONArray);

		}
		catch (SystemException e) {
			throw new PortletException(e);
		}
	}

	/**
	 * Prepara l'oggetto JSON e lo setta come attributo. L'oggetto JSON avrà una
	 * lista di Associations e Cards. Usato nell'operazione di UPDATE
	 * 
	 * @param request
	 * @param response
	 * @throws PortletException
	 * @throws PortalException
	 */
	public void prepareJSONUpdAssociationsCards(
		RenderRequest request, RenderResponse response)
		throws PortletException, PortalException {

		try {

			JSONArray associationsJSONArray = JSONFactoryUtil.createJSONArray();
			JSONArray cardsJSONArray = JSONFactoryUtil.createJSONArray();

			// Lista delle associations
			long organizationId = ParamUtil.getLong(request, "organizationId");
			long esfUserId = ParamUtil.getLong(request, "esfUserId");

			List<ESFOrganization> associations =
				ESFOrganizationLocalServiceUtil.findAllLeafOrganizations(organizationId);
			for (ESFOrganization association : associations) {
				JSONArray associationsJSONSubarray =
					JSONFactoryUtil.createJSONArray();
				associationsJSONSubarray.put(association.getEsfOrganizationId());
				associationsJSONSubarray.put(association.getName());
				associationsJSONArray.put(associationsJSONSubarray);
			}

			// Lista delle cards associate alla association già scelta
			List<ESFCard> cardsTmp =
				ESFCardLocalServiceUtil.findAllESFCardsByU_S(
					esfUserId, ESFKeys.ESFStateType.ENABLE);

			if (cardsTmp.size() != 0) {
				ESFCard card = cardsTmp.get(0);

				List<ESFCard> cards =
					ESFCardLocalServiceUtil.findAllNotAssignedESFCardsByO_U_S(
						card.getEsfOrganizationId(), true, esfUserId,
						ESFKeys.ESFStateType.ENABLE);

				for (ESFCard esfCard : cards) {
					JSONArray cardsJSONSubarray =
						JSONFactoryUtil.createJSONArray();
					cardsJSONSubarray.put(esfCard.getEsfCardId());
					cardsJSONSubarray.put(esfCard.getCode());
					cardsJSONArray.put(cardsJSONSubarray);
					// regioniJSONArray.put(regione.getIdRegion() + "|" +
					// regione.getName());
				}

				request.setAttribute("cards", cardsJSONArray);
			}

			request.setAttribute("associations", associationsJSONArray);

		}
		catch (SystemException e) {
			throw new PortletException(e);
		}
	}
	
	/**
	 * Prepara l'oggetto JSON e lo setta come attributo. L'oggetto JSON avrà una
	 * lista di Associations e Fields. Usato nell'operazione di UPDATE
	 * 
	 * @param request
	 * @param response
	 * @throws PortletException
	 * @throws PortalException
	 */
	public void prepareJSONUpdAssociationsFields(
		RenderRequest request, RenderResponse response)
		throws PortletException, PortalException {

		try {

			JSONArray associationsJSONArray = JSONFactoryUtil.createJSONArray();
			JSONArray fieldsJSONArray = JSONFactoryUtil.createJSONArray();
			JSONArray sportTypesJSONArray = JSONFactoryUtil.createJSONArray();

			long organizationId = ParamUtil.getLong(request, "organizationId");
			long associationId = ParamUtil.getLong(request, "associationId");
			long fieldId = ParamUtil.getLong(request, "fieldId");
			
			List<ESFOrganization> associations =
				ESFOrganizationLocalServiceUtil.findAllLeafOrganizations(organizationId);
			for (ESFOrganization association : associations) {
				JSONArray associationsJSONSubarray =
					JSONFactoryUtil.createJSONArray();
				associationsJSONSubarray.put(association.getEsfOrganizationId());
				associationsJSONSubarray.put(association.getName());
				associationsJSONArray.put(associationsJSONSubarray);
			}

			List<ESFField> fieldsTmps = ESFFieldLocalServiceUtil.findByESFOrganization(associationId, ESFKeys.ESFStateType.ENABLE);
			
			for (ESFField fieldsTmp : fieldsTmps) {
				JSONArray fieldsJSONSubarray =
					JSONFactoryUtil.createJSONArray();
				fieldsJSONSubarray.put(fieldsTmp.getEsfFieldId());
				fieldsJSONSubarray.put(fieldsTmp.getName());
				fieldsJSONArray.put(fieldsJSONSubarray);
				// regioniJSONArray.put(regione.getIdRegion() + "|" +
				// regione.getName());
			}
			
			List<ESFSportType> esfSportTypes = ESFSportTypeLocalServiceUtil.findByESFFieldId(fieldId);
			
			for (ESFSportType esfSportType : esfSportTypes) {
				JSONArray sportTypesJSONSubarray =
					JSONFactoryUtil.createJSONArray();
				sportTypesJSONSubarray.put(esfSportType.getEsfSportTypeId());
				sportTypesJSONSubarray.put(esfSportType.getName());
				sportTypesJSONArray.put(sportTypesJSONSubarray);
				// regioniJSONArray.put(regione.getIdRegion() + "|" +
				// regione.getName());
			}

			request.setAttribute("sporttypes", sportTypesJSONArray);
			request.setAttribute("fields", fieldsJSONArray);
			request.setAttribute("associations", associationsJSONArray);

		}
		catch (SystemException e) {
			throw new PortletException(e);
		}
	}

	/**
	 * Prepara l'oggetto JSON e lo setta come attributo. L'oggetto JSON avrà una
	 * lista di Regioni. Usato nell'operazione di INSERT
	 * 
	 * @param request
	 * @param response
	 * @throws PortletException
	 * @throws PortalException 
	 */
	public void prepareJSONOrganizations(
		RenderRequest request, RenderResponse response)
		throws PortletException, PortalException {

		try {
			JSONArray resultJSONArr = JSONFactoryUtil.createJSONArray();
			
			long organizationId = ParamUtil.getLong(request, "organizationId");

			List<ESFOrganization> organizations =
							ESFOrganizationLocalServiceUtil.findAllChildOrganizations(organizationId);
			
			for (ESFOrganization organization : organizations) {
				JSONArray organizationJSONSubarray =
					JSONFactoryUtil.createJSONArray();
				organizationJSONSubarray.put(organization.getEsfOrganizationId());
				organizationJSONSubarray.put(organization.getName());
				resultJSONArr.put(organizationJSONSubarray);
			}
			
			request.setAttribute("liv1", resultJSONArr);

		}
		catch (SystemException e) {
			throw new PortletException(e);
		}
	}
	
}
