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

import it.ethica.esf.model.VW_NomineDirettoriTiro;
import it.ethica.esf.service.base.VW_NomineDirettoriTiroLocalServiceBaseImpl;

/**
 * The implementation of the v w_ nomine direttori tiro local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.service.VW_NomineDirettoriTiroLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.service.base.VW_NomineDirettoriTiroLocalServiceBaseImpl
 * @see it.ethica.esf.service.VW_NomineDirettoriTiroLocalServiceUtil
 */
public class VW_NomineDirettoriTiroLocalServiceImpl
	extends VW_NomineDirettoriTiroLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.service.VW_NomineDirettoriTiroLocalServiceUtil} to access the v w_ nomine direttori tiro local service.
	 */
	
	public List<VW_NomineDirettoriTiro> findByIdDirettore(int id) throws SystemException {
		return this.getVW_NomineDirettoriTiroPersistence().findByIdDirettore(id);
	}
	
	
}