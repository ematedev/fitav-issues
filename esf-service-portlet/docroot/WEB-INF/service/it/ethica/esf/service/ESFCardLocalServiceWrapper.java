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
 * Provides a wrapper for {@link ESFCardLocalService}.
 *
 * @author Ethica
 * @see ESFCardLocalService
 * @generated
 */
public class ESFCardLocalServiceWrapper implements ESFCardLocalService,
	ServiceWrapper<ESFCardLocalService> {
	public ESFCardLocalServiceWrapper(ESFCardLocalService esfCardLocalService) {
		_esfCardLocalService = esfCardLocalService;
	}

	/**
	* Adds the e s f card to the database. Also notifies the appropriate model listeners.
	*
	* @param esfCard the e s f card
	* @return the e s f card that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFCard addESFCard(
		it.ethica.esf.model.ESFCard esfCard)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.addESFCard(esfCard);
	}

	/**
	* Creates a new e s f card with the primary key. Does not add the e s f card to the database.
	*
	* @param esfCardId the primary key for the new e s f card
	* @return the new e s f card
	*/
	@Override
	public it.ethica.esf.model.ESFCard createESFCard(long esfCardId) {
		return _esfCardLocalService.createESFCard(esfCardId);
	}

	/**
	* Deletes the e s f card with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfCardId the primary key of the e s f card
	* @return the e s f card that was removed
	* @throws PortalException if a e s f card with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFCard deleteESFCard(long esfCardId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.deleteESFCard(esfCardId);
	}

	/**
	* Deletes the e s f card from the database. Also notifies the appropriate model listeners.
	*
	* @param esfCard the e s f card
	* @return the e s f card that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFCard deleteESFCard(
		it.ethica.esf.model.ESFCard esfCard)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.deleteESFCard(esfCard);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfCardLocalService.dynamicQuery();
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
		return _esfCardLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfCardLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfCardLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _esfCardLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfCardLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public it.ethica.esf.model.ESFCard fetchESFCard(long esfCardId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.fetchESFCard(esfCardId);
	}

	/**
	* Returns the e s f card with the matching UUID and company.
	*
	* @param uuid the e s f card's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f card, or <code>null</code> if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFCard fetchESFCardByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.fetchESFCardByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the e s f card matching the UUID and group.
	*
	* @param uuid the e s f card's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f card, or <code>null</code> if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFCard fetchESFCardByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.fetchESFCardByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the e s f card with the primary key.
	*
	* @param esfCardId the primary key of the e s f card
	* @return the e s f card
	* @throws PortalException if a e s f card with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFCard getESFCard(long esfCardId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.getESFCard(esfCardId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the e s f card with the matching UUID and company.
	*
	* @param uuid the e s f card's UUID
	* @param companyId the primary key of the company
	* @return the matching e s f card
	* @throws PortalException if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFCard getESFCardByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.getESFCardByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the e s f card matching the UUID and group.
	*
	* @param uuid the e s f card's UUID
	* @param groupId the primary key of the group
	* @return the matching e s f card
	* @throws PortalException if a matching e s f card could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFCard getESFCardByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.getESFCardByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the e s f cards.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f cards
	* @param end the upper bound of the range of e s f cards (not inclusive)
	* @return the range of e s f cards
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFCard> getESFCards(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.getESFCards(start, end);
	}

	/**
	* Returns the number of e s f cards.
	*
	* @return the number of e s f cards
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFCardsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.getESFCardsCount();
	}

	/**
	* Updates the e s f card in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfCard the e s f card
	* @return the e s f card that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFCard updateESFCard(
		it.ethica.esf.model.ESFCard esfCard)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCardLocalService.updateESFCard(esfCard);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfCardLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfCardLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfCardLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFCardLocalService getWrappedESFCardLocalService() {
		return _esfCardLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFCardLocalService(
		ESFCardLocalService esfCardLocalService) {
		_esfCardLocalService = esfCardLocalService;
	}

	@Override
	public ESFCardLocalService getWrappedService() {
		return _esfCardLocalService;
	}

	@Override
	public void setWrappedService(ESFCardLocalService esfCardLocalService) {
		_esfCardLocalService = esfCardLocalService;
	}

	private ESFCardLocalService _esfCardLocalService;
}