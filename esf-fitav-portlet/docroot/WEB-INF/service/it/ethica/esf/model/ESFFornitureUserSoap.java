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
public class ESFFornitureUserSoap implements Serializable {
	public static ESFFornitureUserSoap toSoapModel(ESFFornitureUser model) {
		ESFFornitureUserSoap soapModel = new ESFFornitureUserSoap();

		soapModel.setEsfIDForniture(model.getEsfIDForniture());
		soapModel.setEsfIdUser(model.getEsfIdUser());
		soapModel.setEsfQuantity(model.getEsfQuantity());
		soapModel.setEsfDateAssign(model.getEsfDateAssign());
		soapModel.setEsfFornitureUserID(model.getEsfFornitureUserID());

		return soapModel;
	}

	public static ESFFornitureUserSoap[] toSoapModels(ESFFornitureUser[] models) {
		ESFFornitureUserSoap[] soapModels = new ESFFornitureUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFFornitureUserSoap[][] toSoapModels(
		ESFFornitureUser[][] models) {
		ESFFornitureUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFFornitureUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFFornitureUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFFornitureUserSoap[] toSoapModels(
		List<ESFFornitureUser> models) {
		List<ESFFornitureUserSoap> soapModels = new ArrayList<ESFFornitureUserSoap>(models.size());

		for (ESFFornitureUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFFornitureUserSoap[soapModels.size()]);
	}

	public ESFFornitureUserSoap() {
	}

	public long getPrimaryKey() {
		return _esfFornitureUserID;
	}

	public void setPrimaryKey(long pk) {
		setEsfFornitureUserID(pk);
	}

	public long getEsfIDForniture() {
		return _esfIDForniture;
	}

	public void setEsfIDForniture(long esfIDForniture) {
		_esfIDForniture = esfIDForniture;
	}

	public long getEsfIdUser() {
		return _esfIdUser;
	}

	public void setEsfIdUser(long esfIdUser) {
		_esfIdUser = esfIdUser;
	}

	public long getEsfQuantity() {
		return _esfQuantity;
	}

	public void setEsfQuantity(long esfQuantity) {
		_esfQuantity = esfQuantity;
	}

	public Date getEsfDateAssign() {
		return _esfDateAssign;
	}

	public void setEsfDateAssign(Date esfDateAssign) {
		_esfDateAssign = esfDateAssign;
	}

	public long getEsfFornitureUserID() {
		return _esfFornitureUserID;
	}

	public void setEsfFornitureUserID(long esfFornitureUserID) {
		_esfFornitureUserID = esfFornitureUserID;
	}

	private long _esfIDForniture;
	private long _esfIdUser;
	private long _esfQuantity;
	private Date _esfDateAssign;
	private long _esfFornitureUserID;
}