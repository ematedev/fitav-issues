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
 * This class is a wrapper for {@link ESFOrganization}.
 * </p>
 *
 * @author Ethica
 * @see ESFOrganization
 * @generated
 */
public class ESFOrganizationWrapper implements ESFOrganization,
	ModelWrapper<ESFOrganization> {
	public ESFOrganizationWrapper(ESFOrganization esfOrganization) {
		_esfOrganization = esfOrganization;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFOrganization.class;
	}

	@Override
	public String getModelClassName() {
		return ESFOrganization.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfOrganizationId", getEsfOrganizationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("portalOrganizationId", getPortalOrganizationId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfOrganizationId = (Long)attributes.get("esfOrganizationId");

		if (esfOrganizationId != null) {
			setEsfOrganizationId(esfOrganizationId);
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

		Long portalOrganizationId = (Long)attributes.get("portalOrganizationId");

		if (portalOrganizationId != null) {
			setPortalOrganizationId(portalOrganizationId);
		}
	}

	/**
	* Returns the primary key of this e s f organization.
	*
	* @return the primary key of this e s f organization
	*/
	@Override
	public long getPrimaryKey() {
		return _esfOrganization.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f organization.
	*
	* @param primaryKey the primary key of this e s f organization
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfOrganization.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this e s f organization.
	*
	* @return the uuid of this e s f organization
	*/
	@Override
	public java.lang.String getUuid() {
		return _esfOrganization.getUuid();
	}

	/**
	* Sets the uuid of this e s f organization.
	*
	* @param uuid the uuid of this e s f organization
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_esfOrganization.setUuid(uuid);
	}

	/**
	* Returns the esf organization ID of this e s f organization.
	*
	* @return the esf organization ID of this e s f organization
	*/
	@Override
	public long getEsfOrganizationId() {
		return _esfOrganization.getEsfOrganizationId();
	}

	/**
	* Sets the esf organization ID of this e s f organization.
	*
	* @param esfOrganizationId the esf organization ID of this e s f organization
	*/
	@Override
	public void setEsfOrganizationId(long esfOrganizationId) {
		_esfOrganization.setEsfOrganizationId(esfOrganizationId);
	}

	/**
	* Returns the group ID of this e s f organization.
	*
	* @return the group ID of this e s f organization
	*/
	@Override
	public long getGroupId() {
		return _esfOrganization.getGroupId();
	}

	/**
	* Sets the group ID of this e s f organization.
	*
	* @param groupId the group ID of this e s f organization
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfOrganization.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f organization.
	*
	* @return the company ID of this e s f organization
	*/
	@Override
	public long getCompanyId() {
		return _esfOrganization.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f organization.
	*
	* @param companyId the company ID of this e s f organization
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfOrganization.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f organization.
	*
	* @return the user ID of this e s f organization
	*/
	@Override
	public long getUserId() {
		return _esfOrganization.getUserId();
	}

	/**
	* Sets the user ID of this e s f organization.
	*
	* @param userId the user ID of this e s f organization
	*/
	@Override
	public void setUserId(long userId) {
		_esfOrganization.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f organization.
	*
	* @return the user uuid of this e s f organization
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganization.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f organization.
	*
	* @param userUuid the user uuid of this e s f organization
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfOrganization.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f organization.
	*
	* @return the user name of this e s f organization
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfOrganization.getUserName();
	}

	/**
	* Sets the user name of this e s f organization.
	*
	* @param userName the user name of this e s f organization
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfOrganization.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f organization.
	*
	* @return the create date of this e s f organization
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfOrganization.getCreateDate();
	}

	/**
	* Sets the create date of this e s f organization.
	*
	* @param createDate the create date of this e s f organization
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfOrganization.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f organization.
	*
	* @return the modified date of this e s f organization
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfOrganization.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f organization.
	*
	* @param modifiedDate the modified date of this e s f organization
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfOrganization.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the portal organization ID of this e s f organization.
	*
	* @return the portal organization ID of this e s f organization
	*/
	@Override
	public long getPortalOrganizationId() {
		return _esfOrganization.getPortalOrganizationId();
	}

	/**
	* Sets the portal organization ID of this e s f organization.
	*
	* @param portalOrganizationId the portal organization ID of this e s f organization
	*/
	@Override
	public void setPortalOrganizationId(long portalOrganizationId) {
		_esfOrganization.setPortalOrganizationId(portalOrganizationId);
	}

	@Override
	public boolean isNew() {
		return _esfOrganization.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfOrganization.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfOrganization.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfOrganization.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfOrganization.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfOrganization.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfOrganization.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfOrganization.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfOrganization.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfOrganization.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfOrganization.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFOrganizationWrapper((ESFOrganization)_esfOrganization.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFOrganization esfOrganization) {
		return _esfOrganization.compareTo(esfOrganization);
	}

	@Override
	public int hashCode() {
		return _esfOrganization.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFOrganization> toCacheModel() {
		return _esfOrganization.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFOrganization toEscapedModel() {
		return new ESFOrganizationWrapper(_esfOrganization.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFOrganization toUnescapedModel() {
		return new ESFOrganizationWrapper(_esfOrganization.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfOrganization.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfOrganization.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfOrganization.persist();
	}

	@Override
	public java.lang.String getName()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganization.getName();
	}

	@Override
	public java.util.List<java.lang.String> getTypes()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganization.getTypes();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFOrganizationWrapper)) {
			return false;
		}

		ESFOrganizationWrapper esfOrganizationWrapper = (ESFOrganizationWrapper)obj;

		if (Validator.equals(_esfOrganization,
					esfOrganizationWrapper._esfOrganization)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _esfOrganization.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFOrganization getWrappedESFOrganization() {
		return _esfOrganization;
	}

	@Override
	public ESFOrganization getWrappedModel() {
		return _esfOrganization;
	}

	@Override
	public void resetOriginalValues() {
		_esfOrganization.resetOriginalValues();
	}

	private ESFOrganization _esfOrganization;
}