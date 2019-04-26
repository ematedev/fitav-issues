/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.ethica.esf.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import it.ethica.esf.model.ESFAddressClp;
import it.ethica.esf.model.ESFAirportClp;
import it.ethica.esf.model.ESFAnnualConiReportClp;
import it.ethica.esf.model.ESFAnnualFreeCardClp;
import it.ethica.esf.model.ESFBrandClp;
import it.ethica.esf.model.ESFCaneClp;
import it.ethica.esf.model.ESFCardClp;
import it.ethica.esf.model.ESFCategoryClp;
import it.ethica.esf.model.ESFCatridgeClp;
import it.ethica.esf.model.ESFCityClp;
import it.ethica.esf.model.ESFCodeOrgClp;
import it.ethica.esf.model.ESFConfigurationClp;
import it.ethica.esf.model.ESFCountryClp;
import it.ethica.esf.model.ESFDepartureClp;
import it.ethica.esf.model.ESFDescriptionClp;
import it.ethica.esf.model.ESFDocumentClp;
import it.ethica.esf.model.ESFDocumentTypeClp;
import it.ethica.esf.model.ESFElectronicClp;
import it.ethica.esf.model.ESFEntityStateClp;
import it.ethica.esf.model.ESFEventTypeClp;
import it.ethica.esf.model.ESFFederalRoleClp;
import it.ethica.esf.model.ESFFederalRoleESFSpecificClp;
import it.ethica.esf.model.ESFFieldClp;
import it.ethica.esf.model.ESFFieldESFElectronicClp;
import it.ethica.esf.model.ESFFieldESFSportTypeClp;
import it.ethica.esf.model.ESFFornitureClp;
import it.ethica.esf.model.ESFFornitureRelClp;
import it.ethica.esf.model.ESFFornitureTypeClp;
import it.ethica.esf.model.ESFFornitureUserClp;
import it.ethica.esf.model.ESFGunClp;
import it.ethica.esf.model.ESFGunKindClp;
import it.ethica.esf.model.ESFGunTypeClp;
import it.ethica.esf.model.ESFHistoricalAssociationClp;
import it.ethica.esf.model.ESFInstructsShootingDirectorClp;
import it.ethica.esf.model.ESFJobClp;
import it.ethica.esf.model.ESFJunioresClp;
import it.ethica.esf.model.ESFLentFieldClp;
import it.ethica.esf.model.ESFMatchClp;
import it.ethica.esf.model.ESFMatchResultClp;
import it.ethica.esf.model.ESFMatchTypeClp;
import it.ethica.esf.model.ESFNationalClp;
import it.ethica.esf.model.ESFNationalDelegationClp;
import it.ethica.esf.model.ESFNationalMatchResultClp;
import it.ethica.esf.model.ESFOrganizationClp;
import it.ethica.esf.model.ESFOrganizationUnitserviceClp;
import it.ethica.esf.model.ESFPartecipantClp;
import it.ethica.esf.model.ESFPartecipantInfoClp;
import it.ethica.esf.model.ESFPartecipantTypeClp;
import it.ethica.esf.model.ESFPhoneClp;
import it.ethica.esf.model.ESFProvinceClp;
import it.ethica.esf.model.ESFPublicAuthorityClp;
import it.ethica.esf.model.ESFRegionClp;
import it.ethica.esf.model.ESFRenewalClp;
import it.ethica.esf.model.ESFResultClp;
import it.ethica.esf.model.ESFShooterAffiliationChronoClp;
import it.ethica.esf.model.ESFShooterCategoryClp;
import it.ethica.esf.model.ESFShooterCategoryESFMatchClp;
import it.ethica.esf.model.ESFShooterCategoryESFTournamentClp;
import it.ethica.esf.model.ESFShooterQualificationClp;
import it.ethica.esf.model.ESFShooterQualificationESFMatchClp;
import it.ethica.esf.model.ESFShooterQualificationESFTournamentClp;
import it.ethica.esf.model.ESFShootingDirectorClp;
import it.ethica.esf.model.ESFShootingDirectorQualificationClp;
import it.ethica.esf.model.ESFSpecificClp;
import it.ethica.esf.model.ESFSportTypeClp;
import it.ethica.esf.model.ESFStateAssEntityClp;
import it.ethica.esf.model.ESFStateClp;
import it.ethica.esf.model.ESFSuspensiveCodeClp;
import it.ethica.esf.model.ESFSuspensiveShootingDirectorClp;
import it.ethica.esf.model.ESFTeamClp;
import it.ethica.esf.model.ESFTournamentClp;
import it.ethica.esf.model.ESFTransitionClp;
import it.ethica.esf.model.ESFUnitserviceClp;
import it.ethica.esf.model.ESFUserCategoryClp;
import it.ethica.esf.model.ESFUserClp;
import it.ethica.esf.model.ESFUserESFFederalRoleClp;
import it.ethica.esf.model.ESFUserESFUserRoleClp;
import it.ethica.esf.model.ESFUserRoleClp;
import it.ethica.esf.model.ESFgunUserClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ethica
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"esf-fitav-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"esf-fitav-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "esf-fitav-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(ESFAddressClp.class.getName())) {
			return translateInputESFAddress(oldModel);
		}

		if (oldModelClassName.equals(ESFAirportClp.class.getName())) {
			return translateInputESFAirport(oldModel);
		}

		if (oldModelClassName.equals(ESFAnnualConiReportClp.class.getName())) {
			return translateInputESFAnnualConiReport(oldModel);
		}

		if (oldModelClassName.equals(ESFAnnualFreeCardClp.class.getName())) {
			return translateInputESFAnnualFreeCard(oldModel);
		}

		if (oldModelClassName.equals(ESFBrandClp.class.getName())) {
			return translateInputESFBrand(oldModel);
		}

		if (oldModelClassName.equals(ESFCaneClp.class.getName())) {
			return translateInputESFCane(oldModel);
		}

		if (oldModelClassName.equals(ESFCardClp.class.getName())) {
			return translateInputESFCard(oldModel);
		}

		if (oldModelClassName.equals(ESFCategoryClp.class.getName())) {
			return translateInputESFCategory(oldModel);
		}

		if (oldModelClassName.equals(ESFCatridgeClp.class.getName())) {
			return translateInputESFCatridge(oldModel);
		}

		if (oldModelClassName.equals(ESFCityClp.class.getName())) {
			return translateInputESFCity(oldModel);
		}

		if (oldModelClassName.equals(ESFCodeOrgClp.class.getName())) {
			return translateInputESFCodeOrg(oldModel);
		}

		if (oldModelClassName.equals(ESFConfigurationClp.class.getName())) {
			return translateInputESFConfiguration(oldModel);
		}

		if (oldModelClassName.equals(ESFCountryClp.class.getName())) {
			return translateInputESFCountry(oldModel);
		}

		if (oldModelClassName.equals(ESFDepartureClp.class.getName())) {
			return translateInputESFDeparture(oldModel);
		}

		if (oldModelClassName.equals(ESFDescriptionClp.class.getName())) {
			return translateInputESFDescription(oldModel);
		}

		if (oldModelClassName.equals(ESFDocumentClp.class.getName())) {
			return translateInputESFDocument(oldModel);
		}

		if (oldModelClassName.equals(ESFDocumentTypeClp.class.getName())) {
			return translateInputESFDocumentType(oldModel);
		}

		if (oldModelClassName.equals(ESFElectronicClp.class.getName())) {
			return translateInputESFElectronic(oldModel);
		}

		if (oldModelClassName.equals(ESFEntityStateClp.class.getName())) {
			return translateInputESFEntityState(oldModel);
		}

		if (oldModelClassName.equals(ESFEventTypeClp.class.getName())) {
			return translateInputESFEventType(oldModel);
		}

		if (oldModelClassName.equals(ESFFederalRoleClp.class.getName())) {
			return translateInputESFFederalRole(oldModel);
		}

		if (oldModelClassName.equals(
					ESFFederalRoleESFSpecificClp.class.getName())) {
			return translateInputESFFederalRoleESFSpecific(oldModel);
		}

		if (oldModelClassName.equals(ESFFieldClp.class.getName())) {
			return translateInputESFField(oldModel);
		}

		if (oldModelClassName.equals(ESFFieldESFElectronicClp.class.getName())) {
			return translateInputESFFieldESFElectronic(oldModel);
		}

		if (oldModelClassName.equals(ESFFieldESFSportTypeClp.class.getName())) {
			return translateInputESFFieldESFSportType(oldModel);
		}

		if (oldModelClassName.equals(ESFFornitureClp.class.getName())) {
			return translateInputESFForniture(oldModel);
		}

		if (oldModelClassName.equals(ESFFornitureRelClp.class.getName())) {
			return translateInputESFFornitureRel(oldModel);
		}

		if (oldModelClassName.equals(ESFFornitureTypeClp.class.getName())) {
			return translateInputESFFornitureType(oldModel);
		}

		if (oldModelClassName.equals(ESFFornitureUserClp.class.getName())) {
			return translateInputESFFornitureUser(oldModel);
		}

		if (oldModelClassName.equals(ESFGunClp.class.getName())) {
			return translateInputESFGun(oldModel);
		}

		if (oldModelClassName.equals(ESFGunKindClp.class.getName())) {
			return translateInputESFGunKind(oldModel);
		}

		if (oldModelClassName.equals(ESFGunTypeClp.class.getName())) {
			return translateInputESFGunType(oldModel);
		}

		if (oldModelClassName.equals(ESFgunUserClp.class.getName())) {
			return translateInputESFgunUser(oldModel);
		}

		if (oldModelClassName.equals(
					ESFHistoricalAssociationClp.class.getName())) {
			return translateInputESFHistoricalAssociation(oldModel);
		}

		if (oldModelClassName.equals(
					ESFInstructsShootingDirectorClp.class.getName())) {
			return translateInputESFInstructsShootingDirector(oldModel);
		}

		if (oldModelClassName.equals(ESFJobClp.class.getName())) {
			return translateInputESFJob(oldModel);
		}

		if (oldModelClassName.equals(ESFJunioresClp.class.getName())) {
			return translateInputESFJuniores(oldModel);
		}

		if (oldModelClassName.equals(ESFLentFieldClp.class.getName())) {
			return translateInputESFLentField(oldModel);
		}

		if (oldModelClassName.equals(ESFMatchClp.class.getName())) {
			return translateInputESFMatch(oldModel);
		}

		if (oldModelClassName.equals(ESFMatchResultClp.class.getName())) {
			return translateInputESFMatchResult(oldModel);
		}

		if (oldModelClassName.equals(ESFMatchTypeClp.class.getName())) {
			return translateInputESFMatchType(oldModel);
		}

		if (oldModelClassName.equals(ESFNationalClp.class.getName())) {
			return translateInputESFNational(oldModel);
		}

		if (oldModelClassName.equals(ESFNationalDelegationClp.class.getName())) {
			return translateInputESFNationalDelegation(oldModel);
		}

		if (oldModelClassName.equals(ESFNationalMatchResultClp.class.getName())) {
			return translateInputESFNationalMatchResult(oldModel);
		}

		if (oldModelClassName.equals(ESFOrganizationClp.class.getName())) {
			return translateInputESFOrganization(oldModel);
		}

		if (oldModelClassName.equals(
					ESFOrganizationUnitserviceClp.class.getName())) {
			return translateInputESFOrganizationUnitservice(oldModel);
		}

		if (oldModelClassName.equals(ESFPartecipantClp.class.getName())) {
			return translateInputESFPartecipant(oldModel);
		}

		if (oldModelClassName.equals(ESFPartecipantInfoClp.class.getName())) {
			return translateInputESFPartecipantInfo(oldModel);
		}

		if (oldModelClassName.equals(ESFPartecipantTypeClp.class.getName())) {
			return translateInputESFPartecipantType(oldModel);
		}

		if (oldModelClassName.equals(ESFPhoneClp.class.getName())) {
			return translateInputESFPhone(oldModel);
		}

		if (oldModelClassName.equals(ESFProvinceClp.class.getName())) {
			return translateInputESFProvince(oldModel);
		}

		if (oldModelClassName.equals(ESFPublicAuthorityClp.class.getName())) {
			return translateInputESFPublicAuthority(oldModel);
		}

		if (oldModelClassName.equals(ESFRegionClp.class.getName())) {
			return translateInputESFRegion(oldModel);
		}

		if (oldModelClassName.equals(ESFRenewalClp.class.getName())) {
			return translateInputESFRenewal(oldModel);
		}

		if (oldModelClassName.equals(ESFResultClp.class.getName())) {
			return translateInputESFResult(oldModel);
		}

		if (oldModelClassName.equals(
					ESFShooterAffiliationChronoClp.class.getName())) {
			return translateInputESFShooterAffiliationChrono(oldModel);
		}

		if (oldModelClassName.equals(ESFShooterCategoryClp.class.getName())) {
			return translateInputESFShooterCategory(oldModel);
		}

		if (oldModelClassName.equals(
					ESFShooterCategoryESFMatchClp.class.getName())) {
			return translateInputESFShooterCategoryESFMatch(oldModel);
		}

		if (oldModelClassName.equals(
					ESFShooterCategoryESFTournamentClp.class.getName())) {
			return translateInputESFShooterCategoryESFTournament(oldModel);
		}

		if (oldModelClassName.equals(ESFShooterQualificationClp.class.getName())) {
			return translateInputESFShooterQualification(oldModel);
		}

		if (oldModelClassName.equals(
					ESFShooterQualificationESFMatchClp.class.getName())) {
			return translateInputESFShooterQualificationESFMatch(oldModel);
		}

		if (oldModelClassName.equals(
					ESFShooterQualificationESFTournamentClp.class.getName())) {
			return translateInputESFShooterQualificationESFTournament(oldModel);
		}

		if (oldModelClassName.equals(ESFShootingDirectorClp.class.getName())) {
			return translateInputESFShootingDirector(oldModel);
		}

		if (oldModelClassName.equals(
					ESFShootingDirectorQualificationClp.class.getName())) {
			return translateInputESFShootingDirectorQualification(oldModel);
		}

		if (oldModelClassName.equals(ESFSpecificClp.class.getName())) {
			return translateInputESFSpecific(oldModel);
		}

		if (oldModelClassName.equals(ESFSportTypeClp.class.getName())) {
			return translateInputESFSportType(oldModel);
		}

		if (oldModelClassName.equals(ESFStateClp.class.getName())) {
			return translateInputESFState(oldModel);
		}

		if (oldModelClassName.equals(ESFStateAssEntityClp.class.getName())) {
			return translateInputESFStateAssEntity(oldModel);
		}

		if (oldModelClassName.equals(ESFSuspensiveCodeClp.class.getName())) {
			return translateInputESFSuspensiveCode(oldModel);
		}

		if (oldModelClassName.equals(
					ESFSuspensiveShootingDirectorClp.class.getName())) {
			return translateInputESFSuspensiveShootingDirector(oldModel);
		}

		if (oldModelClassName.equals(ESFTeamClp.class.getName())) {
			return translateInputESFTeam(oldModel);
		}

		if (oldModelClassName.equals(ESFTournamentClp.class.getName())) {
			return translateInputESFTournament(oldModel);
		}

		if (oldModelClassName.equals(ESFTransitionClp.class.getName())) {
			return translateInputESFTransition(oldModel);
		}

		if (oldModelClassName.equals(ESFUnitserviceClp.class.getName())) {
			return translateInputESFUnitservice(oldModel);
		}

		if (oldModelClassName.equals(ESFUserClp.class.getName())) {
			return translateInputESFUser(oldModel);
		}

		if (oldModelClassName.equals(ESFUserCategoryClp.class.getName())) {
			return translateInputESFUserCategory(oldModel);
		}

		if (oldModelClassName.equals(ESFUserESFFederalRoleClp.class.getName())) {
			return translateInputESFUserESFFederalRole(oldModel);
		}

		if (oldModelClassName.equals(ESFUserESFUserRoleClp.class.getName())) {
			return translateInputESFUserESFUserRole(oldModel);
		}

		if (oldModelClassName.equals(ESFUserRoleClp.class.getName())) {
			return translateInputESFUserRole(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputESFAddress(BaseModel<?> oldModel) {
		ESFAddressClp oldClpModel = (ESFAddressClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFAddressRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFAirport(BaseModel<?> oldModel) {
		ESFAirportClp oldClpModel = (ESFAirportClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFAirportRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFAnnualConiReport(
		BaseModel<?> oldModel) {
		ESFAnnualConiReportClp oldClpModel = (ESFAnnualConiReportClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFAnnualConiReportRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFAnnualFreeCard(BaseModel<?> oldModel) {
		ESFAnnualFreeCardClp oldClpModel = (ESFAnnualFreeCardClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFAnnualFreeCardRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFBrand(BaseModel<?> oldModel) {
		ESFBrandClp oldClpModel = (ESFBrandClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFBrandRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFCane(BaseModel<?> oldModel) {
		ESFCaneClp oldClpModel = (ESFCaneClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFCaneRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFCard(BaseModel<?> oldModel) {
		ESFCardClp oldClpModel = (ESFCardClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFCardRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFCategory(BaseModel<?> oldModel) {
		ESFCategoryClp oldClpModel = (ESFCategoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFCategoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFCatridge(BaseModel<?> oldModel) {
		ESFCatridgeClp oldClpModel = (ESFCatridgeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFCatridgeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFCity(BaseModel<?> oldModel) {
		ESFCityClp oldClpModel = (ESFCityClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFCityRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFCodeOrg(BaseModel<?> oldModel) {
		ESFCodeOrgClp oldClpModel = (ESFCodeOrgClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFCodeOrgRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFConfiguration(BaseModel<?> oldModel) {
		ESFConfigurationClp oldClpModel = (ESFConfigurationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFConfigurationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFCountry(BaseModel<?> oldModel) {
		ESFCountryClp oldClpModel = (ESFCountryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFCountryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFDeparture(BaseModel<?> oldModel) {
		ESFDepartureClp oldClpModel = (ESFDepartureClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFDepartureRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFDescription(BaseModel<?> oldModel) {
		ESFDescriptionClp oldClpModel = (ESFDescriptionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFDescriptionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFDocument(BaseModel<?> oldModel) {
		ESFDocumentClp oldClpModel = (ESFDocumentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFDocumentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFDocumentType(BaseModel<?> oldModel) {
		ESFDocumentTypeClp oldClpModel = (ESFDocumentTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFDocumentTypeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFElectronic(BaseModel<?> oldModel) {
		ESFElectronicClp oldClpModel = (ESFElectronicClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFElectronicRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFEntityState(BaseModel<?> oldModel) {
		ESFEntityStateClp oldClpModel = (ESFEntityStateClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFEntityStateRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFEventType(BaseModel<?> oldModel) {
		ESFEventTypeClp oldClpModel = (ESFEventTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFEventTypeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFFederalRole(BaseModel<?> oldModel) {
		ESFFederalRoleClp oldClpModel = (ESFFederalRoleClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFFederalRoleRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFFederalRoleESFSpecific(
		BaseModel<?> oldModel) {
		ESFFederalRoleESFSpecificClp oldClpModel = (ESFFederalRoleESFSpecificClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFFederalRoleESFSpecificRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFField(BaseModel<?> oldModel) {
		ESFFieldClp oldClpModel = (ESFFieldClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFFieldRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFFieldESFElectronic(
		BaseModel<?> oldModel) {
		ESFFieldESFElectronicClp oldClpModel = (ESFFieldESFElectronicClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFFieldESFElectronicRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFFieldESFSportType(
		BaseModel<?> oldModel) {
		ESFFieldESFSportTypeClp oldClpModel = (ESFFieldESFSportTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFFieldESFSportTypeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFForniture(BaseModel<?> oldModel) {
		ESFFornitureClp oldClpModel = (ESFFornitureClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFFornitureRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFFornitureRel(BaseModel<?> oldModel) {
		ESFFornitureRelClp oldClpModel = (ESFFornitureRelClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFFornitureRelRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFFornitureType(BaseModel<?> oldModel) {
		ESFFornitureTypeClp oldClpModel = (ESFFornitureTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFFornitureTypeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFFornitureUser(BaseModel<?> oldModel) {
		ESFFornitureUserClp oldClpModel = (ESFFornitureUserClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFFornitureUserRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFGun(BaseModel<?> oldModel) {
		ESFGunClp oldClpModel = (ESFGunClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFGunRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFGunKind(BaseModel<?> oldModel) {
		ESFGunKindClp oldClpModel = (ESFGunKindClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFGunKindRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFGunType(BaseModel<?> oldModel) {
		ESFGunTypeClp oldClpModel = (ESFGunTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFGunTypeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFgunUser(BaseModel<?> oldModel) {
		ESFgunUserClp oldClpModel = (ESFgunUserClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFgunUserRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFHistoricalAssociation(
		BaseModel<?> oldModel) {
		ESFHistoricalAssociationClp oldClpModel = (ESFHistoricalAssociationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFHistoricalAssociationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFInstructsShootingDirector(
		BaseModel<?> oldModel) {
		ESFInstructsShootingDirectorClp oldClpModel = (ESFInstructsShootingDirectorClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFInstructsShootingDirectorRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFJob(BaseModel<?> oldModel) {
		ESFJobClp oldClpModel = (ESFJobClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFJobRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFJuniores(BaseModel<?> oldModel) {
		ESFJunioresClp oldClpModel = (ESFJunioresClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFJunioresRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFLentField(BaseModel<?> oldModel) {
		ESFLentFieldClp oldClpModel = (ESFLentFieldClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFLentFieldRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFMatch(BaseModel<?> oldModel) {
		ESFMatchClp oldClpModel = (ESFMatchClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFMatchRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFMatchResult(BaseModel<?> oldModel) {
		ESFMatchResultClp oldClpModel = (ESFMatchResultClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFMatchResultRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFMatchType(BaseModel<?> oldModel) {
		ESFMatchTypeClp oldClpModel = (ESFMatchTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFMatchTypeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFNational(BaseModel<?> oldModel) {
		ESFNationalClp oldClpModel = (ESFNationalClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFNationalRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFNationalDelegation(
		BaseModel<?> oldModel) {
		ESFNationalDelegationClp oldClpModel = (ESFNationalDelegationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFNationalDelegationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFNationalMatchResult(
		BaseModel<?> oldModel) {
		ESFNationalMatchResultClp oldClpModel = (ESFNationalMatchResultClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFNationalMatchResultRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFOrganization(BaseModel<?> oldModel) {
		ESFOrganizationClp oldClpModel = (ESFOrganizationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFOrganizationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFOrganizationUnitservice(
		BaseModel<?> oldModel) {
		ESFOrganizationUnitserviceClp oldClpModel = (ESFOrganizationUnitserviceClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFOrganizationUnitserviceRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFPartecipant(BaseModel<?> oldModel) {
		ESFPartecipantClp oldClpModel = (ESFPartecipantClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFPartecipantRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFPartecipantInfo(BaseModel<?> oldModel) {
		ESFPartecipantInfoClp oldClpModel = (ESFPartecipantInfoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFPartecipantInfoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFPartecipantType(BaseModel<?> oldModel) {
		ESFPartecipantTypeClp oldClpModel = (ESFPartecipantTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFPartecipantTypeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFPhone(BaseModel<?> oldModel) {
		ESFPhoneClp oldClpModel = (ESFPhoneClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFPhoneRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFProvince(BaseModel<?> oldModel) {
		ESFProvinceClp oldClpModel = (ESFProvinceClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFProvinceRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFPublicAuthority(BaseModel<?> oldModel) {
		ESFPublicAuthorityClp oldClpModel = (ESFPublicAuthorityClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFPublicAuthorityRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFRegion(BaseModel<?> oldModel) {
		ESFRegionClp oldClpModel = (ESFRegionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFRegionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFRenewal(BaseModel<?> oldModel) {
		ESFRenewalClp oldClpModel = (ESFRenewalClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFRenewalRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFResult(BaseModel<?> oldModel) {
		ESFResultClp oldClpModel = (ESFResultClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFResultRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFShooterAffiliationChrono(
		BaseModel<?> oldModel) {
		ESFShooterAffiliationChronoClp oldClpModel = (ESFShooterAffiliationChronoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFShooterAffiliationChronoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFShooterCategory(BaseModel<?> oldModel) {
		ESFShooterCategoryClp oldClpModel = (ESFShooterCategoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFShooterCategoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFShooterCategoryESFMatch(
		BaseModel<?> oldModel) {
		ESFShooterCategoryESFMatchClp oldClpModel = (ESFShooterCategoryESFMatchClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFShooterCategoryESFMatchRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFShooterCategoryESFTournament(
		BaseModel<?> oldModel) {
		ESFShooterCategoryESFTournamentClp oldClpModel = (ESFShooterCategoryESFTournamentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFShooterCategoryESFTournamentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFShooterQualification(
		BaseModel<?> oldModel) {
		ESFShooterQualificationClp oldClpModel = (ESFShooterQualificationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFShooterQualificationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFShooterQualificationESFMatch(
		BaseModel<?> oldModel) {
		ESFShooterQualificationESFMatchClp oldClpModel = (ESFShooterQualificationESFMatchClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFShooterQualificationESFMatchRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFShooterQualificationESFTournament(
		BaseModel<?> oldModel) {
		ESFShooterQualificationESFTournamentClp oldClpModel = (ESFShooterQualificationESFTournamentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFShooterQualificationESFTournamentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFShootingDirector(
		BaseModel<?> oldModel) {
		ESFShootingDirectorClp oldClpModel = (ESFShootingDirectorClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFShootingDirectorRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFShootingDirectorQualification(
		BaseModel<?> oldModel) {
		ESFShootingDirectorQualificationClp oldClpModel = (ESFShootingDirectorQualificationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFShootingDirectorQualificationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFSpecific(BaseModel<?> oldModel) {
		ESFSpecificClp oldClpModel = (ESFSpecificClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFSpecificRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFSportType(BaseModel<?> oldModel) {
		ESFSportTypeClp oldClpModel = (ESFSportTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFSportTypeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFState(BaseModel<?> oldModel) {
		ESFStateClp oldClpModel = (ESFStateClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFStateRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFStateAssEntity(BaseModel<?> oldModel) {
		ESFStateAssEntityClp oldClpModel = (ESFStateAssEntityClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFStateAssEntityRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFSuspensiveCode(BaseModel<?> oldModel) {
		ESFSuspensiveCodeClp oldClpModel = (ESFSuspensiveCodeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFSuspensiveCodeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFSuspensiveShootingDirector(
		BaseModel<?> oldModel) {
		ESFSuspensiveShootingDirectorClp oldClpModel = (ESFSuspensiveShootingDirectorClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFSuspensiveShootingDirectorRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFTeam(BaseModel<?> oldModel) {
		ESFTeamClp oldClpModel = (ESFTeamClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFTeamRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFTournament(BaseModel<?> oldModel) {
		ESFTournamentClp oldClpModel = (ESFTournamentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFTournamentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFTransition(BaseModel<?> oldModel) {
		ESFTransitionClp oldClpModel = (ESFTransitionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFTransitionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFUnitservice(BaseModel<?> oldModel) {
		ESFUnitserviceClp oldClpModel = (ESFUnitserviceClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFUnitserviceRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFUser(BaseModel<?> oldModel) {
		ESFUserClp oldClpModel = (ESFUserClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFUserRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFUserCategory(BaseModel<?> oldModel) {
		ESFUserCategoryClp oldClpModel = (ESFUserCategoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFUserCategoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFUserESFFederalRole(
		BaseModel<?> oldModel) {
		ESFUserESFFederalRoleClp oldClpModel = (ESFUserESFFederalRoleClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFUserESFFederalRoleRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFUserESFUserRole(BaseModel<?> oldModel) {
		ESFUserESFUserRoleClp oldClpModel = (ESFUserESFUserRoleClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFUserESFUserRoleRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputESFUserRole(BaseModel<?> oldModel) {
		ESFUserRoleClp oldClpModel = (ESFUserRoleClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getESFUserRoleRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals("it.ethica.esf.model.impl.ESFAddressImpl")) {
			return translateOutputESFAddress(oldModel);
		}

		if (oldModelClassName.equals("it.ethica.esf.model.impl.ESFAirportImpl")) {
			return translateOutputESFAirport(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFAnnualConiReportImpl")) {
			return translateOutputESFAnnualConiReport(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFAnnualFreeCardImpl")) {
			return translateOutputESFAnnualFreeCard(oldModel);
		}

		if (oldModelClassName.equals("it.ethica.esf.model.impl.ESFBrandImpl")) {
			return translateOutputESFBrand(oldModel);
		}

		if (oldModelClassName.equals("it.ethica.esf.model.impl.ESFCaneImpl")) {
			return translateOutputESFCane(oldModel);
		}

		if (oldModelClassName.equals("it.ethica.esf.model.impl.ESFCardImpl")) {
			return translateOutputESFCard(oldModel);
		}

		if (oldModelClassName.equals("it.ethica.esf.model.impl.ESFCategoryImpl")) {
			return translateOutputESFCategory(oldModel);
		}

		if (oldModelClassName.equals("it.ethica.esf.model.impl.ESFCatridgeImpl")) {
			return translateOutputESFCatridge(oldModel);
		}

		if (oldModelClassName.equals("it.ethica.esf.model.impl.ESFCityImpl")) {
			return translateOutputESFCity(oldModel);
		}

		if (oldModelClassName.equals("it.ethica.esf.model.impl.ESFCodeOrgImpl")) {
			return translateOutputESFCodeOrg(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFConfigurationImpl")) {
			return translateOutputESFConfiguration(oldModel);
		}

		if (oldModelClassName.equals("it.ethica.esf.model.impl.ESFCountryImpl")) {
			return translateOutputESFCountry(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFDepartureImpl")) {
			return translateOutputESFDeparture(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFDescriptionImpl")) {
			return translateOutputESFDescription(oldModel);
		}

		if (oldModelClassName.equals("it.ethica.esf.model.impl.ESFDocumentImpl")) {
			return translateOutputESFDocument(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFDocumentTypeImpl")) {
			return translateOutputESFDocumentType(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFElectronicImpl")) {
			return translateOutputESFElectronic(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFEntityStateImpl")) {
			return translateOutputESFEntityState(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFEventTypeImpl")) {
			return translateOutputESFEventType(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFFederalRoleImpl")) {
			return translateOutputESFFederalRole(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFFederalRoleESFSpecificImpl")) {
			return translateOutputESFFederalRoleESFSpecific(oldModel);
		}

		if (oldModelClassName.equals("it.ethica.esf.model.impl.ESFFieldImpl")) {
			return translateOutputESFField(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFFieldESFElectronicImpl")) {
			return translateOutputESFFieldESFElectronic(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFFieldESFSportTypeImpl")) {
			return translateOutputESFFieldESFSportType(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFFornitureImpl")) {
			return translateOutputESFForniture(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFFornitureRelImpl")) {
			return translateOutputESFFornitureRel(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFFornitureTypeImpl")) {
			return translateOutputESFFornitureType(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFFornitureUserImpl")) {
			return translateOutputESFFornitureUser(oldModel);
		}

		if (oldModelClassName.equals("it.ethica.esf.model.impl.ESFGunImpl")) {
			return translateOutputESFGun(oldModel);
		}

		if (oldModelClassName.equals("it.ethica.esf.model.impl.ESFGunKindImpl")) {
			return translateOutputESFGunKind(oldModel);
		}

		if (oldModelClassName.equals("it.ethica.esf.model.impl.ESFGunTypeImpl")) {
			return translateOutputESFGunType(oldModel);
		}

		if (oldModelClassName.equals("it.ethica.esf.model.impl.ESFgunUserImpl")) {
			return translateOutputESFgunUser(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFHistoricalAssociationImpl")) {
			return translateOutputESFHistoricalAssociation(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFInstructsShootingDirectorImpl")) {
			return translateOutputESFInstructsShootingDirector(oldModel);
		}

		if (oldModelClassName.equals("it.ethica.esf.model.impl.ESFJobImpl")) {
			return translateOutputESFJob(oldModel);
		}

		if (oldModelClassName.equals("it.ethica.esf.model.impl.ESFJunioresImpl")) {
			return translateOutputESFJuniores(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFLentFieldImpl")) {
			return translateOutputESFLentField(oldModel);
		}

		if (oldModelClassName.equals("it.ethica.esf.model.impl.ESFMatchImpl")) {
			return translateOutputESFMatch(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFMatchResultImpl")) {
			return translateOutputESFMatchResult(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFMatchTypeImpl")) {
			return translateOutputESFMatchType(oldModel);
		}

		if (oldModelClassName.equals("it.ethica.esf.model.impl.ESFNationalImpl")) {
			return translateOutputESFNational(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFNationalDelegationImpl")) {
			return translateOutputESFNationalDelegation(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFNationalMatchResultImpl")) {
			return translateOutputESFNationalMatchResult(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFOrganizationImpl")) {
			return translateOutputESFOrganization(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFOrganizationUnitserviceImpl")) {
			return translateOutputESFOrganizationUnitservice(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFPartecipantImpl")) {
			return translateOutputESFPartecipant(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFPartecipantInfoImpl")) {
			return translateOutputESFPartecipantInfo(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFPartecipantTypeImpl")) {
			return translateOutputESFPartecipantType(oldModel);
		}

		if (oldModelClassName.equals("it.ethica.esf.model.impl.ESFPhoneImpl")) {
			return translateOutputESFPhone(oldModel);
		}

		if (oldModelClassName.equals("it.ethica.esf.model.impl.ESFProvinceImpl")) {
			return translateOutputESFProvince(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFPublicAuthorityImpl")) {
			return translateOutputESFPublicAuthority(oldModel);
		}

		if (oldModelClassName.equals("it.ethica.esf.model.impl.ESFRegionImpl")) {
			return translateOutputESFRegion(oldModel);
		}

		if (oldModelClassName.equals("it.ethica.esf.model.impl.ESFRenewalImpl")) {
			return translateOutputESFRenewal(oldModel);
		}

		if (oldModelClassName.equals("it.ethica.esf.model.impl.ESFResultImpl")) {
			return translateOutputESFResult(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFShooterAffiliationChronoImpl")) {
			return translateOutputESFShooterAffiliationChrono(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFShooterCategoryImpl")) {
			return translateOutputESFShooterCategory(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFShooterCategoryESFMatchImpl")) {
			return translateOutputESFShooterCategoryESFMatch(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFShooterCategoryESFTournamentImpl")) {
			return translateOutputESFShooterCategoryESFTournament(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFShooterQualificationImpl")) {
			return translateOutputESFShooterQualification(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFShooterQualificationESFMatchImpl")) {
			return translateOutputESFShooterQualificationESFMatch(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFShooterQualificationESFTournamentImpl")) {
			return translateOutputESFShooterQualificationESFTournament(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFShootingDirectorImpl")) {
			return translateOutputESFShootingDirector(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFShootingDirectorQualificationImpl")) {
			return translateOutputESFShootingDirectorQualification(oldModel);
		}

		if (oldModelClassName.equals("it.ethica.esf.model.impl.ESFSpecificImpl")) {
			return translateOutputESFSpecific(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFSportTypeImpl")) {
			return translateOutputESFSportType(oldModel);
		}

		if (oldModelClassName.equals("it.ethica.esf.model.impl.ESFStateImpl")) {
			return translateOutputESFState(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFStateAssEntityImpl")) {
			return translateOutputESFStateAssEntity(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFSuspensiveCodeImpl")) {
			return translateOutputESFSuspensiveCode(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFSuspensiveShootingDirectorImpl")) {
			return translateOutputESFSuspensiveShootingDirector(oldModel);
		}

		if (oldModelClassName.equals("it.ethica.esf.model.impl.ESFTeamImpl")) {
			return translateOutputESFTeam(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFTournamentImpl")) {
			return translateOutputESFTournament(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFTransitionImpl")) {
			return translateOutputESFTransition(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFUnitserviceImpl")) {
			return translateOutputESFUnitservice(oldModel);
		}

		if (oldModelClassName.equals("it.ethica.esf.model.impl.ESFUserImpl")) {
			return translateOutputESFUser(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFUserCategoryImpl")) {
			return translateOutputESFUserCategory(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFUserESFFederalRoleImpl")) {
			return translateOutputESFUserESFFederalRole(oldModel);
		}

		if (oldModelClassName.equals(
					"it.ethica.esf.model.impl.ESFUserESFUserRoleImpl")) {
			return translateOutputESFUserESFUserRole(oldModel);
		}

		if (oldModelClassName.equals("it.ethica.esf.model.impl.ESFUserRoleImpl")) {
			return translateOutputESFUserRole(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals("it.ethica.esf.ESFAddressLatitudeException")) {
			return new it.ethica.esf.ESFAddressLatitudeException();
		}

		if (className.equals("it.ethica.esf.ESFAddressLongitudeException")) {
			return new it.ethica.esf.ESFAddressLongitudeException();
		}

		if (className.equals("it.ethica.esf.ESFCardCodeException")) {
			return new it.ethica.esf.ESFCardCodeException();
		}

		if (className.equals("it.ethica.esf.ESFFieldNameException")) {
			return new it.ethica.esf.ESFFieldNameException();
		}

		if (className.equals("it.ethica.esf.ESFFornitureNameException")) {
			return new it.ethica.esf.ESFFornitureNameException();
		}

		if (className.equals("it.ethica.esf.ESFGunKindNameException")) {
			return new it.ethica.esf.ESFGunKindNameException();
		}

		if (className.equals("it.ethica.esf.ESFGunNameException")) {
			return new it.ethica.esf.ESFGunNameException();
		}

		if (className.equals("it.ethica.esf.ESFGunTypeNameException")) {
			return new it.ethica.esf.ESFGunTypeNameException();
		}

		if (className.equals("it.ethica.esf.ESFOrganizationNameException")) {
			return new it.ethica.esf.ESFOrganizationNameException();
		}

		if (className.equals("it.ethica.esf.ESFOrganizationTypeException")) {
			return new it.ethica.esf.ESFOrganizationTypeException();
		}

		if (className.equals("it.ethica.esf.ESFSportTypeNameException")) {
			return new it.ethica.esf.ESFSportTypeNameException();
		}

		if (className.equals("it.ethica.esf.ESFUserNameException")) {
			return new it.ethica.esf.ESFUserNameException();
		}

		if (className.equals("it.ethica.esf.ESFUserPortalUserException")) {
			return new it.ethica.esf.ESFUserPortalUserException();
		}

		if (className.equals("it.ethica.esf.ESFUserRoleNameException")) {
			return new it.ethica.esf.ESFUserRoleNameException();
		}

		if (className.equals("it.ethica.esf.ESFUserRoleTypeException")) {
			return new it.ethica.esf.ESFUserRoleTypeException();
		}

		if (className.equals("it.ethica.esf.NoSuchAddressException")) {
			return new it.ethica.esf.NoSuchAddressException();
		}

		if (className.equals("it.ethica.esf.NoSuchAirportException")) {
			return new it.ethica.esf.NoSuchAirportException();
		}

		if (className.equals("it.ethica.esf.NoSuchAnnualConiReportException")) {
			return new it.ethica.esf.NoSuchAnnualConiReportException();
		}

		if (className.equals("it.ethica.esf.NoSuchAnnualFreeCardException")) {
			return new it.ethica.esf.NoSuchAnnualFreeCardException();
		}

		if (className.equals("it.ethica.esf.NoSuchBrandException")) {
			return new it.ethica.esf.NoSuchBrandException();
		}

		if (className.equals("it.ethica.esf.NoSuchCaneException")) {
			return new it.ethica.esf.NoSuchCaneException();
		}

		if (className.equals("it.ethica.esf.NoSuchCardException")) {
			return new it.ethica.esf.NoSuchCardException();
		}

		if (className.equals("it.ethica.esf.NoSuchCategoryException")) {
			return new it.ethica.esf.NoSuchCategoryException();
		}

		if (className.equals("it.ethica.esf.NoSuchCatridgeException")) {
			return new it.ethica.esf.NoSuchCatridgeException();
		}

		if (className.equals("it.ethica.esf.NoSuchCityException")) {
			return new it.ethica.esf.NoSuchCityException();
		}

		if (className.equals("it.ethica.esf.NoSuchCodeOrgException")) {
			return new it.ethica.esf.NoSuchCodeOrgException();
		}

		if (className.equals("it.ethica.esf.NoSuchConfigurationException")) {
			return new it.ethica.esf.NoSuchConfigurationException();
		}

		if (className.equals("it.ethica.esf.NoSuchCountryException")) {
			return new it.ethica.esf.NoSuchCountryException();
		}

		if (className.equals("it.ethica.esf.NoSuchDepartureException")) {
			return new it.ethica.esf.NoSuchDepartureException();
		}

		if (className.equals("it.ethica.esf.NoSuchDescriptionException")) {
			return new it.ethica.esf.NoSuchDescriptionException();
		}

		if (className.equals("it.ethica.esf.NoSuchDocumentException")) {
			return new it.ethica.esf.NoSuchDocumentException();
		}

		if (className.equals("it.ethica.esf.NoSuchDocumentTypeException")) {
			return new it.ethica.esf.NoSuchDocumentTypeException();
		}

		if (className.equals("it.ethica.esf.NoSuchElectronicException")) {
			return new it.ethica.esf.NoSuchElectronicException();
		}

		if (className.equals("it.ethica.esf.NoSuchEntityStateException")) {
			return new it.ethica.esf.NoSuchEntityStateException();
		}

		if (className.equals("it.ethica.esf.NoSuchEventTypeException")) {
			return new it.ethica.esf.NoSuchEventTypeException();
		}

		if (className.equals("it.ethica.esf.NoSuchFederalRoleException")) {
			return new it.ethica.esf.NoSuchFederalRoleException();
		}

		if (className.equals(
					"it.ethica.esf.NoSuchFederalRoleESFSpecificException")) {
			return new it.ethica.esf.NoSuchFederalRoleESFSpecificException();
		}

		if (className.equals("it.ethica.esf.NoSuchFieldException")) {
			return new it.ethica.esf.NoSuchFieldException();
		}

		if (className.equals("it.ethica.esf.NoSuchFieldESFElectronicException")) {
			return new it.ethica.esf.NoSuchFieldESFElectronicException();
		}

		if (className.equals("it.ethica.esf.NoSuchFieldESFSportTypeException")) {
			return new it.ethica.esf.NoSuchFieldESFSportTypeException();
		}

		if (className.equals("it.ethica.esf.NoSuchFornitureException")) {
			return new it.ethica.esf.NoSuchFornitureException();
		}

		if (className.equals("it.ethica.esf.NoSuchFornitureRelException")) {
			return new it.ethica.esf.NoSuchFornitureRelException();
		}

		if (className.equals("it.ethica.esf.NoSuchFornitureTypeException")) {
			return new it.ethica.esf.NoSuchFornitureTypeException();
		}

		if (className.equals("it.ethica.esf.NoSuchFornitureUserException")) {
			return new it.ethica.esf.NoSuchFornitureUserException();
		}

		if (className.equals("it.ethica.esf.NoSuchGunException")) {
			return new it.ethica.esf.NoSuchGunException();
		}

		if (className.equals("it.ethica.esf.NoSuchGunKindException")) {
			return new it.ethica.esf.NoSuchGunKindException();
		}

		if (className.equals("it.ethica.esf.NoSuchGunTypeException")) {
			return new it.ethica.esf.NoSuchGunTypeException();
		}

		if (className.equals("it.ethica.esf.NoSuchgunUserException")) {
			return new it.ethica.esf.NoSuchgunUserException();
		}

		if (className.equals(
					"it.ethica.esf.NoSuchHistoricalAssociationException")) {
			return new it.ethica.esf.NoSuchHistoricalAssociationException();
		}

		if (className.equals(
					"it.ethica.esf.NoSuchInstructsShootingDirectorException")) {
			return new it.ethica.esf.NoSuchInstructsShootingDirectorException();
		}

		if (className.equals("it.ethica.esf.NoSuchJobException")) {
			return new it.ethica.esf.NoSuchJobException();
		}

		if (className.equals("it.ethica.esf.NoSuchJunioresException")) {
			return new it.ethica.esf.NoSuchJunioresException();
		}

		if (className.equals("it.ethica.esf.NoSuchLentFieldException")) {
			return new it.ethica.esf.NoSuchLentFieldException();
		}

		if (className.equals("it.ethica.esf.NoSuchMatchException")) {
			return new it.ethica.esf.NoSuchMatchException();
		}

		if (className.equals("it.ethica.esf.NoSuchMatchResultException")) {
			return new it.ethica.esf.NoSuchMatchResultException();
		}

		if (className.equals("it.ethica.esf.NoSuchMatchTypeException")) {
			return new it.ethica.esf.NoSuchMatchTypeException();
		}

		if (className.equals("it.ethica.esf.NoSuchNationalException")) {
			return new it.ethica.esf.NoSuchNationalException();
		}

		if (className.equals("it.ethica.esf.NoSuchNationalDelegationException")) {
			return new it.ethica.esf.NoSuchNationalDelegationException();
		}

		if (className.equals("it.ethica.esf.NoSuchNationalMatchResultException")) {
			return new it.ethica.esf.NoSuchNationalMatchResultException();
		}

		if (className.equals("it.ethica.esf.NoSuchOrganizationException")) {
			return new it.ethica.esf.NoSuchOrganizationException();
		}

		if (className.equals(
					"it.ethica.esf.NoSuchOrganizationUnitserviceException")) {
			return new it.ethica.esf.NoSuchOrganizationUnitserviceException();
		}

		if (className.equals("it.ethica.esf.NoSuchPartecipantException")) {
			return new it.ethica.esf.NoSuchPartecipantException();
		}

		if (className.equals("it.ethica.esf.NoSuchPartecipantInfoException")) {
			return new it.ethica.esf.NoSuchPartecipantInfoException();
		}

		if (className.equals("it.ethica.esf.NoSuchPartecipantTypeException")) {
			return new it.ethica.esf.NoSuchPartecipantTypeException();
		}

		if (className.equals("it.ethica.esf.NoSuchPhoneException")) {
			return new it.ethica.esf.NoSuchPhoneException();
		}

		if (className.equals("it.ethica.esf.NoSuchProvinceException")) {
			return new it.ethica.esf.NoSuchProvinceException();
		}

		if (className.equals("it.ethica.esf.NoSuchPublicAuthorityException")) {
			return new it.ethica.esf.NoSuchPublicAuthorityException();
		}

		if (className.equals("it.ethica.esf.NoSuchRegionException")) {
			return new it.ethica.esf.NoSuchRegionException();
		}

		if (className.equals("it.ethica.esf.NoSuchRenewalException")) {
			return new it.ethica.esf.NoSuchRenewalException();
		}

		if (className.equals("it.ethica.esf.NoSuchResultException")) {
			return new it.ethica.esf.NoSuchResultException();
		}

		if (className.equals(
					"it.ethica.esf.NoSuchShooterAffiliationChronoException")) {
			return new it.ethica.esf.NoSuchShooterAffiliationChronoException();
		}

		if (className.equals("it.ethica.esf.NoSuchShooterCategoryException")) {
			return new it.ethica.esf.NoSuchShooterCategoryException();
		}

		if (className.equals(
					"it.ethica.esf.NoSuchShooterCategoryESFMatchException")) {
			return new it.ethica.esf.NoSuchShooterCategoryESFMatchException();
		}

		if (className.equals(
					"it.ethica.esf.NoSuchShooterCategoryESFTournamentException")) {
			return new it.ethica.esf.NoSuchShooterCategoryESFTournamentException();
		}

		if (className.equals(
					"it.ethica.esf.NoSuchShooterQualificationException")) {
			return new it.ethica.esf.NoSuchShooterQualificationException();
		}

		if (className.equals(
					"it.ethica.esf.NoSuchShooterQualificationESFMatchException")) {
			return new it.ethica.esf.NoSuchShooterQualificationESFMatchException();
		}

		if (className.equals(
					"it.ethica.esf.NoSuchShooterQualificationESFTournamentException")) {
			return new it.ethica.esf.NoSuchShooterQualificationESFTournamentException();
		}

		if (className.equals("it.ethica.esf.NoSuchShootingDirectorException")) {
			return new it.ethica.esf.NoSuchShootingDirectorException();
		}

		if (className.equals(
					"it.ethica.esf.NoSuchShootingDirectorQualificationException")) {
			return new it.ethica.esf.NoSuchShootingDirectorQualificationException();
		}

		if (className.equals("it.ethica.esf.NoSuchSpecificException")) {
			return new it.ethica.esf.NoSuchSpecificException();
		}

		if (className.equals("it.ethica.esf.NoSuchSportTypeException")) {
			return new it.ethica.esf.NoSuchSportTypeException();
		}

		if (className.equals("it.ethica.esf.NoSuchStateException")) {
			return new it.ethica.esf.NoSuchStateException();
		}

		if (className.equals("it.ethica.esf.NoSuchStateAssEntityException")) {
			return new it.ethica.esf.NoSuchStateAssEntityException();
		}

		if (className.equals("it.ethica.esf.NoSuchSuspensiveCodeException")) {
			return new it.ethica.esf.NoSuchSuspensiveCodeException();
		}

		if (className.equals(
					"it.ethica.esf.NoSuchSuspensiveShootingDirectorException")) {
			return new it.ethica.esf.NoSuchSuspensiveShootingDirectorException();
		}

		if (className.equals("it.ethica.esf.NoSuchTeamException")) {
			return new it.ethica.esf.NoSuchTeamException();
		}

		if (className.equals("it.ethica.esf.NoSuchTournamentException")) {
			return new it.ethica.esf.NoSuchTournamentException();
		}

		if (className.equals("it.ethica.esf.NoSuchTransitionException")) {
			return new it.ethica.esf.NoSuchTransitionException();
		}

		if (className.equals("it.ethica.esf.NoSuchUnitserviceException")) {
			return new it.ethica.esf.NoSuchUnitserviceException();
		}

		if (className.equals("it.ethica.esf.NoSuchUserException")) {
			return new it.ethica.esf.NoSuchUserException();
		}

		if (className.equals("it.ethica.esf.NoSuchUserCategoryException")) {
			return new it.ethica.esf.NoSuchUserCategoryException();
		}

		if (className.equals("it.ethica.esf.NoSuchUserESFFederalRoleException")) {
			return new it.ethica.esf.NoSuchUserESFFederalRoleException();
		}

		if (className.equals("it.ethica.esf.NoSuchUserESFUserRoleException")) {
			return new it.ethica.esf.NoSuchUserESFUserRoleException();
		}

		if (className.equals("it.ethica.esf.NoSuchUserRoleException")) {
			return new it.ethica.esf.NoSuchUserRoleException();
		}

		return throwable;
	}

	public static Object translateOutputESFAddress(BaseModel<?> oldModel) {
		ESFAddressClp newModel = new ESFAddressClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFAddressRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFAirport(BaseModel<?> oldModel) {
		ESFAirportClp newModel = new ESFAirportClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFAirportRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFAnnualConiReport(
		BaseModel<?> oldModel) {
		ESFAnnualConiReportClp newModel = new ESFAnnualConiReportClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFAnnualConiReportRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFAnnualFreeCard(BaseModel<?> oldModel) {
		ESFAnnualFreeCardClp newModel = new ESFAnnualFreeCardClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFAnnualFreeCardRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFBrand(BaseModel<?> oldModel) {
		ESFBrandClp newModel = new ESFBrandClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFBrandRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFCane(BaseModel<?> oldModel) {
		ESFCaneClp newModel = new ESFCaneClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFCaneRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFCard(BaseModel<?> oldModel) {
		ESFCardClp newModel = new ESFCardClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFCardRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFCategory(BaseModel<?> oldModel) {
		ESFCategoryClp newModel = new ESFCategoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFCategoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFCatridge(BaseModel<?> oldModel) {
		ESFCatridgeClp newModel = new ESFCatridgeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFCatridgeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFCity(BaseModel<?> oldModel) {
		ESFCityClp newModel = new ESFCityClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFCityRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFCodeOrg(BaseModel<?> oldModel) {
		ESFCodeOrgClp newModel = new ESFCodeOrgClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFCodeOrgRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFConfiguration(BaseModel<?> oldModel) {
		ESFConfigurationClp newModel = new ESFConfigurationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFConfigurationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFCountry(BaseModel<?> oldModel) {
		ESFCountryClp newModel = new ESFCountryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFCountryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFDeparture(BaseModel<?> oldModel) {
		ESFDepartureClp newModel = new ESFDepartureClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFDepartureRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFDescription(BaseModel<?> oldModel) {
		ESFDescriptionClp newModel = new ESFDescriptionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFDescriptionRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFDocument(BaseModel<?> oldModel) {
		ESFDocumentClp newModel = new ESFDocumentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFDocumentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFDocumentType(BaseModel<?> oldModel) {
		ESFDocumentTypeClp newModel = new ESFDocumentTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFDocumentTypeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFElectronic(BaseModel<?> oldModel) {
		ESFElectronicClp newModel = new ESFElectronicClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFElectronicRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFEntityState(BaseModel<?> oldModel) {
		ESFEntityStateClp newModel = new ESFEntityStateClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFEntityStateRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFEventType(BaseModel<?> oldModel) {
		ESFEventTypeClp newModel = new ESFEventTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFEventTypeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFFederalRole(BaseModel<?> oldModel) {
		ESFFederalRoleClp newModel = new ESFFederalRoleClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFFederalRoleRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFFederalRoleESFSpecific(
		BaseModel<?> oldModel) {
		ESFFederalRoleESFSpecificClp newModel = new ESFFederalRoleESFSpecificClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFFederalRoleESFSpecificRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFField(BaseModel<?> oldModel) {
		ESFFieldClp newModel = new ESFFieldClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFFieldRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFFieldESFElectronic(
		BaseModel<?> oldModel) {
		ESFFieldESFElectronicClp newModel = new ESFFieldESFElectronicClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFFieldESFElectronicRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFFieldESFSportType(
		BaseModel<?> oldModel) {
		ESFFieldESFSportTypeClp newModel = new ESFFieldESFSportTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFFieldESFSportTypeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFForniture(BaseModel<?> oldModel) {
		ESFFornitureClp newModel = new ESFFornitureClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFFornitureRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFFornitureRel(BaseModel<?> oldModel) {
		ESFFornitureRelClp newModel = new ESFFornitureRelClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFFornitureRelRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFFornitureType(BaseModel<?> oldModel) {
		ESFFornitureTypeClp newModel = new ESFFornitureTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFFornitureTypeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFFornitureUser(BaseModel<?> oldModel) {
		ESFFornitureUserClp newModel = new ESFFornitureUserClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFFornitureUserRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFGun(BaseModel<?> oldModel) {
		ESFGunClp newModel = new ESFGunClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFGunRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFGunKind(BaseModel<?> oldModel) {
		ESFGunKindClp newModel = new ESFGunKindClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFGunKindRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFGunType(BaseModel<?> oldModel) {
		ESFGunTypeClp newModel = new ESFGunTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFGunTypeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFgunUser(BaseModel<?> oldModel) {
		ESFgunUserClp newModel = new ESFgunUserClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFgunUserRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFHistoricalAssociation(
		BaseModel<?> oldModel) {
		ESFHistoricalAssociationClp newModel = new ESFHistoricalAssociationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFHistoricalAssociationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFInstructsShootingDirector(
		BaseModel<?> oldModel) {
		ESFInstructsShootingDirectorClp newModel = new ESFInstructsShootingDirectorClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFInstructsShootingDirectorRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFJob(BaseModel<?> oldModel) {
		ESFJobClp newModel = new ESFJobClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFJobRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFJuniores(BaseModel<?> oldModel) {
		ESFJunioresClp newModel = new ESFJunioresClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFJunioresRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFLentField(BaseModel<?> oldModel) {
		ESFLentFieldClp newModel = new ESFLentFieldClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFLentFieldRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFMatch(BaseModel<?> oldModel) {
		ESFMatchClp newModel = new ESFMatchClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFMatchRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFMatchResult(BaseModel<?> oldModel) {
		ESFMatchResultClp newModel = new ESFMatchResultClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFMatchResultRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFMatchType(BaseModel<?> oldModel) {
		ESFMatchTypeClp newModel = new ESFMatchTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFMatchTypeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFNational(BaseModel<?> oldModel) {
		ESFNationalClp newModel = new ESFNationalClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFNationalRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFNationalDelegation(
		BaseModel<?> oldModel) {
		ESFNationalDelegationClp newModel = new ESFNationalDelegationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFNationalDelegationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFNationalMatchResult(
		BaseModel<?> oldModel) {
		ESFNationalMatchResultClp newModel = new ESFNationalMatchResultClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFNationalMatchResultRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFOrganization(BaseModel<?> oldModel) {
		ESFOrganizationClp newModel = new ESFOrganizationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFOrganizationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFOrganizationUnitservice(
		BaseModel<?> oldModel) {
		ESFOrganizationUnitserviceClp newModel = new ESFOrganizationUnitserviceClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFOrganizationUnitserviceRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFPartecipant(BaseModel<?> oldModel) {
		ESFPartecipantClp newModel = new ESFPartecipantClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFPartecipantRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFPartecipantInfo(
		BaseModel<?> oldModel) {
		ESFPartecipantInfoClp newModel = new ESFPartecipantInfoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFPartecipantInfoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFPartecipantType(
		BaseModel<?> oldModel) {
		ESFPartecipantTypeClp newModel = new ESFPartecipantTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFPartecipantTypeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFPhone(BaseModel<?> oldModel) {
		ESFPhoneClp newModel = new ESFPhoneClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFPhoneRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFProvince(BaseModel<?> oldModel) {
		ESFProvinceClp newModel = new ESFProvinceClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFProvinceRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFPublicAuthority(
		BaseModel<?> oldModel) {
		ESFPublicAuthorityClp newModel = new ESFPublicAuthorityClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFPublicAuthorityRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFRegion(BaseModel<?> oldModel) {
		ESFRegionClp newModel = new ESFRegionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFRegionRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFRenewal(BaseModel<?> oldModel) {
		ESFRenewalClp newModel = new ESFRenewalClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFRenewalRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFResult(BaseModel<?> oldModel) {
		ESFResultClp newModel = new ESFResultClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFResultRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFShooterAffiliationChrono(
		BaseModel<?> oldModel) {
		ESFShooterAffiliationChronoClp newModel = new ESFShooterAffiliationChronoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFShooterAffiliationChronoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFShooterCategory(
		BaseModel<?> oldModel) {
		ESFShooterCategoryClp newModel = new ESFShooterCategoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFShooterCategoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFShooterCategoryESFMatch(
		BaseModel<?> oldModel) {
		ESFShooterCategoryESFMatchClp newModel = new ESFShooterCategoryESFMatchClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFShooterCategoryESFMatchRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFShooterCategoryESFTournament(
		BaseModel<?> oldModel) {
		ESFShooterCategoryESFTournamentClp newModel = new ESFShooterCategoryESFTournamentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFShooterCategoryESFTournamentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFShooterQualification(
		BaseModel<?> oldModel) {
		ESFShooterQualificationClp newModel = new ESFShooterQualificationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFShooterQualificationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFShooterQualificationESFMatch(
		BaseModel<?> oldModel) {
		ESFShooterQualificationESFMatchClp newModel = new ESFShooterQualificationESFMatchClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFShooterQualificationESFMatchRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFShooterQualificationESFTournament(
		BaseModel<?> oldModel) {
		ESFShooterQualificationESFTournamentClp newModel = new ESFShooterQualificationESFTournamentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFShooterQualificationESFTournamentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFShootingDirector(
		BaseModel<?> oldModel) {
		ESFShootingDirectorClp newModel = new ESFShootingDirectorClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFShootingDirectorRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFShootingDirectorQualification(
		BaseModel<?> oldModel) {
		ESFShootingDirectorQualificationClp newModel = new ESFShootingDirectorQualificationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFShootingDirectorQualificationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFSpecific(BaseModel<?> oldModel) {
		ESFSpecificClp newModel = new ESFSpecificClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFSpecificRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFSportType(BaseModel<?> oldModel) {
		ESFSportTypeClp newModel = new ESFSportTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFSportTypeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFState(BaseModel<?> oldModel) {
		ESFStateClp newModel = new ESFStateClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFStateRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFStateAssEntity(BaseModel<?> oldModel) {
		ESFStateAssEntityClp newModel = new ESFStateAssEntityClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFStateAssEntityRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFSuspensiveCode(BaseModel<?> oldModel) {
		ESFSuspensiveCodeClp newModel = new ESFSuspensiveCodeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFSuspensiveCodeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFSuspensiveShootingDirector(
		BaseModel<?> oldModel) {
		ESFSuspensiveShootingDirectorClp newModel = new ESFSuspensiveShootingDirectorClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFSuspensiveShootingDirectorRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFTeam(BaseModel<?> oldModel) {
		ESFTeamClp newModel = new ESFTeamClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFTeamRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFTournament(BaseModel<?> oldModel) {
		ESFTournamentClp newModel = new ESFTournamentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFTournamentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFTransition(BaseModel<?> oldModel) {
		ESFTransitionClp newModel = new ESFTransitionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFTransitionRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFUnitservice(BaseModel<?> oldModel) {
		ESFUnitserviceClp newModel = new ESFUnitserviceClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFUnitserviceRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFUser(BaseModel<?> oldModel) {
		ESFUserClp newModel = new ESFUserClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFUserRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFUserCategory(BaseModel<?> oldModel) {
		ESFUserCategoryClp newModel = new ESFUserCategoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFUserCategoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFUserESFFederalRole(
		BaseModel<?> oldModel) {
		ESFUserESFFederalRoleClp newModel = new ESFUserESFFederalRoleClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFUserESFFederalRoleRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFUserESFUserRole(
		BaseModel<?> oldModel) {
		ESFUserESFUserRoleClp newModel = new ESFUserESFUserRoleClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFUserESFUserRoleRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputESFUserRole(BaseModel<?> oldModel) {
		ESFUserRoleClp newModel = new ESFUserRoleClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setESFUserRoleRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}