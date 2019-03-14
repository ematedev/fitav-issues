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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ESFFederalRoleESFSpecific}.
 * </p>
 *
 * @author Ethica
 * @see ESFFederalRoleESFSpecific
 * @generated
 */
public class ESFFederalRoleESFSpecificWrapper
	implements ESFFederalRoleESFSpecific,
		ModelWrapper<ESFFederalRoleESFSpecific> {
	public ESFFederalRoleESFSpecificWrapper(
		ESFFederalRoleESFSpecific esfFederalRoleESFSpecific) {
		_esfFederalRoleESFSpecific = esfFederalRoleESFSpecific;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFFederalRoleESFSpecific.class;
	}

	@Override
	public String getModelClassName() {
		return ESFFederalRoleESFSpecific.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfSpecificId", getEsfSpecificId());
		attributes.put("esfFederalRoleId", getEsfFederalRoleId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfSpecificId = (Long)attributes.get("esfSpecificId");

		if (esfSpecificId != null) {
			setEsfSpecificId(esfSpecificId);
		}

		Long esfFederalRoleId = (Long)attributes.get("esfFederalRoleId");

		if (esfFederalRoleId != null) {
			setEsfFederalRoleId(esfFederalRoleId);
		}
	}

	/**
	* Returns the primary key of this e s f federal role e s f specific.
	*
	* @return the primary key of this e s f federal role e s f specific
	*/
	@Override
	public it.ethica.esf.service.persistence.ESFFederalRoleESFSpecificPK getPrimaryKey() {
		return _esfFederalRoleESFSpecific.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f federal role e s f specific.
	*
	* @param primaryKey the primary key of this e s f federal role e s f specific
	*/
	@Override
	public void setPrimaryKey(
		it.ethica.esf.service.persistence.ESFFederalRoleESFSpecificPK primaryKey) {
		_esfFederalRoleESFSpecific.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this e s f federal role e s f specific.
	*
	* @return the uuid of this e s f federal role e s f specific
	*/
	@Override
	public java.lang.String getUuid() {
		return _esfFederalRoleESFSpecific.getUuid();
	}

	/**
	* Sets the uuid of this e s f federal role e s f specific.
	*
	* @param uuid the uuid of this e s f federal role e s f specific
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_esfFederalRoleESFSpecific.setUuid(uuid);
	}

	/**
	* Returns the esf specific ID of this e s f federal role e s f specific.
	*
	* @return the esf specific ID of this e s f federal role e s f specific
	*/
	@Override
	public long getEsfSpecificId() {
		return _esfFederalRoleESFSpecific.getEsfSpecificId();
	}

	/**
	* Sets the esf specific ID of this e s f federal role e s f specific.
	*
	* @param esfSpecificId the esf specific ID of this e s f federal role e s f specific
	*/
	@Override
	public void setEsfSpecificId(long esfSpecificId) {
		_esfFederalRoleESFSpecific.setEsfSpecificId(esfSpecificId);
	}

	/**
	* Returns the esf federal role ID of this e s f federal role e s f specific.
	*
	* @return the esf federal role ID of this e s f federal role e s f specific
	*/
	@Override
	public long getEsfFederalRoleId() {
		return _esfFederalRoleESFSpecific.getEsfFederalRoleId();
	}

	/**
	* Sets the esf federal role ID of this e s f federal role e s f specific.
	*
	* @param esfFederalRoleId the esf federal role ID of this e s f federal role e s f specific
	*/
	@Override
	public void setEsfFederalRoleId(long esfFederalRoleId) {
		_esfFederalRoleESFSpecific.setEsfFederalRoleId(esfFederalRoleId);
	}

	@Override
	public boolean isNew() {
		return _esfFederalRoleESFSpecific.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfFederalRoleESFSpecific.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfFederalRoleESFSpecific.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfFederalRoleESFSpecific.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfFederalRoleESFSpecific.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfFederalRoleESFSpecific.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfFederalRoleESFSpecific.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfFederalRoleESFSpecific.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfFederalRoleESFSpecific.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfFederalRoleESFSpecific.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfFederalRoleESFSpecific.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFFederalRoleESFSpecificWrapper((ESFFederalRoleESFSpecific)_esfFederalRoleESFSpecific.clone());
	}

	@Override
	public int compareTo(
		it.ethica.esf.model.ESFFederalRoleESFSpecific esfFederalRoleESFSpecific) {
		return _esfFederalRoleESFSpecific.compareTo(esfFederalRoleESFSpecific);
	}

	@Override
	public int hashCode() {
		return _esfFederalRoleESFSpecific.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFFederalRoleESFSpecific> toCacheModel() {
		return _esfFederalRoleESFSpecific.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFFederalRoleESFSpecific toEscapedModel() {
		return new ESFFederalRoleESFSpecificWrapper(_esfFederalRoleESFSpecific.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFFederalRoleESFSpecific toUnescapedModel() {
		return new ESFFederalRoleESFSpecificWrapper(_esfFederalRoleESFSpecific.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfFederalRoleESFSpecific.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfFederalRoleESFSpecific.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfFederalRoleESFSpecific.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFFederalRoleESFSpecificWrapper)) {
			return false;
		}

		ESFFederalRoleESFSpecificWrapper esfFederalRoleESFSpecificWrapper = (ESFFederalRoleESFSpecificWrapper)obj;

		if (Validator.equals(_esfFederalRoleESFSpecific,
					esfFederalRoleESFSpecificWrapper._esfFederalRoleESFSpecific)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFFederalRoleESFSpecific getWrappedESFFederalRoleESFSpecific() {
		return _esfFederalRoleESFSpecific;
	}

	@Override
	public ESFFederalRoleESFSpecific getWrappedModel() {
		return _esfFederalRoleESFSpecific;
	}

	@Override
	public void resetOriginalValues() {
		_esfFederalRoleESFSpecific.resetOriginalValues();
	}

	private ESFFederalRoleESFSpecific _esfFederalRoleESFSpecific;
}