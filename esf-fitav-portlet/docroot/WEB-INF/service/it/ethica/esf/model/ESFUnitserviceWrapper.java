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
 * This class is a wrapper for {@link ESFUnitservice}.
 * </p>
 *
 * @author Ethica
 * @see ESFUnitservice
 * @generated
 */
public class ESFUnitserviceWrapper implements ESFUnitservice,
	ModelWrapper<ESFUnitservice> {
	public ESFUnitserviceWrapper(ESFUnitservice esfUnitservice) {
		_esfUnitservice = esfUnitservice;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFUnitservice.class;
	}

	@Override
	public String getModelClassName() {
		return ESFUnitservice.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfUnitserviceId", getEsfUnitserviceId());
		attributes.put("description", getDescription());
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

		Long esfUnitserviceId = (Long)attributes.get("esfUnitserviceId");

		if (esfUnitserviceId != null) {
			setEsfUnitserviceId(esfUnitserviceId);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
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
	* Returns the primary key of this e s f unitservice.
	*
	* @return the primary key of this e s f unitservice
	*/
	@Override
	public long getPrimaryKey() {
		return _esfUnitservice.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f unitservice.
	*
	* @param primaryKey the primary key of this e s f unitservice
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfUnitservice.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this e s f unitservice.
	*
	* @return the uuid of this e s f unitservice
	*/
	@Override
	public java.lang.String getUuid() {
		return _esfUnitservice.getUuid();
	}

	/**
	* Sets the uuid of this e s f unitservice.
	*
	* @param uuid the uuid of this e s f unitservice
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_esfUnitservice.setUuid(uuid);
	}

	/**
	* Returns the esf unitservice ID of this e s f unitservice.
	*
	* @return the esf unitservice ID of this e s f unitservice
	*/
	@Override
	public long getEsfUnitserviceId() {
		return _esfUnitservice.getEsfUnitserviceId();
	}

	/**
	* Sets the esf unitservice ID of this e s f unitservice.
	*
	* @param esfUnitserviceId the esf unitservice ID of this e s f unitservice
	*/
	@Override
	public void setEsfUnitserviceId(long esfUnitserviceId) {
		_esfUnitservice.setEsfUnitserviceId(esfUnitserviceId);
	}

	/**
	* Returns the description of this e s f unitservice.
	*
	* @return the description of this e s f unitservice
	*/
	@Override
	public java.lang.String getDescription() {
		return _esfUnitservice.getDescription();
	}

	/**
	* Sets the description of this e s f unitservice.
	*
	* @param description the description of this e s f unitservice
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_esfUnitservice.setDescription(description);
	}

	/**
	* Returns the group ID of this e s f unitservice.
	*
	* @return the group ID of this e s f unitservice
	*/
	@Override
	public long getGroupId() {
		return _esfUnitservice.getGroupId();
	}

	/**
	* Sets the group ID of this e s f unitservice.
	*
	* @param groupId the group ID of this e s f unitservice
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfUnitservice.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f unitservice.
	*
	* @return the company ID of this e s f unitservice
	*/
	@Override
	public long getCompanyId() {
		return _esfUnitservice.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f unitservice.
	*
	* @param companyId the company ID of this e s f unitservice
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfUnitservice.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f unitservice.
	*
	* @return the user ID of this e s f unitservice
	*/
	@Override
	public long getUserId() {
		return _esfUnitservice.getUserId();
	}

	/**
	* Sets the user ID of this e s f unitservice.
	*
	* @param userId the user ID of this e s f unitservice
	*/
	@Override
	public void setUserId(long userId) {
		_esfUnitservice.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f unitservice.
	*
	* @return the user uuid of this e s f unitservice
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfUnitservice.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f unitservice.
	*
	* @param userUuid the user uuid of this e s f unitservice
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfUnitservice.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f unitservice.
	*
	* @return the user name of this e s f unitservice
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfUnitservice.getUserName();
	}

	/**
	* Sets the user name of this e s f unitservice.
	*
	* @param userName the user name of this e s f unitservice
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfUnitservice.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f unitservice.
	*
	* @return the create date of this e s f unitservice
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfUnitservice.getCreateDate();
	}

	/**
	* Sets the create date of this e s f unitservice.
	*
	* @param createDate the create date of this e s f unitservice
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfUnitservice.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f unitservice.
	*
	* @return the modified date of this e s f unitservice
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfUnitservice.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f unitservice.
	*
	* @param modifiedDate the modified date of this e s f unitservice
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfUnitservice.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _esfUnitservice.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfUnitservice.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfUnitservice.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfUnitservice.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfUnitservice.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfUnitservice.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfUnitservice.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfUnitservice.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfUnitservice.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfUnitservice.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfUnitservice.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFUnitserviceWrapper((ESFUnitservice)_esfUnitservice.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFUnitservice esfUnitservice) {
		return _esfUnitservice.compareTo(esfUnitservice);
	}

	@Override
	public int hashCode() {
		return _esfUnitservice.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFUnitservice> toCacheModel() {
		return _esfUnitservice.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFUnitservice toEscapedModel() {
		return new ESFUnitserviceWrapper(_esfUnitservice.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFUnitservice toUnescapedModel() {
		return new ESFUnitserviceWrapper(_esfUnitservice.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfUnitservice.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfUnitservice.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfUnitservice.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFUnitserviceWrapper)) {
			return false;
		}

		ESFUnitserviceWrapper esfUnitserviceWrapper = (ESFUnitserviceWrapper)obj;

		if (Validator.equals(_esfUnitservice,
					esfUnitserviceWrapper._esfUnitservice)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _esfUnitservice.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFUnitservice getWrappedESFUnitservice() {
		return _esfUnitservice;
	}

	@Override
	public ESFUnitservice getWrappedModel() {
		return _esfUnitservice;
	}

	@Override
	public void resetOriginalValues() {
		_esfUnitservice.resetOriginalValues();
	}

	private ESFUnitservice _esfUnitservice;
}