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

package it.ethica.esf.renewal.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ESFRenewalCompany}.
 * </p>
 *
 * @author Ethica
 * @see ESFRenewalCompany
 * @generated
 */
public class ESFRenewalCompanyWrapper implements ESFRenewalCompany,
	ModelWrapper<ESFRenewalCompany> {
	public ESFRenewalCompanyWrapper(ESFRenewalCompany esfRenewalCompany) {
		_esfRenewalCompany = esfRenewalCompany;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFRenewalCompany.class;
	}

	@Override
	public String getModelClassName() {
		return ESFRenewalCompany.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfRenewalCompanyId", getEsfRenewalCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("esfOrganizationId", getEsfOrganizationId());
		attributes.put("cardsNumber", getCardsNumber());
		attributes.put("year", getYear());
		attributes.put("date", getDate());
		attributes.put("paymentType", getPaymentType());
		attributes.put("status", getStatus());
		attributes.put("amount", getAmount());
		attributes.put("info", getInfo());
		attributes.put("accountholder", getAccountholder());
		attributes.put("paymentDate", getPaymentDate());
		attributes.put("integrationAmount", getIntegrationAmount());
		attributes.put("integrationDate", getIntegrationDate());
		attributes.put("integrationType", getIntegrationType());
		attributes.put("integrationAccountholder", getIntegrationAccountholder());
		attributes.put("join", getJoin());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfRenewalCompanyId = (Long)attributes.get("esfRenewalCompanyId");

		if (esfRenewalCompanyId != null) {
			setEsfRenewalCompanyId(esfRenewalCompanyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long esfOrganizationId = (Long)attributes.get("esfOrganizationId");

		if (esfOrganizationId != null) {
			setEsfOrganizationId(esfOrganizationId);
		}

		Integer cardsNumber = (Integer)attributes.get("cardsNumber");

		if (cardsNumber != null) {
			setCardsNumber(cardsNumber);
		}

		Integer year = (Integer)attributes.get("year");

		if (year != null) {
			setYear(year);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}

		Integer paymentType = (Integer)attributes.get("paymentType");

		if (paymentType != null) {
			setPaymentType(paymentType);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Double amount = (Double)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		String info = (String)attributes.get("info");

		if (info != null) {
			setInfo(info);
		}

		String accountholder = (String)attributes.get("accountholder");

		if (accountholder != null) {
			setAccountholder(accountholder);
		}

		Date paymentDate = (Date)attributes.get("paymentDate");

		if (paymentDate != null) {
			setPaymentDate(paymentDate);
		}

		Double integrationAmount = (Double)attributes.get("integrationAmount");

		if (integrationAmount != null) {
			setIntegrationAmount(integrationAmount);
		}

		Date integrationDate = (Date)attributes.get("integrationDate");

		if (integrationDate != null) {
			setIntegrationDate(integrationDate);
		}

		Integer integrationType = (Integer)attributes.get("integrationType");

		if (integrationType != null) {
			setIntegrationType(integrationType);
		}

		String integrationAccountholder = (String)attributes.get(
				"integrationAccountholder");

		if (integrationAccountholder != null) {
			setIntegrationAccountholder(integrationAccountholder);
		}

		Boolean join = (Boolean)attributes.get("join");

		if (join != null) {
			setJoin(join);
		}
	}

	/**
	* Returns the primary key of this e s f renewal company.
	*
	* @return the primary key of this e s f renewal company
	*/
	@Override
	public long getPrimaryKey() {
		return _esfRenewalCompany.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f renewal company.
	*
	* @param primaryKey the primary key of this e s f renewal company
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfRenewalCompany.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf renewal company ID of this e s f renewal company.
	*
	* @return the esf renewal company ID of this e s f renewal company
	*/
	@Override
	public long getEsfRenewalCompanyId() {
		return _esfRenewalCompany.getEsfRenewalCompanyId();
	}

	/**
	* Sets the esf renewal company ID of this e s f renewal company.
	*
	* @param esfRenewalCompanyId the esf renewal company ID of this e s f renewal company
	*/
	@Override
	public void setEsfRenewalCompanyId(long esfRenewalCompanyId) {
		_esfRenewalCompany.setEsfRenewalCompanyId(esfRenewalCompanyId);
	}

	/**
	* Returns the user ID of this e s f renewal company.
	*
	* @return the user ID of this e s f renewal company
	*/
	@Override
	public long getUserId() {
		return _esfRenewalCompany.getUserId();
	}

	/**
	* Sets the user ID of this e s f renewal company.
	*
	* @param userId the user ID of this e s f renewal company
	*/
	@Override
	public void setUserId(long userId) {
		_esfRenewalCompany.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f renewal company.
	*
	* @return the user uuid of this e s f renewal company
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfRenewalCompany.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f renewal company.
	*
	* @param userUuid the user uuid of this e s f renewal company
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfRenewalCompany.setUserUuid(userUuid);
	}

	/**
	* Returns the esf organization ID of this e s f renewal company.
	*
	* @return the esf organization ID of this e s f renewal company
	*/
	@Override
	public long getEsfOrganizationId() {
		return _esfRenewalCompany.getEsfOrganizationId();
	}

	/**
	* Sets the esf organization ID of this e s f renewal company.
	*
	* @param esfOrganizationId the esf organization ID of this e s f renewal company
	*/
	@Override
	public void setEsfOrganizationId(long esfOrganizationId) {
		_esfRenewalCompany.setEsfOrganizationId(esfOrganizationId);
	}

	/**
	* Returns the cards number of this e s f renewal company.
	*
	* @return the cards number of this e s f renewal company
	*/
	@Override
	public int getCardsNumber() {
		return _esfRenewalCompany.getCardsNumber();
	}

	/**
	* Sets the cards number of this e s f renewal company.
	*
	* @param cardsNumber the cards number of this e s f renewal company
	*/
	@Override
	public void setCardsNumber(int cardsNumber) {
		_esfRenewalCompany.setCardsNumber(cardsNumber);
	}

	/**
	* Returns the year of this e s f renewal company.
	*
	* @return the year of this e s f renewal company
	*/
	@Override
	public int getYear() {
		return _esfRenewalCompany.getYear();
	}

	/**
	* Sets the year of this e s f renewal company.
	*
	* @param year the year of this e s f renewal company
	*/
	@Override
	public void setYear(int year) {
		_esfRenewalCompany.setYear(year);
	}

	/**
	* Returns the date of this e s f renewal company.
	*
	* @return the date of this e s f renewal company
	*/
	@Override
	public java.util.Date getDate() {
		return _esfRenewalCompany.getDate();
	}

	/**
	* Sets the date of this e s f renewal company.
	*
	* @param date the date of this e s f renewal company
	*/
	@Override
	public void setDate(java.util.Date date) {
		_esfRenewalCompany.setDate(date);
	}

	/**
	* Returns the payment type of this e s f renewal company.
	*
	* @return the payment type of this e s f renewal company
	*/
	@Override
	public int getPaymentType() {
		return _esfRenewalCompany.getPaymentType();
	}

	/**
	* Sets the payment type of this e s f renewal company.
	*
	* @param paymentType the payment type of this e s f renewal company
	*/
	@Override
	public void setPaymentType(int paymentType) {
		_esfRenewalCompany.setPaymentType(paymentType);
	}

	/**
	* Returns the status of this e s f renewal company.
	*
	* @return the status of this e s f renewal company
	*/
	@Override
	public int getStatus() {
		return _esfRenewalCompany.getStatus();
	}

	/**
	* Sets the status of this e s f renewal company.
	*
	* @param status the status of this e s f renewal company
	*/
	@Override
	public void setStatus(int status) {
		_esfRenewalCompany.setStatus(status);
	}

	/**
	* Returns the amount of this e s f renewal company.
	*
	* @return the amount of this e s f renewal company
	*/
	@Override
	public double getAmount() {
		return _esfRenewalCompany.getAmount();
	}

	/**
	* Sets the amount of this e s f renewal company.
	*
	* @param amount the amount of this e s f renewal company
	*/
	@Override
	public void setAmount(double amount) {
		_esfRenewalCompany.setAmount(amount);
	}

	/**
	* Returns the info of this e s f renewal company.
	*
	* @return the info of this e s f renewal company
	*/
	@Override
	public java.lang.String getInfo() {
		return _esfRenewalCompany.getInfo();
	}

	/**
	* Sets the info of this e s f renewal company.
	*
	* @param info the info of this e s f renewal company
	*/
	@Override
	public void setInfo(java.lang.String info) {
		_esfRenewalCompany.setInfo(info);
	}

	/**
	* Returns the accountholder of this e s f renewal company.
	*
	* @return the accountholder of this e s f renewal company
	*/
	@Override
	public java.lang.String getAccountholder() {
		return _esfRenewalCompany.getAccountholder();
	}

	/**
	* Sets the accountholder of this e s f renewal company.
	*
	* @param accountholder the accountholder of this e s f renewal company
	*/
	@Override
	public void setAccountholder(java.lang.String accountholder) {
		_esfRenewalCompany.setAccountholder(accountholder);
	}

	/**
	* Returns the payment date of this e s f renewal company.
	*
	* @return the payment date of this e s f renewal company
	*/
	@Override
	public java.util.Date getPaymentDate() {
		return _esfRenewalCompany.getPaymentDate();
	}

	/**
	* Sets the payment date of this e s f renewal company.
	*
	* @param paymentDate the payment date of this e s f renewal company
	*/
	@Override
	public void setPaymentDate(java.util.Date paymentDate) {
		_esfRenewalCompany.setPaymentDate(paymentDate);
	}

	/**
	* Returns the integration amount of this e s f renewal company.
	*
	* @return the integration amount of this e s f renewal company
	*/
	@Override
	public double getIntegrationAmount() {
		return _esfRenewalCompany.getIntegrationAmount();
	}

	/**
	* Sets the integration amount of this e s f renewal company.
	*
	* @param integrationAmount the integration amount of this e s f renewal company
	*/
	@Override
	public void setIntegrationAmount(double integrationAmount) {
		_esfRenewalCompany.setIntegrationAmount(integrationAmount);
	}

	/**
	* Returns the integration date of this e s f renewal company.
	*
	* @return the integration date of this e s f renewal company
	*/
	@Override
	public java.util.Date getIntegrationDate() {
		return _esfRenewalCompany.getIntegrationDate();
	}

	/**
	* Sets the integration date of this e s f renewal company.
	*
	* @param integrationDate the integration date of this e s f renewal company
	*/
	@Override
	public void setIntegrationDate(java.util.Date integrationDate) {
		_esfRenewalCompany.setIntegrationDate(integrationDate);
	}

	/**
	* Returns the integration type of this e s f renewal company.
	*
	* @return the integration type of this e s f renewal company
	*/
	@Override
	public int getIntegrationType() {
		return _esfRenewalCompany.getIntegrationType();
	}

	/**
	* Sets the integration type of this e s f renewal company.
	*
	* @param integrationType the integration type of this e s f renewal company
	*/
	@Override
	public void setIntegrationType(int integrationType) {
		_esfRenewalCompany.setIntegrationType(integrationType);
	}

	/**
	* Returns the integration accountholder of this e s f renewal company.
	*
	* @return the integration accountholder of this e s f renewal company
	*/
	@Override
	public java.lang.String getIntegrationAccountholder() {
		return _esfRenewalCompany.getIntegrationAccountholder();
	}

	/**
	* Sets the integration accountholder of this e s f renewal company.
	*
	* @param integrationAccountholder the integration accountholder of this e s f renewal company
	*/
	@Override
	public void setIntegrationAccountholder(
		java.lang.String integrationAccountholder) {
		_esfRenewalCompany.setIntegrationAccountholder(integrationAccountholder);
	}

	/**
	* Returns the join of this e s f renewal company.
	*
	* @return the join of this e s f renewal company
	*/
	@Override
	public boolean getJoin() {
		return _esfRenewalCompany.getJoin();
	}

	/**
	* Returns <code>true</code> if this e s f renewal company is join.
	*
	* @return <code>true</code> if this e s f renewal company is join; <code>false</code> otherwise
	*/
	@Override
	public boolean isJoin() {
		return _esfRenewalCompany.isJoin();
	}

	/**
	* Sets whether this e s f renewal company is join.
	*
	* @param join the join of this e s f renewal company
	*/
	@Override
	public void setJoin(boolean join) {
		_esfRenewalCompany.setJoin(join);
	}

	@Override
	public boolean isNew() {
		return _esfRenewalCompany.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfRenewalCompany.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfRenewalCompany.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfRenewalCompany.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfRenewalCompany.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfRenewalCompany.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfRenewalCompany.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfRenewalCompany.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfRenewalCompany.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfRenewalCompany.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfRenewalCompany.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFRenewalCompanyWrapper((ESFRenewalCompany)_esfRenewalCompany.clone());
	}

	@Override
	public int compareTo(
		it.ethica.esf.renewal.model.ESFRenewalCompany esfRenewalCompany) {
		return _esfRenewalCompany.compareTo(esfRenewalCompany);
	}

	@Override
	public int hashCode() {
		return _esfRenewalCompany.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.renewal.model.ESFRenewalCompany> toCacheModel() {
		return _esfRenewalCompany.toCacheModel();
	}

	@Override
	public it.ethica.esf.renewal.model.ESFRenewalCompany toEscapedModel() {
		return new ESFRenewalCompanyWrapper(_esfRenewalCompany.toEscapedModel());
	}

	@Override
	public it.ethica.esf.renewal.model.ESFRenewalCompany toUnescapedModel() {
		return new ESFRenewalCompanyWrapper(_esfRenewalCompany.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfRenewalCompany.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfRenewalCompany.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfRenewalCompany.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFRenewalCompanyWrapper)) {
			return false;
		}

		ESFRenewalCompanyWrapper esfRenewalCompanyWrapper = (ESFRenewalCompanyWrapper)obj;

		if (Validator.equals(_esfRenewalCompany,
					esfRenewalCompanyWrapper._esfRenewalCompany)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFRenewalCompany getWrappedESFRenewalCompany() {
		return _esfRenewalCompany;
	}

	@Override
	public ESFRenewalCompany getWrappedModel() {
		return _esfRenewalCompany;
	}

	@Override
	public void resetOriginalValues() {
		_esfRenewalCompany.resetOriginalValues();
	}

	private ESFRenewalCompany _esfRenewalCompany;
}