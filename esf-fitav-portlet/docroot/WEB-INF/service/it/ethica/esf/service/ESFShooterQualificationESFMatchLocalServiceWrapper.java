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
 * Provides a wrapper for {@link ESFShooterQualificationESFMatchLocalService}.
 *
 * @author Ethica
 * @see ESFShooterQualificationESFMatchLocalService
 * @generated
 */
public class ESFShooterQualificationESFMatchLocalServiceWrapper
	implements ESFShooterQualificationESFMatchLocalService,
		ServiceWrapper<ESFShooterQualificationESFMatchLocalService> {
	public ESFShooterQualificationESFMatchLocalServiceWrapper(
		ESFShooterQualificationESFMatchLocalService esfShooterQualificationESFMatchLocalService) {
		_esfShooterQualificationESFMatchLocalService = esfShooterQualificationESFMatchLocalService;
	}

	/**
	* Adds the e s f shooter qualification e s f match to the database. Also notifies the appropriate model listeners.
	*
	* @param esfShooterQualificationESFMatch the e s f shooter qualification e s f match
	* @return the e s f shooter qualification e s f match that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFShooterQualificationESFMatch addESFShooterQualificationESFMatch(
		it.ethica.esf.model.ESFShooterQualificationESFMatch esfShooterQualificationESFMatch)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterQualificationESFMatchLocalService.addESFShooterQualificationESFMatch(esfShooterQualificationESFMatch);
	}

	/**
	* Creates a new e s f shooter qualification e s f match with the primary key. Does not add the e s f shooter qualification e s f match to the database.
	*
	* @param esfShooterQualificationESFMatchPK the primary key for the new e s f shooter qualification e s f match
	* @return the new e s f shooter qualification e s f match
	*/
	@Override
	public it.ethica.esf.model.ESFShooterQualificationESFMatch createESFShooterQualificationESFMatch(
		it.ethica.esf.service.persistence.ESFShooterQualificationESFMatchPK esfShooterQualificationESFMatchPK) {
		return _esfShooterQualificationESFMatchLocalService.createESFShooterQualificationESFMatch(esfShooterQualificationESFMatchPK);
	}

	/**
	* Deletes the e s f shooter qualification e s f match with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfShooterQualificationESFMatchPK the primary key of the e s f shooter qualification e s f match
	* @return the e s f shooter qualification e s f match that was removed
	* @throws PortalException if a e s f shooter qualification e s f match with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFShooterQualificationESFMatch deleteESFShooterQualificationESFMatch(
		it.ethica.esf.service.persistence.ESFShooterQualificationESFMatchPK esfShooterQualificationESFMatchPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterQualificationESFMatchLocalService.deleteESFShooterQualificationESFMatch(esfShooterQualificationESFMatchPK);
	}

	/**
	* Deletes the e s f shooter qualification e s f match from the database. Also notifies the appropriate model listeners.
	*
	* @param esfShooterQualificationESFMatch the e s f shooter qualification e s f match
	* @return the e s f shooter qualification e s f match that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFShooterQualificationESFMatch deleteESFShooterQualificationESFMatch(
		it.ethica.esf.model.ESFShooterQualificationESFMatch esfShooterQualificationESFMatch)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterQualificationESFMatchLocalService.deleteESFShooterQualificationESFMatch(esfShooterQualificationESFMatch);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfShooterQualificationESFMatchLocalService.dynamicQuery();
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
		return _esfShooterQualificationESFMatchLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfShooterQualificationESFMatchLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfShooterQualificationESFMatchLocalService.dynamicQuery(dynamicQuery,
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
		return _esfShooterQualificationESFMatchLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfShooterQualificationESFMatchLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.ESFShooterQualificationESFMatch fetchESFShooterQualificationESFMatch(
		it.ethica.esf.service.persistence.ESFShooterQualificationESFMatchPK esfShooterQualificationESFMatchPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterQualificationESFMatchLocalService.fetchESFShooterQualificationESFMatch(esfShooterQualificationESFMatchPK);
	}

	/**
	* Returns the e s f shooter qualification e s f match with the matching UUID and company.
	*
	* @param uuid the e s f shooter qualification e s f match's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f shooter qualification e s f match, or <code>null</code> if a matching e s f shooter qualification e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFShooterQualificationESFMatch fetchESFShooterQualificationESFMatchByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterQualificationESFMatchLocalService.fetchESFShooterQualificationESFMatchByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the e s f shooter qualification e s f match matching the UUID and group.
	*
	* @param uuid the e s f shooter qualification e s f match's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f shooter qualification e s f match, or <code>null</code> if a matching e s f shooter qualification e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFShooterQualificationESFMatch fetchESFShooterQualificationESFMatchByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterQualificationESFMatchLocalService.fetchESFShooterQualificationESFMatchByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the e s f shooter qualification e s f match with the primary key.
	*
	* @param esfShooterQualificationESFMatchPK the primary key of the e s f shooter qualification e s f match
	* @return the e s f shooter qualification e s f match
	* @throws PortalException if a e s f shooter qualification e s f match with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFShooterQualificationESFMatch getESFShooterQualificationESFMatch(
		it.ethica.esf.service.persistence.ESFShooterQualificationESFMatchPK esfShooterQualificationESFMatchPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterQualificationESFMatchLocalService.getESFShooterQualificationESFMatch(esfShooterQualificationESFMatchPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterQualificationESFMatchLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the e s f shooter qualification e s f match with the matching UUID and company.
	*
	* @param uuid the e s f shooter qualification e s f match's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f shooter qualification e s f match
	* @throws PortalException if a matching e s f shooter qualification e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFShooterQualificationESFMatch getESFShooterQualificationESFMatchByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterQualificationESFMatchLocalService.getESFShooterQualificationESFMatchByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the e s f shooter qualification e s f match matching the UUID and group.
	*
	* @param uuid the e s f shooter qualification e s f match's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f shooter qualification e s f match
	* @throws PortalException if a matching e s f shooter qualification e s f match could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFShooterQualificationESFMatch getESFShooterQualificationESFMatchByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterQualificationESFMatchLocalService.getESFShooterQualificationESFMatchByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the e s f shooter qualification e s f matchs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFShooterQualificationESFMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f shooter qualification e s f matchs
	* @param end the upper bound of the range of e s f shooter qualification e s f matchs (not inclusive)
	* @return the range of e s f shooter qualification e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFShooterQualificationESFMatch> getESFShooterQualificationESFMatchs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterQualificationESFMatchLocalService.getESFShooterQualificationESFMatchs(start,
			end);
	}

	/**
	* Returns the number of e s f shooter qualification e s f matchs.
	*
	* @return the number of e s f shooter qualification e s f matchs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFShooterQualificationESFMatchsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterQualificationESFMatchLocalService.getESFShooterQualificationESFMatchsCount();
	}

	/**
	* Updates the e s f shooter qualification e s f match in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfShooterQualificationESFMatch the e s f shooter qualification e s f match
	* @return the e s f shooter qualification e s f match that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFShooterQualificationESFMatch updateESFShooterQualificationESFMatch(
		it.ethica.esf.model.ESFShooterQualificationESFMatch esfShooterQualificationESFMatch)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterQualificationESFMatchLocalService.updateESFShooterQualificationESFMatch(esfShooterQualificationESFMatch);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfShooterQualificationESFMatchLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfShooterQualificationESFMatchLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfShooterQualificationESFMatchLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public void deleteESFShooterQualificationESFMatchId(long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfShooterQualificationESFMatchLocalService.deleteESFShooterQualificationESFMatchId(esfMatchId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFShooterQualificationESFMatch> findbyMatchId(
		long esfMatchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterQualificationESFMatchLocalService.findbyMatchId(esfMatchId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFShooterQualificationESFMatchLocalService getWrappedESFShooterQualificationESFMatchLocalService() {
		return _esfShooterQualificationESFMatchLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFShooterQualificationESFMatchLocalService(
		ESFShooterQualificationESFMatchLocalService esfShooterQualificationESFMatchLocalService) {
		_esfShooterQualificationESFMatchLocalService = esfShooterQualificationESFMatchLocalService;
	}

	@Override
	public ESFShooterQualificationESFMatchLocalService getWrappedService() {
		return _esfShooterQualificationESFMatchLocalService;
	}

	@Override
	public void setWrappedService(
		ESFShooterQualificationESFMatchLocalService esfShooterQualificationESFMatchLocalService) {
		_esfShooterQualificationESFMatchLocalService = esfShooterQualificationESFMatchLocalService;
	}

	private ESFShooterQualificationESFMatchLocalService _esfShooterQualificationESFMatchLocalService;
}