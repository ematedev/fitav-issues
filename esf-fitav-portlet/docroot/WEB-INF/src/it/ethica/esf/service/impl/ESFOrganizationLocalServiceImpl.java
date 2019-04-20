/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package it.ethica.esf.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactory;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.EmailAddress;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.LayoutSet;
import com.liferay.portal.model.ListType;
import com.liferay.portal.model.ListTypeConstants;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.Phone;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.EmailAddressLocalServiceUtil;
import com.liferay.portal.service.LayoutSetLocalServiceUtil;
import com.liferay.portal.service.ListTypeServiceUtil;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.PhoneLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.sites.util.SitesUtil;

import it.ethica.esf.ESFOrganizationNameException;
import it.ethica.esf.ESFOrganizationTypeException;
import it.ethica.esf.model.ESFAddress;
import it.ethica.esf.model.ESFCard;
import it.ethica.esf.model.ESFEntityState;
import it.ethica.esf.model.ESFField;
import it.ethica.esf.model.ESFLentField;
import it.ethica.esf.model.ESFOrganization;
import it.ethica.esf.model.ESFPhone;
import it.ethica.esf.model.ESFRenewal;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.impl.ESFOrganizationImpl;
import it.ethica.esf.portlet.ESFUserAdminPortlet;
import it.ethica.esf.renewal.model.ESFRenewalCompany;
import it.ethica.esf.renewal.service.ESFRenewalCompanyLocalServiceUtil;
import it.ethica.esf.service.ESFAddressLocalServiceUtil;
import it.ethica.esf.service.ESFEntityStateLocalServiceUtil;
import it.ethica.esf.service.ESFLentFieldLocalServiceUtil;
import it.ethica.esf.service.ESFOrganizationLocalServiceUtil;
import it.ethica.esf.service.ESFPhoneLocalServiceUtil;
import it.ethica.esf.service.ESFRenewalLocalServiceUtil;
import it.ethica.esf.service.ESFUserLocalServiceUtil;
import it.ethica.esf.service.base.ESFOrganizationLocalServiceBaseImpl;
import it.ethica.esf.service.persistence.ESFOrganizationFinderUtil;
import it.ethica.esf.util.ESFKeys;
/**
 * The implementation of the e s f organization local service.
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link it.ethica.esf.service.ESFOrganizationLocalService} interface.
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFOrganizationLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFOrganizationLocalServiceUtil
 */
