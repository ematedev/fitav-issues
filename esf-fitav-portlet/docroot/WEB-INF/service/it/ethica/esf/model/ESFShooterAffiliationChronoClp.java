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

import it.ethica.esf.service.ClpSerializer;
import it.ethica.esf.service.ESFShooterAffiliationChronoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFShooterAffiliationChronoClp extends BaseModelImpl<ESFShooterAffiliationChrono>
	implements ESFShooterAffiliationChrono {
	public ESFShooterAffiliationChronoClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFShooterAffiliationChrono.class;
	}

	@Override
	public String getModelClassName() {
		return ESFShooterAffiliationChrono.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _esfShooterAffiliationChronoId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfShooterAffiliationChronoId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfShooterAffiliationChronoId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfShooterAffiliationChronoId",
			getEsfShooterAffiliationChronoId());
		attributes.put("esfuserId", getEsfuserId());
		attributes.put("affiliationDate", getAffiliationDate());
		attributes.put("year", getYear());
		attributes.put("Vcampo", getVcampo());
		attributes.put("paymentDate", getPaymentDate());
		attributes.put("payment", getPayment());
		attributes.put("card", getCard());
		attributes.put("esfOrganization", getEsfOrganization());
		attributes.put("note", getNote());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfShooterAffiliationChronoId = (Long)attributes.get(
				"esfShooterAffiliationChronoId");

		if (esfShooterAffiliationChronoId != null) {
			setEsfShooterAffiliationChronoId(esfShooterAffiliationChronoId);
		}

		Long esfuserId = (Long)attributes.get("esfuserId");

		if (esfuserId != null) {
			setEsfuserId(esfuserId);
		}

		Date affiliationDate = (Date)attributes.get("affiliationDate");

		if (affiliationDate != null) {
			setAffiliationDate(affiliationDate);
		}

		Integer year = (Integer)attributes.get("year");

		if (year != null) {
			setYear(year);
		}

		String Vcampo = (String)attributes.get("Vcampo");

		if (Vcampo != null) {
			setVcampo(Vcampo);
		}

		Date paymentDate = (Date)attributes.get("paymentDate");

		if (paymentDate != null) {
			setPaymentDate(paymentDate);
		}

		String payment = (String)attributes.get("payment");

		if (payment != null) {
			setPayment(payment);
		}

		String card = (String)attributes.get("card");

		if (card != null) {
			setCard(card);
		}

		String esfOrganization = (String)attributes.get("esfOrganization");

		if (esfOrganization != null) {
			setEsfOrganization(esfOrganization);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}
	}

	@Override
	public long getEsfShooterAffiliationChronoId() {
		return _esfShooterAffiliationChronoId;
	}

	@Override
	public void setEsfShooterAffiliationChronoId(
		long esfShooterAffiliationChronoId) {
		_esfShooterAffiliationChronoId = esfShooterAffiliationChronoId;

		if (_esfShooterAffiliationChronoRemoteModel != null) {
			try {
				Class<?> clazz = _esfShooterAffiliationChronoRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfShooterAffiliationChronoId",
						long.class);

				method.invoke(_esfShooterAffiliationChronoRemoteModel,
					esfShooterAffiliationChronoId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEsfuserId() {
		return _esfuserId;
	}

	@Override
	public void setEsfuserId(long esfuserId) {
		_esfuserId = esfuserId;

		if (_esfShooterAffiliationChronoRemoteModel != null) {
			try {
				Class<?> clazz = _esfShooterAffiliationChronoRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfuserId", long.class);

				method.invoke(_esfShooterAffiliationChronoRemoteModel, esfuserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getAffiliationDate() {
		return _affiliationDate;
	}

	@Override
	public void setAffiliationDate(Date affiliationDate) {
		_affiliationDate = affiliationDate;

		if (_esfShooterAffiliationChronoRemoteModel != null) {
			try {
				Class<?> clazz = _esfShooterAffiliationChronoRemoteModel.getClass();

				Method method = clazz.getMethod("setAffiliationDate", Date.class);

				method.invoke(_esfShooterAffiliationChronoRemoteModel,
					affiliationDate);
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

		if (_esfShooterAffiliationChronoRemoteModel != null) {
			try {
				Class<?> clazz = _esfShooterAffiliationChronoRemoteModel.getClass();

				Method method = clazz.getMethod("setYear", int.class);

				method.invoke(_esfShooterAffiliationChronoRemoteModel, year);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVcampo() {
		return _Vcampo;
	}

	@Override
	public void setVcampo(String Vcampo) {
		_Vcampo = Vcampo;

		if (_esfShooterAffiliationChronoRemoteModel != null) {
			try {
				Class<?> clazz = _esfShooterAffiliationChronoRemoteModel.getClass();

				Method method = clazz.getMethod("setVcampo", String.class);

				method.invoke(_esfShooterAffiliationChronoRemoteModel, Vcampo);
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

		if (_esfShooterAffiliationChronoRemoteModel != null) {
			try {
				Class<?> clazz = _esfShooterAffiliationChronoRemoteModel.getClass();

				Method method = clazz.getMethod("setPaymentDate", Date.class);

				method.invoke(_esfShooterAffiliationChronoRemoteModel,
					paymentDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPayment() {
		return _payment;
	}

	@Override
	public void setPayment(String payment) {
		_payment = payment;

		if (_esfShooterAffiliationChronoRemoteModel != null) {
			try {
				Class<?> clazz = _esfShooterAffiliationChronoRemoteModel.getClass();

				Method method = clazz.getMethod("setPayment", String.class);

				method.invoke(_esfShooterAffiliationChronoRemoteModel, payment);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCard() {
		return _card;
	}

	@Override
	public void setCard(String card) {
		_card = card;

		if (_esfShooterAffiliationChronoRemoteModel != null) {
			try {
				Class<?> clazz = _esfShooterAffiliationChronoRemoteModel.getClass();

				Method method = clazz.getMethod("setCard", String.class);

				method.invoke(_esfShooterAffiliationChronoRemoteModel, card);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEsfOrganization() {
		return _esfOrganization;
	}

	@Override
	public void setEsfOrganization(String esfOrganization) {
		_esfOrganization = esfOrganization;

		if (_esfShooterAffiliationChronoRemoteModel != null) {
			try {
				Class<?> clazz = _esfShooterAffiliationChronoRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfOrganization",
						String.class);

				method.invoke(_esfShooterAffiliationChronoRemoteModel,
					esfOrganization);
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

		if (_esfShooterAffiliationChronoRemoteModel != null) {
			try {
				Class<?> clazz = _esfShooterAffiliationChronoRemoteModel.getClass();

				Method method = clazz.getMethod("setNote", String.class);

				method.invoke(_esfShooterAffiliationChronoRemoteModel, note);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFShooterAffiliationChronoRemoteModel() {
		return _esfShooterAffiliationChronoRemoteModel;
	}

	public void setESFShooterAffiliationChronoRemoteModel(
		BaseModel<?> esfShooterAffiliationChronoRemoteModel) {
		_esfShooterAffiliationChronoRemoteModel = esfShooterAffiliationChronoRemoteModel;
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

		Class<?> remoteModelClass = _esfShooterAffiliationChronoRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfShooterAffiliationChronoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFShooterAffiliationChronoLocalServiceUtil.addESFShooterAffiliationChrono(this);
		}
		else {
			ESFShooterAffiliationChronoLocalServiceUtil.updateESFShooterAffiliationChrono(this);
		}
	}

	@Override
	public ESFShooterAffiliationChrono toEscapedModel() {
		return (ESFShooterAffiliationChrono)ProxyUtil.newProxyInstance(ESFShooterAffiliationChrono.class.getClassLoader(),
			new Class[] { ESFShooterAffiliationChrono.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFShooterAffiliationChronoClp clone = new ESFShooterAffiliationChronoClp();

		clone.setEsfShooterAffiliationChronoId(getEsfShooterAffiliationChronoId());
		clone.setEsfuserId(getEsfuserId());
		clone.setAffiliationDate(getAffiliationDate());
		clone.setYear(getYear());
		clone.setVcampo(getVcampo());
		clone.setPaymentDate(getPaymentDate());
		clone.setPayment(getPayment());
		clone.setCard(getCard());
		clone.setEsfOrganization(getEsfOrganization());
		clone.setNote(getNote());

		return clone;
	}

	@Override
	public int compareTo(
		ESFShooterAffiliationChrono esfShooterAffiliationChrono) {
		long primaryKey = esfShooterAffiliationChrono.getPrimaryKey();

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

		if (!(obj instanceof ESFShooterAffiliationChronoClp)) {
			return false;
		}

		ESFShooterAffiliationChronoClp esfShooterAffiliationChrono = (ESFShooterAffiliationChronoClp)obj;

		long primaryKey = esfShooterAffiliationChrono.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{esfShooterAffiliationChronoId=");
		sb.append(getEsfShooterAffiliationChronoId());
		sb.append(", esfuserId=");
		sb.append(getEsfuserId());
		sb.append(", affiliationDate=");
		sb.append(getAffiliationDate());
		sb.append(", year=");
		sb.append(getYear());
		sb.append(", Vcampo=");
		sb.append(getVcampo());
		sb.append(", paymentDate=");
		sb.append(getPaymentDate());
		sb.append(", payment=");
		sb.append(getPayment());
		sb.append(", card=");
		sb.append(getCard());
		sb.append(", esfOrganization=");
		sb.append(getEsfOrganization());
		sb.append(", note=");
		sb.append(getNote());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFShooterAffiliationChrono");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfShooterAffiliationChronoId</column-name><column-value><![CDATA[");
		sb.append(getEsfShooterAffiliationChronoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfuserId</column-name><column-value><![CDATA[");
		sb.append(getEsfuserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>affiliationDate</column-name><column-value><![CDATA[");
		sb.append(getAffiliationDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>year</column-name><column-value><![CDATA[");
		sb.append(getYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Vcampo</column-name><column-value><![CDATA[");
		sb.append(getVcampo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paymentDate</column-name><column-value><![CDATA[");
		sb.append(getPaymentDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>payment</column-name><column-value><![CDATA[");
		sb.append(getPayment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>card</column-name><column-value><![CDATA[");
		sb.append(getCard());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esfOrganization</column-name><column-value><![CDATA[");
		sb.append(getEsfOrganization());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>note</column-name><column-value><![CDATA[");
		sb.append(getNote());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfShooterAffiliationChronoId;
	private long _esfuserId;
	private Date _affiliationDate;
	private int _year;
	private String _Vcampo;
	private Date _paymentDate;
	private String _payment;
	private String _card;
	private String _esfOrganization;
	private String _note;
	private BaseModel<?> _esfShooterAffiliationChronoRemoteModel;
}