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
 * This class is a wrapper for {@link ESFGun}.
 * </p>
 *
 * @author Ethica
 * @see ESFGun
 * @generated
 */
public class ESFGunWrapper implements ESFGun, ModelWrapper<ESFGun> {
	public ESFGunWrapper(ESFGun esfGun) {
		_esfGun = esfGun;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFGun.class;
	}

	@Override
	public String getModelClassName() {
		return ESFGun.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfGunId", getEsfGunId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("esfUserId", getEsfUserId());
		attributes.put("code", getCode());
		attributes.put("esfGunKindId", getEsfGunKindId());
		attributes.put("esfOrganizationId", getEsfOrganizationId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfGunId = (Long)attributes.get("esfGunId");

		if (esfGunId != null) {
			setEsfGunId(esfGunId);
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

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		Long esfGunKindId = (Long)attributes.get("esfGunKindId");

		if (esfGunKindId != null) {
			setEsfGunKindId(esfGunKindId);
		}

		Long esfOrganizationId = (Long)attributes.get("esfOrganizationId");

		if (esfOrganizationId != null) {
			setEsfOrganizationId(esfOrganizationId);
		}
	}

	/**
	* Returns the primary key of this e s f gun.
	*
	* @return the primary key of this e s f gun
	*/
	@Override
	public long getPrimaryKey() {
		return _esfGun.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f gun.
	*
	* @param primaryKey the primary key of this e s f gun
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfGun.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this e s f gun.
	*
	* @return the uuid of this e s f gun
	*/
	@Override
	public java.lang.String getUuid() {
		return _esfGun.getUuid();
	}

	/**
	* Sets the uuid of this e s f gun.
	*
	* @param uuid the uuid of this e s f gun
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_esfGun.setUuid(uuid);
	}

	/**
	* Returns the esf gun ID of this e s f gun.
	*
	* @return the esf gun ID of this e s f gun
	*/
	@Override
	public long getEsfGunId() {
		return _esfGun.getEsfGunId();
	}

	/**
	* Sets the esf gun ID of this e s f gun.
	*
	* @param esfGunId the esf gun ID of this e s f gun
	*/
	@Override
	public void setEsfGunId(long esfGunId) {
		_esfGun.setEsfGunId(esfGunId);
	}

	/**
	* Returns the group ID of this e s f gun.
	*
	* @return the group ID of this e s f gun
	*/
	@Override
	public long getGroupId() {
		return _esfGun.getGroupId();
	}

	/**
	* Sets the group ID of this e s f gun.
	*
	* @param groupId the group ID of this e s f gun
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfGun.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this e s f gun.
	*
	* @return the company ID of this e s f gun
	*/
	@Override
	public long getCompanyId() {
		return _esfGun.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f gun.
	*
	* @param companyId the company ID of this e s f gun
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfGun.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f gun.
	*
	* @return the user ID of this e s f gun
	*/
	@Override
	public long getUserId() {
		return _esfGun.getUserId();
	}

	/**
	* Sets the user ID of this e s f gun.
	*
	* @param userId the user ID of this e s f gun
	*/
	@Override
	public void setUserId(long userId) {
		_esfGun.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f gun.
	*
	* @return the user uuid of this e s f gun
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGun.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f gun.
	*
	* @param userUuid the user uuid of this e s f gun
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfGun.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this e s f gun.
	*
	* @return the user name of this e s f gun
	*/
	@Override
	public java.lang.String getUserName() {
		return _esfGun.getUserName();
	}

	/**
	* Sets the user name of this e s f gun.
	*
	* @param userName the user name of this e s f gun
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_esfGun.setUserName(userName);
	}

	/**
	* Returns the create date of this e s f gun.
	*
	* @return the create date of this e s f gun
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfGun.getCreateDate();
	}

	/**
	* Sets the create date of this e s f gun.
	*
	* @param createDate the create date of this e s f gun
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfGun.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this e s f gun.
	*
	* @return the modified date of this e s f gun
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfGun.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f gun.
	*
	* @param modifiedDate the modified date of this e s f gun
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfGun.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the esf user ID of this e s f gun.
	*
	* @return the esf user ID of this e s f gun
	*/
	@Override
	public long getEsfUserId() {
		return _esfGun.getEsfUserId();
	}

	/**
	* Sets the esf user ID of this e s f gun.
	*
	* @param esfUserId the esf user ID of this e s f gun
	*/
	@Override
	public void setEsfUserId(long esfUserId) {
		_esfGun.setEsfUserId(esfUserId);
	}

	/**
	* Returns the esf user uuid of this e s f gun.
	*
	* @return the esf user uuid of this e s f gun
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getEsfUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfGun.getEsfUserUuid();
	}

	/**
	* Sets the esf user uuid of this e s f gun.
	*
	* @param esfUserUuid the esf user uuid of this e s f gun
	*/
	@Override
	public void setEsfUserUuid(java.lang.String esfUserUuid) {
		_esfGun.setEsfUserUuid(esfUserUuid);
	}

	/**
	* Returns the code of this e s f gun.
	*
	* @return the code of this e s f gun
	*/
	@Override
	public java.lang.String getCode() {
		return _esfGun.getCode();
	}

	/**
	* Sets the code of this e s f gun.
	*
	* @param code the code of this e s f gun
	*/
	@Override
	public void setCode(java.lang.String code) {
		_esfGun.setCode(code);
	}

	/**
	* Returns the esf gun kind ID of this e s f gun.
	*
	* @return the esf gun kind ID of this e s f gun
	*/
	@Override
	public long getEsfGunKindId() {
		return _esfGun.getEsfGunKindId();
	}

	/**
	* Sets the esf gun kind ID of this e s f gun.
	*
	* @param esfGunKindId the esf gun kind ID of this e s f gun
	*/
	@Override
	public void setEsfGunKindId(long esfGunKindId) {
		_esfGun.setEsfGunKindId(esfGunKindId);
	}

	/**
	* Returns the esf organization ID of this e s f gun.
	*
	* @return the esf organization ID of this e s f gun
	*/
	@Override
	public long getEsfOrganizationId() {
		return _esfGun.getEsfOrganizationId();
	}

	/**
	* Sets the esf organization ID of this e s f gun.
	*
	* @param esfOrganizationId the esf organization ID of this e s f gun
	*/
	@Override
	public void setEsfOrganizationId(long esfOrganizationId) {
		_esfGun.setEsfOrganizationId(esfOrganizationId);
	}

	@Override
	public boolean isNew() {
		return _esfGun.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfGun.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfGun.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfGun.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfGun.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfGun.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfGun.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfGun.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfGun.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfGun.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfGun.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFGunWrapper((ESFGun)_esfGun.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFGun esfGun) {
		return _esfGun.compareTo(esfGun);
	}

	@Override
	public int hashCode() {
		return _esfGun.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFGun> toCacheModel() {
		return _esfGun.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFGun toEscapedModel() {
		return new ESFGunWrapper(_esfGun.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFGun toUnescapedModel() {
		return new ESFGunWrapper(_esfGun.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfGun.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfGun.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfGun.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFGunWrapper)) {
			return false;
		}

		ESFGunWrapper esfGunWrapper = (ESFGunWrapper)obj;

		if (Validator.equals(_esfGun, esfGunWrapper._esfGun)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _esfGun.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFGun getWrappedESFGun() {
		return _esfGun;
	}

	@Override
	public ESFGun getWrappedModel() {
		return _esfGun;
	}

	@Override
	public void resetOriginalValues() {
		_esfGun.resetOriginalValues();
	}

	private ESFGun _esfGun;
}