/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import it.ethica.esf.NoSuchEsfRadunoShootersException;
import it.ethica.esf.NoSuchRadunoStaffException;
import it.ethica.esf.model.ESFRadunoAzzurri;
import it.ethica.esf.model.ESFRadunoStaff;
import it.ethica.esf.model.EsfRadunoShooters;
import it.ethica.esf.model.impl.ESFRadunoStaffImpl;
import it.ethica.esf.model.impl.EsfRadunoShootersImpl;
import it.ethica.esf.service.base.EsfRadunoShootersLocalServiceBaseImpl;

/**
 * The implementation of the esf raduno shooters local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.EsfRadunoShootersLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.EsfRadunoShootersLocalServiceBaseImpl
 * @see it.ethica.esf.service.EsfRadunoShootersLocalServiceUtil
 */
public class EsfRadunoShootersLocalServiceImpl
	extends EsfRadunoShootersLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.EsfRadunoShootersLocalServiceUtil} to access the esf raduno shooters local service.
	 */
	
	public List<EsfRadunoShooters> findById(long id_esf_raduno) throws SystemException{
		List<EsfRadunoShooters> listaRadunoShooters = null;
		
		listaRadunoShooters = esfRadunoShootersPersistence.findByfindByRaduno(id_esf_raduno);
		
		return listaRadunoShooters;
	}
	
		
	public void associaShooters(long id_esf_raduno, List<String> listaChecked, List<String> listaUnchecked) throws SystemException, NumberFormatException{
		
		if(id_esf_raduno == 0)
			return;
		
		if(listaChecked == null)
			return;
		
		if(listaUnchecked == null)
			return;
		
		for(String idUnchecked : listaUnchecked){
			
			long userId = Long.valueOf(idUnchecked);
			try {
				esfRadunoShootersPersistence.removeByfindRadunoShooters(id_esf_raduno, userId);
			} catch (NoSuchEsfRadunoShootersException e) {
				// TODO Auto-generated catch block
				System.out.println("CANCELLO LA RIGA n. " + idUnchecked);
				e.printStackTrace();
			}
		}
		
		for(String idChecked : listaChecked){
			long userId = Long.valueOf(idChecked);
			try {
				esfRadunoShootersPersistence.findByfindRadunoShooters(id_esf_raduno, userId);
			} catch (NoSuchEsfRadunoShootersException e) {
				// TODO Auto-generated catch block
				EsfRadunoShooters rsNew = new EsfRadunoShootersImpl();
				rsNew.setId_esf_raduno(id_esf_raduno);
				rsNew.setUserId(userId);
				this.addEsfRadunoShooters(rsNew);
				System.out.println("INSERISCO LA RIGA n. " + userId);
			}

		}
	}		
}
