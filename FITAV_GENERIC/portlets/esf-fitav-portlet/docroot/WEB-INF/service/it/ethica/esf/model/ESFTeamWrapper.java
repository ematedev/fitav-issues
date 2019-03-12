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
 * This class is a wrapper for {@link ESFTeam}.
 * </p>
 *
 * @author Ethica
 * @see ESFTeam
 * @generated
 */
public class ESFTeamWrapper implements ESFTeam, ModelWrapper<ESFTeam> {
	public ESFTeamWrapper(ESFTeam esfTeam) {
		_esfTeam = esfTeam;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFTeam.class;
	}

	@Override
	public String getModelClassName() {
		return ESFTeam.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfTeamId", getEsfTeamId());
		attributes.put("esfTournamentId", getEsfTournamentId());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfTeamId = (Long)attributes.get("esfTeamId");

		if (esfTeamId != null) {
			setEsfTeamId(esfTeamId);
		}

		Long esfTournamentId = (Long)attributes.get("esfTournamentId");

		if (esfTournamentId != null) {
			setEsfTournamentId(esfTournamentId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	/**
	* Returns the primary key of this e s f team.
	*
	* @return the primary key of this e s f team
	*/
	@Override
	public long getPrimaryKey() {
		return _esfTeam.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f team.
	*
	* @param primaryKey the primary key of this e s f team
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfTeam.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf team ID of this e s f team.
	*
	* @return the esf team ID of this e s f team
	*/
	@Override
	public long getEsfTeamId() {
		return _esfTeam.getEsfTeamId();
	}

	/**
	* Sets the esf team ID of this e s f team.
	*
	* @param esfTeamId the esf team ID of this e s f team
	*/
	@Override
	public void setEsfTeamId(long esfTeamId) {
		_esfTeam.setEsfTeamId(esfTeamId);
	}

	/**
	* Returns the esf tournament ID of this e s f team.
	*
	* @return the esf tournament ID of this e s f team
	*/
	@Override
	public long getEsfTournamentId() {
		return _esfTeam.getEsfTournamentId();
	}

	/**
	* Sets the esf tournament ID of this e s f team.
	*
	* @param esfTournamentId the esf tournament ID of this e s f team
	*/
	@Override
	public void setEsfTournamentId(long esfTournamentId) {
		_esfTeam.setEsfTournamentId(esfTournamentId);
	}

	/**
	* Returns the name of this e s f team.
	*
	* @return the name of this e s f team
	*/
	@Override
	public java.lang.String getName() {
		return _esfTeam.getName();
	}

	/**
	* Sets the name of this e s f team.
	*
	* @param name the name of this e s f team
	*/
	@Override
	public void setName(java.lang.String name) {
		_esfTeam.setName(name);
	}

	@Override
	public boolean isNew() {
		return _esfTeam.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfTeam.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfTeam.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfTeam.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfTeam.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfTeam.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfTeam.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfTeam.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfTeam.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfTeam.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfTeam.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFTeamWrapper((ESFTeam)_esfTeam.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFTeam esfTeam) {
		return _esfTeam.compareTo(esfTeam);
	}

	@Override
	public int hashCode() {
		return _esfTeam.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFTeam> toCacheModel() {
		return _esfTeam.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFTeam toEscapedModel() {
		return new ESFTeamWrapper(_esfTeam.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFTeam toUnescapedModel() {
		return new ESFTeamWrapper(_esfTeam.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfTeam.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfTeam.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfTeam.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFTeamWrapper)) {
			return false;
		}

		ESFTeamWrapper esfTeamWrapper = (ESFTeamWrapper)obj;

		if (Validator.equals(_esfTeam, esfTeamWrapper._esfTeam)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFTeam getWrappedESFTeam() {
		return _esfTeam;
	}

	@Override
	public ESFTeam getWrappedModel() {
		return _esfTeam;
	}

	@Override
	public void resetOriginalValues() {
		_esfTeam.resetOriginalValues();
	}

	private ESFTeam _esfTeam;
}