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
public class ESFArticleTypeSoap implements Serializable {
	public static ESFArticleTypeSoap toSoapModel(ESFArticleType model) {
		ESFArticleTypeSoap soapModel = new ESFArticleTypeSoap();

		soapModel.setEsfArticleTypeId(model.getEsfArticleTypeId());
		soapModel.setDescription(model.getDescription());
		soapModel.setDepartment(model.getDepartment());
		soapModel.setArea(model.getArea());

		return soapModel;
	}

	public static ESFArticleTypeSoap[] toSoapModels(ESFArticleType[] models) {
		ESFArticleTypeSoap[] soapModels = new ESFArticleTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFArticleTypeSoap[][] toSoapModels(ESFArticleType[][] models) {
		ESFArticleTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFArticleTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFArticleTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFArticleTypeSoap[] toSoapModels(List<ESFArticleType> models) {
		List<ESFArticleTypeSoap> soapModels = new ArrayList<ESFArticleTypeSoap>(models.size());

		for (ESFArticleType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFArticleTypeSoap[soapModels.size()]);
	}

	public ESFArticleTypeSoap() {
	}

	public long getPrimaryKey() {
		return _esfArticleTypeId;
	}

	public void setPrimaryKey(long pk) {
		setEsfArticleTypeId(pk);
	}

	public long getEsfArticleTypeId() {
		return _esfArticleTypeId;
	}

	public void setEsfArticleTypeId(long esfArticleTypeId) {
		_esfArticleTypeId = esfArticleTypeId;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getDepartment() {
		return _department;
	}

	public void setDepartment(String department) {
		_department = department;
	}

	public String getArea() {
		return _area;
	}

	public void setArea(String area) {
		_area = area;
	}

	private long _esfArticleTypeId;
	private String _description;
	private String _department;
	private String _area;
}