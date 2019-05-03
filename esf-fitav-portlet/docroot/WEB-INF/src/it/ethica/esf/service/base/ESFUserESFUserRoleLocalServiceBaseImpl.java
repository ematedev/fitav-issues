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

import it.ethica.esf.model.ESFUserESFUserRole;
import it.ethica.esf.service.ESFUserESFUserRoleLocalService;
import it.ethica.esf.service.persistence.ESFAddressPersistence;
import it.ethica.esf.service.persistence.ESFAirportPersistence;
import it.ethica.esf.service.persistence.ESFAnnualConiReportPersistence;
import it.ethica.esf.service.persistence.ESFAnnualFreeCardPersistence;
import it.ethica.esf.service.persistence.ESFBrandPersistence;
import it.ethica.esf.service.persistence.ESFCanePersistence;
import it.ethica.esf.service.persistence.ESFCardFinder;
import it.ethica.esf.service.persistence.ESFCardPersistence;
import it.ethica.esf.service.persistence.ESFCategoryPersistence;
import it.ethica.esf.service.persistence.ESFCatridgePersistence;
import it.ethica.esf.service.persistence.ESFCityPersistence;
import it.ethica.esf.service.persistence.ESFCodeOrgPersistence;
import it.ethica.esf.service.persistence.ESFConfigurationPersistence;
import it.ethica.esf.service.persistence.ESFCountryPersistence;
import it.ethica.esf.service.persistence.ESFDeparturePersistence;
import it.ethica.esf.service.persistence.ESFDescriptionPersistence;
import it.ethica.esf.service.persistence.ESFDocumentPersistence;
import it.ethica.esf.service.persistence.ESFElectronicPersistence;
import it.ethica.esf.service.persistence.ESFEntityStateFinder;
import it.ethica.esf.service.persistence.ESFEntityStatePersistence;
import it.ethica.esf.service.persistence.ESFEventTypePersistence;
import it.ethica.esf.service.persistence.ESFFederalRoleESFSpecificPersistence;
import it.ethica.esf.service.persistence.ESFFederalRoleFinder;
import it.ethica.esf.service.persistence.ESFFederalRolePersistence;
import it.ethica.esf.service.persistence.ESFFieldESFElectronicPersistence;
import it.ethica.esf.service.persistence.ESFFieldESFSportTypePersistence;
import it.ethica.esf.service.persistence.ESFFieldPersistence;
import it.ethica.esf.service.persistence.ESFForniturePersistence;
import it.ethica.esf.service.persistence.ESFFornitureRelPersistence;
import it.ethica.esf.service.persistence.ESFFornitureTypePersistence;
import it.ethica.esf.service.persistence.ESFFornitureUserPersistence;
import it.ethica.esf.service.persistence.ESFGunKindFinder;
import it.ethica.esf.service.persistence.ESFGunKindPersistence;
import it.ethica.esf.service.persistence.ESFGunPersistence;
import it.ethica.esf.service.persistence.ESFGunTypePersistence;
import it.ethica.esf.service.persistence.ESFHistoricalAssociationPersistence;
import it.ethica.esf.service.persistence.ESFInstructsShootingDirectorPersistence;
import it.ethica.esf.service.persistence.ESFJobPersistence;
import it.ethica.esf.service.persistence.ESFJunioresPersistence;
import it.ethica.esf.service.persistence.ESFLentFieldPersistence;
import it.ethica.esf.service.persistence.ESFMatchFinder;
import it.ethica.esf.service.persistence.ESFMatchPersistence;
import it.ethica.esf.service.persistence.ESFMatchResultPersistence;
import it.ethica.esf.service.persistence.ESFMatchTypePersistence;
import it.ethica.esf.service.persistence.ESFNationalDelegationPersistence;
import it.ethica.esf.service.persistence.ESFNationalFinder;
import it.ethica.esf.service.persistence.ESFNationalMatchResultPersistence;
import it.ethica.esf.service.persistence.ESFNationalPersistence;
import it.ethica.esf.service.persistence.ESFOrganizationFinder;
import it.ethica.esf.service.persistence.ESFOrganizationPersistence;
import it.ethica.esf.service.persistence.ESFOrganizationUnitservicePersistence;
import it.ethica.esf.service.persistence.ESFPartecipantInfoPersistence;
import it.ethica.esf.service.persistence.ESFPartecipantPersistence;
import it.ethica.esf.service.persistence.ESFPartecipantTypePersistence;
import it.ethica.esf.service.persistence.ESFPhonePersistence;
import it.ethica.esf.service.persistence.ESFProvincePersistence;
import it.ethica.esf.service.persistence.ESFRegionPersistence;
import it.ethica.esf.service.persistence.ESFRenewalPersistence;
import it.ethica.esf.service.persistence.ESFResultFinder;
import it.ethica.esf.service.persistence.ESFResultPersistence;
import it.ethica.esf.service.persistence.ESFShooterAffiliationChronoFinder;
import it.ethica.esf.service.persistence.ESFShooterAffiliationChronoPersistence;
import it.ethica.esf.service.persistence.ESFShooterCategoryESFMatchPersistence;
import it.ethica.esf.service.persistence.ESFShooterCategoryESFTournamentPersistence;
import it.ethica.esf.service.persistence.ESFShooterCategoryPersistence;
import it.ethica.esf.service.persistence.ESFShooterQualificationESFMatchPersistence;
import it.ethica.esf.service.persistence.ESFShooterQualificationESFTournamentPersistence;
import it.ethica.esf.service.persistence.ESFShooterQualificationPersistence;
import it.ethica.esf.service.persistence.ESFShootingDirectorFinder;
import it.ethica.esf.service.persistence.ESFShootingDirectorPersistence;
import it.ethica.esf.service.persistence.ESFShootingDirectorQualificationPersistence;
import it.ethica.esf.service.persistence.ESFSpecificPersistence;
import it.ethica.esf.service.persistence.ESFSportTypePersistence;
import it.ethica.esf.service.persistence.ESFStateAssEntityPersistence;
import it.ethica.esf.service.persistence.ESFStatePersistence;
import it.ethica.esf.service.persistence.ESFSuspensiveCodePersistence;
import it.ethica.esf.service.persistence.ESFSuspensiveShootingDirectorPersistence;
import it.ethica.esf.service.persistence.ESFTeamPersistence;
import it.ethica.esf.service.persistence.ESFTournamentPersistence;
import it.ethica.esf.service.persistence.ESFTransitionPersistence;
import it.ethica.esf.service.persistence.ESFUnitservicePersistence;
import it.ethica.esf.service.persistence.ESFUserCategoryFinder;
import it.ethica.esf.service.persistence.ESFUserCategoryPersistence;
import it.ethica.esf.service.persistence.ESFUserESFFederalRolePersistence;
import it.ethica.esf.service.persistence.ESFUserESFUserRoleFinder;
import it.ethica.esf.service.persistence.ESFUserESFUserRolePK;
import it.ethica.esf.service.persistence.ESFUserESFUserRolePersistence;
import it.ethica.esf.service.persistence.ESFUserFinder;
import it.ethica.esf.service.persistence.ESFUserPersistence;
import it.ethica.esf.service.persistence.ESFUserRolePersistence;
import it.ethica.esf.service.persistence.ESFgunUserFinder;
import it.ethica.esf.service.persistence.ESFgunUserPersistence;
import it.ethica.esf.service.persistence.vw_datidirettoretiroPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the e s f user e s f user role local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link it.ethica.esf.service.impl.ESFUserESFUserRoleLocalServiceImpl}.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.impl.ESFUserESFUserRoleLocalServiceImpl
 * @see it.ethica.esf.service.ESFUserESFUserRoleLocalServiceUtil
 * @generated
 */
public abstract class ESFUserESFUserRoleLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements ESFUserESFUserRoleLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link it.ethica.esf.service.ESFUserESFUserRoleLocalServiceUtil} to access the e s f user e s f user role local service.
	 */

	/**
	 * Adds the e s f user e s f user role to the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfUserESFUserRole the e s f user e s f user role
	 * @return the e s f user e s f user role that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ESFUserESFUserRole addESFUserESFUserRole(
		ESFUserESFUserRole esfUserESFUserRole) throws SystemException {
		esfUserESFUserRole.setNew(true);

		return esfUserESFUserRolePersistence.update(esfUserESFUserRole);
	}

	/**
	 * Creates a new e s f user e s f user role with the primary key. Does not add the e s f user e s f user role to the database.
	 *
	 * @param esfUserESFUserRolePK the primary key for the new e s f user e s f user role
	 * @return the new e s f user e s f user role
	 */
	@Override
	public ESFUserESFUserRole createESFUserESFUserRole(
		ESFUserESFUserRolePK esfUserESFUserRolePK) {
		return esfUserESFUserRolePersistence.create(esfUserESFUserRolePK);
	}

	/**
	 * Deletes the e s f user e s f user role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfUserESFUserRolePK the primary key of the e s f user e s f user role
	 * @return the e s f user e s f user role that was removed
	 * @throws PortalException if a e s f user e s f user role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ESFUserESFUserRole deleteESFUserESFUserRole(
		ESFUserESFUserRolePK esfUserESFUserRolePK)
		throws PortalException, SystemException {
		return esfUserESFUserRolePersistence.remove(esfUserESFUserRolePK);
	}

	/**
	 * Deletes the e s f user e s f user role from the database. Also notifies the appropriate model listeners.
	 *
	 * @param esfUserESFUserRole the e s f user e s f user role
	 * @return the e s f user e s f user role that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ESFUserESFUserRole deleteESFUserESFUserRole(
		ESFUserESFUserRole esfUserESFUserRole) throws SystemException {
		return esfUserESFUserRolePersistence.remove(esfUserESFUserRole);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(ESFUserESFUserRole.class,
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
		return esfUserESFUserRolePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return esfUserESFUserRolePersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return esfUserESFUserRolePersistence.findWithDynamicQuery(dynamicQuery,
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
		return esfUserESFUserRolePersistence.countWithDynamicQuery(dynamicQuery);
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
		return esfUserESFUserRolePersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public ESFUserESFUserRole fetchESFUserESFUserRole(
		ESFUserESFUserRolePK esfUserESFUserRolePK) throws SystemException {
		return esfUserESFUserRolePersistence.fetchByPrimaryKey(esfUserESFUserRolePK);
	}

	/**
	 * Returns the e s f user e s f user role with the primary key.
	 *
	 * @param esfUserESFUserRolePK the primary key of the e s f user e s f user role
	 * @return the e s f user e s f user role
	 * @throws PortalException if a e s f user e s f user role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ESFUserESFUserRole getESFUserESFUserRole(
		ESFUserESFUserRolePK esfUserESFUserRolePK)
		throws PortalException, SystemException {
		return esfUserESFUserRolePersistence.findByPrimaryKey(esfUserESFUserRolePK);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return esfUserESFUserRolePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the e s f user e s f user roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.ethica.esf.model.impl.ESFUserESFUserRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e s f user e s f user roles
	 * @param end the upper bound of the range of e s f user e s f user roles (not inclusive)
	 * @return the range of e s f user e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ESFUserESFUserRole> getESFUserESFUserRoles(int start, int end)
		throws SystemException {
		return esfUserESFUserRolePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of e s f user e s f user roles.
	 *
	 * @return the number of e s f user e s f user roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getESFUserESFUserRolesCount() throws SystemException {
		return esfUserESFUserRolePersistence.countAll();
	}

	/**
	 * Updates the e s f user e s f user role in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param esfUserESFUserRole the e s f user e s f user role
	 * @return the e s f user e s f user role that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ESFUserESFUserRole updateESFUserESFUserRole(
		ESFUserESFUserRole esfUserESFUserRole) throws SystemException {
		return esfUserESFUserRolePersistence.update(esfUserESFUserRole);
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
	 * Returns the e s f airport local service.
	 *
	 * @return the e s f airport local service
	 */
	public it.ethica.esf.service.ESFAirportLocalService getESFAirportLocalService() {
		return esfAirportLocalService;
	}

	/**
	 * Sets the e s f airport local service.
	 *
	 * @param esfAirportLocalService the e s f airport local service
	 */
	public void setESFAirportLocalService(
		it.ethica.esf.service.ESFAirportLocalService esfAirportLocalService) {
		this.esfAirportLocalService = esfAirportLocalService;
	}

	/**
	 * Returns the e s f airport persistence.
	 *
	 * @return the e s f airport persistence
	 */
	public ESFAirportPersistence getESFAirportPersistence() {
		return esfAirportPersistence;
	}

	/**
	 * Sets the e s f airport persistence.
	 *
	 * @param esfAirportPersistence the e s f airport persistence
	 */
	public void setESFAirportPersistence(
		ESFAirportPersistence esfAirportPersistence) {
		this.esfAirportPersistence = esfAirportPersistence;
	}

	/**
	 * Returns the e s f annual coni report local service.
	 *
	 * @return the e s f annual coni report local service
	 */
	public it.ethica.esf.service.ESFAnnualConiReportLocalService getESFAnnualConiReportLocalService() {
		return esfAnnualConiReportLocalService;
	}

	/**
	 * Sets the e s f annual coni report local service.
	 *
	 * @param esfAnnualConiReportLocalService the e s f annual coni report local service
	 */
	public void setESFAnnualConiReportLocalService(
		it.ethica.esf.service.ESFAnnualConiReportLocalService esfAnnualConiReportLocalService) {
		this.esfAnnualConiReportLocalService = esfAnnualConiReportLocalService;
	}

	/**
	 * Returns the e s f annual coni report persistence.
	 *
	 * @return the e s f annual coni report persistence
	 */
	public ESFAnnualConiReportPersistence getESFAnnualConiReportPersistence() {
		return esfAnnualConiReportPersistence;
	}

	/**
	 * Sets the e s f annual coni report persistence.
	 *
	 * @param esfAnnualConiReportPersistence the e s f annual coni report persistence
	 */
	public void setESFAnnualConiReportPersistence(
		ESFAnnualConiReportPersistence esfAnnualConiReportPersistence) {
		this.esfAnnualConiReportPersistence = esfAnnualConiReportPersistence;
	}

	/**
	 * Returns the e s f annual free card local service.
	 *
	 * @return the e s f annual free card local service
	 */
	public it.ethica.esf.service.ESFAnnualFreeCardLocalService getESFAnnualFreeCardLocalService() {
		return esfAnnualFreeCardLocalService;
	}

	/**
	 * Sets the e s f annual free card local service.
	 *
	 * @param esfAnnualFreeCardLocalService the e s f annual free card local service
	 */
	public void setESFAnnualFreeCardLocalService(
		it.ethica.esf.service.ESFAnnualFreeCardLocalService esfAnnualFreeCardLocalService) {
		this.esfAnnualFreeCardLocalService = esfAnnualFreeCardLocalService;
	}

	/**
	 * Returns the e s f annual free card persistence.
	 *
	 * @return the e s f annual free card persistence
	 */
	public ESFAnnualFreeCardPersistence getESFAnnualFreeCardPersistence() {
		return esfAnnualFreeCardPersistence;
	}

	/**
	 * Sets the e s f annual free card persistence.
	 *
	 * @param esfAnnualFreeCardPersistence the e s f annual free card persistence
	 */
	public void setESFAnnualFreeCardPersistence(
		ESFAnnualFreeCardPersistence esfAnnualFreeCardPersistence) {
		this.esfAnnualFreeCardPersistence = esfAnnualFreeCardPersistence;
	}

	/**
	 * Returns the e s f brand local service.
	 *
	 * @return the e s f brand local service
	 */
	public it.ethica.esf.service.ESFBrandLocalService getESFBrandLocalService() {
		return esfBrandLocalService;
	}

	/**
	 * Sets the e s f brand local service.
	 *
	 * @param esfBrandLocalService the e s f brand local service
	 */
	public void setESFBrandLocalService(
		it.ethica.esf.service.ESFBrandLocalService esfBrandLocalService) {
		this.esfBrandLocalService = esfBrandLocalService;
	}

	/**
	 * Returns the e s f brand persistence.
	 *
	 * @return the e s f brand persistence
	 */
	public ESFBrandPersistence getESFBrandPersistence() {
		return esfBrandPersistence;
	}

	/**
	 * Sets the e s f brand persistence.
	 *
	 * @param esfBrandPersistence the e s f brand persistence
	 */
	public void setESFBrandPersistence(ESFBrandPersistence esfBrandPersistence) {
		this.esfBrandPersistence = esfBrandPersistence;
	}

	/**
	 * Returns the e s f cane local service.
	 *
	 * @return the e s f cane local service
	 */
	public it.ethica.esf.service.ESFCaneLocalService getESFCaneLocalService() {
		return esfCaneLocalService;
	}

	/**
	 * Sets the e s f cane local service.
	 *
	 * @param esfCaneLocalService the e s f cane local service
	 */
	public void setESFCaneLocalService(
		it.ethica.esf.service.ESFCaneLocalService esfCaneLocalService) {
		this.esfCaneLocalService = esfCaneLocalService;
	}

	/**
	 * Returns the e s f cane persistence.
	 *
	 * @return the e s f cane persistence
	 */
	public ESFCanePersistence getESFCanePersistence() {
		return esfCanePersistence;
	}

	/**
	 * Sets the e s f cane persistence.
	 *
	 * @param esfCanePersistence the e s f cane persistence
	 */
	public void setESFCanePersistence(ESFCanePersistence esfCanePersistence) {
		this.esfCanePersistence = esfCanePersistence;
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
	 * Returns the e s f card remote service.
	 *
	 * @return the e s f card remote service
	 */
	public it.ethica.esf.service.ESFCardService getESFCardService() {
		return esfCardService;
	}

	/**
	 * Sets the e s f card remote service.
	 *
	 * @param esfCardService the e s f card remote service
	 */
	public void setESFCardService(
		it.ethica.esf.service.ESFCardService esfCardService) {
		this.esfCardService = esfCardService;
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
	 * Returns the e s f card finder.
	 *
	 * @return the e s f card finder
	 */
	public ESFCardFinder getESFCardFinder() {
		return esfCardFinder;
	}

	/**
	 * Sets the e s f card finder.
	 *
	 * @param esfCardFinder the e s f card finder
	 */
	public void setESFCardFinder(ESFCardFinder esfCardFinder) {
		this.esfCardFinder = esfCardFinder;
	}

	/**
	 * Returns the e s f category local service.
	 *
	 * @return the e s f category local service
	 */
	public it.ethica.esf.service.ESFCategoryLocalService getESFCategoryLocalService() {
		return esfCategoryLocalService;
	}

	/**
	 * Sets the e s f category local service.
	 *
	 * @param esfCategoryLocalService the e s f category local service
	 */
	public void setESFCategoryLocalService(
		it.ethica.esf.service.ESFCategoryLocalService esfCategoryLocalService) {
		this.esfCategoryLocalService = esfCategoryLocalService;
	}

	/**
	 * Returns the e s f category persistence.
	 *
	 * @return the e s f category persistence
	 */
	public ESFCategoryPersistence getESFCategoryPersistence() {
		return esfCategoryPersistence;
	}

	/**
	 * Sets the e s f category persistence.
	 *
	 * @param esfCategoryPersistence the e s f category persistence
	 */
	public void setESFCategoryPersistence(
		ESFCategoryPersistence esfCategoryPersistence) {
		this.esfCategoryPersistence = esfCategoryPersistence;
	}

	/**
	 * Returns the e s f catridge local service.
	 *
	 * @return the e s f catridge local service
	 */
	public it.ethica.esf.service.ESFCatridgeLocalService getESFCatridgeLocalService() {
		return esfCatridgeLocalService;
	}

	/**
	 * Sets the e s f catridge local service.
	 *
	 * @param esfCatridgeLocalService the e s f catridge local service
	 */
	public void setESFCatridgeLocalService(
		it.ethica.esf.service.ESFCatridgeLocalService esfCatridgeLocalService) {
		this.esfCatridgeLocalService = esfCatridgeLocalService;
	}

	/**
	 * Returns the e s f catridge persistence.
	 *
	 * @return the e s f catridge persistence
	 */
	public ESFCatridgePersistence getESFCatridgePersistence() {
		return esfCatridgePersistence;
	}

	/**
	 * Sets the e s f catridge persistence.
	 *
	 * @param esfCatridgePersistence the e s f catridge persistence
	 */
	public void setESFCatridgePersistence(
		ESFCatridgePersistence esfCatridgePersistence) {
		this.esfCatridgePersistence = esfCatridgePersistence;
	}

	/**
	 * Returns the e s f city local service.
	 *
	 * @return the e s f city local service
	 */
	public it.ethica.esf.service.ESFCityLocalService getESFCityLocalService() {
		return esfCityLocalService;
	}

	/**
	 * Sets the e s f city local service.
	 *
	 * @param esfCityLocalService the e s f city local service
	 */
	public void setESFCityLocalService(
		it.ethica.esf.service.ESFCityLocalService esfCityLocalService) {
		this.esfCityLocalService = esfCityLocalService;
	}

	/**
	 * Returns the e s f city persistence.
	 *
	 * @return the e s f city persistence
	 */
	public ESFCityPersistence getESFCityPersistence() {
		return esfCityPersistence;
	}

	/**
	 * Sets the e s f city persistence.
	 *
	 * @param esfCityPersistence the e s f city persistence
	 */
	public void setESFCityPersistence(ESFCityPersistence esfCityPersistence) {
		this.esfCityPersistence = esfCityPersistence;
	}

	/**
	 * Returns the e s f code org local service.
	 *
	 * @return the e s f code org local service
	 */
	public it.ethica.esf.service.ESFCodeOrgLocalService getESFCodeOrgLocalService() {
		return esfCodeOrgLocalService;
	}

	/**
	 * Sets the e s f code org local service.
	 *
	 * @param esfCodeOrgLocalService the e s f code org local service
	 */
	public void setESFCodeOrgLocalService(
		it.ethica.esf.service.ESFCodeOrgLocalService esfCodeOrgLocalService) {
		this.esfCodeOrgLocalService = esfCodeOrgLocalService;
	}

	/**
	 * Returns the e s f code org persistence.
	 *
	 * @return the e s f code org persistence
	 */
	public ESFCodeOrgPersistence getESFCodeOrgPersistence() {
		return esfCodeOrgPersistence;
	}

	/**
	 * Sets the e s f code org persistence.
	 *
	 * @param esfCodeOrgPersistence the e s f code org persistence
	 */
	public void setESFCodeOrgPersistence(
		ESFCodeOrgPersistence esfCodeOrgPersistence) {
		this.esfCodeOrgPersistence = esfCodeOrgPersistence;
	}

	/**
	 * Returns the e s f configuration local service.
	 *
	 * @return the e s f configuration local service
	 */
	public it.ethica.esf.service.ESFConfigurationLocalService getESFConfigurationLocalService() {
		return esfConfigurationLocalService;
	}

	/**
	 * Sets the e s f configuration local service.
	 *
	 * @param esfConfigurationLocalService the e s f configuration local service
	 */
	public void setESFConfigurationLocalService(
		it.ethica.esf.service.ESFConfigurationLocalService esfConfigurationLocalService) {
		this.esfConfigurationLocalService = esfConfigurationLocalService;
	}

	/**
	 * Returns the e s f configuration persistence.
	 *
	 * @return the e s f configuration persistence
	 */
	public ESFConfigurationPersistence getESFConfigurationPersistence() {
		return esfConfigurationPersistence;
	}

	/**
	 * Sets the e s f configuration persistence.
	 *
	 * @param esfConfigurationPersistence the e s f configuration persistence
	 */
	public void setESFConfigurationPersistence(
		ESFConfigurationPersistence esfConfigurationPersistence) {
		this.esfConfigurationPersistence = esfConfigurationPersistence;
	}

	/**
	 * Returns the e s f country local service.
	 *
	 * @return the e s f country local service
	 */
	public it.ethica.esf.service.ESFCountryLocalService getESFCountryLocalService() {
		return esfCountryLocalService;
	}

	/**
	 * Sets the e s f country local service.
	 *
	 * @param esfCountryLocalService the e s f country local service
	 */
	public void setESFCountryLocalService(
		it.ethica.esf.service.ESFCountryLocalService esfCountryLocalService) {
		this.esfCountryLocalService = esfCountryLocalService;
	}

	/**
	 * Returns the e s f country persistence.
	 *
	 * @return the e s f country persistence
	 */
	public ESFCountryPersistence getESFCountryPersistence() {
		return esfCountryPersistence;
	}

	/**
	 * Sets the e s f country persistence.
	 *
	 * @param esfCountryPersistence the e s f country persistence
	 */
	public void setESFCountryPersistence(
		ESFCountryPersistence esfCountryPersistence) {
		this.esfCountryPersistence = esfCountryPersistence;
	}

	/**
	 * Returns the e s f departure local service.
	 *
	 * @return the e s f departure local service
	 */
	public it.ethica.esf.service.ESFDepartureLocalService getESFDepartureLocalService() {
		return esfDepartureLocalService;
	}

	/**
	 * Sets the e s f departure local service.
	 *
	 * @param esfDepartureLocalService the e s f departure local service
	 */
	public void setESFDepartureLocalService(
		it.ethica.esf.service.ESFDepartureLocalService esfDepartureLocalService) {
		this.esfDepartureLocalService = esfDepartureLocalService;
	}

	/**
	 * Returns the e s f departure persistence.
	 *
	 * @return the e s f departure persistence
	 */
	public ESFDeparturePersistence getESFDeparturePersistence() {
		return esfDeparturePersistence;
	}

	/**
	 * Sets the e s f departure persistence.
	 *
	 * @param esfDeparturePersistence the e s f departure persistence
	 */
	public void setESFDeparturePersistence(
		ESFDeparturePersistence esfDeparturePersistence) {
		this.esfDeparturePersistence = esfDeparturePersistence;
	}

	/**
	 * Returns the e s f description local service.
	 *
	 * @return the e s f description local service
	 */
	public it.ethica.esf.service.ESFDescriptionLocalService getESFDescriptionLocalService() {
		return esfDescriptionLocalService;
	}

	/**
	 * Sets the e s f description local service.
	 *
	 * @param esfDescriptionLocalService the e s f description local service
	 */
	public void setESFDescriptionLocalService(
		it.ethica.esf.service.ESFDescriptionLocalService esfDescriptionLocalService) {
		this.esfDescriptionLocalService = esfDescriptionLocalService;
	}

	/**
	 * Returns the e s f description persistence.
	 *
	 * @return the e s f description persistence
	 */
	public ESFDescriptionPersistence getESFDescriptionPersistence() {
		return esfDescriptionPersistence;
	}

	/**
	 * Sets the e s f description persistence.
	 *
	 * @param esfDescriptionPersistence the e s f description persistence
	 */
	public void setESFDescriptionPersistence(
		ESFDescriptionPersistence esfDescriptionPersistence) {
		this.esfDescriptionPersistence = esfDescriptionPersistence;
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
	 * Returns the e s f electronic local service.
	 *
	 * @return the e s f electronic local service
	 */
	public it.ethica.esf.service.ESFElectronicLocalService getESFElectronicLocalService() {
		return esfElectronicLocalService;
	}

	/**
	 * Sets the e s f electronic local service.
	 *
	 * @param esfElectronicLocalService the e s f electronic local service
	 */
	public void setESFElectronicLocalService(
		it.ethica.esf.service.ESFElectronicLocalService esfElectronicLocalService) {
		this.esfElectronicLocalService = esfElectronicLocalService;
	}

	/**
	 * Returns the e s f electronic persistence.
	 *
	 * @return the e s f electronic persistence
	 */
	public ESFElectronicPersistence getESFElectronicPersistence() {
		return esfElectronicPersistence;
	}

	/**
	 * Sets the e s f electronic persistence.
	 *
	 * @param esfElectronicPersistence the e s f electronic persistence
	 */
	public void setESFElectronicPersistence(
		ESFElectronicPersistence esfElectronicPersistence) {
		this.esfElectronicPersistence = esfElectronicPersistence;
	}

	/**
	 * Returns the e s f entity state local service.
	 *
	 * @return the e s f entity state local service
	 */
	public it.ethica.esf.service.ESFEntityStateLocalService getESFEntityStateLocalService() {
		return esfEntityStateLocalService;
	}

	/**
	 * Sets the e s f entity state local service.
	 *
	 * @param esfEntityStateLocalService the e s f entity state local service
	 */
	public void setESFEntityStateLocalService(
		it.ethica.esf.service.ESFEntityStateLocalService esfEntityStateLocalService) {
		this.esfEntityStateLocalService = esfEntityStateLocalService;
	}

	/**
	 * Returns the e s f entity state persistence.
	 *
	 * @return the e s f entity state persistence
	 */
	public ESFEntityStatePersistence getESFEntityStatePersistence() {
		return esfEntityStatePersistence;
	}

	/**
	 * Sets the e s f entity state persistence.
	 *
	 * @param esfEntityStatePersistence the e s f entity state persistence
	 */
	public void setESFEntityStatePersistence(
		ESFEntityStatePersistence esfEntityStatePersistence) {
		this.esfEntityStatePersistence = esfEntityStatePersistence;
	}

	/**
	 * Returns the e s f entity state finder.
	 *
	 * @return the e s f entity state finder
	 */
	public ESFEntityStateFinder getESFEntityStateFinder() {
		return esfEntityStateFinder;
	}

	/**
	 * Sets the e s f entity state finder.
	 *
	 * @param esfEntityStateFinder the e s f entity state finder
	 */
	public void setESFEntityStateFinder(
		ESFEntityStateFinder esfEntityStateFinder) {
		this.esfEntityStateFinder = esfEntityStateFinder;
	}

	/**
	 * Returns the e s f event type local service.
	 *
	 * @return the e s f event type local service
	 */
	public it.ethica.esf.service.ESFEventTypeLocalService getESFEventTypeLocalService() {
		return esfEventTypeLocalService;
	}

	/**
	 * Sets the e s f event type local service.
	 *
	 * @param esfEventTypeLocalService the e s f event type local service
	 */
	public void setESFEventTypeLocalService(
		it.ethica.esf.service.ESFEventTypeLocalService esfEventTypeLocalService) {
		this.esfEventTypeLocalService = esfEventTypeLocalService;
	}

	/**
	 * Returns the e s f event type persistence.
	 *
	 * @return the e s f event type persistence
	 */
	public ESFEventTypePersistence getESFEventTypePersistence() {
		return esfEventTypePersistence;
	}

	/**
	 * Sets the e s f event type persistence.
	 *
	 * @param esfEventTypePersistence the e s f event type persistence
	 */
	public void setESFEventTypePersistence(
		ESFEventTypePersistence esfEventTypePersistence) {
		this.esfEventTypePersistence = esfEventTypePersistence;
	}

	/**
	 * Returns the e s f federal role local service.
	 *
	 * @return the e s f federal role local service
	 */
	public it.ethica.esf.service.ESFFederalRoleLocalService getESFFederalRoleLocalService() {
		return esfFederalRoleLocalService;
	}

	/**
	 * Sets the e s f federal role local service.
	 *
	 * @param esfFederalRoleLocalService the e s f federal role local service
	 */
	public void setESFFederalRoleLocalService(
		it.ethica.esf.service.ESFFederalRoleLocalService esfFederalRoleLocalService) {
		this.esfFederalRoleLocalService = esfFederalRoleLocalService;
	}

	/**
	 * Returns the e s f federal role remote service.
	 *
	 * @return the e s f federal role remote service
	 */
	public it.ethica.esf.service.ESFFederalRoleService getESFFederalRoleService() {
		return esfFederalRoleService;
	}

	/**
	 * Sets the e s f federal role remote service.
	 *
	 * @param esfFederalRoleService the e s f federal role remote service
	 */
	public void setESFFederalRoleService(
		it.ethica.esf.service.ESFFederalRoleService esfFederalRoleService) {
		this.esfFederalRoleService = esfFederalRoleService;
	}

	/**
	 * Returns the e s f federal role persistence.
	 *
	 * @return the e s f federal role persistence
	 */
	public ESFFederalRolePersistence getESFFederalRolePersistence() {
		return esfFederalRolePersistence;
	}

	/**
	 * Sets the e s f federal role persistence.
	 *
	 * @param esfFederalRolePersistence the e s f federal role persistence
	 */
	public void setESFFederalRolePersistence(
		ESFFederalRolePersistence esfFederalRolePersistence) {
		this.esfFederalRolePersistence = esfFederalRolePersistence;
	}

	/**
	 * Returns the e s f federal role finder.
	 *
	 * @return the e s f federal role finder
	 */
	public ESFFederalRoleFinder getESFFederalRoleFinder() {
		return esfFederalRoleFinder;
	}

	/**
	 * Sets the e s f federal role finder.
	 *
	 * @param esfFederalRoleFinder the e s f federal role finder
	 */
	public void setESFFederalRoleFinder(
		ESFFederalRoleFinder esfFederalRoleFinder) {
		this.esfFederalRoleFinder = esfFederalRoleFinder;
	}

	/**
	 * Returns the e s f federal role e s f specific local service.
	 *
	 * @return the e s f federal role e s f specific local service
	 */
	public it.ethica.esf.service.ESFFederalRoleESFSpecificLocalService getESFFederalRoleESFSpecificLocalService() {
		return esfFederalRoleESFSpecificLocalService;
	}

	/**
	 * Sets the e s f federal role e s f specific local service.
	 *
	 * @param esfFederalRoleESFSpecificLocalService the e s f federal role e s f specific local service
	 */
	public void setESFFederalRoleESFSpecificLocalService(
		it.ethica.esf.service.ESFFederalRoleESFSpecificLocalService esfFederalRoleESFSpecificLocalService) {
		this.esfFederalRoleESFSpecificLocalService = esfFederalRoleESFSpecificLocalService;
	}

	/**
	 * Returns the e s f federal role e s f specific remote service.
	 *
	 * @return the e s f federal role e s f specific remote service
	 */
	public it.ethica.esf.service.ESFFederalRoleESFSpecificService getESFFederalRoleESFSpecificService() {
		return esfFederalRoleESFSpecificService;
	}

	/**
	 * Sets the e s f federal role e s f specific remote service.
	 *
	 * @param esfFederalRoleESFSpecificService the e s f federal role e s f specific remote service
	 */
	public void setESFFederalRoleESFSpecificService(
		it.ethica.esf.service.ESFFederalRoleESFSpecificService esfFederalRoleESFSpecificService) {
		this.esfFederalRoleESFSpecificService = esfFederalRoleESFSpecificService;
	}

	/**
	 * Returns the e s f federal role e s f specific persistence.
	 *
	 * @return the e s f federal role e s f specific persistence
	 */
	public ESFFederalRoleESFSpecificPersistence getESFFederalRoleESFSpecificPersistence() {
		return esfFederalRoleESFSpecificPersistence;
	}

	/**
	 * Sets the e s f federal role e s f specific persistence.
	 *
	 * @param esfFederalRoleESFSpecificPersistence the e s f federal role e s f specific persistence
	 */
	public void setESFFederalRoleESFSpecificPersistence(
		ESFFederalRoleESFSpecificPersistence esfFederalRoleESFSpecificPersistence) {
		this.esfFederalRoleESFSpecificPersistence = esfFederalRoleESFSpecificPersistence;
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
	 * Returns the e s f field e s f electronic local service.
	 *
	 * @return the e s f field e s f electronic local service
	 */
	public it.ethica.esf.service.ESFFieldESFElectronicLocalService getESFFieldESFElectronicLocalService() {
		return esfFieldESFElectronicLocalService;
	}

	/**
	 * Sets the e s f field e s f electronic local service.
	 *
	 * @param esfFieldESFElectronicLocalService the e s f field e s f electronic local service
	 */
	public void setESFFieldESFElectronicLocalService(
		it.ethica.esf.service.ESFFieldESFElectronicLocalService esfFieldESFElectronicLocalService) {
		this.esfFieldESFElectronicLocalService = esfFieldESFElectronicLocalService;
	}

	/**
	 * Returns the e s f field e s f electronic persistence.
	 *
	 * @return the e s f field e s f electronic persistence
	 */
	public ESFFieldESFElectronicPersistence getESFFieldESFElectronicPersistence() {
		return esfFieldESFElectronicPersistence;
	}

	/**
	 * Sets the e s f field e s f electronic persistence.
	 *
	 * @param esfFieldESFElectronicPersistence the e s f field e s f electronic persistence
	 */
	public void setESFFieldESFElectronicPersistence(
		ESFFieldESFElectronicPersistence esfFieldESFElectronicPersistence) {
		this.esfFieldESFElectronicPersistence = esfFieldESFElectronicPersistence;
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
	 * Returns the e s f forniture local service.
	 *
	 * @return the e s f forniture local service
	 */
	public it.ethica.esf.service.ESFFornitureLocalService getESFFornitureLocalService() {
		return esfFornitureLocalService;
	}

	/**
	 * Sets the e s f forniture local service.
	 *
	 * @param esfFornitureLocalService the e s f forniture local service
	 */
	public void setESFFornitureLocalService(
		it.ethica.esf.service.ESFFornitureLocalService esfFornitureLocalService) {
		this.esfFornitureLocalService = esfFornitureLocalService;
	}

	/**
	 * Returns the e s f forniture persistence.
	 *
	 * @return the e s f forniture persistence
	 */
	public ESFForniturePersistence getESFForniturePersistence() {
		return esfForniturePersistence;
	}

	/**
	 * Sets the e s f forniture persistence.
	 *
	 * @param esfForniturePersistence the e s f forniture persistence
	 */
	public void setESFForniturePersistence(
		ESFForniturePersistence esfForniturePersistence) {
		this.esfForniturePersistence = esfForniturePersistence;
	}

	/**
	 * Returns the e s f forniture rel local service.
	 *
	 * @return the e s f forniture rel local service
	 */
	public it.ethica.esf.service.ESFFornitureRelLocalService getESFFornitureRelLocalService() {
		return esfFornitureRelLocalService;
	}

	/**
	 * Sets the e s f forniture rel local service.
	 *
	 * @param esfFornitureRelLocalService the e s f forniture rel local service
	 */
	public void setESFFornitureRelLocalService(
		it.ethica.esf.service.ESFFornitureRelLocalService esfFornitureRelLocalService) {
		this.esfFornitureRelLocalService = esfFornitureRelLocalService;
	}

	/**
	 * Returns the e s f forniture rel persistence.
	 *
	 * @return the e s f forniture rel persistence
	 */
	public ESFFornitureRelPersistence getESFFornitureRelPersistence() {
		return esfFornitureRelPersistence;
	}

	/**
	 * Sets the e s f forniture rel persistence.
	 *
	 * @param esfFornitureRelPersistence the e s f forniture rel persistence
	 */
	public void setESFFornitureRelPersistence(
		ESFFornitureRelPersistence esfFornitureRelPersistence) {
		this.esfFornitureRelPersistence = esfFornitureRelPersistence;
	}

	/**
	 * Returns the e s f forniture type local service.
	 *
	 * @return the e s f forniture type local service
	 */
	public it.ethica.esf.service.ESFFornitureTypeLocalService getESFFornitureTypeLocalService() {
		return esfFornitureTypeLocalService;
	}

	/**
	 * Sets the e s f forniture type local service.
	 *
	 * @param esfFornitureTypeLocalService the e s f forniture type local service
	 */
	public void setESFFornitureTypeLocalService(
		it.ethica.esf.service.ESFFornitureTypeLocalService esfFornitureTypeLocalService) {
		this.esfFornitureTypeLocalService = esfFornitureTypeLocalService;
	}

	/**
	 * Returns the e s f forniture type persistence.
	 *
	 * @return the e s f forniture type persistence
	 */
	public ESFFornitureTypePersistence getESFFornitureTypePersistence() {
		return esfFornitureTypePersistence;
	}

	/**
	 * Sets the e s f forniture type persistence.
	 *
	 * @param esfFornitureTypePersistence the e s f forniture type persistence
	 */
	public void setESFFornitureTypePersistence(
		ESFFornitureTypePersistence esfFornitureTypePersistence) {
		this.esfFornitureTypePersistence = esfFornitureTypePersistence;
	}

	/**
	 * Returns the e s f forniture user local service.
	 *
	 * @return the e s f forniture user local service
	 */
	public it.ethica.esf.service.ESFFornitureUserLocalService getESFFornitureUserLocalService() {
		return esfFornitureUserLocalService;
	}

	/**
	 * Sets the e s f forniture user local service.
	 *
	 * @param esfFornitureUserLocalService the e s f forniture user local service
	 */
	public void setESFFornitureUserLocalService(
		it.ethica.esf.service.ESFFornitureUserLocalService esfFornitureUserLocalService) {
		this.esfFornitureUserLocalService = esfFornitureUserLocalService;
	}

	/**
	 * Returns the e s f forniture user persistence.
	 *
	 * @return the e s f forniture user persistence
	 */
	public ESFFornitureUserPersistence getESFFornitureUserPersistence() {
		return esfFornitureUserPersistence;
	}

	/**
	 * Sets the e s f forniture user persistence.
	 *
	 * @param esfFornitureUserPersistence the e s f forniture user persistence
	 */
	public void setESFFornitureUserPersistence(
		ESFFornitureUserPersistence esfFornitureUserPersistence) {
		this.esfFornitureUserPersistence = esfFornitureUserPersistence;
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
	 * Returns the e s f gun kind finder.
	 *
	 * @return the e s f gun kind finder
	 */
	public ESFGunKindFinder getESFGunKindFinder() {
		return esfGunKindFinder;
	}

	/**
	 * Sets the e s f gun kind finder.
	 *
	 * @param esfGunKindFinder the e s f gun kind finder
	 */
	public void setESFGunKindFinder(ESFGunKindFinder esfGunKindFinder) {
		this.esfGunKindFinder = esfGunKindFinder;
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
	 * Returns the e s fgun user local service.
	 *
	 * @return the e s fgun user local service
	 */
	public it.ethica.esf.service.ESFgunUserLocalService getESFgunUserLocalService() {
		return esFgunUserLocalService;
	}

	/**
	 * Sets the e s fgun user local service.
	 *
	 * @param esFgunUserLocalService the e s fgun user local service
	 */
	public void setESFgunUserLocalService(
		it.ethica.esf.service.ESFgunUserLocalService esFgunUserLocalService) {
		this.esFgunUserLocalService = esFgunUserLocalService;
	}

	/**
	 * Returns the e s fgun user persistence.
	 *
	 * @return the e s fgun user persistence
	 */
	public ESFgunUserPersistence getESFgunUserPersistence() {
		return esFgunUserPersistence;
	}

	/**
	 * Sets the e s fgun user persistence.
	 *
	 * @param esFgunUserPersistence the e s fgun user persistence
	 */
	public void setESFgunUserPersistence(
		ESFgunUserPersistence esFgunUserPersistence) {
		this.esFgunUserPersistence = esFgunUserPersistence;
	}

	/**
	 * Returns the e s fgun user finder.
	 *
	 * @return the e s fgun user finder
	 */
	public ESFgunUserFinder getESFgunUserFinder() {
		return esFgunUserFinder;
	}

	/**
	 * Sets the e s fgun user finder.
	 *
	 * @param esFgunUserFinder the e s fgun user finder
	 */
	public void setESFgunUserFinder(ESFgunUserFinder esFgunUserFinder) {
		this.esFgunUserFinder = esFgunUserFinder;
	}

	/**
	 * Returns the e s f historical association local service.
	 *
	 * @return the e s f historical association local service
	 */
	public it.ethica.esf.service.ESFHistoricalAssociationLocalService getESFHistoricalAssociationLocalService() {
		return esfHistoricalAssociationLocalService;
	}

	/**
	 * Sets the e s f historical association local service.
	 *
	 * @param esfHistoricalAssociationLocalService the e s f historical association local service
	 */
	public void setESFHistoricalAssociationLocalService(
		it.ethica.esf.service.ESFHistoricalAssociationLocalService esfHistoricalAssociationLocalService) {
		this.esfHistoricalAssociationLocalService = esfHistoricalAssociationLocalService;
	}

	/**
	 * Returns the e s f historical association persistence.
	 *
	 * @return the e s f historical association persistence
	 */
	public ESFHistoricalAssociationPersistence getESFHistoricalAssociationPersistence() {
		return esfHistoricalAssociationPersistence;
	}

	/**
	 * Sets the e s f historical association persistence.
	 *
	 * @param esfHistoricalAssociationPersistence the e s f historical association persistence
	 */
	public void setESFHistoricalAssociationPersistence(
		ESFHistoricalAssociationPersistence esfHistoricalAssociationPersistence) {
		this.esfHistoricalAssociationPersistence = esfHistoricalAssociationPersistence;
	}

	/**
	 * Returns the e s f instructs shooting director local service.
	 *
	 * @return the e s f instructs shooting director local service
	 */
	public it.ethica.esf.service.ESFInstructsShootingDirectorLocalService getESFInstructsShootingDirectorLocalService() {
		return esfInstructsShootingDirectorLocalService;
	}

	/**
	 * Sets the e s f instructs shooting director local service.
	 *
	 * @param esfInstructsShootingDirectorLocalService the e s f instructs shooting director local service
	 */
	public void setESFInstructsShootingDirectorLocalService(
		it.ethica.esf.service.ESFInstructsShootingDirectorLocalService esfInstructsShootingDirectorLocalService) {
		this.esfInstructsShootingDirectorLocalService = esfInstructsShootingDirectorLocalService;
	}

	/**
	 * Returns the e s f instructs shooting director persistence.
	 *
	 * @return the e s f instructs shooting director persistence
	 */
	public ESFInstructsShootingDirectorPersistence getESFInstructsShootingDirectorPersistence() {
		return esfInstructsShootingDirectorPersistence;
	}

	/**
	 * Sets the e s f instructs shooting director persistence.
	 *
	 * @param esfInstructsShootingDirectorPersistence the e s f instructs shooting director persistence
	 */
	public void setESFInstructsShootingDirectorPersistence(
		ESFInstructsShootingDirectorPersistence esfInstructsShootingDirectorPersistence) {
		this.esfInstructsShootingDirectorPersistence = esfInstructsShootingDirectorPersistence;
	}

	/**
	 * Returns the e s f job local service.
	 *
	 * @return the e s f job local service
	 */
	public it.ethica.esf.service.ESFJobLocalService getESFJobLocalService() {
		return esfJobLocalService;
	}

	/**
	 * Sets the e s f job local service.
	 *
	 * @param esfJobLocalService the e s f job local service
	 */
	public void setESFJobLocalService(
		it.ethica.esf.service.ESFJobLocalService esfJobLocalService) {
		this.esfJobLocalService = esfJobLocalService;
	}

	/**
	 * Returns the e s f job persistence.
	 *
	 * @return the e s f job persistence
	 */
	public ESFJobPersistence getESFJobPersistence() {
		return esfJobPersistence;
	}

	/**
	 * Sets the e s f job persistence.
	 *
	 * @param esfJobPersistence the e s f job persistence
	 */
	public void setESFJobPersistence(ESFJobPersistence esfJobPersistence) {
		this.esfJobPersistence = esfJobPersistence;
	}

	/**
	 * Returns the e s f juniores local service.
	 *
	 * @return the e s f juniores local service
	 */
	public it.ethica.esf.service.ESFJunioresLocalService getESFJunioresLocalService() {
		return esfJunioresLocalService;
	}

	/**
	 * Sets the e s f juniores local service.
	 *
	 * @param esfJunioresLocalService the e s f juniores local service
	 */
	public void setESFJunioresLocalService(
		it.ethica.esf.service.ESFJunioresLocalService esfJunioresLocalService) {
		this.esfJunioresLocalService = esfJunioresLocalService;
	}

	/**
	 * Returns the e s f juniores persistence.
	 *
	 * @return the e s f juniores persistence
	 */
	public ESFJunioresPersistence getESFJunioresPersistence() {
		return esfJunioresPersistence;
	}

	/**
	 * Sets the e s f juniores persistence.
	 *
	 * @param esfJunioresPersistence the e s f juniores persistence
	 */
	public void setESFJunioresPersistence(
		ESFJunioresPersistence esfJunioresPersistence) {
		this.esfJunioresPersistence = esfJunioresPersistence;
	}

	/**
	 * Returns the e s f lent field local service.
	 *
	 * @return the e s f lent field local service
	 */
	public it.ethica.esf.service.ESFLentFieldLocalService getESFLentFieldLocalService() {
		return esfLentFieldLocalService;
	}

	/**
	 * Sets the e s f lent field local service.
	 *
	 * @param esfLentFieldLocalService the e s f lent field local service
	 */
	public void setESFLentFieldLocalService(
		it.ethica.esf.service.ESFLentFieldLocalService esfLentFieldLocalService) {
		this.esfLentFieldLocalService = esfLentFieldLocalService;
	}

	/**
	 * Returns the e s f lent field persistence.
	 *
	 * @return the e s f lent field persistence
	 */
	public ESFLentFieldPersistence getESFLentFieldPersistence() {
		return esfLentFieldPersistence;
	}

	/**
	 * Sets the e s f lent field persistence.
	 *
	 * @param esfLentFieldPersistence the e s f lent field persistence
	 */
	public void setESFLentFieldPersistence(
		ESFLentFieldPersistence esfLentFieldPersistence) {
		this.esfLentFieldPersistence = esfLentFieldPersistence;
	}

	/**
	 * Returns the e s f match local service.
	 *
	 * @return the e s f match local service
	 */
	public it.ethica.esf.service.ESFMatchLocalService getESFMatchLocalService() {
		return esfMatchLocalService;
	}

	/**
	 * Sets the e s f match local service.
	 *
	 * @param esfMatchLocalService the e s f match local service
	 */
	public void setESFMatchLocalService(
		it.ethica.esf.service.ESFMatchLocalService esfMatchLocalService) {
		this.esfMatchLocalService = esfMatchLocalService;
	}

	/**
	 * Returns the e s f match persistence.
	 *
	 * @return the e s f match persistence
	 */
	public ESFMatchPersistence getESFMatchPersistence() {
		return esfMatchPersistence;
	}

	/**
	 * Sets the e s f match persistence.
	 *
	 * @param esfMatchPersistence the e s f match persistence
	 */
	public void setESFMatchPersistence(ESFMatchPersistence esfMatchPersistence) {
		this.esfMatchPersistence = esfMatchPersistence;
	}

	/**
	 * Returns the e s f match finder.
	 *
	 * @return the e s f match finder
	 */
	public ESFMatchFinder getESFMatchFinder() {
		return esfMatchFinder;
	}

	/**
	 * Sets the e s f match finder.
	 *
	 * @param esfMatchFinder the e s f match finder
	 */
	public void setESFMatchFinder(ESFMatchFinder esfMatchFinder) {
		this.esfMatchFinder = esfMatchFinder;
	}

	/**
	 * Returns the e s f match result local service.
	 *
	 * @return the e s f match result local service
	 */
	public it.ethica.esf.service.ESFMatchResultLocalService getESFMatchResultLocalService() {
		return esfMatchResultLocalService;
	}

	/**
	 * Sets the e s f match result local service.
	 *
	 * @param esfMatchResultLocalService the e s f match result local service
	 */
	public void setESFMatchResultLocalService(
		it.ethica.esf.service.ESFMatchResultLocalService esfMatchResultLocalService) {
		this.esfMatchResultLocalService = esfMatchResultLocalService;
	}

	/**
	 * Returns the e s f match result persistence.
	 *
	 * @return the e s f match result persistence
	 */
	public ESFMatchResultPersistence getESFMatchResultPersistence() {
		return esfMatchResultPersistence;
	}

	/**
	 * Sets the e s f match result persistence.
	 *
	 * @param esfMatchResultPersistence the e s f match result persistence
	 */
	public void setESFMatchResultPersistence(
		ESFMatchResultPersistence esfMatchResultPersistence) {
		this.esfMatchResultPersistence = esfMatchResultPersistence;
	}

	/**
	 * Returns the e s f match type local service.
	 *
	 * @return the e s f match type local service
	 */
	public it.ethica.esf.service.ESFMatchTypeLocalService getESFMatchTypeLocalService() {
		return esfMatchTypeLocalService;
	}

	/**
	 * Sets the e s f match type local service.
	 *
	 * @param esfMatchTypeLocalService the e s f match type local service
	 */
	public void setESFMatchTypeLocalService(
		it.ethica.esf.service.ESFMatchTypeLocalService esfMatchTypeLocalService) {
		this.esfMatchTypeLocalService = esfMatchTypeLocalService;
	}

	/**
	 * Returns the e s f match type persistence.
	 *
	 * @return the e s f match type persistence
	 */
	public ESFMatchTypePersistence getESFMatchTypePersistence() {
		return esfMatchTypePersistence;
	}

	/**
	 * Sets the e s f match type persistence.
	 *
	 * @param esfMatchTypePersistence the e s f match type persistence
	 */
	public void setESFMatchTypePersistence(
		ESFMatchTypePersistence esfMatchTypePersistence) {
		this.esfMatchTypePersistence = esfMatchTypePersistence;
	}

	/**
	 * Returns the e s f national local service.
	 *
	 * @return the e s f national local service
	 */
	public it.ethica.esf.service.ESFNationalLocalService getESFNationalLocalService() {
		return esfNationalLocalService;
	}

	/**
	 * Sets the e s f national local service.
	 *
	 * @param esfNationalLocalService the e s f national local service
	 */
	public void setESFNationalLocalService(
		it.ethica.esf.service.ESFNationalLocalService esfNationalLocalService) {
		this.esfNationalLocalService = esfNationalLocalService;
	}

	/**
	 * Returns the e s f national persistence.
	 *
	 * @return the e s f national persistence
	 */
	public ESFNationalPersistence getESFNationalPersistence() {
		return esfNationalPersistence;
	}

	/**
	 * Sets the e s f national persistence.
	 *
	 * @param esfNationalPersistence the e s f national persistence
	 */
	public void setESFNationalPersistence(
		ESFNationalPersistence esfNationalPersistence) {
		this.esfNationalPersistence = esfNationalPersistence;
	}

	/**
	 * Returns the e s f national finder.
	 *
	 * @return the e s f national finder
	 */
	public ESFNationalFinder getESFNationalFinder() {
		return esfNationalFinder;
	}

	/**
	 * Sets the e s f national finder.
	 *
	 * @param esfNationalFinder the e s f national finder
	 */
	public void setESFNationalFinder(ESFNationalFinder esfNationalFinder) {
		this.esfNationalFinder = esfNationalFinder;
	}

	/**
	 * Returns the e s f national delegation local service.
	 *
	 * @return the e s f national delegation local service
	 */
	public it.ethica.esf.service.ESFNationalDelegationLocalService getESFNationalDelegationLocalService() {
		return esfNationalDelegationLocalService;
	}

	/**
	 * Sets the e s f national delegation local service.
	 *
	 * @param esfNationalDelegationLocalService the e s f national delegation local service
	 */
	public void setESFNationalDelegationLocalService(
		it.ethica.esf.service.ESFNationalDelegationLocalService esfNationalDelegationLocalService) {
		this.esfNationalDelegationLocalService = esfNationalDelegationLocalService;
	}

	/**
	 * Returns the e s f national delegation persistence.
	 *
	 * @return the e s f national delegation persistence
	 */
	public ESFNationalDelegationPersistence getESFNationalDelegationPersistence() {
		return esfNationalDelegationPersistence;
	}

	/**
	 * Sets the e s f national delegation persistence.
	 *
	 * @param esfNationalDelegationPersistence the e s f national delegation persistence
	 */
	public void setESFNationalDelegationPersistence(
		ESFNationalDelegationPersistence esfNationalDelegationPersistence) {
		this.esfNationalDelegationPersistence = esfNationalDelegationPersistence;
	}

	/**
	 * Returns the e s f national match result local service.
	 *
	 * @return the e s f national match result local service
	 */
	public it.ethica.esf.service.ESFNationalMatchResultLocalService getESFNationalMatchResultLocalService() {
		return esfNationalMatchResultLocalService;
	}

	/**
	 * Sets the e s f national match result local service.
	 *
	 * @param esfNationalMatchResultLocalService the e s f national match result local service
	 */
	public void setESFNationalMatchResultLocalService(
		it.ethica.esf.service.ESFNationalMatchResultLocalService esfNationalMatchResultLocalService) {
		this.esfNationalMatchResultLocalService = esfNationalMatchResultLocalService;
	}

	/**
	 * Returns the e s f national match result persistence.
	 *
	 * @return the e s f national match result persistence
	 */
	public ESFNationalMatchResultPersistence getESFNationalMatchResultPersistence() {
		return esfNationalMatchResultPersistence;
	}

	/**
	 * Sets the e s f national match result persistence.
	 *
	 * @param esfNationalMatchResultPersistence the e s f national match result persistence
	 */
	public void setESFNationalMatchResultPersistence(
		ESFNationalMatchResultPersistence esfNationalMatchResultPersistence) {
		this.esfNationalMatchResultPersistence = esfNationalMatchResultPersistence;
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
	 * Returns the e s f organization finder.
	 *
	 * @return the e s f organization finder
	 */
	public ESFOrganizationFinder getESFOrganizationFinder() {
		return esfOrganizationFinder;
	}

	/**
	 * Sets the e s f organization finder.
	 *
	 * @param esfOrganizationFinder the e s f organization finder
	 */
	public void setESFOrganizationFinder(
		ESFOrganizationFinder esfOrganizationFinder) {
		this.esfOrganizationFinder = esfOrganizationFinder;
	}

	/**
	 * Returns the e s f organization unitservice local service.
	 *
	 * @return the e s f organization unitservice local service
	 */
	public it.ethica.esf.service.ESFOrganizationUnitserviceLocalService getESFOrganizationUnitserviceLocalService() {
		return esfOrganizationUnitserviceLocalService;
	}

	/**
	 * Sets the e s f organization unitservice local service.
	 *
	 * @param esfOrganizationUnitserviceLocalService the e s f organization unitservice local service
	 */
	public void setESFOrganizationUnitserviceLocalService(
		it.ethica.esf.service.ESFOrganizationUnitserviceLocalService esfOrganizationUnitserviceLocalService) {
		this.esfOrganizationUnitserviceLocalService = esfOrganizationUnitserviceLocalService;
	}

	/**
	 * Returns the e s f organization unitservice persistence.
	 *
	 * @return the e s f organization unitservice persistence
	 */
	public ESFOrganizationUnitservicePersistence getESFOrganizationUnitservicePersistence() {
		return esfOrganizationUnitservicePersistence;
	}

	/**
	 * Sets the e s f organization unitservice persistence.
	 *
	 * @param esfOrganizationUnitservicePersistence the e s f organization unitservice persistence
	 */
	public void setESFOrganizationUnitservicePersistence(
		ESFOrganizationUnitservicePersistence esfOrganizationUnitservicePersistence) {
		this.esfOrganizationUnitservicePersistence = esfOrganizationUnitservicePersistence;
	}

	/**
	 * Returns the e s f partecipant local service.
	 *
	 * @return the e s f partecipant local service
	 */
	public it.ethica.esf.service.ESFPartecipantLocalService getESFPartecipantLocalService() {
		return esfPartecipantLocalService;
	}

	/**
	 * Sets the e s f partecipant local service.
	 *
	 * @param esfPartecipantLocalService the e s f partecipant local service
	 */
	public void setESFPartecipantLocalService(
		it.ethica.esf.service.ESFPartecipantLocalService esfPartecipantLocalService) {
		this.esfPartecipantLocalService = esfPartecipantLocalService;
	}

	/**
	 * Returns the e s f partecipant persistence.
	 *
	 * @return the e s f partecipant persistence
	 */
	public ESFPartecipantPersistence getESFPartecipantPersistence() {
		return esfPartecipantPersistence;
	}

	/**
	 * Sets the e s f partecipant persistence.
	 *
	 * @param esfPartecipantPersistence the e s f partecipant persistence
	 */
	public void setESFPartecipantPersistence(
		ESFPartecipantPersistence esfPartecipantPersistence) {
		this.esfPartecipantPersistence = esfPartecipantPersistence;
	}

	/**
	 * Returns the e s f partecipant info local service.
	 *
	 * @return the e s f partecipant info local service
	 */
	public it.ethica.esf.service.ESFPartecipantInfoLocalService getESFPartecipantInfoLocalService() {
		return esfPartecipantInfoLocalService;
	}

	/**
	 * Sets the e s f partecipant info local service.
	 *
	 * @param esfPartecipantInfoLocalService the e s f partecipant info local service
	 */
	public void setESFPartecipantInfoLocalService(
		it.ethica.esf.service.ESFPartecipantInfoLocalService esfPartecipantInfoLocalService) {
		this.esfPartecipantInfoLocalService = esfPartecipantInfoLocalService;
	}

	/**
	 * Returns the e s f partecipant info persistence.
	 *
	 * @return the e s f partecipant info persistence
	 */
	public ESFPartecipantInfoPersistence getESFPartecipantInfoPersistence() {
		return esfPartecipantInfoPersistence;
	}

	/**
	 * Sets the e s f partecipant info persistence.
	 *
	 * @param esfPartecipantInfoPersistence the e s f partecipant info persistence
	 */
	public void setESFPartecipantInfoPersistence(
		ESFPartecipantInfoPersistence esfPartecipantInfoPersistence) {
		this.esfPartecipantInfoPersistence = esfPartecipantInfoPersistence;
	}

	/**
	 * Returns the e s f partecipant type local service.
	 *
	 * @return the e s f partecipant type local service
	 */
	public it.ethica.esf.service.ESFPartecipantTypeLocalService getESFPartecipantTypeLocalService() {
		return esfPartecipantTypeLocalService;
	}

	/**
	 * Sets the e s f partecipant type local service.
	 *
	 * @param esfPartecipantTypeLocalService the e s f partecipant type local service
	 */
	public void setESFPartecipantTypeLocalService(
		it.ethica.esf.service.ESFPartecipantTypeLocalService esfPartecipantTypeLocalService) {
		this.esfPartecipantTypeLocalService = esfPartecipantTypeLocalService;
	}

	/**
	 * Returns the e s f partecipant type persistence.
	 *
	 * @return the e s f partecipant type persistence
	 */
	public ESFPartecipantTypePersistence getESFPartecipantTypePersistence() {
		return esfPartecipantTypePersistence;
	}

	/**
	 * Sets the e s f partecipant type persistence.
	 *
	 * @param esfPartecipantTypePersistence the e s f partecipant type persistence
	 */
	public void setESFPartecipantTypePersistence(
		ESFPartecipantTypePersistence esfPartecipantTypePersistence) {
		this.esfPartecipantTypePersistence = esfPartecipantTypePersistence;
	}

	/**
	 * Returns the e s f phone local service.
	 *
	 * @return the e s f phone local service
	 */
	public it.ethica.esf.service.ESFPhoneLocalService getESFPhoneLocalService() {
		return esfPhoneLocalService;
	}

	/**
	 * Sets the e s f phone local service.
	 *
	 * @param esfPhoneLocalService the e s f phone local service
	 */
	public void setESFPhoneLocalService(
		it.ethica.esf.service.ESFPhoneLocalService esfPhoneLocalService) {
		this.esfPhoneLocalService = esfPhoneLocalService;
	}

	/**
	 * Returns the e s f phone persistence.
	 *
	 * @return the e s f phone persistence
	 */
	public ESFPhonePersistence getESFPhonePersistence() {
		return esfPhonePersistence;
	}

	/**
	 * Sets the e s f phone persistence.
	 *
	 * @param esfPhonePersistence the e s f phone persistence
	 */
	public void setESFPhonePersistence(ESFPhonePersistence esfPhonePersistence) {
		this.esfPhonePersistence = esfPhonePersistence;
	}

	/**
	 * Returns the e s f province local service.
	 *
	 * @return the e s f province local service
	 */
	public it.ethica.esf.service.ESFProvinceLocalService getESFProvinceLocalService() {
		return esfProvinceLocalService;
	}

	/**
	 * Sets the e s f province local service.
	 *
	 * @param esfProvinceLocalService the e s f province local service
	 */
	public void setESFProvinceLocalService(
		it.ethica.esf.service.ESFProvinceLocalService esfProvinceLocalService) {
		this.esfProvinceLocalService = esfProvinceLocalService;
	}

	/**
	 * Returns the e s f province persistence.
	 *
	 * @return the e s f province persistence
	 */
	public ESFProvincePersistence getESFProvincePersistence() {
		return esfProvincePersistence;
	}

	/**
	 * Sets the e s f province persistence.
	 *
	 * @param esfProvincePersistence the e s f province persistence
	 */
	public void setESFProvincePersistence(
		ESFProvincePersistence esfProvincePersistence) {
		this.esfProvincePersistence = esfProvincePersistence;
	}

	/**
	 * Returns the e s f region local service.
	 *
	 * @return the e s f region local service
	 */
	public it.ethica.esf.service.ESFRegionLocalService getESFRegionLocalService() {
		return esfRegionLocalService;
	}

	/**
	 * Sets the e s f region local service.
	 *
	 * @param esfRegionLocalService the e s f region local service
	 */
	public void setESFRegionLocalService(
		it.ethica.esf.service.ESFRegionLocalService esfRegionLocalService) {
		this.esfRegionLocalService = esfRegionLocalService;
	}

	/**
	 * Returns the e s f region persistence.
	 *
	 * @return the e s f region persistence
	 */
	public ESFRegionPersistence getESFRegionPersistence() {
		return esfRegionPersistence;
	}

	/**
	 * Sets the e s f region persistence.
	 *
	 * @param esfRegionPersistence the e s f region persistence
	 */
	public void setESFRegionPersistence(
		ESFRegionPersistence esfRegionPersistence) {
		this.esfRegionPersistence = esfRegionPersistence;
	}

	/**
	 * Returns the e s f renewal local service.
	 *
	 * @return the e s f renewal local service
	 */
	public it.ethica.esf.service.ESFRenewalLocalService getESFRenewalLocalService() {
		return esfRenewalLocalService;
	}

	/**
	 * Sets the e s f renewal local service.
	 *
	 * @param esfRenewalLocalService the e s f renewal local service
	 */
	public void setESFRenewalLocalService(
		it.ethica.esf.service.ESFRenewalLocalService esfRenewalLocalService) {
		this.esfRenewalLocalService = esfRenewalLocalService;
	}

	/**
	 * Returns the e s f renewal persistence.
	 *
	 * @return the e s f renewal persistence
	 */
	public ESFRenewalPersistence getESFRenewalPersistence() {
		return esfRenewalPersistence;
	}

	/**
	 * Sets the e s f renewal persistence.
	 *
	 * @param esfRenewalPersistence the e s f renewal persistence
	 */
	public void setESFRenewalPersistence(
		ESFRenewalPersistence esfRenewalPersistence) {
		this.esfRenewalPersistence = esfRenewalPersistence;
	}

	/**
	 * Returns the e s f result local service.
	 *
	 * @return the e s f result local service
	 */
	public it.ethica.esf.service.ESFResultLocalService getESFResultLocalService() {
		return esfResultLocalService;
	}

	/**
	 * Sets the e s f result local service.
	 *
	 * @param esfResultLocalService the e s f result local service
	 */
	public void setESFResultLocalService(
		it.ethica.esf.service.ESFResultLocalService esfResultLocalService) {
		this.esfResultLocalService = esfResultLocalService;
	}

	/**
	 * Returns the e s f result persistence.
	 *
	 * @return the e s f result persistence
	 */
	public ESFResultPersistence getESFResultPersistence() {
		return esfResultPersistence;
	}

	/**
	 * Sets the e s f result persistence.
	 *
	 * @param esfResultPersistence the e s f result persistence
	 */
	public void setESFResultPersistence(
		ESFResultPersistence esfResultPersistence) {
		this.esfResultPersistence = esfResultPersistence;
	}

	/**
	 * Returns the e s f result finder.
	 *
	 * @return the e s f result finder
	 */
	public ESFResultFinder getESFResultFinder() {
		return esfResultFinder;
	}

	/**
	 * Sets the e s f result finder.
	 *
	 * @param esfResultFinder the e s f result finder
	 */
	public void setESFResultFinder(ESFResultFinder esfResultFinder) {
		this.esfResultFinder = esfResultFinder;
	}

	/**
	 * Returns the e s f shooter affiliation chrono local service.
	 *
	 * @return the e s f shooter affiliation chrono local service
	 */
	public it.ethica.esf.service.ESFShooterAffiliationChronoLocalService getESFShooterAffiliationChronoLocalService() {
		return esfShooterAffiliationChronoLocalService;
	}

	/**
	 * Sets the e s f shooter affiliation chrono local service.
	 *
	 * @param esfShooterAffiliationChronoLocalService the e s f shooter affiliation chrono local service
	 */
	public void setESFShooterAffiliationChronoLocalService(
		it.ethica.esf.service.ESFShooterAffiliationChronoLocalService esfShooterAffiliationChronoLocalService) {
		this.esfShooterAffiliationChronoLocalService = esfShooterAffiliationChronoLocalService;
	}

	/**
	 * Returns the e s f shooter affiliation chrono persistence.
	 *
	 * @return the e s f shooter affiliation chrono persistence
	 */
	public ESFShooterAffiliationChronoPersistence getESFShooterAffiliationChronoPersistence() {
		return esfShooterAffiliationChronoPersistence;
	}

	/**
	 * Sets the e s f shooter affiliation chrono persistence.
	 *
	 * @param esfShooterAffiliationChronoPersistence the e s f shooter affiliation chrono persistence
	 */
	public void setESFShooterAffiliationChronoPersistence(
		ESFShooterAffiliationChronoPersistence esfShooterAffiliationChronoPersistence) {
		this.esfShooterAffiliationChronoPersistence = esfShooterAffiliationChronoPersistence;
	}

	/**
	 * Returns the e s f shooter affiliation chrono finder.
	 *
	 * @return the e s f shooter affiliation chrono finder
	 */
	public ESFShooterAffiliationChronoFinder getESFShooterAffiliationChronoFinder() {
		return esfShooterAffiliationChronoFinder;
	}

	/**
	 * Sets the e s f shooter affiliation chrono finder.
	 *
	 * @param esfShooterAffiliationChronoFinder the e s f shooter affiliation chrono finder
	 */
	public void setESFShooterAffiliationChronoFinder(
		ESFShooterAffiliationChronoFinder esfShooterAffiliationChronoFinder) {
		this.esfShooterAffiliationChronoFinder = esfShooterAffiliationChronoFinder;
	}

	/**
	 * Returns the e s f shooter category local service.
	 *
	 * @return the e s f shooter category local service
	 */
	public it.ethica.esf.service.ESFShooterCategoryLocalService getESFShooterCategoryLocalService() {
		return esfShooterCategoryLocalService;
	}

	/**
	 * Sets the e s f shooter category local service.
	 *
	 * @param esfShooterCategoryLocalService the e s f shooter category local service
	 */
	public void setESFShooterCategoryLocalService(
		it.ethica.esf.service.ESFShooterCategoryLocalService esfShooterCategoryLocalService) {
		this.esfShooterCategoryLocalService = esfShooterCategoryLocalService;
	}

	/**
	 * Returns the e s f shooter category persistence.
	 *
	 * @return the e s f shooter category persistence
	 */
	public ESFShooterCategoryPersistence getESFShooterCategoryPersistence() {
		return esfShooterCategoryPersistence;
	}

	/**
	 * Sets the e s f shooter category persistence.
	 *
	 * @param esfShooterCategoryPersistence the e s f shooter category persistence
	 */
	public void setESFShooterCategoryPersistence(
		ESFShooterCategoryPersistence esfShooterCategoryPersistence) {
		this.esfShooterCategoryPersistence = esfShooterCategoryPersistence;
	}

	/**
	 * Returns the e s f shooter category e s f match local service.
	 *
	 * @return the e s f shooter category e s f match local service
	 */
	public it.ethica.esf.service.ESFShooterCategoryESFMatchLocalService getESFShooterCategoryESFMatchLocalService() {
		return esfShooterCategoryESFMatchLocalService;
	}

	/**
	 * Sets the e s f shooter category e s f match local service.
	 *
	 * @param esfShooterCategoryESFMatchLocalService the e s f shooter category e s f match local service
	 */
	public void setESFShooterCategoryESFMatchLocalService(
		it.ethica.esf.service.ESFShooterCategoryESFMatchLocalService esfShooterCategoryESFMatchLocalService) {
		this.esfShooterCategoryESFMatchLocalService = esfShooterCategoryESFMatchLocalService;
	}

	/**
	 * Returns the e s f shooter category e s f match persistence.
	 *
	 * @return the e s f shooter category e s f match persistence
	 */
	public ESFShooterCategoryESFMatchPersistence getESFShooterCategoryESFMatchPersistence() {
		return esfShooterCategoryESFMatchPersistence;
	}

	/**
	 * Sets the e s f shooter category e s f match persistence.
	 *
	 * @param esfShooterCategoryESFMatchPersistence the e s f shooter category e s f match persistence
	 */
	public void setESFShooterCategoryESFMatchPersistence(
		ESFShooterCategoryESFMatchPersistence esfShooterCategoryESFMatchPersistence) {
		this.esfShooterCategoryESFMatchPersistence = esfShooterCategoryESFMatchPersistence;
	}

	/**
	 * Returns the e s f shooter category e s f tournament persistence.
	 *
	 * @return the e s f shooter category e s f tournament persistence
	 */
	public ESFShooterCategoryESFTournamentPersistence getESFShooterCategoryESFTournamentPersistence() {
		return esfShooterCategoryESFTournamentPersistence;
	}

	/**
	 * Sets the e s f shooter category e s f tournament persistence.
	 *
	 * @param esfShooterCategoryESFTournamentPersistence the e s f shooter category e s f tournament persistence
	 */
	public void setESFShooterCategoryESFTournamentPersistence(
		ESFShooterCategoryESFTournamentPersistence esfShooterCategoryESFTournamentPersistence) {
		this.esfShooterCategoryESFTournamentPersistence = esfShooterCategoryESFTournamentPersistence;
	}

	/**
	 * Returns the e s f shooter qualification local service.
	 *
	 * @return the e s f shooter qualification local service
	 */
	public it.ethica.esf.service.ESFShooterQualificationLocalService getESFShooterQualificationLocalService() {
		return esfShooterQualificationLocalService;
	}

	/**
	 * Sets the e s f shooter qualification local service.
	 *
	 * @param esfShooterQualificationLocalService the e s f shooter qualification local service
	 */
	public void setESFShooterQualificationLocalService(
		it.ethica.esf.service.ESFShooterQualificationLocalService esfShooterQualificationLocalService) {
		this.esfShooterQualificationLocalService = esfShooterQualificationLocalService;
	}

	/**
	 * Returns the e s f shooter qualification persistence.
	 *
	 * @return the e s f shooter qualification persistence
	 */
	public ESFShooterQualificationPersistence getESFShooterQualificationPersistence() {
		return esfShooterQualificationPersistence;
	}

	/**
	 * Sets the e s f shooter qualification persistence.
	 *
	 * @param esfShooterQualificationPersistence the e s f shooter qualification persistence
	 */
	public void setESFShooterQualificationPersistence(
		ESFShooterQualificationPersistence esfShooterQualificationPersistence) {
		this.esfShooterQualificationPersistence = esfShooterQualificationPersistence;
	}

	/**
	 * Returns the e s f shooter qualification e s f match local service.
	 *
	 * @return the e s f shooter qualification e s f match local service
	 */
	public it.ethica.esf.service.ESFShooterQualificationESFMatchLocalService getESFShooterQualificationESFMatchLocalService() {
		return esfShooterQualificationESFMatchLocalService;
	}

	/**
	 * Sets the e s f shooter qualification e s f match local service.
	 *
	 * @param esfShooterQualificationESFMatchLocalService the e s f shooter qualification e s f match local service
	 */
	public void setESFShooterQualificationESFMatchLocalService(
		it.ethica.esf.service.ESFShooterQualificationESFMatchLocalService esfShooterQualificationESFMatchLocalService) {
		this.esfShooterQualificationESFMatchLocalService = esfShooterQualificationESFMatchLocalService;
	}

	/**
	 * Returns the e s f shooter qualification e s f match persistence.
	 *
	 * @return the e s f shooter qualification e s f match persistence
	 */
	public ESFShooterQualificationESFMatchPersistence getESFShooterQualificationESFMatchPersistence() {
		return esfShooterQualificationESFMatchPersistence;
	}

	/**
	 * Sets the e s f shooter qualification e s f match persistence.
	 *
	 * @param esfShooterQualificationESFMatchPersistence the e s f shooter qualification e s f match persistence
	 */
	public void setESFShooterQualificationESFMatchPersistence(
		ESFShooterQualificationESFMatchPersistence esfShooterQualificationESFMatchPersistence) {
		this.esfShooterQualificationESFMatchPersistence = esfShooterQualificationESFMatchPersistence;
	}

	/**
	 * Returns the e s f shooter qualification e s f tournament persistence.
	 *
	 * @return the e s f shooter qualification e s f tournament persistence
	 */
	public ESFShooterQualificationESFTournamentPersistence getESFShooterQualificationESFTournamentPersistence() {
		return esfShooterQualificationESFTournamentPersistence;
	}

	/**
	 * Sets the e s f shooter qualification e s f tournament persistence.
	 *
	 * @param esfShooterQualificationESFTournamentPersistence the e s f shooter qualification e s f tournament persistence
	 */
	public void setESFShooterQualificationESFTournamentPersistence(
		ESFShooterQualificationESFTournamentPersistence esfShooterQualificationESFTournamentPersistence) {
		this.esfShooterQualificationESFTournamentPersistence = esfShooterQualificationESFTournamentPersistence;
	}

	/**
	 * Returns the e s f shooting director local service.
	 *
	 * @return the e s f shooting director local service
	 */
	public it.ethica.esf.service.ESFShootingDirectorLocalService getESFShootingDirectorLocalService() {
		return esfShootingDirectorLocalService;
	}

	/**
	 * Sets the e s f shooting director local service.
	 *
	 * @param esfShootingDirectorLocalService the e s f shooting director local service
	 */
	public void setESFShootingDirectorLocalService(
		it.ethica.esf.service.ESFShootingDirectorLocalService esfShootingDirectorLocalService) {
		this.esfShootingDirectorLocalService = esfShootingDirectorLocalService;
	}

	/**
	 * Returns the e s f shooting director persistence.
	 *
	 * @return the e s f shooting director persistence
	 */
	public ESFShootingDirectorPersistence getESFShootingDirectorPersistence() {
		return esfShootingDirectorPersistence;
	}

	/**
	 * Sets the e s f shooting director persistence.
	 *
	 * @param esfShootingDirectorPersistence the e s f shooting director persistence
	 */
	public void setESFShootingDirectorPersistence(
		ESFShootingDirectorPersistence esfShootingDirectorPersistence) {
		this.esfShootingDirectorPersistence = esfShootingDirectorPersistence;
	}

	/**
	 * Returns the e s f shooting director finder.
	 *
	 * @return the e s f shooting director finder
	 */
	public ESFShootingDirectorFinder getESFShootingDirectorFinder() {
		return esfShootingDirectorFinder;
	}

	/**
	 * Sets the e s f shooting director finder.
	 *
	 * @param esfShootingDirectorFinder the e s f shooting director finder
	 */
	public void setESFShootingDirectorFinder(
		ESFShootingDirectorFinder esfShootingDirectorFinder) {
		this.esfShootingDirectorFinder = esfShootingDirectorFinder;
	}

	/**
	 * Returns the e s f shooting director qualification local service.
	 *
	 * @return the e s f shooting director qualification local service
	 */
	public it.ethica.esf.service.ESFShootingDirectorQualificationLocalService getESFShootingDirectorQualificationLocalService() {
		return esfShootingDirectorQualificationLocalService;
	}

	/**
	 * Sets the e s f shooting director qualification local service.
	 *
	 * @param esfShootingDirectorQualificationLocalService the e s f shooting director qualification local service
	 */
	public void setESFShootingDirectorQualificationLocalService(
		it.ethica.esf.service.ESFShootingDirectorQualificationLocalService esfShootingDirectorQualificationLocalService) {
		this.esfShootingDirectorQualificationLocalService = esfShootingDirectorQualificationLocalService;
	}

	/**
	 * Returns the e s f shooting director qualification persistence.
	 *
	 * @return the e s f shooting director qualification persistence
	 */
	public ESFShootingDirectorQualificationPersistence getESFShootingDirectorQualificationPersistence() {
		return esfShootingDirectorQualificationPersistence;
	}

	/**
	 * Sets the e s f shooting director qualification persistence.
	 *
	 * @param esfShootingDirectorQualificationPersistence the e s f shooting director qualification persistence
	 */
	public void setESFShootingDirectorQualificationPersistence(
		ESFShootingDirectorQualificationPersistence esfShootingDirectorQualificationPersistence) {
		this.esfShootingDirectorQualificationPersistence = esfShootingDirectorQualificationPersistence;
	}

	/**
	 * Returns the e s f specific local service.
	 *
	 * @return the e s f specific local service
	 */
	public it.ethica.esf.service.ESFSpecificLocalService getESFSpecificLocalService() {
		return esfSpecificLocalService;
	}

	/**
	 * Sets the e s f specific local service.
	 *
	 * @param esfSpecificLocalService the e s f specific local service
	 */
	public void setESFSpecificLocalService(
		it.ethica.esf.service.ESFSpecificLocalService esfSpecificLocalService) {
		this.esfSpecificLocalService = esfSpecificLocalService;
	}

	/**
	 * Returns the e s f specific remote service.
	 *
	 * @return the e s f specific remote service
	 */
	public it.ethica.esf.service.ESFSpecificService getESFSpecificService() {
		return esfSpecificService;
	}

	/**
	 * Sets the e s f specific remote service.
	 *
	 * @param esfSpecificService the e s f specific remote service
	 */
	public void setESFSpecificService(
		it.ethica.esf.service.ESFSpecificService esfSpecificService) {
		this.esfSpecificService = esfSpecificService;
	}

	/**
	 * Returns the e s f specific persistence.
	 *
	 * @return the e s f specific persistence
	 */
	public ESFSpecificPersistence getESFSpecificPersistence() {
		return esfSpecificPersistence;
	}

	/**
	 * Sets the e s f specific persistence.
	 *
	 * @param esfSpecificPersistence the e s f specific persistence
	 */
	public void setESFSpecificPersistence(
		ESFSpecificPersistence esfSpecificPersistence) {
		this.esfSpecificPersistence = esfSpecificPersistence;
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
	 * Returns the e s f state local service.
	 *
	 * @return the e s f state local service
	 */
	public it.ethica.esf.service.ESFStateLocalService getESFStateLocalService() {
		return esfStateLocalService;
	}

	/**
	 * Sets the e s f state local service.
	 *
	 * @param esfStateLocalService the e s f state local service
	 */
	public void setESFStateLocalService(
		it.ethica.esf.service.ESFStateLocalService esfStateLocalService) {
		this.esfStateLocalService = esfStateLocalService;
	}

	/**
	 * Returns the e s f state persistence.
	 *
	 * @return the e s f state persistence
	 */
	public ESFStatePersistence getESFStatePersistence() {
		return esfStatePersistence;
	}

	/**
	 * Sets the e s f state persistence.
	 *
	 * @param esfStatePersistence the e s f state persistence
	 */
	public void setESFStatePersistence(ESFStatePersistence esfStatePersistence) {
		this.esfStatePersistence = esfStatePersistence;
	}

	/**
	 * Returns the e s f state ass entity persistence.
	 *
	 * @return the e s f state ass entity persistence
	 */
	public ESFStateAssEntityPersistence getESFStateAssEntityPersistence() {
		return esfStateAssEntityPersistence;
	}

	/**
	 * Sets the e s f state ass entity persistence.
	 *
	 * @param esfStateAssEntityPersistence the e s f state ass entity persistence
	 */
	public void setESFStateAssEntityPersistence(
		ESFStateAssEntityPersistence esfStateAssEntityPersistence) {
		this.esfStateAssEntityPersistence = esfStateAssEntityPersistence;
	}

	/**
	 * Returns the e s f suspensive code local service.
	 *
	 * @return the e s f suspensive code local service
	 */
	public it.ethica.esf.service.ESFSuspensiveCodeLocalService getESFSuspensiveCodeLocalService() {
		return esfSuspensiveCodeLocalService;
	}

	/**
	 * Sets the e s f suspensive code local service.
	 *
	 * @param esfSuspensiveCodeLocalService the e s f suspensive code local service
	 */
	public void setESFSuspensiveCodeLocalService(
		it.ethica.esf.service.ESFSuspensiveCodeLocalService esfSuspensiveCodeLocalService) {
		this.esfSuspensiveCodeLocalService = esfSuspensiveCodeLocalService;
	}

	/**
	 * Returns the e s f suspensive code persistence.
	 *
	 * @return the e s f suspensive code persistence
	 */
	public ESFSuspensiveCodePersistence getESFSuspensiveCodePersistence() {
		return esfSuspensiveCodePersistence;
	}

	/**
	 * Sets the e s f suspensive code persistence.
	 *
	 * @param esfSuspensiveCodePersistence the e s f suspensive code persistence
	 */
	public void setESFSuspensiveCodePersistence(
		ESFSuspensiveCodePersistence esfSuspensiveCodePersistence) {
		this.esfSuspensiveCodePersistence = esfSuspensiveCodePersistence;
	}

	/**
	 * Returns the e s f suspensive shooting director local service.
	 *
	 * @return the e s f suspensive shooting director local service
	 */
	public it.ethica.esf.service.ESFSuspensiveShootingDirectorLocalService getESFSuspensiveShootingDirectorLocalService() {
		return esfSuspensiveShootingDirectorLocalService;
	}

	/**
	 * Sets the e s f suspensive shooting director local service.
	 *
	 * @param esfSuspensiveShootingDirectorLocalService the e s f suspensive shooting director local service
	 */
	public void setESFSuspensiveShootingDirectorLocalService(
		it.ethica.esf.service.ESFSuspensiveShootingDirectorLocalService esfSuspensiveShootingDirectorLocalService) {
		this.esfSuspensiveShootingDirectorLocalService = esfSuspensiveShootingDirectorLocalService;
	}

	/**
	 * Returns the e s f suspensive shooting director persistence.
	 *
	 * @return the e s f suspensive shooting director persistence
	 */
	public ESFSuspensiveShootingDirectorPersistence getESFSuspensiveShootingDirectorPersistence() {
		return esfSuspensiveShootingDirectorPersistence;
	}

	/**
	 * Sets the e s f suspensive shooting director persistence.
	 *
	 * @param esfSuspensiveShootingDirectorPersistence the e s f suspensive shooting director persistence
	 */
	public void setESFSuspensiveShootingDirectorPersistence(
		ESFSuspensiveShootingDirectorPersistence esfSuspensiveShootingDirectorPersistence) {
		this.esfSuspensiveShootingDirectorPersistence = esfSuspensiveShootingDirectorPersistence;
	}

	/**
	 * Returns the e s f team local service.
	 *
	 * @return the e s f team local service
	 */
	public it.ethica.esf.service.ESFTeamLocalService getESFTeamLocalService() {
		return esfTeamLocalService;
	}

	/**
	 * Sets the e s f team local service.
	 *
	 * @param esfTeamLocalService the e s f team local service
	 */
	public void setESFTeamLocalService(
		it.ethica.esf.service.ESFTeamLocalService esfTeamLocalService) {
		this.esfTeamLocalService = esfTeamLocalService;
	}

	/**
	 * Returns the e s f team persistence.
	 *
	 * @return the e s f team persistence
	 */
	public ESFTeamPersistence getESFTeamPersistence() {
		return esfTeamPersistence;
	}

	/**
	 * Sets the e s f team persistence.
	 *
	 * @param esfTeamPersistence the e s f team persistence
	 */
	public void setESFTeamPersistence(ESFTeamPersistence esfTeamPersistence) {
		this.esfTeamPersistence = esfTeamPersistence;
	}

	/**
	 * Returns the e s f tournament local service.
	 *
	 * @return the e s f tournament local service
	 */
	public it.ethica.esf.service.ESFTournamentLocalService getESFTournamentLocalService() {
		return esfTournamentLocalService;
	}

	/**
	 * Sets the e s f tournament local service.
	 *
	 * @param esfTournamentLocalService the e s f tournament local service
	 */
	public void setESFTournamentLocalService(
		it.ethica.esf.service.ESFTournamentLocalService esfTournamentLocalService) {
		this.esfTournamentLocalService = esfTournamentLocalService;
	}

	/**
	 * Returns the e s f tournament persistence.
	 *
	 * @return the e s f tournament persistence
	 */
	public ESFTournamentPersistence getESFTournamentPersistence() {
		return esfTournamentPersistence;
	}

	/**
	 * Sets the e s f tournament persistence.
	 *
	 * @param esfTournamentPersistence the e s f tournament persistence
	 */
	public void setESFTournamentPersistence(
		ESFTournamentPersistence esfTournamentPersistence) {
		this.esfTournamentPersistence = esfTournamentPersistence;
	}

	/**
	 * Returns the e s f transition local service.
	 *
	 * @return the e s f transition local service
	 */
	public it.ethica.esf.service.ESFTransitionLocalService getESFTransitionLocalService() {
		return esfTransitionLocalService;
	}

	/**
	 * Sets the e s f transition local service.
	 *
	 * @param esfTransitionLocalService the e s f transition local service
	 */
	public void setESFTransitionLocalService(
		it.ethica.esf.service.ESFTransitionLocalService esfTransitionLocalService) {
		this.esfTransitionLocalService = esfTransitionLocalService;
	}

	/**
	 * Returns the e s f transition persistence.
	 *
	 * @return the e s f transition persistence
	 */
	public ESFTransitionPersistence getESFTransitionPersistence() {
		return esfTransitionPersistence;
	}

	/**
	 * Sets the e s f transition persistence.
	 *
	 * @param esfTransitionPersistence the e s f transition persistence
	 */
	public void setESFTransitionPersistence(
		ESFTransitionPersistence esfTransitionPersistence) {
		this.esfTransitionPersistence = esfTransitionPersistence;
	}

	/**
	 * Returns the e s f unitservice local service.
	 *
	 * @return the e s f unitservice local service
	 */
	public it.ethica.esf.service.ESFUnitserviceLocalService getESFUnitserviceLocalService() {
		return esfUnitserviceLocalService;
	}

	/**
	 * Sets the e s f unitservice local service.
	 *
	 * @param esfUnitserviceLocalService the e s f unitservice local service
	 */
	public void setESFUnitserviceLocalService(
		it.ethica.esf.service.ESFUnitserviceLocalService esfUnitserviceLocalService) {
		this.esfUnitserviceLocalService = esfUnitserviceLocalService;
	}

	/**
	 * Returns the e s f unitservice persistence.
	 *
	 * @return the e s f unitservice persistence
	 */
	public ESFUnitservicePersistence getESFUnitservicePersistence() {
		return esfUnitservicePersistence;
	}

	/**
	 * Sets the e s f unitservice persistence.
	 *
	 * @param esfUnitservicePersistence the e s f unitservice persistence
	 */
	public void setESFUnitservicePersistence(
		ESFUnitservicePersistence esfUnitservicePersistence) {
		this.esfUnitservicePersistence = esfUnitservicePersistence;
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
	 * Returns the e s f user remote service.
	 *
	 * @return the e s f user remote service
	 */
	public it.ethica.esf.service.ESFUserService getESFUserService() {
		return esfUserService;
	}

	/**
	 * Sets the e s f user remote service.
	 *
	 * @param esfUserService the e s f user remote service
	 */
	public void setESFUserService(
		it.ethica.esf.service.ESFUserService esfUserService) {
		this.esfUserService = esfUserService;
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
	 * Returns the e s f user finder.
	 *
	 * @return the e s f user finder
	 */
	public ESFUserFinder getESFUserFinder() {
		return esfUserFinder;
	}

	/**
	 * Sets the e s f user finder.
	 *
	 * @param esfUserFinder the e s f user finder
	 */
	public void setESFUserFinder(ESFUserFinder esfUserFinder) {
		this.esfUserFinder = esfUserFinder;
	}

	/**
	 * Returns the e s f user category local service.
	 *
	 * @return the e s f user category local service
	 */
	public it.ethica.esf.service.ESFUserCategoryLocalService getESFUserCategoryLocalService() {
		return esfUserCategoryLocalService;
	}

	/**
	 * Sets the e s f user category local service.
	 *
	 * @param esfUserCategoryLocalService the e s f user category local service
	 */
	public void setESFUserCategoryLocalService(
		it.ethica.esf.service.ESFUserCategoryLocalService esfUserCategoryLocalService) {
		this.esfUserCategoryLocalService = esfUserCategoryLocalService;
	}

	/**
	 * Returns the e s f user category persistence.
	 *
	 * @return the e s f user category persistence
	 */
	public ESFUserCategoryPersistence getESFUserCategoryPersistence() {
		return esfUserCategoryPersistence;
	}

	/**
	 * Sets the e s f user category persistence.
	 *
	 * @param esfUserCategoryPersistence the e s f user category persistence
	 */
	public void setESFUserCategoryPersistence(
		ESFUserCategoryPersistence esfUserCategoryPersistence) {
		this.esfUserCategoryPersistence = esfUserCategoryPersistence;
	}

	/**
	 * Returns the e s f user category finder.
	 *
	 * @return the e s f user category finder
	 */
	public ESFUserCategoryFinder getESFUserCategoryFinder() {
		return esfUserCategoryFinder;
	}

	/**
	 * Sets the e s f user category finder.
	 *
	 * @param esfUserCategoryFinder the e s f user category finder
	 */
	public void setESFUserCategoryFinder(
		ESFUserCategoryFinder esfUserCategoryFinder) {
		this.esfUserCategoryFinder = esfUserCategoryFinder;
	}

	/**
	 * Returns the e s f user e s f federal role local service.
	 *
	 * @return the e s f user e s f federal role local service
	 */
	public it.ethica.esf.service.ESFUserESFFederalRoleLocalService getESFUserESFFederalRoleLocalService() {
		return esfUserESFFederalRoleLocalService;
	}

	/**
	 * Sets the e s f user e s f federal role local service.
	 *
	 * @param esfUserESFFederalRoleLocalService the e s f user e s f federal role local service
	 */
	public void setESFUserESFFederalRoleLocalService(
		it.ethica.esf.service.ESFUserESFFederalRoleLocalService esfUserESFFederalRoleLocalService) {
		this.esfUserESFFederalRoleLocalService = esfUserESFFederalRoleLocalService;
	}

	/**
	 * Returns the e s f user e s f federal role persistence.
	 *
	 * @return the e s f user e s f federal role persistence
	 */
	public ESFUserESFFederalRolePersistence getESFUserESFFederalRolePersistence() {
		return esfUserESFFederalRolePersistence;
	}

	/**
	 * Sets the e s f user e s f federal role persistence.
	 *
	 * @param esfUserESFFederalRolePersistence the e s f user e s f federal role persistence
	 */
	public void setESFUserESFFederalRolePersistence(
		ESFUserESFFederalRolePersistence esfUserESFFederalRolePersistence) {
		this.esfUserESFFederalRolePersistence = esfUserESFFederalRolePersistence;
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
	 * Returns the e s f user e s f user role finder.
	 *
	 * @return the e s f user e s f user role finder
	 */
	public ESFUserESFUserRoleFinder getESFUserESFUserRoleFinder() {
		return esfUserESFUserRoleFinder;
	}

	/**
	 * Sets the e s f user e s f user role finder.
	 *
	 * @param esfUserESFUserRoleFinder the e s f user e s f user role finder
	 */
	public void setESFUserESFUserRoleFinder(
		ESFUserESFUserRoleFinder esfUserESFUserRoleFinder) {
		this.esfUserESFUserRoleFinder = esfUserESFUserRoleFinder;
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
	 * Returns the vw_datidirettoretiro local service.
	 *
	 * @return the vw_datidirettoretiro local service
	 */
	public it.ethica.esf.service.vw_datidirettoretiroLocalService getvw_datidirettoretiroLocalService() {
		return vw_datidirettoretiroLocalService;
	}

	/**
	 * Sets the vw_datidirettoretiro local service.
	 *
	 * @param vw_datidirettoretiroLocalService the vw_datidirettoretiro local service
	 */
	public void setvw_datidirettoretiroLocalService(
		it.ethica.esf.service.vw_datidirettoretiroLocalService vw_datidirettoretiroLocalService) {
		this.vw_datidirettoretiroLocalService = vw_datidirettoretiroLocalService;
	}

	/**
	 * Returns the vw_datidirettoretiro persistence.
	 *
	 * @return the vw_datidirettoretiro persistence
	 */
	public vw_datidirettoretiroPersistence getvw_datidirettoretiroPersistence() {
		return vw_datidirettoretiroPersistence;
	}

	/**
	 * Sets the vw_datidirettoretiro persistence.
	 *
	 * @param vw_datidirettoretiroPersistence the vw_datidirettoretiro persistence
	 */
	public void setvw_datidirettoretiroPersistence(
		vw_datidirettoretiroPersistence vw_datidirettoretiroPersistence) {
		this.vw_datidirettoretiroPersistence = vw_datidirettoretiroPersistence;
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

		PersistedModelLocalServiceRegistryUtil.register("it.ethica.esf.model.ESFUserESFUserRole",
			esfUserESFUserRoleLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"it.ethica.esf.model.ESFUserESFUserRole");
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
		return ESFUserESFUserRole.class;
	}

	protected String getModelClassName() {
		return ESFUserESFUserRole.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = esfUserESFUserRolePersistence.getDataSource();

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
	@BeanReference(type = it.ethica.esf.service.ESFAirportLocalService.class)
	protected it.ethica.esf.service.ESFAirportLocalService esfAirportLocalService;
	@BeanReference(type = ESFAirportPersistence.class)
	protected ESFAirportPersistence esfAirportPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFAnnualConiReportLocalService.class)
	protected it.ethica.esf.service.ESFAnnualConiReportLocalService esfAnnualConiReportLocalService;
	@BeanReference(type = ESFAnnualConiReportPersistence.class)
	protected ESFAnnualConiReportPersistence esfAnnualConiReportPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFAnnualFreeCardLocalService.class)
	protected it.ethica.esf.service.ESFAnnualFreeCardLocalService esfAnnualFreeCardLocalService;
	@BeanReference(type = ESFAnnualFreeCardPersistence.class)
	protected ESFAnnualFreeCardPersistence esfAnnualFreeCardPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFBrandLocalService.class)
	protected it.ethica.esf.service.ESFBrandLocalService esfBrandLocalService;
	@BeanReference(type = ESFBrandPersistence.class)
	protected ESFBrandPersistence esfBrandPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFCaneLocalService.class)
	protected it.ethica.esf.service.ESFCaneLocalService esfCaneLocalService;
	@BeanReference(type = ESFCanePersistence.class)
	protected ESFCanePersistence esfCanePersistence;
	@BeanReference(type = it.ethica.esf.service.ESFCardLocalService.class)
	protected it.ethica.esf.service.ESFCardLocalService esfCardLocalService;
	@BeanReference(type = it.ethica.esf.service.ESFCardService.class)
	protected it.ethica.esf.service.ESFCardService esfCardService;
	@BeanReference(type = ESFCardPersistence.class)
	protected ESFCardPersistence esfCardPersistence;
	@BeanReference(type = ESFCardFinder.class)
	protected ESFCardFinder esfCardFinder;
	@BeanReference(type = it.ethica.esf.service.ESFCategoryLocalService.class)
	protected it.ethica.esf.service.ESFCategoryLocalService esfCategoryLocalService;
	@BeanReference(type = ESFCategoryPersistence.class)
	protected ESFCategoryPersistence esfCategoryPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFCatridgeLocalService.class)
	protected it.ethica.esf.service.ESFCatridgeLocalService esfCatridgeLocalService;
	@BeanReference(type = ESFCatridgePersistence.class)
	protected ESFCatridgePersistence esfCatridgePersistence;
	@BeanReference(type = it.ethica.esf.service.ESFCityLocalService.class)
	protected it.ethica.esf.service.ESFCityLocalService esfCityLocalService;
	@BeanReference(type = ESFCityPersistence.class)
	protected ESFCityPersistence esfCityPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFCodeOrgLocalService.class)
	protected it.ethica.esf.service.ESFCodeOrgLocalService esfCodeOrgLocalService;
	@BeanReference(type = ESFCodeOrgPersistence.class)
	protected ESFCodeOrgPersistence esfCodeOrgPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFConfigurationLocalService.class)
	protected it.ethica.esf.service.ESFConfigurationLocalService esfConfigurationLocalService;
	@BeanReference(type = ESFConfigurationPersistence.class)
	protected ESFConfigurationPersistence esfConfigurationPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFCountryLocalService.class)
	protected it.ethica.esf.service.ESFCountryLocalService esfCountryLocalService;
	@BeanReference(type = ESFCountryPersistence.class)
	protected ESFCountryPersistence esfCountryPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFDepartureLocalService.class)
	protected it.ethica.esf.service.ESFDepartureLocalService esfDepartureLocalService;
	@BeanReference(type = ESFDeparturePersistence.class)
	protected ESFDeparturePersistence esfDeparturePersistence;
	@BeanReference(type = it.ethica.esf.service.ESFDescriptionLocalService.class)
	protected it.ethica.esf.service.ESFDescriptionLocalService esfDescriptionLocalService;
	@BeanReference(type = ESFDescriptionPersistence.class)
	protected ESFDescriptionPersistence esfDescriptionPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFDocumentLocalService.class)
	protected it.ethica.esf.service.ESFDocumentLocalService esfDocumentLocalService;
	@BeanReference(type = ESFDocumentPersistence.class)
	protected ESFDocumentPersistence esfDocumentPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFElectronicLocalService.class)
	protected it.ethica.esf.service.ESFElectronicLocalService esfElectronicLocalService;
	@BeanReference(type = ESFElectronicPersistence.class)
	protected ESFElectronicPersistence esfElectronicPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFEntityStateLocalService.class)
	protected it.ethica.esf.service.ESFEntityStateLocalService esfEntityStateLocalService;
	@BeanReference(type = ESFEntityStatePersistence.class)
	protected ESFEntityStatePersistence esfEntityStatePersistence;
	@BeanReference(type = ESFEntityStateFinder.class)
	protected ESFEntityStateFinder esfEntityStateFinder;
	@BeanReference(type = it.ethica.esf.service.ESFEventTypeLocalService.class)
	protected it.ethica.esf.service.ESFEventTypeLocalService esfEventTypeLocalService;
	@BeanReference(type = ESFEventTypePersistence.class)
	protected ESFEventTypePersistence esfEventTypePersistence;
	@BeanReference(type = it.ethica.esf.service.ESFFederalRoleLocalService.class)
	protected it.ethica.esf.service.ESFFederalRoleLocalService esfFederalRoleLocalService;
	@BeanReference(type = it.ethica.esf.service.ESFFederalRoleService.class)
	protected it.ethica.esf.service.ESFFederalRoleService esfFederalRoleService;
	@BeanReference(type = ESFFederalRolePersistence.class)
	protected ESFFederalRolePersistence esfFederalRolePersistence;
	@BeanReference(type = ESFFederalRoleFinder.class)
	protected ESFFederalRoleFinder esfFederalRoleFinder;
	@BeanReference(type = it.ethica.esf.service.ESFFederalRoleESFSpecificLocalService.class)
	protected it.ethica.esf.service.ESFFederalRoleESFSpecificLocalService esfFederalRoleESFSpecificLocalService;
	@BeanReference(type = it.ethica.esf.service.ESFFederalRoleESFSpecificService.class)
	protected it.ethica.esf.service.ESFFederalRoleESFSpecificService esfFederalRoleESFSpecificService;
	@BeanReference(type = ESFFederalRoleESFSpecificPersistence.class)
	protected ESFFederalRoleESFSpecificPersistence esfFederalRoleESFSpecificPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFFieldLocalService.class)
	protected it.ethica.esf.service.ESFFieldLocalService esfFieldLocalService;
	@BeanReference(type = ESFFieldPersistence.class)
	protected ESFFieldPersistence esfFieldPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFFieldESFElectronicLocalService.class)
	protected it.ethica.esf.service.ESFFieldESFElectronicLocalService esfFieldESFElectronicLocalService;
	@BeanReference(type = ESFFieldESFElectronicPersistence.class)
	protected ESFFieldESFElectronicPersistence esfFieldESFElectronicPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFFieldESFSportTypeLocalService.class)
	protected it.ethica.esf.service.ESFFieldESFSportTypeLocalService esfFieldESFSportTypeLocalService;
	@BeanReference(type = ESFFieldESFSportTypePersistence.class)
	protected ESFFieldESFSportTypePersistence esfFieldESFSportTypePersistence;
	@BeanReference(type = it.ethica.esf.service.ESFFornitureLocalService.class)
	protected it.ethica.esf.service.ESFFornitureLocalService esfFornitureLocalService;
	@BeanReference(type = ESFForniturePersistence.class)
	protected ESFForniturePersistence esfForniturePersistence;
	@BeanReference(type = it.ethica.esf.service.ESFFornitureRelLocalService.class)
	protected it.ethica.esf.service.ESFFornitureRelLocalService esfFornitureRelLocalService;
	@BeanReference(type = ESFFornitureRelPersistence.class)
	protected ESFFornitureRelPersistence esfFornitureRelPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFFornitureTypeLocalService.class)
	protected it.ethica.esf.service.ESFFornitureTypeLocalService esfFornitureTypeLocalService;
	@BeanReference(type = ESFFornitureTypePersistence.class)
	protected ESFFornitureTypePersistence esfFornitureTypePersistence;
	@BeanReference(type = it.ethica.esf.service.ESFFornitureUserLocalService.class)
	protected it.ethica.esf.service.ESFFornitureUserLocalService esfFornitureUserLocalService;
	@BeanReference(type = ESFFornitureUserPersistence.class)
	protected ESFFornitureUserPersistence esfFornitureUserPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFGunLocalService.class)
	protected it.ethica.esf.service.ESFGunLocalService esfGunLocalService;
	@BeanReference(type = ESFGunPersistence.class)
	protected ESFGunPersistence esfGunPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFGunKindLocalService.class)
	protected it.ethica.esf.service.ESFGunKindLocalService esfGunKindLocalService;
	@BeanReference(type = ESFGunKindPersistence.class)
	protected ESFGunKindPersistence esfGunKindPersistence;
	@BeanReference(type = ESFGunKindFinder.class)
	protected ESFGunKindFinder esfGunKindFinder;
	@BeanReference(type = it.ethica.esf.service.ESFGunTypeLocalService.class)
	protected it.ethica.esf.service.ESFGunTypeLocalService esfGunTypeLocalService;
	@BeanReference(type = ESFGunTypePersistence.class)
	protected ESFGunTypePersistence esfGunTypePersistence;
	@BeanReference(type = it.ethica.esf.service.ESFgunUserLocalService.class)
	protected it.ethica.esf.service.ESFgunUserLocalService esFgunUserLocalService;
	@BeanReference(type = ESFgunUserPersistence.class)
	protected ESFgunUserPersistence esFgunUserPersistence;
	@BeanReference(type = ESFgunUserFinder.class)
	protected ESFgunUserFinder esFgunUserFinder;
	@BeanReference(type = it.ethica.esf.service.ESFHistoricalAssociationLocalService.class)
	protected it.ethica.esf.service.ESFHistoricalAssociationLocalService esfHistoricalAssociationLocalService;
	@BeanReference(type = ESFHistoricalAssociationPersistence.class)
	protected ESFHistoricalAssociationPersistence esfHistoricalAssociationPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFInstructsShootingDirectorLocalService.class)
	protected it.ethica.esf.service.ESFInstructsShootingDirectorLocalService esfInstructsShootingDirectorLocalService;
	@BeanReference(type = ESFInstructsShootingDirectorPersistence.class)
	protected ESFInstructsShootingDirectorPersistence esfInstructsShootingDirectorPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFJobLocalService.class)
	protected it.ethica.esf.service.ESFJobLocalService esfJobLocalService;
	@BeanReference(type = ESFJobPersistence.class)
	protected ESFJobPersistence esfJobPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFJunioresLocalService.class)
	protected it.ethica.esf.service.ESFJunioresLocalService esfJunioresLocalService;
	@BeanReference(type = ESFJunioresPersistence.class)
	protected ESFJunioresPersistence esfJunioresPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFLentFieldLocalService.class)
	protected it.ethica.esf.service.ESFLentFieldLocalService esfLentFieldLocalService;
	@BeanReference(type = ESFLentFieldPersistence.class)
	protected ESFLentFieldPersistence esfLentFieldPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFMatchLocalService.class)
	protected it.ethica.esf.service.ESFMatchLocalService esfMatchLocalService;
	@BeanReference(type = ESFMatchPersistence.class)
	protected ESFMatchPersistence esfMatchPersistence;
	@BeanReference(type = ESFMatchFinder.class)
	protected ESFMatchFinder esfMatchFinder;
	@BeanReference(type = it.ethica.esf.service.ESFMatchResultLocalService.class)
	protected it.ethica.esf.service.ESFMatchResultLocalService esfMatchResultLocalService;
	@BeanReference(type = ESFMatchResultPersistence.class)
	protected ESFMatchResultPersistence esfMatchResultPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFMatchTypeLocalService.class)
	protected it.ethica.esf.service.ESFMatchTypeLocalService esfMatchTypeLocalService;
	@BeanReference(type = ESFMatchTypePersistence.class)
	protected ESFMatchTypePersistence esfMatchTypePersistence;
	@BeanReference(type = it.ethica.esf.service.ESFNationalLocalService.class)
	protected it.ethica.esf.service.ESFNationalLocalService esfNationalLocalService;
	@BeanReference(type = ESFNationalPersistence.class)
	protected ESFNationalPersistence esfNationalPersistence;
	@BeanReference(type = ESFNationalFinder.class)
	protected ESFNationalFinder esfNationalFinder;
	@BeanReference(type = it.ethica.esf.service.ESFNationalDelegationLocalService.class)
	protected it.ethica.esf.service.ESFNationalDelegationLocalService esfNationalDelegationLocalService;
	@BeanReference(type = ESFNationalDelegationPersistence.class)
	protected ESFNationalDelegationPersistence esfNationalDelegationPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFNationalMatchResultLocalService.class)
	protected it.ethica.esf.service.ESFNationalMatchResultLocalService esfNationalMatchResultLocalService;
	@BeanReference(type = ESFNationalMatchResultPersistence.class)
	protected ESFNationalMatchResultPersistence esfNationalMatchResultPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFOrganizationLocalService.class)
	protected it.ethica.esf.service.ESFOrganizationLocalService esfOrganizationLocalService;
	@BeanReference(type = ESFOrganizationPersistence.class)
	protected ESFOrganizationPersistence esfOrganizationPersistence;
	@BeanReference(type = ESFOrganizationFinder.class)
	protected ESFOrganizationFinder esfOrganizationFinder;
	@BeanReference(type = it.ethica.esf.service.ESFOrganizationUnitserviceLocalService.class)
	protected it.ethica.esf.service.ESFOrganizationUnitserviceLocalService esfOrganizationUnitserviceLocalService;
	@BeanReference(type = ESFOrganizationUnitservicePersistence.class)
	protected ESFOrganizationUnitservicePersistence esfOrganizationUnitservicePersistence;
	@BeanReference(type = it.ethica.esf.service.ESFPartecipantLocalService.class)
	protected it.ethica.esf.service.ESFPartecipantLocalService esfPartecipantLocalService;
	@BeanReference(type = ESFPartecipantPersistence.class)
	protected ESFPartecipantPersistence esfPartecipantPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFPartecipantInfoLocalService.class)
	protected it.ethica.esf.service.ESFPartecipantInfoLocalService esfPartecipantInfoLocalService;
	@BeanReference(type = ESFPartecipantInfoPersistence.class)
	protected ESFPartecipantInfoPersistence esfPartecipantInfoPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFPartecipantTypeLocalService.class)
	protected it.ethica.esf.service.ESFPartecipantTypeLocalService esfPartecipantTypeLocalService;
	@BeanReference(type = ESFPartecipantTypePersistence.class)
	protected ESFPartecipantTypePersistence esfPartecipantTypePersistence;
	@BeanReference(type = it.ethica.esf.service.ESFPhoneLocalService.class)
	protected it.ethica.esf.service.ESFPhoneLocalService esfPhoneLocalService;
	@BeanReference(type = ESFPhonePersistence.class)
	protected ESFPhonePersistence esfPhonePersistence;
	@BeanReference(type = it.ethica.esf.service.ESFProvinceLocalService.class)
	protected it.ethica.esf.service.ESFProvinceLocalService esfProvinceLocalService;
	@BeanReference(type = ESFProvincePersistence.class)
	protected ESFProvincePersistence esfProvincePersistence;
	@BeanReference(type = it.ethica.esf.service.ESFRegionLocalService.class)
	protected it.ethica.esf.service.ESFRegionLocalService esfRegionLocalService;
	@BeanReference(type = ESFRegionPersistence.class)
	protected ESFRegionPersistence esfRegionPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFRenewalLocalService.class)
	protected it.ethica.esf.service.ESFRenewalLocalService esfRenewalLocalService;
	@BeanReference(type = ESFRenewalPersistence.class)
	protected ESFRenewalPersistence esfRenewalPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFResultLocalService.class)
	protected it.ethica.esf.service.ESFResultLocalService esfResultLocalService;
	@BeanReference(type = ESFResultPersistence.class)
	protected ESFResultPersistence esfResultPersistence;
	@BeanReference(type = ESFResultFinder.class)
	protected ESFResultFinder esfResultFinder;
	@BeanReference(type = it.ethica.esf.service.ESFShooterAffiliationChronoLocalService.class)
	protected it.ethica.esf.service.ESFShooterAffiliationChronoLocalService esfShooterAffiliationChronoLocalService;
	@BeanReference(type = ESFShooterAffiliationChronoPersistence.class)
	protected ESFShooterAffiliationChronoPersistence esfShooterAffiliationChronoPersistence;
	@BeanReference(type = ESFShooterAffiliationChronoFinder.class)
	protected ESFShooterAffiliationChronoFinder esfShooterAffiliationChronoFinder;
	@BeanReference(type = it.ethica.esf.service.ESFShooterCategoryLocalService.class)
	protected it.ethica.esf.service.ESFShooterCategoryLocalService esfShooterCategoryLocalService;
	@BeanReference(type = ESFShooterCategoryPersistence.class)
	protected ESFShooterCategoryPersistence esfShooterCategoryPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFShooterCategoryESFMatchLocalService.class)
	protected it.ethica.esf.service.ESFShooterCategoryESFMatchLocalService esfShooterCategoryESFMatchLocalService;
	@BeanReference(type = ESFShooterCategoryESFMatchPersistence.class)
	protected ESFShooterCategoryESFMatchPersistence esfShooterCategoryESFMatchPersistence;
	@BeanReference(type = ESFShooterCategoryESFTournamentPersistence.class)
	protected ESFShooterCategoryESFTournamentPersistence esfShooterCategoryESFTournamentPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFShooterQualificationLocalService.class)
	protected it.ethica.esf.service.ESFShooterQualificationLocalService esfShooterQualificationLocalService;
	@BeanReference(type = ESFShooterQualificationPersistence.class)
	protected ESFShooterQualificationPersistence esfShooterQualificationPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFShooterQualificationESFMatchLocalService.class)
	protected it.ethica.esf.service.ESFShooterQualificationESFMatchLocalService esfShooterQualificationESFMatchLocalService;
	@BeanReference(type = ESFShooterQualificationESFMatchPersistence.class)
	protected ESFShooterQualificationESFMatchPersistence esfShooterQualificationESFMatchPersistence;
	@BeanReference(type = ESFShooterQualificationESFTournamentPersistence.class)
	protected ESFShooterQualificationESFTournamentPersistence esfShooterQualificationESFTournamentPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFShootingDirectorLocalService.class)
	protected it.ethica.esf.service.ESFShootingDirectorLocalService esfShootingDirectorLocalService;
	@BeanReference(type = ESFShootingDirectorPersistence.class)
	protected ESFShootingDirectorPersistence esfShootingDirectorPersistence;
	@BeanReference(type = ESFShootingDirectorFinder.class)
	protected ESFShootingDirectorFinder esfShootingDirectorFinder;
	@BeanReference(type = it.ethica.esf.service.ESFShootingDirectorQualificationLocalService.class)
	protected it.ethica.esf.service.ESFShootingDirectorQualificationLocalService esfShootingDirectorQualificationLocalService;
	@BeanReference(type = ESFShootingDirectorQualificationPersistence.class)
	protected ESFShootingDirectorQualificationPersistence esfShootingDirectorQualificationPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFSpecificLocalService.class)
	protected it.ethica.esf.service.ESFSpecificLocalService esfSpecificLocalService;
	@BeanReference(type = it.ethica.esf.service.ESFSpecificService.class)
	protected it.ethica.esf.service.ESFSpecificService esfSpecificService;
	@BeanReference(type = ESFSpecificPersistence.class)
	protected ESFSpecificPersistence esfSpecificPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFSportTypeLocalService.class)
	protected it.ethica.esf.service.ESFSportTypeLocalService esfSportTypeLocalService;
	@BeanReference(type = ESFSportTypePersistence.class)
	protected ESFSportTypePersistence esfSportTypePersistence;
	@BeanReference(type = it.ethica.esf.service.ESFStateLocalService.class)
	protected it.ethica.esf.service.ESFStateLocalService esfStateLocalService;
	@BeanReference(type = ESFStatePersistence.class)
	protected ESFStatePersistence esfStatePersistence;
	@BeanReference(type = ESFStateAssEntityPersistence.class)
	protected ESFStateAssEntityPersistence esfStateAssEntityPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFSuspensiveCodeLocalService.class)
	protected it.ethica.esf.service.ESFSuspensiveCodeLocalService esfSuspensiveCodeLocalService;
	@BeanReference(type = ESFSuspensiveCodePersistence.class)
	protected ESFSuspensiveCodePersistence esfSuspensiveCodePersistence;
	@BeanReference(type = it.ethica.esf.service.ESFSuspensiveShootingDirectorLocalService.class)
	protected it.ethica.esf.service.ESFSuspensiveShootingDirectorLocalService esfSuspensiveShootingDirectorLocalService;
	@BeanReference(type = ESFSuspensiveShootingDirectorPersistence.class)
	protected ESFSuspensiveShootingDirectorPersistence esfSuspensiveShootingDirectorPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFTeamLocalService.class)
	protected it.ethica.esf.service.ESFTeamLocalService esfTeamLocalService;
	@BeanReference(type = ESFTeamPersistence.class)
	protected ESFTeamPersistence esfTeamPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFTournamentLocalService.class)
	protected it.ethica.esf.service.ESFTournamentLocalService esfTournamentLocalService;
	@BeanReference(type = ESFTournamentPersistence.class)
	protected ESFTournamentPersistence esfTournamentPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFTransitionLocalService.class)
	protected it.ethica.esf.service.ESFTransitionLocalService esfTransitionLocalService;
	@BeanReference(type = ESFTransitionPersistence.class)
	protected ESFTransitionPersistence esfTransitionPersistence;
	@BeanReference(type = it.ethica.esf.service.ESFUnitserviceLocalService.class)
	protected it.ethica.esf.service.ESFUnitserviceLocalService esfUnitserviceLocalService;
	@BeanReference(type = ESFUnitservicePersistence.class)
	protected ESFUnitservicePersistence esfUnitservicePersistence;
	@BeanReference(type = it.ethica.esf.service.ESFUserLocalService.class)
	protected it.ethica.esf.service.ESFUserLocalService esfUserLocalService;
	@BeanReference(type = it.ethica.esf.service.ESFUserService.class)
	protected it.ethica.esf.service.ESFUserService esfUserService;
	@BeanReference(type = ESFUserPersistence.class)
	protected ESFUserPersistence esfUserPersistence;
	@BeanReference(type = ESFUserFinder.class)
	protected ESFUserFinder esfUserFinder;
	@BeanReference(type = it.ethica.esf.service.ESFUserCategoryLocalService.class)
	protected it.ethica.esf.service.ESFUserCategoryLocalService esfUserCategoryLocalService;
	@BeanReference(type = ESFUserCategoryPersistence.class)
	protected ESFUserCategoryPersistence esfUserCategoryPersistence;
	@BeanReference(type = ESFUserCategoryFinder.class)
	protected ESFUserCategoryFinder esfUserCategoryFinder;
	@BeanReference(type = it.ethica.esf.service.ESFUserESFFederalRoleLocalService.class)
	protected it.ethica.esf.service.ESFUserESFFederalRoleLocalService esfUserESFFederalRoleLocalService;
	@BeanReference(type = ESFUserESFFederalRolePersistence.class)
	protected ESFUserESFFederalRolePersistence esfUserESFFederalRolePersistence;
	@BeanReference(type = it.ethica.esf.service.ESFUserESFUserRoleLocalService.class)
	protected it.ethica.esf.service.ESFUserESFUserRoleLocalService esfUserESFUserRoleLocalService;
	@BeanReference(type = ESFUserESFUserRolePersistence.class)
	protected ESFUserESFUserRolePersistence esfUserESFUserRolePersistence;
	@BeanReference(type = ESFUserESFUserRoleFinder.class)
	protected ESFUserESFUserRoleFinder esfUserESFUserRoleFinder;
	@BeanReference(type = it.ethica.esf.service.ESFUserRoleLocalService.class)
	protected it.ethica.esf.service.ESFUserRoleLocalService esfUserRoleLocalService;
	@BeanReference(type = ESFUserRolePersistence.class)
	protected ESFUserRolePersistence esfUserRolePersistence;
	@BeanReference(type = it.ethica.esf.service.vw_datidirettoretiroLocalService.class)
	protected it.ethica.esf.service.vw_datidirettoretiroLocalService vw_datidirettoretiroLocalService;
	@BeanReference(type = vw_datidirettoretiroPersistence.class)
	protected vw_datidirettoretiroPersistence vw_datidirettoretiroPersistence;
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
	private ESFUserESFUserRoleLocalServiceClpInvoker _clpInvoker = new ESFUserESFUserRoleLocalServiceClpInvoker();
}