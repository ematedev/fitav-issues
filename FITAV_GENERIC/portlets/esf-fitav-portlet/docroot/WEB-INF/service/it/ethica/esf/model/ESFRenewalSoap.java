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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Ethica
 * @generated
 */
public class ESFRenewalSoap implements Serializable {
	public static ESFRenewalSoap toSoapModel(ESFRenewal model) {
		ESFRenewalSoap soapModel = new ESFRenewalSoap();

		soapModel.setEsfRenewalId(model.getEsfRenewalId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setQuantity(model.getQuantity());
		soapModel.setPaymentReason(model.getPaymentReason());
		soapModel.setPaymentType(model.getPaymentType());
		soapModel.setPaymentDate(model.getPaymentDate());
		soapModel.setPaymentReceived(model.getPaymentReceived());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setInfo(model.getInfo());
		soapModel.setMadeBy(model.getMadeBy());
		soapModel.setAmount(model.getAmount());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setReportingYear(model.getReportingYear());
		soapModel.setAmountTotal(model.getAmountTotal());
		soapModel.setIsTotal(model.getIsTotal());
		soapModel.setRenewalFatherId(model.getRenewalFatherId());
		soapModel.setAffiliates(model.getAffiliates());

		return soapModel;
	}

	public static ESFRenewalSoap[] toSoapModels(ESFRenewal[] models) {
		ESFRenewalSoap[] soapModels = new ESFRenewalSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFRenewalSoap[][] toSoapModels(ESFRenewal[][] models) {
		ESFRenewalSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFRenewalSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFRenewalSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFRenewalSoap[] toSoapModels(List<ESFRenewal> models) {
		List<ESFRenewalSoap> soapModels = new ArrayList<ESFRenewalSoap>(models.size());

		for (ESFRenewal model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFRenewalSoap[soapModels.size()]);
	}

	public ESFRenewalSoap() {
	}

	public long getPrimaryKey() {
		return _esfRenewalId;
	}

	public void setPrimaryKey(long pk) {
		setEsfRenewalId(pk);
	}

	public long getEsfRenewalId() {
		return _esfRenewalId;
	}

	public void setEsfRenewalId(long esfRenewalId) {
		_esfRenewalId = esfRenewalId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getQuantity() {
		return _quantity;
	}

	public void setQuantity(long quantity) {
		_quantity = quantity;
	}

	public String getPaymentReason() {
		return _paymentReason;
	}

	public void setPaymentReason(String paymentReason) {
		_paymentReason = paymentReason;
	}

	public String getPaymentType() {
		return _paymentType;
	}

	public void setPaymentType(String paymentType) {
		_paymentType = paymentType;
	}

	public Date getPaymentDate() {
		return _paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		_paymentDate = paymentDate;
	}

	public boolean getPaymentReceived() {
		return _paymentReceived;
	}

	public boolean isPaymentReceived() {
		return _paymentReceived;
	}

	public void setPaymentReceived(boolean paymentReceived) {
		_paymentReceived = paymentReceived;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public String getInfo() {
		return _info;
	}

	public void setInfo(String info) {
		_info = info;
	}

	public String getMadeBy() {
		return _madeBy;
	}

	public void setMadeBy(String madeBy) {
		_madeBy = madeBy;
	}

	public double getAmount() {
		return _amount;
	}

	public void setAmount(double amount) {
		_amount = amount;
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	public int getReportingYear() {
		return _reportingYear;
	}

	public void setReportingYear(int reportingYear) {
		_reportingYear = reportingYear;
	}

	public double getAmountTotal() {
		return _amountTotal;
	}

	public void setAmountTotal(double amountTotal) {
		_amountTotal = amountTotal;
	}

	public boolean getIsTotal() {
		return _isTotal;
	}

	public boolean isIsTotal() {
		return _isTotal;
	}

	public void setIsTotal(boolean isTotal) {
		_isTotal = isTotal;
	}

	public long getRenewalFatherId() {
		return _renewalFatherId;
	}

	public void setRenewalFatherId(long renewalFatherId) {
		_renewalFatherId = renewalFatherId;
	}

	public boolean getAffiliates() {
		return _affiliates;
	}

	public boolean isAffiliates() {
		return _affiliates;
	}

	public void setAffiliates(boolean affiliates) {
		_affiliates = affiliates;
	}

	private long _esfRenewalId;
	private long _companyId;
	private long _userId;
	private Date _modifiedDate;
	private long _quantity;
	private String _paymentReason;
	private String _paymentType;
	private Date _paymentDate;
	private boolean _paymentReceived;
	private Date _createDate;
	private long _groupId;
	private String _info;
	private String _madeBy;
	private double _amount;
	private long _organizationId;
	private int _reportingYear;
	private double _amountTotal;
	private boolean _isTotal;
	private long _renewalFatherId;
	private boolean _affiliates;
}