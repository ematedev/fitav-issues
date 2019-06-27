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
 * This class is a wrapper for {@link VW_Shooters}.
 * </p>
 *
 * @author Ethica
 * @see VW_Shooters
 * @generated
 */
public class VW_ShootersWrapper implements VW_Shooters,
	ModelWrapper<VW_Shooters> {
	public VW_ShootersWrapper(VW_Shooters vw_Shooters) {
		_vw_Shooters = vw_Shooters;
	}

	@Override
	public Class<?> getModelClass() {
		return VW_Shooters.class;
	}

	@Override
	public String getModelClassName() {
		return VW_Shooters.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("CodiceTessera", getCodiceTessera());
		attributes.put("CodiceOrganizzazione", getCodiceOrganizzazione());
		attributes.put("Nome", getNome());
		attributes.put("Cognome", getCognome());
		attributes.put("Email", getEmail());
		attributes.put("CF", getCF());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("invitato", getInvitato());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String CodiceTessera = (String)attributes.get("CodiceTessera");

		if (CodiceTessera != null) {
			setCodiceTessera(CodiceTessera);
		}

		String CodiceOrganizzazione = (String)attributes.get(
				"CodiceOrganizzazione");

		if (CodiceOrganizzazione != null) {
			setCodiceOrganizzazione(CodiceOrganizzazione);
		}

		String Nome = (String)attributes.get("Nome");

		if (Nome != null) {
			setNome(Nome);
		}

		String Cognome = (String)attributes.get("Cognome");

		if (Cognome != null) {
			setCognome(Cognome);
		}

		String Email = (String)attributes.get("Email");

		if (Email != null) {
			setEmail(Email);
		}

		String CF = (String)attributes.get("CF");

		if (CF != null) {
			setCF(CF);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		Integer invitato = (Integer)attributes.get("invitato");

		if (invitato != null) {
			setInvitato(invitato);
		}
	}

	/**
	* Returns the primary key of this v w_ shooters.
	*
	* @return the primary key of this v w_ shooters
	*/
	@Override
	public it.ethica.esf.service.persistence.VW_ShootersPK getPrimaryKey() {
		return _vw_Shooters.getPrimaryKey();
	}

	/**
	* Sets the primary key of this v w_ shooters.
	*
	* @param primaryKey the primary key of this v w_ shooters
	*/
	@Override
	public void setPrimaryKey(
		it.ethica.esf.service.persistence.VW_ShootersPK primaryKey) {
		_vw_Shooters.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the user ID of this v w_ shooters.
	*
	* @return the user ID of this v w_ shooters
	*/
	@Override
	public long getUserId() {
		return _vw_Shooters.getUserId();
	}

	/**
	* Sets the user ID of this v w_ shooters.
	*
	* @param userId the user ID of this v w_ shooters
	*/
	@Override
	public void setUserId(long userId) {
		_vw_Shooters.setUserId(userId);
	}

	/**
	* Returns the user uuid of this v w_ shooters.
	*
	* @return the user uuid of this v w_ shooters
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_Shooters.getUserUuid();
	}

	/**
	* Sets the user uuid of this v w_ shooters.
	*
	* @param userUuid the user uuid of this v w_ shooters
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_vw_Shooters.setUserUuid(userUuid);
	}

	/**
	* Returns the codice tessera of this v w_ shooters.
	*
	* @return the codice tessera of this v w_ shooters
	*/
	@Override
	public java.lang.String getCodiceTessera() {
		return _vw_Shooters.getCodiceTessera();
	}

	/**
	* Sets the codice tessera of this v w_ shooters.
	*
	* @param CodiceTessera the codice tessera of this v w_ shooters
	*/
	@Override
	public void setCodiceTessera(java.lang.String CodiceTessera) {
		_vw_Shooters.setCodiceTessera(CodiceTessera);
	}

	/**
	* Returns the codice organizzazione of this v w_ shooters.
	*
	* @return the codice organizzazione of this v w_ shooters
	*/
	@Override
	public java.lang.String getCodiceOrganizzazione() {
		return _vw_Shooters.getCodiceOrganizzazione();
	}

	/**
	* Sets the codice organizzazione of this v w_ shooters.
	*
	* @param CodiceOrganizzazione the codice organizzazione of this v w_ shooters
	*/
	@Override
	public void setCodiceOrganizzazione(java.lang.String CodiceOrganizzazione) {
		_vw_Shooters.setCodiceOrganizzazione(CodiceOrganizzazione);
	}

	/**
	* Returns the nome of this v w_ shooters.
	*
	* @return the nome of this v w_ shooters
	*/
	@Override
	public java.lang.String getNome() {
		return _vw_Shooters.getNome();
	}

	/**
	* Sets the nome of this v w_ shooters.
	*
	* @param Nome the nome of this v w_ shooters
	*/
	@Override
	public void setNome(java.lang.String Nome) {
		_vw_Shooters.setNome(Nome);
	}

	/**
	* Returns the cognome of this v w_ shooters.
	*
	* @return the cognome of this v w_ shooters
	*/
	@Override
	public java.lang.String getCognome() {
		return _vw_Shooters.getCognome();
	}

	/**
	* Sets the cognome of this v w_ shooters.
	*
	* @param Cognome the cognome of this v w_ shooters
	*/
	@Override
	public void setCognome(java.lang.String Cognome) {
		_vw_Shooters.setCognome(Cognome);
	}

	/**
	* Returns the email of this v w_ shooters.
	*
	* @return the email of this v w_ shooters
	*/
	@Override
	public java.lang.String getEmail() {
		return _vw_Shooters.getEmail();
	}

	/**
	* Sets the email of this v w_ shooters.
	*
	* @param Email the email of this v w_ shooters
	*/
	@Override
	public void setEmail(java.lang.String Email) {
		_vw_Shooters.setEmail(Email);
	}

	/**
	* Returns the c f of this v w_ shooters.
	*
	* @return the c f of this v w_ shooters
	*/
	@Override
	public java.lang.String getCF() {
		return _vw_Shooters.getCF();
	}

	/**
	* Sets the c f of this v w_ shooters.
	*
	* @param CF the c f of this v w_ shooters
	*/
	@Override
	public void setCF(java.lang.String CF) {
		_vw_Shooters.setCF(CF);
	}

	/**
	* Returns the organization ID of this v w_ shooters.
	*
	* @return the organization ID of this v w_ shooters
	*/
	@Override
	public long getOrganizationId() {
		return _vw_Shooters.getOrganizationId();
	}

	/**
	* Sets the organization ID of this v w_ shooters.
	*
	* @param organizationId the organization ID of this v w_ shooters
	*/
	@Override
	public void setOrganizationId(long organizationId) {
		_vw_Shooters.setOrganizationId(organizationId);
	}

	/**
	* Returns the invitato of this v w_ shooters.
	*
	* @return the invitato of this v w_ shooters
	*/
	@Override
	public int getInvitato() {
		return _vw_Shooters.getInvitato();
	}

	/**
	* Sets the invitato of this v w_ shooters.
	*
	* @param invitato the invitato of this v w_ shooters
	*/
	@Override
	public void setInvitato(int invitato) {
		_vw_Shooters.setInvitato(invitato);
	}

	@Override
	public boolean isNew() {
		return _vw_Shooters.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_vw_Shooters.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _vw_Shooters.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_vw_Shooters.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _vw_Shooters.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _vw_Shooters.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vw_Shooters.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vw_Shooters.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_vw_Shooters.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_vw_Shooters.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vw_Shooters.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VW_ShootersWrapper((VW_Shooters)_vw_Shooters.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.VW_Shooters vw_Shooters) {
		return _vw_Shooters.compareTo(vw_Shooters);
	}

	@Override
	public int hashCode() {
		return _vw_Shooters.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.VW_Shooters> toCacheModel() {
		return _vw_Shooters.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.VW_Shooters toEscapedModel() {
		return new VW_ShootersWrapper(_vw_Shooters.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.VW_Shooters toUnescapedModel() {
		return new VW_ShootersWrapper(_vw_Shooters.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vw_Shooters.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _vw_Shooters.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vw_Shooters.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VW_ShootersWrapper)) {
			return false;
		}

		VW_ShootersWrapper vw_ShootersWrapper = (VW_ShootersWrapper)obj;

		if (Validator.equals(_vw_Shooters, vw_ShootersWrapper._vw_Shooters)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public VW_Shooters getWrappedVW_Shooters() {
		return _vw_Shooters;
	}

	@Override
	public VW_Shooters getWrappedModel() {
		return _vw_Shooters;
	}

	@Override
	public void resetOriginalValues() {
		_vw_Shooters.resetOriginalValues();
	}

	private VW_Shooters _vw_Shooters;
}