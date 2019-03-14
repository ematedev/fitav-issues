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
 * This class is a wrapper for {@link ESFEntityState}.
 * </p>
 *
 * @author Ethica
 * @see ESFEntityState
 * @generated
 */
public class ESFEntityStateWrapper implements ESFEntityState,
	ModelWrapper<ESFEntityState> {
	public ESFEntityStateWrapper(ESFEntityState esfEntityState) {
		_esfEntityState = esfEntityState;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFEntityState.class;
	}

	@Override
	public String getModelClassName() {
		return ESFEntityState.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("className", getClassName());
		attributes.put("classPk", getClassPk());
		attributes.put("stateId", getStateId());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
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

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		Long classPk = (Long)attributes.get("classPk");

		if (classPk != null) {
			setClassPk(classPk);
		}

		Long stateId = (Long)attributes.get("stateId");

		if (stateId != null) {
			setStateId(stateId);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}
	}

	/**
	* Returns the primary key of this e s f entity state.
	*
	* @return the primary key of this e s f entity state
	*/
	@Override
	public it.ethica.esf.service.persistence.ESFEntityStatePK getPrimaryKey() {
		return _esfEntityState.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f entity state.
	*
	* @param primaryKey the primary key of this e s f entity state
	*/
	@Override
	public void setPrimaryKey(
		it.ethica.esf.service.persistence.ESFEntityStatePK primaryKey) {
		_esfEntityState.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this e s f entity state.
	*
	* @return the uuid of this e s f entity state
	*/
	@Override
	public java.lang.String getUuid() {
		return _esfEntityState.getUuid();
	}

	/**
	* Sets the uuid of this e s f entity state.
	*
	* @param uuid the uuid of this e s f entity state
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_esfEntityState.setUuid(uuid);
	}

	/**
	* Returns the group ID of this e s f entity state.
	*
	* @return the group ID of this e s f entity state
	*/
	@Override
	public long getGroupId() {
		return _esfEntityState.getGroupId();
	}

	/**
	* Sets the group ID of this e s f entity state.
	*
	* @param groupId the group ID of this e s f entity state
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfEntityState.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f entity state.
	*
	* @return the company ID of this e s f entity state
	*/
	@Override
	public long getCompanyId() {
		return _esfEntityState.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f entity state.
	*
	* @param companyId the company ID of this e s f entity state
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfEntityState.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f entity state.
	*
	* @return the user ID of this e s f entity state
	*/
	@Override
	public long getUserId() {
		return _esfEntityState.getUserId();
	}

	/**
	* Sets the user ID of this e s f entity state.
	*
	* @param userId the user ID of this e s f entity state
	*/
	@Override
	public void setUserId(long userId) {
		_esfEntityState.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f entity state.
	*
	* @return the user uuid of this e s f entity state
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfEntityState.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f entity state.
	*
	* @param userUuid the user uuid of this e s f entity state
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfEntityState.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f entity state.
	*
	* @return the user name of this e s f entity state
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfEntityState.getUserName();
	}

	/**
	* Sets the user name of this e s f entity state.
	*
	* @param userName the user name of this e s f entity state
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfEntityState.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f entity state.
	*
	* @return the create date of this e s f entity state
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfEntityState.getCreateDate();
	}

	/**
	* Sets the create date of this e s f entity state.
	*
	* @param createDate the create date of this e s f entity state
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfEntityState.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f entity state.
	*
	* @return the modified date of this e s f entity state
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfEntityState.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f entity state.
	*
	* @param modifiedDate the modified date of this e s f entity state
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfEntityState.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the class name of this e s f entity state.
	*
	* @return the class name of this e s f entity state
	*/
	@Override
	public java.lang.String getClassName() {
		return _esfEntityState.getClassName();
	}

	/**
	* Sets the class name of this e s f entity state.
	*
	* @param className the class name of this e s f entity state
	*/
	@Override
	public void setClassName(java.lang.String className) {
		_esfEntityState.setClassName(className);
	}

	/**
	* Returns the class pk of this e s f entity state.
	*
	* @return the class pk of this e s f entity state
	*/
	@Override
	public long getClassPk() {
		return _esfEntityState.getClassPk();
	}

	/**
	* Sets the class pk of this e s f entity state.
	*
	* @param classPk the class pk of this e s f entity state
	*/
	@Override
	public void setClassPk(long classPk) {
		_esfEntityState.setClassPk(classPk);
	}

	/**
	* Returns the state ID of this e s f entity state.
	*
	* @return the state ID of this e s f entity state
	*/
	@Override
	public long getStateId() {
		return _esfEntityState.getStateId();
	}

	/**
	* Sets the state ID of this e s f entity state.
	*
	* @param stateId the state ID of this e s f entity state
	*/
	@Override
	public void setStateId(long stateId) {
		_esfEntityState.setStateId(stateId);
	}

	/**
	* Returns the start date of this e s f entity state.
	*
	* @return the start date of this e s f entity state
	*/
	@Override
	public java.util.Date getStartDate() {
		return _esfEntityState.getStartDate();
	}

	/**
	* Sets the start date of this e s f entity state.
	*
	* @param startDate the start date of this e s f entity state
	*/
	@Override
	public void setStartDate(java.util.Date startDate) {
		_esfEntityState.setStartDate(startDate);
	}

	/**
	* Returns the end date of this e s f entity state.
	*
	* @return the end date of this e s f entity state
	*/
	@Override
	public java.util.Date getEndDate() {
		return _esfEntityState.getEndDate();
	}

	/**
	* Sets the end date of this e s f entity state.
	*
	* @param endDate the end date of this e s f entity state
	*/
	@Override
	public void setEndDate(java.util.Date endDate) {
		_esfEntityState.setEndDate(endDate);
	}

	@Override
	public boolean isNew() {
		return _esfEntityState.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfEntityState.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfEntityState.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfEntityState.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfEntityState.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfEntityState.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfEntityState.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfEntityState.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfEntityState.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfEntityState.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfEntityState.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFEntityStateWrapper((ESFEntityState)_esfEntityState.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFEntityState esfEntityState) {
		return _esfEntityState.compareTo(esfEntityState);
	}

	@Override
	public int hashCode() {
		return _esfEntityState.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFEntityState> toCacheModel() {
		return _esfEntityState.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFEntityState toEscapedModel() {
		return new ESFEntityStateWrapper(_esfEntityState.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFEntityState toUnescapedModel() {
		return new ESFEntityStateWrapper(_esfEntityState.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfEntityState.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfEntityState.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfEntityState.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFEntityStateWrapper)) {
			return false;
		}

		ESFEntityStateWrapper esfEntityStateWrapper = (ESFEntityStateWrapper)obj;

		if (Validator.equals(_esfEntityState,
					esfEntityStateWrapper._esfEntityState)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _esfEntityState.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFEntityState getWrappedESFEntityState() {
		return _esfEntityState;
	}

	@Override
	public ESFEntityState getWrappedModel() {
		return _esfEntityState;
	}

	@Override
	public void resetOriginalValues() {
		_esfEntityState.resetOriginalValues();
	}

	private ESFEntityState _esfEntityState;
}