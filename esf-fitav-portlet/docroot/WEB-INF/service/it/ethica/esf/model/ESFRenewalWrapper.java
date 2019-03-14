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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ESFRenewal}.
 * </p>
 *
 * @author Ethica
 * @see ESFRenewal
 * @generated
 */
public class ESFRenewalWrapper implements ESFRenewal, ModelWrapper<ESFRenewal> {
	public ESFRenewalWrapper(ESFRenewal esfRenewal) {
		_esfRenewal = esfRenewal;
	}

	@Override
	public Class<?> getModelClass() {
		return ESFRenewal.class;
	}

	@Override
	public String getModelClassName() {
		return ESFRenewal.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfRenewalId", getEsfRenewalId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("quantity", getQuantity());
		attributes.put("paymentReason", getPaymentReason());
		attributes.put("paymentType", getPaymentType());
		attributes.put("paymentDate", getPaymentDate());
		attributes.put("paymentReceived", getPaymentReceived());
		attributes.put("createDate", getCreateDate());
		attributes.put("groupId", getGroupId());
		attributes.put("info", getInfo());
		attributes.put("madeBy", getMadeBy());
		attributes.put("amount", getAmount());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("reportingYear", getReportingYear());
		attributes.put("amountTotal", getAmountTotal());
		attributes.put("isTotal", getIsTotal());
		attributes.put("renewalFatherId", getRenewalFatherId());
		attributes.put("affiliates", getAffiliates());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfRenewalId = (Long)attributes.get("esfRenewalId");

		if (esfRenewalId != null) {
			setEsfRenewalId(esfRenewalId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long quantity = (Long)attributes.get("quantity");

		if (quantity != null) {
			setQuantity(quantity);
		}

		String paymentReason = (String)attributes.get("paymentReason");

		if (paymentReason != null) {
			setPaymentReason(paymentReason);
		}

		String paymentType = (String)attributes.get("paymentType");

		if (paymentType != null) {
			setPaymentType(paymentType);
		}

		Date paymentDate = (Date)attributes.get("paymentDate");

		if (paymentDate != null) {
			setPaymentDate(paymentDate);
		}

		Boolean paymentReceived = (Boolean)attributes.get("paymentReceived");

		if (paymentReceived != null) {
			setPaymentReceived(paymentReceived);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String info = (String)attributes.get("info");

		if (info != null) {
			setInfo(info);
		}

		String madeBy = (String)attributes.get("madeBy");

		if (madeBy != null) {
			setMadeBy(madeBy);
		}

		Double amount = (Double)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		Integer reportingYear = (Integer)attributes.get("reportingYear");

		if (reportingYear != null) {
			setReportingYear(reportingYear);
		}

		Double amountTotal = (Double)attributes.get("amountTotal");

		if (amountTotal != null) {
			setAmountTotal(amountTotal);
		}

		Boolean isTotal = (Boolean)attributes.get("isTotal");

		if (isTotal != null) {
			setIsTotal(isTotal);
		}

		Long renewalFatherId = (Long)attributes.get("renewalFatherId");

		if (renewalFatherId != null) {
			setRenewalFatherId(renewalFatherId);
		}

		Boolean affiliates = (Boolean)attributes.get("affiliates");

		if (affiliates != null) {
			setAffiliates(affiliates);
		}
	}

	/**
	* Returns the primary key of this e s f renewal.
	*
	* @return the primary key of this e s f renewal
	*/
	@Override
	public long getPrimaryKey() {
		return _esfRenewal.getPrimaryKey();
	}

	/**
	* Sets the primary key of this e s f renewal.
	*
	* @param primaryKey the primary key of this e s f renewal
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_esfRenewal.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the esf renewal ID of this e s f renewal.
	*
	* @return the esf renewal ID of this e s f renewal
	*/
	@Override
	public long getEsfRenewalId() {
		return _esfRenewal.getEsfRenewalId();
	}

	/**
	* Sets the esf renewal ID of this e s f renewal.
	*
	* @param esfRenewalId the esf renewal ID of this e s f renewal
	*/
	@Override
	public void setEsfRenewalId(long esfRenewalId) {
		_esfRenewal.setEsfRenewalId(esfRenewalId);
	}

	/**
	* Returns the company ID of this e s f renewal.
	*
	* @return the company ID of this e s f renewal
	*/
	@Override
	public long getCompanyId() {
		return _esfRenewal.getCompanyId();
	}

	/**
	* Sets the company ID of this e s f renewal.
	*
	* @param companyId the company ID of this e s f renewal
	*/
	@Override
	public void setCompanyId(long companyId) {
		_esfRenewal.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this e s f renewal.
	*
	* @return the user ID of this e s f renewal
	*/
	@Override
	public long getUserId() {
		return _esfRenewal.getUserId();
	}

	/**
	* Sets the user ID of this e s f renewal.
	*
	* @param userId the user ID of this e s f renewal
	*/
	@Override
	public void setUserId(long userId) {
		_esfRenewal.setUserId(userId);
	}

	/**
	* Returns the user uuid of this e s f renewal.
	*
	* @return the user uuid of this e s f renewal
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _esfRenewal.getUserUuid();
	}

	/**
	* Sets the user uuid of this e s f renewal.
	*
	* @param userUuid the user uuid of this e s f renewal
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_esfRenewal.setUserUuid(userUuid);
	}

	/**
	* Returns the modified date of this e s f renewal.
	*
	* @return the modified date of this e s f renewal
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _esfRenewal.getModifiedDate();
	}

	/**
	* Sets the modified date of this e s f renewal.
	*
	* @param modifiedDate the modified date of this e s f renewal
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_esfRenewal.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the quantity of this e s f renewal.
	*
	* @return the quantity of this e s f renewal
	*/
	@Override
	public long getQuantity() {
		return _esfRenewal.getQuantity();
	}

	/**
	* Sets the quantity of this e s f renewal.
	*
	* @param quantity the quantity of this e s f renewal
	*/
	@Override
	public void setQuantity(long quantity) {
		_esfRenewal.setQuantity(quantity);
	}

	/**
	* Returns the payment reason of this e s f renewal.
	*
	* @return the payment reason of this e s f renewal
	*/
	@Override
	public java.lang.String getPaymentReason() {
		return _esfRenewal.getPaymentReason();
	}

	/**
	* Sets the payment reason of this e s f renewal.
	*
	* @param paymentReason the payment reason of this e s f renewal
	*/
	@Override
	public void setPaymentReason(java.lang.String paymentReason) {
		_esfRenewal.setPaymentReason(paymentReason);
	}

	/**
	* Returns the payment type of this e s f renewal.
	*
	* @return the payment type of this e s f renewal
	*/
	@Override
	public java.lang.String getPaymentType() {
		return _esfRenewal.getPaymentType();
	}

	/**
	* Sets the payment type of this e s f renewal.
	*
	* @param paymentType the payment type of this e s f renewal
	*/
	@Override
	public void setPaymentType(java.lang.String paymentType) {
		_esfRenewal.setPaymentType(paymentType);
	}

	/**
	* Returns the payment date of this e s f renewal.
	*
	* @return the payment date of this e s f renewal
	*/
	@Override
	public java.util.Date getPaymentDate() {
		return _esfRenewal.getPaymentDate();
	}

	/**
	* Sets the payment date of this e s f renewal.
	*
	* @param paymentDate the payment date of this e s f renewal
	*/
	@Override
	public void setPaymentDate(java.util.Date paymentDate) {
		_esfRenewal.setPaymentDate(paymentDate);
	}

	/**
	* Returns the payment received of this e s f renewal.
	*
	* @return the payment received of this e s f renewal
	*/
	@Override
	public boolean getPaymentReceived() {
		return _esfRenewal.getPaymentReceived();
	}

	/**
	* Returns <code>true</code> if this e s f renewal is payment received.
	*
	* @return <code>true</code> if this e s f renewal is payment received; <code>false</code> otherwise
	*/
	@Override
	public boolean isPaymentReceived() {
		return _esfRenewal.isPaymentReceived();
	}

	/**
	* Sets whether this e s f renewal is payment received.
	*
	* @param paymentReceived the payment received of this e s f renewal
	*/
	@Override
	public void setPaymentReceived(boolean paymentReceived) {
		_esfRenewal.setPaymentReceived(paymentReceived);
	}

	/**
	* Returns the create date of this e s f renewal.
	*
	* @return the create date of this e s f renewal
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _esfRenewal.getCreateDate();
	}

	/**
	* Sets the create date of this e s f renewal.
	*
	* @param createDate the create date of this e s f renewal
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_esfRenewal.setCreateDate(createDate);
	}

	/**
	* Returns the group ID of this e s f renewal.
	*
	* @return the group ID of this e s f renewal
	*/
	@Override
	public long getGroupId() {
		return _esfRenewal.getGroupId();
	}

	/**
	* Sets the group ID of this e s f renewal.
	*
	* @param groupId the group ID of this e s f renewal
	*/
	@Override
	public void setGroupId(long groupId) {
		_esfRenewal.setGroupId(groupId);
	}

	/**
	* Returns the info of this e s f renewal.
	*
	* @return the info of this e s f renewal
	*/
	@Override
	public java.lang.String getInfo() {
		return _esfRenewal.getInfo();
	}

	/**
	* Sets the info of this e s f renewal.
	*
	* @param info the info of this e s f renewal
	*/
	@Override
	public void setInfo(java.lang.String info) {
		_esfRenewal.setInfo(info);
	}

	/**
	* Returns the made by of this e s f renewal.
	*
	* @return the made by of this e s f renewal
	*/
	@Override
	public java.lang.String getMadeBy() {
		return _esfRenewal.getMadeBy();
	}

	/**
	* Sets the made by of this e s f renewal.
	*
	* @param madeBy the made by of this e s f renewal
	*/
	@Override
	public void setMadeBy(java.lang.String madeBy) {
		_esfRenewal.setMadeBy(madeBy);
	}

	/**
	* Returns the amount of this e s f renewal.
	*
	* @return the amount of this e s f renewal
	*/
	@Override
	public double getAmount() {
		return _esfRenewal.getAmount();
	}

	/**
	* Sets the amount of this e s f renewal.
	*
	* @param amount the amount of this e s f renewal
	*/
	@Override
	public void setAmount(double amount) {
		_esfRenewal.setAmount(amount);
	}

	/**
	* Returns the organization ID of this e s f renewal.
	*
	* @return the organization ID of this e s f renewal
	*/
	@Override
	public long getOrganizationId() {
		return _esfRenewal.getOrganizationId();
	}

	/**
	* Sets the organization ID of this e s f renewal.
	*
	* @param organizationId the organization ID of this e s f renewal
	*/
	@Override
	public void setOrganizationId(long organizationId) {
		_esfRenewal.setOrganizationId(organizationId);
	}

	/**
	* Returns the reporting year of this e s f renewal.
	*
	* @return the reporting year of this e s f renewal
	*/
	@Override
	public int getReportingYear() {
		return _esfRenewal.getReportingYear();
	}

	/**
	* Sets the reporting year of this e s f renewal.
	*
	* @param reportingYear the reporting year of this e s f renewal
	*/
	@Override
	public void setReportingYear(int reportingYear) {
		_esfRenewal.setReportingYear(reportingYear);
	}

	/**
	* Returns the amount total of this e s f renewal.
	*
	* @return the amount total of this e s f renewal
	*/
	@Override
	public double getAmountTotal() {
		return _esfRenewal.getAmountTotal();
	}

	/**
	* Sets the amount total of this e s f renewal.
	*
	* @param amountTotal the amount total of this e s f renewal
	*/
	@Override
	public void setAmountTotal(double amountTotal) {
		_esfRenewal.setAmountTotal(amountTotal);
	}

	/**
	* Returns the is total of this e s f renewal.
	*
	* @return the is total of this e s f renewal
	*/
	@Override
	public boolean getIsTotal() {
		return _esfRenewal.getIsTotal();
	}

	/**
	* Returns <code>true</code> if this e s f renewal is is total.
	*
	* @return <code>true</code> if this e s f renewal is is total; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsTotal() {
		return _esfRenewal.isIsTotal();
	}

	/**
	* Sets whether this e s f renewal is is total.
	*
	* @param isTotal the is total of this e s f renewal
	*/
	@Override
	public void setIsTotal(boolean isTotal) {
		_esfRenewal.setIsTotal(isTotal);
	}

	/**
	* Returns the renewal father ID of this e s f renewal.
	*
	* @return the renewal father ID of this e s f renewal
	*/
	@Override
	public long getRenewalFatherId() {
		return _esfRenewal.getRenewalFatherId();
	}

	/**
	* Sets the renewal father ID of this e s f renewal.
	*
	* @param renewalFatherId the renewal father ID of this e s f renewal
	*/
	@Override
	public void setRenewalFatherId(long renewalFatherId) {
		_esfRenewal.setRenewalFatherId(renewalFatherId);
	}

	/**
	* Returns the affiliates of this e s f renewal.
	*
	* @return the affiliates of this e s f renewal
	*/
	@Override
	public boolean getAffiliates() {
		return _esfRenewal.getAffiliates();
	}

	/**
	* Returns <code>true</code> if this e s f renewal is affiliates.
	*
	* @return <code>true</code> if this e s f renewal is affiliates; <code>false</code> otherwise
	*/
	@Override
	public boolean isAffiliates() {
		return _esfRenewal.isAffiliates();
	}

	/**
	* Sets whether this e s f renewal is affiliates.
	*
	* @param affiliates the affiliates of this e s f renewal
	*/
	@Override
	public void setAffiliates(boolean affiliates) {
		_esfRenewal.setAffiliates(affiliates);
	}

	@Override
	public boolean isNew() {
		return _esfRenewal.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_esfRenewal.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _esfRenewal.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_esfRenewal.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _esfRenewal.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _esfRenewal.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_esfRenewal.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _esfRenewal.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_esfRenewal.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_esfRenewal.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_esfRenewal.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ESFRenewalWrapper((ESFRenewal)_esfRenewal.clone());
	}

	@Override
	public int compareTo(it.ethica.esf.model.ESFRenewal esfRenewal) {
		return _esfRenewal.compareTo(esfRenewal);
	}

	@Override
	public int hashCode() {
		return _esfRenewal.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.ethica.esf.model.ESFRenewal> toCacheModel() {
		return _esfRenewal.toCacheModel();
	}

	@Override
	public it.ethica.esf.model.ESFRenewal toEscapedModel() {
		return new ESFRenewalWrapper(_esfRenewal.toEscapedModel());
	}

	@Override
	public it.ethica.esf.model.ESFRenewal toUnescapedModel() {
		return new ESFRenewalWrapper(_esfRenewal.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _esfRenewal.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _esfRenewal.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_esfRenewal.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFRenewalWrapper)) {
			return false;
		}

		ESFRenewalWrapper esfRenewalWrapper = (ESFRenewalWrapper)obj;

		if (Validator.equals(_esfRenewal, esfRenewalWrapper._esfRenewal)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ESFRenewal getWrappedESFRenewal() {
		return _esfRenewal;
	}

	@Override
	public ESFRenewal getWrappedModel() {
		return _esfRenewal;
	}

	@Override
	public void resetOriginalValues() {
		_esfRenewal.resetOriginalValues();
	}

	private ESFRenewal _esfRenewal;
}