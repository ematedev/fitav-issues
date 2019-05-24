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
 * This class is a wrapper for {@link ESFShooterQualificationESFTournament}.
 * </p>
 *
 * @author Ethica
 * @see ESFShooterQualificationESFTournament
 * @generated
 */
public class ESFShooterQualificationESFTournamentWrapper
	implements ESFShooterQualificationESFTournament,
		ModelWrapper<ESFShooterQualificationESFTournament> {
	public ESFShooterQualificationESFTournamentWrapper(
		ESFShooterQualificationESFTournament esfShooterQualificationESFTournament) {
		_esfShooterQualificationESFTournament = esfShooterQualificationESFTournament;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFShooterQualificationESFTournament.class;
	}

	@Override
	public String getModelClassName() {
		return ESFShooterQualificationESFTournament.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfShooterQualificationId",
			getEsfShooterQualificationId());
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

		Long esfShooterQualificationId = (Long)attributes.get(
				"esfShooterQualificationId");

		if (esfShooterQualificationId != null) {
			setEsfShooterQualificationId(esfShooterQualificationId);
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
	* Returns the primary key of this e s f shooter qualification e s f tournament.
	*
	* @return the primary key of this e s f shooter qualification e s f tournament
	*/
	@Override
	public it.ethica.esf.service.persistence.ESFShooterQualificationESFTournamentPK getPrimaryKey() {
		return _esfShooterQualificationESFTournament.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f shooter qualification e s f tournament.
	*
	* @param primaryKey the primary key of this e s f shooter qualification e s f tournament
	*/
	@Override
	public void setPrimaryKey(
		it.ethica.esf.service.persistence.ESFShooterQualificationESFTournamentPK primaryKey) {
		_esfShooterQualificationESFTournament.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this e s f shooter qualification e s f tournament.
	*
	* @return the uuid of this e s f shooter qualification e s f tournament
	*/
	@Override
	public java.lang.String getUuid() {
		return _esfShooterQualificationESFTournament.getUuid();
	}

	/**
	* Sets the uuid of this e s f shooter qualification e s f tournament.
	*
	* @param uuid the uuid of this e s f shooter qualification e s f tournament
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_esfShooterQualificationESFTournament.setUuid(uuid);
	}

	/**
	* Returns the esf shooter qualification ID of this e s f shooter qualification e s f tournament.
	*
	* @return the esf shooter qualification ID of this e s f shooter qualification e s f tournament
	*/
	@Override
	public long getEsfShooterQualificationId() {
		return _esfShooterQualificationESFTournament.getEsfShooterQualificationId();
	}

	/**
	* Sets the esf shooter qualification ID of this e s f shooter qualification e s f tournament.
	*
	* @param esfShooterQualificationId the esf shooter qualification ID of this e s f shooter qualification e s f tournament
	*/
	@Override
	public void setEsfShooterQualificationId(long esfShooterQualificationId) {
		_esfShooterQualificationESFTournament.setEsfShooterQualificationId(esfShooterQualificationId);
	}

	/**
	* Returns the esf tournament ID of this e s f shooter qualification e s f tournament.
	*
	* @return the esf tournament ID of this e s f shooter qualification e s f tournament
	*/
	@Override
	public long getEsfTournamentId() {
		return _esfShooterQualificationESFTournament.getEsfTournamentId();
	}

	/**
	* Sets the esf tournament ID of this e s f shooter qualification e s f tournament.
	*
	* @param esfTournamentId the esf tournament ID of this e s f shooter qualification e s f tournament
	*/
	@Override
	public void setEsfTournamentId(long esfTournamentId) {
		_esfShooterQualificationESFTournament.setEsfTournamentId(esfTournamentId);
	}

	/**
	* Returns the group ID of this e s f shooter qualification e s f tournament.
	*
	* @return the group ID of this e s f shooter qualification e s f tournament
	*/
	@Override
	public long getGroupId() {
		return _esfShooterQualificationESFTournament.getGroupId();
	}

	/**
	* Sets the group ID of this e s f shooter qualification e s f tournament.
	*
	* @param groupId the group ID of this e s f shooter qualification e s f tournament
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfShooterQualificationESFTournament.setGroupId(groupId);
	}

	@Override
	public boolean isNew() {
		return _esfShooterQualificationESFTournament.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfShooterQualificationESFTournament.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfShooterQualificationESFTournament.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfShooterQualificationESFTournament.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfShooterQualificationESFTournament.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfShooterQualificationESFTournament.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfShooterQualificationESFTournament.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfShooterQualificationESFTournament.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfShooterQualificationESFTournament.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfShooterQualificationESFTournament.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfShooterQualificationESFTournament.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFShooterQualificationESFTournamentWrapper((ESFShooterQualificationESFTournament)_esfShooterQualificationESFTournament.clone());
	}

	@Override
	public int compareTo(
		it.ethica.esf.model.ESFShooterQualificationESFTournament esfShooterQualificationESFTournament) {
		return _esfShooterQualificationESFTournament.compareTo(esfShooterQualificationESFTournament);
	}

	@Override
	public int hashCode() {
		return _esfShooterQualificationESFTournament.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFShooterQualificationESFTournament> toCacheModel() {
		return _esfShooterQualificationESFTournament.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFShooterQualificationESFTournament toEscapedModel() {
		return new ESFShooterQualificationESFTournamentWrapper(_esfShooterQualificationESFTournament.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFShooterQualificationESFTournament toUnescapedModel() {
		return new ESFShooterQualificationESFTournamentWrapper(_esfShooterQualificationESFTournament.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfShooterQualificationESFTournament.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfShooterQualificationESFTournament.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFShooterQualificationESFTournamentWrapper)) {
			return false;
		}

		ESFShooterQualificationESFTournamentWrapper esfShooterQualificationESFTournamentWrapper =
			(ESFShooterQualificationESFTournamentWrapper)obj;

		if (Validator.equals(_esfShooterQualificationESFTournament,
					esfShooterQualificationESFTournamentWrapper._esfShooterQualificationESFTournament)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFShooterQualificationESFTournament getWrappedESFShooterQualificationESFTournament() {
		return _esfShooterQualificationESFTournament;
	}

	@Override
	public ESFShooterQualificationESFTournament getWrappedModel() {
		return _esfShooterQualificationESFTournament;
	}

	@Override
	public void resetOriginalValues() {
		_esfShooterQualificationESFTournament.resetOriginalValues();
	}

	private ESFShooterQualificationESFTournament _esfShooterQualificationESFTournament;
}