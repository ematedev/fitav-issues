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
import it.ethica.esf.service.VW_AzzurriLocalServiceUtil;
import it.ethica.esf.service.persistence.VW_AzzurriPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class VW_AzzurriClp extends BaseModelImpl<VW_Azzurri>
	implements VW_Azzurri {
	public VW_AzzurriClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return VW_Azzurri.class;
	}

	@Override
	public String getModelClassName() {
		return VW_Azzurri.class.getName();
	}

	@Override
	public VW_AzzurriPK getPrimaryKey() {
		return new VW_AzzurriPK(_esfNationalId, _userId, _esfSportTypeId,
			_id_esf_raduno);
	}

	@Override
	public void setPrimaryKey(VW_AzzurriPK primaryKey) {
		setEsfNationalId(primaryKey.esfNationalId);
		setUserId(primaryKey.userId);
		setEsfSportTypeId(primaryKey.esfSportTypeId);
		setId_esf_raduno(primaryKey.id_esf_raduno);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new VW_AzzurriPK(_esfNationalId, _userId, _esfSportTypeId,
			_id_esf_raduno);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((VW_AzzurriPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfNationalId", getEsfNationalId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("esfSportTypeId", getEsfSportTypeId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("invitato", getInvitato());
		attributes.put("id_esf_raduno", getId_esf_raduno());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfNationalId = (Long)attributes.get("esfNationalId");

		if (esfNationalId != null) {
			setEsfNationalId(esfNationalId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Long esfSportTypeId = (Long)attributes.get("esfSportTypeId");

		if (esfSportTypeId != null) {
			setEsfSportTypeId(esfSportTypeId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long invitato = (Long)attributes.get("invitato");

		if (invitato != null) {
			setInvitato(invitato);
		}

		Long id_esf_raduno = (Long)attributes.get("id_esf_raduno");

		if (id_esf_raduno != null) {
			setId_esf_raduno(id_esf_raduno);
		}
	}

	@Override
	public long getEsfNationalId() {
		return _esfNationalId;
	}

	@Override
	public void setEsfNationalId(long esfNationalId) {
		_esfNationalId = esfNationalId;

		if (_vw_AzzurriRemoteModel != null) {
			try {
				Class<?> clazz = _vw_AzzurriRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfNationalId", long.class);

				method.invoke(_vw_AzzurriRemoteModel, esfNationalId);
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

		if (_vw_AzzurriRemoteModel != null) {
			try {
				Class<?> clazz = _vw_AzzurriRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_vw_AzzurriRemoteModel, userId);
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

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_vw_AzzurriRemoteModel != null) {
			try {
				Class<?> clazz = _vw_AzzurriRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_vw_AzzurriRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		_startDate = startDate;

		if (_vw_AzzurriRemoteModel != null) {
			try {
				Class<?> clazz = _vw_AzzurriRemoteModel.getClass();

				Method method = clazz.getMethod("setStartDate", Date.class);

				method.invoke(_vw_AzzurriRemoteModel, startDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		_endDate = endDate;

		if (_vw_AzzurriRemoteModel != null) {
			try {
				Class<?> clazz = _vw_AzzurriRemoteModel.getClass();

				Method method = clazz.getMethod("setEndDate", Date.class);

				method.invoke(_vw_AzzurriRemoteModel, endDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfSportTypeId() {
		return _esfSportTypeId;
	}

	@Override
	public void setEsfSportTypeId(long esfSportTypeId) {
		_esfSportTypeId = esfSportTypeId;

		if (_vw_AzzurriRemoteModel != null) {
			try {
				Class<?> clazz = _vw_AzzurriRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfSportTypeId", long.class);

				method.invoke(_vw_AzzurriRemoteModel, esfSportTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_vw_AzzurriRemoteModel != null) {
			try {
				Class<?> clazz = _vw_AzzurriRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_vw_AzzurriRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_vw_AzzurriRemoteModel != null) {
			try {
				Class<?> clazz = _vw_AzzurriRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_vw_AzzurriRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getInvitato() {
		return _invitato;
	}

	@Override
	public void setInvitato(long invitato) {
		_invitato = invitato;

		if (_vw_AzzurriRemoteModel != null) {
			try {
				Class<?> clazz = _vw_AzzurriRemoteModel.getClass();

				Method method = clazz.getMethod("setInvitato", long.class);

				method.invoke(_vw_AzzurriRemoteModel, invitato);
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

		if (_vw_AzzurriRemoteModel != null) {
			try {
				Class<?> clazz = _vw_AzzurriRemoteModel.getClass();

				Method method = clazz.getMethod("setId_esf_raduno", long.class);

				method.invoke(_vw_AzzurriRemoteModel, id_esf_raduno);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getVW_AzzurriRemoteModel() {
		return _vw_AzzurriRemoteModel;
	}

	public void setVW_AzzurriRemoteModel(BaseModel<?> vw_AzzurriRemoteModel) {
		_vw_AzzurriRemoteModel = vw_AzzurriRemoteModel;
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

		Class<?> remoteModelClass = _vw_AzzurriRemoteModel.getClass();

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

		Object returnValue = method.invoke(_vw_AzzurriRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			VW_AzzurriLocalServiceUtil.addVW_Azzurri(this);
		}
		else {
			VW_AzzurriLocalServiceUtil.updateVW_Azzurri(this);
		}
	}

	@Override
	public VW_Azzurri toEscapedModel() {
		return (VW_Azzurri)ProxyUtil.newProxyInstance(VW_Azzurri.class.getClassLoader(),
			new Class[] { VW_Azzurri.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VW_AzzurriClp clone = new VW_AzzurriClp();

		clone.setEsfNationalId(getEsfNationalId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setStartDate(getStartDate());
		clone.setEndDate(getEndDate());
		clone.setEsfSportTypeId(getEsfSportTypeId());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setInvitato(getInvitato());
		clone.setId_esf_raduno(getId_esf_raduno());

		return clone;
	}

	@Override
	public int compareTo(VW_Azzurri vw_Azzurri) {
		VW_AzzurriPK primaryKey = vw_Azzurri.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VW_AzzurriClp)) {
			return false;
		}

		VW_AzzurriClp vw_Azzurri = (VW_AzzurriClp)obj;

		VW_AzzurriPK primaryKey = vw_Azzurri.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{esfNationalId=");
		sb.append(getEsfNationalId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", esfSportTypeId=");
		sb.append(getEsfSportTypeId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", invitato=");
		sb.append(getInvitato());
		sb.append(", id_esf_raduno=");
		sb.append(getId_esf_raduno());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.VW_Azzurri");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfNationalId</column-name><column-value><![CDATA[");
		sb.append(getEsfNationalId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfSportTypeId</column-name><column-value><![CDATA[");
		sb.append(getEsfSportTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>invitato</column-name><column-value><![CDATA[");
		sb.append(getInvitato());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id_esf_raduno</column-name><column-value><![CDATA[");
		sb.append(getId_esf_raduno());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfNationalId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _startDate;
	private Date _endDate;
	private long _esfSportTypeId;
	private String _name;
	private String _description;
	private long _invitato;
	private long _id_esf_raduno;
	private BaseModel<?> _vw_AzzurriRemoteModel;
}