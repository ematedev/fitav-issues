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

import it.ethica.esf.model.ESFDeparture;
import it.ethica.esf.service.base.ESFDepartureLocalServiceBaseImpl;

/**
 * The implementation of the e s f departure local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFDepartureLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFDepartureLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFDepartureLocalServiceUtil
 */
public class ESFDepartureLocalServiceImpl
	extends ESFDepartureLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.ESFDepartureLocalServiceUtil} to access the e s f departure local service.
	 */
	
	public ESFDeparture addEsfDeparture(
		long groupId, long companyId, String userName, long userId,
		long esfUserId, String code, Date leaveDate, Date arriveDate,
		Date createDate, String leaveHour, String arriveHour,
		String companyName, String departureFrom, String arrivalTo,
		long esfMatchId, boolean returned,String meetingPlace, String typeTravel, String stopover)
		throws SystemException {

		long esfDepartureId = counterLocalService.increment();

		ESFDeparture esfDeparture =
			esfDepartureLocalService.createESFDeparture(esfDepartureId);

		esfDeparture.setGroupId(groupId);
		esfDeparture.setCompanyId(companyId);
		esfDeparture.setUserName(userName);
		esfDeparture.setUserId(userId);
		esfDeparture.setEsfUserId(esfUserId);
		esfDeparture.setCreateDate(createDate);
		esfDeparture.setCode(code);
		esfDeparture.setLeaveDate(leaveDate);
		esfDeparture.setLeaveHour(leaveHour);
		esfDeparture.setArriveDate(arriveDate);
		esfDeparture.setArriveHour(arriveHour);;
		esfDeparture.setCompanyName(companyName);
		esfDeparture.setDepartureFrom(departureFrom);
		esfDeparture.setArrivalTo(arrivalTo);
		esfDeparture.setEsfMatchId(esfMatchId);
		esfDeparture.setIsReturn(returned);
		esfDeparture.setMeetingPlace(meetingPlace);
		esfDeparture.setTypeTravel(typeTravel);
		esfDeparture.setStopoverId(stopover);
		esfDepartureLocalService.updateESFDeparture(esfDeparture);

		return esfDeparture;
	}

	public ESFDeparture updateEsfDeparture(
		long esfDepartureId, long groupId, long companyId, String userName,
		long esfUserId, long userId, String code, Date modifiedDate,
		Date leaveDate, String leaveHour, Date arriveDate, String arriveHour,
		String companyName, String departureFrom, String arrivalTo,
		long esfMatchId, boolean returned,String meetingPlace, String typeTravel, String stopover)
		throws SystemException {

		ESFDeparture esfDeparture = esfDepartureLocalService.fetchESFDeparture(esfDepartureId);

		esfDeparture.setGroupId(groupId);
		esfDeparture.setCompanyId(companyId);
		esfDeparture.setUserName(userName);
		esfDeparture.setModifiedDate(modifiedDate);
		esfDeparture.setEsfUserId(esfUserId);
		esfDeparture.setUserId(userId);
		esfDeparture.setCode(code);
		esfDeparture.setLeaveDate(leaveDate);
		esfDeparture.setLeaveHour(leaveHour);
		esfDeparture.setArriveDate(arriveDate);
		esfDeparture.setArriveHour(arriveHour);
		esfDeparture.setCompanyName(companyName);
		esfDeparture.setDepartureFrom(departureFrom);
		esfDeparture.setArrivalTo(arrivalTo);
		esfDeparture.setIsReturn(returned);
		esfDeparture.setMeetingPlace(meetingPlace);
		esfDeparture.setTypeTravel(typeTravel);
		esfDeparture.setStopoverId(stopover);
		esfDepartureLocalService.updateESFDeparture(esfDeparture);

		return esfDeparture;
	}

	public List<ESFDeparture> findESFDeparturesByESFMatchId(long esfMatchId)
		throws SystemException {

		return esfDeparturePersistence.findByesfMatch(esfMatchId);
	}
	
	public List<ESFDeparture> findESFDeparturesByESFMatchId(long esfMatchId, int start, int end)
					throws SystemException {

					return esfDeparturePersistence.findByesfMatch(esfMatchId, start, end);
	}

	
	public List<ESFDeparture> findDeparturesByCode(String code)
		throws SystemException {

		return esfDeparturePersistence.findBycode(code);
	}
	

	public List<ESFDeparture> findDeparturesByCode(String code, int start, int end)
		throws SystemException {

		return esfDeparturePersistence.findBycode(code, start, end);
	}
	
	public List<ESFDeparture> getByEsfMatchIdEsfUserId(long esfMatchId, long esfUserId) 
		throws SystemException {

		return esfDeparturePersistence.findByesfMatchEsfUser(esfMatchId, esfUserId);
}
	
	public List<ESFDeparture> getByEsfMatchIdEsfUserId(long esfMatchId, long esfUserId,
														int start, int end)
		throws SystemException {

		return esfDeparturePersistence.findByesfMatchEsfUser(esfMatchId, esfUserId, start, end);
	}

	public List<ESFDeparture> getESFDeparturesByEsfMatchId_F_L_L_C_D(
		long esfMatchId, String code, Date leaveDate, String leaveHour,
		String companyName, String departureFrom) throws SystemException {

		return esfDeparturePersistence.findByesfMatchId_C_L_L_C_D(esfMatchId, code,
							leaveDate, leaveHour, companyName, departureFrom);
	}
	
	public List<ESFDeparture> getESFDeparturesByEsfMatchId_F_L_L_C_D(
		long esfMatchId, String code, Date leaveDate, String leaveHour,
		String companyName, String departureFrom , int start, int end) throws SystemException {

		return esfDeparturePersistence.findByesfMatchId_C_L_L_C_D(esfMatchId, code,
							leaveDate, leaveHour, companyName, departureFrom, start, end);
	}
}