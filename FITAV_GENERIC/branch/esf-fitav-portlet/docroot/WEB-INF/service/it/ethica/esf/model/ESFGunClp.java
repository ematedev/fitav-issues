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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import it.ethica.esf.service.ClpSerializer;
import it.ethica.esf.service.ESFGunLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFGunClp extends BaseModelImpl<ESFGun> implements ESFGun {
	public ESFGunClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFGun.class;
	}

	@Override
	public String getModelClassName() {
		return ESFGun.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _esfGunId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfGunId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfGunId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfGunId", getEsfGunId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("esfUserId", getEsfUserId());
		attributes.put("code", getCode());
		attributes.put("esfGunKindId", getEsfGunKindId());
		attributes.put("esfOrganizationId", getEsfOrganizationId());
		attributes.put("registrationNumber", getRegistrationNumber());
		attributes.put("catridgeCaliber", getCatridgeCaliber());
		attributes.put("isFavoriteGun", getIsFavoriteGun());
		attributes.put("typeId", getTypeId());
		attributes.put("measures", getMeasures());
		attributes.put("note", getNote());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfGunId = (Long)attributes.get("esfGunId");

		if (esfGunId != null) {
			setEsfGunId(esfGunId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long esfUserId = (Long)attributes.get("esfUserId");

		if (esfUserId != null) {
			setEsfUserId(esfUserId);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		Long esfGunKindId = (Long)attributes.get("esfGunKindId");

		if (esfGunKindId != null) {
			setEsfGunKindId(esfGunKindId);
		}

		Long esfOrganizationId = (Long)attributes.get("esfOrganizationId");

		if (esfOrganizationId != null) {
			setEsfOrganizationId(esfOrganizationId);
		}

		String registrationNumber = (String)attributes.get("registrationNumber");

		if (registrationNumber != null) {
			setRegistrationNumber(registrationNumber);
		}

		Long catridgeCaliber = (Long)attributes.get("catridgeCaliber");

		if (catridgeCaliber != null) {
			setCatridgeCaliber(catridgeCaliber);
		}

		Boolean isFavoriteGun = (Boolean)attributes.get("isFavoriteGun");

		if (isFavoriteGun != null) {
			setIsFavoriteGun(isFavoriteGun);
		}

		Integer typeId = (Integer)attributes.get("typeId");

		if (typeId != null) {
			setTypeId(typeId);
		}

		String measures = (String)attributes.get("measures");

		if (measures != null) {
			setMeasures(measures);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_esfGunRemoteModel != null) {
			try {
				Class<?> clazz = _esfGunRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_esfGunRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfGunId() {
		return _esfGunId;
	}

	@Override
	public void setEsfGunId(long esfGunId) {
		_esfGunId = esfGunId;

		if (_esfGunRemoteModel != null) {
			try {
				Class<?> clazz = _esfGunRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfGunId", long.class);

				method.invoke(_esfGunRemoteModel, esfGunId);
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

		if (_esfGunRemoteModel != null) {
			try {
				Class<?> clazz = _esfGunRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_esfGunRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_esfGunRemoteModel != null) {
			try {
				Class<?> clazz = _esfGunRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_esfGunRemoteModel, companyId);
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

		if (_esfGunRemoteModel != null) {
			try {
				Class<?> clazz = _esfGunRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_esfGunRemoteModel, userId);
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

		if (_esfGunRemoteModel != null) {
			try {
				Class<?> clazz = _esfGunRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_esfGunRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_esfGunRemoteModel != null) {
			try {
				Class<?> clazz = _esfGunRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_esfGunRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_esfGunRemoteModel != null) {
			try {
				Class<?> clazz = _esfGunRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_esfGunRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfUserId() {
		return _esfUserId;
	}

	@Override
	public void setEsfUserId(long esfUserId) {
		_esfUserId = esfUserId;

		if (_esfGunRemoteModel != null) {
			try {
				Class<?> clazz = _esfGunRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfUserId", long.class);

				method.invoke(_esfGunRemoteModel, esfUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEsfUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getEsfUserId(), "uuid", _esfUserUuid);
	}

	@Override
	public void setEsfUserUuid(String esfUserUuid) {
		_esfUserUuid = esfUserUuid;
	}

	@Override
	public String getCode() {
		return _code;
	}

	@Override
	public void setCode(String code) {
		_code = code;

		if (_esfGunRemoteModel != null) {
			try {
				Class<?> clazz = _esfGunRemoteModel.getClass();

				Method method = clazz.getMethod("setCode", String.class);

				method.invoke(_esfGunRemoteModel, code);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfGunKindId() {
		return _esfGunKindId;
	}

	@Override
	public void setEsfGunKindId(long esfGunKindId) {
		_esfGunKindId = esfGunKindId;

		if (_esfGunRemoteModel != null) {
			try {
				Class<?> clazz = _esfGunRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfGunKindId", long.class);

				method.invoke(_esfGunRemoteModel, esfGunKindId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfOrganizationId() {
		return _esfOrganizationId;
	}

	@Override
	public void setEsfOrganizationId(long esfOrganizationId) {
		_esfOrganizationId = esfOrganizationId;

		if (_esfGunRemoteModel != null) {
			try {
				Class<?> clazz = _esfGunRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfOrganizationId",
						long.class);

				method.invoke(_esfGunRemoteModel, esfOrganizationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRegistrationNumber() {
		return _registrationNumber;
	}

	@Override
	public void setRegistrationNumber(String registrationNumber) {
		_registrationNumber = registrationNumber;

		if (_esfGunRemoteModel != null) {
			try {
				Class<?> clazz = _esfGunRemoteModel.getClass();

				Method method = clazz.getMethod("setRegistrationNumber",
						String.class);

				method.invoke(_esfGunRemoteModel, registrationNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCatridgeCaliber() {
		return _catridgeCaliber;
	}

	@Override
	public void setCatridgeCaliber(long catridgeCaliber) {
		_catridgeCaliber = catridgeCaliber;

		if (_esfGunRemoteModel != null) {
			try {
				Class<?> clazz = _esfGunRemoteModel.getClass();

				Method method = clazz.getMethod("setCatridgeCaliber", long.class);

				method.invoke(_esfGunRemoteModel, catridgeCaliber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsFavoriteGun() {
		return _isFavoriteGun;
	}

	@Override
	public boolean isIsFavoriteGun() {
		return _isFavoriteGun;
	}

	@Override
	public void setIsFavoriteGun(boolean isFavoriteGun) {
		_isFavoriteGun = isFavoriteGun;

		if (_esfGunRemoteModel != null) {
			try {
				Class<?> clazz = _esfGunRemoteModel.getClass();

				Method method = clazz.getMethod("setIsFavoriteGun",
						boolean.class);

				method.invoke(_esfGunRemoteModel, isFavoriteGun);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getTypeId() {
		return _typeId;
	}

	@Override
	public void setTypeId(int typeId) {
		_typeId = typeId;

		if (_esfGunRemoteModel != null) {
			try {
				Class<?> clazz = _esfGunRemoteModel.getClass();

				Method method = clazz.getMethod("setTypeId", int.class);

				method.invoke(_esfGunRemoteModel, typeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMeasures() {
		return _measures;
	}

	@Override
	public void setMeasures(String measures) {
		_measures = measures;

		if (_esfGunRemoteModel != null) {
			try {
				Class<?> clazz = _esfGunRemoteModel.getClass();

				Method method = clazz.getMethod("setMeasures", String.class);

				method.invoke(_esfGunRemoteModel, measures);
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

		if (_esfGunRemoteModel != null) {
			try {
				Class<?> clazz = _esfGunRemoteModel.getClass();

				Method method = clazz.getMethod("setNote", String.class);

				method.invoke(_esfGunRemoteModel, note);
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

		if (_esfGunRemoteModel != null) {
			try {
				Class<?> clazz = _esfGunRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_esfGunRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public java.lang.String getFullName() {
		try {
			String methodName = "getFullName";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				ESFGun.class.getName()));
	}

	public BaseModel<?> getESFGunRemoteModel() {
		return _esfGunRemoteModel;
	}

	public void setESFGunRemoteModel(BaseModel<?> esfGunRemoteModel) {
		_esfGunRemoteModel = esfGunRemoteModel;
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

		Class<?> remoteModelClass = _esfGunRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfGunRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFGunLocalServiceUtil.addESFGun(this);
		}
		else {
			ESFGunLocalServiceUtil.updateESFGun(this);
		}
	}

	@Override
	public ESFGun toEscapedModel() {
		return (ESFGun)ProxyUtil.newProxyInstance(ESFGun.class.getClassLoader(),
			new Class[] { ESFGun.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFGunClp clone = new ESFGunClp();

		clone.setUuid(getUuid());
		clone.setEsfGunId(getEsfGunId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setEsfUserId(getEsfUserId());
		clone.setCode(getCode());
		clone.setEsfGunKindId(getEsfGunKindId());
		clone.setEsfOrganizationId(getEsfOrganizationId());
		clone.setRegistrationNumber(getRegistrationNumber());
		clone.setCatridgeCaliber(getCatridgeCaliber());
		clone.setIsFavoriteGun(getIsFavoriteGun());
		clone.setTypeId(getTypeId());
		clone.setMeasures(getMeasures());
		clone.setNote(getNote());
		clone.setName(getName());

		return clone;
	}

	@Override
	public int compareTo(ESFGun esfGun) {
		int value = 0;

		value = getName().compareTo(esfGun.getName());

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

		if (!(obj instanceof ESFGunClp)) {
			return false;
		}

		ESFGunClp esfGun = (ESFGunClp)obj;

		long primaryKey = esfGun.getPrimaryKey();

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
		StringBundler sb = new StringBundler(39);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", esfGunId=");
		sb.append(getEsfGunId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", esfUserId=");
		sb.append(getEsfUserId());
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", esfGunKindId=");
		sb.append(getEsfGunKindId());
		sb.append(", esfOrganizationId=");
		sb.append(getEsfOrganizationId());
		sb.append(", registrationNumber=");
		sb.append(getRegistrationNumber());
		sb.append(", catridgeCaliber=");
		sb.append(getCatridgeCaliber());
		sb.append(", isFavoriteGun=");
		sb.append(getIsFavoriteGun());
		sb.append(", typeId=");
		sb.append(getTypeId());
		sb.append(", measures=");
		sb.append(getMeasures());
		sb.append(", note=");
		sb.append(getNote());
		sb.append(", name=");
		sb.append(getName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFGun");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfGunId</column-name><column-value><![CDATA[");
		sb.append(getEsfGunId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
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
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfUserId</column-name><column-value><![CDATA[");
		sb.append(getEsfUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>code</column-name><column-value><![CDATA[");
		sb.append(getCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfGunKindId</column-name><column-value><![CDATA[");
		sb.append(getEsfGunKindId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfOrganizationId</column-name><column-value><![CDATA[");
		sb.append(getEsfOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>registrationNumber</column-name><column-value><![CDATA[");
		sb.append(getRegistrationNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>catridgeCaliber</column-name><column-value><![CDATA[");
		sb.append(getCatridgeCaliber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isFavoriteGun</column-name><column-value><![CDATA[");
		sb.append(getIsFavoriteGun());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typeId</column-name><column-value><![CDATA[");
		sb.append(getTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>measures</column-name><column-value><![CDATA[");
		sb.append(getMeasures());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>note</column-name><column-value><![CDATA[");
		sb.append(getNote());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _esfGunId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _esfUserId;
	private String _esfUserUuid;
	private String _code;
	private long _esfGunKindId;
	private long _esfOrganizationId;
	private String _registrationNumber;
	private long _catridgeCaliber;
	private boolean _isFavoriteGun;
	private int _typeId;
	private String _measures;
	private String _note;
	private String _name;
	private BaseModel<?> _esfGunRemoteModel;
	private Class<?> _clpSerializerClass = it.ethica.esf.service.ClpSerializer.class;
}