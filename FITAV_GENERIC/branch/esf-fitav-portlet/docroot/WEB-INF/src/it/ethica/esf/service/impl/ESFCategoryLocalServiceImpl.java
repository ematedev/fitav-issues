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
import java.util.HashMap;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import it.ethica.esf.model.ESFCategory;
import it.ethica.esf.service.base.ESFCategoryLocalServiceBaseImpl;

/**
 * The implementation of the e s f category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFCategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFCategoryLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFCategoryLocalServiceUtil
 */
public class ESFCategoryLocalServiceImpl extends ESFCategoryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.ESFCategoryLocalServiceUtil} to access the e s f category local service.
	 */
	public HashMap<String,Long> findMapLongIdCategory() throws SystemException{
		HashMap<String,Long> nameCategoryIdCategory = new HashMap<String,Long>();
		List<ESFCategory> allCategory = new ArrayList<ESFCategory>();
		allCategory = esfCategoryPersistence.findAll();
		for(ESFCategory ec: allCategory){
			String name = ec.getName();
			long id = ec.getPrimaryKey();
			nameCategoryIdCategory.put(name, id);
		}
		return nameCategoryIdCategory;
	}
}