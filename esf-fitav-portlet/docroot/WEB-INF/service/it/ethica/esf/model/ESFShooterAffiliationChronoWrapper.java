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
 * This class is a wrapper for {@link ESFShooterAffiliationChrono}.
 * </p>
 *
 * @author Ethica
 * @see ESFShooterAffiliationChrono
 * @generated
 */
public class ESFShooterAffiliationChronoWrapper
	implements ESFShooterAffiliationChrono,
		ModelWrapper<ESFShooterAffiliationChrono> {
	public ESFShooterAffiliationChronoWrapper(
		ESFShooterAffiliationChrono esfShooterAffiliationChrono) {
		_esfShooterAffiliationChrono = esfShooterAffiliationChrono;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFShooterAffiliationChrono.class;
	}

	@Override
	public String getModelClassName() {
		return ESFShooterAffiliationChrono.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfShooterAffiliationChronoId",
			getEsfShooterAffiliationChronoId());
		attributes.put("esfuserId", getEsfuserId());
		attributes.put("affiliationDate", getAffiliationDate());
		attributes.put("year", getYear());
		attributes.put("Vcampo", getVcampo());
		attributes.put("paymentDate", getPaymentDate());
		attributes.put("payment", getPayment());
		attributes.put("card", getCard());
		attributes.put("esfOrganization", getEsfOrganization());
		attributes.put("note", getNote());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfShooterAffiliationChronoId = (Long)attributes.get(
				"esfShooterAffiliationChronoId");

		if (esfShooterAffiliationChronoId != null) {
			setEsfShooterAffiliationChronoId(esfShooterAffiliationChronoId);
		}

		Long esfuserId = (Long)attributes.get("esfuserId");

		if (esfuserId != null) {
			setEsfuserId(esfuserId);
		}

		Date affiliationDate = (Date)attributes.get("affiliationDate");

		if (affiliationDate != null) {
			setAffiliationDate(affiliationDate);
		}

		Integer year = (Integer)attributes.get("year");

		if (year != null) {
			setYear(year);
		}

		String Vcampo = (String)attributes.get("Vcampo");

		if (Vcampo != null) {
			setVcampo(Vcampo);
		}

		Date paymentDate = (Date)attributes.get("paymentDate");

		if (paymentDate != null) {
			setPaymentDate(paymentDate);
		}

		String payment = (String)attributes.get("payment");

		if (payment != null) {
			setPayment(payment);
		}

		String card = (String)attributes.get("card");

		if (card != null) {
			setCard(card);
		}

		String esfOrganization = (String)attributes.get("esfOrganization");

		if (esfOrganization != null) {
			setEsfOrganization(esfOrganization);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}
	}

	/**
	* Returns the primary key of this e s f shooter affiliation chrono.
	*
	* @return the primary key of this e s f shooter affiliation chrono
	*/
	@Override
	public long getPrimaryKey() {
		return _esfShooterAffiliationChrono.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f shooter affiliation chrono.
	*
	* @param primaryKey the primary key of this e s f shooter affiliation chrono
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfShooterAffiliationChrono.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf shooter affiliation chrono ID of this e s f shooter affiliation chrono.
	*
	* @return the esf shooter affiliation chrono ID of this e s f shooter affiliation chrono
	*/
	@Override
	public long getEsfShooterAffiliationChronoId() {
		return _esfShooterAffiliationChrono.getEsfShooterAffiliationChronoId();
	}

	/**
	* Sets the esf shooter affiliation chrono ID of this e s f shooter affiliation chrono.
	*
	* @param esfShooterAffiliationChronoId the esf shooter affiliation chrono ID of this e s f shooter affiliation chrono
	*/
	@Override
	public void setEsfShooterAffiliationChronoId(
		long esfShooterAffiliationChronoId) {
		_esfShooterAffiliationChrono.setEsfShooterAffiliationChronoId(esfShooterAffiliationChronoId);
	}

	/**
	* Returns the esfuser ID of this e s f shooter affiliation chrono.
	*
	* @return the esfuser ID of this e s f shooter affiliation chrono
	*/
	@Override
	public long getEsfuserId() {
		return _esfShooterAffiliationChrono.getEsfuserId();
	}

	/**
	* Sets the esfuser ID of this e s f shooter affiliation chrono.
	*
	* @param esfuserId the esfuser ID of this e s f shooter affiliation chrono
	*/
	@Override
	public void setEsfuserId(long esfuserId) {
		_esfShooterAffiliationChrono.setEsfuserId(esfuserId);
	}

	/**
	* Returns the affiliation date of this e s f shooter affiliation chrono.
	*
	* @return the affiliation date of this e s f shooter affiliation chrono
	*/
	@Override
	public java.util.Date getAffiliationDate() {
		return _esfShooterAffiliationChrono.getAffiliationDate();
	}

	/**
	* Sets the affiliation date of this e s f shooter affiliation chrono.
	*
	* @param affiliationDate the affiliation date of this e s f shooter affiliation chrono
	*/
	@Override
	public void setAffiliationDate(java.util.Date affiliationDate) {
		_esfShooterAffiliationChrono.setAffiliationDate(affiliationDate);
	}

	/**
	* Returns the year of this e s f shooter affiliation chrono.
	*
	* @return the year of this e s f shooter affiliation chrono
	*/
	@Override
	public int getYear() {
		return _esfShooterAffiliationChrono.getYear();
	}

	/**
	* Sets the year of this e s f shooter affiliation chrono.
	*
	* @param year the year of this e s f shooter affiliation chrono
	*/
	@Override
	public void setYear(int year) {
		_esfShooterAffiliationChrono.setYear(year);
	}

	/**
	* Returns the vcampo of this e s f shooter affiliation chrono.
	*
	* @return the vcampo of this e s f shooter affiliation chrono
	*/
	@Override
	public java.lang.String getVcampo() {
		return _esfShooterAffiliationChrono.getVcampo();
	}

	/**
	* Sets the vcampo of this e s f shooter affiliation chrono.
	*
	* @param Vcampo the vcampo of this e s f shooter affiliation chrono
	*/
	@Override
	public void setVcampo(java.lang.String Vcampo) {
		_esfShooterAffiliationChrono.setVcampo(Vcampo);
	}

	/**
	* Returns the payment date of this e s f shooter affiliation chrono.
	*
	* @return the payment date of this e s f shooter affiliation chrono
	*/
	@Override
	public java.util.Date getPaymentDate() {
		return _esfShooterAffiliationChrono.getPaymentDate();
	}

	/**
	* Sets the payment date of this e s f shooter affiliation chrono.
	*
	* @param paymentDate the payment date of this e s f shooter affiliation chrono
	*/
	@Override
	public void setPaymentDate(java.util.Date paymentDate) {
		_esfShooterAffiliationChrono.setPaymentDate(paymentDate);
	}

	/**
	* Returns the payment of this e s f shooter affiliation chrono.
	*
	* @return the payment of this e s f shooter affiliation chrono
	*/
	@Override
	public java.lang.String getPayment() {
		return _esfShooterAffiliationChrono.getPayment();
	}

	/**
	* Sets the payment of this e s f shooter affiliation chrono.
	*
	* @param payment the payment of this e s f shooter affiliation chrono
	*/
	@Override
	public void setPayment(java.lang.String payment) {
		_esfShooterAffiliationChrono.setPayment(payment);
	}

	/**
	* Returns the card of this e s f shooter affiliation chrono.
	*
	* @return the card of this e s f shooter affiliation chrono
	*/
	@Override
	public java.lang.String getCard() {
		return _esfShooterAffiliationChrono.getCard();
	}

	/**
	* Sets the card of this e s f shooter affiliation chrono.
	*
	* @param card the card of this e s f shooter affiliation chrono
	*/
	@Override
	public void setCard(java.lang.String card) {
		_esfShooterAffiliationChrono.setCard(card);
	}

	/**
	* Returns the esf organization of this e s f shooter affiliation chrono.
	*
	* @return the esf organization of this e s f shooter affiliation chrono
	*/
	@Override
	public java.lang.String getEsfOrganization() {
		return _esfShooterAffiliationChrono.getEsfOrganization();
	}

	/**
	* Sets the esf organization of this e s f shooter affiliation chrono.
	*
	* @param esfOrganization the esf organization of this e s f shooter affiliation chrono
	*/
	@Override
	public void setEsfOrganization(java.lang.String esfOrganization) {
		_esfShooterAffiliationChrono.setEsfOrganization(esfOrganization);
	}

	/**
	* Returns the note of this e s f shooter affiliation chrono.
	*
	* @return the note of this e s f shooter affiliation chrono
	*/
	@Override
	public java.lang.String getNote() {
		return _esfShooterAffiliationChrono.getNote();
	}

	/**
	* Sets the note of this e s f shooter affiliation chrono.
	*
	* @param note the note of this e s f shooter affiliation chrono
	*/
	@Override
	public void setNote(java.lang.String note) {
		_esfShooterAffiliationChrono.setNote(note);
	}

	@Override
	public boolean isNew() {
		return _esfShooterAffiliationChrono.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfShooterAffiliationChrono.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfShooterAffiliationChrono.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfShooterAffiliationChrono.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfShooterAffiliationChrono.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfShooterAffiliationChrono.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfShooterAffiliationChrono.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfShooterAffiliationChrono.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfShooterAffiliationChrono.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfShooterAffiliationChrono.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfShooterAffiliationChrono.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFShooterAffiliationChronoWrapper((ESFShooterAffiliationChrono)_esfShooterAffiliationChrono.clone());
	}

	@Override
	public int compareTo(
		it.ethica.esf.model.ESFShooterAffiliationChrono esfShooterAffiliationChrono) {
		return _esfShooterAffiliationChrono.compareTo(esfShooterAffiliationChrono);
	}

	@Override
	public int hashCode() {
		return _esfShooterAffiliationChrono.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFShooterAffiliationChrono> toCacheModel() {
		return _esfShooterAffiliationChrono.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFShooterAffiliationChrono toEscapedModel() {
		return new ESFShooterAffiliationChronoWrapper(_esfShooterAffiliationChrono.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFShooterAffiliationChrono toUnescapedModel() {
		return new ESFShooterAffiliationChronoWrapper(_esfShooterAffiliationChrono.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfShooterAffiliationChrono.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfShooterAffiliationChrono.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfShooterAffiliationChrono.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFShooterAffiliationChronoWrapper)) {
			return false;
		}

		ESFShooterAffiliationChronoWrapper esfShooterAffiliationChronoWrapper = (ESFShooterAffiliationChronoWrapper)obj;

		if (Validator.equals(_esfShooterAffiliationChrono,
					esfShooterAffiliationChronoWrapper._esfShooterAffiliationChrono)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFShooterAffiliationChrono getWrappedESFShooterAffiliationChrono() {
		return _esfShooterAffiliationChrono;
	}

	@Override
	public ESFShooterAffiliationChrono getWrappedModel() {
		return _esfShooterAffiliationChrono;
	}

	@Override
	public void resetOriginalValues() {
		_esfShooterAffiliationChrono.resetOriginalValues();
	}

	private ESFShooterAffiliationChrono _esfShooterAffiliationChrono;
}