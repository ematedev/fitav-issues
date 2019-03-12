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
public class ESFgunUserSoap implements Serializable {
	public static ESFgunUserSoap toSoapModel(ESFgunUser model) {
		ESFgunUserSoap soapModel = new ESFgunUserSoap();

		soapModel.setEsfGunUserId(model.getEsfGunUserId());
		soapModel.setEsfGunId(model.getEsfGunId());
		soapModel.setEsfUserId(model.getEsfUserId());
		soapModel.setCode(model.getCode());
		soapModel.setIsFavorite(model.getIsFavorite());
		soapModel.setType(model.getType());
		soapModel.setNote(model.getNote());
		soapModel.setEsfGunnTypeId(model.getEsfGunnTypeId());
		soapModel.setEsfGunKindId(model.getEsfGunKindId());
		soapModel.setTypeId(model.getTypeId());
		soapModel.setEsfMeasures(model.getEsfMeasures());
		soapModel.setEsfCaliber(model.getEsfCaliber());

		return soapModel;
	}

	public static ESFgunUserSoap[] toSoapModels(ESFgunUser[] models) {
		ESFgunUserSoap[] soapModels = new ESFgunUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFgunUserSoap[][] toSoapModels(ESFgunUser[][] models) {
		ESFgunUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFgunUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFgunUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFgunUserSoap[] toSoapModels(List<ESFgunUser> models) {
		List<ESFgunUserSoap> soapModels = new ArrayList<ESFgunUserSoap>(models.size());

		for (ESFgunUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFgunUserSoap[soapModels.size()]);
	}

	public ESFgunUserSoap() {
	}

	public long getPrimaryKey() {
		return _esfGunUserId;
	}

	public void setPrimaryKey(long pk) {
		setEsfGunUserId(pk);
	}

	public long getEsfGunUserId() {
		return _esfGunUserId;
	}

	public void setEsfGunUserId(long esfGunUserId) {
		_esfGunUserId = esfGunUserId;
	}

	public long getEsfGunId() {
		return _esfGunId;
	}

	public void setEsfGunId(long esfGunId) {
		_esfGunId = esfGunId;
	}

	public long getEsfUserId() {
		return _esfUserId;
	}

	public void setEsfUserId(long esfUserId) {
		_esfUserId = esfUserId;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public boolean getIsFavorite() {
		return _isFavorite;
	}

	public boolean isIsFavorite() {
		return _isFavorite;
	}

	public void setIsFavorite(boolean isFavorite) {
		_isFavorite = isFavorite;
	}

	public int getType() {
		return _type;
	}

	public void setType(int type) {
		_type = type;
	}

	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
	}

	public long getEsfGunnTypeId() {
		return _esfGunnTypeId;
	}

	public void setEsfGunnTypeId(long esfGunnTypeId) {
		_esfGunnTypeId = esfGunnTypeId;
	}

	public long getEsfGunKindId() {
		return _esfGunKindId;
	}

	public void setEsfGunKindId(long esfGunKindId) {
		_esfGunKindId = esfGunKindId;
	}

	public long getTypeId() {
		return _typeId;
	}

	public void setTypeId(long typeId) {
		_typeId = typeId;
	}

	public String getEsfMeasures() {
		return _esfMeasures;
	}

	public void setEsfMeasures(String esfMeasures) {
		_esfMeasures = esfMeasures;
	}

	public String getEsfCaliber() {
		return _esfCaliber;
	}

	public void setEsfCaliber(String esfCaliber) {
		_esfCaliber = esfCaliber;
	}

	private long _esfGunUserId;
	private long _esfGunId;
	private long _esfUserId;
	private String _code;
	private boolean _isFavorite;
	private int _type;
	private String _note;
	private long _esfGunnTypeId;
	private long _esfGunKindId;
	private long _typeId;
	private String _esfMeasures;
	private String _esfCaliber;
}