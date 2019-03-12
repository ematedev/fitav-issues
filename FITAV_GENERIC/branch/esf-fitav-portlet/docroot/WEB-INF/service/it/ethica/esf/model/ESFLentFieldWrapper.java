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
 * This class is a wrapper for {@link ESFLentField}.
 * </p>
 *
 * @author Ethica
 * @see ESFLentField
 * @generated
 */
public class ESFLentFieldWrapper implements ESFLentField,
	ModelWrapper<ESFLentField> {
	public ESFLentFieldWrapper(ESFLentField esfLentField) {
		_esfLentField = esfLentField;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFLentField.class;
	}

	@Override
	public String getModelClassName() {
		return ESFLentField.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("lentFieldId", getLentFieldId());
		attributes.put("esfEntityStateId", getEsfEntityStateId());
		attributes.put("esfFieldId", getEsfFieldId());
		attributes.put("realOwnerId", getRealOwnerId());
		attributes.put("actualOwnerId", getActualOwnerId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long lentFieldId = (Long)attributes.get("lentFieldId");

		if (lentFieldId != null) {
			setLentFieldId(lentFieldId);
		}

		Long esfEntityStateId = (Long)attributes.get("esfEntityStateId");

		if (esfEntityStateId != null) {
			setEsfEntityStateId(esfEntityStateId);
		}

		Long esfFieldId = (Long)attributes.get("esfFieldId");

		if (esfFieldId != null) {
			setEsfFieldId(esfFieldId);
		}

		Long realOwnerId = (Long)attributes.get("realOwnerId");

		if (realOwnerId != null) {
			setRealOwnerId(realOwnerId);
		}

		Long actualOwnerId = (Long)attributes.get("actualOwnerId");

		if (actualOwnerId != null) {
			setActualOwnerId(actualOwnerId);
		}
	}

	/**
	* Returns the primary key of this e s f lent field.
	*
	* @return the primary key of this e s f lent field
	*/
	@Override
	public long getPrimaryKey() {
		return _esfLentField.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f lent field.
	*
	* @param primaryKey the primary key of this e s f lent field
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfLentField.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the lent field ID of this e s f lent field.
	*
	* @return the lent field ID of this e s f lent field
	*/
	@Override
	public long getLentFieldId() {
		return _esfLentField.getLentFieldId();
	}

	/**
	* Sets the lent field ID of this e s f lent field.
	*
	* @param lentFieldId the lent field ID of this e s f lent field
	*/
	@Override
	public void setLentFieldId(long lentFieldId) {
		_esfLentField.setLentFieldId(lentFieldId);
	}

	/**
	* Returns the esf entity state ID of this e s f lent field.
	*
	* @return the esf entity state ID of this e s f lent field
	*/
	@Override
	public long getEsfEntityStateId() {
		return _esfLentField.getEsfEntityStateId();
	}

	/**
	* Sets the esf entity state ID of this e s f lent field.
	*
	* @param esfEntityStateId the esf entity state ID of this e s f lent field
	*/
	@Override
	public void setEsfEntityStateId(long esfEntityStateId) {
		_esfLentField.setEsfEntityStateId(esfEntityStateId);
	}

	/**
	* Returns the esf field ID of this e s f lent field.
	*
	* @return the esf field ID of this e s f lent field
	*/
	@Override
	public long getEsfFieldId() {
		return _esfLentField.getEsfFieldId();
	}

	/**
	* Sets the esf field ID of this e s f lent field.
	*
	* @param esfFieldId the esf field ID of this e s f lent field
	*/
	@Override
	public void setEsfFieldId(long esfFieldId) {
		_esfLentField.setEsfFieldId(esfFieldId);
	}

	/**
	* Returns the real owner ID of this e s f lent field.
	*
	* @return the real owner ID of this e s f lent field
	*/
	@Override
	public long getRealOwnerId() {
		return _esfLentField.getRealOwnerId();
	}

	/**
	* Sets the real owner ID of this e s f lent field.
	*
	* @param realOwnerId the real owner ID of this e s f lent field
	*/
	@Override
	public void setRealOwnerId(long realOwnerId) {
		_esfLentField.setRealOwnerId(realOwnerId);
	}

	/**
	* Returns the actual owner ID of this e s f lent field.
	*
	* @return the actual owner ID of this e s f lent field
	*/
	@Override
	public long getActualOwnerId() {
		return _esfLentField.getActualOwnerId();
	}

	/**
	* Sets the actual owner ID of this e s f lent field.
	*
	* @param actualOwnerId the actual owner ID of this e s f lent field
	*/
	@Override
	public void setActualOwnerId(long actualOwnerId) {
		_esfLentField.setActualOwnerId(actualOwnerId);
	}

	@Override
	public boolean isNew() {
		return _esfLentField.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfLentField.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfLentField.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfLentField.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfLentField.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfLentField.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfLentField.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfLentField.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfLentField.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfLentField.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfLentField.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFLentFieldWrapper((ESFLentField)_esfLentField.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFLentField esfLentField) {
		return _esfLentField.compareTo(esfLentField);
	}

	@Override
	public int hashCode() {
		return _esfLentField.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFLentField> toCacheModel() {
		return _esfLentField.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFLentField toEscapedModel() {
		return new ESFLentFieldWrapper(_esfLentField.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFLentField toUnescapedModel() {
		return new ESFLentFieldWrapper(_esfLentField.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfLentField.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfLentField.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfLentField.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFLentFieldWrapper)) {
			return false;
		}

		ESFLentFieldWrapper esfLentFieldWrapper = (ESFLentFieldWrapper)obj;

		if (Validator.equals(_esfLentField, esfLentFieldWrapper._esfLentField)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFLentField getWrappedESFLentField() {
		return _esfLentField;
	}

	@Override
	public ESFLentField getWrappedModel() {
		return _esfLentField;
	}

	@Override
	public void resetOriginalValues() {
		_esfLentField.resetOriginalValues();
	}

	private ESFLentField _esfLentField;
}