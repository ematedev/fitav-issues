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
 * This class is a wrapper for {@link ESFCatridge}.
 * </p>
 *
 * @author Ethica
 * @see ESFCatridge
 * @generated
 */
public class ESFCatridgeWrapper implements ESFCatridge,
	ModelWrapper<ESFCatridge> {
	public ESFCatridgeWrapper(ESFCatridge esfCatridge) {
		_esfCatridge = esfCatridge;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFCatridge.class;
	}

	@Override
	public String getModelClassName() {
		return ESFCatridge.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfCatridgeId", getEsfCatridgeId());
		attributes.put("esfUserId", getEsfUserId());
		attributes.put("esfGunTypeId", getEsfGunTypeId());
		attributes.put("catridgeModel", getCatridgeModel());
		attributes.put("catridgeCaliber", getCatridgeCaliber());
		attributes.put("note", getNote());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfCatridgeId = (Long)attributes.get("esfCatridgeId");

		if (esfCatridgeId != null) {
			setEsfCatridgeId(esfCatridgeId);
		}

		Long esfUserId = (Long)attributes.get("esfUserId");

		if (esfUserId != null) {
			setEsfUserId(esfUserId);
		}

		Long esfGunTypeId = (Long)attributes.get("esfGunTypeId");

		if (esfGunTypeId != null) {
			setEsfGunTypeId(esfGunTypeId);
		}

		String catridgeModel = (String)attributes.get("catridgeModel");

		if (catridgeModel != null) {
			setCatridgeModel(catridgeModel);
		}

		Long catridgeCaliber = (Long)attributes.get("catridgeCaliber");

		if (catridgeCaliber != null) {
			setCatridgeCaliber(catridgeCaliber);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}
	}

	/**
	* Returns the primary key of this e s f catridge.
	*
	* @return the primary key of this e s f catridge
	*/
	@Override
	public long getPrimaryKey() {
		return _esfCatridge.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f catridge.
	*
	* @param primaryKey the primary key of this e s f catridge
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfCatridge.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this e s f catridge.
	*
	* @return the uuid of this e s f catridge
	*/
	@Override
	public java.lang.String getUuid() {
		return _esfCatridge.getUuid();
	}

	/**
	* Sets the uuid of this e s f catridge.
	*
	* @param uuid the uuid of this e s f catridge
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_esfCatridge.setUuid(uuid);
	}

	/**
	* Returns the esf catridge ID of this e s f catridge.
	*
	* @return the esf catridge ID of this e s f catridge
	*/
	@Override
	public long getEsfCatridgeId() {
		return _esfCatridge.getEsfCatridgeId();
	}

	/**
	* Sets the esf catridge ID of this e s f catridge.
	*
	* @param esfCatridgeId the esf catridge ID of this e s f catridge
	*/
	@Override
	public void setEsfCatridgeId(long esfCatridgeId) {
		_esfCatridge.setEsfCatridgeId(esfCatridgeId);
	}

	/**
	* Returns the esf user ID of this e s f catridge.
	*
	* @return the esf user ID of this e s f catridge
	*/
	@Override
	public long getEsfUserId() {
		return _esfCatridge.getEsfUserId();
	}

	/**
	* Sets the esf user ID of this e s f catridge.
	*
	* @param esfUserId the esf user ID of this e s f catridge
	*/
	@Override
	public void setEsfUserId(long esfUserId) {
		_esfCatridge.setEsfUserId(esfUserId);
	}

	/**
	* Returns the esf user uuid of this e s f catridge.
	*
	* @return the esf user uuid of this e s f catridge
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getEsfUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfCatridge.getEsfUserUuid();
	}

	/**
	* Sets the esf user uuid of this e s f catridge.
	*
	* @param esfUserUuid the esf user uuid of this e s f catridge
	*/
	@Override
	public void setEsfUserUuid(java.lang.String esfUserUuid) {
		_esfCatridge.setEsfUserUuid(esfUserUuid);
	}

	/**
	* Returns the esf gun type ID of this e s f catridge.
	*
	* @return the esf gun type ID of this e s f catridge
	*/
	@Override
	public long getEsfGunTypeId() {
		return _esfCatridge.getEsfGunTypeId();
	}

	/**
	* Sets the esf gun type ID of this e s f catridge.
	*
	* @param esfGunTypeId the esf gun type ID of this e s f catridge
	*/
	@Override
	public void setEsfGunTypeId(long esfGunTypeId) {
		_esfCatridge.setEsfGunTypeId(esfGunTypeId);
	}

	/**
	* Returns the catridge model of this e s f catridge.
	*
	* @return the catridge model of this e s f catridge
	*/
	@Override
	public java.lang.String getCatridgeModel() {
		return _esfCatridge.getCatridgeModel();
	}

	/**
	* Sets the catridge model of this e s f catridge.
	*
	* @param catridgeModel the catridge model of this e s f catridge
	*/
	@Override
	public void setCatridgeModel(java.lang.String catridgeModel) {
		_esfCatridge.setCatridgeModel(catridgeModel);
	}

	/**
	* Returns the catridge caliber of this e s f catridge.
	*
	* @return the catridge caliber of this e s f catridge
	*/
	@Override
	public long getCatridgeCaliber() {
		return _esfCatridge.getCatridgeCaliber();
	}

	/**
	* Sets the catridge caliber of this e s f catridge.
	*
	* @param catridgeCaliber the catridge caliber of this e s f catridge
	*/
	@Override
	public void setCatridgeCaliber(long catridgeCaliber) {
		_esfCatridge.setCatridgeCaliber(catridgeCaliber);
	}

	/**
	* Returns the note of this e s f catridge.
	*
	* @return the note of this e s f catridge
	*/
	@Override
	public java.lang.String getNote() {
		return _esfCatridge.getNote();
	}

	/**
	* Sets the note of this e s f catridge.
	*
	* @param note the note of this e s f catridge
	*/
	@Override
	public void setNote(java.lang.String note) {
		_esfCatridge.setNote(note);
	}

	@Override
	public boolean isNew() {
		return _esfCatridge.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfCatridge.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfCatridge.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfCatridge.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfCatridge.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfCatridge.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfCatridge.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfCatridge.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfCatridge.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfCatridge.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfCatridge.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFCatridgeWrapper((ESFCatridge)_esfCatridge.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFCatridge esfCatridge) {
		return _esfCatridge.compareTo(esfCatridge);
	}

	@Override
	public int hashCode() {
		return _esfCatridge.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFCatridge> toCacheModel() {
		return _esfCatridge.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFCatridge toEscapedModel() {
		return new ESFCatridgeWrapper(_esfCatridge.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFCatridge toUnescapedModel() {
		return new ESFCatridgeWrapper(_esfCatridge.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfCatridge.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfCatridge.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfCatridge.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFCatridgeWrapper)) {
			return false;
		}

		ESFCatridgeWrapper esfCatridgeWrapper = (ESFCatridgeWrapper)obj;

		if (Validator.equals(_esfCatridge, esfCatridgeWrapper._esfCatridge)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFCatridge getWrappedESFCatridge() {
		return _esfCatridge;
	}

	@Override
	public ESFCatridge getWrappedModel() {
		return _esfCatridge;
	}

	@Override
	public void resetOriginalValues() {
		_esfCatridge.resetOriginalValues();
	}

	private ESFCatridge _esfCatridge;
}