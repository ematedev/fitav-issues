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
 * This class is a wrapper for {@link ESFShooterCategoryESFTournament}.
 * </p>
 *
 * @author Ethica
 * @see ESFShooterCategoryESFTournament
 * @generated
 */
public class ESFShooterCategoryESFTournamentWrapper
	implements ESFShooterCategoryESFTournament,
		ModelWrapper<ESFShooterCategoryESFTournament> {
	public ESFShooterCategoryESFTournamentWrapper(
		ESFShooterCategoryESFTournament esfShooterCategoryESFTournament) {
		_esfShooterCategoryESFTournament = esfShooterCategoryESFTournament;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFShooterCategoryESFTournament.class;
	}

	@Override
	public String getModelClassName() {
		return ESFShooterCategoryESFTournament.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfShooterCategoryId", getEsfShooterCategoryId());
		attributes.put("esfTournamentId", getEsfTournamentId());
		attributes.put("groupId", getGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfShooterCategoryId = (Long)attributes.get("esfShooterCategoryId");

		if (esfShooterCategoryId != null) {
			setEsfShooterCategoryId(esfShooterCategoryId);
		}

		Long esfTournamentId = (Long)attributes.get("esfTournamentId");

		if (esfTournamentId != null) {
			setEsfTournamentId(esfTournamentId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}
	}

	/**
	* Returns the primary key of this e s f shooter category e s f tournament.
	*
	* @return the primary key of this e s f shooter category e s f tournament
	*/
	@Override
	public it.ethica.esf.service.persistence.ESFShooterCategoryESFTournamentPK getPrimaryKey() {
		return _esfShooterCategoryESFTournament.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f shooter category e s f tournament.
	*
	* @param primaryKey the primary key of this e s f shooter category e s f tournament
	*/
	@Override
	public void setPrimaryKey(
		it.ethica.esf.service.persistence.ESFShooterCategoryESFTournamentPK primaryKey) {
		_esfShooterCategoryESFTournament.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this e s f shooter category e s f tournament.
	*
	* @return the uuid of this e s f shooter category e s f tournament
	*/
	@Override
	public java.lang.String getUuid() {
		return _esfShooterCategoryESFTournament.getUuid();
	}

	/**
	* Sets the uuid of this e s f shooter category e s f tournament.
	*
	* @param uuid the uuid of this e s f shooter category e s f tournament
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_esfShooterCategoryESFTournament.setUuid(uuid);
	}

	/**
	* Returns the esf shooter category ID of this e s f shooter category e s f tournament.
	*
	* @return the esf shooter category ID of this e s f shooter category e s f tournament
	*/
	@Override
	public long getEsfShooterCategoryId() {
		return _esfShooterCategoryESFTournament.getEsfShooterCategoryId();
	}

	/**
	* Sets the esf shooter category ID of this e s f shooter category e s f tournament.
	*
	* @param esfShooterCategoryId the esf shooter category ID of this e s f shooter category e s f tournament
	*/
	@Override
	public void setEsfShooterCategoryId(long esfShooterCategoryId) {
		_esfShooterCategoryESFTournament.setEsfShooterCategoryId(esfShooterCategoryId);
	}

	/**
	* Returns the esf tournament ID of this e s f shooter category e s f tournament.
	*
	* @return the esf tournament ID of this e s f shooter category e s f tournament
	*/
	@Override
	public long getEsfTournamentId() {
		return _esfShooterCategoryESFTournament.getEsfTournamentId();
	}

	/**
	* Sets the esf tournament ID of this e s f shooter category e s f tournament.
	*
	* @param esfTournamentId the esf tournament ID of this e s f shooter category e s f tournament
	*/
	@Override
	public void setEsfTournamentId(long esfTournamentId) {
		_esfShooterCategoryESFTournament.setEsfTournamentId(esfTournamentId);
	}

	/**
	* Returns the group ID of this e s f shooter category e s f tournament.
	*
	* @return the group ID of this e s f shooter category e s f tournament
	*/
	@Override
	public long getGroupId() {
		return _esfShooterCategoryESFTournament.getGroupId();
	}

	/**
	* Sets the group ID of this e s f shooter category e s f tournament.
	*
	* @param groupId the group ID of this e s f shooter category e s f tournament
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfShooterCategoryESFTournament.setGroupId(groupId);
	}

	@Override
	public boolean isNew() {
		return _esfShooterCategoryESFTournament.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfShooterCategoryESFTournament.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfShooterCategoryESFTournament.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfShooterCategoryESFTournament.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfShooterCategoryESFTournament.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfShooterCategoryESFTournament.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfShooterCategoryESFTournament.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfShooterCategoryESFTournament.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfShooterCategoryESFTournament.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfShooterCategoryESFTournament.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfShooterCategoryESFTournament.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFShooterCategoryESFTournamentWrapper((ESFShooterCategoryESFTournament)_esfShooterCategoryESFTournament.clone());
	}

	@Override
	public int compareTo(
		it.ethica.esf.model.ESFShooterCategoryESFTournament esfShooterCategoryESFTournament) {
		return _esfShooterCategoryESFTournament.compareTo(esfShooterCategoryESFTournament);
	}

	@Override
	public int hashCode() {
		return _esfShooterCategoryESFTournament.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFShooterCategoryESFTournament> toCacheModel() {
		return _esfShooterCategoryESFTournament.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFShooterCategoryESFTournament toEscapedModel() {
		return new ESFShooterCategoryESFTournamentWrapper(_esfShooterCategoryESFTournament.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFShooterCategoryESFTournament toUnescapedModel() {
		return new ESFShooterCategoryESFTournamentWrapper(_esfShooterCategoryESFTournament.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfShooterCategoryESFTournament.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfShooterCategoryESFTournament.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfShooterCategoryESFTournament.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFShooterCategoryESFTournamentWrapper)) {
			return false;
		}

		ESFShooterCategoryESFTournamentWrapper esfShooterCategoryESFTournamentWrapper =
			(ESFShooterCategoryESFTournamentWrapper)obj;

		if (Validator.equals(_esfShooterCategoryESFTournament,
					esfShooterCategoryESFTournamentWrapper._esfShooterCategoryESFTournament)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFShooterCategoryESFTournament getWrappedESFShooterCategoryESFTournament() {
		return _esfShooterCategoryESFTournament;
	}

	@Override
	public ESFShooterCategoryESFTournament getWrappedModel() {
		return _esfShooterCategoryESFTournament;
	}

	@Override
	public void resetOriginalValues() {
		_esfShooterCategoryESFTournament.resetOriginalValues();
	}

	private ESFShooterCategoryESFTournament _esfShooterCategoryESFTournament;
}