public class ESFOrganizationLocalServiceImpl extends
		ESFOrganizationLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link it.ethica.esf.service.ESFOrganizationLocalServiceUtil} to access
	 * the e s f organization local service.
	 */
	
	public ESFOrganization addESFOrganization(long userId,
			long parentOrganizationId, String name, String emailAddress,
			String code, String vat, String fiscalCode, String ibanCode,
			Date establishmentDate, Date closureDate, Date insertDate,
			Date coniDate, String coniCode, String legalForm, String category,
			List<ESFAddress> esfAddresses, List<ESFPhone> esfphones,
			boolean publicLayoutSetPrototypeEnabled,
			boolean privateLayoutSetPrototypeEnabled, boolean isMultiSport,
			String description, boolean isYouthActive, 
			Date firstAffiliationDate, ESFEntityState esfEntityState, long variation, long regionCode,
			boolean constitutiveAct, boolean registeredStatus, boolean planimetrySportsStand, boolean certificateFITAV,
			boolean isSimplyOrganizzation, String note, String webSite, boolean addToConiReport , ServiceContext serviceContext) throws PortalException,
			SystemException {
		
		
		ESFOrganization esfOrganization = addESFOrganization(userId,
				parentOrganizationId, name, code, vat, fiscalCode, ibanCode,
				establishmentDate, closureDate, insertDate, coniDate, coniCode,
				legalForm, category, publicLayoutSetPrototypeEnabled,
				privateLayoutSetPrototypeEnabled, isMultiSport, description,
				isYouthActive, firstAffiliationDate, esfEntityState, variation, regionCode,
				constitutiveAct, registeredStatus, planimetrySportsStand, certificateFITAV,
				isSimplyOrganizzation,note, webSite,addToConiReport, serviceContext);
		
		for (ESFAddress esfAddress : esfAddresses) {
			ESFAddressLocalServiceUtil.addESFAddress(userId,
					esfAddress.getLongitude(), esfAddress.getEsfCountryId(),
					esfAddress.getEsfRegionId(), esfAddress.getEsfProvinceId(),
					esfAddress.getEsfCityId(), esfAddress.getLatitude(),
					esfAddress.getType(), esfAddress.getListTypeId(),
					Organization.class.getName(),
					esfOrganization.getEsfOrganizationId(),
					esfAddress.getStreet1(), esfAddress.getStreet2(),
					esfAddress.getStreet3(), esfAddress.getZip(), 12000,
					esfAddress.getMailing(), esfAddress.getPrimary_(), false,
					serviceContext);
		}
		boolean first = true;

		for (ESFPhone phone : esfphones) {

			ESFPhoneLocalServiceUtil.addESFPhone(userId,
					Organization.class.getName(),
					esfOrganization.getEsfOrganizationId(), phone.getNumber(),
					StringPool.BLANK, phone.getListTypeId(), phone.getTypeId(),
					first, serviceContext);

			first = false;
		}
		List<ListType> emailListType = ListTypeServiceUtil
				.getListTypes(Organization.class.getName()
						+ ListTypeConstants.EMAIL_ADDRESS);
		int typeId = 0;
		if (emailListType.size() > 0) {
			typeId = emailListType.get(0).getListTypeId();
		}
		EmailAddressLocalServiceUtil.addEmailAddress(userId,
				Organization.class.getName(),
				esfOrganization.getEsfOrganizationId(), emailAddress, typeId,
				true, serviceContext);
		List<Phone> phones = new ArrayList<Phone>();

		ESFUser esfUser = ESFUserLocalServiceUtil.addESFUserInOrganization(
				userId, "", "", emailAddress, (new Long(0)).longValue(),
				serviceContext.getLocale(), name, "", name, 0, 0, true, 1, 1,
				1970, "", esfAddresses.get(0), esfEntityState, phones,
				serviceContext, serviceContext);
		OrganizationLocalServiceUtil.addUserOrganization(
				esfUser.getEsfUserId(), esfOrganization.getEsfOrganizationId());
		Role role = RoleLocalServiceUtil.getRole(esfUser.getCompanyId(),
				RoleConstants.ORGANIZATION_ADMINISTRATOR);
		UserLocalServiceUtil.addRoleUser(role.getRoleId(),
				esfUser.getEsfUserId());
		return esfOrganization;
	}

	public ESFOrganization addESFOrganization(long userId,
			long parentOrganizationId, String name, String code, String vat,
			String fiscalCode, String ibanCode, Date establishmentDate,
			Date closureDate, Date insertDate, Date coniDate, String coniCode,
			String legalForm, String category,
			boolean publicLayoutSetPrototypeEnabled,
			boolean privateLayoutSetPrototypeEnabled, boolean isMultiSport,
			String description, boolean isYouthActive,
			Date firstAffiliationDate, ESFEntityState esfEntityState, long variation, long regionCode,
			boolean constitutiveAct, boolean registeredStatus, boolean planimetrySportsStand, boolean certificateFITAV,
			boolean isSimplyOrganizzation, String note, String  webSite, boolean addToConiReport, ServiceContext serviceContext) throws PortalException,
			SystemException {

		validate(name);

		if (!validate(parentOrganizationId)) {

			parentOrganizationId = 0;

		}

		Organization organization = OrganizationLocalServiceUtil
				.addOrganization(userId, parentOrganizationId, name,
						"regular-organization", 0, 0, 12017, "", true,
						serviceContext);

		Group organizationGroup = organization.getGroup();

		ESFOrganization parentESFOrganization = esfOrganizationPersistence
				.fetchByPrimaryKey(parentOrganizationId);

		long portalOrganizationId = organization.getOrganizationId();

		int esfOrganizationtype = parentESFOrganization == null ? 1
				: parentESFOrganization.getType() + 1;

		validateType(esfOrganizationtype);
		
		long renewalComanyId = CounterLocalServiceUtil.increment("it.ethica.esf.model.ESFRenewalCompany");
		
		Calendar calendar = GregorianCalendar.getInstance();
		int actualYear = calendar.get( Calendar.YEAR );
		Date today = new Date();
		
		
		ESFRenewalCompany renewalComany =  ESFRenewalCompanyLocalServiceUtil.createESFRenewalCompany(renewalComanyId);
		
		renewalComany.setUserId(userId);
		renewalComany.setEsfOrganizationId(portalOrganizationId);
		renewalComany.setYear(actualYear);
		renewalComany.setDate(today);
		renewalComany.setStatus(0);
		ESFRenewalCompanyLocalServiceUtil.updateESFRenewalCompany(renewalComany);
		
		/*
		 * 
		 * rimosso e sostituito con la creazione di una riga sulla tabella esfrenewalcompany 
		ESFEntityStateLocalServiceUtil.addEntityState(
				serviceContext.getUserId(), ESFOrganization.class.getName(),
				portalOrganizationId, esfEntityState.getEsfStateId(),
				serviceContext);
				*/

		ESFOrganization esfOrganization = esfOrganizationPersistence
				.create(portalOrganizationId);

		esfOrganization.setUuid(serviceContext.getUuid());
		esfOrganization.setCode(code);
		esfOrganization.setVat(vat);
		esfOrganization.setFiscalCode(fiscalCode);
		esfOrganization.setIbanCode(ibanCode);
		esfOrganization.setEstablishmentDate(establishmentDate);
		esfOrganization.setClosureDate(closureDate);
		esfOrganization.setInsertDate(insertDate);
		esfOrganization.setConiDate(coniDate);
		esfOrganization.setConiCode(coniCode);
		esfOrganization.setLegalForm(legalForm);
		esfOrganization.setCategory(category);
		esfOrganization.setGroupId(organizationGroup.getGroupId());
		esfOrganization.setExpandoBridgeAttributes(serviceContext);
		esfOrganization.setType(esfOrganizationtype);
		esfOrganization.setIsMultiSport(isMultiSport);
		esfOrganization.setIsYouthActive(isYouthActive);
		esfOrganization.setFirstAffiliationDate(firstAffiliationDate);
		esfOrganization.setDescription(description);
		esfOrganization.setVariations(variation);
		esfOrganization.setRegionCode(regionCode);
		esfOrganization.setConstitutiveAct(constitutiveAct);
		esfOrganization.setRegisteredStatus(registeredStatus);
		esfOrganization.setPlanimetrySportsStand(planimetrySportsStand);
		esfOrganization.setCertificateFITAV(certificateFITAV);
		esfOrganization.setIsSimplyOrganizzation(isSimplyOrganizzation);
		esfOrganization.setNote(note);
		esfOrganization.setWebSite(webSite);
		esfOrganization.setIncludeConiReport(addToConiReport);
		esfOrganizationPersistence.update(esfOrganization);

		try {
			long publicLayoutSetPrototypeId = 0;
			long privateLayoutSetPrototypeId = 0;
			
			
			if (publicLayoutSetPrototypeEnabled) {

				publicLayoutSetPrototypeId = esfOrganization
						.getDefaultLayoutSetPrototypeId(true);
			}

			if (privateLayoutSetPrototypeEnabled) {
				privateLayoutSetPrototypeId = esfOrganization
						.getDefaultLayoutSetPrototypeId(false);
			}
			
			SitesUtil.updateLayoutSetPrototypesLinks(organizationGroup,
					publicLayoutSetPrototypeId, privateLayoutSetPrototypeId,
					publicLayoutSetPrototypeEnabled,
					privateLayoutSetPrototypeEnabled);

			LayoutSet layoutSet = LayoutSetLocalServiceUtil.getLayoutSet(
					organizationGroup.getGroupId(), true);
			SitesUtil.mergeLayoutSetPrototypeLayouts(organizationGroup,
					layoutSet);
		} catch (Exception e) {
		}

		resourceLocalService.addResources(serviceContext.getCompanyId(),
				serviceContext.getScopeGroupId(), userId,
				ESFOrganization.class.getName(), portalOrganizationId, false,
				true, true);

		return esfOrganization;
	}

	public ESFOrganization updateESFOrganization(long userId,
			long esfOrganizationId, long parentOrganizationId, String name,
			String emailAddress, String code, String vat, String fiscalCode,
			String ibanCode, Date establishmentDate, Date closureDate,
			Date insertDate, Date coniDate, String coniCode, String legalForm,
			String category, List<ESFAddress> esfAddresses,
			List<ESFPhone> phones, boolean isMultiSport, String description,
			boolean isYouthActive, Date firstAffiliationDate,
			ESFEntityState esfEntityState, long variation, long regionCode, long idFatherAssociation,
			boolean constitutiveAct, boolean registeredStatus, boolean planimetrySportsStand, boolean certificateFITAV,
			String note, String webSite, boolean addToConiReport, ServiceContext serviceContext)
			throws PortalException, SystemException {

		ESFOrganization esfOrganization = updateESFOrganization(userId,
				esfOrganizationId, parentOrganizationId, name, code, vat,
				fiscalCode, ibanCode, establishmentDate, closureDate,
				insertDate, coniDate, coniCode, legalForm, category,
				isMultiSport, description, isYouthActive, firstAffiliationDate,
				esfEntityState, variation, regionCode, idFatherAssociation,
				constitutiveAct, registeredStatus, planimetrySportsStand, certificateFITAV, note, 
				webSite, addToConiReport, serviceContext);

		try {

			List<ESFAddress> esfAddressesInDb = ESFAddressLocalServiceUtil
					.getESFAddresses(esfOrganization.getCompanyId(),
							Organization.class.getName(), esfOrganizationId);
			
			for (ESFAddress esfAddressInDb : esfAddressesInDb) {

				ESFAddressLocalServiceUtil.deleteESFAddress(
						esfAddressInDb.getEsfAddressId(), serviceContext);
			}

			for (ESFAddress esfAddress : esfAddresses) {

				esfAddressLocalService.addESFAddress(
						serviceContext.getUserId(), esfAddress.getLongitude(),
						esfAddress.getEsfCountryId(),
						esfAddress.getEsfRegionId(),
						esfAddress.getEsfProvinceId(),
						esfAddress.getEsfCityId(), esfAddress.getLatitude(),
						esfAddress.getType(), esfAddress.getListTypeId(),
						Organization.class.getName(), esfOrganizationId,
						esfAddress.getStreet1(), esfAddress.getStreet2(),
						esfAddress.getStreet3(), esfAddress.getZip(),
						esfAddress.getTypeId(), esfAddress.getMailing(),
						esfAddress.getPrimary_(), false , serviceContext);

			}

		} catch (Exception ex) {
			// ex.printStackTrace();
		}

		try {
			List<Phone> phonesInDb = PhoneLocalServiceUtil.getPhones(
					esfOrganization.getCompanyId(),
					Organization.class.getName(), esfOrganizationId);

			for (Phone phoneInDb : phonesInDb) {

				ESFPhoneLocalServiceUtil.deleteESFPhone(phoneInDb.getPhoneId(),
						serviceContext);
			}

			boolean first = true;

			for (ESFPhone phone : phones) {

				ESFPhoneLocalServiceUtil.addESFPhone(userId,
						Organization.class.getName(),
						esfOrganization.getEsfOrganizationId(),
						phone.getNumber(), StringPool.BLANK,
						phone.getListTypeId(), phone.getTypeId(), first,
						serviceContext);

				first = false;
			}
		} catch (Exception ex) {
			// ex.printStackTrace();
		}

		try {
			List<ListType> emailListType = ListTypeServiceUtil
					.getListTypes(Organization.class.getName()
							+ ListTypeConstants.EMAIL_ADDRESS);

			int typeId = 0;
			if (emailListType.size() > 0) {
				typeId = emailListType.get(0).getListTypeId();
			}

			List<EmailAddress> organizationEmailAddresses = EmailAddressLocalServiceUtil
					.getEmailAddresses(serviceContext.getCompanyId(),
							Organization.class.getName(),
							esfOrganization.getEsfOrganizationId());

			if (organizationEmailAddresses != null
					&& organizationEmailAddresses.size() == 1) {

				EmailAddress emailAddressObj = organizationEmailAddresses
						.get(0);

				EmailAddressLocalServiceUtil.updateEmailAddress(
						emailAddressObj.getEmailAddressId(), emailAddress,
						typeId, true);
			} else {

				EmailAddressLocalServiceUtil.addEmailAddress(userId,
						Organization.class.getName(),
						esfOrganization.getEsfOrganizationId(), emailAddress,
						typeId, true, serviceContext);
			}
		} catch (Exception ex) {
			// ex.printStackTrace();
		}

		return esfOrganization;

	}

	public ESFOrganization updateESFOrganization(long userId,
			long esfOrganizationId, long parentOrganizationId, String name,
			String code, String vat, String fiscalCode, String ibanCode,
			Date establishmentDate, Date closureDate, Date insertDate,
			Date coniDate, String coniCode, String legalForm, String category,
			boolean isMultiSport, String description, boolean isYouthActive,
			Date firstAffiliationDate, ESFEntityState esfEntityState, long variation, long regionCode, long idFatherAssociation,
			boolean constitutiveAct, boolean registeredStatus, boolean planimetrySportsStand, boolean certificateFITAV, String note,
			String webSite, boolean addToConiReport ,ServiceContext serviceContext) throws PortalException,
			SystemException {

		validate(name);

		if (parentOrganizationId != 0) {

			OrganizationLocalServiceUtil.updateOrganization(
					serviceContext.getCompanyId(), esfOrganizationId,
					parentOrganizationId, name, "regular-organization", 0, 0,
					12017, "", true, serviceContext);

		}

		ESFOrganization esfOrganization = getESFOrganization(esfOrganizationId);

		esfOrganization.setCategory(category);
		esfOrganization.setClosureDate(closureDate);
		esfOrganization.setCode(code);
		esfOrganization.setConiCode(coniCode);
		esfOrganization.setConiDate(coniDate);
		esfOrganization.setDescription(description);
		esfOrganization.setEsfOrganizationId(esfOrganizationId);
		esfOrganization.setEstablishmentDate(establishmentDate);
		esfOrganization.setFirstAffiliationDate(firstAffiliationDate);
		esfOrganization.setFiscalCode(fiscalCode);
		esfOrganization.setIbanCode(ibanCode);
		esfOrganization.setInsertDate(insertDate);
		esfOrganization.setIsMultiSport(isMultiSport);
		esfOrganization.setIsYouthActive(isYouthActive);
		esfOrganization.setLegalForm(legalForm);
		esfOrganization.setName(name);
		esfOrganization.setParentOrganizationId(parentOrganizationId);
		esfOrganization.setStatusId(12017);
		esfOrganization.setType_("regular-organization");
		esfOrganization.setVat(vat);
		esfOrganization.setVariations(variation);
		esfOrganization.setRegionCode(regionCode);
		esfOrganization.setIdFatherAssociation(idFatherAssociation);
		esfOrganization.setConstitutiveAct(constitutiveAct);
		esfOrganization.setRegisteredStatus(registeredStatus);
		esfOrganization.setPlanimetrySportsStand(planimetrySportsStand);
		esfOrganization.setCertificateFITAV(certificateFITAV);
		esfOrganization.setNote(note);
		esfOrganization.setWebSite(webSite);
		esfOrganization.setIncludeConiReport(addToConiReport);
		ESFEntityState esfEntityStateFromDB = ESFEntityStateLocalServiceUtil
				.findESFEntityStateByC_PK(ESFOrganization.class.getName(),
						esfOrganizationId);

		if (esfEntityStateFromDB != null
				&& esfEntityStateFromDB.getEsfStateId() != esfEntityState
						.getEsfStateId()) {

			ESFEntityStateLocalServiceUtil.updateEntityState(
					serviceContext.getUserId(),
					esfEntityStateFromDB.getEsfEntityStateId(), serviceContext);

			ESFEntityStateLocalServiceUtil.addEntityState(
					serviceContext.getUserId(),
					ESFOrganization.class.getName(), esfOrganizationId,
					esfEntityState.getEsfStateId(), serviceContext);
		}

		esfOrganizationPersistence.update(esfOrganization);

		Organization organization = organizationPersistence
				.findByPrimaryKey(esfOrganization.getPrimaryKey());

		organization.setName(name);
		organization.setModifiedDate(new Date());

		organizationPersistence.update(organization);

		resourceLocalService.updateResources(serviceContext.getCompanyId(),
				serviceContext.getScopeGroupId(), name, esfOrganizationId,
				serviceContext.getGroupPermissions(),
				serviceContext.getGuestPermissions());

		return esfOrganization;
	}

	
	public List<ESFOrganization> findByGroupId(long groupId)
			throws SystemException {

		return esfOrganizationPersistence.findByGroupId(groupId);
	}

	public List<ESFOrganization> getByProvinceCode(String id)
			throws SystemException {

		List<ESFOrganization> list = esfOrganizationPersistence
				.findByCodeLike(id);
		ESFOrganization org = list.get(0);
		List<ESFOrganization> list2 = null;
		try {
			list2 = ESFOrganizationLocalServiceUtil
					.findAllChildOrganizations(org.getEsfOrganizationId());
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list2;

	}

	public List<ESFOrganization> findByGroupId(long groupId, int start, int end)
			throws SystemException {

		return esfOrganizationPersistence.findByGroupId(groupId, start, end);
	}

	public ESFOrganization findByCode(String code) throws SystemException {

		return esfOrganizationPersistence.fetchByCode(code);
	}

	public ESFOrganization getRealOwner(long esfStateId, long esfFieldId)
			throws SystemException {

		ESFOrganization esfOrganization = null;

		ESFEntityState esfEntityState = ESFEntityStateLocalServiceUtil
				.findESFEntityStateByC_PK_S(ESFField.class.getName(),
						esfFieldId, esfStateId);

		if (esfEntityState != null) {

			ESFLentField esfLentField = ESFLentFieldLocalServiceUtil
					.findESFLentFieldbyF_S(esfFieldId,
							esfEntityState.getEsfEntityStateId());

			if (esfLentField != null)
				esfOrganization = esfOrganizationPersistence
						.fetchByPrimaryKey(esfLentField.getRealOwnerId());

		}

		return esfOrganization;
	}

	/**
	 * Ricerca tutte le organizzazioni di tipo <b>type</b>
	 * 
	 * @throws SystemException
	 * @throws PortalException
	 */
	public List<ESFOrganization> findAllESFOrganizations(long type, int state)
			throws SystemException, PortalException {

		List<ESFOrganization> esfOrganizations = new ArrayList<ESFOrganization>();

		List<ESFOrganization> esfOrganizationsFromDb = getAllEsfOrganizationByState(state);

		for (ESFOrganization esfOrganization : esfOrganizationsFromDb) {

			if (esfOrganization.getType() == type) {

				esfOrganizations.add(esfOrganization);

			}

		}

		return esfOrganizations;
	}
	
	/**
	 * Ricerca tutte le organizzazioni il cui code inizia con il pattern
	 * indicato da <b>code</b>
	 * 
	 * @param code
	 *            patten di partenza
	 * @return List<ESFOrganization>
	 */

	public List<ESFOrganization> findESFOrganizationsByCode(String code) {

		List<ESFOrganization> esfOrganizzations = new ArrayList<ESFOrganization>();

		try {
			esfOrganizzations = esfOrganizationPersistence.findByCodeLike(code
					+ "%");
		} catch (SystemException e) {
		}

		return esfOrganizzations;
	}

	/**
	 * Ricerca tutte le organizzazioni sportive con type = <b>type</b> il cui
	 * code inizia con il pattern indicato da <b>code</b>
	 * 
	 * @param code
	 *            patten di partenza
	 * @param type
	 *            il tipo dell'organizzazione
	 * @return List<ESFOrganization>
	 * @throws PortalException
	 * @throws SystemException
	 */
	public List<ESFOrganization> findESFOrganizationsByT_C(long type,
			String code, int state) throws SystemException, PortalException {

		List<ESFOrganization> esfOrganizations = findAllESFOrganizations(type,
				state);

		long[] classPKs = new long[esfOrganizations.size()];
		int i = 0;

		for (ESFOrganization esfOrganization : esfOrganizations) {
			classPKs[i] = esfOrganization.getEsfOrganizationId();
			i++;
		}

		try {

			DynamicQuery orgsQuery = DynamicQueryFactoryUtil.forClass(
					ESFOrganization.class, "orgsQuery",
					PortletClassLoaderUtil.getClassLoader());

			orgsQuery.add(PropertyFactoryUtil.forName("orgsQuery.code").like(
					code + StringPool.PERCENT));
			orgsQuery.add(PropertyFactoryUtil.forName(
					"orgsQuery.esfOrganizationId").in(classPKs));

			esfOrganizations = ESFOrganizationLocalServiceUtil
					.dynamicQuery(orgsQuery);

		} catch (Exception e) {
			// TODO: handle exception
		}

		return esfOrganizations;
	}

	/**
	 * Ricerca tutte le organizzazioni sportive con type = <b>type</b> il cui
	 * code inizia con il pattern indicato da <b>code</b>
	 * 
	 * @param code
	 *            patten di partenza
	 * @param type
	 *            il tipo dell'organizzazione
	 * @return List<ESFOrganization>
	 * @throws PortalException
	 * @throws SystemException
	 */
	public List<ESFOrganization> findESFOrganizationsByT_C(long type,
			String code, int state, int start, int end) throws SystemException,
			PortalException {

		List<ESFOrganization> esfOrganizations = findAllESFOrganizations(type,
				state);

		long[] classPKs = new long[esfOrganizations.size()];
		int i = 0;

		for (ESFOrganization esfOrganization : esfOrganizations) {
			classPKs[i] = esfOrganization.getEsfOrganizationId();
			i++;
		}

		try {

			DynamicQuery orgsQuery = DynamicQueryFactoryUtil.forClass(
					ESFOrganization.class, "orgsQuery",
					PortletClassLoaderUtil.getClassLoader());

			orgsQuery.add(PropertyFactoryUtil.forName("orgsQuery.code").like(
					code + StringPool.PERCENT));
			orgsQuery.add(PropertyFactoryUtil.forName(
					"orgsQuery.esfOrganizationId").in(classPKs));

			esfOrganizations = ESFOrganizationLocalServiceUtil.dynamicQuery(
					orgsQuery, start, end);

		} catch (Exception e) {
			// TODO: handle exception
		}

		return esfOrganizations;
	}

	public List<ESFOrganization> findESFOrganizationsByT_C_N(long type,
			String code, String name, int state, int start, int end) throws SystemException, PortalException {

		List<ESFOrganization> associations=findAllESFOrganizations(type,
					state);
		
		
		List<ESFOrganization> esfOrganizzationFinal = new ArrayList<ESFOrganization>();

		try {
			
			List<Long> orgIds = new ArrayList<Long>();

			DynamicQuery orgQuery = DynamicQueryFactoryUtil.forClass(
					Organization.class, "orgQuery",
					PortalClassLoaderUtil.getClassLoader());

			orgQuery.add(PropertyFactoryUtil.forName("orgQuery.name").like(
					StringPool.PERCENT + name + StringPool.PERCENT));

						List<Organization> organizzations = OrganizationLocalServiceUtil
					.dynamicQuery(orgQuery);

			for (Organization organizzation : organizzations) {
				for (ESFOrganization association : associations) {
					if (association.getEsfOrganizationId() == organizzation
							.getOrganizationId()) {
						orgIds.add(association.getEsfOrganizationId());
					}
				}
			}

			DynamicQuery esfOrgQuery = DynamicQueryFactoryUtil.forClass(
					ESFOrganization.class, "esfOrgQuery",
					PortletClassLoaderUtil.getClassLoader());

			esfOrgQuery.add(PropertyFactoryUtil.forName("esfOrgQuery.code")
					.like(StringPool.PERCENT + code + StringPool.PERCENT));

			esfOrgQuery.add(PropertyFactoryUtil.forName(
					"esfOrgQuery.esfOrganizationId").in(orgIds));

			esfOrganizzationFinal = ESFOrganizationLocalServiceUtil
					.dynamicQuery(esfOrgQuery, start, end);
		} catch (Exception e) {

		}
		
		return esfOrganizzationFinal;
	}
	
	public List<ESFOrganization> findESFOrganizationsByT_C_N(long type,
			String code, String name, int state) throws SystemException, PortalException {

		List<ESFOrganization> associations=findAllESFOrganizations(type,
					state);
		
		
		List<ESFOrganization> esfOrganizzationFinal = new ArrayList<ESFOrganization>();

		try {
			
			List<Long> orgIds = new ArrayList<Long>();

			DynamicQuery orgQuery = DynamicQueryFactoryUtil.forClass(
					Organization.class, "orgQuery",
					PortalClassLoaderUtil.getClassLoader());

			orgQuery.add(PropertyFactoryUtil.forName("orgQuery.name").like(
					StringPool.PERCENT + name + StringPool.PERCENT));

						List<Organization> organizzations = OrganizationLocalServiceUtil
					.dynamicQuery(orgQuery);

			for (Organization organizzation : organizzations) {
				for (ESFOrganization association : associations) {
					if (association.getEsfOrganizationId() == organizzation
							.getOrganizationId()) {
						orgIds.add(association.getEsfOrganizationId());
					}
				}
			}

			DynamicQuery esfOrgQuery = DynamicQueryFactoryUtil.forClass(
					ESFOrganization.class, "esfOrgQuery",
					PortletClassLoaderUtil.getClassLoader());

			esfOrgQuery.add(PropertyFactoryUtil.forName("esfOrgQuery.code")
					.like(StringPool.PERCENT + code + StringPool.PERCENT));

			esfOrgQuery.add(PropertyFactoryUtil.forName(
					"esfOrgQuery.esfOrganizationId").in(orgIds));

			esfOrganizzationFinal = ESFOrganizationLocalServiceUtil
					.dynamicQuery(esfOrgQuery);
		} catch (Exception e) {

		}
		
		return esfOrganizzationFinal;
	}

	
	//trova le organizzazioni in base al tipo e allo stato
	
	public List<ESFOrganization> findESFOrganizationsByT_C(long type,
			 int state) throws SystemException, PortalException {

		List<ESFOrganization> esfOrganizations = findAllESFOrganizations(type,
				state);

		long[] classPKs = new long[esfOrganizations.size()];
		int i = 0;

		for (ESFOrganization esfOrganization : esfOrganizations) {
			classPKs[i] = esfOrganization.getEsfOrganizationId();
			i++;
		}

		try {

			DynamicQuery orgsQuery = DynamicQueryFactoryUtil.forClass(
					ESFOrganization.class, "orgsQuery",
					PortletClassLoaderUtil.getClassLoader());

				orgsQuery.add(PropertyFactoryUtil.forName(
					"orgsQuery.esfOrganizationId").in(classPKs));

			esfOrganizations = ESFOrganizationLocalServiceUtil
					.dynamicQuery(orgsQuery);

		} catch (Exception e) {
			// TODO: handle exception
		}

		return esfOrganizations;
	}
	
	//trova le organizzazioni in base al tipo e allo stato con start ed end
	
	public List<ESFOrganization> findESFOrganizationsByT_C(long type,
			int state, int start, int end) throws SystemException,
			PortalException {

		List<ESFOrganization> esfOrganizations = findAllESFOrganizations(type,
				state);

		long[] classPKs = new long[esfOrganizations.size()];
		int i = 0;

		for (ESFOrganization esfOrganization : esfOrganizations) {
			classPKs[i] = esfOrganization.getEsfOrganizationId();
			i++;
		}

		try {

			DynamicQuery orgsQuery = DynamicQueryFactoryUtil.forClass(
					ESFOrganization.class, "orgsQuery",
					PortletClassLoaderUtil.getClassLoader());

			orgsQuery.add(PropertyFactoryUtil.forName(
					"orgsQuery.esfOrganizationId").in(classPKs));

			esfOrganizations = ESFOrganizationLocalServiceUtil.dynamicQuery(
					orgsQuery, start, end);

		} catch (Exception e) {
			// TODO: handle exception
		}

		return esfOrganizations;
	}
	
	
	/**
	 * Ricerca tutte le organizzazioni sportive foglie a partire
	 * dall'organizzazione con id = organizationId il cui code inizia con il
	 * pattern indicato da <b>code</b>
	 * 
	 * @param code
	 *            patten di partenza
	 * @param organizationId
	 *            id dell'organizzazione
	 * @return List<ESFOrganization>
	 * @throws PortalException
	 * @throws SystemException
	 */

	public List<ESFOrganization> findESFOrganizationsByCode(
			long organizationId, String code, int state)
			throws SystemException, PortalException {

		List<ESFOrganization> esfOrganizations = findAllLeafOrganizations(
				organizationId, state);

		long[] classPKs = new long[esfOrganizations.size()];
		int i = 0;

		for (ESFOrganization esfOrganization : esfOrganizations) {
			classPKs[i] = esfOrganization.getEsfOrganizationId();
			i++;
		}

		try {

			DynamicQuery orgsQuery = DynamicQueryFactoryUtil.forClass(
					ESFOrganization.class, "orgsQuery",
					PortletClassLoaderUtil.getClassLoader());

			orgsQuery.add(PropertyFactoryUtil.forName("orgsQuery.code").like(
					code + StringPool.PERCENT));
			orgsQuery.add(PropertyFactoryUtil.forName(
					"orgsQuery.esfOrganizationId").in(classPKs));

			esfOrganizations = ESFOrganizationLocalServiceUtil
					.dynamicQuery(orgsQuery);

		} catch (Exception e) {
			// TODO: handle exception
		}

		return esfOrganizations;
	}

	/**
	 * Ricerca tutte le organizzazioni sportive foglie a partire
	 * dall'organizzazione con id = organizationId il cui code inizia con il
	 * pattern indicato da <b>code</b>
	 * 
	 * @param code
	 *            patten di partenza
	 * @param organizationId
	 *            id dell'organizzazione
	 * @return List<ESFOrganization>
	 * @throws PortalException
	 * @throws SystemException
	 */

	public List<ESFOrganization> findESFOrganizationsByCode(
			long organizationId, String code, int state, int start, int end)
			throws SystemException, PortalException {

		List<ESFOrganization> esfOrganizations = findAllLeafOrganizations(
				organizationId, state);

		long[] classPKs = new long[esfOrganizations.size()];
		int i = 0;

		for (ESFOrganization esfOrganization : esfOrganizations) {
			classPKs[i] = esfOrganization.getEsfOrganizationId();
			i++;
		}

		try {

			DynamicQuery orgsQuery = DynamicQueryFactoryUtil.forClass(
					ESFOrganization.class, "orgsQuery",
					PortletClassLoaderUtil.getClassLoader());

			orgsQuery.add(PropertyFactoryUtil.forName("orgsQuery.code").like(
					code + StringPool.PERCENT));
			orgsQuery.add(PropertyFactoryUtil.forName(
					"orgsQuery.esfOrganizationId").in(classPKs));

			esfOrganizations = ESFOrganizationLocalServiceUtil.dynamicQuery(
					orgsQuery, start, end);

		} catch (Exception e) {

		}

		return esfOrganizations;
	}

	/**
	 * Ricerca tutte le organizzazioni di tipologia <b>type</b> a partire
	 * dall'organizzazione con id = organizationId
	 * 
	 * @param organizationId
	 *            identificativo dell'organizzazione
	 * @param type
	 *            tipologia di organizzazione [Fitav, regione, provincia,
	 *            associazione]
	 * @return List<ESFOrganization>
	 */
	public List<ESFOrganization> findESFOrganizationsByO_T(long organizationId,
			long type) {

		List<ESFOrganization> organizations = new ArrayList<ESFOrganization>();
		List<ESFOrganization> esfOrganizzationFinal = new ArrayList<ESFOrganization>();

		try {

			if (organizationId <= 0)
				return organizations;

			ESFOrganization esfSameOrganization = ESFOrganizationLocalServiceUtil
					.fetchESFOrganization(organizationId);

			if (esfSameOrganization != null
					&& esfSameOrganization.getType() == type) {
				organizations.add(esfSameOrganization);
				return organizations;
			}

			Organization organization = OrganizationLocalServiceUtil
					.getOrganization(organizationId);

			List<Organization> childOrganizations = organization
					.getDescendants();

			OrderByComparatorFactory orderByComparatorFactory = OrderByComparatorFactoryUtil
					.getOrderByComparatorFactory();
			OrderByComparator orderByComparator = orderByComparatorFactory
					.create("Organization", "name", true);

			childOrganizations = ListUtil.sort(childOrganizations,
					orderByComparator);

			if (childOrganizations.isEmpty()) {
				return organizations;

			} else {
				for (Organization child : childOrganizations) {
					ESFOrganization esfOrganization = ESFOrganizationLocalServiceUtil
							.fetchESFOrganization(child.getOrganizationId());

					boolean addOrganization = false;

					if (esfOrganization != null) {

						addOrganization = esfOrganization.getType() == type;

						if (addOrganization) {
							organizations.add(esfOrganization);
						}
					}
				}
			}

			List<Long> orgIds = new ArrayList<Long>();

			for (ESFOrganization org : organizations) {
				orgIds.add(org.getEsfOrganizationId());
			}

			DynamicQuery orgQuery = DynamicQueryFactoryUtil.forClass(
					ESFOrganization.class, "orgQuery",
					PortletClassLoaderUtil.getClassLoader());

			orgQuery.add(PropertyFactoryUtil.forName(
					"orgQuery.esfOrganizationId").in(orgIds));

			esfOrganizzationFinal = ESFOrganizationLocalServiceUtil
					.dynamicQuery(orgQuery);

		} catch (Exception e) {

		}

		OrderByComparatorFactory orderByComparatorFactory = OrderByComparatorFactoryUtil
				.getOrderByComparatorFactory();
		OrderByComparator orderByComparator = orderByComparatorFactory.create(
				"Organization", "name", true);

		esfOrganizzationFinal = ListUtil.sort(esfOrganizzationFinal,
				orderByComparator);

		return esfOrganizzationFinal;
	}

	public List<ESFOrganization> findESFOrganizationsByO_T_C_N(
			long organizationId, long type, String organizationCode,
			String organizationName) {

		List<ESFOrganization> organizations = new ArrayList<ESFOrganization>();
		List<ESFOrganization> esfOrganizzationFinal = new ArrayList<ESFOrganization>();

		try {

			if (organizationId <= 0)
				return organizations;

			ESFOrganization esfSameOrganization = ESFOrganizationLocalServiceUtil
					.fetchESFOrganization(organizationId);

			if (esfSameOrganization != null
					&& esfSameOrganization.getType() == type) {
				organizations.add(esfSameOrganization);
				return organizations;
			}

			Organization organization = OrganizationLocalServiceUtil
					.getOrganization(organizationId);

			List<Organization> childOrganizations = organization
					.getDescendants();

			OrderByComparatorFactory orderByComparatorFactory = OrderByComparatorFactoryUtil
					.getOrderByComparatorFactory();
			OrderByComparator orderByComparator = orderByComparatorFactory
					.create("Organization", "name", true);

			childOrganizations = ListUtil.sort(childOrganizations,
					orderByComparator);

			if (childOrganizations.isEmpty()) {
				return organizations;

			} else {
				for (Organization child : childOrganizations) {
					ESFOrganization esfOrganization = ESFOrganizationLocalServiceUtil
							.fetchESFOrganization(child.getOrganizationId());

					boolean addOrganization = false;

					if (esfOrganization != null) {

						addOrganization = esfOrganization.getType() == type;
						if (Validator.isNotNull(organizationName)
								&& addOrganization)
							addOrganization = esfOrganization.getName()
									.toUpperCase()
									.contains(organizationName.toUpperCase());

						if (addOrganization) {
							organizations.add(esfOrganization);
						}
					}
				}
			}

			List<Long> orgIds = new ArrayList<Long>();

			for (ESFOrganization org : organizations) {
				orgIds.add(org.getEsfOrganizationId());

			}

			DynamicQuery orgQuery = DynamicQueryFactoryUtil.forClass(
					ESFOrganization.class, "orgQuery",
					PortletClassLoaderUtil.getClassLoader());

			orgQuery.add(PropertyFactoryUtil.forName(
					"orgQuery.esfOrganizationId").in(orgIds));

			orgQuery.add(RestrictionsFactoryUtil.ilike("orgQuery.code",
					StringPool.PERCENT + organizationCode + StringPool.PERCENT));

			esfOrganizzationFinal = ESFOrganizationLocalServiceUtil
					.dynamicQuery(orgQuery);

		} catch (Exception e) {

		}

		OrderByComparatorFactory orderByComparatorFactory = OrderByComparatorFactoryUtil
				.getOrderByComparatorFactory();
		OrderByComparator orderByComparator = orderByComparatorFactory.create(
				"Organization", "name", true);

		esfOrganizzationFinal = ListUtil.sort(esfOrganizzationFinal,
				orderByComparator);
		return esfOrganizzationFinal;
	}

	public List<ESFOrganization> findESFOrganizationsByO_T_C_N(
			long organizationId, long type, String organizationCode,
			String organizationName, int start, int end) {

		List<ESFOrganization> organizations = new ArrayList<ESFOrganization>();
		List<ESFOrganization> esfOrganizzationFinal = new ArrayList<ESFOrganization>();

		try {

			if (organizationId <= 0)
				return organizations;

			ESFOrganization esfSameOrganization = ESFOrganizationLocalServiceUtil
					.fetchESFOrganization(organizationId);

			if (esfSameOrganization != null
					&& esfSameOrganization.getType() == type) {
				organizations.add(esfSameOrganization);
				return organizations;
			}

			Organization organization = OrganizationLocalServiceUtil
					.getOrganization(organizationId);

			List<Organization> childOrganizations = organization
					.getDescendants();

			OrderByComparatorFactory orderByComparatorFactory = OrderByComparatorFactoryUtil
					.getOrderByComparatorFactory();
			OrderByComparator orderByComparator = orderByComparatorFactory
					.create("Organization", "name", true);

			childOrganizations = ListUtil.sort(childOrganizations,
					orderByComparator);

			if (childOrganizations.isEmpty()) {
				return organizations;

			} else {
				for (Organization child : childOrganizations) {
					ESFOrganization esfOrganization = ESFOrganizationLocalServiceUtil
							.fetchESFOrganization(child.getOrganizationId());

					boolean addOrganization = false;

					if (esfOrganization != null) {

						addOrganization = esfOrganization.getType() == type;
						if (Validator.isNotNull(organizationName)
								&& addOrganization)
							addOrganization = esfOrganization.getName()
									.toUpperCase()
									.contains(organizationName.toUpperCase());

						if (addOrganization) {
							organizations.add(esfOrganization);
						}
					}
				}
			}

			List<Long> orgIds = new ArrayList<Long>();

			for (ESFOrganization org : organizations) {
				orgIds.add(org.getEsfOrganizationId());

			}

			DynamicQuery orgQuery = DynamicQueryFactoryUtil.forClass(
					ESFOrganization.class, "orgQuery",
					PortletClassLoaderUtil.getClassLoader());

			orgQuery.add(PropertyFactoryUtil.forName(
					"orgQuery.esfOrganizationId").in(orgIds));

			orgQuery.add(RestrictionsFactoryUtil.ilike("orgQuery.code",
					StringPool.PERCENT + organizationCode + StringPool.PERCENT));

			esfOrganizzationFinal = ESFOrganizationLocalServiceUtil
					.dynamicQuery(orgQuery, start, end);

		} catch (Exception e) {

		}

		OrderByComparatorFactory orderByComparatorFactory = OrderByComparatorFactoryUtil
				.getOrderByComparatorFactory();
		OrderByComparator orderByComparator = orderByComparatorFactory.create(
				"Organization", "name", true);

		esfOrganizzationFinal = ListUtil.sort(esfOrganizzationFinal,
				orderByComparator);
		return esfOrganizzationFinal;
	}

	public List<ESFOrganization> getOrganizzationLeafByLikeN_C(String name,
			String code, long parentOrganizationId, long organizationId) {

		List<ESFOrganization> associations = new ArrayList<ESFOrganization>();
		List<ESFOrganization> esfOrganizzationFinal = new ArrayList<ESFOrganization>();

		try {
			associations = ESFOrganizationLocalServiceUtil
					.findAllLeafOrganizations(organizationId);

			List<Long> orgIds = new ArrayList<Long>();

			DynamicQuery orgQuery = DynamicQueryFactoryUtil.forClass(
					Organization.class, "orgQuery",
					PortalClassLoaderUtil.getClassLoader());

			orgQuery.add(PropertyFactoryUtil.forName("orgQuery.name").like(
					StringPool.PERCENT + name + StringPool.PERCENT));

			if (parentOrganizationId != 0)
				orgQuery.add(PropertyFactoryUtil.forName(
						"orgQuery.parentOrganizationId").eq(
						parentOrganizationId));

			List<Organization> organizzations = OrganizationLocalServiceUtil
					.dynamicQuery(orgQuery);

			OrderByComparatorFactory orderByComparatorFactory = OrderByComparatorFactoryUtil
					.getOrderByComparatorFactory();
			OrderByComparator orderByComparator = orderByComparatorFactory
					.create("Organization", "name", true);

			organizzations = ListUtil.sort(organizzations, orderByComparator);

			for (Organization organizzation : organizzations) {
				for (ESFOrganization association : associations) {
					if (association.getEsfOrganizationId() == organizzation
							.getOrganizationId()) {
						orgIds.add(association.getEsfOrganizationId());
					}
				}
			}
			DynamicQuery esfOrgQuery = DynamicQueryFactoryUtil.forClass(
					ESFOrganization.class, "esfOrgQuery",
					PortletClassLoaderUtil.getClassLoader());

			esfOrgQuery.add(PropertyFactoryUtil.forName("esfOrgQuery.code")
					.like(StringPool.PERCENT + code + StringPool.PERCENT));

			esfOrgQuery.add(PropertyFactoryUtil.forName(
					"esfOrgQuery.esfOrganizationId").in(orgIds));

			esfOrganizzationFinal = ESFOrganizationLocalServiceUtil
					.dynamicQuery(esfOrgQuery);

		} catch (Exception e) {

		}

		return esfOrganizzationFinal;
	}

	public List<ESFOrganization> getOrganizzationLeafByLikeN_C(String name,
			String code, long parentOrganizationId, long organizationId,
			int start, int end) {

		List<ESFOrganization> associations = new ArrayList<ESFOrganization>();
		List<ESFOrganization> esfOrganizzationFinal = new ArrayList<ESFOrganization>();

		try {
			associations = ESFOrganizationLocalServiceUtil
					.findAllLeafOrganizations(organizationId);

			List<Long> orgIds = new ArrayList<Long>();

			DynamicQuery orgQuery = DynamicQueryFactoryUtil.forClass(
					Organization.class, "orgQuery",
					PortalClassLoaderUtil.getClassLoader());

			orgQuery.add(PropertyFactoryUtil.forName("orgQuery.name").like(
					StringPool.PERCENT + name + StringPool.PERCENT));

			if (parentOrganizationId != 0)
				orgQuery.add(PropertyFactoryUtil.forName(
						"orgQuery.parentOrganizationId").eq(
						parentOrganizationId));

			List<Organization> organizzations = OrganizationLocalServiceUtil
					.dynamicQuery(orgQuery);

			OrderByComparatorFactory orderByComparatorFactory = OrderByComparatorFactoryUtil
					.getOrderByComparatorFactory();
			OrderByComparator orderByComparator = orderByComparatorFactory
					.create("Organization", "name", true);

			organizzations = ListUtil.sort(organizzations, orderByComparator);

			for (Organization organizzation : organizzations) {
				for (ESFOrganization association : associations) {
					if (association.getEsfOrganizationId() == organizzation
							.getOrganizationId()) {
						orgIds.add(association.getEsfOrganizationId());
					}
				}
			}

			DynamicQuery esfOrgQuery = DynamicQueryFactoryUtil.forClass(
					ESFOrganization.class, "esfOrgQuery",
					PortletClassLoaderUtil.getClassLoader());

			esfOrgQuery.add(PropertyFactoryUtil.forName("esfOrgQuery.code")
					.like(StringPool.PERCENT + code + StringPool.PERCENT));

			esfOrgQuery.add(PropertyFactoryUtil.forName(
					"esfOrgQuery.esfOrganizationId").in(orgIds));

			esfOrganizzationFinal = ESFOrganizationLocalServiceUtil
					.dynamicQuery(esfOrgQuery, start, end);
		} catch (Exception e) {

		}

		return esfOrganizzationFinal;
	}

	/**
	 * Ricerca tutte le organizzazioni sportive foglie a partire
	 * dall'organizzazione con id = organizationId. Se l'organizationId e' di un
	 * organizzazione foglia, ritorna una lista con solo quella organizzazione.
	 */
	public List<ESFOrganization> findAllLeafOrganizations(long organizationId)
			throws SystemException, PortalException {

		List<ESFOrganization> associations = new ArrayList<ESFOrganization>();
		List<ESFOrganization> esfOrganizzationFinal = new ArrayList<ESFOrganization>();

		try {
			if (organizationId <= 0)
				return associations;

			Organization organization = OrganizationLocalServiceUtil
					.getOrganization(organizationId);

			List<Organization> childOrganizations = organization
					.getDescendants();

			if (childOrganizations.isEmpty()) {
				ESFOrganization esfOrganization = ESFOrganizationLocalServiceUtil
						.fetchESFOrganization(organization.getOrganizationId());

				associations.add(esfOrganization);

			} else {
				for (Organization child : childOrganizations) {
					ESFOrganization esfOrganization = ESFOrganizationLocalServiceUtil
							.fetchESFOrganization(child.getOrganizationId());

					boolean addOrganization = false;

					if (esfOrganization != null) {

						addOrganization = esfOrganization.getType() == ESFKeys.ESFOrganizationTypeId.ASSOCIATION;

						if (addOrganization) {
							associations.add(esfOrganization);
						}
					}
				}
			}

			List<Long> orgIds = new ArrayList<Long>();

			for (ESFOrganization association : associations) {
				orgIds.add(association.getEsfOrganizationId());
			}

			DynamicQuery orgQuery = DynamicQueryFactoryUtil.forClass(
					ESFOrganization.class, "orgQuery",
					PortletClassLoaderUtil.getClassLoader());

			orgQuery.add(PropertyFactoryUtil.forName(
					"orgQuery.esfOrganizationId").in(orgIds));

			esfOrganizzationFinal = ESFOrganizationLocalServiceUtil
					.dynamicQuery(orgQuery);

		} catch (Exception e) {

		}

		OrderByComparatorFactory orderByComparatorFactory = OrderByComparatorFactoryUtil
				.getOrderByComparatorFactory();
		OrderByComparator orderByComparator = orderByComparatorFactory.create(
				"ESFOrganization", "name", true);
		esfOrganizzationFinal = ListUtil.sort(esfOrganizzationFinal,
				orderByComparator);

		return esfOrganizzationFinal;
	}
	/**
	 * Ricerca tutte le organizzazioni sportive foglie a partire
	 * dall'organizzazione con id = organizationId. Se l'organizationId e' di un
	 * organizzazione foglia, ritorna una lista con solo quella organizzazione.
	 */
	public List<ESFOrganization> findAllLeafOrganizations(long organizationId,String code, String name)
			throws SystemException, PortalException {

		List<ESFOrganization> associations = new ArrayList<ESFOrganization>();
		List<ESFOrganization> esfOrganizzationFinal = new ArrayList<ESFOrganization>();

		try {
			if (organizationId <= 0)
				return associations;

			Organization organization = OrganizationLocalServiceUtil
					.getOrganization(organizationId);

			List<Organization> childOrganizations = organization
					.getDescendants();

			if (childOrganizations.isEmpty()) {
				ESFOrganization esfOrganization = ESFOrganizationLocalServiceUtil
						.fetchESFOrganization(organization.getOrganizationId());

				associations.add(esfOrganization);

			} else {
				for (Organization child : childOrganizations) {
					ESFOrganization esfOrganization = ESFOrganizationLocalServiceUtil
							.fetchESFOrganization(child.getOrganizationId());

					boolean addOrganization = false;

					if (esfOrganization != null) {

						addOrganization = esfOrganization.getType() == ESFKeys.ESFOrganizationTypeId.ASSOCIATION;

						if (addOrganization) {
							associations.add(esfOrganization);
						}
					}
				}
			}

			List<Long> orgIds = new ArrayList<Long>();

			for (ESFOrganization association : associations) {
				orgIds.add(association.getEsfOrganizationId());
			}

			DynamicQuery orgQuery = DynamicQueryFactoryUtil.forClass(
					ESFOrganization.class, "orgQuery",
					PortletClassLoaderUtil.getClassLoader());

			orgQuery.add(PropertyFactoryUtil.forName(
					"orgQuery.esfOrganizationId").in(orgIds));

			esfOrganizzationFinal = ESFOrganizationLocalServiceUtil
					.dynamicQuery(orgQuery);

		} catch (Exception e) {

		}

		OrderByComparatorFactory orderByComparatorFactory = OrderByComparatorFactoryUtil
				.getOrderByComparatorFactory();
		OrderByComparator orderByComparator = orderByComparatorFactory.create(
				"ESFOrganization", "name", true);
		List<ESFOrganization> lastResults = new ArrayList<ESFOrganization>();
		boolean test = Validator.isNotNull(name)||Validator.isNotNull(code);
		
		if(Validator.isNotNull(name))
		{
			for(ESFOrganization eo: esfOrganizzationFinal)
			{
				if(eo.getName().contains(name))
				{
					lastResults.add(eo);
				}
			}
		}
		if(Validator.isNotNull(code))
		{
			for(ESFOrganization eo: esfOrganizzationFinal)
			{
				if(eo.getCode().contains(code))
				{
					if(!lastResults.contains(eo))
					{
						lastResults.add(eo);
					}
				}
			}
			
		}
		if(Validator.isNull(code)&&Validator.isNull(name))
		{
			esfOrganizzationFinal = ListUtil.sort(esfOrganizzationFinal,
					orderByComparator);
			return esfOrganizzationFinal;
		
		}
		else
		{
			lastResults = ListUtil.sort(lastResults,orderByComparator);
			return lastResults;
		}
		
	}
	/**
	 * Ricerca tutte le organizzazioni sportive foglie a partire
	 * dall'organizzazione con id = organizationId. Se l'organizationId � di
	 * un organizzazione foglia, ritorna una lista con solo quella
	 * organizzazione.
	 */
	
	
	/*trovo tutte le associazioni che non hanno i pagamenti di iscrizione annuale completi*/
	public List<ESFOrganization> findAllOrganizationsIncrements(String name, String code,
			int start, int end) throws SystemException, PortalException {
		List<ESFOrganization> esfOrganizations = new ArrayList<ESFOrganization>();
		List<ESFOrganization> esfOrganizationsStartEnd = new ArrayList<ESFOrganization>();
		ESFOrganization esfOrganization = new ESFOrganizationImpl();
		List<ESFRenewal> renewals = new ArrayList<ESFRenewal>();
		boolean isTotal = false;
		String reason = "annual-membership-due-payment";
		renewals = ESFRenewalLocalServiceUtil.findByReason_IsTotal(reason, isTotal);
		
		for(ESFRenewal r : renewals){
			esfOrganization = ESFOrganizationLocalServiceUtil.fetchESFOrganization(r.getOrganizationId());
			if(esfOrganization.getName().toLowerCase().contains(name.toLowerCase()) 
					&& esfOrganization.getCode().toLowerCase().contains(code.toLowerCase()) ){
			esfOrganizations.add(esfOrganization);
			}
		}
		
		if(end > esfOrganizations.size()){
			end = esfOrganizations.size();
		}
		
		esfOrganizationsStartEnd = esfOrganizations.subList(start, end);
		
		return esfOrganizationsStartEnd;
	}
	
	public int findAllOrganizationsIncrements(String name, String code) throws SystemException, PortalException {
		int total = 0;
		List<ESFOrganization> esfOrganizations = new ArrayList<ESFOrganization>();
		ESFOrganization esfOrganization = new ESFOrganizationImpl();
		List<ESFRenewal> renewals = new ArrayList<ESFRenewal>();
		boolean isTotal = false;
		String reason = "annual-membership-due-payment";
		renewals = ESFRenewalLocalServiceUtil.findByReason_IsTotal(reason, isTotal);
		
		for(ESFRenewal r : renewals){
			esfOrganization = ESFOrganizationLocalServiceUtil.fetchESFOrganization(r.getOrganizationId());
			if(esfOrganization.getName().toLowerCase().contains(name.toLowerCase()) 
					&& esfOrganization.getCode().toLowerCase().contains(code.toLowerCase()) ){
			esfOrganizations.add(esfOrganization);
			}
		}
		total = esfOrganizations.size();
		
		return total;
	}
	
	
	
	
	public List<ESFOrganization> findAllLeafOrganizations(long organizationId,
			int start, int end) throws SystemException, PortalException {

		List<ESFOrganization> associations = new ArrayList<ESFOrganization>();
		List<ESFOrganization> esfOrganizzationFinal = new ArrayList<ESFOrganization>();

		try {
			if (organizationId <= 0)
				return associations;

			Organization organization = OrganizationLocalServiceUtil
					.getOrganization(organizationId);

			List<Organization> childOrganizations = organization
					.getDescendants();

			if (childOrganizations.isEmpty()) {
				ESFOrganization esfOrganization = ESFOrganizationLocalServiceUtil
						.fetchESFOrganization(organization.getOrganizationId());

				associations.add(esfOrganization);

			} else {
				for (Organization child : childOrganizations) {
					ESFOrganization esfOrganization = ESFOrganizationLocalServiceUtil
							.fetchESFOrganization(child.getOrganizationId());

					boolean addOrganization = false;

					if (esfOrganization != null) {

						addOrganization = esfOrganization.getType() == ESFKeys.ESFOrganizationTypeId.ASSOCIATION;

						if (addOrganization) {
							associations.add(esfOrganization);
						}
					}
				}
			}

			List<Long> orgIds = new ArrayList<Long>();

			for (ESFOrganization association : associations) {
				orgIds.add(association.getEsfOrganizationId());
			}

			DynamicQuery orgQuery = DynamicQueryFactoryUtil.forClass(
					ESFOrganization.class, "orgQuery",
					PortletClassLoaderUtil.getClassLoader());

			orgQuery.add(PropertyFactoryUtil.forName(
					"orgQuery.esfOrganizationId").in(orgIds));

			esfOrganizzationFinal = ESFOrganizationLocalServiceUtil
					.dynamicQuery(orgQuery, start, end);

		} catch (Exception e) {

		}
		OrderByComparatorFactory orderByComparatorFactory = OrderByComparatorFactoryUtil
				.getOrderByComparatorFactory();
		OrderByComparator orderByComparator = orderByComparatorFactory.create(
				"ESFOrganization", "name", true);
		esfOrganizzationFinal = ListUtil.sort(esfOrganizzationFinal,
				orderByComparator);
		return esfOrganizzationFinal;
	}
	/**
	 * Ricerca tutte le organizzazioni sportive foglie a partire
	 * dall'organizzazione con id = organizationId. Se l'organizationId � di
	 * un organizzazione foglia, ritorna una lista con solo quella
	 * organizzazione.
	 */
	public List<ESFOrganization> findAllLeafOrganizations(long organizationId,String code,String name,
			int start, int end) throws SystemException, PortalException {

		List<ESFOrganization> associations = new ArrayList<ESFOrganization>();
		List<ESFOrganization> esfOrganizzationFinal = new ArrayList<ESFOrganization>();

		try {
			if (organizationId <= 0)
				return associations;

			Organization organization = OrganizationLocalServiceUtil
					.getOrganization(organizationId);

			List<Organization> childOrganizations = organization
					.getDescendants();

			if (childOrganizations.isEmpty()) {
				ESFOrganization esfOrganization = ESFOrganizationLocalServiceUtil
						.fetchESFOrganization(organization.getOrganizationId());

				associations.add(esfOrganization);

			} else {
				for (Organization child : childOrganizations) {
					ESFOrganization esfOrganization = ESFOrganizationLocalServiceUtil
							.fetchESFOrganization(child.getOrganizationId());

					boolean addOrganization = false;

					if (esfOrganization != null) {

						addOrganization = esfOrganization.getType() == ESFKeys.ESFOrganizationTypeId.ASSOCIATION;

						if (addOrganization) {
							associations.add(esfOrganization);
						}
					}
				}
			}

			List<Long> orgIds = new ArrayList<Long>();

			for (ESFOrganization association : associations) {
				orgIds.add(association.getEsfOrganizationId());
			}

			DynamicQuery orgQuery = DynamicQueryFactoryUtil.forClass(
					ESFOrganization.class, "orgQuery",
					PortletClassLoaderUtil.getClassLoader());

			orgQuery.add(PropertyFactoryUtil.forName(
					"orgQuery.esfOrganizationId").in(orgIds));

			esfOrganizzationFinal = ESFOrganizationLocalServiceUtil
					.dynamicQuery(orgQuery, start, end);

		} catch (Exception e) {

		}
		OrderByComparatorFactory orderByComparatorFactory = OrderByComparatorFactoryUtil
				.getOrderByComparatorFactory();
		OrderByComparator orderByComparator = orderByComparatorFactory.create(
				"ESFOrganization", "name", true);
		//esfOrganizzationFinal = ListUtil.sort(esfOrganizzationFinal,
		//		orderByComparator);
		List<ESFOrganization> lastResults = new ArrayList<ESFOrganization>();
		boolean test = Validator.isNotNull(name)||Validator.isNotNull(code);
		
		if(Validator.isNotNull(name))
		{
			for(ESFOrganization eo: esfOrganizzationFinal)
			{
				if(eo.getName().contains(name))
				{
					
					lastResults.add(eo);
				}
			}
		}
		if(Validator.isNotNull(code))
		{
			for(ESFOrganization eo: esfOrganizzationFinal)
			{
				if(eo.getCode().contains(code))
				{
					if(!lastResults.contains(eo))
					{
						lastResults.add(eo);
					}
				}
			}
			
		}
		
		if(Validator.isNull(code)&&Validator.isNull(name))
		{
			esfOrganizzationFinal = ListUtil.sort(esfOrganizzationFinal,
					orderByComparator);
			return esfOrganizzationFinal;
			
		}
		else
		{
			lastResults = ListUtil.sort(lastResults,
					orderByComparator);
			return lastResults;
		}
		
	}

	/**
	 * Ricerca tutte le organizzazioni sportive foglie a partire
	 * dall'organizzazione con id = organizationId con stato pari a state. Se
	 * l'organizationId � di un organizzazione foglia, ritorna una lista con
	 * solo quella organizzazione.
	 */
	public List<ESFOrganization> findAllLeafOrganizations(long organizationId,
			int state) throws SystemException, PortalException {

		List<ESFOrganization> associations = new ArrayList<ESFOrganization>();
		List<ESFOrganization> esfOrganizzationFinal = new ArrayList<ESFOrganization>();

		try {
			if (organizationId <= 0)
				return associations;

			Organization organization = OrganizationLocalServiceUtil
					.getOrganization(organizationId);

			List<Organization> childOrganizations = organization
					.getDescendants();

			if (childOrganizations.isEmpty()) {
				ESFOrganization esfOrganization = ESFOrganizationLocalServiceUtil
						.fetchESFOrganization(organization.getOrganizationId());

				associations.add(esfOrganization);

			} else {
				for (Organization child : childOrganizations) {
					ESFOrganization esfOrganization = ESFOrganizationLocalServiceUtil
							.fetchESFOrganization(child.getOrganizationId());

					boolean addOrganization = false;

					if (esfOrganization != null) {

						addOrganization = esfOrganization.getType() == ESFKeys.ESFOrganizationTypeId.ASSOCIATION;

						if (addOrganization) {
							associations.add(esfOrganization);
						}
					}
				}
			}

			List<Long> orgIds = new ArrayList<Long>();

			List<ESFOrganization> esfOrgsByState = ESFOrganizationLocalServiceUtil
					.getAllEsfOrganizationByState(state);

			for (ESFOrganization esfOrgByState : esfOrgsByState) {
				for (ESFOrganization association : associations) {
					if (esfOrgByState.getEsfOrganizationId() == association
							.getEsfOrganizationId()) {
						orgIds.add(esfOrgByState.getEsfOrganizationId());
					}
				}
			}

			DynamicQuery orgQuery = DynamicQueryFactoryUtil.forClass(
					ESFOrganization.class, "orgQuery",
					PortletClassLoaderUtil.getClassLoader());

			orgQuery.add(PropertyFactoryUtil.forName(
					"orgQuery.esfOrganizationId").in(orgIds));

			esfOrganizzationFinal = ESFOrganizationLocalServiceUtil
					.dynamicQuery(orgQuery);

		} catch (Exception e) {

		}

		return esfOrganizzationFinal;
	}

	/**
	 * Ricerca tutte le organizzazioni sportive foglie a partire
	 * dall'organizzazione con id = organizationId con stato pari a state. Se
	 * l'organizationId � di un organizzazione foglia, ritorna una lista con
	 * solo quella organizzazione.
	 */
	public List<ESFOrganization> findAllLeafOrganizations(long organizationId,
			int state, int start, int end) throws SystemException,
			PortalException {

		List<ESFOrganization> associations = new ArrayList<ESFOrganization>();
		List<ESFOrganization> esfOrganizzationFinal = new ArrayList<ESFOrganization>();

		try {

			if (organizationId <= 0)
				return associations;

			Organization organization = OrganizationLocalServiceUtil
					.getOrganization(organizationId);

			List<Organization> childOrganizations = organization
					.getDescendants();

			if (childOrganizations.isEmpty()) {
				ESFOrganization esfOrganization = ESFOrganizationLocalServiceUtil
						.fetchESFOrganization(organization.getOrganizationId());

				associations.add(esfOrganization);

			} else {
				for (Organization child : childOrganizations) {
					ESFOrganization esfOrganization = ESFOrganizationLocalServiceUtil
							.fetchESFOrganization(child.getOrganizationId());

					boolean addOrganization = false;

					if (esfOrganization != null) {

						addOrganization = esfOrganization.getType() == ESFKeys.ESFOrganizationTypeId.ASSOCIATION;

						if (addOrganization) {
							associations.add(esfOrganization);
						}
					}
				}
			}

			List<Long> orgIds = new ArrayList<Long>();

			List<ESFOrganization> esfOrgsByState = ESFOrganizationLocalServiceUtil
					.getAllEsfOrganizationByState(state);

			for (ESFOrganization esfOrgByState : esfOrgsByState) {
				for (ESFOrganization association : associations) {
					if (esfOrgByState.getEsfOrganizationId() == association
							.getEsfOrganizationId()) {
						orgIds.add(esfOrgByState.getEsfOrganizationId());
					}
				}
			}

			DynamicQuery orgQuery = DynamicQueryFactoryUtil.forClass(
					ESFOrganization.class, "orgQuery",
					PortletClassLoaderUtil.getClassLoader());

			orgQuery.add(PropertyFactoryUtil.forName(
					"orgQuery.esfOrganizationId").in(orgIds));

			esfOrganizzationFinal = ESFOrganizationLocalServiceUtil
					.dynamicQuery(orgQuery, start, end);

		} catch (Exception e) {

		}

		return esfOrganizzationFinal;
	}

	/**
	 * Ricerca tutte le organizzazioni sportive figlie a partire
	 * dall'organizzazione con id = organizationId
	 */
	public List<ESFOrganization> findAllChildOrganizations(long organizationId)
			throws SystemException, PortalException {

		int type = 0;

		List<ESFOrganization> associations = new ArrayList<ESFOrganization>();
		List<ESFOrganization> esfOrganizzationFinal = new ArrayList<ESFOrganization>();

		try {
			if (organizationId <= 0)
				return associations;

			Organization organization = OrganizationLocalServiceUtil
					.getOrganization(organizationId);

			ESFOrganization esfOrganization = ESFOrganizationLocalServiceUtil
					.fetchESFOrganization(organizationId);

			if (esfOrganization != null)
				type = esfOrganization.getType();

			List<Organization> childOrganizations = organization
					.getDescendants();

			for (Organization child : childOrganizations) {

				ESFOrganization esfChildOrganization = ESFOrganizationLocalServiceUtil
						.fetchESFOrganization(child.getOrganizationId());

				boolean addOrganization = false;

				if (esfChildOrganization != null) {

					addOrganization = esfChildOrganization.getType() == type + 1;

					if (addOrganization) {

						associations.add(esfChildOrganization);
					}
				}
			}

			List<Long> orgIds = new ArrayList<Long>();

			for (ESFOrganization association : associations) {

				orgIds.add(association.getEsfOrganizationId());

			}
			
		/*	DynamicQuery orgQuery = DynamicQueryFactoryUtil.forClass(
					ESFOrganization.class, "orgQuery",
					PortletClassLoaderUtil.getClassLoader());

			orgQuery.add(PropertyFactoryUtil.forName(
					"orgQuery.esfOrganizationId").in(orgIds));

			esfOrganizzationFinal = ESFOrganizationLocalServiceUtil
					.dynamicQuery(orgQuery);*/
			esfOrganizzationFinal = associations;

		} catch (Exception e) {

		}
		
		OrderByComparatorFactory orderByComparatorFactory = OrderByComparatorFactoryUtil
				.getOrderByComparatorFactory();
		OrderByComparator orderByComparator = orderByComparatorFactory.create(
				"ESFOrganization", "name", true);
		esfOrganizzationFinal = ListUtil.sort(esfOrganizzationFinal,
				orderByComparator);

		return esfOrganizzationFinal;
	}

	/**
	 * Ricerca tutte le organizzazioni sportive figlie a partire
	 * dall'organizzazione con id = organizationId
	 */
	public List<ESFOrganization> findAllChildOrganizations(long organizationId,
			int start, int end) throws SystemException, PortalException {

		int type = 0;

		List<ESFOrganization> associations = new ArrayList<ESFOrganization>();
		List<ESFOrganization> esfOrganizzationFinal = new ArrayList<ESFOrganization>();

		try {
			if (organizationId <= 0)
				return associations;

			Organization organization = OrganizationLocalServiceUtil
					.getOrganization(organizationId);

			ESFOrganization esfOrganization = ESFOrganizationLocalServiceUtil
					.fetchESFOrganization(organizationId);

			if (esfOrganization != null)
				type = esfOrganization.getType();

			List<Organization> childOrganizations = organization
					.getDescendants();

			for (Organization child : childOrganizations) {

				ESFOrganization esfChildOrganization = ESFOrganizationLocalServiceUtil
						.fetchESFOrganization(child.getOrganizationId());

				boolean addOrganization = false;

				if (esfChildOrganization != null) {

					addOrganization = esfChildOrganization.getType() == type + 1;

					if (addOrganization) {

						associations.add(esfChildOrganization);
					}
				}
			}

			List<Long> orgIds = new ArrayList<Long>();

			for (ESFOrganization association : associations) {

				orgIds.add(association.getEsfOrganizationId());

			}

			DynamicQuery orgQuery = DynamicQueryFactoryUtil.forClass(
					ESFOrganization.class, "orgQuery",
					PortletClassLoaderUtil.getClassLoader());

			orgQuery.add(PropertyFactoryUtil.forName(
					"orgQuery.esfOrganizationId").in(orgIds));

			esfOrganizzationFinal = ESFOrganizationLocalServiceUtil
					.dynamicQuery(orgQuery, start, end);

		} catch (Exception e) {

		}
		OrderByComparatorFactory orderByComparatorFactory = OrderByComparatorFactoryUtil
				.getOrderByComparatorFactory();
		OrderByComparator orderByComparator = orderByComparatorFactory.create(
				"ESFOrganization", "name", true);
		esfOrganizzationFinal = ListUtil.sort(esfOrganizzationFinal,
				orderByComparator);
		return esfOrganizzationFinal;
	}

	/**
	 * Ricerca tutte le organizzazioni sportive figlie a partire
	 * dall'organizzazione con id = organizationId che ha uno stato pari a
	 * state.
	 */
	public List<ESFOrganization> findAllChildOrganizations(long organizationId,
			int state) throws SystemException, PortalException {

		int type = 0;

		List<ESFOrganization> associations = new ArrayList<ESFOrganization>();
		List<ESFOrganization> esfOrganizzationFinal = new ArrayList<ESFOrganization>();

		try {
			if (organizationId <= 0)
				return associations;

			Organization organization = OrganizationLocalServiceUtil
					.getOrganization(organizationId);

			ESFOrganization esfOrganization = ESFOrganizationLocalServiceUtil
					.fetchESFOrganization(organizationId);

			if (esfOrganization != null)
				type = esfOrganization.getType();

			List<Organization> childOrganizations = organization
					.getDescendants();

			for (Organization child : childOrganizations) {

				ESFOrganization esfChildOrganization = ESFOrganizationLocalServiceUtil
						.fetchESFOrganization(child.getOrganizationId());

				boolean addOrganization = false;

				if (esfChildOrganization != null) {

					addOrganization = esfChildOrganization.getType() == type + 1;

					if (addOrganization) {

						associations.add(esfChildOrganization);
					}
				}
			}

			List<Long> orgIds = new ArrayList<Long>();

			List<ESFOrganization> esfOrgsByState = ESFOrganizationLocalServiceUtil
					.getAllEsfOrganizationByState(state);

			for (ESFOrganization esfOrgByState : esfOrgsByState) {
				for (ESFOrganization association : associations) {
					if (esfOrgByState.getEsfOrganizationId() == association
							.getEsfOrganizationId()) {
						orgIds.add(esfOrgByState.getEsfOrganizationId());
					}
				}
			}

			DynamicQuery orgQuery = DynamicQueryFactoryUtil.forClass(
					ESFOrganization.class, "orgQuery",
					PortletClassLoaderUtil.getClassLoader());

			orgQuery.add(PropertyFactoryUtil.forName(
					"orgQuery.esfOrganizationId").in(orgIds));

			esfOrganizzationFinal = ESFOrganizationLocalServiceUtil
					.dynamicQuery(orgQuery);

		} catch (Exception e) {

		}
		OrderByComparatorFactory orderByComparatorFactory = OrderByComparatorFactoryUtil
				.getOrderByComparatorFactory();
		OrderByComparator orderByComparator = orderByComparatorFactory.create(
				"ESFOrganization", "name", true);
		esfOrganizzationFinal = ListUtil.sort(esfOrganizzationFinal,
				orderByComparator);
		return esfOrganizzationFinal;
	}

	/**
	 * Ricerca tutte le organizzazioni sportive figlie a partire
	 * dall'organizzazione con id = organizationId che ha uno stato pari a
	 * state.
	 */
	public List<ESFOrganization> findAllChildOrganizations(long organizationId,
			int state, int start, int end) throws SystemException,
			PortalException {

		int type = 0;
		List<ESFOrganization> associations = new ArrayList<ESFOrganization>();
		List<ESFOrganization> esfOrganizzationFinal = new ArrayList<ESFOrganization>();

		try {
			if (organizationId <= 0)
				return associations;

			Organization organization = OrganizationLocalServiceUtil
					.getOrganization(organizationId);
			ESFOrganization esfOrganization = ESFOrganizationLocalServiceUtil
					.fetchESFOrganization(organizationId);
			if (esfOrganization != null)
				type = esfOrganization.getType();
			List<Organization> childOrganizations = organization
					.getDescendants();
			for (Organization child : childOrganizations) {

				ESFOrganization esfChildOrganization = ESFOrganizationLocalServiceUtil
						.fetchESFOrganization(child.getOrganizationId());

				boolean addOrganization = false;

				if (esfChildOrganization != null) {

					addOrganization = esfChildOrganization.getType() == type + 1;

					if (addOrganization) {

						associations.add(esfChildOrganization);
					}
				}
			}
			List<Long> orgIds = new ArrayList<Long>();

			List<ESFOrganization> esfOrgsByState = ESFOrganizationLocalServiceUtil
					.getAllEsfOrganizationByState(state);

			for (ESFOrganization esfOrgByState : esfOrgsByState) {
				for (ESFOrganization association : associations) {
					if (esfOrgByState.getEsfOrganizationId() == association
							.getEsfOrganizationId()) {
						orgIds.add(esfOrgByState.getEsfOrganizationId());
					}
				}
			}

			DynamicQuery orgQuery = DynamicQueryFactoryUtil.forClass(
					ESFOrganization.class, "orgQuery",
					PortletClassLoaderUtil.getClassLoader());

			orgQuery.add(PropertyFactoryUtil.forName(
					"orgQuery.esfOrganizationId").in(orgIds));

			esfOrganizzationFinal = ESFOrganizationLocalServiceUtil
					.dynamicQuery(orgQuery, start, end);
			
		} catch (Exception e) {

		}
		OrderByComparatorFactory orderByComparatorFactory = OrderByComparatorFactoryUtil
				.getOrderByComparatorFactory();
		OrderByComparator orderByComparator = orderByComparatorFactory.create(
				"ESFOrganization", "name", true);
		esfOrganizzationFinal = ListUtil.sort(esfOrganizzationFinal,
				orderByComparator);
		return esfOrganizzationFinal;
	}

	/**
	 * Ricerca tutte le organizzazioni sportive con pagamento del rinnovo effettuato per l'anno specificato
	 */
	public List<ESFOrganization> findByPaymentYear(int year, int start, int end) throws SystemException,
			PortalException {

		List<ESFOrganization> associations = new ArrayList<ESFOrganization>();
		List<ESFRenewal> renewals = esfRenewalPersistence.findByPaymentReceived(Boolean.TRUE, start, end);
		if(renewals.size() > 0){
			for(ESFRenewal renewal : renewals){
				ESFOrganization organization = esfOrganizationPersistence.fetchByPrimaryKey(renewal.getOrganizationId());
				if(organization != null){
					associations.add(organization);
				}
			}
		}
		return associations;
	}

	/**
	 * Ricerca tutte le organizzazioni sportive con pagamento del rinnovo effettuato per l'anno specificato
	 */
	public int countByPaymentYear(int year) throws SystemException,
			PortalException {

		int result = 0;
		List<ESFRenewal> renewals = esfRenewalPersistence.findByPaymentReceived(Boolean.TRUE, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		if(renewals.size() > 0){
			result = renewals.size();
		}
		return result;
	}

	public List<ESFOrganization> getAllEsfOrganizationByState(int state) {
		
		List<ESFOrganization> esfOrganizations = new ArrayList<ESFOrganization>();

		try {
			List<ESFEntityState> entityStates = ESFEntityStateLocalServiceUtil
					.findESFEntityStateByC_S(ESFOrganization.class.getName(),
							state);

			long[] classPKs = new long[entityStates.size()];

			int i = 0;

			for (ESFEntityState entityState : entityStates) {
				classPKs[i] = entityState.getClassPK();
				i++;
				
			}

			DynamicQuery organizationQuery = DynamicQueryFactoryUtil.forClass(
					ESFOrganization.class, "organizationQuery",
					PortletClassLoaderUtil.getClassLoader());

			organizationQuery.add(PropertyFactoryUtil.forName(
					"organizationQuery.esfOrganizationId").in(classPKs));

			esfOrganizations = ESFOrganizationLocalServiceUtil
					.dynamicQuery(organizationQuery);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return esfOrganizations;
	}

	public List<ESFOrganization> getAllEsfOrganizationByState(int state,
			int start, int end) {

		List<ESFOrganization> esfOrganizations = new ArrayList<ESFOrganization>();

		try {
			List<ESFEntityState> entityStates = ESFEntityStateLocalServiceUtil
					.findESFEntityStateByC_S(ESFOrganization.class.getName(),
							state);

			long[] classPKs = new long[entityStates.size()];

			int i = 0;

			for (ESFEntityState entityState : entityStates) {
				classPKs[i] = entityState.getClassPK();
				i++;
			}

			DynamicQuery organizationQuery = DynamicQueryFactoryUtil.forClass(
					ESFOrganization.class, "organizationQuery",
					PortletClassLoaderUtil.getClassLoader());

			organizationQuery.add(PropertyFactoryUtil.forName(
					"organizationQuery.esfOrganizationId").in(classPKs));

			esfOrganizations = ESFOrganizationLocalServiceUtil.dynamicQuery(
					organizationQuery, start, end);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return esfOrganizations;
	}
public int getAllEsfOrganizationDisabled(String name, String code ) throws PortalException, SystemException {
		
		List<ESFOrganization> esfOrganizations = new ArrayList<ESFOrganization>();
		List<ESFOrganization> esfOrganizationsNamed = new ArrayList<ESFOrganization>();
		List<ESFEntityState>entity = new ArrayList<ESFEntityState>();
		int state = ESFKeys.ESFStateType.DISABLE;
		int tot = 0;
		long type = ESFKeys.ESFOrganizationTypeId.ASSOCIATION;
		String className = "it.ethica.esf.model.ESFOrganization";
		entity = ESFEntityStateLocalServiceUtil.findESFEntityStateByC_S(className, state);
		
		for(ESFEntityState e : entity){
			esfOrganizations.add(ESFOrganizationLocalServiceUtil.fetchESFOrganization(e.getClassPK()));
		}
		
		for(ESFOrganization o : esfOrganizations){
			try{
			if(o.getName().toLowerCase().contains(name.toLowerCase()) 
					&& o.getCode().toLowerCase().contains(code.toLowerCase())
						&& o.getType() == ESFKeys.ESFOrganizationTypeId.ASSOCIATION){
				esfOrganizationsNamed.add(o);
			}
			} catch (Exception e){
				_log.error ("errore org -->");
			}
		}
		tot=esfOrganizationsNamed.size();
		return tot;
	}

	public List<ESFOrganization> getAllEsfOrganizationDisabledStartEnd(String name, String code,
			int start, int end) throws PortalException, SystemException {

		
		
		List<ESFOrganization> esfOrganizations = new ArrayList<ESFOrganization>();
		List<ESFOrganization> esfOrganizationsDisable = new ArrayList<ESFOrganization>();
		List<ESFOrganization> esfOrganizationsNamed = new ArrayList<ESFOrganization>();
		List<ESFEntityState>entity = new ArrayList<ESFEntityState>();
		int state = ESFKeys.ESFStateType.DISABLE;
		int endOrg = end;
		long type = ESFKeys.ESFOrganizationTypeId.ASSOCIATION;
		String className = "it.ethica.esf.model.ESFOrganization";
		
		entity = ESFEntityStateLocalServiceUtil.findESFEntityStateByC_S(className, state);
	
		for(ESFEntityState e : entity){
			esfOrganizationsDisable.add(ESFOrganizationLocalServiceUtil.fetchESFOrganization(e.getClassPK()));
			

		}
		for(ESFOrganization o : esfOrganizationsDisable){
			try {
			if(o.getName().toLowerCase().contains(name.toLowerCase()) 
					&& o.getCode().toLowerCase().contains(code.toLowerCase())
						&& o.getType() == ESFKeys.ESFOrganizationTypeId.ASSOCIATION){
				esfOrganizationsNamed.add(o);
			}
			} catch (Exception e){
				_log.error ("errore org -->");
			}
		}
		if(end > esfOrganizationsNamed.size()){
			endOrg = esfOrganizationsNamed.size(); 
		}
		
		esfOrganizations = esfOrganizationsNamed.subList(start, endOrg);
				
		return esfOrganizations;
	}


	public ESFOrganization deleteESFOrganization(long esfOrganizationId,
			ServiceContext serviceContext) throws PortalException,
			SystemException {

		ESFOrganization esfOrganization = getESFOrganization(esfOrganizationId);

		resourceLocalService.deleteResource(serviceContext.getCompanyId(),
				ESFOrganization.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, esfOrganizationId);

		deleteESFOrganization(esfOrganizationId);

		organizationLocalService.deleteOrganization(esfOrganizationId);

		List<Address> addresses = AddressLocalServiceUtil.getAddresses(
				serviceContext.getCompanyId(), Organization.class.getName(),
				esfOrganizationId);
		for (Address address : addresses) {
			esfAddressLocalService.deleteESFAddress(address.getAddressId());
		}

		List<ESFField> esfFields = esfFieldPersistence
				.findByOwnerOrganizationId(esfOrganizationId);

		for (ESFField esfField : esfFields) {
			esfFieldLocalService.deleteESFField(esfField.getEsfFieldId());
		}

		return esfOrganization;
	}


	public void updateESFOrganitazionESFCard(long esfOrganizationId,
			long esfCardId) throws SystemException, PortalException {

		ESFCard esfCard = esfCardPersistence.findByPrimaryKey(esfCardId);
		esfCard.setEsfOrganizationId(esfOrganizationId);
		esfCardPersistence.update(esfCard);

	}

	public void updateOnlyESFOrganitazionState(long esfOrganizationId,
			ServiceContext serviceContext) throws SystemException,
			PortalException {

		ESFEntityState esfEntityStateFromDB = ESFEntityStateLocalServiceUtil
				.findESFEntityStateByC_PK(ESFOrganization.class.getName(),
						esfOrganizationId);

		if (esfEntityStateFromDB != null
				&& esfEntityStateFromDB.getEsfStateId() == ESFKeys.ESFStateType.ENABLE) {

			ESFEntityStateLocalServiceUtil.updateEntityState(
					serviceContext.getUserId(),
					esfEntityStateFromDB.getEsfEntityStateId(), serviceContext);

			ESFEntityStateLocalServiceUtil.addEntityState(
					serviceContext.getUserId(),
					ESFOrganization.class.getName(), esfOrganizationId,
					ESFKeys.ESFStateType.DISABLE, serviceContext);
		}
	}

	protected List<ESFOrganization> dynamicQuery(List<Long> orgIds,
			String orderBy) {

		List<Organization> organizations = new ArrayList<Organization>();

		List<ESFOrganization> esfOrganizzationFinal = new ArrayList<ESFOrganization>();

		try {
			DynamicQuery orgQuery = DynamicQueryFactoryUtil.forClass(
					Organization.class, "orgQuery",
					PortletClassLoaderUtil.getClassLoader());

			orgQuery.add(PropertyFactoryUtil.forName("orgQuery.organizationId")
					.in(orgIds));

			orgQuery.addOrder(OrderFactoryUtil.asc(orderBy));

			organizations = OrganizationLocalServiceUtil.dynamicQuery(orgQuery);

			List<Long> orgTmpIds = new ArrayList<Long>();

			for (Organization organization : organizations) {
				orgTmpIds.add(organization.getOrganizationId());
			}

			DynamicQuery esfOrgQuery = DynamicQueryFactoryUtil.forClass(
					ESFOrganization.class, "esfOrgQuery",
					PortletClassLoaderUtil.getClassLoader());

			esfOrgQuery.add(PropertyFactoryUtil.forName(
					"esfOrgQuery.esfOrganizationId").in(orgTmpIds));

			esfOrganizzationFinal = ESFOrganizationLocalServiceUtil
					.dynamicQuery(esfOrgQuery);
		} catch (Exception e) {

		}

		return esfOrganizzationFinal;
	}

	protected List<ESFOrganization> dynamicQuery(List<Long> orgIds,
			String orderBy, int start, int end) {

		List<Organization> organizations = new ArrayList<Organization>();

		List<ESFOrganization> esfOrganizzationFinal = new ArrayList<ESFOrganization>();

		try {
			DynamicQuery orgQuery = DynamicQueryFactoryUtil.forClass(
					Organization.class, "orgQuery",
					PortletClassLoaderUtil.getClassLoader());

			orgQuery.add(PropertyFactoryUtil.forName("orgQuery.organizationId")
					.in(orgIds));

			orgQuery.addOrder(OrderFactoryUtil.asc(orderBy));

			organizations = OrganizationLocalServiceUtil.dynamicQuery(orgQuery);

			List<Long> orgTmpIds = new ArrayList<Long>();

			for (Organization organization : organizations) {
				orgTmpIds.add(organization.getOrganizationId());
			}

			DynamicQuery esfOrgQuery = DynamicQueryFactoryUtil.forClass(
					ESFOrganization.class, "esfOrgQuery",
					PortletClassLoaderUtil.getClassLoader());

			esfOrgQuery.add(PropertyFactoryUtil.forName(
					"esfOrgQuery.esfOrganizationId").in(orgTmpIds));

			esfOrganizzationFinal = ESFOrganizationLocalServiceUtil
					.dynamicQuery(esfOrgQuery, start, end);
		} catch (Exception e) {

		}

		return esfOrganizzationFinal;
	}

	protected void validate(String name) throws PortalException {

		if (Validator.isNull(name)) {
			throw new ESFOrganizationNameException();
		}
	}

	protected boolean validate(long id) throws PortalException {

		if (Validator.isNull(id)) {
			return false;
		}
		return true;
	}

	protected void validateType(long organizationType) throws PortalException {

		if (Validator.isNull(organizationType)) {

			throw new ESFOrganizationTypeException(
					"No ESFOrganization type found or his value is incorrect");
		}

		if (organizationType + 1 > ESFKeys.ESFOrganizationTypeLabel.length) {

			throw new ESFOrganizationTypeException(
					"This value ["
							+ organizationType
							+ "] is too high to have a children. Update ESFKeys.ESFOrganizationType and ESFKeys.ESFOrganizationTypeLabel and try again.");
		}
	}
	
	public String getNameT(ESFOrganization esfOrganization) 
			throws PortalException, SystemException{
		ListType type=ListTypeServiceUtil.getListType((int) esfOrganization.getVariations());
			
			return type.getName();
	}
	
	public List<ESFOrganization> findByT_C_N(Long organizationType, String code, String name, Long orgId,
				int start, int end)throws SystemException, Exception {
		List<ESFOrganization> esfOrganizzations = new ArrayList<ESFOrganization>();
		List<ESFOrganization> organizzation = new ArrayList<ESFOrganization>();
		//organizzation = ESFOrganizationLocalServiceUtil.findESFOrganizationsByCode(code);
		organizzation = ESFOrganizationLocalServiceUtil.findAllESFOrganizations(organizationType, ESFKeys.ESFStateType.ENABLE);
		for(ESFOrganization org : organizzation){
			/*if(organizationType == org.getType() && org.getName().toLowerCase().contains(name.toLowerCase())
					&& orgId != org.getEsfOrganizationId()){
				esfOrganizzations.add(org);
			}*/
			
			if( org.getName().toLowerCase().contains(name.toLowerCase())
							&& orgId != org.getEsfOrganizationId() &&	org.getCode().toLowerCase().contains(code.toLowerCase())){
						esfOrganizzations.add(org);
			}
		}
		if(end>esfOrganizzations.size()){
			end = esfOrganizzations.size();
		}
		return esfOrganizzations.subList(start, end);
	}
	
	public int countByT_C_N(Long organizationType, String code, String name, Long orgId)
			throws SystemException, Exception {
		int count = 0;
		List<ESFOrganization> esfOrganizzations = new ArrayList<ESFOrganization>();
		List<ESFOrganization> organizzation = new ArrayList<ESFOrganization>();
		/*organizzation = ESFOrganizationLocalServiceUtil.findESFOrganizationsByCode(code);
		for(ESFOrganization org : organizzation){
			if(organizationType == org.getType() && org.getName().toLowerCase().contains(name.toLowerCase())
					&& orgId != org.getEsfOrganizationId()){
				esfOrganizzations.add(org);
			}
		}*/
		organizzation = ESFOrganizationLocalServiceUtil.findAllESFOrganizations(organizationType, ESFKeys.ESFStateType.ENABLE);
		for(ESFOrganization org : organizzation){
			/*if(organizationType == org.getType() && org.getName().toLowerCase().contains(name.toLowerCase())
					&& orgId != org.getEsfOrganizationId()){
				esfOrganizzations.add(org);
			}*/
			
			if( org.getName().toLowerCase().contains(name.toLowerCase())
							&& orgId != org.getEsfOrganizationId() &&	org.getCode().toLowerCase().contains(code.toLowerCase())){
						esfOrganizzations.add(org);
			}
		}
		count = esfOrganizzations.size();
		return count;
	}
	
	public List<ESFOrganization> findAllAffilationConiReportAndArmy(){
		
		List<ESFOrganization> esfOrganization = new ArrayList<ESFOrganization>();
		esfOrganization = ESFOrganizationFinderUtil.findAllAffilationConiReportAndArmy();
		
		return esfOrganization;
	}
	
	public List<ESFOrganization> findNewAffilationConiReportAndArmy( int year){
		
		List<ESFOrganization> esfOrganization = new ArrayList<ESFOrganization>();
		esfOrganization = ESFOrganizationFinderUtil.findNewAffilationConiReportAndArmy(year);
		
		return esfOrganization;
	}
	
	
	private static Log _log = LogFactoryUtil.getLog(ESFUserAdminPortlet.class);
}