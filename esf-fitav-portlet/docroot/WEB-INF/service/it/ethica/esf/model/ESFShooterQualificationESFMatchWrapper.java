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
 * This class is a wrapper for {@link ESFShooterQualificationESFMatch}.
 * </p>
 *
 * @author Ethica
 * @see ESFShooterQualificationESFMatch
 * @generated
 */
public class ESFShooterQualificationESFMatchWrapper
	implements ESFShooterQualificationESFMatch,
		ModelWrapper<ESFShooterQualificationESFMatch> {
	public ESFShooterQualificationESFMatchWrapper(
		ESFShooterQualificationESFMatch esfShooterQualificationESFMatch) {
		_esfShooterQualificationESFMatch = esfShooterQualificationESFMatch;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFShooterQualificationESFMatch.class;
	}

	@Override
	public String getModelClassName() {
		return ESFShooterQualificationESFMatch.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfShooterQualificationId",
			getEsfShooterQualificationId());
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

		Long esfShooterQualificationId = (Long)attributes.get(
				"esfShooterQualificationId");

		if (esfShooterQualificationId != null) {
			setEsfShooterQualificationId(esfShooterQualificationId);
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
	* Returns the primary key of this e s f shooter qualification e s f match.
	*
	* @return the primary key of this e s f shooter qualification e s f match
	*/
	@Override
	public it.ethica.esf.service.persistence.ESFShooterQualificationESFMatchPK getPrimaryKey() {
		return _esfShooterQualificationESFMatch.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f shooter qualification e s f match.
	*
	* @param primaryKey the primary key of this e s f shooter qualification e s f match
	*/
	@Override
	public void setPrimaryKey(
		it.ethica.esf.service.persistence.ESFShooterQualificationESFMatchPK primaryKey) {
		_esfShooterQualificationESFMatch.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this e s f shooter qualification e s f match.
	*
	* @return the uuid of this e s f shooter qualification e s f match
	*/
	@Override
	public java.lang.String getUuid() {
		return _esfShooterQualificationESFMatch.getUuid();
	}

	/**
	* Sets the uuid of this e s f shooter qualification e s f match.
	*
	* @param uuid the uuid of this e s f shooter qualification e s f match
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_esfShooterQualificationESFMatch.setUuid(uuid);
	}

	/**
	* Returns the esf shooter qualification ID of this e s f shooter qualification e s f match.
	*
	* @return the esf shooter qualification ID of this e s f shooter qualification e s f match
	*/
	@Override
	public long getEsfShooterQualificationId() {
		return _esfShooterQualificationESFMatch.getEsfShooterQualificationId();
	}

	/**
	* Sets the esf shooter qualification ID of this e s f shooter qualification e s f match.
	*
	* @param esfShooterQualificationId the esf shooter qualification ID of this e s f shooter qualification e s f match
	*/
	@Override
	public void setEsfShooterQualificationId(long esfShooterQualificationId) {
		_esfShooterQualificationESFMatch.setEsfShooterQualificationId(esfShooterQualificationId);
	}

	/**
	* Returns the esf match ID of this e s f shooter qualification e s f match.
	*
	* @return the esf match ID of this e s f shooter qualification e s f match
	*/
	@Override
	public long getEsfMatchId() {
		return _esfShooterQualificationESFMatch.getEsfMatchId();
	}

	/**
	* Sets the esf match ID of this e s f shooter qualification e s f match.
	*
	* @param esfMatchId the esf match ID of this e s f shooter qualification e s f match
	*/
	@Override
	public void setEsfMatchId(long esfMatchId) {
		_esfShooterQualificationESFMatch.setEsfMatchId(esfMatchId);
	}

	/**
	* Returns the group ID of this e s f shooter qualification e s f match.
	*
	* @return the group ID of this e s f shooter qualification e s f match
	*/
	@Override
	public long getGroupId() {
		return _esfShooterQualificationESFMatch.getGroupId();
	}

	/**
	* Sets the group ID of this e s f shooter qualification e s f match.
	*
	* @param groupId the group ID of this e s f shooter qualification e s f match
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfShooterQualificationESFMatch.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f shooter qualification e s f match.
	*
	* @return the company ID of this e s f shooter qualification e s f match
	*/
	@Override
	public long getCompanyId() {
		return _esfShooterQualificationESFMatch.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f shooter qualification e s f match.
	*
	* @param companyId the company ID of this e s f shooter qualification e s f match
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfShooterQualificationESFMatch.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f shooter qualification e s f match.
	*
	* @return the user ID of this e s f shooter qualification e s f match
	*/
	@Override
	public long getUserId() {
		return _esfShooterQualificationESFMatch.getUserId();
	}

	/**
	* Sets the user ID of this e s f shooter qualification e s f match.
	*
	* @param userId the user ID of this e s f shooter qualification e s f match
	*/
	@Override
	public void setUserId(long userId) {
		_esfShooterQualificationESFMatch.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f shooter qualification e s f match.
	*
	* @return the user uuid of this e s f shooter qualification e s f match
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfShooterQualificationESFMatch.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f shooter qualification e s f match.
	*
	* @param userUuid the user uuid of this e s f shooter qualification e s f match
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfShooterQualificationESFMatch.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f shooter qualification e s f match.
	*
	* @return the user name of this e s f shooter qualification e s f match
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfShooterQualificationESFMatch.getUserName();
	}

	/**
	* Sets the user name of this e s f shooter qualification e s f match.
	*
	* @param userName the user name of this e s f shooter qualification e s f match
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfShooterQualificationESFMatch.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f shooter qualification e s f match.
	*
	* @return the create date of this e s f shooter qualification e s f match
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfShooterQualificationESFMatch.getCreateDate();
	}

	/**
	* Sets the create date of this e s f shooter qualification e s f match.
	*
	* @param createDate the create date of this e s f shooter qualification e s f match
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfShooterQualificationESFMatch.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f shooter qualification e s f match.
	*
	* @return the modified date of this e s f shooter qualification e s f match
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfShooterQualificationESFMatch.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f shooter qualification e s f match.
	*
	* @param modifiedDate the modified date of this e s f shooter qualification e s f match
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfShooterQualificationESFMatch.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _esfShooterQualificationESFMatch.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfShooterQualificationESFMatch.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfShooterQualificationESFMatch.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfShooterQualificationESFMatch.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfShooterQualificationESFMatch.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfShooterQualificationESFMatch.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfShooterQualificationESFMatch.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfShooterQualificationESFMatch.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfShooterQualificationESFMatch.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfShooterQualificationESFMatch.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfShooterQualificationESFMatch.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFShooterQualificationESFMatchWrapper((ESFShooterQualificationESFMatch)_esfShooterQualificationESFMatch.clone());
	}

	@Override
	public int compareTo(
		it.ethica.esf.model.ESFShooterQualificationESFMatch esfShooterQualificationESFMatch) {
		return _esfShooterQualificationESFMatch.compareTo(esfShooterQualificationESFMatch);
	}

	@Override
	public int hashCode() {
		return _esfShooterQualificationESFMatch.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFShooterQualificationESFMatch> toCacheModel() {
		return _esfShooterQualificationESFMatch.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFShooterQualificationESFMatch toEscapedModel() {
		return new ESFShooterQualificationESFMatchWrapper(_esfShooterQualificationESFMatch.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFShooterQualificationESFMatch toUnescapedModel() {
		return new ESFShooterQualificationESFMatchWrapper(_esfShooterQualificationESFMatch.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfShooterQualificationESFMatch.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfShooterQualificationESFMatch.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfShooterQualificationESFMatch.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFShooterQualificationESFMatchWrapper)) {
			return false;
		}

		ESFShooterQualificationESFMatchWrapper esfShooterQualificationESFMatchWrapper =
			(ESFShooterQualificationESFMatchWrapper)obj;

		if (Validator.equals(_esfShooterQualificationESFMatch,
					esfShooterQualificationESFMatchWrapper._esfShooterQualificationESFMatch)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _esfShooterQualificationESFMatch.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFShooterQualificationESFMatch getWrappedESFShooterQualificationESFMatch() {
		return _esfShooterQualificationESFMatch;
	}

	@Override
	public ESFShooterQualificationESFMatch getWrappedModel() {
		return _esfShooterQualificationESFMatch;
	}

	@Override
	public void resetOriginalValues() {
		_esfShooterQualificationESFMatch.resetOriginalValues();
	}

	private ESFShooterQualificationESFMatch _esfShooterQualificationESFMatch;
}