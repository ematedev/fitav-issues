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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ESFUser}.
 * </p>
 *
 * @author Ethica
 * @see ESFUser
 * @generated
 */
public class ESFUserWrapper implements ESFUser, ModelWrapper<ESFUser> {
	public ESFUserWrapper(ESFUser esfUser) {
		_esfUser = esfUser;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFUser.class;
	}

	@Override
	public String getModelClassName() {
		return ESFUser.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfUserId", getEsfUserId());
		attributes.put("code", getCode());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfUserId = (Long)attributes.get("esfUserId");

		if (esfUserId != null) {
			setEsfUserId(esfUserId);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}
	}

	/**
	* Returns the primary key of this e s f user.
	*
	* @return the primary key of this e s f user
	*/
	@Override
	public long getPrimaryKey() {
		return _esfUser.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f user.
	*
	* @param primaryKey the primary key of this e s f user
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfUser.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this e s f user.
	*
	* @return the uuid of this e s f user
	*/
	@Override
	public java.lang.String getUuid() {
		return _esfUser.getUuid();
	}

	/**
	* Sets the uuid of this e s f user.
	*
	* @param uuid the uuid of this e s f user
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_esfUser.setUuid(uuid);
	}

	/**
	* Returns the esf user ID of this e s f user.
	*
	* @return the esf user ID of this e s f user
	*/
	@Override
	public long getEsfUserId() {
		return _esfUser.getEsfUserId();
	}

	/**
	* Sets the esf user ID of this e s f user.
	*
	* @param esfUserId the esf user ID of this e s f user
	*/
	@Override
	public void setEsfUserId(long esfUserId) {
		_esfUser.setEsfUserId(esfUserId);
	}

	/**
	* Returns the esf user uuid of this e s f user.
	*
	* @return the esf user uuid of this e s f user
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getEsfUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfUser.getEsfUserUuid();
	}

	/**
	* Sets the esf user uuid of this e s f user.
	*
	* @param esfUserUuid the esf user uuid of this e s f user
	*/
	@Override
	public void setEsfUserUuid(java.lang.String esfUserUuid) {
		_esfUser.setEsfUserUuid(esfUserUuid);
	}

	/**
	* Returns the code of this e s f user.
	*
	* @return the code of this e s f user
	*/
	@Override
	public java.lang.String getCode() {
		return _esfUser.getCode();
	}

	/**
	* Sets the code of this e s f user.
	*
	* @param code the code of this e s f user
	*/
	@Override
	public void setCode(java.lang.String code) {
		_esfUser.setCode(code);
	}

	@Override
	public boolean isNew() {
		return _esfUser.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfUser.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfUser.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfUser.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfUser.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfUser.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfUser.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfUser.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfUser.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfUser.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfUser.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFUserWrapper((ESFUser)_esfUser.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFUser esfUser) {
		return _esfUser.compareTo(esfUser);
	}

	@Override
	public int hashCode() {
		return _esfUser.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFUser> toCacheModel() {
		return _esfUser.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFUser toEscapedModel() {
		return new ESFUserWrapper(_esfUser.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFUser toUnescapedModel() {
		return new ESFUserWrapper(_esfUser.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfUser.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfUser.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfUser.persist();
	}

	@Override
	public com.liferay.portal.model.User getOriginalUser()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUser.getOriginalUser();
	}

	@Override
	public java.lang.String getUserEmail()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUser.getUserEmail();
	}

	@Override
	public java.util.Date getBirthday()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUser.getBirthday();
	}

	@Override
	public java.lang.String getFirstName()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUser.getFirstName();
	}

	@Override
	public java.lang.String getLastName()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUser.getLastName();
	}

	@Override
	public java.lang.String getScreenName()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUser.getScreenName();
	}

	@Override
	public boolean getMale()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUser.getMale();
	}

	@Override
	public java.lang.String getJobTitle()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUser.getJobTitle();
	}

	@Override
	public long getCompanyId()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _esfUser.getCompanyId();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFUserWrapper)) {
			return false;
		}

		ESFUserWrapper esfUserWrapper = (ESFUserWrapper)obj;

		if (Validator.equals(_esfUser, esfUserWrapper._esfUser)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFUser getWrappedESFUser() {
		return _esfUser;
	}

	@Override
	public ESFUser getWrappedModel() {
		return _esfUser;
	}

	@Override
	public void resetOriginalValues() {
		_esfUser.resetOriginalValues();
	}

	private ESFUser _esfUser;
}