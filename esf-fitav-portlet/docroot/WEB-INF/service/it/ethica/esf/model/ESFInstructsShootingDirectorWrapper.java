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
 * This class is a wrapper for {@link ESFInstructsShootingDirector}.
 * </p>
 *
 * @author Ethica
 * @see ESFInstructsShootingDirector
 * @generated
 */
public class ESFInstructsShootingDirectorWrapper
	implements ESFInstructsShootingDirector,
		ModelWrapper<ESFInstructsShootingDirector> {
	public ESFInstructsShootingDirectorWrapper(
		ESFInstructsShootingDirector esfInstructsShootingDirector) {
		_esfInstructsShootingDirector = esfInstructsShootingDirector;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFInstructsShootingDirector.class;
	}

	@Override
	public String getModelClassName() {
		return ESFInstructsShootingDirector.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfInstructsShootingDirectorId",
			getEsfInstructsShootingDirectorId());
		attributes.put("esfInstructsShootingDirectorCode",
			getEsfInstructsShootingDirectorCode());
		attributes.put("esfInstructsShootingDirectorDesc",
			getEsfInstructsShootingDirectorDesc());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfInstructsShootingDirectorId = (Long)attributes.get(
				"esfInstructsShootingDirectorId");

		if (esfInstructsShootingDirectorId != null) {
			setEsfInstructsShootingDirectorId(esfInstructsShootingDirectorId);
		}

		String esfInstructsShootingDirectorCode = (String)attributes.get(
				"esfInstructsShootingDirectorCode");

		if (esfInstructsShootingDirectorCode != null) {
			setEsfInstructsShootingDirectorCode(esfInstructsShootingDirectorCode);
		}

		String esfInstructsShootingDirectorDesc = (String)attributes.get(
				"esfInstructsShootingDirectorDesc");

		if (esfInstructsShootingDirectorDesc != null) {
			setEsfInstructsShootingDirectorDesc(esfInstructsShootingDirectorDesc);
		}
	}

	/**
	* Returns the primary key of this e s f instructs shooting director.
	*
	* @return the primary key of this e s f instructs shooting director
	*/
	@Override
	public long getPrimaryKey() {
		return _esfInstructsShootingDirector.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f instructs shooting director.
	*
	* @param primaryKey the primary key of this e s f instructs shooting director
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfInstructsShootingDirector.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf instructs shooting director ID of this e s f instructs shooting director.
	*
	* @return the esf instructs shooting director ID of this e s f instructs shooting director
	*/
	@Override
	public long getEsfInstructsShootingDirectorId() {
		return _esfInstructsShootingDirector.getEsfInstructsShootingDirectorId();
	}

	/**
	* Sets the esf instructs shooting director ID of this e s f instructs shooting director.
	*
	* @param esfInstructsShootingDirectorId the esf instructs shooting director ID of this e s f instructs shooting director
	*/
	@Override
	public void setEsfInstructsShootingDirectorId(
		long esfInstructsShootingDirectorId) {
		_esfInstructsShootingDirector.setEsfInstructsShootingDirectorId(esfInstructsShootingDirectorId);
	}

	/**
	* Returns the esf instructs shooting director code of this e s f instructs shooting director.
	*
	* @return the esf instructs shooting director code of this e s f instructs shooting director
	*/
	@Override
	public java.lang.String getEsfInstructsShootingDirectorCode() {
		return _esfInstructsShootingDirector.getEsfInstructsShootingDirectorCode();
	}

	/**
	* Sets the esf instructs shooting director code of this e s f instructs shooting director.
	*
	* @param esfInstructsShootingDirectorCode the esf instructs shooting director code of this e s f instructs shooting director
	*/
	@Override
	public void setEsfInstructsShootingDirectorCode(
		java.lang.String esfInstructsShootingDirectorCode) {
		_esfInstructsShootingDirector.setEsfInstructsShootingDirectorCode(esfInstructsShootingDirectorCode);
	}

	/**
	* Returns the esf instructs shooting director desc of this e s f instructs shooting director.
	*
	* @return the esf instructs shooting director desc of this e s f instructs shooting director
	*/
	@Override
	public java.lang.String getEsfInstructsShootingDirectorDesc() {
		return _esfInstructsShootingDirector.getEsfInstructsShootingDirectorDesc();
	}

	/**
	* Sets the esf instructs shooting director desc of this e s f instructs shooting director.
	*
	* @param esfInstructsShootingDirectorDesc the esf instructs shooting director desc of this e s f instructs shooting director
	*/
	@Override
	public void setEsfInstructsShootingDirectorDesc(
		java.lang.String esfInstructsShootingDirectorDesc) {
		_esfInstructsShootingDirector.setEsfInstructsShootingDirectorDesc(esfInstructsShootingDirectorDesc);
	}

	@Override
	public boolean isNew() {
		return _esfInstructsShootingDirector.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfInstructsShootingDirector.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfInstructsShootingDirector.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfInstructsShootingDirector.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfInstructsShootingDirector.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfInstructsShootingDirector.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfInstructsShootingDirector.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfInstructsShootingDirector.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfInstructsShootingDirector.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfInstructsShootingDirector.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfInstructsShootingDirector.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFInstructsShootingDirectorWrapper((ESFInstructsShootingDirector)_esfInstructsShootingDirector.clone());
	}

	@Override
	public int compareTo(
		it.ethica.esf.model.ESFInstructsShootingDirector esfInstructsShootingDirector) {
		return _esfInstructsShootingDirector.compareTo(esfInstructsShootingDirector);
	}

	@Override
	public int hashCode() {
		return _esfInstructsShootingDirector.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFInstructsShootingDirector> toCacheModel() {
		return _esfInstructsShootingDirector.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFInstructsShootingDirector toEscapedModel() {
		return new ESFInstructsShootingDirectorWrapper(_esfInstructsShootingDirector.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFInstructsShootingDirector toUnescapedModel() {
		return new ESFInstructsShootingDirectorWrapper(_esfInstructsShootingDirector.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfInstructsShootingDirector.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfInstructsShootingDirector.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfInstructsShootingDirector.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFInstructsShootingDirectorWrapper)) {
			return false;
		}

		ESFInstructsShootingDirectorWrapper esfInstructsShootingDirectorWrapper = (ESFInstructsShootingDirectorWrapper)obj;

		if (Validator.equals(_esfInstructsShootingDirector,
					esfInstructsShootingDirectorWrapper._esfInstructsShootingDirector)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFInstructsShootingDirector getWrappedESFInstructsShootingDirector() {
		return _esfInstructsShootingDirector;
	}

	@Override
	public ESFInstructsShootingDirector getWrappedModel() {
		return _esfInstructsShootingDirector;
	}

	@Override
	public void resetOriginalValues() {
		_esfInstructsShootingDirector.resetOriginalValues();
	}

	private ESFInstructsShootingDirector _esfInstructsShootingDirector;
}