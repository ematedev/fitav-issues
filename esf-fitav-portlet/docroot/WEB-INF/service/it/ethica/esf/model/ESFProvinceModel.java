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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import it.ethica.esf.service.persistence.ESFProvincePK;

import java.io.Serializable;

/**
 * The base model interface for the ESFProvince service. Represents a row in the &quot;ESFProvince&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.ethica.esf.model.impl.ESFProvinceModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.ethica.esf.model.impl.ESFProvinceImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFProvince
 * @see it.ethica.esf.model.impl.ESFProvinceImpl
 * @see it.ethica.esf.model.impl.ESFProvinceModelImpl
 * @generated
 */
public interface ESFProvinceModel extends BaseModel<ESFProvince> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a e s f province model instance should use the {@link ESFProvince} interface instead.
	 */

	/**
	 * Returns the primary key of this e s f province.
	 *
	 * @return the primary key of this e s f province
	 */
	public ESFProvincePK getPrimaryKey();

	/**
	 * Sets the primary key of this e s f province.
	 *
	 * @param primaryKey the primary key of this e s f province
	 */
	public void setPrimaryKey(ESFProvincePK primaryKey);

	/**
	 * Returns the id province of this e s f province.
	 *
	 * @return the id province of this e s f province
	 */
	@AutoEscape
	public String getIdProvince();

	/**
	 * Sets the id province of this e s f province.
	 *
	 * @param idProvince the id province of this e s f province
	 */
	public void setIdProvince(String idProvince);

	/**
	 * Returns the id region of this e s f province.
	 *
	 * @return the id region of this e s f province
	 */
	@AutoEscape
	public String getIdRegion();

	/**
	 * Sets the id region of this e s f province.
	 *
	 * @param idRegion the id region of this e s f province
	 */
	public void setIdRegion(String idRegion);

	/**
	 * Returns the id country of this e s f province.
	 *
	 * @return the id country of this e s f province
	 */
	@AutoEscape
	public String getIdCountry();

	/**
	 * Sets the id country of this e s f province.
	 *
	 * @param idCountry the id country of this e s f province
	 */
	public void setIdCountry(String idCountry);

	/**
	 * Returns the name of this e s f province.
	 *
	 * @return the name of this e s f province
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this e s f province.
	 *
	 * @param name the name of this e s f province
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
	public int compareTo(ESFProvince esfProvince);

	@Override
	public int hashCode();

	@Override
	public CacheModel<ESFProvince> toCacheModel();

	@Override
	public ESFProvince toEscapedModel();

	@Override
	public ESFProvince toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}