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
public class ESFLentFieldSoap implements Serializable {
	public static ESFLentFieldSoap toSoapModel(ESFLentField model) {
		ESFLentFieldSoap soapModel = new ESFLentFieldSoap();

		soapModel.setLentFieldId(model.getLentFieldId());
		soapModel.setEsfEntityStateId(model.getEsfEntityStateId());
		soapModel.setEsfFieldId(model.getEsfFieldId());
		soapModel.setRealOwnerId(model.getRealOwnerId());
		soapModel.setActualOwnerId(model.getActualOwnerId());

		return soapModel;
	}

	public static ESFLentFieldSoap[] toSoapModels(ESFLentField[] models) {
		ESFLentFieldSoap[] soapModels = new ESFLentFieldSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFLentFieldSoap[][] toSoapModels(ESFLentField[][] models) {
		ESFLentFieldSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFLentFieldSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFLentFieldSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFLentFieldSoap[] toSoapModels(List<ESFLentField> models) {
		List<ESFLentFieldSoap> soapModels = new ArrayList<ESFLentFieldSoap>(models.size());

		for (ESFLentField model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFLentFieldSoap[soapModels.size()]);
	}

	public ESFLentFieldSoap() {
	}

	public long getPrimaryKey() {
		return _lentFieldId;
	}

	public void setPrimaryKey(long pk) {
		setLentFieldId(pk);
	}

	public long getLentFieldId() {
		return _lentFieldId;
	}

	public void setLentFieldId(long lentFieldId) {
		_lentFieldId = lentFieldId;
	}

	public long getEsfEntityStateId() {
		return _esfEntityStateId;
	}

	public void setEsfEntityStateId(long esfEntityStateId) {
		_esfEntityStateId = esfEntityStateId;
	}

	public long getEsfFieldId() {
		return _esfFieldId;
	}

	public void setEsfFieldId(long esfFieldId) {
		_esfFieldId = esfFieldId;
	}

	public long getRealOwnerId() {
		return _realOwnerId;
	}

	public void setRealOwnerId(long realOwnerId) {
		_realOwnerId = realOwnerId;
	}

	public long getActualOwnerId() {
		return _actualOwnerId;
	}

	public void setActualOwnerId(long actualOwnerId) {
		_actualOwnerId = actualOwnerId;
	}

	private long _lentFieldId;
	private long _esfEntityStateId;
	private long _esfFieldId;
	private long _realOwnerId;
	private long _actualOwnerId;
}