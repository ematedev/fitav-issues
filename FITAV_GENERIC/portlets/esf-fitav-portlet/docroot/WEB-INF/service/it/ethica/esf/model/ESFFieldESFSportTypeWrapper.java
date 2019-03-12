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
 * This class is a wrapper for {@link ESFFieldESFSportType}.
 * </p>
 *
 * @author Ethica
 * @see ESFFieldESFSportType
 * @generated
 */
public class ESFFieldESFSportTypeWrapper implements ESFFieldESFSportType,
	ModelWrapper<ESFFieldESFSportType> {
	public ESFFieldESFSportTypeWrapper(
		ESFFieldESFSportType esfFieldESFSportType) {
		_esfFieldESFSportType = esfFieldESFSportType;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFFieldESFSportType.class;
	}

	@Override
	public String getModelClassName() {
		return ESFFieldESFSportType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfFieldId", getEsfFieldId());
		attributes.put("esfSportTypeId", getEsfSportTypeId());
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
		Long esfFieldId = (Long)attributes.get("esfFieldId");

		if (esfFieldId != null) {
			setEsfFieldId(esfFieldId);
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
	}

	/**
	* Returns the primary key of this e s f field e s f sport type.
	*
	* @return the primary key of this e s f field e s f sport type
	*/
	@Override
	public it.ethica.esf.service.persistence.ESFFieldESFSportTypePK getPrimaryKey() {
		return _esfFieldESFSportType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f field e s f sport type.
	*
	* @param primaryKey the primary key of this e s f field e s f sport type
	*/
	@Override
	public void setPrimaryKey(
		it.ethica.esf.service.persistence.ESFFieldESFSportTypePK primaryKey) {
		_esfFieldESFSportType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf field ID of this e s f field e s f sport type.
	*
	* @return the esf field ID of this e s f field e s f sport type
	*/
	@Override
	public long getEsfFieldId() {
		return _esfFieldESFSportType.getEsfFieldId();
	}

	/**
	* Sets the esf field ID of this e s f field e s f sport type.
	*
	* @param esfFieldId the esf field ID of this e s f field e s f sport type
	*/
	@Override
	public void setEsfFieldId(long esfFieldId) {
		_esfFieldESFSportType.setEsfFieldId(esfFieldId);
	}

	/**
	* Returns the esf sport type ID of this e s f field e s f sport type.
	*
	* @return the esf sport type ID of this e s f field e s f sport type
	*/
	@Override
	public long getEsfSportTypeId() {
		return _esfFieldESFSportType.getEsfSportTypeId();
	}

	/**
	* Sets the esf sport type ID of this e s f field e s f sport type.
	*
	* @param esfSportTypeId the esf sport type ID of this e s f field e s f sport type
	*/
	@Override
	public void setEsfSportTypeId(long esfSportTypeId) {
		_esfFieldESFSportType.setEsfSportTypeId(esfSportTypeId);
	}

	/**
	* Returns the group ID of this e s f field e s f sport type.
	*
	* @return the group ID of this e s f field e s f sport type
	*/
	@Override
	public long getGroupId() {
		return _esfFieldESFSportType.getGroupId();
	}

	/**
	* Sets the group ID of this e s f field e s f sport type.
	*
	* @param groupId the group ID of this e s f field e s f sport type
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfFieldESFSportType.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f field e s f sport type.
	*
	* @return the company ID of this e s f field e s f sport type
	*/
	@Override
	public long getCompanyId() {
		return _esfFieldESFSportType.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f field e s f sport type.
	*
	* @param companyId the company ID of this e s f field e s f sport type
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfFieldESFSportType.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f field e s f sport type.
	*
	* @return the user ID of this e s f field e s f sport type
	*/
	@Override
	public long getUserId() {
		return _esfFieldESFSportType.getUserId();
	}

	/**
	* Sets the user ID of this e s f field e s f sport type.
	*
	* @param userId the user ID of this e s f field e s f sport type
	*/
	@Override
	public void setUserId(long userId) {
		_esfFieldESFSportType.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f field e s f sport type.
	*
	* @return the user uuid of this e s f field e s f sport type
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFieldESFSportType.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f field e s f sport type.
	*
	* @param userUuid the user uuid of this e s f field e s f sport type
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfFieldESFSportType.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f field e s f sport type.
	*
	* @return the user name of this e s f field e s f sport type
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfFieldESFSportType.getUserName();
	}

	/**
	* Sets the user name of this e s f field e s f sport type.
	*
	* @param userName the user name of this e s f field e s f sport type
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfFieldESFSportType.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f field e s f sport type.
	*
	* @return the create date of this e s f field e s f sport type
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfFieldESFSportType.getCreateDate();
	}

	/**
	* Sets the create date of this e s f field e s f sport type.
	*
	* @param createDate the create date of this e s f field e s f sport type
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfFieldESFSportType.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f field e s f sport type.
	*
	* @return the modified date of this e s f field e s f sport type
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfFieldESFSportType.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f field e s f sport type.
	*
	* @param modifiedDate the modified date of this e s f field e s f sport type
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfFieldESFSportType.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _esfFieldESFSportType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfFieldESFSportType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfFieldESFSportType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfFieldESFSportType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfFieldESFSportType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfFieldESFSportType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfFieldESFSportType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfFieldESFSportType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfFieldESFSportType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfFieldESFSportType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfFieldESFSportType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFFieldESFSportTypeWrapper((ESFFieldESFSportType)_esfFieldESFSportType.clone());
	}

	@Override
	public int compareTo(
		it.ethica.esf.model.ESFFieldESFSportType esfFieldESFSportType) {
		return _esfFieldESFSportType.compareTo(esfFieldESFSportType);
	}

	@Override
	public int hashCode() {
		return _esfFieldESFSportType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFFieldESFSportType> toCacheModel() {
		return _esfFieldESFSportType.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFFieldESFSportType toEscapedModel() {
		return new ESFFieldESFSportTypeWrapper(_esfFieldESFSportType.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFFieldESFSportType toUnescapedModel() {
		return new ESFFieldESFSportTypeWrapper(_esfFieldESFSportType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfFieldESFSportType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfFieldESFSportType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfFieldESFSportType.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFFieldESFSportTypeWrapper)) {
			return false;
		}

		ESFFieldESFSportTypeWrapper esfFieldESFSportTypeWrapper = (ESFFieldESFSportTypeWrapper)obj;

		if (Validator.equals(_esfFieldESFSportType,
					esfFieldESFSportTypeWrapper._esfFieldESFSportType)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFFieldESFSportType getWrappedESFFieldESFSportType() {
		return _esfFieldESFSportType;
	}

	@Override
	public ESFFieldESFSportType getWrappedModel() {
		return _esfFieldESFSportType;
	}

	@Override
	public void resetOriginalValues() {
		_esfFieldESFSportType.resetOriginalValues();
	}

	private ESFFieldESFSportType _esfFieldESFSportType;
}