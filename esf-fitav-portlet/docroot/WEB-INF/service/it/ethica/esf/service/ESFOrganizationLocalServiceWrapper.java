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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ESFOrganizationLocalService}.
 *
 * @author Ethica
 * @see ESFOrganizationLocalService
 * @generated
 */
public class ESFOrganizationLocalServiceWrapper
	implements ESFOrganizationLocalService,
		ServiceWrapper<ESFOrganizationLocalService> {
	public ESFOrganizationLocalServiceWrapper(
		ESFOrganizationLocalService esfOrganizationLocalService) {
		_esfOrganizationLocalService = esfOrganizationLocalService;
	}

	/**
	* Adds the e s f organization to the database. Also notifies the appropriate model listeners.
	*
	* @param esfOrganization the e s f organization
	* @return the e s f organization that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFOrganization addESFOrganization(
		it.ethica.esf.model.ESFOrganization esfOrganization)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.addESFOrganization(esfOrganization);
	}

	/**
	* Creates a new e s f organization with the primary key. Does not add the e s f organization to the database.
	*
	* @param esfOrganizationId the primary key for the new e s f organization
	* @return the new e s f organization
	*/
	@Override
	public it.ethica.esf.model.ESFOrganization createESFOrganization(
		long esfOrganizationId) {
		return _esfOrganizationLocalService.createESFOrganization(esfOrganizationId);
	}

	/**
	* Deletes the e s f organization with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfOrganizationId the primary key of the e s f organization
	* @return the e s f organization that was removed
	* @throws PortalException if a e s f organization with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFOrganization deleteESFOrganization(
		long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.deleteESFOrganization(esfOrganizationId);
	}

	/**
	* Deletes the e s f organization from the database. Also notifies the appropriate model listeners.
	*
	* @param esfOrganization the e s f organization
	* @return the e s f organization that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFOrganization deleteESFOrganization(
		it.ethica.esf.model.ESFOrganization esfOrganization)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.deleteESFOrganization(esfOrganization);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfOrganizationLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.ESFOrganization fetchESFOrganization(
		long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.fetchESFOrganization(esfOrganizationId);
	}

	/**
	* Returns the e s f organization matching the UUID and group.
	*
	* @param uuid the e s f organization's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f organization, or <code>null</code> if a matching e s f organization could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFOrganization fetchESFOrganizationByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.fetchESFOrganizationByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the e s f organization with the primary key.
	*
	* @param esfOrganizationId the primary key of the e s f organization
	* @return the e s f organization
	* @throws PortalException if a e s f organization with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFOrganization getESFOrganization(
		long esfOrganizationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.getESFOrganization(esfOrganizationId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public it.ethica.esf.model.ESFOrganization getESFOrganizationByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.getESFOrganizationByUuidAndGroupId(uuid,
			groupId);
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
	@Override
	public java.util.List<it.ethica.esf.model.ESFOrganization> getESFOrganizations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.getESFOrganizations(start, end);
	}

	/**
	* Returns the number of e s f organizations.
	*
	* @return the number of e s f organizations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFOrganizationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.getESFOrganizationsCount();
	}

	/**
	* Updates the e s f organization in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfOrganization the e s f organization
	* @return the e s f organization that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFOrganization updateESFOrganization(
		it.ethica.esf.model.ESFOrganization esfOrganization)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.updateESFOrganization(esfOrganization);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfOrganizationLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfOrganizationLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfOrganizationLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public it.ethica.esf.model.ESFOrganization addESFOrganization(long userId,
		long parentOrganizationId, java.lang.String name,
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
		return _esfOrganizationLocalService.addESFOrganization(userId,
			parentOrganizationId, name, emailAddress, code, vat, fiscalCode,
			ibanCode, establishmentDate, closureDate, insertDate, coniDate,
			coniCode, legalForm, category, esfAddresses, esfphones,
			publicLayoutSetPrototypeEnabled, privateLayoutSetPrototypeEnabled,
			isMultiSport, description, isYouthActive, firstAffiliationDate,
			esfEntityState, variation, regionCode, constitutiveAct,
			registeredStatus, planimetrySportsStand, certificateFITAV,
			isSimplyOrganizzation, note, webSite, addToConiReport,
			serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFOrganization addESFOrganization(long userId,
		long parentOrganizationId, java.lang.String name,
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
		return _esfOrganizationLocalService.addESFOrganization(userId,
			parentOrganizationId, name, code, vat, fiscalCode, ibanCode,
			establishmentDate, closureDate, insertDate, coniDate, coniCode,
			legalForm, category, publicLayoutSetPrototypeEnabled,
			privateLayoutSetPrototypeEnabled, isMultiSport, description,
			isYouthActive, firstAffiliationDate, esfEntityState, variation,
			regionCode, constitutiveAct, registeredStatus,
			planimetrySportsStand, certificateFITAV, isSimplyOrganizzation,
			note, webSite, addToConiReport, serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFOrganization updateESFOrganization(
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
		return _esfOrganizationLocalService.updateESFOrganization(userId,
			esfOrganizationId, parentOrganizationId, name, emailAddress, code,
			vat, fiscalCode, ibanCode, establishmentDate, closureDate,
			insertDate, coniDate, coniCode, legalForm, category, esfAddresses,
			phones, isMultiSport, description, isYouthActive,
			firstAffiliationDate, esfEntityState, variation, regionCode,
			idFatherAssociation, constitutiveAct, registeredStatus,
			planimetrySportsStand, certificateFITAV, note, webSite,
			addToConiReport, serviceContext);
	}

	@Override
	public it.ethica.esf.model.ESFOrganization updateESFOrganization(
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
		return _esfOrganizationLocalService.updateESFOrganization(userId,
			esfOrganizationId, parentOrganizationId, name, code, vat,
			fiscalCode, ibanCode, establishmentDate, closureDate, insertDate,
			coniDate, coniCode, legalForm, category, isMultiSport, description,
			isYouthActive, firstAffiliationDate, esfEntityState, variation,
			regionCode, idFatherAssociation, constitutiveAct, registeredStatus,
			planimetrySportsStand, certificateFITAV, note, webSite,
			addToConiReport, serviceContext);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFOrganization> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.findByGroupId(groupId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFOrganization> getByProvinceCode(
		java.lang.String id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.getByProvinceCode(id);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFOrganization> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.findByGroupId(groupId, start, end);
	}

	@Override
	public it.ethica.esf.model.ESFOrganization findByCode(java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.findByCode(code);
	}

	@Override
	public it.ethica.esf.model.ESFOrganization getRealOwner(long esfStateId,
		long esfFieldId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.getRealOwner(esfStateId, esfFieldId);
	}

	/**
	* Ricerca tutte le organizzazioni di tipo <b>type</b>
	*
	* @throws SystemException
	* @throws PortalException
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFOrganization> findAllESFOrganizations(
		long type, int state)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.findAllESFOrganizations(type, state);
	}

	/**
	* Ricerca tutte le organizzazioni il cui code inizia con il pattern
	* indicato da <b>code</b>
	*
	* @param code
	patten di partenza
	* @return List<ESFOrganization>
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFOrganization> findESFOrganizationsByCode(
		java.lang.String code) {
		return _esfOrganizationLocalService.findESFOrganizationsByCode(code);
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
	@Override
	public java.util.List<it.ethica.esf.model.ESFOrganization> findESFOrganizationsByT_C(
		long type, java.lang.String code, int state)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.findESFOrganizationsByT_C(type,
			code, state);
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
	@Override
	public java.util.List<it.ethica.esf.model.ESFOrganization> findESFOrganizationsByT_C(
		long type, java.lang.String code, int state, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.findESFOrganizationsByT_C(type,
			code, state, start, end);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFOrganization> findESFOrganizationsByT_C_N(
		long type, java.lang.String code, java.lang.String name, int state,
		int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.findESFOrganizationsByT_C_N(type,
			code, name, state, start, end);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFOrganization> findESFOrganizationsByT_C_N(
		long type, java.lang.String code, java.lang.String name, int state)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.findESFOrganizationsByT_C_N(type,
			code, name, state);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFOrganization> findESFOrganizationsByT_C(
		long type, int state)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.findESFOrganizationsByT_C(type,
			state);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFOrganization> findESFOrganizationsByT_C(
		long type, int state, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.findESFOrganizationsByT_C(type,
			state, start, end);
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
	@Override
	public java.util.List<it.ethica.esf.model.ESFOrganization> findESFOrganizationsByCode(
		long organizationId, java.lang.String code, int state)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.findESFOrganizationsByCode(organizationId,
			code, state);
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
	@Override
	public java.util.List<it.ethica.esf.model.ESFOrganization> findESFOrganizationsByCode(
		long organizationId, java.lang.String code, int state, int start,
		int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.findESFOrganizationsByCode(organizationId,
			code, state, start, end);
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
	@Override
	public java.util.List<it.ethica.esf.model.ESFOrganization> findESFOrganizationsByO_T(
		long organizationId, long type) {
		return _esfOrganizationLocalService.findESFOrganizationsByO_T(organizationId,
			type);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFOrganization> findESFOrganizationsByO_T_C_N(
		long organizationId, long type, java.lang.String organizationCode,
		java.lang.String organizationName) {
		return _esfOrganizationLocalService.findESFOrganizationsByO_T_C_N(organizationId,
			type, organizationCode, organizationName);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFOrganization> findESFOrganizationsByO_T_C_N(
		long organizationId, long type, java.lang.String organizationCode,
		java.lang.String organizationName, int start, int end) {
		return _esfOrganizationLocalService.findESFOrganizationsByO_T_C_N(organizationId,
			type, organizationCode, organizationName, start, end);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFOrganization> getOrganizzationLeafByLikeN_C(
		java.lang.String name, java.lang.String code,
		long parentOrganizationId, long organizationId) {
		return _esfOrganizationLocalService.getOrganizzationLeafByLikeN_C(name,
			code, parentOrganizationId, organizationId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFOrganization> getOrganizzationLeafByLikeN_C(
		java.lang.String name, java.lang.String code,
		long parentOrganizationId, long organizationId, int start, int end) {
		return _esfOrganizationLocalService.getOrganizzationLeafByLikeN_C(name,
			code, parentOrganizationId, organizationId, start, end);
	}

	/**
	* Ricerca tutte le organizzazioni sportive foglie a partire
	* dall'organizzazione con id = organizationId. Se l'organizationId e' di un
	* organizzazione foglia, ritorna una lista con solo quella organizzazione.
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFOrganization> findAllLeafOrganizations(
		long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.findAllLeafOrganizations(organizationId);
	}

	/**
	* Ricerca tutte le organizzazioni sportive foglie a partire
	* dall'organizzazione con id = organizationId. Se l'organizationId e' di un
	* organizzazione foglia, ritorna una lista con solo quella organizzazione.
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFOrganization> findAllLeafOrganizations(
		long organizationId, java.lang.String code, java.lang.String name)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.findAllLeafOrganizations(organizationId,
			code, name);
	}

	/**
	* Ricerca tutte le organizzazioni sportive foglie a partire
	* dall'organizzazione con id = organizationId. Se l'organizationId � di
	* un organizzazione foglia, ritorna una lista con solo quella
	* organizzazione.
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFOrganization> findAllOrganizationsIncrements(
		java.lang.String name, java.lang.String code, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.findAllOrganizationsIncrements(name,
			code, start, end);
	}

	@Override
	public int findAllOrganizationsIncrements(java.lang.String name,
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.findAllOrganizationsIncrements(name,
			code);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFOrganization> findAllLeafOrganizations(
		long organizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.findAllLeafOrganizations(organizationId,
			start, end);
	}

	/**
	* Ricerca tutte le organizzazioni sportive foglie a partire
	* dall'organizzazione con id = organizationId. Se l'organizationId � di
	* un organizzazione foglia, ritorna una lista con solo quella
	* organizzazione.
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFOrganization> findAllLeafOrganizations(
		long organizationId, java.lang.String code, java.lang.String name,
		int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.findAllLeafOrganizations(organizationId,
			code, name, start, end);
	}

	/**
	* Ricerca tutte le organizzazioni sportive foglie a partire
	* dall'organizzazione con id = organizationId con stato pari a state. Se
	* l'organizationId � di un organizzazione foglia, ritorna una lista con
	* solo quella organizzazione.
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFOrganization> findAllLeafOrganizations(
		long organizationId, int state)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.findAllLeafOrganizations(organizationId,
			state);
	}

	/**
	* Ricerca tutte le organizzazioni sportive foglie a partire
	* dall'organizzazione con id = organizationId con stato pari a state. Se
	* l'organizationId � di un organizzazione foglia, ritorna una lista con
	* solo quella organizzazione.
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFOrganization> findAllLeafOrganizations(
		long organizationId, int state, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.findAllLeafOrganizations(organizationId,
			state, start, end);
	}

	/**
	* Ricerca tutte le organizzazioni sportive figlie a partire
	* dall'organizzazione con id = organizationId
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFOrganization> findAllChildOrganizations(
		long organizationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.findAllChildOrganizations(organizationId);
	}

	/**
	* Ricerca tutte le organizzazioni sportive figlie a partire
	* dall'organizzazione con id = organizationId
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFOrganization> findAllChildOrganizations(
		long organizationId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.findAllChildOrganizations(organizationId,
			start, end);
	}

	/**
	* Ricerca tutte le organizzazioni sportive figlie a partire
	* dall'organizzazione con id = organizationId che ha uno stato pari a
	* state.
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFOrganization> findAllChildOrganizations(
		long organizationId, int state)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.findAllChildOrganizations(organizationId,
			state);
	}

	/**
	* Ricerca tutte le organizzazioni sportive figlie a partire
	* dall'organizzazione con id = organizationId che ha uno stato pari a
	* state.
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFOrganization> findAllChildOrganizations(
		long organizationId, int state, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.findAllChildOrganizations(organizationId,
			state, start, end);
	}

	/**
	* Ricerca tutte le organizzazioni sportive con pagamento del rinnovo effettuato per l'anno specificato
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFOrganization> findByPaymentYear(
		int year, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.findByPaymentYear(year, start, end);
	}

	/**
	* Ricerca tutte le organizzazioni sportive con pagamento del rinnovo effettuato per l'anno specificato
	*/
	@Override
	public int countByPaymentYear(int year)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.countByPaymentYear(year);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFOrganization> getAllEsfOrganizationByState(
		int state) {
		return _esfOrganizationLocalService.getAllEsfOrganizationByState(state);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFOrganization> getAllEsfOrganizationByState(
		int state, int start, int end) {
		return _esfOrganizationLocalService.getAllEsfOrganizationByState(state,
			start, end);
	}

	@Override
	public int getAllEsfOrganizationDisabled(java.lang.String name,
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.getAllEsfOrganizationDisabled(name,
			code);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFOrganization> getAllEsfOrganizationDisabledStartEnd(
		java.lang.String name, java.lang.String code, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.getAllEsfOrganizationDisabledStartEnd(name,
			code, start, end);
	}

	@Override
	public it.ethica.esf.model.ESFOrganization deleteESFOrganization(
		long esfOrganizationId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.deleteESFOrganization(esfOrganizationId,
			serviceContext);
	}

	@Override
	public void updateESFOrganitazionESFCard(long esfOrganizationId,
		long esfCardId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_esfOrganizationLocalService.updateESFOrganitazionESFCard(esfOrganizationId,
			esfCardId);
	}

	@Override
	public void updateOnlyESFOrganitazionState(long esfOrganizationId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_esfOrganizationLocalService.updateOnlyESFOrganitazionState(esfOrganizationId,
			serviceContext);
	}

	@Override
	public java.lang.String getNameT(
		it.ethica.esf.model.ESFOrganization esfOrganization)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.getNameT(esfOrganization);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFOrganization> findByT_C_N(
		java.lang.Long organizationType, java.lang.String code,
		java.lang.String name, java.lang.Long orgId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.lang.Exception {
		return _esfOrganizationLocalService.findByT_C_N(organizationType, code,
			name, orgId, start, end);
	}

	@Override
	public int countByT_C_N(java.lang.Long organizationType,
		java.lang.String code, java.lang.String name, java.lang.Long orgId)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.lang.Exception {
		return _esfOrganizationLocalService.countByT_C_N(organizationType,
			code, name, orgId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFOrganization> findAllAffilationConiReportAndArmy() {
		return _esfOrganizationLocalService.findAllAffilationConiReportAndArmy();
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFOrganization> findNewAffilationConiReportAndArmy(
		int year) {
		return _esfOrganizationLocalService.findNewAffilationConiReportAndArmy(year);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFOrganization> findByType(
		int type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationLocalService.findByType(type, start, end);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFOrganizationLocalService getWrappedESFOrganizationLocalService() {
		return _esfOrganizationLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFOrganizationLocalService(
		ESFOrganizationLocalService esfOrganizationLocalService) {
		_esfOrganizationLocalService = esfOrganizationLocalService;
	}

	@Override
	public ESFOrganizationLocalService getWrappedService() {
		return _esfOrganizationLocalService;
	}

	@Override
	public void setWrappedService(
		ESFOrganizationLocalService esfOrganizationLocalService) {
		_esfOrganizationLocalService = esfOrganizationLocalService;
	}

	private ESFOrganizationLocalService _esfOrganizationLocalService;
}