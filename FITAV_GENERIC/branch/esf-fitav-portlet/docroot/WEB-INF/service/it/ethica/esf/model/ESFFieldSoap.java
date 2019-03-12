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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Ethica
 * @generated
 */
public class ESFFieldSoap implements Serializable {
	public static ESFFieldSoap toSoapModel(ESFField model) {
		ESFFieldSoap soapModel = new ESFFieldSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEsfFieldId(model.getEsfFieldId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setOwnerOrganizationId(model.getOwnerOrganizationId());
		soapModel.setEsfAddressId(model.getEsfAddressId());
		soapModel.setBillboard(model.getBillboard());
		soapModel.setBillboardStations(model.getBillboardStations());
		soapModel.setBackgroundRampart(model.getBackgroundRampart());
		soapModel.setBackgroundNet(model.getBackgroundNet());
		soapModel.setBackgroundLeadRecovery(model.getBackgroundLeadRecovery());
		soapModel.setDisabledAccess(model.getDisabledAccess());
		soapModel.setNote(model.getNote());

		return soapModel;
	}

	public static ESFFieldSoap[] toSoapModels(ESFField[] models) {
		ESFFieldSoap[] soapModels = new ESFFieldSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFFieldSoap[][] toSoapModels(ESFField[][] models) {
		ESFFieldSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFFieldSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFFieldSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFFieldSoap[] toSoapModels(List<ESFField> models) {
		List<ESFFieldSoap> soapModels = new ArrayList<ESFFieldSoap>(models.size());

		for (ESFField model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFFieldSoap[soapModels.size()]);
	}

	public ESFFieldSoap() {
	}

	public long getPrimaryKey() {
		return _esfFieldId;
	}

	public void setPrimaryKey(long pk) {
		setEsfFieldId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEsfFieldId() {
		return _esfFieldId;
	}

	public void setEsfFieldId(long esfFieldId) {
		_esfFieldId = esfFieldId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public long getOwnerOrganizationId() {
		return _ownerOrganizationId;
	}

	public void setOwnerOrganizationId(long ownerOrganizationId) {
		_ownerOrganizationId = ownerOrganizationId;
	}

	public long getEsfAddressId() {
		return _esfAddressId;
	}

	public void setEsfAddressId(long esfAddressId) {
		_esfAddressId = esfAddressId;
	}

	public long getBillboard() {
		return _billboard;
	}

	public void setBillboard(long billboard) {
		_billboard = billboard;
	}

	public boolean getBillboardStations() {
		return _billboardStations;
	}

	public boolean isBillboardStations() {
		return _billboardStations;
	}

	public void setBillboardStations(boolean billboardStations) {
		_billboardStations = billboardStations;
	}

	public boolean getBackgroundRampart() {
		return _backgroundRampart;
	}

	public boolean isBackgroundRampart() {
		return _backgroundRampart;
	}

	public void setBackgroundRampart(boolean backgroundRampart) {
		_backgroundRampart = backgroundRampart;
	}

	public boolean getBackgroundNet() {
		return _backgroundNet;
	}

	public boolean isBackgroundNet() {
		return _backgroundNet;
	}

	public void setBackgroundNet(boolean backgroundNet) {
		_backgroundNet = backgroundNet;
	}

	public boolean getBackgroundLeadRecovery() {
		return _backgroundLeadRecovery;
	}

	public boolean isBackgroundLeadRecovery() {
		return _backgroundLeadRecovery;
	}

	public void setBackgroundLeadRecovery(boolean backgroundLeadRecovery) {
		_backgroundLeadRecovery = backgroundLeadRecovery;
	}

	public boolean getDisabledAccess() {
		return _disabledAccess;
	}

	public boolean isDisabledAccess() {
		return _disabledAccess;
	}

	public void setDisabledAccess(boolean disabledAccess) {
		_disabledAccess = disabledAccess;
	}

	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
	}

	private String _uuid;
	private long _esfFieldId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private long _ownerOrganizationId;
	private long _esfAddressId;
	private long _billboard;
	private boolean _billboardStations;
	private boolean _backgroundRampart;
	private boolean _backgroundNet;
	private boolean _backgroundLeadRecovery;
	private boolean _disabledAccess;
	private String _note;
}