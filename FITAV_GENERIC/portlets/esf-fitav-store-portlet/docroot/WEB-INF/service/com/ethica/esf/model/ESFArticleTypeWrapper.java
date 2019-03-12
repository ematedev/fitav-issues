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

package com.ethica.esf.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ESFArticleType}.
 * </p>
 *
 * @author Ethica
 * @see ESFArticleType
 * @generated
 */
public class ESFArticleTypeWrapper implements ESFArticleType,
	ModelWrapper<ESFArticleType> {
	public ESFArticleTypeWrapper(ESFArticleType esfArticleType) {
		_esfArticleType = esfArticleType;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFArticleType.class;
	}

	@Override
	public String getModelClassName() {
		return ESFArticleType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfArticleTypeId", getEsfArticleTypeId());
		attributes.put("description", getDescription());
		attributes.put("department", getDepartment());
		attributes.put("area", getArea());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfArticleTypeId = (Long)attributes.get("esfArticleTypeId");

		if (esfArticleTypeId != null) {
			setEsfArticleTypeId(esfArticleTypeId);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String department = (String)attributes.get("department");

		if (department != null) {
			setDepartment(department);
		}

		String area = (String)attributes.get("area");

		if (area != null) {
			setArea(area);
		}
	}

	/**
	* Returns the primary key of this e s f article type.
	*
	* @return the primary key of this e s f article type
	*/
	@Override
	public long getPrimaryKey() {
		return _esfArticleType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f article type.
	*
	* @param primaryKey the primary key of this e s f article type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfArticleType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf article type ID of this e s f article type.
	*
	* @return the esf article type ID of this e s f article type
	*/
	@Override
	public long getEsfArticleTypeId() {
		return _esfArticleType.getEsfArticleTypeId();
	}

	/**
	* Sets the esf article type ID of this e s f article type.
	*
	* @param esfArticleTypeId the esf article type ID of this e s f article type
	*/
	@Override
	public void setEsfArticleTypeId(long esfArticleTypeId) {
		_esfArticleType.setEsfArticleTypeId(esfArticleTypeId);
	}

	/**
	* Returns the description of this e s f article type.
	*
	* @return the description of this e s f article type
	*/
	@Override
	public java.lang.String getDescription() {
		return _esfArticleType.getDescription();
	}

	/**
	* Sets the description of this e s f article type.
	*
	* @param description the description of this e s f article type
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_esfArticleType.setDescription(description);
	}

	/**
	* Returns the department of this e s f article type.
	*
	* @return the department of this e s f article type
	*/
	@Override
	public java.lang.String getDepartment() {
		return _esfArticleType.getDepartment();
	}

	/**
	* Sets the department of this e s f article type.
	*
	* @param department the department of this e s f article type
	*/
	@Override
	public void setDepartment(java.lang.String department) {
		_esfArticleType.setDepartment(department);
	}

	/**
	* Returns the area of this e s f article type.
	*
	* @return the area of this e s f article type
	*/
	@Override
	public java.lang.String getArea() {
		return _esfArticleType.getArea();
	}

	/**
	* Sets the area of this e s f article type.
	*
	* @param area the area of this e s f article type
	*/
	@Override
	public void setArea(java.lang.String area) {
		_esfArticleType.setArea(area);
	}

	@Override
	public boolean isNew() {
		return _esfArticleType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfArticleType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfArticleType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfArticleType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfArticleType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfArticleType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfArticleType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfArticleType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfArticleType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfArticleType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfArticleType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFArticleTypeWrapper((ESFArticleType)_esfArticleType.clone());
	}

	@Override
	public int compareTo(com.ethica.esf.model.ESFArticleType esfArticleType) {
		return _esfArticleType.compareTo(esfArticleType);
	}

	@Override
	public int hashCode() {
		return _esfArticleType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ethica.esf.model.ESFArticleType> toCacheModel() {
		return _esfArticleType.toCacheModel();
	}

	@Override
	public com.ethica.esf.model.ESFArticleType toEscapedModel() {
		return new ESFArticleTypeWrapper(_esfArticleType.toEscapedModel());
	}

	@Override
	public com.ethica.esf.model.ESFArticleType toUnescapedModel() {
		return new ESFArticleTypeWrapper(_esfArticleType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfArticleType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfArticleType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfArticleType.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFArticleTypeWrapper)) {
			return false;
		}

		ESFArticleTypeWrapper esfArticleTypeWrapper = (ESFArticleTypeWrapper)obj;

		if (Validator.equals(_esfArticleType,
					esfArticleTypeWrapper._esfArticleType)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFArticleType getWrappedESFArticleType() {
		return _esfArticleType;
	}

	@Override
	public ESFArticleType getWrappedModel() {
		return _esfArticleType;
	}

	@Override
	public void resetOriginalValues() {
		_esfArticleType.resetOriginalValues();
	}

	private ESFArticleType _esfArticleType;
}