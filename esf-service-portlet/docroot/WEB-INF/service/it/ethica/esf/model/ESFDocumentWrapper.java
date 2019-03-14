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

import com.liferay.portal.kernel.lar.StagedModelType;
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

		attributes.put("uuid", getUuid());
		attributes.put("esfDocumentId", getEsfDocumentId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("ownerId", getOwnerId());
		attributes.put("ownerType", getOwnerType());
		attributes.put("name", getName());
		attributes.put("number", getNumber());
		attributes.put("releaseDate", getReleaseDate());
		attributes.put("expireDate", getExpireDate());
		attributes.put("issuer", getIssuer());
		attributes.put("contents", getContents());
		attributes.put("locationReference", getLocationReference());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

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

		Long ownerId = (Long)attributes.get("ownerId");

		if (ownerId != null) {
			setOwnerId(ownerId);
		}

		String ownerType = (String)attributes.get("ownerType");

		if (ownerType != null) {
			setOwnerType(ownerType);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long number = (Long)attributes.get("number");

		if (number != null) {
			setNumber(number);
		}

		Date releaseDate = (Date)attributes.get("releaseDate");

		if (releaseDate != null) {
			setReleaseDate(releaseDate);
		}

		Date expireDate = (Date)attributes.get("expireDate");

		if (expireDate != null) {
			setExpireDate(expireDate);
		}

		String issuer = (String)attributes.get("issuer");

		if (issuer != null) {
			setIssuer(issuer);
		}

		String contents = (String)attributes.get("contents");

		if (contents != null) {
			setContents(contents);
		}

		String locationReference = (String)attributes.get("locationReference");

		if (locationReference != null) {
			setLocationReference(locationReference);
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
	* Returns the uuid of this e s f document.
	*
	* @return the uuid of this e s f document
	*/
	@Override
	public java.lang.String getUuid() {
		return _esfDocument.getUuid();
	}

	/**
	* Sets the uuid of this e s f document.
	*
	* @param uuid the uuid of this e s f document
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_esfDocument.setUuid(uuid);
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
	* Returns the owner ID of this e s f document.
	*
	* @return the owner ID of this e s f document
	*/
	@Override
	public long getOwnerId() {
		return _esfDocument.getOwnerId();
	}

	/**
	* Sets the owner ID of this e s f document.
	*
	* @param ownerId the owner ID of this e s f document
	*/
	@Override
	public void setOwnerId(long ownerId) {
		_esfDocument.setOwnerId(ownerId);
	}

	/**
	* Returns the owner type of this e s f document.
	*
	* @return the owner type of this e s f document
	*/
	@Override
	public java.lang.String getOwnerType() {
		return _esfDocument.getOwnerType();
	}

	/**
	* Sets the owner type of this e s f document.
	*
	* @param ownerType the owner type of this e s f document
	*/
	@Override
	public void setOwnerType(java.lang.String ownerType) {
		_esfDocument.setOwnerType(ownerType);
	}

	/**
	* Returns the name of this e s f document.
	*
	* @return the name of this e s f document
	*/
	@Override
	public java.lang.String getName() {
		return _esfDocument.getName();
	}

	/**
	* Sets the name of this e s f document.
	*
	* @param name the name of this e s f document
	*/
	@Override
	public void setName(java.lang.String name) {
		_esfDocument.setName(name);
	}

	/**
	* Returns the number of this e s f document.
	*
	* @return the number of this e s f document
	*/
	@Override
	public long getNumber() {
		return _esfDocument.getNumber();
	}

	/**
	* Sets the number of this e s f document.
	*
	* @param number the number of this e s f document
	*/
	@Override
	public void setNumber(long number) {
		_esfDocument.setNumber(number);
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
	* Returns the expire date of this e s f document.
	*
	* @return the expire date of this e s f document
	*/
	@Override
	public java.util.Date getExpireDate() {
		return _esfDocument.getExpireDate();
	}

	/**
	* Sets the expire date of this e s f document.
	*
	* @param expireDate the expire date of this e s f document
	*/
	@Override
	public void setExpireDate(java.util.Date expireDate) {
		_esfDocument.setExpireDate(expireDate);
	}

	/**
	* Returns the issuer of this e s f document.
	*
	* @return the issuer of this e s f document
	*/
	@Override
	public java.lang.String getIssuer() {
		return _esfDocument.getIssuer();
	}

	/**
	* Sets the issuer of this e s f document.
	*
	* @param issuer the issuer of this e s f document
	*/
	@Override
	public void setIssuer(java.lang.String issuer) {
		_esfDocument.setIssuer(issuer);
	}

	/**
	* Returns the contents of this e s f document.
	*
	* @return the contents of this e s f document
	*/
	@Override
	public java.lang.String getContents() {
		return _esfDocument.getContents();
	}

	/**
	* Sets the contents of this e s f document.
	*
	* @param contents the contents of this e s f document
	*/
	@Override
	public void setContents(java.lang.String contents) {
		_esfDocument.setContents(contents);
	}

	/**
	* Returns the location reference of this e s f document.
	*
	* @return the location reference of this e s f document
	*/
	@Override
	public java.lang.String getLocationReference() {
		return _esfDocument.getLocationReference();
	}

	/**
	* Sets the location reference of this e s f document.
	*
	* @param locationReference the location reference of this e s f document
	*/
	@Override
	public void setLocationReference(java.lang.String locationReference) {
		_esfDocument.setLocationReference(locationReference);
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

	@Override
	public StagedModelType getStagedModelType() {
		return _esfDocument.getStagedModelType();
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