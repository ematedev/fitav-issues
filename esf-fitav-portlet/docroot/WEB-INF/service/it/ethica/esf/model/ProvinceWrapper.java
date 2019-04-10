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
 * This class is a wrapper for {@link Province}.
 * </p>
 *
 * @author Ethica
 * @see Province
 * @generated
 */
public class ProvinceWrapper implements Province, ModelWrapper<Province> {
	public ProvinceWrapper(Province province) {
		_province = province;
	}

	@Override
	public Class<?> getModelClass() {
		return Province.class;
	}

	@Override
	public String getModelClassName() {
		return Province.class.getName();
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
	* Returns the primary key of this province.
	*
	* @return the primary key of this province
	*/
	@Override
	public it.ethica.esf.service.persistence.ProvincePK getPrimaryKey() {
		return _province.getPrimaryKey();
	}

	/**
	* Sets the primary key of this province.
	*
	* @param primaryKey the primary key of this province
	*/
	@Override
	public void setPrimaryKey(
		it.ethica.esf.service.persistence.ProvincePK primaryKey) {
		_province.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id province of this province.
	*
	* @return the id province of this province
	*/
	@Override
	public java.lang.String getIdProvince() {
		return _province.getIdProvince();
	}

	/**
	* Sets the id province of this province.
	*
	* @param idProvince the id province of this province
	*/
	@Override
	public void setIdProvince(java.lang.String idProvince) {
		_province.setIdProvince(idProvince);
	}

	/**
	* Returns the id region of this province.
	*
	* @return the id region of this province
	*/
	@Override
	public java.lang.String getIdRegion() {
		return _province.getIdRegion();
	}

	/**
	* Sets the id region of this province.
	*
	* @param idRegion the id region of this province
	*/
	@Override
	public void setIdRegion(java.lang.String idRegion) {
		_province.setIdRegion(idRegion);
	}

	/**
	* Returns the id country of this province.
	*
	* @return the id country of this province
	*/
	@Override
	public java.lang.String getIdCountry() {
		return _province.getIdCountry();
	}

	/**
	* Sets the id country of this province.
	*
	* @param idCountry the id country of this province
	*/
	@Override
	public void setIdCountry(java.lang.String idCountry) {
		_province.setIdCountry(idCountry);
	}

	/**
	* Returns the name of this province.
	*
	* @return the name of this province
	*/
	@Override
	public java.lang.String getName() {
		return _province.getName();
	}

	/**
	* Sets the name of this province.
	*
	* @param name the name of this province
	*/
	@Override
	public void setName(java.lang.String name) {
		_province.setName(name);
	}

	@Override
	public boolean isNew() {
		return _province.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_province.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _province.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_province.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _province.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _province.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_province.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _province.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_province.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_province.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_province.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ProvinceWrapper((Province)_province.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.Province province) {
		return _province.compareTo(province);
	}

	@Override
	public int hashCode() {
		return _province.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.Province> toCacheModel() {
		return _province.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.Province toEscapedModel() {
		return new ProvinceWrapper(_province.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.Province toUnescapedModel() {
		return new ProvinceWrapper(_province.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _province.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _province.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_province.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProvinceWrapper)) {
			return false;
		}

		ProvinceWrapper provinceWrapper = (ProvinceWrapper)obj;

		if (Validator.equals(_province, provinceWrapper._province)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Province getWrappedProvince() {
		return _province;
	}

	@Override
	public Province getWrappedModel() {
		return _province;
	}

	@Override
	public void resetOriginalValues() {
		_province.resetOriginalValues();
	}

	private Province _province;
}