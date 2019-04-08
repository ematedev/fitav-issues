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
public class ESFHistoricalAssociationSoap implements Serializable {
	public static ESFHistoricalAssociationSoap toSoapModel(
		ESFHistoricalAssociation model) {
		ESFHistoricalAssociationSoap soapModel = new ESFHistoricalAssociationSoap();

		soapModel.setIdHistoricalAssociation(model.getIdHistoricalAssociation());
		soapModel.setName(model.getName());
		soapModel.setCode(model.getCode());
		soapModel.setDateChange(model.getDateChange());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setStateId(model.getStateId());
		soapModel.setVariationId(model.getVariationId());

		return soapModel;
	}

	public static ESFHistoricalAssociationSoap[] toSoapModels(
		ESFHistoricalAssociation[] models) {
		ESFHistoricalAssociationSoap[] soapModels = new ESFHistoricalAssociationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFHistoricalAssociationSoap[][] toSoapModels(
		ESFHistoricalAssociation[][] models) {
		ESFHistoricalAssociationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFHistoricalAssociationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFHistoricalAssociationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFHistoricalAssociationSoap[] toSoapModels(
		List<ESFHistoricalAssociation> models) {
		List<ESFHistoricalAssociationSoap> soapModels = new ArrayList<ESFHistoricalAssociationSoap>(models.size());

		for (ESFHistoricalAssociation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFHistoricalAssociationSoap[soapModels.size()]);
	}

	public ESFHistoricalAssociationSoap() {
	}

	public long getPrimaryKey() {
		return _idHistoricalAssociation;
	}

	public void setPrimaryKey(long pk) {
		setIdHistoricalAssociation(pk);
	}

	public long getIdHistoricalAssociation() {
		return _idHistoricalAssociation;
	}

	public void setIdHistoricalAssociation(long idHistoricalAssociation) {
		_idHistoricalAssociation = idHistoricalAssociation;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public Date getDateChange() {
		return _dateChange;
	}

	public void setDateChange(Date dateChange) {
		_dateChange = dateChange;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	public long getStateId() {
		return _stateId;
	}

	public void setStateId(long stateId) {
		_stateId = stateId;
	}

	public long getVariationId() {
		return _variationId;
	}

	public void setVariationId(long variationId) {
		_variationId = variationId;
	}

	private long _idHistoricalAssociation;
	private String _name;
	private String _code;
	private Date _dateChange;
	private Date _endDate;
	private long _organizationId;
	private long _stateId;
	private long _variationId;
}