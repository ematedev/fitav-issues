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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Ethica
 * @generated
 */
public class ESFCatridgeSoap implements Serializable {
	public static ESFCatridgeSoap toSoapModel(ESFCatridge model) {
		ESFCatridgeSoap soapModel = new ESFCatridgeSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEsfCatridgeId(model.getEsfCatridgeId());
		soapModel.setEsfUserId(model.getEsfUserId());
		soapModel.setEsfGunTypeId(model.getEsfGunTypeId());
		soapModel.setCatridgeModel(model.getCatridgeModel());
		soapModel.setCatridgeCaliber(model.getCatridgeCaliber());
		soapModel.setNote(model.getNote());

		return soapModel;
	}

	public static ESFCatridgeSoap[] toSoapModels(ESFCatridge[] models) {
		ESFCatridgeSoap[] soapModels = new ESFCatridgeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFCatridgeSoap[][] toSoapModels(ESFCatridge[][] models) {
		ESFCatridgeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFCatridgeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFCatridgeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFCatridgeSoap[] toSoapModels(List<ESFCatridge> models) {
		List<ESFCatridgeSoap> soapModels = new ArrayList<ESFCatridgeSoap>(models.size());

		for (ESFCatridge model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFCatridgeSoap[soapModels.size()]);
	}

	public ESFCatridgeSoap() {
	}

	public long getPrimaryKey() {
		return _esfCatridgeId;
	}

	public void setPrimaryKey(long pk) {
		setEsfCatridgeId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEsfCatridgeId() {
		return _esfCatridgeId;
	}

	public void setEsfCatridgeId(long esfCatridgeId) {
		_esfCatridgeId = esfCatridgeId;
	}

	public long getEsfUserId() {
		return _esfUserId;
	}

	public void setEsfUserId(long esfUserId) {
		_esfUserId = esfUserId;
	}

	public long getEsfGunTypeId() {
		return _esfGunTypeId;
	}

	public void setEsfGunTypeId(long esfGunTypeId) {
		_esfGunTypeId = esfGunTypeId;
	}

	public String getCatridgeModel() {
		return _catridgeModel;
	}

	public void setCatridgeModel(String catridgeModel) {
		_catridgeModel = catridgeModel;
	}

	public long getCatridgeCaliber() {
		return _catridgeCaliber;
	}

	public void setCatridgeCaliber(long catridgeCaliber) {
		_catridgeCaliber = catridgeCaliber;
	}

	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
	}

	private String _uuid;
	private long _esfCatridgeId;
	private long _esfUserId;
	private long _esfGunTypeId;
	private String _catridgeModel;
	private long _catridgeCaliber;
	private String _note;
}