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
public class ESFArticleDeliveredSoap implements Serializable {
	public static ESFArticleDeliveredSoap toSoapModel(ESFArticleDelivered model) {
		ESFArticleDeliveredSoap soapModel = new ESFArticleDeliveredSoap();

		soapModel.setEsfArticleDeliveredId(model.getEsfArticleDeliveredId());
		soapModel.setData(model.getData());
		soapModel.setDescription(model.getDescription());
		soapModel.setEsfArticleId(model.getEsfArticleId());
		soapModel.setEsfShooterId(model.getEsfShooterId());
		soapModel.setXxxlQty(model.getXxxlQty());
		soapModel.setXxlQty(model.getXxlQty());
		soapModel.setXlQty(model.getXlQty());
		soapModel.setLQty(model.getLQty());
		soapModel.setMQty(model.getMQty());
		soapModel.setSQty(model.getSQty());
		soapModel.setXsQty(model.getXsQty());
		soapModel.setXxsQty(model.getXxsQty());
		soapModel.setOtherQty(model.getOtherQty());

		return soapModel;
	}

	public static ESFArticleDeliveredSoap[] toSoapModels(
		ESFArticleDelivered[] models) {
		ESFArticleDeliveredSoap[] soapModels = new ESFArticleDeliveredSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFArticleDeliveredSoap[][] toSoapModels(
		ESFArticleDelivered[][] models) {
		ESFArticleDeliveredSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFArticleDeliveredSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFArticleDeliveredSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFArticleDeliveredSoap[] toSoapModels(
		List<ESFArticleDelivered> models) {
		List<ESFArticleDeliveredSoap> soapModels = new ArrayList<ESFArticleDeliveredSoap>(models.size());

		for (ESFArticleDelivered model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFArticleDeliveredSoap[soapModels.size()]);
	}

	public ESFArticleDeliveredSoap() {
	}

	public long getPrimaryKey() {
		return _esfArticleDeliveredId;
	}

	public void setPrimaryKey(long pk) {
		setEsfArticleDeliveredId(pk);
	}

	public long getEsfArticleDeliveredId() {
		return _esfArticleDeliveredId;
	}

	public void setEsfArticleDeliveredId(long esfArticleDeliveredId) {
		_esfArticleDeliveredId = esfArticleDeliveredId;
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

	public long getEsfArticleId() {
		return _esfArticleId;
	}

	public void setEsfArticleId(long esfArticleId) {
		_esfArticleId = esfArticleId;
	}

	public long getEsfShooterId() {
		return _esfShooterId;
	}

	public void setEsfShooterId(long esfShooterId) {
		_esfShooterId = esfShooterId;
	}

	public long getXxxlQty() {
		return _xxxlQty;
	}

	public void setXxxlQty(long xxxlQty) {
		_xxxlQty = xxxlQty;
	}

	public long getXxlQty() {
		return _xxlQty;
	}

	public void setXxlQty(long xxlQty) {
		_xxlQty = xxlQty;
	}

	public long getXlQty() {
		return _xlQty;
	}

	public void setXlQty(long xlQty) {
		_xlQty = xlQty;
	}

	public long getLQty() {
		return _lQty;
	}

	public void setLQty(long lQty) {
		_lQty = lQty;
	}

	public long getMQty() {
		return _mQty;
	}

	public void setMQty(long mQty) {
		_mQty = mQty;
	}

	public long getSQty() {
		return _sQty;
	}

	public void setSQty(long sQty) {
		_sQty = sQty;
	}

	public long getXsQty() {
		return _xsQty;
	}

	public void setXsQty(long xsQty) {
		_xsQty = xsQty;
	}

	public long getXxsQty() {
		return _xxsQty;
	}

	public void setXxsQty(long xxsQty) {
		_xxsQty = xxsQty;
	}

	public long getOtherQty() {
		return _otherQty;
	}

	public void setOtherQty(long otherQty) {
		_otherQty = otherQty;
	}

	private long _esfArticleDeliveredId;
	private Date _data;
	private String _description;
	private long _esfArticleId;
	private long _esfShooterId;
	private long _xxxlQty;
	private long _xxlQty;
	private long _xlQty;
	private long _lQty;
	private long _mQty;
	private long _sQty;
	private long _xsQty;
	private long _xxsQty;
	private long _otherQty;
}