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
 * This class is a wrapper for {@link ESFFederalRole}.
 * </p>
 *
 * @author Ethica
 * @see ESFFederalRole
 * @generated
 */
public class ESFFederalRoleWrapper implements ESFFederalRole,
	ModelWrapper<ESFFederalRole> {
	public ESFFederalRoleWrapper(ESFFederalRole esfFederalRole) {
		_esfFederalRole = esfFederalRole;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFFederalRole.class;
	}

	@Override
	public String getModelClassName() {
		return ESFFederalRole.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfFederalRoleId", getEsfFederalRoleId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("code", getCode());
		attributes.put("description", getDescription());
		attributes.put("regional", getRegional());
		attributes.put("provincial", getProvincial());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfFederalRoleId = (Long)attributes.get("esfFederalRoleId");

		if (esfFederalRoleId != null) {
			setEsfFederalRoleId(esfFederalRoleId);
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

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Boolean regional = (Boolean)attributes.get("regional");

		if (regional != null) {
			setRegional(regional);
		}

		Boolean provincial = (Boolean)attributes.get("provincial");

		if (provincial != null) {
			setProvincial(provincial);
		}
	}

	/**
	* Returns the primary key of this e s f federal role.
	*
	* @return the primary key of this e s f federal role
	*/
	@Override
	public long getPrimaryKey() {
		return _esfFederalRole.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f federal role.
	*
	* @param primaryKey the primary key of this e s f federal role
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfFederalRole.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this e s f federal role.
	*
	* @return the uuid of this e s f federal role
	*/
	@Override
	public java.lang.String getUuid() {
		return _esfFederalRole.getUuid();
	}

	/**
	* Sets the uuid of this e s f federal role.
	*
	* @param uuid the uuid of this e s f federal role
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_esfFederalRole.setUuid(uuid);
	}

	/**
	* Returns the esf federal role ID of this e s f federal role.
	*
	* @return the esf federal role ID of this e s f federal role
	*/
	@Override
	public long getEsfFederalRoleId() {
		return _esfFederalRole.getEsfFederalRoleId();
	}

	/**
	* Sets the esf federal role ID of this e s f federal role.
	*
	* @param esfFederalRoleId the esf federal role ID of this e s f federal role
	*/
	@Override
	public void setEsfFederalRoleId(long esfFederalRoleId) {
		_esfFederalRole.setEsfFederalRoleId(esfFederalRoleId);
	}

	/**
	* Returns the group ID of this e s f federal role.
	*
	* @return the group ID of this e s f federal role
	*/
	@Override
	public long getGroupId() {
		return _esfFederalRole.getGroupId();
	}

	/**
	* Sets the group ID of this e s f federal role.
	*
	* @param groupId the group ID of this e s f federal role
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfFederalRole.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f federal role.
	*
	* @return the company ID of this e s f federal role
	*/
	@Override
	public long getCompanyId() {
		return _esfFederalRole.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f federal role.
	*
	* @param companyId the company ID of this e s f federal role
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfFederalRole.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f federal role.
	*
	* @return the user ID of this e s f federal role
	*/
	@Override
	public long getUserId() {
		return _esfFederalRole.getUserId();
	}

	/**
	* Sets the user ID of this e s f federal role.
	*
	* @param userId the user ID of this e s f federal role
	*/
	@Override
	public void setUserId(long userId) {
		_esfFederalRole.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f federal role.
	*
	* @return the user uuid of this e s f federal role
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfFederalRole.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f federal role.
	*
	* @param userUuid the user uuid of this e s f federal role
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfFederalRole.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f federal role.
	*
	* @return the user name of this e s f federal role
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfFederalRole.getUserName();
	}

	/**
	* Sets the user name of this e s f federal role.
	*
	* @param userName the user name of this e s f federal role
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfFederalRole.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f federal role.
	*
	* @return the create date of this e s f federal role
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfFederalRole.getCreateDate();
	}

	/**
	* Sets the create date of this e s f federal role.
	*
	* @param createDate the create date of this e s f federal role
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfFederalRole.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f federal role.
	*
	* @return the modified date of this e s f federal role
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfFederalRole.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f federal role.
	*
	* @param modifiedDate the modified date of this e s f federal role
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfFederalRole.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the code of this e s f federal role.
	*
	* @return the code of this e s f federal role
	*/
	@Override
	public java.lang.String getCode() {
		return _esfFederalRole.getCode();
	}

	/**
	* Sets the code of this e s f federal role.
	*
	* @param code the code of this e s f federal role
	*/
	@Override
	public void setCode(java.lang.String code) {
		_esfFederalRole.setCode(code);
	}

	/**
	* Returns the description of this e s f federal role.
	*
	* @return the description of this e s f federal role
	*/
	@Override
	public java.lang.String getDescription() {
		return _esfFederalRole.getDescription();
	}

	/**
	* Sets the description of this e s f federal role.
	*
	* @param description the description of this e s f federal role
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_esfFederalRole.setDescription(description);
	}

	/**
	* Returns the regional of this e s f federal role.
	*
	* @return the regional of this e s f federal role
	*/
	@Override
	public boolean getRegional() {
		return _esfFederalRole.getRegional();
	}

	/**
	* Returns <code>true</code> if this e s f federal role is regional.
	*
	* @return <code>true</code> if this e s f federal role is regional; <code>false</code> otherwise
	*/
	@Override
	public boolean isRegional() {
		return _esfFederalRole.isRegional();
	}

	/**
	* Sets whether this e s f federal role is regional.
	*
	* @param regional the regional of this e s f federal role
	*/
	@Override
	public void setRegional(boolean regional) {
		_esfFederalRole.setRegional(regional);
	}

	/**
	* Returns the provincial of this e s f federal role.
	*
	* @return the provincial of this e s f federal role
	*/
	@Override
	public boolean getProvincial() {
		return _esfFederalRole.getProvincial();
	}

	/**
	* Returns <code>true</code> if this e s f federal role is provincial.
	*
	* @return <code>true</code> if this e s f federal role is provincial; <code>false</code> otherwise
	*/
	@Override
	public boolean isProvincial() {
		return _esfFederalRole.isProvincial();
	}

	/**
	* Sets whether this e s f federal role is provincial.
	*
	* @param provincial the provincial of this e s f federal role
	*/
	@Override
	public void setProvincial(boolean provincial) {
		_esfFederalRole.setProvincial(provincial);
	}

	@Override
	public boolean isNew() {
		return _esfFederalRole.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfFederalRole.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfFederalRole.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfFederalRole.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfFederalRole.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfFederalRole.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfFederalRole.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfFederalRole.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfFederalRole.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfFederalRole.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfFederalRole.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFFederalRoleWrapper((ESFFederalRole)_esfFederalRole.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFFederalRole esfFederalRole) {
		return _esfFederalRole.compareTo(esfFederalRole);
	}

	@Override
	public int hashCode() {
		return _esfFederalRole.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFFederalRole> toCacheModel() {
		return _esfFederalRole.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFFederalRole toEscapedModel() {
		return new ESFFederalRoleWrapper(_esfFederalRole.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFFederalRole toUnescapedModel() {
		return new ESFFederalRoleWrapper(_esfFederalRole.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfFederalRole.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfFederalRole.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfFederalRole.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFFederalRoleWrapper)) {
			return false;
		}

		ESFFederalRoleWrapper esfFederalRoleWrapper = (ESFFederalRoleWrapper)obj;

		if (Validator.equals(_esfFederalRole,
					esfFederalRoleWrapper._esfFederalRole)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _esfFederalRole.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFFederalRole getWrappedESFFederalRole() {
		return _esfFederalRole;
	}

	@Override
	public ESFFederalRole getWrappedModel() {
		return _esfFederalRole;
	}

	@Override
	public void resetOriginalValues() {
		_esfFederalRole.resetOriginalValues();
	}

	private ESFFederalRole _esfFederalRole;
}