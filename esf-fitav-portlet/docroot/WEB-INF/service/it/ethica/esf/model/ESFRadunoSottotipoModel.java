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

import java.io.Serializable;

/**
 * The base model interface for the ESFRadunoSottotipo service. Represents a row in the &quot;ESFRadunoSottotipo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.ethica.esf.model.impl.ESFRadunoSottotipoModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.ethica.esf.model.impl.ESFRadunoSottotipoImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFRadunoSottotipo
 * @see it.ethica.esf.model.impl.ESFRadunoSottotipoImpl
 * @see it.ethica.esf.model.impl.ESFRadunoSottotipoModelImpl
 * @generated
 */
public interface ESFRadunoSottotipoModel extends BaseModel<ESFRadunoSottotipo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a e s f raduno sottotipo model instance should use the {@link ESFRadunoSottotipo} interface instead.
	 */

	/**
	 * Returns the primary key of this e s f raduno sottotipo.
	 *
	 * @return the primary key of this e s f raduno sottotipo
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this e s f raduno sottotipo.
	 *
	 * @param primaryKey the primary key of this e s f raduno sottotipo
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the id_esf_raduno_sottotipo of this e s f raduno sottotipo.
	 *
	 * @return the id_esf_raduno_sottotipo of this e s f raduno sottotipo
	 */
	public long getId_esf_raduno_sottotipo();

	/**
	 * Sets the id_esf_raduno_sottotipo of this e s f raduno sottotipo.
	 *
	 * @param id_esf_raduno_sottotipo the id_esf_raduno_sottotipo of this e s f raduno sottotipo
	 */
	public void setId_esf_raduno_sottotipo(long id_esf_raduno_sottotipo);

	/**
	 * Returns the descrizione of this e s f raduno sottotipo.
	 *
	 * @return the descrizione of this e s f raduno sottotipo
	 */
	@AutoEscape
	public String getDescrizione();

	/**
	 * Sets the descrizione of this e s f raduno sottotipo.
	 *
	 * @param descrizione the descrizione of this e s f raduno sottotipo
	 */
	public void setDescrizione(String descrizione);

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
	public int compareTo(
		it.ethica.esf.model.ESFRadunoSottotipo esfRadunoSottotipo);

	@Override
	public int hashCode();

	@Override
	public CacheModel<it.ethica.esf.model.ESFRadunoSottotipo> toCacheModel();

	@Override
	public it.ethica.esf.model.ESFRadunoSottotipo toEscapedModel();

	@Override
	public it.ethica.esf.model.ESFRadunoSottotipo toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}