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

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Transactional;

import it.ethica.esf.model.VW_ESFIncarichiFederali;
import it.ethica.esf.service.VW_ESFIncarichiFederaliLocalServiceUtil;
import it.ethica.esf.service.base.VW_ESFIncarichiFederaliLocalServiceBaseImpl;
import it.ethica.esf.service.persistence.VW_ESFIncarichiFederaliUtil;
import it.ethica.esf.util.ESFKeys;

/**
 * The implementation of the v w_ e s f incarichi federali local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.VW_ESFIncarichiFederaliLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.VW_ESFIncarichiFederaliLocalServiceBaseImpl
 * @see it.ethica.esf.service.VW_ESFIncarichiFederaliLocalServiceUtil
 */
public class VW_ESFIncarichiFederaliLocalServiceImpl
	extends VW_ESFIncarichiFederaliLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.VW_ESFIncarichiFederaliLocalServiceUtil} to access the v w_ e s f incarichi federali local service.
	 */
	
	@Transactional
	public java.util.List<it.ethica.esf.model.VW_ESFIncarichiFederali> findBylistaIncarichi(long esfUserId, boolean attivo)
			throws com.liferay.portal.kernel.exception.SystemException {
		return this.vw_esfIncarichiFederaliPersistence.findBylistaIncarichi(Boolean.TRUE, esfUserId);
	}
	
	public java.util.List<it.ethica.esf.model.VW_ESFIncarichiFederali> getListaIncarichifindBylistaIncarichi (long esfUserId, boolean attivo) throws SystemException{
		List<VW_ESFIncarichiFederali> listaIncarichiAttivi = new ArrayList<VW_ESFIncarichiFederali>();
		listaIncarichiAttivi = VW_ESFIncarichiFederaliLocalServiceUtil.findBylistaIncarichi(esfUserId, ESFKeys.EsfFederalRole.INCARICO_ATTIVO);
		return listaIncarichiAttivi;
	}
}