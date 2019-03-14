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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ESFShootingDirectorQualification}.
 * </p>
 *
 * @author Ethica
 * @see ESFShootingDirectorQualification
 * @generated
 */
public class ESFShootingDirectorQualificationWrapper
	implements ESFShootingDirectorQualification,
		ModelWrapper<ESFShootingDirectorQualification> {
	public ESFShootingDirectorQualificationWrapper(
		ESFShootingDirectorQualification esfShootingDirectorQualification) {
		_esfShootingDirectorQualification = esfShootingDirectorQualification;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFShootingDirectorQualification.class;
	}

	@Override
	public String getModelClassName() {
		return ESFShootingDirectorQualification.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfShootingDirectorQualificationId",
			getEsfShootingDirectorQualificationId());
		attributes.put("esfShootingDirectorQualificationDesc",
			getEsfShootingDirectorQualificationDesc());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfShootingDirectorQualificationId = (Long)attributes.get(
				"esfShootingDirectorQualificationId");

		if (esfShootingDirectorQualificationId != null) {
			setEsfShootingDirectorQualificationId(esfShootingDirectorQualificationId);
		}

		String esfShootingDirectorQualificationDesc = (String)attributes.get(
				"esfShootingDirectorQualificationDesc");

		if (esfShootingDirectorQualificationDesc != null) {
			setEsfShootingDirectorQualificationDesc(esfShootingDirectorQualificationDesc);
		}
	}

	/**
	* Returns the primary key of this e s f shooting director qualification.
	*
	* @return the primary key of this e s f shooting director qualification
	*/
	@Override
	public long getPrimaryKey() {
		return _esfShootingDirectorQualification.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f shooting director qualification.
	*
	* @param primaryKey the primary key of this e s f shooting director qualification
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfShootingDirectorQualification.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf shooting director qualification ID of this e s f shooting director qualification.
	*
	* @return the esf shooting director qualification ID of this e s f shooting director qualification
	*/
	@Override
	public long getEsfShootingDirectorQualificationId() {
		return _esfShootingDirectorQualification.getEsfShootingDirectorQualificationId();
	}

	/**
	* Sets the esf shooting director qualification ID of this e s f shooting director qualification.
	*
	* @param esfShootingDirectorQualificationId the esf shooting director qualification ID of this e s f shooting director qualification
	*/
	@Override
	public void setEsfShootingDirectorQualificationId(
		long esfShootingDirectorQualificationId) {
		_esfShootingDirectorQualification.setEsfShootingDirectorQualificationId(esfShootingDirectorQualificationId);
	}

	/**
	* Returns the esf shooting director qualification desc of this e s f shooting director qualification.
	*
	* @return the esf shooting director qualification desc of this e s f shooting director qualification
	*/
	@Override
	public java.lang.String getEsfShootingDirectorQualificationDesc() {
		return _esfShootingDirectorQualification.getEsfShootingDirectorQualificationDesc();
	}

	/**
	* Sets the esf shooting director qualification desc of this e s f shooting director qualification.
	*
	* @param esfShootingDirectorQualificationDesc the esf shooting director qualification desc of this e s f shooting director qualification
	*/
	@Override
	public void setEsfShootingDirectorQualificationDesc(
		java.lang.String esfShootingDirectorQualificationDesc) {
		_esfShootingDirectorQualification.setEsfShootingDirectorQualificationDesc(esfShootingDirectorQualificationDesc);
	}

	@Override
	public boolean isNew() {
		return _esfShootingDirectorQualification.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfShootingDirectorQualification.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfShootingDirectorQualification.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfShootingDirectorQualification.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfShootingDirectorQualification.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfShootingDirectorQualification.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfShootingDirectorQualification.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfShootingDirectorQualification.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfShootingDirectorQualification.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfShootingDirectorQualification.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfShootingDirectorQualification.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFShootingDirectorQualificationWrapper((ESFShootingDirectorQualification)_esfShootingDirectorQualification.clone());
	}

	@Override
	public int compareTo(
		it.ethica.esf.model.ESFShootingDirectorQualification esfShootingDirectorQualification) {
		return _esfShootingDirectorQualification.compareTo(esfShootingDirectorQualification);
	}

	@Override
	public int hashCode() {
		return _esfShootingDirectorQualification.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFShootingDirectorQualification> toCacheModel() {
		return _esfShootingDirectorQualification.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFShootingDirectorQualification toEscapedModel() {
		return new ESFShootingDirectorQualificationWrapper(_esfShootingDirectorQualification.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFShootingDirectorQualification toUnescapedModel() {
		return new ESFShootingDirectorQualificationWrapper(_esfShootingDirectorQualification.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfShootingDirectorQualification.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfShootingDirectorQualification.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfShootingDirectorQualification.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFShootingDirectorQualificationWrapper)) {
			return false;
		}

		ESFShootingDirectorQualificationWrapper esfShootingDirectorQualificationWrapper =
			(ESFShootingDirectorQualificationWrapper)obj;

		if (Validator.equals(_esfShootingDirectorQualification,
					esfShootingDirectorQualificationWrapper._esfShootingDirectorQualification)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFShootingDirectorQualification getWrappedESFShootingDirectorQualification() {
		return _esfShootingDirectorQualification;
	}

	@Override
	public ESFShootingDirectorQualification getWrappedModel() {
		return _esfShootingDirectorQualification;
	}

	@Override
	public void resetOriginalValues() {
		_esfShootingDirectorQualification.resetOriginalValues();
	}

	private ESFShootingDirectorQualification _esfShootingDirectorQualification;
}