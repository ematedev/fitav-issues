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
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * The extended model implementation for the ESFAddress service. Represents a
 * row in the &quot;ESF_ESFAddress&quot; database table, with each column mapped
 * to a property of this class. <p> Helper methods and all application logic
 * should be put in this class. Whenever methods are added, rerun ServiceBuilder
 * to copy their definitions into the {@link it.ethica.esf.model.ESFAddress}
 * interface. </p>
 *
 * @author Ethica
 */
public class ESFAddressImpl extends ESFAddressBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this class directly. All methods
	 * that expect a e s f address model instance should use the {@link
	 * it.ethica.esf.model.ESFAddress} interface instead.
	 */

	private long companyId;
	private long userId;
	private String userName;
	private Date createDate;
	private Date modifiedDate;
	private long classNameId;
	private long classPk;
	private String street1;
	private String street2;
	private String street3;
	private String zip;
	private int typeId;
	private boolean mailing;
	private boolean primary_;

	public ESFAddressImpl() {

	}


	public long getCompanyId()
		throws PortalException, SystemException {

		companyId =
			AddressLocalServiceUtil.getAddress(getEsfAddressId()).getCompanyId();
		return companyId;
	}

	public void setCompanyId(long companyId)
		throws PortalException, SystemException {

		AddressLocalServiceUtil.getAddress(getEsfAddressId()).setCompanyId(
			companyId);
		this.companyId = companyId;
	}

	public long getUserId()
		throws PortalException, SystemException {

		userId =
			AddressLocalServiceUtil.getAddress(getEsfAddressId()).getUserId();
		return userId;
	}

	public void setUserId(long userId)
		throws PortalException, SystemException {

		AddressLocalServiceUtil.getAddress(getEsfAddressId()).setUserId(userId);
		this.userId = userId;
	}

	public String getUserName()
		throws PortalException, SystemException {

		userName =
			AddressLocalServiceUtil.getAddress(getEsfAddressId()).getUserName();
		return userName;
	}

	public void setUserName(String userName)
		throws PortalException, SystemException {

		AddressLocalServiceUtil.getAddress(getEsfAddressId()).setUserName(
			userName);
		this.userName = userName;
	}

	public Date getCreateDate()
		throws PortalException, SystemException {

		createDate =
			AddressLocalServiceUtil.getAddress(getEsfAddressId()).getCreateDate();
		return createDate;
	}

	public void setCreateDate(Date createDate)
		throws PortalException, SystemException {

		AddressLocalServiceUtil.getAddress(getEsfAddressId()).setCreateDate(
			createDate);
		this.createDate = createDate;
	}

	public Date getModifiedDate()
		throws PortalException, SystemException {

		modifiedDate =
			AddressLocalServiceUtil.getAddress(getEsfAddressId()).getModifiedDate();
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate)
		throws PortalException, SystemException {

		AddressLocalServiceUtil.getAddress(getEsfAddressId()).setModifiedDate(
			modifiedDate);
		this.modifiedDate = modifiedDate;
	}

	public long getClassNameId()
		throws PortalException, SystemException {

		classNameId =
			AddressLocalServiceUtil.getAddress(getEsfAddressId()).getClassNameId();
		return classNameId;
	}

	public void setClassNameId(long classNameId)
		throws PortalException, SystemException {

		AddressLocalServiceUtil.getAddress(getEsfAddressId()).setClassNameId(
			classNameId);
		this.classNameId = classNameId;
	}

	public long getClassPk()
		throws PortalException, SystemException {

		classPk =
			AddressLocalServiceUtil.getAddress(getEsfAddressId()).getClassPK();
		return classPk;
	}

	public void setClassPk(long classPk)
		throws PortalException, SystemException {

		AddressLocalServiceUtil.getAddress(getEsfAddressId()).setClassPK(
			classPk);
		this.classPk = classPk;
	}

	public String getStreet1()
		throws PortalException, SystemException {

		street1 =
			AddressLocalServiceUtil.getAddress(getEsfAddressId()).getStreet1();
		return street1;
	}

	public void setStreet1(String street1)
		throws PortalException, SystemException {

		AddressLocalServiceUtil.getAddress(getEsfAddressId()).setStreet1(
			street1);
		this.street1 = street1;
	}

	public String getStreet2()
		throws PortalException, SystemException {

		street2 =
			AddressLocalServiceUtil.getAddress(getEsfAddressId()).getStreet2();
		return street2;
	}

	public void setStreet2(String street2)
		throws PortalException, SystemException {

		AddressLocalServiceUtil.getAddress(getEsfAddressId()).setStreet2(
			street2);
		this.street2 = street2;
	}

	public String getStreet3()
		throws PortalException, SystemException {

		street3 =
			AddressLocalServiceUtil.getAddress(getEsfAddressId()).getStreet3();
		return street3;
	}

	public void setStreet3(String street3)
		throws PortalException, SystemException {

		AddressLocalServiceUtil.getAddress(getEsfAddressId()).setStreet3(
			street3);
		this.street3 = street3;
	}

	public String getZip()
		throws PortalException, SystemException {

		zip = AddressLocalServiceUtil.getAddress(getEsfAddressId()).getZip();
		return zip;
	}

	public void setZip(String zip)
		throws PortalException, SystemException {

		AddressLocalServiceUtil.getAddress(getEsfAddressId()).setZip(zip);
		this.zip = zip;
	}

	public int getTypeId()
		throws PortalException, SystemException {

		typeId =
			AddressLocalServiceUtil.getAddress(getEsfAddressId()).getTypeId();
		return typeId;
	}

	public void setTypeId(int typeId)
		throws PortalException, SystemException {

		AddressLocalServiceUtil.getAddress(getEsfAddressId()).setTypeId(typeId);
		this.typeId = typeId;
	}

	public boolean getMailing()
		throws PortalException, SystemException {

		mailing =
			AddressLocalServiceUtil.getAddress(getEsfAddressId()).getMailing();
		return mailing;
	}

	public void setMailing(boolean mailing)
		throws PortalException, SystemException {

		AddressLocalServiceUtil.getAddress(getEsfAddressId()).setMailing(
			mailing);
		this.mailing = mailing;
	}

	public boolean getPrimary_()
		throws PortalException, SystemException {

		primary_ =
			AddressLocalServiceUtil.getAddress(getEsfAddressId()).getPrimary();
		return primary_;
	}

	public void setPrimary_(boolean primary_)
		throws PortalException, SystemException {

		AddressLocalServiceUtil.getAddress(getEsfAddressId()).setPrimary(
			primary_);
		this.primary_ = primary_;
	}

}
