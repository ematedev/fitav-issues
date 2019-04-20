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

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;

import it.ethica.esf.NoSuchUserCategoryException;
import it.ethica.esf.model.ESFField;
import it.ethica.esf.model.ESFUnitservice;
import it.ethica.esf.model.ESFUser;
import it.ethica.esf.model.ESFUserCategory;
import it.ethica.esf.portlet.ESFQualificationsFederalYouthPortlet;
import it.ethica.esf.service.ESFFieldLocalServiceUtil;
import it.ethica.esf.service.ESFUserCategoryLocalServiceUtil;
import it.ethica.esf.service.base.ESFUserCategoryLocalServiceBaseImpl;
import it.ethica.esf.service.persistence.ESFUserCategoryFinderUtil;
import it.ethica.esf.util.ManageDate;

/**
 * The implementation of the e s f user category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFUserCategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFUserCategoryLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFUserCategoryLocalServiceUtil
 */
public class ESFUserCategoryLocalServiceImpl
	extends ESFUserCategoryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.ESFUserCategoryLocalServiceUtil} to access the e s f user category local service.
	 */
	
	public List<ESFUserCategory> allESFUserCategoryByActualYear(int year) throws SystemException{
		
			List<ESFUserCategory> results = new ArrayList<ESFUserCategory>();
			List<ESFUserCategory> eUC = new ArrayList<ESFUserCategory>();
			eUC = esfUserCategoryPersistence.findAll();
			Calendar cal = Calendar.getInstance();
			int anno = 0;
			
			for(ESFUserCategory esfUC: eUC){
				if (Validator.isNull(esfUC.getStartDate())) {
					continue;
				}
				cal.setTime(esfUC.getStartDate());
				anno = cal.get(Calendar.YEAR);

				if(anno == year){
					results.add(esfUC);
				}
			}

			return results;
	}
	
	public List<ESFUserCategory> allESFUserCategoryByIdUtente(long idUtente) throws SystemException{
		List<ESFUserCategory> results = new ArrayList<ESFUserCategory>();
		List<ESFUserCategory> eUC = new ArrayList<ESFUserCategory>();
		eUC = esfUserCategoryPersistence.findAll();
		for(ESFUserCategory esfUC: eUC)
		{
			if(esfUC.getEsfUserId() == idUtente)
			{
				results.add(esfUC);
			}
		}
		return results;
	}
	
	public List<ESFUserCategory> findUserFO( long esfSportTypeId)
			throws SystemException, PortalException, ParseException {
			
		List<ESFUserCategory> userFO = new ArrayList<ESFUserCategory>();
		List<ESFUserCategory> userFOTOT = new ArrayList<ESFUserCategory>();
		
		DynamicQuery userCategoryQuery =
				DynamicQueryFactoryUtil.forClass(
						ESFUserCategory.class, "userCategoryQuery",
					PortletClassLoaderUtil.getClassLoader());
		
		userCategoryQuery.add(PropertyFactoryUtil.forName("userCategoryQuery.esfSportTypeId").eq(
				esfSportTypeId));
		userCategoryQuery.add(PropertyFactoryUtil.forName("userCategoryQuery.esfCategoryId").eq(
				new Long(1)));
		
		userFOTOT = ESFUserCategoryLocalServiceUtil.dynamicQuery(userCategoryQuery);
		
		for(ESFUserCategory u : userFOTOT){
			if(u.getEndDate().equals(null)){
				userFO.add(u);
			}
		}
		
		return userFO;
	}
	
	public List<ESFUserCategory> findUserByS_ED( long esfSportTypeId, int year)
			throws SystemException, PortalException, ParseException {
		
		List<ESFUserCategory> esfUserCategory =  new ArrayList<ESFUserCategory>();
		List<ESFUserCategory> esfUserCategoryOld = new ArrayList<ESFUserCategory>();
		int yearInt ; 
		
		DynamicQuery userCategoryQuery =
				DynamicQueryFactoryUtil.forClass(
						ESFUserCategory.class, "userCategoryQuery",
					PortletClassLoaderUtil.getClassLoader());

		userCategoryQuery.add(PropertyFactoryUtil.forName("userCategoryQuery.esfSportTypeId").eq(
				esfSportTypeId));

		
		esfUserCategory = ESFUserCategoryLocalServiceUtil.dynamicQuery(userCategoryQuery);
		for(ESFUserCategory u : esfUserCategory){
			yearInt = ManageDate.getYear(u.getStartDate());
			if(((yearInt-1) == year)&& Validator.isNull(u.getEndDate())){
				esfUserCategoryOld.add(u);
			}
		}
		
		return esfUserCategoryOld;
	}
	
	public ESFUserCategory fetchUserByS_ED_UI(long userId,  long esfSportTypeId,ServiceContext serviceContext)
			throws SystemException, PortalException, ParseException {
		
		List<ESFUserCategory> esfUserCategory =  new ArrayList<ESFUserCategory>();
		ESFUserCategory esfUserCategoryOld = null;
		DynamicQuery userCategoryQuery =
				DynamicQueryFactoryUtil.forClass(
						ESFUserCategory.class, "userCategoryQuery",
					PortletClassLoaderUtil.getClassLoader());

		userCategoryQuery.add(PropertyFactoryUtil.forName("userCategoryQuery.esfUserId").eq(
				userId));
		userCategoryQuery.add(PropertyFactoryUtil.forName("userCategoryQuery.esfSportTypeId").eq(
				esfSportTypeId));

		
		esfUserCategory = ESFUserCategoryLocalServiceUtil.dynamicQuery(userCategoryQuery);
		for(ESFUserCategory u : esfUserCategory){
			if(Validator.isNull(u.getEndDate())){
				esfUserCategoryOld = u;
			}
		}
		
		return esfUserCategoryOld;
	}
	
	@Override
	public ESFUserCategory addEsfUserCategory(
			long userId, long esfUserId, long esfCategoryId, long esfSportTypeId,
			ServiceContext serviceContext)
		throws NoSuchUserException, SystemException {

		Date now = new Date();
		User user = userPersistence.findByPrimaryKey(userId);
		long groupId = serviceContext.getScopeGroupId();
		
		long esfUserCategoryId = counterLocalService.increment();

		ESFUserCategory esfUserCategory = esfUserCategoryPersistence.create(esfUserCategoryId);
		esfUserCategory.setGroupId(groupId);
		esfUserCategory.setUserId(user.getUserId());
		esfUserCategory.setCompanyId(user.getCompanyId());
		esfUserCategory.setCreateDate(serviceContext.getCreateDate(now));
		esfUserCategory.setModifiedDate(serviceContext.getModifiedDate(now));
		esfUserCategory.setEsfUserId(esfUserId);
		esfUserCategory.setEsfCategoryId(esfCategoryId);
		esfUserCategory.setEsfSportTypeId(esfSportTypeId);
		esfUserCategory.setStartDate(now);

		esfUserCategoryPersistence.update(esfUserCategory);

		return esfUserCategory;
	}

	@Override
	public ESFUserCategory updateEsfUserCategory(
			long userId, long esfUserCategoryId, long esfUserId,
			long esfCategoryId, long esfSportTypeId,
			ServiceContext serviceContext)
		throws NoSuchUserException, SystemException, NoSuchUserCategoryException {

		Date now = new Date();
		User user = userPersistence.findByPrimaryKey(userId);
		long groupId = serviceContext.getScopeGroupId();
		
		ESFUserCategory esfUserCategory = esfUserCategoryPersistence.findByPrimaryKey(esfUserCategoryId);
		esfUserCategory.setGroupId(groupId);
		esfUserCategory.setUserId(user.getUserId());
		esfUserCategory.setCompanyId(user.getCompanyId());
		esfUserCategory.setCreateDate(serviceContext.getCreateDate(now));
		esfUserCategory.setModifiedDate(serviceContext.getModifiedDate(now));
		esfUserCategory.setEsfUserId(esfUserId);
		esfUserCategory.setEsfCategoryId(esfCategoryId);
		esfUserCategory.setEsfSportTypeId(esfSportTypeId);

		esfUserCategoryPersistence.update(esfUserCategory);

		return esfUserCategory;
	}

	public ESFUserCategory addEsfUserCategory(long userId, long nextCategory, long esfSportTypeId,
			int year, User user, long groupId, long companyId,	ServiceContext serviceContext)
			throws SystemException, PortalException, ParseException {

		Date now = new Date();
		String startDateString="01/01/"+year;
		
		Date startDate = ManageDate.StringToDate(startDateString);
		long esfUserCategoryId = counterLocalService.increment();
		
		ESFUserCategory esfUserCategoryold = ESFUserCategoryLocalServiceUtil.
											fetchUserByS_ED_UI(userId, esfSportTypeId, serviceContext);

		if(Validator.isNotNull(esfUserCategoryold)){
			String endDateString="31/12/"+(year-1);
			Date endDate = ManageDate.StringToDate(endDateString);
			esfUserCategoryold.setEndDate(endDate);
			ESFUserCategoryLocalServiceUtil.updateESFUserCategory(esfUserCategoryold);
		}
		
		ESFUserCategory esfUserCategory = esfUserCategoryPersistence.create(esfUserCategoryId);
		esfUserCategory.setGroupId(groupId);
		esfUserCategory.setUserId(user.getUserId());
		esfUserCategory.setCompanyId(companyId);
		esfUserCategory.setCreateDate(now);
		esfUserCategory.setModifiedDate(now);
		esfUserCategory.setEsfUserId(userId);
		esfUserCategory.setEsfCategoryId(nextCategory);
		esfUserCategory.setEsfSportTypeId(esfSportTypeId);
		esfUserCategory.setStartDate(startDate);
		
	
		esfUserCategoryPersistence.update(esfUserCategory);
	
		return esfUserCategory;
	}
	
	public ESFUserCategory findByU_C_S(
		long esfUserId, long esfCategoryId, long esfSportTypeId)
		throws NoSuchUserCategoryException, SystemException {

		return esfUserCategoryPersistence.findByU_C_S(
			esfUserId, esfCategoryId, esfSportTypeId);
	}
	
	public List<ESFUserCategory> findYouthNotPromoved(int year){
		List<ESFUserCategory> esfUsersCategory = ESFUserCategoryFinderUtil.findYouthNotPromoved(year);
		
		return esfUsersCategory;
	}
	private static Log _log = LogFactoryUtil.getLog(ESFUserCategoryLocalServiceImpl.class);
}