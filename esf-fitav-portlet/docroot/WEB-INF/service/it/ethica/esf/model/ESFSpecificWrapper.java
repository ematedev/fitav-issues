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
 * This class is a wrapper for {@link ESFSpecific}.
 * </p>
 *
 * @author Ethica
 * @see ESFSpecific
 * @generated
 */
public class ESFSpecificWrapper implements ESFSpecific,
	ModelWrapper<ESFSpecific> {
	public ESFSpecificWrapper(ESFSpecific esfSpecific) {
		_esfSpecific = esfSpecific;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFSpecific.class;
	}

	@Override
	public String getModelClassName() {
		return ESFSpecific.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfSpecificId", getEsfSpecificId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("code", getCode());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfSpecificId = (Long)attributes.get("esfSpecificId");

		if (esfSpecificId != null) {
			setEsfSpecificId(esfSpecificId);
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
	}

	/**
	* Returns the primary key of this e s f specific.
	*
	* @return the primary key of this e s f specific
	*/
	@Override
	public long getPrimaryKey() {
		return _esfSpecific.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f specific.
	*
	* @param primaryKey the primary key of this e s f specific
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfSpecific.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this e s f specific.
	*
	* @return the uuid of this e s f specific
	*/
	@Override
	public java.lang.String getUuid() {
		return _esfSpecific.getUuid();
	}

	/**
	* Sets the uuid of this e s f specific.
	*
	* @param uuid the uuid of this e s f specific
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_esfSpecific.setUuid(uuid);
	}

	/**
	* Returns the esf specific ID of this e s f specific.
	*
	* @return the esf specific ID of this e s f specific
	*/
	@Override
	public long getEsfSpecificId() {
		return _esfSpecific.getEsfSpecificId();
	}

	/**
	* Sets the esf specific ID of this e s f specific.
	*
	* @param esfSpecificId the esf specific ID of this e s f specific
	*/
	@Override
	public void setEsfSpecificId(long esfSpecificId) {
		_esfSpecific.setEsfSpecificId(esfSpecificId);
	}

	/**
	* Returns the group ID of this e s f specific.
	*
	* @return the group ID of this e s f specific
	*/
	@Override
	public long getGroupId() {
		return _esfSpecific.getGroupId();
	}

	/**
	* Sets the group ID of this e s f specific.
	*
	* @param groupId the group ID of this e s f specific
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfSpecific.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f specific.
	*
	* @return the company ID of this e s f specific
	*/
	@Override
	public long getCompanyId() {
		return _esfSpecific.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f specific.
	*
	* @param companyId the company ID of this e s f specific
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfSpecific.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f specific.
	*
	* @return the user ID of this e s f specific
	*/
	@Override
	public long getUserId() {
		return _esfSpecific.getUserId();
	}

	/**
	* Sets the user ID of this e s f specific.
	*
	* @param userId the user ID of this e s f specific
	*/
	@Override
	public void setUserId(long userId) {
		_esfSpecific.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f specific.
	*
	* @return the user uuid of this e s f specific
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfSpecific.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f specific.
	*
	* @param userUuid the user uuid of this e s f specific
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfSpecific.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f specific.
	*
	* @return the user name of this e s f specific
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfSpecific.getUserName();
	}

	/**
	* Sets the user name of this e s f specific.
	*
	* @param userName the user name of this e s f specific
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfSpecific.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f specific.
	*
	* @return the create date of this e s f specific
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfSpecific.getCreateDate();
	}

	/**
	* Sets the create date of this e s f specific.
	*
	* @param createDate the create date of this e s f specific
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfSpecific.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f specific.
	*
	* @return the modified date of this e s f specific
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfSpecific.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f specific.
	*
	* @param modifiedDate the modified date of this e s f specific
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfSpecific.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the code of this e s f specific.
	*
	* @return the code of this e s f specific
	*/
	@Override
	public java.lang.String getCode() {
		return _esfSpecific.getCode();
	}

	/**
	* Sets the code of this e s f specific.
	*
	* @param code the code of this e s f specific
	*/
	@Override
	public void setCode(java.lang.String code) {
		_esfSpecific.setCode(code);
	}

	/**
	* Returns the description of this e s f specific.
	*
	* @return the description of this e s f specific
	*/
	@Override
	public java.lang.String getDescription() {
		return _esfSpecific.getDescription();
	}

	/**
	* Sets the description of this e s f specific.
	*
	* @param description the description of this e s f specific
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_esfSpecific.setDescription(description);
	}

	@Override
	public boolean isNew() {
		return _esfSpecific.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfSpecific.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfSpecific.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfSpecific.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfSpecific.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfSpecific.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfSpecific.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfSpecific.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfSpecific.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfSpecific.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfSpecific.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFSpecificWrapper((ESFSpecific)_esfSpecific.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFSpecific esfSpecific) {
		return _esfSpecific.compareTo(esfSpecific);
	}

	@Override
	public int hashCode() {
		return _esfSpecific.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFSpecific> toCacheModel() {
		return _esfSpecific.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFSpecific toEscapedModel() {
		return new ESFSpecificWrapper(_esfSpecific.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFSpecific toUnescapedModel() {
		return new ESFSpecificWrapper(_esfSpecific.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfSpecific.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfSpecific.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfSpecific.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFSpecificWrapper)) {
			return false;
		}

		ESFSpecificWrapper esfSpecificWrapper = (ESFSpecificWrapper)obj;

		if (Validator.equals(_esfSpecific, esfSpecificWrapper._esfSpecific)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _esfSpecific.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFSpecific getWrappedESFSpecific() {
		return _esfSpecific;
	}

	@Override
	public ESFSpecific getWrappedModel() {
		return _esfSpecific;
	}

	@Override
	public void resetOriginalValues() {
		_esfSpecific.resetOriginalValues();
	}

	private ESFSpecific _esfSpecific;
}