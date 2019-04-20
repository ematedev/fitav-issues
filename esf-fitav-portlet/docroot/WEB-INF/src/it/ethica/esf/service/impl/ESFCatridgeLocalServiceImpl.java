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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

import it.ethica.esf.model.ESFCatridge;
import it.ethica.esf.model.ESFGunType;
import it.ethica.esf.service.base.ESFCatridgeLocalServiceBaseImpl;

/**
 * The implementation of the e s f catridge local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFCatridgeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFCatridgeLocalServiceBaseImpl
 * @see it.ethica.esf.service.ESFCatridgeLocalServiceUtil
 */
public class ESFCatridgeLocalServiceImpl extends ESFCatridgeLocalServiceBaseImpl {
	
	/**
	 * Ricerca tutti gli oggetti ESFCatridge sulla base dell'utente.
	 * 
	 * @param esfUserId l'identificativo dell'utente
	 * @return List<ESFCatridge> 
	 */
	public List<ESFCatridge> getESFCatridgesByUserId(long esfUserId)
		throws SystemException {

		return esfCatridgePersistence.findByEsfUserId(esfUserId);
	}

	/**
	 * Ricerca tutti gli oggetti ESFCatridge sulla base dell'utente.
	 * I parametri di <b>start</b> e <b>end</b> definiscono il range di oggetti da restituire
	 * 
	 * @param esfUserId l'identificativo dell'utente
	 * @param start
	 * @param end
	 * @return List<ESFCatridge> 
	 */
	public List<ESFCatridge> getESFCatridgesByUserId(long esfUserId, int start, int end)
		throws SystemException {

		return esfCatridgePersistence.findByEsfUserId(esfUserId, start, end);
	}
	
	/**
	 * Ricerca le cartucce in base al produttore
	 * 
	 * 
	 * 
	 */
	
	public List<ESFCatridge> getESFCatridgesByType(long esfTypeId, int start, int end)
			throws SystemException {

			return esfCatridgePersistence.findByEsfGunTypeId(esfTypeId, start, end);
	}
	
	
	
	public int countESFCatridgesByType(long esfTypeId)
			throws SystemException {

		List<ESFCatridge> cat = new ArrayList<ESFCatridge>();
		int tot = 0;
		
		cat = esfCatridgePersistence.findByEsfGunTypeId(esfTypeId);
		tot = cat.size();
				
		return tot;
	}

	/**
	 * Ricerca tutti gli oggetti ESFCatridge.
	 * I parametri di <b>start</b> e <b>end</b> definiscono il range di oggetti da restituire
	 * 
	 * @return List<ESFCatridge> 
	 */
	public List<ESFCatridge> getESFCatridges()
		throws SystemException {

		return esfCatridgePersistence.findAll();
	}

	/**
	 * Ricerca tutti gli oggetti ESFCatridge.
	 * I parametri di <b>start</b> e <b>end</b> definiscono il range di oggetti da restituire
	 * 
	 * @return List<ESFCatridge> 
	 */
	public List<ESFCatridge> getESFCatridges(int start, int end)
		throws SystemException {

		return esfCatridgePersistence.findAll(start, end);
	}

	
	
	public ESFCatridge addESFCatridge(
		long userId, long esfGunTypeId,
		long esfUserId, String catridgeModel,
		 long catridgeCaliber, String note,
		ServiceContext serviceContext)
		throws SystemException, PortalException {

		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		

		long esfCatridgeId = counterLocalService.increment();

		ESFCatridge esfCatridge = esfCatridgePersistence.create(esfCatridgeId);

	
		esfCatridge.setEsfUserId(esfUserId);
		esfCatridge.setEsfGunTypeId(esfGunTypeId);
		esfCatridge.setCatridgeModel(catridgeModel);
		esfCatridge.setCatridgeCaliber(catridgeCaliber);
		esfCatridge.setNote(note);
		esfCatridge.setExpandoBridgeAttributes(serviceContext);

		esfCatridgePersistence.update(esfCatridge);


		return esfCatridge;

	}

	public ESFCatridge updateESFCatridge(
		long userId, long esfCatridgeId, long esfGunTypeId,
		 long esfUserId, String catridgeModel,
		long catridgeCaliber, String note, ServiceContext serviceContext)
		throws PortalException, SystemException {

		

		ESFCatridge esfCatridge = getESFCatridge(esfCatridgeId);

		User user = UserLocalServiceUtil.getUser(userId);

		esfCatridge.setEsfUserId(esfUserId);
		esfCatridge.setEsfGunTypeId(esfGunTypeId);
		esfCatridge.setCatridgeModel(catridgeModel);
		esfCatridge.setCatridgeCaliber(catridgeCaliber);
		esfCatridge.setNote(note);
		esfCatridge.setExpandoBridgeAttributes(serviceContext);
		

		esfCatridgePersistence.update(esfCatridge);


		return esfCatridge;
	}

	public ESFCatridge deleteESFCatridge(long esfCatridgeId, ServiceContext serviceContext)
		throws PortalException, SystemException {

		ESFCatridge esfCatridge = getESFCatridge(esfCatridgeId);


		esfCatridge = deleteESFCatridge(esfCatridgeId);

		return esfCatridge;
	}

	
	public String getNameM(ESFCatridge esfCatridge) throws PortalException, SystemException{
					ESFGunType esfGunType =
						esfGunTypeLocalService.getESFGunType(esfCatridge.getEsfGunTypeId());
		return esfGunType.getName();
	}
}