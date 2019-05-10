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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link vw_datidirettoretiro}.
 * </p>
 *
 * @author Ethica
 * @see vw_datidirettoretiro
 * @generated
 */
public class vw_datidirettoretiroWrapper implements vw_datidirettoretiro,
	ModelWrapper<vw_datidirettoretiro> {
	public vw_datidirettoretiroWrapper(
		vw_datidirettoretiro vw_datidirettoretiro) {
		_vw_datidirettoretiro = vw_datidirettoretiro;
	}

	@Override
	public Class<?> getModelClass() {
		return vw_datidirettoretiro.class;
	}

	@Override
	public String getModelClassName() {
		return vw_datidirettoretiro.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfshootingdirectorid", getEsfshootingdirectorid());
		attributes.put("nome", getNome());
		attributes.put("cognome", getCognome());
		attributes.put("esfstartdata", getEsfstartdata());
		attributes.put("categoryid", getCategoryid());
		attributes.put("numerotessera", getNumerotessera());
		attributes.put("codiceregione", getCodiceregione());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfshootingdirectorid = (Long)attributes.get(
				"esfshootingdirectorid");

		if (esfshootingdirectorid != null) {
			setEsfshootingdirectorid(esfshootingdirectorid);
		}

		Long nome = (Long)attributes.get("nome");

		if (nome != null) {
			setNome(nome);
		}

		Long cognome = (Long)attributes.get("cognome");

		if (cognome != null) {
			setCognome(cognome);
		}

		Date esfstartdata = (Date)attributes.get("esfstartdata");

		if (esfstartdata != null) {
			setEsfstartdata(esfstartdata);
		}

		Long categoryid = (Long)attributes.get("categoryid");

		if (categoryid != null) {
			setCategoryid(categoryid);
		}

		Long numerotessera = (Long)attributes.get("numerotessera");

		if (numerotessera != null) {
			setNumerotessera(numerotessera);
		}

		Long codiceregione = (Long)attributes.get("codiceregione");

		if (codiceregione != null) {
			setCodiceregione(codiceregione);
		}
	}

	/**
	* Returns the primary key of this vw_datidirettoretiro.
	*
	* @return the primary key of this vw_datidirettoretiro
	*/
	@Override
	public it.ethica.esf.service.persistence.vw_datidirettoretiroPK getPrimaryKey() {
		return _vw_datidirettoretiro.getPrimaryKey();
	}

	/**
	* Sets the primary key of this vw_datidirettoretiro.
	*
	* @param primaryKey the primary key of this vw_datidirettoretiro
	*/
	@Override
	public void setPrimaryKey(
		it.ethica.esf.service.persistence.vw_datidirettoretiroPK primaryKey) {
		_vw_datidirettoretiro.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esfshootingdirectorid of this vw_datidirettoretiro.
	*
	* @return the esfshootingdirectorid of this vw_datidirettoretiro
	*/
	@Override
	public long getEsfshootingdirectorid() {
		return _vw_datidirettoretiro.getEsfshootingdirectorid();
	}

	/**
	* Sets the esfshootingdirectorid of this vw_datidirettoretiro.
	*
	* @param esfshootingdirectorid the esfshootingdirectorid of this vw_datidirettoretiro
	*/
	@Override
	public void setEsfshootingdirectorid(long esfshootingdirectorid) {
		_vw_datidirettoretiro.setEsfshootingdirectorid(esfshootingdirectorid);
	}

	/**
	* Returns the nome of this vw_datidirettoretiro.
	*
	* @return the nome of this vw_datidirettoretiro
	*/
	@Override
	public long getNome() {
		return _vw_datidirettoretiro.getNome();
	}

	/**
	* Sets the nome of this vw_datidirettoretiro.
	*
	* @param nome the nome of this vw_datidirettoretiro
	*/
	@Override
	public void setNome(long nome) {
		_vw_datidirettoretiro.setNome(nome);
	}

	/**
	* Returns the cognome of this vw_datidirettoretiro.
	*
	* @return the cognome of this vw_datidirettoretiro
	*/
	@Override
	public long getCognome() {
		return _vw_datidirettoretiro.getCognome();
	}

	/**
	* Sets the cognome of this vw_datidirettoretiro.
	*
	* @param cognome the cognome of this vw_datidirettoretiro
	*/
	@Override
	public void setCognome(long cognome) {
		_vw_datidirettoretiro.setCognome(cognome);
	}

	/**
	* Returns the esfstartdata of this vw_datidirettoretiro.
	*
	* @return the esfstartdata of this vw_datidirettoretiro
	*/
	@Override
	public java.util.Date getEsfstartdata() {
		return _vw_datidirettoretiro.getEsfstartdata();
	}

	/**
	* Sets the esfstartdata of this vw_datidirettoretiro.
	*
	* @param esfstartdata the esfstartdata of this vw_datidirettoretiro
	*/
	@Override
	public void setEsfstartdata(java.util.Date esfstartdata) {
		_vw_datidirettoretiro.setEsfstartdata(esfstartdata);
	}

	/**
	* Returns the categoryid of this vw_datidirettoretiro.
	*
	* @return the categoryid of this vw_datidirettoretiro
	*/
	@Override
	public long getCategoryid() {
		return _vw_datidirettoretiro.getCategoryid();
	}

	/**
	* Sets the categoryid of this vw_datidirettoretiro.
	*
	* @param categoryid the categoryid of this vw_datidirettoretiro
	*/
	@Override
	public void setCategoryid(long categoryid) {
		_vw_datidirettoretiro.setCategoryid(categoryid);
	}

	/**
	* Returns the numerotessera of this vw_datidirettoretiro.
	*
	* @return the numerotessera of this vw_datidirettoretiro
	*/
	@Override
	public long getNumerotessera() {
		return _vw_datidirettoretiro.getNumerotessera();
	}

	/**
	* Sets the numerotessera of this vw_datidirettoretiro.
	*
	* @param numerotessera the numerotessera of this vw_datidirettoretiro
	*/
	@Override
	public void setNumerotessera(long numerotessera) {
		_vw_datidirettoretiro.setNumerotessera(numerotessera);
	}

	/**
	* Returns the codiceregione of this vw_datidirettoretiro.
	*
	* @return the codiceregione of this vw_datidirettoretiro
	*/
	@Override
	public long getCodiceregione() {
		return _vw_datidirettoretiro.getCodiceregione();
	}

	/**
	* Sets the codiceregione of this vw_datidirettoretiro.
	*
	* @param codiceregione the codiceregione of this vw_datidirettoretiro
	*/
	@Override
	public void setCodiceregione(long codiceregione) {
		_vw_datidirettoretiro.setCodiceregione(codiceregione);
	}

	@Override
	public boolean isNew() {
		return _vw_datidirettoretiro.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_vw_datidirettoretiro.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _vw_datidirettoretiro.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_vw_datidirettoretiro.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _vw_datidirettoretiro.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _vw_datidirettoretiro.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vw_datidirettoretiro.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vw_datidirettoretiro.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_vw_datidirettoretiro.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_vw_datidirettoretiro.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vw_datidirettoretiro.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new vw_datidirettoretiroWrapper((vw_datidirettoretiro)_vw_datidirettoretiro.clone());
	}

	@Override
	public int compareTo(vw_datidirettoretiro vw_datidirettoretiro) {
		return _vw_datidirettoretiro.compareTo(vw_datidirettoretiro);
	}

	@Override
	public int hashCode() {
		return _vw_datidirettoretiro.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vw_datidirettoretiro> toCacheModel() {
		return _vw_datidirettoretiro.toCacheModel();
	}

	@Override
	public vw_datidirettoretiro toEscapedModel() {
		return new vw_datidirettoretiroWrapper(_vw_datidirettoretiro.toEscapedModel());
	}

	@Override
	public vw_datidirettoretiro toUnescapedModel() {
		return new vw_datidirettoretiroWrapper(_vw_datidirettoretiro.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vw_datidirettoretiro.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _vw_datidirettoretiro.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vw_datidirettoretiro.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof vw_datidirettoretiroWrapper)) {
			return false;
		}

		vw_datidirettoretiroWrapper vw_datidirettoretiroWrapper = (vw_datidirettoretiroWrapper)obj;

		if (Validator.equals(_vw_datidirettoretiro,
					vw_datidirettoretiroWrapper._vw_datidirettoretiro)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public vw_datidirettoretiro getWrappedvw_datidirettoretiro() {
		return _vw_datidirettoretiro;
	}

	@Override
	public vw_datidirettoretiro getWrappedModel() {
		return _vw_datidirettoretiro;
	}

	@Override
	public void resetOriginalValues() {
		_vw_datidirettoretiro.resetOriginalValues();
	}

	private vw_datidirettoretiro _vw_datidirettoretiro;
}