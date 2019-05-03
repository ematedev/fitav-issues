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

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ESFField}.
 * </p>
 *
 * @author Ethica
 * @see ESFField
 * @generated
 */
public class ESFFieldWrapper implements ESFField, ModelWrapper<ESFField> {
	public ESFFieldWrapper(ESFField esfField) {
		_esfField = esfField;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFField.class;
	}

	@Override
	public String getModelClassName() {
		return ESFField.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfFieldId", getEsfFieldId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("ownerOrganizationId", getOwnerOrganizationId());
		attributes.put("esfAddressId", getEsfAddressId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfFieldId = (Long)attributes.get("esfFieldId");

		if (esfFieldId != null) {
			setEsfFieldId(esfFieldId);
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

		Long ownerOrganizationId = (Long)attributes.get("ownerOrganizationId");

		if (ownerOrganizationId != null) {
			setOwnerOrganizationId(ownerOrganizationId);
		}

		Long esfAddressId = (Long)attributes.get("esfAddressId");

		if (esfAddressId != null) {
			setEsfAddressId(esfAddressId);
		}
	}

	/**
	* Returns the primary key of this e s f field.
	*
	* @return the primary key of this e s f field
	*/
	@Override
	public long getPrimaryKey() {
		return _esfField.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f field.
	*
	* @param primaryKey the primary key of this e s f field
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfField.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this e s f field.
	*
	* @return the uuid of this e s f field
	*/
	@Override
	public java.lang.String getUuid() {
		return _esfField.getUuid();
	}

	/**
	* Sets the uuid of this e s f field.
	*
	* @param uuid the uuid of this e s f field
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_esfField.setUuid(uuid);
	}

	/**
	* Returns the esf field ID of this e s f field.
	*
	* @return the esf field ID of this e s f field
	*/
	@Override
	public long getEsfFieldId() {
		return _esfField.getEsfFieldId();
	}

	/**
	* Sets the esf field ID of this e s f field.
	*
	* @param esfFieldId the esf field ID of this e s f field
	*/
	@Override
	public void setEsfFieldId(long esfFieldId) {
		_esfField.setEsfFieldId(esfFieldId);
	}

	/**
	* Returns the group ID of this e s f field.
	*
	* @return the group ID of this e s f field
	*/
	@Override
	public long getGroupId() {
		return _esfField.getGroupId();
	}

	/**
	* Sets the group ID of this e s f field.
	*
	* @param groupId the group ID of this e s f field
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfField.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f field.
	*
	* @return the company ID of this e s f field
	*/
	@Override
	public long getCompanyId() {
		return _esfField.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f field.
	*
	* @param companyId the company ID of this e s f field
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfField.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f field.
	*
	* @return the user ID of this e s f field
	*/
	@Override
	public long getUserId() {
		return _esfField.getUserId();
	}

	/**
	* Sets the user ID of this e s f field.
	*
	* @param userId the user ID of this e s f field
	*/
	@Override
	public void setUserId(long userId) {
		_esfField.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f field.
	*
	* @return the user uuid of this e s f field
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfField.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f field.
	*
	* @param userUuid the user uuid of this e s f field
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfField.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f field.
	*
	* @return the user name of this e s f field
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfField.getUserName();
	}

	/**
	* Sets the user name of this e s f field.
	*
	* @param userName the user name of this e s f field
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfField.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f field.
	*
	* @return the create date of this e s f field
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfField.getCreateDate();
	}

	/**
	* Sets the create date of this e s f field.
	*
	* @param createDate the create date of this e s f field
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfField.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f field.
	*
	* @return the modified date of this e s f field
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfField.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f field.
	*
	* @param modifiedDate the modified date of this e s f field
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfField.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this e s f field.
	*
	* @return the name of this e s f field
	*/
	@Override
	public java.lang.String getName() {
		return _esfField.getName();
	}

	/**
	* Sets the name of this e s f field.
	*
	* @param name the name of this e s f field
	*/
	@Override
	public void setName(java.lang.String name) {
		_esfField.setName(name);
	}

	/**
	* Returns the owner organization ID of this e s f field.
	*
	* @return the owner organization ID of this e s f field
	*/
	@Override
	public long getOwnerOrganizationId() {
		return _esfField.getOwnerOrganizationId();
	}

	/**
	* Sets the owner organization ID of this e s f field.
	*
	* @param ownerOrganizationId the owner organization ID of this e s f field
	*/
	@Override
	public void setOwnerOrganizationId(long ownerOrganizationId) {
		_esfField.setOwnerOrganizationId(ownerOrganizationId);
	}

	/**
	* Returns the esf address ID of this e s f field.
	*
	* @return the esf address ID of this e s f field
	*/
	@Override
	public long getEsfAddressId() {
		return _esfField.getEsfAddressId();
	}

	/**
	* Sets the esf address ID of this e s f field.
	*
	* @param esfAddressId the esf address ID of this e s f field
	*/
	@Override
	public void setEsfAddressId(long esfAddressId) {
		_esfField.setEsfAddressId(esfAddressId);
	}

	@Override
	public boolean isNew() {
		return _esfField.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfField.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfField.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfField.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfField.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfField.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfField.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfField.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfField.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfField.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfField.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFFieldWrapper((ESFField)_esfField.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFField esfField) {
		return _esfField.compareTo(esfField);
	}

	@Override
	public int hashCode() {
		return _esfField.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFField> toCacheModel() {
		return _esfField.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFField toEscapedModel() {
		return new ESFFieldWrapper(_esfField.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFField toUnescapedModel() {
		return new ESFFieldWrapper(_esfField.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfField.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfField.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfField.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFFieldWrapper)) {
			return false;
		}

		ESFFieldWrapper esfFieldWrapper = (ESFFieldWrapper)obj;

		if (Validator.equals(_esfField, esfFieldWrapper._esfField)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _esfField.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFField getWrappedESFField() {
		return _esfField;
	}

	@Override
	public ESFField getWrappedModel() {
		return _esfField;
	}

	@Override
	public void resetOriginalValues() {
		_esfField.resetOriginalValues();
	}

	private ESFField _esfField;
}