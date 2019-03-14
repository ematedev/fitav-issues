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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ESFRenewal service. Represents a row in the &quot;ESFRenewal&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link it.ethica.esf.model.impl.ESFRenewalModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link it.ethica.esf.model.impl.ESFRenewalImpl}.
 * </p>
 *
 * @author Ethica
 * @see ESFRenewal
 * @see it.ethica.esf.model.impl.ESFRenewalImpl
 * @see it.ethica.esf.model.impl.ESFRenewalModelImpl
 * @generated
 */
public interface ESFRenewalModel extends BaseModel<ESFRenewal> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a e s f renewal model instance should use the {@link ESFRenewal} interface instead.
	 */

	/**
	 * Returns the primary key of this e s f renewal.
	 *
	 * @return the primary key of this e s f renewal
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this e s f renewal.
	 *
	 * @param primaryKey the primary key of this e s f renewal
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the esf renewal ID of this e s f renewal.
	 *
	 * @return the esf renewal ID of this e s f renewal
	 */
	public long getEsfRenewalId();

	/**
	 * Sets the esf renewal ID of this e s f renewal.
	 *
	 * @param esfRenewalId the esf renewal ID of this e s f renewal
	 */
	public void setEsfRenewalId(long esfRenewalId);

	/**
	 * Returns the company ID of this e s f renewal.
	 *
	 * @return the company ID of this e s f renewal
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this e s f renewal.
	 *
	 * @param companyId the company ID of this e s f renewal
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this e s f renewal.
	 *
	 * @return the user ID of this e s f renewal
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this e s f renewal.
	 *
	 * @param userId the user ID of this e s f renewal
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this e s f renewal.
	 *
	 * @return the user uuid of this e s f renewal
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this e s f renewal.
	 *
	 * @param userUuid the user uuid of this e s f renewal
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the modified date of this e s f renewal.
	 *
	 * @return the modified date of this e s f renewal
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this e s f renewal.
	 *
	 * @param modifiedDate the modified date of this e s f renewal
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the quantity of this e s f renewal.
	 *
	 * @return the quantity of this e s f renewal
	 */
	public long getQuantity();

	/**
	 * Sets the quantity of this e s f renewal.
	 *
	 * @param quantity the quantity of this e s f renewal
	 */
	public void setQuantity(long quantity);

	/**
	 * Returns the payment reason of this e s f renewal.
	 *
	 * @return the payment reason of this e s f renewal
	 */
	@AutoEscape
	public String getPaymentReason();

	/**
	 * Sets the payment reason of this e s f renewal.
	 *
	 * @param paymentReason the payment reason of this e s f renewal
	 */
	public void setPaymentReason(String paymentReason);

	/**
	 * Returns the payment type of this e s f renewal.
	 *
	 * @return the payment type of this e s f renewal
	 */
	@AutoEscape
	public String getPaymentType();

	/**
	 * Sets the payment type of this e s f renewal.
	 *
	 * @param paymentType the payment type of this e s f renewal
	 */
	public void setPaymentType(String paymentType);

	/**
	 * Returns the payment date of this e s f renewal.
	 *
	 * @return the payment date of this e s f renewal
	 */
	public Date getPaymentDate();

	/**
	 * Sets the payment date of this e s f renewal.
	 *
	 * @param paymentDate the payment date of this e s f renewal
	 */
	public void setPaymentDate(Date paymentDate);

	/**
	 * Returns the payment received of this e s f renewal.
	 *
	 * @return the payment received of this e s f renewal
	 */
	public boolean getPaymentReceived();

	/**
	 * Returns <code>true</code> if this e s f renewal is payment received.
	 *
	 * @return <code>true</code> if this e s f renewal is payment received; <code>false</code> otherwise
	 */
	public boolean isPaymentReceived();

	/**
	 * Sets whether this e s f renewal is payment received.
	 *
	 * @param paymentReceived the payment received of this e s f renewal
	 */
	public void setPaymentReceived(boolean paymentReceived);

	/**
	 * Returns the create date of this e s f renewal.
	 *
	 * @return the create date of this e s f renewal
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this e s f renewal.
	 *
	 * @param createDate the create date of this e s f renewal
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the group ID of this e s f renewal.
	 *
	 * @return the group ID of this e s f renewal
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this e s f renewal.
	 *
	 * @param groupId the group ID of this e s f renewal
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the info of this e s f renewal.
	 *
	 * @return the info of this e s f renewal
	 */
	@AutoEscape
	public String getInfo();

	/**
	 * Sets the info of this e s f renewal.
	 *
	 * @param info the info of this e s f renewal
	 */
	public void setInfo(String info);

	/**
	 * Returns the made by of this e s f renewal.
	 *
	 * @return the made by of this e s f renewal
	 */
	@AutoEscape
	public String getMadeBy();

	/**
	 * Sets the made by of this e s f renewal.
	 *
	 * @param madeBy the made by of this e s f renewal
	 */
	public void setMadeBy(String madeBy);

	/**
	 * Returns the amount of this e s f renewal.
	 *
	 * @return the amount of this e s f renewal
	 */
	public double getAmount();

	/**
	 * Sets the amount of this e s f renewal.
	 *
	 * @param amount the amount of this e s f renewal
	 */
	public void setAmount(double amount);

	/**
	 * Returns the organization ID of this e s f renewal.
	 *
	 * @return the organization ID of this e s f renewal
	 */
	public long getOrganizationId();

	/**
	 * Sets the organization ID of this e s f renewal.
	 *
	 * @param organizationId the organization ID of this e s f renewal
	 */
	public void setOrganizationId(long organizationId);

	/**
	 * Returns the reporting year of this e s f renewal.
	 *
	 * @return the reporting year of this e s f renewal
	 */
	public int getReportingYear();

	/**
	 * Sets the reporting year of this e s f renewal.
	 *
	 * @param reportingYear the reporting year of this e s f renewal
	 */
	public void setReportingYear(int reportingYear);

	/**
	 * Returns the amount total of this e s f renewal.
	 *
	 * @return the amount total of this e s f renewal
	 */
	public double getAmountTotal();

	/**
	 * Sets the amount total of this e s f renewal.
	 *
	 * @param amountTotal the amount total of this e s f renewal
	 */
	public void setAmountTotal(double amountTotal);

	/**
	 * Returns the is total of this e s f renewal.
	 *
	 * @return the is total of this e s f renewal
	 */
	public boolean getIsTotal();

	/**
	 * Returns <code>true</code> if this e s f renewal is is total.
	 *
	 * @return <code>true</code> if this e s f renewal is is total; <code>false</code> otherwise
	 */
	public boolean isIsTotal();

	/**
	 * Sets whether this e s f renewal is is total.
	 *
	 * @param isTotal the is total of this e s f renewal
	 */
	public void setIsTotal(boolean isTotal);

	/**
	 * Returns the renewal father ID of this e s f renewal.
	 *
	 * @return the renewal father ID of this e s f renewal
	 */
	public long getRenewalFatherId();

	/**
	 * Sets the renewal father ID of this e s f renewal.
	 *
	 * @param renewalFatherId the renewal father ID of this e s f renewal
	 */
	public void setRenewalFatherId(long renewalFatherId);

	/**
	 * Returns the affiliates of this e s f renewal.
	 *
	 * @return the affiliates of this e s f renewal
	 */
	public boolean getAffiliates();

	/**
	 * Returns <code>true</code> if this e s f renewal is affiliates.
	 *
	 * @return <code>true</code> if this e s f renewal is affiliates; <code>false</code> otherwise
	 */
	public boolean isAffiliates();

	/**
	 * Sets whether this e s f renewal is affiliates.
	 *
	 * @param affiliates the affiliates of this e s f renewal
	 */
	public void setAffiliates(boolean affiliates);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(ESFRenewal esfRenewal);

	@Override
	public int hashCode();

	@Override
	public CacheModel<ESFRenewal> toCacheModel();

	@Override
	public ESFRenewal toEscapedModel();

	@Override
	public ESFRenewal toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}