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
 * This class is a wrapper for {@link ESFShooterQualification}.
 * </p>
 *
 * @author Ethica
 * @see ESFShooterQualification
 * @generated
 */
public class ESFShooterQualificationWrapper implements ESFShooterQualification,
	ModelWrapper<ESFShooterQualification> {
	public ESFShooterQualificationWrapper(
		ESFShooterQualification esfShooterQualification) {
		_esfShooterQualification = esfShooterQualification;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFShooterQualification.class;
	}

	@Override
	public String getModelClassName() {
		return ESFShooterQualification.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfShooterQualificationId",
			getEsfShooterQualificationId());
		attributes.put("name", getName());
		attributes.put("isJunior", getIsJunior());
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

		Long esfShooterQualificationId = (Long)attributes.get(
				"esfShooterQualificationId");

		if (esfShooterQualificationId != null) {
			setEsfShooterQualificationId(esfShooterQualificationId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Boolean isJunior = (Boolean)attributes.get("isJunior");

		if (isJunior != null) {
			setIsJunior(isJunior);
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
	* Returns the primary key of this e s f shooter qualification.
	*
	* @return the primary key of this e s f shooter qualification
	*/
	@Override
	public long getPrimaryKey() {
		return _esfShooterQualification.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f shooter qualification.
	*
	* @param primaryKey the primary key of this e s f shooter qualification
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfShooterQualification.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this e s f shooter qualification.
	*
	* @return the uuid of this e s f shooter qualification
	*/
	@Override
	public java.lang.String getUuid() {
		return _esfShooterQualification.getUuid();
	}

	/**
	* Sets the uuid of this e s f shooter qualification.
	*
	* @param uuid the uuid of this e s f shooter qualification
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_esfShooterQualification.setUuid(uuid);
	}

	/**
	* Returns the esf shooter qualification ID of this e s f shooter qualification.
	*
	* @return the esf shooter qualification ID of this e s f shooter qualification
	*/
	@Override
	public long getEsfShooterQualificationId() {
		return _esfShooterQualification.getEsfShooterQualificationId();
	}

	/**
	* Sets the esf shooter qualification ID of this e s f shooter qualification.
	*
	* @param esfShooterQualificationId the esf shooter qualification ID of this e s f shooter qualification
	*/
	@Override
	public void setEsfShooterQualificationId(long esfShooterQualificationId) {
		_esfShooterQualification.setEsfShooterQualificationId(esfShooterQualificationId);
	}

	/**
	* Returns the name of this e s f shooter qualification.
	*
	* @return the name of this e s f shooter qualification
	*/
	@Override
	public java.lang.String getName() {
		return _esfShooterQualification.getName();
	}

	/**
	* Sets the name of this e s f shooter qualification.
	*
	* @param name the name of this e s f shooter qualification
	*/
	@Override
	public void setName(java.lang.String name) {
		_esfShooterQualification.setName(name);
	}

	/**
	* Returns the is junior of this e s f shooter qualification.
	*
	* @return the is junior of this e s f shooter qualification
	*/
	@Override
	public boolean getIsJunior() {
		return _esfShooterQualification.getIsJunior();
	}

	/**
	* Returns <code>true</code> if this e s f shooter qualification is is junior.
	*
	* @return <code>true</code> if this e s f shooter qualification is is junior; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsJunior() {
		return _esfShooterQualification.isIsJunior();
	}

	/**
	* Sets whether this e s f shooter qualification is is junior.
	*
	* @param isJunior the is junior of this e s f shooter qualification
	*/
	@Override
	public void setIsJunior(boolean isJunior) {
		_esfShooterQualification.setIsJunior(isJunior);
	}

	/**
	* Returns the group ID of this e s f shooter qualification.
	*
	* @return the group ID of this e s f shooter qualification
	*/
	@Override
	public long getGroupId() {
		return _esfShooterQualification.getGroupId();
	}

	/**
	* Sets the group ID of this e s f shooter qualification.
	*
	* @param groupId the group ID of this e s f shooter qualification
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfShooterQualification.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f shooter qualification.
	*
	* @return the company ID of this e s f shooter qualification
	*/
	@Override
	public long getCompanyId() {
		return _esfShooterQualification.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f shooter qualification.
	*
	* @param companyId the company ID of this e s f shooter qualification
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfShooterQualification.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f shooter qualification.
	*
	* @return the user ID of this e s f shooter qualification
	*/
	@Override
	public long getUserId() {
		return _esfShooterQualification.getUserId();
	}

	/**
	* Sets the user ID of this e s f shooter qualification.
	*
	* @param userId the user ID of this e s f shooter qualification
	*/
	@Override
	public void setUserId(long userId) {
		_esfShooterQualification.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f shooter qualification.
	*
	* @return the user uuid of this e s f shooter qualification
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterQualification.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f shooter qualification.
	*
	* @param userUuid the user uuid of this e s f shooter qualification
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfShooterQualification.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f shooter qualification.
	*
	* @return the user name of this e s f shooter qualification
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfShooterQualification.getUserName();
	}

	/**
	* Sets the user name of this e s f shooter qualification.
	*
	* @param userName the user name of this e s f shooter qualification
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfShooterQualification.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f shooter qualification.
	*
	* @return the create date of this e s f shooter qualification
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfShooterQualification.getCreateDate();
	}

	/**
	* Sets the create date of this e s f shooter qualification.
	*
	* @param createDate the create date of this e s f shooter qualification
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfShooterQualification.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f shooter qualification.
	*
	* @return the modified date of this e s f shooter qualification
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfShooterQualification.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f shooter qualification.
	*
	* @param modifiedDate the modified date of this e s f shooter qualification
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfShooterQualification.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the description of this e s f shooter qualification.
	*
	* @return the description of this e s f shooter qualification
	*/
	@Override
	public java.lang.String getDescription() {
		return _esfShooterQualification.getDescription();
	}

	/**
	* Sets the description of this e s f shooter qualification.
	*
	* @param description the description of this e s f shooter qualification
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_esfShooterQualification.setDescription(description);
	}

	/**
	* Returns the code of this e s f shooter qualification.
	*
	* @return the code of this e s f shooter qualification
	*/
	@Override
	public java.lang.String getCode() {
		return _esfShooterQualification.getCode();
	}

	/**
	* Sets the code of this e s f shooter qualification.
	*
	* @param code the code of this e s f shooter qualification
	*/
	@Override
	public void setCode(java.lang.String code) {
		_esfShooterQualification.setCode(code);
	}

	@Override
	public boolean isNew() {
		return _esfShooterQualification.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfShooterQualification.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfShooterQualification.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfShooterQualification.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfShooterQualification.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfShooterQualification.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfShooterQualification.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfShooterQualification.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfShooterQualification.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfShooterQualification.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfShooterQualification.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFShooterQualificationWrapper((ESFShooterQualification)_esfShooterQualification.clone());
	}

	@Override
	public int compareTo(
		it.ethica.esf.model.ESFShooterQualification esfShooterQualification) {
		return _esfShooterQualification.compareTo(esfShooterQualification);
	}

	@Override
	public int hashCode() {
		return _esfShooterQualification.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFShooterQualification> toCacheModel() {
		return _esfShooterQualification.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFShooterQualification toEscapedModel() {
		return new ESFShooterQualificationWrapper(_esfShooterQualification.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFShooterQualification toUnescapedModel() {
		return new ESFShooterQualificationWrapper(_esfShooterQualification.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfShooterQualification.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfShooterQualification.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfShooterQualification.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFShooterQualificationWrapper)) {
			return false;
		}

		ESFShooterQualificationWrapper esfShooterQualificationWrapper = (ESFShooterQualificationWrapper)obj;

		if (Validator.equals(_esfShooterQualification,
					esfShooterQualificationWrapper._esfShooterQualification)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _esfShooterQualification.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFShooterQualification getWrappedESFShooterQualification() {
		return _esfShooterQualification;
	}

	@Override
	public ESFShooterQualification getWrappedModel() {
		return _esfShooterQualification;
	}

	@Override
	public void resetOriginalValues() {
		_esfShooterQualification.resetOriginalValues();
	}

	private ESFShooterQualification _esfShooterQualification;
}