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
 * This class is a wrapper for {@link ESFUserRole}.
 * </p>
 *
 * @author Ethica
 * @see ESFUserRole
 * @generated
 */
public class ESFUserRoleWrapper implements ESFUserRole,
	ModelWrapper<ESFUserRole> {
	public ESFUserRoleWrapper(ESFUserRole esfUserRole) {
		_esfUserRole = esfUserRole;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFUserRole.class;
	}

	@Override
	public String getModelClassName() {
		return ESFUserRole.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfUserRoleId", getEsfUserRoleId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("isBDO", getIsBDO());
		attributes.put("isLEA", getIsLEA());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfUserRoleId = (Long)attributes.get("esfUserRoleId");

		if (esfUserRoleId != null) {
			setEsfUserRoleId(esfUserRoleId);
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

		Boolean isBDO = (Boolean)attributes.get("isBDO");

		if (isBDO != null) {
			setIsBDO(isBDO);
		}

		Boolean isLEA = (Boolean)attributes.get("isLEA");

		if (isLEA != null) {
			setIsLEA(isLEA);
		}
	}

	/**
	* Returns the primary key of this e s f user role.
	*
	* @return the primary key of this e s f user role
	*/
	@Override
	public long getPrimaryKey() {
		return _esfUserRole.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f user role.
	*
	* @param primaryKey the primary key of this e s f user role
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfUserRole.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this e s f user role.
	*
	* @return the uuid of this e s f user role
	*/
	@Override
	public java.lang.String getUuid() {
		return _esfUserRole.getUuid();
	}

	/**
	* Sets the uuid of this e s f user role.
	*
	* @param uuid the uuid of this e s f user role
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_esfUserRole.setUuid(uuid);
	}

	/**
	* Returns the esf user role ID of this e s f user role.
	*
	* @return the esf user role ID of this e s f user role
	*/
	@Override
	public long getEsfUserRoleId() {
		return _esfUserRole.getEsfUserRoleId();
	}

	/**
	* Sets the esf user role ID of this e s f user role.
	*
	* @param esfUserRoleId the esf user role ID of this e s f user role
	*/
	@Override
	public void setEsfUserRoleId(long esfUserRoleId) {
		_esfUserRole.setEsfUserRoleId(esfUserRoleId);
	}

	/**
	* Returns the group ID of this e s f user role.
	*
	* @return the group ID of this e s f user role
	*/
	@Override
	public long getGroupId() {
		return _esfUserRole.getGroupId();
	}

	/**
	* Sets the group ID of this e s f user role.
	*
	* @param groupId the group ID of this e s f user role
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfUserRole.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f user role.
	*
	* @return the company ID of this e s f user role
	*/
	@Override
	public long getCompanyId() {
		return _esfUserRole.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f user role.
	*
	* @param companyId the company ID of this e s f user role
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfUserRole.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f user role.
	*
	* @return the user ID of this e s f user role
	*/
	@Override
	public long getUserId() {
		return _esfUserRole.getUserId();
	}

	/**
	* Sets the user ID of this e s f user role.
	*
	* @param userId the user ID of this e s f user role
	*/
	@Override
	public void setUserId(long userId) {
		_esfUserRole.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f user role.
	*
	* @return the user uuid of this e s f user role
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfUserRole.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f user role.
	*
	* @param userUuid the user uuid of this e s f user role
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfUserRole.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f user role.
	*
	* @return the user name of this e s f user role
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfUserRole.getUserName();
	}

	/**
	* Sets the user name of this e s f user role.
	*
	* @param userName the user name of this e s f user role
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfUserRole.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f user role.
	*
	* @return the create date of this e s f user role
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfUserRole.getCreateDate();
	}

	/**
	* Sets the create date of this e s f user role.
	*
	* @param createDate the create date of this e s f user role
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfUserRole.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f user role.
	*
	* @return the modified date of this e s f user role
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfUserRole.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f user role.
	*
	* @param modifiedDate the modified date of this e s f user role
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfUserRole.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this e s f user role.
	*
	* @return the name of this e s f user role
	*/
	@Override
	public java.lang.String getName() {
		return _esfUserRole.getName();
	}

	/**
	* Sets the name of this e s f user role.
	*
	* @param name the name of this e s f user role
	*/
	@Override
	public void setName(java.lang.String name) {
		_esfUserRole.setName(name);
	}

	/**
	* Returns the description of this e s f user role.
	*
	* @return the description of this e s f user role
	*/
	@Override
	public java.lang.String getDescription() {
		return _esfUserRole.getDescription();
	}

	/**
	* Sets the description of this e s f user role.
	*
	* @param description the description of this e s f user role
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_esfUserRole.setDescription(description);
	}

	/**
	* Returns the is b d o of this e s f user role.
	*
	* @return the is b d o of this e s f user role
	*/
	@Override
	public boolean getIsBDO() {
		return _esfUserRole.getIsBDO();
	}

	/**
	* Returns <code>true</code> if this e s f user role is is b d o.
	*
	* @return <code>true</code> if this e s f user role is is b d o; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsBDO() {
		return _esfUserRole.isIsBDO();
	}

	/**
	* Sets whether this e s f user role is is b d o.
	*
	* @param isBDO the is b d o of this e s f user role
	*/
	@Override
	public void setIsBDO(boolean isBDO) {
		_esfUserRole.setIsBDO(isBDO);
	}

	/**
	* Returns the is l e a of this e s f user role.
	*
	* @return the is l e a of this e s f user role
	*/
	@Override
	public boolean getIsLEA() {
		return _esfUserRole.getIsLEA();
	}

	/**
	* Returns <code>true</code> if this e s f user role is is l e a.
	*
	* @return <code>true</code> if this e s f user role is is l e a; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsLEA() {
		return _esfUserRole.isIsLEA();
	}

	/**
	* Sets whether this e s f user role is is l e a.
	*
	* @param isLEA the is l e a of this e s f user role
	*/
	@Override
	public void setIsLEA(boolean isLEA) {
		_esfUserRole.setIsLEA(isLEA);
	}

	@Override
	public boolean isNew() {
		return _esfUserRole.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfUserRole.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfUserRole.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfUserRole.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfUserRole.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfUserRole.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfUserRole.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfUserRole.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfUserRole.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfUserRole.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfUserRole.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFUserRoleWrapper((ESFUserRole)_esfUserRole.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFUserRole esfUserRole) {
		return _esfUserRole.compareTo(esfUserRole);
	}

	@Override
	public int hashCode() {
		return _esfUserRole.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFUserRole> toCacheModel() {
		return _esfUserRole.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFUserRole toEscapedModel() {
		return new ESFUserRoleWrapper(_esfUserRole.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFUserRole toUnescapedModel() {
		return new ESFUserRoleWrapper(_esfUserRole.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfUserRole.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfUserRole.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfUserRole.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFUserRoleWrapper)) {
			return false;
		}

		ESFUserRoleWrapper esfUserRoleWrapper = (ESFUserRoleWrapper)obj;

		if (Validator.equals(_esfUserRole, esfUserRoleWrapper._esfUserRole)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _esfUserRole.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFUserRole getWrappedESFUserRole() {
		return _esfUserRole;
	}

	@Override
	public ESFUserRole getWrappedModel() {
		return _esfUserRole;
	}

	@Override
	public void resetOriginalValues() {
		_esfUserRole.resetOriginalValues();
	}

	private ESFUserRole _esfUserRole;
}