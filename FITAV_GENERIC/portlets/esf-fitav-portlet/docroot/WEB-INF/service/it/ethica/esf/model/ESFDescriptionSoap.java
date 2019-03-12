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
public class ESFDescriptionSoap implements Serializable {
	public static ESFDescriptionSoap toSoapModel(ESFDescription model) {
		ESFDescriptionSoap soapModel = new ESFDescriptionSoap();

		soapModel.setEsfDescriptionId(model.getEsfDescriptionId());
		soapModel.setIsNational(model.getIsNational());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static ESFDescriptionSoap[] toSoapModels(ESFDescription[] models) {
		ESFDescriptionSoap[] soapModels = new ESFDescriptionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFDescriptionSoap[][] toSoapModels(ESFDescription[][] models) {
		ESFDescriptionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFDescriptionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFDescriptionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFDescriptionSoap[] toSoapModels(List<ESFDescription> models) {
		List<ESFDescriptionSoap> soapModels = new ArrayList<ESFDescriptionSoap>(models.size());

		for (ESFDescription model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFDescriptionSoap[soapModels.size()]);
	}

	public ESFDescriptionSoap() {
	}

	public long getPrimaryKey() {
		return _esfDescriptionId;
	}

	public void setPrimaryKey(long pk) {
		setEsfDescriptionId(pk);
	}

	public long getEsfDescriptionId() {
		return _esfDescriptionId;
	}

	public void setEsfDescriptionId(long esfDescriptionId) {
		_esfDescriptionId = esfDescriptionId;
	}

	public boolean getIsNational() {
		return _isNational;
	}

	public boolean isIsNational() {
		return _isNational;
	}

	public void setIsNational(boolean isNational) {
		_isNational = isNational;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private long _esfDescriptionId;
	private boolean _isNational;
	private String _name;
}