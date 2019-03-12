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

import java.util.Date;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.PhoneLocalServiceUtil;

/**
 * The extended model implementation for the ESFPhone service. Represents a row
 * in the &quot;ESFPhone&quot; database table, with each column mapped to a
 * property of this class. <p> Helper methods and all application logic should
 * be put in this class. Whenever methods are added, rerun ServiceBuilder to
 * copy their definitions into the {@link it.ethica.esf.model.ESFPhone}
 * interface. </p>
 *
 * @author Ethica
 */
public class ESFPhoneImpl extends ESFPhoneBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this class directly. All methods
	 * that expect a e s f phone model instance should use the {@link
	 * it.ethica.esf.model.ESFPhone} interface instead.
	 */

	private long companyId;
	private long userId;
	private String userName;
	private Date createDate;
	private Date modifiedDate;
	private long classNameId;
	private long classPk;
	private String number;
	private int typeId;
	private boolean primary;
	private boolean isWrapper;

	public ESFPhoneImpl() {

	}

	public long getCompanyId()
		throws PortalException, SystemException {

		if (getEsfPhoneId() > 0 && !this.isWrapper) {
			companyId =
				PhoneLocalServiceUtil.getPhone(getEsfPhoneId()).getCompanyId();
		}
		return companyId;
	}

	public void setCompanyId(long companyId) {

		this.companyId = companyId;
	}

	public long getUserId()
		throws PortalException, SystemException {

		if (getEsfPhoneId() > 0 && !this.isWrapper) {
			userId =
				PhoneLocalServiceUtil.getPhone(getEsfPhoneId()).getUserId();
		}
		return userId;
	}

	public void setUserId(long userId) {

		this.userId = userId;
	}

	public String getUserName()
		throws PortalException, SystemException {

		if (getEsfPhoneId() > 0 && !this.isWrapper) {
			userName =
				PhoneLocalServiceUtil.getPhone(getEsfPhoneId()).getUserName();
		}
		return userName;
	}

	public void setUserName(String userName) {

		this.userName = userName;
	}

	public Date getCreateDate()
		throws PortalException, SystemException {

		if (getEsfPhoneId() > 0 && !this.isWrapper) {
			createDate =
				PhoneLocalServiceUtil.getPhone(getEsfPhoneId()).getCreateDate();
		}
		return createDate;
	}

	public void setCreateDate(Date createDate) {

		this.createDate = createDate;
	}

	public Date getModifiedDate()
		throws PortalException, SystemException {

		if (getEsfPhoneId() > 0 && !this.isWrapper) {
			modifiedDate =
				PhoneLocalServiceUtil.getPhone(getEsfPhoneId()).getModifiedDate();
		}
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {

		this.modifiedDate = modifiedDate;
	}

	public long getClassNameId()
		throws PortalException, SystemException {

		if (getEsfPhoneId() > 0 && !this.isWrapper) {
			classNameId =
				PhoneLocalServiceUtil.getPhone(getEsfPhoneId()).getClassNameId();
		}
		return classNameId;
	}

	public void setClassNameId(long classNameId) {

		this.classNameId = classNameId;
	}

	public long getClassPk()
		throws PortalException, SystemException {

		if (getEsfPhoneId() > 0 && !this.isWrapper) {
			classPk =
				PhoneLocalServiceUtil.getPhone(getEsfPhoneId()).getClassPK();
		}
		return classPk;
	}

	public void setClassPk(long classPk) {

		this.classPk = classPk;
	}

	public String getNumber()
		throws PortalException, SystemException {

		if (getEsfPhoneId() > 0 && !this.isWrapper) {
			number =
				PhoneLocalServiceUtil.getPhone(getEsfPhoneId()).getNumber();
		}
		return number;
	}

	public void setNumber(String number) {

		this.number = number;
	}

	public int getTypeId()
		throws PortalException, SystemException {

		if (getEsfPhoneId() > 0 && !this.isWrapper) {
			typeId =
				PhoneLocalServiceUtil.getPhone(getEsfPhoneId()).getTypeId();
		}
		return typeId;
	}

	public void setTypeId(int typeId) {

		this.typeId = typeId;
	}

	public boolean isPrimary()
		throws PortalException, SystemException {
		if (getEsfPhoneId() > 0 && !this.isWrapper) {
			primary =
				PhoneLocalServiceUtil.getPhone(getEsfPhoneId()).getPrimary();
		}
		return primary;
	}

	public void setPrimary(boolean primary) {

		this.primary = primary;
	}

	public boolean isWrapper() {

		return isWrapper;
	}

	public void setWrapper(boolean isWrapper) {

		this.isWrapper = isWrapper;
	}

}
