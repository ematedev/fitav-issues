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
 * This class is a wrapper for {@link VW_ESFListaIncarichi}.
 * </p>
 *
 * @author Ethica
 * @see VW_ESFListaIncarichi
 * @generated
 */
public class VW_ESFListaIncarichiWrapper implements VW_ESFListaIncarichi,
	ModelWrapper<VW_ESFListaIncarichi> {
	public VW_ESFListaIncarichiWrapper(
		VW_ESFListaIncarichi vw_esfListaIncarichi) {
		_vw_esfListaIncarichi = vw_esfListaIncarichi;
	}

	@Override
	public Class<?> getModelClass() {
		return VW_ESFListaIncarichi.class;
	}

	@Override
	public String getModelClassName() {
		return VW_ESFListaIncarichi.class.getName();
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
	}

	/**
	* Returns the primary key of this v w_ e s f lista incarichi.
	*
	* @return the primary key of this v w_ e s f lista incarichi
	*/
	@Override
	public it.ethica.esf.service.persistence.VW_ESFListaIncarichiPK getPrimaryKey() {
		return _vw_esfListaIncarichi.getPrimaryKey();
	}

	/**
	* Sets the primary key of this v w_ e s f lista incarichi.
	*
	* @param primaryKey the primary key of this v w_ e s f lista incarichi
	*/
	@Override
	public void setPrimaryKey(
		it.ethica.esf.service.persistence.VW_ESFListaIncarichiPK primaryKey) {
		_vw_esfListaIncarichi.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the anni precedenti of this v w_ e s f lista incarichi.
	*
	* @return the anni precedenti of this v w_ e s f lista incarichi
	*/
	@Override
	public int getAnniPrecedenti() {
		return _vw_esfListaIncarichi.getAnniPrecedenti();
	}

	/**
	* Sets the anni precedenti of this v w_ e s f lista incarichi.
	*
	* @param AnniPrecedenti the anni precedenti of this v w_ e s f lista incarichi
	*/
	@Override
	public void setAnniPrecedenti(int AnniPrecedenti) {
		_vw_esfListaIncarichi.setAnniPrecedenti(AnniPrecedenti);
	}

	/**
	* Returns the anno fine incarico of this v w_ e s f lista incarichi.
	*
	* @return the anno fine incarico of this v w_ e s f lista incarichi
	*/
	@Override
	public int getAnnoFineIncarico() {
		return _vw_esfListaIncarichi.getAnnoFineIncarico();
	}

	/**
	* Sets the anno fine incarico of this v w_ e s f lista incarichi.
	*
	* @param AnnoFineIncarico the anno fine incarico of this v w_ e s f lista incarichi
	*/
	@Override
	public void setAnnoFineIncarico(int AnnoFineIncarico) {
		_vw_esfListaIncarichi.setAnnoFineIncarico(AnnoFineIncarico);
	}

	/**
	* Returns the anno inizio incarico of this v w_ e s f lista incarichi.
	*
	* @return the anno inizio incarico of this v w_ e s f lista incarichi
	*/
	@Override
	public int getAnnoInizioIncarico() {
		return _vw_esfListaIncarichi.getAnnoInizioIncarico();
	}

	/**
	* Sets the anno inizio incarico of this v w_ e s f lista incarichi.
	*
	* @param AnnoInizioIncarico the anno inizio incarico of this v w_ e s f lista incarichi
	*/
	@Override
	public void setAnnoInizioIncarico(int AnnoInizioIncarico) {
		_vw_esfListaIncarichi.setAnnoInizioIncarico(AnnoInizioIncarico);
	}

	/**
	* Returns the anno corrente of this v w_ e s f lista incarichi.
	*
	* @return the anno corrente of this v w_ e s f lista incarichi
	*/
	@Override
	public int getAnnoCorrente() {
		return _vw_esfListaIncarichi.getAnnoCorrente();
	}

	/**
	* Sets the anno corrente of this v w_ e s f lista incarichi.
	*
	* @param AnnoCorrente the anno corrente of this v w_ e s f lista incarichi
	*/
	@Override
	public void setAnnoCorrente(int AnnoCorrente) {
		_vw_esfListaIncarichi.setAnnoCorrente(AnnoCorrente);
	}

	/**
	* Returns the nome ruolo of this v w_ e s f lista incarichi.
	*
	* @return the nome ruolo of this v w_ e s f lista incarichi
	*/
	@Override
	public java.lang.String getNomeRuolo() {
		return _vw_esfListaIncarichi.getNomeRuolo();
	}

	/**
	* Sets the nome ruolo of this v w_ e s f lista incarichi.
	*
	* @param NomeRuolo the nome ruolo of this v w_ e s f lista incarichi
	*/
	@Override
	public void setNomeRuolo(java.lang.String NomeRuolo) {
		_vw_esfListaIncarichi.setNomeRuolo(NomeRuolo);
	}

	/**
	* Returns the end date of this v w_ e s f lista incarichi.
	*
	* @return the end date of this v w_ e s f lista incarichi
	*/
	@Override
	public java.util.Date getEndDate() {
		return _vw_esfListaIncarichi.getEndDate();
	}

	/**
	* Sets the end date of this v w_ e s f lista incarichi.
	*
	* @param endDate the end date of this v w_ e s f lista incarichi
	*/
	@Override
	public void setEndDate(java.util.Date endDate) {
		_vw_esfListaIncarichi.setEndDate(endDate);
	}

	/**
	* Returns the start date of this v w_ e s f lista incarichi.
	*
	* @return the start date of this v w_ e s f lista incarichi
	*/
	@Override
	public java.util.Date getStartDate() {
		return _vw_esfListaIncarichi.getStartDate();
	}

	/**
	* Sets the start date of this v w_ e s f lista incarichi.
	*
	* @param startDate the start date of this v w_ e s f lista incarichi
	*/
	@Override
	public void setStartDate(java.util.Date startDate) {
		_vw_esfListaIncarichi.setStartDate(startDate);
	}

	/**
	* Returns the esf user ID of this v w_ e s f lista incarichi.
	*
	* @return the esf user ID of this v w_ e s f lista incarichi
	*/
	@Override
	public long getEsfUserId() {
		return _vw_esfListaIncarichi.getEsfUserId();
	}

	/**
	* Sets the esf user ID of this v w_ e s f lista incarichi.
	*
	* @param esfUserId the esf user ID of this v w_ e s f lista incarichi
	*/
	@Override
	public void setEsfUserId(long esfUserId) {
		_vw_esfListaIncarichi.setEsfUserId(esfUserId);
	}

	/**
	* Returns the esf user uuid of this v w_ e s f lista incarichi.
	*
	* @return the esf user uuid of this v w_ e s f lista incarichi
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getEsfUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vw_esfListaIncarichi.getEsfUserUuid();
	}

	/**
	* Sets the esf user uuid of this v w_ e s f lista incarichi.
	*
	* @param esfUserUuid the esf user uuid of this v w_ e s f lista incarichi
	*/
	@Override
	public void setEsfUserUuid(java.lang.String esfUserUuid) {
		_vw_esfListaIncarichi.setEsfUserUuid(esfUserUuid);
	}

	/**
	* Returns the esf organization ID of this v w_ e s f lista incarichi.
	*
	* @return the esf organization ID of this v w_ e s f lista incarichi
	*/
	@Override
	public long getEsfOrganizationId() {
		return _vw_esfListaIncarichi.getEsfOrganizationId();
	}

	/**
	* Sets the esf organization ID of this v w_ e s f lista incarichi.
	*
	* @param esfOrganizationId the esf organization ID of this v w_ e s f lista incarichi
	*/
	@Override
	public void setEsfOrganizationId(long esfOrganizationId) {
		_vw_esfListaIncarichi.setEsfOrganizationId(esfOrganizationId);
	}

	/**
	* Returns the last name of this v w_ e s f lista incarichi.
	*
	* @return the last name of this v w_ e s f lista incarichi
	*/
	@Override
	public java.lang.String getLastName() {
		return _vw_esfListaIncarichi.getLastName();
	}

	/**
	* Sets the last name of this v w_ e s f lista incarichi.
	*
	* @param lastName the last name of this v w_ e s f lista incarichi
	*/
	@Override
	public void setLastName(java.lang.String lastName) {
		_vw_esfListaIncarichi.setLastName(lastName);
	}

	/**
	* Returns the first name of this v w_ e s f lista incarichi.
	*
	* @return the first name of this v w_ e s f lista incarichi
	*/
	@Override
	public java.lang.String getFirstName() {
		return _vw_esfListaIncarichi.getFirstName();
	}

	/**
	* Sets the first name of this v w_ e s f lista incarichi.
	*
	* @param firstName the first name of this v w_ e s f lista incarichi
	*/
	@Override
	public void setFirstName(java.lang.String firstName) {
		_vw_esfListaIncarichi.setFirstName(firstName);
	}

	@Override
	public boolean isNew() {
		return _vw_esfListaIncarichi.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_vw_esfListaIncarichi.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _vw_esfListaIncarichi.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_vw_esfListaIncarichi.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _vw_esfListaIncarichi.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _vw_esfListaIncarichi.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vw_esfListaIncarichi.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vw_esfListaIncarichi.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_vw_esfListaIncarichi.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_vw_esfListaIncarichi.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vw_esfListaIncarichi.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VW_ESFListaIncarichiWrapper((VW_ESFListaIncarichi)_vw_esfListaIncarichi.clone());
	}

	@Override
	public int compareTo(
		it.ethica.esf.model.VW_ESFListaIncarichi vw_esfListaIncarichi) {
		return _vw_esfListaIncarichi.compareTo(vw_esfListaIncarichi);
	}

	@Override
	public int hashCode() {
		return _vw_esfListaIncarichi.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.VW_ESFListaIncarichi> toCacheModel() {
		return _vw_esfListaIncarichi.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.VW_ESFListaIncarichi toEscapedModel() {
		return new VW_ESFListaIncarichiWrapper(_vw_esfListaIncarichi.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.VW_ESFListaIncarichi toUnescapedModel() {
		return new VW_ESFListaIncarichiWrapper(_vw_esfListaIncarichi.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vw_esfListaIncarichi.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _vw_esfListaIncarichi.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vw_esfListaIncarichi.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VW_ESFListaIncarichiWrapper)) {
			return false;
		}

		VW_ESFListaIncarichiWrapper vw_esfListaIncarichiWrapper = (VW_ESFListaIncarichiWrapper)obj;

		if (Validator.equals(_vw_esfListaIncarichi,
					vw_esfListaIncarichiWrapper._vw_esfListaIncarichi)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public VW_ESFListaIncarichi getWrappedVW_ESFListaIncarichi() {
		return _vw_esfListaIncarichi;
	}

	@Override
	public VW_ESFListaIncarichi getWrappedModel() {
		return _vw_esfListaIncarichi;
	}

	@Override
	public void resetOriginalValues() {
		_vw_esfListaIncarichi.resetOriginalValues();
	}

	private VW_ESFListaIncarichi _vw_esfListaIncarichi;
}