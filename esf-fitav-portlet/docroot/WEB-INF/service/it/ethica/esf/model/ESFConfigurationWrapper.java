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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ESFConfiguration}.
 * </p>
 *
 * @author Ethica
 * @see ESFConfiguration
 * @generated
 */
public class ESFConfigurationWrapper implements ESFConfiguration,
	ModelWrapper<ESFConfiguration> {
	public ESFConfigurationWrapper(ESFConfiguration esfConfiguration) {
		_esfConfiguration = esfConfiguration;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFConfiguration.class;
	}

	@Override
	public String getModelClassName() {
		return ESFConfiguration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfConfigurationId", getEsfConfigurationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("key", getKey());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfConfigurationId = (Long)attributes.get("esfConfigurationId");

		if (esfConfigurationId != null) {
			setEsfConfigurationId(esfConfigurationId);
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

		String key = (String)attributes.get("key");

		if (key != null) {
			setKey(key);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	/**
	* Returns the primary key of this e s f configuration.
	*
	* @return the primary key of this e s f configuration
	*/
	@Override
	public long getPrimaryKey() {
		return _esfConfiguration.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f configuration.
	*
	* @param primaryKey the primary key of this e s f configuration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfConfiguration.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf configuration ID of this e s f configuration.
	*
	* @return the esf configuration ID of this e s f configuration
	*/
	@Override
	public long getEsfConfigurationId() {
		return _esfConfiguration.getEsfConfigurationId();
	}

	/**
	* Sets the esf configuration ID of this e s f configuration.
	*
	* @param esfConfigurationId the esf configuration ID of this e s f configuration
	*/
	@Override
	public void setEsfConfigurationId(long esfConfigurationId) {
		_esfConfiguration.setEsfConfigurationId(esfConfigurationId);
	}

	/**
	* Returns the group ID of this e s f configuration.
	*
	* @return the group ID of this e s f configuration
	*/
	@Override
	public long getGroupId() {
		return _esfConfiguration.getGroupId();
	}

	/**
	* Sets the group ID of this e s f configuration.
	*
	* @param groupId the group ID of this e s f configuration
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfConfiguration.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f configuration.
	*
	* @return the company ID of this e s f configuration
	*/
	@Override
	public long getCompanyId() {
		return _esfConfiguration.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f configuration.
	*
	* @param companyId the company ID of this e s f configuration
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfConfiguration.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f configuration.
	*
	* @return the user ID of this e s f configuration
	*/
	@Override
	public long getUserId() {
		return _esfConfiguration.getUserId();
	}

	/**
	* Sets the user ID of this e s f configuration.
	*
	* @param userId the user ID of this e s f configuration
	*/
	@Override
	public void setUserId(long userId) {
		_esfConfiguration.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f configuration.
	*
	* @return the user uuid of this e s f configuration
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfConfiguration.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f configuration.
	*
	* @param userUuid the user uuid of this e s f configuration
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfConfiguration.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f configuration.
	*
	* @return the user name of this e s f configuration
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfConfiguration.getUserName();
	}

	/**
	* Sets the user name of this e s f configuration.
	*
	* @param userName the user name of this e s f configuration
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfConfiguration.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f configuration.
	*
	* @return the create date of this e s f configuration
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfConfiguration.getCreateDate();
	}

	/**
	* Sets the create date of this e s f configuration.
	*
	* @param createDate the create date of this e s f configuration
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfConfiguration.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f configuration.
	*
	* @return the modified date of this e s f configuration
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfConfiguration.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f configuration.
	*
	* @param modifiedDate the modified date of this e s f configuration
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfConfiguration.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the key of this e s f configuration.
	*
	* @return the key of this e s f configuration
	*/
	@Override
	public java.lang.String getKey() {
		return _esfConfiguration.getKey();
	}

	/**
	* Sets the key of this e s f configuration.
	*
	* @param key the key of this e s f configuration
	*/
	@Override
	public void setKey(java.lang.String key) {
		_esfConfiguration.setKey(key);
	}

	/**
	* Returns the value of this e s f configuration.
	*
	* @return the value of this e s f configuration
	*/
	@Override
	public java.lang.String getValue() {
		return _esfConfiguration.getValue();
	}

	/**
	* Sets the value of this e s f configuration.
	*
	* @param value the value of this e s f configuration
	*/
	@Override
	public void setValue(java.lang.String value) {
		_esfConfiguration.setValue(value);
	}

	@Override
	public boolean isNew() {
		return _esfConfiguration.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfConfiguration.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfConfiguration.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfConfiguration.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfConfiguration.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfConfiguration.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfConfiguration.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfConfiguration.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfConfiguration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfConfiguration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfConfiguration.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFConfigurationWrapper((ESFConfiguration)_esfConfiguration.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFConfiguration esfConfiguration) {
		return _esfConfiguration.compareTo(esfConfiguration);
	}

	@Override
	public int hashCode() {
		return _esfConfiguration.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFConfiguration> toCacheModel() {
		return _esfConfiguration.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFConfiguration toEscapedModel() {
		return new ESFConfigurationWrapper(_esfConfiguration.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFConfiguration toUnescapedModel() {
		return new ESFConfigurationWrapper(_esfConfiguration.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfConfiguration.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfConfiguration.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfConfiguration.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFConfigurationWrapper)) {
			return false;
		}

		ESFConfigurationWrapper esfConfigurationWrapper = (ESFConfigurationWrapper)obj;

		if (Validator.equals(_esfConfiguration,
					esfConfigurationWrapper._esfConfiguration)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFConfiguration getWrappedESFConfiguration() {
		return _esfConfiguration;
	}

	@Override
	public ESFConfiguration getWrappedModel() {
		return _esfConfiguration;
	}

	@Override
	public void resetOriginalValues() {
		_esfConfiguration.resetOriginalValues();
	}

	private ESFConfiguration _esfConfiguration;
}