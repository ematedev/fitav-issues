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

import it.ethica.esf.model.ESFUserRole;
import it.ethica.esf.service.ESFUserRoleLocalService;
import it.ethica.esf.service.persistence.ESFUserESFUserRolePersistence;
import it.ethica.esf.service.persistence.ESFUserPersistence;
import it.ethica.esf.service.persistence.ESFUserRolePersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the e s f user role local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link it.ethica.esf.service.impl.ESFUserRoleLocalServiceImpl}.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.impl.ESFUserRoleLocalServiceImpl
 * @see it.ethica.esf.service.ESFUserRoleLocalServiceUtil
 * @generated
 */
public abstract class ESFUserRoleLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements ESFUserRoleLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link it.ethica.esf.service.ESFUserRoleLocalServiceUtil} to access the e s f user role local service.
	 */

	/**
	 * Adds the e s f user role to the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfUserRole the e s f user role
	 * @return the e s f user role that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ESFUserRole addESFUserRole(ESFUserRole esfUserRole)
		throws SystemException {
		esfUserRole.setNew(true);

		return esfUserRolePersistence.update(esfUserRole);
	}

	/**
	 * Creates a new e s f user role with the primary key. Does not add the e s f user role to the database.
	 *
	 * @param esfUserRoleId the primary key for the new e s f user role
	 * @return the new e s f user role
	 */
	@Override
	public ESFUserRole createESFUserRole(long esfUserRoleId) {
		return esfUserRolePersistence.create(esfUserRoleId);
	}

	/**
	 * Deletes the e s f user role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfUserRoleId the primary key of the e s f user role
	 * @return the e s f user role that was removed
	 * @throws PortalException if a e s f user role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ESFUserRole deleteESFUserRole(long esfUserRoleId)
		throws PortalException, SystemException {
		return esfUserRolePersistence.remove(esfUserRoleId);
	}

	/**
	 * Deletes the e s f user role from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfUserRole the e s f user role
	 * @return the e s f user role that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ESFUserRole deleteESFUserRole(ESFUserRole esfUserRole)
		throws SystemException {
		return esfUserRolePersistence.remove(esfUserRole);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(ESFUserRole.class,
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
		return esfUserRolePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return esfUserRolePersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return esfUserRolePersistence.findWithDynamicQuery(dynamicQuery, start,
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
		return esfUserRolePersistence.countWithDynamicQuery(dynamicQuery);
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
		return esfUserRolePersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public ESFUserRole fetchESFUserRole(long esfUserRoleId)
		throws SystemException {
		return esfUserRolePersistence.fetchByPrimaryKey(esfUserRoleId);
	}

	/**
	 * Returns the e s f user role with the matching UUID and company.
	 *
	 * @param uuid the e s f user role's UUID
	 * @param  companyId the primary key of the company
	 * @return the matching e s f user role, or <code>null</code> if a matching e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole fetchESFUserRoleByUuidAndCompanyId(String uuid,
		long companyId) throws SystemException {
		return esfUserRolePersistence.fetchByUuid_C_First(uuid, companyId, null);
	}

	/**
	 * Returns the e s f user role matching the UUID and group.
	 *
	 * @param uuid the e s f user role's UUID
	 * @param groupId the primary key of the group
	 * @return the matching e s f user role, or <code>null</code> if a matching e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole fetchESFUserRoleByUuidAndGroupId(String uuid,
		long groupId) throws SystemException {
		return esfUserRolePersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the e s f user role with the primary key.
	 *
	 * @param esfUserRoleId the primary key of the e s f user role
	 * @return the e s f user role
	 * @throws PortalException if a e s f user role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole getESFUserRole(long esfUserRoleId)
		throws PortalException, SystemException {
		return esfUserRolePersistence.findByPrimaryKey(esfUserRoleId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return esfUserRolePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns the e s f user role with the matching UUID and company.
	 *
	 * @param uuid the e s f user role's UUID
	 * @param  companyId the primary key of the company
	 * @return the matching e s f user role
	 * @throws PortalException if a matching e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole getESFUserRoleByUuidAndCompanyId(String uuid,
		long companyId) throws PortalException, SystemException {
		return esfUserRolePersistence.findByUuid_C_First(uuid, companyId, null);
	}

	/**
	 * Returns the e s f user role matching the UUID and group.
	 *
	 * @param uuid the e s f user role's UUID
	 * @param groupId the primary key of the group
	 * @return the matching e s f user role
	 * @throws PortalException if a matching e s f user role could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserRole getESFUserRoleByUuidAndGroupId(String uuid, long groupId)
		throws PortalException, SystemException {
		return esfUserRolePersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the e s f user roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f user roles
	 * @param end the upper bound of the range of e s f user roles (not inclusive)
	 * @return the range of e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserRole> getESFUserRoles(int start, int end)
		throws SystemException {
		return esfUserRolePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of e s f user roles.
	 *
	 * @return the number of e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getESFUserRolesCount() throws SystemException {
		return esfUserRolePersistence.countAll();
	}

	/**
	 * Updates the e s f user role in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param esfUserRole the e s f user role
	 * @return the e s f user role that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ESFUserRole updateESFUserRole(ESFUserRole esfUserRole)
		throws SystemException {
		return esfUserRolePersistence.update(esfUserRole);
	}

	/**
	 * Returns the e s f user local service.
	 *
	 * @return the e s f user local service
	 */
	public it.ethica.esf.service.ESFUserLocalService getESFUserLocalService() {
		return esfUserLocalService;
	}

	/**
	 * Sets the e s f user local service.
	 *
	 * @param esfUserLocalService the e s f user local service
	 */
	public void setESFUserLocalService(
		it.ethica.esf.service.ESFUserLocalService esfUserLocalService) {
		this.esfUserLocalService = esfUserLocalService;
	}

	/**
	 * Returns the e s f user persistence.
	 *
	 * @return the e s f user persistence
	 */
	public ESFUserPersistence getESFUserPersistence() {
		return esfUserPersistence;
	}

	/**
	 * Sets the e s f user persistence.
	 *
	 * @param esfUserPersistence the e s f user persistence
	 */
	public void setESFUserPersistence(ESFUserPersistence esfUserPersistence) {
		this.esfUserPersistence = esfUserPersistence;
	}

	/**
	 * Returns the e s f user e s f user role local service.
	 *
	 * @return the e s f user e s f user role local service
	 */
	public it.ethica.esf.service.ESFUserESFUserRoleLocalService getESFUserESFUserRoleLocalService() {
		return esfUserESFUserRoleLocalService;
	}

	/**
	 * Sets the e s f user e s f user role local service.
	 *
	 * @param esfUserESFUserRoleLocalService the e s f user e s f user role local service
	 */
	public void setESFUserESFUserRoleLocalService(
		it.ethica.esf.service.ESFUserESFUserRoleLocalService esfUserESFUserRoleLocalService) {
		this.esfUserESFUserRoleLocalService = esfUserESFUserRoleLocalService;
	}

	/**
	 * Returns the e s f user e s f user role persistence.
	 *
	 * @return the e s f user e s f user role persistence
	 */
	public ESFUserESFUserRolePersistence getESFUserESFUserRolePersistence() {
		return esfUserESFUserRolePersistence;
	}

	/**
	 * Sets the e s f user e s f user role persistence.
	 *
	 * @param esfUserESFUserRolePersistence the e s f user e s f user role persistence
	 */
	public void setESFUserESFUserRolePersistence(
		ESFUserESFUserRolePersistence esfUserESFUserRolePersistence) {
		this.esfUserESFUserRolePersistence = esfUserESFUserRolePersistence;
	}

	/**
	 * Returns the e s f user role local service.
	 *
	 * @return the e s f user role local service
	 */
	public it.ethica.esf.service.ESFUserRoleLocalService getESFUserRoleLocalService() {
		return esfUserRoleLocalService;
	}

	/**
	 * Sets the e s f user role local service.
	 *
	 * @param esfUserRoleLocalService the e s f user role local service
	 */
	public void setESFUserRoleLocalService(
		it.ethica.esf.service.ESFUserRoleLocalService esfUserRoleLocalService) {
		this.esfUserRoleLocalService = esfUserRoleLocalService;
	}

	/**
	 * Returns the e s f user role persistence.
	 *
	 * @return the e s f user role persistence
	 */
	public ESFUserRolePersistence getESFUserRolePersistence() {
		return esfUserRolePersistence;
	}

	/**
	 * Sets the e s f user role persistence.
	 *
	 * @param esfUserRolePersistence the e s f user role persistence
	 */
	public void setESFUserRolePersistence(
		ESFUserRolePersistence esfUserRolePersistence) {
		this.esfUserRolePersistence = esfUserRolePersistence;
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

		PersistedModelLocalServiceRegistryUtil.register("it.ethica.esf.model.ESFUserRole",
			esfUserRoleLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"it.ethica.esf.model.ESFUserRole");
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
		return ESFUserRole.class;
	}

	protected String getModelClassName() {
		return ESFUserRole.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = esfUserRolePersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = it.ethica.esf.service.ESFUserLocalService.class)
	protected it.ethica.esf.service.ESFUserLocalService esfUserLocalService;
	@BeanReference(type = ESFUserPersistence.class)
	protected ESFUserPersistence esfUserPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFUserESFUserRoleLocalService.class)
	protected it.ethica.esf.service.ESFUserESFUserRoleLocalService esfUserESFUserRoleLocalService;
	@BeanReference(type = ESFUserESFUserRolePersistence.class)
	protected ESFUserESFUserRolePersistence esfUserESFUserRolePersistence;
	@BeanReference(type = it.ethica.esf.service.ESFUserRoleLocalService.class)
	protected it.ethica.esf.service.ESFUserRoleLocalService esfUserRoleLocalService;
	@BeanReference(type = ESFUserRolePersistence.class)
	protected ESFUserRolePersistence esfUserRolePersistence;
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
	private ESFUserRoleLocalServiceClpInvoker _clpInvoker = new ESFUserRoleLocalServiceClpInvoker();
}