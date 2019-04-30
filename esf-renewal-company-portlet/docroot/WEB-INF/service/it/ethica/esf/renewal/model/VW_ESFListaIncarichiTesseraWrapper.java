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

package it.ethica.esf.renewal.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link VW_ESFListaIncarichiTessera}.
 * </p>
 *
 * @author Ethica
 * @see VW_ESFListaIncarichiTessera
 * @generated
 */
public class VW_ESFListaIncarichiTesseraWrapper
	implements VW_ESFListaIncarichiTessera,
		ModelWrapper<VW_ESFListaIncarichiTessera> {
	public VW_ESFListaIncarichiTesseraWrapper(
		VW_ESFListaIncarichiTessera vw_esfListaIncarichiTessera) {
		_vw_esfListaIncarichiTessera = vw_esfListaIncarichiTessera;
	}

	@Override
	public Class<?> getModelClass() {
		return VW_ESFListaIncarichiTessera.class;
	}

	@Override
	public String getModelClassName() {
		return VW_ESFListaIncarichiTessera.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("AnniPrecedenti", getAnniPrecedenti());
		attributes.put("AnnoFineIncarico", getAnnoFineIncarico());
		attributes.put("AnnoInizioIncarico", getAnnoInizioIncarico());
		attributes.put("AnnoCorrente", getAnnoCorrente());
		attributes.put("NomeRuolo", getNomeRuolo());
		attributes.put("endDate", getEndDate());
		attributes.put("startDate", getStartDate());
		attributes.put("esfUserId", getEsfUserId());
		attributes.put("esfOrganizationId", getEsfOrganizationId());
		attributes.put("lastName", getLastName());
		attributes.put("firstName", getFirstName());
		attributes.put("CodiceTessera", getCodiceTessera());
		attributes.put("DataTesseramento", getDataTesseramento());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer AnniPrecedenti = (Integer)attributes.get("AnniPrecedenti");

		if (AnniPrecedenti != null) {
			setAnniPrecedenti(AnniPrecedenti);
		}

		Integer AnnoFineIncarico = (Integer)attributes.get("AnnoFineIncarico");

		if (AnnoFineIncarico != null) {
			setAnnoFineIncarico(AnnoFineIncarico);
		}

		Integer AnnoInizioIncarico = (Integer)attributes.get(
				"AnnoInizioIncarico");

		if (AnnoInizioIncarico != null) {
			setAnnoInizioIncarico(AnnoInizioIncarico);
		}

		Integer AnnoCorrente = (Integer)attributes.get("AnnoCorrente");

		if (AnnoCorrente != null) {
			setAnnoCorrente(AnnoCorrente);
		}

		String NomeRuolo = (String)attributes.get("NomeRuolo");

		if (NomeRuolo != null) {
			setNomeRuolo(NomeRuolo);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Long esfUserId = (Long)attributes.get("esfUserId");

		if (esfUserId != null) {
			setEsfUserId(esfUserId);
		}

		Long esfOrganizationId = (Long)attributes.get("esfOrganizationId");

		if (esfOrganizationId != null) {
			setEsfOrganizationId(esfOrganizationId);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String CodiceTessera = (String)attributes.get("CodiceTessera");

		if (CodiceTessera != null) {
			setCodiceTessera(CodiceTessera);
		}

		Date DataTesseramento = (Date)attributes.get("DataTesseramento");

		if (DataTesseramento != null) {
			setDataTesseramento(DataTesseramento);
		}
	}

	/**
	* Returns the primary key of this v w_ e s f lista incarichi tessera.
	*
	* @return the primary key of this v w_ e s f lista incarichi tessera
	*/
	@Override
	public it.ethica.esf.renewal.service.persistence.VW_ESFListaIncarichiTesseraPK getPrimaryKey() {
		return _vw_esfListaIncarichiTessera.getPrimaryKey();
	}

	/**
	* Sets the primary key of this v w_ e s f lista incarichi tessera.
	*
	* @param primaryKey the primary key of this v w_ e s f lista incarichi tessera
	*/
	@Override
	public void setPrimaryKey(
		it.ethica.esf.renewal.service.persistence.VW_ESFListaIncarichiTesseraPK primaryKey) {
		_vw_esfListaIncarichiTessera.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the anni precedenti of this v w_ e s f lista incarichi tessera.
	*
	* @return the anni precedenti of this v w_ e s f lista incarichi tessera
	*/
	@Override
	public int getAnniPrecedenti() {
		return _vw_esfListaIncarichiTessera.getAnniPrecedenti();
	}

	/**
	* Sets the anni precedenti of this v w_ e s f lista incarichi tessera.
	*
	* @param AnniPrecedenti the anni precedenti of this v w_ e s f lista incarichi tessera
	*/
	@Override
	public void setAnniPrecedenti(int AnniPrecedenti) {
		_vw_esfListaIncarichiTessera.setAnniPrecedenti(AnniPrecedenti);
	}

	/**
	* Returns the anno fine incarico of this v w_ e s f lista incarichi tessera.
	*
	* @return the anno fine incarico of this v w_ e s f lista incarichi tessera
	*/
	@Override
	public int getAnnoFineIncarico() {
		return _vw_esfListaIncarichiTessera.getAnnoFineIncarico();
	}

	/**
	* Sets the anno fine incarico of this v w_ e s f lista incarichi tessera.
	*
	* @param AnnoFineIncarico the anno fine incarico of this v w_ e s f lista incarichi tessera
	*/
	@Override
	public void setAnnoFineIncarico(int AnnoFineIncarico) {
		_vw_esfListaIncarichiTessera.setAnnoFineIncarico(AnnoFineIncarico);
	}

	/**
	* Returns the anno inizio incarico of this v w_ e s f lista incarichi tessera.
	*
	* @return the anno inizio incarico of this v w_ e s f lista incarichi tessera
	*/
	@Override
	public int getAnnoInizioIncarico() {
		return _vw_esfListaIncarichiTessera.getAnnoInizioIncarico();
	}

	/**
	* Sets the anno inizio incarico of this v w_ e s f lista incarichi tessera.
	*
	* @param AnnoInizioIncarico the anno inizio incarico of this v w_ e s f lista incarichi tessera
	*/
	@Override
	public void setAnnoInizioIncarico(int AnnoInizioIncarico) {
		_vw_esfListaIncarichiTessera.setAnnoInizioIncarico(AnnoInizioIncarico);
	}

	/**
	* Returns the anno corrente of this v w_ e s f lista incarichi tessera.
	*
	* @return the anno corrente of this v w_ e s f lista incarichi tessera
	*/
	@Override
	public int getAnnoCorrente() {
		return _vw_esfListaIncarichiTessera.getAnnoCorrente();
	}

	/**
	* Sets the anno corrente of this v w_ e s f lista incarichi tessera.
	*
	* @param AnnoCorrente the anno corrente of this v w_ e s f lista incarichi tessera
	*/
	@Override
	public void setAnnoCorrente(int AnnoCorrente) {
		_vw_esfListaIncarichiTessera.setAnnoCorrente(AnnoCorrente);
	}

	/**
	* Returns the nome ruolo of this v w_ e s f lista incarichi tessera.
	*
	* @return the nome ruolo of this v w_ e s f lista incarichi tessera
	*/
	@Override
	public java.lang.String getNomeRuolo() {
		return _vw_esfListaIncarichiTessera.getNomeRuolo();
	}

	/**
	* Sets the nome ruolo of this v w_ e s f lista incarichi tessera.
	*
	* @param NomeRuolo the nome ruolo of this v w_ e s f lista incarichi tessera
	*/
	@Override
	public void setNomeRuolo(java.lang.String NomeRuolo) {
		_vw_esfListaIncarichiTessera.setNomeRuolo(NomeRuolo);
	}

	/**
	* Returns the end date of this v w_ e s f lista incarichi tessera.
	*
	* @return the end date of this v w_ e s f lista incarichi tessera
	*/
	@Override
	public java.util.Date getEndDate() {
		return _vw_esfListaIncarichiTessera.getEndDate();
	}

	/**
	* Sets the end date of this v w_ e s f lista incarichi tessera.
	*
	* @param endDate the end date of this v w_ e s f lista incarichi tessera
	*/
	@Override
	public void setEndDate(java.util.Date endDate) {
		_vw_esfListaIncarichiTessera.setEndDate(endDate);
	}

	/**
	* Returns the start date of this v w_ e s f lista incarichi tessera.
	*
	* @return the start date of this v w_ e s f lista incarichi tessera
	*/
	@Override
	public java.util.Date getStartDate() {
		return _vw_esfListaIncarichiTessera.getStartDate();
	}

	/**
	* Sets the start date of this v w_ e s f lista incarichi tessera.
	*
	* @param startDate the start date of this v w_ e s f lista incarichi tessera
	*/
	@Override
	public void setStartDate(java.util.Date startDate) {
		_vw_esfListaIncarichiTessera.setStartDate(startDate);
	}

	/**
	* Returns the esf user ID of this v w_ e s f lista incarichi tessera.
	*
	* @return the esf user ID of this v w_ e s f lista incarichi tessera
	*/
	@Override
	public long getEsfUserId() {
		return _vw_esfListaIncarichiTessera.getEsfUserId();
	}

	/**
	* Sets the esf user ID of this v w_ e s f lista incarichi tessera.
	*
	* @param esfUserId the esf user ID of this v w_ e s f lista incarichi tessera
	*/
	@Override
	public void setEsfUserId(long esfUserId) {
		_vw_esfListaIncarichiTessera.setEsfUserId(esfUserId);
	}

	/**
	* Returns the esf user uuid of this v w_ e s f lista incarichi tessera.
	*
	* @return the esf user uuid of this v w_ e s f lista incarichi tessera
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getEsfUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_esfListaIncarichiTessera.getEsfUserUuid();
	}

	/**
	* Sets the esf user uuid of this v w_ e s f lista incarichi tessera.
	*
	* @param esfUserUuid the esf user uuid of this v w_ e s f lista incarichi tessera
	*/
	@Override
	public void setEsfUserUuid(java.lang.String esfUserUuid) {
		_vw_esfListaIncarichiTessera.setEsfUserUuid(esfUserUuid);
	}

	/**
	* Returns the esf organization ID of this v w_ e s f lista incarichi tessera.
	*
	* @return the esf organization ID of this v w_ e s f lista incarichi tessera
	*/
	@Override
	public long getEsfOrganizationId() {
		return _vw_esfListaIncarichiTessera.getEsfOrganizationId();
	}

	/**
	* Sets the esf organization ID of this v w_ e s f lista incarichi tessera.
	*
	* @param esfOrganizationId the esf organization ID of this v w_ e s f lista incarichi tessera
	*/
	@Override
	public void setEsfOrganizationId(long esfOrganizationId) {
		_vw_esfListaIncarichiTessera.setEsfOrganizationId(esfOrganizationId);
	}

	/**
	* Returns the last name of this v w_ e s f lista incarichi tessera.
	*
	* @return the last name of this v w_ e s f lista incarichi tessera
	*/
	@Override
	public java.lang.String getLastName() {
		return _vw_esfListaIncarichiTessera.getLastName();
	}

	/**
	* Sets the last name of this v w_ e s f lista incarichi tessera.
	*
	* @param lastName the last name of this v w_ e s f lista incarichi tessera
	*/
	@Override
	public void setLastName(java.lang.String lastName) {
		_vw_esfListaIncarichiTessera.setLastName(lastName);
	}

	/**
	* Returns the first name of this v w_ e s f lista incarichi tessera.
	*
	* @return the first name of this v w_ e s f lista incarichi tessera
	*/
	@Override
	public java.lang.String getFirstName() {
		return _vw_esfListaIncarichiTessera.getFirstName();
	}

	/**
	* Sets the first name of this v w_ e s f lista incarichi tessera.
	*
	* @param firstName the first name of this v w_ e s f lista incarichi tessera
	*/
	@Override
	public void setFirstName(java.lang.String firstName) {
		_vw_esfListaIncarichiTessera.setFirstName(firstName);
	}

	/**
	* Returns the codice tessera of this v w_ e s f lista incarichi tessera.
	*
	* @return the codice tessera of this v w_ e s f lista incarichi tessera
	*/
	@Override
	public java.lang.String getCodiceTessera() {
		return _vw_esfListaIncarichiTessera.getCodiceTessera();
	}

	/**
	* Sets the codice tessera of this v w_ e s f lista incarichi tessera.
	*
	* @param CodiceTessera the codice tessera of this v w_ e s f lista incarichi tessera
	*/
	@Override
	public void setCodiceTessera(java.lang.String CodiceTessera) {
		_vw_esfListaIncarichiTessera.setCodiceTessera(CodiceTessera);
	}

	/**
	* Returns the data tesseramento of this v w_ e s f lista incarichi tessera.
	*
	* @return the data tesseramento of this v w_ e s f lista incarichi tessera
	*/
	@Override
	public java.util.Date getDataTesseramento() {
		return _vw_esfListaIncarichiTessera.getDataTesseramento();
	}

	/**
	* Sets the data tesseramento of this v w_ e s f lista incarichi tessera.
	*
	* @param DataTesseramento the data tesseramento of this v w_ e s f lista incarichi tessera
	*/
	@Override
	public void setDataTesseramento(java.util.Date DataTesseramento) {
		_vw_esfListaIncarichiTessera.setDataTesseramento(DataTesseramento);
	}

	@Override
	public boolean isNew() {
		return _vw_esfListaIncarichiTessera.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_vw_esfListaIncarichiTessera.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _vw_esfListaIncarichiTessera.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_vw_esfListaIncarichiTessera.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _vw_esfListaIncarichiTessera.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _vw_esfListaIncarichiTessera.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vw_esfListaIncarichiTessera.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vw_esfListaIncarichiTessera.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_vw_esfListaIncarichiTessera.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_vw_esfListaIncarichiTessera.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vw_esfListaIncarichiTessera.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VW_ESFListaIncarichiTesseraWrapper((VW_ESFListaIncarichiTessera)_vw_esfListaIncarichiTessera.clone());
	}

	@Override
	public int compareTo(
		it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera vw_esfListaIncarichiTessera) {
		return _vw_esfListaIncarichiTessera.compareTo(vw_esfListaIncarichiTessera);
	}

	@Override
	public int hashCode() {
		return _vw_esfListaIncarichiTessera.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera> toCacheModel() {
		return _vw_esfListaIncarichiTessera.toCacheModel();
	}

	@Override
	public it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera toEscapedModel() {
		return new VW_ESFListaIncarichiTesseraWrapper(_vw_esfListaIncarichiTessera.toEscapedModel());
	}

	@Override
	public it.ethica.esf.renewal.model.VW_ESFListaIncarichiTessera toUnescapedModel() {
		return new VW_ESFListaIncarichiTesseraWrapper(_vw_esfListaIncarichiTessera.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vw_esfListaIncarichiTessera.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _vw_esfListaIncarichiTessera.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vw_esfListaIncarichiTessera.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VW_ESFListaIncarichiTesseraWrapper)) {
			return false;
		}

		VW_ESFListaIncarichiTesseraWrapper vw_esfListaIncarichiTesseraWrapper = (VW_ESFListaIncarichiTesseraWrapper)obj;

		if (Validator.equals(_vw_esfListaIncarichiTessera,
					vw_esfListaIncarichiTesseraWrapper._vw_esfListaIncarichiTessera)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public VW_ESFListaIncarichiTessera getWrappedVW_ESFListaIncarichiTessera() {
		return _vw_esfListaIncarichiTessera;
	}

	@Override
	public VW_ESFListaIncarichiTessera getWrappedModel() {
		return _vw_esfListaIncarichiTessera;
	}

	@Override
	public void resetOriginalValues() {
		_vw_esfListaIncarichiTessera.resetOriginalValues();
	}

	private VW_ESFListaIncarichiTessera _vw_esfListaIncarichiTessera;
}