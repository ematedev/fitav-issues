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
 * This class is a wrapper for {@link EsfRadunoShooters}.
 * </p>
 *
 * @author Ethica
 * @see EsfRadunoShooters
 * @generated
 */
public class EsfRadunoShootersWrapper implements EsfRadunoShooters,
	ModelWrapper<EsfRadunoShooters> {
	public EsfRadunoShootersWrapper(EsfRadunoShooters esfRadunoShooters) {
		_esfRadunoShooters = esfRadunoShooters;
	}

	@Override
	public Class<?> getModelClass() {
		return EsfRadunoShooters.class;
	}

	@Override
	public String getModelClassName() {
		return EsfRadunoShooters.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_esf_raduno_shooters", getId_esf_raduno_shooters());
		attributes.put("id_esf_raduno", getId_esf_raduno());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_esf_raduno_shooters = (Long)attributes.get(
				"id_esf_raduno_shooters");

		if (id_esf_raduno_shooters != null) {
			setId_esf_raduno_shooters(id_esf_raduno_shooters);
		}

		Long id_esf_raduno = (Long)attributes.get("id_esf_raduno");

		if (id_esf_raduno != null) {
			setId_esf_raduno(id_esf_raduno);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	/**
	* Returns the primary key of this esf raduno shooters.
	*
	* @return the primary key of this esf raduno shooters
	*/
	@Override
	public it.ethica.esf.service.persistence.EsfRadunoShootersPK getPrimaryKey() {
		return _esfRadunoShooters.getPrimaryKey();
	}

	/**
	* Sets the primary key of this esf raduno shooters.
	*
	* @param primaryKey the primary key of this esf raduno shooters
	*/
	@Override
	public void setPrimaryKey(
		it.ethica.esf.service.persistence.EsfRadunoShootersPK primaryKey) {
		_esfRadunoShooters.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id_esf_raduno_shooters of this esf raduno shooters.
	*
	* @return the id_esf_raduno_shooters of this esf raduno shooters
	*/
	@Override
	public long getId_esf_raduno_shooters() {
		return _esfRadunoShooters.getId_esf_raduno_shooters();
	}

	/**
	* Sets the id_esf_raduno_shooters of this esf raduno shooters.
	*
	* @param id_esf_raduno_shooters the id_esf_raduno_shooters of this esf raduno shooters
	*/
	@Override
	public void setId_esf_raduno_shooters(long id_esf_raduno_shooters) {
		_esfRadunoShooters.setId_esf_raduno_shooters(id_esf_raduno_shooters);
	}

	/**
	* Returns the id_esf_raduno of this esf raduno shooters.
	*
	* @return the id_esf_raduno of this esf raduno shooters
	*/
	@Override
	public long getId_esf_raduno() {
		return _esfRadunoShooters.getId_esf_raduno();
	}

	/**
	* Sets the id_esf_raduno of this esf raduno shooters.
	*
	* @param id_esf_raduno the id_esf_raduno of this esf raduno shooters
	*/
	@Override
	public void setId_esf_raduno(long id_esf_raduno) {
		_esfRadunoShooters.setId_esf_raduno(id_esf_raduno);
	}

	/**
	* Returns the user ID of this esf raduno shooters.
	*
	* @return the user ID of this esf raduno shooters
	*/
	@Override
	public long getUserId() {
		return _esfRadunoShooters.getUserId();
	}

	/**
	* Sets the user ID of this esf raduno shooters.
	*
	* @param userId the user ID of this esf raduno shooters
	*/
	@Override
	public void setUserId(long userId) {
		_esfRadunoShooters.setUserId(userId);
	}

	/**
	* Returns the user uuid of this esf raduno shooters.
	*
	* @return the user uuid of this esf raduno shooters
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfRadunoShooters.getUserUuid();
	}

	/**
	* Sets the user uuid of this esf raduno shooters.
	*
	* @param userUuid the user uuid of this esf raduno shooters
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfRadunoShooters.setUserUuid(userUuid);
	}

	@Override
	public boolean isNew() {
		return _esfRadunoShooters.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfRadunoShooters.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfRadunoShooters.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfRadunoShooters.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfRadunoShooters.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfRadunoShooters.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfRadunoShooters.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfRadunoShooters.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfRadunoShooters.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfRadunoShooters.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfRadunoShooters.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EsfRadunoShootersWrapper((EsfRadunoShooters)_esfRadunoShooters.clone());
	}

	@Override
	public int compareTo(
		it.ethica.esf.model.EsfRadunoShooters esfRadunoShooters) {
		return _esfRadunoShooters.compareTo(esfRadunoShooters);
	}

	@Override
	public int hashCode() {
		return _esfRadunoShooters.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.EsfRadunoShooters> toCacheModel() {
		return _esfRadunoShooters.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.EsfRadunoShooters toEscapedModel() {
		return new EsfRadunoShootersWrapper(_esfRadunoShooters.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.EsfRadunoShooters toUnescapedModel() {
		return new EsfRadunoShootersWrapper(_esfRadunoShooters.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfRadunoShooters.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfRadunoShooters.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfRadunoShooters.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EsfRadunoShootersWrapper)) {
			return false;
		}

		EsfRadunoShootersWrapper esfRadunoShootersWrapper = (EsfRadunoShootersWrapper)obj;

		if (Validator.equals(_esfRadunoShooters,
					esfRadunoShootersWrapper._esfRadunoShooters)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EsfRadunoShooters getWrappedEsfRadunoShooters() {
		return _esfRadunoShooters;
	}

	@Override
	public EsfRadunoShooters getWrappedModel() {
		return _esfRadunoShooters;
	}

	@Override
	public void resetOriginalValues() {
		_esfRadunoShooters.resetOriginalValues();
	}

	private EsfRadunoShooters _esfRadunoShooters;
}