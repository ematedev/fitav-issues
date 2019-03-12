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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import it.ethica.esf.service.ClpSerializer;
import it.ethica.esf.service.ESFDocumentLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFDocumentClp extends BaseModelImpl<ESFDocument>
	implements ESFDocument {
	public ESFDocumentClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFDocument.class;
	}

	@Override
	public String getModelClassName() {
		return ESFDocument.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _esfDocumentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfDocumentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfDocumentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("esfDocumentId", getEsfDocumentId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("ownerId", getOwnerId());
		attributes.put("ownerType", getOwnerType());
		attributes.put("name", getName());
		attributes.put("number", getNumber());
		attributes.put("releaseDate", getReleaseDate());
		attributes.put("expireDate", getExpireDate());
		attributes.put("issuer", getIssuer());
		attributes.put("contents", getContents());
		attributes.put("locationReference", getLocationReference());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long esfDocumentId = (Long)attributes.get("esfDocumentId");

		if (esfDocumentId != null) {
			setEsfDocumentId(esfDocumentId);
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

		Long ownerId = (Long)attributes.get("ownerId");

		if (ownerId != null) {
			setOwnerId(ownerId);
		}

		String ownerType = (String)attributes.get("ownerType");

		if (ownerType != null) {
			setOwnerType(ownerType);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long number = (Long)attributes.get("number");

		if (number != null) {
			setNumber(number);
		}

		Date releaseDate = (Date)attributes.get("releaseDate");

		if (releaseDate != null) {
			setReleaseDate(releaseDate);
		}

		Date expireDate = (Date)attributes.get("expireDate");

		if (expireDate != null) {
			setExpireDate(expireDate);
		}

		String issuer = (String)attributes.get("issuer");

		if (issuer != null) {
			setIssuer(issuer);
		}

		String contents = (String)attributes.get("contents");

		if (contents != null) {
			setContents(contents);
		}

		String locationReference = (String)attributes.get("locationReference");

		if (locationReference != null) {
			setLocationReference(locationReference);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_esfDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _esfDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_esfDocumentRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfDocumentId() {
		return _esfDocumentId;
	}

	@Override
	public void setEsfDocumentId(long esfDocumentId) {
		_esfDocumentId = esfDocumentId;

		if (_esfDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _esfDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfDocumentId", long.class);

				method.invoke(_esfDocumentRemoteModel, esfDocumentId);
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

		if (_esfDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _esfDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_esfDocumentRemoteModel, groupId);
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

		if (_esfDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _esfDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_esfDocumentRemoteModel, companyId);
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

		if (_esfDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _esfDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_esfDocumentRemoteModel, userId);
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

		if (_esfDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _esfDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_esfDocumentRemoteModel, userName);
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

		if (_esfDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _esfDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_esfDocumentRemoteModel, createDate);
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

		if (_esfDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _esfDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_esfDocumentRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOwnerId() {
		return _ownerId;
	}

	@Override
	public void setOwnerId(long ownerId) {
		_ownerId = ownerId;

		if (_esfDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _esfDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setOwnerId", long.class);

				method.invoke(_esfDocumentRemoteModel, ownerId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOwnerType() {
		return _ownerType;
	}

	@Override
	public void setOwnerType(String ownerType) {
		_ownerType = ownerType;

		if (_esfDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _esfDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setOwnerType", String.class);

				method.invoke(_esfDocumentRemoteModel, ownerType);
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

		if (_esfDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _esfDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_esfDocumentRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNumber() {
		return _number;
	}

	@Override
	public void setNumber(long number) {
		_number = number;

		if (_esfDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _esfDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setNumber", long.class);

				method.invoke(_esfDocumentRemoteModel, number);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getReleaseDate() {
		return _releaseDate;
	}

	@Override
	public void setReleaseDate(Date releaseDate) {
		_releaseDate = releaseDate;

		if (_esfDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _esfDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setReleaseDate", Date.class);

				method.invoke(_esfDocumentRemoteModel, releaseDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getExpireDate() {
		return _expireDate;
	}

	@Override
	public void setExpireDate(Date expireDate) {
		_expireDate = expireDate;

		if (_esfDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _esfDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setExpireDate", Date.class);

				method.invoke(_esfDocumentRemoteModel, expireDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIssuer() {
		return _issuer;
	}

	@Override
	public void setIssuer(String issuer) {
		_issuer = issuer;

		if (_esfDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _esfDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setIssuer", String.class);

				method.invoke(_esfDocumentRemoteModel, issuer);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContents() {
		return _contents;
	}

	@Override
	public void setContents(String contents) {
		_contents = contents;

		if (_esfDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _esfDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setContents", String.class);

				method.invoke(_esfDocumentRemoteModel, contents);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLocationReference() {
		return _locationReference;
	}

	@Override
	public void setLocationReference(String locationReference) {
		_locationReference = locationReference;

		if (_esfDocumentRemoteModel != null) {
			try {
				Class<?> clazz = _esfDocumentRemoteModel.getClass();

				Method method = clazz.getMethod("setLocationReference",
						String.class);

				method.invoke(_esfDocumentRemoteModel, locationReference);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				ESFDocument.class.getName()));
	}

	public BaseModel<?> getESFDocumentRemoteModel() {
		return _esfDocumentRemoteModel;
	}

	public void setESFDocumentRemoteModel(BaseModel<?> esfDocumentRemoteModel) {
		_esfDocumentRemoteModel = esfDocumentRemoteModel;
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

		Class<?> remoteModelClass = _esfDocumentRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfDocumentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFDocumentLocalServiceUtil.addESFDocument(this);
		}
		else {
			ESFDocumentLocalServiceUtil.updateESFDocument(this);
		}
	}

	@Override
	public ESFDocument toEscapedModel() {
		return (ESFDocument)ProxyUtil.newProxyInstance(ESFDocument.class.getClassLoader(),
			new Class[] { ESFDocument.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFDocumentClp clone = new ESFDocumentClp();

		clone.setUuid(getUuid());
		clone.setEsfDocumentId(getEsfDocumentId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setOwnerId(getOwnerId());
		clone.setOwnerType(getOwnerType());
		clone.setName(getName());
		clone.setNumber(getNumber());
		clone.setReleaseDate(getReleaseDate());
		clone.setExpireDate(getExpireDate());
		clone.setIssuer(getIssuer());
		clone.setContents(getContents());
		clone.setLocationReference(getLocationReference());

		return clone;
	}

	@Override
	public int compareTo(ESFDocument esfDocument) {
		int value = 0;

		value = DateUtil.compareTo(getReleaseDate(),
				esfDocument.getReleaseDate());

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

		if (!(obj instanceof ESFDocumentClp)) {
			return false;
		}

		ESFDocumentClp esfDocument = (ESFDocumentClp)obj;

		long primaryKey = esfDocument.getPrimaryKey();

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
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", esfDocumentId=");
		sb.append(getEsfDocumentId());
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
		sb.append(", ownerId=");
		sb.append(getOwnerId());
		sb.append(", ownerType=");
		sb.append(getOwnerType());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", number=");
		sb.append(getNumber());
		sb.append(", releaseDate=");
		sb.append(getReleaseDate());
		sb.append(", expireDate=");
		sb.append(getExpireDate());
		sb.append(", issuer=");
		sb.append(getIssuer());
		sb.append(", contents=");
		sb.append(getContents());
		sb.append(", locationReference=");
		sb.append(getLocationReference());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFDocument");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfDocumentId</column-name><column-value><![CDATA[");
		sb.append(getEsfDocumentId());
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
			"<column><column-name>ownerId</column-name><column-value><![CDATA[");
		sb.append(getOwnerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ownerType</column-name><column-value><![CDATA[");
		sb.append(getOwnerType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>number</column-name><column-value><![CDATA[");
		sb.append(getNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>releaseDate</column-name><column-value><![CDATA[");
		sb.append(getReleaseDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expireDate</column-name><column-value><![CDATA[");
		sb.append(getExpireDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>issuer</column-name><column-value><![CDATA[");
		sb.append(getIssuer());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contents</column-name><column-value><![CDATA[");
		sb.append(getContents());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>locationReference</column-name><column-value><![CDATA[");
		sb.append(getLocationReference());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _esfDocumentId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _ownerId;
	private String _ownerType;
	private String _name;
	private long _number;
	private Date _releaseDate;
	private Date _expireDate;
	private String _issuer;
	private String _contents;
	private String _locationReference;
	private BaseModel<?> _esfDocumentRemoteModel;
}