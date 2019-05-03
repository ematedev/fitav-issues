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
 * This class is a wrapper for {@link ESFDescription}.
 * </p>
 *
 * @author Ethica
 * @see ESFDescription
 * @generated
 */
public class ESFDescriptionWrapper implements ESFDescription,
	ModelWrapper<ESFDescription> {
	public ESFDescriptionWrapper(ESFDescription esfDescription) {
		_esfDescription = esfDescription;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFDescription.class;
	}

	@Override
	public String getModelClassName() {
		return ESFDescription.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfDescriptionId", getEsfDescriptionId());
		attributes.put("isNational", getIsNational());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfDescriptionId = (Long)attributes.get("esfDescriptionId");

		if (esfDescriptionId != null) {
			setEsfDescriptionId(esfDescriptionId);
		}

		Boolean isNational = (Boolean)attributes.get("isNational");

		if (isNational != null) {
			setIsNational(isNational);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	/**
	* Returns the primary key of this e s f description.
	*
	* @return the primary key of this e s f description
	*/
	@Override
	public long getPrimaryKey() {
		return _esfDescription.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f description.
	*
	* @param primaryKey the primary key of this e s f description
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfDescription.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf description ID of this e s f description.
	*
	* @return the esf description ID of this e s f description
	*/
	@Override
	public long getEsfDescriptionId() {
		return _esfDescription.getEsfDescriptionId();
	}

	/**
	* Sets the esf description ID of this e s f description.
	*
	* @param esfDescriptionId the esf description ID of this e s f description
	*/
	@Override
	public void setEsfDescriptionId(long esfDescriptionId) {
		_esfDescription.setEsfDescriptionId(esfDescriptionId);
	}

	/**
	* Returns the is national of this e s f description.
	*
	* @return the is national of this e s f description
	*/
	@Override
	public boolean getIsNational() {
		return _esfDescription.getIsNational();
	}

	/**
	* Returns <code>true</code> if this e s f description is is national.
	*
	* @return <code>true</code> if this e s f description is is national; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsNational() {
		return _esfDescription.isIsNational();
	}

	/**
	* Sets whether this e s f description is is national.
	*
	* @param isNational the is national of this e s f description
	*/
	@Override
	public void setIsNational(boolean isNational) {
		_esfDescription.setIsNational(isNational);
	}

	/**
	* Returns the name of this e s f description.
	*
	* @return the name of this e s f description
	*/
	@Override
	public java.lang.String getName() {
		return _esfDescription.getName();
	}

	/**
	* Sets the name of this e s f description.
	*
	* @param name the name of this e s f description
	*/
	@Override
	public void setName(java.lang.String name) {
		_esfDescription.setName(name);
	}

	@Override
	public boolean isNew() {
		return _esfDescription.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfDescription.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfDescription.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfDescription.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfDescription.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfDescription.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfDescription.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfDescription.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfDescription.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfDescription.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfDescription.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFDescriptionWrapper((ESFDescription)_esfDescription.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFDescription esfDescription) {
		return _esfDescription.compareTo(esfDescription);
	}

	@Override
	public int hashCode() {
		return _esfDescription.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFDescription> toCacheModel() {
		return _esfDescription.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFDescription toEscapedModel() {
		return new ESFDescriptionWrapper(_esfDescription.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFDescription toUnescapedModel() {
		return new ESFDescriptionWrapper(_esfDescription.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfDescription.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfDescription.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfDescription.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFDescriptionWrapper)) {
			return false;
		}

		ESFDescriptionWrapper esfDescriptionWrapper = (ESFDescriptionWrapper)obj;

		if (Validator.equals(_esfDescription,
					esfDescriptionWrapper._esfDescription)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFDescription getWrappedESFDescription() {
		return _esfDescription;
	}

	@Override
	public ESFDescription getWrappedModel() {
		return _esfDescription;
	}

	@Override
	public void resetOriginalValues() {
		_esfDescription.resetOriginalValues();
	}

	private ESFDescription _esfDescription;
}