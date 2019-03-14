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
 * The base model interface for the ESFTool service. Represents a row in the &quot;ESFTool&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.ethica.esf.model.impl.ESFToolModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.ethica.esf.model.impl.ESFToolImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFTool
 * @see it.ethica.esf.model.impl.ESFToolImpl
 * @see it.ethica.esf.model.impl.ESFToolModelImpl
 * @generated
 */
public interface ESFToolModel extends BaseModel<ESFTool>, StagedGroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a e s f tool model instance should use the {@link ESFTool} interface instead.
	 */

	/**
	 * Returns the primary key of this e s f tool.
	 *
	 * @return the primary key of this e s f tool
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this e s f tool.
	 *
	 * @param primaryKey the primary key of this e s f tool
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this e s f tool.
	 *
	 * @return the uuid of this e s f tool
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this e s f tool.
	 *
	 * @param uuid the uuid of this e s f tool
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the esf tool ID of this e s f tool.
	 *
	 * @return the esf tool ID of this e s f tool
	 */
	public long getEsfToolId();

	/**
	 * Sets the esf tool ID of this e s f tool.
	 *
	 * @param esfToolId the esf tool ID of this e s f tool
	 */
	public void setEsfToolId(long esfToolId);

	/**
	 * Returns the group ID of this e s f tool.
	 *
	 * @return the group ID of this e s f tool
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this e s f tool.
	 *
	 * @param groupId the group ID of this e s f tool
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this e s f tool.
	 *
	 * @return the company ID of this e s f tool
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this e s f tool.
	 *
	 * @param companyId the company ID of this e s f tool
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this e s f tool.
	 *
	 * @return the user ID of this e s f tool
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this e s f tool.
	 *
	 * @param userId the user ID of this e s f tool
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this e s f tool.
	 *
	 * @return the user uuid of this e s f tool
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this e s f tool.
	 *
	 * @param userUuid the user uuid of this e s f tool
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this e s f tool.
	 *
	 * @return the user name of this e s f tool
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this e s f tool.
	 *
	 * @param userName the user name of this e s f tool
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this e s f tool.
	 *
	 * @return the create date of this e s f tool
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this e s f tool.
	 *
	 * @param createDate the create date of this e s f tool
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this e s f tool.
	 *
	 * @return the modified date of this e s f tool
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this e s f tool.
	 *
	 * @param modifiedDate the modified date of this e s f tool
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the code of this e s f tool.
	 *
	 * @return the code of this e s f tool
	 */
	@AutoEscape
	public String getCode();

	/**
	 * Sets the code of this e s f tool.
	 *
	 * @param code the code of this e s f tool
	 */
	public void setCode(String code);

	/**
	 * Returns the name of this e s f tool.
	 *
	 * @return the name of this e s f tool
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this e s f tool.
	 *
	 * @param name the name of this e s f tool
	 */
	public void setName(String name);

	/**
	 * Returns the description of this e s f tool.
	 *
	 * @return the description of this e s f tool
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this e s f tool.
	 *
	 * @param description the description of this e s f tool
	 */
	public void setDescription(String description);

	/**
	 * Returns the type of this e s f tool.
	 *
	 * @return the type of this e s f tool
	 */
	@AutoEscape
	public String getType();

	/**
	 * Sets the type of this e s f tool.
	 *
	 * @param type the type of this e s f tool
	 */
	public void setType(String type);

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
	public int compareTo(ESFTool esfTool);

	@Override
	public int hashCode();

	@Override
	public CacheModel<ESFTool> toCacheModel();

	@Override
	public ESFTool toEscapedModel();

	@Override
	public ESFTool toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}