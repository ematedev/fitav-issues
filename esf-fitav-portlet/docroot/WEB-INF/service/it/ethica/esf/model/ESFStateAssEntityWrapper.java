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
 * This class is a wrapper for {@link ESFStateAssEntity}.
 * </p>
 *
 * @author Ethica
 * @see ESFStateAssEntity
 * @generated
 */
public class ESFStateAssEntityWrapper implements ESFStateAssEntity,
	ModelWrapper<ESFStateAssEntity> {
	public ESFStateAssEntityWrapper(ESFStateAssEntity esfStateAssEntity) {
		_esfStateAssEntity = esfStateAssEntity;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFStateAssEntity.class;
	}

	@Override
	public String getModelClassName() {
		return ESFStateAssEntity.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfStateId", getEsfStateId());
		attributes.put("className", getClassName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfStateId = (Long)attributes.get("esfStateId");

		if (esfStateId != null) {
			setEsfStateId(esfStateId);
		}

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}
	}

	/**
	* Returns the primary key of this e s f state ass entity.
	*
	* @return the primary key of this e s f state ass entity
	*/
	@Override
	public it.ethica.esf.service.persistence.ESFStateAssEntityPK getPrimaryKey() {
		return _esfStateAssEntity.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f state ass entity.
	*
	* @param primaryKey the primary key of this e s f state ass entity
	*/
	@Override
	public void setPrimaryKey(
		it.ethica.esf.service.persistence.ESFStateAssEntityPK primaryKey) {
		_esfStateAssEntity.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf state ID of this e s f state ass entity.
	*
	* @return the esf state ID of this e s f state ass entity
	*/
	@Override
	public long getEsfStateId() {
		return _esfStateAssEntity.getEsfStateId();
	}

	/**
	* Sets the esf state ID of this e s f state ass entity.
	*
	* @param esfStateId the esf state ID of this e s f state ass entity
	*/
	@Override
	public void setEsfStateId(long esfStateId) {
		_esfStateAssEntity.setEsfStateId(esfStateId);
	}

	/**
	* Returns the class name of this e s f state ass entity.
	*
	* @return the class name of this e s f state ass entity
	*/
	@Override
	public java.lang.String getClassName() {
		return _esfStateAssEntity.getClassName();
	}

	/**
	* Sets the class name of this e s f state ass entity.
	*
	* @param className the class name of this e s f state ass entity
	*/
	@Override
	public void setClassName(java.lang.String className) {
		_esfStateAssEntity.setClassName(className);
	}

	@Override
	public boolean isNew() {
		return _esfStateAssEntity.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfStateAssEntity.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfStateAssEntity.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfStateAssEntity.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfStateAssEntity.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfStateAssEntity.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfStateAssEntity.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfStateAssEntity.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfStateAssEntity.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfStateAssEntity.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfStateAssEntity.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFStateAssEntityWrapper((ESFStateAssEntity)_esfStateAssEntity.clone());
	}

	@Override
	public int compareTo(ESFStateAssEntity esfStateAssEntity) {
		return _esfStateAssEntity.compareTo(esfStateAssEntity);
	}

	@Override
	public int hashCode() {
		return _esfStateAssEntity.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<ESFStateAssEntity> toCacheModel() {
		return _esfStateAssEntity.toCacheModel();
	}

	@Override
	public ESFStateAssEntity toEscapedModel() {
		return new ESFStateAssEntityWrapper(_esfStateAssEntity.toEscapedModel());
	}

	@Override
	public ESFStateAssEntity toUnescapedModel() {
		return new ESFStateAssEntityWrapper(_esfStateAssEntity.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfStateAssEntity.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfStateAssEntity.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfStateAssEntity.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFStateAssEntityWrapper)) {
			return false;
		}

		ESFStateAssEntityWrapper esfStateAssEntityWrapper = (ESFStateAssEntityWrapper)obj;

		if (Validator.equals(_esfStateAssEntity,
					esfStateAssEntityWrapper._esfStateAssEntity)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFStateAssEntity getWrappedESFStateAssEntity() {
		return _esfStateAssEntity;
	}

	@Override
	public ESFStateAssEntity getWrappedModel() {
		return _esfStateAssEntity;
	}

	@Override
	public void resetOriginalValues() {
		_esfStateAssEntity.resetOriginalValues();
	}

	private ESFStateAssEntity _esfStateAssEntity;
}