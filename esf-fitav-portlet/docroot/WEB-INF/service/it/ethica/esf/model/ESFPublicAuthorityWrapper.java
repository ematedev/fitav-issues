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
 * This class is a wrapper for {@link ESFPublicAuthority}.
 * </p>
 *
 * @author Ethica
 * @see ESFPublicAuthority
 * @generated
 */
public class ESFPublicAuthorityWrapper implements ESFPublicAuthority,
	ModelWrapper<ESFPublicAuthority> {
	public ESFPublicAuthorityWrapper(ESFPublicAuthority esfPublicAuthority) {
		_esfPublicAuthority = esfPublicAuthority;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFPublicAuthority.class;
	}

	@Override
	public String getModelClassName() {
		return ESFPublicAuthority.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfPublicAuthorityId", getEsfPublicAuthorityId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfPublicAuthorityId = (Long)attributes.get("esfPublicAuthorityId");

		if (esfPublicAuthorityId != null) {
			setEsfPublicAuthorityId(esfPublicAuthorityId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	* Returns the primary key of this e s f public authority.
	*
	* @return the primary key of this e s f public authority
	*/
	@Override
	public long getPrimaryKey() {
		return _esfPublicAuthority.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f public authority.
	*
	* @param primaryKey the primary key of this e s f public authority
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfPublicAuthority.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf public authority ID of this e s f public authority.
	*
	* @return the esf public authority ID of this e s f public authority
	*/
	@Override
	public long getEsfPublicAuthorityId() {
		return _esfPublicAuthority.getEsfPublicAuthorityId();
	}

	/**
	* Sets the esf public authority ID of this e s f public authority.
	*
	* @param esfPublicAuthorityId the esf public authority ID of this e s f public authority
	*/
	@Override
	public void setEsfPublicAuthorityId(long esfPublicAuthorityId) {
		_esfPublicAuthority.setEsfPublicAuthorityId(esfPublicAuthorityId);
	}

	/**
	* Returns the create date of this e s f public authority.
	*
	* @return the create date of this e s f public authority
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfPublicAuthority.getCreateDate();
	}

	/**
	* Sets the create date of this e s f public authority.
	*
	* @param createDate the create date of this e s f public authority
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfPublicAuthority.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f public authority.
	*
	* @return the modified date of this e s f public authority
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfPublicAuthority.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f public authority.
	*
	* @param modifiedDate the modified date of this e s f public authority
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfPublicAuthority.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the description of this e s f public authority.
	*
	* @return the description of this e s f public authority
	*/
	@Override
	public java.lang.String getDescription() {
		return _esfPublicAuthority.getDescription();
	}

	/**
	* Sets the description of this e s f public authority.
	*
	* @param description the description of this e s f public authority
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_esfPublicAuthority.setDescription(description);
	}

	@Override
	public boolean isNew() {
		return _esfPublicAuthority.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfPublicAuthority.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfPublicAuthority.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfPublicAuthority.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfPublicAuthority.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfPublicAuthority.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfPublicAuthority.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfPublicAuthority.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfPublicAuthority.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfPublicAuthority.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfPublicAuthority.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFPublicAuthorityWrapper((ESFPublicAuthority)_esfPublicAuthority.clone());
	}

	@Override
	public int compareTo(ESFPublicAuthority esfPublicAuthority) {
		return _esfPublicAuthority.compareTo(esfPublicAuthority);
	}

	@Override
	public int hashCode() {
		return _esfPublicAuthority.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<ESFPublicAuthority> toCacheModel() {
		return _esfPublicAuthority.toCacheModel();
	}

	@Override
	public ESFPublicAuthority toEscapedModel() {
		return new ESFPublicAuthorityWrapper(_esfPublicAuthority.toEscapedModel());
	}

	@Override
	public ESFPublicAuthority toUnescapedModel() {
		return new ESFPublicAuthorityWrapper(_esfPublicAuthority.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfPublicAuthority.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfPublicAuthority.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfPublicAuthority.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFPublicAuthorityWrapper)) {
			return false;
		}

		ESFPublicAuthorityWrapper esfPublicAuthorityWrapper = (ESFPublicAuthorityWrapper)obj;

		if (Validator.equals(_esfPublicAuthority,
					esfPublicAuthorityWrapper._esfPublicAuthority)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFPublicAuthority getWrappedESFPublicAuthority() {
		return _esfPublicAuthority;
	}

	@Override
	public ESFPublicAuthority getWrappedModel() {
		return _esfPublicAuthority;
	}

	@Override
	public void resetOriginalValues() {
		_esfPublicAuthority.resetOriginalValues();
	}

	private ESFPublicAuthority _esfPublicAuthority;
}