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
 * This class is a wrapper for {@link City}.
 * </p>
 *
 * @author Ethica
 * @see City
 * @generated
 */
public class CityWrapper implements City, ModelWrapper<City> {
	public CityWrapper(City city) {
		_city = city;
	}

	@Override
	public Class<?> getModelClass() {
		return City.class;
	}

	@Override
	public String getModelClassName() {
		return City.class.getName();
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
	* Returns the primary key of this city.
	*
	* @return the primary key of this city
	*/
	@Override
	public it.ethica.esf.service.persistence.CityPK getPrimaryKey() {
		return _city.getPrimaryKey();
	}

	/**
	* Sets the primary key of this city.
	*
	* @param primaryKey the primary key of this city
	*/
	@Override
	public void setPrimaryKey(
		it.ethica.esf.service.persistence.CityPK primaryKey) {
		_city.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id city of this city.
	*
	* @return the id city of this city
	*/
	@Override
	public long getIdCity() {
		return _city.getIdCity();
	}

	/**
	* Sets the id city of this city.
	*
	* @param idCity the id city of this city
	*/
	@Override
	public void setIdCity(long idCity) {
		_city.setIdCity(idCity);
	}

	/**
	* Returns the id province of this city.
	*
	* @return the id province of this city
	*/
	@Override
	public java.lang.String getIdProvince() {
		return _city.getIdProvince();
	}

	/**
	* Sets the id province of this city.
	*
	* @param idProvince the id province of this city
	*/
	@Override
	public void setIdProvince(java.lang.String idProvince) {
		_city.setIdProvince(idProvince);
	}

	/**
	* Returns the id region of this city.
	*
	* @return the id region of this city
	*/
	@Override
	public java.lang.String getIdRegion() {
		return _city.getIdRegion();
	}

	/**
	* Sets the id region of this city.
	*
	* @param idRegion the id region of this city
	*/
	@Override
	public void setIdRegion(java.lang.String idRegion) {
		_city.setIdRegion(idRegion);
	}

	/**
	* Returns the id country of this city.
	*
	* @return the id country of this city
	*/
	@Override
	public java.lang.String getIdCountry() {
		return _city.getIdCountry();
	}

	/**
	* Sets the id country of this city.
	*
	* @param idCountry the id country of this city
	*/
	@Override
	public void setIdCountry(java.lang.String idCountry) {
		_city.setIdCountry(idCountry);
	}

	/**
	* Returns the zip of this city.
	*
	* @return the zip of this city
	*/
	@Override
	public long getZip() {
		return _city.getZip();
	}

	/**
	* Sets the zip of this city.
	*
	* @param zip the zip of this city
	*/
	@Override
	public void setZip(long zip) {
		_city.setZip(zip);
	}

	/**
	* Returns the name of this city.
	*
	* @return the name of this city
	*/
	@Override
	public java.lang.String getName() {
		return _city.getName();
	}

	/**
	* Sets the name of this city.
	*
	* @param name the name of this city
	*/
	@Override
	public void setName(java.lang.String name) {
		_city.setName(name);
	}

	/**
	* Returns the latitude of this city.
	*
	* @return the latitude of this city
	*/
	@Override
	public double getLatitude() {
		return _city.getLatitude();
	}

	/**
	* Sets the latitude of this city.
	*
	* @param latitude the latitude of this city
	*/
	@Override
	public void setLatitude(double latitude) {
		_city.setLatitude(latitude);
	}

	/**
	* Returns the longitude of this city.
	*
	* @return the longitude of this city
	*/
	@Override
	public double getLongitude() {
		return _city.getLongitude();
	}

	/**
	* Sets the longitude of this city.
	*
	* @param longitude the longitude of this city
	*/
	@Override
	public void setLongitude(double longitude) {
		_city.setLongitude(longitude);
	}

	/**
	* Returns the altitude of this city.
	*
	* @return the altitude of this city
	*/
	@Override
	public double getAltitude() {
		return _city.getAltitude();
	}

	/**
	* Sets the altitude of this city.
	*
	* @param altitude the altitude of this city
	*/
	@Override
	public void setAltitude(double altitude) {
		_city.setAltitude(altitude);
	}

	/**
	* Returns the website of this city.
	*
	* @return the website of this city
	*/
	@Override
	public java.lang.String getWebsite() {
		return _city.getWebsite();
	}

	/**
	* Sets the website of this city.
	*
	* @param website the website of this city
	*/
	@Override
	public void setWebsite(java.lang.String website) {
		_city.setWebsite(website);
	}

	@Override
	public boolean isNew() {
		return _city.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_city.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _city.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_city.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _city.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _city.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_city.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _city.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_city.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_city.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_city.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CityWrapper((City)_city.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.City city) {
		return _city.compareTo(city);
	}

	@Override
	public int hashCode() {
		return _city.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.City> toCacheModel() {
		return _city.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.City toEscapedModel() {
		return new CityWrapper(_city.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.City toUnescapedModel() {
		return new CityWrapper(_city.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _city.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _city.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_city.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CityWrapper)) {
			return false;
		}

		CityWrapper cityWrapper = (CityWrapper)obj;

		if (Validator.equals(_city, cityWrapper._city)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public City getWrappedCity() {
		return _city;
	}

	@Override
	public City getWrappedModel() {
		return _city;
	}

	@Override
	public void resetOriginalValues() {
		_city.resetOriginalValues();
	}

	private City _city;
}