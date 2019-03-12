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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import it.ethica.esf.service.ClpSerializer;
import it.ethica.esf.service.persistence.ESFShooterQualificationESFTournamentPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFShooterQualificationESFTournamentClp extends BaseModelImpl<ESFShooterQualificationESFTournament>
	implements ESFShooterQualificationESFTournament {
	public ESFShooterQualificationESFTournamentClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFShooterQualificationESFTournament.class;
	}

	@Override
	public String getModelClassName() {
		return ESFShooterQualificationESFTournament.class.getName();
	}

	@Override
	public ESFShooterQualificationESFTournamentPK getPrimaryKey() {
		return new ESFShooterQualificationESFTournamentPK(_esfShooterQualificationId,
			_esfTournamentId);
	}

	@Override
	public void setPrimaryKey(ESFShooterQualificationESFTournamentPK primaryKey) {
		setEsfShooterQualificationId(primaryKey.esfShooterQualificationId);
		setEsfTournamentId(primaryKey.esfTournamentId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ESFShooterQualificationESFTournamentPK(_esfShooterQualificationId,
			_esfTournamentId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ESFShooterQualificationESFTournamentPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfShooterQualificationId",
			getEsfShooterQualificationId());
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

		Long esfShooterQualificationId = (Long)attributes.get(
				"esfShooterQualificationId");

		if (esfShooterQualificationId != null) {
			setEsfShooterQualificationId(esfShooterQualificationId);
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

		if (_esfShooterQualificationESFTournamentRemoteModel != null) {
			try {
				Class<?> clazz = _esfShooterQualificationESFTournamentRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_esfShooterQualificationESFTournamentRemoteModel,
					uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfShooterQualificationId() {
		return _esfShooterQualificationId;
	}

	@Override
	public void setEsfShooterQualificationId(long esfShooterQualificationId) {
		_esfShooterQualificationId = esfShooterQualificationId;

		if (_esfShooterQualificationESFTournamentRemoteModel != null) {
			try {
				Class<?> clazz = _esfShooterQualificationESFTournamentRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfShooterQualificationId",
						long.class);

				method.invoke(_esfShooterQualificationESFTournamentRemoteModel,
					esfShooterQualificationId);
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

		if (_esfShooterQualificationESFTournamentRemoteModel != null) {
			try {
				Class<?> clazz = _esfShooterQualificationESFTournamentRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfTournamentId", long.class);

				method.invoke(_esfShooterQualificationESFTournamentRemoteModel,
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

		if (_esfShooterQualificationESFTournamentRemoteModel != null) {
			try {
				Class<?> clazz = _esfShooterQualificationESFTournamentRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_esfShooterQualificationESFTournamentRemoteModel,
					groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFShooterQualificationESFTournamentRemoteModel() {
		return _esfShooterQualificationESFTournamentRemoteModel;
	}

	public void setESFShooterQualificationESFTournamentRemoteModel(
		BaseModel<?> esfShooterQualificationESFTournamentRemoteModel) {
		_esfShooterQualificationESFTournamentRemoteModel = esfShooterQualificationESFTournamentRemoteModel;
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

		Class<?> remoteModelClass = _esfShooterQualificationESFTournamentRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfShooterQualificationESFTournamentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public ESFShooterQualificationESFTournament toEscapedModel() {
		return (ESFShooterQualificationESFTournament)ProxyUtil.newProxyInstance(ESFShooterQualificationESFTournament.class.getClassLoader(),
			new Class[] { ESFShooterQualificationESFTournament.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFShooterQualificationESFTournamentClp clone = new ESFShooterQualificationESFTournamentClp();

		clone.setUuid(getUuid());
		clone.setEsfShooterQualificationId(getEsfShooterQualificationId());
		clone.setEsfTournamentId(getEsfTournamentId());
		clone.setGroupId(getGroupId());

		return clone;
	}

	@Override
	public int compareTo(
		ESFShooterQualificationESFTournament esfShooterQualificationESFTournament) {
		ESFShooterQualificationESFTournamentPK primaryKey = esfShooterQualificationESFTournament.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFShooterQualificationESFTournamentClp)) {
			return false;
		}

		ESFShooterQualificationESFTournamentClp esfShooterQualificationESFTournament =
			(ESFShooterQualificationESFTournamentClp)obj;

		ESFShooterQualificationESFTournamentPK primaryKey = esfShooterQualificationESFTournament.getPrimaryKey();

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
		sb.append(", esfShooterQualificationId=");
		sb.append(getEsfShooterQualificationId());
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
		sb.append("it.ethica.esf.model.ESFShooterQualificationESFTournament");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfShooterQualificationId</column-name><column-value><![CDATA[");
		sb.append(getEsfShooterQualificationId());
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
	private long _esfShooterQualificationId;
	private long _esfTournamentId;
	private long _groupId;
	private BaseModel<?> _esfShooterQualificationESFTournamentRemoteModel;
	private Class<?> _clpSerializerClass = it.ethica.esf.service.ClpSerializer.class;
}