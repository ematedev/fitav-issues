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

import it.ethica.esf.service.persistence.ProvincePK;

import java.io.Serializable;

/**
 * The base model interface for the Province service. Represents a row in the &quot;Province&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.ethica.esf.model.impl.ProvinceModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.ethica.esf.model.impl.ProvinceImpl}.
 * </p>
 *
 * @author Ethica
 * @see Province
 * @see it.ethica.esf.model.impl.ProvinceImpl
 * @see it.ethica.esf.model.impl.ProvinceModelImpl
 * @generated
 */
public interface ProvinceModel extends BaseModel<Province> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a province model instance should use the {@link Province} interface instead.
	 */

	/**
	 * Returns the primary key of this province.
	 *
	 * @return the primary key of this province
	 */
	public ProvincePK getPrimaryKey();

	/**
	 * Sets the primary key of this province.
	 *
	 * @param primaryKey the primary key of this province
	 */
	public void setPrimaryKey(ProvincePK primaryKey);

	/**
	 * Returns the id province of this province.
	 *
	 * @return the id province of this province
	 */
	@AutoEscape
	public String getIdProvince();

	/**
	 * Sets the id province of this province.
	 *
	 * @param idProvince the id province of this province
	 */
	public void setIdProvince(String idProvince);

	/**
	 * Returns the id region of this province.
	 *
	 * @return the id region of this province
	 */
	@AutoEscape
	public String getIdRegion();

	/**
	 * Sets the id region of this province.
	 *
	 * @param idRegion the id region of this province
	 */
	public void setIdRegion(String idRegion);

	/**
	 * Returns the id country of this province.
	 *
	 * @return the id country of this province
	 */
	@AutoEscape
	public String getIdCountry();

	/**
	 * Sets the id country of this province.
	 *
	 * @param idCountry the id country of this province
	 */
	public void setIdCountry(String idCountry);

	/**
	 * Returns the name of this province.
	 *
	 * @return the name of this province
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this province.
	 *
	 * @param name the name of this province
	 */
	public void setName(String name);

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
	public int compareTo(Province province);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Province> toCacheModel();

	@Override
	public Province toEscapedModel();

	@Override
	public Province toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}