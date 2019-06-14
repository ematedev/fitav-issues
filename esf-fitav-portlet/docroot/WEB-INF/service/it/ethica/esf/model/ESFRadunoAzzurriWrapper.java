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
 * This class is a wrapper for {@link ESFRadunoAzzurri}.
 * </p>
 *
 * @author Ethica
 * @see ESFRadunoAzzurri
 * @generated
 */
public class ESFRadunoAzzurriWrapper implements ESFRadunoAzzurri,
	ModelWrapper<ESFRadunoAzzurri> {
	public ESFRadunoAzzurriWrapper(ESFRadunoAzzurri esfRadunoAzzurri) {
		_esfRadunoAzzurri = esfRadunoAzzurri;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFRadunoAzzurri.class;
	}

	@Override
	public String getModelClassName() {
		return ESFRadunoAzzurri.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_esf_raduno_azzurri", getId_esf_raduno_azzurri());
		attributes.put("id_esf_raduno", getId_esf_raduno());
		attributes.put("esf_national_id", getEsf_national_id());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_esf_raduno_azzurri = (Long)attributes.get(
				"id_esf_raduno_azzurri");

		if (id_esf_raduno_azzurri != null) {
			setId_esf_raduno_azzurri(id_esf_raduno_azzurri);
		}

		Long id_esf_raduno = (Long)attributes.get("id_esf_raduno");

		if (id_esf_raduno != null) {
			setId_esf_raduno(id_esf_raduno);
		}

		Long esf_national_id = (Long)attributes.get("esf_national_id");

		if (esf_national_id != null) {
			setEsf_national_id(esf_national_id);
		}
	}

	/**
	* Returns the primary key of this e s f raduno azzurri.
	*
	* @return the primary key of this e s f raduno azzurri
	*/
	@Override
	public it.ethica.esf.service.persistence.ESFRadunoAzzurriPK getPrimaryKey() {
		return _esfRadunoAzzurri.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f raduno azzurri.
	*
	* @param primaryKey the primary key of this e s f raduno azzurri
	*/
	@Override
	public void setPrimaryKey(
		it.ethica.esf.service.persistence.ESFRadunoAzzurriPK primaryKey) {
		_esfRadunoAzzurri.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id_esf_raduno_azzurri of this e s f raduno azzurri.
	*
	* @return the id_esf_raduno_azzurri of this e s f raduno azzurri
	*/
	@Override
	public long getId_esf_raduno_azzurri() {
		return _esfRadunoAzzurri.getId_esf_raduno_azzurri();
	}

	/**
	* Sets the id_esf_raduno_azzurri of this e s f raduno azzurri.
	*
	* @param id_esf_raduno_azzurri the id_esf_raduno_azzurri of this e s f raduno azzurri
	*/
	@Override
	public void setId_esf_raduno_azzurri(long id_esf_raduno_azzurri) {
		_esfRadunoAzzurri.setId_esf_raduno_azzurri(id_esf_raduno_azzurri);
	}

	/**
	* Returns the id_esf_raduno of this e s f raduno azzurri.
	*
	* @return the id_esf_raduno of this e s f raduno azzurri
	*/
	@Override
	public long getId_esf_raduno() {
		return _esfRadunoAzzurri.getId_esf_raduno();
	}

	/**
	* Sets the id_esf_raduno of this e s f raduno azzurri.
	*
	* @param id_esf_raduno the id_esf_raduno of this e s f raduno azzurri
	*/
	@Override
	public void setId_esf_raduno(long id_esf_raduno) {
		_esfRadunoAzzurri.setId_esf_raduno(id_esf_raduno);
	}

	/**
	* Returns the esf_national_id of this e s f raduno azzurri.
	*
	* @return the esf_national_id of this e s f raduno azzurri
	*/
	@Override
	public long getEsf_national_id() {
		return _esfRadunoAzzurri.getEsf_national_id();
	}

	/**
	* Sets the esf_national_id of this e s f raduno azzurri.
	*
	* @param esf_national_id the esf_national_id of this e s f raduno azzurri
	*/
	@Override
	public void setEsf_national_id(long esf_national_id) {
		_esfRadunoAzzurri.setEsf_national_id(esf_national_id);
	}

	@Override
	public boolean isNew() {
		return _esfRadunoAzzurri.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfRadunoAzzurri.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfRadunoAzzurri.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfRadunoAzzurri.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfRadunoAzzurri.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfRadunoAzzurri.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfRadunoAzzurri.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfRadunoAzzurri.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfRadunoAzzurri.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfRadunoAzzurri.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfRadunoAzzurri.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFRadunoAzzurriWrapper((ESFRadunoAzzurri)_esfRadunoAzzurri.clone());
	}

	@Override
	public int compareTo(ESFRadunoAzzurri esfRadunoAzzurri) {
		return _esfRadunoAzzurri.compareTo(esfRadunoAzzurri);
	}

	@Override
	public int hashCode() {
		return _esfRadunoAzzurri.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<ESFRadunoAzzurri> toCacheModel() {
		return _esfRadunoAzzurri.toCacheModel();
	}

	@Override
	public ESFRadunoAzzurri toEscapedModel() {
		return new ESFRadunoAzzurriWrapper(_esfRadunoAzzurri.toEscapedModel());
	}

	@Override
	public ESFRadunoAzzurri toUnescapedModel() {
		return new ESFRadunoAzzurriWrapper(_esfRadunoAzzurri.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfRadunoAzzurri.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfRadunoAzzurri.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfRadunoAzzurri.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFRadunoAzzurriWrapper)) {
			return false;
		}

		ESFRadunoAzzurriWrapper esfRadunoAzzurriWrapper = (ESFRadunoAzzurriWrapper)obj;

		if (Validator.equals(_esfRadunoAzzurri,
					esfRadunoAzzurriWrapper._esfRadunoAzzurri)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFRadunoAzzurri getWrappedESFRadunoAzzurri() {
		return _esfRadunoAzzurri;
	}

	@Override
	public ESFRadunoAzzurri getWrappedModel() {
		return _esfRadunoAzzurri;
	}

	@Override
	public void resetOriginalValues() {
		_esfRadunoAzzurri.resetOriginalValues();
	}

	private ESFRadunoAzzurri _esfRadunoAzzurri;
}