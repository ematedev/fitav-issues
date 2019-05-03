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
public class ESFRenewalCompanySoap implements Serializable {
	public static ESFRenewalCompanySoap toSoapModel(ESFRenewalCompany model) {
		ESFRenewalCompanySoap soapModel = new ESFRenewalCompanySoap();

		soapModel.setEsfRenewalCompanyId(model.getEsfRenewalCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setEsfOrganizationId(model.getEsfOrganizationId());
		soapModel.setCardsNumber(model.getCardsNumber());
		soapModel.setYear(model.getYear());
		soapModel.setDate(model.getDate());
		soapModel.setPaymentType(model.getPaymentType());
		soapModel.setStatus(model.getStatus());
		soapModel.setAmount(model.getAmount());
		soapModel.setInfo(model.getInfo());
		soapModel.setAccountholder(model.getAccountholder());
		soapModel.setPaymentDate(model.getPaymentDate());
		soapModel.setIntegrationAmount(model.getIntegrationAmount());
		soapModel.setIntegrationDate(model.getIntegrationDate());
		soapModel.setIntegrationType(model.getIntegrationType());
		soapModel.setIntegrationAccountholder(model.getIntegrationAccountholder());
		soapModel.setJoin(model.getJoin());

		return soapModel;
	}

	public static ESFRenewalCompanySoap[] toSoapModels(
		ESFRenewalCompany[] models) {
		ESFRenewalCompanySoap[] soapModels = new ESFRenewalCompanySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFRenewalCompanySoap[][] toSoapModels(
		ESFRenewalCompany[][] models) {
		ESFRenewalCompanySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFRenewalCompanySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFRenewalCompanySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFRenewalCompanySoap[] toSoapModels(
		List<ESFRenewalCompany> models) {
		List<ESFRenewalCompanySoap> soapModels = new ArrayList<ESFRenewalCompanySoap>(models.size());

		for (ESFRenewalCompany model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFRenewalCompanySoap[soapModels.size()]);
	}

	public ESFRenewalCompanySoap() {
	}

	public long getPrimaryKey() {
		return _esfRenewalCompanyId;
	}

	public void setPrimaryKey(long pk) {
		setEsfRenewalCompanyId(pk);
	}

	public long getEsfRenewalCompanyId() {
		return _esfRenewalCompanyId;
	}

	public void setEsfRenewalCompanyId(long esfRenewalCompanyId) {
		_esfRenewalCompanyId = esfRenewalCompanyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getEsfOrganizationId() {
		return _esfOrganizationId;
	}

	public void setEsfOrganizationId(long esfOrganizationId) {
		_esfOrganizationId = esfOrganizationId;
	}

	public int getCardsNumber() {
		return _cardsNumber;
	}

	public void setCardsNumber(int cardsNumber) {
		_cardsNumber = cardsNumber;
	}

	public int getYear() {
		return _year;
	}

	public void setYear(int year) {
		_year = year;
	}

	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		_date = date;
	}

	public int getPaymentType() {
		return _paymentType;
	}

	public void setPaymentType(int paymentType) {
		_paymentType = paymentType;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public double getAmount() {
		return _amount;
	}

	public void setAmount(double amount) {
		_amount = amount;
	}

	public String getInfo() {
		return _info;
	}

	public void setInfo(String info) {
		_info = info;
	}

	public String getAccountholder() {
		return _accountholder;
	}

	public void setAccountholder(String accountholder) {
		_accountholder = accountholder;
	}

	public Date getPaymentDate() {
		return _paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		_paymentDate = paymentDate;
	}

	public double getIntegrationAmount() {
		return _integrationAmount;
	}

	public void setIntegrationAmount(double integrationAmount) {
		_integrationAmount = integrationAmount;
	}

	public Date getIntegrationDate() {
		return _integrationDate;
	}

	public void setIntegrationDate(Date integrationDate) {
		_integrationDate = integrationDate;
	}

	public int getIntegrationType() {
		return _integrationType;
	}

	public void setIntegrationType(int integrationType) {
		_integrationType = integrationType;
	}

	public String getIntegrationAccountholder() {
		return _integrationAccountholder;
	}

	public void setIntegrationAccountholder(String integrationAccountholder) {
		_integrationAccountholder = integrationAccountholder;
	}

	public boolean getJoin() {
		return _join;
	}

	public boolean isJoin() {
		return _join;
	}

	public void setJoin(boolean join) {
		_join = join;
	}

	private long _esfRenewalCompanyId;
	private long _userId;
	private long _esfOrganizationId;
	private int _cardsNumber;
	private int _year;
	private Date _date;
	private int _paymentType;
	private int _status;
	private double _amount;
	private String _info;
	private String _accountholder;
	private Date _paymentDate;
	private double _integrationAmount;
	private Date _integrationDate;
	private int _integrationType;
	private String _integrationAccountholder;
	private boolean _join;
}