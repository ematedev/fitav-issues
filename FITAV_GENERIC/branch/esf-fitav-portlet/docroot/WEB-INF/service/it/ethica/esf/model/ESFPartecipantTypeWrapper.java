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
 * This class is a wrapper for {@link ESFPartecipantType}.
 * </p>
 *
 * @author Ethica
 * @see ESFPartecipantType
 * @generated
 */
public class ESFPartecipantTypeWrapper implements ESFPartecipantType,
	ModelWrapper<ESFPartecipantType> {
	public ESFPartecipantTypeWrapper(ESFPartecipantType esfPartecipantType) {
		_esfPartecipantType = esfPartecipantType;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFPartecipantType.class;
	}

	@Override
	public String getModelClassName() {
		return ESFPartecipantType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfPartecipantTypeId", getEsfPartecipantTypeId());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfPartecipantTypeId = (Long)attributes.get("esfPartecipantTypeId");

		if (esfPartecipantTypeId != null) {
			setEsfPartecipantTypeId(esfPartecipantTypeId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	/**
	* Returns the primary key of this e s f partecipant type.
	*
	* @return the primary key of this e s f partecipant type
	*/
	@Override
	public long getPrimaryKey() {
		return _esfPartecipantType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f partecipant type.
	*
	* @param primaryKey the primary key of this e s f partecipant type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfPartecipantType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf partecipant type ID of this e s f partecipant type.
	*
	* @return the esf partecipant type ID of this e s f partecipant type
	*/
	@Override
	public long getEsfPartecipantTypeId() {
		return _esfPartecipantType.getEsfPartecipantTypeId();
	}

	/**
	* Sets the esf partecipant type ID of this e s f partecipant type.
	*
	* @param esfPartecipantTypeId the esf partecipant type ID of this e s f partecipant type
	*/
	@Override
	public void setEsfPartecipantTypeId(long esfPartecipantTypeId) {
		_esfPartecipantType.setEsfPartecipantTypeId(esfPartecipantTypeId);
	}

	/**
	* Returns the name of this e s f partecipant type.
	*
	* @return the name of this e s f partecipant type
	*/
	@Override
	public java.lang.String getName() {
		return _esfPartecipantType.getName();
	}

	/**
	* Sets the name of this e s f partecipant type.
	*
	* @param name the name of this e s f partecipant type
	*/
	@Override
	public void setName(java.lang.String name) {
		_esfPartecipantType.setName(name);
	}

	@Override
	public boolean isNew() {
		return _esfPartecipantType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfPartecipantType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfPartecipantType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfPartecipantType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfPartecipantType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfPartecipantType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfPartecipantType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfPartecipantType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfPartecipantType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfPartecipantType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfPartecipantType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFPartecipantTypeWrapper((ESFPartecipantType)_esfPartecipantType.clone());
	}

	@Override
	public int compareTo(
		it.ethica.esf.model.ESFPartecipantType esfPartecipantType) {
		return _esfPartecipantType.compareTo(esfPartecipantType);
	}

	@Override
	public int hashCode() {
		return _esfPartecipantType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFPartecipantType> toCacheModel() {
		return _esfPartecipantType.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFPartecipantType toEscapedModel() {
		return new ESFPartecipantTypeWrapper(_esfPartecipantType.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFPartecipantType toUnescapedModel() {
		return new ESFPartecipantTypeWrapper(_esfPartecipantType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfPartecipantType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfPartecipantType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfPartecipantType.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFPartecipantTypeWrapper)) {
			return false;
		}

		ESFPartecipantTypeWrapper esfPartecipantTypeWrapper = (ESFPartecipantTypeWrapper)obj;

		if (Validator.equals(_esfPartecipantType,
					esfPartecipantTypeWrapper._esfPartecipantType)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFPartecipantType getWrappedESFPartecipantType() {
		return _esfPartecipantType;
	}

	@Override
	public ESFPartecipantType getWrappedModel() {
		return _esfPartecipantType;
	}

	@Override
	public void resetOriginalValues() {
		_esfPartecipantType.resetOriginalValues();
	}

	private ESFPartecipantType _esfPartecipantType;
}