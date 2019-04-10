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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ESFState}.
 * </p>
 *
 * @author Ethica
 * @see ESFState
 * @generated
 */
public class ESFStateWrapper implements ESFState, ModelWrapper<ESFState> {
	public ESFStateWrapper(ESFState esfState) {
		_esfState = esfState;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFState.class;
	}

	@Override
	public String getModelClassName() {
		return ESFState.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfStateId", getEsfStateId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfStateId = (Long)attributes.get("esfStateId");

		if (esfStateId != null) {
			setEsfStateId(esfStateId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	* Returns the primary key of this e s f state.
	*
	* @return the primary key of this e s f state
	*/
	@Override
	public long getPrimaryKey() {
		return _esfState.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f state.
	*
	* @param primaryKey the primary key of this e s f state
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfState.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf state ID of this e s f state.
	*
	* @return the esf state ID of this e s f state
	*/
	@Override
	public long getEsfStateId() {
		return _esfState.getEsfStateId();
	}

	/**
	* Sets the esf state ID of this e s f state.
	*
	* @param esfStateId the esf state ID of this e s f state
	*/
	@Override
	public void setEsfStateId(long esfStateId) {
		_esfState.setEsfStateId(esfStateId);
	}

	/**
	* Returns the name of this e s f state.
	*
	* @return the name of this e s f state
	*/
	@Override
	public java.lang.String getName() {
		return _esfState.getName();
	}

	/**
	* Sets the name of this e s f state.
	*
	* @param name the name of this e s f state
	*/
	@Override
	public void setName(java.lang.String name) {
		_esfState.setName(name);
	}

	/**
	* Returns the description of this e s f state.
	*
	* @return the description of this e s f state
	*/
	@Override
	public java.lang.String getDescription() {
		return _esfState.getDescription();
	}

	/**
	* Sets the description of this e s f state.
	*
	* @param description the description of this e s f state
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_esfState.setDescription(description);
	}

	@Override
	public boolean isNew() {
		return _esfState.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfState.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfState.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfState.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfState.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfState.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfState.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfState.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfState.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfState.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfState.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFStateWrapper((ESFState)_esfState.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFState esfState) {
		return _esfState.compareTo(esfState);
	}

	@Override
	public int hashCode() {
		return _esfState.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFState> toCacheModel() {
		return _esfState.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFState toEscapedModel() {
		return new ESFStateWrapper(_esfState.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFState toUnescapedModel() {
		return new ESFStateWrapper(_esfState.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfState.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfState.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfState.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFStateWrapper)) {
			return false;
		}

		ESFStateWrapper esfStateWrapper = (ESFStateWrapper)obj;

		if (Validator.equals(_esfState, esfStateWrapper._esfState)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFState getWrappedESFState() {
		return _esfState;
	}

	@Override
	public ESFState getWrappedModel() {
		return _esfState;
	}

	@Override
	public void resetOriginalValues() {
		_esfState.resetOriginalValues();
	}

	private ESFState _esfState;
}