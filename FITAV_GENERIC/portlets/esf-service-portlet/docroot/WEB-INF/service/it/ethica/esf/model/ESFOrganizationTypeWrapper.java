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
 * This class is a wrapper for {@link ESFOrganizationType}.
 * </p>
 *
 * @author Ethica
 * @see ESFOrganizationType
 * @generated
 */
public class ESFOrganizationTypeWrapper implements ESFOrganizationType,
	ModelWrapper<ESFOrganizationType> {
	public ESFOrganizationTypeWrapper(ESFOrganizationType esfOrganizationType) {
		_esfOrganizationType = esfOrganizationType;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFOrganizationType.class;
	}

	@Override
	public String getModelClassName() {
		return ESFOrganizationType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfOrganizationTypeId", getEsfOrganizationTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("esfOrganizationId", getEsfOrganizationId());
		attributes.put("esfTypeId", getEsfTypeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfOrganizationTypeId = (Long)attributes.get(
				"esfOrganizationTypeId");

		if (esfOrganizationTypeId != null) {
			setEsfOrganizationTypeId(esfOrganizationTypeId);
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

		Long esfOrganizationId = (Long)attributes.get("esfOrganizationId");

		if (esfOrganizationId != null) {
			setEsfOrganizationId(esfOrganizationId);
		}

		Long esfTypeId = (Long)attributes.get("esfTypeId");

		if (esfTypeId != null) {
			setEsfTypeId(esfTypeId);
		}
	}

	/**
	* Returns the primary key of this e s f organization type.
	*
	* @return the primary key of this e s f organization type
	*/
	@Override
	public long getPrimaryKey() {
		return _esfOrganizationType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f organization type.
	*
	* @param primaryKey the primary key of this e s f organization type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfOrganizationType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf organization type ID of this e s f organization type.
	*
	* @return the esf organization type ID of this e s f organization type
	*/
	@Override
	public long getEsfOrganizationTypeId() {
		return _esfOrganizationType.getEsfOrganizationTypeId();
	}

	/**
	* Sets the esf organization type ID of this e s f organization type.
	*
	* @param esfOrganizationTypeId the esf organization type ID of this e s f organization type
	*/
	@Override
	public void setEsfOrganizationTypeId(long esfOrganizationTypeId) {
		_esfOrganizationType.setEsfOrganizationTypeId(esfOrganizationTypeId);
	}

	/**
	* Returns the group ID of this e s f organization type.
	*
	* @return the group ID of this e s f organization type
	*/
	@Override
	public long getGroupId() {
		return _esfOrganizationType.getGroupId();
	}

	/**
	* Sets the group ID of this e s f organization type.
	*
	* @param groupId the group ID of this e s f organization type
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfOrganizationType.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f organization type.
	*
	* @return the company ID of this e s f organization type
	*/
	@Override
	public long getCompanyId() {
		return _esfOrganizationType.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f organization type.
	*
	* @param companyId the company ID of this e s f organization type
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfOrganizationType.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f organization type.
	*
	* @return the user ID of this e s f organization type
	*/
	@Override
	public long getUserId() {
		return _esfOrganizationType.getUserId();
	}

	/**
	* Sets the user ID of this e s f organization type.
	*
	* @param userId the user ID of this e s f organization type
	*/
	@Override
	public void setUserId(long userId) {
		_esfOrganizationType.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f organization type.
	*
	* @return the user uuid of this e s f organization type
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfOrganizationType.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f organization type.
	*
	* @param userUuid the user uuid of this e s f organization type
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfOrganizationType.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f organization type.
	*
	* @return the user name of this e s f organization type
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfOrganizationType.getUserName();
	}

	/**
	* Sets the user name of this e s f organization type.
	*
	* @param userName the user name of this e s f organization type
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfOrganizationType.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f organization type.
	*
	* @return the create date of this e s f organization type
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfOrganizationType.getCreateDate();
	}

	/**
	* Sets the create date of this e s f organization type.
	*
	* @param createDate the create date of this e s f organization type
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfOrganizationType.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f organization type.
	*
	* @return the modified date of this e s f organization type
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfOrganizationType.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f organization type.
	*
	* @param modifiedDate the modified date of this e s f organization type
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfOrganizationType.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the esf organization ID of this e s f organization type.
	*
	* @return the esf organization ID of this e s f organization type
	*/
	@Override
	public long getEsfOrganizationId() {
		return _esfOrganizationType.getEsfOrganizationId();
	}

	/**
	* Sets the esf organization ID of this e s f organization type.
	*
	* @param esfOrganizationId the esf organization ID of this e s f organization type
	*/
	@Override
	public void setEsfOrganizationId(long esfOrganizationId) {
		_esfOrganizationType.setEsfOrganizationId(esfOrganizationId);
	}

	/**
	* Returns the esf type ID of this e s f organization type.
	*
	* @return the esf type ID of this e s f organization type
	*/
	@Override
	public long getEsfTypeId() {
		return _esfOrganizationType.getEsfTypeId();
	}

	/**
	* Sets the esf type ID of this e s f organization type.
	*
	* @param esfTypeId the esf type ID of this e s f organization type
	*/
	@Override
	public void setEsfTypeId(long esfTypeId) {
		_esfOrganizationType.setEsfTypeId(esfTypeId);
	}

	@Override
	public boolean isNew() {
		return _esfOrganizationType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfOrganizationType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfOrganizationType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfOrganizationType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfOrganizationType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfOrganizationType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfOrganizationType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfOrganizationType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfOrganizationType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfOrganizationType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfOrganizationType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFOrganizationTypeWrapper((ESFOrganizationType)_esfOrganizationType.clone());
	}

	@Override
	public int compareTo(
		it.ethica.esf.model.ESFOrganizationType esfOrganizationType) {
		return _esfOrganizationType.compareTo(esfOrganizationType);
	}

	@Override
	public int hashCode() {
		return _esfOrganizationType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFOrganizationType> toCacheModel() {
		return _esfOrganizationType.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFOrganizationType toEscapedModel() {
		return new ESFOrganizationTypeWrapper(_esfOrganizationType.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFOrganizationType toUnescapedModel() {
		return new ESFOrganizationTypeWrapper(_esfOrganizationType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfOrganizationType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfOrganizationType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfOrganizationType.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFOrganizationTypeWrapper)) {
			return false;
		}

		ESFOrganizationTypeWrapper esfOrganizationTypeWrapper = (ESFOrganizationTypeWrapper)obj;

		if (Validator.equals(_esfOrganizationType,
					esfOrganizationTypeWrapper._esfOrganizationType)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFOrganizationType getWrappedESFOrganizationType() {
		return _esfOrganizationType;
	}

	@Override
	public ESFOrganizationType getWrappedModel() {
		return _esfOrganizationType;
	}

	@Override
	public void resetOriginalValues() {
		_esfOrganizationType.resetOriginalValues();
	}

	private ESFOrganizationType _esfOrganizationType;
}