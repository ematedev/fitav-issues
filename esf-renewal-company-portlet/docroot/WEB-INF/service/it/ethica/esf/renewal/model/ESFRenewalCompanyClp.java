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

package it.ethica.esf.renewal.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import it.ethica.esf.renewal.service.ClpSerializer;
import it.ethica.esf.renewal.service.ESFRenewalCompanyLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFRenewalCompanyClp extends BaseModelImpl<ESFRenewalCompany>
	implements ESFRenewalCompany {
	public ESFRenewalCompanyClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFRenewalCompany.class;
	}

	@Override
	public String getModelClassName() {
		return ESFRenewalCompany.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _esfRenewalCompanyId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfRenewalCompanyId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfRenewalCompanyId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfRenewalCompanyId", getEsfRenewalCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("esfOrganizationId", getEsfOrganizationId());
		attributes.put("cardsNumber", getCardsNumber());
		attributes.put("year", getYear());
		attributes.put("date", getDate());
		attributes.put("paymentType", getPaymentType());
		attributes.put("status", getStatus());
		attributes.put("amount", getAmount());
		attributes.put("info", getInfo());
		attributes.put("accountholder", getAccountholder());
		attributes.put("paymentDate", getPaymentDate());
		attributes.put("integrationAmount", getIntegrationAmount());
		attributes.put("integrationDate", getIntegrationDate());
		attributes.put("integrationType", getIntegrationType());
		attributes.put("integrationAccountholder", getIntegrationAccountholder());
		attributes.put("join", getJoin());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfRenewalCompanyId = (Long)attributes.get("esfRenewalCompanyId");

		if (esfRenewalCompanyId != null) {
			setEsfRenewalCompanyId(esfRenewalCompanyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long esfOrganizationId = (Long)attributes.get("esfOrganizationId");

		if (esfOrganizationId != null) {
			setEsfOrganizationId(esfOrganizationId);
		}

		Integer cardsNumber = (Integer)attributes.get("cardsNumber");

		if (cardsNumber != null) {
			setCardsNumber(cardsNumber);
		}

		Integer year = (Integer)attributes.get("year");

		if (year != null) {
			setYear(year);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}

		Integer paymentType = (Integer)attributes.get("paymentType");

		if (paymentType != null) {
			setPaymentType(paymentType);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Double amount = (Double)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		String info = (String)attributes.get("info");

		if (info != null) {
			setInfo(info);
		}

		String accountholder = (String)attributes.get("accountholder");

		if (accountholder != null) {
			setAccountholder(accountholder);
		}

		Date paymentDate = (Date)attributes.get("paymentDate");

		if (paymentDate != null) {
			setPaymentDate(paymentDate);
		}

		Double integrationAmount = (Double)attributes.get("integrationAmount");

		if (integrationAmount != null) {
			setIntegrationAmount(integrationAmount);
		}

		Date integrationDate = (Date)attributes.get("integrationDate");

		if (integrationDate != null) {
			setIntegrationDate(integrationDate);
		}

		Integer integrationType = (Integer)attributes.get("integrationType");

		if (integrationType != null) {
			setIntegrationType(integrationType);
		}

		String integrationAccountholder = (String)attributes.get(
				"integrationAccountholder");

		if (integrationAccountholder != null) {
			setIntegrationAccountholder(integrationAccountholder);
		}

		Boolean join = (Boolean)attributes.get("join");

		if (join != null) {
			setJoin(join);
		}
	}

	@Override
	public long getEsfRenewalCompanyId() {
		return _esfRenewalCompanyId;
	}

	@Override
	public void setEsfRenewalCompanyId(long esfRenewalCompanyId) {
		_esfRenewalCompanyId = esfRenewalCompanyId;

		if (_esfRenewalCompanyRemoteModel != null) {
			try {
				Class<?> clazz = _esfRenewalCompanyRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfRenewalCompanyId",
						long.class);

				method.invoke(_esfRenewalCompanyRemoteModel, esfRenewalCompanyId);
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

		if (_esfRenewalCompanyRemoteModel != null) {
			try {
				Class<?> clazz = _esfRenewalCompanyRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_esfRenewalCompanyRemoteModel, userId);
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
	public long getEsfOrganizationId() {
		return _esfOrganizationId;
	}

	@Override
	public void setEsfOrganizationId(long esfOrganizationId) {
		_esfOrganizationId = esfOrganizationId;

		if (_esfRenewalCompanyRemoteModel != null) {
			try {
				Class<?> clazz = _esfRenewalCompanyRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfOrganizationId",
						long.class);

				method.invoke(_esfRenewalCompanyRemoteModel, esfOrganizationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getCardsNumber() {
		return _cardsNumber;
	}

	@Override
	public void setCardsNumber(int cardsNumber) {
		_cardsNumber = cardsNumber;

		if (_esfRenewalCompanyRemoteModel != null) {
			try {
				Class<?> clazz = _esfRenewalCompanyRemoteModel.getClass();

				Method method = clazz.getMethod("setCardsNumber", int.class);

				method.invoke(_esfRenewalCompanyRemoteModel, cardsNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getYear() {
		return _year;
	}

	@Override
	public void setYear(int year) {
		_year = year;

		if (_esfRenewalCompanyRemoteModel != null) {
			try {
				Class<?> clazz = _esfRenewalCompanyRemoteModel.getClass();

				Method method = clazz.getMethod("setYear", int.class);

				method.invoke(_esfRenewalCompanyRemoteModel, year);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDate() {
		return _date;
	}

	@Override
	public void setDate(Date date) {
		_date = date;

		if (_esfRenewalCompanyRemoteModel != null) {
			try {
				Class<?> clazz = _esfRenewalCompanyRemoteModel.getClass();

				Method method = clazz.getMethod("setDate", Date.class);

				method.invoke(_esfRenewalCompanyRemoteModel, date);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getPaymentType() {
		return _paymentType;
	}

	@Override
	public void setPaymentType(int paymentType) {
		_paymentType = paymentType;

		if (_esfRenewalCompanyRemoteModel != null) {
			try {
				Class<?> clazz = _esfRenewalCompanyRemoteModel.getClass();

				Method method = clazz.getMethod("setPaymentType", int.class);

				method.invoke(_esfRenewalCompanyRemoteModel, paymentType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;

		if (_esfRenewalCompanyRemoteModel != null) {
			try {
				Class<?> clazz = _esfRenewalCompanyRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_esfRenewalCompanyRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getAmount() {
		return _amount;
	}

	@Override
	public void setAmount(double amount) {
		_amount = amount;

		if (_esfRenewalCompanyRemoteModel != null) {
			try {
				Class<?> clazz = _esfRenewalCompanyRemoteModel.getClass();

				Method method = clazz.getMethod("setAmount", double.class);

				method.invoke(_esfRenewalCompanyRemoteModel, amount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getInfo() {
		return _info;
	}

	@Override
	public void setInfo(String info) {
		_info = info;

		if (_esfRenewalCompanyRemoteModel != null) {
			try {
				Class<?> clazz = _esfRenewalCompanyRemoteModel.getClass();

				Method method = clazz.getMethod("setInfo", String.class);

				method.invoke(_esfRenewalCompanyRemoteModel, info);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAccountholder() {
		return _accountholder;
	}

	@Override
	public void setAccountholder(String accountholder) {
		_accountholder = accountholder;

		if (_esfRenewalCompanyRemoteModel != null) {
			try {
				Class<?> clazz = _esfRenewalCompanyRemoteModel.getClass();

				Method method = clazz.getMethod("setAccountholder", String.class);

				method.invoke(_esfRenewalCompanyRemoteModel, accountholder);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getPaymentDate() {
		return _paymentDate;
	}

	@Override
	public void setPaymentDate(Date paymentDate) {
		_paymentDate = paymentDate;

		if (_esfRenewalCompanyRemoteModel != null) {
			try {
				Class<?> clazz = _esfRenewalCompanyRemoteModel.getClass();

				Method method = clazz.getMethod("setPaymentDate", Date.class);

				method.invoke(_esfRenewalCompanyRemoteModel, paymentDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getIntegrationAmount() {
		return _integrationAmount;
	}

	@Override
	public void setIntegrationAmount(double integrationAmount) {
		_integrationAmount = integrationAmount;

		if (_esfRenewalCompanyRemoteModel != null) {
			try {
				Class<?> clazz = _esfRenewalCompanyRemoteModel.getClass();

				Method method = clazz.getMethod("setIntegrationAmount",
						double.class);

				method.invoke(_esfRenewalCompanyRemoteModel, integrationAmount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getIntegrationDate() {
		return _integrationDate;
	}

	@Override
	public void setIntegrationDate(Date integrationDate) {
		_integrationDate = integrationDate;

		if (_esfRenewalCompanyRemoteModel != null) {
			try {
				Class<?> clazz = _esfRenewalCompanyRemoteModel.getClass();

				Method method = clazz.getMethod("setIntegrationDate", Date.class);

				method.invoke(_esfRenewalCompanyRemoteModel, integrationDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getIntegrationType() {
		return _integrationType;
	}

	@Override
	public void setIntegrationType(int integrationType) {
		_integrationType = integrationType;

		if (_esfRenewalCompanyRemoteModel != null) {
			try {
				Class<?> clazz = _esfRenewalCompanyRemoteModel.getClass();

				Method method = clazz.getMethod("setIntegrationType", int.class);

				method.invoke(_esfRenewalCompanyRemoteModel, integrationType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIntegrationAccountholder() {
		return _integrationAccountholder;
	}

	@Override
	public void setIntegrationAccountholder(String integrationAccountholder) {
		_integrationAccountholder = integrationAccountholder;

		if (_esfRenewalCompanyRemoteModel != null) {
			try {
				Class<?> clazz = _esfRenewalCompanyRemoteModel.getClass();

				Method method = clazz.getMethod("setIntegrationAccountholder",
						String.class);

				method.invoke(_esfRenewalCompanyRemoteModel,
					integrationAccountholder);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getJoin() {
		return _join;
	}

	@Override
	public boolean isJoin() {
		return _join;
	}

	@Override
	public void setJoin(boolean join) {
		_join = join;

		if (_esfRenewalCompanyRemoteModel != null) {
			try {
				Class<?> clazz = _esfRenewalCompanyRemoteModel.getClass();

				Method method = clazz.getMethod("setJoin", boolean.class);

				method.invoke(_esfRenewalCompanyRemoteModel, join);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFRenewalCompanyRemoteModel() {
		return _esfRenewalCompanyRemoteModel;
	}

	public void setESFRenewalCompanyRemoteModel(
		BaseModel<?> esfRenewalCompanyRemoteModel) {
		_esfRenewalCompanyRemoteModel = esfRenewalCompanyRemoteModel;
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

		Class<?> remoteModelClass = _esfRenewalCompanyRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfRenewalCompanyRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFRenewalCompanyLocalServiceUtil.addESFRenewalCompany(this);
		}
		else {
			ESFRenewalCompanyLocalServiceUtil.updateESFRenewalCompany(this);
		}
	}

	@Override
	public ESFRenewalCompany toEscapedModel() {
		return (ESFRenewalCompany)ProxyUtil.newProxyInstance(ESFRenewalCompany.class.getClassLoader(),
			new Class[] { ESFRenewalCompany.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFRenewalCompanyClp clone = new ESFRenewalCompanyClp();

		clone.setEsfRenewalCompanyId(getEsfRenewalCompanyId());
		clone.setUserId(getUserId());
		clone.setEsfOrganizationId(getEsfOrganizationId());
		clone.setCardsNumber(getCardsNumber());
		clone.setYear(getYear());
		clone.setDate(getDate());
		clone.setPaymentType(getPaymentType());
		clone.setStatus(getStatus());
		clone.setAmount(getAmount());
		clone.setInfo(getInfo());
		clone.setAccountholder(getAccountholder());
		clone.setPaymentDate(getPaymentDate());
		clone.setIntegrationAmount(getIntegrationAmount());
		clone.setIntegrationDate(getIntegrationDate());
		clone.setIntegrationType(getIntegrationType());
		clone.setIntegrationAccountholder(getIntegrationAccountholder());
		clone.setJoin(getJoin());

		return clone;
	}

	@Override
	public int compareTo(ESFRenewalCompany esfRenewalCompany) {
		long primaryKey = esfRenewalCompany.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ESFRenewalCompanyClp)) {
			return false;
		}

		ESFRenewalCompanyClp esfRenewalCompany = (ESFRenewalCompanyClp)obj;

		long primaryKey = esfRenewalCompany.getPrimaryKey();

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

		sb.append("{esfRenewalCompanyId=");
		sb.append(getEsfRenewalCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", esfOrganizationId=");
		sb.append(getEsfOrganizationId());
		sb.append(", cardsNumber=");
		sb.append(getCardsNumber());
		sb.append(", year=");
		sb.append(getYear());
		sb.append(", date=");
		sb.append(getDate());
		sb.append(", paymentType=");
		sb.append(getPaymentType());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", amount=");
		sb.append(getAmount());
		sb.append(", info=");
		sb.append(getInfo());
		sb.append(", accountholder=");
		sb.append(getAccountholder());
		sb.append(", paymentDate=");
		sb.append(getPaymentDate());
		sb.append(", integrationAmount=");
		sb.append(getIntegrationAmount());
		sb.append(", integrationDate=");
		sb.append(getIntegrationDate());
		sb.append(", integrationType=");
		sb.append(getIntegrationType());
		sb.append(", integrationAccountholder=");
		sb.append(getIntegrationAccountholder());
		sb.append(", join=");
		sb.append(getJoin());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.renewal.model.ESFRenewalCompany");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfRenewalCompanyId</column-name><column-value><![CDATA[");
		sb.append(getEsfRenewalCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfOrganizationId</column-name><column-value><![CDATA[");
		sb.append(getEsfOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cardsNumber</column-name><column-value><![CDATA[");
		sb.append(getCardsNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>year</column-name><column-value><![CDATA[");
		sb.append(getYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>date</column-name><column-value><![CDATA[");
		sb.append(getDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paymentType</column-name><column-value><![CDATA[");
		sb.append(getPaymentType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>amount</column-name><column-value><![CDATA[");
		sb.append(getAmount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>info</column-name><column-value><![CDATA[");
		sb.append(getInfo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accountholder</column-name><column-value><![CDATA[");
		sb.append(getAccountholder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paymentDate</column-name><column-value><![CDATA[");
		sb.append(getPaymentDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>integrationAmount</column-name><column-value><![CDATA[");
		sb.append(getIntegrationAmount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>integrationDate</column-name><column-value><![CDATA[");
		sb.append(getIntegrationDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>integrationType</column-name><column-value><![CDATA[");
		sb.append(getIntegrationType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>integrationAccountholder</column-name><column-value><![CDATA[");
		sb.append(getIntegrationAccountholder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>join</column-name><column-value><![CDATA[");
		sb.append(getJoin());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfRenewalCompanyId;
	private long _userId;
	private String _userUuid;
	private long _esfOrganizationId;
	private int _cardsNumber;
	private int _year;
	private Date _date;
	private int _paymentType;
	private int _status;
	private double _amount;
	private String _info;
	private String _accountholder;
	private Date _paymentDate;
	private double _integrationAmount;
	private Date _integrationDate;
	private int _integrationType;
	private String _integrationAccountholder;
	private boolean _join;
	private BaseModel<?> _esfRenewalCompanyRemoteModel;
}