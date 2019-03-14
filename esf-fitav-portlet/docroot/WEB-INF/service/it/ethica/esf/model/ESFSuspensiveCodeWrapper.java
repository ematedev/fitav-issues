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
 * This class is a wrapper for {@link ESFSuspensiveCode}.
 * </p>
 *
 * @author Ethica
 * @see ESFSuspensiveCode
 * @generated
 */
public class ESFSuspensiveCodeWrapper implements ESFSuspensiveCode,
	ModelWrapper<ESFSuspensiveCode> {
	public ESFSuspensiveCodeWrapper(ESFSuspensiveCode esfSuspensiveCode) {
		_esfSuspensiveCode = esfSuspensiveCode;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFSuspensiveCode.class;
	}

	@Override
	public String getModelClassName() {
		return ESFSuspensiveCode.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfSuspensiveCodeId", getEsfSuspensiveCodeId());
		attributes.put("code", getCode());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfSuspensiveCodeId = (Long)attributes.get("esfSuspensiveCodeId");

		if (esfSuspensiveCodeId != null) {
			setEsfSuspensiveCodeId(esfSuspensiveCodeId);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	* Returns the primary key of this e s f suspensive code.
	*
	* @return the primary key of this e s f suspensive code
	*/
	@Override
	public long getPrimaryKey() {
		return _esfSuspensiveCode.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f suspensive code.
	*
	* @param primaryKey the primary key of this e s f suspensive code
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfSuspensiveCode.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf suspensive code ID of this e s f suspensive code.
	*
	* @return the esf suspensive code ID of this e s f suspensive code
	*/
	@Override
	public long getEsfSuspensiveCodeId() {
		return _esfSuspensiveCode.getEsfSuspensiveCodeId();
	}

	/**
	* Sets the esf suspensive code ID of this e s f suspensive code.
	*
	* @param esfSuspensiveCodeId the esf suspensive code ID of this e s f suspensive code
	*/
	@Override
	public void setEsfSuspensiveCodeId(long esfSuspensiveCodeId) {
		_esfSuspensiveCode.setEsfSuspensiveCodeId(esfSuspensiveCodeId);
	}

	/**
	* Returns the code of this e s f suspensive code.
	*
	* @return the code of this e s f suspensive code
	*/
	@Override
	public java.lang.String getCode() {
		return _esfSuspensiveCode.getCode();
	}

	/**
	* Sets the code of this e s f suspensive code.
	*
	* @param code the code of this e s f suspensive code
	*/
	@Override
	public void setCode(java.lang.String code) {
		_esfSuspensiveCode.setCode(code);
	}

	/**
	* Returns the description of this e s f suspensive code.
	*
	* @return the description of this e s f suspensive code
	*/
	@Override
	public java.lang.String getDescription() {
		return _esfSuspensiveCode.getDescription();
	}

	/**
	* Sets the description of this e s f suspensive code.
	*
	* @param description the description of this e s f suspensive code
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_esfSuspensiveCode.setDescription(description);
	}

	@Override
	public boolean isNew() {
		return _esfSuspensiveCode.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfSuspensiveCode.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfSuspensiveCode.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfSuspensiveCode.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfSuspensiveCode.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfSuspensiveCode.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfSuspensiveCode.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfSuspensiveCode.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfSuspensiveCode.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfSuspensiveCode.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfSuspensiveCode.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFSuspensiveCodeWrapper((ESFSuspensiveCode)_esfSuspensiveCode.clone());
	}

	@Override
	public int compareTo(
		it.ethica.esf.model.ESFSuspensiveCode esfSuspensiveCode) {
		return _esfSuspensiveCode.compareTo(esfSuspensiveCode);
	}

	@Override
	public int hashCode() {
		return _esfSuspensiveCode.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFSuspensiveCode> toCacheModel() {
		return _esfSuspensiveCode.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFSuspensiveCode toEscapedModel() {
		return new ESFSuspensiveCodeWrapper(_esfSuspensiveCode.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFSuspensiveCode toUnescapedModel() {
		return new ESFSuspensiveCodeWrapper(_esfSuspensiveCode.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfSuspensiveCode.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfSuspensiveCode.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfSuspensiveCode.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFSuspensiveCodeWrapper)) {
			return false;
		}

		ESFSuspensiveCodeWrapper esfSuspensiveCodeWrapper = (ESFSuspensiveCodeWrapper)obj;

		if (Validator.equals(_esfSuspensiveCode,
					esfSuspensiveCodeWrapper._esfSuspensiveCode)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFSuspensiveCode getWrappedESFSuspensiveCode() {
		return _esfSuspensiveCode;
	}

	@Override
	public ESFSuspensiveCode getWrappedModel() {
		return _esfSuspensiveCode;
	}

	@Override
	public void resetOriginalValues() {
		_esfSuspensiveCode.resetOriginalValues();
	}

	private ESFSuspensiveCode _esfSuspensiveCode;
}