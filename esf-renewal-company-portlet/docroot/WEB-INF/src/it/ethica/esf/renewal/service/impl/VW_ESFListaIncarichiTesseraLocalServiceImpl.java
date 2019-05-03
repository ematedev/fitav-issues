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

package it.ethica.esf.renewal.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Transactional;

import it.ethica.esf.renewal.service.base.VW_ESFListaIncarichiTesseraLocalServiceBaseImpl;

/**
 * The implementation of the v w_ e s f lista incarichi tessera local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.renewal.service.VW_ESFListaIncarichiTesseraLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ethica
 * @see it.ethica.esf.renewal.service.base.VW_ESFListaIncarichiTesseraLocalServiceBaseImpl
 * @see it.ethica.esf.renewal.service.VW_ESFListaIncarichiTesseraLocalServiceUtil
 */
public class VW_ESFListaIncarichiTesseraLocalServiceImpl
	extends VW_ESFListaIncarichiTesseraLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link it.ethica.esf.renewal.service.VW_ESFListaIncarichiTesseraLocalServiceUtil} to access the v w_ e s f lista incarichi tessera local service.
	 */
	@Transactional
	public List<it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera> findByorganizzazione(long esfOrganizationId) throws SystemException {
		return this.vw_esfListaIncarichiTesseraPersistence.findByorganizzazione(esfOrganizationId);
	}
}