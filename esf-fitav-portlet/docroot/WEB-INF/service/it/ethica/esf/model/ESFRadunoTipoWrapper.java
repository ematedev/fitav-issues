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
 * This class is a wrapper for {@link ESFRadunoTipo}.
 * </p>
 *
 * @author Ethica
 * @see ESFRadunoTipo
 * @generated
 */
public class ESFRadunoTipoWrapper implements ESFRadunoTipo,
	ModelWrapper<ESFRadunoTipo> {
	public ESFRadunoTipoWrapper(ESFRadunoTipo esfRadunoTipo) {
		_esfRadunoTipo = esfRadunoTipo;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFRadunoTipo.class;
	}

	@Override
	public String getModelClassName() {
		return ESFRadunoTipo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_esf_raduno_tipo", getId_esf_raduno_tipo());
		attributes.put("descrizione", getDescrizione());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_esf_raduno_tipo = (Long)attributes.get("id_esf_raduno_tipo");

		if (id_esf_raduno_tipo != null) {
			setId_esf_raduno_tipo(id_esf_raduno_tipo);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}
	}

	/**
	* Returns the primary key of this e s f raduno tipo.
	*
	* @return the primary key of this e s f raduno tipo
	*/
	@Override
	public long getPrimaryKey() {
		return _esfRadunoTipo.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f raduno tipo.
	*
	* @param primaryKey the primary key of this e s f raduno tipo
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfRadunoTipo.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id_esf_raduno_tipo of this e s f raduno tipo.
	*
	* @return the id_esf_raduno_tipo of this e s f raduno tipo
	*/
	@Override
	public long getId_esf_raduno_tipo() {
		return _esfRadunoTipo.getId_esf_raduno_tipo();
	}

	/**
	* Sets the id_esf_raduno_tipo of this e s f raduno tipo.
	*
	* @param id_esf_raduno_tipo the id_esf_raduno_tipo of this e s f raduno tipo
	*/
	@Override
	public void setId_esf_raduno_tipo(long id_esf_raduno_tipo) {
		_esfRadunoTipo.setId_esf_raduno_tipo(id_esf_raduno_tipo);
	}

	/**
	* Returns the descrizione of this e s f raduno tipo.
	*
	* @return the descrizione of this e s f raduno tipo
	*/
	@Override
	public java.lang.String getDescrizione() {
		return _esfRadunoTipo.getDescrizione();
	}

	/**
	* Sets the descrizione of this e s f raduno tipo.
	*
	* @param descrizione the descrizione of this e s f raduno tipo
	*/
	@Override
	public void setDescrizione(java.lang.String descrizione) {
		_esfRadunoTipo.setDescrizione(descrizione);
	}

	@Override
	public boolean isNew() {
		return _esfRadunoTipo.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfRadunoTipo.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfRadunoTipo.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfRadunoTipo.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfRadunoTipo.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfRadunoTipo.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfRadunoTipo.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfRadunoTipo.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfRadunoTipo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfRadunoTipo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfRadunoTipo.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFRadunoTipoWrapper((ESFRadunoTipo)_esfRadunoTipo.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFRadunoTipo esfRadunoTipo) {
		return _esfRadunoTipo.compareTo(esfRadunoTipo);
	}

	@Override
	public int hashCode() {
		return _esfRadunoTipo.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFRadunoTipo> toCacheModel() {
		return _esfRadunoTipo.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFRadunoTipo toEscapedModel() {
		return new ESFRadunoTipoWrapper(_esfRadunoTipo.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFRadunoTipo toUnescapedModel() {
		return new ESFRadunoTipoWrapper(_esfRadunoTipo.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfRadunoTipo.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfRadunoTipo.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfRadunoTipo.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFRadunoTipoWrapper)) {
			return false;
		}

		ESFRadunoTipoWrapper esfRadunoTipoWrapper = (ESFRadunoTipoWrapper)obj;

		if (Validator.equals(_esfRadunoTipo, esfRadunoTipoWrapper._esfRadunoTipo)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFRadunoTipo getWrappedESFRadunoTipo() {
		return _esfRadunoTipo;
	}

	@Override
	public ESFRadunoTipo getWrappedModel() {
		return _esfRadunoTipo;
	}

	@Override
	public void resetOriginalValues() {
		_esfRadunoTipo.resetOriginalValues();
	}

	private ESFRadunoTipo _esfRadunoTipo;
}