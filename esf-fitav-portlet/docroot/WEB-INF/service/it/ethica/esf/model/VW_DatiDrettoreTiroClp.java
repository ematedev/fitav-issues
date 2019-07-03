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
import it.ethica.esf.service.VW_DatiDrettoreTiroLocalServiceUtil;
import it.ethica.esf.service.persistence.VW_DatiDrettoreTiroPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class VW_DatiDrettoreTiroClp extends BaseModelImpl<VW_DatiDrettoreTiro>
	implements VW_DatiDrettoreTiro {
	public VW_DatiDrettoreTiroClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return VW_DatiDrettoreTiro.class;
	}

	@Override
	public String getModelClassName() {
		return VW_DatiDrettoreTiro.class.getName();
	}

	@Override
	public VW_DatiDrettoreTiroPK getPrimaryKey() {
		return new VW_DatiDrettoreTiroPK(_esfShootingDirectorId, _Nome,
			_Cognome, _CodiceRegione);
	}

	@Override
	public void setPrimaryKey(VW_DatiDrettoreTiroPK primaryKey) {
		setEsfShootingDirectorId(primaryKey.esfShootingDirectorId);
		setNome(primaryKey.Nome);
		setCognome(primaryKey.Cognome);
		setCodiceRegione(primaryKey.CodiceRegione);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new VW_DatiDrettoreTiroPK(_esfShootingDirectorId, _Nome,
			_Cognome, _CodiceRegione);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((VW_DatiDrettoreTiroPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfShootingDirectorId", getEsfShootingDirectorId());
		attributes.put("Nome", getNome());
		attributes.put("Cognome", getCognome());
		attributes.put("CodiceRegione", getCodiceRegione());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfShootingDirectorId = (Long)attributes.get(
				"esfShootingDirectorId");

		if (esfShootingDirectorId != null) {
			setEsfShootingDirectorId(esfShootingDirectorId);
		}

		String Nome = (String)attributes.get("Nome");

		if (Nome != null) {
			setNome(Nome);
		}

		String Cognome = (String)attributes.get("Cognome");

		if (Cognome != null) {
			setCognome(Cognome);
		}

		String CodiceRegione = (String)attributes.get("CodiceRegione");

		if (CodiceRegione != null) {
			setCodiceRegione(CodiceRegione);
		}
	}

	@Override
	public long getEsfShootingDirectorId() {
		return _esfShootingDirectorId;
	}

	@Override
	public void setEsfShootingDirectorId(long esfShootingDirectorId) {
		_esfShootingDirectorId = esfShootingDirectorId;

		if (_vw_DatiDrettoreTiroRemoteModel != null) {
			try {
				Class<?> clazz = _vw_DatiDrettoreTiroRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfShootingDirectorId",
						long.class);

				method.invoke(_vw_DatiDrettoreTiroRemoteModel,
					esfShootingDirectorId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNome() {
		return _Nome;
	}

	@Override
	public void setNome(String Nome) {
		_Nome = Nome;

		if (_vw_DatiDrettoreTiroRemoteModel != null) {
			try {
				Class<?> clazz = _vw_DatiDrettoreTiroRemoteModel.getClass();

				Method method = clazz.getMethod("setNome", String.class);

				method.invoke(_vw_DatiDrettoreTiroRemoteModel, Nome);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCognome() {
		return _Cognome;
	}

	@Override
	public void setCognome(String Cognome) {
		_Cognome = Cognome;

		if (_vw_DatiDrettoreTiroRemoteModel != null) {
			try {
				Class<?> clazz = _vw_DatiDrettoreTiroRemoteModel.getClass();

				Method method = clazz.getMethod("setCognome", String.class);

				method.invoke(_vw_DatiDrettoreTiroRemoteModel, Cognome);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCodiceRegione() {
		return _CodiceRegione;
	}

	@Override
	public void setCodiceRegione(String CodiceRegione) {
		_CodiceRegione = CodiceRegione;

		if (_vw_DatiDrettoreTiroRemoteModel != null) {
			try {
				Class<?> clazz = _vw_DatiDrettoreTiroRemoteModel.getClass();

				Method method = clazz.getMethod("setCodiceRegione", String.class);

				method.invoke(_vw_DatiDrettoreTiroRemoteModel, CodiceRegione);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getVW_DatiDrettoreTiroRemoteModel() {
		return _vw_DatiDrettoreTiroRemoteModel;
	}

	public void setVW_DatiDrettoreTiroRemoteModel(
		BaseModel<?> vw_DatiDrettoreTiroRemoteModel) {
		_vw_DatiDrettoreTiroRemoteModel = vw_DatiDrettoreTiroRemoteModel;
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

		Class<?> remoteModelClass = _vw_DatiDrettoreTiroRemoteModel.getClass();

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

		Object returnValue = method.invoke(_vw_DatiDrettoreTiroRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			VW_DatiDrettoreTiroLocalServiceUtil.addVW_DatiDrettoreTiro(this);
		}
		else {
			VW_DatiDrettoreTiroLocalServiceUtil.updateVW_DatiDrettoreTiro(this);
		}
	}

	@Override
	public VW_DatiDrettoreTiro toEscapedModel() {
		return (VW_DatiDrettoreTiro)ProxyUtil.newProxyInstance(VW_DatiDrettoreTiro.class.getClassLoader(),
			new Class[] { VW_DatiDrettoreTiro.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VW_DatiDrettoreTiroClp clone = new VW_DatiDrettoreTiroClp();

		clone.setEsfShootingDirectorId(getEsfShootingDirectorId());
		clone.setNome(getNome());
		clone.setCognome(getCognome());
		clone.setCodiceRegione(getCodiceRegione());

		return clone;
	}

	@Override
	public int compareTo(VW_DatiDrettoreTiro vw_DatiDrettoreTiro) {
		VW_DatiDrettoreTiroPK primaryKey = vw_DatiDrettoreTiro.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VW_DatiDrettoreTiroClp)) {
			return false;
		}

		VW_DatiDrettoreTiroClp vw_DatiDrettoreTiro = (VW_DatiDrettoreTiroClp)obj;

		VW_DatiDrettoreTiroPK primaryKey = vw_DatiDrettoreTiro.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
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
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{esfShootingDirectorId=");
		sb.append(getEsfShootingDirectorId());
		sb.append(", Nome=");
		sb.append(getNome());
		sb.append(", Cognome=");
		sb.append(getCognome());
		sb.append(", CodiceRegione=");
		sb.append(getCodiceRegione());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.VW_DatiDrettoreTiro");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfShootingDirectorId</column-name><column-value><![CDATA[");
		sb.append(getEsfShootingDirectorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Nome</column-name><column-value><![CDATA[");
		sb.append(getNome());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Cognome</column-name><column-value><![CDATA[");
		sb.append(getCognome());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CodiceRegione</column-name><column-value><![CDATA[");
		sb.append(getCodiceRegione());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfShootingDirectorId;
	private String _Nome;
	private String _Cognome;
	private String _CodiceRegione;
	private BaseModel<?> _vw_DatiDrettoreTiroRemoteModel;
	private Class<?> _clpSerializerClass = it.ethica.esf.service.ClpSerializer.class;
}