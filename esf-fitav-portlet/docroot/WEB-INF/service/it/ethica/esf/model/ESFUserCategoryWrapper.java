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
 * This class is a wrapper for {@link ESFUserCategory}.
 * </p>
 *
 * @author Ethica
 * @see ESFUserCategory
 * @generated
 */
public class ESFUserCategoryWrapper implements ESFUserCategory,
	ModelWrapper<ESFUserCategory> {
	public ESFUserCategoryWrapper(ESFUserCategory esfUserCategory) {
		_esfUserCategory = esfUserCategory;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFUserCategory.class;
	}

	@Override
	public String getModelClassName() {
		return ESFUserCategory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfUserCategoryId", getEsfUserCategoryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("esfUserId", getEsfUserId());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("esfCategoryId", getEsfCategoryId());
		attributes.put("esfSportTypeId", getEsfSportTypeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfUserCategoryId = (Long)attributes.get("esfUserCategoryId");

		if (esfUserCategoryId != null) {
			setEsfUserCategoryId(esfUserCategoryId);
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

		Long esfUserId = (Long)attributes.get("esfUserId");

		if (esfUserId != null) {
			setEsfUserId(esfUserId);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Long esfCategoryId = (Long)attributes.get("esfCategoryId");

		if (esfCategoryId != null) {
			setEsfCategoryId(esfCategoryId);
		}

		Long esfSportTypeId = (Long)attributes.get("esfSportTypeId");

		if (esfSportTypeId != null) {
			setEsfSportTypeId(esfSportTypeId);
		}
	}

	/**
	* Returns the primary key of this e s f user category.
	*
	* @return the primary key of this e s f user category
	*/
	@Override
	public long getPrimaryKey() {
		return _esfUserCategory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f user category.
	*
	* @param primaryKey the primary key of this e s f user category
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfUserCategory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf user category ID of this e s f user category.
	*
	* @return the esf user category ID of this e s f user category
	*/
	@Override
	public long getEsfUserCategoryId() {
		return _esfUserCategory.getEsfUserCategoryId();
	}

	/**
	* Sets the esf user category ID of this e s f user category.
	*
	* @param esfUserCategoryId the esf user category ID of this e s f user category
	*/
	@Override
	public void setEsfUserCategoryId(long esfUserCategoryId) {
		_esfUserCategory.setEsfUserCategoryId(esfUserCategoryId);
	}

	/**
	* Returns the group ID of this e s f user category.
	*
	* @return the group ID of this e s f user category
	*/
	@Override
	public long getGroupId() {
		return _esfUserCategory.getGroupId();
	}

	/**
	* Sets the group ID of this e s f user category.
	*
	* @param groupId the group ID of this e s f user category
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfUserCategory.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f user category.
	*
	* @return the company ID of this e s f user category
	*/
	@Override
	public long getCompanyId() {
		return _esfUserCategory.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f user category.
	*
	* @param companyId the company ID of this e s f user category
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfUserCategory.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f user category.
	*
	* @return the user ID of this e s f user category
	*/
	@Override
	public long getUserId() {
		return _esfUserCategory.getUserId();
	}

	/**
	* Sets the user ID of this e s f user category.
	*
	* @param userId the user ID of this e s f user category
	*/
	@Override
	public void setUserId(long userId) {
		_esfUserCategory.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f user category.
	*
	* @return the user uuid of this e s f user category
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfUserCategory.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f user category.
	*
	* @param userUuid the user uuid of this e s f user category
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfUserCategory.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f user category.
	*
	* @return the user name of this e s f user category
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfUserCategory.getUserName();
	}

	/**
	* Sets the user name of this e s f user category.
	*
	* @param userName the user name of this e s f user category
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfUserCategory.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f user category.
	*
	* @return the create date of this e s f user category
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfUserCategory.getCreateDate();
	}

	/**
	* Sets the create date of this e s f user category.
	*
	* @param createDate the create date of this e s f user category
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfUserCategory.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f user category.
	*
	* @return the modified date of this e s f user category
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfUserCategory.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f user category.
	*
	* @param modifiedDate the modified date of this e s f user category
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfUserCategory.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the esf user ID of this e s f user category.
	*
	* @return the esf user ID of this e s f user category
	*/
	@Override
	public long getEsfUserId() {
		return _esfUserCategory.getEsfUserId();
	}

	/**
	* Sets the esf user ID of this e s f user category.
	*
	* @param esfUserId the esf user ID of this e s f user category
	*/
	@Override
	public void setEsfUserId(long esfUserId) {
		_esfUserCategory.setEsfUserId(esfUserId);
	}

	/**
	* Returns the esf user uuid of this e s f user category.
	*
	* @return the esf user uuid of this e s f user category
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getEsfUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfUserCategory.getEsfUserUuid();
	}

	/**
	* Sets the esf user uuid of this e s f user category.
	*
	* @param esfUserUuid the esf user uuid of this e s f user category
	*/
	@Override
	public void setEsfUserUuid(java.lang.String esfUserUuid) {
		_esfUserCategory.setEsfUserUuid(esfUserUuid);
	}

	/**
	* Returns the start date of this e s f user category.
	*
	* @return the start date of this e s f user category
	*/
	@Override
	public java.util.Date getStartDate() {
		return _esfUserCategory.getStartDate();
	}

	/**
	* Sets the start date of this e s f user category.
	*
	* @param startDate the start date of this e s f user category
	*/
	@Override
	public void setStartDate(java.util.Date startDate) {
		_esfUserCategory.setStartDate(startDate);
	}

	/**
	* Returns the end date of this e s f user category.
	*
	* @return the end date of this e s f user category
	*/
	@Override
	public java.util.Date getEndDate() {
		return _esfUserCategory.getEndDate();
	}

	/**
	* Sets the end date of this e s f user category.
	*
	* @param endDate the end date of this e s f user category
	*/
	@Override
	public void setEndDate(java.util.Date endDate) {
		_esfUserCategory.setEndDate(endDate);
	}

	/**
	* Returns the esf category ID of this e s f user category.
	*
	* @return the esf category ID of this e s f user category
	*/
	@Override
	public long getEsfCategoryId() {
		return _esfUserCategory.getEsfCategoryId();
	}

	/**
	* Sets the esf category ID of this e s f user category.
	*
	* @param esfCategoryId the esf category ID of this e s f user category
	*/
	@Override
	public void setEsfCategoryId(long esfCategoryId) {
		_esfUserCategory.setEsfCategoryId(esfCategoryId);
	}

	/**
	* Returns the esf sport type ID of this e s f user category.
	*
	* @return the esf sport type ID of this e s f user category
	*/
	@Override
	public long getEsfSportTypeId() {
		return _esfUserCategory.getEsfSportTypeId();
	}

	/**
	* Sets the esf sport type ID of this e s f user category.
	*
	* @param esfSportTypeId the esf sport type ID of this e s f user category
	*/
	@Override
	public void setEsfSportTypeId(long esfSportTypeId) {
		_esfUserCategory.setEsfSportTypeId(esfSportTypeId);
	}

	@Override
	public boolean isNew() {
		return _esfUserCategory.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfUserCategory.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfUserCategory.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfUserCategory.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfUserCategory.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfUserCategory.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfUserCategory.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfUserCategory.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfUserCategory.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfUserCategory.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfUserCategory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFUserCategoryWrapper((ESFUserCategory)_esfUserCategory.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFUserCategory esfUserCategory) {
		return _esfUserCategory.compareTo(esfUserCategory);
	}

	@Override
	public int hashCode() {
		return _esfUserCategory.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFUserCategory> toCacheModel() {
		return _esfUserCategory.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFUserCategory toEscapedModel() {
		return new ESFUserCategoryWrapper(_esfUserCategory.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFUserCategory toUnescapedModel() {
		return new ESFUserCategoryWrapper(_esfUserCategory.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfUserCategory.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfUserCategory.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfUserCategory.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFUserCategoryWrapper)) {
			return false;
		}

		ESFUserCategoryWrapper esfUserCategoryWrapper = (ESFUserCategoryWrapper)obj;

		if (Validator.equals(_esfUserCategory,
					esfUserCategoryWrapper._esfUserCategory)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFUserCategory getWrappedESFUserCategory() {
		return _esfUserCategory;
	}

	@Override
	public ESFUserCategory getWrappedModel() {
		return _esfUserCategory;
	}

	@Override
	public void resetOriginalValues() {
		_esfUserCategory.resetOriginalValues();
	}

	private ESFUserCategory _esfUserCategory;
}