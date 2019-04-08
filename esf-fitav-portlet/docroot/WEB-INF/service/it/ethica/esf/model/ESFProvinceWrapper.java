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
 * This class is a wrapper for {@link ESFProvince}.
 * </p>
 *
 * @author Ethica
 * @see ESFProvince
 * @generated
 */
public class ESFProvinceWrapper implements ESFProvince,
	ModelWrapper<ESFProvince> {
	public ESFProvinceWrapper(ESFProvince esfProvince) {
		_esfProvince = esfProvince;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFProvince.class;
	}

	@Override
	public String getModelClassName() {
		return ESFProvince.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idProvince", getIdProvince());
		attributes.put("idRegion", getIdRegion());
		attributes.put("idCountry", getIdCountry());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String idProvince = (String)attributes.get("idProvince");

		if (idProvince != null) {
			setIdProvince(idProvince);
		}

		String idRegion = (String)attributes.get("idRegion");

		if (idRegion != null) {
			setIdRegion(idRegion);
		}

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
	* Returns the primary key of this e s f province.
	*
	* @return the primary key of this e s f province
	*/
	@Override
	public it.ethica.esf.service.persistence.ESFProvincePK getPrimaryKey() {
		return _esfProvince.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f province.
	*
	* @param primaryKey the primary key of this e s f province
	*/
	@Override
	public void setPrimaryKey(
		it.ethica.esf.service.persistence.ESFProvincePK primaryKey) {
		_esfProvince.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id province of this e s f province.
	*
	* @return the id province of this e s f province
	*/
	@Override
	public java.lang.String getIdProvince() {
		return _esfProvince.getIdProvince();
	}

	/**
	* Sets the id province of this e s f province.
	*
	* @param idProvince the id province of this e s f province
	*/
	@Override
	public void setIdProvince(java.lang.String idProvince) {
		_esfProvince.setIdProvince(idProvince);
	}

	/**
	* Returns the id region of this e s f province.
	*
	* @return the id region of this e s f province
	*/
	@Override
	public java.lang.String getIdRegion() {
		return _esfProvince.getIdRegion();
	}

	/**
	* Sets the id region of this e s f province.
	*
	* @param idRegion the id region of this e s f province
	*/
	@Override
	public void setIdRegion(java.lang.String idRegion) {
		_esfProvince.setIdRegion(idRegion);
	}

	/**
	* Returns the id country of this e s f province.
	*
	* @return the id country of this e s f province
	*/
	@Override
	public java.lang.String getIdCountry() {
		return _esfProvince.getIdCountry();
	}

	/**
	* Sets the id country of this e s f province.
	*
	* @param idCountry the id country of this e s f province
	*/
	@Override
	public void setIdCountry(java.lang.String idCountry) {
		_esfProvince.setIdCountry(idCountry);
	}

	/**
	* Returns the name of this e s f province.
	*
	* @return the name of this e s f province
	*/
	@Override
	public java.lang.String getName() {
		return _esfProvince.getName();
	}

	/**
	* Sets the name of this e s f province.
	*
	* @param name the name of this e s f province
	*/
	@Override
	public void setName(java.lang.String name) {
		_esfProvince.setName(name);
	}

	@Override
	public boolean isNew() {
		return _esfProvince.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfProvince.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfProvince.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfProvince.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfProvince.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfProvince.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfProvince.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfProvince.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfProvince.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfProvince.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfProvince.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFProvinceWrapper((ESFProvince)_esfProvince.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFProvince esfProvince) {
		return _esfProvince.compareTo(esfProvince);
	}

	@Override
	public int hashCode() {
		return _esfProvince.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFProvince> toCacheModel() {
		return _esfProvince.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFProvince toEscapedModel() {
		return new ESFProvinceWrapper(_esfProvince.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFProvince toUnescapedModel() {
		return new ESFProvinceWrapper(_esfProvince.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfProvince.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfProvince.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfProvince.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFProvinceWrapper)) {
			return false;
		}

		ESFProvinceWrapper esfProvinceWrapper = (ESFProvinceWrapper)obj;

		if (Validator.equals(_esfProvince, esfProvinceWrapper._esfProvince)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFProvince getWrappedESFProvince() {
		return _esfProvince;
	}

	@Override
	public ESFProvince getWrappedModel() {
		return _esfProvince;
	}

	@Override
	public void resetOriginalValues() {
		_esfProvince.resetOriginalValues();
	}

	private ESFProvince _esfProvince;
}