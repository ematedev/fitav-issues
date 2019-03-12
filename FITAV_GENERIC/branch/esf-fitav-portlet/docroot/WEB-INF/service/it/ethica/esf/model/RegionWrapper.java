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
 * This class is a wrapper for {@link Region}.
 * </p>
 *
 * @author Ethica
 * @see Region
 * @generated
 */
public class RegionWrapper implements Region, ModelWrapper<Region> {
	public RegionWrapper(Region region) {
		_region = region;
	}

	@Override
	public Class<?> getModelClass() {
		return Region.class;
	}

	@Override
	public String getModelClassName() {
		return Region.class.getName();
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
	* Returns the primary key of this region.
	*
	* @return the primary key of this region
	*/
	@Override
	public it.ethica.esf.service.persistence.RegionPK getPrimaryKey() {
		return _region.getPrimaryKey();
	}

	/**
	* Sets the primary key of this region.
	*
	* @param primaryKey the primary key of this region
	*/
	@Override
	public void setPrimaryKey(
		it.ethica.esf.service.persistence.RegionPK primaryKey) {
		_region.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id region of this region.
	*
	* @return the id region of this region
	*/
	@Override
	public java.lang.String getIdRegion() {
		return _region.getIdRegion();
	}

	/**
	* Sets the id region of this region.
	*
	* @param idRegion the id region of this region
	*/
	@Override
	public void setIdRegion(java.lang.String idRegion) {
		_region.setIdRegion(idRegion);
	}

	/**
	* Returns the id country of this region.
	*
	* @return the id country of this region
	*/
	@Override
	public java.lang.String getIdCountry() {
		return _region.getIdCountry();
	}

	/**
	* Sets the id country of this region.
	*
	* @param idCountry the id country of this region
	*/
	@Override
	public void setIdCountry(java.lang.String idCountry) {
		_region.setIdCountry(idCountry);
	}

	/**
	* Returns the name of this region.
	*
	* @return the name of this region
	*/
	@Override
	public java.lang.String getName() {
		return _region.getName();
	}

	/**
	* Sets the name of this region.
	*
	* @param name the name of this region
	*/
	@Override
	public void setName(java.lang.String name) {
		_region.setName(name);
	}

	@Override
	public boolean isNew() {
		return _region.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_region.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _region.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_region.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _region.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _region.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_region.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _region.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_region.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_region.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_region.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RegionWrapper((Region)_region.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.Region region) {
		return _region.compareTo(region);
	}

	@Override
	public int hashCode() {
		return _region.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.Region> toCacheModel() {
		return _region.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.Region toEscapedModel() {
		return new RegionWrapper(_region.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.Region toUnescapedModel() {
		return new RegionWrapper(_region.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _region.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _region.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_region.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RegionWrapper)) {
			return false;
		}

		RegionWrapper regionWrapper = (RegionWrapper)obj;

		if (Validator.equals(_region, regionWrapper._region)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Region getWrappedRegion() {
		return _region;
	}

	@Override
	public Region getWrappedModel() {
		return _region;
	}

	@Override
	public void resetOriginalValues() {
		_region.resetOriginalValues();
	}

	private Region _region;
}