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
import it.ethica.esf.service.ESFFornitureRelLocalServiceUtil;
import it.ethica.esf.service.persistence.ESFFornitureRelPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFFornitureRelClp extends BaseModelImpl<ESFFornitureRel>
	implements ESFFornitureRel {
	public ESFFornitureRelClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFFornitureRel.class;
	}

	@Override
	public String getModelClassName() {
		return ESFFornitureRel.class.getName();
	}

	@Override
	public ESFFornitureRelPK getPrimaryKey() {
		return new ESFFornitureRelPK(_esfToolId, _className, _classPK);
	}

	@Override
	public void setPrimaryKey(ESFFornitureRelPK primaryKey) {
		setEsfToolId(primaryKey.esfToolId);
		setClassName(primaryKey.className);
		setClassPK(primaryKey.classPK);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ESFFornitureRelPK(_esfToolId, _className, _classPK);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ESFFornitureRelPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfToolId", getEsfToolId());
		attributes.put("className", getClassName());
		attributes.put("classPK", getClassPK());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("assignmentDate", getAssignmentDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfToolId = (Long)attributes.get("esfToolId");

		if (esfToolId != null) {
			setEsfToolId(esfToolId);
		}

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
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

		Date assignmentDate = (Date)attributes.get("assignmentDate");

		if (assignmentDate != null) {
			setAssignmentDate(assignmentDate);
		}
	}

	@Override
	public long getEsfToolId() {
		return _esfToolId;
	}

	@Override
	public void setEsfToolId(long esfToolId) {
		_esfToolId = esfToolId;

		if (_esfFornitureRelRemoteModel != null) {
			try {
				Class<?> clazz = _esfFornitureRelRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfToolId", long.class);

				method.invoke(_esfFornitureRelRemoteModel, esfToolId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getClassName() {
		return _className;
	}

	@Override
	public void setClassName(String className) {
		_className = className;

		if (_esfFornitureRelRemoteModel != null) {
			try {
				Class<?> clazz = _esfFornitureRelRemoteModel.getClass();

				Method method = clazz.getMethod("setClassName", String.class);

				method.invoke(_esfFornitureRelRemoteModel, className);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public void setClassPK(long classPK) {
		_classPK = classPK;

		if (_esfFornitureRelRemoteModel != null) {
			try {
				Class<?> clazz = _esfFornitureRelRemoteModel.getClass();

				Method method = clazz.getMethod("setClassPK", long.class);

				method.invoke(_esfFornitureRelRemoteModel, classPK);
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

		if (_esfFornitureRelRemoteModel != null) {
			try {
				Class<?> clazz = _esfFornitureRelRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_esfFornitureRelRemoteModel, groupId);
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

		if (_esfFornitureRelRemoteModel != null) {
			try {
				Class<?> clazz = _esfFornitureRelRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_esfFornitureRelRemoteModel, companyId);
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

		if (_esfFornitureRelRemoteModel != null) {
			try {
				Class<?> clazz = _esfFornitureRelRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_esfFornitureRelRemoteModel, userId);
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

		if (_esfFornitureRelRemoteModel != null) {
			try {
				Class<?> clazz = _esfFornitureRelRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_esfFornitureRelRemoteModel, userName);
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

		if (_esfFornitureRelRemoteModel != null) {
			try {
				Class<?> clazz = _esfFornitureRelRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_esfFornitureRelRemoteModel, createDate);
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

		if (_esfFornitureRelRemoteModel != null) {
			try {
				Class<?> clazz = _esfFornitureRelRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_esfFornitureRelRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getAssignmentDate() {
		return _assignmentDate;
	}

	@Override
	public void setAssignmentDate(Date assignmentDate) {
		_assignmentDate = assignmentDate;

		if (_esfFornitureRelRemoteModel != null) {
			try {
				Class<?> clazz = _esfFornitureRelRemoteModel.getClass();

				Method method = clazz.getMethod("setAssignmentDate", Date.class);

				method.invoke(_esfFornitureRelRemoteModel, assignmentDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFFornitureRelRemoteModel() {
		return _esfFornitureRelRemoteModel;
	}

	public void setESFFornitureRelRemoteModel(
		BaseModel<?> esfFornitureRelRemoteModel) {
		_esfFornitureRelRemoteModel = esfFornitureRelRemoteModel;
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

		Class<?> remoteModelClass = _esfFornitureRelRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfFornitureRelRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFFornitureRelLocalServiceUtil.addESFFornitureRel(this);
		}
		else {
			ESFFornitureRelLocalServiceUtil.updateESFFornitureRel(this);
		}
	}

	@Override
	public ESFFornitureRel toEscapedModel() {
		return (ESFFornitureRel)ProxyUtil.newProxyInstance(ESFFornitureRel.class.getClassLoader(),
			new Class[] { ESFFornitureRel.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFFornitureRelClp clone = new ESFFornitureRelClp();

		clone.setEsfToolId(getEsfToolId());
		clone.setClassName(getClassName());
		clone.setClassPK(getClassPK());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setAssignmentDate(getAssignmentDate());

		return clone;
	}

	@Override
	public int compareTo(ESFFornitureRel esfFornitureRel) {
		ESFFornitureRelPK primaryKey = esfFornitureRel.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFFornitureRelClp)) {
			return false;
		}

		ESFFornitureRelClp esfFornitureRel = (ESFFornitureRelClp)obj;

		ESFFornitureRelPK primaryKey = esfFornitureRel.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{esfToolId=");
		sb.append(getEsfToolId());
		sb.append(", className=");
		sb.append(getClassName());
		sb.append(", classPK=");
		sb.append(getClassPK());
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
		sb.append(", assignmentDate=");
		sb.append(getAssignmentDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFFornitureRel");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfToolId</column-name><column-value><![CDATA[");
		sb.append(getEsfToolId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>className</column-name><column-value><![CDATA[");
		sb.append(getClassName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classPK</column-name><column-value><![CDATA[");
		sb.append(getClassPK());
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
			"<column><column-name>assignmentDate</column-name><column-value><![CDATA[");
		sb.append(getAssignmentDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfToolId;
	private String _className;
	private long _classPK;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _assignmentDate;
	private BaseModel<?> _esfFornitureRelRemoteModel;
	private Class<?> _clpSerializerClass = it.ethica.esf.service.ClpSerializer.class;
}