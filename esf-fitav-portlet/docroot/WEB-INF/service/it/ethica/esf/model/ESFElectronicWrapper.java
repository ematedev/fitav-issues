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
 * This class is a wrapper for {@link ESFElectronic}.
 * </p>
 *
 * @author Ethica
 * @see ESFElectronic
 * @generated
 */
public class ESFElectronicWrapper implements ESFElectronic,
	ModelWrapper<ESFElectronic> {
	public ESFElectronicWrapper(ESFElectronic esfElectronic) {
		_esfElectronic = esfElectronic;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFElectronic.class;
	}

	@Override
	public String getModelClassName() {
		return ESFElectronic.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("electronicId", getElectronicId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long electronicId = (Long)attributes.get("electronicId");

		if (electronicId != null) {
			setElectronicId(electronicId);
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
	* Returns the primary key of this e s f electronic.
	*
	* @return the primary key of this e s f electronic
	*/
	@Override
	public long getPrimaryKey() {
		return _esfElectronic.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f electronic.
	*
	* @param primaryKey the primary key of this e s f electronic
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfElectronic.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the electronic ID of this e s f electronic.
	*
	* @return the electronic ID of this e s f electronic
	*/
	@Override
	public long getElectronicId() {
		return _esfElectronic.getElectronicId();
	}

	/**
	* Sets the electronic ID of this e s f electronic.
	*
	* @param electronicId the electronic ID of this e s f electronic
	*/
	@Override
	public void setElectronicId(long electronicId) {
		_esfElectronic.setElectronicId(electronicId);
	}

	/**
	* Returns the name of this e s f electronic.
	*
	* @return the name of this e s f electronic
	*/
	@Override
	public java.lang.String getName() {
		return _esfElectronic.getName();
	}

	/**
	* Sets the name of this e s f electronic.
	*
	* @param name the name of this e s f electronic
	*/
	@Override
	public void setName(java.lang.String name) {
		_esfElectronic.setName(name);
	}

	/**
	* Returns the description of this e s f electronic.
	*
	* @return the description of this e s f electronic
	*/
	@Override
	public java.lang.String getDescription() {
		return _esfElectronic.getDescription();
	}

	/**
	* Sets the description of this e s f electronic.
	*
	* @param description the description of this e s f electronic
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_esfElectronic.setDescription(description);
	}

	@Override
	public boolean isNew() {
		return _esfElectronic.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfElectronic.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfElectronic.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfElectronic.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfElectronic.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfElectronic.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfElectronic.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfElectronic.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfElectronic.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfElectronic.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfElectronic.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFElectronicWrapper((ESFElectronic)_esfElectronic.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFElectronic esfElectronic) {
		return _esfElectronic.compareTo(esfElectronic);
	}

	@Override
	public int hashCode() {
		return _esfElectronic.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFElectronic> toCacheModel() {
		return _esfElectronic.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFElectronic toEscapedModel() {
		return new ESFElectronicWrapper(_esfElectronic.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFElectronic toUnescapedModel() {
		return new ESFElectronicWrapper(_esfElectronic.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfElectronic.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfElectronic.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfElectronic.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFElectronicWrapper)) {
			return false;
		}

		ESFElectronicWrapper esfElectronicWrapper = (ESFElectronicWrapper)obj;

		if (Validator.equals(_esfElectronic, esfElectronicWrapper._esfElectronic)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFElectronic getWrappedESFElectronic() {
		return _esfElectronic;
	}

	@Override
	public ESFElectronic getWrappedModel() {
		return _esfElectronic;
	}

	@Override
	public void resetOriginalValues() {
		_esfElectronic.resetOriginalValues();
	}

	private ESFElectronic _esfElectronic;
}