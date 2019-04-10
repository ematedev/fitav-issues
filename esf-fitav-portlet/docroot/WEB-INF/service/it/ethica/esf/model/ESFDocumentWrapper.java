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
 * This class is a wrapper for {@link ESFDocument}.
 * </p>
 *
 * @author Ethica
 * @see ESFDocument
 * @generated
 */
public class ESFDocumentWrapper implements ESFDocument,
	ModelWrapper<ESFDocument> {
	public ESFDocumentWrapper(ESFDocument esfDocument) {
		_esfDocument = esfDocument;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFDocument.class;
	}

	@Override
	public String getModelClassName() {
		return ESFDocument.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfDocumentId", getEsfDocumentId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("code", getCode());
		attributes.put("releasedBy", getReleasedBy());
		attributes.put("releaseDate", getReleaseDate());
		attributes.put("expirationDate", getExpirationDate());
		attributes.put("esfUserId", getEsfUserId());
		attributes.put("type", getType());
		attributes.put("path", getPath());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfDocumentId = (Long)attributes.get("esfDocumentId");

		if (esfDocumentId != null) {
			setEsfDocumentId(esfDocumentId);
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

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String releasedBy = (String)attributes.get("releasedBy");

		if (releasedBy != null) {
			setReleasedBy(releasedBy);
		}

		Date releaseDate = (Date)attributes.get("releaseDate");

		if (releaseDate != null) {
			setReleaseDate(releaseDate);
		}

		Date expirationDate = (Date)attributes.get("expirationDate");

		if (expirationDate != null) {
			setExpirationDate(expirationDate);
		}

		Long esfUserId = (Long)attributes.get("esfUserId");

		if (esfUserId != null) {
			setEsfUserId(esfUserId);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String path = (String)attributes.get("path");

		if (path != null) {
			setPath(path);
		}
	}

	/**
	* Returns the primary key of this e s f document.
	*
	* @return the primary key of this e s f document
	*/
	@Override
	public long getPrimaryKey() {
		return _esfDocument.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f document.
	*
	* @param primaryKey the primary key of this e s f document
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfDocument.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf document ID of this e s f document.
	*
	* @return the esf document ID of this e s f document
	*/
	@Override
	public long getEsfDocumentId() {
		return _esfDocument.getEsfDocumentId();
	}

	/**
	* Sets the esf document ID of this e s f document.
	*
	* @param esfDocumentId the esf document ID of this e s f document
	*/
	@Override
	public void setEsfDocumentId(long esfDocumentId) {
		_esfDocument.setEsfDocumentId(esfDocumentId);
	}

	/**
	* Returns the group ID of this e s f document.
	*
	* @return the group ID of this e s f document
	*/
	@Override
	public long getGroupId() {
		return _esfDocument.getGroupId();
	}

	/**
	* Sets the group ID of this e s f document.
	*
	* @param groupId the group ID of this e s f document
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfDocument.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f document.
	*
	* @return the company ID of this e s f document
	*/
	@Override
	public long getCompanyId() {
		return _esfDocument.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f document.
	*
	* @param companyId the company ID of this e s f document
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfDocument.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f document.
	*
	* @return the user ID of this e s f document
	*/
	@Override
	public long getUserId() {
		return _esfDocument.getUserId();
	}

	/**
	* Sets the user ID of this e s f document.
	*
	* @param userId the user ID of this e s f document
	*/
	@Override
	public void setUserId(long userId) {
		_esfDocument.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f document.
	*
	* @return the user uuid of this e s f document
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDocument.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f document.
	*
	* @param userUuid the user uuid of this e s f document
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfDocument.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f document.
	*
	* @return the user name of this e s f document
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfDocument.getUserName();
	}

	/**
	* Sets the user name of this e s f document.
	*
	* @param userName the user name of this e s f document
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfDocument.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f document.
	*
	* @return the create date of this e s f document
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfDocument.getCreateDate();
	}

	/**
	* Sets the create date of this e s f document.
	*
	* @param createDate the create date of this e s f document
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfDocument.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f document.
	*
	* @return the modified date of this e s f document
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfDocument.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f document.
	*
	* @param modifiedDate the modified date of this e s f document
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfDocument.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the code of this e s f document.
	*
	* @return the code of this e s f document
	*/
	@Override
	public java.lang.String getCode() {
		return _esfDocument.getCode();
	}

	/**
	* Sets the code of this e s f document.
	*
	* @param code the code of this e s f document
	*/
	@Override
	public void setCode(java.lang.String code) {
		_esfDocument.setCode(code);
	}

	/**
	* Returns the released by of this e s f document.
	*
	* @return the released by of this e s f document
	*/
	@Override
	public java.lang.String getReleasedBy() {
		return _esfDocument.getReleasedBy();
	}

	/**
	* Sets the released by of this e s f document.
	*
	* @param releasedBy the released by of this e s f document
	*/
	@Override
	public void setReleasedBy(java.lang.String releasedBy) {
		_esfDocument.setReleasedBy(releasedBy);
	}

	/**
	* Returns the release date of this e s f document.
	*
	* @return the release date of this e s f document
	*/
	@Override
	public java.util.Date getReleaseDate() {
		return _esfDocument.getReleaseDate();
	}

	/**
	* Sets the release date of this e s f document.
	*
	* @param releaseDate the release date of this e s f document
	*/
	@Override
	public void setReleaseDate(java.util.Date releaseDate) {
		_esfDocument.setReleaseDate(releaseDate);
	}

	/**
	* Returns the expiration date of this e s f document.
	*
	* @return the expiration date of this e s f document
	*/
	@Override
	public java.util.Date getExpirationDate() {
		return _esfDocument.getExpirationDate();
	}

	/**
	* Sets the expiration date of this e s f document.
	*
	* @param expirationDate the expiration date of this e s f document
	*/
	@Override
	public void setExpirationDate(java.util.Date expirationDate) {
		_esfDocument.setExpirationDate(expirationDate);
	}

	/**
	* Returns the esf user ID of this e s f document.
	*
	* @return the esf user ID of this e s f document
	*/
	@Override
	public long getEsfUserId() {
		return _esfDocument.getEsfUserId();
	}

	/**
	* Sets the esf user ID of this e s f document.
	*
	* @param esfUserId the esf user ID of this e s f document
	*/
	@Override
	public void setEsfUserId(long esfUserId) {
		_esfDocument.setEsfUserId(esfUserId);
	}

	/**
	* Returns the esf user uuid of this e s f document.
	*
	* @return the esf user uuid of this e s f document
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getEsfUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfDocument.getEsfUserUuid();
	}

	/**
	* Sets the esf user uuid of this e s f document.
	*
	* @param esfUserUuid the esf user uuid of this e s f document
	*/
	@Override
	public void setEsfUserUuid(java.lang.String esfUserUuid) {
		_esfDocument.setEsfUserUuid(esfUserUuid);
	}

	/**
	* Returns the type of this e s f document.
	*
	* @return the type of this e s f document
	*/
	@Override
	public java.lang.String getType() {
		return _esfDocument.getType();
	}

	/**
	* Sets the type of this e s f document.
	*
	* @param type the type of this e s f document
	*/
	@Override
	public void setType(java.lang.String type) {
		_esfDocument.setType(type);
	}

	/**
	* Returns the path of this e s f document.
	*
	* @return the path of this e s f document
	*/
	@Override
	public java.lang.String getPath() {
		return _esfDocument.getPath();
	}

	/**
	* Sets the path of this e s f document.
	*
	* @param path the path of this e s f document
	*/
	@Override
	public void setPath(java.lang.String path) {
		_esfDocument.setPath(path);
	}

	@Override
	public boolean isNew() {
		return _esfDocument.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfDocument.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfDocument.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfDocument.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfDocument.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfDocument.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfDocument.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfDocument.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfDocument.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfDocument.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfDocument.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFDocumentWrapper((ESFDocument)_esfDocument.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFDocument esfDocument) {
		return _esfDocument.compareTo(esfDocument);
	}

	@Override
	public int hashCode() {
		return _esfDocument.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFDocument> toCacheModel() {
		return _esfDocument.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFDocument toEscapedModel() {
		return new ESFDocumentWrapper(_esfDocument.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFDocument toUnescapedModel() {
		return new ESFDocumentWrapper(_esfDocument.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfDocument.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfDocument.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfDocument.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFDocumentWrapper)) {
			return false;
		}

		ESFDocumentWrapper esfDocumentWrapper = (ESFDocumentWrapper)obj;

		if (Validator.equals(_esfDocument, esfDocumentWrapper._esfDocument)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFDocument getWrappedESFDocument() {
		return _esfDocument;
	}

	@Override
	public ESFDocument getWrappedModel() {
		return _esfDocument;
	}

	@Override
	public void resetOriginalValues() {
		_esfDocument.resetOriginalValues();
	}

	private ESFDocument _esfDocument;
}