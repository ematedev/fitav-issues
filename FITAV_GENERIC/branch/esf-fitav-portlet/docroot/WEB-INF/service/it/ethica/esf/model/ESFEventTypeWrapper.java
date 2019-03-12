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
 * This class is a wrapper for {@link ESFEventType}.
 * </p>
 *
 * @author Ethica
 * @see ESFEventType
 * @generated
 */
public class ESFEventTypeWrapper implements ESFEventType,
	ModelWrapper<ESFEventType> {
	public ESFEventTypeWrapper(ESFEventType esfEventType) {
		_esfEventType = esfEventType;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFEventType.class;
	}

	@Override
	public String getModelClassName() {
		return ESFEventType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfEventTypeId", getEsfEventTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("macrocategory", getMacrocategory());
		attributes.put("eventType", getEventType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfEventTypeId = (Long)attributes.get("esfEventTypeId");

		if (esfEventTypeId != null) {
			setEsfEventTypeId(esfEventTypeId);
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

		String macrocategory = (String)attributes.get("macrocategory");

		if (macrocategory != null) {
			setMacrocategory(macrocategory);
		}

		String eventType = (String)attributes.get("eventType");

		if (eventType != null) {
			setEventType(eventType);
		}
	}

	/**
	* Returns the primary key of this e s f event type.
	*
	* @return the primary key of this e s f event type
	*/
	@Override
	public long getPrimaryKey() {
		return _esfEventType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f event type.
	*
	* @param primaryKey the primary key of this e s f event type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfEventType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf event type ID of this e s f event type.
	*
	* @return the esf event type ID of this e s f event type
	*/
	@Override
	public long getEsfEventTypeId() {
		return _esfEventType.getEsfEventTypeId();
	}

	/**
	* Sets the esf event type ID of this e s f event type.
	*
	* @param esfEventTypeId the esf event type ID of this e s f event type
	*/
	@Override
	public void setEsfEventTypeId(long esfEventTypeId) {
		_esfEventType.setEsfEventTypeId(esfEventTypeId);
	}

	/**
	* Returns the group ID of this e s f event type.
	*
	* @return the group ID of this e s f event type
	*/
	@Override
	public long getGroupId() {
		return _esfEventType.getGroupId();
	}

	/**
	* Sets the group ID of this e s f event type.
	*
	* @param groupId the group ID of this e s f event type
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfEventType.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f event type.
	*
	* @return the company ID of this e s f event type
	*/
	@Override
	public long getCompanyId() {
		return _esfEventType.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f event type.
	*
	* @param companyId the company ID of this e s f event type
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfEventType.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f event type.
	*
	* @return the user ID of this e s f event type
	*/
	@Override
	public long getUserId() {
		return _esfEventType.getUserId();
	}

	/**
	* Sets the user ID of this e s f event type.
	*
	* @param userId the user ID of this e s f event type
	*/
	@Override
	public void setUserId(long userId) {
		_esfEventType.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f event type.
	*
	* @return the user uuid of this e s f event type
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfEventType.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f event type.
	*
	* @param userUuid the user uuid of this e s f event type
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfEventType.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f event type.
	*
	* @return the user name of this e s f event type
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfEventType.getUserName();
	}

	/**
	* Sets the user name of this e s f event type.
	*
	* @param userName the user name of this e s f event type
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfEventType.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f event type.
	*
	* @return the create date of this e s f event type
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfEventType.getCreateDate();
	}

	/**
	* Sets the create date of this e s f event type.
	*
	* @param createDate the create date of this e s f event type
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfEventType.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f event type.
	*
	* @return the modified date of this e s f event type
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfEventType.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f event type.
	*
	* @param modifiedDate the modified date of this e s f event type
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfEventType.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the macrocategory of this e s f event type.
	*
	* @return the macrocategory of this e s f event type
	*/
	@Override
	public java.lang.String getMacrocategory() {
		return _esfEventType.getMacrocategory();
	}

	/**
	* Sets the macrocategory of this e s f event type.
	*
	* @param macrocategory the macrocategory of this e s f event type
	*/
	@Override
	public void setMacrocategory(java.lang.String macrocategory) {
		_esfEventType.setMacrocategory(macrocategory);
	}

	/**
	* Returns the event type of this e s f event type.
	*
	* @return the event type of this e s f event type
	*/
	@Override
	public java.lang.String getEventType() {
		return _esfEventType.getEventType();
	}

	/**
	* Sets the event type of this e s f event type.
	*
	* @param eventType the event type of this e s f event type
	*/
	@Override
	public void setEventType(java.lang.String eventType) {
		_esfEventType.setEventType(eventType);
	}

	@Override
	public boolean isNew() {
		return _esfEventType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfEventType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfEventType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfEventType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfEventType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfEventType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfEventType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfEventType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfEventType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfEventType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfEventType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFEventTypeWrapper((ESFEventType)_esfEventType.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFEventType esfEventType) {
		return _esfEventType.compareTo(esfEventType);
	}

	@Override
	public int hashCode() {
		return _esfEventType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFEventType> toCacheModel() {
		return _esfEventType.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFEventType toEscapedModel() {
		return new ESFEventTypeWrapper(_esfEventType.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFEventType toUnescapedModel() {
		return new ESFEventTypeWrapper(_esfEventType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfEventType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfEventType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfEventType.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFEventTypeWrapper)) {
			return false;
		}

		ESFEventTypeWrapper esfEventTypeWrapper = (ESFEventTypeWrapper)obj;

		if (Validator.equals(_esfEventType, esfEventTypeWrapper._esfEventType)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFEventType getWrappedESFEventType() {
		return _esfEventType;
	}

	@Override
	public ESFEventType getWrappedModel() {
		return _esfEventType;
	}

	@Override
	public void resetOriginalValues() {
		_esfEventType.resetOriginalValues();
	}

	private ESFEventType _esfEventType;
}