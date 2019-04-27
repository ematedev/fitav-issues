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

package it.ethica.esf.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import it.ethica.esf.model.ESFFlight;
import it.ethica.esf.service.base.ESFFlightLocalServiceBaseImpl;

/**
 * The implementation of the e s f flight local service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link it.ethica.esf.service.ESFFlightLocalService} interface. <p> This is a
 * local service. Methods of this service will not have security checks based on
 * the propagated JAAS credentials because this service can only be accessed
 * from within the same VM. </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFFlightLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFFlightLocalServiceUtil
 */
public class ESFFlightLocalServiceImpl extends ESFFlightLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link it.ethica.esf.service.ESFFlightLocalServiceUtil} to access the e s
	 * f flight local service.
	 */

	public ESFFlight addEsfFlight(
		long groupId, long companyId, String userName, long userId,
		long esfUserId, String flightCode, Date leaveDate, Date arriveDate,
		Date createDate, String leaveHour, String arriveHour,
		String companyName, String departureAirport, String arrivalAirport,
		long esfMatchId)
		throws SystemException {

		long esfFlightId = counterLocalService.increment();

		ESFFlight esfFlight =
			esfFlightLocalService.createESFFlight(esfFlightId);

		esfFlight.setGroupId(groupId);
		esfFlight.setCompanyId(companyId);
		esfFlight.setUserName(userName);
		esfFlight.setUserId(userId);
		esfFlight.setEsfUserId(esfUserId);
		esfFlight.setCreateDate(createDate);
		esfFlight.setFlightCode(flightCode);
		esfFlight.setLeaveDate(leaveDate);
		esfFlight.setLeaveHour(leaveHour);
		esfFlight.setArriveDate(arriveDate);
		esfFlight.setArriveHour(arriveHour);;
		esfFlight.setCompanyName(companyName);
		esfFlight.setDepartureAirport(departureAirport);
		esfFlight.setArrivalAirport(arrivalAirport);
		esfFlight.setEsfMatchId(esfMatchId);

		esfFlightLocalService.updateESFFlight(esfFlight);

		return esfFlight;
	}

	public ESFFlight updateEsfFlight(
		long esfFlightId, long groupId, long companyId, String userName,
		long esfUserId, long userId, String flightCode, Date modifiedDate,
		Date leaveDate, String leaveHour, Date arriveDate, String arriveHour,
		String companyName, String departureAirport, String arrivalAirport,
		long esfMatchId)
		throws SystemException {

		ESFFlight esfFlight = esfFlightLocalService.fetchESFFlight(esfFlightId);

		esfFlight.setGroupId(groupId);
		esfFlight.setCompanyId(companyId);
		esfFlight.setUserName(userName);
		esfFlight.setModifiedDate(modifiedDate);
		esfFlight.setEsfUserId(esfUserId);
		esfFlight.setUserId(userId);
		esfFlight.setFlightCode(flightCode);
		esfFlight.setLeaveDate(leaveDate);
		esfFlight.setLeaveHour(leaveHour);
		esfFlight.setArriveDate(arriveDate);
		esfFlight.setArriveHour(arriveHour);
		esfFlight.setCompanyName(companyName);
		esfFlight.setDepartureAirport(departureAirport);
		esfFlight.setArrivalAirport(arrivalAirport);

		esfFlightLocalService.updateESFFlight(esfFlight);

		return esfFlight;
	}

	public List<ESFFlight> findFlightsByESFMatchId(long esfMatchId)
		throws SystemException {

		return esfFlightPersistence.findByesfMatch(esfMatchId);
	}

	public List<ESFFlight> findFlightsByFlightCode(String flightCode)
		throws SystemException {

		return esfFlightPersistence.findByflightCode(flightCode);
	}
	
	public List<ESFFlight> getByEsfMatchIdEsfUserId(long esfMatchId, long esfUserId)
		throws SystemException {

		return esfFlightPersistence.findByesfMatchEsfUser(esfMatchId, esfUserId);
	}

	public List<ESFFlight> getESFFlightsByEsfMatchId_F_L_L_C_D(
		long esfMatchId, String flightCode, Date leaveDate, String leaveHour,
		String companyName, String departureAirport) throws SystemException {

		return esfFlightPersistence.findByesfMatchId_F_L_L_C_D(
			esfMatchId, flightCode, leaveDate, leaveHour, companyName,
			departureAirport);
	}
}
