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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import it.ethica.esf.service.ClpSerializer;
import it.ethica.esf.service.ESFSuspensiveShootingDirectorLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFSuspensiveShootingDirectorClp extends BaseModelImpl<ESFSuspensiveShootingDirector>
	implements ESFSuspensiveShootingDirector {
	public ESFSuspensiveShootingDirectorClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFSuspensiveShootingDirector.class;
	}

	@Override
	public String getModelClassName() {
		return ESFSuspensiveShootingDirector.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _esfSuspensiveShooingDirectorId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfSuspensiveShooingDirectorId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfSuspensiveShooingDirectorId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfSuspensiveShooingDirectorId",
			getEsfSuspensiveShooingDirectorId());
		attributes.put("esfData", getEsfData());
		attributes.put("esfCodeData", getEsfCodeData());
		attributes.put("esfStartData", getEsfStartData());
		attributes.put("esfEndData", getEsfEndData());
		attributes.put("esfUserId", getEsfUserId());
		attributes.put("codeUser", getCodeUser());
		attributes.put("Codice_Sosp", getCodice_Sosp());
		attributes.put("note", getNote());
		attributes.put("Qualif1_Utiliz", getQualif1_Utiliz());
		attributes.put("Qualif2_Utiliz", getQualif2_Utiliz());
		attributes.put("Qualif3_Utiliz", getQualif3_Utiliz());
		attributes.put("Tipo_Gara1_noUtil", getTipo_Gara1_noUtil());
		attributes.put("Tipo_Gara2_noUtil", getTipo_Gara2_noUtil());
		attributes.put("Tipo_Gara3_noUtil", getTipo_Gara3_noUtil());
		attributes.put("Tipo_Gara4_noUtil", getTipo_Gara4_noUtil());
		attributes.put("Tipo_Gara5_noUtil", getTipo_Gara5_noUtil());
		attributes.put("Tipo_Gara6_noUtil", getTipo_Gara6_noUtil());
		attributes.put("Tipo_Gara7_noUtil", getTipo_Gara7_noUtil());
		attributes.put("Tipo_Gara8_noUtil", getTipo_Gara8_noUtil());
		attributes.put("Tipo_Gara9_noUtil", getTipo_Gara9_noUtil());
		attributes.put("Tipo_Gara10_noUtil", getTipo_Gara10_noUtil());
		attributes.put("esfVariationData", getEsfVariationData());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfSuspensiveShooingDirectorId = (Long)attributes.get(
				"esfSuspensiveShooingDirectorId");

		if (esfSuspensiveShooingDirectorId != null) {
			setEsfSuspensiveShooingDirectorId(esfSuspensiveShooingDirectorId);
		}

		Date esfData = (Date)attributes.get("esfData");

		if (esfData != null) {
			setEsfData(esfData);
		}

		String esfCodeData = (String)attributes.get("esfCodeData");

		if (esfCodeData != null) {
			setEsfCodeData(esfCodeData);
		}

		Date esfStartData = (Date)attributes.get("esfStartData");

		if (esfStartData != null) {
			setEsfStartData(esfStartData);
		}

		Date esfEndData = (Date)attributes.get("esfEndData");

		if (esfEndData != null) {
			setEsfEndData(esfEndData);
		}

		Long esfUserId = (Long)attributes.get("esfUserId");

		if (esfUserId != null) {
			setEsfUserId(esfUserId);
		}

		Long codeUser = (Long)attributes.get("codeUser");

		if (codeUser != null) {
			setCodeUser(codeUser);
		}

		Long Codice_Sosp = (Long)attributes.get("Codice_Sosp");

		if (Codice_Sosp != null) {
			setCodice_Sosp(Codice_Sosp);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		Long Qualif1_Utiliz = (Long)attributes.get("Qualif1_Utiliz");

		if (Qualif1_Utiliz != null) {
			setQualif1_Utiliz(Qualif1_Utiliz);
		}

		Long Qualif2_Utiliz = (Long)attributes.get("Qualif2_Utiliz");

		if (Qualif2_Utiliz != null) {
			setQualif2_Utiliz(Qualif2_Utiliz);
		}

		Long Qualif3_Utiliz = (Long)attributes.get("Qualif3_Utiliz");

		if (Qualif3_Utiliz != null) {
			setQualif3_Utiliz(Qualif3_Utiliz);
		}

		Long Tipo_Gara1_noUtil = (Long)attributes.get("Tipo_Gara1_noUtil");

		if (Tipo_Gara1_noUtil != null) {
			setTipo_Gara1_noUtil(Tipo_Gara1_noUtil);
		}

		Long Tipo_Gara2_noUtil = (Long)attributes.get("Tipo_Gara2_noUtil");

		if (Tipo_Gara2_noUtil != null) {
			setTipo_Gara2_noUtil(Tipo_Gara2_noUtil);
		}

		Long Tipo_Gara3_noUtil = (Long)attributes.get("Tipo_Gara3_noUtil");

		if (Tipo_Gara3_noUtil != null) {
			setTipo_Gara3_noUtil(Tipo_Gara3_noUtil);
		}

		Long Tipo_Gara4_noUtil = (Long)attributes.get("Tipo_Gara4_noUtil");

		if (Tipo_Gara4_noUtil != null) {
			setTipo_Gara4_noUtil(Tipo_Gara4_noUtil);
		}

		Long Tipo_Gara5_noUtil = (Long)attributes.get("Tipo_Gara5_noUtil");

		if (Tipo_Gara5_noUtil != null) {
			setTipo_Gara5_noUtil(Tipo_Gara5_noUtil);
		}

		Long Tipo_Gara6_noUtil = (Long)attributes.get("Tipo_Gara6_noUtil");

		if (Tipo_Gara6_noUtil != null) {
			setTipo_Gara6_noUtil(Tipo_Gara6_noUtil);
		}

		Long Tipo_Gara7_noUtil = (Long)attributes.get("Tipo_Gara7_noUtil");

		if (Tipo_Gara7_noUtil != null) {
			setTipo_Gara7_noUtil(Tipo_Gara7_noUtil);
		}

		Long Tipo_Gara8_noUtil = (Long)attributes.get("Tipo_Gara8_noUtil");

		if (Tipo_Gara8_noUtil != null) {
			setTipo_Gara8_noUtil(Tipo_Gara8_noUtil);
		}

		Long Tipo_Gara9_noUtil = (Long)attributes.get("Tipo_Gara9_noUtil");

		if (Tipo_Gara9_noUtil != null) {
			setTipo_Gara9_noUtil(Tipo_Gara9_noUtil);
		}

		Long Tipo_Gara10_noUtil = (Long)attributes.get("Tipo_Gara10_noUtil");

		if (Tipo_Gara10_noUtil != null) {
			setTipo_Gara10_noUtil(Tipo_Gara10_noUtil);
		}

		Date esfVariationData = (Date)attributes.get("esfVariationData");

		if (esfVariationData != null) {
			setEsfVariationData(esfVariationData);
		}
	}

	@Override
	public long getEsfSuspensiveShooingDirectorId() {
		return _esfSuspensiveShooingDirectorId;
	}

	@Override
	public void setEsfSuspensiveShooingDirectorId(
		long esfSuspensiveShooingDirectorId) {
		_esfSuspensiveShooingDirectorId = esfSuspensiveShooingDirectorId;

		if (_esfSuspensiveShootingDirectorRemoteModel != null) {
			try {
				Class<?> clazz = _esfSuspensiveShootingDirectorRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfSuspensiveShooingDirectorId",
						long.class);

				method.invoke(_esfSuspensiveShootingDirectorRemoteModel,
					esfSuspensiveShooingDirectorId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEsfData() {
		return _esfData;
	}

	@Override
	public void setEsfData(Date esfData) {
		_esfData = esfData;

		if (_esfSuspensiveShootingDirectorRemoteModel != null) {
			try {
				Class<?> clazz = _esfSuspensiveShootingDirectorRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfData", Date.class);

				method.invoke(_esfSuspensiveShootingDirectorRemoteModel, esfData);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEsfCodeData() {
		return _esfCodeData;
	}

	@Override
	public void setEsfCodeData(String esfCodeData) {
		_esfCodeData = esfCodeData;

		if (_esfSuspensiveShootingDirectorRemoteModel != null) {
			try {
				Class<?> clazz = _esfSuspensiveShootingDirectorRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfCodeData", String.class);

				method.invoke(_esfSuspensiveShootingDirectorRemoteModel,
					esfCodeData);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEsfStartData() {
		return _esfStartData;
	}

	@Override
	public void setEsfStartData(Date esfStartData) {
		_esfStartData = esfStartData;

		if (_esfSuspensiveShootingDirectorRemoteModel != null) {
			try {
				Class<?> clazz = _esfSuspensiveShootingDirectorRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfStartData", Date.class);

				method.invoke(_esfSuspensiveShootingDirectorRemoteModel,
					esfStartData);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEsfEndData() {
		return _esfEndData;
	}

	@Override
	public void setEsfEndData(Date esfEndData) {
		_esfEndData = esfEndData;

		if (_esfSuspensiveShootingDirectorRemoteModel != null) {
			try {
				Class<?> clazz = _esfSuspensiveShootingDirectorRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfEndData", Date.class);

				method.invoke(_esfSuspensiveShootingDirectorRemoteModel,
					esfEndData);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Long getEsfUserId() {
		return _esfUserId;
	}

	@Override
	public void setEsfUserId(Long esfUserId) {
		_esfUserId = esfUserId;

		if (_esfSuspensiveShootingDirectorRemoteModel != null) {
			try {
				Class<?> clazz = _esfSuspensiveShootingDirectorRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfUserId", Long.class);

				method.invoke(_esfSuspensiveShootingDirectorRemoteModel,
					esfUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Long getCodeUser() {
		return _codeUser;
	}

	@Override
	public void setCodeUser(Long codeUser) {
		_codeUser = codeUser;

		if (_esfSuspensiveShootingDirectorRemoteModel != null) {
			try {
				Class<?> clazz = _esfSuspensiveShootingDirectorRemoteModel.getClass();

				Method method = clazz.getMethod("setCodeUser", Long.class);

				method.invoke(_esfSuspensiveShootingDirectorRemoteModel,
					codeUser);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCodice_Sosp() {
		return _Codice_Sosp;
	}

	@Override
	public void setCodice_Sosp(long Codice_Sosp) {
		_Codice_Sosp = Codice_Sosp;

		if (_esfSuspensiveShootingDirectorRemoteModel != null) {
			try {
				Class<?> clazz = _esfSuspensiveShootingDirectorRemoteModel.getClass();

				Method method = clazz.getMethod("setCodice_Sosp", long.class);

				method.invoke(_esfSuspensiveShootingDirectorRemoteModel,
					Codice_Sosp);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNote() {
		return _note;
	}

	@Override
	public void setNote(String note) {
		_note = note;

		if (_esfSuspensiveShootingDirectorRemoteModel != null) {
			try {
				Class<?> clazz = _esfSuspensiveShootingDirectorRemoteModel.getClass();

				Method method = clazz.getMethod("setNote", String.class);

				method.invoke(_esfSuspensiveShootingDirectorRemoteModel, note);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getQualif1_Utiliz() {
		return _Qualif1_Utiliz;
	}

	@Override
	public void setQualif1_Utiliz(long Qualif1_Utiliz) {
		_Qualif1_Utiliz = Qualif1_Utiliz;

		if (_esfSuspensiveShootingDirectorRemoteModel != null) {
			try {
				Class<?> clazz = _esfSuspensiveShootingDirectorRemoteModel.getClass();

				Method method = clazz.getMethod("setQualif1_Utiliz", long.class);

				method.invoke(_esfSuspensiveShootingDirectorRemoteModel,
					Qualif1_Utiliz);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getQualif2_Utiliz() {
		return _Qualif2_Utiliz;
	}

	@Override
	public void setQualif2_Utiliz(long Qualif2_Utiliz) {
		_Qualif2_Utiliz = Qualif2_Utiliz;

		if (_esfSuspensiveShootingDirectorRemoteModel != null) {
			try {
				Class<?> clazz = _esfSuspensiveShootingDirectorRemoteModel.getClass();

				Method method = clazz.getMethod("setQualif2_Utiliz", long.class);

				method.invoke(_esfSuspensiveShootingDirectorRemoteModel,
					Qualif2_Utiliz);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getQualif3_Utiliz() {
		return _Qualif3_Utiliz;
	}

	@Override
	public void setQualif3_Utiliz(long Qualif3_Utiliz) {
		_Qualif3_Utiliz = Qualif3_Utiliz;

		if (_esfSuspensiveShootingDirectorRemoteModel != null) {
			try {
				Class<?> clazz = _esfSuspensiveShootingDirectorRemoteModel.getClass();

				Method method = clazz.getMethod("setQualif3_Utiliz", long.class);

				method.invoke(_esfSuspensiveShootingDirectorRemoteModel,
					Qualif3_Utiliz);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTipo_Gara1_noUtil() {
		return _Tipo_Gara1_noUtil;
	}

	@Override
	public void setTipo_Gara1_noUtil(long Tipo_Gara1_noUtil) {
		_Tipo_Gara1_noUtil = Tipo_Gara1_noUtil;

		if (_esfSuspensiveShootingDirectorRemoteModel != null) {
			try {
				Class<?> clazz = _esfSuspensiveShootingDirectorRemoteModel.getClass();

				Method method = clazz.getMethod("setTipo_Gara1_noUtil",
						long.class);

				method.invoke(_esfSuspensiveShootingDirectorRemoteModel,
					Tipo_Gara1_noUtil);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTipo_Gara2_noUtil() {
		return _Tipo_Gara2_noUtil;
	}

	@Override
	public void setTipo_Gara2_noUtil(long Tipo_Gara2_noUtil) {
		_Tipo_Gara2_noUtil = Tipo_Gara2_noUtil;

		if (_esfSuspensiveShootingDirectorRemoteModel != null) {
			try {
				Class<?> clazz = _esfSuspensiveShootingDirectorRemoteModel.getClass();

				Method method = clazz.getMethod("setTipo_Gara2_noUtil",
						long.class);

				method.invoke(_esfSuspensiveShootingDirectorRemoteModel,
					Tipo_Gara2_noUtil);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTipo_Gara3_noUtil() {
		return _Tipo_Gara3_noUtil;
	}

	@Override
	public void setTipo_Gara3_noUtil(long Tipo_Gara3_noUtil) {
		_Tipo_Gara3_noUtil = Tipo_Gara3_noUtil;

		if (_esfSuspensiveShootingDirectorRemoteModel != null) {
			try {
				Class<?> clazz = _esfSuspensiveShootingDirectorRemoteModel.getClass();

				Method method = clazz.getMethod("setTipo_Gara3_noUtil",
						long.class);

				method.invoke(_esfSuspensiveShootingDirectorRemoteModel,
					Tipo_Gara3_noUtil);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTipo_Gara4_noUtil() {
		return _Tipo_Gara4_noUtil;
	}

	@Override
	public void setTipo_Gara4_noUtil(long Tipo_Gara4_noUtil) {
		_Tipo_Gara4_noUtil = Tipo_Gara4_noUtil;

		if (_esfSuspensiveShootingDirectorRemoteModel != null) {
			try {
				Class<?> clazz = _esfSuspensiveShootingDirectorRemoteModel.getClass();

				Method method = clazz.getMethod("setTipo_Gara4_noUtil",
						long.class);

				method.invoke(_esfSuspensiveShootingDirectorRemoteModel,
					Tipo_Gara4_noUtil);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTipo_Gara5_noUtil() {
		return _Tipo_Gara5_noUtil;
	}

	@Override
	public void setTipo_Gara5_noUtil(long Tipo_Gara5_noUtil) {
		_Tipo_Gara5_noUtil = Tipo_Gara5_noUtil;

		if (_esfSuspensiveShootingDirectorRemoteModel != null) {
			try {
				Class<?> clazz = _esfSuspensiveShootingDirectorRemoteModel.getClass();

				Method method = clazz.getMethod("setTipo_Gara5_noUtil",
						long.class);

				method.invoke(_esfSuspensiveShootingDirectorRemoteModel,
					Tipo_Gara5_noUtil);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTipo_Gara6_noUtil() {
		return _Tipo_Gara6_noUtil;
	}

	@Override
	public void setTipo_Gara6_noUtil(long Tipo_Gara6_noUtil) {
		_Tipo_Gara6_noUtil = Tipo_Gara6_noUtil;

		if (_esfSuspensiveShootingDirectorRemoteModel != null) {
			try {
				Class<?> clazz = _esfSuspensiveShootingDirectorRemoteModel.getClass();

				Method method = clazz.getMethod("setTipo_Gara6_noUtil",
						long.class);

				method.invoke(_esfSuspensiveShootingDirectorRemoteModel,
					Tipo_Gara6_noUtil);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTipo_Gara7_noUtil() {
		return _Tipo_Gara7_noUtil;
	}

	@Override
	public void setTipo_Gara7_noUtil(long Tipo_Gara7_noUtil) {
		_Tipo_Gara7_noUtil = Tipo_Gara7_noUtil;

		if (_esfSuspensiveShootingDirectorRemoteModel != null) {
			try {
				Class<?> clazz = _esfSuspensiveShootingDirectorRemoteModel.getClass();

				Method method = clazz.getMethod("setTipo_Gara7_noUtil",
						long.class);

				method.invoke(_esfSuspensiveShootingDirectorRemoteModel,
					Tipo_Gara7_noUtil);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTipo_Gara8_noUtil() {
		return _Tipo_Gara8_noUtil;
	}

	@Override
	public void setTipo_Gara8_noUtil(long Tipo_Gara8_noUtil) {
		_Tipo_Gara8_noUtil = Tipo_Gara8_noUtil;

		if (_esfSuspensiveShootingDirectorRemoteModel != null) {
			try {
				Class<?> clazz = _esfSuspensiveShootingDirectorRemoteModel.getClass();

				Method method = clazz.getMethod("setTipo_Gara8_noUtil",
						long.class);

				method.invoke(_esfSuspensiveShootingDirectorRemoteModel,
					Tipo_Gara8_noUtil);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTipo_Gara9_noUtil() {
		return _Tipo_Gara9_noUtil;
	}

	@Override
	public void setTipo_Gara9_noUtil(long Tipo_Gara9_noUtil) {
		_Tipo_Gara9_noUtil = Tipo_Gara9_noUtil;

		if (_esfSuspensiveShootingDirectorRemoteModel != null) {
			try {
				Class<?> clazz = _esfSuspensiveShootingDirectorRemoteModel.getClass();

				Method method = clazz.getMethod("setTipo_Gara9_noUtil",
						long.class);

				method.invoke(_esfSuspensiveShootingDirectorRemoteModel,
					Tipo_Gara9_noUtil);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTipo_Gara10_noUtil() {
		return _Tipo_Gara10_noUtil;
	}

	@Override
	public void setTipo_Gara10_noUtil(long Tipo_Gara10_noUtil) {
		_Tipo_Gara10_noUtil = Tipo_Gara10_noUtil;

		if (_esfSuspensiveShootingDirectorRemoteModel != null) {
			try {
				Class<?> clazz = _esfSuspensiveShootingDirectorRemoteModel.getClass();

				Method method = clazz.getMethod("setTipo_Gara10_noUtil",
						long.class);

				method.invoke(_esfSuspensiveShootingDirectorRemoteModel,
					Tipo_Gara10_noUtil);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEsfVariationData() {
		return _esfVariationData;
	}

	@Override
	public void setEsfVariationData(Date esfVariationData) {
		_esfVariationData = esfVariationData;

		if (_esfSuspensiveShootingDirectorRemoteModel != null) {
			try {
				Class<?> clazz = _esfSuspensiveShootingDirectorRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfVariationData",
						Date.class);

				method.invoke(_esfSuspensiveShootingDirectorRemoteModel,
					esfVariationData);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFSuspensiveShootingDirectorRemoteModel() {
		return _esfSuspensiveShootingDirectorRemoteModel;
	}

	public void setESFSuspensiveShootingDirectorRemoteModel(
		BaseModel<?> esfSuspensiveShootingDirectorRemoteModel) {
		_esfSuspensiveShootingDirectorRemoteModel = esfSuspensiveShootingDirectorRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _esfSuspensiveShootingDirectorRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_esfSuspensiveShootingDirectorRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFSuspensiveShootingDirectorLocalServiceUtil.addESFSuspensiveShootingDirector(this);
		}
		else {
			ESFSuspensiveShootingDirectorLocalServiceUtil.updateESFSuspensiveShootingDirector(this);
		}
	}

	@Override
	public ESFSuspensiveShootingDirector toEscapedModel() {
		return (ESFSuspensiveShootingDirector)ProxyUtil.newProxyInstance(ESFSuspensiveShootingDirector.class.getClassLoader(),
			new Class[] { ESFSuspensiveShootingDirector.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFSuspensiveShootingDirectorClp clone = new ESFSuspensiveShootingDirectorClp();

		clone.setEsfSuspensiveShooingDirectorId(getEsfSuspensiveShooingDirectorId());
		clone.setEsfData(getEsfData());
		clone.setEsfCodeData(getEsfCodeData());
		clone.setEsfStartData(getEsfStartData());
		clone.setEsfEndData(getEsfEndData());
		clone.setEsfUserId(getEsfUserId());
		clone.setCodeUser(getCodeUser());
		clone.setCodice_Sosp(getCodice_Sosp());
		clone.setNote(getNote());
		clone.setQualif1_Utiliz(getQualif1_Utiliz());
		clone.setQualif2_Utiliz(getQualif2_Utiliz());
		clone.setQualif3_Utiliz(getQualif3_Utiliz());
		clone.setTipo_Gara1_noUtil(getTipo_Gara1_noUtil());
		clone.setTipo_Gara2_noUtil(getTipo_Gara2_noUtil());
		clone.setTipo_Gara3_noUtil(getTipo_Gara3_noUtil());
		clone.setTipo_Gara4_noUtil(getTipo_Gara4_noUtil());
		clone.setTipo_Gara5_noUtil(getTipo_Gara5_noUtil());
		clone.setTipo_Gara6_noUtil(getTipo_Gara6_noUtil());
		clone.setTipo_Gara7_noUtil(getTipo_Gara7_noUtil());
		clone.setTipo_Gara8_noUtil(getTipo_Gara8_noUtil());
		clone.setTipo_Gara9_noUtil(getTipo_Gara9_noUtil());
		clone.setTipo_Gara10_noUtil(getTipo_Gara10_noUtil());
		clone.setEsfVariationData(getEsfVariationData());

		return clone;
	}

	@Override
	public int compareTo(
		ESFSuspensiveShootingDirector esfSuspensiveShootingDirector) {
		int value = 0;

		if (getEsfSuspensiveShooingDirectorId() < esfSuspensiveShootingDirector.getEsfSuspensiveShooingDirectorId()) {
			value = -1;
		}
		else if (getEsfSuspensiveShooingDirectorId() > esfSuspensiveShootingDirector.getEsfSuspensiveShooingDirectorId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFSuspensiveShootingDirectorClp)) {
			return false;
		}

		ESFSuspensiveShootingDirectorClp esfSuspensiveShootingDirector = (ESFSuspensiveShootingDirectorClp)obj;

		long primaryKey = esfSuspensiveShootingDirector.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{esfSuspensiveShooingDirectorId=");
		sb.append(getEsfSuspensiveShooingDirectorId());
		sb.append(", esfData=");
		sb.append(getEsfData());
		sb.append(", esfCodeData=");
		sb.append(getEsfCodeData());
		sb.append(", esfStartData=");
		sb.append(getEsfStartData());
		sb.append(", esfEndData=");
		sb.append(getEsfEndData());
		sb.append(", esfUserId=");
		sb.append(getEsfUserId());
		sb.append(", codeUser=");
		sb.append(getCodeUser());
		sb.append(", Codice_Sosp=");
		sb.append(getCodice_Sosp());
		sb.append(", note=");
		sb.append(getNote());
		sb.append(", Qualif1_Utiliz=");
		sb.append(getQualif1_Utiliz());
		sb.append(", Qualif2_Utiliz=");
		sb.append(getQualif2_Utiliz());
		sb.append(", Qualif3_Utiliz=");
		sb.append(getQualif3_Utiliz());
		sb.append(", Tipo_Gara1_noUtil=");
		sb.append(getTipo_Gara1_noUtil());
		sb.append(", Tipo_Gara2_noUtil=");
		sb.append(getTipo_Gara2_noUtil());
		sb.append(", Tipo_Gara3_noUtil=");
		sb.append(getTipo_Gara3_noUtil());
		sb.append(", Tipo_Gara4_noUtil=");
		sb.append(getTipo_Gara4_noUtil());
		sb.append(", Tipo_Gara5_noUtil=");
		sb.append(getTipo_Gara5_noUtil());
		sb.append(", Tipo_Gara6_noUtil=");
		sb.append(getTipo_Gara6_noUtil());
		sb.append(", Tipo_Gara7_noUtil=");
		sb.append(getTipo_Gara7_noUtil());
		sb.append(", Tipo_Gara8_noUtil=");
		sb.append(getTipo_Gara8_noUtil());
		sb.append(", Tipo_Gara9_noUtil=");
		sb.append(getTipo_Gara9_noUtil());
		sb.append(", Tipo_Gara10_noUtil=");
		sb.append(getTipo_Gara10_noUtil());
		sb.append(", esfVariationData=");
		sb.append(getEsfVariationData());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(73);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFSuspensiveShootingDirector");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfSuspensiveShooingDirectorId</column-name><column-value><![CDATA[");
		sb.append(getEsfSuspensiveShooingDirectorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfData</column-name><column-value><![CDATA[");
		sb.append(getEsfData());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfCodeData</column-name><column-value><![CDATA[");
		sb.append(getEsfCodeData());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfStartData</column-name><column-value><![CDATA[");
		sb.append(getEsfStartData());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfEndData</column-name><column-value><![CDATA[");
		sb.append(getEsfEndData());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfUserId</column-name><column-value><![CDATA[");
		sb.append(getEsfUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codeUser</column-name><column-value><![CDATA[");
		sb.append(getCodeUser());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Codice_Sosp</column-name><column-value><![CDATA[");
		sb.append(getCodice_Sosp());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>note</column-name><column-value><![CDATA[");
		sb.append(getNote());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Qualif1_Utiliz</column-name><column-value><![CDATA[");
		sb.append(getQualif1_Utiliz());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Qualif2_Utiliz</column-name><column-value><![CDATA[");
		sb.append(getQualif2_Utiliz());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Qualif3_Utiliz</column-name><column-value><![CDATA[");
		sb.append(getQualif3_Utiliz());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Tipo_Gara1_noUtil</column-name><column-value><![CDATA[");
		sb.append(getTipo_Gara1_noUtil());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Tipo_Gara2_noUtil</column-name><column-value><![CDATA[");
		sb.append(getTipo_Gara2_noUtil());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Tipo_Gara3_noUtil</column-name><column-value><![CDATA[");
		sb.append(getTipo_Gara3_noUtil());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Tipo_Gara4_noUtil</column-name><column-value><![CDATA[");
		sb.append(getTipo_Gara4_noUtil());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Tipo_Gara5_noUtil</column-name><column-value><![CDATA[");
		sb.append(getTipo_Gara5_noUtil());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Tipo_Gara6_noUtil</column-name><column-value><![CDATA[");
		sb.append(getTipo_Gara6_noUtil());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Tipo_Gara7_noUtil</column-name><column-value><![CDATA[");
		sb.append(getTipo_Gara7_noUtil());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Tipo_Gara8_noUtil</column-name><column-value><![CDATA[");
		sb.append(getTipo_Gara8_noUtil());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Tipo_Gara9_noUtil</column-name><column-value><![CDATA[");
		sb.append(getTipo_Gara9_noUtil());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Tipo_Gara10_noUtil</column-name><column-value><![CDATA[");
		sb.append(getTipo_Gara10_noUtil());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfVariationData</column-name><column-value><![CDATA[");
		sb.append(getEsfVariationData());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfSuspensiveShooingDirectorId;
	private Date _esfData;
	private String _esfCodeData;
	private Date _esfStartData;
	private Date _esfEndData;
	private Long _esfUserId;
	private Long _codeUser;
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
	private BaseModel<?> _esfSuspensiveShootingDirectorRemoteModel;
	private Class<?> _clpSerializerClass = it.ethica.esf.service.ClpSerializer.class;
}