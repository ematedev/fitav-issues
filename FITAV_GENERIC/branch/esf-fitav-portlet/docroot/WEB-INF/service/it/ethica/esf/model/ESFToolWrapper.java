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
 * This class is a wrapper for {@link ESFTool}.
 * </p>
 *
 * @author Ethica
 * @see ESFTool
 * @generated
 */
public class ESFToolWrapper implements ESFTool, ModelWrapper<ESFTool> {
	public ESFToolWrapper(ESFTool esfTool) {
		_esfTool = esfTool;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFTool.class;
	}

	@Override
	public String getModelClassName() {
		return ESFTool.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfToolId", getEsfToolId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("code", getCode());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("type", getType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfToolId = (Long)attributes.get("esfToolId");

		if (esfToolId != null) {
			setEsfToolId(esfToolId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}
	}

	/**
	* Returns the primary key of this e s f tool.
	*
	* @return the primary key of this e s f tool
	*/
	@Override
	public long getPrimaryKey() {
		return _esfTool.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f tool.
	*
	* @param primaryKey the primary key of this e s f tool
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfTool.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this e s f tool.
	*
	* @return the uuid of this e s f tool
	*/
	@Override
	public java.lang.String getUuid() {
		return _esfTool.getUuid();
	}

	/**
	* Sets the uuid of this e s f tool.
	*
	* @param uuid the uuid of this e s f tool
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_esfTool.setUuid(uuid);
	}

	/**
	* Returns the esf tool ID of this e s f tool.
	*
	* @return the esf tool ID of this e s f tool
	*/
	@Override
	public long getEsfToolId() {
		return _esfTool.getEsfToolId();
	}

	/**
	* Sets the esf tool ID of this e s f tool.
	*
	* @param esfToolId the esf tool ID of this e s f tool
	*/
	@Override
	public void setEsfToolId(long esfToolId) {
		_esfTool.setEsfToolId(esfToolId);
	}

	/**
	* Returns the group ID of this e s f tool.
	*
	* @return the group ID of this e s f tool
	*/
	@Override
	public long getGroupId() {
		return _esfTool.getGroupId();
	}

	/**
	* Sets the group ID of this e s f tool.
	*
	* @param groupId the group ID of this e s f tool
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfTool.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f tool.
	*
	* @return the company ID of this e s f tool
	*/
	@Override
	public long getCompanyId() {
		return _esfTool.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f tool.
	*
	* @param companyId the company ID of this e s f tool
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfTool.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f tool.
	*
	* @return the user ID of this e s f tool
	*/
	@Override
	public long getUserId() {
		return _esfTool.getUserId();
	}

	/**
	* Sets the user ID of this e s f tool.
	*
	* @param userId the user ID of this e s f tool
	*/
	@Override
	public void setUserId(long userId) {
		_esfTool.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f tool.
	*
	* @return the user uuid of this e s f tool
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfTool.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f tool.
	*
	* @param userUuid the user uuid of this e s f tool
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfTool.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f tool.
	*
	* @return the user name of this e s f tool
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfTool.getUserName();
	}

	/**
	* Sets the user name of this e s f tool.
	*
	* @param userName the user name of this e s f tool
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfTool.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f tool.
	*
	* @return the create date of this e s f tool
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfTool.getCreateDate();
	}

	/**
	* Sets the create date of this e s f tool.
	*
	* @param createDate the create date of this e s f tool
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfTool.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f tool.
	*
	* @return the modified date of this e s f tool
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfTool.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f tool.
	*
	* @param modifiedDate the modified date of this e s f tool
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfTool.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the code of this e s f tool.
	*
	* @return the code of this e s f tool
	*/
	@Override
	public java.lang.String getCode() {
		return _esfTool.getCode();
	}

	/**
	* Sets the code of this e s f tool.
	*
	* @param code the code of this e s f tool
	*/
	@Override
	public void setCode(java.lang.String code) {
		_esfTool.setCode(code);
	}

	/**
	* Returns the name of this e s f tool.
	*
	* @return the name of this e s f tool
	*/
	@Override
	public java.lang.String getName() {
		return _esfTool.getName();
	}

	/**
	* Sets the name of this e s f tool.
	*
	* @param name the name of this e s f tool
	*/
	@Override
	public void setName(java.lang.String name) {
		_esfTool.setName(name);
	}

	/**
	* Returns the description of this e s f tool.
	*
	* @return the description of this e s f tool
	*/
	@Override
	public java.lang.String getDescription() {
		return _esfTool.getDescription();
	}

	/**
	* Sets the description of this e s f tool.
	*
	* @param description the description of this e s f tool
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_esfTool.setDescription(description);
	}

	/**
	* Returns the type of this e s f tool.
	*
	* @return the type of this e s f tool
	*/
	@Override
	public java.lang.String getType() {
		return _esfTool.getType();
	}

	/**
	* Sets the type of this e s f tool.
	*
	* @param type the type of this e s f tool
	*/
	@Override
	public void setType(java.lang.String type) {
		_esfTool.setType(type);
	}

	@Override
	public boolean isNew() {
		return _esfTool.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfTool.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfTool.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfTool.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfTool.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfTool.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfTool.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfTool.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfTool.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfTool.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfTool.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFToolWrapper((ESFTool)_esfTool.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFTool esfTool) {
		return _esfTool.compareTo(esfTool);
	}

	@Override
	public int hashCode() {
		return _esfTool.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFTool> toCacheModel() {
		return _esfTool.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFTool toEscapedModel() {
		return new ESFToolWrapper(_esfTool.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFTool toUnescapedModel() {
		return new ESFToolWrapper(_esfTool.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfTool.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfTool.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfTool.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFToolWrapper)) {
			return false;
		}

		ESFToolWrapper esfToolWrapper = (ESFToolWrapper)obj;

		if (Validator.equals(_esfTool, esfToolWrapper._esfTool)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _esfTool.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFTool getWrappedESFTool() {
		return _esfTool;
	}

	@Override
	public ESFTool getWrappedModel() {
		return _esfTool;
	}

	@Override
	public void resetOriginalValues() {
		_esfTool.resetOriginalValues();
	}

	private ESFTool _esfTool;
}