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
 * This class is a wrapper for {@link ESFRadunoSottotipiRaduno}.
 * </p>
 *
 * @author Ethica
 * @see ESFRadunoSottotipiRaduno
 * @generated
 */
public class ESFRadunoSottotipiRadunoWrapper implements ESFRadunoSottotipiRaduno,
	ModelWrapper<ESFRadunoSottotipiRaduno> {
	public ESFRadunoSottotipiRadunoWrapper(
		ESFRadunoSottotipiRaduno esfRadunoSottotipiRaduno) {
		_esfRadunoSottotipiRaduno = esfRadunoSottotipiRaduno;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFRadunoSottotipiRaduno.class;
	}

	@Override
	public String getModelClassName() {
		return ESFRadunoSottotipiRaduno.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_esf_raduno_sottotipi_raduno",
			getId_esf_raduno_sottotipi_raduno());
		attributes.put("id_esf_raduno", getId_esf_raduno());
		attributes.put("id_esf_raduno_sottotipo", getId_esf_raduno_sottotipo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_esf_raduno_sottotipi_raduno = (Long)attributes.get(
				"id_esf_raduno_sottotipi_raduno");

		if (id_esf_raduno_sottotipi_raduno != null) {
			setId_esf_raduno_sottotipi_raduno(id_esf_raduno_sottotipi_raduno);
		}

		Long id_esf_raduno = (Long)attributes.get("id_esf_raduno");

		if (id_esf_raduno != null) {
			setId_esf_raduno(id_esf_raduno);
		}

		Long id_esf_raduno_sottotipo = (Long)attributes.get(
				"id_esf_raduno_sottotipo");

		if (id_esf_raduno_sottotipo != null) {
			setId_esf_raduno_sottotipo(id_esf_raduno_sottotipo);
		}
	}

	/**
	* Returns the primary key of this e s f raduno sottotipi raduno.
	*
	* @return the primary key of this e s f raduno sottotipi raduno
	*/
	@Override
	public long getPrimaryKey() {
		return _esfRadunoSottotipiRaduno.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f raduno sottotipi raduno.
	*
	* @param primaryKey the primary key of this e s f raduno sottotipi raduno
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfRadunoSottotipiRaduno.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id_esf_raduno_sottotipi_raduno of this e s f raduno sottotipi raduno.
	*
	* @return the id_esf_raduno_sottotipi_raduno of this e s f raduno sottotipi raduno
	*/
	@Override
	public long getId_esf_raduno_sottotipi_raduno() {
		return _esfRadunoSottotipiRaduno.getId_esf_raduno_sottotipi_raduno();
	}

	/**
	* Sets the id_esf_raduno_sottotipi_raduno of this e s f raduno sottotipi raduno.
	*
	* @param id_esf_raduno_sottotipi_raduno the id_esf_raduno_sottotipi_raduno of this e s f raduno sottotipi raduno
	*/
	@Override
	public void setId_esf_raduno_sottotipi_raduno(
		long id_esf_raduno_sottotipi_raduno) {
		_esfRadunoSottotipiRaduno.setId_esf_raduno_sottotipi_raduno(id_esf_raduno_sottotipi_raduno);
	}

	/**
	* Returns the id_esf_raduno of this e s f raduno sottotipi raduno.
	*
	* @return the id_esf_raduno of this e s f raduno sottotipi raduno
	*/
	@Override
	public long getId_esf_raduno() {
		return _esfRadunoSottotipiRaduno.getId_esf_raduno();
	}

	/**
	* Sets the id_esf_raduno of this e s f raduno sottotipi raduno.
	*
	* @param id_esf_raduno the id_esf_raduno of this e s f raduno sottotipi raduno
	*/
	@Override
	public void setId_esf_raduno(long id_esf_raduno) {
		_esfRadunoSottotipiRaduno.setId_esf_raduno(id_esf_raduno);
	}

	/**
	* Returns the id_esf_raduno_sottotipo of this e s f raduno sottotipi raduno.
	*
	* @return the id_esf_raduno_sottotipo of this e s f raduno sottotipi raduno
	*/
	@Override
	public long getId_esf_raduno_sottotipo() {
		return _esfRadunoSottotipiRaduno.getId_esf_raduno_sottotipo();
	}

	/**
	* Sets the id_esf_raduno_sottotipo of this e s f raduno sottotipi raduno.
	*
	* @param id_esf_raduno_sottotipo the id_esf_raduno_sottotipo of this e s f raduno sottotipi raduno
	*/
	@Override
	public void setId_esf_raduno_sottotipo(long id_esf_raduno_sottotipo) {
		_esfRadunoSottotipiRaduno.setId_esf_raduno_sottotipo(id_esf_raduno_sottotipo);
	}

	@Override
	public boolean isNew() {
		return _esfRadunoSottotipiRaduno.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfRadunoSottotipiRaduno.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfRadunoSottotipiRaduno.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfRadunoSottotipiRaduno.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfRadunoSottotipiRaduno.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfRadunoSottotipiRaduno.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfRadunoSottotipiRaduno.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfRadunoSottotipiRaduno.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfRadunoSottotipiRaduno.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfRadunoSottotipiRaduno.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfRadunoSottotipiRaduno.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFRadunoSottotipiRadunoWrapper((ESFRadunoSottotipiRaduno)_esfRadunoSottotipiRaduno.clone());
	}

	@Override
	public int compareTo(
		it.ethica.esf.model.ESFRadunoSottotipiRaduno esfRadunoSottotipiRaduno) {
		return _esfRadunoSottotipiRaduno.compareTo(esfRadunoSottotipiRaduno);
	}

	@Override
	public int hashCode() {
		return _esfRadunoSottotipiRaduno.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFRadunoSottotipiRaduno> toCacheModel() {
		return _esfRadunoSottotipiRaduno.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFRadunoSottotipiRaduno toEscapedModel() {
		return new ESFRadunoSottotipiRadunoWrapper(_esfRadunoSottotipiRaduno.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFRadunoSottotipiRaduno toUnescapedModel() {
		return new ESFRadunoSottotipiRadunoWrapper(_esfRadunoSottotipiRaduno.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfRadunoSottotipiRaduno.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfRadunoSottotipiRaduno.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfRadunoSottotipiRaduno.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFRadunoSottotipiRadunoWrapper)) {
			return false;
		}

		ESFRadunoSottotipiRadunoWrapper esfRadunoSottotipiRadunoWrapper = (ESFRadunoSottotipiRadunoWrapper)obj;

		if (Validator.equals(_esfRadunoSottotipiRaduno,
					esfRadunoSottotipiRadunoWrapper._esfRadunoSottotipiRaduno)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFRadunoSottotipiRaduno getWrappedESFRadunoSottotipiRaduno() {
		return _esfRadunoSottotipiRaduno;
	}

	@Override
	public ESFRadunoSottotipiRaduno getWrappedModel() {
		return _esfRadunoSottotipiRaduno;
	}

	@Override
	public void resetOriginalValues() {
		_esfRadunoSottotipiRaduno.resetOriginalValues();
	}

	private ESFRadunoSottotipiRaduno _esfRadunoSottotipiRaduno;
}