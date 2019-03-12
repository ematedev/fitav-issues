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
public class ESFBillSoap implements Serializable {
	public static ESFBillSoap toSoapModel(ESFBill model) {
		ESFBillSoap soapModel = new ESFBillSoap();

		soapModel.setEsfBillId(model.getEsfBillId());
		soapModel.setEsfArticleId(model.getEsfArticleId());
		soapModel.setEsfOrderId(model.getEsfOrderId());
		soapModel.setBillNumber(model.getBillNumber());
		soapModel.setXxxlQty(model.getXxxlQty());
		soapModel.setXxlQty(model.getXxlQty());
		soapModel.setXlQty(model.getXlQty());
		soapModel.setLQty(model.getLQty());
		soapModel.setMQty(model.getMQty());
		soapModel.setSQty(model.getSQty());
		soapModel.setXsQty(model.getXsQty());
		soapModel.setXxsQty(model.getXxsQty());
		soapModel.setOtherQty(model.getOtherQty());
		soapModel.setTotalQty(model.getTotalQty());

		return soapModel;
	}

	public static ESFBillSoap[] toSoapModels(ESFBill[] models) {
		ESFBillSoap[] soapModels = new ESFBillSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFBillSoap[][] toSoapModels(ESFBill[][] models) {
		ESFBillSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFBillSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFBillSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFBillSoap[] toSoapModels(List<ESFBill> models) {
		List<ESFBillSoap> soapModels = new ArrayList<ESFBillSoap>(models.size());

		for (ESFBill model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFBillSoap[soapModels.size()]);
	}

	public ESFBillSoap() {
	}

	public long getPrimaryKey() {
		return _esfBillId;
	}

	public void setPrimaryKey(long pk) {
		setEsfBillId(pk);
	}

	public long getEsfBillId() {
		return _esfBillId;
	}

	public void setEsfBillId(long esfBillId) {
		_esfBillId = esfBillId;
	}

	public long getEsfArticleId() {
		return _esfArticleId;
	}

	public void setEsfArticleId(long esfArticleId) {
		_esfArticleId = esfArticleId;
	}

	public long getEsfOrderId() {
		return _esfOrderId;
	}

	public void setEsfOrderId(long esfOrderId) {
		_esfOrderId = esfOrderId;
	}

	public String getBillNumber() {
		return _billNumber;
	}

	public void setBillNumber(String billNumber) {
		_billNumber = billNumber;
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

	public long getTotalQty() {
		return _totalQty;
	}

	public void setTotalQty(long totalQty) {
		_totalQty = totalQty;
	}

	private long _esfBillId;
	private long _esfArticleId;
	private long _esfOrderId;
	private String _billNumber;
	private long _xxxlQty;
	private long _xxlQty;
	private long _xlQty;
	private long _lQty;
	private long _mQty;
	private long _sQty;
	private long _xsQty;
	private long _xxsQty;
	private long _otherQty;
	private long _totalQty;
}