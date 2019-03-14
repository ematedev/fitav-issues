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
 * The base model interface for the ESFGunType service. Represents a row in the &quot;ESF_ESFGunType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.ethica.esf.model.impl.ESFGunTypeModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.ethica.esf.model.impl.ESFGunTypeImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFGunType
 * @see it.ethica.esf.model.impl.ESFGunTypeImpl
 * @see it.ethica.esf.model.impl.ESFGunTypeModelImpl
 * @generated
 */
public interface ESFGunTypeModel extends BaseModel<ESFGunType>,
	StagedGroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a e s f gun type model instance should use the {@link ESFGunType} interface instead.
	 */

	/**
	 * Returns the primary key of this e s f gun type.
	 *
	 * @return the primary key of this e s f gun type
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this e s f gun type.
	 *
	 * @param primaryKey the primary key of this e s f gun type
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this e s f gun type.
	 *
	 * @return the uuid of this e s f gun type
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this e s f gun type.
	 *
	 * @param uuid the uuid of this e s f gun type
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the esf gun type ID of this e s f gun type.
	 *
	 * @return the esf gun type ID of this e s f gun type
	 */
	public long getEsfGunTypeId();

	/**
	 * Sets the esf gun type ID of this e s f gun type.
	 *
	 * @param esfGunTypeId the esf gun type ID of this e s f gun type
	 */
	public void setEsfGunTypeId(long esfGunTypeId);

	/**
	 * Returns the group ID of this e s f gun type.
	 *
	 * @return the group ID of this e s f gun type
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this e s f gun type.
	 *
	 * @param groupId the group ID of this e s f gun type
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this e s f gun type.
	 *
	 * @return the company ID of this e s f gun type
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this e s f gun type.
	 *
	 * @param companyId the company ID of this e s f gun type
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this e s f gun type.
	 *
	 * @return the user ID of this e s f gun type
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this e s f gun type.
	 *
	 * @param userId the user ID of this e s f gun type
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this e s f gun type.
	 *
	 * @return the user uuid of this e s f gun type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this e s f gun type.
	 *
	 * @param userUuid the user uuid of this e s f gun type
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this e s f gun type.
	 *
	 * @return the user name of this e s f gun type
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this e s f gun type.
	 *
	 * @param userName the user name of this e s f gun type
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this e s f gun type.
	 *
	 * @return the create date of this e s f gun type
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this e s f gun type.
	 *
	 * @param createDate the create date of this e s f gun type
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this e s f gun type.
	 *
	 * @return the modified date of this e s f gun type
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this e s f gun type.
	 *
	 * @param modifiedDate the modified date of this e s f gun type
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this e s f gun type.
	 *
	 * @return the name of this e s f gun type
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this e s f gun type.
	 *
	 * @param name the name of this e s f gun type
	 */
	public void setName(String name);

	/**
	 * Returns the description of this e s f gun type.
	 *
	 * @return the description of this e s f gun type
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this e s f gun type.
	 *
	 * @param description the description of this e s f gun type
	 */
	public void setDescription(String description);

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
	public int compareTo(ESFGunType esfGunType);

	@Override
	public int hashCode();

	@Override
	public CacheModel<ESFGunType> toCacheModel();

	@Override
	public ESFGunType toEscapedModel();

	@Override
	public ESFGunType toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}