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
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

import it.ethica.esf.ESFStateDescriptionException;
import it.ethica.esf.ESFStateNameException;
import it.ethica.esf.NoSuchStateException;
import it.ethica.esf.model.ESFEntityState;
import it.ethica.esf.model.ESFState;
import it.ethica.esf.service.base.ESFStateLocalServiceBaseImpl;
import it.ethica.esf.service.persistence.ESFEntityStatePK;

/**
 * The implementation of the e s f state local service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link it.ethica.esf.service.ESFStateLocalService} interface. <p> This is a
 * local service. Methods of this service will not have security checks based on
 * the propagated JAAS credentials because this service can only be accessed
 * from within the same VM. </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFStateLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFStateLocalServiceUtil
 */
public class ESFStateLocalServiceImpl extends ESFStateLocalServiceBaseImpl {

	public List<ESFState> findByStates(String className, long classPK) throws SystemException, NoSuchStateException {

		List<ESFEntityState> esfEntityStates =
			esfEntityStatePersistence.findByfindByC_C(classPK, className);

		List<ESFState> esfStates = new ArrayList<ESFState>();

		for (ESFEntityState esfEntityState : esfEntityStates) {
			ESFState esfState =
				esfStatePersistence.findByPrimaryKey(esfEntityState.getStateId());

			esfStates.add(esfState);
		}
		return esfStates;
	}

	public List<ESFState> findByStates(
		String className, long classPK, int start, int end)
		throws SystemException, NoSuchStateException {

		List<ESFEntityState> esfEntityStates =
			esfEntityStatePersistence.findByfindByC_C(
				classPK, className, start, end);

		List<ESFState> esfStates = new ArrayList<ESFState>();

		for (ESFEntityState esfEntityState : esfEntityStates) {
			ESFState esfState =
				esfStatePersistence.findByPrimaryKey(esfEntityState.getStateId());

			esfStates.add(esfState);
		}
		return esfStates;
	}

	public ESFState addESFState(
		long userId, String esfName, String esfDescription,
		ServiceContext serviceContext)
		throws PortalException, SystemException {

		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date date = new Date();

//		validate(esfName, esfDescription);

		long esfStateId = counterLocalService.increment();
		
		ESFState esfState = esfStatePersistence.create(esfStateId);

		esfState.setUuid(serviceContext.getUuid());
		esfState.setUserId(userId);
		esfState.setGroupId(groupId);
		esfState.setCompanyId(user.getCompanyId());
		esfState.setUserName(user.getFirstName());
		esfState.setCreateDate(serviceContext.getCreateDate(date));
		esfState.setModifiedDate(serviceContext.getModifiedDate(date));
		esfState.setEsfName(esfName);
		esfState.setEsfDescription(esfDescription);

		esfState = esfStatePersistence.update(esfState);

		return esfState;
	}

	public ESFState updateESFState(
		long userId, long esfStateId, String esfName, String esfDescription,
		ServiceContext serviceContext)
		throws PortalException, SystemException {

		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date date = new Date();

//		validate(esfName, esfDescription);

		ESFState esfState = getESFState(esfStateId);

		esfState.setUserId(userId);
		esfState.setUserName(user.getFirstName());
		esfState.setModifiedDate(serviceContext.getModifiedDate(date));
		esfState.setEsfName(esfName);
		esfState.setEsfDescription(esfDescription);

		esfState = esfStatePersistence.update(esfState);

		return esfState;
	}

	public ESFState deleteESFState(
		long esfStateId, ServiceContext serviceContext)
		throws PortalException, SystemException {

		ESFState esfState = deleteESFState(esfStateId);

		return esfState;
	}

	public ESFEntityState addESFEntityState(
		long userId, long classPK, long esfStateId, String className,
		Date startDate, Date endDate, ServiceContext serviceContext)
		throws PortalException, SystemException {

		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date date = new Date();

		// chiave tripla per l'entità ESFEntityState
		ESFEntityStatePK esfEntityStatePK = new ESFEntityStatePK();
		esfEntityStatePK.setClassName(className);
		esfEntityStatePK.setClassPk(classPK);
		esfEntityStatePK.setStateId(esfStateId);

		ESFEntityState esfEntityState =
			esfEntityStatePersistence.create(esfEntityStatePK);

		esfEntityState.setUuid(serviceContext.getUuid());
		esfEntityState.setUserId(userId);
		esfEntityState.setGroupId(groupId);
		esfEntityState.setCompanyId(user.getCompanyId());
		esfEntityState.setUserName(user.getFullName());
		esfEntityState.setCreateDate(serviceContext.getCreateDate(date));
		esfEntityState.setModifiedDate(serviceContext.getModifiedDate(date));
		esfEntityState.setStartDate(startDate);
		esfEntityState.setEndDate(endDate);

		esfEntityState = esfEntityStatePersistence.update(esfEntityState);

		return esfEntityState;
	}

	public ESFEntityState updateESFEntityState(
		long userId, long classPKOld, long esfStateIdOld, String classNameOld,
		long classPKNew, long esfStateIdNew, String classNameNew,
		Date startDate, Date endDate, ServiceContext serviceContext)
		throws SystemException, PortalException {

		User user = userPersistence.findByPrimaryKey(userId);

		Date date = new Date();

		// chiave tripla per l'entità ESFEntityState
		ESFEntityStatePK esfEntityStatePK = new ESFEntityStatePK();
		esfEntityStatePK.setClassName(classNameOld);
		esfEntityStatePK.setClassPk(classPKOld);
		esfEntityStatePK.setStateId(esfStateIdOld);

		ESFEntityState esfEntityState =
			getESFEntityStateLocalService().getESFEntityState(esfEntityStatePK);

		esfEntityState.setUserName(user.getFullName());
		esfEntityState.setModifiedDate(serviceContext.getModifiedDate(date));
		esfEntityState.setStartDate(startDate);
		esfEntityState.setEndDate(endDate);

		esfEntityState = esfEntityStatePersistence.update(esfEntityState);
		return esfEntityState;

	}

	public ESFEntityState deleteESFEntityState(
		long classPK, long esfStateId, String className,
		ServiceContext serviceContext)
		throws PortalException, SystemException {

		ESFEntityState esfEntityState =
			deleteESFEntityState(classPK, esfStateId, className, serviceContext);

		return esfEntityState;
	}

	protected void validate(String name, String description)
		throws PortalException {

		if (Validator.isNull(name)) {
			throw new ESFStateNameException("Il campo Name è null");
		}

		if (Validator.isNull(description)) {
			throw new ESFStateDescriptionException(
				"Il campo Descrizione è null");
		}
	}
}
