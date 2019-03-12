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
 * This class is a wrapper for {@link ESFShooterCategory}.
 * </p>
 *
 * @author Ethica
 * @see ESFShooterCategory
 * @generated
 */
public class ESFShooterCategoryWrapper implements ESFShooterCategory,
	ModelWrapper<ESFShooterCategory> {
	public ESFShooterCategoryWrapper(ESFShooterCategory esfShooterCategory) {
		_esfShooterCategory = esfShooterCategory;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFShooterCategory.class;
	}

	@Override
	public String getModelClassName() {
		return ESFShooterCategory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfShooterCategoryId", getEsfShooterCategoryId());
		attributes.put("name", getName());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("description", getDescription());
		attributes.put("code", getCode());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfShooterCategoryId = (Long)attributes.get("esfShooterCategoryId");

		if (esfShooterCategoryId != null) {
			setEsfShooterCategoryId(esfShooterCategoryId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
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

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}
	}

	/**
	* Returns the primary key of this e s f shooter category.
	*
	* @return the primary key of this e s f shooter category
	*/
	@Override
	public long getPrimaryKey() {
		return _esfShooterCategory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f shooter category.
	*
	* @param primaryKey the primary key of this e s f shooter category
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfShooterCategory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this e s f shooter category.
	*
	* @return the uuid of this e s f shooter category
	*/
	@Override
	public java.lang.String getUuid() {
		return _esfShooterCategory.getUuid();
	}

	/**
	* Sets the uuid of this e s f shooter category.
	*
	* @param uuid the uuid of this e s f shooter category
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_esfShooterCategory.setUuid(uuid);
	}

	/**
	* Returns the esf shooter category ID of this e s f shooter category.
	*
	* @return the esf shooter category ID of this e s f shooter category
	*/
	@Override
	public long getEsfShooterCategoryId() {
		return _esfShooterCategory.getEsfShooterCategoryId();
	}

	/**
	* Sets the esf shooter category ID of this e s f shooter category.
	*
	* @param esfShooterCategoryId the esf shooter category ID of this e s f shooter category
	*/
	@Override
	public void setEsfShooterCategoryId(long esfShooterCategoryId) {
		_esfShooterCategory.setEsfShooterCategoryId(esfShooterCategoryId);
	}

	/**
	* Returns the name of this e s f shooter category.
	*
	* @return the name of this e s f shooter category
	*/
	@Override
	public java.lang.String getName() {
		return _esfShooterCategory.getName();
	}

	/**
	* Sets the name of this e s f shooter category.
	*
	* @param name the name of this e s f shooter category
	*/
	@Override
	public void setName(java.lang.String name) {
		_esfShooterCategory.setName(name);
	}

	/**
	* Returns the group ID of this e s f shooter category.
	*
	* @return the group ID of this e s f shooter category
	*/
	@Override
	public long getGroupId() {
		return _esfShooterCategory.getGroupId();
	}

	/**
	* Sets the group ID of this e s f shooter category.
	*
	* @param groupId the group ID of this e s f shooter category
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfShooterCategory.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f shooter category.
	*
	* @return the company ID of this e s f shooter category
	*/
	@Override
	public long getCompanyId() {
		return _esfShooterCategory.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f shooter category.
	*
	* @param companyId the company ID of this e s f shooter category
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfShooterCategory.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f shooter category.
	*
	* @return the user ID of this e s f shooter category
	*/
	@Override
	public long getUserId() {
		return _esfShooterCategory.getUserId();
	}

	/**
	* Sets the user ID of this e s f shooter category.
	*
	* @param userId the user ID of this e s f shooter category
	*/
	@Override
	public void setUserId(long userId) {
		_esfShooterCategory.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f shooter category.
	*
	* @return the user uuid of this e s f shooter category
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterCategory.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f shooter category.
	*
	* @param userUuid the user uuid of this e s f shooter category
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfShooterCategory.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f shooter category.
	*
	* @return the user name of this e s f shooter category
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfShooterCategory.getUserName();
	}

	/**
	* Sets the user name of this e s f shooter category.
	*
	* @param userName the user name of this e s f shooter category
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfShooterCategory.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f shooter category.
	*
	* @return the create date of this e s f shooter category
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfShooterCategory.getCreateDate();
	}

	/**
	* Sets the create date of this e s f shooter category.
	*
	* @param createDate the create date of this e s f shooter category
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfShooterCategory.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f shooter category.
	*
	* @return the modified date of this e s f shooter category
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfShooterCategory.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f shooter category.
	*
	* @param modifiedDate the modified date of this e s f shooter category
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfShooterCategory.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the description of this e s f shooter category.
	*
	* @return the description of this e s f shooter category
	*/
	@Override
	public java.lang.String getDescription() {
		return _esfShooterCategory.getDescription();
	}

	/**
	* Sets the description of this e s f shooter category.
	*
	* @param description the description of this e s f shooter category
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_esfShooterCategory.setDescription(description);
	}

	/**
	* Returns the code of this e s f shooter category.
	*
	* @return the code of this e s f shooter category
	*/
	@Override
	public java.lang.String getCode() {
		return _esfShooterCategory.getCode();
	}

	/**
	* Sets the code of this e s f shooter category.
	*
	* @param code the code of this e s f shooter category
	*/
	@Override
	public void setCode(java.lang.String code) {
		_esfShooterCategory.setCode(code);
	}

	@Override
	public boolean isNew() {
		return _esfShooterCategory.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfShooterCategory.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfShooterCategory.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfShooterCategory.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfShooterCategory.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfShooterCategory.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfShooterCategory.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfShooterCategory.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfShooterCategory.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfShooterCategory.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfShooterCategory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFShooterCategoryWrapper((ESFShooterCategory)_esfShooterCategory.clone());
	}

	@Override
	public int compareTo(
		it.ethica.esf.model.ESFShooterCategory esfShooterCategory) {
		return _esfShooterCategory.compareTo(esfShooterCategory);
	}

	@Override
	public int hashCode() {
		return _esfShooterCategory.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFShooterCategory> toCacheModel() {
		return _esfShooterCategory.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFShooterCategory toEscapedModel() {
		return new ESFShooterCategoryWrapper(_esfShooterCategory.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFShooterCategory toUnescapedModel() {
		return new ESFShooterCategoryWrapper(_esfShooterCategory.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfShooterCategory.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfShooterCategory.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfShooterCategory.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFShooterCategoryWrapper)) {
			return false;
		}

		ESFShooterCategoryWrapper esfShooterCategoryWrapper = (ESFShooterCategoryWrapper)obj;

		if (Validator.equals(_esfShooterCategory,
					esfShooterCategoryWrapper._esfShooterCategory)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _esfShooterCategory.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFShooterCategory getWrappedESFShooterCategory() {
		return _esfShooterCategory;
	}

	@Override
	public ESFShooterCategory getWrappedModel() {
		return _esfShooterCategory;
	}

	@Override
	public void resetOriginalValues() {
		_esfShooterCategory.resetOriginalValues();
	}

	private ESFShooterCategory _esfShooterCategory;
}