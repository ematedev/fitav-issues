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
 * Provides a wrapper for {@link ESFAnnualFreeCardLocalService}.
 *
 * @author Ethica
 * @see ESFAnnualFreeCardLocalService
 * @generated
 */
public class ESFAnnualFreeCardLocalServiceWrapper
	implements ESFAnnualFreeCardLocalService,
		ServiceWrapper<ESFAnnualFreeCardLocalService> {
	public ESFAnnualFreeCardLocalServiceWrapper(
		ESFAnnualFreeCardLocalService esfAnnualFreeCardLocalService) {
		_esfAnnualFreeCardLocalService = esfAnnualFreeCardLocalService;
	}

	/**
	* Adds the e s f annual free card to the database. Also notifies the appropriate model listeners.
	*
	* @param esfAnnualFreeCard the e s f annual free card
	* @return the e s f annual free card that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFAnnualFreeCard addESFAnnualFreeCard(
		it.ethica.esf.model.ESFAnnualFreeCard esfAnnualFreeCard)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfAnnualFreeCardLocalService.addESFAnnualFreeCard(esfAnnualFreeCard);
	}

	/**
	* Creates a new e s f annual free card with the primary key. Does not add the e s f annual free card to the database.
	*
	* @param annualFreeCardId the primary key for the new e s f annual free card
	* @return the new e s f annual free card
	*/
	@Override
	public it.ethica.esf.model.ESFAnnualFreeCard createESFAnnualFreeCard(
		long annualFreeCardId) {
		return _esfAnnualFreeCardLocalService.createESFAnnualFreeCard(annualFreeCardId);
	}

	/**
	* Deletes the e s f annual free card with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param annualFreeCardId the primary key of the e s f annual free card
	* @return the e s f annual free card that was removed
	* @throws PortalException if a e s f annual free card with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFAnnualFreeCard deleteESFAnnualFreeCard(
		long annualFreeCardId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfAnnualFreeCardLocalService.deleteESFAnnualFreeCard(annualFreeCardId);
	}

	/**
	* Deletes the e s f annual free card from the database. Also notifies the appropriate model listeners.
	*
	* @param esfAnnualFreeCard the e s f annual free card
	* @return the e s f annual free card that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFAnnualFreeCard deleteESFAnnualFreeCard(
		it.ethica.esf.model.ESFAnnualFreeCard esfAnnualFreeCard)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfAnnualFreeCardLocalService.deleteESFAnnualFreeCard(esfAnnualFreeCard);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esfAnnualFreeCardLocalService.dynamicQuery();
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
		return _esfAnnualFreeCardLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFAnnualFreeCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfAnnualFreeCardLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFAnnualFreeCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esfAnnualFreeCardLocalService.dynamicQuery(dynamicQuery, start,
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
		return _esfAnnualFreeCardLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esfAnnualFreeCardLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.ESFAnnualFreeCard fetchESFAnnualFreeCard(
		long annualFreeCardId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfAnnualFreeCardLocalService.fetchESFAnnualFreeCard(annualFreeCardId);
	}

	/**
	* Returns the e s f annual free card with the primary key.
	*
	* @param annualFreeCardId the primary key of the e s f annual free card
	* @return the e s f annual free card
	* @throws PortalException if a e s f annual free card with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFAnnualFreeCard getESFAnnualFreeCard(
		long annualFreeCardId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfAnnualFreeCardLocalService.getESFAnnualFreeCard(annualFreeCardId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfAnnualFreeCardLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s f annual free cards.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFAnnualFreeCardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s f annual free cards
	* @param end the upper bound of the range of e s f annual free cards (not inclusive)
	* @return the range of e s f annual free cards
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFAnnualFreeCard> getESFAnnualFreeCards(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfAnnualFreeCardLocalService.getESFAnnualFreeCards(start, end);
	}

	/**
	* Returns the number of e s f annual free cards.
	*
	* @return the number of e s f annual free cards
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFAnnualFreeCardsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfAnnualFreeCardLocalService.getESFAnnualFreeCardsCount();
	}

	/**
	* Updates the e s f annual free card in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esfAnnualFreeCard the e s f annual free card
	* @return the e s f annual free card that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFAnnualFreeCard updateESFAnnualFreeCard(
		it.ethica.esf.model.ESFAnnualFreeCard esfAnnualFreeCard)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfAnnualFreeCardLocalService.updateESFAnnualFreeCard(esfAnnualFreeCard);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esfAnnualFreeCardLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esfAnnualFreeCardLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esfAnnualFreeCardLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFAnnualFreeCardLocalService getWrappedESFAnnualFreeCardLocalService() {
		return _esfAnnualFreeCardLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFAnnualFreeCardLocalService(
		ESFAnnualFreeCardLocalService esfAnnualFreeCardLocalService) {
		_esfAnnualFreeCardLocalService = esfAnnualFreeCardLocalService;
	}

	@Override
	public ESFAnnualFreeCardLocalService getWrappedService() {
		return _esfAnnualFreeCardLocalService;
	}

	@Override
	public void setWrappedService(
		ESFAnnualFreeCardLocalService esfAnnualFreeCardLocalService) {
		_esfAnnualFreeCardLocalService = esfAnnualFreeCardLocalService;
	}

	private ESFAnnualFreeCardLocalService _esfAnnualFreeCardLocalService;
}