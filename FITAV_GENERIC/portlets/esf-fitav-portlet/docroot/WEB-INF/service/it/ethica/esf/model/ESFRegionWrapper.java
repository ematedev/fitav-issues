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
 * This class is a wrapper for {@link ESFRegion}.
 * </p>
 *
 * @author Ethica
 * @see ESFRegion
 * @generated
 */
public class ESFRegionWrapper implements ESFRegion, ModelWrapper<ESFRegion> {
	public ESFRegionWrapper(ESFRegion esfRegion) {
		_esfRegion = esfRegion;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFRegion.class;
	}

	@Override
	public String getModelClassName() {
		return ESFRegion.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idRegion", getIdRegion());
		attributes.put("idCountry", getIdCountry());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
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
	* Returns the primary key of this e s f region.
	*
	* @return the primary key of this e s f region
	*/
	@Override
	public it.ethica.esf.service.persistence.ESFRegionPK getPrimaryKey() {
		return _esfRegion.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f region.
	*
	* @param primaryKey the primary key of this e s f region
	*/
	@Override
	public void setPrimaryKey(
		it.ethica.esf.service.persistence.ESFRegionPK primaryKey) {
		_esfRegion.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id region of this e s f region.
	*
	* @return the id region of this e s f region
	*/
	@Override
	public java.lang.String getIdRegion() {
		return _esfRegion.getIdRegion();
	}

	/**
	* Sets the id region of this e s f region.
	*
	* @param idRegion the id region of this e s f region
	*/
	@Override
	public void setIdRegion(java.lang.String idRegion) {
		_esfRegion.setIdRegion(idRegion);
	}

	/**
	* Returns the id country of this e s f region.
	*
	* @return the id country of this e s f region
	*/
	@Override
	public java.lang.String getIdCountry() {
		return _esfRegion.getIdCountry();
	}

	/**
	* Sets the id country of this e s f region.
	*
	* @param idCountry the id country of this e s f region
	*/
	@Override
	public void setIdCountry(java.lang.String idCountry) {
		_esfRegion.setIdCountry(idCountry);
	}

	/**
	* Returns the name of this e s f region.
	*
	* @return the name of this e s f region
	*/
	@Override
	public java.lang.String getName() {
		return _esfRegion.getName();
	}

	/**
	* Sets the name of this e s f region.
	*
	* @param name the name of this e s f region
	*/
	@Override
	public void setName(java.lang.String name) {
		_esfRegion.setName(name);
	}

	@Override
	public boolean isNew() {
		return _esfRegion.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfRegion.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfRegion.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfRegion.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfRegion.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfRegion.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfRegion.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfRegion.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfRegion.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfRegion.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfRegion.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFRegionWrapper((ESFRegion)_esfRegion.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFRegion esfRegion) {
		return _esfRegion.compareTo(esfRegion);
	}

	@Override
	public int hashCode() {
		return _esfRegion.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFRegion> toCacheModel() {
		return _esfRegion.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFRegion toEscapedModel() {
		return new ESFRegionWrapper(_esfRegion.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFRegion toUnescapedModel() {
		return new ESFRegionWrapper(_esfRegion.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfRegion.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfRegion.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfRegion.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFRegionWrapper)) {
			return false;
		}

		ESFRegionWrapper esfRegionWrapper = (ESFRegionWrapper)obj;

		if (Validator.equals(_esfRegion, esfRegionWrapper._esfRegion)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFRegion getWrappedESFRegion() {
		return _esfRegion;
	}

	@Override
	public ESFRegion getWrappedModel() {
		return _esfRegion;
	}

	@Override
	public void resetOriginalValues() {
		_esfRegion.resetOriginalValues();
	}

	private ESFRegion _esfRegion;
}