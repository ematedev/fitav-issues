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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;

import it.ethica.esf.model.ESFEntityState;
import it.ethica.esf.model.ESFField;
import it.ethica.esf.model.ESFLentField;
import it.ethica.esf.service.ESFEntityStateLocalServiceUtil;
import it.ethica.esf.service.ESFLentFieldLocalServiceUtil;
import it.ethica.esf.service.base.ESFLentFieldLocalServiceBaseImpl;

/**
 * The implementation of the e s f lent field local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFLentFieldLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFLentFieldLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFLentFieldLocalServiceUtil
 */
public class ESFLentFieldLocalServiceImpl
	extends ESFLentFieldLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.ESFLentFieldLocalServiceUtil} to access the e s f lent field local service.
	 */
	
	public ESFLentField findESFLentFieldbyF_S(long esfFieldId, long esfEntityStateId) 
					throws SystemException{
		
		return esfLentFieldPersistence.fetchByF_S(esfFieldId, esfEntityStateId);
		
	}
	
	public List<ESFLentField> findESFLentFieldsbyF_S(long esfStateId, long realOwnerId) 
					throws SystemException{
		
		List<ESFLentField> esfLentFields = new ArrayList<ESFLentField>();
		
		List<ESFEntityState> esfEntityStates =ESFEntityStateLocalServiceUtil.findESFEntityStateByC_S(
			ESFField.class.getName(), esfStateId);
		
		long[] classPKs = new long[esfEntityStates.size()];

		int i = 0;

		for (ESFEntityState esfEntityState : esfEntityStates) {
			classPKs[i] = esfEntityState.getEsfEntityStateId();
			i++;
		}
		
		try{
			
			DynamicQuery lentFieldQuery = DynamicQueryFactoryUtil.forClass(
				ESFLentField.class, "lentFieldQuery", PortletClassLoaderUtil.getClassLoader());
	
			lentFieldQuery.add(PropertyFactoryUtil.forName(
				"lentFieldQuery.realOwnerId").eq(realOwnerId));
			lentFieldQuery.add(PropertyFactoryUtil.forName("lentFieldQuery.esfEntityStateId").in(
				classPKs));
	
			esfLentFields = ESFLentFieldLocalServiceUtil.dynamicQuery(lentFieldQuery);
		
		}
		catch(Exception e){
			
		}
		
		return esfLentFields;
		
	}
	
	public ESFLentField addESFLentField(long esfEntityStateId, long esfFieldId, 
		long realOwnerId, long actualOwnerId) throws SystemException{
		
		long esfLentFieldId = counterLocalService.increment();
		
		ESFLentField esfLentField = esfLentFieldPersistence.create(esfLentFieldId);
		
		esfLentField.setEsfEntityStateId(esfEntityStateId);
		esfLentField.setEsfFieldId(esfFieldId);
		esfLentField.setRealOwnerId(realOwnerId);
		esfLentField.setActualOwnerId(actualOwnerId);
		
		esfLentField = esfLentFieldPersistence.update(esfLentField);
		
		return esfLentField;
	}
}