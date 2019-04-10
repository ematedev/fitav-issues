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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ESFUserESFFederalRole}.
 * </p>
 *
 * @author Ethica
 * @see ESFUserESFFederalRole
 * @generated
 */
public class ESFUserESFFederalRoleWrapper implements ESFUserESFFederalRole,
	ModelWrapper<ESFUserESFFederalRole> {
	public ESFUserESFFederalRoleWrapper(
		ESFUserESFFederalRole esfUserESFFederalRole) {
		_esfUserESFFederalRole = esfUserESFFederalRole;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFUserESFFederalRole.class;
	}

	@Override
	public String getModelClassName() {
		return ESFUserESFFederalRole.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfUserId", getEsfUserId());
		attributes.put("esfFederalRoleId", getEsfFederalRoleId());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("active", getActive());
		attributes.put("esfSpecificId", getEsfSpecificId());
		attributes.put("regionId", getRegionId());
		attributes.put("provinceId", getProvinceId());
		attributes.put("notes", getNotes());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfUserId = (Long)attributes.get("esfUserId");

		if (esfUserId != null) {
			setEsfUserId(esfUserId);
		}

		Long esfFederalRoleId = (Long)attributes.get("esfFederalRoleId");

		if (esfFederalRoleId != null) {
			setEsfFederalRoleId(esfFederalRoleId);
		}

		Long startDate = (Long)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Long esfSpecificId = (Long)attributes.get("esfSpecificId");

		if (esfSpecificId != null) {
			setEsfSpecificId(esfSpecificId);
		}

		String regionId = (String)attributes.get("regionId");

		if (regionId != null) {
			setRegionId(regionId);
		}

		String provinceId = (String)attributes.get("provinceId");

		if (provinceId != null) {
			setProvinceId(provinceId);
		}

		String notes = (String)attributes.get("notes");

		if (notes != null) {
			setNotes(notes);
		}
	}

	/**
	* Returns the primary key of this e s f user e s f federal role.
	*
	* @return the primary key of this e s f user e s f federal role
	*/
	@Override
	public it.ethica.esf.service.persistence.ESFUserESFFederalRolePK getPrimaryKey() {
		return _esfUserESFFederalRole.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f user e s f federal role.
	*
	* @param primaryKey the primary key of this e s f user e s f federal role
	*/
	@Override
	public void setPrimaryKey(
		it.ethica.esf.service.persistence.ESFUserESFFederalRolePK primaryKey) {
		_esfUserESFFederalRole.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf user ID of this e s f user e s f federal role.
	*
	* @return the esf user ID of this e s f user e s f federal role
	*/
	@Override
	public long getEsfUserId() {
		return _esfUserESFFederalRole.getEsfUserId();
	}

	/**
	* Sets the esf user ID of this e s f user e s f federal role.
	*
	* @param esfUserId the esf user ID of this e s f user e s f federal role
	*/
	@Override
	public void setEsfUserId(long esfUserId) {
		_esfUserESFFederalRole.setEsfUserId(esfUserId);
	}

	/**
	* Returns the esf user uuid of this e s f user e s f federal role.
	*
	* @return the esf user uuid of this e s f user e s f federal role
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getEsfUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfUserESFFederalRole.getEsfUserUuid();
	}

	/**
	* Sets the esf user uuid of this e s f user e s f federal role.
	*
	* @param esfUserUuid the esf user uuid of this e s f user e s f federal role
	*/
	@Override
	public void setEsfUserUuid(java.lang.String esfUserUuid) {
		_esfUserESFFederalRole.setEsfUserUuid(esfUserUuid);
	}

	/**
	* Returns the esf federal role ID of this e s f user e s f federal role.
	*
	* @return the esf federal role ID of this e s f user e s f federal role
	*/
	@Override
	public long getEsfFederalRoleId() {
		return _esfUserESFFederalRole.getEsfFederalRoleId();
	}

	/**
	* Sets the esf federal role ID of this e s f user e s f federal role.
	*
	* @param esfFederalRoleId the esf federal role ID of this e s f user e s f federal role
	*/
	@Override
	public void setEsfFederalRoleId(long esfFederalRoleId) {
		_esfUserESFFederalRole.setEsfFederalRoleId(esfFederalRoleId);
	}

	/**
	* Returns the start date of this e s f user e s f federal role.
	*
	* @return the start date of this e s f user e s f federal role
	*/
	@Override
	public long getStartDate() {
		return _esfUserESFFederalRole.getStartDate();
	}

	/**
	* Sets the start date of this e s f user e s f federal role.
	*
	* @param startDate the start date of this e s f user e s f federal role
	*/
	@Override
	public void setStartDate(long startDate) {
		_esfUserESFFederalRole.setStartDate(startDate);
	}

	/**
	* Returns the end date of this e s f user e s f federal role.
	*
	* @return the end date of this e s f user e s f federal role
	*/
	@Override
	public java.util.Date getEndDate() {
		return _esfUserESFFederalRole.getEndDate();
	}

	/**
	* Sets the end date of this e s f user e s f federal role.
	*
	* @param endDate the end date of this e s f user e s f federal role
	*/
	@Override
	public void setEndDate(java.util.Date endDate) {
		_esfUserESFFederalRole.setEndDate(endDate);
	}

	/**
	* Returns the modified date of this e s f user e s f federal role.
	*
	* @return the modified date of this e s f user e s f federal role
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfUserESFFederalRole.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f user e s f federal role.
	*
	* @param modifiedDate the modified date of this e s f user e s f federal role
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfUserESFFederalRole.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the active of this e s f user e s f federal role.
	*
	* @return the active of this e s f user e s f federal role
	*/
	@Override
	public boolean getActive() {
		return _esfUserESFFederalRole.getActive();
	}

	/**
	* Returns <code>true</code> if this e s f user e s f federal role is active.
	*
	* @return <code>true</code> if this e s f user e s f federal role is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isActive() {
		return _esfUserESFFederalRole.isActive();
	}

	/**
	* Sets whether this e s f user e s f federal role is active.
	*
	* @param active the active of this e s f user e s f federal role
	*/
	@Override
	public void setActive(boolean active) {
		_esfUserESFFederalRole.setActive(active);
	}

	/**
	* Returns the esf specific ID of this e s f user e s f federal role.
	*
	* @return the esf specific ID of this e s f user e s f federal role
	*/
	@Override
	public long getEsfSpecificId() {
		return _esfUserESFFederalRole.getEsfSpecificId();
	}

	/**
	* Sets the esf specific ID of this e s f user e s f federal role.
	*
	* @param esfSpecificId the esf specific ID of this e s f user e s f federal role
	*/
	@Override
	public void setEsfSpecificId(long esfSpecificId) {
		_esfUserESFFederalRole.setEsfSpecificId(esfSpecificId);
	}

	/**
	* Returns the region ID of this e s f user e s f federal role.
	*
	* @return the region ID of this e s f user e s f federal role
	*/
	@Override
	public java.lang.String getRegionId() {
		return _esfUserESFFederalRole.getRegionId();
	}

	/**
	* Sets the region ID of this e s f user e s f federal role.
	*
	* @param regionId the region ID of this e s f user e s f federal role
	*/
	@Override
	public void setRegionId(java.lang.String regionId) {
		_esfUserESFFederalRole.setRegionId(regionId);
	}

	/**
	* Returns the province ID of this e s f user e s f federal role.
	*
	* @return the province ID of this e s f user e s f federal role
	*/
	@Override
	public java.lang.String getProvinceId() {
		return _esfUserESFFederalRole.getProvinceId();
	}

	/**
	* Sets the province ID of this e s f user e s f federal role.
	*
	* @param provinceId the province ID of this e s f user e s f federal role
	*/
	@Override
	public void setProvinceId(java.lang.String provinceId) {
		_esfUserESFFederalRole.setProvinceId(provinceId);
	}

	/**
	* Returns the notes of this e s f user e s f federal role.
	*
	* @return the notes of this e s f user e s f federal role
	*/
	@Override
	public java.lang.String getNotes() {
		return _esfUserESFFederalRole.getNotes();
	}

	/**
	* Sets the notes of this e s f user e s f federal role.
	*
	* @param notes the notes of this e s f user e s f federal role
	*/
	@Override
	public void setNotes(java.lang.String notes) {
		_esfUserESFFederalRole.setNotes(notes);
	}

	@Override
	public boolean isNew() {
		return _esfUserESFFederalRole.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfUserESFFederalRole.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfUserESFFederalRole.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfUserESFFederalRole.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfUserESFFederalRole.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfUserESFFederalRole.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfUserESFFederalRole.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfUserESFFederalRole.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfUserESFFederalRole.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfUserESFFederalRole.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfUserESFFederalRole.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFUserESFFederalRoleWrapper((ESFUserESFFederalRole)_esfUserESFFederalRole.clone());
	}

	@Override
	public int compareTo(
		it.ethica.esf.model.ESFUserESFFederalRole esfUserESFFederalRole) {
		return _esfUserESFFederalRole.compareTo(esfUserESFFederalRole);
	}

	@Override
	public int hashCode() {
		return _esfUserESFFederalRole.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFUserESFFederalRole> toCacheModel() {
		return _esfUserESFFederalRole.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFUserESFFederalRole toEscapedModel() {
		return new ESFUserESFFederalRoleWrapper(_esfUserESFFederalRole.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFUserESFFederalRole toUnescapedModel() {
		return new ESFUserESFFederalRoleWrapper(_esfUserESFFederalRole.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfUserESFFederalRole.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfUserESFFederalRole.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfUserESFFederalRole.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFUserESFFederalRoleWrapper)) {
			return false;
		}

		ESFUserESFFederalRoleWrapper esfUserESFFederalRoleWrapper = (ESFUserESFFederalRoleWrapper)obj;

		if (Validator.equals(_esfUserESFFederalRole,
					esfUserESFFederalRoleWrapper._esfUserESFFederalRole)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFUserESFFederalRole getWrappedESFUserESFFederalRole() {
		return _esfUserESFFederalRole;
	}

	@Override
	public ESFUserESFFederalRole getWrappedModel() {
		return _esfUserESFFederalRole;
	}

	@Override
	public void resetOriginalValues() {
		_esfUserESFFederalRole.resetOriginalValues();
	}

	private ESFUserESFFederalRole _esfUserESFFederalRole;
}