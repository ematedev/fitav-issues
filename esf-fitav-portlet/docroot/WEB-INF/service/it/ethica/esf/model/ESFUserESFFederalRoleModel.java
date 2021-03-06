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
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import it.ethica.esf.service.persistence.ESFUserESFFederalRolePK;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ESFUserESFFederalRole service. Represents a row in the &quot;ESFUserESFFederalRole&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.ethica.esf.model.impl.ESFUserESFFederalRoleModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.ethica.esf.model.impl.ESFUserESFFederalRoleImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFUserESFFederalRole
 * @see it.ethica.esf.model.impl.ESFUserESFFederalRoleImpl
 * @see it.ethica.esf.model.impl.ESFUserESFFederalRoleModelImpl
 * @generated
 */
public interface ESFUserESFFederalRoleModel extends BaseModel<ESFUserESFFederalRole> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a e s f user e s f federal role model instance should use the {@link ESFUserESFFederalRole} interface instead.
	 */

	/**
	 * Returns the primary key of this e s f user e s f federal role.
	 *
	 * @return the primary key of this e s f user e s f federal role
	 */
	public ESFUserESFFederalRolePK getPrimaryKey();

	/**
	 * Sets the primary key of this e s f user e s f federal role.
	 *
	 * @param primaryKey the primary key of this e s f user e s f federal role
	 */
	public void setPrimaryKey(ESFUserESFFederalRolePK primaryKey);

	/**
	 * Returns the esf user ID of this e s f user e s f federal role.
	 *
	 * @return the esf user ID of this e s f user e s f federal role
	 */
	public long getEsfUserId();

	/**
	 * Sets the esf user ID of this e s f user e s f federal role.
	 *
	 * @param esfUserId the esf user ID of this e s f user e s f federal role
	 */
	public void setEsfUserId(long esfUserId);

	/**
	 * Returns the esf user uuid of this e s f user e s f federal role.
	 *
	 * @return the esf user uuid of this e s f user e s f federal role
	 * @throws SystemException if a system exception occurred
	 */
	public String getEsfUserUuid() throws SystemException;

	/**
	 * Sets the esf user uuid of this e s f user e s f federal role.
	 *
	 * @param esfUserUuid the esf user uuid of this e s f user e s f federal role
	 */
	public void setEsfUserUuid(String esfUserUuid);

	/**
	 * Returns the esf federal role ID of this e s f user e s f federal role.
	 *
	 * @return the esf federal role ID of this e s f user e s f federal role
	 */
	public long getEsfFederalRoleId();

	/**
	 * Sets the esf federal role ID of this e s f user e s f federal role.
	 *
	 * @param esfFederalRoleId the esf federal role ID of this e s f user e s f federal role
	 */
	public void setEsfFederalRoleId(long esfFederalRoleId);

	/**
	 * Returns the start date of this e s f user e s f federal role.
	 *
	 * @return the start date of this e s f user e s f federal role
	 */
	public long getStartDate();

	/**
	 * Sets the start date of this e s f user e s f federal role.
	 *
	 * @param startDate the start date of this e s f user e s f federal role
	 */
	public void setStartDate(long startDate);

	/**
	 * Returns the end date of this e s f user e s f federal role.
	 *
	 * @return the end date of this e s f user e s f federal role
	 */
	public Date getEndDate();

	/**
	 * Sets the end date of this e s f user e s f federal role.
	 *
	 * @param endDate the end date of this e s f user e s f federal role
	 */
	public void setEndDate(Date endDate);

	/**
	 * Returns the modified date of this e s f user e s f federal role.
	 *
	 * @return the modified date of this e s f user e s f federal role
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this e s f user e s f federal role.
	 *
	 * @param modifiedDate the modified date of this e s f user e s f federal role
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the active of this e s f user e s f federal role.
	 *
	 * @return the active of this e s f user e s f federal role
	 */
	public boolean getActive();

	/**
	 * Returns <code>true</code> if this e s f user e s f federal role is active.
	 *
	 * @return <code>true</code> if this e s f user e s f federal role is active; <code>false</code> otherwise
	 */
	public boolean isActive();

	/**
	 * Sets whether this e s f user e s f federal role is active.
	 *
	 * @param active the active of this e s f user e s f federal role
	 */
	public void setActive(boolean active);

	/**
	 * Returns the esf specific ID of this e s f user e s f federal role.
	 *
	 * @return the esf specific ID of this e s f user e s f federal role
	 */
	public long getEsfSpecificId();

	/**
	 * Sets the esf specific ID of this e s f user e s f federal role.
	 *
	 * @param esfSpecificId the esf specific ID of this e s f user e s f federal role
	 */
	public void setEsfSpecificId(long esfSpecificId);

	/**
	 * Returns the region ID of this e s f user e s f federal role.
	 *
	 * @return the region ID of this e s f user e s f federal role
	 */
	@AutoEscape
	public String getRegionId();

	/**
	 * Sets the region ID of this e s f user e s f federal role.
	 *
	 * @param regionId the region ID of this e s f user e s f federal role
	 */
	public void setRegionId(String regionId);

	/**
	 * Returns the province ID of this e s f user e s f federal role.
	 *
	 * @return the province ID of this e s f user e s f federal role
	 */
	@AutoEscape
	public String getProvinceId();

	/**
	 * Sets the province ID of this e s f user e s f federal role.
	 *
	 * @param provinceId the province ID of this e s f user e s f federal role
	 */
	public void setProvinceId(String provinceId);

	/**
	 * Returns the notes of this e s f user e s f federal role.
	 *
	 * @return the notes of this e s f user e s f federal role
	 */
	@AutoEscape
	public String getNotes();

	/**
	 * Sets the notes of this e s f user e s f federal role.
	 *
	 * @param notes the notes of this e s f user e s f federal role
	 */
	public void setNotes(String notes);

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
		it.ethica.esf.model.ESFUserESFFederalRole esfUserESFFederalRole);

	@Override
	public int hashCode();

	@Override
	public CacheModel<it.ethica.esf.model.ESFUserESFFederalRole> toCacheModel();

	@Override
	public it.ethica.esf.model.ESFUserESFFederalRole toEscapedModel();

	@Override
	public it.ethica.esf.model.ESFUserESFFederalRole toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}