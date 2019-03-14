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
 * This class is a wrapper for {@link ESFCountry}.
 * </p>
 *
 * @author Ethica
 * @see ESFCountry
 * @generated
 */
public class ESFCountryWrapper implements ESFCountry, ModelWrapper<ESFCountry> {
	public ESFCountryWrapper(ESFCountry esfCountry) {
		_esfCountry = esfCountry;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFCountry.class;
	}

	@Override
	public String getModelClassName() {
		return ESFCountry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idCountry", getIdCountry());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String idCountry = (String)attributes.get("idCountry");

		if (idCountry != null) {
			setIdCountry(idCountry);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	/**
	* Returns the primary key of this e s f country.
	*
	* @return the primary key of this e s f country
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _esfCountry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f country.
	*
	* @param primaryKey the primary key of this e s f country
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_esfCountry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id country of this e s f country.
	*
	* @return the id country of this e s f country
	*/
	@Override
	public java.lang.String getIdCountry() {
		return _esfCountry.getIdCountry();
	}

	/**
	* Sets the id country of this e s f country.
	*
	* @param idCountry the id country of this e s f country
	*/
	@Override
	public void setIdCountry(java.lang.String idCountry) {
		_esfCountry.setIdCountry(idCountry);
	}

	/**
	* Returns the name of this e s f country.
	*
	* @return the name of this e s f country
	*/
	@Override
	public java.lang.String getName() {
		return _esfCountry.getName();
	}

	/**
	* Sets the name of this e s f country.
	*
	* @param name the name of this e s f country
	*/
	@Override
	public void setName(java.lang.String name) {
		_esfCountry.setName(name);
	}

	@Override
	public boolean isNew() {
		return _esfCountry.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfCountry.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfCountry.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfCountry.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfCountry.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfCountry.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfCountry.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfCountry.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfCountry.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfCountry.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfCountry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFCountryWrapper((ESFCountry)_esfCountry.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFCountry esfCountry) {
		return _esfCountry.compareTo(esfCountry);
	}

	@Override
	public int hashCode() {
		return _esfCountry.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFCountry> toCacheModel() {
		return _esfCountry.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFCountry toEscapedModel() {
		return new ESFCountryWrapper(_esfCountry.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFCountry toUnescapedModel() {
		return new ESFCountryWrapper(_esfCountry.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfCountry.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfCountry.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfCountry.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFCountryWrapper)) {
			return false;
		}

		ESFCountryWrapper esfCountryWrapper = (ESFCountryWrapper)obj;

		if (Validator.equals(_esfCountry, esfCountryWrapper._esfCountry)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFCountry getWrappedESFCountry() {
		return _esfCountry;
	}

	@Override
	public ESFCountry getWrappedModel() {
		return _esfCountry;
	}

	@Override
	public void resetOriginalValues() {
		_esfCountry.resetOriginalValues();
	}

	private ESFCountry _esfCountry;
}