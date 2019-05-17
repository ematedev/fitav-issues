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

package it.ethica.esf.renewal.service.impl;

import it.ethica.esf.renewal.NoSuchESFRenewalCompanyException;
import it.ethica.esf.renewal.model.ESFRenewalCompany;
import it.ethica.esf.renewal.service.base.ESFRenewalCompanyLocalServiceBaseImpl;
import it.ethica.esf.renewal.service.persistence.ESFRenewalCompanyFinderUtil;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

/**
 * The implementation of the e s f renewal company local service. <p> All custom
 * service methods should be put in this class. Whenever methods are added,
 * rerun ServiceBuilder to copy their definitions into the
 * {@link it.ethica.esf.renewal.service.ESFRenewalCompanyLocalService}
 * interface. <p> This is a local service. Methods of this service will not have
 * security checks based on the propagated JAAS credentials because this service
 * can only be accessed from within the same VM. </p>
 *
 * @author Ethica
 * @see it.ethica.esf.renewal.service.base.ESFRenewalCompanyLocalServiceBaseImpl
 * @see it.ethica.esf.renewal.service.ESFRenewalCompanyLocalServiceUtil
 */
public class ESFRenewalCompanyLocalServiceImpl
	extends ESFRenewalCompanyLocalServiceBaseImpl {

	@Override
	public ESFRenewalCompany addESFRenewalCompany(
		long userId, long esfOrganizationId, int cardsNumber, int year,
		Date date, int paymentType, int status, double amount, String info,
		String accountholder, Date paymentDate, double integrationAmount,
		Date integrationDate, int integrationType,
		String integrationAccountholder, boolean join)
		throws SystemException {

		long esfRenewalCompanyId = counterLocalService.increment();

		ESFRenewalCompany esfRenewalCompany =
			esfRenewalCompanyPersistence.create(esfRenewalCompanyId);

		esfRenewalCompany.setUserId(userId);
		esfRenewalCompany.setEsfOrganizationId(esfOrganizationId);
		esfRenewalCompany.setCardsNumber(cardsNumber);
		esfRenewalCompany.setYear(year);
		esfRenewalCompany.setDate(date);
		esfRenewalCompany.setPaymentType(paymentType);
		esfRenewalCompany.setStatus(status);
		esfRenewalCompany.setAmount(amount);
		esfRenewalCompany.setInfo(info);
		esfRenewalCompany.setAccountholder(accountholder);
		esfRenewalCompany.setPaymentDate(paymentDate);
		esfRenewalCompany.setIntegrationAmount(integrationAmount);
		esfRenewalCompany.setIntegrationDate(integrationDate);
		esfRenewalCompany.setIntegrationType(integrationType);
		esfRenewalCompany.setIntegrationAccountholder(integrationAccountholder);
		esfRenewalCompany.setJoin(join);

		esfRenewalCompanyPersistence.update(esfRenewalCompany);

		return esfRenewalCompany;
	}

	@Override
	public List<Integer> getAllYears()
		throws SystemException {

		DynamicQuery dynamicQuery =
			DynamicQueryFactoryUtil.forClass(
				ESFRenewalCompany.class,
				ESFRenewalCompany.class.getClassLoader());
		Projection projection =
			ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("year"));
		dynamicQuery.setProjection(projection);
		List<Integer> yearsList =
			(List<Integer>) esfRenewalCompanyLocalService.dynamicQuery(dynamicQuery);
		return yearsList;
	}

	@Override
	public ESFRenewalCompany deleteESFRenewalCompany(int esfRenewalCompanyId)
		throws SystemException {

		return esfRenewalCompanyLocalService.deleteESFRenewalCompany(esfRenewalCompanyId);
	}

	@Override
	public List<ESFRenewalCompany> getESFRenewalCompanyByStatus(int status)
		throws SystemException {

		return esfRenewalCompanyPersistence.findByStatus(status);
	}

	@Override
	public List<ESFRenewalCompany> getESFRenewalCompanyByPaymentType(
		int paymentType)
		throws SystemException {

		return esfRenewalCompanyPersistence.findByPaymentType(paymentType);
	}

	@Override
	public List<ESFRenewalCompany> getESFRenewalCompanyByYear(int year)
		throws SystemException {

		return esfRenewalCompanyPersistence.findByYear(year);
	}

	@Override
	public List<ESFRenewalCompany> getESFRenewalCompanyByP_S(
		int paymentType, int status)
		throws SystemException {

		return esfRenewalCompanyPersistence.findByP_S(paymentType, status);
	}

	@Override
	public List<ESFRenewalCompany> getESFRenewalCompanyByP_Y(
		int paymentType, int year)
		throws SystemException {

		return esfRenewalCompanyPersistence.findByP_Y(paymentType, year);
	}

	@Override
	public List<ESFRenewalCompany> getESFRenewalCompanyByS_Y(
		int status, int year)
		throws SystemException {

		return esfRenewalCompanyPersistence.findByS_Y(status, year);
	}

	@Override
	public ESFRenewalCompany getESFRenewalCompanyByE_Y(
		long esfOrganizationId, int year)
		throws SystemException, NoSuchESFRenewalCompanyException {

		return esfRenewalCompanyPersistence.findByE_Y(esfOrganizationId, year);
	}

	@Override
	public List<ESFRenewalCompany> getESFRenewalCompanyByN_C_R_Y(
		String name, String code, String region, int year, int start, int end) {

		return ESFRenewalCompanyFinderUtil.getESFRenewalCompanyByN_C_R_Y(
			name, code, region, year, start, end);
	}

	@Override
	public ESFRenewalCompany updateESFRenewalCompany(
		long esfRenewalCompanyId, long userId, long esfOrganizationId,
		int cardsNumber, int year, Date date, int paymentType, int status,
		double amount, String info, String accountholder, Date paymentDate,
		double integrationAmount, Date integrationDate, int integrationType,
		String integrationAccountholder, boolean join)
		throws PortalException, SystemException {

		ESFRenewalCompany esfRenewalCompany =
			esfRenewalCompanyLocalService.getESFRenewalCompany(esfRenewalCompanyId);

		esfRenewalCompany.setUserId(userId);
		esfRenewalCompany.setEsfOrganizationId(esfOrganizationId);
		esfRenewalCompany.setCardsNumber(cardsNumber);
		esfRenewalCompany.setYear(year);
		esfRenewalCompany.setDate(date);
		esfRenewalCompany.setPaymentType(paymentType);
		esfRenewalCompany.setStatus(status);
		esfRenewalCompany.setAmount(amount);
		esfRenewalCompany.setInfo(info);
		esfRenewalCompany.setAccountholder(accountholder);
		esfRenewalCompany.setPaymentDate(paymentDate);
		esfRenewalCompany.setIntegrationAmount(integrationAmount);
		esfRenewalCompany.setIntegrationDate(integrationDate);
		esfRenewalCompany.setIntegrationType(integrationType);
		esfRenewalCompany.setIntegrationAccountholder(integrationAccountholder);
		esfRenewalCompany.setJoin(join);

		return esfRenewalCompanyPersistence.update(esfRenewalCompany);
	}
}
