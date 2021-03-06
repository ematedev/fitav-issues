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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import it.ethica.esf.service.persistence.CityPK;

import java.io.Serializable;

/**
 * The base model interface for the City service. Represents a row in the &quot;ESF_City&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.ethica.esf.model.impl.CityModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.ethica.esf.model.impl.CityImpl}.
 * </p>
 *
 * @author Ethica
 * @see City
 * @see it.ethica.esf.model.impl.CityImpl
 * @see it.ethica.esf.model.impl.CityModelImpl
 * @generated
 */
public interface CityModel extends BaseModel<City> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a city model instance should use the {@link City} interface instead.
	 */

	/**
	 * Returns the primary key of this city.
	 *
	 * @return the primary key of this city
	 */
	public CityPK getPrimaryKey();

	/**
	 * Sets the primary key of this city.
	 *
	 * @param primaryKey the primary key of this city
	 */
	public void setPrimaryKey(CityPK primaryKey);

	/**
	 * Returns the id city of this city.
	 *
	 * @return the id city of this city
	 */
	public long getIdCity();

	/**
	 * Sets the id city of this city.
	 *
	 * @param idCity the id city of this city
	 */
	public void setIdCity(long idCity);

	/**
	 * Returns the id province of this city.
	 *
	 * @return the id province of this city
	 */
	@AutoEscape
	public String getIdProvince();

	/**
	 * Sets the id province of this city.
	 *
	 * @param idProvince the id province of this city
	 */
	public void setIdProvince(String idProvince);

	/**
	 * Returns the id region of this city.
	 *
	 * @return the id region of this city
	 */
	@AutoEscape
	public String getIdRegion();

	/**
	 * Sets the id region of this city.
	 *
	 * @param idRegion the id region of this city
	 */
	public void setIdRegion(String idRegion);

	/**
	 * Returns the id country of this city.
	 *
	 * @return the id country of this city
	 */
	@AutoEscape
	public String getIdCountry();

	/**
	 * Sets the id country of this city.
	 *
	 * @param idCountry the id country of this city
	 */
	public void setIdCountry(String idCountry);

	/**
	 * Returns the zip of this city.
	 *
	 * @return the zip of this city
	 */
	public long getZip();

	/**
	 * Sets the zip of this city.
	 *
	 * @param zip the zip of this city
	 */
	public void setZip(long zip);

	/**
	 * Returns the name of this city.
	 *
	 * @return the name of this city
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this city.
	 *
	 * @param name the name of this city
	 */
	public void setName(String name);

	/**
	 * Returns the latitude of this city.
	 *
	 * @return the latitude of this city
	 */
	public double getLatitude();

	/**
	 * Sets the latitude of this city.
	 *
	 * @param latitude the latitude of this city
	 */
	public void setLatitude(double latitude);

	/**
	 * Returns the longitude of this city.
	 *
	 * @return the longitude of this city
	 */
	public double getLongitude();

	/**
	 * Sets the longitude of this city.
	 *
	 * @param longitude the longitude of this city
	 */
	public void setLongitude(double longitude);

	/**
	 * Returns the altitude of this city.
	 *
	 * @return the altitude of this city
	 */
	public double getAltitude();

	/**
	 * Sets the altitude of this city.
	 *
	 * @param altitude the altitude of this city
	 */
	public void setAltitude(double altitude);

	/**
	 * Returns the website of this city.
	 *
	 * @return the website of this city
	 */
	@AutoEscape
	public String getWebsite();

	/**
	 * Sets the website of this city.
	 *
	 * @param website the website of this city
	 */
	public void setWebsite(String website);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(City city);

	@Override
	public int hashCode();

	@Override
	public CacheModel<City> toCacheModel();

	@Override
	public City toEscapedModel();

	@Override
	public City toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}