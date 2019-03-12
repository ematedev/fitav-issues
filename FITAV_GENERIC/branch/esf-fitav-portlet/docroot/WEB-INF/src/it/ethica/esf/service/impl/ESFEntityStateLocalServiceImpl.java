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

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

import it.ethica.esf.NoSuchEntityStateException;
import it.ethica.esf.model.ESFEntityState;
import it.ethica.esf.service.base.ESFEntityStateLocalServiceBaseImpl;

/**
 * The implementation of the e s f entity state local service. <p> All custom
 * service methods should be put in this class. Whenever methods are added,
 * rerun ServiceBuilder to copy their definitions into the
 * {@link it.ethica.esf.service.ESFEntityStateLocalService} interface. <p> This
 * is a local service. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM. </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFEntityStateLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFEntityStateLocalServiceUtil
 */
public class ESFEntityStateLocalServiceImpl
	extends ESFEntityStateLocalServiceBaseImpl {

	/**
	 * Ricerca l'entit� ESFEntityState sulla base dei sequenti filtri: -
	 * className; - classPK; - WHERE CONDITION ( endDate=null )
	 * @throws SystemException 
	 */
	public List<ESFEntityState> findESFEntityStateByCN(String className) throws SystemException{
		return esfEntityStatePersistence.findByESFEntityStateCN(className);
	}
	public ESFEntityState findESFEntityStateByC_PK(
		String className, long classPK)
		throws SystemException {

		return esfEntityStatePersistence.fetchByESFEntityStateC_PK(
			className, classPK);
	}

	/**
	 * Ricerca l'entit� ESFEntityState sulla base dei sequenti filtri: -
	 * className; - classPK; - esfStateId - WHERE CONDITION ( endDate=null )
	 */
	public ESFEntityState findESFEntityStateByC_PK_S(
		String className, long classPK, long esfStateId)
		throws SystemException {

		return esfEntityStatePersistence.fetchByESFEntityStateC_PK_S(
			className, classPK, esfStateId);
	}
	
	/**
	 * Ricerca le entit� ESFEntityState sulla base dei sequenti filtri: -
	 * className; - esfStateId - WHERE CONDITION ( endDate=null )
	 */
	public List<ESFEntityState> findESFEntityStateByC_S(
		String className, long esfStateId)
		throws SystemException {

		return esfEntityStatePersistence.findByESFEntityStateC_S(
			className, esfStateId);

	}

	/**
	 * Ricerca le entit� ESFEntityState sulla base dei sequenti filtri: -
	 * className; - esfStateId - WHERE CONDITION ( endDate=null )
	 */
	public List<ESFEntityState> findESFEntityStateByC_S(
		String className, long esfStateId, int start, int end)
		throws SystemException {

		return esfEntityStatePersistence.findByESFEntityStateC_S(
			className, esfStateId, start, end);
	}

	public ESFEntityState addEntityState(
		long userId, long groupId, long companyId, String className,
		long classPK, long esfStateId)
		throws NoSuchUserException, SystemException {

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		long esfEntityStateId = counterLocalService.increment();

		ESFEntityState esfEntityState =
			esfEntityStatePersistence.create(esfEntityStateId);
		esfEntityState.setCompanyId(companyId);
		esfEntityState.setGroupId(groupId);
		esfEntityState.setUserId(userId);
		esfEntityState.setUserName(user.getScreenName());
		esfEntityState.setCreateDate(now);
		esfEntityState.setClassName(className);
		esfEntityState.setClassPK(classPK);
		esfEntityState.setEsfStateId(esfStateId);
		esfEntityState.setStartDate(now);
		esfEntityState.setEndDate(null);

		esfEntityStatePersistence.update(esfEntityState);

		return esfEntityState;
	}

	public ESFEntityState addEntityState(
			long userId, String className, long classPK, long esfStateId,	ServiceContext serviceContext)
			throws NoSuchUserException, SystemException {

			return addEntityState(
				 userId,  className,  classPK,  esfStateId, new Date(),null, serviceContext);
		}
	
	
	public ESFEntityState addEntityState(
		long userId, String className, long classPK, long esfStateId,Date startDate,Date endDate,
		ServiceContext serviceContext)
		throws NoSuchUserException, SystemException {

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		long esfEntityStateId = counterLocalService.increment();

		ESFEntityState esfEntityState =
			esfEntityStatePersistence.create(esfEntityStateId);
		esfEntityState.setCompanyId(serviceContext.getCompanyId());
		esfEntityState.setGroupId(serviceContext.getScopeGroupId());
		esfEntityState.setUserId(userId);
		esfEntityState.setUserName(user.getScreenName());
		esfEntityState.setCreateDate(now);
		esfEntityState.setClassName(className);
		esfEntityState.setClassPK(classPK);
		esfEntityState.setEsfStateId(esfStateId);
		esfEntityState.setStartDate(startDate);
		esfEntityState.setEndDate(endDate);

		esfEntityStatePersistence.update(esfEntityState);

		return esfEntityState;
	}

	/**
	 * Effettua l'update di tutti i parametri di ESFEntityState settando la data
	 * endDate = data attuale
	 */
	public ESFEntityState updateEntityState(
		long userId, long esfEntityStateId, ServiceContext serviceContext)
		throws SystemException, PortalException {

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		ESFEntityState esfEntityState = getESFEntityState(esfEntityStateId);

		esfEntityState.setUserId(userId);
		esfEntityState.setUserName(user.getScreenName());
		esfEntityState.setModifiedDate(now);
		esfEntityState.setEndDate(now);

		esfEntityStatePersistence.update(esfEntityState);

		return esfEntityState;
	}
	
	
	/**
	 * Ricerca l'entit� ESFEntityState sulla base dei sequenti filtri: -
	 * className; - classPK; 
	 */
	public ESFEntityState findAllESFEntityStateByClassName_ClassPK(
		String className, long classPK)
		throws SystemException {

		try {
			return esfEntityStatePersistence.findByAllESFEntityStateClassName_ClassPK(className, classPK);
		}
		catch (NoSuchEntityStateException e) {
			e.printStackTrace();
			throw new SystemException(e.getCause());
		}
		
	}
	private static Log _log = LogFactoryUtil.getLog(ESFEntityStateLocalServiceImpl.class);
}
