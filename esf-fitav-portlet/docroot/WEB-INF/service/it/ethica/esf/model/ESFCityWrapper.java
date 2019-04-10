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
 * This class is a wrapper for {@link ESFCity}.
 * </p>
 *
 * @author Ethica
 * @see ESFCity
 * @generated
 */
public class ESFCityWrapper implements ESFCity, ModelWrapper<ESFCity> {
	public ESFCityWrapper(ESFCity esfCity) {
		_esfCity = esfCity;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFCity.class;
	}

	@Override
	public String getModelClassName() {
		return ESFCity.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idCity", getIdCity());
		attributes.put("idProvince", getIdProvince());
		attributes.put("idRegion", getIdRegion());
		attributes.put("idCountry", getIdCountry());
		attributes.put("zip", getZip());
		attributes.put("name", getName());
		attributes.put("latitude", getLatitude());
		attributes.put("longitude", getLongitude());
		attributes.put("altitude", getAltitude());
		attributes.put("website", getWebsite());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long idCity = (Long)attributes.get("idCity");

		if (idCity != null) {
			setIdCity(idCity);
		}

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

		Long zip = (Long)attributes.get("zip");

		if (zip != null) {
			setZip(zip);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Double latitude = (Double)attributes.get("latitude");

		if (latitude != null) {
			setLatitude(latitude);
		}

		Double longitude = (Double)attributes.get("longitude");

		if (longitude != null) {
			setLongitude(longitude);
		}

		Double altitude = (Double)attributes.get("altitude");

		if (altitude != null) {
			setAltitude(altitude);
		}

		String website = (String)attributes.get("website");

		if (website != null) {
			setWebsite(website);
		}
	}

	/**
	* Returns the primary key of this e s f city.
	*
	* @return the primary key of this e s f city
	*/
	@Override
	public it.ethica.esf.service.persistence.ESFCityPK getPrimaryKey() {
		return _esfCity.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f city.
	*
	* @param primaryKey the primary key of this e s f city
	*/
	@Override
	public void setPrimaryKey(
		it.ethica.esf.service.persistence.ESFCityPK primaryKey) {
		_esfCity.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id city of this e s f city.
	*
	* @return the id city of this e s f city
	*/
	@Override
	public long getIdCity() {
		return _esfCity.getIdCity();
	}

	/**
	* Sets the id city of this e s f city.
	*
	* @param idCity the id city of this e s f city
	*/
	@Override
	public void setIdCity(long idCity) {
		_esfCity.setIdCity(idCity);
	}

	/**
	* Returns the id province of this e s f city.
	*
	* @return the id province of this e s f city
	*/
	@Override
	public java.lang.String getIdProvince() {
		return _esfCity.getIdProvince();
	}

	/**
	* Sets the id province of this e s f city.
	*
	* @param idProvince the id province of this e s f city
	*/
	@Override
	public void setIdProvince(java.lang.String idProvince) {
		_esfCity.setIdProvince(idProvince);
	}

	/**
	* Returns the id region of this e s f city.
	*
	* @return the id region of this e s f city
	*/
	@Override
	public java.lang.String getIdRegion() {
		return _esfCity.getIdRegion();
	}

	/**
	* Sets the id region of this e s f city.
	*
	* @param idRegion the id region of this e s f city
	*/
	@Override
	public void setIdRegion(java.lang.String idRegion) {
		_esfCity.setIdRegion(idRegion);
	}

	/**
	* Returns the id country of this e s f city.
	*
	* @return the id country of this e s f city
	*/
	@Override
	public java.lang.String getIdCountry() {
		return _esfCity.getIdCountry();
	}

	/**
	* Sets the id country of this e s f city.
	*
	* @param idCountry the id country of this e s f city
	*/
	@Override
	public void setIdCountry(java.lang.String idCountry) {
		_esfCity.setIdCountry(idCountry);
	}

	/**
	* Returns the zip of this e s f city.
	*
	* @return the zip of this e s f city
	*/
	@Override
	public long getZip() {
		return _esfCity.getZip();
	}

	/**
	* Sets the zip of this e s f city.
	*
	* @param zip the zip of this e s f city
	*/
	@Override
	public void setZip(long zip) {
		_esfCity.setZip(zip);
	}

	/**
	* Returns the name of this e s f city.
	*
	* @return the name of this e s f city
	*/
	@Override
	public java.lang.String getName() {
		return _esfCity.getName();
	}

	/**
	* Sets the name of this e s f city.
	*
	* @param name the name of this e s f city
	*/
	@Override
	public void setName(java.lang.String name) {
		_esfCity.setName(name);
	}

	/**
	* Returns the latitude of this e s f city.
	*
	* @return the latitude of this e s f city
	*/
	@Override
	public double getLatitude() {
		return _esfCity.getLatitude();
	}

	/**
	* Sets the latitude of this e s f city.
	*
	* @param latitude the latitude of this e s f city
	*/
	@Override
	public void setLatitude(double latitude) {
		_esfCity.setLatitude(latitude);
	}

	/**
	* Returns the longitude of this e s f city.
	*
	* @return the longitude of this e s f city
	*/
	@Override
	public double getLongitude() {
		return _esfCity.getLongitude();
	}

	/**
	* Sets the longitude of this e s f city.
	*
	* @param longitude the longitude of this e s f city
	*/
	@Override
	public void setLongitude(double longitude) {
		_esfCity.setLongitude(longitude);
	}

	/**
	* Returns the altitude of this e s f city.
	*
	* @return the altitude of this e s f city
	*/
	@Override
	public double getAltitude() {
		return _esfCity.getAltitude();
	}

	/**
	* Sets the altitude of this e s f city.
	*
	* @param altitude the altitude of this e s f city
	*/
	@Override
	public void setAltitude(double altitude) {
		_esfCity.setAltitude(altitude);
	}

	/**
	* Returns the website of this e s f city.
	*
	* @return the website of this e s f city
	*/
	@Override
	public java.lang.String getWebsite() {
		return _esfCity.getWebsite();
	}

	/**
	* Sets the website of this e s f city.
	*
	* @param website the website of this e s f city
	*/
	@Override
	public void setWebsite(java.lang.String website) {
		_esfCity.setWebsite(website);
	}

	@Override
	public boolean isNew() {
		return _esfCity.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfCity.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfCity.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfCity.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfCity.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfCity.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfCity.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfCity.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfCity.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfCity.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfCity.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFCityWrapper((ESFCity)_esfCity.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFCity esfCity) {
		return _esfCity.compareTo(esfCity);
	}

	@Override
	public int hashCode() {
		return _esfCity.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFCity> toCacheModel() {
		return _esfCity.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFCity toEscapedModel() {
		return new ESFCityWrapper(_esfCity.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFCity toUnescapedModel() {
		return new ESFCityWrapper(_esfCity.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfCity.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfCity.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfCity.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFCityWrapper)) {
			return false;
		}

		ESFCityWrapper esfCityWrapper = (ESFCityWrapper)obj;

		if (Validator.equals(_esfCity, esfCityWrapper._esfCity)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFCity getWrappedESFCity() {
		return _esfCity;
	}

	@Override
	public ESFCity getWrappedModel() {
		return _esfCity;
	}

	@Override
	public void resetOriginalValues() {
		_esfCity.resetOriginalValues();
	}

	private ESFCity _esfCity;
}