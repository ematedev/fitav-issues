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
import it.ethica.esf.service.ESFAnnualFreeCardLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFAnnualFreeCardClp extends BaseModelImpl<ESFAnnualFreeCard>
	implements ESFAnnualFreeCard {
	public ESFAnnualFreeCardClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFAnnualFreeCard.class;
	}

	@Override
	public String getModelClassName() {
		return ESFAnnualFreeCard.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _annualFreeCardId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAnnualFreeCardId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _annualFreeCardId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("annualFreeCardId", getAnnualFreeCardId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("assId", getAssId());
		attributes.put("code", getCode());
		attributes.put("cardCode", getCardCode());
		attributes.put("assCode", getAssCode());
		attributes.put("assName", getAssName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long annualFreeCardId = (Long)attributes.get("annualFreeCardId");

		if (annualFreeCardId != null) {
			setAnnualFreeCardId(annualFreeCardId);
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

		Long assId = (Long)attributes.get("assId");

		if (assId != null) {
			setAssId(assId);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String cardCode = (String)attributes.get("cardCode");

		if (cardCode != null) {
			setCardCode(cardCode);
		}

		String assCode = (String)attributes.get("assCode");

		if (assCode != null) {
			setAssCode(assCode);
		}

		String assName = (String)attributes.get("assName");

		if (assName != null) {
			setAssName(assName);
		}
	}

	@Override
	public long getAnnualFreeCardId() {
		return _annualFreeCardId;
	}

	@Override
	public void setAnnualFreeCardId(long annualFreeCardId) {
		_annualFreeCardId = annualFreeCardId;

		if (_esfAnnualFreeCardRemoteModel != null) {
			try {
				Class<?> clazz = _esfAnnualFreeCardRemoteModel.getClass();

				Method method = clazz.getMethod("setAnnualFreeCardId",
						long.class);

				method.invoke(_esfAnnualFreeCardRemoteModel, annualFreeCardId);
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

		if (_esfAnnualFreeCardRemoteModel != null) {
			try {
				Class<?> clazz = _esfAnnualFreeCardRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_esfAnnualFreeCardRemoteModel, companyId);
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

		if (_esfAnnualFreeCardRemoteModel != null) {
			try {
				Class<?> clazz = _esfAnnualFreeCardRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_esfAnnualFreeCardRemoteModel, userId);
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

		if (_esfAnnualFreeCardRemoteModel != null) {
			try {
				Class<?> clazz = _esfAnnualFreeCardRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_esfAnnualFreeCardRemoteModel, userName);
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

		if (_esfAnnualFreeCardRemoteModel != null) {
			try {
				Class<?> clazz = _esfAnnualFreeCardRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_esfAnnualFreeCardRemoteModel, createDate);
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

		if (_esfAnnualFreeCardRemoteModel != null) {
			try {
				Class<?> clazz = _esfAnnualFreeCardRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_esfAnnualFreeCardRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAssId() {
		return _assId;
	}

	@Override
	public void setAssId(long assId) {
		_assId = assId;

		if (_esfAnnualFreeCardRemoteModel != null) {
			try {
				Class<?> clazz = _esfAnnualFreeCardRemoteModel.getClass();

				Method method = clazz.getMethod("setAssId", long.class);

				method.invoke(_esfAnnualFreeCardRemoteModel, assId);
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

		if (_esfAnnualFreeCardRemoteModel != null) {
			try {
				Class<?> clazz = _esfAnnualFreeCardRemoteModel.getClass();

				Method method = clazz.getMethod("setCode", String.class);

				method.invoke(_esfAnnualFreeCardRemoteModel, code);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCardCode() {
		return _cardCode;
	}

	@Override
	public void setCardCode(String cardCode) {
		_cardCode = cardCode;

		if (_esfAnnualFreeCardRemoteModel != null) {
			try {
				Class<?> clazz = _esfAnnualFreeCardRemoteModel.getClass();

				Method method = clazz.getMethod("setCardCode", String.class);

				method.invoke(_esfAnnualFreeCardRemoteModel, cardCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAssCode() {
		return _assCode;
	}

	@Override
	public void setAssCode(String assCode) {
		_assCode = assCode;

		if (_esfAnnualFreeCardRemoteModel != null) {
			try {
				Class<?> clazz = _esfAnnualFreeCardRemoteModel.getClass();

				Method method = clazz.getMethod("setAssCode", String.class);

				method.invoke(_esfAnnualFreeCardRemoteModel, assCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAssName() {
		return _assName;
	}

	@Override
	public void setAssName(String assName) {
		_assName = assName;

		if (_esfAnnualFreeCardRemoteModel != null) {
			try {
				Class<?> clazz = _esfAnnualFreeCardRemoteModel.getClass();

				Method method = clazz.getMethod("setAssName", String.class);

				method.invoke(_esfAnnualFreeCardRemoteModel, assName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFAnnualFreeCardRemoteModel() {
		return _esfAnnualFreeCardRemoteModel;
	}

	public void setESFAnnualFreeCardRemoteModel(
		BaseModel<?> esfAnnualFreeCardRemoteModel) {
		_esfAnnualFreeCardRemoteModel = esfAnnualFreeCardRemoteModel;
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

		Class<?> remoteModelClass = _esfAnnualFreeCardRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfAnnualFreeCardRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFAnnualFreeCardLocalServiceUtil.addESFAnnualFreeCard(this);
		}
		else {
			ESFAnnualFreeCardLocalServiceUtil.updateESFAnnualFreeCard(this);
		}
	}

	@Override
	public ESFAnnualFreeCard toEscapedModel() {
		return (ESFAnnualFreeCard)ProxyUtil.newProxyInstance(ESFAnnualFreeCard.class.getClassLoader(),
			new Class[] { ESFAnnualFreeCard.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFAnnualFreeCardClp clone = new ESFAnnualFreeCardClp();

		clone.setAnnualFreeCardId(getAnnualFreeCardId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setAssId(getAssId());
		clone.setCode(getCode());
		clone.setCardCode(getCardCode());
		clone.setAssCode(getAssCode());
		clone.setAssName(getAssName());

		return clone;
	}

	@Override
	public int compareTo(ESFAnnualFreeCard esfAnnualFreeCard) {
		int value = 0;

		if (getAnnualFreeCardId() < esfAnnualFreeCard.getAnnualFreeCardId()) {
			value = -1;
		}
		else if (getAnnualFreeCardId() > esfAnnualFreeCard.getAnnualFreeCardId()) {
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

		if (!(obj instanceof ESFAnnualFreeCardClp)) {
			return false;
		}

		ESFAnnualFreeCardClp esfAnnualFreeCard = (ESFAnnualFreeCardClp)obj;

		long primaryKey = esfAnnualFreeCard.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{annualFreeCardId=");
		sb.append(getAnnualFreeCardId());
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
		sb.append(", assId=");
		sb.append(getAssId());
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", cardCode=");
		sb.append(getCardCode());
		sb.append(", assCode=");
		sb.append(getAssCode());
		sb.append(", assName=");
		sb.append(getAssName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFAnnualFreeCard");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>annualFreeCardId</column-name><column-value><![CDATA[");
		sb.append(getAnnualFreeCardId());
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
			"<column><column-name>assId</column-name><column-value><![CDATA[");
		sb.append(getAssId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>code</column-name><column-value><![CDATA[");
		sb.append(getCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cardCode</column-name><column-value><![CDATA[");
		sb.append(getCardCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>assCode</column-name><column-value><![CDATA[");
		sb.append(getAssCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>assName</column-name><column-value><![CDATA[");
		sb.append(getAssName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _annualFreeCardId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _assId;
	private String _code;
	private String _cardCode;
	private String _assCode;
	private String _assName;
	private BaseModel<?> _esfAnnualFreeCardRemoteModel;
	private Class<?> _clpSerializerClass = it.ethica.esf.service.ClpSerializer.class;
}