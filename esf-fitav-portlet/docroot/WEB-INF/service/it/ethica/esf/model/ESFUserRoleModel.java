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

package it.ethica.esf.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.StagedGroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ESFUserRole service. Represents a row in the &quot;ESFUserRole&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.ethica.esf.model.impl.ESFUserRoleModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.ethica.esf.model.impl.ESFUserRoleImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFUserRole
 * @see it.ethica.esf.model.impl.ESFUserRoleImpl
 * @see it.ethica.esf.model.impl.ESFUserRoleModelImpl
 * @generated
 */
public interface ESFUserRoleModel extends BaseModel<ESFUserRole>,
	StagedGroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a e s f user role model instance should use the {@link ESFUserRole} interface instead.
	 */

	/**
	 * Returns the primary key of this e s f user role.
	 *
	 * @return the primary key of this e s f user role
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this e s f user role.
	 *
	 * @param primaryKey the primary key of this e s f user role
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this e s f user role.
	 *
	 * @return the uuid of this e s f user role
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this e s f user role.
	 *
	 * @param uuid the uuid of this e s f user role
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the esf user role ID of this e s f user role.
	 *
	 * @return the esf user role ID of this e s f user role
	 */
	public long getEsfUserRoleId();

	/**
	 * Sets the esf user role ID of this e s f user role.
	 *
	 * @param esfUserRoleId the esf user role ID of this e s f user role
	 */
	public void setEsfUserRoleId(long esfUserRoleId);

	/**
	 * Returns the group ID of this e s f user role.
	 *
	 * @return the group ID of this e s f user role
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this e s f user role.
	 *
	 * @param groupId the group ID of this e s f user role
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this e s f user role.
	 *
	 * @return the company ID of this e s f user role
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this e s f user role.
	 *
	 * @param companyId the company ID of this e s f user role
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this e s f user role.
	 *
	 * @return the user ID of this e s f user role
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this e s f user role.
	 *
	 * @param userId the user ID of this e s f user role
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this e s f user role.
	 *
	 * @return the user uuid of this e s f user role
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this e s f user role.
	 *
	 * @param userUuid the user uuid of this e s f user role
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this e s f user role.
	 *
	 * @return the user name of this e s f user role
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this e s f user role.
	 *
	 * @param userName the user name of this e s f user role
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this e s f user role.
	 *
	 * @return the create date of this e s f user role
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this e s f user role.
	 *
	 * @param createDate the create date of this e s f user role
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this e s f user role.
	 *
	 * @return the modified date of this e s f user role
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this e s f user role.
	 *
	 * @param modifiedDate the modified date of this e s f user role
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the is b d o of this e s f user role.
	 *
	 * @return the is b d o of this e s f user role
	 */
	public boolean getIsBDO();

	/**
	 * Returns <code>true</code> if this e s f user role is is b d o.
	 *
	 * @return <code>true</code> if this e s f user role is is b d o; <code>false</code> otherwise
	 */
	public boolean isIsBDO();

	/**
	 * Sets whether this e s f user role is is b d o.
	 *
	 * @param isBDO the is b d o of this e s f user role
	 */
	public void setIsBDO(boolean isBDO);

	/**
	 * Returns the is l e a of this e s f user role.
	 *
	 * @return the is l e a of this e s f user role
	 */
	public boolean getIsLEA();

	/**
	 * Returns <code>true</code> if this e s f user role is is l e a.
	 *
	 * @return <code>true</code> if this e s f user role is is l e a; <code>false</code> otherwise
	 */
	public boolean isIsLEA();

	/**
	 * Sets whether this e s f user role is is l e a.
	 *
	 * @param isLEA the is l e a of this e s f user role
	 */
	public void setIsLEA(boolean isLEA);

	/**
	 * Returns the type of this e s f user role.
	 *
	 * @return the type of this e s f user role
	 */
	public int getType();

	/**
	 * Sets the type of this e s f user role.
	 *
	 * @param type the type of this e s f user role
	 */
	public void setType(int type);

	/**
	 * Returns the max user of this e s f user role.
	 *
	 * @return the max user of this e s f user role
	 */
	public int getMaxUser();

	/**
	 * Sets the max user of this e s f user role.
	 *
	 * @param maxUser the max user of this e s f user role
	 */
	public void setMaxUser(int maxUser);

	/**
	 * Returns the is org admin of this e s f user role.
	 *
	 * @return the is org admin of this e s f user role
	 */
	public boolean getIsOrgAdmin();

	/**
	 * Returns <code>true</code> if this e s f user role is is org admin.
	 *
	 * @return <code>true</code> if this e s f user role is is org admin; <code>false</code> otherwise
	 */
	public boolean isIsOrgAdmin();

	/**
	 * Sets whether this e s f user role is is org admin.
	 *
	 * @param isOrgAdmin the is org admin of this e s f user role
	 */
	public void setIsOrgAdmin(boolean isOrgAdmin);

	/**
	 * Returns the is editable of this e s f user role.
	 *
	 * @return the is editable of this e s f user role
	 */
	public boolean getIsEditable();

	/**
	 * Returns <code>true</code> if this e s f user role is is editable.
	 *
	 * @return <code>true</code> if this e s f user role is is editable; <code>false</code> otherwise
	 */
	public boolean isIsEditable();

	/**
	 * Sets whether this e s f user role is is editable.
	 *
	 * @param isEditable the is editable of this e s f user role
	 */
	public void setIsEditable(boolean isEditable);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(it.ethica.esf.model.ESFUserRole esfUserRole);

	@Override
	public int hashCode();

	@Override
	public CacheModel<it.ethica.esf.model.ESFUserRole> toCacheModel();

	@Override
	public it.ethica.esf.model.ESFUserRole toEscapedModel();

	@Override
	public it.ethica.esf.model.ESFUserRole toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}