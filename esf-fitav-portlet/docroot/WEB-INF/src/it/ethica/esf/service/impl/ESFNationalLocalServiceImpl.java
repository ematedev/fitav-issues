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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

import it.ethica.esf.model.ESFNational;
import it.ethica.esf.service.ESFNationalDelegationLocalServiceUtil;
import it.ethica.esf.service.ESFNationalLocalServiceUtil;
import it.ethica.esf.service.base.ESFNationalLocalServiceBaseImpl;
import it.ethica.esf.service.persistence.ESFNationalFinderUtil;
import it.ethica.esf.util.ESFKeys;

/**
 * The implementation of the e s f national local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFNationalLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFNationalLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFNationalLocalServiceUtil
 */
public class ESFNationalLocalServiceImpl
		extends ESFNationalLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.ESFNationalLocalServiceUtil} to access the e s f national local service.
	 */

	public List<ESFNational> getActiveESFNationals(long esfSportTypeId,
			int start, int end) throws SystemException {

		Calendar now = CalendarFactoryUtil.getCalendar();

		return esfNationalPersistence.findByE_E(now.getTime(), esfSportTypeId,
				start, end);
	}

	public List<ESFNational> getActiveESFNationals(
			int start, int end) throws SystemException {

		Calendar now = CalendarFactoryUtil.getCalendar();

		return esfNationalPersistence.findByEndDate(now.getTime(), start, end);
	}

	public int countActiveESFNationals(long esfSportTypeId, int start, int end)
			throws SystemException {

		Calendar now = CalendarFactoryUtil.getCalendar();

		return esfNationalPersistence.countByE_E(now.getTime(), esfSportTypeId);
	}

	public int countActiveESFNationals()
			throws SystemException {

		Calendar now = CalendarFactoryUtil.getCalendar();

		return esfNationalPersistence.countByEndDate(now.getTime());
	}

	public ESFNational getActiveESFNational(long esfUserId)
			throws SystemException {

		Calendar now = CalendarFactoryUtil.getCalendar();

		List<ESFNational> activeForESFUser = esfNationalPersistence
				.findByU_E(now.getTime(), esfUserId);

		if (activeForESFUser.size() == 1) {

			return activeForESFUser.get(0);
		}
		else {

			return null;
		}
	}
