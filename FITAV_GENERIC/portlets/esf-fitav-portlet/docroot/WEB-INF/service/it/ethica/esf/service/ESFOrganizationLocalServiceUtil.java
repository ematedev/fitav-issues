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

package it.ethica.esf.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ESFOrganization. This utility wraps
 * {@link it.ethica.esf.service.impl.ESFOrganizationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Ethica
 * @see ESFOrganizationLocalService
 * @see it.ethica.esf.service.base.ESFOrganizationLocalServiceBaseImpl
 * @see it.ethica.esf.service.impl.ESFOrganizationLocalServiceImpl
 * @generated
 */
public class ESFOrganizationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.ethica.esf.service.impl.ESFOrganizationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the e s f organization to the database. Also notifies the appropriate model listeners.
	*
	* @param esfOrganization the e s f organization
	* @return the e s f organization that was added
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization addESFOrganization(
		it.ethica.esf.model.ESFOrganization esfOrganization)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addESFOrganization(esfOrganization);
	}

	/**
	* Creates a new e s f organization with the primary key. Does not add the e s f organization to the database.
	*
	* @param esfOrganizationId the primary key for the new e s f organization
	* @return the new e s f organization
	*/
	public static it.ethica.esf.model.ESFOrganization createESFOrganization(
		long esfOrganizationId) {
		return getService().createESFOrganization(esfOrganizationId);
	}

	/**
	* Deletes the e s f organization with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfOrganizationId the primary key of the e s f organization
	* @return the e s f organization that was removed
	* @throws PortalException if a e s f organization with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization deleteESFOrganization(
		long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFOrganization(esfOrganizationId);
	}

	/**
	* Deletes the e s f organization from the database. Also notifies the appropriate model listeners.
	*
	* @param esfOrganization the e s f organization
	* @return the e s f organization that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization deleteESFOrganization(
		it.ethica.esf.model.ESFOrganization esfOrganization)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteESFOrganization(esfOrganization);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static it.ethica.esf.model.ESFOrganization fetchESFOrganization(
		long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFOrganization(esfOrganizationId);
	}

	/**
	* Returns the e s f organization matching the UUID and group.
	*
	* @param uuid the e s f organization's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f organization, or <code>null</code> if a matching e s f organization could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization fetchESFOrganizationByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchESFOrganizationByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the e s f organization with the primary key.
	*
	* @param esfOrganizationId the primary key of the e s f organization
	* @return the e s f organization
	* @throws PortalException if a e s f organization with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization getESFOrganization(
		long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFOrganization(esfOrganizationId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the e s f organization matching the UUID and group.
	*
	* @param uuid the e s f organization's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f organization
	* @throws PortalException if a matching e s f organization could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization getESFOrganizationByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFOrganizationByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the e s f organizations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f organizations
	* @param end the upper bound of the range of e s f organizations (not inclusive)
	* @return the range of e s f organizations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganization> getESFOrganizations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFOrganizations(start, end);
	}

	/**
	* Returns the number of e s f organizations.
	*
	* @return the number of e s f organizations
	* @throws SystemException if a system exception occurred
	*/
	public static int getESFOrganizationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getESFOrganizationsCount();
	}

	/**
	* Updates the e s f organization in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfOrganization the e s f organization
	* @return the e s f organization that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static it.ethica.esf.model.ESFOrganization updateESFOrganization(
		it.ethica.esf.model.ESFOrganization esfOrganization)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateESFOrganization(esfOrganization);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static it.ethica.esf.model.ESFOrganization addESFOrganization(
		long userId, long parentOrganizationId, java.lang.String name,
		java.lang.String emailAddress, java.lang.String code,
		java.lang.String vat, java.lang.String fiscalCode,
		java.lang.String ibanCode, java.util.Date establishmentDate,
		java.util.Date closureDate, java.util.Date insertDate,
		java.util.Date coniDate, java.lang.String coniCode,
		java.lang.String legalForm, java.lang.String category,
		java.util.List<it.ethica.esf.model.ESFAddress> esfAddresses,
		java.util.List<it.ethica.esf.model.ESFPhone> esfphones,
		boolean publicLayoutSetPrototypeEnabled,
		boolean privateLayoutSetPrototypeEnabled, boolean isMultiSport,
		java.lang.String description, boolean isYouthActive,
		java.util.Date firstAffiliationDate,
		it.ethica.esf.model.ESFEntityState esfEntityState, long variation,
		long regionCode, boolean constitutiveAct, boolean registeredStatus,
		boolean planimetrySportsStand, boolean certificateFITAV,
		boolean isSimplyOrganizzation, java.lang.String note,
		java.lang.String webSite, boolean addToConiReport,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addESFOrganization(userId, parentOrganizationId, name,
			emailAddress, code, vat, fiscalCode, ibanCode, establishmentDate,
			closureDate, insertDate, coniDate, coniCode, legalForm, category,
			esfAddresses, esfphones, publicLayoutSetPrototypeEnabled,
			privateLayoutSetPrototypeEnabled, isMultiSport, description,
			isYouthActive, firstAffiliationDate, esfEntityState, variation,
			regionCode, constitutiveAct, registeredStatus,
			planimetrySportsStand, certificateFITAV, isSimplyOrganizzation,
			note, webSite, addToConiReport, serviceContext);
	}

	public static it.ethica.esf.model.ESFOrganization addESFOrganization(
		long userId, long parentOrganizationId, java.lang.String name,
		java.lang.String code, java.lang.String vat,
		java.lang.String fiscalCode, java.lang.String ibanCode,
		java.util.Date establishmentDate, java.util.Date closureDate,
		java.util.Date insertDate, java.util.Date coniDate,
		java.lang.String coniCode, java.lang.String legalForm,
		java.lang.String category, boolean publicLayoutSetPrototypeEnabled,
		boolean privateLayoutSetPrototypeEnabled, boolean isMultiSport,
		java.lang.String description, boolean isYouthActive,
		java.util.Date firstAffiliationDate,
		it.ethica.esf.model.ESFEntityState esfEntityState, long variation,
		long regionCode, boolean constitutiveAct, boolean registeredStatus,
		boolean planimetrySportsStand, boolean certificateFITAV,
		boolean isSimplyOrganizzation, java.lang.String note,
		java.lang.String webSite, boolean addToConiReport,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addESFOrganization(userId, parentOrganizationId, name,
			code, vat, fiscalCode, ibanCode, establishmentDate, closureDate,
			insertDate, coniDate, coniCode, legalForm, category,
			publicLayoutSetPrototypeEnabled, privateLayoutSetPrototypeEnabled,
			isMultiSport, description, isYouthActive, firstAffiliationDate,
			esfEntityState, variation, regionCode, constitutiveAct,
			registeredStatus, planimetrySportsStand, certificateFITAV,
			isSimplyOrganizzation, note, webSite, addToConiReport,
			serviceContext);
	}

	public static it.ethica.esf.model.ESFOrganization updateESFOrganization(
		long userId, long esfOrganizationId, long parentOrganizationId,
		java.lang.String name, java.lang.String emailAddress,
		java.lang.String code, java.lang.String vat,
		java.lang.String fiscalCode, java.lang.String ibanCode,
		java.util.Date establishmentDate, java.util.Date closureDate,
		java.util.Date insertDate, java.util.Date coniDate,
		java.lang.String coniCode, java.lang.String legalForm,
		java.lang.String category,
		java.util.List<it.ethica.esf.model.ESFAddress> esfAddresses,
		java.util.List<it.ethica.esf.model.ESFPhone> phones,
		boolean isMultiSport, java.lang.String description,
		boolean isYouthActive, java.util.Date firstAffiliationDate,
		it.ethica.esf.model.ESFEntityState esfEntityState, long variation,
		long regionCode, long idFatherAssociation, boolean constitutiveAct,
		boolean registeredStatus, boolean planimetrySportsStand,
		boolean certificateFITAV, java.lang.String note,
		java.lang.String webSite, boolean addToConiReport,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateESFOrganization(userId, esfOrganizationId,
			parentOrganizationId, name, emailAddress, code, vat, fiscalCode,
			ibanCode, establishmentDate, closureDate, insertDate, coniDate,
			coniCode, legalForm, category, esfAddresses, phones, isMultiSport,
			description, isYouthActive, firstAffiliationDate, esfEntityState,
			variation, regionCode, idFatherAssociation, constitutiveAct,
			registeredStatus, planimetrySportsStand, certificateFITAV, note,
			webSite, addToConiReport, serviceContext);
	}

	public static it.ethica.esf.model.ESFOrganization updateESFOrganization(
		long userId, long esfOrganizationId, long parentOrganizationId,
		java.lang.String name, java.lang.String code, java.lang.String vat,
		java.lang.String fiscalCode, java.lang.String ibanCode,
		java.util.Date establishmentDate, java.util.Date closureDate,
		java.util.Date insertDate, java.util.Date coniDate,
		java.lang.String coniCode, java.lang.String legalForm,
		java.lang.String category, boolean isMultiSport,
		java.lang.String description, boolean isYouthActive,
		java.util.Date firstAffiliationDate,
		it.ethica.esf.model.ESFEntityState esfEntityState, long variation,
		long regionCode, long idFatherAssociation, boolean constitutiveAct,
		boolean registeredStatus, boolean planimetrySportsStand,
		boolean certificateFITAV, java.lang.String note,
		java.lang.String webSite, boolean addToConiReport,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateESFOrganization(userId, esfOrganizationId,
			parentOrganizationId, name, code, vat, fiscalCode, ibanCode,
			establishmentDate, closureDate, insertDate, coniDate, coniCode,
			legalForm, category, isMultiSport, description, isYouthActive,
			firstAffiliationDate, esfEntityState, variation, regionCode,
			idFatherAssociation, constitutiveAct, registeredStatus,
			planimetrySportsStand, certificateFITAV, note, webSite,
			addToConiReport, serviceContext);
	}

	public static java.util.List<it.ethica.esf.model.ESFOrganization> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroupId(groupId);
	}

	public static java.util.List<it.ethica.esf.model.ESFOrganization> getByProvinceCode(
		java.lang.String id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByProvinceCode(id);
	}

	public static java.util.List<it.ethica.esf.model.ESFOrganization> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByGroupId(groupId, start, end);
	}

	public static it.ethica.esf.model.ESFOrganization findByCode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCode(code);
	}

	public static it.ethica.esf.model.ESFOrganization getRealOwner(
		long esfStateId, long esfFieldId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRealOwner(esfStateId, esfFieldId);
	}

	/**
	* Ricerca tutte le organizzazioni di tipo <b>type</b>
	*
	* @throws SystemException
	* @throws PortalException
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganization> findAllESFOrganizations(
		long type, int state)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllESFOrganizations(type, state);
	}

	/**
	* Ricerca tutte le organizzazioni il cui code inizia con il pattern
	* indicato da <b>code</b>
	*
	* @param code
	patten di partenza
	* @return List<ESFOrganization>
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganization> findESFOrganizationsByCode(
		java.lang.String code) {
		return getService().findESFOrganizationsByCode(code);
	}

	/**
	* Ricerca tutte le organizzazioni sportive con type = <b>type</b> il cui
	* code inizia con il pattern indicato da <b>code</b>
	*
	* @param code
	patten di partenza
	* @param type
	il tipo dell'organizzazione
	* @return List<ESFOrganization>
	* @throws PortalException
	* @throws SystemException
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganization> findESFOrganizationsByT_C(
		long type, java.lang.String code, int state)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findESFOrganizationsByT_C(type, code, state);
	}

	/**
	* Ricerca tutte le organizzazioni sportive con type = <b>type</b> il cui
	* code inizia con il pattern indicato da <b>code</b>
	*
	* @param code
	patten di partenza
	* @param type
	il tipo dell'organizzazione
	* @return List<ESFOrganization>
	* @throws PortalException
	* @throws SystemException
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganization> findESFOrganizationsByT_C(
		long type, java.lang.String code, int state, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findESFOrganizationsByT_C(type, code, state, start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFOrganization> findESFOrganizationsByT_C_N(
		long type, java.lang.String code, java.lang.String name, int state,
		int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findESFOrganizationsByT_C_N(type, code, name, state, start,
			end);
	}

	public static java.util.List<it.ethica.esf.model.ESFOrganization> findESFOrganizationsByT_C_N(
		long type, java.lang.String code, java.lang.String name, int state)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findESFOrganizationsByT_C_N(type, code, name, state);
	}

	public static java.util.List<it.ethica.esf.model.ESFOrganization> findESFOrganizationsByT_C(
		long type, int state)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findESFOrganizationsByT_C(type, state);
	}

	public static java.util.List<it.ethica.esf.model.ESFOrganization> findESFOrganizationsByT_C(
		long type, int state, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findESFOrganizationsByT_C(type, state, start, end);
	}

	/**
	* Ricerca tutte le organizzazioni sportive foglie a partire
	* dall'organizzazione con id = organizationId il cui code inizia con il
	* pattern indicato da <b>code</b>
	*
	* @param code
	patten di partenza
	* @param organizationId
	id dell'organizzazione
	* @return List<ESFOrganization>
	* @throws PortalException
	* @throws SystemException
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganization> findESFOrganizationsByCode(
		long organizationId, java.lang.String code, int state)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findESFOrganizationsByCode(organizationId, code, state);
	}

	/**
	* Ricerca tutte le organizzazioni sportive foglie a partire
	* dall'organizzazione con id = organizationId il cui code inizia con il
	* pattern indicato da <b>code</b>
	*
	* @param code
	patten di partenza
	* @param organizationId
	id dell'organizzazione
	* @return List<ESFOrganization>
	* @throws PortalException
	* @throws SystemException
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganization> findESFOrganizationsByCode(
		long organizationId, java.lang.String code, int state, int start,
		int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findESFOrganizationsByCode(organizationId, code, state,
			start, end);
	}

	/**
	* Ricerca tutte le organizzazioni di tipologia <b>type</b> a partire
	* dall'organizzazione con id = organizationId
	*
	* @param organizationId
	identificativo dell'organizzazione
	* @param type
	tipologia di organizzazione [Fitav, regione, provincia,
	associazione]
	* @return List<ESFOrganization>
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganization> findESFOrganizationsByO_T(
		long organizationId, long type) {
		return getService().findESFOrganizationsByO_T(organizationId, type);
	}

	public static java.util.List<it.ethica.esf.model.ESFOrganization> findESFOrganizationsByO_T_C_N(
		long organizationId, long type, java.lang.String organizationCode,
		java.lang.String organizationName) {
		return getService()
				   .findESFOrganizationsByO_T_C_N(organizationId, type,
			organizationCode, organizationName);
	}

	public static java.util.List<it.ethica.esf.model.ESFOrganization> findESFOrganizationsByO_T_C_N(
		long organizationId, long type, java.lang.String organizationCode,
		java.lang.String organizationName, int start, int end) {
		return getService()
				   .findESFOrganizationsByO_T_C_N(organizationId, type,
			organizationCode, organizationName, start, end);
	}

	public static java.util.List<it.ethica.esf.model.ESFOrganization> getOrganizzationLeafByLikeN_C(
		java.lang.String name, java.lang.String code,
		long parentOrganizationId, long organizationId) {
		return getService()
				   .getOrganizzationLeafByLikeN_C(name, code,
			parentOrganizationId, organizationId);
	}

	public static java.util.List<it.ethica.esf.model.ESFOrganization> getOrganizzationLeafByLikeN_C(
		java.lang.String name, java.lang.String code,
		long parentOrganizationId, long organizationId, int start, int end) {
		return getService()
				   .getOrganizzationLeafByLikeN_C(name, code,
			parentOrganizationId, organizationId, start, end);
	}

	/**
	* Ricerca tutte le organizzazioni sportive foglie a partire
	* dall'organizzazione con id = organizationId. Se l'organizationId e' di un
	* organizzazione foglia, ritorna una lista con solo quella organizzazione.
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganization> findAllLeafOrganizations(
		long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllLeafOrganizations(organizationId);
	}

	/**
	* Ricerca tutte le organizzazioni sportive foglie a partire
	* dall'organizzazione con id = organizationId. Se l'organizationId e' di un
	* organizzazione foglia, ritorna una lista con solo quella organizzazione.
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganization> findAllLeafOrganizations(
		long organizationId, java.lang.String code, java.lang.String name)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllLeafOrganizations(organizationId, code, name);
	}

	/**
	* Ricerca tutte le organizzazioni sportive foglie a partire
	* dall'organizzazione con id = organizationId. Se l'organizationId Ã¯Â¿Â½ di
	* un organizzazione foglia, ritorna una lista con solo quella
	* organizzazione.
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganization> findAllOrganizationsIncrements(
		java.lang.String name, java.lang.String code, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findAllOrganizationsIncrements(name, code, start, end);
	}

	public static int findAllOrganizationsIncrements(java.lang.String name,
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllOrganizationsIncrements(name, code);
	}

	public static java.util.List<it.ethica.esf.model.ESFOrganization> findAllLeafOrganizations(
		long organizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllLeafOrganizations(organizationId, start, end);
	}

	/**
	* Ricerca tutte le organizzazioni sportive foglie a partire
	* dall'organizzazione con id = organizationId. Se l'organizationId Ã¯Â¿Â½ di
	* un organizzazione foglia, ritorna una lista con solo quella
	* organizzazione.
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganization> findAllLeafOrganizations(
		long organizationId, java.lang.String code, java.lang.String name,
		int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findAllLeafOrganizations(organizationId, code, name, start,
			end);
	}

	/**
	* Ricerca tutte le organizzazioni sportive foglie a partire
	* dall'organizzazione con id = organizationId con stato pari a state. Se
	* l'organizationId Ã¯Â¿Â½ di un organizzazione foglia, ritorna una lista con
	* solo quella organizzazione.
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganization> findAllLeafOrganizations(
		long organizationId, int state)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllLeafOrganizations(organizationId, state);
	}

	/**
	* Ricerca tutte le organizzazioni sportive foglie a partire
	* dall'organizzazione con id = organizationId con stato pari a state. Se
	* l'organizationId Ã¯Â¿Â½ di un organizzazione foglia, ritorna una lista con
	* solo quella organizzazione.
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganization> findAllLeafOrganizations(
		long organizationId, int state, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findAllLeafOrganizations(organizationId, state, start, end);
	}

	/**
	* Ricerca tutte le organizzazioni sportive figlie a partire
	* dall'organizzazione con id = organizationId
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganization> findAllChildOrganizations(
		long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllChildOrganizations(organizationId);
	}

	/**
	* Ricerca tutte le organizzazioni sportive figlie a partire
	* dall'organizzazione con id = organizationId
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganization> findAllChildOrganizations(
		long organizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllChildOrganizations(organizationId, start, end);
	}

	/**
	* Ricerca tutte le organizzazioni sportive figlie a partire
	* dall'organizzazione con id = organizationId che ha uno stato pari a
	* state.
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganization> findAllChildOrganizations(
		long organizationId, int state)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllChildOrganizations(organizationId, state);
	}

	/**
	* Ricerca tutte le organizzazioni sportive figlie a partire
	* dall'organizzazione con id = organizationId che ha uno stato pari a
	* state.
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganization> findAllChildOrganizations(
		long organizationId, int state, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findAllChildOrganizations(organizationId, state, start, end);
	}

	/**
	* Ricerca tutte le organizzazioni sportive con pagamento del rinnovo effettuato per l'anno specificato
	*/
	public static java.util.List<it.ethica.esf.model.ESFOrganization> findByPaymentYear(
		int year, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findByPaymentYear(year, start, end);
	}

	/**
	* Ricerca tutte le organizzazioni sportive con pagamento del rinnovo effettuato per l'anno specificato
	*/
	public static int countByPaymentYear(int year)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().countByPaymentYear(year);
	}

	public static java.util.List<it.ethica.esf.model.ESFOrganization> getAllEsfOrganizationByState(
		int state) {
		return getService().getAllEsfOrganizationByState(state);
	}

	public static java.util.List<it.ethica.esf.model.ESFOrganization> getAllEsfOrganizationByState(
		int state, int start, int end) {
		return getService().getAllEsfOrganizationByState(state, start, end);
	}

	public static int getAllEsfOrganizationDisabled(java.lang.String name,
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllEsfOrganizationDisabled(name, code);
	}

	public static java.util.List<it.ethica.esf.model.ESFOrganization> getAllEsfOrganizationDisabledStartEnd(
		java.lang.String name, java.lang.String code, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getAllEsfOrganizationDisabledStartEnd(name, code, start, end);
	}

	public static it.ethica.esf.model.ESFOrganization deleteESFOrganization(
		long esfOrganizationId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteESFOrganization(esfOrganizationId, serviceContext);
	}

	public static void updateESFOrganitazionESFCard(long esfOrganizationId,
		long esfCardId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().updateESFOrganitazionESFCard(esfOrganizationId, esfCardId);
	}

	public static void updateOnlyESFOrganitazionState(long esfOrganizationId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.updateOnlyESFOrganitazionState(esfOrganizationId, serviceContext);
	}

	public static java.lang.String getNameT(
		it.ethica.esf.model.ESFOrganization esfOrganization)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getNameT(esfOrganization);
	}

	public static java.util.List<it.ethica.esf.model.ESFOrganization> findByT_C_N(
		java.lang.Long organizationType, java.lang.String code,
		java.lang.String name, java.lang.Long orgId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.lang.Exception {
		return getService()
				   .findByT_C_N(organizationType, code, name, orgId, start, end);
	}

	public static int countByT_C_N(java.lang.Long organizationType,
		java.lang.String code, java.lang.String name, java.lang.Long orgId)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.lang.Exception {
		return getService().countByT_C_N(organizationType, code, name, orgId);
	}

	public static java.util.List<it.ethica.esf.model.ESFOrganization> findAllAffilationConiReportAndArmy() {
		return getService().findAllAffilationConiReportAndArmy();
	}

	public static java.util.List<it.ethica.esf.model.ESFOrganization> findNewAffilationConiReportAndArmy(
		int year) {
		return getService().findNewAffilationConiReportAndArmy(year);
	}

	public static void clearService() {
		_service = null;
	}

	public static ESFOrganizationLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ESFOrganizationLocalService.class.getName());

			if (invokableLocalService instanceof ESFOrganizationLocalService) {
				_service = (ESFOrganizationLocalService)invokableLocalService;
			}
			else {
				_service = new ESFOrganizationLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ESFOrganizationLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ESFOrganizationLocalService service) {
	}

	private static ESFOrganizationLocalService _service;
}