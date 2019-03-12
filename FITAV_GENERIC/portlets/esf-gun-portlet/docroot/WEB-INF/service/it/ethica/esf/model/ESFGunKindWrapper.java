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
 * This class is a wrapper for {@link ESFGunKind}.
 * </p>
 *
 * @author Ethica
 * @see ESFGunKind
 * @generated
 */
public class ESFGunKindWrapper implements ESFGunKind, ModelWrapper<ESFGunKind> {
	public ESFGunKindWrapper(ESFGunKind esfGunKind) {
		_esfGunKind = esfGunKind;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFGunKind.class;
	}

	@Override
	public String getModelClassName() {
		return ESFGunKind.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfGunKindId", getEsfGunKindId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("esfGunTypeId", getEsfGunTypeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfGunKindId = (Long)attributes.get("esfGunKindId");

		if (esfGunKindId != null) {
			setEsfGunKindId(esfGunKindId);
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

		Long esfGunTypeId = (Long)attributes.get("esfGunTypeId");

		if (esfGunTypeId != null) {
			setEsfGunTypeId(esfGunTypeId);
		}
	}

	/**
	* Returns the primary key of this e s f gun kind.
	*
	* @return the primary key of this e s f gun kind
	*/
	@Override
	public long getPrimaryKey() {
		return _esfGunKind.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f gun kind.
	*
	* @param primaryKey the primary key of this e s f gun kind
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfGunKind.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this e s f gun kind.
	*
	* @return the uuid of this e s f gun kind
	*/
	@Override
	public java.lang.String getUuid() {
		return _esfGunKind.getUuid();
	}

	/**
	* Sets the uuid of this e s f gun kind.
	*
	* @param uuid the uuid of this e s f gun kind
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_esfGunKind.setUuid(uuid);
	}

	/**
	* Returns the esf gun kind ID of this e s f gun kind.
	*
	* @return the esf gun kind ID of this e s f gun kind
	*/
	@Override
	public long getEsfGunKindId() {
		return _esfGunKind.getEsfGunKindId();
	}

	/**
	* Sets the esf gun kind ID of this e s f gun kind.
	*
	* @param esfGunKindId the esf gun kind ID of this e s f gun kind
	*/
	@Override
	public void setEsfGunKindId(long esfGunKindId) {
		_esfGunKind.setEsfGunKindId(esfGunKindId);
	}

	/**
	* Returns the group ID of this e s f gun kind.
	*
	* @return the group ID of this e s f gun kind
	*/
	@Override
	public long getGroupId() {
		return _esfGunKind.getGroupId();
	}

	/**
	* Sets the group ID of this e s f gun kind.
	*
	* @param groupId the group ID of this e s f gun kind
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfGunKind.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f gun kind.
	*
	* @return the company ID of this e s f gun kind
	*/
	@Override
	public long getCompanyId() {
		return _esfGunKind.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f gun kind.
	*
	* @param companyId the company ID of this e s f gun kind
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfGunKind.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f gun kind.
	*
	* @return the user ID of this e s f gun kind
	*/
	@Override
	public long getUserId() {
		return _esfGunKind.getUserId();
	}

	/**
	* Sets the user ID of this e s f gun kind.
	*
	* @param userId the user ID of this e s f gun kind
	*/
	@Override
	public void setUserId(long userId) {
		_esfGunKind.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f gun kind.
	*
	* @return the user uuid of this e s f gun kind
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGunKind.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f gun kind.
	*
	* @param userUuid the user uuid of this e s f gun kind
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfGunKind.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f gun kind.
	*
	* @return the user name of this e s f gun kind
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfGunKind.getUserName();
	}

	/**
	* Sets the user name of this e s f gun kind.
	*
	* @param userName the user name of this e s f gun kind
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfGunKind.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f gun kind.
	*
	* @return the create date of this e s f gun kind
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfGunKind.getCreateDate();
	}

	/**
	* Sets the create date of this e s f gun kind.
	*
	* @param createDate the create date of this e s f gun kind
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfGunKind.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f gun kind.
	*
	* @return the modified date of this e s f gun kind
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfGunKind.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f gun kind.
	*
	* @param modifiedDate the modified date of this e s f gun kind
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfGunKind.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this e s f gun kind.
	*
	* @return the name of this e s f gun kind
	*/
	@Override
	public java.lang.String getName() {
		return _esfGunKind.getName();
	}

	/**
	* Sets the name of this e s f gun kind.
	*
	* @param name the name of this e s f gun kind
	*/
	@Override
	public void setName(java.lang.String name) {
		_esfGunKind.setName(name);
	}

	/**
	* Returns the description of this e s f gun kind.
	*
	* @return the description of this e s f gun kind
	*/
	@Override
	public java.lang.String getDescription() {
		return _esfGunKind.getDescription();
	}

	/**
	* Sets the description of this e s f gun kind.
	*
	* @param description the description of this e s f gun kind
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_esfGunKind.setDescription(description);
	}

	/**
	* Returns the esf gun type ID of this e s f gun kind.
	*
	* @return the esf gun type ID of this e s f gun kind
	*/
	@Override
	public long getEsfGunTypeId() {
		return _esfGunKind.getEsfGunTypeId();
	}

	/**
	* Sets the esf gun type ID of this e s f gun kind.
	*
	* @param esfGunTypeId the esf gun type ID of this e s f gun kind
	*/
	@Override
	public void setEsfGunTypeId(long esfGunTypeId) {
		_esfGunKind.setEsfGunTypeId(esfGunTypeId);
	}

	@Override
	public boolean isNew() {
		return _esfGunKind.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfGunKind.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfGunKind.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfGunKind.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfGunKind.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfGunKind.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfGunKind.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfGunKind.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfGunKind.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfGunKind.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfGunKind.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFGunKindWrapper((ESFGunKind)_esfGunKind.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFGunKind esfGunKind) {
		return _esfGunKind.compareTo(esfGunKind);
	}

	@Override
	public int hashCode() {
		return _esfGunKind.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFGunKind> toCacheModel() {
		return _esfGunKind.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFGunKind toEscapedModel() {
		return new ESFGunKindWrapper(_esfGunKind.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFGunKind toUnescapedModel() {
		return new ESFGunKindWrapper(_esfGunKind.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfGunKind.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfGunKind.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfGunKind.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFGunKindWrapper)) {
			return false;
		}

		ESFGunKindWrapper esfGunKindWrapper = (ESFGunKindWrapper)obj;

		if (Validator.equals(_esfGunKind, esfGunKindWrapper._esfGunKind)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _esfGunKind.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFGunKind getWrappedESFGunKind() {
		return _esfGunKind;
	}

	@Override
	public ESFGunKind getWrappedModel() {
		return _esfGunKind;
	}

	@Override
	public void resetOriginalValues() {
		_esfGunKind.resetOriginalValues();
	}

	private ESFGunKind _esfGunKind;
}