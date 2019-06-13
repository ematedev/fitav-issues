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
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import it.ethica.esf.service.ClpSerializer;
import it.ethica.esf.service.persistence.ESFShooterCategoryESFTournamentPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFShooterCategoryESFTournamentClp extends BaseModelImpl<ESFShooterCategoryESFTournament>
	implements ESFShooterCategoryESFTournament {
	public ESFShooterCategoryESFTournamentClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFShooterCategoryESFTournament.class;
	}

	@Override
	public String getModelClassName() {
		return ESFShooterCategoryESFTournament.class.getName();
	}

	@Override
	public ESFShooterCategoryESFTournamentPK getPrimaryKey() {
		return new ESFShooterCategoryESFTournamentPK(_esfShooterCategoryId,
			_esfTournamentId);
	}

	@Override
	public void setPrimaryKey(ESFShooterCategoryESFTournamentPK primaryKey) {
		setEsfShooterCategoryId(primaryKey.esfShooterCategoryId);
		setEsfTournamentId(primaryKey.esfTournamentId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ESFShooterCategoryESFTournamentPK(_esfShooterCategoryId,
			_esfTournamentId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ESFShooterCategoryESFTournamentPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfShooterCategoryId", getEsfShooterCategoryId());
		attributes.put("esfTournamentId", getEsfTournamentId());
		attributes.put("groupId", getGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfShooterCategoryId = (Long)attributes.get("esfShooterCategoryId");

		if (esfShooterCategoryId != null) {
			setEsfShooterCategoryId(esfShooterCategoryId);
		}

		Long esfTournamentId = (Long)attributes.get("esfTournamentId");

		if (esfTournamentId != null) {
			setEsfTournamentId(esfTournamentId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_esfShooterCategoryESFTournamentRemoteModel != null) {
			try {
				Class<?> clazz = _esfShooterCategoryESFTournamentRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_esfShooterCategoryESFTournamentRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfShooterCategoryId() {
		return _esfShooterCategoryId;
	}

	@Override
	public void setEsfShooterCategoryId(long esfShooterCategoryId) {
		_esfShooterCategoryId = esfShooterCategoryId;

		if (_esfShooterCategoryESFTournamentRemoteModel != null) {
			try {
				Class<?> clazz = _esfShooterCategoryESFTournamentRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfShooterCategoryId",
						long.class);

				method.invoke(_esfShooterCategoryESFTournamentRemoteModel,
					esfShooterCategoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfTournamentId() {
		return _esfTournamentId;
	}

	@Override
	public void setEsfTournamentId(long esfTournamentId) {
		_esfTournamentId = esfTournamentId;

		if (_esfShooterCategoryESFTournamentRemoteModel != null) {
			try {
				Class<?> clazz = _esfShooterCategoryESFTournamentRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfTournamentId", long.class);

				method.invoke(_esfShooterCategoryESFTournamentRemoteModel,
					esfTournamentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_esfShooterCategoryESFTournamentRemoteModel != null) {
			try {
				Class<?> clazz = _esfShooterCategoryESFTournamentRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_esfShooterCategoryESFTournamentRemoteModel,
					groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFShooterCategoryESFTournamentRemoteModel() {
		return _esfShooterCategoryESFTournamentRemoteModel;
	}

	public void setESFShooterCategoryESFTournamentRemoteModel(
		BaseModel<?> esfShooterCategoryESFTournamentRemoteModel) {
		_esfShooterCategoryESFTournamentRemoteModel = esfShooterCategoryESFTournamentRemoteModel;
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

		Class<?> remoteModelClass = _esfShooterCategoryESFTournamentRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfShooterCategoryESFTournamentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public ESFShooterCategoryESFTournament toEscapedModel() {
		return (ESFShooterCategoryESFTournament)ProxyUtil.newProxyInstance(ESFShooterCategoryESFTournament.class.getClassLoader(),
			new Class[] { ESFShooterCategoryESFTournament.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFShooterCategoryESFTournamentClp clone = new ESFShooterCategoryESFTournamentClp();

		clone.setUuid(getUuid());
		clone.setEsfShooterCategoryId(getEsfShooterCategoryId());
		clone.setEsfTournamentId(getEsfTournamentId());
		clone.setGroupId(getGroupId());

		return clone;
	}

	@Override
	public int compareTo(
		ESFShooterCategoryESFTournament esfShooterCategoryESFTournament) {
		ESFShooterCategoryESFTournamentPK primaryKey = esfShooterCategoryESFTournament.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFShooterCategoryESFTournamentClp)) {
			return false;
		}

		ESFShooterCategoryESFTournamentClp esfShooterCategoryESFTournament = (ESFShooterCategoryESFTournamentClp)obj;

		ESFShooterCategoryESFTournamentPK primaryKey = esfShooterCategoryESFTournament.getPrimaryKey();

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

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", esfShooterCategoryId=");
		sb.append(getEsfShooterCategoryId());
		sb.append(", esfTournamentId=");
		sb.append(getEsfTournamentId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFShooterCategoryESFTournament");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfShooterCategoryId</column-name><column-value><![CDATA[");
		sb.append(getEsfShooterCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfTournamentId</column-name><column-value><![CDATA[");
		sb.append(getEsfTournamentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _esfShooterCategoryId;
	private long _esfTournamentId;
	private long _groupId;
	private BaseModel<?> _esfShooterCategoryESFTournamentRemoteModel;
	private Class<?> _clpSerializerClass = it.ethica.esf.service.ClpSerializer.class;
}