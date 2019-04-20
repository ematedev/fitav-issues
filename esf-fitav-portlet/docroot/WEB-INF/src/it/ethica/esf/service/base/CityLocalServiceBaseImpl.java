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

import it.ethica.esf.model.City;
import it.ethica.esf.service.CityLocalService;
import it.ethica.esf.service.persistence.CityPK;
import it.ethica.esf.service.persistence.CityPersistence;
import it.ethica.esf.service.persistence.CountryPersistence;
import it.ethica.esf.service.persistence.ESFAddressPersistence;
import it.ethica.esf.service.persistence.ESFFieldESFSportTypePersistence;
import it.ethica.esf.service.persistence.ESFFieldPersistence;
import it.ethica.esf.service.persistence.ESFGunKindPersistence;
import it.ethica.esf.service.persistence.ESFGunPersistence;
import it.ethica.esf.service.persistence.ESFGunTypePersistence;
import it.ethica.esf.service.persistence.ESFOrganizationPersistence;
import it.ethica.esf.service.persistence.ESFSportTypePersistence;
import it.ethica.esf.service.persistence.ESFToolPersistence;
import it.ethica.esf.service.persistence.ESFToolRelPersistence;
import it.ethica.esf.service.persistence.ESFUserESFUserRolePersistence;
import it.ethica.esf.service.persistence.ESFUserPersistence;
import it.ethica.esf.service.persistence.ESFUserRolePersistence;
import it.ethica.esf.service.persistence.ProvincePersistence;
import it.ethica.esf.service.persistence.RegionPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the city local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link it.ethica.esf.service.impl.CityLocalServiceImpl}.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.impl.CityLocalServiceImpl
 * @see it.ethica.esf.service.CityLocalServiceUtil
 * @generated
 */
