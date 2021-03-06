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

import it.ethica.esf.model.ESFOrganizationType;
import it.ethica.esf.service.ESFOrganizationTypeLocalService;
import it.ethica.esf.service.persistence.ESFCardPersistence;
import it.ethica.esf.service.persistence.ESFDocumentPersistence;
import it.ethica.esf.service.persistence.ESFDocumentTypePersistence;
import it.ethica.esf.service.persistence.ESFOrganizationPersistence;
import it.ethica.esf.service.persistence.ESFOrganizationTypePersistence;
import it.ethica.esf.service.persistence.ESFTypePersistence;
import it.ethica.esf.service.persistence.ESFUserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the e s f organization type local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link it.ethica.esf.service.impl.ESFOrganizationTypeLocalServiceImpl}.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.impl.ESFOrganizationTypeLocalServiceImpl
 * @see it.ethica.esf.service.ESFOrganizationTypeLocalServiceUtil
 * @generated
 */
public abstract class ESFOrganizationTypeLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements ESFOrganizationTypeLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link it.ethica.esf.service.ESFOrganizationTypeLocalServiceUtil} to access the e s f organization type local service.
	 */

	/**
	 * Adds the e s f organization type to the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfOrganizationType the e s f organization type
	 * @return the e s f organization type that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ESFOrganizationType addESFOrganizationType(
		ESFOrganizationType esfOrganizationType) throws SystemException {
		esfOrganizationType.setNew(true);

		return esfOrganizationTypePersistence.update(esfOrganizationType);
	}

	/**
	 * Creates a new e s f organization type with the primary key. Does not add the e s f organization type to the database.
	 *
	 * @param esfOrganizationTypeId the primary key for the new e s f organization type
	 * @return the new e s f organization type
	 */
	@Override
	public ESFOrganizationType createESFOrganizationType(
		long esfOrganizationTypeId) {
		return esfOrganizationTypePersistence.create(esfOrganizationTypeId);
	}

	/**
	 * Deletes the e s f organization type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfOrganizationTypeId the primary key of the e s f organization type
	 * @return the e s f organization type that was removed
	 * @throws PortalException if a e s f organization type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ESFOrganizationType deleteESFOrganizationType(
		long esfOrganizationTypeId) throws PortalException, SystemException {
		return esfOrganizationTypePersistence.remove(esfOrganizationTypeId);
	}

	/**
	 * Deletes the e s f organization type from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfOrganizationType the e s f organization type
	 * @return the e s f organization type that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ESFOrganizationType deleteESFOrganizationType(
		ESFOrganizationType esfOrganizationType) throws SystemException {
		return esfOrganizationTypePersistence.remove(esfOrganizationType);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(ESFOrganizationType.class,
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
		return esfOrganizationTypePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return esfOrganizationTypePersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return esfOrganizationTypePersistence.findWithDynamicQuery(dynamicQuery,
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
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return esfOrganizationTypePersistence.countWithDynamicQuery(dynamicQuery);
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
		return esfOrganizationTypePersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public ESFOrganizationType fetchESFOrganizationType(
		long esfOrganizationTypeId) throws SystemException {
		return esfOrganizationTypePersistence.fetchByPrimaryKey(esfOrganizationTypeId);
	}

	/**
	 * Returns the e s f organization type with the primary key.
	 *
	 * @param esfOrganizationTypeId the primary key of the e s f organization type
	 * @return the e s f organization type
	 * @throws PortalException if a e s f organization type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFOrganizationType getESFOrganizationType(
		long esfOrganizationTypeId) throws PortalException, SystemException {
		return esfOrganizationTypePersistence.findByPrimaryKey(esfOrganizationTypeId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return esfOrganizationTypePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the e s f organization types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFOrganizationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f organization types
	 * @param end the upper bound of the range of e s f organization types (not inclusive)
	 * @return the range of e s f organization types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFOrganizationType> getESFOrganizationTypes(int start, int end)
		throws SystemException {
		return esfOrganizationTypePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of e s f organization types.
	 *
	 * @return the number of e s f organization types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getESFOrganizationTypesCount() throws SystemException {
		return esfOrganizationTypePersistence.countAll();
	}

	/**
	 * Updates the e s f organization type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param esfOrganizationType the e s f organization type
	 * @return the e s f organization type that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ESFOrganizationType updateESFOrganizationType(
		ESFOrganizationType esfOrganizationType) throws SystemException {
		return esfOrganizationTypePersistence.update(esfOrganizationType);
	}

	/**
	 * Returns the e s f card local service.
	 *
	 * @return the e s f card local service
	 */
	public it.ethica.esf.service.ESFCardLocalService getESFCardLocalService() {
		return esfCardLocalService;
	}

	/**
	 * Sets the e s f card local service.
	 *
	 * @param esfCardLocalService the e s f card local service
	 */
	public void setESFCardLocalService(
		it.ethica.esf.service.ESFCardLocalService esfCardLocalService) {
		this.esfCardLocalService = esfCardLocalService;
	}

	/**
	 * Returns the e s f card persistence.
	 *
	 * @return the e s f card persistence
	 */
	public ESFCardPersistence getESFCardPersistence() {
		return esfCardPersistence;
	}

	/**
	 * Sets the e s f card persistence.
	 *
	 * @param esfCardPersistence the e s f card persistence
	 */
	public void setESFCardPersistence(ESFCardPersistence esfCardPersistence) {
		this.esfCardPersistence = esfCardPersistence;
	}

	/**
	 * Returns the e s f document local service.
	 *
	 * @return the e s f document local service
	 */
	public it.ethica.esf.service.ESFDocumentLocalService getESFDocumentLocalService() {
		return esfDocumentLocalService;
	}

	/**
	 * Sets the e s f document local service.
	 *
	 * @param esfDocumentLocalService the e s f document local service
	 */
	public void setESFDocumentLocalService(
		it.ethica.esf.service.ESFDocumentLocalService esfDocumentLocalService) {
		this.esfDocumentLocalService = esfDocumentLocalService;
	}

	/**
	 * Returns the e s f document persistence.
	 *
	 * @return the e s f document persistence
	 */
	public ESFDocumentPersistence getESFDocumentPersistence() {
		return esfDocumentPersistence;
	}

	/**
	 * Sets the e s f document persistence.
	 *
	 * @param esfDocumentPersistence the e s f document persistence
	 */
	public void setESFDocumentPersistence(
		ESFDocumentPersistence esfDocumentPersistence) {
		this.esfDocumentPersistence = esfDocumentPersistence;
	}

	/**
	 * Returns the e s f document type local service.
	 *
	 * @return the e s f document type local service
	 */
	public it.ethica.esf.service.ESFDocumentTypeLocalService getESFDocumentTypeLocalService() {
		return esfDocumentTypeLocalService;
	}

	/**
	 * Sets the e s f document type local service.
	 *
	 * @param esfDocumentTypeLocalService the e s f document type local service
	 */
	public void setESFDocumentTypeLocalService(
		it.ethica.esf.service.ESFDocumentTypeLocalService esfDocumentTypeLocalService) {
		this.esfDocumentTypeLocalService = esfDocumentTypeLocalService;
	}

	/**
	 * Returns the e s f document type persistence.
	 *
	 * @return the e s f document type persistence
	 */
	public ESFDocumentTypePersistence getESFDocumentTypePersistence() {
		return esfDocumentTypePersistence;
	}

	/**
	 * Sets the e s f document type persistence.
	 *
	 * @param esfDocumentTypePersistence the e s f document type persistence
	 */
	public void setESFDocumentTypePersistence(
		ESFDocumentTypePersistence esfDocumentTypePersistence) {
		this.esfDocumentTypePersistence = esfDocumentTypePersistence;
	}

	/**
	 * Returns the e s f organization local service.
	 *
	 * @return the e s f organization local service
	 */
	public it.ethica.esf.service.ESFOrganizationLocalService getESFOrganizationLocalService() {
		return esfOrganizationLocalService;
	}

	/**
	 * Sets the e s f organization local service.
	 *
	 * @param esfOrganizationLocalService the e s f organization local service
	 */
	public void setESFOrganizationLocalService(
		it.ethica.esf.service.ESFOrganizationLocalService esfOrganizationLocalService) {
		this.esfOrganizationLocalService = esfOrganizationLocalService;
	}

	/**
	 * Returns the e s f organization persistence.
	 *
	 * @return the e s f organization persistence
	 */
	public ESFOrganizationPersistence getESFOrganizationPersistence() {
		return esfOrganizationPersistence;
	}

	/**
	 * Sets the e s f organization persistence.
	 *
	 * @param esfOrganizationPersistence the e s f organization persistence
	 */
	public void setESFOrganizationPersistence(
		ESFOrganizationPersistence esfOrganizationPersistence) {
		this.esfOrganizationPersistence = esfOrganizationPersistence;
	}

	/**
	 * Returns the e s f organization type local service.
	 *
	 * @return the e s f organization type local service
	 */
	public it.ethica.esf.service.ESFOrganizationTypeLocalService getESFOrganizationTypeLocalService() {
		return esfOrganizationTypeLocalService;
	}

	/**
	 * Sets the e s f organization type local service.
	 *
	 * @param esfOrganizationTypeLocalService the e s f organization type local service
	 */
	public void setESFOrganizationTypeLocalService(
		it.ethica.esf.service.ESFOrganizationTypeLocalService esfOrganizationTypeLocalService) {
		this.esfOrganizationTypeLocalService = esfOrganizationTypeLocalService;
	}

	/**
	 * Returns the e s f organization type persistence.
	 *
	 * @return the e s f organization type persistence
	 */
	public ESFOrganizationTypePersistence getESFOrganizationTypePersistence() {
		return esfOrganizationTypePersistence;
	}

	/**
	 * Sets the e s f organization type persistence.
	 *
	 * @param esfOrganizationTypePersistence the e s f organization type persistence
	 */
	public void setESFOrganizationTypePersistence(
		ESFOrganizationTypePersistence esfOrganizationTypePersistence) {
		this.esfOrganizationTypePersistence = esfOrganizationTypePersistence;
	}

	/**
	 * Returns the e s f type local service.
	 *
	 * @return the e s f type local service
	 */
	public it.ethica.esf.service.ESFTypeLocalService getESFTypeLocalService() {
		return esfTypeLocalService;
	}

	/**
	 * Sets the e s f type local service.
	 *
	 * @param esfTypeLocalService the e s f type local service
	 */
	public void setESFTypeLocalService(
		it.ethica.esf.service.ESFTypeLocalService esfTypeLocalService) {
		this.esfTypeLocalService = esfTypeLocalService;
	}

	/**
	 * Returns the e s f type persistence.
	 *
	 * @return the e s f type persistence
	 */
	public ESFTypePersistence getESFTypePersistence() {
		return esfTypePersistence;
	}

	/**
	 * Sets the e s f type persistence.
	 *
	 * @param esfTypePersistence the e s f type persistence
	 */
	public void setESFTypePersistence(ESFTypePersistence esfTypePersistence) {
		this.esfTypePersistence = esfTypePersistence;
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

		PersistedModelLocalServiceRegistryUtil.register("it.ethica.esf.model.ESFOrganizationType",
			esfOrganizationTypeLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"it.ethica.esf.model.ESFOrganizationType");
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
		return ESFOrganizationType.class;
	}

	protected String getModelClassName() {
		return ESFOrganizationType.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = esfOrganizationTypePersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = it.ethica.esf.service.ESFCardLocalService.class)
	protected it.ethica.esf.service.ESFCardLocalService esfCardLocalService;
	@BeanReference(type = ESFCardPersistence.class)
	protected ESFCardPersistence esfCardPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFDocumentLocalService.class)
	protected it.ethica.esf.service.ESFDocumentLocalService esfDocumentLocalService;
	@BeanReference(type = ESFDocumentPersistence.class)
	protected ESFDocumentPersistence esfDocumentPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFDocumentTypeLocalService.class)
	protected it.ethica.esf.service.ESFDocumentTypeLocalService esfDocumentTypeLocalService;
	@BeanReference(type = ESFDocumentTypePersistence.class)
	protected ESFDocumentTypePersistence esfDocumentTypePersistence;
	@BeanReference(type = it.ethica.esf.service.ESFOrganizationLocalService.class)
	protected it.ethica.esf.service.ESFOrganizationLocalService esfOrganizationLocalService;
	@BeanReference(type = ESFOrganizationPersistence.class)
	protected ESFOrganizationPersistence esfOrganizationPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFOrganizationTypeLocalService.class)
	protected it.ethica.esf.service.ESFOrganizationTypeLocalService esfOrganizationTypeLocalService;
	@BeanReference(type = ESFOrganizationTypePersistence.class)
	protected ESFOrganizationTypePersistence esfOrganizationTypePersistence;
	@BeanReference(type = it.ethica.esf.service.ESFTypeLocalService.class)
	protected it.ethica.esf.service.ESFTypeLocalService esfTypeLocalService;
	@BeanReference(type = ESFTypePersistence.class)
	protected ESFTypePersistence esfTypePersistence;
	@BeanReference(type = it.ethica.esf.service.ESFUserLocalService.class)
	protected it.ethica.esf.service.ESFUserLocalService esfUserLocalService;
	@BeanReference(type = ESFUserPersistence.class)
	protected ESFUserPersistence esfUserPersistence;
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
	private ESFOrganizationTypeLocalServiceClpInvoker _clpInvoker = new ESFOrganizationTypeLocalServiceClpInvoker();
}