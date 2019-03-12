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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ESFJuniores}.
 * </p>
 *
 * @author Ethica
 * @see ESFJuniores
 * @generated
 */
public class ESFJunioresWrapper implements ESFJuniores,
	ModelWrapper<ESFJuniores> {
	public ESFJunioresWrapper(ESFJuniores esfJuniores) {
		_esfJuniores = esfJuniores;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFJuniores.class;
	}

	@Override
	public String getModelClassName() {
		return ESFJuniores.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ESFUserId", getESFUserId());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ESFUserId = (Long)attributes.get("ESFUserId");

		if (ESFUserId != null) {
			setESFUserId(ESFUserId);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}
	}

	/**
	* Returns the primary key of this e s f juniores.
	*
	* @return the primary key of this e s f juniores
	*/
	@Override
	public long getPrimaryKey() {
		return _esfJuniores.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f juniores.
	*
	* @param primaryKey the primary key of this e s f juniores
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfJuniores.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the e s f user ID of this e s f juniores.
	*
	* @return the e s f user ID of this e s f juniores
	*/
	@Override
	public long getESFUserId() {
		return _esfJuniores.getESFUserId();
	}

	/**
	* Sets the e s f user ID of this e s f juniores.
	*
	* @param ESFUserId the e s f user ID of this e s f juniores
	*/
	@Override
	public void setESFUserId(long ESFUserId) {
		_esfJuniores.setESFUserId(ESFUserId);
	}

	/**
	* Returns the e s f user uuid of this e s f juniores.
	*
	* @return the e s f user uuid of this e s f juniores
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getESFUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfJuniores.getESFUserUuid();
	}

	/**
	* Sets the e s f user uuid of this e s f juniores.
	*
	* @param ESFUserUuid the e s f user uuid of this e s f juniores
	*/
	@Override
	public void setESFUserUuid(java.lang.String ESFUserUuid) {
		_esfJuniores.setESFUserUuid(ESFUserUuid);
	}

	/**
	* Returns the start date of this e s f juniores.
	*
	* @return the start date of this e s f juniores
	*/
	@Override
	public java.util.Date getStartDate() {
		return _esfJuniores.getStartDate();
	}

	/**
	* Sets the start date of this e s f juniores.
	*
	* @param startDate the start date of this e s f juniores
	*/
	@Override
	public void setStartDate(java.util.Date startDate) {
		_esfJuniores.setStartDate(startDate);
	}

	/**
	* Returns the end date of this e s f juniores.
	*
	* @return the end date of this e s f juniores
	*/
	@Override
	public java.util.Date getEndDate() {
		return _esfJuniores.getEndDate();
	}

	/**
	* Sets the end date of this e s f juniores.
	*
	* @param endDate the end date of this e s f juniores
	*/
	@Override
	public void setEndDate(java.util.Date endDate) {
		_esfJuniores.setEndDate(endDate);
	}

	@Override
	public boolean isNew() {
		return _esfJuniores.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfJuniores.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfJuniores.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfJuniores.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfJuniores.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfJuniores.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfJuniores.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfJuniores.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfJuniores.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfJuniores.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfJuniores.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFJunioresWrapper((ESFJuniores)_esfJuniores.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFJuniores esfJuniores) {
		return _esfJuniores.compareTo(esfJuniores);
	}

	@Override
	public int hashCode() {
		return _esfJuniores.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFJuniores> toCacheModel() {
		return _esfJuniores.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFJuniores toEscapedModel() {
		return new ESFJunioresWrapper(_esfJuniores.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFJuniores toUnescapedModel() {
		return new ESFJunioresWrapper(_esfJuniores.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfJuniores.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfJuniores.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfJuniores.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFJunioresWrapper)) {
			return false;
		}

		ESFJunioresWrapper esfJunioresWrapper = (ESFJunioresWrapper)obj;

		if (Validator.equals(_esfJuniores, esfJunioresWrapper._esfJuniores)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFJuniores getWrappedESFJuniores() {
		return _esfJuniores;
	}

	@Override
	public ESFJuniores getWrappedModel() {
		return _esfJuniores;
	}

	@Override
	public void resetOriginalValues() {
		_esfJuniores.resetOriginalValues();
	}

	private ESFJuniores _esfJuniores;
}