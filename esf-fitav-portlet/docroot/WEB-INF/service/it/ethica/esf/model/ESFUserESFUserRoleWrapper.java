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
 * This class is a wrapper for {@link ESFUserESFUserRole}.
 * </p>
 *
 * @author Ethica
 * @see ESFUserESFUserRole
 * @generated
 */
public class ESFUserESFUserRoleWrapper implements ESFUserESFUserRole,
	ModelWrapper<ESFUserESFUserRole> {
	public ESFUserESFUserRoleWrapper(ESFUserESFUserRole esfUserESFUserRole) {
		_esfUserESFUserRole = esfUserESFUserRole;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFUserESFUserRole.class;
	}

	@Override
	public String getModelClassName() {
		return ESFUserESFUserRole.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfUserRoleId", getEsfUserRoleId());
		attributes.put("esfUserId", getEsfUserId());
		attributes.put("esfOrganizationId", getEsfOrganizationId());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfUserRoleId = (Long)attributes.get("esfUserRoleId");

		if (esfUserRoleId != null) {
			setEsfUserRoleId(esfUserRoleId);
		}

		Long esfUserId = (Long)attributes.get("esfUserId");

		if (esfUserId != null) {
			setEsfUserId(esfUserId);
		}

		Long esfOrganizationId = (Long)attributes.get("esfOrganizationId");

		if (esfOrganizationId != null) {
			setEsfOrganizationId(esfOrganizationId);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}
	}

	/**
	* Returns the primary key of this e s f user e s f user role.
	*
	* @return the primary key of this e s f user e s f user role
	*/
	@Override
	public it.ethica.esf.service.persistence.ESFUserESFUserRolePK getPrimaryKey() {
		return _esfUserESFUserRole.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f user e s f user role.
	*
	* @param primaryKey the primary key of this e s f user e s f user role
	*/
	@Override
	public void setPrimaryKey(
		it.ethica.esf.service.persistence.ESFUserESFUserRolePK primaryKey) {
		_esfUserESFUserRole.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf user role ID of this e s f user e s f user role.
	*
	* @return the esf user role ID of this e s f user e s f user role
	*/
	@Override
	public long getEsfUserRoleId() {
		return _esfUserESFUserRole.getEsfUserRoleId();
	}

	/**
	* Sets the esf user role ID of this e s f user e s f user role.
	*
	* @param esfUserRoleId the esf user role ID of this e s f user e s f user role
	*/
	@Override
	public void setEsfUserRoleId(long esfUserRoleId) {
		_esfUserESFUserRole.setEsfUserRoleId(esfUserRoleId);
	}

	/**
	* Returns the esf user ID of this e s f user e s f user role.
	*
	* @return the esf user ID of this e s f user e s f user role
	*/
	@Override
	public long getEsfUserId() {
		return _esfUserESFUserRole.getEsfUserId();
	}

	/**
	* Sets the esf user ID of this e s f user e s f user role.
	*
	* @param esfUserId the esf user ID of this e s f user e s f user role
	*/
	@Override
	public void setEsfUserId(long esfUserId) {
		_esfUserESFUserRole.setEsfUserId(esfUserId);
	}

	/**
	* Returns the esf user uuid of this e s f user e s f user role.
	*
	* @return the esf user uuid of this e s f user e s f user role
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getEsfUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfUserESFUserRole.getEsfUserUuid();
	}

	/**
	* Sets the esf user uuid of this e s f user e s f user role.
	*
	* @param esfUserUuid the esf user uuid of this e s f user e s f user role
	*/
	@Override
	public void setEsfUserUuid(java.lang.String esfUserUuid) {
		_esfUserESFUserRole.setEsfUserUuid(esfUserUuid);
	}

	/**
	* Returns the esf organization ID of this e s f user e s f user role.
	*
	* @return the esf organization ID of this e s f user e s f user role
	*/
	@Override
	public long getEsfOrganizationId() {
		return _esfUserESFUserRole.getEsfOrganizationId();
	}

	/**
	* Sets the esf organization ID of this e s f user e s f user role.
	*
	* @param esfOrganizationId the esf organization ID of this e s f user e s f user role
	*/
	@Override
	public void setEsfOrganizationId(long esfOrganizationId) {
		_esfUserESFUserRole.setEsfOrganizationId(esfOrganizationId);
	}

	/**
	* Returns the start date of this e s f user e s f user role.
	*
	* @return the start date of this e s f user e s f user role
	*/
	@Override
	public java.util.Date getStartDate() {
		return _esfUserESFUserRole.getStartDate();
	}

	/**
	* Sets the start date of this e s f user e s f user role.
	*
	* @param startDate the start date of this e s f user e s f user role
	*/
	@Override
	public void setStartDate(java.util.Date startDate) {
		_esfUserESFUserRole.setStartDate(startDate);
	}

	/**
	* Returns the end date of this e s f user e s f user role.
	*
	* @return the end date of this e s f user e s f user role
	*/
	@Override
	public java.util.Date getEndDate() {
		return _esfUserESFUserRole.getEndDate();
	}

	/**
	* Sets the end date of this e s f user e s f user role.
	*
	* @param endDate the end date of this e s f user e s f user role
	*/
	@Override
	public void setEndDate(java.util.Date endDate) {
		_esfUserESFUserRole.setEndDate(endDate);
	}

	@Override
	public boolean isNew() {
		return _esfUserESFUserRole.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfUserESFUserRole.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfUserESFUserRole.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfUserESFUserRole.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfUserESFUserRole.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfUserESFUserRole.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfUserESFUserRole.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfUserESFUserRole.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfUserESFUserRole.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfUserESFUserRole.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfUserESFUserRole.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFUserESFUserRoleWrapper((ESFUserESFUserRole)_esfUserESFUserRole.clone());
	}

	@Override
	public int compareTo(
		it.ethica.esf.model.ESFUserESFUserRole esfUserESFUserRole) {
		return _esfUserESFUserRole.compareTo(esfUserESFUserRole);
	}

	@Override
	public int hashCode() {
		return _esfUserESFUserRole.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFUserESFUserRole> toCacheModel() {
		return _esfUserESFUserRole.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFUserESFUserRole toEscapedModel() {
		return new ESFUserESFUserRoleWrapper(_esfUserESFUserRole.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFUserESFUserRole toUnescapedModel() {
		return new ESFUserESFUserRoleWrapper(_esfUserESFUserRole.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfUserESFUserRole.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfUserESFUserRole.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfUserESFUserRole.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFUserESFUserRoleWrapper)) {
			return false;
		}

		ESFUserESFUserRoleWrapper esfUserESFUserRoleWrapper = (ESFUserESFUserRoleWrapper)obj;

		if (Validator.equals(_esfUserESFUserRole,
					esfUserESFUserRoleWrapper._esfUserESFUserRole)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFUserESFUserRole getWrappedESFUserESFUserRole() {
		return _esfUserESFUserRole;
	}

	@Override
	public ESFUserESFUserRole getWrappedModel() {
		return _esfUserESFUserRole;
	}

	@Override
	public void resetOriginalValues() {
		_esfUserESFUserRole.resetOriginalValues();
	}

	private ESFUserESFUserRole _esfUserESFUserRole;
}