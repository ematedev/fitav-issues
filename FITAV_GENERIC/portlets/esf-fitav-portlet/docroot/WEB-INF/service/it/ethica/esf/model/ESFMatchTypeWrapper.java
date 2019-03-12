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
 * This class is a wrapper for {@link ESFMatchType}.
 * </p>
 *
 * @author Ethica
 * @see ESFMatchType
 * @generated
 */
public class ESFMatchTypeWrapper implements ESFMatchType,
	ModelWrapper<ESFMatchType> {
	public ESFMatchTypeWrapper(ESFMatchType esfMatchType) {
		_esfMatchType = esfMatchType;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFMatchType.class;
	}

	@Override
	public String getModelClassName() {
		return ESFMatchType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfMatchTypeId", getEsfMatchTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("isCategoryQualification", getIsCategoryQualification());
		attributes.put("isNational", getIsNational());
		attributes.put("code", getCode());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfMatchTypeId = (Long)attributes.get("esfMatchTypeId");

		if (esfMatchTypeId != null) {
			setEsfMatchTypeId(esfMatchTypeId);
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

		Boolean isCategoryQualification = (Boolean)attributes.get(
				"isCategoryQualification");

		if (isCategoryQualification != null) {
			setIsCategoryQualification(isCategoryQualification);
		}

		Boolean isNational = (Boolean)attributes.get("isNational");

		if (isNational != null) {
			setIsNational(isNational);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}
	}

	/**
	* Returns the primary key of this e s f match type.
	*
	* @return the primary key of this e s f match type
	*/
	@Override
	public long getPrimaryKey() {
		return _esfMatchType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f match type.
	*
	* @param primaryKey the primary key of this e s f match type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfMatchType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf match type ID of this e s f match type.
	*
	* @return the esf match type ID of this e s f match type
	*/
	@Override
	public long getEsfMatchTypeId() {
		return _esfMatchType.getEsfMatchTypeId();
	}

	/**
	* Sets the esf match type ID of this e s f match type.
	*
	* @param esfMatchTypeId the esf match type ID of this e s f match type
	*/
	@Override
	public void setEsfMatchTypeId(long esfMatchTypeId) {
		_esfMatchType.setEsfMatchTypeId(esfMatchTypeId);
	}

	/**
	* Returns the group ID of this e s f match type.
	*
	* @return the group ID of this e s f match type
	*/
	@Override
	public long getGroupId() {
		return _esfMatchType.getGroupId();
	}

	/**
	* Sets the group ID of this e s f match type.
	*
	* @param groupId the group ID of this e s f match type
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfMatchType.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f match type.
	*
	* @return the company ID of this e s f match type
	*/
	@Override
	public long getCompanyId() {
		return _esfMatchType.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f match type.
	*
	* @param companyId the company ID of this e s f match type
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfMatchType.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f match type.
	*
	* @return the user ID of this e s f match type
	*/
	@Override
	public long getUserId() {
		return _esfMatchType.getUserId();
	}

	/**
	* Sets the user ID of this e s f match type.
	*
	* @param userId the user ID of this e s f match type
	*/
	@Override
	public void setUserId(long userId) {
		_esfMatchType.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f match type.
	*
	* @return the user uuid of this e s f match type
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfMatchType.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f match type.
	*
	* @param userUuid the user uuid of this e s f match type
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfMatchType.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f match type.
	*
	* @return the user name of this e s f match type
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfMatchType.getUserName();
	}

	/**
	* Sets the user name of this e s f match type.
	*
	* @param userName the user name of this e s f match type
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfMatchType.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f match type.
	*
	* @return the create date of this e s f match type
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfMatchType.getCreateDate();
	}

	/**
	* Sets the create date of this e s f match type.
	*
	* @param createDate the create date of this e s f match type
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfMatchType.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f match type.
	*
	* @return the modified date of this e s f match type
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfMatchType.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f match type.
	*
	* @param modifiedDate the modified date of this e s f match type
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfMatchType.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this e s f match type.
	*
	* @return the name of this e s f match type
	*/
	@Override
	public java.lang.String getName() {
		return _esfMatchType.getName();
	}

	/**
	* Sets the name of this e s f match type.
	*
	* @param name the name of this e s f match type
	*/
	@Override
	public void setName(java.lang.String name) {
		_esfMatchType.setName(name);
	}

	/**
	* Returns the is category qualification of this e s f match type.
	*
	* @return the is category qualification of this e s f match type
	*/
	@Override
	public boolean getIsCategoryQualification() {
		return _esfMatchType.getIsCategoryQualification();
	}

	/**
	* Returns <code>true</code> if this e s f match type is is category qualification.
	*
	* @return <code>true</code> if this e s f match type is is category qualification; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsCategoryQualification() {
		return _esfMatchType.isIsCategoryQualification();
	}

	/**
	* Sets whether this e s f match type is is category qualification.
	*
	* @param isCategoryQualification the is category qualification of this e s f match type
	*/
	@Override
	public void setIsCategoryQualification(boolean isCategoryQualification) {
		_esfMatchType.setIsCategoryQualification(isCategoryQualification);
	}

	/**
	* Returns the is national of this e s f match type.
	*
	* @return the is national of this e s f match type
	*/
	@Override
	public boolean getIsNational() {
		return _esfMatchType.getIsNational();
	}

	/**
	* Returns <code>true</code> if this e s f match type is is national.
	*
	* @return <code>true</code> if this e s f match type is is national; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsNational() {
		return _esfMatchType.isIsNational();
	}

	/**
	* Sets whether this e s f match type is is national.
	*
	* @param isNational the is national of this e s f match type
	*/
	@Override
	public void setIsNational(boolean isNational) {
		_esfMatchType.setIsNational(isNational);
	}

	/**
	* Returns the code of this e s f match type.
	*
	* @return the code of this e s f match type
	*/
	@Override
	public java.lang.String getCode() {
		return _esfMatchType.getCode();
	}

	/**
	* Sets the code of this e s f match type.
	*
	* @param code the code of this e s f match type
	*/
	@Override
	public void setCode(java.lang.String code) {
		_esfMatchType.setCode(code);
	}

	@Override
	public boolean isNew() {
		return _esfMatchType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfMatchType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfMatchType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfMatchType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfMatchType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfMatchType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfMatchType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfMatchType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfMatchType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfMatchType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfMatchType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFMatchTypeWrapper((ESFMatchType)_esfMatchType.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFMatchType esfMatchType) {
		return _esfMatchType.compareTo(esfMatchType);
	}

	@Override
	public int hashCode() {
		return _esfMatchType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFMatchType> toCacheModel() {
		return _esfMatchType.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFMatchType toEscapedModel() {
		return new ESFMatchTypeWrapper(_esfMatchType.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFMatchType toUnescapedModel() {
		return new ESFMatchTypeWrapper(_esfMatchType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfMatchType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfMatchType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfMatchType.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFMatchTypeWrapper)) {
			return false;
		}

		ESFMatchTypeWrapper esfMatchTypeWrapper = (ESFMatchTypeWrapper)obj;

		if (Validator.equals(_esfMatchType, esfMatchTypeWrapper._esfMatchType)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFMatchType getWrappedESFMatchType() {
		return _esfMatchType;
	}

	@Override
	public ESFMatchType getWrappedModel() {
		return _esfMatchType;
	}

	@Override
	public void resetOriginalValues() {
		_esfMatchType.resetOriginalValues();
	}

	private ESFMatchType _esfMatchType;
}