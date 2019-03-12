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
 * This class is a wrapper for {@link ESFFornitureType}.
 * </p>
 *
 * @author Ethica
 * @see ESFFornitureType
 * @generated
 */
public class ESFFornitureTypeWrapper implements ESFFornitureType,
	ModelWrapper<ESFFornitureType> {
	public ESFFornitureTypeWrapper(ESFFornitureType esfFornitureType) {
		_esfFornitureType = esfFornitureType;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFFornitureType.class;
	}

	@Override
	public String getModelClassName() {
		return ESFFornitureType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfFornitureTypeId", getEsfFornitureTypeId());
		attributes.put("description", getDescription());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfFornitureTypeId = (Long)attributes.get("esfFornitureTypeId");

		if (esfFornitureTypeId != null) {
			setEsfFornitureTypeId(esfFornitureTypeId);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
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
	}

	/**
	* Returns the primary key of this e s f forniture type.
	*
	* @return the primary key of this e s f forniture type
	*/
	@Override
	public long getPrimaryKey() {
		return _esfFornitureType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f forniture type.
	*
	* @param primaryKey the primary key of this e s f forniture type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfFornitureType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this e s f forniture type.
	*
	* @return the uuid of this e s f forniture type
	*/
	@Override
	public java.lang.String getUuid() {
		return _esfFornitureType.getUuid();
	}

	/**
	* Sets the uuid of this e s f forniture type.
	*
	* @param uuid the uuid of this e s f forniture type
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_esfFornitureType.setUuid(uuid);
	}

	/**
	* Returns the esf forniture type ID of this e s f forniture type.
	*
	* @return the esf forniture type ID of this e s f forniture type
	*/
	@Override
	public long getEsfFornitureTypeId() {
		return _esfFornitureType.getEsfFornitureTypeId();
	}

	/**
	* Sets the esf forniture type ID of this e s f forniture type.
	*
	* @param esfFornitureTypeId the esf forniture type ID of this e s f forniture type
	*/
	@Override
	public void setEsfFornitureTypeId(long esfFornitureTypeId) {
		_esfFornitureType.setEsfFornitureTypeId(esfFornitureTypeId);
	}

	/**
	* Returns the description of this e s f forniture type.
	*
	* @return the description of this e s f forniture type
	*/
	@Override
	public java.lang.String getDescription() {
		return _esfFornitureType.getDescription();
	}

	/**
	* Sets the description of this e s f forniture type.
	*
	* @param description the description of this e s f forniture type
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_esfFornitureType.setDescription(description);
	}

	/**
	* Returns the group ID of this e s f forniture type.
	*
	* @return the group ID of this e s f forniture type
	*/
	@Override
	public long getGroupId() {
		return _esfFornitureType.getGroupId();
	}

	/**
	* Sets the group ID of this e s f forniture type.
	*
	* @param groupId the group ID of this e s f forniture type
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfFornitureType.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f forniture type.
	*
	* @return the company ID of this e s f forniture type
	*/
	@Override
	public long getCompanyId() {
		return _esfFornitureType.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f forniture type.
	*
	* @param companyId the company ID of this e s f forniture type
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfFornitureType.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f forniture type.
	*
	* @return the user ID of this e s f forniture type
	*/
	@Override
	public long getUserId() {
		return _esfFornitureType.getUserId();
	}

	/**
	* Sets the user ID of this e s f forniture type.
	*
	* @param userId the user ID of this e s f forniture type
	*/
	@Override
	public void setUserId(long userId) {
		_esfFornitureType.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f forniture type.
	*
	* @return the user uuid of this e s f forniture type
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFornitureType.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f forniture type.
	*
	* @param userUuid the user uuid of this e s f forniture type
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfFornitureType.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f forniture type.
	*
	* @return the user name of this e s f forniture type
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfFornitureType.getUserName();
	}

	/**
	* Sets the user name of this e s f forniture type.
	*
	* @param userName the user name of this e s f forniture type
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfFornitureType.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f forniture type.
	*
	* @return the create date of this e s f forniture type
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfFornitureType.getCreateDate();
	}

	/**
	* Sets the create date of this e s f forniture type.
	*
	* @param createDate the create date of this e s f forniture type
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfFornitureType.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f forniture type.
	*
	* @return the modified date of this e s f forniture type
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfFornitureType.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f forniture type.
	*
	* @param modifiedDate the modified date of this e s f forniture type
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfFornitureType.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _esfFornitureType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfFornitureType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfFornitureType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfFornitureType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfFornitureType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfFornitureType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfFornitureType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfFornitureType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfFornitureType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfFornitureType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfFornitureType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFFornitureTypeWrapper((ESFFornitureType)_esfFornitureType.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFFornitureType esfFornitureType) {
		return _esfFornitureType.compareTo(esfFornitureType);
	}

	@Override
	public int hashCode() {
		return _esfFornitureType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFFornitureType> toCacheModel() {
		return _esfFornitureType.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFFornitureType toEscapedModel() {
		return new ESFFornitureTypeWrapper(_esfFornitureType.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFFornitureType toUnescapedModel() {
		return new ESFFornitureTypeWrapper(_esfFornitureType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfFornitureType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfFornitureType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfFornitureType.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFFornitureTypeWrapper)) {
			return false;
		}

		ESFFornitureTypeWrapper esfFornitureTypeWrapper = (ESFFornitureTypeWrapper)obj;

		if (Validator.equals(_esfFornitureType,
					esfFornitureTypeWrapper._esfFornitureType)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _esfFornitureType.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFFornitureType getWrappedESFFornitureType() {
		return _esfFornitureType;
	}

	@Override
	public ESFFornitureType getWrappedModel() {
		return _esfFornitureType;
	}

	@Override
	public void resetOriginalValues() {
		_esfFornitureType.resetOriginalValues();
	}

	private ESFFornitureType _esfFornitureType;
}