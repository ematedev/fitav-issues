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
 * The base model interface for the ESFNational service. Represents a row in the &quot;ESFNational&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.ethica.esf.model.impl.ESFNationalModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.ethica.esf.model.impl.ESFNationalImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFNational
 * @see it.ethica.esf.model.impl.ESFNationalImpl
 * @see it.ethica.esf.model.impl.ESFNationalModelImpl
 * @generated
 */
public interface ESFNationalModel extends BaseModel<ESFNational>,
	StagedGroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a e s f national model instance should use the {@link ESFNational} interface instead.
	 */

	/**
	 * Returns the primary key of this e s f national.
	 *
	 * @return the primary key of this e s f national
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this e s f national.
	 *
	 * @param primaryKey the primary key of this e s f national
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this e s f national.
	 *
	 * @return the uuid of this e s f national
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this e s f national.
	 *
	 * @param uuid the uuid of this e s f national
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the esf national ID of this e s f national.
	 *
	 * @return the esf national ID of this e s f national
	 */
	public long getEsfNationalId();

	/**
	 * Sets the esf national ID of this e s f national.
	 *
	 * @param esfNationalId the esf national ID of this e s f national
	 */
	public void setEsfNationalId(long esfNationalId);

	/**
	 * Returns the group ID of this e s f national.
	 *
	 * @return the group ID of this e s f national
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this e s f national.
	 *
	 * @param groupId the group ID of this e s f national
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this e s f national.
	 *
	 * @return the company ID of this e s f national
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this e s f national.
	 *
	 * @param companyId the company ID of this e s f national
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this e s f national.
	 *
	 * @return the user ID of this e s f national
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this e s f national.
	 *
	 * @param userId the user ID of this e s f national
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this e s f national.
	 *
	 * @return the user uuid of this e s f national
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this e s f national.
	 *
	 * @param userUuid the user uuid of this e s f national
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this e s f national.
	 *
	 * @return the user name of this e s f national
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this e s f national.
	 *
	 * @param userName the user name of this e s f national
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this e s f national.
	 *
	 * @return the create date of this e s f national
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this e s f national.
	 *
	 * @param createDate the create date of this e s f national
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this e s f national.
	 *
	 * @return the modified date of this e s f national
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this e s f national.
	 *
	 * @param modifiedDate the modified date of this e s f national
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the esf user ID of this e s f national.
	 *
	 * @return the esf user ID of this e s f national
	 */
	public long getEsfUserId();

	/**
	 * Sets the esf user ID of this e s f national.
	 *
	 * @param esfUserId the esf user ID of this e s f national
	 */
	public void setEsfUserId(long esfUserId);

	/**
	 * Returns the esf user uuid of this e s f national.
	 *
	 * @return the esf user uuid of this e s f national
	 * @throws SystemException if a system exception occurred
	 */
	public String getEsfUserUuid() throws SystemException;

	/**
	 * Sets the esf user uuid of this e s f national.
	 *
	 * @param esfUserUuid the esf user uuid of this e s f national
	 */
	public void setEsfUserUuid(String esfUserUuid);

	/**
	 * Returns the esf sport type ID of this e s f national.
	 *
	 * @return the esf sport type ID of this e s f national
	 */
	public long getEsfSportTypeId();

	/**
	 * Sets the esf sport type ID of this e s f national.
	 *
	 * @param esfSportTypeId the esf sport type ID of this e s f national
	 */
	public void setEsfSportTypeId(long esfSportTypeId);

	/**
	 * Returns the start date of this e s f national.
	 *
	 * @return the start date of this e s f national
	 */
	public Date getStartDate();

	/**
	 * Sets the start date of this e s f national.
	 *
	 * @param startDate the start date of this e s f national
	 */
	public void setStartDate(Date startDate);

	/**
	 * Returns the end date of this e s f national.
	 *
	 * @return the end date of this e s f national
	 */
	public Date getEndDate();

	/**
	 * Sets the end date of this e s f national.
	 *
	 * @param endDate the end date of this e s f national
	 */
	public void setEndDate(Date endDate);

	/**
	 * Returns the b d o date of this e s f national.
	 *
	 * @return the b d o date of this e s f national
	 */
	public Date getBDODate();

	/**
	 * Sets the b d o date of this e s f national.
	 *
	 * @param BDODate the b d o date of this e s f national
	 */
	public void setBDODate(Date BDODate);

	/**
	 * Returns the id international of this e s f national.
	 *
	 * @return the id international of this e s f national
	 */
	@AutoEscape
	public String getIdInternational();

	/**
	 * Sets the id international of this e s f national.
	 *
	 * @param idInternational the id international of this e s f national
	 */
	public void setIdInternational(String idInternational);

	/**
	 * Returns the is university of this e s f national.
	 *
	 * @return the is university of this e s f national
	 */
	public boolean getIsUniversity();

	/**
	 * Returns <code>true</code> if this e s f national is is university.
	 *
	 * @return <code>true</code> if this e s f national is is university; <code>false</code> otherwise
	 */
	public boolean isIsUniversity();

	/**
	 * Sets whether this e s f national is is university.
	 *
	 * @param isUniversity the is university of this e s f national
	 */
	public void setIsUniversity(boolean isUniversity);

	/**
	 * Returns the is national of this e s f national.
	 *
	 * @return the is national of this e s f national
	 */
	public boolean getIsNational();

	/**
	 * Returns <code>true</code> if this e s f national is is national.
	 *
	 * @return <code>true</code> if this e s f national is is national; <code>false</code> otherwise
	 */
	public boolean isIsNational();

	/**
	 * Sets whether this e s f national is is national.
	 *
	 * @param isNational the is national of this e s f national
	 */
	public void setIsNational(boolean isNational);

	/**
	 * Returns the deliberate of this e s f national.
	 *
	 * @return the deliberate of this e s f national
	 */
	@AutoEscape
	public String getDeliberate();

	/**
	 * Sets the deliberate of this e s f national.
	 *
	 * @param deliberate the deliberate of this e s f national
	 */
	public void setDeliberate(String deliberate);

	/**
	 * Returns the deliberate date of this e s f national.
	 *
	 * @return the deliberate date of this e s f national
	 */
	public Date getDeliberateDate();

	/**
	 * Sets the deliberate date of this e s f national.
	 *
	 * @param deliberateDate the deliberate date of this e s f national
	 */
	public void setDeliberateDate(Date deliberateDate);

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
	public int compareTo(ESFNational esfNational);

	@Override
	public int hashCode();

	@Override
	public CacheModel<ESFNational> toCacheModel();

	@Override
	public ESFNational toEscapedModel();

	@Override
	public ESFNational toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}