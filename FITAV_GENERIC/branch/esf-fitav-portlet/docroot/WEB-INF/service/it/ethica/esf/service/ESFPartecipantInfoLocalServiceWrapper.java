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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ESFPartecipantInfoLocalService}.
 *
 * @author Ethica
 * @see ESFPartecipantInfoLocalService
 * @generated
 */
public class ESFPartecipantInfoLocalServiceWrapper
	implements ESFPartecipantInfoLocalService,
		ServiceWrapper<ESFPartecipantInfoLocalService> {
	public ESFPartecipantInfoLocalServiceWrapper(
		ESFPartecipantInfoLocalService esfPartecipantInfoLocalService) {
		_esfPartecipantInfoLocalService = esfPartecipantInfoLocalService;
	}

	/**
	* Adds the e s f partecipant info to the database. Also notifies the appropriate model listeners.
	*
	* @param esfPartecipantInfo the e s f partecipant info
	* @return the e s f partecipant info that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFPartecipantInfo addESFPartecipantInfo(
		it.ethica.esf.model.ESFPartecipantInfo esfPartecipantInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantInfoLocalService.addESFPartecipantInfo(esfPartecipantInfo);
	}

	/**
	* Creates a new e s f partecipant info with the primary key. Does not add the e s f partecipant info to the database.
	*
	* @param esfPartecipantInfoId the primary key for the new e s f partecipant info
	* @return the new e s f partecipant info
	*/
	@Override
	public it.ethica.esf.model.ESFPartecipantInfo createESFPartecipantInfo(
		long esfPartecipantInfoId) {
		return _esfPartecipantInfoLocalService.createESFPartecipantInfo(esfPartecipantInfoId);
	}

	/**
	* Deletes the e s f partecipant info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfPartecipantInfoId the primary key of the e s f partecipant info
	* @return the e s f partecipant info that was removed
	* @throws PortalException if a e s f partecipant info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFPartecipantInfo deleteESFPartecipantInfo(
		long esfPartecipantInfoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantInfoLocalService.deleteESFPartecipantInfo(esfPartecipantInfoId);
	}

	/**
	* Deletes the e s f partecipant info from the database. Also notifies the appropriate model listeners.
	*
	* @param esfPartecipantInfo the e s f partecipant info
	* @return the e s f partecipant info that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFPartecipantInfo deleteESFPartecipantInfo(
		it.ethica.esf.model.ESFPartecipantInfo esfPartecipantInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantInfoLocalService.deleteESFPartecipantInfo(esfPartecipantInfo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfPartecipantInfoLocalService.dynamicQuery();
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
		return _esfPartecipantInfoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfPartecipantInfoLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfPartecipantInfoLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _esfPartecipantInfoLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfPartecipantInfoLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.ESFPartecipantInfo fetchESFPartecipantInfo(
		long esfPartecipantInfoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantInfoLocalService.fetchESFPartecipantInfo(esfPartecipantInfoId);
	}

	/**
	* Returns the e s f partecipant info with the primary key.
	*
	* @param esfPartecipantInfoId the primary key of the e s f partecipant info
	* @return the e s f partecipant info
	* @throws PortalException if a e s f partecipant info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFPartecipantInfo getESFPartecipantInfo(
		long esfPartecipantInfoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantInfoLocalService.getESFPartecipantInfo(esfPartecipantInfoId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantInfoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f partecipant infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFPartecipantInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f partecipant infos
	* @param end the upper bound of the range of e s f partecipant infos (not inclusive)
	* @return the range of e s f partecipant infos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFPartecipantInfo> getESFPartecipantInfos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantInfoLocalService.getESFPartecipantInfos(start, end);
	}

	/**
	* Returns the number of e s f partecipant infos.
	*
	* @return the number of e s f partecipant infos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFPartecipantInfosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantInfoLocalService.getESFPartecipantInfosCount();
	}

	/**
	* Updates the e s f partecipant info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfPartecipantInfo the e s f partecipant info
	* @return the e s f partecipant info that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFPartecipantInfo updateESFPartecipantInfo(
		it.ethica.esf.model.ESFPartecipantInfo esfPartecipantInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantInfoLocalService.updateESFPartecipantInfo(esfPartecipantInfo);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfPartecipantInfoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfPartecipantInfoLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfPartecipantInfoLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFPartecipantInfo> getESFPartecipantInfosByFirstName_L_P(
		java.lang.String firstName, java.lang.String lastName, long protocol) {
		return _esfPartecipantInfoLocalService.getESFPartecipantInfosByFirstName_L_P(firstName,
			lastName, protocol);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFPartecipantInfo> getESFPartecipantInfosByFirstName_L_P(
		java.lang.String firstName, java.lang.String lastName, long protocol,
		int start, int end) {
		return _esfPartecipantInfoLocalService.getESFPartecipantInfosByFirstName_L_P(firstName,
			lastName, protocol, start, end);
	}

	@Override
	public void updateESFPartecipantInfo(long esfPartecipantInfoId,
		long groupId, long companyId, long userId, java.lang.String userName,
		boolean isPortalUser, long esfUserId, long protocol,
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String placeOfBirth, java.util.Date dateOfBirth,
		java.lang.String residenceCity, java.lang.String province, int zip,
		java.lang.String address, java.lang.String phoneNumber,
		java.lang.String email, java.lang.String maritialStatus,
		java.lang.String fiscalCode, java.lang.String passport,
		java.lang.String releasedBy, java.util.Date passportReleaseDate,
		java.util.Date passportExpirationDate,
		java.lang.String europeanCardNumber,
		java.util.Date europeanCardReleaseDate,
		java.util.Date europeanCardExpirationDate,
		java.lang.String gunLicenceNumber,
		java.util.Date gunLicenceReleaseDate,
		java.util.Date gunLicenceExpirationDate,
		java.lang.String esfGunTypeNameOne, java.lang.String esfGunKindNameOne,
		java.lang.String firstGunCode, double firstGunCaliber,
		java.lang.String firstGunExtraCanes,
		java.lang.String esfGunTypeNameTwo, java.lang.String esfGunKindNameTwo,
		java.lang.String secondGunCode, double secondGunCaliber,
		java.lang.String secondGunExtraCanes,
		java.lang.String gunCartridgeType, java.lang.String gunCartridgeKind,
		java.lang.String cartridgeCaliber, long esfMatchId,
		long esfGunTypeIdOne, long esfGunKindIdOne, long esfGunTypeIdTwo,
		long esfGunKindIdTwo)
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfPartecipantInfoLocalService.updateESFPartecipantInfo(esfPartecipantInfoId,
			groupId, companyId, userId, userName, isPortalUser, esfUserId,
			protocol, firstName, lastName, placeOfBirth, dateOfBirth,
			residenceCity, province, zip, address, phoneNumber, email,
			maritialStatus, fiscalCode, passport, releasedBy,
			passportReleaseDate, passportExpirationDate, europeanCardNumber,
			europeanCardReleaseDate, europeanCardExpirationDate,
			gunLicenceNumber, gunLicenceReleaseDate, gunLicenceExpirationDate,
			esfGunTypeNameOne, esfGunKindNameOne, firstGunCode,
			firstGunCaliber, firstGunExtraCanes, esfGunTypeNameTwo,
			esfGunKindNameTwo, secondGunCode, secondGunCaliber,
			secondGunExtraCanes, gunCartridgeType, gunCartridgeKind,
			cartridgeCaliber, esfMatchId, esfGunTypeIdOne, esfGunKindIdOne,
			esfGunTypeIdTwo, esfGunKindIdTwo);
	}

	@Override
	public void addESFPartecipantInfo(long groupId, long companyId,
		long userId, java.lang.String userName, java.util.Date createDate,
		boolean isPortalUser, long esfUserId, long protocol,
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String placeOfBirth, java.util.Date dateOfBirth,
		java.lang.String residenceCity, java.lang.String province, int zip,
		java.lang.String address, java.lang.String phoneNumber,
		java.lang.String email, java.lang.String maritialStatus,
		java.lang.String fiscalCode, java.lang.String passport,
		java.lang.String releasedBy, java.util.Date passportReleaseDate,
		java.util.Date passportExpirationDate,
		java.lang.String europeanCardNumber,
		java.util.Date europeanCardReleaseDate,
		java.util.Date europeanCardExpirationDate,
		java.lang.String gunLicenceNumber,
		java.util.Date gunLicenceReleaseDate,
		java.util.Date gunLicenceExpirationDate,
		java.lang.String esfGunTypeNameOne, java.lang.String esfGunKindNameOne,
		java.lang.String firstGunCode, double firstGunCaliber,
		java.lang.String firstGunExtraCanes,
		java.lang.String esfGunTypeNameTwo, java.lang.String esfGunKindNameTwo,
		java.lang.String secondGunCode, double secondGunCaliber,
		java.lang.String secondGunExtraCanes,
		java.lang.String gunCartridgeType, java.lang.String gunCartridgeKind,
		java.lang.String cartridgeCaliber, long esfMatchId,
		long esfGunTypeIdOne, long esfGunKindIdOne, long esfGunTypeIdTwo,
		long esfGunKindIdTwo)
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfPartecipantInfoLocalService.addESFPartecipantInfo(groupId,
			companyId, userId, userName, createDate, isPortalUser, esfUserId,
			protocol, firstName, lastName, placeOfBirth, dateOfBirth,
			residenceCity, province, zip, address, phoneNumber, email,
			maritialStatus, fiscalCode, passport, releasedBy,
			passportReleaseDate, passportExpirationDate, europeanCardNumber,
			europeanCardReleaseDate, europeanCardExpirationDate,
			gunLicenceNumber, gunLicenceReleaseDate, gunLicenceExpirationDate,
			esfGunTypeNameOne, esfGunKindNameOne, firstGunCode,
			firstGunCaliber, firstGunExtraCanes, esfGunTypeNameTwo,
			esfGunKindNameTwo, secondGunCode, secondGunCaliber,
			secondGunExtraCanes, gunCartridgeType, gunCartridgeKind,
			cartridgeCaliber, esfMatchId, esfGunTypeIdOne, esfGunKindIdOne,
			esfGunTypeIdTwo, esfGunKindIdTwo);
	}

	@Override
	public long addESFPartecipantInfoAndReturnId(long groupId, long companyId,
		long userId, java.lang.String userName, java.util.Date createDate,
		boolean isPortalUser, long esfUserId, long protocol,
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String placeOfBirth, java.util.Date dateOfBirth,
		java.lang.String residenceCity, java.lang.String province, int zip,
		java.lang.String address, java.lang.String phoneNumber,
		java.lang.String email, java.lang.String maritialStatus,
		java.lang.String fiscalCode, java.lang.String passport,
		java.lang.String releasedBy, java.util.Date passportReleaseDate,
		java.util.Date passportExpirationDate,
		java.lang.String europeanCardNumber,
		java.util.Date europeanCardReleaseDate,
		java.util.Date europeanCardExpirationDate,
		java.lang.String gunLicenceNumber,
		java.util.Date gunLicenceReleaseDate,
		java.util.Date gunLicenceExpirationDate,
		java.lang.String esfGunTypeNameOne, java.lang.String esfGunKindNameOne,
		java.lang.String firstGunCode, double firstGunCaliber,
		java.lang.String firstGunExtraCanes,
		java.lang.String esfGunTypeNameTwo, java.lang.String esfGunKindNameTwo,
		java.lang.String secondGunCode, double secondGunCaliber,
		java.lang.String secondGunExtraCanes,
		java.lang.String gunCartridgeType, java.lang.String gunCartridgeKind,
		java.lang.String cartridgeCaliber, long esfMatchId,
		long esfGunTypeIdOne, long esfGunKindIdOne, long esfGunTypeIdTwo,
		long esfGunKindIdTwo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfPartecipantInfoLocalService.addESFPartecipantInfoAndReturnId(groupId,
			companyId, userId, userName, createDate, isPortalUser, esfUserId,
			protocol, firstName, lastName, placeOfBirth, dateOfBirth,
			residenceCity, province, zip, address, phoneNumber, email,
			maritialStatus, fiscalCode, passport, releasedBy,
			passportReleaseDate, passportExpirationDate, europeanCardNumber,
			europeanCardReleaseDate, europeanCardExpirationDate,
			gunLicenceNumber, gunLicenceReleaseDate, gunLicenceExpirationDate,
			esfGunTypeNameOne, esfGunKindNameOne, firstGunCode,
			firstGunCaliber, firstGunExtraCanes, esfGunTypeNameTwo,
			esfGunKindNameTwo, secondGunCode, secondGunCaliber,
			secondGunExtraCanes, gunCartridgeType, gunCartridgeKind,
			cartridgeCaliber, esfMatchId, esfGunTypeIdOne, esfGunKindIdOne,
			esfGunTypeIdTwo, esfGunKindIdTwo);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFPartecipantInfoLocalService getWrappedESFPartecipantInfoLocalService() {
		return _esfPartecipantInfoLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFPartecipantInfoLocalService(
		ESFPartecipantInfoLocalService esfPartecipantInfoLocalService) {
		_esfPartecipantInfoLocalService = esfPartecipantInfoLocalService;
	}

	@Override
	public ESFPartecipantInfoLocalService getWrappedService() {
		return _esfPartecipantInfoLocalService;
	}

	@Override
	public void setWrappedService(
		ESFPartecipantInfoLocalService esfPartecipantInfoLocalService) {
		_esfPartecipantInfoLocalService = esfPartecipantInfoLocalService;
	}

	private ESFPartecipantInfoLocalService _esfPartecipantInfoLocalService;
}