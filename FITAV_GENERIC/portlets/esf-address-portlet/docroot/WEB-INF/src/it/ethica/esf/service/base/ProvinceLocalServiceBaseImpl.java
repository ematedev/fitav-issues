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

import it.ethica.esf.model.Province;
import it.ethica.esf.service.ProvinceLocalService;
import it.ethica.esf.service.persistence.CityPersistence;
import it.ethica.esf.service.persistence.CountryPersistence;
import it.ethica.esf.service.persistence.ESFAddressPersistence;
import it.ethica.esf.service.persistence.ProvincePK;
import it.ethica.esf.service.persistence.ProvincePersistence;
import it.ethica.esf.service.persistence.RegionPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the province local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link it.ethica.esf.service.impl.ProvinceLocalServiceImpl}.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.impl.ProvinceLocalServiceImpl
 * @see it.ethica.esf.service.ProvinceLocalServiceUtil
 * @generated
 */
public abstract class ProvinceLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements ProvinceLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link it.ethica.esf.service.ProvinceLocalServiceUtil} to access the province local service.
	 */

	/**
	 * Adds the province to the database. Also notifies the appropriate model listeners.
	 *
	 * @param province the province
	 * @return the province that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Province addProvince(Province province) throws SystemException {
		province.setNew(true);

		return provincePersistence.update(province);
	}

	/**
	 * Creates a new province with the primary key. Does not add the province to the database.
	 *
	 * @param provincePK the primary key for the new province
	 * @return the new province
	 */
	@Override
	public Province createProvince(ProvincePK provincePK) {
		return provincePersistence.create(provincePK);
	}

	/**
	 * Deletes the province with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param provincePK the primary key of the province
	 * @return the province that was removed
	 * @throws PortalException if a province with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Province deleteProvince(ProvincePK provincePK)
		throws PortalException, SystemException {
		return provincePersistence.remove(provincePK);
	}

	/**
	 * Deletes the province from the database. Also notifies the appropriate model listeners.
	 *
	 * @param province the province
	 * @return the province that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Province deleteProvince(Province province) throws SystemException {
		return provincePersistence.remove(province);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Province.class,
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
		return provincePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ProvinceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return provincePersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ProvinceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return provincePersistence.findWithDynamicQuery(dynamicQuery, start,
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
		return provincePersistence.countWithDynamicQuery(dynamicQuery);
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
		return provincePersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public Province fetchProvince(ProvincePK provincePK)
		throws SystemException {
		return provincePersistence.fetchByPrimaryKey(provincePK);
	}

	/**
	 * Returns the province with the primary key.
	 *
	 * @param provincePK the primary key of the province
	 * @return the province
	 * @throws PortalException if a province with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Province getProvince(ProvincePK provincePK)
		throws PortalException, SystemException {
		return provincePersistence.findByPrimaryKey(provincePK);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return provincePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the provinces.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ProvinceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of provinces
	 * @param end the upper bound of the range of provinces (not inclusive)
	 * @return the range of provinces
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Province> getProvinces(int start, int end)
		throws SystemException {
		return provincePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of provinces.
	 *
	 * @return the number of provinces
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getProvincesCount() throws SystemException {
		return provincePersistence.countAll();
	}

	/**
	 * Updates the province in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param province the province
	 * @return the province that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Province updateProvince(Province province) throws SystemException {
		return provincePersistence.update(province);
	}

	/**
	 * Returns the city local service.
	 *
	 * @return the city local service
	 */
	public it.ethica.esf.service.CityLocalService getCityLocalService() {
		return cityLocalService;
	}

	/**
	 * Sets the city local service.
	 *
	 * @param cityLocalService the city local service
	 */
	public void setCityLocalService(
		it.ethica.esf.service.CityLocalService cityLocalService) {
		this.cityLocalService = cityLocalService;
	}

	/**
	 * Returns the city persistence.
	 *
	 * @return the city persistence
	 */
	public CityPersistence getCityPersistence() {
		return cityPersistence;
	}

	/**
	 * Sets the city persistence.
	 *
	 * @param cityPersistence the city persistence
	 */
	public void setCityPersistence(CityPersistence cityPersistence) {
		this.cityPersistence = cityPersistence;
	}

	/**
	 * Returns the country local service.
	 *
	 * @return the country local service
	 */
	public it.ethica.esf.service.CountryLocalService getCountryLocalService() {
		return countryLocalService;
	}

	/**
	 * Sets the country local service.
	 *
	 * @param countryLocalService the country local service
	 */
	public void setCountryLocalService(
		it.ethica.esf.service.CountryLocalService countryLocalService) {
		this.countryLocalService = countryLocalService;
	}

	/**
	 * Returns the country persistence.
	 *
	 * @return the country persistence
	 */
	public CountryPersistence getCountryPersistence() {
		return countryPersistence;
	}

	/**
	 * Sets the country persistence.
	 *
	 * @param countryPersistence the country persistence
	 */
	public void setCountryPersistence(CountryPersistence countryPersistence) {
		this.countryPersistence = countryPersistence;
	}

	/**
	 * Returns the e s f address local service.
	 *
	 * @return the e s f address local service
	 */
	public it.ethica.esf.service.ESFAddressLocalService getESFAddressLocalService() {
		return esfAddressLocalService;
	}

	/**
	 * Sets the e s f address local service.
	 *
	 * @param esfAddressLocalService the e s f address local service
	 */
	public void setESFAddressLocalService(
		it.ethica.esf.service.ESFAddressLocalService esfAddressLocalService) {
		this.esfAddressLocalService = esfAddressLocalService;
	}

	/**
	 * Returns the e s f address persistence.
	 *
	 * @return the e s f address persistence
	 */
	public ESFAddressPersistence getESFAddressPersistence() {
		return esfAddressPersistence;
	}

	/**
	 * Sets the e s f address persistence.
	 *
	 * @param esfAddressPersistence the e s f address persistence
	 */
	public void setESFAddressPersistence(
		ESFAddressPersistence esfAddressPersistence) {
		this.esfAddressPersistence = esfAddressPersistence;
	}

	/**
	 * Returns the province local service.
	 *
	 * @return the province local service
	 */
	public it.ethica.esf.service.ProvinceLocalService getProvinceLocalService() {
		return provinceLocalService;
	}

	/**
	 * Sets the province local service.
	 *
	 * @param provinceLocalService the province local service
	 */
	public void setProvinceLocalService(
		it.ethica.esf.service.ProvinceLocalService provinceLocalService) {
		this.provinceLocalService = provinceLocalService;
	}

	/**
	 * Returns the province persistence.
	 *
	 * @return the province persistence
	 */
	public ProvincePersistence getProvincePersistence() {
		return provincePersistence;
	}

	/**
	 * Sets the province persistence.
	 *
	 * @param provincePersistence the province persistence
	 */
	public void setProvincePersistence(ProvincePersistence provincePersistence) {
		this.provincePersistence = provincePersistence;
	}

	/**
	 * Returns the region local service.
	 *
	 * @return the region local service
	 */
	public it.ethica.esf.service.RegionLocalService getRegionLocalService() {
		return regionLocalService;
	}

	/**
	 * Sets the region local service.
	 *
	 * @param regionLocalService the region local service
	 */
	public void setRegionLocalService(
		it.ethica.esf.service.RegionLocalService regionLocalService) {
		this.regionLocalService = regionLocalService;
	}

	/**
	 * Returns the region persistence.
	 *
	 * @return the region persistence
	 */
	public RegionPersistence getRegionPersistence() {
		return regionPersistence;
	}

	/**
	 * Sets the region persistence.
	 *
	 * @param regionPersistence the region persistence
	 */
	public void setRegionPersistence(RegionPersistence regionPersistence) {
		this.regionPersistence = regionPersistence;
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

		PersistedModelLocalServiceRegistryUtil.register("it.ethica.esf.model.Province",
			provinceLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"it.ethica.esf.model.Province");
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
		return Province.class;
	}

	protected String getModelClassName() {
		return Province.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = provincePersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = it.ethica.esf.service.CityLocalService.class)
	protected it.ethica.esf.service.CityLocalService cityLocalService;
	@BeanReference(type = CityPersistence.class)
	protected CityPersistence cityPersistence;
	@BeanReference(type = it.ethica.esf.service.CountryLocalService.class)
	protected it.ethica.esf.service.CountryLocalService countryLocalService;
	@BeanReference(type = CountryPersistence.class)
	protected CountryPersistence countryPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFAddressLocalService.class)
	protected it.ethica.esf.service.ESFAddressLocalService esfAddressLocalService;
	@BeanReference(type = ESFAddressPersistence.class)
	protected ESFAddressPersistence esfAddressPersistence;
	@BeanReference(type = it.ethica.esf.service.ProvinceLocalService.class)
	protected it.ethica.esf.service.ProvinceLocalService provinceLocalService;
	@BeanReference(type = ProvincePersistence.class)
	protected ProvincePersistence provincePersistence;
	@BeanReference(type = it.ethica.esf.service.RegionLocalService.class)
	protected it.ethica.esf.service.RegionLocalService regionLocalService;
	@BeanReference(type = RegionPersistence.class)
	protected RegionPersistence regionPersistence;
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
	private ProvinceLocalServiceClpInvoker _clpInvoker = new ProvinceLocalServiceClpInvoker();
}