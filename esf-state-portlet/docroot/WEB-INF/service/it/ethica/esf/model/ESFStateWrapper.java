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
 * This class is a wrapper for {@link ESFState}.
 * </p>
 *
 * @author Ethica
 * @see ESFState
 * @generated
 */
public class ESFStateWrapper implements ESFState, ModelWrapper<ESFState> {
	public ESFStateWrapper(ESFState esfState) {
		_esfState = esfState;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFState.class;
	}

	@Override
	public String getModelClassName() {
		return ESFState.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfStateId", getEsfStateId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("esfName", getEsfName());
		attributes.put("esfDescription", getEsfDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfStateId = (Long)attributes.get("esfStateId");

		if (esfStateId != null) {
			setEsfStateId(esfStateId);
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

		String esfName = (String)attributes.get("esfName");

		if (esfName != null) {
			setEsfName(esfName);
		}

		String esfDescription = (String)attributes.get("esfDescription");

		if (esfDescription != null) {
			setEsfDescription(esfDescription);
		}
	}

	/**
	* Returns the primary key of this e s f state.
	*
	* @return the primary key of this e s f state
	*/
	@Override
	public long getPrimaryKey() {
		return _esfState.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f state.
	*
	* @param primaryKey the primary key of this e s f state
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfState.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this e s f state.
	*
	* @return the uuid of this e s f state
	*/
	@Override
	public java.lang.String getUuid() {
		return _esfState.getUuid();
	}

	/**
	* Sets the uuid of this e s f state.
	*
	* @param uuid the uuid of this e s f state
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_esfState.setUuid(uuid);
	}

	/**
	* Returns the esf state ID of this e s f state.
	*
	* @return the esf state ID of this e s f state
	*/
	@Override
	public long getEsfStateId() {
		return _esfState.getEsfStateId();
	}

	/**
	* Sets the esf state ID of this e s f state.
	*
	* @param esfStateId the esf state ID of this e s f state
	*/
	@Override
	public void setEsfStateId(long esfStateId) {
		_esfState.setEsfStateId(esfStateId);
	}

	/**
	* Returns the group ID of this e s f state.
	*
	* @return the group ID of this e s f state
	*/
	@Override
	public long getGroupId() {
		return _esfState.getGroupId();
	}

	/**
	* Sets the group ID of this e s f state.
	*
	* @param groupId the group ID of this e s f state
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfState.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f state.
	*
	* @return the company ID of this e s f state
	*/
	@Override
	public long getCompanyId() {
		return _esfState.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f state.
	*
	* @param companyId the company ID of this e s f state
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfState.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f state.
	*
	* @return the user ID of this e s f state
	*/
	@Override
	public long getUserId() {
		return _esfState.getUserId();
	}

	/**
	* Sets the user ID of this e s f state.
	*
	* @param userId the user ID of this e s f state
	*/
	@Override
	public void setUserId(long userId) {
		_esfState.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f state.
	*
	* @return the user uuid of this e s f state
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfState.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f state.
	*
	* @param userUuid the user uuid of this e s f state
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfState.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f state.
	*
	* @return the user name of this e s f state
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfState.getUserName();
	}

	/**
	* Sets the user name of this e s f state.
	*
	* @param userName the user name of this e s f state
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfState.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f state.
	*
	* @return the create date of this e s f state
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfState.getCreateDate();
	}

	/**
	* Sets the create date of this e s f state.
	*
	* @param createDate the create date of this e s f state
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfState.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f state.
	*
	* @return the modified date of this e s f state
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfState.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f state.
	*
	* @param modifiedDate the modified date of this e s f state
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfState.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the esf name of this e s f state.
	*
	* @return the esf name of this e s f state
	*/
	@Override
	public java.lang.String getEsfName() {
		return _esfState.getEsfName();
	}

	/**
	* Sets the esf name of this e s f state.
	*
	* @param esfName the esf name of this e s f state
	*/
	@Override
	public void setEsfName(java.lang.String esfName) {
		_esfState.setEsfName(esfName);
	}

	/**
	* Returns the esf description of this e s f state.
	*
	* @return the esf description of this e s f state
	*/
	@Override
	public java.lang.String getEsfDescription() {
		return _esfState.getEsfDescription();
	}

	/**
	* Sets the esf description of this e s f state.
	*
	* @param esfDescription the esf description of this e s f state
	*/
	@Override
	public void setEsfDescription(java.lang.String esfDescription) {
		_esfState.setEsfDescription(esfDescription);
	}

	@Override
	public boolean isNew() {
		return _esfState.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfState.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfState.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfState.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfState.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfState.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfState.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfState.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfState.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfState.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfState.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFStateWrapper((ESFState)_esfState.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFState esfState) {
		return _esfState.compareTo(esfState);
	}

	@Override
	public int hashCode() {
		return _esfState.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFState> toCacheModel() {
		return _esfState.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFState toEscapedModel() {
		return new ESFStateWrapper(_esfState.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFState toUnescapedModel() {
		return new ESFStateWrapper(_esfState.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfState.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfState.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfState.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFStateWrapper)) {
			return false;
		}

		ESFStateWrapper esfStateWrapper = (ESFStateWrapper)obj;

		if (Validator.equals(_esfState, esfStateWrapper._esfState)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _esfState.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFState getWrappedESFState() {
		return _esfState;
	}

	@Override
	public ESFState getWrappedModel() {
		return _esfState;
	}

	@Override
	public void resetOriginalValues() {
		_esfState.resetOriginalValues();
	}

	private ESFState _esfState;
}