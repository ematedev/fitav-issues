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
public class ESFPhoneSoap implements Serializable {
	public static ESFPhoneSoap toSoapModel(ESFPhone model) {
		ESFPhoneSoap soapModel = new ESFPhoneSoap();

		soapModel.setEsfPhoneId(model.getEsfPhoneId());
		soapModel.setListTypeId(model.getListTypeId());

		return soapModel;
	}

	public static ESFPhoneSoap[] toSoapModels(ESFPhone[] models) {
		ESFPhoneSoap[] soapModels = new ESFPhoneSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFPhoneSoap[][] toSoapModels(ESFPhone[][] models) {
		ESFPhoneSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFPhoneSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFPhoneSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFPhoneSoap[] toSoapModels(List<ESFPhone> models) {
		List<ESFPhoneSoap> soapModels = new ArrayList<ESFPhoneSoap>(models.size());

		for (ESFPhone model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFPhoneSoap[soapModels.size()]);
	}

	public ESFPhoneSoap() {
	}

	public long getPrimaryKey() {
		return _esfPhoneId;
	}

	public void setPrimaryKey(long pk) {
		setEsfPhoneId(pk);
	}

	public long getEsfPhoneId() {
		return _esfPhoneId;
	}

	public void setEsfPhoneId(long esfPhoneId) {
		_esfPhoneId = esfPhoneId;
	}

	public int getListTypeId() {
		return _listTypeId;
	}

	public void setListTypeId(int listTypeId) {
		_listTypeId = listTypeId;
	}

	private long _esfPhoneId;
	private int _listTypeId;
}