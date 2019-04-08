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
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import it.ethica.esf.service.ClpSerializer;
import it.ethica.esf.service.ESFFieldLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFFieldClp extends BaseModelImpl<ESFField> implements ESFField {
	public ESFFieldClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFField.class;
	}

	@Override
	public String getModelClassName() {
		return ESFField.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _esfFieldId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfFieldId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfFieldId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfFieldId", getEsfFieldId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("ownerOrganizationId", getOwnerOrganizationId());
		attributes.put("esfAddressId", getEsfAddressId());
		attributes.put("billboard", getBillboard());
		attributes.put("billboardStations", getBillboardStations());
		attributes.put("backgroundRampart", getBackgroundRampart());
		attributes.put("backgroundNet", getBackgroundNet());
		attributes.put("backgroundLeadRecovery", getBackgroundLeadRecovery());
		attributes.put("disabledAccess", getDisabledAccess());
		attributes.put("note", getNote());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfFieldId = (Long)attributes.get("esfFieldId");

		if (esfFieldId != null) {
			setEsfFieldId(esfFieldId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long ownerOrganizationId = (Long)attributes.get("ownerOrganizationId");

		if (ownerOrganizationId != null) {
			setOwnerOrganizationId(ownerOrganizationId);
		}

		Long esfAddressId = (Long)attributes.get("esfAddressId");

		if (esfAddressId != null) {
			setEsfAddressId(esfAddressId);
		}

		Long billboard = (Long)attributes.get("billboard");

		if (billboard != null) {
			setBillboard(billboard);
		}

		Boolean billboardStations = (Boolean)attributes.get("billboardStations");

		if (billboardStations != null) {
			setBillboardStations(billboardStations);
		}

		Boolean backgroundRampart = (Boolean)attributes.get("backgroundRampart");

		if (backgroundRampart != null) {
			setBackgroundRampart(backgroundRampart);
		}

		Boolean backgroundNet = (Boolean)attributes.get("backgroundNet");

		if (backgroundNet != null) {
			setBackgroundNet(backgroundNet);
		}

		Boolean backgroundLeadRecovery = (Boolean)attributes.get(
				"backgroundLeadRecovery");

		if (backgroundLeadRecovery != null) {
			setBackgroundLeadRecovery(backgroundLeadRecovery);
		}

		Boolean disabledAccess = (Boolean)attributes.get("disabledAccess");

		if (disabledAccess != null) {
			setDisabledAccess(disabledAccess);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_esfFieldRemoteModel != null) {
			try {
				Class<?> clazz = _esfFieldRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_esfFieldRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfFieldId() {
		return _esfFieldId;
	}

	@Override
	public void setEsfFieldId(long esfFieldId) {
		_esfFieldId = esfFieldId;

		if (_esfFieldRemoteModel != null) {
			try {
				Class<?> clazz = _esfFieldRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfFieldId", long.class);

				method.invoke(_esfFieldRemoteModel, esfFieldId);
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

		if (_esfFieldRemoteModel != null) {
			try {
				Class<?> clazz = _esfFieldRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_esfFieldRemoteModel, groupId);
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

		if (_esfFieldRemoteModel != null) {
			try {
				Class<?> clazz = _esfFieldRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_esfFieldRemoteModel, companyId);
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

		if (_esfFieldRemoteModel != null) {
			try {
				Class<?> clazz = _esfFieldRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_esfFieldRemoteModel, userId);
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

		if (_esfFieldRemoteModel != null) {
			try {
				Class<?> clazz = _esfFieldRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_esfFieldRemoteModel, userName);
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

		if (_esfFieldRemoteModel != null) {
			try {
				Class<?> clazz = _esfFieldRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_esfFieldRemoteModel, createDate);
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

		if (_esfFieldRemoteModel != null) {
			try {
				Class<?> clazz = _esfFieldRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_esfFieldRemoteModel, modifiedDate);
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

		if (_esfFieldRemoteModel != null) {
			try {
				Class<?> clazz = _esfFieldRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_esfFieldRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOwnerOrganizationId() {
		return _ownerOrganizationId;
	}

	@Override
	public void setOwnerOrganizationId(long ownerOrganizationId) {
		_ownerOrganizationId = ownerOrganizationId;

		if (_esfFieldRemoteModel != null) {
			try {
				Class<?> clazz = _esfFieldRemoteModel.getClass();

				Method method = clazz.getMethod("setOwnerOrganizationId",
						long.class);

				method.invoke(_esfFieldRemoteModel, ownerOrganizationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfAddressId() {
		return _esfAddressId;
	}

	@Override
	public void setEsfAddressId(long esfAddressId) {
		_esfAddressId = esfAddressId;

		if (_esfFieldRemoteModel != null) {
			try {
				Class<?> clazz = _esfFieldRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfAddressId", long.class);

				method.invoke(_esfFieldRemoteModel, esfAddressId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getBillboard() {
		return _billboard;
	}

	@Override
	public void setBillboard(long billboard) {
		_billboard = billboard;

		if (_esfFieldRemoteModel != null) {
			try {
				Class<?> clazz = _esfFieldRemoteModel.getClass();

				Method method = clazz.getMethod("setBillboard", long.class);

				method.invoke(_esfFieldRemoteModel, billboard);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getBillboardStations() {
		return _billboardStations;
	}

	@Override
	public boolean isBillboardStations() {
		return _billboardStations;
	}

	@Override
	public void setBillboardStations(boolean billboardStations) {
		_billboardStations = billboardStations;

		if (_esfFieldRemoteModel != null) {
			try {
				Class<?> clazz = _esfFieldRemoteModel.getClass();

				Method method = clazz.getMethod("setBillboardStations",
						boolean.class);

				method.invoke(_esfFieldRemoteModel, billboardStations);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getBackgroundRampart() {
		return _backgroundRampart;
	}

	@Override
	public boolean isBackgroundRampart() {
		return _backgroundRampart;
	}

	@Override
	public void setBackgroundRampart(boolean backgroundRampart) {
		_backgroundRampart = backgroundRampart;

		if (_esfFieldRemoteModel != null) {
			try {
				Class<?> clazz = _esfFieldRemoteModel.getClass();

				Method method = clazz.getMethod("setBackgroundRampart",
						boolean.class);

				method.invoke(_esfFieldRemoteModel, backgroundRampart);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getBackgroundNet() {
		return _backgroundNet;
	}

	@Override
	public boolean isBackgroundNet() {
		return _backgroundNet;
	}

	@Override
	public void setBackgroundNet(boolean backgroundNet) {
		_backgroundNet = backgroundNet;

		if (_esfFieldRemoteModel != null) {
			try {
				Class<?> clazz = _esfFieldRemoteModel.getClass();

				Method method = clazz.getMethod("setBackgroundNet",
						boolean.class);

				method.invoke(_esfFieldRemoteModel, backgroundNet);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getBackgroundLeadRecovery() {
		return _backgroundLeadRecovery;
	}

	@Override
	public boolean isBackgroundLeadRecovery() {
		return _backgroundLeadRecovery;
	}

	@Override
	public void setBackgroundLeadRecovery(boolean backgroundLeadRecovery) {
		_backgroundLeadRecovery = backgroundLeadRecovery;

		if (_esfFieldRemoteModel != null) {
			try {
				Class<?> clazz = _esfFieldRemoteModel.getClass();

				Method method = clazz.getMethod("setBackgroundLeadRecovery",
						boolean.class);

				method.invoke(_esfFieldRemoteModel, backgroundLeadRecovery);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getDisabledAccess() {
		return _disabledAccess;
	}

	@Override
	public boolean isDisabledAccess() {
		return _disabledAccess;
	}

	@Override
	public void setDisabledAccess(boolean disabledAccess) {
		_disabledAccess = disabledAccess;

		if (_esfFieldRemoteModel != null) {
			try {
				Class<?> clazz = _esfFieldRemoteModel.getClass();

				Method method = clazz.getMethod("setDisabledAccess",
						boolean.class);

				method.invoke(_esfFieldRemoteModel, disabledAccess);
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

		if (_esfFieldRemoteModel != null) {
			try {
				Class<?> clazz = _esfFieldRemoteModel.getClass();

				Method method = clazz.getMethod("setNote", String.class);

				method.invoke(_esfFieldRemoteModel, note);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				ESFField.class.getName()));
	}

	public BaseModel<?> getESFFieldRemoteModel() {
		return _esfFieldRemoteModel;
	}

	public void setESFFieldRemoteModel(BaseModel<?> esfFieldRemoteModel) {
		_esfFieldRemoteModel = esfFieldRemoteModel;
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

		Class<?> remoteModelClass = _esfFieldRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfFieldRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFFieldLocalServiceUtil.addESFField(this);
		}
		else {
			ESFFieldLocalServiceUtil.updateESFField(this);
		}
	}

	@Override
	public ESFField toEscapedModel() {
		return (ESFField)ProxyUtil.newProxyInstance(ESFField.class.getClassLoader(),
			new Class[] { ESFField.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFFieldClp clone = new ESFFieldClp();

		clone.setUuid(getUuid());
		clone.setEsfFieldId(getEsfFieldId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setName(getName());
		clone.setOwnerOrganizationId(getOwnerOrganizationId());
		clone.setEsfAddressId(getEsfAddressId());
		clone.setBillboard(getBillboard());
		clone.setBillboardStations(getBillboardStations());
		clone.setBackgroundRampart(getBackgroundRampart());
		clone.setBackgroundNet(getBackgroundNet());
		clone.setBackgroundLeadRecovery(getBackgroundLeadRecovery());
		clone.setDisabledAccess(getDisabledAccess());
		clone.setNote(getNote());

		return clone;
	}

	@Override
	public int compareTo(ESFField esfField) {
		int value = 0;

		value = getName().compareTo(esfField.getName());

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

		if (!(obj instanceof ESFFieldClp)) {
			return false;
		}

		ESFFieldClp esfField = (ESFFieldClp)obj;

		long primaryKey = esfField.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", esfFieldId=");
		sb.append(getEsfFieldId());
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
		sb.append(", name=");
		sb.append(getName());
		sb.append(", ownerOrganizationId=");
		sb.append(getOwnerOrganizationId());
		sb.append(", esfAddressId=");
		sb.append(getEsfAddressId());
		sb.append(", billboard=");
		sb.append(getBillboard());
		sb.append(", billboardStations=");
		sb.append(getBillboardStations());
		sb.append(", backgroundRampart=");
		sb.append(getBackgroundRampart());
		sb.append(", backgroundNet=");
		sb.append(getBackgroundNet());
		sb.append(", backgroundLeadRecovery=");
		sb.append(getBackgroundLeadRecovery());
		sb.append(", disabledAccess=");
		sb.append(getDisabledAccess());
		sb.append(", note=");
		sb.append(getNote());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFField");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfFieldId</column-name><column-value><![CDATA[");
		sb.append(getEsfFieldId());
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
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ownerOrganizationId</column-name><column-value><![CDATA[");
		sb.append(getOwnerOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfAddressId</column-name><column-value><![CDATA[");
		sb.append(getEsfAddressId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>billboard</column-name><column-value><![CDATA[");
		sb.append(getBillboard());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>billboardStations</column-name><column-value><![CDATA[");
		sb.append(getBillboardStations());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>backgroundRampart</column-name><column-value><![CDATA[");
		sb.append(getBackgroundRampart());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>backgroundNet</column-name><column-value><![CDATA[");
		sb.append(getBackgroundNet());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>backgroundLeadRecovery</column-name><column-value><![CDATA[");
		sb.append(getBackgroundLeadRecovery());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>disabledAccess</column-name><column-value><![CDATA[");
		sb.append(getDisabledAccess());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>note</column-name><column-value><![CDATA[");
		sb.append(getNote());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _esfFieldId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private long _ownerOrganizationId;
	private long _esfAddressId;
	private long _billboard;
	private boolean _billboardStations;
	private boolean _backgroundRampart;
	private boolean _backgroundNet;
	private boolean _backgroundLeadRecovery;
	private boolean _disabledAccess;
	private String _note;
	private BaseModel<?> _esfFieldRemoteModel;
}