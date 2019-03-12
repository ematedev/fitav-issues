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
public class ESFCategorySoap implements Serializable {
	public static ESFCategorySoap toSoapModel(ESFCategory model) {
		ESFCategorySoap soapModel = new ESFCategorySoap();

		soapModel.setEsfCategoryId(model.getEsfCategoryId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static ESFCategorySoap[] toSoapModels(ESFCategory[] models) {
		ESFCategorySoap[] soapModels = new ESFCategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFCategorySoap[][] toSoapModels(ESFCategory[][] models) {
		ESFCategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFCategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFCategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFCategorySoap[] toSoapModels(List<ESFCategory> models) {
		List<ESFCategorySoap> soapModels = new ArrayList<ESFCategorySoap>(models.size());

		for (ESFCategory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFCategorySoap[soapModels.size()]);
	}

	public ESFCategorySoap() {
	}

	public long getPrimaryKey() {
		return _esfCategoryId;
	}

	public void setPrimaryKey(long pk) {
		setEsfCategoryId(pk);
	}

	public long getEsfCategoryId() {
		return _esfCategoryId;
	}

	public void setEsfCategoryId(long esfCategoryId) {
		_esfCategoryId = esfCategoryId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private long _esfCategoryId;
	private String _name;
	private String _description;
}