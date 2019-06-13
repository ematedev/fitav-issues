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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ESFRaduno}.
 * </p>
 *
 * @author Ethica
 * @see ESFRaduno
 * @generated
 */
public class ESFRadunoWrapper implements ESFRaduno, ModelWrapper<ESFRaduno> {
	public ESFRadunoWrapper(ESFRaduno esfRaduno) {
		_esfRaduno = esfRaduno;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFRaduno.class;
	}

	@Override
	public String getModelClassName() {
		return ESFRaduno.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_esf_raduno", getId_esf_raduno());
		attributes.put("codice", getCodice());
		attributes.put("data_inizio", getData_inizio());
		attributes.put("data_fine", getData_fine());
		attributes.put("tipo_raduno", getTipo_raduno());
		attributes.put("id_sottotipo_raduno", getId_sottotipo_raduno());
		attributes.put("note", getNote());
		attributes.put("id_associazione_ospitante",
			getId_associazione_ospitante());
		attributes.put("altra_sede_ospitante", getAltra_sede_ospitante());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_esf_raduno = (Long)attributes.get("id_esf_raduno");

		if (id_esf_raduno != null) {
			setId_esf_raduno(id_esf_raduno);
		}

		String codice = (String)attributes.get("codice");

		if (codice != null) {
			setCodice(codice);
		}

		Date data_inizio = (Date)attributes.get("data_inizio");

		if (data_inizio != null) {
			setData_inizio(data_inizio);
		}

		Date data_fine = (Date)attributes.get("data_fine");

		if (data_fine != null) {
			setData_fine(data_fine);
		}

		Long tipo_raduno = (Long)attributes.get("tipo_raduno");

		if (tipo_raduno != null) {
			setTipo_raduno(tipo_raduno);
		}

		Long id_sottotipo_raduno = (Long)attributes.get("id_sottotipo_raduno");

		if (id_sottotipo_raduno != null) {
			setId_sottotipo_raduno(id_sottotipo_raduno);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		Long id_associazione_ospitante = (Long)attributes.get(
				"id_associazione_ospitante");

		if (id_associazione_ospitante != null) {
			setId_associazione_ospitante(id_associazione_ospitante);
		}

		String altra_sede_ospitante = (String)attributes.get(
				"altra_sede_ospitante");

		if (altra_sede_ospitante != null) {
			setAltra_sede_ospitante(altra_sede_ospitante);
		}
	}

	/**
	* Returns the primary key of this e s f raduno.
	*
	* @return the primary key of this e s f raduno
	*/
	@Override
	public long getPrimaryKey() {
		return _esfRaduno.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f raduno.
	*
	* @param primaryKey the primary key of this e s f raduno
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfRaduno.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id_esf_raduno of this e s f raduno.
	*
	* @return the id_esf_raduno of this e s f raduno
	*/
	@Override
	public long getId_esf_raduno() {
		return _esfRaduno.getId_esf_raduno();
	}

	/**
	* Sets the id_esf_raduno of this e s f raduno.
	*
	* @param id_esf_raduno the id_esf_raduno of this e s f raduno
	*/
	@Override
	public void setId_esf_raduno(long id_esf_raduno) {
		_esfRaduno.setId_esf_raduno(id_esf_raduno);
	}

	/**
	* Returns the codice of this e s f raduno.
	*
	* @return the codice of this e s f raduno
	*/
	@Override
	public java.lang.String getCodice() {
		return _esfRaduno.getCodice();
	}

	/**
	* Sets the codice of this e s f raduno.
	*
	* @param codice the codice of this e s f raduno
	*/
	@Override
	public void setCodice(java.lang.String codice) {
		_esfRaduno.setCodice(codice);
	}

	/**
	* Returns the data_inizio of this e s f raduno.
	*
	* @return the data_inizio of this e s f raduno
	*/
	@Override
	public java.util.Date getData_inizio() {
		return _esfRaduno.getData_inizio();
	}

	/**
	* Sets the data_inizio of this e s f raduno.
	*
	* @param data_inizio the data_inizio of this e s f raduno
	*/
	@Override
	public void setData_inizio(java.util.Date data_inizio) {
		_esfRaduno.setData_inizio(data_inizio);
	}

	/**
	* Returns the data_fine of this e s f raduno.
	*
	* @return the data_fine of this e s f raduno
	*/
	@Override
	public java.util.Date getData_fine() {
		return _esfRaduno.getData_fine();
	}

	/**
	* Sets the data_fine of this e s f raduno.
	*
	* @param data_fine the data_fine of this e s f raduno
	*/
	@Override
	public void setData_fine(java.util.Date data_fine) {
		_esfRaduno.setData_fine(data_fine);
	}

	/**
	* Returns the tipo_raduno of this e s f raduno.
	*
	* @return the tipo_raduno of this e s f raduno
	*/
	@Override
	public long getTipo_raduno() {
		return _esfRaduno.getTipo_raduno();
	}

	/**
	* Sets the tipo_raduno of this e s f raduno.
	*
	* @param tipo_raduno the tipo_raduno of this e s f raduno
	*/
	@Override
	public void setTipo_raduno(long tipo_raduno) {
		_esfRaduno.setTipo_raduno(tipo_raduno);
	}

	/**
	* Returns the id_sottotipo_raduno of this e s f raduno.
	*
	* @return the id_sottotipo_raduno of this e s f raduno
	*/
	@Override
	public long getId_sottotipo_raduno() {
		return _esfRaduno.getId_sottotipo_raduno();
	}

	/**
	* Sets the id_sottotipo_raduno of this e s f raduno.
	*
	* @param id_sottotipo_raduno the id_sottotipo_raduno of this e s f raduno
	*/
	@Override
	public void setId_sottotipo_raduno(long id_sottotipo_raduno) {
		_esfRaduno.setId_sottotipo_raduno(id_sottotipo_raduno);
	}

	/**
	* Returns the note of this e s f raduno.
	*
	* @return the note of this e s f raduno
	*/
	@Override
	public java.lang.String getNote() {
		return _esfRaduno.getNote();
	}

	/**
	* Sets the note of this e s f raduno.
	*
	* @param note the note of this e s f raduno
	*/
	@Override
	public void setNote(java.lang.String note) {
		_esfRaduno.setNote(note);
	}

	/**
	* Returns the id_associazione_ospitante of this e s f raduno.
	*
	* @return the id_associazione_ospitante of this e s f raduno
	*/
	@Override
	public long getId_associazione_ospitante() {
		return _esfRaduno.getId_associazione_ospitante();
	}

	/**
	* Sets the id_associazione_ospitante of this e s f raduno.
	*
	* @param id_associazione_ospitante the id_associazione_ospitante of this e s f raduno
	*/
	@Override
	public void setId_associazione_ospitante(long id_associazione_ospitante) {
		_esfRaduno.setId_associazione_ospitante(id_associazione_ospitante);
	}

	/**
	* Returns the altra_sede_ospitante of this e s f raduno.
	*
	* @return the altra_sede_ospitante of this e s f raduno
	*/
	@Override
	public java.lang.String getAltra_sede_ospitante() {
		return _esfRaduno.getAltra_sede_ospitante();
	}

	/**
	* Sets the altra_sede_ospitante of this e s f raduno.
	*
	* @param altra_sede_ospitante the altra_sede_ospitante of this e s f raduno
	*/
	@Override
	public void setAltra_sede_ospitante(java.lang.String altra_sede_ospitante) {
		_esfRaduno.setAltra_sede_ospitante(altra_sede_ospitante);
	}

	@Override
	public boolean isNew() {
		return _esfRaduno.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfRaduno.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfRaduno.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfRaduno.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfRaduno.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfRaduno.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfRaduno.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfRaduno.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfRaduno.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfRaduno.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfRaduno.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFRadunoWrapper((ESFRaduno)_esfRaduno.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFRaduno esfRaduno) {
		return _esfRaduno.compareTo(esfRaduno);
	}

	@Override
	public int hashCode() {
		return _esfRaduno.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFRaduno> toCacheModel() {
		return _esfRaduno.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFRaduno toEscapedModel() {
		return new ESFRadunoWrapper(_esfRaduno.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFRaduno toUnescapedModel() {
		return new ESFRadunoWrapper(_esfRaduno.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfRaduno.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfRaduno.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfRaduno.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFRadunoWrapper)) {
			return false;
		}

		ESFRadunoWrapper esfRadunoWrapper = (ESFRadunoWrapper)obj;

		if (Validator.equals(_esfRaduno, esfRadunoWrapper._esfRaduno)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFRaduno getWrappedESFRaduno() {
		return _esfRaduno;
	}

	@Override
	public ESFRaduno getWrappedModel() {
		return _esfRaduno;
	}

	@Override
	public void resetOriginalValues() {
		_esfRaduno.resetOriginalValues();
	}

	private ESFRaduno _esfRaduno;
}