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
 * This class is a wrapper for {@link VW_DatiDrettoreTiro}.
 * </p>
 *
 * @author Ethica
 * @see VW_DatiDrettoreTiro
 * @generated
 */
public class VW_DatiDrettoreTiroWrapper implements VW_DatiDrettoreTiro,
	ModelWrapper<VW_DatiDrettoreTiro> {
	public VW_DatiDrettoreTiroWrapper(VW_DatiDrettoreTiro vw_DatiDrettoreTiro) {
		_vw_DatiDrettoreTiro = vw_DatiDrettoreTiro;
	}

	@Override
	public Class<?> getModelClass() {
		return VW_DatiDrettoreTiro.class;
	}

	@Override
	public String getModelClassName() {
		return VW_DatiDrettoreTiro.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfShootingDirectorId", getEsfShootingDirectorId());
		attributes.put("Nome", getNome());
		attributes.put("Cognome", getCognome());
		attributes.put("CodiceRegione", getCodiceRegione());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfShootingDirectorId = (Long)attributes.get(
				"esfShootingDirectorId");

		if (esfShootingDirectorId != null) {
			setEsfShootingDirectorId(esfShootingDirectorId);
		}

		String Nome = (String)attributes.get("Nome");

		if (Nome != null) {
			setNome(Nome);
		}

		String Cognome = (String)attributes.get("Cognome");

		if (Cognome != null) {
			setCognome(Cognome);
		}

		String CodiceRegione = (String)attributes.get("CodiceRegione");

		if (CodiceRegione != null) {
			setCodiceRegione(CodiceRegione);
		}
	}

	/**
	* Returns the primary key of this v w_ dati drettore tiro.
	*
	* @return the primary key of this v w_ dati drettore tiro
	*/
	@Override
	public it.ethica.esf.service.persistence.VW_DatiDrettoreTiroPK getPrimaryKey() {
		return _vw_DatiDrettoreTiro.getPrimaryKey();
	}

	/**
	* Sets the primary key of this v w_ dati drettore tiro.
	*
	* @param primaryKey the primary key of this v w_ dati drettore tiro
	*/
	@Override
	public void setPrimaryKey(
		it.ethica.esf.service.persistence.VW_DatiDrettoreTiroPK primaryKey) {
		_vw_DatiDrettoreTiro.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf shooting director ID of this v w_ dati drettore tiro.
	*
	* @return the esf shooting director ID of this v w_ dati drettore tiro
	*/
	@Override
	public long getEsfShootingDirectorId() {
		return _vw_DatiDrettoreTiro.getEsfShootingDirectorId();
	}

	/**
	* Sets the esf shooting director ID of this v w_ dati drettore tiro.
	*
	* @param esfShootingDirectorId the esf shooting director ID of this v w_ dati drettore tiro
	*/
	@Override
	public void setEsfShootingDirectorId(long esfShootingDirectorId) {
		_vw_DatiDrettoreTiro.setEsfShootingDirectorId(esfShootingDirectorId);
	}

	/**
	* Returns the nome of this v w_ dati drettore tiro.
	*
	* @return the nome of this v w_ dati drettore tiro
	*/
	@Override
	public java.lang.String getNome() {
		return _vw_DatiDrettoreTiro.getNome();
	}

	/**
	* Sets the nome of this v w_ dati drettore tiro.
	*
	* @param Nome the nome of this v w_ dati drettore tiro
	*/
	@Override
	public void setNome(java.lang.String Nome) {
		_vw_DatiDrettoreTiro.setNome(Nome);
	}

	/**
	* Returns the cognome of this v w_ dati drettore tiro.
	*
	* @return the cognome of this v w_ dati drettore tiro
	*/
	@Override
	public java.lang.String getCognome() {
		return _vw_DatiDrettoreTiro.getCognome();
	}

	/**
	* Sets the cognome of this v w_ dati drettore tiro.
	*
	* @param Cognome the cognome of this v w_ dati drettore tiro
	*/
	@Override
	public void setCognome(java.lang.String Cognome) {
		_vw_DatiDrettoreTiro.setCognome(Cognome);
	}

	/**
	* Returns the codice regione of this v w_ dati drettore tiro.
	*
	* @return the codice regione of this v w_ dati drettore tiro
	*/
	@Override
	public java.lang.String getCodiceRegione() {
		return _vw_DatiDrettoreTiro.getCodiceRegione();
	}

	/**
	* Sets the codice regione of this v w_ dati drettore tiro.
	*
	* @param CodiceRegione the codice regione of this v w_ dati drettore tiro
	*/
	@Override
	public void setCodiceRegione(java.lang.String CodiceRegione) {
		_vw_DatiDrettoreTiro.setCodiceRegione(CodiceRegione);
	}

	@Override
	public boolean isNew() {
		return _vw_DatiDrettoreTiro.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_vw_DatiDrettoreTiro.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _vw_DatiDrettoreTiro.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_vw_DatiDrettoreTiro.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _vw_DatiDrettoreTiro.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _vw_DatiDrettoreTiro.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vw_DatiDrettoreTiro.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vw_DatiDrettoreTiro.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_vw_DatiDrettoreTiro.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_vw_DatiDrettoreTiro.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vw_DatiDrettoreTiro.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VW_DatiDrettoreTiroWrapper((VW_DatiDrettoreTiro)_vw_DatiDrettoreTiro.clone());
	}

	@Override
<<<<<<< HEAD
	public int compareTo(
		it.ethica.esf.model.VW_DatiDrettoreTiro vw_DatiDrettoreTiro) {
=======
	public int compareTo(VW_DatiDrettoreTiro vw_DatiDrettoreTiro) {
>>>>>>> origin/master
		return _vw_DatiDrettoreTiro.compareTo(vw_DatiDrettoreTiro);
	}

	@Override
	public int hashCode() {
		return _vw_DatiDrettoreTiro.hashCode();
	}

	@Override
<<<<<<< HEAD
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.VW_DatiDrettoreTiro> toCacheModel() {
=======
	public com.liferay.portal.model.CacheModel<VW_DatiDrettoreTiro> toCacheModel() {
>>>>>>> origin/master
		return _vw_DatiDrettoreTiro.toCacheModel();
	}

	@Override
<<<<<<< HEAD
	public it.ethica.esf.model.VW_DatiDrettoreTiro toEscapedModel() {
=======
	public VW_DatiDrettoreTiro toEscapedModel() {
>>>>>>> origin/master
		return new VW_DatiDrettoreTiroWrapper(_vw_DatiDrettoreTiro.toEscapedModel());
	}

	@Override
<<<<<<< HEAD
	public it.ethica.esf.model.VW_DatiDrettoreTiro toUnescapedModel() {
=======
	public VW_DatiDrettoreTiro toUnescapedModel() {
>>>>>>> origin/master
		return new VW_DatiDrettoreTiroWrapper(_vw_DatiDrettoreTiro.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vw_DatiDrettoreTiro.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _vw_DatiDrettoreTiro.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vw_DatiDrettoreTiro.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VW_DatiDrettoreTiroWrapper)) {
			return false;
		}

		VW_DatiDrettoreTiroWrapper vw_DatiDrettoreTiroWrapper = (VW_DatiDrettoreTiroWrapper)obj;

		if (Validator.equals(_vw_DatiDrettoreTiro,
					vw_DatiDrettoreTiroWrapper._vw_DatiDrettoreTiro)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public VW_DatiDrettoreTiro getWrappedVW_DatiDrettoreTiro() {
		return _vw_DatiDrettoreTiro;
	}

	@Override
	public VW_DatiDrettoreTiro getWrappedModel() {
		return _vw_DatiDrettoreTiro;
	}

	@Override
	public void resetOriginalValues() {
		_vw_DatiDrettoreTiro.resetOriginalValues();
	}

	private VW_DatiDrettoreTiro _vw_DatiDrettoreTiro;
}