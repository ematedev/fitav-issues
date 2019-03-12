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
 * This class is a wrapper for {@link ESFShooterCategoryESFMatch}.
 * </p>
 *
 * @author Ethica
 * @see ESFShooterCategoryESFMatch
 * @generated
 */
public class ESFShooterCategoryESFMatchWrapper
	implements ESFShooterCategoryESFMatch,
		ModelWrapper<ESFShooterCategoryESFMatch> {
	public ESFShooterCategoryESFMatchWrapper(
		ESFShooterCategoryESFMatch esfShooterCategoryESFMatch) {
		_esfShooterCategoryESFMatch = esfShooterCategoryESFMatch;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFShooterCategoryESFMatch.class;
	}

	@Override
	public String getModelClassName() {
		return ESFShooterCategoryESFMatch.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfShooterCategoryId", getEsfShooterCategoryId());
		attributes.put("esfMatchId", getEsfMatchId());
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

		Long esfShooterCategoryId = (Long)attributes.get("esfShooterCategoryId");

		if (esfShooterCategoryId != null) {
			setEsfShooterCategoryId(esfShooterCategoryId);
		}

		Long esfMatchId = (Long)attributes.get("esfMatchId");

		if (esfMatchId != null) {
			setEsfMatchId(esfMatchId);
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
	* Returns the primary key of this e s f shooter category e s f match.
	*
	* @return the primary key of this e s f shooter category e s f match
	*/
	@Override
	public it.ethica.esf.service.persistence.ESFShooterCategoryESFMatchPK getPrimaryKey() {
		return _esfShooterCategoryESFMatch.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f shooter category e s f match.
	*
	* @param primaryKey the primary key of this e s f shooter category e s f match
	*/
	@Override
	public void setPrimaryKey(
		it.ethica.esf.service.persistence.ESFShooterCategoryESFMatchPK primaryKey) {
		_esfShooterCategoryESFMatch.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this e s f shooter category e s f match.
	*
	* @return the uuid of this e s f shooter category e s f match
	*/
	@Override
	public java.lang.String getUuid() {
		return _esfShooterCategoryESFMatch.getUuid();
	}

	/**
	* Sets the uuid of this e s f shooter category e s f match.
	*
	* @param uuid the uuid of this e s f shooter category e s f match
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_esfShooterCategoryESFMatch.setUuid(uuid);
	}

	/**
	* Returns the esf shooter category ID of this e s f shooter category e s f match.
	*
	* @return the esf shooter category ID of this e s f shooter category e s f match
	*/
	@Override
	public long getEsfShooterCategoryId() {
		return _esfShooterCategoryESFMatch.getEsfShooterCategoryId();
	}

	/**
	* Sets the esf shooter category ID of this e s f shooter category e s f match.
	*
	* @param esfShooterCategoryId the esf shooter category ID of this e s f shooter category e s f match
	*/
	@Override
	public void setEsfShooterCategoryId(long esfShooterCategoryId) {
		_esfShooterCategoryESFMatch.setEsfShooterCategoryId(esfShooterCategoryId);
	}

	/**
	* Returns the esf match ID of this e s f shooter category e s f match.
	*
	* @return the esf match ID of this e s f shooter category e s f match
	*/
	@Override
	public long getEsfMatchId() {
		return _esfShooterCategoryESFMatch.getEsfMatchId();
	}

	/**
	* Sets the esf match ID of this e s f shooter category e s f match.
	*
	* @param esfMatchId the esf match ID of this e s f shooter category e s f match
	*/
	@Override
	public void setEsfMatchId(long esfMatchId) {
		_esfShooterCategoryESFMatch.setEsfMatchId(esfMatchId);
	}

	/**
	* Returns the group ID of this e s f shooter category e s f match.
	*
	* @return the group ID of this e s f shooter category e s f match
	*/
	@Override
	public long getGroupId() {
		return _esfShooterCategoryESFMatch.getGroupId();
	}

	/**
	* Sets the group ID of this e s f shooter category e s f match.
	*
	* @param groupId the group ID of this e s f shooter category e s f match
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfShooterCategoryESFMatch.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f shooter category e s f match.
	*
	* @return the company ID of this e s f shooter category e s f match
	*/
	@Override
	public long getCompanyId() {
		return _esfShooterCategoryESFMatch.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f shooter category e s f match.
	*
	* @param companyId the company ID of this e s f shooter category e s f match
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfShooterCategoryESFMatch.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f shooter category e s f match.
	*
	* @return the user ID of this e s f shooter category e s f match
	*/
	@Override
	public long getUserId() {
		return _esfShooterCategoryESFMatch.getUserId();
	}

	/**
	* Sets the user ID of this e s f shooter category e s f match.
	*
	* @param userId the user ID of this e s f shooter category e s f match
	*/
	@Override
	public void setUserId(long userId) {
		_esfShooterCategoryESFMatch.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f shooter category e s f match.
	*
	* @return the user uuid of this e s f shooter category e s f match
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterCategoryESFMatch.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f shooter category e s f match.
	*
	* @param userUuid the user uuid of this e s f shooter category e s f match
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfShooterCategoryESFMatch.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f shooter category e s f match.
	*
	* @return the user name of this e s f shooter category e s f match
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfShooterCategoryESFMatch.getUserName();
	}

	/**
	* Sets the user name of this e s f shooter category e s f match.
	*
	* @param userName the user name of this e s f shooter category e s f match
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfShooterCategoryESFMatch.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f shooter category e s f match.
	*
	* @return the create date of this e s f shooter category e s f match
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfShooterCategoryESFMatch.getCreateDate();
	}

	/**
	* Sets the create date of this e s f shooter category e s f match.
	*
	* @param createDate the create date of this e s f shooter category e s f match
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfShooterCategoryESFMatch.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f shooter category e s f match.
	*
	* @return the modified date of this e s f shooter category e s f match
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfShooterCategoryESFMatch.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f shooter category e s f match.
	*
	* @param modifiedDate the modified date of this e s f shooter category e s f match
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfShooterCategoryESFMatch.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _esfShooterCategoryESFMatch.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfShooterCategoryESFMatch.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfShooterCategoryESFMatch.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfShooterCategoryESFMatch.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfShooterCategoryESFMatch.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfShooterCategoryESFMatch.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfShooterCategoryESFMatch.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfShooterCategoryESFMatch.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfShooterCategoryESFMatch.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfShooterCategoryESFMatch.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfShooterCategoryESFMatch.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFShooterCategoryESFMatchWrapper((ESFShooterCategoryESFMatch)_esfShooterCategoryESFMatch.clone());
	}

	@Override
	public int compareTo(
		it.ethica.esf.model.ESFShooterCategoryESFMatch esfShooterCategoryESFMatch) {
		return _esfShooterCategoryESFMatch.compareTo(esfShooterCategoryESFMatch);
	}

	@Override
	public int hashCode() {
		return _esfShooterCategoryESFMatch.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFShooterCategoryESFMatch> toCacheModel() {
		return _esfShooterCategoryESFMatch.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFShooterCategoryESFMatch toEscapedModel() {
		return new ESFShooterCategoryESFMatchWrapper(_esfShooterCategoryESFMatch.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFShooterCategoryESFMatch toUnescapedModel() {
		return new ESFShooterCategoryESFMatchWrapper(_esfShooterCategoryESFMatch.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfShooterCategoryESFMatch.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfShooterCategoryESFMatch.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfShooterCategoryESFMatch.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFShooterCategoryESFMatchWrapper)) {
			return false;
		}

		ESFShooterCategoryESFMatchWrapper esfShooterCategoryESFMatchWrapper = (ESFShooterCategoryESFMatchWrapper)obj;

		if (Validator.equals(_esfShooterCategoryESFMatch,
					esfShooterCategoryESFMatchWrapper._esfShooterCategoryESFMatch)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _esfShooterCategoryESFMatch.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFShooterCategoryESFMatch getWrappedESFShooterCategoryESFMatch() {
		return _esfShooterCategoryESFMatch;
	}

	@Override
	public ESFShooterCategoryESFMatch getWrappedModel() {
		return _esfShooterCategoryESFMatch;
	}

	@Override
	public void resetOriginalValues() {
		_esfShooterCategoryESFMatch.resetOriginalValues();
	}

	private ESFShooterCategoryESFMatch _esfShooterCategoryESFMatch;
}