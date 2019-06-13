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
 * This class is a wrapper for {@link ESFRadunoSottotipo}.
 * </p>
 *
 * @author Ethica
 * @see ESFRadunoSottotipo
 * @generated
 */
public class ESFRadunoSottotipoWrapper implements ESFRadunoSottotipo,
	ModelWrapper<ESFRadunoSottotipo> {
	public ESFRadunoSottotipoWrapper(ESFRadunoSottotipo esfRadunoSottotipo) {
		_esfRadunoSottotipo = esfRadunoSottotipo;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFRadunoSottotipo.class;
	}

	@Override
	public String getModelClassName() {
		return ESFRadunoSottotipo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_esf_raduno_sottotipo", getId_esf_raduno_sottotipo());
		attributes.put("descrizione", getDescrizione());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_esf_raduno_sottotipo = (Long)attributes.get(
				"id_esf_raduno_sottotipo");

		if (id_esf_raduno_sottotipo != null) {
			setId_esf_raduno_sottotipo(id_esf_raduno_sottotipo);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}
	}

	/**
	* Returns the primary key of this e s f raduno sottotipo.
	*
	* @return the primary key of this e s f raduno sottotipo
	*/
	@Override
	public long getPrimaryKey() {
		return _esfRadunoSottotipo.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f raduno sottotipo.
	*
	* @param primaryKey the primary key of this e s f raduno sottotipo
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfRadunoSottotipo.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id_esf_raduno_sottotipo of this e s f raduno sottotipo.
	*
	* @return the id_esf_raduno_sottotipo of this e s f raduno sottotipo
	*/
	@Override
	public long getId_esf_raduno_sottotipo() {
		return _esfRadunoSottotipo.getId_esf_raduno_sottotipo();
	}

	/**
	* Sets the id_esf_raduno_sottotipo of this e s f raduno sottotipo.
	*
	* @param id_esf_raduno_sottotipo the id_esf_raduno_sottotipo of this e s f raduno sottotipo
	*/
	@Override
	public void setId_esf_raduno_sottotipo(long id_esf_raduno_sottotipo) {
		_esfRadunoSottotipo.setId_esf_raduno_sottotipo(id_esf_raduno_sottotipo);
	}

	/**
	* Returns the descrizione of this e s f raduno sottotipo.
	*
	* @return the descrizione of this e s f raduno sottotipo
	*/
	@Override
	public java.lang.String getDescrizione() {
		return _esfRadunoSottotipo.getDescrizione();
	}

	/**
	* Sets the descrizione of this e s f raduno sottotipo.
	*
	* @param descrizione the descrizione of this e s f raduno sottotipo
	*/
	@Override
	public void setDescrizione(java.lang.String descrizione) {
		_esfRadunoSottotipo.setDescrizione(descrizione);
	}

	@Override
	public boolean isNew() {
		return _esfRadunoSottotipo.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfRadunoSottotipo.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfRadunoSottotipo.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfRadunoSottotipo.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfRadunoSottotipo.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfRadunoSottotipo.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfRadunoSottotipo.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfRadunoSottotipo.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfRadunoSottotipo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfRadunoSottotipo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfRadunoSottotipo.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFRadunoSottotipoWrapper((ESFRadunoSottotipo)_esfRadunoSottotipo.clone());
	}

	@Override
	public int compareTo(
		it.ethica.esf.model.ESFRadunoSottotipo esfRadunoSottotipo) {
		return _esfRadunoSottotipo.compareTo(esfRadunoSottotipo);
	}

	@Override
	public int hashCode() {
		return _esfRadunoSottotipo.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFRadunoSottotipo> toCacheModel() {
		return _esfRadunoSottotipo.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFRadunoSottotipo toEscapedModel() {
		return new ESFRadunoSottotipoWrapper(_esfRadunoSottotipo.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFRadunoSottotipo toUnescapedModel() {
		return new ESFRadunoSottotipoWrapper(_esfRadunoSottotipo.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfRadunoSottotipo.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfRadunoSottotipo.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfRadunoSottotipo.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFRadunoSottotipoWrapper)) {
			return false;
		}

		ESFRadunoSottotipoWrapper esfRadunoSottotipoWrapper = (ESFRadunoSottotipoWrapper)obj;

		if (Validator.equals(_esfRadunoSottotipo,
					esfRadunoSottotipoWrapper._esfRadunoSottotipo)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFRadunoSottotipo getWrappedESFRadunoSottotipo() {
		return _esfRadunoSottotipo;
	}

	@Override
	public ESFRadunoSottotipo getWrappedModel() {
		return _esfRadunoSottotipo;
	}

	@Override
	public void resetOriginalValues() {
		_esfRadunoSottotipo.resetOriginalValues();
	}

	private ESFRadunoSottotipo _esfRadunoSottotipo;
}