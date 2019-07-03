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
 * The base model interface for the ESFSpecific service. Represents a row in the &quot;ESFSpecific&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.ethica.esf.model.impl.ESFSpecificModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.ethica.esf.model.impl.ESFSpecificImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFSpecific
 * @see it.ethica.esf.model.impl.ESFSpecificImpl
 * @see it.ethica.esf.model.impl.ESFSpecificModelImpl
 * @generated
 */
public interface ESFSpecificModel extends BaseModel<ESFSpecific>,
	StagedGroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a e s f specific model instance should use the {@link ESFSpecific} interface instead.
	 */

	/**
	 * Returns the primary key of this e s f specific.
	 *
	 * @return the primary key of this e s f specific
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this e s f specific.
	 *
	 * @param primaryKey the primary key of this e s f specific
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this e s f specific.
	 *
	 * @return the uuid of this e s f specific
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this e s f specific.
	 *
	 * @param uuid the uuid of this e s f specific
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the esf specific ID of this e s f specific.
	 *
	 * @return the esf specific ID of this e s f specific
	 */
	public long getEsfSpecificId();

	/**
	 * Sets the esf specific ID of this e s f specific.
	 *
	 * @param esfSpecificId the esf specific ID of this e s f specific
	 */
	public void setEsfSpecificId(long esfSpecificId);

	/**
	 * Returns the group ID of this e s f specific.
	 *
	 * @return the group ID of this e s f specific
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this e s f specific.
	 *
	 * @param groupId the group ID of this e s f specific
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this e s f specific.
	 *
	 * @return the company ID of this e s f specific
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this e s f specific.
	 *
	 * @param companyId the company ID of this e s f specific
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this e s f specific.
	 *
	 * @return the user ID of this e s f specific
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this e s f specific.
	 *
	 * @param userId the user ID of this e s f specific
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this e s f specific.
	 *
	 * @return the user uuid of this e s f specific
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this e s f specific.
	 *
	 * @param userUuid the user uuid of this e s f specific
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this e s f specific.
	 *
	 * @return the user name of this e s f specific
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this e s f specific.
	 *
	 * @param userName the user name of this e s f specific
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this e s f specific.
	 *
	 * @return the create date of this e s f specific
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this e s f specific.
	 *
	 * @param createDate the create date of this e s f specific
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this e s f specific.
	 *
	 * @return the modified date of this e s f specific
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this e s f specific.
	 *
	 * @param modifiedDate the modified date of this e s f specific
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the code of this e s f specific.
	 *
	 * @return the code of this e s f specific
	 */
	@AutoEscape
	public String getCode();

	/**
	 * Sets the code of this e s f specific.
	 *
	 * @param code the code of this e s f specific
	 */
	public void setCode(String code);

	/**
	 * Returns the description of this e s f specific.
	 *
	 * @return the description of this e s f specific
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this e s f specific.
	 *
	 * @param description the description of this e s f specific
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
	public int compareTo(it.ethica.esf.model.ESFSpecific esfSpecific);

	@Override
	public int hashCode();

	@Override
	public CacheModel<it.ethica.esf.model.ESFSpecific> toCacheModel();

	@Override
	public it.ethica.esf.model.ESFSpecific toEscapedModel();

	@Override
	public it.ethica.esf.model.ESFSpecific toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}