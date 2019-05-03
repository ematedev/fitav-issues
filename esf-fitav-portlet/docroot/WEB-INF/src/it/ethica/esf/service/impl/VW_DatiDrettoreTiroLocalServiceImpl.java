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
import com.liferay.portal.kernel.transaction.Transactional;

import it.ethica.esf.NoSuchVW_DatiDrettoreTiroException;
import it.ethica.esf.model.VW_DatiDrettoreTiro;
import it.ethica.esf.model.VW_ESFListaIncarichi;
import it.ethica.esf.service.base.VW_DatiDrettoreTiroLocalServiceBaseImpl;
import it.ethica.esf.service.persistence.VW_ESFListaIncarichiActionableDynamicQuery;

/**
 * The implementation of the v w_ dati drettore tiro local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.VW_DatiDrettoreTiroLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.VW_DatiDrettoreTiroLocalServiceBaseImpl
 * @see it.ethica.esf.service.VW_DatiDrettoreTiroLocalServiceUtil
 */
public class VW_DatiDrettoreTiroLocalServiceImpl
	extends VW_DatiDrettoreTiroLocalServiceBaseImpl {
	
	@Transactional
	public VW_DatiDrettoreTiro findByorganizzazione(long esfShootingDirectorId) throws SystemException, NoSuchVW_DatiDrettoreTiroException {
		return this.vw_DatiDrettoreTiroPersistence.findByesfShootingDirectorId(esfShootingDirectorId);
	}
	
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.VW_DatiDrettoreTiroLocalServiceUtil} to access the v w_ dati drettore tiro local service.
	 */
}