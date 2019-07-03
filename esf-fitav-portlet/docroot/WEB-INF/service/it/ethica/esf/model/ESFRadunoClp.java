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
import it.ethica.esf.service.ESFRadunoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFRadunoClp extends BaseModelImpl<ESFRaduno> implements ESFRaduno {
	public ESFRadunoClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFRaduno.class;
	}

	@Override
	public String getModelClassName() {
		return ESFRaduno.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _id_esf_raduno;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId_esf_raduno(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id_esf_raduno;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_esf_raduno", getId_esf_raduno());
		attributes.put("codice", getCodice());
		attributes.put("data_inizio", getData_inizio());
		attributes.put("data_fine", getData_fine());
		attributes.put("tipo_raduno", getTipo_raduno());
		attributes.put("id_sottotipo_raduno", getId_sottotipo_raduno());
		attributes.put("note", getNote());
		attributes.put("id_associazione_ospitante",
			getId_associazione_ospitante());
		attributes.put("altra_sede_ospitante", getAltra_sede_ospitante());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_esf_raduno = (Long)attributes.get("id_esf_raduno");

		if (id_esf_raduno != null) {
			setId_esf_raduno(id_esf_raduno);
		}

		String codice = (String)attributes.get("codice");

		if (codice != null) {
			setCodice(codice);
		}

		Date data_inizio = (Date)attributes.get("data_inizio");

		if (data_inizio != null) {
			setData_inizio(data_inizio);
		}

		Date data_fine = (Date)attributes.get("data_fine");

		if (data_fine != null) {
			setData_fine(data_fine);
		}

		Long tipo_raduno = (Long)attributes.get("tipo_raduno");

		if (tipo_raduno != null) {
			setTipo_raduno(tipo_raduno);
		}

		Long id_sottotipo_raduno = (Long)attributes.get("id_sottotipo_raduno");

		if (id_sottotipo_raduno != null) {
			setId_sottotipo_raduno(id_sottotipo_raduno);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		Long id_associazione_ospitante = (Long)attributes.get(
				"id_associazione_ospitante");

		if (id_associazione_ospitante != null) {
			setId_associazione_ospitante(id_associazione_ospitante);
		}

		String altra_sede_ospitante = (String)attributes.get(
				"altra_sede_ospitante");

		if (altra_sede_ospitante != null) {
			setAltra_sede_ospitante(altra_sede_ospitante);
		}
	}

	@Override
	public long getId_esf_raduno() {
		return _id_esf_raduno;
	}

	@Override
	public void setId_esf_raduno(long id_esf_raduno) {
		_id_esf_raduno = id_esf_raduno;

		if (_esfRadunoRemoteModel != null) {
			try {
				Class<?> clazz = _esfRadunoRemoteModel.getClass();

				Method method = clazz.getMethod("setId_esf_raduno", long.class);

				method.invoke(_esfRadunoRemoteModel, id_esf_raduno);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCodice() {
		return _codice;
	}

	@Override
	public void setCodice(String codice) {
		_codice = codice;

		if (_esfRadunoRemoteModel != null) {
			try {
				Class<?> clazz = _esfRadunoRemoteModel.getClass();

				Method method = clazz.getMethod("setCodice", String.class);

				method.invoke(_esfRadunoRemoteModel, codice);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getData_inizio() {
		return _data_inizio;
	}

	@Override
	public void setData_inizio(Date data_inizio) {
		_data_inizio = data_inizio;

		if (_esfRadunoRemoteModel != null) {
			try {
				Class<?> clazz = _esfRadunoRemoteModel.getClass();

				Method method = clazz.getMethod("setData_inizio", Date.class);

				method.invoke(_esfRadunoRemoteModel, data_inizio);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getData_fine() {
		return _data_fine;
	}

	@Override
	public void setData_fine(Date data_fine) {
		_data_fine = data_fine;

		if (_esfRadunoRemoteModel != null) {
			try {
				Class<?> clazz = _esfRadunoRemoteModel.getClass();

				Method method = clazz.getMethod("setData_fine", Date.class);

				method.invoke(_esfRadunoRemoteModel, data_fine);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTipo_raduno() {
		return _tipo_raduno;
	}

	@Override
	public void setTipo_raduno(long tipo_raduno) {
		_tipo_raduno = tipo_raduno;

		if (_esfRadunoRemoteModel != null) {
			try {
				Class<?> clazz = _esfRadunoRemoteModel.getClass();

				Method method = clazz.getMethod("setTipo_raduno", long.class);

				method.invoke(_esfRadunoRemoteModel, tipo_raduno);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getId_sottotipo_raduno() {
		return _id_sottotipo_raduno;
	}

	@Override
	public void setId_sottotipo_raduno(long id_sottotipo_raduno) {
		_id_sottotipo_raduno = id_sottotipo_raduno;

		if (_esfRadunoRemoteModel != null) {
			try {
				Class<?> clazz = _esfRadunoRemoteModel.getClass();

				Method method = clazz.getMethod("setId_sottotipo_raduno",
						long.class);

				method.invoke(_esfRadunoRemoteModel, id_sottotipo_raduno);
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

		if (_esfRadunoRemoteModel != null) {
			try {
				Class<?> clazz = _esfRadunoRemoteModel.getClass();

				Method method = clazz.getMethod("setNote", String.class);

				method.invoke(_esfRadunoRemoteModel, note);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getId_associazione_ospitante() {
		return _id_associazione_ospitante;
	}

	@Override
	public void setId_associazione_ospitante(long id_associazione_ospitante) {
		_id_associazione_ospitante = id_associazione_ospitante;

		if (_esfRadunoRemoteModel != null) {
			try {
				Class<?> clazz = _esfRadunoRemoteModel.getClass();

				Method method = clazz.getMethod("setId_associazione_ospitante",
						long.class);

				method.invoke(_esfRadunoRemoteModel, id_associazione_ospitante);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAltra_sede_ospitante() {
		return _altra_sede_ospitante;
	}

	@Override
	public void setAltra_sede_ospitante(String altra_sede_ospitante) {
		_altra_sede_ospitante = altra_sede_ospitante;

		if (_esfRadunoRemoteModel != null) {
			try {
				Class<?> clazz = _esfRadunoRemoteModel.getClass();

				Method method = clazz.getMethod("setAltra_sede_ospitante",
						String.class);

				method.invoke(_esfRadunoRemoteModel, altra_sede_ospitante);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFRadunoRemoteModel() {
		return _esfRadunoRemoteModel;
	}

	public void setESFRadunoRemoteModel(BaseModel<?> esfRadunoRemoteModel) {
		_esfRadunoRemoteModel = esfRadunoRemoteModel;
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

		Class<?> remoteModelClass = _esfRadunoRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfRadunoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFRadunoLocalServiceUtil.addESFRaduno(this);
		}
		else {
			ESFRadunoLocalServiceUtil.updateESFRaduno(this);
		}
	}

	@Override
	public ESFRaduno toEscapedModel() {
		return (ESFRaduno)ProxyUtil.newProxyInstance(ESFRaduno.class.getClassLoader(),
			new Class[] { ESFRaduno.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFRadunoClp clone = new ESFRadunoClp();

		clone.setId_esf_raduno(getId_esf_raduno());
		clone.setCodice(getCodice());
		clone.setData_inizio(getData_inizio());
		clone.setData_fine(getData_fine());
		clone.setTipo_raduno(getTipo_raduno());
		clone.setId_sottotipo_raduno(getId_sottotipo_raduno());
		clone.setNote(getNote());
		clone.setId_associazione_ospitante(getId_associazione_ospitante());
		clone.setAltra_sede_ospitante(getAltra_sede_ospitante());

		return clone;
	}

	@Override
	public int compareTo(ESFRaduno esfRaduno) {
		long primaryKey = esfRaduno.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFRadunoClp)) {
			return false;
		}

		ESFRadunoClp esfRaduno = (ESFRadunoClp)obj;

		long primaryKey = esfRaduno.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{id_esf_raduno=");
		sb.append(getId_esf_raduno());
		sb.append(", codice=");
		sb.append(getCodice());
		sb.append(", data_inizio=");
		sb.append(getData_inizio());
		sb.append(", data_fine=");
		sb.append(getData_fine());
		sb.append(", tipo_raduno=");
		sb.append(getTipo_raduno());
		sb.append(", id_sottotipo_raduno=");
		sb.append(getId_sottotipo_raduno());
		sb.append(", note=");
		sb.append(getNote());
		sb.append(", id_associazione_ospitante=");
		sb.append(getId_associazione_ospitante());
		sb.append(", altra_sede_ospitante=");
		sb.append(getAltra_sede_ospitante());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFRaduno");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id_esf_raduno</column-name><column-value><![CDATA[");
		sb.append(getId_esf_raduno());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codice</column-name><column-value><![CDATA[");
		sb.append(getCodice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>data_inizio</column-name><column-value><![CDATA[");
		sb.append(getData_inizio());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>data_fine</column-name><column-value><![CDATA[");
		sb.append(getData_fine());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipo_raduno</column-name><column-value><![CDATA[");
		sb.append(getTipo_raduno());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id_sottotipo_raduno</column-name><column-value><![CDATA[");
		sb.append(getId_sottotipo_raduno());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>note</column-name><column-value><![CDATA[");
		sb.append(getNote());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id_associazione_ospitante</column-name><column-value><![CDATA[");
		sb.append(getId_associazione_ospitante());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>altra_sede_ospitante</column-name><column-value><![CDATA[");
		sb.append(getAltra_sede_ospitante());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id_esf_raduno;
	private String _codice;
	private Date _data_inizio;
	private Date _data_fine;
	private long _tipo_raduno;
	private long _id_sottotipo_raduno;
	private String _note;
	private long _id_associazione_ospitante;
	private String _altra_sede_ospitante;
	private BaseModel<?> _esfRadunoRemoteModel;
	private Class<?> _clpSerializerClass = it.ethica.esf.service.ClpSerializer.class;
}