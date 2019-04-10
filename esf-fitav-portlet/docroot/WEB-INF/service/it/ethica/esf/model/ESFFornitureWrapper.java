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
 * This class is a wrapper for {@link ESFForniture}.
 * </p>
 *
 * @author Ethica
 * @see ESFForniture
 * @generated
 */
public class ESFFornitureWrapper implements ESFForniture,
	ModelWrapper<ESFForniture> {
	public ESFFornitureWrapper(ESFForniture esfForniture) {
		_esfForniture = esfForniture;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFForniture.class;
	}

	@Override
	public String getModelClassName() {
		return ESFForniture.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfFornitureId", getEsfFornitureId());
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
		attributes.put("insertDate", getInsertDate());
		attributes.put("numberFornitures", getNumberFornitures());
		attributes.put("size", getSize());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfFornitureId = (Long)attributes.get("esfFornitureId");

		if (esfFornitureId != null) {
			setEsfFornitureId(esfFornitureId);
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

		Long type = (Long)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Date insertDate = (Date)attributes.get("insertDate");

		if (insertDate != null) {
			setInsertDate(insertDate);
		}

		Long numberFornitures = (Long)attributes.get("numberFornitures");

		if (numberFornitures != null) {
			setNumberFornitures(numberFornitures);
		}

		String size = (String)attributes.get("size");

		if (size != null) {
			setSize(size);
		}
	}

	/**
	* Returns the primary key of this e s f forniture.
	*
	* @return the primary key of this e s f forniture
	*/
	@Override
	public long getPrimaryKey() {
		return _esfForniture.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f forniture.
	*
	* @param primaryKey the primary key of this e s f forniture
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfForniture.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this e s f forniture.
	*
	* @return the uuid of this e s f forniture
	*/
	@Override
	public java.lang.String getUuid() {
		return _esfForniture.getUuid();
	}

	/**
	* Sets the uuid of this e s f forniture.
	*
	* @param uuid the uuid of this e s f forniture
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_esfForniture.setUuid(uuid);
	}

	/**
	* Returns the esf forniture ID of this e s f forniture.
	*
	* @return the esf forniture ID of this e s f forniture
	*/
	@Override
	public long getEsfFornitureId() {
		return _esfForniture.getEsfFornitureId();
	}

	/**
	* Sets the esf forniture ID of this e s f forniture.
	*
	* @param esfFornitureId the esf forniture ID of this e s f forniture
	*/
	@Override
	public void setEsfFornitureId(long esfFornitureId) {
		_esfForniture.setEsfFornitureId(esfFornitureId);
	}

	/**
	* Returns the group ID of this e s f forniture.
	*
	* @return the group ID of this e s f forniture
	*/
	@Override
	public long getGroupId() {
		return _esfForniture.getGroupId();
	}

	/**
	* Sets the group ID of this e s f forniture.
	*
	* @param groupId the group ID of this e s f forniture
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfForniture.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f forniture.
	*
	* @return the company ID of this e s f forniture
	*/
	@Override
	public long getCompanyId() {
		return _esfForniture.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f forniture.
	*
	* @param companyId the company ID of this e s f forniture
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfForniture.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f forniture.
	*
	* @return the user ID of this e s f forniture
	*/
	@Override
	public long getUserId() {
		return _esfForniture.getUserId();
	}

	/**
	* Sets the user ID of this e s f forniture.
	*
	* @param userId the user ID of this e s f forniture
	*/
	@Override
	public void setUserId(long userId) {
		_esfForniture.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f forniture.
	*
	* @return the user uuid of this e s f forniture
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfForniture.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f forniture.
	*
	* @param userUuid the user uuid of this e s f forniture
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfForniture.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f forniture.
	*
	* @return the user name of this e s f forniture
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfForniture.getUserName();
	}

	/**
	* Sets the user name of this e s f forniture.
	*
	* @param userName the user name of this e s f forniture
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfForniture.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f forniture.
	*
	* @return the create date of this e s f forniture
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfForniture.getCreateDate();
	}

	/**
	* Sets the create date of this e s f forniture.
	*
	* @param createDate the create date of this e s f forniture
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfForniture.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f forniture.
	*
	* @return the modified date of this e s f forniture
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfForniture.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f forniture.
	*
	* @param modifiedDate the modified date of this e s f forniture
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfForniture.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the code of this e s f forniture.
	*
	* @return the code of this e s f forniture
	*/
	@Override
	public java.lang.String getCode() {
		return _esfForniture.getCode();
	}

	/**
	* Sets the code of this e s f forniture.
	*
	* @param code the code of this e s f forniture
	*/
	@Override
	public void setCode(java.lang.String code) {
		_esfForniture.setCode(code);
	}

	/**
	* Returns the name of this e s f forniture.
	*
	* @return the name of this e s f forniture
	*/
	@Override
	public java.lang.String getName() {
		return _esfForniture.getName();
	}

	/**
	* Sets the name of this e s f forniture.
	*
	* @param name the name of this e s f forniture
	*/
	@Override
	public void setName(java.lang.String name) {
		_esfForniture.setName(name);
	}

	/**
	* Returns the description of this e s f forniture.
	*
	* @return the description of this e s f forniture
	*/
	@Override
	public java.lang.String getDescription() {
		return _esfForniture.getDescription();
	}

	/**
	* Sets the description of this e s f forniture.
	*
	* @param description the description of this e s f forniture
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_esfForniture.setDescription(description);
	}

	/**
	* Returns the type of this e s f forniture.
	*
	* @return the type of this e s f forniture
	*/
	@Override
	public long getType() {
		return _esfForniture.getType();
	}

	/**
	* Sets the type of this e s f forniture.
	*
	* @param type the type of this e s f forniture
	*/
	@Override
	public void setType(long type) {
		_esfForniture.setType(type);
	}

	/**
	* Returns the insert date of this e s f forniture.
	*
	* @return the insert date of this e s f forniture
	*/
	@Override
	public java.util.Date getInsertDate() {
		return _esfForniture.getInsertDate();
	}

	/**
	* Sets the insert date of this e s f forniture.
	*
	* @param insertDate the insert date of this e s f forniture
	*/
	@Override
	public void setInsertDate(java.util.Date insertDate) {
		_esfForniture.setInsertDate(insertDate);
	}

	/**
	* Returns the number fornitures of this e s f forniture.
	*
	* @return the number fornitures of this e s f forniture
	*/
	@Override
	public long getNumberFornitures() {
		return _esfForniture.getNumberFornitures();
	}

	/**
	* Sets the number fornitures of this e s f forniture.
	*
	* @param numberFornitures the number fornitures of this e s f forniture
	*/
	@Override
	public void setNumberFornitures(long numberFornitures) {
		_esfForniture.setNumberFornitures(numberFornitures);
	}

	/**
	* Returns the size of this e s f forniture.
	*
	* @return the size of this e s f forniture
	*/
	@Override
	public java.lang.String getSize() {
		return _esfForniture.getSize();
	}

	/**
	* Sets the size of this e s f forniture.
	*
	* @param size the size of this e s f forniture
	*/
	@Override
	public void setSize(java.lang.String size) {
		_esfForniture.setSize(size);
	}

	@Override
	public boolean isNew() {
		return _esfForniture.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfForniture.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfForniture.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfForniture.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfForniture.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfForniture.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfForniture.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfForniture.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfForniture.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfForniture.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfForniture.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFFornitureWrapper((ESFForniture)_esfForniture.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFForniture esfForniture) {
		return _esfForniture.compareTo(esfForniture);
	}

	@Override
	public int hashCode() {
		return _esfForniture.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFForniture> toCacheModel() {
		return _esfForniture.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFForniture toEscapedModel() {
		return new ESFFornitureWrapper(_esfForniture.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFForniture toUnescapedModel() {
		return new ESFFornitureWrapper(_esfForniture.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfForniture.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfForniture.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfForniture.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFFornitureWrapper)) {
			return false;
		}

		ESFFornitureWrapper esfFornitureWrapper = (ESFFornitureWrapper)obj;

		if (Validator.equals(_esfForniture, esfFornitureWrapper._esfForniture)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _esfForniture.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFForniture getWrappedESFForniture() {
		return _esfForniture;
	}

	@Override
	public ESFForniture getWrappedModel() {
		return _esfForniture;
	}

	@Override
	public void resetOriginalValues() {
		_esfForniture.resetOriginalValues();
	}

	private ESFForniture _esfForniture;
}