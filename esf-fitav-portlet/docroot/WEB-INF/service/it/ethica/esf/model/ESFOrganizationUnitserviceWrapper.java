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
 * This class is a wrapper for {@link ESFOrganizationUnitservice}.
 * </p>
 *
 * @author Ethica
 * @see ESFOrganizationUnitservice
 * @generated
 */
public class ESFOrganizationUnitserviceWrapper
	implements ESFOrganizationUnitservice,
		ModelWrapper<ESFOrganizationUnitservice> {
	public ESFOrganizationUnitserviceWrapper(
		ESFOrganizationUnitservice esfOrganizationUnitservice) {
		_esfOrganizationUnitservice = esfOrganizationUnitservice;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFOrganizationUnitservice.class;
	}

	@Override
	public String getModelClassName() {
		return ESFOrganizationUnitservice.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfOrganizationUnitserviceId",
			getEsfOrganizationUnitserviceId());
		attributes.put("esfOrganizationId", getEsfOrganizationId());
		attributes.put("esfUnitserviceId", getEsfUnitserviceId());
		attributes.put("numberUnitservices", getNumberUnitservices());
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

		Long esfOrganizationUnitserviceId = (Long)attributes.get(
				"esfOrganizationUnitserviceId");

		if (esfOrganizationUnitserviceId != null) {
			setEsfOrganizationUnitserviceId(esfOrganizationUnitserviceId);
		}

		Long esfOrganizationId = (Long)attributes.get("esfOrganizationId");

		if (esfOrganizationId != null) {
			setEsfOrganizationId(esfOrganizationId);
		}

		Long esfUnitserviceId = (Long)attributes.get("esfUnitserviceId");

		if (esfUnitserviceId != null) {
			setEsfUnitserviceId(esfUnitserviceId);
		}

		Long numberUnitservices = (Long)attributes.get("numberUnitservices");

		if (numberUnitservices != null) {
			setNumberUnitservices(numberUnitservices);
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
	* Returns the primary key of this e s f organization unitservice.
	*
	* @return the primary key of this e s f organization unitservice
	*/
	@Override
	public long getPrimaryKey() {
		return _esfOrganizationUnitservice.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f organization unitservice.
	*
	* @param primaryKey the primary key of this e s f organization unitservice
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfOrganizationUnitservice.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this e s f organization unitservice.
	*
	* @return the uuid of this e s f organization unitservice
	*/
	@Override
	public java.lang.String getUuid() {
		return _esfOrganizationUnitservice.getUuid();
	}

	/**
	* Sets the uuid of this e s f organization unitservice.
	*
	* @param uuid the uuid of this e s f organization unitservice
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_esfOrganizationUnitservice.setUuid(uuid);
	}

	/**
	* Returns the esf organization unitservice ID of this e s f organization unitservice.
	*
	* @return the esf organization unitservice ID of this e s f organization unitservice
	*/
	@Override
	public long getEsfOrganizationUnitserviceId() {
		return _esfOrganizationUnitservice.getEsfOrganizationUnitserviceId();
	}

	/**
	* Sets the esf organization unitservice ID of this e s f organization unitservice.
	*
	* @param esfOrganizationUnitserviceId the esf organization unitservice ID of this e s f organization unitservice
	*/
	@Override
	public void setEsfOrganizationUnitserviceId(
		long esfOrganizationUnitserviceId) {
		_esfOrganizationUnitservice.setEsfOrganizationUnitserviceId(esfOrganizationUnitserviceId);
	}

	/**
	* Returns the esf organization ID of this e s f organization unitservice.
	*
	* @return the esf organization ID of this e s f organization unitservice
	*/
	@Override
	public long getEsfOrganizationId() {
		return _esfOrganizationUnitservice.getEsfOrganizationId();
	}

	/**
	* Sets the esf organization ID of this e s f organization unitservice.
	*
	* @param esfOrganizationId the esf organization ID of this e s f organization unitservice
	*/
	@Override
	public void setEsfOrganizationId(long esfOrganizationId) {
		_esfOrganizationUnitservice.setEsfOrganizationId(esfOrganizationId);
	}

	/**
	* Returns the esf unitservice ID of this e s f organization unitservice.
	*
	* @return the esf unitservice ID of this e s f organization unitservice
	*/
	@Override
	public long getEsfUnitserviceId() {
		return _esfOrganizationUnitservice.getEsfUnitserviceId();
	}

	/**
	* Sets the esf unitservice ID of this e s f organization unitservice.
	*
	* @param esfUnitserviceId the esf unitservice ID of this e s f organization unitservice
	*/
	@Override
	public void setEsfUnitserviceId(long esfUnitserviceId) {
		_esfOrganizationUnitservice.setEsfUnitserviceId(esfUnitserviceId);
	}

	/**
	* Returns the number unitservices of this e s f organization unitservice.
	*
	* @return the number unitservices of this e s f organization unitservice
	*/
	@Override
	public long getNumberUnitservices() {
		return _esfOrganizationUnitservice.getNumberUnitservices();
	}

	/**
	* Sets the number unitservices of this e s f organization unitservice.
	*
	* @param numberUnitservices the number unitservices of this e s f organization unitservice
	*/
	@Override
	public void setNumberUnitservices(long numberUnitservices) {
		_esfOrganizationUnitservice.setNumberUnitservices(numberUnitservices);
	}

	/**
	* Returns the description of this e s f organization unitservice.
	*
	* @return the description of this e s f organization unitservice
	*/
	@Override
	public java.lang.String getDescription() {
		return _esfOrganizationUnitservice.getDescription();
	}

	/**
	* Sets the description of this e s f organization unitservice.
	*
	* @param description the description of this e s f organization unitservice
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_esfOrganizationUnitservice.setDescription(description);
	}

	/**
	* Returns the group ID of this e s f organization unitservice.
	*
	* @return the group ID of this e s f organization unitservice
	*/
	@Override
	public long getGroupId() {
		return _esfOrganizationUnitservice.getGroupId();
	}

	/**
	* Sets the group ID of this e s f organization unitservice.
	*
	* @param groupId the group ID of this e s f organization unitservice
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfOrganizationUnitservice.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f organization unitservice.
	*
	* @return the company ID of this e s f organization unitservice
	*/
	@Override
	public long getCompanyId() {
		return _esfOrganizationUnitservice.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f organization unitservice.
	*
	* @param companyId the company ID of this e s f organization unitservice
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfOrganizationUnitservice.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f organization unitservice.
	*
	* @return the user ID of this e s f organization unitservice
	*/
	@Override
	public long getUserId() {
		return _esfOrganizationUnitservice.getUserId();
	}

	/**
	* Sets the user ID of this e s f organization unitservice.
	*
	* @param userId the user ID of this e s f organization unitservice
	*/
	@Override
	public void setUserId(long userId) {
		_esfOrganizationUnitservice.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f organization unitservice.
	*
	* @return the user uuid of this e s f organization unitservice
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationUnitservice.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f organization unitservice.
	*
	* @param userUuid the user uuid of this e s f organization unitservice
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfOrganizationUnitservice.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f organization unitservice.
	*
	* @return the user name of this e s f organization unitservice
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfOrganizationUnitservice.getUserName();
	}

	/**
	* Sets the user name of this e s f organization unitservice.
	*
	* @param userName the user name of this e s f organization unitservice
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfOrganizationUnitservice.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f organization unitservice.
	*
	* @return the create date of this e s f organization unitservice
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfOrganizationUnitservice.getCreateDate();
	}

	/**
	* Sets the create date of this e s f organization unitservice.
	*
	* @param createDate the create date of this e s f organization unitservice
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfOrganizationUnitservice.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f organization unitservice.
	*
	* @return the modified date of this e s f organization unitservice
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfOrganizationUnitservice.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f organization unitservice.
	*
	* @param modifiedDate the modified date of this e s f organization unitservice
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfOrganizationUnitservice.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _esfOrganizationUnitservice.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfOrganizationUnitservice.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfOrganizationUnitservice.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfOrganizationUnitservice.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfOrganizationUnitservice.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfOrganizationUnitservice.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfOrganizationUnitservice.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfOrganizationUnitservice.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfOrganizationUnitservice.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfOrganizationUnitservice.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfOrganizationUnitservice.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFOrganizationUnitserviceWrapper((ESFOrganizationUnitservice)_esfOrganizationUnitservice.clone());
	}

	@Override
	public int compareTo(
		it.ethica.esf.model.ESFOrganizationUnitservice esfOrganizationUnitservice) {
		return _esfOrganizationUnitservice.compareTo(esfOrganizationUnitservice);
	}

	@Override
	public int hashCode() {
		return _esfOrganizationUnitservice.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFOrganizationUnitservice> toCacheModel() {
		return _esfOrganizationUnitservice.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFOrganizationUnitservice toEscapedModel() {
		return new ESFOrganizationUnitserviceWrapper(_esfOrganizationUnitservice.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFOrganizationUnitservice toUnescapedModel() {
		return new ESFOrganizationUnitserviceWrapper(_esfOrganizationUnitservice.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfOrganizationUnitservice.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfOrganizationUnitservice.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfOrganizationUnitservice.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFOrganizationUnitserviceWrapper)) {
			return false;
		}

		ESFOrganizationUnitserviceWrapper esfOrganizationUnitserviceWrapper = (ESFOrganizationUnitserviceWrapper)obj;

		if (Validator.equals(_esfOrganizationUnitservice,
					esfOrganizationUnitserviceWrapper._esfOrganizationUnitservice)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _esfOrganizationUnitservice.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFOrganizationUnitservice getWrappedESFOrganizationUnitservice() {
		return _esfOrganizationUnitservice;
	}

	@Override
	public ESFOrganizationUnitservice getWrappedModel() {
		return _esfOrganizationUnitservice;
	}

	@Override
	public void resetOriginalValues() {
		_esfOrganizationUnitservice.resetOriginalValues();
	}

	private ESFOrganizationUnitservice _esfOrganizationUnitservice;
}