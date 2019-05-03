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
public class ESFOrganizationSoap implements Serializable {
	public static ESFOrganizationSoap toSoapModel(ESFOrganization model) {
		ESFOrganizationSoap soapModel = new ESFOrganizationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEsfOrganizationId(model.getEsfOrganizationId());
		soapModel.setCode(model.getCode());
		soapModel.setVat(model.getVat());
		soapModel.setFiscalCode(model.getFiscalCode());
		soapModel.setEstablishmentDate(model.getEstablishmentDate());
		soapModel.setClosureDate(model.getClosureDate());
		soapModel.setGroupId(model.getGroupId());

		return soapModel;
	}

	public static ESFOrganizationSoap[] toSoapModels(ESFOrganization[] models) {
		ESFOrganizationSoap[] soapModels = new ESFOrganizationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFOrganizationSoap[][] toSoapModels(
		ESFOrganization[][] models) {
		ESFOrganizationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFOrganizationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFOrganizationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFOrganizationSoap[] toSoapModels(
		List<ESFOrganization> models) {
		List<ESFOrganizationSoap> soapModels = new ArrayList<ESFOrganizationSoap>(models.size());

		for (ESFOrganization model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFOrganizationSoap[soapModels.size()]);
	}

	public ESFOrganizationSoap() {
	}

	public long getPrimaryKey() {
		return _esfOrganizationId;
	}

	public void setPrimaryKey(long pk) {
		setEsfOrganizationId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEsfOrganizationId() {
		return _esfOrganizationId;
	}

	public void setEsfOrganizationId(long esfOrganizationId) {
		_esfOrganizationId = esfOrganizationId;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public String getVat() {
		return _vat;
	}

	public void setVat(String vat) {
		_vat = vat;
	}

	public String getFiscalCode() {
		return _fiscalCode;
	}

	public void setFiscalCode(String fiscalCode) {
		_fiscalCode = fiscalCode;
	}

	public Date getEstablishmentDate() {
		return _establishmentDate;
	}

	public void setEstablishmentDate(Date establishmentDate) {
		_establishmentDate = establishmentDate;
	}

	public Date getClosureDate() {
		return _closureDate;
	}

	public void setClosureDate(Date closureDate) {
		_closureDate = closureDate;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	private String _uuid;
	private long _esfOrganizationId;
	private String _code;
	private String _vat;
	private String _fiscalCode;
	private Date _establishmentDate;
	private Date _closureDate;
	private long _groupId;
}