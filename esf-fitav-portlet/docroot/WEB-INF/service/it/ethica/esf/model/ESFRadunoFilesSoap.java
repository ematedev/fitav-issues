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
public class ESFRadunoFilesSoap implements Serializable {
	public static ESFRadunoFilesSoap toSoapModel(ESFRadunoFiles model) {
		ESFRadunoFilesSoap soapModel = new ESFRadunoFilesSoap();

		soapModel.setId_esf_raduno_files(model.getId_esf_raduno_files());
		soapModel.setId_esf_raduno(model.getId_esf_raduno());
		soapModel.setNome(model.getNome());
		soapModel.setPath(model.getPath());

		return soapModel;
	}

	public static ESFRadunoFilesSoap[] toSoapModels(ESFRadunoFiles[] models) {
		ESFRadunoFilesSoap[] soapModels = new ESFRadunoFilesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFRadunoFilesSoap[][] toSoapModels(ESFRadunoFiles[][] models) {
		ESFRadunoFilesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFRadunoFilesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFRadunoFilesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFRadunoFilesSoap[] toSoapModels(List<ESFRadunoFiles> models) {
		List<ESFRadunoFilesSoap> soapModels = new ArrayList<ESFRadunoFilesSoap>(models.size());

		for (ESFRadunoFiles model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFRadunoFilesSoap[soapModels.size()]);
	}

	public ESFRadunoFilesSoap() {
	}

	public long getPrimaryKey() {
		return _id_esf_raduno_files;
	}

	public void setPrimaryKey(long pk) {
		setId_esf_raduno_files(pk);
	}

	public long getId_esf_raduno_files() {
		return _id_esf_raduno_files;
	}

	public void setId_esf_raduno_files(long id_esf_raduno_files) {
		_id_esf_raduno_files = id_esf_raduno_files;
	}

	public long getId_esf_raduno() {
		return _id_esf_raduno;
	}

	public void setId_esf_raduno(long id_esf_raduno) {
		_id_esf_raduno = id_esf_raduno;
	}

	public String getNome() {
		return _nome;
	}

	public void setNome(String nome) {
		_nome = nome;
	}

	public String getPath() {
		return _path;
	}

	public void setPath(String path) {
		_path = path;
	}

	private long _id_esf_raduno_files;
	private long _id_esf_raduno;
	private String _nome;
	private String _path;
}