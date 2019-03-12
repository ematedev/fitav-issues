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
 * This class is a wrapper for {@link ESFFieldESFElectronic}.
 * </p>
 *
 * @author Ethica
 * @see ESFFieldESFElectronic
 * @generated
 */
public class ESFFieldESFElectronicWrapper implements ESFFieldESFElectronic,
	ModelWrapper<ESFFieldESFElectronic> {
	public ESFFieldESFElectronicWrapper(
		ESFFieldESFElectronic esfFieldESFElectronic) {
		_esfFieldESFElectronic = esfFieldESFElectronic;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFFieldESFElectronic.class;
	}

	@Override
	public String getModelClassName() {
		return ESFFieldESFElectronic.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("brandId", getBrandId());
		attributes.put("electronicId", getElectronicId());
		attributes.put("fieldId", getFieldId());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long brandId = (Long)attributes.get("brandId");

		if (brandId != null) {
			setBrandId(brandId);
		}

		Long electronicId = (Long)attributes.get("electronicId");

		if (electronicId != null) {
			setElectronicId(electronicId);
		}

		Long fieldId = (Long)attributes.get("fieldId");

		if (fieldId != null) {
			setFieldId(fieldId);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	* Returns the primary key of this e s f field e s f electronic.
	*
	* @return the primary key of this e s f field e s f electronic
	*/
	@Override
	public long getPrimaryKey() {
		return _esfFieldESFElectronic.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f field e s f electronic.
	*
	* @param primaryKey the primary key of this e s f field e s f electronic
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfFieldESFElectronic.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this e s f field e s f electronic.
	*
	* @return the ID of this e s f field e s f electronic
	*/
	@Override
	public long getId() {
		return _esfFieldESFElectronic.getId();
	}

	/**
	* Sets the ID of this e s f field e s f electronic.
	*
	* @param id the ID of this e s f field e s f electronic
	*/
	@Override
	public void setId(long id) {
		_esfFieldESFElectronic.setId(id);
	}

	/**
	* Returns the brand ID of this e s f field e s f electronic.
	*
	* @return the brand ID of this e s f field e s f electronic
	*/
	@Override
	public long getBrandId() {
		return _esfFieldESFElectronic.getBrandId();
	}

	/**
	* Sets the brand ID of this e s f field e s f electronic.
	*
	* @param brandId the brand ID of this e s f field e s f electronic
	*/
	@Override
	public void setBrandId(long brandId) {
		_esfFieldESFElectronic.setBrandId(brandId);
	}

	/**
	* Returns the electronic ID of this e s f field e s f electronic.
	*
	* @return the electronic ID of this e s f field e s f electronic
	*/
	@Override
	public long getElectronicId() {
		return _esfFieldESFElectronic.getElectronicId();
	}

	/**
	* Sets the electronic ID of this e s f field e s f electronic.
	*
	* @param electronicId the electronic ID of this e s f field e s f electronic
	*/
	@Override
	public void setElectronicId(long electronicId) {
		_esfFieldESFElectronic.setElectronicId(electronicId);
	}

	/**
	* Returns the field ID of this e s f field e s f electronic.
	*
	* @return the field ID of this e s f field e s f electronic
	*/
	@Override
	public long getFieldId() {
		return _esfFieldESFElectronic.getFieldId();
	}

	/**
	* Sets the field ID of this e s f field e s f electronic.
	*
	* @param fieldId the field ID of this e s f field e s f electronic
	*/
	@Override
	public void setFieldId(long fieldId) {
		_esfFieldESFElectronic.setFieldId(fieldId);
	}

	/**
	* Returns the description of this e s f field e s f electronic.
	*
	* @return the description of this e s f field e s f electronic
	*/
	@Override
	public java.lang.String getDescription() {
		return _esfFieldESFElectronic.getDescription();
	}

	/**
	* Sets the description of this e s f field e s f electronic.
	*
	* @param description the description of this e s f field e s f electronic
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_esfFieldESFElectronic.setDescription(description);
	}

	@Override
	public boolean isNew() {
		return _esfFieldESFElectronic.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfFieldESFElectronic.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfFieldESFElectronic.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfFieldESFElectronic.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfFieldESFElectronic.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfFieldESFElectronic.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfFieldESFElectronic.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfFieldESFElectronic.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfFieldESFElectronic.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfFieldESFElectronic.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfFieldESFElectronic.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFFieldESFElectronicWrapper((ESFFieldESFElectronic)_esfFieldESFElectronic.clone());
	}

	@Override
	public int compareTo(
		it.ethica.esf.model.ESFFieldESFElectronic esfFieldESFElectronic) {
		return _esfFieldESFElectronic.compareTo(esfFieldESFElectronic);
	}

	@Override
	public int hashCode() {
		return _esfFieldESFElectronic.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFFieldESFElectronic> toCacheModel() {
		return _esfFieldESFElectronic.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFFieldESFElectronic toEscapedModel() {
		return new ESFFieldESFElectronicWrapper(_esfFieldESFElectronic.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFFieldESFElectronic toUnescapedModel() {
		return new ESFFieldESFElectronicWrapper(_esfFieldESFElectronic.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfFieldESFElectronic.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfFieldESFElectronic.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfFieldESFElectronic.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFFieldESFElectronicWrapper)) {
			return false;
		}

		ESFFieldESFElectronicWrapper esfFieldESFElectronicWrapper = (ESFFieldESFElectronicWrapper)obj;

		if (Validator.equals(_esfFieldESFElectronic,
					esfFieldESFElectronicWrapper._esfFieldESFElectronic)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFFieldESFElectronic getWrappedESFFieldESFElectronic() {
		return _esfFieldESFElectronic;
	}

	@Override
	public ESFFieldESFElectronic getWrappedModel() {
		return _esfFieldESFElectronic;
	}

	@Override
	public void resetOriginalValues() {
		_esfFieldESFElectronic.resetOriginalValues();
	}

	private ESFFieldESFElectronic _esfFieldESFElectronic;
}