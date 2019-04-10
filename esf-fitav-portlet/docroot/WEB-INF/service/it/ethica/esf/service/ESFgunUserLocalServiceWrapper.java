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
 * Provides a wrapper for {@link ESFgunUserLocalService}.
 *
 * @author Ethica
 * @see ESFgunUserLocalService
 * @generated
 */
public class ESFgunUserLocalServiceWrapper implements ESFgunUserLocalService,
	ServiceWrapper<ESFgunUserLocalService> {
	public ESFgunUserLocalServiceWrapper(
		ESFgunUserLocalService esFgunUserLocalService) {
		_esFgunUserLocalService = esFgunUserLocalService;
	}

	/**
	* Adds the e s fgun user to the database. Also notifies the appropriate model listeners.
	*
	* @param esFgunUser the e s fgun user
	* @return the e s fgun user that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFgunUser addESFgunUser(
		it.ethica.esf.model.ESFgunUser esFgunUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esFgunUserLocalService.addESFgunUser(esFgunUser);
	}

	/**
	* Creates a new e s fgun user with the primary key. Does not add the e s fgun user to the database.
	*
	* @param esfGunUserId the primary key for the new e s fgun user
	* @return the new e s fgun user
	*/
	@Override
	public it.ethica.esf.model.ESFgunUser createESFgunUser(long esfGunUserId) {
		return _esFgunUserLocalService.createESFgunUser(esfGunUserId);
	}

	/**
	* Deletes the e s fgun user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param esfGunUserId the primary key of the e s fgun user
	* @return the e s fgun user that was removed
	* @throws PortalException if a e s fgun user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFgunUser deleteESFgunUser(long esfGunUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esFgunUserLocalService.deleteESFgunUser(esfGunUserId);
	}

	/**
	* Deletes the e s fgun user from the database. Also notifies the appropriate model listeners.
	*
	* @param esFgunUser the e s fgun user
	* @return the e s fgun user that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFgunUser deleteESFgunUser(
		it.ethica.esf.model.ESFgunUser esFgunUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esFgunUserLocalService.deleteESFgunUser(esFgunUser);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _esFgunUserLocalService.dynamicQuery();
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
		return _esFgunUserLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFgunUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esFgunUserLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFgunUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _esFgunUserLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _esFgunUserLocalService.dynamicQueryCount(dynamicQuery);
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
		return _esFgunUserLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public it.ethica.esf.model.ESFgunUser fetchESFgunUser(long esfGunUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esFgunUserLocalService.fetchESFgunUser(esfGunUserId);
	}

	/**
	* Returns the e s fgun user with the primary key.
	*
	* @param esfGunUserId the primary key of the e s fgun user
	* @return the e s fgun user
	* @throws PortalException if a e s fgun user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFgunUser getESFgunUser(long esfGunUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esFgunUserLocalService.getESFgunUser(esfGunUserId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esFgunUserLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e s fgun users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFgunUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e s fgun users
	* @param end the upper bound of the range of e s fgun users (not inclusive)
	* @return the range of e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<it.ethica.esf.model.ESFgunUser> getESFgunUsers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esFgunUserLocalService.getESFgunUsers(start, end);
	}

	/**
	* Returns the number of e s fgun users.
	*
	* @return the number of e s fgun users
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getESFgunUsersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esFgunUserLocalService.getESFgunUsersCount();
	}

	/**
	* Updates the e s fgun user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param esFgunUser the e s fgun user
	* @return the e s fgun user that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public it.ethica.esf.model.ESFgunUser updateESFgunUser(
		it.ethica.esf.model.ESFgunUser esFgunUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esFgunUserLocalService.updateESFgunUser(esFgunUser);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _esFgunUserLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_esFgunUserLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _esFgunUserLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public it.ethica.esf.model.ESFgunUser addESFGunUser(long esfGunId,
		long esfUserId, java.lang.String code, boolean isFavoriteGun, int type,
		java.lang.String note, long esfGunTypeId, long esfGunKindId,
		int typeId, java.lang.String esfMeasures, long esfCaliber,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esFgunUserLocalService.addESFGunUser(esfGunId, esfUserId, code,
			isFavoriteGun, type, note, esfGunTypeId, esfGunKindId, typeId,
			esfMeasures, esfCaliber, serviceContext);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFgunUser> getESFGunByLikeC_K_T(
		java.lang.String code, long kind, int type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esFgunUserLocalService.getESFGunByLikeC_K_T(code, kind, type,
			start, end);
	}

	@Override
	public int countESFGunByLikeC_K_T(java.lang.String code, long kind, int type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esFgunUserLocalService.countESFGunByLikeC_K_T(code, kind, type);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFgunUser> getESFGunByLikeS_T(
		long esfShooterId, int type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esFgunUserLocalService.getESFGunByLikeS_T(esfShooterId, type,
			start, end);
	}

	@Override
	public int countESFGunByLikeS_T(long esfShooterId, int type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esFgunUserLocalService.countESFGunByLikeS_T(esfShooterId, type);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFgunUser> getESFGunByT(
		int type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esFgunUserLocalService.getESFGunByT(type, start, end);
	}

	@Override
	public int countESFGunByT(int type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esFgunUserLocalService.countESFGunByT(type);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFgunUser> findbyESFGunId(
		long esfGunId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esFgunUserLocalService.findbyESFGunId(esfGunId);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFgunUser> findbyESFGunId_Type(
		long esfGunId, int type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esFgunUserLocalService.findbyESFGunId_Type(esfGunId, type);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFgunUser> findbyCode(
		java.lang.String code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esFgunUserLocalService.findbyCode(code);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFgunUser> findbyGunId_Type(
		long gunId, int type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esFgunUserLocalService.findbyGunId_Type(gunId, type, start, end);
	}

	@Override
	public int countbyGunId_Type(long gunId, int type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esFgunUserLocalService.countbyGunId_Type(gunId, type);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFgunUser> findbyKind_Shooter(
		java.lang.String name, java.lang.String lastName, long kindId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esFgunUserLocalService.findbyKind_Shooter(name, lastName,
			kindId, start, end);
	}

	@Override
	public java.util.List<it.ethica.esf.model.ESFgunUser> findCanebyKind_Shooter(
		java.lang.String name, java.lang.String lastName, long kindId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esFgunUserLocalService.findCanebyKind_Shooter(name, lastName,
			kindId, start, end);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ESFgunUserLocalService getWrappedESFgunUserLocalService() {
		return _esFgunUserLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedESFgunUserLocalService(
		ESFgunUserLocalService esFgunUserLocalService) {
		_esFgunUserLocalService = esFgunUserLocalService;
	}

	@Override
	public ESFgunUserLocalService getWrappedService() {
		return _esFgunUserLocalService;
	}

	@Override
	public void setWrappedService(ESFgunUserLocalService esFgunUserLocalService) {
		_esFgunUserLocalService = esFgunUserLocalService;
	}

	private ESFgunUserLocalService _esFgunUserLocalService;
}