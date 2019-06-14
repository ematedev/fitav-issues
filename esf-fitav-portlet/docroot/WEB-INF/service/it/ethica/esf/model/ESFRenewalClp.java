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
import it.ethica.esf.service.ESFRenewalLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ethica
 */
public class ESFRenewalClp extends BaseModelImpl<ESFRenewal>
	implements ESFRenewal {
	public ESFRenewalClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ESFRenewal.class;
	}

	@Override
	public String getModelClassName() {
		return ESFRenewal.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _esfRenewalId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEsfRenewalId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _esfRenewalId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("esfRenewalId", getEsfRenewalId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("quantity", getQuantity());
		attributes.put("paymentReason", getPaymentReason());
		attributes.put("paymentType", getPaymentType());
		attributes.put("paymentDate", getPaymentDate());
		attributes.put("paymentReceived", getPaymentReceived());
		attributes.put("createDate", getCreateDate());
		attributes.put("groupId", getGroupId());
		attributes.put("info", getInfo());
		attributes.put("madeBy", getMadeBy());
		attributes.put("amount", getAmount());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("reportingYear", getReportingYear());
		attributes.put("amountTotal", getAmountTotal());
		attributes.put("isTotal", getIsTotal());
		attributes.put("renewalFatherId", getRenewalFatherId());
		attributes.put("affiliates", getAffiliates());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long esfRenewalId = (Long)attributes.get("esfRenewalId");

		if (esfRenewalId != null) {
			setEsfRenewalId(esfRenewalId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long quantity = (Long)attributes.get("quantity");

		if (quantity != null) {
			setQuantity(quantity);
		}

		String paymentReason = (String)attributes.get("paymentReason");

		if (paymentReason != null) {
			setPaymentReason(paymentReason);
		}

		String paymentType = (String)attributes.get("paymentType");

		if (paymentType != null) {
			setPaymentType(paymentType);
		}

		Date paymentDate = (Date)attributes.get("paymentDate");

		if (paymentDate != null) {
			setPaymentDate(paymentDate);
		}

		Boolean paymentReceived = (Boolean)attributes.get("paymentReceived");

		if (paymentReceived != null) {
			setPaymentReceived(paymentReceived);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String info = (String)attributes.get("info");

		if (info != null) {
			setInfo(info);
		}

		String madeBy = (String)attributes.get("madeBy");

		if (madeBy != null) {
			setMadeBy(madeBy);
		}

		Double amount = (Double)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		Integer reportingYear = (Integer)attributes.get("reportingYear");

		if (reportingYear != null) {
			setReportingYear(reportingYear);
		}

		Double amountTotal = (Double)attributes.get("amountTotal");

		if (amountTotal != null) {
			setAmountTotal(amountTotal);
		}

		Boolean isTotal = (Boolean)attributes.get("isTotal");

		if (isTotal != null) {
			setIsTotal(isTotal);
		}

		Long renewalFatherId = (Long)attributes.get("renewalFatherId");

		if (renewalFatherId != null) {
			setRenewalFatherId(renewalFatherId);
		}

		Boolean affiliates = (Boolean)attributes.get("affiliates");

		if (affiliates != null) {
			setAffiliates(affiliates);
		}
	}

	@Override
	public long getEsfRenewalId() {
		return _esfRenewalId;
	}

	@Override
	public void setEsfRenewalId(long esfRenewalId) {
		_esfRenewalId = esfRenewalId;

		if (_esfRenewalRemoteModel != null) {
			try {
				Class<?> clazz = _esfRenewalRemoteModel.getClass();

				Method method = clazz.getMethod("setEsfRenewalId", long.class);

				method.invoke(_esfRenewalRemoteModel, esfRenewalId);
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

		if (_esfRenewalRemoteModel != null) {
			try {
				Class<?> clazz = _esfRenewalRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_esfRenewalRemoteModel, companyId);
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

		if (_esfRenewalRemoteModel != null) {
			try {
				Class<?> clazz = _esfRenewalRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_esfRenewalRemoteModel, userId);
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
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_esfRenewalRemoteModel != null) {
			try {
				Class<?> clazz = _esfRenewalRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_esfRenewalRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getQuantity() {
		return _quantity;
	}

	@Override
	public void setQuantity(long quantity) {
		_quantity = quantity;

		if (_esfRenewalRemoteModel != null) {
			try {
				Class<?> clazz = _esfRenewalRemoteModel.getClass();

				Method method = clazz.getMethod("setQuantity", long.class);

				method.invoke(_esfRenewalRemoteModel, quantity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPaymentReason() {
		return _paymentReason;
	}

	@Override
	public void setPaymentReason(String paymentReason) {
		_paymentReason = paymentReason;

		if (_esfRenewalRemoteModel != null) {
			try {
				Class<?> clazz = _esfRenewalRemoteModel.getClass();

				Method method = clazz.getMethod("setPaymentReason", String.class);

				method.invoke(_esfRenewalRemoteModel, paymentReason);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPaymentType() {
		return _paymentType;
	}

	@Override
	public void setPaymentType(String paymentType) {
		_paymentType = paymentType;

		if (_esfRenewalRemoteModel != null) {
			try {
				Class<?> clazz = _esfRenewalRemoteModel.getClass();

				Method method = clazz.getMethod("setPaymentType", String.class);

				method.invoke(_esfRenewalRemoteModel, paymentType);
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

		if (_esfRenewalRemoteModel != null) {
			try {
				Class<?> clazz = _esfRenewalRemoteModel.getClass();

				Method method = clazz.getMethod("setPaymentDate", Date.class);

				method.invoke(_esfRenewalRemoteModel, paymentDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getPaymentReceived() {
		return _paymentReceived;
	}

	@Override
	public boolean isPaymentReceived() {
		return _paymentReceived;
	}

	@Override
	public void setPaymentReceived(boolean paymentReceived) {
		_paymentReceived = paymentReceived;

		if (_esfRenewalRemoteModel != null) {
			try {
				Class<?> clazz = _esfRenewalRemoteModel.getClass();

				Method method = clazz.getMethod("setPaymentReceived",
						boolean.class);

				method.invoke(_esfRenewalRemoteModel, paymentReceived);
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

		if (_esfRenewalRemoteModel != null) {
			try {
				Class<?> clazz = _esfRenewalRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_esfRenewalRemoteModel, createDate);
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

		if (_esfRenewalRemoteModel != null) {
			try {
				Class<?> clazz = _esfRenewalRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_esfRenewalRemoteModel, groupId);
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

		if (_esfRenewalRemoteModel != null) {
			try {
				Class<?> clazz = _esfRenewalRemoteModel.getClass();

				Method method = clazz.getMethod("setInfo", String.class);

				method.invoke(_esfRenewalRemoteModel, info);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMadeBy() {
		return _madeBy;
	}

	@Override
	public void setMadeBy(String madeBy) {
		_madeBy = madeBy;

		if (_esfRenewalRemoteModel != null) {
			try {
				Class<?> clazz = _esfRenewalRemoteModel.getClass();

				Method method = clazz.getMethod("setMadeBy", String.class);

				method.invoke(_esfRenewalRemoteModel, madeBy);
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

		if (_esfRenewalRemoteModel != null) {
			try {
				Class<?> clazz = _esfRenewalRemoteModel.getClass();

				Method method = clazz.getMethod("setAmount", double.class);

				method.invoke(_esfRenewalRemoteModel, amount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOrganizationId() {
		return _organizationId;
	}

	@Override
	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;

		if (_esfRenewalRemoteModel != null) {
			try {
				Class<?> clazz = _esfRenewalRemoteModel.getClass();

				Method method = clazz.getMethod("setOrganizationId", long.class);

				method.invoke(_esfRenewalRemoteModel, organizationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getReportingYear() {
		return _reportingYear;
	}

	@Override
	public void setReportingYear(int reportingYear) {
		_reportingYear = reportingYear;

		if (_esfRenewalRemoteModel != null) {
			try {
				Class<?> clazz = _esfRenewalRemoteModel.getClass();

				Method method = clazz.getMethod("setReportingYear", int.class);

				method.invoke(_esfRenewalRemoteModel, reportingYear);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getAmountTotal() {
		return _amountTotal;
	}

	@Override
	public void setAmountTotal(double amountTotal) {
		_amountTotal = amountTotal;

		if (_esfRenewalRemoteModel != null) {
			try {
				Class<?> clazz = _esfRenewalRemoteModel.getClass();

				Method method = clazz.getMethod("setAmountTotal", double.class);

				method.invoke(_esfRenewalRemoteModel, amountTotal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsTotal() {
		return _isTotal;
	}

	@Override
	public boolean isIsTotal() {
		return _isTotal;
	}

	@Override
	public void setIsTotal(boolean isTotal) {
		_isTotal = isTotal;

		if (_esfRenewalRemoteModel != null) {
			try {
				Class<?> clazz = _esfRenewalRemoteModel.getClass();

				Method method = clazz.getMethod("setIsTotal", boolean.class);

				method.invoke(_esfRenewalRemoteModel, isTotal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRenewalFatherId() {
		return _renewalFatherId;
	}

	@Override
	public void setRenewalFatherId(long renewalFatherId) {
		_renewalFatherId = renewalFatherId;

		if (_esfRenewalRemoteModel != null) {
			try {
				Class<?> clazz = _esfRenewalRemoteModel.getClass();

				Method method = clazz.getMethod("setRenewalFatherId", long.class);

				method.invoke(_esfRenewalRemoteModel, renewalFatherId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getAffiliates() {
		return _affiliates;
	}

	@Override
	public boolean isAffiliates() {
		return _affiliates;
	}

	@Override
	public void setAffiliates(boolean affiliates) {
		_affiliates = affiliates;

		if (_esfRenewalRemoteModel != null) {
			try {
				Class<?> clazz = _esfRenewalRemoteModel.getClass();

				Method method = clazz.getMethod("setAffiliates", boolean.class);

				method.invoke(_esfRenewalRemoteModel, affiliates);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getESFRenewalRemoteModel() {
		return _esfRenewalRemoteModel;
	}

	public void setESFRenewalRemoteModel(BaseModel<?> esfRenewalRemoteModel) {
		_esfRenewalRemoteModel = esfRenewalRemoteModel;
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

		Class<?> remoteModelClass = _esfRenewalRemoteModel.getClass();

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

		Object returnValue = method.invoke(_esfRenewalRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ESFRenewalLocalServiceUtil.addESFRenewal(this);
		}
		else {
			ESFRenewalLocalServiceUtil.updateESFRenewal(this);
		}
	}

	@Override
	public ESFRenewal toEscapedModel() {
		return (ESFRenewal)ProxyUtil.newProxyInstance(ESFRenewal.class.getClassLoader(),
			new Class[] { ESFRenewal.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ESFRenewalClp clone = new ESFRenewalClp();

		clone.setEsfRenewalId(getEsfRenewalId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setModifiedDate(getModifiedDate());
		clone.setQuantity(getQuantity());
		clone.setPaymentReason(getPaymentReason());
		clone.setPaymentType(getPaymentType());
		clone.setPaymentDate(getPaymentDate());
		clone.setPaymentReceived(getPaymentReceived());
		clone.setCreateDate(getCreateDate());
		clone.setGroupId(getGroupId());
		clone.setInfo(getInfo());
		clone.setMadeBy(getMadeBy());
		clone.setAmount(getAmount());
		clone.setOrganizationId(getOrganizationId());
		clone.setReportingYear(getReportingYear());
		clone.setAmountTotal(getAmountTotal());
		clone.setIsTotal(getIsTotal());
		clone.setRenewalFatherId(getRenewalFatherId());
		clone.setAffiliates(getAffiliates());

		return clone;
	}

	@Override
	public int compareTo(ESFRenewal esfRenewal) {
		long primaryKey = esfRenewal.getPrimaryKey();

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

		if (!(obj instanceof ESFRenewalClp)) {
			return false;
		}

		ESFRenewalClp esfRenewal = (ESFRenewalClp)obj;

		long primaryKey = esfRenewal.getPrimaryKey();

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
		StringBundler sb = new StringBundler(41);

		sb.append("{esfRenewalId=");
		sb.append(getEsfRenewalId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", quantity=");
		sb.append(getQuantity());
		sb.append(", paymentReason=");
		sb.append(getPaymentReason());
		sb.append(", paymentType=");
		sb.append(getPaymentType());
		sb.append(", paymentDate=");
		sb.append(getPaymentDate());
		sb.append(", paymentReceived=");
		sb.append(getPaymentReceived());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", info=");
		sb.append(getInfo());
		sb.append(", madeBy=");
		sb.append(getMadeBy());
		sb.append(", amount=");
		sb.append(getAmount());
		sb.append(", organizationId=");
		sb.append(getOrganizationId());
		sb.append(", reportingYear=");
		sb.append(getReportingYear());
		sb.append(", amountTotal=");
		sb.append(getAmountTotal());
		sb.append(", isTotal=");
		sb.append(getIsTotal());
		sb.append(", renewalFatherId=");
		sb.append(getRenewalFatherId());
		sb.append(", affiliates=");
		sb.append(getAffiliates());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(64);

		sb.append("<model><model-name>");
		sb.append("it.ethica.esf.model.ESFRenewal");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>esfRenewalId</column-name><column-value><![CDATA[");
		sb.append(getEsfRenewalId());
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
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>quantity</column-name><column-value><![CDATA[");
		sb.append(getQuantity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paymentReason</column-name><column-value><![CDATA[");
		sb.append(getPaymentReason());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paymentType</column-name><column-value><![CDATA[");
		sb.append(getPaymentType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paymentDate</column-name><column-value><![CDATA[");
		sb.append(getPaymentDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paymentReceived</column-name><column-value><![CDATA[");
		sb.append(getPaymentReceived());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>info</column-name><column-value><![CDATA[");
		sb.append(getInfo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>madeBy</column-name><column-value><![CDATA[");
		sb.append(getMadeBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>amount</column-name><column-value><![CDATA[");
		sb.append(getAmount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organizationId</column-name><column-value><![CDATA[");
		sb.append(getOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reportingYear</column-name><column-value><![CDATA[");
		sb.append(getReportingYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>amountTotal</column-name><column-value><![CDATA[");
		sb.append(getAmountTotal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isTotal</column-name><column-value><![CDATA[");
		sb.append(getIsTotal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>renewalFatherId</column-name><column-value><![CDATA[");
		sb.append(getRenewalFatherId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>affiliates</column-name><column-value><![CDATA[");
		sb.append(getAffiliates());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _esfRenewalId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _modifiedDate;
	private long _quantity;
	private String _paymentReason;
	private String _paymentType;
	private Date _paymentDate;
	private boolean _paymentReceived;
	private Date _createDate;
	private long _groupId;
	private String _info;
	private String _madeBy;
	private double _amount;
	private long _organizationId;
	private int _reportingYear;
	private double _amountTotal;
	private boolean _isTotal;
	private long _renewalFatherId;
	private boolean _affiliates;
	private BaseModel<?> _esfRenewalRemoteModel;
}