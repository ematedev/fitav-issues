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
 * The base model interface for the ESFShooterCategory service. Represents a row in the &quot;ESFShooterCategory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.ethica.esf.model.impl.ESFShooterCategoryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.ethica.esf.model.impl.ESFShooterCategoryImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFShooterCategory
 * @see it.ethica.esf.model.impl.ESFShooterCategoryImpl
 * @see it.ethica.esf.model.impl.ESFShooterCategoryModelImpl
 * @generated
 */
public interface ESFShooterCategoryModel extends BaseModel<ESFShooterCategory>,
	StagedGroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a e s f shooter category model instance should use the {@link ESFShooterCategory} interface instead.
	 */

	/**
	 * Returns the primary key of this e s f shooter category.
	 *
	 * @return the primary key of this e s f shooter category
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this e s f shooter category.
	 *
	 * @param primaryKey the primary key of this e s f shooter category
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this e s f shooter category.
	 *
	 * @return the uuid of this e s f shooter category
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this e s f shooter category.
	 *
	 * @param uuid the uuid of this e s f shooter category
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the esf shooter category ID of this e s f shooter category.
	 *
	 * @return the esf shooter category ID of this e s f shooter category
	 */
	public long getEsfShooterCategoryId();

	/**
	 * Sets the esf shooter category ID of this e s f shooter category.
	 *
	 * @param esfShooterCategoryId the esf shooter category ID of this e s f shooter category
	 */
	public void setEsfShooterCategoryId(long esfShooterCategoryId);

	/**
	 * Returns the name of this e s f shooter category.
	 *
	 * @return the name of this e s f shooter category
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this e s f shooter category.
	 *
	 * @param name the name of this e s f shooter category
	 */
	public void setName(String name);

	/**
	 * Returns the group ID of this e s f shooter category.
	 *
	 * @return the group ID of this e s f shooter category
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this e s f shooter category.
	 *
	 * @param groupId the group ID of this e s f shooter category
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this e s f shooter category.
	 *
	 * @return the company ID of this e s f shooter category
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this e s f shooter category.
	 *
	 * @param companyId the company ID of this e s f shooter category
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this e s f shooter category.
	 *
	 * @return the user ID of this e s f shooter category
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this e s f shooter category.
	 *
	 * @param userId the user ID of this e s f shooter category
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this e s f shooter category.
	 *
	 * @return the user uuid of this e s f shooter category
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this e s f shooter category.
	 *
	 * @param userUuid the user uuid of this e s f shooter category
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this e s f shooter category.
	 *
	 * @return the user name of this e s f shooter category
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this e s f shooter category.
	 *
	 * @param userName the user name of this e s f shooter category
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this e s f shooter category.
	 *
	 * @return the create date of this e s f shooter category
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this e s f shooter category.
	 *
	 * @param createDate the create date of this e s f shooter category
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this e s f shooter category.
	 *
	 * @return the modified date of this e s f shooter category
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this e s f shooter category.
	 *
	 * @param modifiedDate the modified date of this e s f shooter category
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the description of this e s f shooter category.
	 *
	 * @return the description of this e s f shooter category
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this e s f shooter category.
	 *
	 * @param description the description of this e s f shooter category
	 */
	public void setDescription(String description);

	/**
	 * Returns the code of this e s f shooter category.
	 *
	 * @return the code of this e s f shooter category
	 */
	@AutoEscape
	public String getCode();

	/**
	 * Sets the code of this e s f shooter category.
	 *
	 * @param code the code of this e s f shooter category
	 */
	public void setCode(String code);

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
	public int compareTo(
		it.ethica.esf.model.ESFShooterCategory esfShooterCategory);

	@Override
	public int hashCode();

	@Override
	public CacheModel<it.ethica.esf.model.ESFShooterCategory> toCacheModel();

	@Override
	public it.ethica.esf.model.ESFShooterCategory toEscapedModel();

	@Override
	public it.ethica.esf.model.ESFShooterCategory toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}