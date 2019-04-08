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
public class ESFBrandSoap implements Serializable {
	public static ESFBrandSoap toSoapModel(ESFBrand model) {
		ESFBrandSoap soapModel = new ESFBrandSoap();

		soapModel.setBrandId(model.getBrandId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static ESFBrandSoap[] toSoapModels(ESFBrand[] models) {
		ESFBrandSoap[] soapModels = new ESFBrandSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFBrandSoap[][] toSoapModels(ESFBrand[][] models) {
		ESFBrandSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFBrandSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFBrandSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFBrandSoap[] toSoapModels(List<ESFBrand> models) {
		List<ESFBrandSoap> soapModels = new ArrayList<ESFBrandSoap>(models.size());

		for (ESFBrand model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFBrandSoap[soapModels.size()]);
	}

	public ESFBrandSoap() {
	}

	public long getPrimaryKey() {
		return _brandId;
	}

	public void setPrimaryKey(long pk) {
		setBrandId(pk);
	}

	public long getBrandId() {
		return _brandId;
	}

	public void setBrandId(long brandId) {
		_brandId = brandId;
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

	private long _brandId;
	private String _name;
	private String _description;
}