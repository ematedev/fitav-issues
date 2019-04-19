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
public class ESFSuspensiveShootingDirectorSoap implements Serializable {
	public static ESFSuspensiveShootingDirectorSoap toSoapModel(
		ESFSuspensiveShootingDirector model) {
		ESFSuspensiveShootingDirectorSoap soapModel = new ESFSuspensiveShootingDirectorSoap();

		soapModel.setEsfSuspensiveShooingDirectorId(model.getEsfSuspensiveShooingDirectorId());
		soapModel.setEsfData(model.getEsfData());
		soapModel.setEsfCodeData(model.getEsfCodeData());
		soapModel.setEsfStartData(model.getEsfStartData());
		soapModel.setEsfEndData(model.getEsfEndData());
		soapModel.setEsfUserId(model.getEsfUserId());
		soapModel.setCodeUser(model.getCodeUser());
		soapModel.setCodice_Sosp(model.getCodice_Sosp());
		soapModel.setNote(model.getNote());
		soapModel.setQualif1_Utiliz(model.getQualif1_Utiliz());
		soapModel.setQualif2_Utiliz(model.getQualif2_Utiliz());
		soapModel.setQualif3_Utiliz(model.getQualif3_Utiliz());
		soapModel.setTipo_Gara1_noUtil(model.getTipo_Gara1_noUtil());
		soapModel.setTipo_Gara2_noUtil(model.getTipo_Gara2_noUtil());
		soapModel.setTipo_Gara3_noUtil(model.getTipo_Gara3_noUtil());
		soapModel.setTipo_Gara4_noUtil(model.getTipo_Gara4_noUtil());
		soapModel.setTipo_Gara5_noUtil(model.getTipo_Gara5_noUtil());
		soapModel.setTipo_Gara6_noUtil(model.getTipo_Gara6_noUtil());
		soapModel.setTipo_Gara7_noUtil(model.getTipo_Gara7_noUtil());
		soapModel.setTipo_Gara8_noUtil(model.getTipo_Gara8_noUtil());
		soapModel.setTipo_Gara9_noUtil(model.getTipo_Gara9_noUtil());
		soapModel.setTipo_Gara10_noUtil(model.getTipo_Gara10_noUtil());
		soapModel.setEsfVariationData(model.getEsfVariationData());

		return soapModel;
	}

