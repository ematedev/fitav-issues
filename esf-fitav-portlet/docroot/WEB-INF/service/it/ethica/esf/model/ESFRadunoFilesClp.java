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
import it.ethica.esf.service.ESFRadunoFilesLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFRadunoFilesClp extends BaseModelImpl<ESFRadunoFiles>
	implements ESFRadunoFiles {
	public ESFRadunoFilesClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFRadunoFiles.class;
	}

	@Override
	public String getModelClassName() {
		return ESFRadunoFiles.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _id_esf_raduno_files;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId_esf_raduno_files(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id_esf_raduno_files;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_esf_raduno_files", getId_esf_raduno_files());
		attributes.put("id_esf_raduno", getId_esf_raduno());
		attributes.put("nome", getNome());
		attributes.put("path", getPath());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_esf_raduno_files = (Long)attributes.get("id_esf_raduno_files");

		if (id_esf_raduno_files != null) {
			setId_esf_raduno_files(id_esf_raduno_files);
		}

		Long id_esf_raduno = (Long)attributes.get("id_esf_raduno");

		if (id_esf_raduno != null) {
			setId_esf_raduno(id_esf_raduno);
		}

		String nome = (String)attributes.get("nome");

		if (nome != null) {
			setNome(nome);
		}

		String path = (String)attributes.get("path");

		if (path != null) {
			setPath(path);
		}
	}

	@Override
	public long getId_esf_raduno_files() {
		return _id_esf_raduno_files;
	}

	@Override
	public void setId_esf_raduno_files(long id_esf_raduno_files) {
		_id_esf_raduno_files = id_esf_raduno_files;

		if (_esfRadunoFilesRemoteModel != null) {
			try {
				Class<?> clazz = _esfRadunoFilesRemoteModel.getClass();

				Method method = clazz.getMethod("setId_esf_raduno_files",
						long.class);

				method.invoke(_esfRadunoFilesRemoteModel, id_esf_raduno_files);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getId_esf_raduno() {
		return _id_esf_raduno;
	}

	@Override
	public void setId_esf_raduno(long id_esf_raduno) {
		_id_esf_raduno = id_esf_raduno;

		if (_esfRadunoFilesRemoteModel != null) {
			try {
				Class<?> clazz = _esfRadunoFilesRemoteModel.getClass();

				Method method = clazz.getMethod("setId_esf_raduno", long.class);

				method.invoke(_esfRadunoFilesRemoteModel, id_esf_raduno);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNome() {
		return _nome;
	}

	@Override
	public void setNome(String nome) {
		_nome = nome;

		if (_esfRadunoFilesRemoteModel != null) {
			try {
				Class<?> clazz = _esfRadunoFilesRemoteModel.getClass();

				Method method = clazz.getMethod("setNome", String.class);

				method.invoke(_esfRadunoFilesRemoteModel, nome);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPath() {
		return _path;
	}

	@Override
	public void setPath(String path) {
		_path = path;

		if (_esfRadunoFilesRemoteModel != null) {
			try {
				Class<?> clazz = _esfRadunoFilesRemoteModel.getClass();

				Method method = clazz.getMethod("setPath", String.class);

				method.invoke(_esfRadunoFilesRemoteModel, path);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFRadunoFilesRemoteModel() {
		return _esfRadunoFilesRemoteModel;
	}

	public void setESFRadunoFilesRemoteModel(
		BaseModel<?> esfRadunoFilesRemoteModel) {
		_esfRadunoFilesRemoteModel = esfRadunoFilesRemoteModel;
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

		Class<?> remoteModelClass = _esfRadunoFilesRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfRadunoFilesRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFRadunoFilesLocalServiceUtil.addESFRadunoFiles(this);
		}
		else {
			ESFRadunoFilesLocalServiceUtil.updateESFRadunoFiles(this);
		}
	}

	@Override
	public ESFRadunoFiles toEscapedModel() {
		return (ESFRadunoFiles)ProxyUtil.newProxyInstance(ESFRadunoFiles.class.getClassLoader(),
			new Class[] { ESFRadunoFiles.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFRadunoFilesClp clone = new ESFRadunoFilesClp();

		clone.setId_esf_raduno_files(getId_esf_raduno_files());
		clone.setId_esf_raduno(getId_esf_raduno());
		clone.setNome(getNome());
		clone.setPath(getPath());

		return clone;
	}

	@Override
	public int compareTo(ESFRadunoFiles esfRadunoFiles) {
		long primaryKey = esfRadunoFiles.getPrimaryKey();

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

		if (!(obj instanceof ESFRadunoFilesClp)) {
			return false;
		}

		ESFRadunoFilesClp esfRadunoFiles = (ESFRadunoFilesClp)obj;

		long primaryKey = esfRadunoFiles.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{id_esf_raduno_files=");
		sb.append(getId_esf_raduno_files());
		sb.append(", id_esf_raduno=");
		sb.append(getId_esf_raduno());
		sb.append(", nome=");
		sb.append(getNome());
		sb.append(", path=");
		sb.append(getPath());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFRadunoFiles");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id_esf_raduno_files</column-name><column-value><![CDATA[");
		sb.append(getId_esf_raduno_files());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id_esf_raduno</column-name><column-value><![CDATA[");
		sb.append(getId_esf_raduno());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nome</column-name><column-value><![CDATA[");
		sb.append(getNome());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>path</column-name><column-value><![CDATA[");
		sb.append(getPath());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id_esf_raduno_files;
	private long _id_esf_raduno;
	private String _nome;
	private String _path;
	private BaseModel<?> _esfRadunoFilesRemoteModel;
	private Class<?> _clpSerializerClass = it.ethica.esf.service.ClpSerializer.class;
}