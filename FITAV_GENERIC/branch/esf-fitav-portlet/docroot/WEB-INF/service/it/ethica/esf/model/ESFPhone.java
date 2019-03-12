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

package it.ethica.esf.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the ESFPhone service. Represents a row in the &quot;ESFPhone&quot; database table, with each column mapped to a property of this class.
 *
 * @author Ethica
 * @see ESFPhoneModel
 * @see it.ethica.esf.model.impl.ESFPhoneImpl
 * @see it.ethica.esf.model.impl.ESFPhoneModelImpl
 * @generated
 */
public interface ESFPhone extends ESFPhoneModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link it.ethica.esf.model.impl.ESFPhoneImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public long getCompanyId()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void setCompanyId(long companyId);

	public long getUserId()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void setUserId(long userId);

	public java.lang.String getUserName()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void setUserName(java.lang.String userName);

	public java.util.Date getCreateDate()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void setCreateDate(java.util.Date createDate);

	public java.util.Date getModifiedDate()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void setModifiedDate(java.util.Date modifiedDate);

	public long getClassNameId()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void setClassNameId(long classNameId);

	public long getClassPk()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void setClassPk(long classPk);

	public java.lang.String getNumber()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void setNumber(java.lang.String number);

	public int getTypeId()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void setTypeId(int typeId);

	public boolean isPrimary()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void setPrimary(boolean primary);

	public boolean isWrapper();

	public void setWrapper(boolean isWrapper);
}