//ritorna i National validi per questo user
	public List<ESFNational> getActiveESFNational_UserId(long esfUserId)
			throws SystemException {
		Calendar now = CalendarFactoryUtil.getCalendar();
		List<ESFNational> activeForESFUser = esfNationalPersistence
				.findByU_E(now.getTime(), esfUserId);
		return activeForESFUser;
	}
	
	public boolean isActiveESFNationals(long esfUserId) throws SystemException {

		Calendar now = CalendarFactoryUtil.getCalendar();

		List<ESFNational> activeForESFUser = esfNationalPersistence
				.findByU_E(now.getTime(), esfUserId);

		if (activeForESFUser.size() == 0) {

			return false;
		}
		else {
			return true;
		}
	}

	public ESFNational addESFNational(long userId, long esfUserId,
			long esfSportTypeId, Date startDate, Date endDate, Date bdoDate,
			ServiceContext serviceContext)
					throws SystemException, PortalException {

		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		long esfNationalId = counterLocalService.increment();

		ESFNational esfNational = esfNationalPersistence.create(esfNationalId);

		esfNational.setUserId(userId);
		esfNational.setGroupId(groupId);
		esfNational.setCompanyId(user.getCompanyId());
		esfNational.setUserName(user.getFullName());
		esfNational.setCreateDate(serviceContext.getCreateDate(now));
		esfNational.setModifiedDate(serviceContext.getModifiedDate(now));

		esfNational.setEsfUserId(esfUserId);
		esfNational.setEsfSportTypeId(esfSportTypeId);
		esfNational.setStartDate(startDate);
		esfNational.setEndDate(endDate);
		esfNational.setBDODate(bdoDate);

		esfNationalPersistence.update(esfNational);

		return esfNational;
	}

	public ESFNational deleteESFNational(long userId, long esfNationalId,
			Date endDate, ServiceContext serviceContext)
					throws SystemException, PortalException {

		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		ESFNational esfNational = esfNationalPersistence
				.findByPrimaryKey(esfNationalId);

		esfNational.setUserId(userId);
		esfNational.setGroupId(groupId);
		esfNational.setCompanyId(user.getCompanyId());
		esfNational.setUserName(user.getFullName());
		esfNational.setCreateDate(serviceContext.getCreateDate(now));
		esfNational.setModifiedDate(serviceContext.getModifiedDate(now));

		esfNational.setEndDate(endDate);

		esfNationalPersistence.update(esfNational);

		return esfNational;
	}
	
	public List<ESFNational> getEXESFNationalUser(long esfSportTypeId) throws SystemException
	{
		Calendar cal = Calendar.getInstance();
		Calendar start = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		int actualYear = cal.get(Calendar.YEAR);
		actualYear--;
		start.set(actualYear, 01, 01);
		end.set(actualYear,12,31);
		Date startD = start.getTime();
		Date endD = end.getTime();
		return esfNationalPersistence.findBybyStartDateEndDateTypeSportId(startD, endD,esfSportTypeId);
	}
	
	public List<ESFNational> findNationalbySportId_MatchId(long esfSportTypeId, long matchId, int start, int end) throws SystemException{
		
		List<ESFNational> nationals = new ArrayList<ESFNational>();
		List<ESFNational> activeNationals = new ArrayList<ESFNational>();
		List<it.ethica.esf.model.ESFNationalDelegation> delegation = new ArrayList<it.ethica.esf.model.ESFNationalDelegation>();
		List<Long> idDelegation = new ArrayList<Long>();
		
		activeNationals = ESFNationalLocalServiceUtil.getActiveESFNationals(esfSportTypeId, 0, Integer.MAX_VALUE);
		
		
		delegation = ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationByMatchId_PartecipantTypeId_sportTypeId(matchId,
				ESFKeys.ESFNationalDelegationType.SHOOTER, esfSportTypeId);
		
		for(it.ethica.esf.model.ESFNationalDelegation d : delegation){
			idDelegation.add(d.getEsfUserId());
		}
		
		for(ESFNational aN : activeNationals){
			
			if( !idDelegation.contains( aN.getEsfUserId())){
				nationals.add(aN);
			}
		}
		
		if(end>nationals.size()){
			end = nationals.size();
		}
		
		nationals = nationals.subList(start, end);
		
		return nationals;
	}
	
	public int countNationalbySportId_MatchId(long esfSportTypeId, long matchId) throws SystemException{
		
		int tot = 0;
		List<ESFNational> nationals = new ArrayList<ESFNational>();
		List<ESFNational> activeNationals = new ArrayList<ESFNational>();
		List<it.ethica.esf.model.ESFNationalDelegation> delegation = new ArrayList<it.ethica.esf.model.ESFNationalDelegation>();
		List<Long> idDelegation = new ArrayList<Long>();
		
		activeNationals = ESFNationalLocalServiceUtil.getActiveESFNationals(esfSportTypeId, 0, Integer.MAX_VALUE);
		
		delegation = ESFNationalDelegationLocalServiceUtil.getESFNationalDelegationByMatchId_PartecipantTypeId(matchId,
				ESFKeys.ESFNationalDelegationType.SHOOTER);
		
		for(it.ethica.esf.model.ESFNationalDelegation d : delegation){
			idDelegation.add(d.getEsfUserId());
		}
		
		for(ESFNational aN : activeNationals){
			if( !idDelegation.contains( aN.getEsfUserId())){
				nationals.add(aN);
			}
		}
		
		tot = nationals.size();

		
		return tot;
	}
	
	/*
	 * restituisce i nazionali che ancora non partecipano alla gara per una deteminata specialità
	 */
	
	public List<ESFNational> findNationalFreeMatchIdSportId(long matchId, long sportTypeId, int begin, int end){
		
		List<ESFNational> freenational = new ArrayList<ESFNational>();
		
		freenational = ESFNationalFinderUtil.findFreeNationalByMatchIdSportTypeId(matchId, sportTypeId, begin, end);
		
		
		return freenational;
	}
	
	private Log _log = LogFactoryUtil.getLog(ESFNationalLocalServiceImpl.class);

}