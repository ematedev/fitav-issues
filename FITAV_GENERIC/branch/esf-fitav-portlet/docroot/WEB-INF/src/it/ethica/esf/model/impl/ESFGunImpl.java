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

package it.ethica.esf.model.impl;

import it.ethica.esf.model.ESFGunKind;
import it.ethica.esf.model.ESFGunType;
import it.ethica.esf.service.ESFGunKindLocalServiceUtil;
import it.ethica.esf.service.ESFGunTypeLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

/**
 * The extended model implementation for the ESFGun service. Represents a row in the &quot;ESFGun&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.ethica.esf.model.ESFGun} interface.
 * </p>
 *
 * @author Ethica
 */
public class ESFGunImpl extends ESFGunBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a e s f gun model instance should use the {@link it.ethica.esf.model.ESFGun} interface instead.
	 */
	public ESFGunImpl() {
	}

	public String getFullName() {

		try {
			return getAssetName(this.getEsfGunKindId());
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	protected String getAssetName(long esfGunKindId) 
			throws PortalException, SystemException {

		ESFGunKind esfGunKind = ESFGunKindLocalServiceUtil
				.getESFGunKind(esfGunKindId);
		ESFGunType esfGunType = ESFGunTypeLocalServiceUtil
				.getESFGunType(esfGunKind.getEsfGunTypeId());

		return StringUtil.add(esfGunType.getName(),
				esfGunKind.getName(), StringPool.SPACE);
	}
	
}