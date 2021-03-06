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

import it.ethica.esf.service.persistence.ESFFieldESFSportTypePK;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ESFFieldESFSportType service. Represents a row in the &quot;ESF_ESFFieldESFSportType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.ethica.esf.model.impl.ESFFieldESFSportTypeModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.ethica.esf.model.impl.ESFFieldESFSportTypeImpl}.
 * </p>
 *
 * @author ethica
 * @see ESFFieldESFSportType
 * @see it.ethica.esf.model.impl.ESFFieldESFSportTypeImpl
 * @see it.ethica.esf.model.impl.ESFFieldESFSportTypeModelImpl
 * @generated
 */
public interface ESFFieldESFSportTypeModel extends BaseModel<ESFFieldESFSportType>,
	StagedGroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a e s f field e s f sport type model instance should use the {@link ESFFieldESFSportType} interface instead.
	 */

	/**
	 * Returns the primary key of this e s f field e s f sport type.
	 *
	 * @return the primary key of this e s f field e s f sport type
	 */
	public ESFFieldESFSportTypePK getPrimaryKey();

	/**
	 * Sets the primary key of this e s f field e s f sport type.
	 *
	 * @param primaryKey the primary key of this e s f field e s f sport type
	 */
	public void setPrimaryKey(ESFFieldESFSportTypePK primaryKey);

	/**
	 * Returns the uuid of this e s f field e s f sport type.
	 *
	 * @return the uuid of this e s f field e s f sport type
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this e s f field e s f sport type.
	 *
	 * @param uuid the uuid of this e s f field e s f sport type
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the esf field ID of this e s f field e s f sport type.
	 *
	 * @return the esf field ID of this e s f field e s f sport type
	 */
	public long getEsfFieldId();

	/**
	 * Sets the esf field ID of this e s f field e s f sport type.
	 *
	 * @param esfFieldId the esf field ID of this e s f field e s f sport type
	 */
	public void setEsfFieldId(long esfFieldId);

	/**
	 * Returns the esf sport type ID of this e s f field e s f sport type.
	 *
	 * @return the esf sport type ID of this e s f field e s f sport type
	 */
	public long getEsfSportTypeId();

	/**
	 * Sets the esf sport type ID of this e s f field e s f sport type.
	 *
	 * @param esfSportTypeId the esf sport type ID of this e s f field e s f sport type
	 */
	public void setEsfSportTypeId(long esfSportTypeId);

	/**
	 * Returns the group ID of this e s f field e s f sport type.
	 *
	 * @return the group ID of this e s f field e s f sport type
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this e s f field e s f sport type.
	 *
	 * @param groupId the group ID of this e s f field e s f sport type
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this e s f field e s f sport type.
	 *
	 * @return the company ID of this e s f field e s f sport type
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this e s f field e s f sport type.
	 *
	 * @param companyId the company ID of this e s f field e s f sport type
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this e s f field e s f sport type.
	 *
	 * @return the user ID of this e s f field e s f sport type
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this e s f field e s f sport type.
	 *
	 * @param userId the user ID of this e s f field e s f sport type
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this e s f field e s f sport type.
	 *
	 * @return the user uuid of this e s f field e s f sport type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this e s f field e s f sport type.
	 *
	 * @param userUuid the user uuid of this e s f field e s f sport type
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this e s f field e s f sport type.
	 *
	 * @return the user name of this e s f field e s f sport type
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this e s f field e s f sport type.
	 *
	 * @param userName the user name of this e s f field e s f sport type
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this e s f field e s f sport type.
	 *
	 * @return the create date of this e s f field e s f sport type
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this e s f field e s f sport type.
	 *
	 * @param createDate the create date of this e s f field e s f sport type
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this e s f field e s f sport type.
	 *
	 * @return the modified date of this e s f field e s f sport type
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this e s f field e s f sport type.
	 *
	 * @param modifiedDate the modified date of this e s f field e s f sport type
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

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
	public int compareTo(ESFFieldESFSportType esfFieldESFSportType);

	@Override
	public int hashCode();

	@Override
	public CacheModel<ESFFieldESFSportType> toCacheModel();

	@Override
	public ESFFieldESFSportType toEscapedModel();

	@Override
	public ESFFieldESFSportType toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}