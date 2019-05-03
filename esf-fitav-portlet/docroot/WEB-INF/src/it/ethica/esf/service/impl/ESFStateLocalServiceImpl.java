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
import java.util.List;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ClassName;

import it.ethica.esf.NoSuchStateException;
import it.ethica.esf.model.ESFState;
import it.ethica.esf.model.ESFStateAssEntity;
import it.ethica.esf.service.base.ESFStateLocalServiceBaseImpl;
import it.ethica.esf.service.persistence.ESFStateAssEntityPK;
import it.ethica.esf.service.persistence.ESFStateAssEntityUtil;
import it.ethica.esf.util.ESFKeys;

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

	public List<ESFState> findESFStates(String className)
		throws SystemException {

		List<ESFState> esfStates = new ArrayList<ESFState>();

		List<ESFStateAssEntity> esfStateAssEntitys =
			esfStateAssEntityPersistence.findByClassName(className);

		for (ESFStateAssEntity esfStateAssEntity : esfStateAssEntitys) {
			ESFState esfState =
				esfStatePersistence.fetchByPrimaryKey(esfStateAssEntity.getEsfStateId());

			esfStates.add(esfState);
		}

		return esfStates;
	}

	public ESFState findESFStateById(long esfStateId)
		throws NoSuchStateException, SystemException {

		return esfStatePersistence.fetchByPrimaryKey(esfStateId);
	}

	public List<ESFState> findAllESFStates()
		throws SystemException {

		return esfStatePersistence.findAll();
	}

	public ESFStateAssEntity getESFStateAssEntitybyId_CN(
		long esfStateId, String className)
		throws SystemException {

		ESFStateAssEntityPK esfStateAssEntityPK = new ESFStateAssEntityPK();
		esfStateAssEntityPK.setClassName(className);
		esfStateAssEntityPK.setEsfStateId(esfStateId);

		return ESFStateAssEntityUtil.fetchByPrimaryKey(esfStateAssEntityPK);
	}

	
	/**
	 * Torna tutti i className associati alle entit� portlet ESF gi� assegnati
	 * allo stato con id esfStateId
	 * 
	 * @return entit� portlet ESF gi� assegnati ad uno stato
	 * @throws SystemException
	 */
	public List<ClassName> getESFClassNameAssigned(long esfStateId)
		throws SystemException {

		List<ClassName> esfEntities = new ArrayList<ClassName>();

		List<ClassName> classNames = classNamePersistence.findAll();

		for (ClassName className : classNames) {

			String value = className.getValue();

			if (value.matches(ESFKeys.PACKAGE_MODEL + "(.*)") &&
				getESFStateAssEntitybyId_CN(esfStateId, value) != null) {

				esfEntities.add(className);
			}
		}

		return esfEntities;
	}

	/**
	 * Torna tutti i className associati alle entit� portlet ESF e ancora non
	 * assegnati allo stato con id esfStateId
	 * 
	 * @return entit� portlet ESF non assegnati ad uno stato
	 * @throws SystemException
	 */
	public List<ClassName> getESFClassNameNotAssigned(long esfStateId)
		throws SystemException {

		List<ClassName> esfEntities = new ArrayList<ClassName>();

		List<ClassName> classNames = classNamePersistence.findAll();

		for (ClassName className : classNames) {

			String value = className.getValue();

			if (value.matches(ESFKeys.PACKAGE_MODEL + "(.*)") &&
				getESFStateAssEntitybyId_CN(esfStateId, value) == null) {

				esfEntities.add(className);
			}
		}

		return esfEntities;
	}

	public ESFState addState(String name, String description)
		throws NoSuchUserException, SystemException {

		long esfStateId = counterLocalService.increment();

		ESFState esfState = esfStatePersistence.create(esfStateId);

		esfState.setName(name);
		esfState.setDescription(description);

		esfStatePersistence.update(esfState);

		return esfState;
	}

	public ESFState updateState(long esfStateId, String name, String description)
		throws SystemException, PortalException {

		ESFState esfState = getESFState(esfStateId);

		esfState.setName(name);
		esfState.setDescription(description);

		esfStatePersistence.update(esfState);

		return esfState;
	}

	public ESFState deleteState(long esfStateId)
		throws SystemException, PortalException {

		ESFState esfState = getESFState(esfStateId);

		esfStatePersistence.remove(esfState);

		return esfState;
	}

	public ESFStateAssEntity addESFStateAssEntity(
		long esfStateId, long classNameId)
		throws SystemException, PortalException {

		String classNameValue = getClassNameById(classNameId);

		ESFStateAssEntityPK esfStateAssEntityPK = new ESFStateAssEntityPK();
		esfStateAssEntityPK.setEsfStateId(esfStateId);
		esfStateAssEntityPK.setClassName(classNameValue);

		ESFStateAssEntity esfStateAssEntity =
			esfStateAssEntityPersistence.create(esfStateAssEntityPK);

		esfStateAssEntityPersistence.update(esfStateAssEntity);

		return esfStateAssEntity;
	}

	public ESFStateAssEntity deleteESFStateAssEntity(
		long esfStateId, long classNameId)
		throws SystemException, PortalException {

		String classNameValue = getClassNameById(classNameId);

		ESFStateAssEntityPK esfStateAssEntityPK = new ESFStateAssEntityPK();
		esfStateAssEntityPK.setEsfStateId(esfStateId);
		esfStateAssEntityPK.setClassName(classNameValue);

		ESFStateAssEntity esfStateAssEntity =
			esfStateAssEntityPersistence.findByPrimaryKey(esfStateAssEntityPK);

		esfStateAssEntityPersistence.remove(esfStateAssEntity);

		return esfStateAssEntity;
	}

	public ESFState checkName(String name)
		throws PortalException, SystemException {

		if (Validator.isNotNull(name) && !Validator.isBlank(name)) {
			return esfStatePersistence.fetchByName(name);
		}

		return null;
	}

	/**
	 * Verifica se � stato assegnata una o pi� entit� allo stato con id
	 * esfStateId
	 * 
	 * @return true se gia assegnata
	 */
	public boolean isStateAssEntity(long esfStateId)
		throws SystemException {

		List<ESFStateAssEntity> esfStateAssEntitys =
			esfStateAssEntityPersistence.findByESFStateId(esfStateId);

		if (esfStateAssEntitys.isEmpty()) {
			return false;
		}

		return true;
	}

	private String getClassNameById(long classNameId)
		throws PortalException, SystemException {

		ClassName className = classNameLocalService.getClassName(classNameId);

		return className.getValue();
	}
}
