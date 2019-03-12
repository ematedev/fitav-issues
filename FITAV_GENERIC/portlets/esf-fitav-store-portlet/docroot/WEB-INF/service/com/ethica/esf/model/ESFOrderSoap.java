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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Ethica
 * @generated
 */
public class ESFOrderSoap implements Serializable {
	public static ESFOrderSoap toSoapModel(ESFOrder model) {
		ESFOrderSoap soapModel = new ESFOrderSoap();

		soapModel.setEsfOrderId(model.getEsfOrderId());
		soapModel.setCode(model.getCode());
		soapModel.setData(model.getData());
		soapModel.setDescription(model.getDescription());
		soapModel.setEsfStockistId(model.getEsfStockistId());
		soapModel.setQty(model.getQty());
		soapModel.setEsfArticleId(model.getEsfArticleId());

		return soapModel;
	}

	public static ESFOrderSoap[] toSoapModels(ESFOrder[] models) {
		ESFOrderSoap[] soapModels = new ESFOrderSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFOrderSoap[][] toSoapModels(ESFOrder[][] models) {
		ESFOrderSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFOrderSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFOrderSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFOrderSoap[] toSoapModels(List<ESFOrder> models) {
		List<ESFOrderSoap> soapModels = new ArrayList<ESFOrderSoap>(models.size());

		for (ESFOrder model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFOrderSoap[soapModels.size()]);
	}

	public ESFOrderSoap() {
	}

	public long getPrimaryKey() {
		return _esfOrderId;
	}

	public void setPrimaryKey(long pk) {
		setEsfOrderId(pk);
	}

	public long getEsfOrderId() {
		return _esfOrderId;
	}

	public void setEsfOrderId(long esfOrderId) {
		_esfOrderId = esfOrderId;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public Date getData() {
		return _data;
	}

	public void setData(Date data) {
		_data = data;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public long getEsfStockistId() {
		return _esfStockistId;
	}

	public void setEsfStockistId(long esfStockistId) {
		_esfStockistId = esfStockistId;
	}

	public long getQty() {
		return _qty;
	}

	public void setQty(long qty) {
		_qty = qty;
	}

	public long getEsfArticleId() {
		return _esfArticleId;
	}

	public void setEsfArticleId(long esfArticleId) {
		_esfArticleId = esfArticleId;
	}

	private long _esfOrderId;
	private String _code;
	private Date _data;
	private String _description;
	private long _esfStockistId;
	private long _qty;
	private long _esfArticleId;
}