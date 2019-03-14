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
 * This class is a wrapper for {@link ESFGunType}.
 * </p>
 *
 * @author Ethica
 * @see ESFGunType
 * @generated
 */
public class ESFGunTypeWrapper implements ESFGunType, ModelWrapper<ESFGunType> {
	public ESFGunTypeWrapper(ESFGunType esfGunType) {
		_esfGunType = esfGunType;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFGunType.class;
	}

	@Override
	public String getModelClassName() {
		return ESFGunType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfGunTypeId", getEsfGunTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfGunTypeId = (Long)attributes.get("esfGunTypeId");

		if (esfGunTypeId != null) {
			setEsfGunTypeId(esfGunTypeId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	* Returns the primary key of this e s f gun type.
	*
	* @return the primary key of this e s f gun type
	*/
	@Override
	public long getPrimaryKey() {
		return _esfGunType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f gun type.
	*
	* @param primaryKey the primary key of this e s f gun type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfGunType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this e s f gun type.
	*
	* @return the uuid of this e s f gun type
	*/
	@Override
	public java.lang.String getUuid() {
		return _esfGunType.getUuid();
	}

	/**
	* Sets the uuid of this e s f gun type.
	*
	* @param uuid the uuid of this e s f gun type
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_esfGunType.setUuid(uuid);
	}

	/**
	* Returns the esf gun type ID of this e s f gun type.
	*
	* @return the esf gun type ID of this e s f gun type
	*/
	@Override
	public long getEsfGunTypeId() {
		return _esfGunType.getEsfGunTypeId();
	}

	/**
	* Sets the esf gun type ID of this e s f gun type.
	*
	* @param esfGunTypeId the esf gun type ID of this e s f gun type
	*/
	@Override
	public void setEsfGunTypeId(long esfGunTypeId) {
		_esfGunType.setEsfGunTypeId(esfGunTypeId);
	}

	/**
	* Returns the group ID of this e s f gun type.
	*
	* @return the group ID of this e s f gun type
	*/
	@Override
	public long getGroupId() {
		return _esfGunType.getGroupId();
	}

	/**
	* Sets the group ID of this e s f gun type.
	*
	* @param groupId the group ID of this e s f gun type
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfGunType.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f gun type.
	*
	* @return the company ID of this e s f gun type
	*/
	@Override
	public long getCompanyId() {
		return _esfGunType.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f gun type.
	*
	* @param companyId the company ID of this e s f gun type
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfGunType.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f gun type.
	*
	* @return the user ID of this e s f gun type
	*/
	@Override
	public long getUserId() {
		return _esfGunType.getUserId();
	}

	/**
	* Sets the user ID of this e s f gun type.
	*
	* @param userId the user ID of this e s f gun type
	*/
	@Override
	public void setUserId(long userId) {
		_esfGunType.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f gun type.
	*
	* @return the user uuid of this e s f gun type
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunType.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f gun type.
	*
	* @param userUuid the user uuid of this e s f gun type
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfGunType.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f gun type.
	*
	* @return the user name of this e s f gun type
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfGunType.getUserName();
	}

	/**
	* Sets the user name of this e s f gun type.
	*
	* @param userName the user name of this e s f gun type
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfGunType.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f gun type.
	*
	* @return the create date of this e s f gun type
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfGunType.getCreateDate();
	}

	/**
	* Sets the create date of this e s f gun type.
	*
	* @param createDate the create date of this e s f gun type
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfGunType.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f gun type.
	*
	* @return the modified date of this e s f gun type
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfGunType.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f gun type.
	*
	* @param modifiedDate the modified date of this e s f gun type
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfGunType.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this e s f gun type.
	*
	* @return the name of this e s f gun type
	*/
	@Override
	public java.lang.String getName() {
		return _esfGunType.getName();
	}

	/**
	* Sets the name of this e s f gun type.
	*
	* @param name the name of this e s f gun type
	*/
	@Override
	public void setName(java.lang.String name) {
		_esfGunType.setName(name);
	}

	/**
	* Returns the description of this e s f gun type.
	*
	* @return the description of this e s f gun type
	*/
	@Override
	public java.lang.String getDescription() {
		return _esfGunType.getDescription();
	}

	/**
	* Sets the description of this e s f gun type.
	*
	* @param description the description of this e s f gun type
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_esfGunType.setDescription(description);
	}

	@Override
	public boolean isNew() {
		return _esfGunType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfGunType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfGunType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfGunType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfGunType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfGunType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfGunType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfGunType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfGunType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfGunType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfGunType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFGunTypeWrapper((ESFGunType)_esfGunType.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFGunType esfGunType) {
		return _esfGunType.compareTo(esfGunType);
	}

	@Override
	public int hashCode() {
		return _esfGunType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFGunType> toCacheModel() {
		return _esfGunType.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFGunType toEscapedModel() {
		return new ESFGunTypeWrapper(_esfGunType.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFGunType toUnescapedModel() {
		return new ESFGunTypeWrapper(_esfGunType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfGunType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfGunType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfGunType.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFGunTypeWrapper)) {
			return false;
		}

		ESFGunTypeWrapper esfGunTypeWrapper = (ESFGunTypeWrapper)obj;

		if (Validator.equals(_esfGunType, esfGunTypeWrapper._esfGunType)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _esfGunType.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFGunType getWrappedESFGunType() {
		return _esfGunType;
	}

	@Override
	public ESFGunType getWrappedModel() {
		return _esfGunType;
	}

	@Override
	public void resetOriginalValues() {
		_esfGunType.resetOriginalValues();
	}

	private ESFGunType _esfGunType;
}