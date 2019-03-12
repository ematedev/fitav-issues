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

package com.ethica.esf.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Ethica
 * @generated
 */
public class ESFStockistSoap implements Serializable {
	public static ESFStockistSoap toSoapModel(ESFStockist model) {
		ESFStockistSoap soapModel = new ESFStockistSoap();

		soapModel.setEsfStockistId(model.getEsfStockistId());
		soapModel.setName(model.getName());
		soapModel.setEmail(model.getEmail());
		soapModel.setPhone(model.getPhone());
		soapModel.setAddress(model.getAddress());
		soapModel.setDescription(model.getDescription());
		soapModel.setOther(model.getOther());
		soapModel.setNameReference(model.getNameReference());
		soapModel.setLastNameReference(model.getLastNameReference());
		soapModel.setEmailReference(model.getEmailReference());
		soapModel.setPhoneReference(model.getPhoneReference());
		soapModel.setVatNumber(model.getVatNumber());
		soapModel.setIban(model.getIban());

		return soapModel;
	}

	public static ESFStockistSoap[] toSoapModels(ESFStockist[] models) {
		ESFStockistSoap[] soapModels = new ESFStockistSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFStockistSoap[][] toSoapModels(ESFStockist[][] models) {
		ESFStockistSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFStockistSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFStockistSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFStockistSoap[] toSoapModels(List<ESFStockist> models) {
		List<ESFStockistSoap> soapModels = new ArrayList<ESFStockistSoap>(models.size());

		for (ESFStockist model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFStockistSoap[soapModels.size()]);
	}

	public ESFStockistSoap() {
	}

	public long getPrimaryKey() {
		return _esfStockistId;
	}

	public void setPrimaryKey(long pk) {
		setEsfStockistId(pk);
	}

	public long getEsfStockistId() {
		return _esfStockistId;
	}

	public void setEsfStockistId(long esfStockistId) {
		_esfStockistId = esfStockistId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getPhone() {
		return _phone;
	}

	public void setPhone(String phone) {
		_phone = phone;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getOther() {
		return _other;
	}

	public void setOther(String other) {
		_other = other;
	}

	public String getNameReference() {
		return _nameReference;
	}

	public void setNameReference(String nameReference) {
		_nameReference = nameReference;
	}

	public String getLastNameReference() {
		return _lastNameReference;
	}

	public void setLastNameReference(String lastNameReference) {
		_lastNameReference = lastNameReference;
	}

	public String getEmailReference() {
		return _emailReference;
	}

	public void setEmailReference(String emailReference) {
		_emailReference = emailReference;
	}

	public String getPhoneReference() {
		return _phoneReference;
	}

	public void setPhoneReference(String phoneReference) {
		_phoneReference = phoneReference;
	}

	public String getVatNumber() {
		return _vatNumber;
	}

	public void setVatNumber(String vatNumber) {
		_vatNumber = vatNumber;
	}

	public String getIban() {
		return _iban;
	}

	public void setIban(String iban) {
		_iban = iban;
	}

	private long _esfStockistId;
	private String _name;
	private String _email;
	private String _phone;
	private String _address;
	private String _description;
	private String _other;
	private String _nameReference;
	private String _lastNameReference;
	private String _emailReference;
	private String _phoneReference;
	private String _vatNumber;
	private String _iban;
}