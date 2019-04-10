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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Ethica
 * @generated
 */
public class ESFCaneSoap implements Serializable {
	public static ESFCaneSoap toSoapModel(ESFCane model) {
		ESFCaneSoap soapModel = new ESFCaneSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEsfCaneId(model.getEsfCaneId());
		soapModel.setEsfUserId(model.getEsfUserId());
		soapModel.setCode(model.getCode());
		soapModel.setEsfGunKindId(model.getEsfGunKindId());
		soapModel.setEsfOrganizationId(model.getEsfOrganizationId());
		soapModel.setCaneCaliber(model.getCaneCaliber());
		soapModel.setIsFavoriteGun(model.getIsFavoriteGun());
		soapModel.setTypeId(model.getTypeId());
		soapModel.setMeasures(model.getMeasures());
		soapModel.setShooterId(model.getShooterId());
		soapModel.setEsfGunTypeId(model.getEsfGunTypeId());

		return soapModel;
	}

	public static ESFCaneSoap[] toSoapModels(ESFCane[] models) {
		ESFCaneSoap[] soapModels = new ESFCaneSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFCaneSoap[][] toSoapModels(ESFCane[][] models) {
		ESFCaneSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFCaneSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFCaneSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFCaneSoap[] toSoapModels(List<ESFCane> models) {
		List<ESFCaneSoap> soapModels = new ArrayList<ESFCaneSoap>(models.size());

		for (ESFCane model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFCaneSoap[soapModels.size()]);
	}

	public ESFCaneSoap() {
	}

	public long getPrimaryKey() {
		return _esfCaneId;
	}

	public void setPrimaryKey(long pk) {
		setEsfCaneId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEsfCaneId() {
		return _esfCaneId;
	}

	public void setEsfCaneId(long esfCaneId) {
		_esfCaneId = esfCaneId;
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

	public long getEsfGunKindId() {
		return _esfGunKindId;
	}

	public void setEsfGunKindId(long esfGunKindId) {
		_esfGunKindId = esfGunKindId;
	}

	public long getEsfOrganizationId() {
		return _esfOrganizationId;
	}

	public void setEsfOrganizationId(long esfOrganizationId) {
		_esfOrganizationId = esfOrganizationId;
	}

	public long getCaneCaliber() {
		return _caneCaliber;
	}

	public void setCaneCaliber(long caneCaliber) {
		_caneCaliber = caneCaliber;
	}

	public boolean getIsFavoriteGun() {
		return _isFavoriteGun;
	}

	public boolean isIsFavoriteGun() {
		return _isFavoriteGun;
	}

	public void setIsFavoriteGun(boolean isFavoriteGun) {
		_isFavoriteGun = isFavoriteGun;
	}

	public int getTypeId() {
		return _typeId;
	}

	public void setTypeId(int typeId) {
		_typeId = typeId;
	}

	public String getMeasures() {
		return _measures;
	}

	public void setMeasures(String measures) {
		_measures = measures;
	}

	public long getShooterId() {
		return _shooterId;
	}

	public void setShooterId(long shooterId) {
		_shooterId = shooterId;
	}

	public long getEsfGunTypeId() {
		return _esfGunTypeId;
	}

	public void setEsfGunTypeId(long esfGunTypeId) {
		_esfGunTypeId = esfGunTypeId;
	}

	private String _uuid;
	private long _esfCaneId;
	private long _esfUserId;
	private String _code;
	private long _esfGunKindId;
	private long _esfOrganizationId;
	private long _caneCaliber;
	private boolean _isFavoriteGun;
	private int _typeId;
	private String _measures;
	private long _shooterId;
	private long _esfGunTypeId;
}