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

import com.ethica.esf.service.persistence.ESFArticle_ESFUserPK;

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
public class ESFArticle_ESFUserSoap implements Serializable {
	public static ESFArticle_ESFUserSoap toSoapModel(ESFArticle_ESFUser model) {
		ESFArticle_ESFUserSoap soapModel = new ESFArticle_ESFUserSoap();

		soapModel.setEsfArticleId(model.getEsfArticleId());
		soapModel.setEsfUserId(model.getEsfUserId());
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
		soapModel.setDescription(model.getDescription());
		soapModel.setDeliveryDate(model.getDeliveryDate());

		return soapModel;
	}

	public static ESFArticle_ESFUserSoap[] toSoapModels(
		ESFArticle_ESFUser[] models) {
		ESFArticle_ESFUserSoap[] soapModels = new ESFArticle_ESFUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFArticle_ESFUserSoap[][] toSoapModels(
		ESFArticle_ESFUser[][] models) {
		ESFArticle_ESFUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFArticle_ESFUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFArticle_ESFUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFArticle_ESFUserSoap[] toSoapModels(
		List<ESFArticle_ESFUser> models) {
		List<ESFArticle_ESFUserSoap> soapModels = new ArrayList<ESFArticle_ESFUserSoap>(models.size());

		for (ESFArticle_ESFUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFArticle_ESFUserSoap[soapModels.size()]);
	}

	public ESFArticle_ESFUserSoap() {
	}

	public ESFArticle_ESFUserPK getPrimaryKey() {
		return new ESFArticle_ESFUserPK(_esfArticleId, _esfUserId);
	}

	public void setPrimaryKey(ESFArticle_ESFUserPK pk) {
		setEsfArticleId(pk.esfArticleId);
		setEsfUserId(pk.esfUserId);
	}

	public long getEsfArticleId() {
		return _esfArticleId;
	}

	public void setEsfArticleId(long esfArticleId) {
		_esfArticleId = esfArticleId;
	}

	public long getEsfUserId() {
		return _esfUserId;
	}

	public void setEsfUserId(long esfUserId) {
		_esfUserId = esfUserId;
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

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public Date getDeliveryDate() {
		return _deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		_deliveryDate = deliveryDate;
	}

	private long _esfArticleId;
	private long _esfUserId;
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
	private String _description;
	private Date _deliveryDate;
}