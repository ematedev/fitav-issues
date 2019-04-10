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
 * This class is a wrapper for {@link ESFBrand}.
 * </p>
 *
 * @author Ethica
 * @see ESFBrand
 * @generated
 */
public class ESFBrandWrapper implements ESFBrand, ModelWrapper<ESFBrand> {
	public ESFBrandWrapper(ESFBrand esfBrand) {
		_esfBrand = esfBrand;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFBrand.class;
	}

	@Override
	public String getModelClassName() {
		return ESFBrand.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("brandId", getBrandId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long brandId = (Long)attributes.get("brandId");

		if (brandId != null) {
			setBrandId(brandId);
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
	* Returns the primary key of this e s f brand.
	*
	* @return the primary key of this e s f brand
	*/
	@Override
	public long getPrimaryKey() {
		return _esfBrand.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f brand.
	*
	* @param primaryKey the primary key of this e s f brand
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfBrand.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the brand ID of this e s f brand.
	*
	* @return the brand ID of this e s f brand
	*/
	@Override
	public long getBrandId() {
		return _esfBrand.getBrandId();
	}

	/**
	* Sets the brand ID of this e s f brand.
	*
	* @param brandId the brand ID of this e s f brand
	*/
	@Override
	public void setBrandId(long brandId) {
		_esfBrand.setBrandId(brandId);
	}

	/**
	* Returns the name of this e s f brand.
	*
	* @return the name of this e s f brand
	*/
	@Override
	public java.lang.String getName() {
		return _esfBrand.getName();
	}

	/**
	* Sets the name of this e s f brand.
	*
	* @param name the name of this e s f brand
	*/
	@Override
	public void setName(java.lang.String name) {
		_esfBrand.setName(name);
	}

	/**
	* Returns the description of this e s f brand.
	*
	* @return the description of this e s f brand
	*/
	@Override
	public java.lang.String getDescription() {
		return _esfBrand.getDescription();
	}

	/**
	* Sets the description of this e s f brand.
	*
	* @param description the description of this e s f brand
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_esfBrand.setDescription(description);
	}

	@Override
	public boolean isNew() {
		return _esfBrand.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfBrand.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfBrand.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfBrand.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfBrand.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfBrand.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfBrand.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfBrand.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfBrand.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfBrand.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfBrand.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFBrandWrapper((ESFBrand)_esfBrand.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFBrand esfBrand) {
		return _esfBrand.compareTo(esfBrand);
	}

	@Override
	public int hashCode() {
		return _esfBrand.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFBrand> toCacheModel() {
		return _esfBrand.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFBrand toEscapedModel() {
		return new ESFBrandWrapper(_esfBrand.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFBrand toUnescapedModel() {
		return new ESFBrandWrapper(_esfBrand.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfBrand.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfBrand.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfBrand.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFBrandWrapper)) {
			return false;
		}

		ESFBrandWrapper esfBrandWrapper = (ESFBrandWrapper)obj;

		if (Validator.equals(_esfBrand, esfBrandWrapper._esfBrand)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFBrand getWrappedESFBrand() {
		return _esfBrand;
	}

	@Override
	public ESFBrand getWrappedModel() {
		return _esfBrand;
	}

	@Override
	public void resetOriginalValues() {
		_esfBrand.resetOriginalValues();
	}

	private ESFBrand _esfBrand;
}