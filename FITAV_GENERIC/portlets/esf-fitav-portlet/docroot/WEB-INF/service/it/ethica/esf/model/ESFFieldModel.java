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
 * The base model interface for the ESFField service. Represents a row in the &quot;ESFField&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.ethica.esf.model.impl.ESFFieldModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.ethica.esf.model.impl.ESFFieldImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFField
 * @see it.ethica.esf.model.impl.ESFFieldImpl
 * @see it.ethica.esf.model.impl.ESFFieldModelImpl
 * @generated
 */
public interface ESFFieldModel extends BaseModel<ESFField>, StagedGroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a e s f field model instance should use the {@link ESFField} interface instead.
	 */

	/**
	 * Returns the primary key of this e s f field.
	 *
	 * @return the primary key of this e s f field
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this e s f field.
	 *
	 * @param primaryKey the primary key of this e s f field
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this e s f field.
	 *
	 * @return the uuid of this e s f field
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this e s f field.
	 *
	 * @param uuid the uuid of this e s f field
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the esf field ID of this e s f field.
	 *
	 * @return the esf field ID of this e s f field
	 */
	public long getEsfFieldId();

	/**
	 * Sets the esf field ID of this e s f field.
	 *
	 * @param esfFieldId the esf field ID of this e s f field
	 */
	public void setEsfFieldId(long esfFieldId);

	/**
	 * Returns the group ID of this e s f field.
	 *
	 * @return the group ID of this e s f field
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this e s f field.
	 *
	 * @param groupId the group ID of this e s f field
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this e s f field.
	 *
	 * @return the company ID of this e s f field
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this e s f field.
	 *
	 * @param companyId the company ID of this e s f field
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this e s f field.
	 *
	 * @return the user ID of this e s f field
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this e s f field.
	 *
	 * @param userId the user ID of this e s f field
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this e s f field.
	 *
	 * @return the user uuid of this e s f field
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this e s f field.
	 *
	 * @param userUuid the user uuid of this e s f field
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this e s f field.
	 *
	 * @return the user name of this e s f field
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this e s f field.
	 *
	 * @param userName the user name of this e s f field
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this e s f field.
	 *
	 * @return the create date of this e s f field
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this e s f field.
	 *
	 * @param createDate the create date of this e s f field
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this e s f field.
	 *
	 * @return the modified date of this e s f field
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this e s f field.
	 *
	 * @param modifiedDate the modified date of this e s f field
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this e s f field.
	 *
	 * @return the name of this e s f field
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this e s f field.
	 *
	 * @param name the name of this e s f field
	 */
	public void setName(String name);

	/**
	 * Returns the owner organization ID of this e s f field.
	 *
	 * @return the owner organization ID of this e s f field
	 */
	public long getOwnerOrganizationId();

	/**
	 * Sets the owner organization ID of this e s f field.
	 *
	 * @param ownerOrganizationId the owner organization ID of this e s f field
	 */
	public void setOwnerOrganizationId(long ownerOrganizationId);

	/**
	 * Returns the esf address ID of this e s f field.
	 *
	 * @return the esf address ID of this e s f field
	 */
	public long getEsfAddressId();

	/**
	 * Sets the esf address ID of this e s f field.
	 *
	 * @param esfAddressId the esf address ID of this e s f field
	 */
	public void setEsfAddressId(long esfAddressId);

	/**
	 * Returns the billboard of this e s f field.
	 *
	 * @return the billboard of this e s f field
	 */
	public long getBillboard();

	/**
	 * Sets the billboard of this e s f field.
	 *
	 * @param billboard the billboard of this e s f field
	 */
	public void setBillboard(long billboard);

	/**
	 * Returns the billboard stations of this e s f field.
	 *
	 * @return the billboard stations of this e s f field
	 */
	public boolean getBillboardStations();

	/**
	 * Returns <code>true</code> if this e s f field is billboard stations.
	 *
	 * @return <code>true</code> if this e s f field is billboard stations; <code>false</code> otherwise
	 */
	public boolean isBillboardStations();

	/**
	 * Sets whether this e s f field is billboard stations.
	 *
	 * @param billboardStations the billboard stations of this e s f field
	 */
	public void setBillboardStations(boolean billboardStations);

	/**
	 * Returns the background rampart of this e s f field.
	 *
	 * @return the background rampart of this e s f field
	 */
	public boolean getBackgroundRampart();

	/**
	 * Returns <code>true</code> if this e s f field is background rampart.
	 *
	 * @return <code>true</code> if this e s f field is background rampart; <code>false</code> otherwise
	 */
	public boolean isBackgroundRampart();

	/**
	 * Sets whether this e s f field is background rampart.
	 *
	 * @param backgroundRampart the background rampart of this e s f field
	 */
	public void setBackgroundRampart(boolean backgroundRampart);

	/**
	 * Returns the background net of this e s f field.
	 *
	 * @return the background net of this e s f field
	 */
	public boolean getBackgroundNet();

	/**
	 * Returns <code>true</code> if this e s f field is background net.
	 *
	 * @return <code>true</code> if this e s f field is background net; <code>false</code> otherwise
	 */
	public boolean isBackgroundNet();

	/**
	 * Sets whether this e s f field is background net.
	 *
	 * @param backgroundNet the background net of this e s f field
	 */
	public void setBackgroundNet(boolean backgroundNet);

	/**
	 * Returns the background lead recovery of this e s f field.
	 *
	 * @return the background lead recovery of this e s f field
	 */
	public boolean getBackgroundLeadRecovery();

	/**
	 * Returns <code>true</code> if this e s f field is background lead recovery.
	 *
	 * @return <code>true</code> if this e s f field is background lead recovery; <code>false</code> otherwise
	 */
	public boolean isBackgroundLeadRecovery();

	/**
	 * Sets whether this e s f field is background lead recovery.
	 *
	 * @param backgroundLeadRecovery the background lead recovery of this e s f field
	 */
	public void setBackgroundLeadRecovery(boolean backgroundLeadRecovery);

	/**
	 * Returns the disabled access of this e s f field.
	 *
	 * @return the disabled access of this e s f field
	 */
	public boolean getDisabledAccess();

	/**
	 * Returns <code>true</code> if this e s f field is disabled access.
	 *
	 * @return <code>true</code> if this e s f field is disabled access; <code>false</code> otherwise
	 */
	public boolean isDisabledAccess();

	/**
	 * Sets whether this e s f field is disabled access.
	 *
	 * @param disabledAccess the disabled access of this e s f field
	 */
	public void setDisabledAccess(boolean disabledAccess);

	/**
	 * Returns the note of this e s f field.
	 *
	 * @return the note of this e s f field
	 */
	@AutoEscape
	public String getNote();

	/**
	 * Sets the note of this e s f field.
	 *
	 * @param note the note of this e s f field
	 */
	public void setNote(String note);

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
	public int compareTo(ESFField esfField);

	@Override
	public int hashCode();

	@Override
	public CacheModel<ESFField> toCacheModel();

	@Override
	public ESFField toEscapedModel();

	@Override
	public ESFField toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}