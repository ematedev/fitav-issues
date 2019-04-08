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
 * This class is a wrapper for {@link ESFSportType}.
 * </p>
 *
 * @author Ethica
 * @see ESFSportType
 * @generated
 */
public class ESFSportTypeWrapper implements ESFSportType,
	ModelWrapper<ESFSportType> {
	public ESFSportTypeWrapper(ESFSportType esfSportType) {
		_esfSportType = esfSportType;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFSportType.class;
	}

	@Override
	public String getModelClassName() {
		return ESFSportType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfSportTypeId", getEsfSportTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("national", getNational());
		attributes.put("code", getCode());
		attributes.put("isChangeCategory", getIsChangeCategory());
		attributes.put("isOlimpic", getIsOlimpic());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfSportTypeId = (Long)attributes.get("esfSportTypeId");

		if (esfSportTypeId != null) {
			setEsfSportTypeId(esfSportTypeId);
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

		Boolean national = (Boolean)attributes.get("national");

		if (national != null) {
			setNational(national);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		Boolean isChangeCategory = (Boolean)attributes.get("isChangeCategory");

		if (isChangeCategory != null) {
			setIsChangeCategory(isChangeCategory);
		}

		Boolean isOlimpic = (Boolean)attributes.get("isOlimpic");

		if (isOlimpic != null) {
			setIsOlimpic(isOlimpic);
		}
	}

	/**
	* Returns the primary key of this e s f sport type.
	*
	* @return the primary key of this e s f sport type
	*/
	@Override
	public long getPrimaryKey() {
		return _esfSportType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f sport type.
	*
	* @param primaryKey the primary key of this e s f sport type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfSportType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this e s f sport type.
	*
	* @return the uuid of this e s f sport type
	*/
	@Override
	public java.lang.String getUuid() {
		return _esfSportType.getUuid();
	}

	/**
	* Sets the uuid of this e s f sport type.
	*
	* @param uuid the uuid of this e s f sport type
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_esfSportType.setUuid(uuid);
	}

	/**
	* Returns the esf sport type ID of this e s f sport type.
	*
	* @return the esf sport type ID of this e s f sport type
	*/
	@Override
	public long getEsfSportTypeId() {
		return _esfSportType.getEsfSportTypeId();
	}

	/**
	* Sets the esf sport type ID of this e s f sport type.
	*
	* @param esfSportTypeId the esf sport type ID of this e s f sport type
	*/
	@Override
	public void setEsfSportTypeId(long esfSportTypeId) {
		_esfSportType.setEsfSportTypeId(esfSportTypeId);
	}

	/**
	* Returns the group ID of this e s f sport type.
	*
	* @return the group ID of this e s f sport type
	*/
	@Override
	public long getGroupId() {
		return _esfSportType.getGroupId();
	}

	/**
	* Sets the group ID of this e s f sport type.
	*
	* @param groupId the group ID of this e s f sport type
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfSportType.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f sport type.
	*
	* @return the company ID of this e s f sport type
	*/
	@Override
	public long getCompanyId() {
		return _esfSportType.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f sport type.
	*
	* @param companyId the company ID of this e s f sport type
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfSportType.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f sport type.
	*
	* @return the user ID of this e s f sport type
	*/
	@Override
	public long getUserId() {
		return _esfSportType.getUserId();
	}

	/**
	* Sets the user ID of this e s f sport type.
	*
	* @param userId the user ID of this e s f sport type
	*/
	@Override
	public void setUserId(long userId) {
		_esfSportType.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f sport type.
	*
	* @return the user uuid of this e s f sport type
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfSportType.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f sport type.
	*
	* @param userUuid the user uuid of this e s f sport type
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfSportType.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f sport type.
	*
	* @return the user name of this e s f sport type
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfSportType.getUserName();
	}

	/**
	* Sets the user name of this e s f sport type.
	*
	* @param userName the user name of this e s f sport type
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfSportType.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f sport type.
	*
	* @return the create date of this e s f sport type
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfSportType.getCreateDate();
	}

	/**
	* Sets the create date of this e s f sport type.
	*
	* @param createDate the create date of this e s f sport type
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfSportType.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f sport type.
	*
	* @return the modified date of this e s f sport type
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfSportType.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f sport type.
	*
	* @param modifiedDate the modified date of this e s f sport type
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfSportType.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this e s f sport type.
	*
	* @return the name of this e s f sport type
	*/
	@Override
	public java.lang.String getName() {
		return _esfSportType.getName();
	}

	/**
	* Sets the name of this e s f sport type.
	*
	* @param name the name of this e s f sport type
	*/
	@Override
	public void setName(java.lang.String name) {
		_esfSportType.setName(name);
	}

	/**
	* Returns the description of this e s f sport type.
	*
	* @return the description of this e s f sport type
	*/
	@Override
	public java.lang.String getDescription() {
		return _esfSportType.getDescription();
	}

	/**
	* Sets the description of this e s f sport type.
	*
	* @param description the description of this e s f sport type
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_esfSportType.setDescription(description);
	}

	/**
	* Returns the national of this e s f sport type.
	*
	* @return the national of this e s f sport type
	*/
	@Override
	public boolean getNational() {
		return _esfSportType.getNational();
	}

	/**
	* Returns <code>true</code> if this e s f sport type is national.
	*
	* @return <code>true</code> if this e s f sport type is national; <code>false</code> otherwise
	*/
	@Override
	public boolean isNational() {
		return _esfSportType.isNational();
	}

	/**
	* Sets whether this e s f sport type is national.
	*
	* @param national the national of this e s f sport type
	*/
	@Override
	public void setNational(boolean national) {
		_esfSportType.setNational(national);
	}

	/**
	* Returns the code of this e s f sport type.
	*
	* @return the code of this e s f sport type
	*/
	@Override
	public java.lang.String getCode() {
		return _esfSportType.getCode();
	}

	/**
	* Sets the code of this e s f sport type.
	*
	* @param code the code of this e s f sport type
	*/
	@Override
	public void setCode(java.lang.String code) {
		_esfSportType.setCode(code);
	}

	/**
	* Returns the is change category of this e s f sport type.
	*
	* @return the is change category of this e s f sport type
	*/
	@Override
	public boolean getIsChangeCategory() {
		return _esfSportType.getIsChangeCategory();
	}

	/**
	* Returns <code>true</code> if this e s f sport type is is change category.
	*
	* @return <code>true</code> if this e s f sport type is is change category; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsChangeCategory() {
		return _esfSportType.isIsChangeCategory();
	}

	/**
	* Sets whether this e s f sport type is is change category.
	*
	* @param isChangeCategory the is change category of this e s f sport type
	*/
	@Override
	public void setIsChangeCategory(boolean isChangeCategory) {
		_esfSportType.setIsChangeCategory(isChangeCategory);
	}

	/**
	* Returns the is olimpic of this e s f sport type.
	*
	* @return the is olimpic of this e s f sport type
	*/
	@Override
	public boolean getIsOlimpic() {
		return _esfSportType.getIsOlimpic();
	}

	/**
	* Returns <code>true</code> if this e s f sport type is is olimpic.
	*
	* @return <code>true</code> if this e s f sport type is is olimpic; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsOlimpic() {
		return _esfSportType.isIsOlimpic();
	}

	/**
	* Sets whether this e s f sport type is is olimpic.
	*
	* @param isOlimpic the is olimpic of this e s f sport type
	*/
	@Override
	public void setIsOlimpic(boolean isOlimpic) {
		_esfSportType.setIsOlimpic(isOlimpic);
	}

	@Override
	public boolean isNew() {
		return _esfSportType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfSportType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfSportType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfSportType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfSportType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfSportType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfSportType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfSportType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfSportType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfSportType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfSportType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFSportTypeWrapper((ESFSportType)_esfSportType.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFSportType esfSportType) {
		return _esfSportType.compareTo(esfSportType);
	}

	@Override
	public int hashCode() {
		return _esfSportType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFSportType> toCacheModel() {
		return _esfSportType.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFSportType toEscapedModel() {
		return new ESFSportTypeWrapper(_esfSportType.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFSportType toUnescapedModel() {
		return new ESFSportTypeWrapper(_esfSportType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfSportType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfSportType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfSportType.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFSportTypeWrapper)) {
			return false;
		}

		ESFSportTypeWrapper esfSportTypeWrapper = (ESFSportTypeWrapper)obj;

		if (Validator.equals(_esfSportType, esfSportTypeWrapper._esfSportType)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _esfSportType.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFSportType getWrappedESFSportType() {
		return _esfSportType;
	}

	@Override
	public ESFSportType getWrappedModel() {
		return _esfSportType;
	}

	@Override
	public void resetOriginalValues() {
		_esfSportType.resetOriginalValues();
	}

	private ESFSportType _esfSportType;
}