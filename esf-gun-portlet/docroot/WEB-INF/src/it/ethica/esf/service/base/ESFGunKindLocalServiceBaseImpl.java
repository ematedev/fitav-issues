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

package it.ethica.esf.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import it.ethica.esf.model.ESFGunKind;
import it.ethica.esf.service.ESFGunKindLocalService;
import it.ethica.esf.service.persistence.ESFGunKindPersistence;
import it.ethica.esf.service.persistence.ESFGunPersistence;
import it.ethica.esf.service.persistence.ESFGunTypePersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the e s f gun kind local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link it.ethica.esf.service.impl.ESFGunKindLocalServiceImpl}.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.impl.ESFGunKindLocalServiceImpl
 * @see it.ethica.esf.service.ESFGunKindLocalServiceUtil
 * @generated
 */
public abstract class ESFGunKindLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements ESFGunKindLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link it.ethica.esf.service.ESFGunKindLocalServiceUtil} to access the e s f gun kind local service.
	 */

	/**
	 * Adds the e s f gun kind to the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfGunKind the e s f gun kind
	 * @return the e s f gun kind that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ESFGunKind addESFGunKind(ESFGunKind esfGunKind)
		throws SystemException {
		esfGunKind.setNew(true);

		return esfGunKindPersistence.update(esfGunKind);
	}

	/**
	 * Creates a new e s f gun kind with the primary key. Does not add the e s f gun kind to the database.
	 *
	 * @param esfGunKindId the primary key for the new e s f gun kind
	 * @return the new e s f gun kind
	 */
	@Override
	public ESFGunKind createESFGunKind(long esfGunKindId) {
		return esfGunKindPersistence.create(esfGunKindId);
	}

	/**
	 * Deletes the e s f gun kind with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfGunKindId the primary key of the e s f gun kind
	 * @return the e s f gun kind that was removed
	 * @throws PortalException if a e s f gun kind with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ESFGunKind deleteESFGunKind(long esfGunKindId)
		throws PortalException, SystemException {
		return esfGunKindPersistence.remove(esfGunKindId);
	}

	/**
	 * Deletes the e s f gun kind from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfGunKind the e s f gun kind
	 * @return the e s f gun kind that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ESFGunKind deleteESFGunKind(ESFGunKind esfGunKind)
		throws SystemException {
		return esfGunKindPersistence.remove(esfGunKind);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(ESFGunKind.class,
			clazz.getClassLoader());
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
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return esfGunKindPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunKindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return esfGunKindPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunKindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return esfGunKindPersistence.findWithDynamicQuery(dynamicQuery, start,
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
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return esfGunKindPersistence.countWithDynamicQuery(dynamicQuery);
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
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return esfGunKindPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public ESFGunKind fetchESFGunKind(long esfGunKindId)
		throws SystemException {
		return esfGunKindPersistence.fetchByPrimaryKey(esfGunKindId);
	}

	/**
	 * Returns the e s f gun kind with the matching UUID and company.
	 *
	 * @param uuid the e s f gun kind's UUID
	 * @param  companyId the primary key of the company
	 * @return the matching e s f gun kind, or <code>null</code> if a matching e s f gun kind could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunKind fetchESFGunKindByUuidAndCompanyId(String uuid,
		long companyId) throws SystemException {
		return esfGunKindPersistence.fetchByUuid_C_First(uuid, companyId, null);
	}

	/**
	 * Returns the e s f gun kind matching the UUID and group.
	 *
	 * @param uuid the e s f gun kind's UUID
	 * @param groupId the primary key of the group
	 * @return the matching e s f gun kind, or <code>null</code> if a matching e s f gun kind could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunKind fetchESFGunKindByUuidAndGroupId(String uuid, long groupId)
		throws SystemException {
		return esfGunKindPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the e s f gun kind with the primary key.
	 *
	 * @param esfGunKindId the primary key of the e s f gun kind
	 * @return the e s f gun kind
	 * @throws PortalException if a e s f gun kind with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunKind getESFGunKind(long esfGunKindId)
		throws PortalException, SystemException {
		return esfGunKindPersistence.findByPrimaryKey(esfGunKindId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return esfGunKindPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns the e s f gun kind with the matching UUID and company.
	 *
	 * @param uuid the e s f gun kind's UUID
	 * @param  companyId the primary key of the company
	 * @return the matching e s f gun kind
	 * @throws PortalException if a matching e s f gun kind could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunKind getESFGunKindByUuidAndCompanyId(String uuid,
		long companyId) throws PortalException, SystemException {
		return esfGunKindPersistence.findByUuid_C_First(uuid, companyId, null);
	}

	/**
	 * Returns the e s f gun kind matching the UUID and group.
	 *
	 * @param uuid the e s f gun kind's UUID
	 * @param groupId the primary key of the group
	 * @return the matching e s f gun kind
	 * @throws PortalException if a matching e s f gun kind could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFGunKind getESFGunKindByUuidAndGroupId(String uuid, long groupId)
		throws PortalException, SystemException {
		return esfGunKindPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the e s f gun kinds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFGunKindModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f gun kinds
	 * @param end the upper bound of the range of e s f gun kinds (not inclusive)
	 * @return the range of e s f gun kinds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFGunKind> getESFGunKinds(int start, int end)
		throws SystemException {
		return esfGunKindPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of e s f gun kinds.
	 *
	 * @return the number of e s f gun kinds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getESFGunKindsCount() throws SystemException {
		return esfGunKindPersistence.countAll();
	}

	/**
	 * Updates the e s f gun kind in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param esfGunKind the e s f gun kind
	 * @return the e s f gun kind that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ESFGunKind updateESFGunKind(ESFGunKind esfGunKind)
		throws SystemException {
		return esfGunKindPersistence.update(esfGunKind);
	}

	/**
	 * Returns the e s f gun local service.
	 *
	 * @return the e s f gun local service
	 */
	public it.ethica.esf.service.ESFGunLocalService getESFGunLocalService() {
		return esfGunLocalService;
	}

	/**
	 * Sets the e s f gun local service.
	 *
	 * @param esfGunLocalService the e s f gun local service
	 */
	public void setESFGunLocalService(
		it.ethica.esf.service.ESFGunLocalService esfGunLocalService) {
		this.esfGunLocalService = esfGunLocalService;
	}

	/**
	 * Returns the e s f gun persistence.
	 *
	 * @return the e s f gun persistence
	 */
	public ESFGunPersistence getESFGunPersistence() {
		return esfGunPersistence;
	}

	/**
	 * Sets the e s f gun persistence.
	 *
	 * @param esfGunPersistence the e s f gun persistence
	 */
	public void setESFGunPersistence(ESFGunPersistence esfGunPersistence) {
		this.esfGunPersistence = esfGunPersistence;
	}

	/**
	 * Returns the e s f gun kind local service.
	 *
	 * @return the e s f gun kind local service
	 */
	public it.ethica.esf.service.ESFGunKindLocalService getESFGunKindLocalService() {
		return esfGunKindLocalService;
	}

	/**
	 * Sets the e s f gun kind local service.
	 *
	 * @param esfGunKindLocalService the e s f gun kind local service
	 */
	public void setESFGunKindLocalService(
		it.ethica.esf.service.ESFGunKindLocalService esfGunKindLocalService) {
		this.esfGunKindLocalService = esfGunKindLocalService;
	}

	/**
	 * Returns the e s f gun kind persistence.
	 *
	 * @return the e s f gun kind persistence
	 */
	public ESFGunKindPersistence getESFGunKindPersistence() {
		return esfGunKindPersistence;
	}

	/**
	 * Sets the e s f gun kind persistence.
	 *
	 * @param esfGunKindPersistence the e s f gun kind persistence
	 */
	public void setESFGunKindPersistence(
		ESFGunKindPersistence esfGunKindPersistence) {
		this.esfGunKindPersistence = esfGunKindPersistence;
	}

	/**
	 * Returns the e s f gun type local service.
	 *
	 * @return the e s f gun type local service
	 */
	public it.ethica.esf.service.ESFGunTypeLocalService getESFGunTypeLocalService() {
		return esfGunTypeLocalService;
	}

	/**
	 * Sets the e s f gun type local service.
	 *
	 * @param esfGunTypeLocalService the e s f gun type local service
	 */
	public void setESFGunTypeLocalService(
		it.ethica.esf.service.ESFGunTypeLocalService esfGunTypeLocalService) {
		this.esfGunTypeLocalService = esfGunTypeLocalService;
	}

	/**
	 * Returns the e s f gun type persistence.
	 *
	 * @return the e s f gun type persistence
	 */
	public ESFGunTypePersistence getESFGunTypePersistence() {
		return esfGunTypePersistence;
	}

	/**
	 * Sets the e s f gun type persistence.
	 *
	 * @param esfGunTypePersistence the e s f gun type persistence
	 */
	public void setESFGunTypePersistence(
		ESFGunTypePersistence esfGunTypePersistence) {
		this.esfGunTypePersistence = esfGunTypePersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("it.ethica.esf.model.ESFGunKind",
			esfGunKindLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"it.ethica.esf.model.ESFGunKind");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return ESFGunKind.class;
	}

	protected String getModelClassName() {
		return ESFGunKind.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = esfGunKindPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = it.ethica.esf.service.ESFGunLocalService.class)
	protected it.ethica.esf.service.ESFGunLocalService esfGunLocalService;
	@BeanReference(type = ESFGunPersistence.class)
	protected ESFGunPersistence esfGunPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFGunKindLocalService.class)
	protected it.ethica.esf.service.ESFGunKindLocalService esfGunKindLocalService;
	@BeanReference(type = ESFGunKindPersistence.class)
	protected ESFGunKindPersistence esfGunKindPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFGunTypeLocalService.class)
	protected it.ethica.esf.service.ESFGunTypeLocalService esfGunTypeLocalService;
	@BeanReference(type = ESFGunTypePersistence.class)
	protected ESFGunTypePersistence esfGunTypePersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private ESFGunKindLocalServiceClpInvoker _clpInvoker = new ESFGunKindLocalServiceClpInvoker();
}