	public static ESFSuspensiveShootingDirectorSoap[] toSoapModels(
		ESFSuspensiveShootingDirector[] models) {
		ESFSuspensiveShootingDirectorSoap[] soapModels = new ESFSuspensiveShootingDirectorSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ESFSuspensiveShootingDirectorSoap[][] toSoapModels(
		ESFSuspensiveShootingDirector[][] models) {
		ESFSuspensiveShootingDirectorSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ESFSuspensiveShootingDirectorSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ESFSuspensiveShootingDirectorSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ESFSuspensiveShootingDirectorSoap[] toSoapModels(
		List<ESFSuspensiveShootingDirector> models) {
		List<ESFSuspensiveShootingDirectorSoap> soapModels = new ArrayList<ESFSuspensiveShootingDirectorSoap>(models.size());

		for (ESFSuspensiveShootingDirector model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ESFSuspensiveShootingDirectorSoap[soapModels.size()]);
	}

	public ESFSuspensiveShootingDirectorSoap() {
	}

	public long getPrimaryKey() {
		return _esfSuspensiveShooingDirectorId;
	}

	public void setPrimaryKey(long pk) {
		setEsfSuspensiveShooingDirectorId(pk);
	}

	public long getEsfSuspensiveShooingDirectorId() {
		return _esfSuspensiveShooingDirectorId;
	}

	public void setEsfSuspensiveShooingDirectorId(
		long esfSuspensiveShooingDirectorId) {
		_esfSuspensiveShooingDirectorId = esfSuspensiveShooingDirectorId;
	}

	public Date getEsfData() {
		return _esfData;
	}

	public void setEsfData(Date esfData) {
		_esfData = esfData;
	}

	public String getEsfCodeData() {
		return _esfCodeData;
	}

	public void setEsfCodeData(String esfCodeData) {
		_esfCodeData = esfCodeData;
	}

	public Date getEsfStartData() {
		return _esfStartData;
	}

	public void setEsfStartData(Date esfStartData) {
		_esfStartData = esfStartData;
	}

	public Date getEsfEndData() {
		return _esfEndData;
	}

	public void setEsfEndData(Date esfEndData) {
		_esfEndData = esfEndData;
	}

	public long getEsfUserId() {
		return _esfUserId;
	}

	public void setEsfUserId(long esfUserId) {
		_esfUserId = esfUserId;
	}

	public long getCodeUser() {
		return _codeUser;
	}

	public void setCodeUser(long codeUser) {
		_codeUser = codeUser;
	}

	public long getCodice_Sosp() {
		return _Codice_Sosp;
	}

	public void setCodice_Sosp(long Codice_Sosp) {
		_Codice_Sosp = Codice_Sosp;
	}

	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
	}

	public long getQualif1_Utiliz() {
		return _Qualif1_Utiliz;
	}

	public void setQualif1_Utiliz(long Qualif1_Utiliz) {
		_Qualif1_Utiliz = Qualif1_Utiliz;
	}

	public long getQualif2_Utiliz() {
		return _Qualif2_Utiliz;
	}

	public void setQualif2_Utiliz(long Qualif2_Utiliz) {
		_Qualif2_Utiliz = Qualif2_Utiliz;
	}

	public long getQualif3_Utiliz() {
		return _Qualif3_Utiliz;
	}

	public void setQualif3_Utiliz(long Qualif3_Utiliz) {
		_Qualif3_Utiliz = Qualif3_Utiliz;
	}

	public long getTipo_Gara1_noUtil() {
		return _Tipo_Gara1_noUtil;
	}

	public void setTipo_Gara1_noUtil(long Tipo_Gara1_noUtil) {
		_Tipo_Gara1_noUtil = Tipo_Gara1_noUtil;
	}

	public long getTipo_Gara2_noUtil() {
		return _Tipo_Gara2_noUtil;
	}

	public void setTipo_Gara2_noUtil(long Tipo_Gara2_noUtil) {
		_Tipo_Gara2_noUtil = Tipo_Gara2_noUtil;
	}

	public long getTipo_Gara3_noUtil() {
		return _Tipo_Gara3_noUtil;
	}

	public void setTipo_Gara3_noUtil(long Tipo_Gara3_noUtil) {
		_Tipo_Gara3_noUtil = Tipo_Gara3_noUtil;
	}

	public long getTipo_Gara4_noUtil() {
		return _Tipo_Gara4_noUtil;
	}

	public void setTipo_Gara4_noUtil(long Tipo_Gara4_noUtil) {
		_Tipo_Gara4_noUtil = Tipo_Gara4_noUtil;
	}

	public long getTipo_Gara5_noUtil() {
		return _Tipo_Gara5_noUtil;
	}

	public void setTipo_Gara5_noUtil(long Tipo_Gara5_noUtil) {
		_Tipo_Gara5_noUtil = Tipo_Gara5_noUtil;
	}

	public long getTipo_Gara6_noUtil() {
		return _Tipo_Gara6_noUtil;
	}

	public void setTipo_Gara6_noUtil(long Tipo_Gara6_noUtil) {
		_Tipo_Gara6_noUtil = Tipo_Gara6_noUtil;
	}

	public long getTipo_Gara7_noUtil() {
		return _Tipo_Gara7_noUtil;
	}

	public void setTipo_Gara7_noUtil(long Tipo_Gara7_noUtil) {
		_Tipo_Gara7_noUtil = Tipo_Gara7_noUtil;
	}

	public long getTipo_Gara8_noUtil() {
		return _Tipo_Gara8_noUtil;
	}

	public void setTipo_Gara8_noUtil(long Tipo_Gara8_noUtil) {
		_Tipo_Gara8_noUtil = Tipo_Gara8_noUtil;
	}

	public long getTipo_Gara9_noUtil() {
		return _Tipo_Gara9_noUtil;
	}

	public void setTipo_Gara9_noUtil(long Tipo_Gara9_noUtil) {
		_Tipo_Gara9_noUtil = Tipo_Gara9_noUtil;
	}

	public long getTipo_Gara10_noUtil() {
		return _Tipo_Gara10_noUtil;
	}

	public void setTipo_Gara10_noUtil(long Tipo_Gara10_noUtil) {
		_Tipo_Gara10_noUtil = Tipo_Gara10_noUtil;
	}

	public Date getEsfVariationData() {
		return _esfVariationData;
	}

	public void setEsfVariationData(Date esfVariationData) {
		_esfVariationData = esfVariationData;
	}

	private long _esfSuspensiveShooingDirectorId;
	private Date _esfData;
	private String _esfCodeData;
	private Date _esfStartData;
	private Date _esfEndData;
	private long _esfUserId;
	private long _codeUser;
	private long _Codice_Sosp;
	private String _note;
	private long _Qualif1_Utiliz;
	private long _Qualif2_Utiliz;
	private long _Qualif3_Utiliz;
	private long _Tipo_Gara1_noUtil;
	private long _Tipo_Gara2_noUtil;
	private long _Tipo_Gara3_noUtil;
	private long _Tipo_Gara4_noUtil;
	private long _Tipo_Gara5_noUtil;
	private long _Tipo_Gara6_noUtil;
	private long _Tipo_Gara7_noUtil;
	private long _Tipo_Gara8_noUtil;
	private long _Tipo_Gara9_noUtil;
	private long _Tipo_Gara10_noUtil;
	private Date _esfVariationData;
}