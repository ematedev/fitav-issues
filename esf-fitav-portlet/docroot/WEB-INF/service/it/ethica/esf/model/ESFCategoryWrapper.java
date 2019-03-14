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
 * This class is a wrapper for {@link ESFCategory}.
 * </p>
 *
 * @author Ethica
 * @see ESFCategory
 * @generated
 */
public class ESFCategoryWrapper implements ESFCategory,
	ModelWrapper<ESFCategory> {
	public ESFCategoryWrapper(ESFCategory esfCategory) {
		_esfCategory = esfCategory;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFCategory.class;
	}

	@Override
	public String getModelClassName() {
		return ESFCategory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfCategoryId", getEsfCategoryId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfCategoryId = (Long)attributes.get("esfCategoryId");

		if (esfCategoryId != null) {
			setEsfCategoryId(esfCategoryId);
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
	* Returns the primary key of this e s f category.
	*
	* @return the primary key of this e s f category
	*/
	@Override
	public long getPrimaryKey() {
		return _esfCategory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f category.
	*
	* @param primaryKey the primary key of this e s f category
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfCategory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf category ID of this e s f category.
	*
	* @return the esf category ID of this e s f category
	*/
	@Override
	public long getEsfCategoryId() {
		return _esfCategory.getEsfCategoryId();
	}

	/**
	* Sets the esf category ID of this e s f category.
	*
	* @param esfCategoryId the esf category ID of this e s f category
	*/
	@Override
	public void setEsfCategoryId(long esfCategoryId) {
		_esfCategory.setEsfCategoryId(esfCategoryId);
	}

	/**
	* Returns the name of this e s f category.
	*
	* @return the name of this e s f category
	*/
	@Override
	public java.lang.String getName() {
		return _esfCategory.getName();
	}

	/**
	* Sets the name of this e s f category.
	*
	* @param name the name of this e s f category
	*/
	@Override
	public void setName(java.lang.String name) {
		_esfCategory.setName(name);
	}

	/**
	* Returns the description of this e s f category.
	*
	* @return the description of this e s f category
	*/
	@Override
	public java.lang.String getDescription() {
		return _esfCategory.getDescription();
	}

	/**
	* Sets the description of this e s f category.
	*
	* @param description the description of this e s f category
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_esfCategory.setDescription(description);
	}

	@Override
	public boolean isNew() {
		return _esfCategory.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfCategory.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfCategory.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfCategory.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfCategory.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfCategory.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfCategory.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfCategory.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfCategory.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfCategory.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfCategory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFCategoryWrapper((ESFCategory)_esfCategory.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFCategory esfCategory) {
		return _esfCategory.compareTo(esfCategory);
	}

	@Override
	public int hashCode() {
		return _esfCategory.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFCategory> toCacheModel() {
		return _esfCategory.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFCategory toEscapedModel() {
		return new ESFCategoryWrapper(_esfCategory.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFCategory toUnescapedModel() {
		return new ESFCategoryWrapper(_esfCategory.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfCategory.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfCategory.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfCategory.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFCategoryWrapper)) {
			return false;
		}

		ESFCategoryWrapper esfCategoryWrapper = (ESFCategoryWrapper)obj;

		if (Validator.equals(_esfCategory, esfCategoryWrapper._esfCategory)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFCategory getWrappedESFCategory() {
		return _esfCategory;
	}

	@Override
	public ESFCategory getWrappedModel() {
		return _esfCategory;
	}

	@Override
	public void resetOriginalValues() {
		_esfCategory.resetOriginalValues();
	}

	private ESFCategory _esfCategory;
}