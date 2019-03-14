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

import com.liferay.portal.kernel.exception.SystemException;

import it.ethica.esf.model.ESFShootingDirector;
import it.ethica.esf.model.ESFSuspensiveShootingDirector;
import it.ethica.esf.service.base.ESFSuspensiveShootingDirectorLocalServiceBaseImpl;

/**
 * The implementation of the e s f suspensive shooting director local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFSuspensiveShootingDirectorLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFSuspensiveShootingDirectorLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFSuspensiveShootingDirectorLocalServiceUtil
 */
public class ESFSuspensiveShootingDirectorLocalServiceImpl
	extends ESFSuspensiveShootingDirectorLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.ESFSuspensiveShootingDirectorLocalServiceUtil} to access the e s f suspensive shooting director local service.
	 */
	
	public List<ESFSuspensiveShootingDirector> findByUserId(long esfUserId, int start, int end) 
					throws SystemException{
		
		List<ESFSuspensiveShootingDirector> suspensives = new ArrayList<ESFSuspensiveShootingDirector>();
		suspensives = esfSuspensiveShootingDirectorPersistence.findBybyUserId(esfUserId);
		
		if(suspensives.size() > end ){
			suspensives = suspensives.subList(start, end);
		}else{
			suspensives = suspensives.subList(start, suspensives.size());
		}
		
		return suspensives;
	}
	
	public int countByUserId(long esfUserId) 
					throws SystemException{
		int tot = 0;
		List<ESFSuspensiveShootingDirector> suspensives = new ArrayList<ESFSuspensiveShootingDirector>();
		suspensives =  esfSuspensiveShootingDirectorPersistence.findBybyUserId(esfUserId);
		return tot =suspensives.size() ;
		
	}
	
	public List<ESFSuspensiveShootingDirector> findAll( int start, int end)throws SystemException{
		
		List<ESFSuspensiveShootingDirector> suspensive = new ArrayList<ESFSuspensiveShootingDirector>();
		
		suspensive = esfSuspensiveShootingDirectorPersistence.findAll(start, end);
		
		return suspensive;
	}
	
	public int countTotal()throws SystemException{
		
		int total = 0;
		List<ESFSuspensiveShootingDirector> suspensive = new ArrayList<ESFSuspensiveShootingDirector>();
		
		suspensive = esfSuspensiveShootingDirectorPersistence.findAll();
		total = suspensive.size();
		
		return total;
	}
	
	public int findSuspensive(Date matchData, long userId)throws SystemException{
		
		int total = 0;
		List<ESFSuspensiveShootingDirector> suspensive = new ArrayList<ESFSuspensiveShootingDirector>();
		
		suspensive = esfSuspensiveShootingDirectorPersistence.findByDate(matchData, userId);

		total = suspensive.size();
		
		return total;
	}
}