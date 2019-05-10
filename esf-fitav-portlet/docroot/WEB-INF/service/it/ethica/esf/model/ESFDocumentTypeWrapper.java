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
 * This class is a wrapper for {@link ESFDocumentType}.
 * </p>
 *
 * @author Ethica
 * @see ESFDocumentType
 * @generated
 */
public class ESFDocumentTypeWrapper implements ESFDocumentType,
	ModelWrapper<ESFDocumentType> {
	public ESFDocumentTypeWrapper(ESFDocumentType esfDocumentType) {
		_esfDocumentType = esfDocumentType;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFDocumentType.class;
	}

	@Override
	public String getModelClassName() {
		return ESFDocumentType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfDocumentTypeId", getEsfDocumentTypeId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("description", getDescription());
		attributes.put("expirationMonthsNotice", getExpirationMonthsNotice());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfDocumentTypeId = (Long)attributes.get("esfDocumentTypeId");

		if (esfDocumentTypeId != null) {
			setEsfDocumentTypeId(esfDocumentTypeId);
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

		Integer expirationMonthsNotice = (Integer)attributes.get(
				"expirationMonthsNotice");

		if (expirationMonthsNotice != null) {
			setExpirationMonthsNotice(expirationMonthsNotice);
		}
	}

	/**
	* Returns the primary key of this e s f document type.
	*
	* @return the primary key of this e s f document type
	*/
	@Override
	public long getPrimaryKey() {
		return _esfDocumentType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f document type.
	*
	* @param primaryKey the primary key of this e s f document type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfDocumentType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf document type ID of this e s f document type.
	*
	* @return the esf document type ID of this e s f document type
	*/
	@Override
	public long getEsfDocumentTypeId() {
		return _esfDocumentType.getEsfDocumentTypeId();
	}

	/**
	* Sets the esf document type ID of this e s f document type.
	*
	* @param esfDocumentTypeId the esf document type ID of this e s f document type
	*/
	@Override
	public void setEsfDocumentTypeId(long esfDocumentTypeId) {
		_esfDocumentType.setEsfDocumentTypeId(esfDocumentTypeId);
	}

	/**
	* Returns the create date of this e s f document type.
	*
	* @return the create date of this e s f document type
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfDocumentType.getCreateDate();
	}

	/**
	* Sets the create date of this e s f document type.
	*
	* @param createDate the create date of this e s f document type
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfDocumentType.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f document type.
	*
	* @return the modified date of this e s f document type
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfDocumentType.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f document type.
	*
	* @param modifiedDate the modified date of this e s f document type
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfDocumentType.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the description of this e s f document type.
	*
	* @return the description of this e s f document type
	*/
	@Override
	public java.lang.String getDescription() {
		return _esfDocumentType.getDescription();
	}

	/**
	* Sets the description of this e s f document type.
	*
	* @param description the description of this e s f document type
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_esfDocumentType.setDescription(description);
	}

	/**
	* Returns the expiration months notice of this e s f document type.
	*
	* @return the expiration months notice of this e s f document type
	*/
	@Override
	public int getExpirationMonthsNotice() {
		return _esfDocumentType.getExpirationMonthsNotice();
	}

	/**
	* Sets the expiration months notice of this e s f document type.
	*
	* @param expirationMonthsNotice the expiration months notice of this e s f document type
	*/
	@Override
	public void setExpirationMonthsNotice(int expirationMonthsNotice) {
		_esfDocumentType.setExpirationMonthsNotice(expirationMonthsNotice);
	}

	@Override
	public boolean isNew() {
		return _esfDocumentType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfDocumentType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfDocumentType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfDocumentType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfDocumentType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfDocumentType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfDocumentType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfDocumentType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfDocumentType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfDocumentType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfDocumentType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFDocumentTypeWrapper((ESFDocumentType)_esfDocumentType.clone());
	}

	@Override
<<<<<<< HEAD
	public int compareTo(it.ethica.esf.model.ESFDocumentType esfDocumentType) {
=======
	public int compareTo(ESFDocumentType esfDocumentType) {
>>>>>>> origin/master
		return _esfDocumentType.compareTo(esfDocumentType);
	}

	@Override
	public int hashCode() {
		return _esfDocumentType.hashCode();
	}

	@Override
<<<<<<< HEAD
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFDocumentType> toCacheModel() {
=======
	public com.liferay.portal.model.CacheModel<ESFDocumentType> toCacheModel() {
>>>>>>> origin/master
		return _esfDocumentType.toCacheModel();
	}

	@Override
<<<<<<< HEAD
	public it.ethica.esf.model.ESFDocumentType toEscapedModel() {
=======
	public ESFDocumentType toEscapedModel() {
>>>>>>> origin/master
		return new ESFDocumentTypeWrapper(_esfDocumentType.toEscapedModel());
	}

	@Override
<<<<<<< HEAD
	public it.ethica.esf.model.ESFDocumentType toUnescapedModel() {
=======
	public ESFDocumentType toUnescapedModel() {
>>>>>>> origin/master
		return new ESFDocumentTypeWrapper(_esfDocumentType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfDocumentType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfDocumentType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfDocumentType.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFDocumentTypeWrapper)) {
			return false;
		}

		ESFDocumentTypeWrapper esfDocumentTypeWrapper = (ESFDocumentTypeWrapper)obj;

		if (Validator.equals(_esfDocumentType,
					esfDocumentTypeWrapper._esfDocumentType)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFDocumentType getWrappedESFDocumentType() {
		return _esfDocumentType;
	}

	@Override
	public ESFDocumentType getWrappedModel() {
		return _esfDocumentType;
	}

	@Override
	public void resetOriginalValues() {
		_esfDocumentType.resetOriginalValues();
	}

	private ESFDocumentType _esfDocumentType;
}