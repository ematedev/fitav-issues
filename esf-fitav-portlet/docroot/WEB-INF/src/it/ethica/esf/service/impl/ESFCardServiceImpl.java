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

import it.ethica.esf.model.ESFCard;
import it.ethica.esf.service.base.ESFCardServiceBaseImpl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the e s f card remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.ESFCardService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.ESFCardServiceBaseImpl
 * @see it.ethica.esf.service.ESFCardServiceUtil
 */
public class ESFCardServiceImpl extends ESFCardServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.ESFCardServiceUtil} to access the e s f card remote service.
	 */
	public List<ESFCard> findByUserId(long userId){
		List<ESFCard> cards = new ArrayList<ESFCard>();
		try {
			cards = esfCardLocalService.getAllESFCardsByEsfUserId(userId);
		} catch (SystemException e) {
			_log.fatal(e.getMessage());
		} catch (PortalException e) {
			_log.error(e.getMessage());
		}
		return cards;
	}

	public List<ESFCard> findCurrentByUserId(long userId){
		List<ESFCard> cards = new ArrayList<ESFCard>();
		try {
			cards = esfCardLocalService.findAllESFCardsByU_S(userId, 1);
		} catch (SystemException e) {
			_log.fatal(e.getMessage());
		} 
		return cards;
	}
	
	public List<ESFCard> findHistoryByUserId(long userId){
		List<ESFCard> cards = new ArrayList<ESFCard>();
		try {
			cards = esfCardLocalService.findAllESFCardsByU_S(userId, 2);
		} catch (SystemException e) {
			_log.fatal(e.getMessage());
		} 
		return cards;
	}

	Log _log = LogFactoryUtil.getLog(ESFCardServiceImpl.class.getName());
}