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
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("esfDocumentId", getEsfDocumentId());
		attributes.put("esfTypeId", getEsfTypeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfDocumentTypeId = (Long)attributes.get("esfDocumentTypeId");

		if (esfDocumentTypeId != null) {
			setEsfDocumentTypeId(esfDocumentTypeId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long esfDocumentId = (Long)attributes.get("esfDocumentId");

		if (esfDocumentId != null) {
			setEsfDocumentId(esfDocumentId);
		}

		Long esfTypeId = (Long)attributes.get("esfTypeId");

		if (esfTypeId != null) {
			setEsfTypeId(esfTypeId);
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
	* Returns the group ID of this e s f document type.
	*
	* @return the group ID of this e s f document type
	*/
	@Override
	public long getGroupId() {
		return _esfDocumentType.getGroupId();
	}

	/**
	* Sets the group ID of this e s f document type.
	*
	* @param groupId the group ID of this e s f document type
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfDocumentType.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f document type.
	*
	* @return the company ID of this e s f document type
	*/
	@Override
	public long getCompanyId() {
		return _esfDocumentType.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f document type.
	*
	* @param companyId the company ID of this e s f document type
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfDocumentType.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f document type.
	*
	* @return the user ID of this e s f document type
	*/
	@Override
	public long getUserId() {
		return _esfDocumentType.getUserId();
	}

	/**
	* Sets the user ID of this e s f document type.
	*
	* @param userId the user ID of this e s f document type
	*/
	@Override
	public void setUserId(long userId) {
		_esfDocumentType.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f document type.
	*
	* @return the user uuid of this e s f document type
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDocumentType.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f document type.
	*
	* @param userUuid the user uuid of this e s f document type
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfDocumentType.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f document type.
	*
	* @return the user name of this e s f document type
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfDocumentType.getUserName();
	}

	/**
	* Sets the user name of this e s f document type.
	*
	* @param userName the user name of this e s f document type
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfDocumentType.setUserName(userName);
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
	* Returns the esf document ID of this e s f document type.
	*
	* @return the esf document ID of this e s f document type
	*/
	@Override
	public long getEsfDocumentId() {
		return _esfDocumentType.getEsfDocumentId();
	}

	/**
	* Sets the esf document ID of this e s f document type.
	*
	* @param esfDocumentId the esf document ID of this e s f document type
	*/
	@Override
	public void setEsfDocumentId(long esfDocumentId) {
		_esfDocumentType.setEsfDocumentId(esfDocumentId);
	}

	/**
	* Returns the esf type ID of this e s f document type.
	*
	* @return the esf type ID of this e s f document type
	*/
	@Override
	public long getEsfTypeId() {
		return _esfDocumentType.getEsfTypeId();
	}

	/**
	* Sets the esf type ID of this e s f document type.
	*
	* @param esfTypeId the esf type ID of this e s f document type
	*/
	@Override
	public void setEsfTypeId(long esfTypeId) {
		_esfDocumentType.setEsfTypeId(esfTypeId);
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
	public int compareTo(it.ethica.esf.model.ESFDocumentType esfDocumentType) {
		return _esfDocumentType.compareTo(esfDocumentType);
	}

	@Override
	public int hashCode() {
		return _esfDocumentType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFDocumentType> toCacheModel() {
		return _esfDocumentType.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFDocumentType toEscapedModel() {
		return new ESFDocumentTypeWrapper(_esfDocumentType.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFDocumentType toUnescapedModel() {
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