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
 * This class is a wrapper for {@link ESFTransition}.
 * </p>
 *
 * @author Ethica
 * @see ESFTransition
 * @generated
 */
public class ESFTransitionWrapper implements ESFTransition,
	ModelWrapper<ESFTransition> {
	public ESFTransitionWrapper(ESFTransition esfTransition) {
		_esfTransition = esfTransition;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFTransition.class;
	}

	@Override
	public String getModelClassName() {
		return ESFTransition.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfTransitionId", getEsfTransitionId());
		attributes.put("esfUserId", getEsfUserId());
		attributes.put("esfCategoryId", getEsfCategoryId());
		attributes.put("season", getSeason());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfTransitionId = (Long)attributes.get("esfTransitionId");

		if (esfTransitionId != null) {
			setEsfTransitionId(esfTransitionId);
		}

		Long esfUserId = (Long)attributes.get("esfUserId");

		if (esfUserId != null) {
			setEsfUserId(esfUserId);
		}

		Long esfCategoryId = (Long)attributes.get("esfCategoryId");

		if (esfCategoryId != null) {
			setEsfCategoryId(esfCategoryId);
		}

		String season = (String)attributes.get("season");

		if (season != null) {
			setSeason(season);
		}
	}

	/**
	* Returns the primary key of this e s f transition.
	*
	* @return the primary key of this e s f transition
	*/
	@Override
	public long getPrimaryKey() {
		return _esfTransition.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f transition.
	*
	* @param primaryKey the primary key of this e s f transition
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfTransition.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf transition ID of this e s f transition.
	*
	* @return the esf transition ID of this e s f transition
	*/
	@Override
	public long getEsfTransitionId() {
		return _esfTransition.getEsfTransitionId();
	}

	/**
	* Sets the esf transition ID of this e s f transition.
	*
	* @param esfTransitionId the esf transition ID of this e s f transition
	*/
	@Override
	public void setEsfTransitionId(long esfTransitionId) {
		_esfTransition.setEsfTransitionId(esfTransitionId);
	}

	/**
	* Returns the esf user ID of this e s f transition.
	*
	* @return the esf user ID of this e s f transition
	*/
	@Override
	public long getEsfUserId() {
		return _esfTransition.getEsfUserId();
	}

	/**
	* Sets the esf user ID of this e s f transition.
	*
	* @param esfUserId the esf user ID of this e s f transition
	*/
	@Override
	public void setEsfUserId(long esfUserId) {
		_esfTransition.setEsfUserId(esfUserId);
	}

	/**
	* Returns the esf user uuid of this e s f transition.
	*
	* @return the esf user uuid of this e s f transition
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getEsfUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfTransition.getEsfUserUuid();
	}

	/**
	* Sets the esf user uuid of this e s f transition.
	*
	* @param esfUserUuid the esf user uuid of this e s f transition
	*/
	@Override
	public void setEsfUserUuid(java.lang.String esfUserUuid) {
		_esfTransition.setEsfUserUuid(esfUserUuid);
	}

	/**
	* Returns the esf category ID of this e s f transition.
	*
	* @return the esf category ID of this e s f transition
	*/
	@Override
	public long getEsfCategoryId() {
		return _esfTransition.getEsfCategoryId();
	}

	/**
	* Sets the esf category ID of this e s f transition.
	*
	* @param esfCategoryId the esf category ID of this e s f transition
	*/
	@Override
	public void setEsfCategoryId(long esfCategoryId) {
		_esfTransition.setEsfCategoryId(esfCategoryId);
	}

	/**
	* Returns the season of this e s f transition.
	*
	* @return the season of this e s f transition
	*/
	@Override
	public java.lang.String getSeason() {
		return _esfTransition.getSeason();
	}

	/**
	* Sets the season of this e s f transition.
	*
	* @param season the season of this e s f transition
	*/
	@Override
	public void setSeason(java.lang.String season) {
		_esfTransition.setSeason(season);
	}

	@Override
	public boolean isNew() {
		return _esfTransition.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfTransition.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfTransition.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfTransition.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfTransition.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfTransition.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfTransition.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfTransition.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfTransition.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfTransition.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfTransition.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFTransitionWrapper((ESFTransition)_esfTransition.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFTransition esfTransition) {
		return _esfTransition.compareTo(esfTransition);
	}

	@Override
	public int hashCode() {
		return _esfTransition.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFTransition> toCacheModel() {
		return _esfTransition.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFTransition toEscapedModel() {
		return new ESFTransitionWrapper(_esfTransition.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFTransition toUnescapedModel() {
		return new ESFTransitionWrapper(_esfTransition.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfTransition.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfTransition.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfTransition.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFTransitionWrapper)) {
			return false;
		}

		ESFTransitionWrapper esfTransitionWrapper = (ESFTransitionWrapper)obj;

		if (Validator.equals(_esfTransition, esfTransitionWrapper._esfTransition)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFTransition getWrappedESFTransition() {
		return _esfTransition;
	}

	@Override
	public ESFTransition getWrappedModel() {
		return _esfTransition;
	}

	@Override
	public void resetOriginalValues() {
		_esfTransition.resetOriginalValues();
	}

	private ESFTransition _esfTransition;
}