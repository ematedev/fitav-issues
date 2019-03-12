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
 * This class is a wrapper for {@link ESFType}.
 * </p>
 *
 * @author Ethica
 * @see ESFType
 * @generated
 */
public class ESFTypeWrapper implements ESFType, ModelWrapper<ESFType> {
	public ESFTypeWrapper(ESFType esfType) {
		_esfType = esfType;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFType.class;
	}

	@Override
	public String getModelClassName() {
		return ESFType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfTypeId", getEsfTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("code", getCode());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("className", getClassName());
		attributes.put("status", getStatus());
		attributes.put("typeParentId", getTypeParentId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfTypeId = (Long)attributes.get("esfTypeId");

		if (esfTypeId != null) {
			setEsfTypeId(esfTypeId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long typeParentId = (Long)attributes.get("typeParentId");

		if (typeParentId != null) {
			setTypeParentId(typeParentId);
		}
	}

	/**
	* Returns the primary key of this e s f type.
	*
	* @return the primary key of this e s f type
	*/
	@Override
	public long getPrimaryKey() {
		return _esfType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f type.
	*
	* @param primaryKey the primary key of this e s f type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf type ID of this e s f type.
	*
	* @return the esf type ID of this e s f type
	*/
	@Override
	public long getEsfTypeId() {
		return _esfType.getEsfTypeId();
	}

	/**
	* Sets the esf type ID of this e s f type.
	*
	* @param esfTypeId the esf type ID of this e s f type
	*/
	@Override
	public void setEsfTypeId(long esfTypeId) {
		_esfType.setEsfTypeId(esfTypeId);
	}

	/**
	* Returns the group ID of this e s f type.
	*
	* @return the group ID of this e s f type
	*/
	@Override
	public long getGroupId() {
		return _esfType.getGroupId();
	}

	/**
	* Sets the group ID of this e s f type.
	*
	* @param groupId the group ID of this e s f type
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfType.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f type.
	*
	* @return the company ID of this e s f type
	*/
	@Override
	public long getCompanyId() {
		return _esfType.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f type.
	*
	* @param companyId the company ID of this e s f type
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfType.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f type.
	*
	* @return the user ID of this e s f type
	*/
	@Override
	public long getUserId() {
		return _esfType.getUserId();
	}

	/**
	* Sets the user ID of this e s f type.
	*
	* @param userId the user ID of this e s f type
	*/
	@Override
	public void setUserId(long userId) {
		_esfType.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f type.
	*
	* @return the user uuid of this e s f type
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfType.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f type.
	*
	* @param userUuid the user uuid of this e s f type
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfType.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f type.
	*
	* @return the user name of this e s f type
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfType.getUserName();
	}

	/**
	* Sets the user name of this e s f type.
	*
	* @param userName the user name of this e s f type
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfType.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f type.
	*
	* @return the create date of this e s f type
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfType.getCreateDate();
	}

	/**
	* Sets the create date of this e s f type.
	*
	* @param createDate the create date of this e s f type
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfType.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f type.
	*
	* @return the modified date of this e s f type
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfType.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f type.
	*
	* @param modifiedDate the modified date of this e s f type
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfType.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the code of this e s f type.
	*
	* @return the code of this e s f type
	*/
	@Override
	public java.lang.String getCode() {
		return _esfType.getCode();
	}

	/**
	* Sets the code of this e s f type.
	*
	* @param code the code of this e s f type
	*/
	@Override
	public void setCode(java.lang.String code) {
		_esfType.setCode(code);
	}

	/**
	* Returns the name of this e s f type.
	*
	* @return the name of this e s f type
	*/
	@Override
	public java.lang.String getName() {
		return _esfType.getName();
	}

	/**
	* Sets the name of this e s f type.
	*
	* @param name the name of this e s f type
	*/
	@Override
	public void setName(java.lang.String name) {
		_esfType.setName(name);
	}

	/**
	* Returns the description of this e s f type.
	*
	* @return the description of this e s f type
	*/
	@Override
	public java.lang.String getDescription() {
		return _esfType.getDescription();
	}

	/**
	* Sets the description of this e s f type.
	*
	* @param description the description of this e s f type
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_esfType.setDescription(description);
	}

	/**
	* Returns the class name of this e s f type.
	*
	* @return the class name of this e s f type
	*/
	@Override
	public java.lang.String getClassName() {
		return _esfType.getClassName();
	}

	/**
	* Sets the class name of this e s f type.
	*
	* @param className the class name of this e s f type
	*/
	@Override
	public void setClassName(java.lang.String className) {
		_esfType.setClassName(className);
	}

	/**
	* Returns the status of this e s f type.
	*
	* @return the status of this e s f type
	*/
	@Override
	public java.lang.String getStatus() {
		return _esfType.getStatus();
	}

	/**
	* Sets the status of this e s f type.
	*
	* @param status the status of this e s f type
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_esfType.setStatus(status);
	}

	/**
	* Returns the type parent ID of this e s f type.
	*
	* @return the type parent ID of this e s f type
	*/
	@Override
	public long getTypeParentId() {
		return _esfType.getTypeParentId();
	}

	/**
	* Sets the type parent ID of this e s f type.
	*
	* @param typeParentId the type parent ID of this e s f type
	*/
	@Override
	public void setTypeParentId(long typeParentId) {
		_esfType.setTypeParentId(typeParentId);
	}

	@Override
	public boolean isNew() {
		return _esfType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFTypeWrapper((ESFType)_esfType.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFType esfType) {
		return _esfType.compareTo(esfType);
	}

	@Override
	public int hashCode() {
		return _esfType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFType> toCacheModel() {
		return _esfType.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFType toEscapedModel() {
		return new ESFTypeWrapper(_esfType.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFType toUnescapedModel() {
		return new ESFTypeWrapper(_esfType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfType.persist();
	}

	@Override
	public java.lang.String getParent()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfType.getParent();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFTypeWrapper)) {
			return false;
		}

		ESFTypeWrapper esfTypeWrapper = (ESFTypeWrapper)obj;

		if (Validator.equals(_esfType, esfTypeWrapper._esfType)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFType getWrappedESFType() {
		return _esfType;
	}

	@Override
	public ESFType getWrappedModel() {
		return _esfType;
	}

	@Override
	public void resetOriginalValues() {
		_esfType.resetOriginalValues();
	}

	private ESFType _esfType;
}