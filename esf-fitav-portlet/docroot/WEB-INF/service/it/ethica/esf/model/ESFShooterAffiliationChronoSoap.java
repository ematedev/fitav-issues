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
public class ESFShooterAffiliationChronoSoap implements Serializable {
	public static ESFShooterAffiliationChronoSoap toSoapModel(
		ESFShooterAffiliationChrono model) {
		ESFShooterAffiliationChronoSoap soapModel = new ESFShooterAffiliationChronoSoap();

		soapModel.setEsfShooterAffiliationChronoId(model.getEsfShooterAffiliationChronoId());
		soapModel.setEsfuserId(model.getEsfuserId());
		soapModel.setAffiliationDate(model.getAffiliationDate());
		soapModel.setYear(model.getYear());
		soapModel.setVcampo(model.getVcampo());
		soapModel.setPaymentDate(model.getPaymentDate());
		soapModel.setPayment(model.getPayment());
		soapModel.setCard(model.getCard());
		soapModel.setEsfOrganization(model.getEsfOrganization());
		soapModel.setNote(model.getNote());

		return soapModel;
	}

	public static ESFShooterAffiliationChronoSoap[] toSoapModels(
		ESFShooterAffiliationChrono[] models) {
		ESFShooterAffiliationChronoSoap[] soapModels = new ESFShooterAffiliationChronoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFShooterAffiliationChronoSoap[][] toSoapModels(
		ESFShooterAffiliationChrono[][] models) {
		ESFShooterAffiliationChronoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFShooterAffiliationChronoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFShooterAffiliationChronoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFShooterAffiliationChronoSoap[] toSoapModels(
		List<ESFShooterAffiliationChrono> models) {
		List<ESFShooterAffiliationChronoSoap> soapModels = new ArrayList<ESFShooterAffiliationChronoSoap>(models.size());

		for (ESFShooterAffiliationChrono model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFShooterAffiliationChronoSoap[soapModels.size()]);
	}

	public ESFShooterAffiliationChronoSoap() {
	}

	public long getPrimaryKey() {
		return _esfShooterAffiliationChronoId;
	}

	public void setPrimaryKey(long pk) {
		setEsfShooterAffiliationChronoId(pk);
	}

	public long getEsfShooterAffiliationChronoId() {
		return _esfShooterAffiliationChronoId;
	}

	public void setEsfShooterAffiliationChronoId(
		long esfShooterAffiliationChronoId) {
		_esfShooterAffiliationChronoId = esfShooterAffiliationChronoId;
	}

	public long getEsfuserId() {
		return _esfuserId;
	}

	public void setEsfuserId(long esfuserId) {
		_esfuserId = esfuserId;
	}

	public Date getAffiliationDate() {
		return _affiliationDate;
	}

	public void setAffiliationDate(Date affiliationDate) {
		_affiliationDate = affiliationDate;
	}

	public int getYear() {
		return _year;
	}

	public void setYear(int year) {
		_year = year;
	}

	public String getVcampo() {
		return _Vcampo;
	}

	public void setVcampo(String Vcampo) {
		_Vcampo = Vcampo;
	}

	public Date getPaymentDate() {
		return _paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		_paymentDate = paymentDate;
	}

	public String getPayment() {
		return _payment;
	}

	public void setPayment(String payment) {
		_payment = payment;
	}

	public String getCard() {
		return _card;
	}

	public void setCard(String card) {
		_card = card;
	}

	public String getEsfOrganization() {
		return _esfOrganization;
	}

	public void setEsfOrganization(String esfOrganization) {
		_esfOrganization = esfOrganization;
	}

	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
	}

	private long _esfShooterAffiliationChronoId;
	private long _esfuserId;
	private Date _affiliationDate;
	private int _year;
	private String _Vcampo;
	private Date _paymentDate;
	private String _payment;
	private String _card;
	private String _esfOrganization;
	private String _note;
}