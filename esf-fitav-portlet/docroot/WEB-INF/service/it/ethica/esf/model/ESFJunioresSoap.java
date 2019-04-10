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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Ethica
 * @generated
 */
public class ESFJunioresSoap implements Serializable {
	public static ESFJunioresSoap toSoapModel(ESFJuniores model) {
		ESFJunioresSoap soapModel = new ESFJunioresSoap();

		soapModel.setESFUserId(model.getESFUserId());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());

		return soapModel;
	}

	public static ESFJunioresSoap[] toSoapModels(ESFJuniores[] models) {
		ESFJunioresSoap[] soapModels = new ESFJunioresSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFJunioresSoap[][] toSoapModels(ESFJuniores[][] models) {
		ESFJunioresSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFJunioresSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFJunioresSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFJunioresSoap[] toSoapModels(List<ESFJuniores> models) {
		List<ESFJunioresSoap> soapModels = new ArrayList<ESFJunioresSoap>(models.size());

		for (ESFJuniores model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFJunioresSoap[soapModels.size()]);
	}

	public ESFJunioresSoap() {
	}

	public long getPrimaryKey() {
		return _ESFUserId;
	}

	public void setPrimaryKey(long pk) {
		setESFUserId(pk);
	}

	public long getESFUserId() {
		return _ESFUserId;
	}

	public void setESFUserId(long ESFUserId) {
		_ESFUserId = ESFUserId;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	private long _ESFUserId;
	private Date _startDate;
	private Date _endDate;
}