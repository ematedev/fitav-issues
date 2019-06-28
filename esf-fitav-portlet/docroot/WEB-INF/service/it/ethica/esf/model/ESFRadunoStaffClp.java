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
import com.liferay.portal.util.PortalUtil;

import it.ethica.esf.service.ClpSerializer;
import it.ethica.esf.service.ESFRadunoStaffLocalServiceUtil;
import it.ethica.esf.service.persistence.ESFRadunoStaffPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFRadunoStaffClp extends BaseModelImpl<ESFRadunoStaff>
	implements ESFRadunoStaff {
	public ESFRadunoStaffClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFRadunoStaff.class;
	}

	@Override
	public String getModelClassName() {
		return ESFRadunoStaff.class.getName();
	}

	@Override
	public ESFRadunoStaffPK getPrimaryKey() {
		return new ESFRadunoStaffPK(_id_esf_raduno_staff, _id_esf_raduno,
			_userId);
	}

	@Override
	public void setPrimaryKey(ESFRadunoStaffPK primaryKey) {
		setId_esf_raduno_staff(primaryKey.id_esf_raduno_staff);
		setId_esf_raduno(primaryKey.id_esf_raduno);
		setUserId(primaryKey.userId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ESFRadunoStaffPK(_id_esf_raduno_staff, _id_esf_raduno,
			_userId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ESFRadunoStaffPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_esf_raduno_staff", getId_esf_raduno_staff());
		attributes.put("id_esf_raduno", getId_esf_raduno());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_esf_raduno_staff = (Long)attributes.get("id_esf_raduno_staff");

		if (id_esf_raduno_staff != null) {
			setId_esf_raduno_staff(id_esf_raduno_staff);
		}

		Long id_esf_raduno = (Long)attributes.get("id_esf_raduno");

		if (id_esf_raduno != null) {
			setId_esf_raduno(id_esf_raduno);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	@Override
	public long getId_esf_raduno_staff() {
		return _id_esf_raduno_staff;
	}

	@Override
	public void setId_esf_raduno_staff(long id_esf_raduno_staff) {
		_id_esf_raduno_staff = id_esf_raduno_staff;

		if (_esfRadunoStaffRemoteModel != null) {
			try {
				Class<?> clazz = _esfRadunoStaffRemoteModel.getClass();

				Method method = clazz.getMethod("setId_esf_raduno_staff",
						long.class);

				method.invoke(_esfRadunoStaffRemoteModel, id_esf_raduno_staff);
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

		if (_esfRadunoStaffRemoteModel != null) {
			try {
				Class<?> clazz = _esfRadunoStaffRemoteModel.getClass();

				Method method = clazz.getMethod("setId_esf_raduno", long.class);

				method.invoke(_esfRadunoStaffRemoteModel, id_esf_raduno);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_esfRadunoStaffRemoteModel != null) {
			try {
				Class<?> clazz = _esfRadunoStaffRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_esfRadunoStaffRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public BaseModel<?> getESFRadunoStaffRemoteModel() {
		return _esfRadunoStaffRemoteModel;
	}

	public void setESFRadunoStaffRemoteModel(
		BaseModel<?> esfRadunoStaffRemoteModel) {
		_esfRadunoStaffRemoteModel = esfRadunoStaffRemoteModel;
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

		Class<?> remoteModelClass = _esfRadunoStaffRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfRadunoStaffRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFRadunoStaffLocalServiceUtil.addESFRadunoStaff(this);
		}
		else {
			ESFRadunoStaffLocalServiceUtil.updateESFRadunoStaff(this);
		}
	}

	@Override
	public ESFRadunoStaff toEscapedModel() {
		return (ESFRadunoStaff)ProxyUtil.newProxyInstance(ESFRadunoStaff.class.getClassLoader(),
			new Class[] { ESFRadunoStaff.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFRadunoStaffClp clone = new ESFRadunoStaffClp();

		clone.setId_esf_raduno_staff(getId_esf_raduno_staff());
		clone.setId_esf_raduno(getId_esf_raduno());
		clone.setUserId(getUserId());

		return clone;
	}

	@Override
	public int compareTo(ESFRadunoStaff esfRadunoStaff) {
		ESFRadunoStaffPK primaryKey = esfRadunoStaff.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFRadunoStaffClp)) {
			return false;
		}

		ESFRadunoStaffClp esfRadunoStaff = (ESFRadunoStaffClp)obj;

		ESFRadunoStaffPK primaryKey = esfRadunoStaff.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{id_esf_raduno_staff=");
		sb.append(getId_esf_raduno_staff());
		sb.append(", id_esf_raduno=");
		sb.append(getId_esf_raduno());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFRadunoStaff");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id_esf_raduno_staff</column-name><column-value><![CDATA[");
		sb.append(getId_esf_raduno_staff());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id_esf_raduno</column-name><column-value><![CDATA[");
		sb.append(getId_esf_raduno());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id_esf_raduno_staff;
	private long _id_esf_raduno;
	private long _userId;
	private String _userUuid;
	private BaseModel<?> _esfRadunoStaffRemoteModel;
}