public abstract class CityLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements CityLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link it.ethica.esf.service.CityLocalServiceUtil} to access the city local service.
	 */

	/**
	 * Adds the city to the database. Also notifies the appropriate model listeners.
	 *
	 * @param city the city
	 * @return the city that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public City addCity(City city) throws SystemException {
		city.setNew(true);

		return cityPersistence.update(city);
	}

	/**
	 * Creates a new city with the primary key. Does not add the city to the database.
	 *
	 * @param cityPK the primary key for the new city
	 * @return the new city
	 */
	@Override
	public City createCity(CityPK cityPK) {
		return cityPersistence.create(cityPK);
	}

	/**
	 * Deletes the city with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cityPK the primary key of the city
	 * @return the city that was removed
	 * @throws PortalException if a city with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public City deleteCity(CityPK cityPK)
		throws PortalException, SystemException {
		return cityPersistence.remove(cityPK);
	}

	/**
	 * Deletes the city from the database. Also notifies the appropriate model listeners.
	 *
	 * @param city the city
	 * @return the city that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public City deleteCity(City city) throws SystemException {
		return cityPersistence.remove(city);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(City.class,
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
		return cityPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.CityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return cityPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.CityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return cityPersistence.findWithDynamicQuery(dynamicQuery, start, end,
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
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return cityPersistence.countWithDynamicQuery(dynamicQuery);
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
		return cityPersistence.countWithDynamicQuery(dynamicQuery, projection);
	}

	@Override
	public City fetchCity(CityPK cityPK) throws SystemException {
		return cityPersistence.fetchByPrimaryKey(cityPK);
	}

	/**
	 * Returns the city with the primary key.
	 *
	 * @param cityPK the primary key of the city
	 * @return the city
	 * @throws PortalException if a city with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public City getCity(CityPK cityPK) throws PortalException, SystemException {
		return cityPersistence.findByPrimaryKey(cityPK);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return cityPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the cities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.CityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cities
	 * @param end the upper bound of the range of cities (not inclusive)
	 * @return the range of cities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<City> getCities(int start, int end) throws SystemException {
		return cityPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of cities.
	 *
	 * @return the number of cities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getCitiesCount() throws SystemException {
		return cityPersistence.countAll();
	}

	/**
	 * Updates the city in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param city the city
	 * @return the city that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public City updateCity(City city) throws SystemException {
		return cityPersistence.update(city);
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
	 * Returns the e s f field local service.
	 *
	 * @return the e s f field local service
	 */
	public it.ethica.esf.service.ESFFieldLocalService getESFFieldLocalService() {
		return esfFieldLocalService;
	}

	/**
	 * Sets the e s f field local service.
	 *
	 * @param esfFieldLocalService the e s f field local service
	 */
	public void setESFFieldLocalService(
		it.ethica.esf.service.ESFFieldLocalService esfFieldLocalService) {
		this.esfFieldLocalService = esfFieldLocalService;
	}

	/**
	 * Returns the e s f field persistence.
	 *
	 * @return the e s f field persistence
	 */
	public ESFFieldPersistence getESFFieldPersistence() {
		return esfFieldPersistence;
	}

	/**
	 * Sets the e s f field persistence.
	 *
	 * @param esfFieldPersistence the e s f field persistence
	 */
	public void setESFFieldPersistence(ESFFieldPersistence esfFieldPersistence) {
		this.esfFieldPersistence = esfFieldPersistence;
	}

	/**
	 * Returns the e s f field e s f sport type persistence.
	 *
	 * @return the e s f field e s f sport type persistence
	 */
	public ESFFieldESFSportTypePersistence getESFFieldESFSportTypePersistence() {
		return esfFieldESFSportTypePersistence;
	}

	/**
	 * Sets the e s f field e s f sport type persistence.
	 *
	 * @param esfFieldESFSportTypePersistence the e s f field e s f sport type persistence
	 */
	public void setESFFieldESFSportTypePersistence(
		ESFFieldESFSportTypePersistence esfFieldESFSportTypePersistence) {
		this.esfFieldESFSportTypePersistence = esfFieldESFSportTypePersistence;
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
	 * Returns the e s f sport type local service.
	 *
	 * @return the e s f sport type local service
	 */
	public it.ethica.esf.service.ESFSportTypeLocalService getESFSportTypeLocalService() {
		return esfSportTypeLocalService;
	}

	/**
	 * Sets the e s f sport type local service.
	 *
	 * @param esfSportTypeLocalService the e s f sport type local service
	 */
	public void setESFSportTypeLocalService(
		it.ethica.esf.service.ESFSportTypeLocalService esfSportTypeLocalService) {
		this.esfSportTypeLocalService = esfSportTypeLocalService;
	}

	/**
	 * Returns the e s f sport type persistence.
	 *
	 * @return the e s f sport type persistence
	 */
	public ESFSportTypePersistence getESFSportTypePersistence() {
		return esfSportTypePersistence;
	}

	/**
	 * Sets the e s f sport type persistence.
	 *
	 * @param esfSportTypePersistence the e s f sport type persistence
	 */
	public void setESFSportTypePersistence(
		ESFSportTypePersistence esfSportTypePersistence) {
		this.esfSportTypePersistence = esfSportTypePersistence;
	}

	/**
	 * Returns the e s f tool local service.
	 *
	 * @return the e s f tool local service
	 */
	public it.ethica.esf.service.ESFToolLocalService getESFToolLocalService() {
		return esfToolLocalService;
	}

	/**
	 * Sets the e s f tool local service.
	 *
	 * @param esfToolLocalService the e s f tool local service
	 */
	public void setESFToolLocalService(
		it.ethica.esf.service.ESFToolLocalService esfToolLocalService) {
		this.esfToolLocalService = esfToolLocalService;
	}

	/**
	 * Returns the e s f tool persistence.
	 *
	 * @return the e s f tool persistence
	 */
	public ESFToolPersistence getESFToolPersistence() {
		return esfToolPersistence;
	}

	/**
	 * Sets the e s f tool persistence.
	 *
	 * @param esfToolPersistence the e s f tool persistence
	 */
	public void setESFToolPersistence(ESFToolPersistence esfToolPersistence) {
		this.esfToolPersistence = esfToolPersistence;
	}

	/**
	 * Returns the e s f tool rel persistence.
	 *
	 * @return the e s f tool rel persistence
	 */
	public ESFToolRelPersistence getESFToolRelPersistence() {
		return esfToolRelPersistence;
	}

	/**
	 * Sets the e s f tool rel persistence.
	 *
	 * @param esfToolRelPersistence the e s f tool rel persistence
	 */
	public void setESFToolRelPersistence(
		ESFToolRelPersistence esfToolRelPersistence) {
		this.esfToolRelPersistence = esfToolRelPersistence;
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

		PersistedModelLocalServiceRegistryUtil.register("it.ethica.esf.model.City",
			cityLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"it.ethica.esf.model.City");
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
		return City.class;
	}

	protected String getModelClassName() {
		return City.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = cityPersistence.getDataSource();

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
	@BeanReference(type = it.ethica.esf.service.ESFFieldLocalService.class)
	protected it.ethica.esf.service.ESFFieldLocalService esfFieldLocalService;
	@BeanReference(type = ESFFieldPersistence.class)
	protected ESFFieldPersistence esfFieldPersistence;
	@BeanReference(type = ESFFieldESFSportTypePersistence.class)
	protected ESFFieldESFSportTypePersistence esfFieldESFSportTypePersistence;
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
	@BeanReference(type = it.ethica.esf.service.ESFOrganizationLocalService.class)
	protected it.ethica.esf.service.ESFOrganizationLocalService esfOrganizationLocalService;
	@BeanReference(type = ESFOrganizationPersistence.class)
	protected ESFOrganizationPersistence esfOrganizationPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFSportTypeLocalService.class)
	protected it.ethica.esf.service.ESFSportTypeLocalService esfSportTypeLocalService;
	@BeanReference(type = ESFSportTypePersistence.class)
	protected ESFSportTypePersistence esfSportTypePersistence;
	@BeanReference(type = it.ethica.esf.service.ESFToolLocalService.class)
	protected it.ethica.esf.service.ESFToolLocalService esfToolLocalService;
	@BeanReference(type = ESFToolPersistence.class)
	protected ESFToolPersistence esfToolPersistence;
	@BeanReference(type = ESFToolRelPersistence.class)
	protected ESFToolRelPersistence esfToolRelPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFUserLocalService.class)
	protected it.ethica.esf.service.ESFUserLocalService esfUserLocalService;
	@BeanReference(type = ESFUserPersistence.class)
	protected ESFUserPersistence esfUserPersistence;
	@BeanReference(type = ESFUserESFUserRolePersistence.class)
	protected ESFUserESFUserRolePersistence esfUserESFUserRolePersistence;
	@BeanReference(type = it.ethica.esf.service.ESFUserRoleLocalService.class)
	protected it.ethica.esf.service.ESFUserRoleLocalService esfUserRoleLocalService;
	@BeanReference(type = ESFUserRolePersistence.class)
	protected ESFUserRolePersistence esfUserRolePersistence;
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
	private CityLocalServiceClpInvoker _clpInvoker = new CityLocalServiceClpInvoker();
}