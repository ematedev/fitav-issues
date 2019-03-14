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
public class ESFJobSoap implements Serializable {
	public static ESFJobSoap toSoapModel(ESFJob model) {
		ESFJobSoap soapModel = new ESFJobSoap();

		soapModel.setEsfJobId(model.getEsfJobId());
		soapModel.setEsfName(model.getEsfName());

		return soapModel;
	}

	public static ESFJobSoap[] toSoapModels(ESFJob[] models) {
		ESFJobSoap[] soapModels = new ESFJobSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFJobSoap[][] toSoapModels(ESFJob[][] models) {
		ESFJobSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFJobSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFJobSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFJobSoap[] toSoapModels(List<ESFJob> models) {
		List<ESFJobSoap> soapModels = new ArrayList<ESFJobSoap>(models.size());

		for (ESFJob model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFJobSoap[soapModels.size()]);
	}

	public ESFJobSoap() {
	}

	public long getPrimaryKey() {
		return _esfJobId;
	}

	public void setPrimaryKey(long pk) {
		setEsfJobId(pk);
	}

	public long getEsfJobId() {
		return _esfJobId;
	}

	public void setEsfJobId(long esfJobId) {
		_esfJobId = esfJobId;
	}

	public String getEsfName() {
		return _esfName;
	}

	public void setEsfName(String esfName) {
		_esfName = esfName;
	}

	private long _esfJobId;
	private String _esfName;
}