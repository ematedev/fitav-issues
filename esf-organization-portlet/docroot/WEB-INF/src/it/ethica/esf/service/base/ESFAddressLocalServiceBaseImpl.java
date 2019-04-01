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
import com.liferay.portal.service.persistence.AddressPersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.portlet.asset.service.persistence.AssetEntryPersistence;
import com.liferay.portlet.asset.service.persistence.AssetLinkPersistence;

import it.ethica.esf.model.ESFAddress;
import it.ethica.esf.service.ESFAddressLocalService;
import it.ethica.esf.service.persistence.ESFAddressPersistence;
import it.ethica.esf.service.persistence.ESFFieldESFSportTypePersistence;
import it.ethica.esf.service.persistence.ESFFieldPersistence;
import it.ethica.esf.service.persistence.ESFOrganizationPersistence;
import it.ethica.esf.service.persistence.ESFSportTypePersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the e s f address local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link it.ethica.esf.service.impl.ESFAddressLocalServiceImpl}.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.impl.ESFAddressLocalServiceImpl
 * @see it.ethica.esf.service.ESFAddressLocalServiceUtil
 * @generated
 */
public abstract class ESFAddressLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements ESFAddressLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link it.ethica.esf.service.ESFAddressLocalServiceUtil} to access the e s f address local service.
	 */

	/**
	 * Adds the e s f address to the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfAddress the e s f address
	 * @return the e s f address that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ESFAddress addESFAddress(ESFAddress esfAddress)
		throws SystemException {
		esfAddress.setNew(true);

		return esfAddressPersistence.update(esfAddress);
	}

	/**
	 * Creates a new e s f address with the primary key. Does not add the e s f address to the database.
	 *
	 * @param esfAddressId the primary key for the new e s f address
	 * @return the new e s f address
	 */
	@Override
	public ESFAddress createESFAddress(long esfAddressId) {
		return esfAddressPersistence.create(esfAddressId);
	}

	/**
	 * Deletes the e s f address with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfAddressId the primary key of the e s f address
	 * @return the e s f address that was removed
	 * @throws PortalException if a e s f address with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ESFAddress deleteESFAddress(long esfAddressId)
		throws PortalException, SystemException {
		return esfAddressPersistence.remove(esfAddressId);
	}

	/**
	 * Deletes the e s f address from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfAddress the e s f address
	 * @return the e s f address that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ESFAddress deleteESFAddress(ESFAddress esfAddress)
		throws SystemException {
		return esfAddressPersistence.remove(esfAddress);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(ESFAddress.class,
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
		return esfAddressPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return esfAddressPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return esfAddressPersistence.findWithDynamicQuery(dynamicQuery, start,
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
		return esfAddressPersistence.countWithDynamicQuery(dynamicQuery);
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
		return esfAddressPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public ESFAddress fetchESFAddress(long esfAddressId)
		throws SystemException {
		return esfAddressPersistence.fetchByPrimaryKey(esfAddressId);
	}

	/**
	 * Returns the e s f address matching the UUID and group.
	 *
	 * @param uuid the e s f address's UUID
	 * @param groupId the primary key of the group
	 * @return the matching e s f address, or <code>null</code> if a matching e s f address could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAddress fetchESFAddressByUuidAndGroupId(String uuid, long groupId)
		throws SystemException {
		return esfAddressPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the e s f address with the primary key.
	 *
	 * @param esfAddressId the primary key of the e s f address
	 * @return the e s f address
	 * @throws PortalException if a e s f address with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAddress getESFAddress(long esfAddressId)
		throws PortalException, SystemException {
		return esfAddressPersistence.findByPrimaryKey(esfAddressId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return esfAddressPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns the e s f address matching the UUID and group.
	 *
	 * @param uuid the e s f address's UUID
	 * @param groupId the primary key of the group
	 * @return the matching e s f address
	 * @throws PortalException if a matching e s f address could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFAddress getESFAddressByUuidAndGroupId(String uuid, long groupId)
		throws PortalException, SystemException {
		return esfAddressPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the e s f addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFAddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f addresses
	 * @param end the upper bound of the range of e s f addresses (not inclusive)
	 * @return the range of e s f addresses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFAddress> getESFAddresses(int start, int end)
		throws SystemException {
		return esfAddressPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of e s f addresses.
	 *
	 * @return the number of e s f addresses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getESFAddressesCount() throws SystemException {
		return esfAddressPersistence.countAll();
	}

	/**
	 * Updates the e s f address in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param esfAddress the e s f address
	 * @return the e s f address that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ESFAddress updateESFAddress(ESFAddress esfAddress)
		throws SystemException {
		return esfAddressPersistence.update(esfAddress);
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
	 * Returns the e s f field e s f sport type local service.
	 *
	 * @return the e s f field e s f sport type local service
	 */
	public it.ethica.esf.service.ESFFieldESFSportTypeLocalService getESFFieldESFSportTypeLocalService() {
		return esfFieldESFSportTypeLocalService;
	}

	/**
	 * Sets the e s f field e s f sport type local service.
	 *
	 * @param esfFieldESFSportTypeLocalService the e s f field e s f sport type local service
	 */
	public void setESFFieldESFSportTypeLocalService(
		it.ethica.esf.service.ESFFieldESFSportTypeLocalService esfFieldESFSportTypeLocalService) {
		this.esfFieldESFSportTypeLocalService = esfFieldESFSportTypeLocalService;
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
	 * Returns the address local service.
	 *
	 * @return the address local service
	 */
	public com.liferay.portal.service.AddressLocalService getAddressLocalService() {
		return addressLocalService;
	}

	/**
	 * Sets the address local service.
	 *
	 * @param addressLocalService the address local service
	 */
	public void setAddressLocalService(
		com.liferay.portal.service.AddressLocalService addressLocalService) {
		this.addressLocalService = addressLocalService;
	}

	/**
	 * Returns the address remote service.
	 *
	 * @return the address remote service
	 */
	public com.liferay.portal.service.AddressService getAddressService() {
		return addressService;
	}

	/**
	 * Sets the address remote service.
	 *
	 * @param addressService the address remote service
	 */
	public void setAddressService(
		com.liferay.portal.service.AddressService addressService) {
		this.addressService = addressService;
	}

	/**
	 * Returns the address persistence.
	 *
	 * @return the address persistence
	 */
	public AddressPersistence getAddressPersistence() {
		return addressPersistence;
	}

	/**
	 * Sets the address persistence.
	 *
	 * @param addressPersistence the address persistence
	 */
	public void setAddressPersistence(AddressPersistence addressPersistence) {
		this.addressPersistence = addressPersistence;
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

	/**
	 * Returns the asset entry local service.
	 *
	 * @return the asset entry local service
	 */
	public com.liferay.portlet.asset.service.AssetEntryLocalService getAssetEntryLocalService() {
		return assetEntryLocalService;
	}

	/**
	 * Sets the asset entry local service.
	 *
	 * @param assetEntryLocalService the asset entry local service
	 */
	public void setAssetEntryLocalService(
		com.liferay.portlet.asset.service.AssetEntryLocalService assetEntryLocalService) {
		this.assetEntryLocalService = assetEntryLocalService;
	}

	/**
	 * Returns the asset entry remote service.
	 *
	 * @return the asset entry remote service
	 */
	public com.liferay.portlet.asset.service.AssetEntryService getAssetEntryService() {
		return assetEntryService;
	}

	/**
	 * Sets the asset entry remote service.
	 *
	 * @param assetEntryService the asset entry remote service
	 */
	public void setAssetEntryService(
		com.liferay.portlet.asset.service.AssetEntryService assetEntryService) {
		this.assetEntryService = assetEntryService;
	}

	/**
	 * Returns the asset entry persistence.
	 *
	 * @return the asset entry persistence
	 */
	public AssetEntryPersistence getAssetEntryPersistence() {
		return assetEntryPersistence;
	}

	/**
	 * Sets the asset entry persistence.
	 *
	 * @param assetEntryPersistence the asset entry persistence
	 */
	public void setAssetEntryPersistence(
		AssetEntryPersistence assetEntryPersistence) {
		this.assetEntryPersistence = assetEntryPersistence;
	}

	/**
	 * Returns the asset link local service.
	 *
	 * @return the asset link local service
	 */
	public com.liferay.portlet.asset.service.AssetLinkLocalService getAssetLinkLocalService() {
		return assetLinkLocalService;
	}

	/**
	 * Sets the asset link local service.
	 *
	 * @param assetLinkLocalService the asset link local service
	 */
	public void setAssetLinkLocalService(
		com.liferay.portlet.asset.service.AssetLinkLocalService assetLinkLocalService) {
		this.assetLinkLocalService = assetLinkLocalService;
	}

	/**
	 * Returns the asset link persistence.
	 *
	 * @return the asset link persistence
	 */
	public AssetLinkPersistence getAssetLinkPersistence() {
		return assetLinkPersistence;
	}

	/**
	 * Sets the asset link persistence.
	 *
	 * @param assetLinkPersistence the asset link persistence
	 */
	public void setAssetLinkPersistence(
		AssetLinkPersistence assetLinkPersistence) {
		this.assetLinkPersistence = assetLinkPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("it.ethica.esf.model.ESFAddress",
			esfAddressLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"it.ethica.esf.model.ESFAddress");
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
		return ESFAddress.class;
	}

	protected String getModelClassName() {
		return ESFAddress.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = esfAddressPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = it.ethica.esf.service.ESFAddressLocalService.class)
	protected it.ethica.esf.service.ESFAddressLocalService esfAddressLocalService;
	@BeanReference(type = ESFAddressPersistence.class)
	protected ESFAddressPersistence esfAddressPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFFieldLocalService.class)
	protected it.ethica.esf.service.ESFFieldLocalService esfFieldLocalService;
	@BeanReference(type = ESFFieldPersistence.class)
	protected ESFFieldPersistence esfFieldPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFFieldESFSportTypeLocalService.class)
	protected it.ethica.esf.service.ESFFieldESFSportTypeLocalService esfFieldESFSportTypeLocalService;
	@BeanReference(type = ESFFieldESFSportTypePersistence.class)
	protected ESFFieldESFSportTypePersistence esfFieldESFSportTypePersistence;
	@BeanReference(type = it.ethica.esf.service.ESFOrganizationLocalService.class)
	protected it.ethica.esf.service.ESFOrganizationLocalService esfOrganizationLocalService;
	@BeanReference(type = ESFOrganizationPersistence.class)
	protected ESFOrganizationPersistence esfOrganizationPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFSportTypeLocalService.class)
	protected it.ethica.esf.service.ESFSportTypeLocalService esfSportTypeLocalService;
	@BeanReference(type = ESFSportTypePersistence.class)
	protected ESFSportTypePersistence esfSportTypePersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.AddressLocalService.class)
	protected com.liferay.portal.service.AddressLocalService addressLocalService;
	@BeanReference(type = com.liferay.portal.service.AddressService.class)
	protected com.liferay.portal.service.AddressService addressService;
	@BeanReference(type = AddressPersistence.class)
	protected AddressPersistence addressPersistence;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = com.liferay.portlet.asset.service.AssetEntryLocalService.class)
	protected com.liferay.portlet.asset.service.AssetEntryLocalService assetEntryLocalService;
	@BeanReference(type = com.liferay.portlet.asset.service.AssetEntryService.class)
	protected com.liferay.portlet.asset.service.AssetEntryService assetEntryService;
	@BeanReference(type = AssetEntryPersistence.class)
	protected AssetEntryPersistence assetEntryPersistence;
	@BeanReference(type = com.liferay.portlet.asset.service.AssetLinkLocalService.class)
	protected com.liferay.portlet.asset.service.AssetLinkLocalService assetLinkLocalService;
	@BeanReference(type = AssetLinkPersistence.class)
	protected AssetLinkPersistence assetLinkPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private ESFAddressLocalServiceClpInvoker _clpInvoker = new ESFAddressLocalServiceClpInvoker();
}