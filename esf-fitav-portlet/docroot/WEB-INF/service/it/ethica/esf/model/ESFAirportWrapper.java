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
 * This class is a wrapper for {@link ESFAirport}.
 * </p>
 *
 * @author Ethica
 * @see ESFAirport
 * @generated
 */
public class ESFAirportWrapper implements ESFAirport, ModelWrapper<ESFAirport> {
	public ESFAirportWrapper(ESFAirport esfAirport) {
		_esfAirport = esfAirport;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFAirport.class;
	}

	@Override
	public String getModelClassName() {
		return ESFAirport.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfAirportId", getEsfAirportId());
		attributes.put("name", getName());
		attributes.put("city", getCity());
		attributes.put("country", getCountry());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfAirportId = (Long)attributes.get("esfAirportId");

		if (esfAirportId != null) {
			setEsfAirportId(esfAirportId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}
	}

	/**
	* Returns the primary key of this e s f airport.
	*
	* @return the primary key of this e s f airport
	*/
	@Override
	public long getPrimaryKey() {
		return _esfAirport.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f airport.
	*
	* @param primaryKey the primary key of this e s f airport
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfAirport.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf airport ID of this e s f airport.
	*
	* @return the esf airport ID of this e s f airport
	*/
	@Override
	public long getEsfAirportId() {
		return _esfAirport.getEsfAirportId();
	}

	/**
	* Sets the esf airport ID of this e s f airport.
	*
	* @param esfAirportId the esf airport ID of this e s f airport
	*/
	@Override
	public void setEsfAirportId(long esfAirportId) {
		_esfAirport.setEsfAirportId(esfAirportId);
	}

	/**
	* Returns the name of this e s f airport.
	*
	* @return the name of this e s f airport
	*/
	@Override
	public java.lang.String getName() {
		return _esfAirport.getName();
	}

	/**
	* Sets the name of this e s f airport.
	*
	* @param name the name of this e s f airport
	*/
	@Override
	public void setName(java.lang.String name) {
		_esfAirport.setName(name);
	}

	/**
	* Returns the city of this e s f airport.
	*
	* @return the city of this e s f airport
	*/
	@Override
	public java.lang.String getCity() {
		return _esfAirport.getCity();
	}

	/**
	* Sets the city of this e s f airport.
	*
	* @param city the city of this e s f airport
	*/
	@Override
	public void setCity(java.lang.String city) {
		_esfAirport.setCity(city);
	}

	/**
	* Returns the country of this e s f airport.
	*
	* @return the country of this e s f airport
	*/
	@Override
	public java.lang.String getCountry() {
		return _esfAirport.getCountry();
	}

	/**
	* Sets the country of this e s f airport.
	*
	* @param country the country of this e s f airport
	*/
	@Override
	public void setCountry(java.lang.String country) {
		_esfAirport.setCountry(country);
	}

	@Override
	public boolean isNew() {
		return _esfAirport.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfAirport.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfAirport.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfAirport.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfAirport.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfAirport.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfAirport.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfAirport.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfAirport.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfAirport.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfAirport.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFAirportWrapper((ESFAirport)_esfAirport.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFAirport esfAirport) {
		return _esfAirport.compareTo(esfAirport);
	}

	@Override
	public int hashCode() {
		return _esfAirport.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFAirport> toCacheModel() {
		return _esfAirport.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFAirport toEscapedModel() {
		return new ESFAirportWrapper(_esfAirport.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFAirport toUnescapedModel() {
		return new ESFAirportWrapper(_esfAirport.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfAirport.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfAirport.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfAirport.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFAirportWrapper)) {
			return false;
		}

		ESFAirportWrapper esfAirportWrapper = (ESFAirportWrapper)obj;

		if (Validator.equals(_esfAirport, esfAirportWrapper._esfAirport)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFAirport getWrappedESFAirport() {
		return _esfAirport;
	}

	@Override
	public ESFAirport getWrappedModel() {
		return _esfAirport;
	}

	@Override
	public void resetOriginalValues() {
		_esfAirport.resetOriginalValues();
	}

	private ESFAirport _esfAirport;
}