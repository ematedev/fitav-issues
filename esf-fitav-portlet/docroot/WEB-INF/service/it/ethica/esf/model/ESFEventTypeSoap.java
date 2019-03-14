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
public class ESFEventTypeSoap implements Serializable {
	public static ESFEventTypeSoap toSoapModel(ESFEventType model) {
		ESFEventTypeSoap soapModel = new ESFEventTypeSoap();

		soapModel.setEsfEventTypeId(model.getEsfEventTypeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setMacrocategory(model.getMacrocategory());
		soapModel.setEventType(model.getEventType());

		return soapModel;
	}

	public static ESFEventTypeSoap[] toSoapModels(ESFEventType[] models) {
		ESFEventTypeSoap[] soapModels = new ESFEventTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFEventTypeSoap[][] toSoapModels(ESFEventType[][] models) {
		ESFEventTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFEventTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFEventTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFEventTypeSoap[] toSoapModels(List<ESFEventType> models) {
		List<ESFEventTypeSoap> soapModels = new ArrayList<ESFEventTypeSoap>(models.size());

		for (ESFEventType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFEventTypeSoap[soapModels.size()]);
	}

	public ESFEventTypeSoap() {
	}

	public long getPrimaryKey() {
		return _esfEventTypeId;
	}

	public void setPrimaryKey(long pk) {
		setEsfEventTypeId(pk);
	}

	public long getEsfEventTypeId() {
		return _esfEventTypeId;
	}

	public void setEsfEventTypeId(long esfEventTypeId) {
		_esfEventTypeId = esfEventTypeId;
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

	public String getMacrocategory() {
		return _macrocategory;
	}

	public void setMacrocategory(String macrocategory) {
		_macrocategory = macrocategory;
	}

	public String getEventType() {
		return _eventType;
	}

	public void setEventType(String eventType) {
		_eventType = eventType;
	}

	private long _esfEventTypeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _macrocategory;
	private String _eventType;
}