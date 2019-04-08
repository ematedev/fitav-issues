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
public class ESFTransitionSoap implements Serializable {
	public static ESFTransitionSoap toSoapModel(ESFTransition model) {
		ESFTransitionSoap soapModel = new ESFTransitionSoap();

		soapModel.setEsfTransitionId(model.getEsfTransitionId());
		soapModel.setEsfUserId(model.getEsfUserId());
		soapModel.setEsfCategoryId(model.getEsfCategoryId());
		soapModel.setSeason(model.getSeason());

		return soapModel;
	}

	public static ESFTransitionSoap[] toSoapModels(ESFTransition[] models) {
		ESFTransitionSoap[] soapModels = new ESFTransitionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFTransitionSoap[][] toSoapModels(ESFTransition[][] models) {
		ESFTransitionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFTransitionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFTransitionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFTransitionSoap[] toSoapModels(List<ESFTransition> models) {
		List<ESFTransitionSoap> soapModels = new ArrayList<ESFTransitionSoap>(models.size());

		for (ESFTransition model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFTransitionSoap[soapModels.size()]);
	}

	public ESFTransitionSoap() {
	}

	public long getPrimaryKey() {
		return _esfTransitionId;
	}

	public void setPrimaryKey(long pk) {
		setEsfTransitionId(pk);
	}

	public long getEsfTransitionId() {
		return _esfTransitionId;
	}

	public void setEsfTransitionId(long esfTransitionId) {
		_esfTransitionId = esfTransitionId;
	}

	public long getEsfUserId() {
		return _esfUserId;
	}

	public void setEsfUserId(long esfUserId) {
		_esfUserId = esfUserId;
	}

	public long getEsfCategoryId() {
		return _esfCategoryId;
	}

	public void setEsfCategoryId(long esfCategoryId) {
		_esfCategoryId = esfCategoryId;
	}

	public String getSeason() {
		return _season;
	}

	public void setSeason(String season) {
		_season = season;
	}

	private long _esfTransitionId;
	private long _esfUserId;
	private long _esfCategoryId;
	private String _season;
}