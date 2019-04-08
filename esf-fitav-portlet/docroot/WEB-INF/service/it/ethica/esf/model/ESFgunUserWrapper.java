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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ESFgunUser}.
 * </p>
 *
 * @author Ethica
 * @see ESFgunUser
 * @generated
 */
public class ESFgunUserWrapper implements ESFgunUser, ModelWrapper<ESFgunUser> {
	public ESFgunUserWrapper(ESFgunUser esFgunUser) {
		_esFgunUser = esFgunUser;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFgunUser.class;
	}

	@Override
	public String getModelClassName() {
		return ESFgunUser.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfGunUserId", getEsfGunUserId());
		attributes.put("esfGunId", getEsfGunId());
		attributes.put("esfUserId", getEsfUserId());
		attributes.put("code", getCode());
		attributes.put("isFavorite", getIsFavorite());
		attributes.put("type", getType());
		attributes.put("note", getNote());
		attributes.put("esfGunnTypeId", getEsfGunnTypeId());
		attributes.put("esfGunKindId", getEsfGunKindId());
		attributes.put("typeId", getTypeId());
		attributes.put("esfMeasures", getEsfMeasures());
		attributes.put("esfCaliber", getEsfCaliber());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfGunUserId = (Long)attributes.get("esfGunUserId");

		if (esfGunUserId != null) {
			setEsfGunUserId(esfGunUserId);
		}

		Long esfGunId = (Long)attributes.get("esfGunId");

		if (esfGunId != null) {
			setEsfGunId(esfGunId);
		}

		Long esfUserId = (Long)attributes.get("esfUserId");

		if (esfUserId != null) {
			setEsfUserId(esfUserId);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		Boolean isFavorite = (Boolean)attributes.get("isFavorite");

		if (isFavorite != null) {
			setIsFavorite(isFavorite);
		}

		Integer type = (Integer)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		Long esfGunnTypeId = (Long)attributes.get("esfGunnTypeId");

		if (esfGunnTypeId != null) {
			setEsfGunnTypeId(esfGunnTypeId);
		}

		Long esfGunKindId = (Long)attributes.get("esfGunKindId");

		if (esfGunKindId != null) {
			setEsfGunKindId(esfGunKindId);
		}

		Long typeId = (Long)attributes.get("typeId");

		if (typeId != null) {
			setTypeId(typeId);
		}

		String esfMeasures = (String)attributes.get("esfMeasures");

		if (esfMeasures != null) {
			setEsfMeasures(esfMeasures);
		}

		String esfCaliber = (String)attributes.get("esfCaliber");

		if (esfCaliber != null) {
			setEsfCaliber(esfCaliber);
		}
	}

	/**
	* Returns the primary key of this e s fgun user.
	*
	* @return the primary key of this e s fgun user
	*/
	@Override
	public long getPrimaryKey() {
		return _esFgunUser.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s fgun user.
	*
	* @param primaryKey the primary key of this e s fgun user
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esFgunUser.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf gun user ID of this e s fgun user.
	*
	* @return the esf gun user ID of this e s fgun user
	*/
	@Override
	public long getEsfGunUserId() {
		return _esFgunUser.getEsfGunUserId();
	}

	/**
	* Sets the esf gun user ID of this e s fgun user.
	*
	* @param esfGunUserId the esf gun user ID of this e s fgun user
	*/
	@Override
	public void setEsfGunUserId(long esfGunUserId) {
		_esFgunUser.setEsfGunUserId(esfGunUserId);
	}

	/**
	* Returns the esf gun user uuid of this e s fgun user.
	*
	* @return the esf gun user uuid of this e s fgun user
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getEsfGunUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esFgunUser.getEsfGunUserUuid();
	}

	/**
	* Sets the esf gun user uuid of this e s fgun user.
	*
	* @param esfGunUserUuid the esf gun user uuid of this e s fgun user
	*/
	@Override
	public void setEsfGunUserUuid(java.lang.String esfGunUserUuid) {
		_esFgunUser.setEsfGunUserUuid(esfGunUserUuid);
	}

	/**
	* Returns the esf gun ID of this e s fgun user.
	*
	* @return the esf gun ID of this e s fgun user
	*/
	@Override
	public long getEsfGunId() {
		return _esFgunUser.getEsfGunId();
	}

	/**
	* Sets the esf gun ID of this e s fgun user.
	*
	* @param esfGunId the esf gun ID of this e s fgun user
	*/
	@Override
	public void setEsfGunId(long esfGunId) {
		_esFgunUser.setEsfGunId(esfGunId);
	}

	/**
	* Returns the esf user ID of this e s fgun user.
	*
	* @return the esf user ID of this e s fgun user
	*/
	@Override
	public long getEsfUserId() {
		return _esFgunUser.getEsfUserId();
	}

	/**
	* Sets the esf user ID of this e s fgun user.
	*
	* @param esfUserId the esf user ID of this e s fgun user
	*/
	@Override
	public void setEsfUserId(long esfUserId) {
		_esFgunUser.setEsfUserId(esfUserId);
	}

	/**
	* Returns the esf user uuid of this e s fgun user.
	*
	* @return the esf user uuid of this e s fgun user
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getEsfUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esFgunUser.getEsfUserUuid();
	}

	/**
	* Sets the esf user uuid of this e s fgun user.
	*
	* @param esfUserUuid the esf user uuid of this e s fgun user
	*/
	@Override
	public void setEsfUserUuid(java.lang.String esfUserUuid) {
		_esFgunUser.setEsfUserUuid(esfUserUuid);
	}

	/**
	* Returns the code of this e s fgun user.
	*
	* @return the code of this e s fgun user
	*/
	@Override
	public java.lang.String getCode() {
		return _esFgunUser.getCode();
	}

	/**
	* Sets the code of this e s fgun user.
	*
	* @param code the code of this e s fgun user
	*/
	@Override
	public void setCode(java.lang.String code) {
		_esFgunUser.setCode(code);
	}

	/**
	* Returns the is favorite of this e s fgun user.
	*
	* @return the is favorite of this e s fgun user
	*/
	@Override
	public boolean getIsFavorite() {
		return _esFgunUser.getIsFavorite();
	}

	/**
	* Returns <code>true</code> if this e s fgun user is is favorite.
	*
	* @return <code>true</code> if this e s fgun user is is favorite; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsFavorite() {
		return _esFgunUser.isIsFavorite();
	}

	/**
	* Sets whether this e s fgun user is is favorite.
	*
	* @param isFavorite the is favorite of this e s fgun user
	*/
	@Override
	public void setIsFavorite(boolean isFavorite) {
		_esFgunUser.setIsFavorite(isFavorite);
	}

	/**
	* Returns the type of this e s fgun user.
	*
	* @return the type of this e s fgun user
	*/
	@Override
	public int getType() {
		return _esFgunUser.getType();
	}

	/**
	* Sets the type of this e s fgun user.
	*
	* @param type the type of this e s fgun user
	*/
	@Override
	public void setType(int type) {
		_esFgunUser.setType(type);
	}

	/**
	* Returns the note of this e s fgun user.
	*
	* @return the note of this e s fgun user
	*/
	@Override
	public java.lang.String getNote() {
		return _esFgunUser.getNote();
	}

	/**
	* Sets the note of this e s fgun user.
	*
	* @param note the note of this e s fgun user
	*/
	@Override
	public void setNote(java.lang.String note) {
		_esFgunUser.setNote(note);
	}

	/**
	* Returns the esf gunn type ID of this e s fgun user.
	*
	* @return the esf gunn type ID of this e s fgun user
	*/
	@Override
	public long getEsfGunnTypeId() {
		return _esFgunUser.getEsfGunnTypeId();
	}

	/**
	* Sets the esf gunn type ID of this e s fgun user.
	*
	* @param esfGunnTypeId the esf gunn type ID of this e s fgun user
	*/
	@Override
	public void setEsfGunnTypeId(long esfGunnTypeId) {
		_esFgunUser.setEsfGunnTypeId(esfGunnTypeId);
	}

	/**
	* Returns the esf gun kind ID of this e s fgun user.
	*
	* @return the esf gun kind ID of this e s fgun user
	*/
	@Override
	public long getEsfGunKindId() {
		return _esFgunUser.getEsfGunKindId();
	}

	/**
	* Sets the esf gun kind ID of this e s fgun user.
	*
	* @param esfGunKindId the esf gun kind ID of this e s fgun user
	*/
	@Override
	public void setEsfGunKindId(long esfGunKindId) {
		_esFgunUser.setEsfGunKindId(esfGunKindId);
	}

	/**
	* Returns the type ID of this e s fgun user.
	*
	* @return the type ID of this e s fgun user
	*/
	@Override
	public long getTypeId() {
		return _esFgunUser.getTypeId();
	}

	/**
	* Sets the type ID of this e s fgun user.
	*
	* @param typeId the type ID of this e s fgun user
	*/
	@Override
	public void setTypeId(long typeId) {
		_esFgunUser.setTypeId(typeId);
	}

	/**
	* Returns the esf measures of this e s fgun user.
	*
	* @return the esf measures of this e s fgun user
	*/
	@Override
	public java.lang.String getEsfMeasures() {
		return _esFgunUser.getEsfMeasures();
	}

	/**
	* Sets the esf measures of this e s fgun user.
	*
	* @param esfMeasures the esf measures of this e s fgun user
	*/
	@Override
	public void setEsfMeasures(java.lang.String esfMeasures) {
		_esFgunUser.setEsfMeasures(esfMeasures);
	}

	/**
	* Returns the esf caliber of this e s fgun user.
	*
	* @return the esf caliber of this e s fgun user
	*/
	@Override
	public java.lang.String getEsfCaliber() {
		return _esFgunUser.getEsfCaliber();
	}

	/**
	* Sets the esf caliber of this e s fgun user.
	*
	* @param esfCaliber the esf caliber of this e s fgun user
	*/
	@Override
	public void setEsfCaliber(java.lang.String esfCaliber) {
		_esFgunUser.setEsfCaliber(esfCaliber);
	}

	@Override
	public boolean isNew() {
		return _esFgunUser.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esFgunUser.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esFgunUser.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esFgunUser.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esFgunUser.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esFgunUser.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esFgunUser.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esFgunUser.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esFgunUser.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esFgunUser.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esFgunUser.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFgunUserWrapper((ESFgunUser)_esFgunUser.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFgunUser esFgunUser) {
		return _esFgunUser.compareTo(esFgunUser);
	}

	@Override
	public int hashCode() {
		return _esFgunUser.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFgunUser> toCacheModel() {
		return _esFgunUser.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFgunUser toEscapedModel() {
		return new ESFgunUserWrapper(_esFgunUser.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFgunUser toUnescapedModel() {
		return new ESFgunUserWrapper(_esFgunUser.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esFgunUser.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esFgunUser.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esFgunUser.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFgunUserWrapper)) {
			return false;
		}

		ESFgunUserWrapper esFgunUserWrapper = (ESFgunUserWrapper)obj;

		if (Validator.equals(_esFgunUser, esFgunUserWrapper._esFgunUser)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFgunUser getWrappedESFgunUser() {
		return _esFgunUser;
	}

	@Override
	public ESFgunUser getWrappedModel() {
		return _esFgunUser;
	}

	@Override
	public void resetOriginalValues() {
		_esFgunUser.resetOriginalValues();
	}

	private ESFgunUser _esFgunUser;
}