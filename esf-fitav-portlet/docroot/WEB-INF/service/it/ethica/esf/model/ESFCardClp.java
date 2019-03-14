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
import it.ethica.esf.service.ESFCardLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFCardClp extends BaseModelImpl<ESFCard> implements ESFCard {
	public ESFCardClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFCard.class;
	}

	@Override
	public String getModelClassName() {
		return ESFCard.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _esfCardId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfCardId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfCardId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfCardId", getEsfCardId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("codeAlfa", getCodeAlfa());
		attributes.put("codeNum", getCodeNum());
		attributes.put("esfUserId", getEsfUserId());
		attributes.put("esfOrganizationId", getEsfOrganizationId());
		attributes.put("code", getCode());
		attributes.put("oldCode", getOldCode());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfCardId = (Long)attributes.get("esfCardId");

		if (esfCardId != null) {
			setEsfCardId(esfCardId);
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

		String codeAlfa = (String)attributes.get("codeAlfa");

		if (codeAlfa != null) {
			setCodeAlfa(codeAlfa);
		}

		Long codeNum = (Long)attributes.get("codeNum");

		if (codeNum != null) {
			setCodeNum(codeNum);
		}

		Long esfUserId = (Long)attributes.get("esfUserId");

		if (esfUserId != null) {
			setEsfUserId(esfUserId);
		}

		Long esfOrganizationId = (Long)attributes.get("esfOrganizationId");

		if (esfOrganizationId != null) {
			setEsfOrganizationId(esfOrganizationId);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String oldCode = (String)attributes.get("oldCode");

		if (oldCode != null) {
			setOldCode(oldCode);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_esfCardRemoteModel != null) {
			try {
				Class<?> clazz = _esfCardRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_esfCardRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfCardId() {
		return _esfCardId;
	}

	@Override
	public void setEsfCardId(long esfCardId) {
		_esfCardId = esfCardId;

		if (_esfCardRemoteModel != null) {
			try {
				Class<?> clazz = _esfCardRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfCardId", long.class);

				method.invoke(_esfCardRemoteModel, esfCardId);
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

		if (_esfCardRemoteModel != null) {
			try {
				Class<?> clazz = _esfCardRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_esfCardRemoteModel, groupId);
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

		if (_esfCardRemoteModel != null) {
			try {
				Class<?> clazz = _esfCardRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_esfCardRemoteModel, companyId);
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

		if (_esfCardRemoteModel != null) {
			try {
				Class<?> clazz = _esfCardRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_esfCardRemoteModel, userId);
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

		if (_esfCardRemoteModel != null) {
			try {
				Class<?> clazz = _esfCardRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_esfCardRemoteModel, userName);
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

		if (_esfCardRemoteModel != null) {
			try {
				Class<?> clazz = _esfCardRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_esfCardRemoteModel, createDate);
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

		if (_esfCardRemoteModel != null) {
			try {
				Class<?> clazz = _esfCardRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_esfCardRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCodeAlfa() {
		return _codeAlfa;
	}

	@Override
	public void setCodeAlfa(String codeAlfa) {
		_codeAlfa = codeAlfa;

		if (_esfCardRemoteModel != null) {
			try {
				Class<?> clazz = _esfCardRemoteModel.getClass();

				Method method = clazz.getMethod("setCodeAlfa", String.class);

				method.invoke(_esfCardRemoteModel, codeAlfa);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCodeNum() {
		return _codeNum;
	}

	@Override
	public void setCodeNum(long codeNum) {
		_codeNum = codeNum;

		if (_esfCardRemoteModel != null) {
			try {
				Class<?> clazz = _esfCardRemoteModel.getClass();

				Method method = clazz.getMethod("setCodeNum", long.class);

				method.invoke(_esfCardRemoteModel, codeNum);
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

		if (_esfCardRemoteModel != null) {
			try {
				Class<?> clazz = _esfCardRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfUserId", long.class);

				method.invoke(_esfCardRemoteModel, esfUserId);
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
	public long getEsfOrganizationId() {
		return _esfOrganizationId;
	}

	@Override
	public void setEsfOrganizationId(long esfOrganizationId) {
		_esfOrganizationId = esfOrganizationId;

		if (_esfCardRemoteModel != null) {
			try {
				Class<?> clazz = _esfCardRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfOrganizationId",
						long.class);

				method.invoke(_esfCardRemoteModel, esfOrganizationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCode() {
		return _code;
	}

	@Override
	public void setCode(String code) {
		_code = code;

		if (_esfCardRemoteModel != null) {
			try {
				Class<?> clazz = _esfCardRemoteModel.getClass();

				Method method = clazz.getMethod("setCode", String.class);

				method.invoke(_esfCardRemoteModel, code);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOldCode() {
		return _oldCode;
	}

	@Override
	public void setOldCode(String oldCode) {
		_oldCode = oldCode;

		if (_esfCardRemoteModel != null) {
			try {
				Class<?> clazz = _esfCardRemoteModel.getClass();

				Method method = clazz.getMethod("setOldCode", String.class);

				method.invoke(_esfCardRemoteModel, oldCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				ESFCard.class.getName()));
	}

	public BaseModel<?> getESFCardRemoteModel() {
		return _esfCardRemoteModel;
	}

	public void setESFCardRemoteModel(BaseModel<?> esfCardRemoteModel) {
		_esfCardRemoteModel = esfCardRemoteModel;
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

		Class<?> remoteModelClass = _esfCardRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfCardRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFCardLocalServiceUtil.addESFCard(this);
		}
		else {
			ESFCardLocalServiceUtil.updateESFCard(this);
		}
	}

	@Override
	public ESFCard toEscapedModel() {
		return (ESFCard)ProxyUtil.newProxyInstance(ESFCard.class.getClassLoader(),
			new Class[] { ESFCard.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFCardClp clone = new ESFCardClp();

		clone.setUuid(getUuid());
		clone.setEsfCardId(getEsfCardId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCodeAlfa(getCodeAlfa());
		clone.setCodeNum(getCodeNum());
		clone.setEsfUserId(getEsfUserId());
		clone.setEsfOrganizationId(getEsfOrganizationId());
		clone.setCode(getCode());
		clone.setOldCode(getOldCode());

		return clone;
	}

	@Override
	public int compareTo(ESFCard esfCard) {
		int value = 0;

		if (getCodeNum() < esfCard.getCodeNum()) {
			value = -1;
		}
		else if (getCodeNum() > esfCard.getCodeNum()) {
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

		if (!(obj instanceof ESFCardClp)) {
			return false;
		}

		ESFCardClp esfCard = (ESFCardClp)obj;

		long primaryKey = esfCard.getPrimaryKey();

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
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", esfCardId=");
		sb.append(getEsfCardId());
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
		sb.append(", codeAlfa=");
		sb.append(getCodeAlfa());
		sb.append(", codeNum=");
		sb.append(getCodeNum());
		sb.append(", esfUserId=");
		sb.append(getEsfUserId());
		sb.append(", esfOrganizationId=");
		sb.append(getEsfOrganizationId());
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", oldCode=");
		sb.append(getOldCode());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFCard");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfCardId</column-name><column-value><![CDATA[");
		sb.append(getEsfCardId());
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
			"<column><column-name>codeAlfa</column-name><column-value><![CDATA[");
		sb.append(getCodeAlfa());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codeNum</column-name><column-value><![CDATA[");
		sb.append(getCodeNum());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfUserId</column-name><column-value><![CDATA[");
		sb.append(getEsfUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfOrganizationId</column-name><column-value><![CDATA[");
		sb.append(getEsfOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>code</column-name><column-value><![CDATA[");
		sb.append(getCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>oldCode</column-name><column-value><![CDATA[");
		sb.append(getOldCode());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _esfCardId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _codeAlfa;
	private long _codeNum;
	private long _esfUserId;
	private String _esfUserUuid;
	private long _esfOrganizationId;
	private String _code;
	private String _oldCode;
	private BaseModel<?> _esfCardRemoteModel;
}