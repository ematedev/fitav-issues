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

import java.util.Date;

/**
 * The base model interface for the ESFRaduno service. Represents a row in the &quot;ESFRaduno&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.ethica.esf.model.impl.ESFRadunoModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.ethica.esf.model.impl.ESFRadunoImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFRaduno
 * @see it.ethica.esf.model.impl.ESFRadunoImpl
 * @see it.ethica.esf.model.impl.ESFRadunoModelImpl
 * @generated
 */
public interface ESFRadunoModel extends BaseModel<ESFRaduno> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a e s f raduno model instance should use the {@link ESFRaduno} interface instead.
	 */

	/**
	 * Returns the primary key of this e s f raduno.
	 *
	 * @return the primary key of this e s f raduno
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this e s f raduno.
	 *
	 * @param primaryKey the primary key of this e s f raduno
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the id_esf_raduno of this e s f raduno.
	 *
	 * @return the id_esf_raduno of this e s f raduno
	 */
	public long getId_esf_raduno();

	/**
	 * Sets the id_esf_raduno of this e s f raduno.
	 *
	 * @param id_esf_raduno the id_esf_raduno of this e s f raduno
	 */
	public void setId_esf_raduno(long id_esf_raduno);

	/**
	 * Returns the codice of this e s f raduno.
	 *
	 * @return the codice of this e s f raduno
	 */
	@AutoEscape
	public String getCodice();

	/**
	 * Sets the codice of this e s f raduno.
	 *
	 * @param codice the codice of this e s f raduno
	 */
	public void setCodice(String codice);

	/**
	 * Returns the data_inizio of this e s f raduno.
	 *
	 * @return the data_inizio of this e s f raduno
	 */
	public Date getData_inizio();

	/**
	 * Sets the data_inizio of this e s f raduno.
	 *
	 * @param data_inizio the data_inizio of this e s f raduno
	 */
	public void setData_inizio(Date data_inizio);

	/**
	 * Returns the data_fine of this e s f raduno.
	 *
	 * @return the data_fine of this e s f raduno
	 */
	public Date getData_fine();

	/**
	 * Sets the data_fine of this e s f raduno.
	 *
	 * @param data_fine the data_fine of this e s f raduno
	 */
	public void setData_fine(Date data_fine);

	/**
	 * Returns the tipo_raduno of this e s f raduno.
	 *
	 * @return the tipo_raduno of this e s f raduno
	 */
	public long getTipo_raduno();

	/**
	 * Sets the tipo_raduno of this e s f raduno.
	 *
	 * @param tipo_raduno the tipo_raduno of this e s f raduno
	 */
	public void setTipo_raduno(long tipo_raduno);

	/**
	 * Returns the id_sottotipo_raduno of this e s f raduno.
	 *
	 * @return the id_sottotipo_raduno of this e s f raduno
	 */
	public long getId_sottotipo_raduno();

	/**
	 * Sets the id_sottotipo_raduno of this e s f raduno.
	 *
	 * @param id_sottotipo_raduno the id_sottotipo_raduno of this e s f raduno
	 */
	public void setId_sottotipo_raduno(long id_sottotipo_raduno);

	/**
	 * Returns the note of this e s f raduno.
	 *
	 * @return the note of this e s f raduno
	 */
	@AutoEscape
	public String getNote();

	/**
	 * Sets the note of this e s f raduno.
	 *
	 * @param note the note of this e s f raduno
	 */
	public void setNote(String note);

	/**
	 * Returns the id_associazione_ospitante of this e s f raduno.
	 *
	 * @return the id_associazione_ospitante of this e s f raduno
	 */
	public long getId_associazione_ospitante();

	/**
	 * Sets the id_associazione_ospitante of this e s f raduno.
	 *
	 * @param id_associazione_ospitante the id_associazione_ospitante of this e s f raduno
	 */
	public void setId_associazione_ospitante(long id_associazione_ospitante);

	/**
	 * Returns the altra_sede_ospitante of this e s f raduno.
	 *
	 * @return the altra_sede_ospitante of this e s f raduno
	 */
	@AutoEscape
	public String getAltra_sede_ospitante();

	/**
	 * Sets the altra_sede_ospitante of this e s f raduno.
	 *
	 * @param altra_sede_ospitante the altra_sede_ospitante of this e s f raduno
	 */
	public void setAltra_sede_ospitante(String altra_sede_ospitante);

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
	public int compareTo(it.ethica.esf.model.ESFRaduno esfRaduno);

	@Override
	public int hashCode();

	@Override
	public CacheModel<it.ethica.esf.model.ESFRaduno> toCacheModel();

	@Override
	public it.ethica.esf.model.ESFRaduno toEscapedModel();

	@Override
	public it.ethica.esf.model.ESFRaduno toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}